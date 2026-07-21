package com.example.corelearning.mapper;

import com.example.corelearning.dto.OrderDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {
    List<OrderDto> selectByUserId(@Param("userId") Integer userId);
}