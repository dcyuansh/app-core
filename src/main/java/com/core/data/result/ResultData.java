package com.core.data.result;

import com.core.enums.StatusEnum;
import com.core.utils.StringUtils;
import lombok.Data;

/**
 * @author dechun.yuan
 * @version 1.0
 */
@Data
public class ResultData<T> {

    //返回状态
    private String status;
    //返回数据
    private T data;
    //返回信息
    private String msg;


    public ResultData success(T data, String msg) {
        ResultData result = new ResultData();
        result.setStatus(StatusEnum.SUCCESS.toString());
        if (data != null) {
            result.setData(data);
        }
        if (StringUtils.isNotBlank(msg)) {
            result.setMsg(msg);
        }
        return result;
    }

    public ResultData error(T data, String msg) {
        ResultData result = new ResultData();
        result.setStatus(StatusEnum.FAILED.toString());
        if (data != null) {
            result.setData(data);
        }
        if (StringUtils.isNotBlank(msg)) {
            result.setMsg(msg);
        }
        return result;
    }
}
