package com.example.corelearning.service;


import com.example.corelearning.dto.UserDto;
import com.example.corelearning.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class OrderService {
    private final UserMapper userMapper;

    public UserDto getUserWithOrders(Integer id) {
        return userMapper.selectUserWithOrders(id);
    }
}
