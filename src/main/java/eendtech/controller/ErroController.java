package eendtech.controller;

import eendtech.utils.ResultKit;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @ author Seale
 * @ Description:错误信息展示
 * @ QQ:1801157108
 * @ Date 2019/5/13 21:16
 */
@Controller
@RequestMapping("/api/erro")
public class ErroController {
    @RequestMapping("/info")
    @ResponseBody
    public ResultKit<String> showErro(HttpServletRequest request){
        int code = (int) request.getAttribute("erroCode");
        String msg = (String) request.getAttribute("erroMessage");
        String data = (String) request.getAttribute("erroData");
        ResultKit<String> resultKit = new ResultKit<>();
        return resultKit
                .setCode(code)
                .setMessage(msg)
                .setData(data);
    }
}
