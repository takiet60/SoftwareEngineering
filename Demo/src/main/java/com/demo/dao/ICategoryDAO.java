package com.demo.dao;

import com.demo.dao.impl.AbstractDAO;
import com.demo.model.CategoryModel;

import java.sql.SQLException;
import java.util.List;

public interface ICategoryDAO extends IGenericDAO<CategoryModel> {
    List<CategoryModel> findAll() throws SQLException, ClassNotFoundException;
    CategoryModel findOne(long id);
    CategoryModel findOneByCode(String code);
}
