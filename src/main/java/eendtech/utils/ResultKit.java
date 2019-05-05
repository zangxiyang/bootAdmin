package eendtech.utils;

import lombok.Getter;
import lombok.Setter;

/**
 * @ author Seale
 * @ Description: 统一API响应结果工具包
 * @ QQ:1801157108
 * @ Date 2019/4/28 10:29
 */
@Getter@Setter
public class ResultKit<T> {
    private int code ;
    private String message ;
    private T data ;

}
