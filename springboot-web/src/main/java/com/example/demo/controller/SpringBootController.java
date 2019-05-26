package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
public class SpringBootController {

	@RequestMapping("/html")
	public String getStringWeb() {
		System.out.println("首页面");
		
		return "videoupload";
	}
	
	
}



