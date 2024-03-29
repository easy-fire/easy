package com.shopping.easy.utils.define;

/**
 * Created by ZGP on 2018/8/3.
 * 常量接口定义API接口返回值
 */

public interface StatusDefine {
    /**
     * 用户相关 100X
     * 角色相关 110X
     * 权限相关 120X
     * 验证相关 200X
     *
     * 系统相关 500X
     * 文件相关 700X
     *自定义异常相关 900X
     * */
    //操作成功
    public static final int SUCCESS = 0;
    public static final int FAILURE = -1;

    //格式验证
    //数据格式错误
    public static final int DATA_FORMAT_ERROR=2001;
    //系统状态
    //系统错误
    public static final int SYS_ERROR = 5001;
    //网络请求失败
    public static final int NET_ERROR = 5002;
    //数据库访问失败
    public static final int DB_ERROR = 5003;

    //用户相关
    //用户不存在
    public static final int U_INEXISTENCE = 1001;
    //用户密码错误
    public static final int U_PWD_FAILED = 1002;
    //用户密码未经修改
    public static final int U_UNCHANGE_PWD = 1003;
    //用户未激活
    public static final int U_UNACTIVE = 1004;
    //用户授权码错误
    public static final int U_TOKEN_ERROR = 1005;
    //用户未授权
    public static final int U_NO_TOKEN = 1006;
    //用户已经存在
    public static final int U_EXIST_USER = 1007;
    //添加用户失败
    public static final int U_ADD_FAILED = 1008;
    //用户未登录
    public static final int U_UNLOAD = 1009;
    //两次密码不一致
    public static final int U_PWD_TWO_INCONFORMITY = 1010;

    //原密码不正确
    public static final int U_PWD_OLD_FAILED = 1011;




    //登录超时
    public static final int U_LOGIN_OUTTIME = 3000;


    //权限不足
    public static final int PERMISSIONDENIED = 8001;
    //有权限
    public static final int HAVEPERMISSIOND = 8002;


    //角色名不存在
    public static final int R_INEXISTENCE = 7001;
    //角色名已经存在
    public static final int R_EXIST_USER = 7002;

    //业务逻辑层出现异常
    public static final int SERVICE_ERROR=9001;

    //文件格式不正确
    int FILE_FORMAT_ERROR=7001;
}
