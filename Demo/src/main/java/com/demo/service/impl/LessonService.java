package com.demo.service.impl;

import com.demo.dao.ICategoryDAO;
import com.demo.dao.ILessonDAO;
import com.demo.dao.INewDAO;
import com.demo.model.CategoryModel;
import com.demo.model.LessonModel;
import com.demo.service.ILessonService;

import javax.inject.Inject;
import java.sql.Timestamp;

public class LessonService implements ILessonService {

    @Inject
    private ICategoryDAO categoryDAO;

    @Inject
    private ILessonDAO lessonDAO;

    @Override
    public LessonModel addLesson(LessonModel lessonModel) {
        LessonModel model = new LessonModel();
        lessonModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        model = lessonDAO.addLesson(lessonModel);
        return model;
    }
}
