package com.demo.service;

import com.demo.model.CategoryModel;

import java.sql.SQLException;
import java.util.List;

public interface ICategoryService {
    List<CategoryModel> findAll() throws SQLException, ClassNotFoundException;
    CategoryModel findOne(long id);
}
