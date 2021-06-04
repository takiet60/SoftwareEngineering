package com.demo.service.impl;

import com.demo.dao.ICategoryDAO;
import com.demo.dao.impl.CategoryDAO;
import com.demo.model.CategoryModel;
import com.demo.service.ICategoryService;

import javax.inject.Inject;
import java.sql.SQLException;
import java.util.List;

public class CategoryService implements ICategoryService {

    @Inject
    private ICategoryDAO categoryDAO;

    @Override
    public List<CategoryModel> findAll() throws SQLException, ClassNotFoundException {
        return categoryDAO.findAll();
    }

    @Override
    public CategoryModel findOne(long id) {
        return categoryDAO.findOne(id);
    }
}
