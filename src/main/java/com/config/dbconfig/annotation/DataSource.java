package com.config.dbconfig.annotation;

import com.config.dbconfig.multipledatasource.DataSourceType;

import java.lang.annotation.*;

/**
 * @author DC Yuan
 * @version 1.0
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface DataSource {
    DataSourceType value() default DataSourceType.MASTER;
}