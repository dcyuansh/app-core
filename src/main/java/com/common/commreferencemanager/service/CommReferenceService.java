package com.common.commreferencemanager.service;

import com.core.data.model.DataModel;

import java.util.List;

/**
 * @author dechun.yuan
 * @version 1.0
 */
public interface CommReferenceService {

    void saveCommReference(DataModel saveModel);

    List<DataModel> queryCommReference(DataModel queryModel);

    void updateCommReferenceLastValue(DataModel updateModel);

    int generateNumber(DataModel generateModel);
}
