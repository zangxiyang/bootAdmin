package eendtech.controller;

import eendtech.dao.UserDao;
import eendtech.po.User;
import eendtech.utils.JwtUtils;
import eendtech.utils.ResultCode;
import eendtech.utils.ResultKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * @ author Seale
 * @ Description:
 * @ QQ:1801157108
 * @ Date 2019/4/28 10:20
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    UserDao userDao ;

    @ResponseBody
    @PostMapping("/login")
    public ResultKit<String> login(String username , String password , HttpServletResponse response){
        User user = this.userDao.findUser(username,password);
        if (user != null){
                String JWT = JwtUtils.createJWT("1",username,0);
                ResultKit<String> resultKit = new ResultKit<>();
                resultKit.setCode(ResultCode.SUCCESS.code());
                resultKit.setData(JWT);
                resultKit.setMessage("登录成功");
                return resultKit;

        }else{
            ResultKit<String> resultKit = new ResultKit<>();
            resultKit.setCode(ResultCode.WRONG_UP.code());
            resultKit.setMessage("失败");
            return resultKit;
        }
    }

}
