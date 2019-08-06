package com.shopping.easy.service.impl;

import com.shopping.easy.mapper.UserMapper;
import com.shopping.easy.model.UserModel;
import com.shopping.easy.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private UserMapper userMapper;



    @Override
    public UserModel findByAccount(String account) {
        return userMapper.findByAccount(account);
    }
}
