package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.demo.po.AmountChange;
import com.example.demo.queryanmount.service.IQueryAmountService;

@Controller
@RequestMapping("/web")
public class SpringBootController {
      
	@Autowired
	private IQueryAmountService queryAmountServiceImpl;
  
	@RequestMapping("/html")
	public String getStringWeb(String username) {
		System.out.println("首页面");

		EntityWrapper<AmountChange> ew = new EntityWrapper<>();
		ew.where("userName={0}", username);
		//return "videoupload";
    //	return "video3";
		AmountChange AmountChange = queryAmountServiceImpl.selectOne(ew);
		return "success2";
	}
	
	
}



