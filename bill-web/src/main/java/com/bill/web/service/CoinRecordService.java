package com.bill.web.service;

import com.bill.web.entity.CoinRecord;

import java.util.List;

/**
 * 币记录(CoinRecord)表服务接口
 *
 * @author makejava
 * @since 2021-08-18 23:18:33
 */
public interface CoinRecordService {

    /**
     * 通过ID查询单条数据
     *
     * @param  主键
     * @return 实例对象
     */
    CoinRecord queryById(long id );

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<CoinRecord> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param coinRecord 实例对象
     * @return 实例对象
     */
    CoinRecord insert(CoinRecord coinRecord);

    /**
     * 修改数据
     *
     * @param coinRecord 实例对象
     * @return 实例对象
     */
    CoinRecord update(CoinRecord coinRecord);

    /**
     * 通过主键删除数据
     *
     * @param  主键
     * @return 是否成功
     */
    boolean deleteById( );

}