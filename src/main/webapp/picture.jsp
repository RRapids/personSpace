<%@ page import="java.util.List" %>
<%@ page import="com.soft7.web.personSpace.entity.Pictures" %><%--
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
        .picture{
            width: 150px;
            height: 150px;
        }

    </style>
</head>
<body>
<div>
    <jsp:include page="Top.jsp" flush="true"></jsp:include>
</div>
<a class="label2" href="photo.jsp">相册</a>
<label class="label3">图片</label>
<label class="label4">视频</label>
<hr style="position: relative;top: 55px;width: 86%;">
<table border="0" width="95%" cellspacing="0" style="margin-top:10px">
    <tr height="60">
        <td align="center"></td>
    </tr>
    <%
        List<Pictures> pictureList = (List<Pictures>) session.getAttribute("picturesList");
        for (Pictures pictures : pictureList) {%>
            <tr style="height: 150px">
                <td style="width: 25%;padding-left: 150px">
                    <img src="<%=pictures.getPicture()%>" class="picture">
                </td>
            </tr>
    <%}%>
</table>
</body>
</html>
