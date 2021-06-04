package com.demo.dao.impl;

import com.demo.dao.IUserDAO;
import com.demo.mapper.UserMapper;
import com.demo.model.UserModel;

import java.util.List;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO {

    @Override
    public UserModel findByUserNameAndPasswordAndStatus(String username, String password, Integer status) {
        StringBuilder sql = new StringBuilder("SELECT * FROM user AS u ");
        sql.append(" JOIN role AS r ON r.id = u.role_id");
        sql.append(" WHERE username = ? AND password = ? AND status = ?;");
//        SELECT * FROM user AS u JOIN role as r ON r.id = u.role_id WHERE username = 'nguyenvanb' AND password = '123' AND status = 1;
        List<UserModel> list = query(sql.toString(), new UserMapper(), username, password, status);
        return list.isEmpty() ? null : list.get(0);
    }
}
