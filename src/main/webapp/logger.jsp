<%@ page import="java.util.List" %>
<%@ page import="com.soft7.web.personSpace.entity.Logs" %>
<%@ page import="com.soft7.web.personSpace.factory.DaoFactory" %>
<%@ page contentType="text/html;charset=gb2312" pageEncoding="gb2312" language="java" %>

<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=gb2312"/>
    <title>日志</title>
    <style type="text/css">
        /* 页面顶部样式 */
        .mainbox_top {
            color: #3E064B;
            width: 95%;
            height: 3.125rem;
            padding: 10px;
        }

        /* 页面中部样式 */
        .mainbox_middle {
            color: #3E064B;
            width: 95%;
            height: 75%;
        }

        /* 顶部字体样式 */
        .font_top {
            color: #3F6F8A;
            margin-left: 10.125%;
            position: relative;
            text-decoration: none;
        }

        /* “写日志”与“模板日志”按钮样式 */
        .logbtn {
            position: relative;
            background-color: #3F6F8A;
            color: #FFFFFF;
            width: 120px;
            height: 30px;
            border: #EEEEEE;
            border-radius: 10px;
        }

        .mainlog {
            width: 900px;
            height: 2703px;
            margin: 0 auto;
            background-color: #E2E2E2;
        }

        .txt {
            width: 200px;
            height: 30px;
        }

    </style>

</head>

<body style="background: rgb(242,242,242);">

<%--top.jsp--%>
<div>
    <jsp:include page="Top.jsp" flush="true"></jsp:include>
</div>

<div class="mainlog">
    <div class="mainbox_top">
        <form action="LogServlet.do" method="post">
            <input type="hidden" name="action" value="find">
            <tr>
                <td>
                    <a href="logger.jsp" class="font_top">我的日志</a>
                    <a href="#draft" class="font_top">草稿箱</a>
                    <a href="#bin" class="font_top">回收站</a>
                    <input name="findLog" type="text" class="txt"<%request.setCharacterEncoding("UTF-8");%> placeholder="请输入您要搜索的内容...">
                    <input type="submit" value="搜索">
                </td>
            </tr>
            <HR>
        </form>
    </div>

    <div class="mainbox_middle">
        <button class="logbtn" onclick="window.location.href='writeLog.jsp'">写日志</button>
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
                        <a href="readLog.jsp?id=<%=logs.getId()%>">查看</a>
                    </td>
                </tr>
                <%}%>
            </table>
        </from>
    </div>
</div>
</body>
</html>