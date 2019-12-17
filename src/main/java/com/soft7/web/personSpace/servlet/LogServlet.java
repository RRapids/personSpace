package com.soft7.web.personSpace.servlet;

import com.soft7.web.personSpace.dao.LogDAO;
import com.soft7.web.personSpace.daoImpl.LogDAOImpl;
import com.soft7.web.personSpace.entity.Logs;
import com.soft7.web.personSpace.factory.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2019/12/11 18:15
 * @Created by tf_yuan
 */
@WebServlet(name = "LogServlet", urlPatterns = {"/LogServlet.do"})
public class LogServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String action = request.getParameter("action");
        if (action.equals("add")) {
            this.addArticle(request, response);
        }
        if (action.equals("find")) {
            this.findLog(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    //搜素日志
    public void findLog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        LogDAO logDAO = new LogDAOImpl();
        String keyWords = request.getParameter("findLog");
        if (keyWords == null || keyWords.equals("")) {
            out.print("<script language=javascript>alert('未找到此日志！！！');" +
                    "window.location.href='logger.jsp';</script>");
        } else {
            List<Logs> logsList = new ArrayList<>();
            try {
                logsList = logDAO.selectLogsLike(keyWords);
                session.setAttribute("searchLogs", logsList);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            request.getRequestDispatcher("searchLog.jsp").forward(request, response);
        }
    }

    //验证发表日志信息
    public boolean validateLog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean mark = true;
        String messages = "";

        String title = request.getParameter("title");
        String content = request.getParameter("logContent");

        if (title == null || title.equals("")) {
            mark = false;
            messages += "<li>请输入 <b>文章标题！</b></li>";
        }
        if (content == null || content.equals("")) {
            mark = false;
            messages += "<li>请输入 <b>文章内容！</b></li>";
        }
        request.setAttribute("messages", messages);
        return mark;
    }

    //增加日志
    public void addArticle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String t_title = request.getParameter("title");
        String t_logContent = request.getParameter("logContent");
        boolean flag = validateLog(request, response);
        if (flag) {
            Logs logs = new Logs();
            logs.setName((String) session.getAttribute("username"));
            logs.setTitle(t_title);
            logs.setContent(t_logContent);
            logs.setLogDate(new Date());
            LogDAO logDAO = new LogDAOImpl();
            try {
                logDAO.insertLogs(logs);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            request.getRequestDispatcher("logger.jsp").forward(request, response);
        } else {
            response.sendRedirect("err.html");
        }
    }
}
