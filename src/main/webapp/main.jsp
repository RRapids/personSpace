<%--
  Created by IntelliJ IDEA.
  User: tengf
  Date: 2019/12/6
  Time: 8:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=gb2312" pageEncoding="gb2312" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css.css">
    <title>主界面</title>
    <meta http-equiv="content-type" content="text/html; charset=gb2312"/>
    <style type="text/css">
        .dongTai{
            position: relative;
            top: -600px;
        }
    </style>
</head>
<body style="background: rgb(242,242,242);">

<%
    String u = (String) session.getAttribute("username");
    if (u == null) {%>
<script>
    window.alert("sorry!无此用户，请重新登录！")
</script>
<%}%>

<div>
    <jsp:include page="Top.jsp" flush="true"></jsp:include>
</div>

<div>
    <jsp:include page="center.html" flush="true"></jsp:include>
</div>

<div>
    <jsp:include page="left.html" flush="true"></jsp:include>
</div>

<div>
    <jsp:include page="right.jsp" flush="true"></jsp:include>
</div>

<div class="dongTai">
    <jsp:include page="dongTai.jsp" flush="true"></jsp:include>
</div>

</body>
</html>
