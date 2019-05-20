package com.example.demo.thread.fileupload.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/web")
@RestController
public class FileUploadController {

	
	 @RequestMapping(value="/upload",method=RequestMethod.POST)
	 public String fileUpload(MultipartFile file,HttpServletRequest request) throws Exception {
		 String originalFilename = file.getOriginalFilename();

		 
		 File file2 = new File("\\"+originalFilename);
		 OutputStream os = new FileOutputStream(file2);
		 InputStream in = file.getInputStream();
		 IOUtils.copy(in, os);
		 in.close();
		 os.close();
		 return "success";
	 }
	
	
}
