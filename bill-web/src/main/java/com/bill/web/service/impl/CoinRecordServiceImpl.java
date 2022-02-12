package com.bill.web.service.impl;

import com.bill.web.entity.CoinRecord;
import com.bill.web.dao.CoinRecordDao;
import com.bill.web.service.CoinRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 币记录(CoinRecord)表服务实现类
 *
 * @author makejava
 * @since 2021-08-18 23:18:33
 */
@Service("coinRecordService")
public class CoinRecordServiceImpl implements CoinRecordService {
    @Resource
    private CoinRecordDao coinRecordDao;

    /**
     * 通过ID查询单条数据
     *
     * @param  主键
     * @return 实例对象
     */
    @Override
    public CoinRecord queryById(long id  ) {
        return this.coinRecordDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<CoinRecord> queryAllByLimit(int offset, int limit) {
        return this.coinRecordDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param coinRecord 实例对象
     * @return 实例对象
     */
    @Override
    public CoinRecord insert(CoinRecord coinRecord) {
        this.coinRecordDao.insert(coinRecord);
        return coinRecord;
    }

    /**
     * 修改数据
     *
     * @param coinRecord 实例对象
     * @return 实例对象
     */
    @Override
    public CoinRecord update(CoinRecord coinRecord) {
        this.coinRecordDao.update(coinRecord);
        return this.queryById(coinRecord.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param  主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById( ) {
        return this.coinRecordDao.deleteById() > 0;
    }

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 7);
        List<Integer> integers1 = Arrays.asList(0);
        List<Integer> integers2 = Arrays.asList(1,99);
        Collections.sort(integers1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });      Collections.sort(integers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });      Collections.sort(integers2, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });      Collections.sort(integers1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        System.out.println();
    }
}