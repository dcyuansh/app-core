package com.common.commbus.dao;

import com.common.commbus.dto.CommBussDTO;
import com.common.commbus.entity.CommBuss;
import com.core.pagehelper.annotation.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (CommBuss)表数据库访问层
 *
 * @author dc.yuan
 * @since 2022-08-11 12:47:19
 */
@Repository
@Mapper
public interface CommBussDao {


    @Pagination
    List<CommBuss> queryAllByLimit(CommBussDTO commBussDTO);

}

