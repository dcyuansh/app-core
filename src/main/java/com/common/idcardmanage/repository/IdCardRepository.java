package com.common.idcardmanage.repository;

import com.core.data.model.DataModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface IdCardRepository {

    void saveIdCard(DataModel saveModel);

    DataModel queryIdCard(DataModel queryModel);

    List<DataModel> queryIdCardList(DataModel queryModel);

    void deleteIdCard(DataModel deleteModel);

    void updateIdCard(DataModel updateModel);
}
