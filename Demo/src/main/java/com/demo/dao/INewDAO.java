package com.demo.dao;

import com.demo.model.NewsModel;
import com.demo.paging.Pageble;

import java.sql.SQLException;
import java.util.List;

public interface INewDAO extends IGenericDAO<NewsModel>{
    List<NewsModel> findByCategoryId(Long categoryId);
    Long save(NewsModel newsModel);
    NewsModel findOne(long id);
    void update(NewsModel updateNews);
    void delete(long ids);
    List<NewsModel> findAll(Pageble pageble);
    int getTotalItem();

}
