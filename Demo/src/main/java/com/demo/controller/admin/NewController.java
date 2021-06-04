package com.demo.controller.admin;

import com.demo.constant.SystemConstant;
import com.demo.model.NewsModel;
import com.demo.paging.PageRequest;
import com.demo.paging.Pageble;
import com.demo.service.ICategoryService;
import com.demo.service.INewService;
import com.demo.sort.Sorter;
import com.demo.utils.FormUtil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin-new"})
public class NewController extends HttpServlet {

    @Inject
    private INewService newService;

    @Inject
    private ICategoryService categoryService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NewsModel model = FormUtil.toModel(NewsModel.class, req);
        String view = "";
        if(model.getType().equals(SystemConstant.LIST)){
            Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),
                    new Sorter(model.getSortName(), model.getSortBy()));
            model.setListResult(newService.findAll(pageble));
            model.setTotalItem(newService.getTotalItem());
            model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
            view = "views/admin/new/list.jsp";
        }else if(model.getType().equals(SystemConstant.EDIT)){
            if(model.getId() != 0){
                model = newService.findOne(model.getId());
            }else{

            }
            try {
                req.setAttribute("categories", categoryService.findAll());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            view = "views/admin/new/edit.jsp";
        }
        req.setAttribute(SystemConstant.MODEL, model);
        RequestDispatcher rd = req.getRequestDispatcher(view);
        rd.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
