<%@ page import="java.util.List" %>
<%@ page import="com.soft7.web.personSpace.entity.Logs" %><%--
  Created by IntelliJ IDEA.
  User: tengf
  Date: 2019/12/12
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>搜素日志</title>
</head>
<body>

<div>
    <jsp:include page="Top.jsp" flush="true"></jsp:include>
</div>

<table border="0" cellpadding="10" width="80%">
    <tr>
        <td>序号</td>
        <td>标题</td>
        <td>作者</td>
        <td>发表时间</td>
    </tr>
    <%--接受搜素--%>
    <%
        request.setCharacterEncoding("gb2312");
        List<Logs> searchLogList = (List<Logs>) session.getAttribute("searchLogs");
        session.setAttribute("searchLogs",null);
        for (Logs logs : searchLogList) {%>
    <tr>
        <td><%=logs.getId()%>
        </td>
        <td><%=logs.getTitle()%>
        </td>
        <td><%=logs.getName()%>
        </td>
        <td><%=logs.getLogDate()%>
        </td>
        <td>
            <a href="readLog.jsp?id=<%=logs.getId()%>">查看</a>
        </td>
    </tr>
    <%}%>
</table>
</body>
</html>
