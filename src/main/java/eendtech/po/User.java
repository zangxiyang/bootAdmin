package eendtech.po;

import lombok.Getter;
import lombok.Setter;

/**
 * @ author Seale
 * @ Description:
 * @ QQ:1801157108
 * @ Date 2019/4/26 17:51
 */
@Getter@Setter
public class User {
    private Integer user_id;
    private String user_code;
    private String user_name;
    private String user_password;
    private Integer user_state;

}
