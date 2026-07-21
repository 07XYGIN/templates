package com.example.corelearning.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderDto {
    private Integer id;
    private Integer userId;
    private BigDecimal amount;
    private String status;
    private LocalDateTime createdAt;
}
