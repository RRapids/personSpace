package com.soft7.web.personSpace.servlet;

import com.soft7.web.personSpace.dao.PhotoDAO;
import com.soft7.web.personSpace.dao.PictureDAO;
import com.soft7.web.personSpace.daoImpl.PictureDAOImpl;
import com.soft7.web.personSpace.entity.Photos;
import com.soft7.web.personSpace.entity.Pictures;
import com.soft7.web.personSpace.factory.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2019/12/16 16:56
 * @Created by tf_yuan
 */
@WebServlet(name = "PhotoServlet", urlPatterns = {"/PhotoServlet.do"})
public class PhotoServlet extends HttpServlet {
    private PhotoDAO photoDAO = DaoFactory.getPhotoDAOInstance();
    private PictureDAO pictureDAO = DaoFactory.getPictureDAOInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        if (action.equals("list")) {
            this.selectPicture(request, response);
        }
        if (action.equals("manageList")) {
            this.manageList(request, response);
        }
        if (action.equals("addPhoto")) {
            this.addPhoto(request, response);
        }
        if (action.equals("deletePhoto")) {
            this.deletePhoto(request, response);
        }
        if (action.equals("addPicture")) {
            this.addPicture(request, response);
        }
        if (action.equals("deletePicture")) {
            this.deletePicture(request, response);
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
        session.setAttribute("photoId", photoId);
        int t_photoId = Integer.parseInt(photoId);
        List<Pictures> picturesList = new ArrayList<>();
        try {
            picturesList = pictureDAO.getPicturesByPhoto(t_photoId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        session.setAttribute("picturesList", picturesList);
        request.getRequestDispatcher("picture.jsp").forward(request, response);
    }

    /**
     * @功能 后台-查询所有图片
     */
    public void manageList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String photoId = request.getParameter("id");
        session.setAttribute("photoId", photoId);
        int t_photoId = Integer.parseInt(photoId);
        List<Pictures> picturesList = new ArrayList<>();
        try {
            picturesList = pictureDAO.getPicturesByPhoto(t_photoId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        session.setAttribute("picturesList", picturesList);
        request.getRequestDispatcher("managePicture.jsp").forward(request, response);
    }

    //增加相册
    public void addPhoto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //获取值
        String photoName = request.getParameter("photoName");
        String details = request.getParameter("details");
        String photoCover = request.getParameter("photoCover");
        Integer userId = (Integer) session.getAttribute("id");
        //填值
        Photos photos = new Photos();
        photos.setPhotoname(photoName);
        photos.setPhotodetails(details);
        photos.setPhotoCover("images/cover/" + photoCover);
        photos.setUserid(userId);
        photos.setCreatedate(new Date());
        //执行
        if (photos != null) {
            try {
                int n = photoDAO.insertPhoto(photos);
                if (n == 1) {
                    request.getRequestDispatcher("photo.jsp").forward(request, response);
                } else {
                    out.print("<script language=javascript>alert('添加相册失败！请重试！');" +
                            "window.location.href='photo.jsp';</script>");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            out.print("<script language=javascript>alert('添加相册失败！请重试！');" +
                    "window.location.href='photo.jsp';</script>");
        }
    }

    //删除相册
    public void deletePhoto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        String photoId = request.getParameter("id");
        session.setAttribute("photoId", photoId);
        int t_photoId = Integer.parseInt(photoId);
        try {
            int n = photoDAO.deletePhotoById(t_photoId);
            if (n == 1) {
                request.getRequestDispatcher("managePhoto.jsp").forward(request, response);
            } else {
                out.print("<script language=javascript>alert('删除失败！请重试！');" +
                        "window.location.href='managePhoto.jsp';</script>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //增加照片
    public void addPicture(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //获取值
        String pictureName = request.getParameter("pictureName");
        String picture = request.getParameter("pictureFile");
        String photoId = (String) session.getAttribute("photoId");
        int t_photoId = Integer.parseInt(photoId);
        String pictureDetails = request.getParameter("pictureDtails");
        Integer userId = (Integer) session.getAttribute("id");
        //传值
        Pictures pictures = new Pictures();
        pictures.setPicturename(pictureName);
        pictures.setPicture("images/picture/" + picture);
        pictures.setPhotoid(t_photoId);
        pictures.setPicturesdetails(pictureDetails);
        pictures.setUpdate(new Date());
        pictures.setUserid(userId);

        try {
            int n = pictureDAO.insertPicture(pictures);
            if (n == 1) {
                request.getRequestDispatcher("picture.jsp").forward(request, response);
            } else {
                out.print("<script language=javascript>alert('添加照片失败！请重试！');" +
                        "window.location.href='picture.jsp';</script>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //删除照片
    public void deletePicture(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        String pictureId = request.getParameter("id");
        int t_pictureId = Integer.parseInt(pictureId);
        try {
            int n = pictureDAO.deletePictureById(t_pictureId);
            if (n == 1) {
                request.getRequestDispatcher("managePicture.jsp").forward(request, response);
            } else {
                out.print("<script language=javascript>alert('删除失败！请重试！');" +
                        "window.location.href='managePicture.jsp';</script>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
