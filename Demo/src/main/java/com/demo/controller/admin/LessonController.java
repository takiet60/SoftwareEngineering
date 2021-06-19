package com.demo.controller.admin;

import com.demo.model.LessonModel;
import com.demo.service.ILessonService;
import com.demo.utils.HttpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LessonController)", urlPatterns = "/admin-add-lesson")
public class LessonController extends HttpServlet {

    @Inject
    private ILessonService lessonService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        LessonModel lessonModel = HttpUtil.of(request.getReader()).toModel(LessonModel.class);
        lessonService.addLesson(lessonModel);
        response.sendRedirect(request.getContextPath() + "/admin-home");
    }
}

