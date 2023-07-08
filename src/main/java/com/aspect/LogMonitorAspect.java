package com.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 系统日志监控实现类
 *
 * @author DC Yuan
 * @since 2020-02-08
 */
@Aspect
@Component
@Slf4j
public class LogMonitorAspect {

    /**
     * @desc 指定切点
     * 匹配 com..*.controller包及其子包下的所有类的所有方法
     */
    @Pointcut("execution(public * com..*.controller.*.*(..))")
    public void execute() {
    }

    /**
     * @param joinPoint
     * @desc 前置通知，方法调用前被调用
     */
    @Before("execute()")
    public void doBefore(JoinPoint joinPoint) {
        //获取目标方法的参数信息
        Object[] obj = joinPoint.getArgs();
        Signature signature = joinPoint.getSignature();
        //代理的是哪一个方法  方法： signature.getName()
        //AOP代理类的名字  方法所在包: signature.getDeclaringTypeName()
        //AOP代理类的类（class）信息: signature.getDeclaringType()
        MethodSignature methodSignature = (MethodSignature) signature;
        String[] strings = methodSignature.getParameterNames();
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest req = attributes.getRequest();

        // 记录下请求内容
        //请求IP
        log.info("Request IP:{}", req.getRemoteAddr());
        //请求URL
        log.info("Request URL:{}", req.getRequestURL().toString());
        //HTTP_METHOD
        log.info("Request Type:{}", req.getMethod());
        //参数名
        log.info("Request Parameter:{}", Arrays.toString(strings));
        //参数值ARGS
        log.info("Request Parameter Values:{}", Arrays.toString(joinPoint.getArgs()));
        //CLASS_METHOD
        log.info("Request Method:{}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
    }


    /**
     * @param result 返回的结果集
     * @throws Throwable
     * @desc 处理完请求返回内容
     */
    @AfterReturning(returning = "result", pointcut = "execute()")
    public void doAfterReturning(Object result) throws Throwable {
        // 处理完请求，返回内容
//        if (result instanceof Map) {
//            List messageList = AbstractMessageManager.getInstance().getAllMessage();
//            if (messageList.size() > 0)
//                ((Map) result).put(SystemConstant.RESULT_INFO, messageList);
//        }
        log.info("Request Return Value:{}", result);
    }

    /**
     * @param jp
     * @desc 后置异常通知
     */
    @AfterThrowing("execute()")
    public void throwss(JoinPoint jp) {
        log.error("方法异常时执行.....");
    }


    /**
     * @param jp
     * @desc 后置最终通知, final增强，不管是抛出异常或者正常退出都会执行
     */
    @After("execute()")
    public void after(JoinPoint jp) {

    }

    /**
     * @param pjp
     * @return 返回结果集
     * @desc 环绕通知, 环绕增强，相当于MethodInterceptor
     */
    @Around("execute()")
    public Object arround(ProceedingJoinPoint pjp) {
        try {
            Object o = pjp.proceed();
            return o;
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }
}
