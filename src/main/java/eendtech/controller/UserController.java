package eendtech.controller;

import eendtech.po.User;
import eendtech.service.UserService;
import eendtech.utils.CheckResult;
import eendtech.utils.Constants.TokenConstant;
import eendtech.utils.JwtUtils;
import eendtech.utils.ResultCode;
import eendtech.utils.ResultKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @ author Seale
 * @ Description:
 * @ QQ:1801157108
 * @ Date 2019/4/26 18:16
 */
@Controller
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/info")
    @ResponseBody
    public ResultKit info (@RequestBody User user, HttpServletRequest request){
        //进行验证
        String Token = request.getHeader(TokenConstant.HEADER_TOKEN);
        if (Token != null){
            int subLength = TokenConstant.HEADER_TOKEN_PREFIX.length();
            Token = Token.substring(subLength);
            CheckResult result = JwtUtils.validateJWT(Token);
            if (result.isSuccess()){
                User user_info = userService.findUser(user.getUser_code(),user.getUser_password());
                ResultKit<User> resultKit =  new ResultKit<>();
                resultKit.setCode(ResultCode.SUCCESS.code());
                resultKit.setMessage("成功获取信息");
                resultKit.setData(user_info);
                return resultKit;
            }else {
                ResultKit<String> resultKit =  new ResultKit<>();
                resultKit.setCode(ResultCode.UNAUTHORIZED.code());
                resultKit.setMessage("错误:Token授权失败,或许是授权过期,或许是Token错误");
                resultKit.setData("没有权限进行操作");
                return resultKit;
            }

        }else{
            ResultKit<String> resultKit =  new ResultKit<>();
            resultKit.setCode(ResultCode.FAIL.code());
            resultKit.setMessage("错误:没有检测到Token");
            resultKit.setData("没有权限进行操作");
            return resultKit;
        }
    }


}
