package com.example.ucams.servers;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.ucams.model.User;

import java.util.List;

public interface Userserver extends IService<User> {
    List<User> getAll();

    IPage<User> getPage(int currentPage, int pageSize);

    IPage<User> getPage(int currentPage, int pageSize, User user);
}
