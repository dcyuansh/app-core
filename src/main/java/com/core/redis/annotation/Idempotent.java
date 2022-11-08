package com.core.redis.annotation;

import java.lang.annotation.*;

/**
 * @author DC Yuan
 * @version 1.0
 * @date 2022-11-08 17:31
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Idempotent {

    /**
     * 唯一表示key
     */
    String key() default "";

    /**
     * 持续时间秒
     */
    long timeOut() default 1;
}
