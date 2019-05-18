package com.example.register.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/web")
public class RegisterController {

	@RequestMapping("/register")
	public String getRegister() {
		
		return "success";
	}
	
	
}
