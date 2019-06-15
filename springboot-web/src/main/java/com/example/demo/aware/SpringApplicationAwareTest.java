package com.example.demo.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringApplicationAwareTest implements ApplicationContextAware{

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {

		
		System.out.println("21212121=========aware执行方法");
		
	}

}
