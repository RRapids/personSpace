<%--
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
<body>

<%
    int id = (int) session.getAttribute("id");
    String username = (String) session.getAttribute("username");
%>

<center>
    <form action="uploadImage.do" method="post" enctype="multipart/form-data">
        <table>
            <br><br>
            <h1><font color="#00008b">�޸�ͷ��</font></h1><br>
            <h2>�û���:<%=username%></h2>
            <br>
            <label for="file">�ϴ�ͷ��ͼƬ��</label> <input type="file" id="file" name="file" value="D:\javastudy\project\personSpace\src\main\webapp\images\face">
            <br>
            <h4><font color="#cd5c5c">ע�⣺�ļ���С���ܳ���10KB</font></h4><br>
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
