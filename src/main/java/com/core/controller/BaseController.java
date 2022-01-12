package com.core.controller;

import com.core.constants.SystemConstant;
import com.core.data.model.DataModel;
import com.core.enums.StatusEnum;
import com.core.exception.ValidationException;
import com.core.message.service.MessageManager;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author spring.yuan
 * @version 1.0
 */
public abstract class BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    /**
     * @param requestMap 输入的map参数
     * @return 返回, map转换为DataModel对象
     * @desc 获取请求map参数，封装为DataModel对象
     */
    protected DataModel getInputData(Map<String, Object> requestMap) {
        DataModel inputData = new DataModel();
        for (Map.Entry<String, Object> entry : requestMap.entrySet()) {
            inputData.put(entry.getKey(), entry.getValue(), true, false);
        }
        return inputData;
    }


    /**
     * @param request
     * @return
     * @desc 获取request请求参数，封装为DataModel对象
     */
    protected DataModel getInputData(HttpServletRequest request) {
        DataModel inputData = new DataModel();
        Enumeration en = request.getParameterNames();
        while (en.hasMoreElements()) {
            String paramName = (String) en.nextElement();
            String[] values = request.getParameterValues(paramName);
            if (values.length > 1) {
                inputData.put(paramName, values, true, false);
                List<String> paramArrayList = new ArrayList<>();
                Collections.addAll(paramArrayList, values);
                if (request.getParameter(paramName + "List") == null)
                    inputData.put(paramName + "List", paramArrayList, true, false);
            } else {
                inputData.put(paramName, values[0], true, false);
            }
        }
        return inputData;
    }


    protected List<DataModel> getInputDataList(HttpServletRequest request, List parmNameList) {
        List<DataModel> modelList = new ArrayList<>();
        for (Object onParamNName : parmNameList) {
            String paramName = String.valueOf(onParamNName);
            String[] paramValues = request.getParameterValues(paramName);
            if (paramValues != null) {
                for (int j = 0; j < paramValues.length; j++) {
                    if (modelList.size() < (j + 1)) {
                        modelList.add(new DataModel());
                    }
                    DataModel dataModel = modelList.get(j);
                    dataModel.put(paramName, paramValues[j], true, false);
                }
            }
        }
        return modelList;
    }


    protected List<DataModel> getInputDataList(List<Map<String, Object>> requestDataList) {
        List<DataModel> modelList = new ArrayList<>();
        if (requestDataList != null) {
            for (int i = 0; i < requestDataList.size(); i++) {
                DataModel dataModel = new DataModel(requestDataList.get(i));
                modelList.add(dataModel);
            }
        }
        return modelList;
    }


    /***
     * 请求成功收，设置返回参数
     * @param resultMap
     * @return
     */
    public Map<String, Object> handleSuccess(DataModel resultMap) {
        return this.handleSuccess(resultMap, null);
    }


    /**
     * @param resultMap
     * @return
     * @desc 请求成功收，设置返回参数
     */
    public Map<String, Object> handleSuccess(DataModel resultMap, Object obj) {
        if (resultMap == null) {
            resultMap = new DataModel();
        }
        resultMap.setFieldValue(SystemConstant.RESULT_STATUS, StatusEnum.SUCCESS);
        //code: 200
        resultMap.setFieldValue(SystemConstant.RESULT_CODE, HttpStatus.SC_OK);
        //data: 数据
        resultMap.setFieldValue(SystemConstant.RESULT_DATA, obj);
        //message: 信息
        resultMap.setFieldValue(SystemConstant.RESULT_MESSAGE, "");
        //info: 前端提示信息
        List messageList = MessageManager.getInstance().getAllMessage();
        if (messageList.size() > 0) {
            resultMap.setFieldValue(SystemConstant.RESULT_INFO, messageList);
        }
        //logger.info("the request is successful, return data:{}", obj);
        return resultMap;
    }


    /**
     * @param ve
     * @param resultMap
     * @return
     * @desc 请求有校验错误信息是，设置返回参数
     */
    public Map<String, Object> handleValidationException(DataModel resultMap, ValidationException ve) {
        if (resultMap == null) {
            resultMap = new DataModel();
        }
        resultMap.setFieldValue(SystemConstant.RESULT_STATUS, StatusEnum.FAILED);
        //code: 400
        resultMap.setFieldValue(SystemConstant.RESULT_CODE, HttpStatus.SC_BAD_REQUEST);
        //data: 数据
        resultMap.setFieldValue(SystemConstant.RESULT_DATA, null);
        //message: 错误信息
        resultMap.setFieldValue(SystemConstant.RESULT_MESSAGE, ve.getMessage());
        //info: 前端提示信息
        List messageList = MessageManager.getInstance().getAllMessage();
        if (messageList.size() > 0) {
            resultMap.setFieldValue(SystemConstant.RESULT_INFO, messageList);
        }
        logger.warn("validation exception:{}", ve.getMessage());
        return resultMap;
    }


    /**
     * @param e
     * @param resultMap
     * @return
     * @desc 请求发送异常时，设置返回参数
     */
    public Map<String, Object> handleException(DataModel resultMap, Exception e) {
        if (resultMap == null) {
            resultMap = new DataModel();
        }
        resultMap.setFieldValue(SystemConstant.RESULT_STATUS, StatusEnum.FAILED);
        //code: 500
        resultMap.setFieldValue(SystemConstant.RESULT_CODE, HttpStatus.SC_INTERNAL_SERVER_ERROR);
        //data: 数据
        resultMap.setFieldValue(SystemConstant.RESULT_DATA, null);
        //message: 错误信息
        resultMap.setFieldValue(SystemConstant.RESULT_MESSAGE, e.getMessage());
        //info: 前端提示信息
        List messageList = MessageManager.getInstance().getAllMessage();
        if (messageList.size() > 0) {
            resultMap.setFieldValue(SystemConstant.RESULT_INFO, messageList);
        }
        logger.error("system runtime exception:{}", e.getMessage());
        return resultMap;
    }
}
