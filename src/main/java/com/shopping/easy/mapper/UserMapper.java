package com.shopping.easy.mapper;

import com.shopping.easy.model.UserModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
/**
 *@Author: easy-fire
 *@Description : 人员相关方法
 *@Date: 2019/8/6
 *@Medified By:
 */
@Mapper
@Repository
public interface UserMapper {
    /**
     * 根据账号查询用户信息
     * @param   account
     * @return   UserModel:
     * @throws   DataAccessException
     * @author : easy-fire
     * @date : 2019/7/25  16:09
     */
    UserModel findByAccount(String account)throws DataAccessException;

    /**
     * 添加用户，用于用户注册
     * @param   user:
     * @return   Integer:
     * @throws DataAccessException
     * @author : easy-fire
     * @date : 2019/7/25  16:13
     */
    Integer addUser(UserModel user)throws DataAccessException;

    /**
     * 删除用户，通过权限设置来达到逻辑上的删除效果
     * @param   userId:
     * @return   Integer:
     * @throws DataAccessException
     * @author : easy-fire
     * @date : 2019/7/25  16:13
     */
    Integer deleteUser(@Param("userId")Integer[] userId)throws DataAccessException;

    /**
     * 修改用户信息，用于个人信息更改
     * @param   user:
     * @return   Integer:
     * @throws DataAccessException
     * @author : easy-fire
     * @date : 2019/7/25  16:13
     */
    Integer updateUser(UserModel user)throws DataAccessException;
}
