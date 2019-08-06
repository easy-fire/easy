package com.shopping.easy.controller;

import com.shopping.easy.model.SeckModel;
import com.shopping.easy.service.SeckService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 *@Author: easy-fire
 *@Description: SeckController
 *@Date: 2019/8/6
 *@Medified By:
 */
@RestController
@Api(description = "秒杀商品管理")
@RequestMapping(value = "/api/seck")
public class SeckController {

    @Autowired
    private SeckService seckService;

    /**
     * @author : easy-fire
     * @Desicription :
     * @param itemId: 商品id
     * @date : 2019/8/6  9:17
     * @return :
     * @modified By:
     */
    @ApiOperation(value = "秒杀商品管理-秒杀商品查询",httpMethod = "GET",response = String.class,
        notes = "秒杀商品管理-秒杀商品查询，给秒杀商品管理-秒杀商品查询功能提供服务，实现秒杀商品的反馈")
    @RequestMapping(method = RequestMethod.GET)
    public String findByItemId(@ApiParam(value = "商品id",required = true)@RequestParam(value = "itemId")Integer itemId){
        return ""+seckService.findByItemId(itemId).toString();
    }

    @ApiOperation(value = "秒杀商品管理-秒杀商品添加",httpMethod = "GET",response = String.class,
            notes = "秒杀商品管理-秒杀商品查询，给秒杀商品管理-秒杀商品查询功能提供服务，实现秒杀商品的反馈")
    @RequestMapping(method = RequestMethod.POST)
    public String addSeck(@ApiParam(value = "秒杀活动名称",required = true)@RequestParam(value = "seckName")String seckName,
                          @ApiParam(value = "商品id",required = true)@RequestParam(value = "itemId")Integer itemId,
                          @ApiParam(value = "活动开始时间",required = true)@RequestParam(value = "start")Timestamp start,
                          @ApiParam(value = "活动结束时间",required = true)@RequestParam(value = "end") Timestamp end,
                          @ApiParam(value = "活动时价格",required = true)@RequestParam(value = "price") BigDecimal price){
        SeckModel seckModel=new SeckModel(seckName,itemId,start,end,price);
        Integer integer=seckService.addSeck(seckModel);
        return ""+integer;
    }
}
