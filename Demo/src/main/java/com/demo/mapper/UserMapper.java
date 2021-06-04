package com.demo.mapper;

import com.demo.model.RoleModel;
import com.demo.model.UserModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements  RowMapper<UserModel> {

    @Override
    public UserModel mapRow(ResultSet rs) {
        UserModel user = new UserModel();
        try {
            user.setId(rs.getLong("id"));
            user.setUserName(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setFullName(rs.getString("fullname"));
            user.setStatus(rs.getInt("status"));
            try{
                RoleModel roleModel = new RoleModel();
                roleModel.setCode(rs.getString("code"));
                roleModel.setName(rs.getString("name"));
                user.setRoleModel(roleModel);
            }catch (Exception e){

            }
            return user;
        } catch (SQLException throwables) {
            return null;
        }

    }
}
