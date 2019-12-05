package com.soft7.web.personSpace.servlet;

import com.soft7.web.personSpace.dao.UserDAO;
import com.soft7.web.personSpace.entity.User;
import com.soft7.web.personSpace.factory.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2019/12/5 9:25
 * @Created by tf_yuan
 */

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet.do"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //接收用户名和密码
        String userAccount = request.getParameter("account");
        String userPassword = request.getParameter("password");
        String flag = request.getParameter("flag");

        User user = new User();
        user.setAccountNumber(userAccount);
        user.setPassword(userPassword);
        user.setFlag(flag);
        HttpSession session = request.getSession();
        try {
            if (DaoFactory.getUserDAOInstance().login(user)) {
                session.setAttribute("username", user.getUsername());
                session.setAttribute("avatar", user.getAvatar());
                session.setAttribute("id", user.getId());
                if (user.getActive().equals("1")) {
                    request.getRequestDispatcher("loginsuccess.html").forward(request, response);
                } else {
                    request.getRequestDispatcher("err.html").forward(request, response);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
