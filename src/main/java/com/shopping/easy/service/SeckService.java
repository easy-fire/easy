package com.shopping.easy.service;

import com.shopping.easy.model.SeckModel;

public interface SeckService {
    SeckModel findByItemId(Integer itemId);

    Integer addSeck(SeckModel seckModel);
}
