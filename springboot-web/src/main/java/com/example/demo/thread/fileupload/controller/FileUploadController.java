package com.example.demo.thread.fileupload.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/web")
@Controller
public class FileUploadController {

	
	 @RequestMapping(value="/upload",method=RequestMethod.POST)
	 public String fileUpload(MultipartFile file,HttpServletRequest request) throws Exception {
		 String originalFilename = file.getOriginalFilename();
		 String path = FileUploadController.class.getResource("/").getPath();
         String substring2 = path.substring(path.indexOf("D"), path.indexOf("target"));
         String str = substring2+"src/main/resources/static/"+originalFilename;
		 File file2 = new File(str);
		 OutputStream os = new FileOutputStream(file2);
		 InputStream in = file.getInputStream();
		 IOUtils.copy(in, os);
		 in.close();
		 os.close();
		 
		 return "success";
	 }
	
	
}
