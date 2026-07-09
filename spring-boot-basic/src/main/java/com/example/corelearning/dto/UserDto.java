package com.example.corelearning.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserDto {
    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotNull(message = "年龄不能为空")
    @Min(value = 2, message = "年龄必须大于1")
    private Integer age;
}