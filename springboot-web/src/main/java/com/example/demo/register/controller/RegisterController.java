package com.example.demo.register.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.register.service.RegisterService;
import com.example.demo.vo.UserVo;

@RestController
@RequestMapping("/web")
public class RegisterController {
     @Autowired
	private RegisterService registerService;
	
	@RequestMapping("/register")
	public String getRegister(UserVo user) {
		System.out.println(user);
		boolean insert = registerService.insert(user);
		return "success";
	}
	
	
}
