package com.common.commaddress.service.impl;

import com.common.commaddress.entity.CommAddress;
import com.common.commaddress.dao.CommAddressDao;
import com.common.commaddress.service.CommAddressService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (CommAddress)表服务实现类
 *
 * @author makejava
 * @since 2023-03-09 16:53:20
 */
@Service("commAddressService")
public class CommAddressServiceImpl implements CommAddressService {
    @Resource
    private CommAddressDao commAddressDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public CommAddress queryById(Integer id) {
        return this.commAddressDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param commAddress 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<CommAddress> queryByPage(CommAddress commAddress, PageRequest pageRequest) {
        long total = this.commAddressDao.count(commAddress);
        return new PageImpl<>(this.commAddressDao.queryAllByLimit(commAddress, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param commAddress 实例对象
     * @return 实例对象
     */
    @Override
    public CommAddress insert(CommAddress commAddress) {
        this.commAddressDao.insert(commAddress);
        return commAddress;
    }

    /**
     * 修改数据
     *
     * @param commAddress 实例对象
     * @return 实例对象
     */
    @Override
    public CommAddress update(CommAddress commAddress) {
        this.commAddressDao.update(commAddress);
        return this.queryById(commAddress.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.commAddressDao.deleteById(id) > 0;
    }
}
