package com.shopping.easy.service;

import com.shopping.easy.model.ItemModel;

import java.util.List;

public interface ItemService {
    /**
     * @author : easy-fire
     * @Desicription :商品关键字模糊搜索
     * @param itemName:
     * @date : 2019/8/6  17:02
     * @return :
     * @modified By:
     */
    ItemModel findByItemName(String itemName);

    /**
     * @author : easy-fire
     * @Desicription :添加商品信息
     * @param itemModel:商品对象
     * @date : 2019/8/6  16:56
     * @return : Integer
     * @modified By:
     */
    Integer  addItem(ItemModel itemModel);

    /**
     * @author : easy-fire
     * @Desicription :修改商品信息
     * @param itemModel:修改后的商品对象
     * @date : 2019/8/6  16:58
     * @return : Integer
     * @modified By:
     */
    Integer upItem(ItemModel itemModel);

    /**
     * @author : easy-fire
     * @Desicription :下架商品
     * @param itemId:商品ID
     * @date : 2019/8/6  17:00
     * @return :Integer
     * @modified By:
     */
    Integer deleteItem(Integer itemId);

    /**
     * @author : easy-fire
     * @Desicription :查询商品详情
     * @param :
     * @date : 2019/8/6  17:04
     * @return :
     * @modified By:
     */
    ItemModel findByItemId(Integer itemId);

    /**
     * @author : easy-fire
     * @Desicription :店铺商品查询
     * @param :
     * @date : 2019/8/6  17:09
     * @return :
     * @modified By:
     */
    List<ItemModel> findItemBySellerId(Integer userId);
}
