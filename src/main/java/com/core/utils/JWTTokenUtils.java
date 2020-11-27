package com.core.utils;


import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.xml.bind.DatatypeConverter;
import java.util.Date;
import java.util.Map;

/**
 * @author dechun.yuan
 * @version 1.0
 */
public class JWTTokenUtils {

    //设置过期时间1天
    private static long EXPIRE_TIME = 1 * 24 * 60 * 60 * 1000;
    //token私钥
    private static String TOKEN_SECRET = "System Token";
    //签发者
    private static String ISSUER = "System Administrator";
    //主题
    private static String SUBJECT = "System Authorization";


    /***
     * 生成token签名，过期日期为expireTime
     * @param subject
     * @param claims
     * @param expireTime
     * @return
     */
    public static String sign(String subject, Map<String, Object> claims, long expireTime) {
        //json claim参数
        claims.forEach((key, val) ->
                claims.put(key, val instanceof String ? val : JSON.toJSONString(val))
        );

        //过期时间
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        Date expireDate = new Date(nowMillis + (expireTime == 0 ? EXPIRE_TIME : expireTime));
        return Jwts.builder()
                .setId(UUIDUtils.getUUID())
                .setIssuer(ISSUER) //签发者信息
                .setSubject(StringUtils.isBlank(subject) ? SUBJECT : subject) //主题说明
                .addClaims(claims) //claim信息
                .setIssuedAt(now)  //签发时间
                .setExpiration(expireDate) //过期时间戳
                .signWith(SignatureAlgorithm.HS256, TOKEN_SECRET) //加密方式
                .compact();
    }


    /***
     * 判断token是否过期
     * @param token
     * @param token_secret
     * @return
     */
    public static boolean isExpiration(String token, String token_secret) {
        try {
            return parserToken(token, token_secret)
                    .getExpiration()
                    .before(new Date());
        } catch (ExpiredJwtException ex) {
            return true;
        }
    }


    /***
     * 私钥获取token信息
     * @param token
     * @return
     */
    public static Claims parserToken(String token, String token_secret) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(StringUtils.isBlank(token_secret) ? TOKEN_SECRET : token_secret))
                    .parseClaimsJws(token).getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return claims;
    }
}
