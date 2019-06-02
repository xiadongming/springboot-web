package com.example.demo.thread.vedioupload.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestFFmpeg {

	@Test
	public void testProcessBuilder() {
		ProcessBuilder processBuilder = new ProcessBuilder();
		// processBuilder.command("ping","127.0.0.1");
		processBuilder.command("ipconfig");
		// processBuilder.command("java","‐jar","f:/xc‐service‐manage‐course.jar");
		// 将标准输入流和错误输入流合并，通过标准输入流读取信息
		processBuilder.redirectErrorStream(true);
		try {
			// 启动进程
			Process start = processBuilder.start();
			// 获取输入流
			InputStream inputStream = start.getInputStream();
			// 转成字符输入流
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "gbk");
			int len = -1;
			char[] c = new char[1024];
			StringBuffer outputString = new StringBuffer();
			// 读取进程输入流中的内容
			while ((len = inputStreamReader.read(c)) != -1) {
				String s = new String(c, 0, len);
				outputString.append(s);
				System.out.print(s);
			}
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testFFmpeg() {
		ProcessBuilder processBuilder = new ProcessBuilder();
		List<String> commend = new ArrayList<String>();
		commend.add("D:\\06software_pac_anz\\ffmpef_anz\\ffmpeg-20180227-fa0c9d6-win64-static\\bin\\ffmpeg.exe");
		commend.add("-i");
		commend.add("D:\\0_000ffmpeg\\12345.avi");
		commend.add("-y");// 覆盖输出文件
		commend.add("-c:v");
		commend.add("libx264");
		commend.add("-s");
		commend.add("1280x720");
		commend.add("-pix_fmt");
		commend.add("yuv420p");
		commend.add("-b:a");
		commend.add("63k");
		commend.add("-b:v");
		commend.add("753k");

		commend.add("-r");
		commend.add("18");
		commend.add("D:\\0_000ffmpeg\\12345.mp4");
		processBuilder.command(commend);
		// 将标准输入流和错误输入流合并，通过标准输入流读取信息
		processBuilder.redirectErrorStream(true);
		try {
			// 启动进程
			Process start = processBuilder.start();
			// 获取输入流
			InputStream inputStream = start.getInputStream();
			// 转成字符输入流
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "gbk");
			int len = -1;
			char[] c = new char[1024];
			StringBuffer outputString = new StringBuffer();
			// 读取进程输入流中的内容
			while ((len = inputStreamReader.read(c)) != -1) {
				String s = new String(c, 0, len);
				outputString.append(s);
				System.out.print(s);
			}
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
