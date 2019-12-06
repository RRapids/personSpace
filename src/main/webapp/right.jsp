<%@ page import="com.soft7.web.personSpace.dao.FriendsDAO" %>
<%@ page import="com.soft7.web.personSpace.factory.DaoFactory" %>
<%@ page import="java.util.List" %>
<%@ page import="com.soft7.web.personSpace.entity.Friends" %>
<%@ page import="com.soft7.web.personSpace.daoImpl.FriendsDAOImpl" %><%--
  Created by IntelliJ IDEA.
  User: tengf
  Date: 2019/12/6
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=GB2312" language="java" %>
<html>
<head>
    <meta charset="GB2312">
    <meta http-equiv="content-type" content="text/html; charset=gb2312" />
    <title>右侧</title>
    <style type="text/css">
        .juli{
            top: 400px;
            margin: 0 auto;
        }
    </style>
</head>
<body>
<div class="juli">
        <form>
            <table width="20%" border="0" cellpadding="0" align="right">
                <%
                    request.setCharacterEncoding("gb2312");
                    List<Friends> friendsList = (List<Friends>) request.getAttribute("friendsList");
                    for (Friends friends : friendsList) {%>
                <tr>
                    <td><img src="<%=friends.getAvatar()%>"></td>
                </tr>
                <tr>
                    <td>昵称：<%=friends.getName()%></td>
                    <td>账号：<%=friends.getAccount()%></td>
                </tr>
                <%}%>
            </table>
        </form>
    </div>
</body>
</html>
