package com.example.corelearning.service;

import com.example.corelearning.common.JwtUtil;
import com.example.corelearning.dto.PaymentDto;
import com.example.corelearning.dto.UserDto;
import com.example.corelearning.exception.BusinessException;
import com.example.corelearning.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.jspecify.annotations.NonNull;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Log4j2
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil JwtUtil;
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

    public PageInfo<UserDto> getUserPage(Integer pageNum, Integer pageSize, UserDto condition) {
        PageHelper.startPage(pageNum, pageSize);
        List<UserDto> list = userMapper.selectByCondition(condition);
        return new PageInfo<>(list);
    }


    public void RegisterService(UserDto user) {
        List<UserDto> result = userMapper.selectByCondition(user);
        log.info("查询结果数量: {}", result.size());
        if (result.isEmpty()) {
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            userMapper.insertUser(user.getUsername(), encodedPassword);
            log.info("用户 {} 注册成功", user.getUsername());
        } else {
            throw new BusinessException(404, "用户名已存在");
        }
    }

    public String LoginService(UserDto user){
        UserDto result = userMapper.getUserInfo(user.getUsername());
        if(result == null){
            throw new BusinessException(404, "用户不存在");
        }

        boolean matches = passwordEncoder.matches(user.getPassword(),result.getPassword());
        if(!matches){
            throw new BusinessException(404, "密码错误");
        }

        return JwtUtil.generateToken(result.getUsername());
    }
}
