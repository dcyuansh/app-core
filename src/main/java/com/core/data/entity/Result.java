package com.core.data.entity;

import com.core.enums.StatusEnum;
import com.core.utils.StringUtils;
import lombok.Data;

/**
 * @author dechun.yuan
 * @version 1.0
 */
@Data
public class Result<T> {

    //返回状态
    private String status;
    //返回数据
    private T data;
    //返回信息
    private String msg;


    public Result success(T data, String msg) {
        Result result = new Result();
        result.setStatus(StatusEnum.SUCCESS.toString());
        if (data != null) {
            result.setData(data);
        }
        if (StringUtils.isNotBlank(msg)) {
            result.setMsg(msg);
        }
        return result;
    }

    public Result error(T data, String msg) {
        Result result = new Result();
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
