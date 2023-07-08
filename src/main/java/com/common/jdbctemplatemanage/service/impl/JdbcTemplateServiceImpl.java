package com.common.jdbctemplatemanage.service.impl;

import com.common.jdbctemplatemanage.service.JdbcTemplateService;
import com.model.data.DataModel;
import com.utils.excel.pojo.ExcelData;
import com.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * @author DC Yuan
 * @version 1.0
 */
@Service
public class JdbcTemplateServiceImpl implements JdbcTemplateService {

    private Logger logger = LoggerFactory.getLogger(JdbcTemplateServiceImpl.class);


    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public DataModel queryForDataModel(String sql, DataModel queryModel) {
        if (StringUtils.isBlank(sql)) {
            return null;
        }
        BeanPropertyRowMapper<DataModel> rowMapper = new BeanPropertyRowMapper<DataModel>(DataModel.class);
        DataModel resultModel = jdbcTemplate.queryForObject(sql, rowMapper, queryModel);
        return resultModel;
    }

    @Override
    public List<DataModel> queryForDataModelList(String sql, DataModel queryModel) {
        if (StringUtils.isBlank(sql)) {
            return null;
        }
        BeanPropertyRowMapper<DataModel> rowMapper = new BeanPropertyRowMapper<DataModel>(DataModel.class);
        List<DataModel> resultModel = jdbcTemplate.query(sql, rowMapper, queryModel);
        return resultModel;
    }

    @Override
    public ExcelData queryExcelData(String sql) {
        ExcelData excelData = new ExcelData();
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);
        if (result == null || result.size() == 0) {
            return null;
        } else {
            List<String> titles = new ArrayList<String>(result.get(0).keySet());
            List<List<Object>> rows = new ArrayList<>();
            for (int i = 0; i < result.size(); i++) {
                List<Object> values = new ArrayList<Object>(result.get(i).values());
                rows.add(values);
            }
            excelData.setTitles(titles);
            excelData.setRows(rows);
        }
        return excelData;
    }
}
