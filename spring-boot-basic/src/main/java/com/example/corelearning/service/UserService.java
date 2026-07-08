package com.example.corelearning.service;

import com.example.corelearning.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public  List<Integer> getUserId(){
        return userMapper.userAll();
    };
}
