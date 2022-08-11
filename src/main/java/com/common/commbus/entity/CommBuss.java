package com.common.commbus.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (CommBuss)实体类
 *
 * @author spring.yuan
 * @since 2022-08-11 12:47:20
 */
@Data
public class CommBuss implements Serializable {
    private static final long serialVersionUID = -81963887741652440L;
    
    private String busName;
    
    private String busDesc;
    
    private String busType;

}

