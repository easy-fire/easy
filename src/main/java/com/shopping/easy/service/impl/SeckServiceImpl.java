package com.shopping.easy.service.impl;

import com.shopping.easy.mapper.SeckMapper;
import com.shopping.easy.model.SeckModel;
import com.shopping.easy.service.SeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeckServiceImpl implements SeckService {

    @Autowired
    private SeckMapper seckMapper;

    @Override
    public SeckModel findByItemId(Integer itemId) {
        return seckMapper.findByItemId(itemId);
    }
}
