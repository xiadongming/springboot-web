package com.example.thread.config;

import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
@Configuration
@EnableAsync
public class ThreadPoolConfig {
	
	

    @Bean
	public TaskExecutor taskExecutor() {
		ThreadPoolTaskExecutor executor  = new ThreadPoolTaskExecutor();
		//核心线程数
		executor.setCorePoolSize(2);
		//最大线程数
		executor.setMaxPoolSize(5);
		//设置队列容量
		executor.setQueueCapacity(3);
		//设置活跃时间
		executor.setKeepAliveSeconds(300);
		//设置线程名称
		executor.setThreadNamePrefix("Thread--");
		//设置拒绝策略
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		//等所有执行任务结束后再关闭线程池
		executor.setWaitForTasksToCompleteOnShutdown(true);
		return executor;
	}

}
