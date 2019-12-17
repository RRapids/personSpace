<%@ page import="com.soft7.web.personSpace.dao.LogDAO" %>
<%@ page import="com.soft7.web.personSpace.daoImpl.LogDAOImpl" %>
<%@ page import="com.soft7.web.personSpace.entity.Logs" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: tengf
  Date: 2019/12/12
  Time: 8:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>查看日志</title>
</head>
<style type="text/css">

    .gbtn{
        background-color: #FFFFFF;
        color: #606060;
        font-size: 14px;
        border: #FFFFFF
    ;
    }
</style>
<body>

<div>
    <jsp:include page="Top.jsp" flush="true"></jsp:include>
</div>

<div style="background-color: #A68DD9;text-align: center;">
    <label style="font-size: 18px;">查看日志</label>
</div>

<%
    LogDAO logDAO = new LogDAOImpl();
    Logs logs = logDAO.readLogById(Integer.parseInt(request.getParameter("id")));
%>

<form action="logger.jsp" method="post">

    <table align="center">

        <tr align="center">
            <td><input style="font-size: 17px;" name="title" type="text" value="<%=logs.getTitle()%>"/></td>
            <hr>
        </tr>

        <tr>
            <td>
                <textarea style="font-size: 14px;" name="logContent" rows="20" cols="70"><%=logs.getContent()%></textarea>
            </td>
        </tr>
        <input type="submit" class="gbtn" value="< 返回" style=" height: 37px;width: 60px; ackground-color: rgb(112,153,222);">
    </table>
</form>
</body>
</html>
