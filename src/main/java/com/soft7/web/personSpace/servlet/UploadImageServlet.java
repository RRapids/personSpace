package com.soft7.web.personSpace.servlet;

import com.jspsmart.upload.SmartUpload;
import com.soft7.web.personSpace.entity.User;
import com.soft7.web.personSpace.factory.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "UploadImageServlet", urlPatterns = {"/uploadImage.do"})
public class UploadImageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        JspFactory fac = JspFactory.getDefaultFactory();
        PageContext pageContext = fac.getPageContext(this, request, response, null, false, JspWriter.NO_BUFFER, true);
        com.jspsmart.upload.File file = null;
        int id = (int) session.getAttribute("id");
        out.println("<html>");
        out.println("<body><center><h3>");
        //新建上传对象
        SmartUpload su = new SmartUpload();
        // 上传初始化
        su.initialize(pageContext);
        // 限制每个上传文件的最大长度。
        su.setMaxFileSize(200000);
        // 限制总上传数据的长度。
        su.setTotalMaxFileSize(200000);
        //通过扩展名限制设定允许上传的文件,这里仅允许doc,txt文件。
        su.setAllowedFilesList("gif,bmp,jpg");
        //通过扩展名限制设定禁止上传的文件,禁止上传带有exe,bat,jsp,htm,html扩展名的文件和没有扩展名的文件。
        try {
            su.setDeniedFilesList("exe,bat,jsp,htm,html");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 实现文件上传
        try {
            su.upload();
            // 将上传文件全部保存到指定目录,必须保证upload目录在应用程序根文件夹中存在
            su.save("images/face", SmartUpload.SAVE_VIRTUAL);
            for (int i = 0; i < su.getFiles().getCount(); i++) {
                file = su.getFiles().getFile(i);
                // 若文件不存在则继续
                if (file.isMissing()) {
                    continue;
                }
            }
            User user = new User();
            user.setId(id);
            //
            user.setAvatar("images/face/" + file.getFileName());
            DaoFactory.getUserDAOInstance().updateUser(user);
            session.setAttribute("image", user.getAvatar());
            out.print("<script language=javascript>alert('头像上传成功！！！');" +
                    "window.location.href='main.jsp';</script>");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            out.print("<script language=javascript>alert('头像上传失败！！！请检查文件格式和大小！');" +
                    "window.location.href='changeUserAvatar.jsp';</script>");
        }
        out.println("</h3></center></body></html>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }
}