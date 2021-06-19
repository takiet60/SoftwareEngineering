package com.demo.dao;

import com.demo.model.LessonModel;

public interface ILessonDAO extends IGenericDAO<LessonModel> {
    LessonModel addLesson(LessonModel lessonModel);
    LessonModel findLessonById(long id);
}
