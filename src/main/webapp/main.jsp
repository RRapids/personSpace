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
    <style>
        body {
            margin: 0;
            padding: 0;
        }

        .container {
            text-align: center;
            text-align: justify;
            margin-top: 0px;
        }

        .header {
            width: 100%;
            height: 400px;
        }

        .left {
            width: 400px;
            margin-top: -70px;
            margin-left: 10px;
        }

        .right {
            float: right;
            margin-top: -1100px;
            width: 1100px;
            height: 1000px;
        }

        img {
            width: 100%;
            height: 100%;
            float: left;
        }
    </style>
</head>
<body>

<div>
    <jsp
    <jsp:include page="Top.html"></jsp:include>
</div>

<div class="container">
    <jsp:include page="center.html"></jsp:include>
</div>

<div>
    <jsp:include page="left.html"></jsp:include>
</div>

</body>
</html>
