package com.zzw.springbootMybatisdemotest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzw.springbootMybatisdemotest.entity.User;
import com.zzw.springbootMybatisdemotest.mapper.UserMapper;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User selectUser(User user) {
        return userMapper.selectUser(user.getUserName(), user.getPassword());
    }

    public User selectUserByUserName(User user) {
        return userMapper.selectUserByUserName(user.getUserName());
    }

    public int insertUser(User user) {
        return userMapper.insert(user);
    }
}
