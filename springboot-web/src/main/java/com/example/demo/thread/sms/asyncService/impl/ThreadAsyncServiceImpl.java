package com.example.demo.thread.sms.asyncService.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.demo.po.AmountChange;
import com.example.demo.queryanmount.service.IQueryAmountService;
import com.example.demo.thread.sms.asyncService.ThreadAsyncService;

@Service
public class ThreadAsyncServiceImpl  implements ThreadAsyncService {
	 private static final Logger logger = LoggerFactory.getLogger(ThreadAsyncServiceImpl.class);
     
	 @Autowired
	 private IQueryAmountService queryAmountServiceImpl;
	 
	@Scheduled(cron="0/5 * * * * ? ")
	@Async("taskExecutor")
	@Override
	public void executeAsync() {
		        logger.info("start executeAsync=============");
		        try {
		            System.out.println("当前运行的线程名称：" + Thread.currentThread().getName());
		            System.out.println("吕瑞娜");
		            /**
		             * 在次方法中添加任务，即可支持多线程的调用，在浏览器F5刷新，既是多线程调用的
		             * */
		            /**
		             * 第一步：调用银行客户信息，如果这个表中有数据，则进行第二部，(假设在这个表中的信息，都是变化的信息)
		             * 第二部:如果客户账户金额信息有变化，调用发短信功能，发送短信，告知变化金额和所剩余额
		             * */
		            List<AmountChange> listAmount =  getAmountChangeInfo();
		            if(!listAmount.isEmpty()&&null!=listAmount) {
		            	//调用发送短信功能
		            	
		            	
		            }
		            
		            
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		        logger.info("end executeAsync===============");
		    }


	private List<AmountChange> getAmountChangeInfo() {
        EntityWrapper<AmountChange> ew = new EntityWrapper();
		
		return queryAmountServiceImpl.selectList(ew);
	}

}
