package com.demo.controller.web;

import com.demo.model.UserModel;
import com.demo.service.ICategoryService;
import com.demo.service.IUserService;
import com.demo.utils.FormUtil;
import com.demo.utils.SessionUtil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ResourceBundle;

@WebServlet(urlPatterns = {"/home", "/login", "/logout"})
public class HomeController extends HttpServlet {

    ResourceBundle myBunble = ResourceBundle.getBundle("message");

    @Inject
    private ICategoryService categoryService;

    @Inject
    private IUserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action != null && action.equals("login")){
            String message = req.getParameter("message");
            String alert = req.getParameter("alert");
            if(message != null && alert != null){
                req.setAttribute("message", myBunble.getString(message));
                req.setAttribute("alert", myBunble.getString(alert));
            }
            RequestDispatcher rd = req.getRequestDispatcher("/views/login.jsp");
            rd.forward(req, resp);
        }else if(action != null && action.equals("logout")){
            SessionUtil.getInstance().removeValue(req, "USERMODEL");
            resp.sendRedirect(req.getContextPath() + "/home");
        }else{
            try {
                req.setAttribute("categories", categoryService.findAll());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            RequestDispatcher rd = req.getRequestDispatcher("/views/web/home.jsp");
            rd.forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action != null && action.equals("login")){
            UserModel user = FormUtil.toModel(UserModel.class, req);
            user = userService.findByUserNameAndPassWordAndStatus(user.getUserName(), user.getPassword(), 1);
            if(user != null){
                SessionUtil.getInstance().putValue(req, "USERMODEL", user );
                if(user.getRoleModel().getCode().equals("USER")){
                    resp.sendRedirect(req.getContextPath() + "/home");
                }else if(user.getRoleModel().getCode().equals("ADMIN")){
                    resp.sendRedirect(req.getContextPath() + "/admin-home");
                }
            }else{
                resp.sendRedirect(req.getContextPath() + "/login?action=login&message=username_password_invalid&alert=danger");
            }
        }
    }
}
