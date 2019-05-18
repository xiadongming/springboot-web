package com.example.register.service.impl;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.demo.vo.UserVo;
import com.example.register.service.RegisterService;

public class RegisterServiceImpl extends ServiceImpl<BaseMapper<UserVo>, UserVo> implements RegisterService{

}
