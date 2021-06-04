package com.demo.mapper;

import com.demo.model.NewsModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NewMapper implements RowMapper<NewsModel>{

    @Override
    public NewsModel mapRow(ResultSet resultSet) {
       try{
           NewsModel news = new NewsModel();
           news.setId(resultSet.getLong("id"));
           news.setTitle(resultSet.getString("title"));
           news.setContent(resultSet.getString("content"));
           news.setCategoryId(resultSet.getLong("categoryid"));
           news.setThumbnall(resultSet.getString("thumbnall"));
           news.setShortDescription(resultSet.getString("sortdescription"));
           news.setCreatedDate(resultSet.getTimestamp("created_date"));
           news.setCreatedBy(resultSet.getString("createdby"));
           if(resultSet.getTimestamp("modified_date") != null){
               news.setModifiedDate(resultSet.getTimestamp("modified_date"));
           }
           if(resultSet.getTimestamp("modifiedby") != null){
               news.setModifiedBy(resultSet.getString("modifiedby"));
           }
           return news;
       } catch (SQLException throwables) {
            return null;
       }

    }
}
