package com.core.security;


import com.alibaba.fastjson.JSON;
import com.core.utils.StringUtils;
import com.core.utils.UUidUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.xml.bind.DatatypeConverter;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * @author spring.yuan
 * @version 1.0
 */
@Data
@ConfigurationProperties(prefix = "jwt.token")
@Component
public class JwtTokenUtils implements Serializable {

    //token私钥
    private String secret;
    //签发者
    private String issuer;
    //主题
    private String subject;
    //设置过期时间1天
    private long expiration;
    //token头
    private String header;


    /**
     * @param subject_
     * @param claims
     * @param expireTime
     * @return
     * @desc 生成token签名，过期日期为expireTime
     */
    public String sign(String subject_, Map<String, Object> claims, long expireTime) {
        //json claim参数
        claims.forEach((key, val) ->
                claims.put(key, val instanceof String ? val : JSON.toJSONString(val))
        );

        //过期时间
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        Date expireDate = new Date(nowMillis + (expireTime == 0 ? expiration : expireTime));
        return Jwts.builder()
                .setId(UUidUtils.getUUID())
                .setIssuer(issuer) //签发者信息
                .setSubject(StringUtils.isBlank(subject_) ? subject : subject_) //主题说明
                .addClaims(claims) //claim信息
                .setIssuedAt(now)  //签发时间
                .setExpiration(expireDate) //过期时间戳
                .signWith(SignatureAlgorithm.HS256, secret) //加密方式
                .compact();
    }


    /**
     * @param token
     * @param token_secret
     * @return
     * @desc 判断token是否过期
     */
    public boolean isExpiration(String token, String token_secret) {
        try {
            return parserToken(token, token_secret)
                    .getExpiration()
                    .before(new Date());
        } catch (ExpiredJwtException ex) {
            return true;
        }
    }


    /**
     * @param token
     * @param token_secret
     * @return new token
     * @desc refresh token
     */
    public String refreshToken(String token, String token_secret) {
        String refToken = "";
        Claims claims = this.parserToken(token, token_secret);
        if (claims != null) {
            refToken = this.sign(null, claims, 0);
        }
        return refToken;
    }


    /**
     * @param token
     * @return
     * @desc 私钥获取token信息
     */
    public Claims parserToken(String token, String token_secret) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(StringUtils.isBlank(token_secret) ? secret : token_secret))
                    .parseClaimsJws(token).getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return claims;
    }
}
