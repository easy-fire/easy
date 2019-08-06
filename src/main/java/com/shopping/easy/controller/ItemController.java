package com.shopping.easy.controller;

import com.shopping.easy.model.ItemModel;
import com.shopping.easy.service.ItemService;
import com.shopping.easy.utils.Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 *@Author: easy-fire
 *@Description: 商品管理接口
 *@Date: 2019/8/6
 *@Medified By:
 */
@RestController
@Api(description = "商品管理接口")
@RequestMapping("/api/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    /**
     * @author : easy-fire
     * @Desicription :
     * @param itemName: 商品名称
     * @param itemPrice: 商品价格
     * @param itemStock: 商品库存
     * @param itemDescription: 商品描述
     * @param itemUrl: 商品图片
     * @date : 2019/8/6  9:14
     * @return :
     * @modified By:
     */
    @ApiOperation(value = "商品管理模块-商品添加",httpMethod = "POST",response = String.class,
            notes = "商品管理模块-商品添加，提供给商家添加商品功能使用")
    @RequestMapping(method = RequestMethod.POST)
    public String addItem(@ApiParam(value = "商品名称",required = true)@RequestParam(value = "itemName")String itemName,
                          @ApiParam(value = "商品价格",required = true)@RequestParam(value = "itemPrice")BigDecimal itemPrice,
                          @ApiParam(value = "商品库存",required = true)@RequestParam(value = "itemStock")Integer itemStock,
                          @ApiParam(value = "商品描述",required = true)@RequestParam(value = "itemDescription")String itemDescription,
                          @ApiParam(value = "商品图片",required = true)@RequestParam(value = "itemUrl")String itemUrl
                          ){
        ItemModel itemModel = Utils.sealInItem(0,itemName,itemPrice,itemStock,itemDescription,itemUrl);
        return ""+itemService.addItem(itemModel);
    }

    @ApiOperation(value = "商品管理模块-商品信息更改",httpMethod = "PUT",response = String.class,
            notes = "商品管理模块-商品信息更改，提供给商家修改，使用回显机制")
    @RequestMapping(method = RequestMethod.PUT)
    public String upItem(@ApiParam(value = "商品Id",required = true)@RequestParam(value = "itemId")Integer itemId,
                         @ApiParam(value = "商品名称",required = true)@RequestParam(value = "itemName")String itemName,
                         @ApiParam(value = "商品价格",required = true)@RequestParam(value = "itemPrice")BigDecimal itemPrice,
                         @ApiParam(value = "商品库存",required = true)@RequestParam(value = "itemStock")Integer itemStock,
                         @ApiParam(value = "商品描述",required = true)@RequestParam(value = "itemDescription")String itemDescription,
                         @ApiParam(value = "商品图片",required = true)@RequestParam(value = "itemUrl")String itemUrl
    ){
        ItemModel itemModel = Utils.sealInItem(itemId,itemName,itemPrice,itemStock,itemDescription,itemUrl);
        return ""+itemService.upItem(itemModel);
    }

    /**
     * @author : easy-fire
     * @Desicription :
     * @param itemId: 商品Id
     * @date : 2019/8/6  9:15
     * @return :
     * @modified By:
     */
    @ApiOperation(value = "商品管理模块-商品下架",httpMethod = "DELETE",response = String.class,
            notes = "商品管理模块-商品下架，提供给商家下架商品或者管理强制下架")
    @RequestMapping(method = RequestMethod.DELETE)
    public String deleteItem(@ApiParam(value = "商品Id",required = true)@RequestParam(value = "itemId")Integer itemId){
        return ""+itemService.deleteItem(itemId);
    }

}
