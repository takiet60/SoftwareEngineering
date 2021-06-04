package com.demo.service;

import com.demo.model.NewsModel;
import com.demo.paging.Pageble;

import java.sql.SQLException;
import java.util.List;

public interface INewService {
    List<NewsModel> findByCategoryId(Long categoryId) throws SQLException, ClassNotFoundException;
    NewsModel save(NewsModel newsModel);
    NewsModel update(NewsModel newsModel);
    void delete(long[] ids);
    List<NewsModel> findAll(Pageble pageble);
    int getTotalItem();
    NewsModel findOne(long id);
}
