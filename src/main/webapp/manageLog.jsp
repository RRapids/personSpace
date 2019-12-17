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
                location.href="manageServlet.do?manageAction=logManage&logId="+logId;
            }else {
                return false;
            }
        }
    </script>
</head>
<body>
<from>
    <table border="0" cellpadding="10" width="80%">
        <tr>
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
                <button onclick="del(<%=logs.getId()%>)">删除</button>
            </td>
        </tr>
        <%}%>
    </table>
</from>
<a href="AdminCenter.jsp">返回</a>
</body>
</html>
