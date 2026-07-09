package com.example.corelearning.mapper;

import com.example.corelearning.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<Integer> userAll();
    List<UserDto> selectByCondition(UserDto condition);
}
