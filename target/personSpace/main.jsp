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
    <%@ page isELIgnored="false" %>
    <link rel="stylesheet" href="css.css">
    <title>主界面</title>
    <meta http-equiv="content-type" content="text/html; charset=gb2312"/>
</head>
<body>

<div>
    <jsp:include page="Top.html"></jsp:include>
</div>

<div>
    <jsp:include page="center.html"></jsp:include>
</div>

<div>
    <jsp:include page="left.html"></jsp:include>
</div>

<div>
    <jsp:include page="right.jsp"></jsp:include>
</div>

</body>
</html>
