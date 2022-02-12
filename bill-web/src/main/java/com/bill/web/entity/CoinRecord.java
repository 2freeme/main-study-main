package com.bill.web.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 币记录(CoinRecord)实体类
 *
 * @author makejava
 * @since 2021-08-18 23:18:30
 */
public class CoinRecord implements Serializable {
    private static final long serialVersionUID = -39393715495561264L;
    /**
    * ID主键
    */
    private long id;
    /**
    * 币名称
    */
    private String coinName;
    /**
    * 类型
    */
    private String coinType;
    /**
    * 信息来源
    */
    private String sourceUrl;
    /**
    * 地址
    */
    private String contractAddress;
    /**
    * 钱包地址
    */
    private String walletAddress;
    /**
    * 钱包类型
    */
    private String wallectType;
    /**
    * 检查地址
    */
    private String checkUrl;
    /**
    * 耗费
    */
    private Double cost;
    /**
    * 耗费备注
    */
    private String costNote;
    /**
    * 备注
    */
    private String note;
    /**
    * 是否发放 0否 1是
    */
    private String done;
    /**
    * 结束时间
    */
    private Object endDate;
    /**
    * 结束
    */
    private String over;
    
    private Date createTime;
    
    private Date modifyDate;
    /**
    * 推荐链接
    */
    private String refLink;
    /**
    * 信息
    */
    private String message;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCoinName() {
        return coinName;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }

    public String getCoinType() {
        return coinType;
    }

    public void setCoinType(String coinType) {
        this.coinType = coinType;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getContractAddress() {
        return contractAddress;
    }

    public void setContractAddress(String contractAddress) {
        this.contractAddress = contractAddress;
    }

    public String getWalletAddress() {
        return walletAddress;
    }

    public void setWalletAddress(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    public String getWallectType() {
        return wallectType;
    }

    public void setWallectType(String wallectType) {
        this.wallectType = wallectType;
    }

    public String getCheckUrl() {
        return checkUrl;
    }

    public void setCheckUrl(String checkUrl) {
        this.checkUrl = checkUrl;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getCostNote() {
        return costNote;
    }

    public void setCostNote(String costNote) {
        this.costNote = costNote;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDone() {
        return done;
    }

    public void setDone(String done) {
        this.done = done;
    }

    public Object getEndDate() {
        return endDate;
    }

    public void setEndDate(Object endDate) {
        this.endDate = endDate;
    }

    public String getOver() {
        return over;
    }

    public void setOver(String over) {
        this.over = over;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getRefLink() {
        return refLink;
    }

    public void setRefLink(String refLink) {
        this.refLink = refLink;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}