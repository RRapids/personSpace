<%@ page import="com.soft7.web.personSpace.entity.Dongtai" %>
<%@ page import="java.util.List" %>
<%@ page import="com.soft7.web.personSpace.factory.DaoFactory" %>
<%@ page import="com.soft7.web.personSpace.entity.User" %>
<%@ page import="org.omg.DynamicAny.DynAnyOperations" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>个人动态</title>
    <style type="text/css">
        .contentImg {
            width: 500px;
            height: 350px;
        }
        .avatar {
            width: 70px;
            height: 70px;
            border-radius: 50%;
        }

    </style>
</head>
<body>
<center>
    <%
        request.setCharacterEncoding("UTF-8");
        List<Dongtai> dongtaiList = DaoFactory.getDongtaiDAOInstance().selectAllDongtai();
        String account = (String) session.getAttribute("account");
        User user = DaoFactory.getUserDAOInstance().getUserByAccount(account);
        for (Dongtai dongtai : dongtaiList) {%>
    <div style="width: 500px">
        <table cellpadding="1">
            <tr>
                <td>
                    <img class="avatar" src="<%=user.getAvatar()%>">
                    <%=user.getUsername()%>
                </td>
            </tr>
            <tr>
                <td><%=dongtai.getContent()%></td>
            </tr>
            <tr>
                <td>
                    <img class="contentImg" src="<%=dongtai.getContentImg()%>">
                </td>
            </tr>
            <tr>
                <td align="right" colspan="2">
                    发表时间：<%=dongtai.getDate()%> |
                    评论|
                </td>
            </tr>
        </table>
    </div>
    <hr width="50%">
    <%}%>
</center>
</body>
</html>
