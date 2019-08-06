package com.shopping.easy.service;

import com.shopping.easy.model.UserModel;

public interface UserLoginService {
    UserModel findByAccount(String account);
}
