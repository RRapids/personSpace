<%@ page import="com.soft7.web.personSpace.entity.Photos" %>
<%@ page import="java.util.List" %>
<%@ page import="com.soft7.web.personSpace.factory.DaoFactory" %>
<%@ page contentType="text/html;charset=gb2312" pageEncoding="gb2312" language="java" %>
<html>
<head>
    <noscript>
        <meta http-equiv="refresh" content="0; url=//qzs.qq.com/qzone/v6/troubleshooter/noscript.html"/>
    </noscript>
    <meta http-equiv="content-type" content="text/html; charset=gb2312"/>
    <title>个人空间相册部分</title>
</head>
<style>
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

    .btn1 {
        width: 150px;
        height: 35px;
        font-size: 16px;
        background: rgb(92, 170, 230);
        border: none;
        color: #FFFFFF;
        position: relative;
        top: 84px;
        left: 110px;
    }

    .btn2 {
        width: 100px;
        height: 35px;
        font-size: 16px;
        position: relative;
        top: 77px;
        left: 110px;
    }

    .btn3 {
        width: 100px;
        height: 35px;
        font-size: 16px;
        position: relative;
        top: 77px;
        left: 110px;
    }

    .label5 {
        position: relative;
        left: 675px;
        top: 77px;
    }
</style>
<body style="background: rgb(242,242,242);">
<div>
    <jsp:include page="Top.jsp" flush="true"></jsp:include>
</div>
<label class="label2">相册</label>
<label class="label3">图片</label>
<label class="label4">视频</label>
<hr style="position: relative;top: 55px;width: 86%;">

<button class="btn1">
    <img src="images/other/图片.png" style="width: 30px;height: 30px;position: relative;top: 1px;"/>
    <label class="label6" style="position: relative;top: -6px;">相册</label>
</button>
<button class="btn2">创建相册</button>
<button class="btn3">展示设置</button>
<table border="0" width="95%" cellspacing="0" style="margin-top:10px">
    <tr height="60">
        <td align="center"></td>
    </tr>
    <%
        List<Photos> photoList = DaoFactory.getPhotoDAOInstance().selectAllPhotos();
        if (photoList == null) {
    %>
    <tr height="100">
        <td align="center">
            <li>博主目前还未上传任何照片！</li>
        </td>
    </tr>
    <%
        } else {
            out.print("<tr height='150'>");
            out.print("<td width='25%' style='padding-left:150px'>");
            for (Photos photos:photoList){
                out.print("<a href='PhotoServlet.do?action=list&id=" + photos.getId() + "' target='_blank'><img src='images/bg/1.jpg' border='0' width='120' height='120' title='" + photos.getPhotoname() + "' style='border:1 solid;border-color:black'></a> ");
                out.println(photos.getPhotoname());
            }
            out.println("</td>");
            out.println("</tr>");
        }
    %>
</table>

</body>
</html>
