package com.example.demo.controller;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.factorybean.StudentFactoryBean;
import com.example.demo.queryanmount.service.IQueryAmountService;

@Controller
@RequestMapping("/web")
public class SpringBootController {
	@Autowired
	private IQueryAmountService queryAmountServiceImpl;
	// @Autowired
	// private FactoryBean factoryBean;
	@RequestMapping("/html")
	public String getStringWeb(String username) {
		System.out.println("首页面");
		/*
		 * EntityWrapper<AmountChange> ew = new EntityWrapper<>();
		 * ew.where("userName={0}", username); AmountChange AmountChange =
		 * queryAmountServiceImpl.selectOne(ew);
		 */
		AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(StudentFactoryBean.class);
		Object obj = acac.getBean("studentFactoryBean");
		System.out.println(obj);
		Object obj2 = acac.getBean("&studentFactoryBean");
		System.out.println(obj2);
		// System.out.println(factoryBean.toString());
		// return "videoupload";
		// return "video3";
		return "success2";
	}

}
