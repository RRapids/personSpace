<%@ page import="com.soft7.web.personSpace.entity.Logs" %>
<%@ page import="java.util.List" %>
<%@ page import="com.soft7.web.personSpace.factory.DaoFactory" %><%--
  Created by IntelliJ IDEA.
  User: tengf
  Date: 2019/12/15
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>日志管理</title>
    <script type="text/javascript">
        function del(logId) {
            var fdel = window.confirm("确认要删除吗？");
            if (fdel) {
                location.href="manageServlet.do?manageAction=deleteLog&logId="+logId;
            }else {
                return false;
            }
        }
        function modify() {
            location.href="manageServlet.do?manageAction=modifyLog&logId="+logId;
        }
    </script>
    <style type="text/css">
        .debtn{
            border-radius: 10px;
            background-color: brown;
            color: #FFFFFF;
            width: 80px;
            height: 30px;
            font-size: 1.125rem;
            border: #EEEEEE;
            display: block;
        }
    </style>
</head>
<body background="images/other/InfoBg.jpg">
<a href="AdminCenter.jsp" style="font-size: 20px;text-decoration: none;color: #70CCFF;" >【返回上一级】</a>
<hr>
<from>
    <table border="1" cellpadding="10" width="80%">
        <tr  style="font-size: 16px;font-weight: bold;">
            <td>序号</td>
            <td>标题</td>
            <td>作者</td>
            <td>发表时间</td>
        </tr>
        <%
            request.setCharacterEncoding("UTF-8");
            List<Logs> logsList = DaoFactory.getLogDAOInstance().selectAllLogs();
            for (Logs logs : logsList) {%>
        <tr>
            <td><%=logs.getId()%></td>
            <td><%=logs.getTitle()%></td>
            <td><%=logs.getName()%></td>
            <td><%=logs.getLogDate()%></td>
            <td>
                <button class="delbtn" onclick="del(<%=logs.getId()%>)">删除</button>
<%--                <button class="debtn" onclick="modify(<%=logs.getId()%>)">修改</button>--%>
            </td>
        </tr>
        <%}%>
    </table>
</from>
</body>
</body>
</html>
