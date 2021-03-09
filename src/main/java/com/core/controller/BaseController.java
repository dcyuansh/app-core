package com.core.controller;

import com.core.data.model.DataModel;
import com.core.enums.StatusEnum;
import com.core.exception.ValidationException;
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

    public static final String RESULT_STATUS = "status";
    public static final String RESULT_CODE = "code";
    public static final String RESULT_DATA = "data";
    public static final String ERROR_MESSAGE = "errorMsg";


    /***
     * 获取请求map参数，封装为DataModel对象
     * @param requestMap
     * @return
     */
    protected DataModel getInputData(Map<String, Object> requestMap) {
        DataModel inputData = new DataModel();
        for (Map.Entry<String, Object> entry : requestMap.entrySet()) {
            inputData.put(entry.getKey(), entry.getValue(), true, false);
        }
        return inputData;
    }


    /***
     * 获取request请求参数，封装为DataModel对象
     * @param request
     * @return
     */
    protected DataModel getInputData(HttpServletRequest request) {
        DataModel inputData = new DataModel();
        Enumeration en = request.getParameterNames();
        while (en.hasMoreElements()) {
            String paramName = (String) en.nextElement();
            String[] values = request.getParameterValues(paramName);
            if (values.length > 1) {
                inputData.put(paramName, values, true, false);
                List paramArrayList = new ArrayList();
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
        for (Object aParmNameList : parmNameList) {
            String paramName = String.valueOf(aParmNameList);
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


    protected List<DataModel> getInputDataList(List<Map> requestDataList) {
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
     * 请求有校验错误信息是，设置返回参数
     * @param ve
     * @param resultMap
     * @return
     */
    public Map<String, Object> handleValidationExcpetion(ValidationException ve, DataModel resultMap) {
        if (resultMap == null) {
            resultMap = new DataModel();
        }
        logger.warn(ve.getMessage());
        resultMap.setFieldValue(RESULT_STATUS, StatusEnum.FAILED);
        resultMap.setFieldValue(RESULT_CODE, "VALIDATION_FAILED");
        resultMap.setFieldValue(ERROR_MESSAGE, ve.getMessage());
        return resultMap;
    }


    /***
     * 请求发送异常时，设置返回参数
     * @param e
     * @param resultMap
     * @return
     */
    public Map<String, Object> handleException(Exception e, DataModel resultMap) {
        if (resultMap == null) {
            resultMap = new DataModel();
        }
        logger.error(e.getMessage(), e);
        resultMap.setFieldValue(RESULT_STATUS, StatusEnum.FAILED);
        //code: 500
        resultMap.setFieldValue(RESULT_CODE, HttpStatus.SC_INTERNAL_SERVER_ERROR);
        resultMap.setFieldValue(ERROR_MESSAGE, e.getMessage());
        return resultMap;
    }


    /***
     * 请求成功收，设置返回参数
     * @param resultMap
     * @return
     */
    public Map<String, Object> handleSuccess(DataModel resultMap) {
        return this.handleSuccess(null, resultMap);
    }


    /***
     * 请求成功收，设置返回参数
     * @param resultMap
     * @return
     */
    public Map<String, Object> handleSuccess(Object obj, DataModel resultMap) {
        if (resultMap == null) {
            resultMap = new DataModel();
        }
        logger.info("request success!");
        resultMap.setFieldValue(RESULT_STATUS, StatusEnum.SUCCESS);
        //code: 200
        resultMap.setFieldValue(RESULT_CODE, HttpStatus.SC_OK);
        if (obj != null) {
            resultMap.setFieldValue(RESULT_DATA, obj);
        }
        return resultMap;
    }
}
