package com.example.corelearning.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    @NotBlank(message = "用户名不能为空")
    private String username;

    @Min(value = 2, message = "年龄必须大于1")
    private Integer age;

    @NotNull(message = "密码不能为空")
    private String password;

    private List<OrderDto> orders;

    private String id;
}
