<%@ page import="com.soft7.web.personSpace.entity.Pictures" %>
<%@ page import="java.util.List" %>
<%@ page import="com.soft7.web.personSpace.factory.DaoFactory" %><%--
  Created by IntelliJ IDEA.
  User: tengf
  Date: 2019/12/19
  Time: 9:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>照片管理</title>
    <style type="text/css">
        .picture {
            width: 120px;
            height: 120px;
        }
    </style>
</head>
<body background="images/other/InfoBg.jpg">
<a href="managePhoto.jsp" onclick="window.close()" style="font-size: 20px;text-decoration: none;color: #70CCFF;" >【返回上一级】</a>
<hr>
<table border="0" width="95%" cellspacing="0" style="margin-top:10px">
    <tr height="60">
        <td align="center"></td>
    </tr>
    <%
        String photoId = (String) session.getAttribute("photoId");
        int t_photoId = Integer.parseInt(photoId);
        List<Pictures> pictureList = DaoFactory.getPictureDAOInstance().getPicturesByPhoto(t_photoId);
        if (pictureList == null) {%>
    <tr height="100">
        <td align="center">
            <li>博主目前还未上传任何照片！</li>
        </td>
    </tr>
    <%
    } else {
    %>
    <tr align="center" height="50">
        <td><b>照片</b></td>
        <td><b>标题</b></td>
        <td><b>描述</b></td>
        <td><b>上传时间</b></td>
        <td><b>操作</b></td>
    <tr>
            <%
        for (Pictures pictures : pictureList) {
    %>
    <tr style="height: 150px" align="center">
        <td style="width: 25%;padding-left: 150px">
            <img src="<%=pictures.getPicture()%>" class="picture">
        </td>
        <td><%=pictures.getPicturename()%></td>
        <td><%=pictures.getPicturesdetails()%></td>
        <td><%=pictures.getUpdate()%></td>
        <td><a href="PhotoServlet.do?action=deletePicture&id=<%=pictures.getId()%>">×删除</a></td>
    </tr>
    <%}
    }%>
</table>
</body>
</html>
