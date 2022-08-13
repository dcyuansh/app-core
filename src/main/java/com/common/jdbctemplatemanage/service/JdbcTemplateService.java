package com.common.jdbctemplatemanage.service;

import com.core.data.model.DataModel;
import com.core.excel.pojo.ExcelData;

import java.util.List;

/**
 * @author dc.yuan
 * @version 1.0
 */
public interface JdbcTemplateService {

    /***
     * query DataModel by sql and param
     * @param sql
     * @param queryModel
     * @return
     */
    DataModel queryForDataModel(String sql, DataModel queryModel);

    /***
     * query list DataModel by sql and param
     * @param sql
     * @param queryModel
     * @return
     */
    List<DataModel> queryForDataModelList(String sql, DataModel queryModel);

    /***
     * load excel data by sql
     * @param sql
     * @return
     */
    ExcelData queryExcelData(String sql);
}
