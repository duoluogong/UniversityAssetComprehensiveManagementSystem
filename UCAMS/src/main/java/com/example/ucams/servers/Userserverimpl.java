package com.example.ucams.servers;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.ucams.mapper.UserMapper;
import com.example.ucams.model.User;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Userserverimpl extends ServiceImpl<UserMapper, User> implements Userserver {
    @Autowired
    private UserMapper userMapper;
//    @Override
//    public Boolean save(User user) {
//        return userMapper.insert(user)>0;
//    }
//
//    @Override
//    public Boolean delete(Integer id) {
//        return userMapper.deleteById(id)>0;
//    }
//
//    @Override
//    public Boolean update(User user) {
//        return userMapper.updateById(user)>0;
//    }
//
//    @Override
//    public User getById(Integer id) {
//        return userMapper.selectById(id);
//    }
//
//    @Override
//    public User login(User user) {
//        return userMapper.getByUserNameAndUserPwd(user.getUserId(),user.getUserPwd());
//    }
//
//
//    @Override
//    public List<User> getAll() {
//        return userMapper.selectList(
//                null
//        );
//    }

    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }

    @Override
    public IPage<User> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage, pageSize);
        userMapper.selectPage(page, null);
        return page;
    }

    @Override
    public IPage<User> getPage(int currentPage, int pageSize, User user) {
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
        lqw.like(user.getUserId() != null, User::getUserId, user.getUserId());
        lqw.like(Strings.isNotEmpty(user.getUserName()), User::getUserName, user.getUserName());
        lqw.like(Strings.isNotEmpty(user.getAcademyId()), User::getAcademyId, user.getAcademyId());
        lqw.like(Strings.isNotEmpty(user.getUserPower()), User::getUserPower, user.getUserPower());
        IPage page = new Page(currentPage, pageSize);
        userMapper.selectPage(page, lqw);
        return page;
    }

}
