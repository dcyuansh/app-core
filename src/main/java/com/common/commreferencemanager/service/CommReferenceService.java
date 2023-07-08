package com.common.commreferencemanager.service;

import com.core.data.model.DataModel;

import java.util.List;

/**
 * @author DC Yuan
 * @version 1.0
 */
public interface CommReferenceService {

    /***
     * save comm_reftab
     * @param saveModel
     */
    void saveCommReference(DataModel saveModel);

    /***
     * query comm_reftab
     * @param queryModel
     * @return
     */
    DataModel queryCommReference(DataModel queryModel);

    /***
     * query comm_reftab list
     * @param queryModel
     * @return
     */
    List<DataModel> queryCommReferenceList(DataModel queryModel);
}
