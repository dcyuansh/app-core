package com.common.idcardmanage.repository;

import com.core.data.model.DataModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IdCardRepository {

    void saveIdCard(DataModel saveModel);

    DataModel findIdCard(DataModel queryModel);

    List<DataModel> findAllIdCard(DataModel queryModel);

    void deleteIdCard(DataModel deleteModel);

    void updateIdCard(DataModel updateModel);
}
