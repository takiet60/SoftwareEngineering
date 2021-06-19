package com.demo.mapper;

import com.demo.model.LessonModel;
import com.demo.model.NewsModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LessonMapper implements RowMapper<LessonModel> {
    @Override
    public LessonModel mapRow(ResultSet resultSet) {
        try{
            LessonModel lessonModel = new LessonModel();
            lessonModel.setId(resultSet.getLong("id"));
            lessonModel.setImage(resultSet.getString("image"));
            lessonModel.setContent(resultSet.getString("content"));
            lessonModel.setSound(resultSet.getString("sound"));
            lessonModel.setCreatedDate(resultSet.getTimestamp("created_date"));
            lessonModel.setCreatedBy(resultSet.getString("createdby"));
            if(resultSet.getTimestamp("modified_date") != null){
                lessonModel.setModifiedDate(resultSet.getTimestamp("modified_date"));
            }
            if(resultSet.getTimestamp("modifiedby") != null){
                lessonModel.setModifiedBy(resultSet.getString("modifiedby"));
            }
            return lessonModel;
        } catch (SQLException throwables) {
            return null;
        }
    }
}
