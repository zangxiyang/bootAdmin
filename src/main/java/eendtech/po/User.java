package eendtech.po;

import lombok.*;

import java.io.Serializable;

/**
 * @ author Seale
 * @ Description:
 * @ QQ:1801157108
 * @ Date 2019/4/26 17:51
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
@ToString
public class User implements Serializable {
    private static final long serialVersionUID = 1447281933427787505L;
    //ID
    private Integer user_id;
    //帐号
    private String user_code;
    //昵称
    private String user_name;
    //密码
    private String user_password;
    //用户状态
    private Integer user_state;

}
