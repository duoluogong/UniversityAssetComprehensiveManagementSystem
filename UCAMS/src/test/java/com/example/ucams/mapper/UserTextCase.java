package com.example.ucams.mapper;

import com.example.ucams.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTextCase {
    @Autowired
    private UserMapper userMapper;

    @Test
    void textGetById() {
        System.out.println(userMapper.selectById(1));
    }

    @Test
    void textsave() {
        User user = new User();
        user.setUserName("test");
        user.setUserPwd("123");
        userMapper.insert(user);
    }

}
