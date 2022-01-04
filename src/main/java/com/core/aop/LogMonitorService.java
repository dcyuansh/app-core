package com.core.aop;

import com.core.constants.SystemConstant;
import com.core.message.service.MessageManager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author spring.yuan
 * @version 1.0
 * 通用AOP处理Web请求日志
 */
@Aspect
@Component
public class LogMonitorService {
    private Logger logger = LoggerFactory.getLogger(LogMonitorService.class);

    /***
     * 指定切点
     * 匹配 com..*.controller包及其子包下的所有类的所有方法
     */
    @Pointcut("execution(public * com..*.controller.*.*(..))")
    public void execute() {
    }

    /***
     * 前置通知，方法调用前被调用
     * @param joinPoint
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
        logger.info("Request IP：" + req.getRemoteAddr());
        //请求URL
        logger.info("Request URL：" + req.getRequestURL().toString());
        //HTTP_METHOD
        logger.info("Request Type：" + req.getMethod());
        //参数名
        logger.info("Request Parameter：" + Arrays.toString(strings));
        //参数值ARGS
        logger.info("Request Parameter Values：" + Arrays.toString(joinPoint.getArgs()));
        //CLASS_METHOD
        logger.info("Request Method：" + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
    }


    /***
     * 处理完请求返回内容
     * @param result
     * @throws Throwable
     */
    @AfterReturning(returning = "result", pointcut = "execute()")
    public void doAfterReturning(Object result) throws Throwable {
        // 处理完请求，返回内容
        if (result instanceof Map) {
            List messageList = MessageManager.getInstance().getAllMessage();
            ((Map) result).put(SystemConstant.RESULT_INFO, messageList);
        }
        logger.info("Request Return Value：" + result);
    }

    /***
     * 后置异常通知
     * @param jp
     */
    @AfterThrowing("execute()")
    public void throwss(JoinPoint jp) {
        logger.error("方法异常时执行.....");
    }

    /***
     * 后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
     * @param jp
     */
    @After("execute()")
    public void after(JoinPoint jp) {

    }

    /***
     * 环绕通知,环绕增强，相当于MethodInterceptor
     * @param pjp
     * @return
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
