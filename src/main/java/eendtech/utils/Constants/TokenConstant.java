package eendtech.utils.Constants;

/**
 * @ author Seale
 * @ Description:Token常量集
 * @ QQ:1801157108
 * @ Date 2019/4/27 19:05
 */
public class TokenConstant {
    //密钥
    //原始码 eendtech_asgduiashduiAASDWEFHTFGsdhioasd89498411894914648987_%^&&^*^()*()&5201314
    public static final String JWT_SECERT = "ZWVuZHRlY2hfYXNnZHVpYXNoZHVpQUFTRFdFRkhURkdzZGhpb2FzZDg5NDk4NDExODk0OTE0NjQ4OTg3XyUyNSU1RSUyNiUyNiU1RSolNUUlMjglMjkqJTI4JTI5JTI2NTIwMTMxNA==";
    //签发者
    public static final String ISSUER = "Eendtech";
    /****************************************************************/
    //JWT过期错误
    public static final Integer JWT_ERRCODE_EXPIRE = 85201;
    //JWT验证失败
    public static final Integer JWT_ERRCODE_FAIL = 85202;
    /****************************************************************/
    //请求头
    public static final String HEADER_TOKEN = "Authorization";
    //请求头内容前缀
    public static final String HEADER_TOKEN_PREFIX = "Bearer ";
}
