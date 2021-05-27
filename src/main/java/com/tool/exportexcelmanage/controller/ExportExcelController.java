package com.tool.exportexcelmanage.controller;

import com.core.controller.BaseController;
import com.core.data.model.DataModel;
import com.core.enums.StatusEnum;
import com.tool.exportexcelmanage.service.ExportExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@EnableAsync
@Controller
@RequestMapping("/api/export")
public class ExportExcelController extends BaseController {

    @Autowired
    private ExportExcelService exportExcelService;

    @RequestMapping(method = RequestMethod.GET, value = "/excel")
    @ResponseBody
    public Map<String, Object> eportExcel(HttpServletRequest request) {
        DataModel resultModel = new DataModel();
        resultModel.setFieldValue("status", StatusEnum.SUCCESS);
        exportExcelService.exportExcelBySql();
        return resultModel;
    }
}
