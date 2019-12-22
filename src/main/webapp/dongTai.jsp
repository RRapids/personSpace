<%@ page import="com.soft7.web.personSpace.entity.Dongtai" %>
<%@ page import="java.util.List" %>
<%@ page import="com.soft7.web.personSpace.factory.DaoFactory" %>
<%@ page import="com.soft7.web.personSpace.entity.User" %>
<%@ page import="org.omg.DynamicAny.DynAnyOperations" %>
<%@ page contentType="text/html;charset=GB2312" language="java" %>
<html>
<head>
    <meta charset="GB2312">
    <title>���˶�̬</title>
    <style type="text/css">
        .contentImg {
            width: 500px;
            height: 350px;
        }
        .avatar {
            width: 60px;
            height: 60px;
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
                    ����ʱ�䣺<%=dongtai.getDate()%> |
                    ����|
                </td>
            </tr>
        </table>
    </div>
    <hr width="50%">
    <%}%>
</center>
</body>
</html>
