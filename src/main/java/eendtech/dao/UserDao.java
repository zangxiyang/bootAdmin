package eendtech.dao;

import eendtech.po.User;
import org.apache.ibatis.annotations.Param;

/**
 * @ author Seale
 * @ Description:
 * @ QQ:1801157108
 * @ Date 2019/4/26 18:02
 */
public interface UserDao {
    /**
     * 通过帐号和密码来查询用户
     */
    User findUser(@Param("usercode") String usercode
            ,@Param("password") String password);
}
