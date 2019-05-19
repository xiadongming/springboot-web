package com.example.demo.register.service.impl;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.demo.register.service.RegisterService;
import com.example.demo.vo.UserVo;

public class RegisterServiceImpl extends ServiceImpl<BaseMapper<UserVo>, UserVo> implements RegisterService{

}
