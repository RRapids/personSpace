<%@ page import="com.soft7.web.personSpace.entity.User" %>
<%@ page import="com.soft7.web.personSpace.factory.DaoFactory" %><%--
  Created by IntelliJ IDEA.
  User: 79876
  Date: 2019/10/28
  Time: 8:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息</title>
</head>
<body background="images/other/InfoBg.jpg">

<%
    int id = (int) session.getAttribute("id");
    String account = (String) session.getAttribute("account");
    String username = (String) session.getAttribute("username");
    User user = DaoFactory.getUserDAOInstance().getUserByAccount(account);

%>
<a href="main.jsp" style="font-size: 20px;text-decoration: none;color: #70CCFF;" >【返回上一级】</a>
<hr>
<center>
    <form action="uploadImage.do" method="post" enctype="multipart/form-data">
        <table>
            <br><br>
            <span><img width="110px" height="110px" src="<%=user.getAvatar()%>"></span>
            <h2>用户名:<%=user.getUsername()%>
            </h2>
            <h3>账号：<%=user.getAccountNumber()%>
            </h3>
            <h3>手机号：<%=user.getPhoneNumber()%>
            </h3>
            <h3>邮箱：<%=user.getEmail()%>
            </h3>
            <br>
            <label for="file">修改头像：</label> <input type="file" id="file" name="file" value="D:\javastudy\project\personSpace\src\main\webapp\images\face">
            <br>
            <tr>
                <td colspan="2">
                    <input type="hidden" name="id" value="<%=id%>">
                    <div align="center">
                        <input type="submit" value="提交">
                    </div>
                </td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>
