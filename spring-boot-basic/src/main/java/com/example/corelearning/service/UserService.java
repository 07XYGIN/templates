package com.example.corelearning.service;

import com.example.corelearning.dto.PaymentDto;
import com.example.corelearning.dto.UserDto;
import com.example.corelearning.exception.BusinessException;
import com.example.corelearning.mapper.UserMapper;
import lombok.extern.log4j.Log4j2;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Log4j2
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<UserDto> getUserInfo(UserDto user){
        return userMapper.selectByCondition(user);
    }

    @Transactional
    public void transfer(@NonNull PaymentDto Payment){
        int decreaseResult = userMapper.decreaseBalance(Payment.getFromId(), Payment.getAmount());
        if (decreaseResult == 0) {
            throw new BusinessException(404, "转出账户不存在");
        }
        int increaseResult = userMapper.increaseBalance(Payment.getOldId(), Payment.getAmount());
        if (increaseResult == 0) {
            throw new BusinessException(404, "转入账户不存在");
        }
    }
}
