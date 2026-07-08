package com.example.corelearning.service;

import com.example.corelearning.exception.BusinessException;
import com.example.corelearning.mapper.UserMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    List<Integer> list = userMapper.userAll();
    public  List<Integer> getUserId(){
        if(userMapper.userAll().isEmpty()){
            throw new BusinessException(500, "没有查询到指定的用户");
        }
        return list;
    };
}
