package com.common.workflowmanager.service.impl;

import com.common.workflowmanager.enums.ProcApproveStatusEnum;
import com.common.workflowmanager.enums.ProcStateEnum;
import com.common.workflowmanager.service.WorkFlowService;
import com.core.data.model.DataModel;
import com.core.utils.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author dc.yuan
 * @version 1.0
 */
@Aspect
@Component
public class WorkFlowServiceAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WorkFlowService workFlowService;


    /**
     * 指定切点
     * 匹配 com...*.service下的completeWorkFlowProc方法
     */
    @Pointcut("execution(public * com..*.service.*.*.completeWorkFlowProc(..))")
    public void execute() {
    }


    /***
     * 处理完请求返回内容
     * @param joinPoint
     * @throws Throwable
     */
    @AfterReturning(pointcut = "execute()")
    public void doAfterReturning(JoinPoint joinPoint) throws Throwable {
        //获取目标方法的参数信息
        Object[] obj = joinPoint.getArgs();
        for (Object argItem : obj) {
            if (argItem instanceof DataModel) {
                DataModel queryModel = (DataModel) argItem;
                DataModel currentStepModel = workFlowService.findWorkFlowStepDef(queryModel);
                ProcApproveStatusEnum approveStatusEnum = ProcApproveStatusEnum.getInstance(queryModel.getStringValue("approveCode"));
                if (approveStatusEnum.isApproved()) {
                    //approved workflow process
                    String toStepCode = currentStepModel.getStringValue("toStepCode");
                    //continual next workflow node
                    if (StringUtils.isNotBlank(toStepCode)) {
                        queryModel.setFieldValue("stepCode", toStepCode);
                        //find next step assignee,update to workflow process assignee info
                        DataModel nextStepModel = workFlowService.findWorkFlowStepDef(queryModel);
                        queryModel.setFieldValue("assignee", nextStepModel.getStringValue("assignee"));
                    } else {
                        //complete workflow task
                        queryModel.setFieldValue("state", ProcStateEnum.COMPLETED);
                    }
                } else {
                    //disapproved workflow process
                    String fromStepCode = currentStepModel.getStringValue("fromStepCode");
                    if (StringUtils.isNotBlank(fromStepCode)) {
                        DataModel fromStepModel = workFlowService.findWorkFlowStepDef(queryModel);
                        queryModel.setFieldValue("stepCode", fromStepCode);
                        queryModel.setFieldValue("assignee", fromStepModel.getStringValue("assignee"));
                    }
                    queryModel.setFieldValue("state", ProcStateEnum.REJECTED);
                }
                //update workflow process info
                workFlowService.updateWorkFlowProc(queryModel);
            }
            logger.info("auto to next workflow node:{}", argItem);
        }
    }
}
