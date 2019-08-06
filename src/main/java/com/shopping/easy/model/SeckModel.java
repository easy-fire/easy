package com.shopping.easy.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class SeckModel implements Serializable {
    //秒杀活动Id
    private Integer seckId;
    //秒杀活动名称
    private String seckName;
    //对应商品Id
    private Integer itemId;
    //秒杀开始时间，如果数据库中是data类型，则用data接收
    //如果数据库中是其他的时间类型，可以用String接收，或者用timestamp接收。
    // String类型需要在后面的时间使用中进行转换
    private Timestamp start;
    //秒杀结束时间
    private Timestamp end;
    //秒杀价格
    private BigDecimal price;

    public SeckModel(){}

    public SeckModel(String seckName,Integer itemId,Timestamp start,Timestamp end,BigDecimal price){
        setEnd(end);
        setItemId(itemId);
        setPrice(price);
        setSeckName(seckName);
        setStart(start);
    }
    @Override
    public String toString() {
        return "SeckModel{" +
                "seckId=" + seckId +
                ", seckName='" + seckName + '\'' +
                ", itemId=" + itemId +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", price=" + price +
                '}';
    }

    public Integer getSeckId() {
        return seckId;
    }

    public void setSeckId(Integer seckId) {
        this.seckId = seckId;
    }

    public String getSeckName() {
        return seckName;
    }

    public void setSeckName(String seckName) {
        this.seckName = seckName;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Timestamp getStart() {
        return start;
    }

    public void setStart(Timestamp start) {
        this.start = start;
    }

    public Timestamp getEnd() {
        return end;
    }

    public void setEnd(Timestamp end) {
        this.end = end;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
