package com.shopping.easy.service;

import com.shopping.easy.model.UserModel;

/**
 * 工作用户管理实现接口
 *@Description: UserService
 *The Class be used to controller user's information.Including add、change and delete.And it need to implement。
 *@Author: easy-fire
 *@Date: 2019/7/25
 */
public interface UserService {

    /**
     *  添加用户
     * @param   user:
     * @return   Integer:
     * @author : easy-fire
     * @date : 2019/7/25  16:27
     */
    Integer addUser(UserModel user);

    /**
     *  删除用户
     * @param   userId:
     * @return   Integer:
     * @author : easy-fire
     * @date : 2019/7/25  16:18
     */
    Integer deleteUser(Integer[] userId);

    /**
     *  更改用户信息
     * @param   user:
     * @return   Integer:
     * @author : easy-fire
     * @date : 2019/7/25  16:27
     */
    Integer updateUser(UserModel user);
}
