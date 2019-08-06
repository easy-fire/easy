package com.shopping.easy.controller;

import com.shopping.easy.model.ItemModel;
import com.shopping.easy.service.ItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import jdk.nashorn.internal.runtime.JSONFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;
import java.util.List;

import static org.apache.logging.log4j.message.MapMessage.MapFormat.JSON;

@RestController
@Api(description = "公共功能模块")
@RequestMapping("/api/public")
public class SearchController {

    @Autowired
    private ItemService itemService;


    /**
     * @author : easy-fire
     * @Desicription :
     * @param itemName: 商品可能包含的字
     * @date : 2019/8/6  9:12
     * @return :
     * @modified By:
     */
    @ApiOperation(value = "公共功能模块-商品查询",httpMethod = "GET",response = String.class,
            notes = "公共功能模块-商品查询，提供给公共功能模块-商品查询功能使用")
    @RequestMapping(value = "/{itenName}",method = RequestMethod.GET)
    public String findItem(@ApiParam(value = "商品名称",required = true) @RequestParam(value = "itemName") String itemName){
        ItemModel itemModel=itemService.findByItemName(itemName);
        return itemModel.toString();
    }

    /**
     * @author : easy-fire
     * @Desicription :
     * @param itemId: 商品ID
     * @date : 2019/8/6  9:15
     * @return :
     * @modified By:
     */
    @ApiOperation(value = "公共功能模块-商品详情",httpMethod = "GET",response = String.class,
            notes = "公共功能模块-商品详情，提供给公共功能模块-商品详情信息查询")
    @RequestMapping(value = "/{itemId}",method = RequestMethod.GET)
    public String findItemById(@ApiParam(value = "商品ID",required = true) @RequestParam(value = "itemId") Integer itemId){
        ItemModel itemModel=itemService.findByItemId(itemId);
        return itemModel.toString();
    }

    /**
     * @author : easy-fire
     * @Desicription :
     * @param userId: 店铺ID
     * @date : 2019/8/6  9:15
     * @return :
     * @modified By:
     */
    @ApiOperation(value = "公共功能模块-店铺商品",httpMethod = "GET",response = String.class,
            notes = "公共功能模块-店铺商品，提供给公共功能模块-店铺商品查询")
    @RequestMapping(value = "/{userId}",method = RequestMethod.GET)
    public String findItemBySellerId(@ApiParam(value = "店铺ID",required = true) @RequestParam(value = "userId") Integer userId){
        List<ItemModel> itemModelList=itemService.findItemBySellerId(userId);
        return "";
    }
}
