package eendtech.po;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * @ author Seale
 * @ Description:
 * @ QQ:1801157108
 * @ Date 2019/4/26 21:22
 */
@Getter@Setter
public class Msg {
    private String state_code;
    private String msg ;
    private Map<String,String> returns;
}
