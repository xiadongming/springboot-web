package com.example.demo.thread.sms.controller;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.thread.sms.asyncService.ThreadAsyncService;


@RestController
@RequestMapping("/web")
public class ThreadControllerSmsController {
	/**
	 * 定时发送短信的服务，严格是一个定时扫描的后台服务，没有controller
	 * 
	 * */
	 private static final Logger logger = LoggerFactory.getLogger(ThreadControllerSmsController.class);
	 
	    @Autowired
	    private ThreadAsyncService asyncService;
	    
	    @RequestMapping("/thread")
	    public String threadController(){
	    	logger.info("日志信息是====");
	        //调用service层的任务
	        asyncService.executeAsync();
	 
	        return "success";
	    }


}
