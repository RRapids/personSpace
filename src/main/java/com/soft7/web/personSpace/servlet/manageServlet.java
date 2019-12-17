package com.soft7.web.personSpace.servlet;

import com.soft7.web.personSpace.dao.DongtaiDAO;
import com.soft7.web.personSpace.dao.OtherDAO;
import com.soft7.web.personSpace.daoImpl.DongtaiDAOImpl;
import com.soft7.web.personSpace.daoImpl.OtherDAOImpl;
import com.soft7.web.personSpace.entity.Dongtai;
import com.soft7.web.personSpace.entity.Friends;
import com.soft7.web.personSpace.entity.Other;
import com.soft7.web.personSpace.entity.User;
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
import java.util.Date;

/**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2019/12/14 17:41
 * @Created by tf_yuan
 */
@WebServlet(name = "UserServlet", urlPatterns = {"/manageServlet.do"})
public class manageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String manageAction = request.getParameter("manageAction");
        String t_manageAction = request.getParameter("t_manageAction");
        if (manageAction.equals("userManage")) {    //个人信息管理
            this.userManage(request, response);
        }
        if (t_manageAction.equals("addFriend")) { //增加好友
            this.addFriendManage(request, response);
        }
        if (manageAction.equals("deleteFriend")) {   //删除好友
            this.deleteFriendManage(request, response);
        }
        if (manageAction.equals("logManage")) {     //删除日志
            this.logManage(request, response);
        }
        if (manageAction.equals("messageManage")) {  //删除留言
            this.messageManage(request, response);
        }
        if (manageAction.equals("photoManage")) {
            this.photoManage(request, response);
        }
        if (manageAction.equals("addDongTai")) {    //增加动态
            this.addDongTaiManage(request, response);
        }
        if (manageAction.equals("deleteDongTai")) {  //删除动态
            this.deleteDongTaiManage(request, response);
        }
    }

    //个人信息管理
    private void userManage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        int id = (int) session.getAttribute("id");
        String username = request.getParameter("changeName");
        String password = request.getParameter("changePassword");

        String phone = request.getParameter("changePhone");
        int t_phone = Integer.parseInt(phone);

        String email = request.getParameter("changeEmail");
        String gender = request.getParameter("changeGender");

        String age = request.getParameter("changeAge");
        int t_age = Integer.parseInt(age);

        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setPhoneNumber(t_phone);
        user.setEmail(email);
        user.setGender(gender);
        user.setAge(t_age);
        try {
            if (user != null) {
                DaoFactory.getUserDAOInstance().updateInfo(user);
                out.print("<script language=javascript>alert('修改信息成功！！！');" +
                        "window.location.href='AdminCenter.jsp';</script>");
            } else {
                out.print("<script language=javascript>alert('修改信息失败！！！');" +
                        "window.location.href='main.jsp';</script>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //删除好友
    private void deleteFriendManage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String friendId = request.getParameter("friendId");
        out.println(friendId);
        System.out.println(friendId);
        int t_friendId = Integer.parseInt(friendId);
        try {
            DaoFactory.getFriendsDAOInstance().deleteFriendById(t_friendId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("manageFriend.jsp").forward(request, response);
    }

    //增加好友
    private void addFriendManage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String otherAccount = request.getParameter("otherAccount");
        System.out.println(out);
        OtherDAO otherDAO = new OtherDAOImpl();
        Other other = new Other();
        try {
            other = otherDAO.getOtherByAccount(otherAccount);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Friends friends = new Friends();
        friends.setName(other.getName());
        friends.setAccount(other.getAccount());
        friends.setAvatar(other.getAvatar());
        try {
            DaoFactory.getFriendsDAOInstance().insertFriend(friends);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("manageFriend.jsp").forward(request, response);
    }

    //日志管理
    private void logManage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String logId = request.getParameter("logId");
        int t_logId = Integer.parseInt(logId);
        try {
            DaoFactory.getLogDAOInstance().deleteLogsById(t_logId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("manageLog.jsp").forward(request, response);
    }

    //留言管理
    private void messageManage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String messageId = request.getParameter("messageId");
        int t_messageId = Integer.parseInt(messageId);
        try {
            DaoFactory.getMessageDAOInstance().deleteMessagesById(t_messageId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("manageMessage.jsp").forward(request, response);
    }

    //相册管理
    private void photoManage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    //增加说说
    private void addDongTaiManage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String d_content = request.getParameter("dongTaiContent");
        Dongtai dongtai = new Dongtai();
        dongtai.setContent(d_content);
        dongtai.setContentImg("images/bg/3.jpg");
        dongtai.setDate(new Date());
        DongtaiDAO dongtaiDAO = new DongtaiDAOImpl();
        try {
            dongtaiDAO.insertDontai(dongtai);
            System.out.println("1");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("main.jsp").forward(request, response);
    }

    //删除说说
    private void deleteDongTaiManage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String dongTaiId = request.getParameter("dongTaiId");
        int t_Id = Integer.parseInt(dongTaiId);
        try {
            DaoFactory.getDongtaiDAOInstance().deleteDongtaisById(t_Id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("manageDongtai.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
