package com.bill.web.controller;

import com.bill.web.entity.CoinRecord;
import com.bill.web.service.CoinRecordService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 币记录(CoinRecord)表控制层
 *
 * @author makejava
 * @since 2021-08-18 23:18:33
 */
@RestController
@RequestMapping("coinRecord")
public class CoinRecordController {
    /**
     * 服务对象
     */
    @Resource
    private CoinRecordService coinRecordService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public CoinRecord selectOne(long id) {
        return this.coinRecordService.queryById(id);
    }


    @GetMapping("view")
    public CoinRecord view(long id){
        return null;
    }
}