package com.common.idcardmanage.service;

import com.core.data.model.DataModel;

import java.util.List;

public interface IdCardService {

    void saveIdCard(DataModel saveModel);

    DataModel queryIdCard(DataModel queryModel);

    List<DataModel> queryIdCardList(DataModel queryModel);

    void deleteIdCard(DataModel deleteModel);

    void updateIdCard(DataModel updateModel);
}
