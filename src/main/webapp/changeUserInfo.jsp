<%@ page import="com.soft7.web.personSpace.entity.User" %>
<%@ page import="com.soft7.web.personSpace.factory.DaoFactory" %><%--
  Created by IntelliJ IDEA.
  User: 79876
  Date: 2019/10/28
  Time: 8:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=GB2312" language="java" %>
<html>
<head>
    <title>�û���Ϣ</title>
</head>
<body background="images/other/InfoBg.jpg">

<%
    int id = (int) session.getAttribute("id");
    String account = (String) session.getAttribute("account");
    String username = (String) session.getAttribute("username");
    User user = DaoFactory.getUserDAOInstance().getUserByAccount(account);

%>

<center>
    <form action="uploadImage.do" method="post" enctype="multipart/form-data">
        <table>
            <br><br>
            <span><img src="<%=user.getAvatar()%>"></span>
            <h2>�û���:<%=username%></h2>
            <h3>�˺ţ�<%=user.getAccountNumber()%></h3>
            <h3>�ֻ��ţ�<%=user.getPhoneNumber()%></h3>
            <h3>���䣺<%=user.getEmail()%></h3>
            <br>
            <label for="file">�޸�ͷ��</label> <input type="file" id="file" name="file" value="D:\javastudy\project\personSpace\src\main\webapp\images\face">
            <br>
            <tr>
                <td colspan="2">
                    <input type="hidden" name="id" value="<%=id%>">
                    <div align="center">
                        <input type="submit" value="�ύ">
                    </div>
                </td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>
