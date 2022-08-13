package com.common.commbus.dto;

import com.core.pagehelper.pojo.PaginationInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author dc.yuan
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CommBussDTO extends PaginationInfo {

    private String busName;

    private String busDesc;

    private String busType;

}
