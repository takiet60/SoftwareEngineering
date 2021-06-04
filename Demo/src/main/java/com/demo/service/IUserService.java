package com.demo.service;

import com.demo.model.UserModel;

public interface IUserService {
    UserModel findByUserNameAndPassWordAndStatus(String username, String password, Integer status);
}
