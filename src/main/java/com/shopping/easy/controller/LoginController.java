package com.shopping.easy.controller;

import com.shopping.easy.model.UserModel;
import com.shopping.easy.utils.JsonResponseData;
import com.shopping.easy.utils.define.StatusDefine;
import com.shopping.easy.utils.define.StatusDefineMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *@Author: easy-fire
 *@Description: LoginController
 *@Date: 2019/8/6
 *@Medified By:
 */
@Api(description = "用户登录")
@RestController
public class LoginController {

    /**
     * @author : easy-fire
     * @Desicription :
     * @param account: 账号
     * @param password: 密码
     * @date : 2019/8/6  9:16
     * @return :
     * @modified By:
     */
    @ApiOperation(value = "用户登录",httpMethod = "POST",response = String.class,notes = "用户登录")
    @RequestMapping(value = "/api/login",method = RequestMethod.POST,produces = "application/json")
    public String login(@ApiParam(value = "账号",required = true)
                        @RequestParam(value = "acconout",required = true)
                        String account,
                        @ApiParam(value = "密码",required = true)
                        @RequestParam(value = "password",required = true)
                        String password
                        ){
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(account,password);
        token.setRememberMe(true);

        try{
            currentUser.login(token);
            SecurityUtils.getSubject().getSession().setTimeout(1800000);

            UserModel user = (UserModel) currentUser.getPrincipal();
            user.setToken((String) currentUser.getSession().getId());
            System.out.println(user);
            return new JsonResponseData(true, StatusDefineMessage.GetMessage(StatusDefine.SUCCESS),
                    StatusDefine.SUCCESS,"",user).toString();

        }catch (IncorrectCredentialsException ae) {//密码错误
            return new JsonResponseData(false, "", StatusDefine.U_PWD_FAILED,
                    StatusDefineMessage.GetMessage(StatusDefine.U_PWD_FAILED), null).toString();
        } catch (UnknownAccountException e) {//用户不存在
            return new JsonResponseData(false, "", StatusDefine.U_INEXISTENCE,
                    StatusDefineMessage.GetMessage(StatusDefine.U_INEXISTENCE), null).toString();
        } catch(DisabledAccountException e){//用户冻结
            return new JsonResponseData(false, e.getMessage(), StatusDefine.U_UNACTIVE,
                    StatusDefineMessage.GetMessage(StatusDefine.U_UNACTIVE), null).toString();
        }
        catch (DataAccessException e) {
            return new JsonResponseData(false, StatusDefineMessage.GetMessage(StatusDefine.DB_ERROR),
                    StatusDefine.DB_ERROR, "", null).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResponseData(false, "", StatusDefine.SYS_ERROR,
                    StatusDefineMessage.GetMessage(StatusDefine.SYS_ERROR), null).toString();
        }
    }

    @RequestMapping(value = "api/403",method = RequestMethod.GET)
    public String unauthorizedRole(){
        return new JsonResponseData(false,"",StatusDefine.PERMISSIONDENIED,
                StatusDefineMessage.GetMessage(StatusDefine.PERMISSIONDENIED),null).toString();
    }

    @RequestMapping(value = "/api/unauth", method = RequestMethod.GET)
    public String unauth() {
        return new JsonResponseData(false, "", StatusDefine.U_LOGIN_OUTTIME,
                StatusDefineMessage.GetMessage(StatusDefine.U_LOGIN_OUTTIME), null).toString();
    }

    @ApiOperation(value = "用户登出", httpMethod = "GET", response = String.class, notes = "用户登出")
    @RequestMapping(value = "/api/logout", method = RequestMethod.GET)
    public String logOut(){
        Subject currentUser=SecurityUtils.getSubject();
        if(currentUser!=null){
            currentUser.logout();
        }
        return new JsonResponseData(true, StatusDefineMessage.GetMessage(StatusDefine.SUCCESS), StatusDefine.SUCCESS, "",null).toString();
    }

}
