package eendtech.utils;

import io.jsonwebtoken.Claims;
import lombok.Getter;
import lombok.Setter;

/**
 * @ author Seale
 * @ Description:
 * @ QQ:1801157108
 * @ Date 2019/4/27 19:50
 */
@Getter@Setter
public class CheckResult {
    private boolean success;
    private Claims claims;
    private Integer errCode;
}
