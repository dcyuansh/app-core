package com.core.redis.aop;

import com.core.redis.annotation.Idempotent;
import com.core.utils.EncryptUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * @author DC Yuan
 * @version 1.0
 * @date 2022-11-08 17:34
 */
@Component
@Aspect
public class IdempotentAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 指定切点
     */
    @Pointcut("@annotation(com.core.redis.annotation.Idempotent)")
    public void execute() {
    }

    /**
     * @param joinPoint
     * @desc 前置通知，方法调用前被调用
     */
    @Before("execute()")
    public void doBefore(JoinPoint joinPoint) {
        //获取方法
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        //获取幂等注解
        Idempotent idempotent = method.getAnnotation(Idempotent.class);
        //使用redis控制，相同的时间内，只能有一次执行成功，如果数据参数太长，使用MD5加密
        String key = EncryptUtils.encodeByMd5(Arrays.toString(joinPoint.getArgs()));
        if (Boolean.FALSE.equals(redisTemplate.opsForValue().setIfAbsent(idempotent.key() + key, key, idempotent.time(), TimeUnit.SECONDS))) {
            logger.error("一定时间内,多次调用接口");
            throw new RuntimeException("一定时间内,多次调用接口");
        }
    }
}
