package eendtech.dao;

import eendtech.po.User;

/**
 * @ author Seale
 * @ Description:
 * @ QQ:1801157108
 * @ Date 2019/5/7 15:13
 */
public interface LoginDao {
    //通过id查询user
    User findUserById(Integer id);
    //通过帐号查询user
    User findUserByUserName(String usercode);
    //通过帐号密码查询user
    User findUserByCodeAndPwd(String usercode ,String userPassword);
    //添加帐号
    int addUser(User user);
}
