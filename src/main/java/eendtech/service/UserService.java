package eendtech.service;

import eendtech.po.User;

/**
 * @ author Seale
 * @ Description:
 * @ QQ:1801157108
 * @ Date 2019/4/26 18:08
 */
public interface UserService {
    //通过帐号和密码来查询用户
    User findUser(String usercode , String password);

}
