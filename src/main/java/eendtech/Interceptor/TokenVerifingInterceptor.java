package eendtech.Interceptor;

import eendtech.utils.CheckResult;
import eendtech.utils.Constants.TokenConstant;
import eendtech.utils.JwtUtils;
import eendtech.utils.ResultCode;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ author Seale
 * @ Description:权限验证
 * @ QQ:1801157108
 * @ Date 2019/5/13 21:11
 */

public class TokenVerifingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        //进行验证
        String Token = request.getHeader(TokenConstant.HEADER_TOKEN);
        if (Token != null){
            int subLength = TokenConstant.HEADER_TOKEN_PREFIX.length();
            Token = Token.substring(subLength);
            CheckResult result = JwtUtils.validateJWT(Token);
            if (result.isSuccess()){
                return true;
            }
        }
            //拦截请求
            int code = ResultCode.UNAUTHORIZED.code();
            String message = "错误:Token授权失败,或许是授权过期,或许是Token错误";
            String data = "没有权限进行操作";
            request.setAttribute("erroCode",code);
            request.setAttribute("erroMessage",message);
            request.setAttribute("erroData",data);
            request.getRequestDispatcher("/api/erro/info").forward(request,response);

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
