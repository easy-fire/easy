package com.shopping.easy.controller;

import com.shopping.easy.model.UserModel;
import com.shopping.easy.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * 用户管理
 *@Description: 用户管理接口
 *@Author: easy-fire
 *@Date: 2019/7/25
 */
@RestController
@Api(description = "工作用户管理接口")
@RequestMapping("/api/systemUser")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 工作用户管理模块-注册用户
     * @param   user_name
     * @param   account
     * @param   age
     * @param   password
     * @author : easy-fire
     * @date : 2019/7/25  13:39
     */
    @ApiOperation(value = "工作用户管理模块-新增工作用户",httpMethod = "POST",response = String.class,
            notes = "工作用户管理模块-新增工作用户接口，提供给工作用户管理模块-新增工作用户功能使用")
    @RequestMapping(method = RequestMethod.POST)
    public String addUser(@ApiParam(value = "用户名",required = true) @RequestParam(value = "user_name" )String user_name,
                          @ApiParam(value = "账号",required = true ) @RequestParam(value = "account")String account,
                          @ApiParam(value = "密码",required = true) @RequestParam(value = "password")String password,
                          @ApiParam(value = "年龄",required = true) @RequestParam(value = "age")Integer age
    ){
        UserModel user = new UserModel();
        user.setAccount(account);
        user.setUser_name(user_name);
        user.setAge(age);
        user.setPassword(password);
        user.setStage("1");
        Integer result=userService.addUser(user);
      return "操作成功"+result;
    }

    /**
     * 工作用户管理模块-注销用户
     * @param   userId:
     * @author : easy-fire
     * @date : 2019/7/25  16:37
     */
    @RequiresPermissions("/api/systemUser")
    @ApiOperation(value = "工作用户管理模块-注销工作用户",httpMethod = "DELETE",response = String.class,
    notes ="工作用户管理模块-删除工作用户接口，提供给工作用户管理模块-删除工作用户功能使用")
    @RequestMapping(method = RequestMethod.DELETE)
    public String deleteUser(
            @ApiParam(value = "用户id",required = true) @RequestParam(value = "userId") Integer[] userId
    ){

            return "删除成功"+userService.deleteUser(userId);

    }

    /**
     * 工作用户管理模块-更改信息
     * @param   userId:
     * @param user_name;
     * @param password;
     * @author : easy-fire
     * @date : 2019/7/25  16:37
     */
    @RequiresPermissions("/api/systemUser")
    @ApiOperation(value = "工作用户管理模块-更改用户信息",httpMethod = "PUT",response = String.class)
    @RequestMapping(method = RequestMethod.PUT)
    public String updateUser(
                             @ApiParam(value = "用户id",required = true) @RequestParam(value = "userId") Integer userId,
                             @ApiParam(value = "用户名",required = true)@RequestParam(value = "user_name")String user_name,
                             @ApiParam(value = "密码",required = true)@RequestParam(value = "password")String password
                             ){
        UserModel user =new UserModel();
        user.setUserId(userId);
        user.setUser_name(user_name);
        user.setPassword(password);
        return "成功了"+userService.updateUser(user);
    }
}
