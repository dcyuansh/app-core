package com.common.commbus.service.impl;

import com.common.commbus.dao.CommBussDao;
import com.common.commbus.dto.CommBussDTO;
import com.common.commbus.entity.CommBuss;
import com.common.commbus.service.CommBussService;
import com.core.pagehelper.pojo.PaginationInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (CommBuss)表服务实现类
 *
 * @author spring.yuan
 * @since 2022-08-11 12:47:22
 */
@Service("commBussService")
public class CommBussServiceImpl implements CommBussService {
    @Resource
    private CommBussDao commBussDao;


    @Override
    public PaginationInfo<CommBuss> queryByPage(CommBussDTO commBussDTO) {
        List<CommBuss> commBussList = commBussDao.queryAllByLimit(commBussDTO);
        return commBussDTO.getPaginationInfo(commBussDTO, commBussList);
    }
}
