package com.common.commbus.service.impl;

import com.common.commbus.dao.CommBussDao;
import com.common.commbus.dto.CommBussDTO;
import com.common.commbus.service.CommBussService;
import com.common.commbus.vo.CommBussVO;
import com.core.pagehelper.pojo.PaginationInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * (CommBuss)表服务实现类
 *
 * @author DC Yuan
 * @since 2022-08-11 12:47:22
 */
@Service("commBussService")
public class CommBussServiceImpl implements CommBussService {
    @Resource
    private CommBussDao commBussDao;

    @Override
    public PaginationInfo<CommBussVO> queryByPage(CommBussDTO commBussDTO) {
        List<CommBussVO> commBussList = commBussDao.queryAllByLimit(commBussDTO).stream()
                .map(item -> {
                            CommBussVO commBussVO = new CommBussVO();
                            //对象copy
                            BeanUtils.copyProperties(item, commBussVO);
                            return commBussVO;
                        }
                ).collect(Collectors.toList());
        return commBussDTO.getPaginationInfo(commBussDTO, commBussList);
    }
}
