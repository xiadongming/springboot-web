package com.example.thread.asyncService.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.demo.vo.UserVo;
import com.example.register.mapper.RegisterMapper;
import com.example.thread.asyncService.ThreadAsyncService;

@Service
public class ThreadAsyncServiceImpl extends ServiceImpl<RegisterMapper, UserVo> implements ThreadAsyncService {
	 private static final Logger logger = LoggerFactory.getLogger(ThreadAsyncServiceImpl.class);

	@Async("taskExecutor")
	@Override
	public void executeAsync() {
		        logger.info("start executeAsync");
		        try {
		            System.out.println("当前运行的线程名称：" + Thread.currentThread().getName());
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		        logger.info("end executeAsync");
		    }

}
