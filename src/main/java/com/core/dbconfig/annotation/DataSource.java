package com.core.dbconfig.annotation;

import com.core.dbconfig.multipledatasource.DataSourceType;

import java.lang.annotation.*;

/**
 * @author spring.yuan
 * @version 1.0
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface DataSource {
    DataSourceType value() default DataSourceType.MASTER;
}