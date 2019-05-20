package com.example.demo.register.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.demo.register.mapper.RegisterMapper;
import com.example.demo.register.service.RegisterService;
import com.example.demo.vo.UserVo;

@Service
@Transactional
public class RegisterServiceImpl extends ServiceImpl<BaseMapper<UserVo>, UserVo> implements RegisterService{

}
