package com.example.demo.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringApplicationAwareTest implements ApplicationContextAware {
	
	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("21212121=========aware执行方法");
		System.out.println(applicationContext.getApplicationName());
		System.out.println(applicationContext.containsBeanDefinition("queryAmountServiceImpl"));
		System.out.println(applicationContext.getParent());
		this.applicationContext = applicationContext;
	}

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public Object getBean(String name) {
		return getApplicationContext().getBean(name);
	}

	public <T> T getBean(Class<T> Clazz) {
		return getApplicationContext().getBean(Clazz);
	}

	public <T> T getBean(String name, Class<T> clazz) {
		return getApplicationContext().getBean(name, clazz);
	}
}
