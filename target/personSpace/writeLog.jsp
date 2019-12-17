<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=gb2312"/>
    <title>写日志</title>
    <style type="text/css">
        .title {
            width: 220px;
            height: 40px;
            font-size: 18px;

        }
    </style>
</head>
<body>
<div>
    <jsp:include page="Top.jsp" flush="true"></jsp:include>
</div>
<div style="background-color: #70CCFF; text-align: center;height: 40px; ">
    <label>写日志</label>
</div>

<form action="LogServlet.do" method="post">
    <input type="hidden" name="action" value="add">
    <table align="center">
        <tr align="center">
            <td><input name="title" type="text" class="title" placeholder="输入标题"/></td>
            <hr>
        </tr>

        <tr>
            <td>
                <textarea style="font-size: 15px;" name="logContent" rows="20" cols="70"></textarea>
            </td>
        </tr>

        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="发表" style=" height: 37px;width: 60px; ackground-color: rgb(112,153,222);">
                <input type="reset" value="重置" style="height: 37px;width: 60px;">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
