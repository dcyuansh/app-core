package com.common.commbus.dto;

import com.core.pagehelper.pojo.PaginationInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author dc.yuan
 * @version 1.0
 */
@ApiModel("业务模块数据传输对象")
@Data
@EqualsAndHashCode(callSuper = true)
public class CommBussDTO extends PaginationInfo {

    @ApiModelProperty(value = "业务名字", required = true, example = "中国")
    private String busName;

    @ApiModelProperty(value = "业务描述", example = "CHN")
    private String busDesc;

    @ApiModelProperty(value = "业务类型", example = "AC")
    private String busType;

}
