package com.tool.exportexcelmanage.service.impl;

import com.core.excel.ExcelUtils;
import com.core.excel.pojo.ExcelData;
import com.common.jdbctemplatemanage.service.JdbcTemplateService;
import com.core.utils.FileUtils;
import com.tool.exportexcelmanage.service.ExportExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;

@Service
public class ExportExcelServiceImpl implements ExportExcelService {

    @Autowired
    private JdbcTemplateService jdbcTemplateService;

    private final static String sqlPath = "sql/";


    @Async("customTaskExecutor")
    @Override
    public void exportExcelBySql() {
        try {
            ClassPathResource cpr = new ClassPathResource(sqlPath + "exec.sql");
            StringBuffer stringBuffer = FileUtils.readFileByLine(cpr.getFile().toString());
            ExcelData excelData = jdbcTemplateService.queryExcelData(stringBuffer.toString());
            FileOutputStream output = new FileOutputStream("C:\\Users\\DeChunYuan\\Desktop\\exec.xlsx");
            ExcelUtils.exportExcel(excelData, output);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
