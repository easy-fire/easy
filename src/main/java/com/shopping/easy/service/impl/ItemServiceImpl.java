package com.shopping.easy.service.impl;

import com.shopping.easy.mapper.ItemMapper;
import com.shopping.easy.model.ItemModel;
import com.shopping.easy.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemMapper itemMapper;

    /**
     * @author : easy-fire
     * @Desicription :商品关键字模糊搜索
     * @param itemName:
     * @date : 2019/8/6  17:02
     * @return :
     * @modified By:
     */
    @Override
    public ItemModel findByItemName(String itemName) {
        return itemMapper.findByItemName(itemName);
    }

    /**
     * @author : easy-fire
     * @Desicription :添加商品信息
     * @param itemModel:商品对象
     * @date : 2019/8/6  16:56
     * @return : Integer
     * @modified By:
     */
    @Override
    public Integer addItem(ItemModel itemModel) {
        return itemMapper.addItem(itemModel);
    }

    /**
     * @author : easy-fire
     * @Desicription :下架商品
     * @param itemId:商品ID
     * @date : 2019/8/6  17:00
     * @return :Integer
     * @modified By:
     */
    @Override
    public Integer deleteItem(Integer itemId) {
        return itemMapper.deleteItem(itemId);
    }

    /**
     * @author : easy-fire
     * @Desicription :修改商品信息
     * @param itemModel:修改后的商品对象
     * @date : 2019/8/6  16:58
     * @return : Integer
     * @modified By:
     */
    @Override
    public Integer upItem(ItemModel itemModel) {
        return itemMapper.upItem(itemModel);
    }

    /**
     * @author : easy-fire
     * @Desicription :查询商品详情
     * @param :
     * @date : 2019/8/6  17:04
     * @return :
     * @modified By:
     */
    @Override
    public ItemModel findByItemId(Integer itemId) {
        return itemMapper.findByItemId(itemId);
    }

    /**
     * @author : easy-fire
     * @Desicription :店铺商品查询
     * @param :
     * @date : 2019/8/6  17:09
     * @return :
     * @modified By:
     */
    @Override
    public List<ItemModel> findItemBySellerId(Integer userId) {
        return itemMapper.findByUserId(userId);
    }
}
