package common;

/**
 * 常量类
 */
public interface Constant {
    //项目根地址
    String URL_ROOT = "/proDemo/";
    //登录URI
    String URI_LOGIN = "/proDemo/login";
    //注册URI
    String URI_REGISTER = "/proDemo/register";
    //静态资源路径
    String URI_REC = "/static";
    //登录用户
    String LOGIN_USER = "loginUser";
    //默认头像
    String USER_AVATAR = "/upload/img/avatar04.png";
    //默认注册后为待审核状态
    Integer USER_STATUS = 0;
}
