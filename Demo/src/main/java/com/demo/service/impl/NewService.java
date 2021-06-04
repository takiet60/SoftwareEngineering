package com.demo.service.impl;

import com.demo.dao.ICategoryDAO;
import com.demo.dao.INewDAO;
import com.demo.model.CategoryModel;
import com.demo.model.NewsModel;
import com.demo.paging.Pageble;
import com.demo.service.INewService;

import javax.inject.Inject;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class NewService implements INewService {
    @Inject
    private INewDAO newDAO;

    @Inject
    private ICategoryDAO categoryDAO;

    @Override
    public List<NewsModel> findByCategoryId(Long categoryId) throws SQLException, ClassNotFoundException {
        return newDAO.findByCategoryId(categoryId);
    }

    @Override
    public NewsModel save(NewsModel newsModel) {
        newsModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        CategoryModel categoryModel = categoryDAO.findOneByCode(newsModel.getCategoryCode());
        newsModel.setCategoryId(categoryModel.getId());
        Long newId = newDAO.save(newsModel);
        return newDAO.findOne(newId);
    }

    @Override
    public NewsModel update(NewsModel newsModel) {
        NewsModel oldNews = newDAO.findOne(newsModel.getId());
        newsModel.setCreatedDate(oldNews.getCreatedDate());
        newsModel.setCreatedBy(oldNews.getCreatedBy());
        newsModel.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        CategoryModel categoryModel = categoryDAO.findOneByCode(newsModel.getCategoryCode());
        newsModel.setCategoryId(categoryModel.getId());
        newDAO.update(newsModel);
        return newDAO.findOne(newsModel.getId());
    }

    @Override
    public void delete(long[] ids) {
        for(long id : ids){
            newDAO.delete(id);
        }
    }

    @Override
    public List<NewsModel> findAll(Pageble pageble) {
        return newDAO.findAll(pageble);
    }

    @Override
    public int getTotalItem() {
        return newDAO.getTotalItem();
    }

    @Override
    public NewsModel findOne(long id) {
        NewsModel newsModel = newDAO.findOne(id);
        CategoryModel categoryModel = categoryDAO.findOne(newsModel.getCategoryId());
        newsModel.setCategoryCode(categoryModel.getCode());
        return newsModel;
    }

}
