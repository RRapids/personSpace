package com.soft7.web.personSpace.servlet;

import com.soft7.web.personSpace.dao.FriendsDAO;
import com.soft7.web.personSpace.daoImpl.FriendsDAOImpl;
import com.soft7.web.personSpace.entity.Friends;
import com.soft7.web.personSpace.factory.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

/**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2019/12/6 14:48
 * @Created by tf_yuan
 */
@WebServlet(name = "FriendsServlet",urlPatterns = {"/FriendsServlet.do"})
public class FriendsServlet extends HttpServlet {

    private FriendsDAO friendsDAO = DaoFactory.getFriendsDAOInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            List<Friends> friendsList = friendsDAO.getAllFriends();
            request.setAttribute("friendsList",friendsList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("right.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
