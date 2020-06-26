package com.common.workflowmanager.service;

import com.core.data.model.DataModel;

import java.util.List;

/**
 * @author dechun.yuan
 * @version 1.0
 */
public interface WorkFlowService {

    /***
     * start workflow
     * @param saveModel
     * @return
     */
    DataModel startWorkFlowProc(DataModel saveModel);


    /***
     * complete workflow process
     * @param updateModel
     */
    void completeWorkFlowProc(DataModel updateModel);



    /***
     * query workflow process
     * @param queryModel
     * @return
     */
    List<DataModel> findWorkFlowProcList(DataModel queryModel);


    /***
     * update workflow process
     * @param updateModel
     */
    void updateWorkFlowProc(DataModel updateModel);


    /***
     * save workflow process history
     * @param saveModel
     */
    void saveWorkFlowProcHis(DataModel saveModel);


    /***
     * find workflow step def
     * @param queryModel
     * @return
     */
    DataModel findWorkFlowStepDef(DataModel queryModel);
}
