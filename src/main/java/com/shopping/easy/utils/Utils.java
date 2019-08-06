package com.shopping.easy.utils;

import com.shopping.easy.model.ItemModel;
import org.springframework.util.DigestUtils;

import java.math.BigDecimal;

public class Utils {

    /**
     * MD5加密
     * @param   input:
     * @return   String:
     * @author : easy-fire
     * @date : 2019/7/30  10:30
     */
    public static String getMd5DigestAsHex(String input) {
        
        return DigestUtils.md5DigestAsHex(input.getBytes());
    }

    //对象封装
    public static ItemModel sealInItem(Integer itemId, String itemName, BigDecimal itemPrice,Integer itemStock,String itemDescription,String itemUrl){
        ItemModel itemModel = new ItemModel();
        itemModel.setItemId(itemId);
        itemModel.setItemName(itemName);
        itemModel.setItemPrice(itemPrice);
        itemModel.setItemStock(itemStock);
        itemModel.setItemSales(0);
        itemModel.setItemDescription(itemDescription);
        itemModel.setItemUrl(itemUrl);
        return itemModel;
    }

    //时间转换工具

    //倒计时
}
