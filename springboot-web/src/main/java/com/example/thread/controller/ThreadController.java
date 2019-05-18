package com.example.thread.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.vo.UserVo;
import com.example.thread.asyncService.ThreadAsyncService;


@RestController
public class ThreadController {
	 private static final Logger logger = LoggerFactory.getLogger(ThreadController.class);
	 
	    @Autowired
	    private ThreadAsyncService asyncService;
	 
	    @GetMapping("/sss")
	    public UserVo sss(){
	 
	        //调用service层的任务
	        asyncService.executeAsync();
	 
	        return null;
	    }


}
