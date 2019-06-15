package com.example.demo.beanpostprocessorpac;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class PostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if ("springApplicationAwareTest".equals(beanName)) {
			System.out.println(bean);
			System.out.println("******************");
		}
		return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if ("springApplicationAwareTest".equals(beanName)) {
			System.out.println(bean);
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%");
		}
		return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
	}

}
