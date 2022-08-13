package com.core.dbconfig.aop;

import com.core.dbconfig.annotation.DataSource;
import com.core.dbconfig.multipledatasource.DataSourceType;
import com.core.dbconfig.multipledatasource.DynamicDataSourceContextHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author dc.yuan
 * @version 1.0
 */
@Aspect
@Component
public class DynamicDataSourceAspect {

    private Logger LOG = LoggerFactory.getLogger(this.getClass());


    /**
     * 在Mapper层添加注解，实现切换数据源
     */
    @Pointcut("execution(public * com..*.repository.*.*(..))")
    public void dataSourcePointCut() {
    }


    @Before("dataSourcePointCut()")
    public void before(JoinPoint joinPoint) {
        Object target = joinPoint.getTarget();
        String method = joinPoint.getSignature().getName();
        Class<?>[] clazz = target.getClass().getInterfaces();
        Class<?>[] parameterTypes = ((MethodSignature) joinPoint.getSignature()).getMethod().getParameterTypes();
        try {
            Method m = clazz[0].getMethod(method, parameterTypes);
            //如果方法上存在切换数据源的注解，则根据注解内容进行数据源切换
            if (m != null && m.isAnnotationPresent(DataSource.class)) {
                DataSource data = m.getAnnotation(DataSource.class);
                DataSourceType dataSourceType = data.value();
                DynamicDataSourceContextHolder.setDataSourceType(dataSourceType);
                LOG.debug("current thread " + Thread.currentThread().getName() + " add " + dataSourceType + " to ThreadLocal");
            } else {
                LOG.debug("no data source specified, so use the default data source.");
            }
        } catch (Exception e) {
            LOG.error("switch datasource fail,current thread " + Thread.currentThread().getName() + " add data to ThreadLocal error", e);
        }
    }

    @After("dataSourcePointCut()")
    public void after(JoinPoint joinPoint) {
        DynamicDataSourceContextHolder.clearDataSourceType();
    }

}
