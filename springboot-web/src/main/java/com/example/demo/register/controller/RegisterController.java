package com.example.demo.register.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.register.service.RegisterService;

@RestController
@RequestMapping("/web")
public class RegisterController {
	@Autowired
	private RegisterService registerService;

	// @RequestMapping("/register")
	// public String getRegister(UserVo user) {
	// System.out.println(user);
	// boolean insert = registerService.insert(user);
	// return "success";
	// }
	@RequestMapping(value = "/register")
	public String getRegister(@RequestBody String userVo) {
		System.out.println(userVo);

		return "success";
	}

}
