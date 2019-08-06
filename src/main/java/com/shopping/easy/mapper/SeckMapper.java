package com.shopping.easy.mapper;

import com.shopping.easy.model.SeckModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SeckMapper {
    SeckModel findByItemId(Integer itemId) throws DataAccessException;
}
