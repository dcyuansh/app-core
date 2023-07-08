package com.config.pagehelper.aop;

import com.config.pagehelper.pojo.PaginationInfo;
import com.constant.SystemConstant;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author DC Yuan
 * @version 1.0
 */
@Slf4j
@Configuration
@Aspect
@EnableAspectJAutoProxy
public class PaginationAspect {

    /**
     * 指定切点
     */
    @Pointcut("@annotation(com.config.pagehelper.annotation.Pagination)")
    public void execute() {
    }


    @Around("execute()")
    public Object arround(ProceedingJoinPoint pjp) throws Throwable {
        //返回值
        Object result = null;
        //设置默认当前页
        int pageNum = 1;
        //设置默认每页记录数量
        int pageSize = 10;
        PaginationInfo paginationInfo = null;
        Object[] args = pjp.getArgs();
        for (Object arg : args) {
            if (arg instanceof PaginationInfo) {
                paginationInfo = (PaginationInfo) arg;
                pageNum = paginationInfo.getPageNum() == 0 || StringUtils.isBlank(String.valueOf(paginationInfo.getPageNum())) ? SystemConstant.PAGE_NUM : paginationInfo.getPageNum();
                pageSize = paginationInfo.getPageSize() == 0 || StringUtils.isBlank(String.valueOf(paginationInfo.getPageSize())) ? SystemConstant.PAGE_SIZE : paginationInfo.getPageSize();
            }
        }
        try {
            //调用PageHelper分页分页方法
            Page<Object> page = PageHelper.startPage(pageNum, pageSize);
            //执行被增强的方法，不写被增强的方法不会执行
            result = pjp.proceed(args);
            //获取分页后的参数
            paginationInfo.setPageNum(page.getPageNum());
            paginationInfo.setPageSize(page.getPageSize());
            paginationInfo.setPages(page.getPages());
            paginationInfo.setTotal(page.getTotal());
        } catch (Exception e) {
            log.error("PageHelper分页查询数据库异常：{}", e);
        }
        return result;
    }

}
