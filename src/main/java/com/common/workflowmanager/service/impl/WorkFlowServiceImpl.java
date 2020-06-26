package com.common.workflowmanager.service.impl;

import com.common.workflowmanager.enums.ProcStateEnum;
import com.common.workflowmanager.repository.WorkFlowRepository;
import com.common.workflowmanager.service.WorkFlowService;
import com.core.data.model.DataModel;
import com.core.exception.ExceptionHelper;
import com.core.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dechun.yuan
 * @version 1.0
 */
@Service
public class WorkFlowServiceImpl implements WorkFlowService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WorkFlowRepository workFlowRepository;


    /***
     * create workflow task
     * @param saveModel
     * @return
     */
    @Override
    public DataModel startWorkFlowProc(DataModel saveModel) {
        this.validateSaveWorkflow(saveModel);
        //启动任务,设置状态为正在进行中
        saveModel.setFieldValue("state", ProcStateEnum.INPROGRESS);
        workFlowRepository.saveWorkFlowProc(saveModel);
        return saveModel;
    }


    /***
     * complete workflow task
     * @param updateModel
     */
    @Override
    public void completeWorkFlowProc(DataModel updateModel) {
        this.validateUpdateWorkflow(updateModel);
        workFlowRepository.saveWorkFlowProcHis(updateModel);
    }


    /***
     * find all workflow task
     * @param queryModel
     * @return
     */
    @Override
    public List<DataModel> findWorkFlowProcList(DataModel queryModel) {
        return workFlowRepository.findWorkFlowProcList(queryModel);
    }


    /***
     * update workflow process
     * @param updateModel
     */
    @Override
    public void updateWorkFlowProc(DataModel updateModel) {
        workFlowRepository.updateWorkFlowProc(updateModel);
    }


    /***
     * save workflow process history
     * @param saveModel
     */
    @Override
    public void saveWorkFlowProcHis(DataModel saveModel) {
        workFlowRepository.saveWorkFlowProcHis(saveModel);
    }


    /***
     * find workflow step def
     * @param queryModel
     * @return
     */
    @Override
    public DataModel findWorkFlowStepDef(DataModel queryModel) {
        return workFlowRepository.findWorkFlowStepDef(queryModel);
    }


    /***
     * validate create workflow info
     * @param workFlowModel
     */
    protected void validateSaveWorkflow(DataModel workFlowModel) {
        String validationMsg = "";
        if (StringUtils.isBlank(workFlowModel.getStringValue("wfCode"))) {
            validationMsg = "process code can not be null!";
        } else if (StringUtils.isBlank(workFlowModel.getStringValue("ownerId"))) {
            validationMsg = "create user can not be null!";
        }
        if (StringUtils.isNotEmpty(validationMsg)) {
            throw ExceptionHelper.getInstance().handleValidationException(validationMsg);
        }
    }


    /***
     * validate update workflow info
     * @param updateWfModel
     */
    protected void validateUpdateWorkflow(DataModel updateWfModel) {
        String validationMsg = "";
        if (StringUtils.isBlank(updateWfModel.getStringValue("stepCode"))) {
            validationMsg = "process code can not be null!";
        } else if (StringUtils.isBlank(updateWfModel.getStringValue("state"))) {
            validationMsg = "process state can not be null!";
        } else if (StringUtils.isBlank(updateWfModel.getStringValue("assignee"))) {
            validationMsg = "process assignee can not be null!";
        }
        if (StringUtils.isNotEmpty(validationMsg)) {
            throw ExceptionHelper.getInstance().handleValidationException(validationMsg);
        }
    }
}
