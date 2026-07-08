package com.example.corelearning.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserDto {
    @NotNull(message = "用户名不能为空")
    String username;

    @NotBlank(message = "年龄必须大于一")
    Integer age;
}
