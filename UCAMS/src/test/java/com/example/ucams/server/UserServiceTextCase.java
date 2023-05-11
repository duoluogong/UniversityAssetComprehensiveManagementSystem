package com.example.ucams.server;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.ucams.model.User;
import com.example.ucams.servers.Userserver;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTextCase {

    @Autowired  //注入操作对象
    private Userserver userserver;

    @Test
        //查询单个
    void getById() {
        userserver.getById(3);
    }

//    @Test   //登录查询
//    void loginText(){
//        User user=new User();
//        user.setUserId(1);
//        user.setUserPwd("root");
//        user.setUserName("root");
//       System.out.println(userserver.login(user));
//    }

    @Test
        //查询全部
    void getAll() {
        System.out.println(userserver.getAll());
    }

    @Test
        //新增
    void save() {
        User user = new User();
        user.setUserName("fffff");
        user.setUserPwd("1111");
        userserver.save(user);
    }

    @Test
        //修改
    void updataById() {
        User user = new User();
        user.setUserId(4);
        user.setUserName("ceshi");
        user.setUserPwd("qwer");
        userserver.updateById(user);
    }

    @Test
        //删除单个
    void delete() {
        userserver.removeById(4);
    }

    @Test
        //测试分页查询
    void getPage() {
        IPage<User> page = userserver.getPage(1, 2);
        System.out.println(page.getPages());
        System.out.println(page.getCurrent());
        System.out.println(page.getRecords());
        System.out.println(page.getSize());
    }

}
