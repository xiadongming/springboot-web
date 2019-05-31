package com.example.demo.thread.vedioupload.test2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.po.MediaFile;

@RestController
@RequestMapping("/video")
public class TestFileMeger {

	private final static Logger LOGGER = LoggerFactory.getLogger(TestFileMeger.class);
	private String uploadPath = "D:/0_000ffmpeg/webupload/";

	// 合并块文件
	@RequestMapping("/meger")
	public Boolean mergechunks(String fileMd5)
			throws Exception {
		fileMd5 = "abcd";
		  Long fileSize = 111111L;
		String mimetype = "video/mimeto";
		String fileName = "first";
		String fileExt = ".mp4";
		// 获取块文件的路径
		String chunkfileFolderPath = getChunkFileFolderPath(fileMd5);
		File chunkfileFolder = new File(chunkfileFolderPath);
		if (!chunkfileFolder.exists()) {
			chunkfileFolder.mkdirs();
		}
		// 合并文件路径
		File mergeFile = new File(getFilePath(fileMd5, fileExt));
		// 创建合并文件
		// 合并文件存在先删除再创建
		if (mergeFile.exists()) {
			mergeFile.delete();
		}
		boolean newFile = false;
		try {
			newFile = mergeFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
			LOGGER.error("mergechunks..create mergeFile fail:{}", e.getMessage());
		}
		if (!newFile) {
			throw new Exception("创建文件失败");
		}
		// 获取块文件，此列表是已经排好序的列表
		List<File> chunkFiles = getChunkFiles(chunkfileFolder);

		// 合并文件
		mergeFile = mergeFile(mergeFile, chunkFiles);
		if (mergeFile == null) {
			throw new Exception("合并文件失败");
		}
		// 校验文件
		boolean checkResult = this.checkFileMd5(mergeFile, fileMd5);
		if (!checkResult) {
			throw new Exception("合并文件失败");
		}
		// 将文件信息保存到数据库
		MediaFile mediaFile = new MediaFile();
		mediaFile.setFileId(fileMd5);
		mediaFile.setFileName(fileMd5 + "." + fileExt);
		mediaFile.setFileOriginalName(fileName);
		// 文件路径保存相对路径
		mediaFile.setFilePath(getFileFolderRelativePath(fileMd5, fileExt));
		mediaFile.setFileSize(fileSize);
		mediaFile.setUploadTime(new Date());
		mediaFile.setMimeType(mimetype);
		mediaFile.setFileType(fileExt);
		// 状态为上传成功
		mediaFile.setFileStatus("301002");
		/**
		 * 保存到数据库
		 */
		// MediaFile save = mediaFileDao.save(mediaFile);
		// 清除分块文件目录
		clearChunkFile(chunkfileFolder);
		return true;
	}

	private void clearChunkFile(File chunkfileFolder) {
		if (chunkfileFolder == null) {
			return;
		}
		try {
			if (chunkfileFolder.exists()) {
				if (chunkfileFolder.isDirectory() && chunkfileFolder.exists()) {
					File[] files = chunkfileFolder.listFiles();
					for (File file : files) {
						file.delete();
					}
					chunkfileFolder.delete();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("clear chunkFile error,chunkFileFolder is {},errorinfo is :{}",
					chunkfileFolder.getAbsolutePath(), e.getMessage());
		}
	}

	private String getFileFolderRelativePath(String fileMd5, String fileExt) {
		String filePath = fileMd5.substring(0, 1) + "/" + fileMd5.substring(1, 2) + "/" + fileMd5 + "/";
		return filePath;
	}

	private boolean checkFileMd5(File mergeFile, String md5) {
		if (mergeFile == null || StringUtils.isEmpty(md5)) {
			return false;
		}

		// 进行md5校验
		FileInputStream mergeFileInputstream = null;
		try {
			mergeFileInputstream = new FileInputStream(mergeFile);
			// 得到文件的md5
			String mergeFileMd5 = DigestUtils.md5Hex(mergeFileInputstream);
			// 比较md5
			if (md5.equalsIgnoreCase(mergeFileMd5)) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			e.printStackTrace();
			LOGGER.error("checkFileMd5 error,file is:{},md5 is:{}", mergeFile.getAbsoluteFile(), md5);
		} finally {
			try {
				mergeFileInputstream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	private File mergeFile(File mergeFile, List<File> chunkFiles) {
		try {
			// 创建写文件对象
			RandomAccessFile raf_write = new RandomAccessFile(mergeFile, "rw");
			// 遍历分块文件开始合并
			// 读取文件缓冲区
			byte[] b = new byte[1024];
			for (File chunkFile : chunkFiles) {
				RandomAccessFile raf_read = new RandomAccessFile(chunkFile, "r");
				int len = -1;
				// 读取分块文件
				while ((len = raf_read.read(b)) != -1) {
					// 向合并文件中写数据
					raf_write.write(b, 0, len);
				}
				raf_read.close();
			}
			raf_write.close();
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("merge file error:{}", e.getMessage());
			return null;
		}
		return mergeFile;
	}

	private List<File> getChunkFiles(File chunkfileFolder) {
		// 获取路径下的所有块文件
		File[] chunkFiles = chunkfileFolder.listFiles();
		// 将文件数组转成list，并排序
		List<File> chunkFileList = new ArrayList<File>();
		chunkFileList.addAll(Arrays.asList(chunkFiles));
		// 排序
		Collections.sort(chunkFileList, new Comparator<File>() {
			@Override
			public int compare(File o1, File o2) {
				if (Integer.parseInt(o1.getName()) > Integer.parseInt(o2.getName())) {
					return 1;
				}
				return -1;
			}
		});
		return chunkFileList;

	}

	private String getFilePath(String fileMd5, String fileExt) {
		String filePath = uploadPath + fileMd5.substring(0, 1) + "/" + fileMd5.substring(1, 2) + "/" + fileMd5 + "/"
				+ fileMd5 + "." + fileExt;
		return filePath;
	}

	private String getChunkFileFolderPath(String fileMd5) {
		String fileChunkFolderPath = getFileFolderPath(fileMd5) + "/" + "chunks" + "/";
		return fileChunkFolderPath;

	}

	// 得到文件所在目录
	private String getFileFolderPath(String fileMd5) {
		String fileFolderPath = uploadPath + fileMd5.substring(0, 1) + "/" + fileMd5.substring(1, 2) + "/" + fileMd5
				+ "/";
		return fileFolderPath;
	}
}
