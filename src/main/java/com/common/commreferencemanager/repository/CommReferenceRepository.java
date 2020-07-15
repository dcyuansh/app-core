package com.common.commreferencemanager.repository;

import com.core.data.model.DataModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author dechun.yuan
 * @version 1.0
 */
@Mapper
public interface CommReferenceRepository {

    void saveCommReference(DataModel saveModel);

    DataModel queryCommReference(DataModel queryModel);

    List<DataModel> queryCommReferenceList(DataModel queryModel);
}
