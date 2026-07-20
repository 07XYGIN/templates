package com.example.corelearning.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data

public class PaymentDto {
    @NotNull(message = "转出方不能为空")
    private Integer fromId;

    @NotNull(message = "转入方不能为空")
    private Integer oldId;

    @NotNull(message = "金额不能为空")
    @Min(value = 1, message = "金额必须大于0")
    private Integer amount;


}
