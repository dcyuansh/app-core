package com.common.commnumbergenerate.repository;

import com.core.data.model.DataModel;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author dechun.yuan
 * @version 1.0
 */
@Mapper
public interface CommNumberGenerateRepository {

    void saveCommNumberGenerate(DataModel saveModel);

    DataModel queryCommNumberGenerate(DataModel queryModel);

    void updateCommNumberGenerate(DataModel updateModel);
}
