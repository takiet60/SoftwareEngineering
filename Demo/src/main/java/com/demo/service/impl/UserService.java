package com.demo.service.impl;

import com.demo.dao.IUserDAO;
import com.demo.model.UserModel;
import com.demo.service.IUserService;

import javax.inject.Inject;



public class UserService implements IUserService {

    @Inject
    private IUserDAO userDAO;

    @Override
    public UserModel findByUserNameAndPassWordAndStatus(String username, String password, Integer status) {
        return userDAO.findByUserNameAndPasswordAndStatus(username, password, status);
    }


}
