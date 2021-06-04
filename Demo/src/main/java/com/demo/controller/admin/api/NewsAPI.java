package com.demo.controller.admin.api;

import com.demo.model.NewsModel;
import com.demo.model.UserModel;
import com.demo.service.INewService;
import com.demo.utils.HttpUtil;
import com.demo.utils.SessionUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "NewsAPI)", urlPatterns = "/api-admin-news")
public class NewsAPI extends HttpServlet {

    @Inject
    private INewService newService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        NewsModel newsModel = HttpUtil.of(request.getReader()).toModel(NewsModel.class);
        newsModel.setCreatedBy(((UserModel)SessionUtil.getInstance().getValue(request, "USERMODEL")).getUserName());
        newsModel = newService.save(newsModel);
        mapper.writeValue(response.getOutputStream(), newsModel);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json");
        NewsModel updateNews = HttpUtil.of(req.getReader()).toModel(NewsModel.class);
        updateNews.setCreatedBy(((UserModel)SessionUtil.getInstance().getValue(req, "USERMODEL")).getUserName());
        updateNews = newService.update(updateNews);
        mapper.writeValue(resp.getOutputStream(), updateNews);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json");
        NewsModel newsModel = HttpUtil.of(req.getReader()).toModel(NewsModel.class);
        newService.delete(newsModel.getIds());
        mapper.writeValue(resp.getOutputStream(), "{}");
    }
}

