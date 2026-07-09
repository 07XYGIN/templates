package com.example.corelearning.controller;

import com.example.corelearning.common.Result;
import com.example.corelearning.dto.UserDto;
import com.example.corelearning.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class userController {

    private final UserService userService;

    public userController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/user")
    public List<Integer> getUserList(){
        return userService.getUserId();
    }

    @PostMapping("/add")
    public Result<String> addUser(@Valid @RequestBody UserDto user){
        return Result.success("接收成功：" + user.getUsername());
    }

    @PostMapping("getUserInfo")
    public Result<List<UserDto>> getUserInfo(@Valid @RequestBody UserDto user){
        return Result.success(userService.getUserInfo(user));
    }
}
