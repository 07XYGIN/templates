package com.example.corelearning.controller;

import com.example.corelearning.service.UserService;
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


}
