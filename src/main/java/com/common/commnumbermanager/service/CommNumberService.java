package com.common.commnumbermanager.service;

import com.core.data.model.DataModel;

/**
 * @author dechun.yuan
 * @version 1.0
 */
public interface CommNumberService {

    void saveCommNumber(DataModel saveModel);

    DataModel queryCommNumber(DataModel queryModel);

    void updateCommNumber(DataModel updateModel);

    int generateNumber(DataModel generateModel);
}
