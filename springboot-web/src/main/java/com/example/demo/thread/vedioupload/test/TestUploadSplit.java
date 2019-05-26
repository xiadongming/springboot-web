package com.example.demo.thread.vedioupload.test;

import java.io.File;
import java.io.RandomAccessFile;

import org.junit.Test;

public class TestUploadSplit {

	// 上传文件，将文件拆分开
	@Test
	public void testSplitChunk() throws Exception {
		// 上传的文件
		File sourceFile = new File("D:/0_000ffmpeg/1.mp4");
		// 视频片段存放地址
		String chunkPath = "D:/0_000ffmpeg/chunk/";
		File chunkFolder = new File(chunkPath);
		if (!chunkFolder.exists()) {
			chunkFolder.mkdirs();

		}

		// 分块大小
		long chunkSize = 1024 * 1024 * 1;
		// 分块数量
		long chunkNum = (long) Math.ceil(sourceFile.length() * 1.0 / chunkSize);
		if (chunkNum <= 0) {
			chunkNum = 1;
		}
		// 缓冲区大小
		byte[] b = new byte[1024];
		// 使用RandomAccessFile访问文件
		RandomAccessFile raf_read = new RandomAccessFile(sourceFile, "r");
		// 分块
		for (int i = 0; i < chunkNum; i++) {
			// 创建分块文件
			File file = new File(chunkPath + i);
			boolean newFile = file.createNewFile();
			if (newFile) {
				// 向分块文件中写数据
				RandomAccessFile raf_write = new RandomAccessFile(file, "rw");
				int len = (-1);
				while ((len = raf_read.read(b)) != -1) {
					raf_write.write(b, 0, len);
					if (file.length() > chunkSize) {
						break;
					}
				}
				raf_write.close();
			}
		}
		raf_read.close();
	}

}
