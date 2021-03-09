package com.common.workflowmanager.repository;

import com.core.data.model.DataModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * @author spring.yuan
 * @version 1.0
 */
@Mapper
public interface WorkFlowRepository {

    /***
     *  start workflow
     * @param saveModel
     * @return
     */
    void saveWorkFlowProc(DataModel saveModel);


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
     * @param updateModel
     */
    void saveWorkFlowProcHis(DataModel updateModel);


    /***
     * find workflow step def
     * @param queryModel
     * @return
     */
    DataModel findWorkFlowStepDef(DataModel queryModel);
}
