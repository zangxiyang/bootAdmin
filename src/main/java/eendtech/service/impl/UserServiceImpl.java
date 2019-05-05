package eendtech.service.impl;

import eendtech.dao.UserDao;
import eendtech.po.User;
import eendtech.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ author Seale
 * @ Description:
 * @ QQ:1801157108
 * @ Date 2019/4/26 18:11
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    //注入UserDao
    @Autowired private UserDao userDao;

    @Override
    public User findUser(String usercode, String password) {
        return this.userDao.findUser(usercode,password);
    }

}
