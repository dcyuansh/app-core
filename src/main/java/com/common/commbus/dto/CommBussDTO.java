package com.common.commbus.dto;

import com.core.pagehelper.pojo.PaginationInfo;
import lombok.Data;

/**
 * @author spring.yuan
 * @version 1.0
 */
@Data
public class CommBussDTO extends PaginationInfo {

    private String busName;

    private String busDesc;

    private String busType;

}
