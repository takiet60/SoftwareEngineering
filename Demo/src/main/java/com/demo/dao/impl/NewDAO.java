package com.demo.dao.impl;

import com.demo.dao.INewDAO;
import com.demo.mapper.NewMapper;
import com.demo.model.NewsModel;
import com.demo.paging.Pageble;

import java.sql.*;
import java.util.List;

public class NewDAO extends AbstractDAO<NewsModel> implements INewDAO {

    @Override
    public List<NewsModel> findByCategoryId(Long categoryId) {
        try {
            String sql = "SELECT id, title FROM news WHERE  categoryid = ?;";
            return query(sql, new NewMapper(), categoryId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Long save(NewsModel newsModel){
        StringBuilder sql = new StringBuilder("INSERT INTO news(title, content,  ");
        sql.append("categoryid, thumbnall, sortdescription, created_date, createdby)");
        sql.append("VALUES(?, ?, ?, ?, ?, ?, ?)");
        return insert(sql.toString(), newsModel.getTitle(), newsModel.getContent(),
                newsModel.getCategoryId(), newsModel.getThumbnall(), newsModel.getShortDescription(),
                newsModel.getCreatedDate(), newsModel.getCreatedBy());
    }

    @Override
    public NewsModel findOne(long id) {
        String sql = "SELECT * FROM news WHERE id = ?";
        List<NewsModel> news = query(sql, new NewMapper(), id);
        return news.isEmpty() ? null : news.get(0);
    }

    @Override
    public void update(NewsModel updateNews) {
        StringBuilder sql = new StringBuilder("UPDATE news SET title = ?, thumbnall = ?,");
        sql.append(" sortdescription = ?, content = ?, category = ?,");
        sql.append(" created_date = ?, createdby = ?, modified_date = ?, modifiedby = ?  WHERE id = ?");

        update(sql.toString(), updateNews.getTitle(), updateNews.getThumbnall(), updateNews.getShortDescription(),
                updateNews.getContent(), updateNews.getCategoryId(), updateNews.getCreatedDate(),
                updateNews.getCreatedBy(), updateNews.getModifiedDate(), updateNews.getModifiedBy(),
                updateNews.getId());
    }

    @Override
    public void delete(long id) {
        String sql = "DELETE FROM news WHERE id = ?";
        update(sql, id);
    }

    @Override
    public List<NewsModel> findAll(Pageble pageble) {
        StringBuilder sql = new StringBuilder("SELECT * FROM news");
        if(pageble.getSorter() != null){
            sql.append(" ORDER BY " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy() + "");
        }
        if(pageble.getOffset() != null &&  pageble.getLimit() != null){
            sql.append(" LIMIT " + pageble.getOffset() + ", " + pageble.getLimit() + "");
        }
        return query(sql.toString(), new NewMapper());
    }

    @Override
    public int getTotalItem() {
        String sql = "SELECT count(*) from news";
        return count(sql);
    }

}
