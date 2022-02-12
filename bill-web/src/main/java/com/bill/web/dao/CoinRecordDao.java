package com.bill.web.dao;

import com.bill.web.entity.CoinRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 币记录(CoinRecord)表数据库访问层
 *
 * @author makejava
 * @since 2021-08-18 23:18:32
 */
@Mapper
public interface CoinRecordDao {

    /**
     * 通过ID查询单条数据
     *
     * @param  主键
     * @return 实例对象
     */
    CoinRecord queryById(long id  );

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<CoinRecord> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param coinRecord 实例对象
     * @return 对象列表
     */
    List<CoinRecord> queryAll(CoinRecord coinRecord);

    /**
     * 新增数据
     *
     * @param coinRecord 实例对象
     * @return 影响行数
     */
    int insert(CoinRecord coinRecord);

    /**
     * 修改数据
     *
     * @param coinRecord 实例对象
     * @return 影响行数
     */
    int update(CoinRecord coinRecord);

    /**
     * 通过主键删除数据
     *
     * @param  主键
     * @return 影响行数
     */
    int deleteById( );

}