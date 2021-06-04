package com.demo.dao;

import com.demo.model.UserModel;

public interface IUserDAO extends IGenericDAO<UserModel> {
    UserModel findByUserNameAndPasswordAndStatus(String username, String password, Integer status);
}
