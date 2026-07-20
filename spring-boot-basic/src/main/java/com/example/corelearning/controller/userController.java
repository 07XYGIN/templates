package com.example.corelearning.controller;

import com.example.corelearning.common.PageResult;
import com.example.corelearning.common.Result;
import com.example.corelearning.dto.PaymentDto;
import com.example.corelearning.dto.UserDto;
import com.example.corelearning.service.UserService;
import com.github.pagehelper.PageInfo;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Log4j2
@RestController

public class userController {

    private final UserService userService;

    public userController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/add")
    public Result<String> addUser(@Valid @RequestBody UserDto user){
        return Result.success("接收成功：" + user.getUsername());
    }

    @PostMapping("getUserInfo")
    public Result<List<UserDto>> getUserInfo(@Valid @RequestBody UserDto user){
        return Result.success(userService.getUserInfo(user));
    }

    @PostMapping("payment")
    public Result<Void> payment(@Valid @RequestBody PaymentDto payment){
        userService.transfer(payment);
        return Result.ok();
    }

    @GetMapping("/page")
    public Result<PageResult<UserDto>> getUserPage(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize,
            UserDto user){

        PageInfo<UserDto> pageInfo = userService.getUserPage(pageNum, pageSize, user);
        PageResult<UserDto> pageResult = PageResult.of(pageInfo);
        return Result.success(pageResult);
    }

    @PostMapping("/register")
    public Result<String> RegisterController(@Valid @RequestBody UserDto user){
        userService.RegisterService(user);
        return Result.ok();
    }


    @PostMapping("/login")
    public Result<String> LoginController(@Valid @RequestBody UserDto user) {
        return Result.success(userService.LoginService(user));
    }
 }
