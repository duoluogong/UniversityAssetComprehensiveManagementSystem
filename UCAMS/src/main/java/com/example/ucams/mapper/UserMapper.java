package com.example.ucams.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ucams.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    //    @Select("select 'user_name' 'user_pwd' from user where 'user_name'=#{username} and 'user_pwd'=#{userpwd}")
//    User getByUserNameAndUserPwd(@Param("username") String username,@Param("userpwd") String userpwd);
    @Select("SELECT\n" +
            "\tacademy.`name`,\n" +
            "\t`user`.user_id,\n" +
            "\t`user`.user_name,\n" +
            "\t`user`.user_pwd,\n" +
            "\t`user`.user_power,\n" +
            "\t`user`.user_phone \n" +
            "FROM\n" +
            "\t`user`\n" +
            "\tINNER JOIN academy ON `user`.academy_id = academy.id")
    List<User> getAll();
}
