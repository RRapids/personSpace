package com.soft7.web.personSpace.servlet;

import com.soft7.web.personSpace.entity.User;
import com.soft7.web.personSpace.factory.DaoFactory;
import com.soft7.web.personSpace.util.Mail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2019/12/5 14:46
 * @Created by tf_yuan
 */
@WebServlet(name = "RegisterServlet",urlPatterns = {"/register.do"})
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
//        out.println("OK");
        out.println("<html>");
        out.println("<body><center><h3>");
        String account = request.getParameter("userAccount");
        String username = request.getParameter("name");
        String password = request.getParameter("password");
        String userEmail = request.getParameter("userEmail");
        String flag = request.getParameter("flag");
        User user = new User();
        user.setAccountNumber(account);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(userEmail);
        user.setFlag(flag);
        user.setActive("1");
//        out.println(user);
        try {
            if (!DaoFactory.getUserDAOInstance().checkUser(user)) {
//                out.println(user);
                DaoFactory.getUserDAOInstance().insertUser(user);
                user.setId(DaoFactory.getUserDAOInstance().QueryId(user));
                out.println(user);
                out.println("注册成功!请到邮箱激活");
//                new Mail(user);
//                int i = userEmail.indexOf("@");
//                out.println("注册成功!请到邮箱激活");
//                out.println("<a href='https://mail." + userEmail.substring(i + 1) + "'>请进入注册邮箱激活账号</a>");
            } else {
                out.println("注册失败！<a href='register.jsp'>请重新注册</a>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        out.println("</h3></center></body></html>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
