<%@ page import="java.util.List" %>
<%@ page import="com.soft7.web.personSpace.entity.Pictures" %>
<%@ page import="com.soft7.web.personSpace.servlet.PhotoServlet" %>
<%@ page import="com.soft7.web.personSpace.factory.DaoFactory" %><%--
  Created by IntelliJ IDEA.
  User: tengf
  Date: 2019/12/16
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>照片</title>
    <style type="text/css">
        .label2 {
            position: relative;
            left: 105px;
            top: 40px;
        }

        .label3 {
            position: relative;
            left: 155px;
            top: 40px;
        }

        .label4 {
            position: relative;
            left: 205px;
            top: 40px;
        }

        .picture {
            width: 120px;
            height: 120px;
        }
        .box {
            width: 20%;
            margin: 0 auto;
            padding: 28px;
            border: 1px #111 solid;
            display: none; /* 默认对话框隐藏 */
        }

        .box.show {
            display: block;
        }

        .box .x {
            font-size: 15px;
            text-align: right;
            display: block;
        }

        .box input {
            width: 80%;
            font-size: 15px;
            margin-top: 18px;
        }
    </style>
    <script type="text/javascript">
        function msgbox(n) {
            document.getElementById('inputbox').style.display = n ? 'block' : 'none';
        }
    </script>
</head>
<body>
<div>
    <jsp:include page="Top.jsp" flush="true"></jsp:include>
</div>
<a class="label2" href="photo.jsp" onclick="window.close()">相册</a>
<button class="label3" onclick="msgbox(1)">上传照片</button>
<label class="label4">视频</label>
<hr style="position: relative;top: 55px;width: 86%;">
<table border="0" width="95%" cellspacing="0" style="margin-top:10px">
    <tr height="60">
        <td align="center"></td>
    </tr>
    <%
        String photoId = (String) session.getAttribute("photoId");
        int t_photoId = Integer.parseInt(photoId);
        List<Pictures> pictureList = DaoFactory.getPictureDAOInstance().getPicturesByPhoto(t_photoId);
        if (pictureList == null) {%>
    <tr height="100">
        <td align="center">
            <li>博主目前还未上传任何照片！</li>
        </td>
    </tr>
    <%
    } else {
        for (Pictures pictures : pictureList) {
    %>
    <tr style="height: 150px">
        <td style="width: 25%;padding-left: 150px">
            <img src="<%=pictures.getPicture()%>" class="picture">
        </td>
        <td><%=pictures.getPicturename()%></td>
        <td><%=pictures.getPicturesdetails()%></td>
        <td><%=pictures.getUpdate()%></td>
    </tr>
    <%}
    }%>
</table>
<div id="inputbox" class="box">
    <form action="PhotoServlet.do" method="post">
        <meta charset="utf-8">
        <input type="hidden" name="action" value="addPicture">
        <a class="x" onclick="msgbox(0); return false;">关闭</a>
        <input type="text" placeholder="标题" name="pictureName">
        <input type="text" placeholder="描述" name="pictureDtails">
        <br>
        <a>选择照片</a>
        <input type="file" name="pictureFile" value="D:\javastudy\project\personSpace\src\main\webapp\images\picture">
        <br>
        <input type="submit" value="上传">
    </form>
</div>
</body>
</html>
