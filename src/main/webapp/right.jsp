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
    <meta http-equiv="content-type" content="text/html; charset=gb2312"/>
    <title>�Ҳ�</title>
    <style type="text/css">
        .juli {
            position: absolute;
            top: 400px;
            right: 200px;
        }
    </style>
</head>

<body>
<div class="juli">
    <tr>
        <td>
            <h3>����</h3>
        </td>
    </tr>
    <form>
        <table border="1" cellpadding="0">
            <%
                request.setCharacterEncoding("gb2312");
                List<Friends> friendsList = (List<Friends>) session.getAttribute("friends");
                for (Friends friends : friendsList) {%>
            <tr>
                <td><img src="<%=friends.getAvatar()%>"></td>
            </tr>
            <tr>
                <td>�ǳƣ�<%=friends.getName()%>
                </td>
                <td>�˺ţ�<%=friends.getAccount()%>
                </td>
            </tr>
            <%}%>
        </table>
    </form>
</div>
</body>
</html>
