package eendtech.utils;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import eendtech.utils.Constants.TokenConstant;
import io.jsonwebtoken.*;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;

/**
 * @ author Seale
 * @ Description:JWT工具类JSON WEB TOKEN
 * @ QQ:1801157108
 * @ Date 2019/4/27 18:51
 */
public class JwtUtils {
    /**
     * 签发JWT
     * @param id
     * @param subject
     * @param ttlMillis
     * @return
     */
    public static String createJWT(String id , String subject , long ttlMillis){
        //加密算法
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        //密钥
        SecretKey secretKey = generalKey();
        JwtBuilder builder = Jwts.builder()
                .setId(id)
                .setSubject(subject) //主题
                .setIssuer(TokenConstant.ISSUER)//签发者
                .setAudience(TokenConstant.ISSUER)//受众(接收方)
                .setIssuedAt(now)//签发时间
                .signWith(signatureAlgorithm,secretKey)//签名算法和密钥
                .setHeaderParam("typ","JWT");

        if (ttlMillis > 0){
            long expMillis = nowMillis + ttlMillis;
            Date expDate = new Date(expMillis);
            builder.setExpiration(expDate);//设置过期时间
        }
        return builder.compact();
    }

    /**
     * 验证JWT
     * @param jwt
     * @return
     */
    public static CheckResult validateJWT(String jwt) {
        //生成返回类
        CheckResult checkResult = new CheckResult();
        Claims claims = null;
        try {
            claims = parseJWT(jwt);
            if (claims == null){
                checkResult.setSuccess(false);
                checkResult.setErrCode(TokenConstant.JWT_ERRCODE_FAIL);
            } else if (claims.getAudience().equals(TokenConstant.ISSUER)){
                checkResult.setSuccess(false);
                checkResult.setErrCode(TokenConstant.JWT_ERRCODE_FAIL);
            }else if (claims.getIssuer().equals(TokenConstant.ISSUER)){
                checkResult.setSuccess(false);
                checkResult.setErrCode(TokenConstant.JWT_ERRCODE_FAIL);
            }
            checkResult.setSuccess(true);
            checkResult.setClaims(claims);
        }catch (ExpiredJwtException e){
            //JWT过期
            checkResult.setSuccess(false);
            checkResult.setErrCode(TokenConstant.JWT_ERRCODE_EXPIRE);
        }catch (SignatureException e){
            //签名错误
            checkResult.setSuccess(false);
            checkResult.setErrCode(TokenConstant.JWT_ERRCODE_FAIL);
        }

        return checkResult;
    }

    /**
     * 构建密钥
     * @return SecretKey
     */
    public static SecretKey generalKey()  {
        //密钥解密
        byte[] encodedKey = Base64.decode(TokenConstant.JWT_SECERT);
        //生成密钥
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

    /**
     * 解析
     * @param jwt
     * @return
     */
    public static Claims parseJWT(String jwt){
        SecretKey secretKey = generalKey();
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwt)
                .getBody();

    }
}
