package com.demo.dao.impl;

import com.demo.dao.ILessonDAO;
import com.demo.mapper.NewMapper;
import com.demo.model.LessonModel;
import com.demo.model.NewsModel;

import java.sql.Timestamp;
import java.util.List;

public class LessonDAO extends AbstractDAO<LessonModel> implements ILessonDAO {
    @Override
    public LessonModel addLesson(LessonModel lessonModel) {
        StringBuilder sql = new StringBuilder("INSERT INTO lesson(topic, image,  ");
        sql.append("sound, content, created_date, createdby) ");
        sql.append("VALUES(?, ?, ?, ?, ?, ?)");
       long id = insert(sql.toString(), lessonModel.getCategoryCode(), lessonModel.getImage(),
               lessonModel.getSound(), lessonModel.getContent(), new Timestamp(System.currentTimeMillis()), "admin");
       return findLessonById(id);
    }

    @Override
    public LessonModel findLessonById(long id) {
        String sql = "SELECT * FROM lesson WHERE id = ?";
        List<LessonModel> lesson = query(sql, new NewMapper(), id);
        return lesson.isEmpty() ? null : lesson.get(0);
    }

}
