package com.example.corelearning.controller;

import com.example.corelearning.common.Result;
import com.example.corelearning.dto.UserDto;
import com.example.corelearning.service.OrderService;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/orders")
public class orderController {
    private final OrderService orderService;

    public orderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping("/{id}")
    public Result<UserDto> getUserWithOrders(@PathVariable Integer id) {
        UserDto user = orderService.getUserWithOrders(id);
        return Result.success(user);
    }
}
