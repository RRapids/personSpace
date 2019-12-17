package com.soft7.web.personSpace.servlet;

import com.soft7.web.personSpace.dao.PhotoDAO;
import com.soft7.web.personSpace.dao.PictureDAO;
import com.soft7.web.personSpace.daoImpl.PictureDAOImpl;
import com.soft7.web.personSpace.entity.Pictures;
import com.soft7.web.personSpace.factory.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2019/12/16 16:56
 * @Created by tf_yuan
 */
@WebServlet(name = "PhotoServlet",urlPatterns = {"/PhotoServlet.do"})
public class PhotoServlet extends HttpServlet {
    private PhotoDAO photoDAO = DaoFactory.getPhotoDAOInstance();
    private PictureDAO pictureDAO = DaoFactory.getPictureDAOInstance();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action");
        if(action==null) {
            action="";
        }
        if (action.equals("list")){
            this.selectPicture(request,response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    /**
     * @功能 前台-查询所有图片
     */
    public void selectPicture(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String photoId = request.getParameter("id");
        int t_photoId = Integer.parseInt(photoId);
        List<Pictures> picturesList = new ArrayList<>();
        try {
            picturesList = pictureDAO.getPicturesByPhoto(t_photoId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        session.setAttribute("picturesList",picturesList);
        request.getRequestDispatcher("picture.jsp").forward(request,response);
    }
}
