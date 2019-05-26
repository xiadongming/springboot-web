package com.example.demo.thread.vedioupload.test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

public class TestUploadMerge {

	// 合并文件，在服务器端将视频片段合并
	@Test
	public void testMerge() throws IOException {
		// 块文件目录
		File chunkFolder = new File("D:/0_000ffmpeg/chunk/");
		// 合并文件
		File mergeFile = new File("D:/0_000ffmpeg/merge.mp4");
		if (mergeFile.exists()) {
			mergeFile.delete();
		}
		// 创建新的合并文件
		mergeFile.createNewFile();
		// 用于写文件
		RandomAccessFile raf_write = new RandomAccessFile(mergeFile, "rw");
		// 指针指向视频顶端
		raf_write.seek(0);
		// 缓冲区
		byte[] b = new byte[1024];
		// 分块列表
		File[] fileArray = chunkFolder.listFiles();
		// 转成集合，便于排序
		List<File> fileList = new ArrayList<File>(Arrays.asList(fileArray));
		// 从小到大排序
		Collections.sort(fileList, new Comparator<File>() {
			@Override
			public int compare(File o1, File o2) {
				if (Integer.parseInt(o1.getName()) < Integer.parseInt(o2.getName())) {
					return -1;
				}
				return 1;
			}
		});

		// 合并文件
		for (File chunkFile : fileList) {
			RandomAccessFile raf_read = new RandomAccessFile(chunkFile, "rw");
			int len = -1;
			while ((len = raf_read.read(b)) != -1) {
				raf_write.write(b, 0, len);
			}
			raf_read.close();
		}
		raf_write.close();
	}


}
