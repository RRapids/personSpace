<%@ page import="com.soft7.web.personSpace.entity.Photos" %>
<%@ page import="java.util.List" %>
<%@ page import="com.soft7.web.personSpace.factory.DaoFactory" %><%--
  Created by IntelliJ IDEA.
  User: tengf
  Date: 2019/12/19
  Time: 8:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>浏览所有相册</title>
</head>
<body background="images/other/InfoBg.jpg">
<a href="AdminCenter.jsp" style="font-size: 20px;text-decoration: none;color: #70CCFF;" >【返回上一级】</a>
<hr>
<table border="0" width="95%" cellspacing="0" style="margin-top:10px">
    <tr height="60">
        <td align="center"></td>
    </tr>
    <tr height="60"><td colspan="4">【浏览相册】</td></tr>
    <%
        List<Photos> photoList = DaoFactory.getPhotoDAOInstance().selectAllPhotos();
        if (photoList == null&photoList.equals("")) {
    %>
    <tr height="100">
        <td align="center">
            <li>博主目前还未上传任何照片！</li>
        </td>
    </tr>
    <%
        }
        else {
    %>
    <tr align="center" height="50">
        <td align="left" ><b>相册描述</b></td>
        <td><b>上传时间</b></td>
        <td colspan="2"><b>操作</b></td>
    <tr>
        <%
        for(int i=0;i<photoList.size();i++){
            Photos photos=(Photos) photoList.get(i);
            %>
    <tr height="30">
        <td><%=photos.getPhotodetails()%></td>
        <td align="center" width="30%"><%=photos.getCreatedate()%></td>
        <td align="center" width="15%"><a href="PhotoServlet.do?action=manageList&id=<%=photos.getId()%>" target="_blank">查看相册</a></td>
        <td align="center" width="10%"><a href="PhotoServlet.do?action=deletePhoto&id=<%=photos.getId()%>">×删除</a></td>
    </tr>
     <%   }
    }
    %>
</table>
</body>
</html>
