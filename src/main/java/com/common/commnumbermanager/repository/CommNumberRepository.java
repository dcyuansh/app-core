package com.common.commnumbermanager.repository;

import com.core.data.model.DataModel;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author dechun.yuan
 * @version 1.0
 */
@Mapper
public interface CommNumberRepository {

    void saveCommNumber(DataModel saveModel);

    DataModel queryCommNumber(DataModel queryModel);

    void updateCommNumber(DataModel updateModel);
}
