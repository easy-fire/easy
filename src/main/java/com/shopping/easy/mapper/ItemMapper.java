package com.shopping.easy.mapper;

import com.shopping.easy.model.ItemModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *@Author: easy-fire
 *@Description : 商品相关方法
 *@Date: 2019/8/6  
 *@Medified By:
 */
@Mapper
@Repository
public interface ItemMapper {
    /**
     * @author : easy-fire
     * @Desicription :商品关键字模糊搜索
     * @param itemName:
     * @date : 2019/8/6  17:02
     * @return :
     * @modified By:
     */
    ItemModel findByItemName(String itemName) throws DataAccessException;

    /**
     * @author : easy-fire
     * @Desicription :添加商品信息
     * @param itemModel:商品对象
     * @date : 2019/8/6  16:56
     * @return : Integer
     * @modified By:
     */
    Integer addItem(ItemModel itemModel) throws DataAccessException;

    /**
     * @author : easy-fire
     * @Desicription :修改商品信息
     * @param itemModel:修改后的商品对象
     * @date : 2019/8/6  16:58
     * @return : Integer
     * @modified By:
     */
    Integer upItem(ItemModel itemModel) throws DataAccessException;

    /**
     * @author : easy-fire
     * @Desicription :下架商品
     * @param itemId:商品ID
     * @date : 2019/8/6  17:00
     * @return :Integer
     * @modified By:
     */
    Integer deleteItem(Integer itemId) throws DataAccessException;

    /**
     * @author : easy-fire
     * @Desicription :查询商品详情
     * @param :
     * @date : 2019/8/6  17:04
     * @return :
     * @modified By:
     */
    ItemModel findByItemId(Integer itemId) throws  DataAccessException;

    List<ItemModel> findByUserId(Integer userId) throws  DataAccessException;
}
