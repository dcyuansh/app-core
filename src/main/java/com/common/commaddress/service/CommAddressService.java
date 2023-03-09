package com.common.commaddress.service;

import com.common.commaddress.entity.CommAddress;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (CommAddress)表服务接口
 *
 * @author makejava
 * @since 2023-03-09 16:53:20
 */
public interface CommAddressService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    CommAddress queryById(Integer id);

    /**
     * 分页查询
     *
     * @param commAddress 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<CommAddress> queryByPage(CommAddress commAddress, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param commAddress 实例对象
     * @return 实例对象
     */
    CommAddress insert(CommAddress commAddress);

    /**
     * 修改数据
     *
     * @param commAddress 实例对象
     * @return 实例对象
     */
    CommAddress update(CommAddress commAddress);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
