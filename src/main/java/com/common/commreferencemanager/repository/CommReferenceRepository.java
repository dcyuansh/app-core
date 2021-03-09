package com.common.commreferencemanager.repository;

import com.core.data.model.DataModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author spring.yuan
 * @version 1.0
 */
@Repository
@Mapper
public interface CommReferenceRepository {

    void saveCommReference(DataModel saveModel);

    DataModel queryCommReference(DataModel queryModel);

    List<DataModel> queryCommReferenceList(DataModel queryModel);
}
