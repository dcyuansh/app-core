package com.core.pagehelper.aop;

import com.core.constants.SystemConstant;
import com.core.pagehelper.pojo.PaginationInfo;
import com.core.utils.StringUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author dc.yuan
 * @version 1.0
 */
@Configuration
@Aspect
@EnableAspectJAutoProxy
public class PaginationAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 指定切点
     */
    @Pointcut("@annotation(com.core.pagehelper.annotation.Pagination)")
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
            logger.error("PageHelper分页查询数据库异常：{}", e);
        }
        return result;
    }

}
