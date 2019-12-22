<%@ page import="com.soft7.web.personSpace.entity.User" %>
<%@ page import="com.soft7.web.personSpace.factory.DaoFactory" %><%--
  Created by IntelliJ IDEA.
  User: tengf
  Date: 2019/12/8
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人档</title>
    <style type="text/css">
        .avatar {
            width: 70px;
            height: 70px;
            border-radius: 50%;
        }
        .div{
            border:2px solid white;
        }
    </style>
</head>
<body background="images/other/InfoBg.jpg">

<%
    String account = (String) session.getAttribute("account");
    String username = (String) session.getAttribute("username");
    User user = DaoFactory.getUserDAOInstance().getUserByAccount(account);
%>
<a href="main.jsp" style="font-size: 22px;text-decoration: none;color: #70CCFF;" >【前台首页】</a>
<hr>
<center>
    <div class="div">
        <form>
            <table border:2px solid>
                <br><br>
                <h1><font color="#00008b"><%=user.getUsername()%>的个人信息</font></h1><br>
                <span><img class="avatar" src="<%=user.getAvatar()%>"></span>
                <h2>用户名:<%=username%></h2>
                <h3>账号：<%=user.getAccountNumber()%></h3>
                <h3>手机号：<%=user.getPhoneNumber()%></h3>
                <h3>邮箱：<%=user.getEmail()%></h3>
                <br>
            </table>
        </form>
    </div>
</center>
</body>
</html>
