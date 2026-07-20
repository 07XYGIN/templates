package com.example.corelearning.mapper;

import com.example.corelearning.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    List<UserDto> selectByCondition(UserDto condition);
    int decreaseBalance(@Param("id") Integer id, @Param("amount") Integer amount);
    int increaseBalance(@Param("id") Integer id, @Param("amount") Integer amount);
    int insertUser(@Param("username") String username, @Param("password") String password);
    UserDto getUserInfo(@Param("username") String username);
}
