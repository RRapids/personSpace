<%@ page import="java.util.List" %>
<%@ page import="com.soft7.web.personSpace.entity.Message" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.soft7.web.personSpace.factory.DaoFactory" %><%--
  Created by IntelliJ IDEA.
  User: tengf
  Date: 2019/12/15
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>留言管理</title>
    <script type="text/javascript">
        function del(messageId) {
            var fdel = window.confirm("确认要删除吗？");
            if (fdel) {
                location.href = "manageServlet.do?manageAction=messageManage&messageId=" + messageId;
            } else {
                return false;
            }
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
<body>
<from>
    <table border="1" cellpadding="10" width="80%">
        <tr style="font-size: 16px;font-weight: bold;">
            <td>序号</td>
            <td>留言者</td>
            <td>内容</td>
            <td>时间</td>
        </tr>
        <%
            request.setCharacterEncoding("UTF-8");
            List<Message> messageList = DaoFactory.getMessageDAOInstance().selectAllMessages();
            for (Message message:messageList) {%>
        <tr>
            <td>
                <%=message.getId()%>
            </td>
            <td>
                <%=message.getName()%>
            </td>
            <td>
                <%=message.getContent()%>
            </td>
            <td>
                <%=message.getDatetime()%>
            </td>
            <td>
                <button class="debtn" onclick="del(<%=message.getId()%>)">删除</button>
            </td>
        </tr>
        <%}%>
    </table>
</from>
<a href="AdminCenter.jsp">返回</a>
</body>
</html>
