package com.soft7.web.personSpace.servlet;

import com.soft7.web.personSpace.dao.PhotoDAO;
import com.soft7.web.personSpace.dao.PictureDAO;
import com.soft7.web.personSpace.entity.Photos;
import com.soft7.web.personSpace.factory.DaoFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "PhotoServlet",urlPatterns = {"/PhotoServlet.do"})
public class PhotoServlet extends HttpServlet {
    private PhotoDAO photoDAO = DaoFactory.getPhotoDAOInstance();
    private PictureDAO pictureDAO = DaoFactory.getPictureDAOInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        try {
            List<Photos> photosList = photoDAO.selectAllPhotos();
            System.out.println(photosList);
            request.setAttribute("photosList", photosList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("pictures.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}