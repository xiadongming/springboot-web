package com.example.demo.ccb;

import com.example.demo.po.MediaFile;

public class TestDemo {
	
	public static void main(String[] args) {
		try {
		
		MediaFile mediaFile = new MediaFile();//两个try块中的mediaFile
		mediaFile.setFileId("11111");
		mediaFile.setFileName("2222");
		System.out.println(mediaFile);
		change(mediaFile);
		System.out.println(mediaFile);
		//地址传递，，值传递
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			
		MediaFile mediaFile = new MediaFile();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void change(MediaFile mediaFile) {
		mediaFile.setFileId("44444");
		mediaFile.setFileName("555");
		
		
	}

}
