<%@ page import="com.soft7.web.personSpace.entity.Friends" %>
<%@ page import="java.util.List" %>
<%@ page import="com.soft7.web.personSpace.factory.DaoFactory" %><%--
  Created by IntelliJ IDEA.
  User: tengf
  Date: 2019/12/12
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>好友</title>
</head>
<body>
<div>
    <jsp:include page="Top.jsp" flush="true"></jsp:include>
</div>
<center>
    <table border="0" cellpadding="10">
        <tr>
            <td>@</td>
            <td>好友昵称</td>
            <td>账号</td>
        </tr>
        <%
            request.setCharacterEncoding("UTF-8");
            List<Friends> friendsList = DaoFactory.getFriendsDAOInstance().getAllFriends();
            for (Friends friends : friendsList) {%>
            <tr>
                <td><img src="<%=friends.getAvatar()%>"></td>
                <td>昵称：<%=friends.getName()%></td>
                <td>账号：<%=friends.getAccount()%></td>
            </tr>
        <%}%>
    </table>
</center>
</body>
</html>
