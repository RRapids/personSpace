<%@ page import="com.soft7.web.personSpace.entity.User" %>
<%@ page import="com.soft7.web.personSpace.factory.DaoFactory" %><%--
  Created by IntelliJ IDEA.
  User: tengf
  Date: 2019/12/14
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=GB2312" language="java" %>
<html>
<head>
    <title>修改个人信息</title>
    <style type="text/css">
        input{
            width: 250px;
        }
    </style>
</head>
<body background="images/other/InfoBg.jpg">
<%
    request.setCharacterEncoding("gb2312");
    String account = (String) session.getAttribute("account");
    String username = (String) session.getAttribute("username");
    User user = DaoFactory.getUserDAOInstance().getUserByAccount(account);
%>
<center>
    <form action="manageServlet.do" method="post">
        <input type="hidden" name="manageAction" value="userManage">
        <table>
            <tr>
                <td>
                    <h1><font color="#00008b"><%=username%>的个人信息</font></h1><br>
                    <span><img src="<%=user.getAvatar()%>"></span>
                </td>
            </tr>
            <tr>
                <td>
                    <h3>用户名:<%=username%></h3>
                    <input type="text" name="changeName">
                </td>
            </tr>
            <tr>
                <td>
                    <h4>账号：<%=user.getAccountNumber()%></h4>
                </td>
            </tr>
            <tr>
                <td>
                    <h4>密码：<%=user.getPassword()%></h4>
                    <input type="text" name="changePassword">
                </td>
            </tr>
            <tr>
                <td>
                    <h4>手机号：<%=user.getPhoneNumber()%></h4>
                    <input type="text" name="changePhone">
                </td>
            </tr>
            <tr>
                <td>
                    <h4>邮箱：<%=user.getEmail()%></h4>
                    <input type="text" name="changeEmail">
                </td>
            </tr>
            <tr>
                <td>
                    <h4>性别：<%=user.getGender()%></h4>
                    <input type="text" name="changeGender">
                </td>
            </tr>
            <tr>
                <td>
                    <h4>年龄：<%=user.getAge()%></h4>
                    <input type="text" name="changeAge">
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="修改">
                </td>
            </tr>
        </table>
    </form>
    <a href="AdminCenter.jsp">返回</a>
</center>
</body>
</html>
