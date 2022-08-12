package com.common.commbus.service;


import com.common.commbus.dto.CommBussDTO;
import com.common.commbus.vo.CommBussVO;
import com.core.pagehelper.pojo.PaginationInfo;

/**
 * (CommBuss)表服务接口
 *
 * @author spring.yuan
 * @since 2022-08-11 12:47:22
 */
public interface CommBussService {

    PaginationInfo<CommBussVO> queryByPage(CommBussDTO commBussDTO);

}
