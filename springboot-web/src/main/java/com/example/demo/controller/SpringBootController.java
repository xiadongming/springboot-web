package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/web")
public class SpringBootController {

	@RequestMapping("/html")
	public String getStringWeb() {
		System.out.println("首页面");
		
		return "index";
	}
	
	
}



