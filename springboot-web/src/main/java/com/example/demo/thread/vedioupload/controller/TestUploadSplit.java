package com.example.demo.thread.vedioupload.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/video")
public class TestUploadSplit {
	private final static Logger LOGGER = LoggerFactory.getLogger(TestUploadSplit.class);

	
	private Integer i = 0;
	private String uploadPath = "D:/0_000ffmpeg/webupload/";

	/**
	 * webupload断点续传原理：页面(即webupload)将视频分段上传，如将100m分成10m片，10个这样的，
	 * 并不是将这10个存储在文件夹中，后端只负责io读写即可，因为从前端是分片传过来的，所以在后端只负责io读写，也是分片存储的
	 */

	// 上传文件，将文件拆分开
	@RequestMapping("/upload")
	public String uploadchunk(MultipartFile file,String chunk) throws Exception {
		long size = file.getSize();
		String fileMd5 =  file.getOriginalFilename();
		// chunk是当前文件额下标，，，即块文件的数量
		//String name = file.getName();
		//String originalFilename = file.getOriginalFilename();
	//	chunk = chunk + 1;

		if (file == null) {
			throw new Exception("上传文件不能为空");
		}
		// 检查块文件目录
		boolean fileFold = createChunkFileFold(fileMd5);
		if (!fileFold) {
			// 上传文件目录创建失败
		}
		// 块文件
		File chunkfile = new File(getChunkFileFolderPath(fileMd5) + chunk);
		// 上传的块文件
		InputStream inputStream = null;
		FileOutputStream outputStream = null;
		try {
			inputStream = file.getInputStream();
			outputStream = new FileOutputStream(chunkfile);
			IOUtils.copy(inputStream, outputStream);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("upload chunk file fail:{}", e.getMessage());
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("success");
		String path = getChunkFileFolderPath(fileMd5) + chunk;
		modelAndView.addObject(path);
//		System.out.println(i++);
      return "success";
	}

	// 得到块文件所在目录
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

	// 创建块文件目录
	private boolean createChunkFileFold(String fileMd5) {
		// 创建上传文件目录
		String chunkFileFolderPath = getChunkFileFolderPath(fileMd5);
		File chunkFileFolder = new File(chunkFileFolderPath);
		if (!chunkFileFolder.exists()) {
			// 创建文件夹
			boolean mkdirs = chunkFileFolder.mkdirs();
			return mkdirs;
		}
		return true;
	}
}
