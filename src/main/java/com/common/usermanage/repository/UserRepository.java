package com.common.usermanage.repository;

import com.core.data.model.DataModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UserRepository {

    void saveUser(DataModel saveModel);

    DataModel findUser(DataModel queryModel);

    List<DataModel> findAllUser(DataModel queryModel);

    void deleteUser(DataModel deleteModel);

    void updateUser(DataModel updateModel);
}
