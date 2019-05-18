package eendtech.utils;

/**
 * @ author Seale
 * @ Description:
 * @ QQ:1801157108
 * @ Date 2019/4/28 10:26
 */
public enum ResultCode {
    SUCCESS(200),//成功
    WRONG_UP(201),//帐号密码不存在
    FAIL(400),//失败
    TIME_OUT(401),//超时
    UNAUTHORIZED(401),//未认证（签名错误）
    NOT_FOUND(404),//不存在
    INTERNAL_SERVER_ERROR(500),//服务器内部错误
    TOKEN_ERROR(701),//token错误
    TOKEN_MISS(702);//token失效

    private final int code ;
    ResultCode (int code){
        this.code = code ;
    }

    public int code (){
        return code ;
    }
}
