package com.shopping.easy.service.impl;

import com.shopping.easy.mapper.UserMapper;
import com.shopping.easy.model.UserModel;
import com.shopping.easy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 工作用户管理实现类
 *@Description: UserServiceImpl
 *The Class be used to controller user's information.Including add、change and delete.
 *@Author: easy-fire
 *@Date: 2019/7/25
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     *  删除用户
     * @param   userId:
     * @return   Integer:
     * @author : easy-fire
     * @date : 2019/7/25  16:18
     */
    @Override
    public Integer deleteUser(Integer[] userId) {
        return userMapper.deleteUser(userId);
    }

    /**
     *  更改用户信息
     * @param   user:
     * @return   Integer:
     * @author : easy-fire
     * @date : 2019/7/25  16:27
     */
    @Override
    public Integer updateUser(UserModel user) {

        return userMapper.updateUser(user);
    }

    /**
     *  添加用户
     * @param   user:
     * @return   Integer:
     * @author : easy-fire
     * @date : 2019/7/25  16:27
     */
    @Override
    public Integer addUser(UserModel user) {
        return userMapper.addUser(user);
    }
}
