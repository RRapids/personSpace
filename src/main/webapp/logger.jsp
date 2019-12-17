<%@ page import="java.util.List" %>
<%@ page import="com.soft7.web.personSpace.entity.Logs" %>
<%@ page import="com.soft7.web.personSpace.factory.DaoFactory" %>
<%@ page contentType="text/html;charset=gb2312" pageEncoding="gb2312" language="java" %>

<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=gb2312"/>
    <title>��־</title>
    <style type="text/css">
        /* ҳ�涥����ʽ */
        .mainbox_top {
            color: #3E064B;
            width: 95%;
            height: 3.125rem;
            padding: 10px;
        }

        /* ҳ���в���ʽ */
        .mainbox_middle {
            color: #3E064B;
            width: 95%;
            height: 75%;
        }

        /* ����������ʽ */
        .font_top {
            color: #3F6F8A;
            margin-left: 10.125%;
            position: relative;
            text-decoration: none;
        }

        /* ��д��־���롰ģ����־����ť��ʽ */
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
                    <a href="logger.jsp" class="font_top">�ҵ���־</a>
                    <a href="#draft" class="font_top">�ݸ���</a>
                    <a href="#bin" class="font_top">����վ</a>
                    <input name="findLog" type="text" class="txt"<%request.setCharacterEncoding("UTF-8");%> placeholder="��������Ҫ����������...">
                    <input type="submit" value="����">
                </td>
            </tr>
            <HR>
        </form>
    </div>

    <div class="mainbox_middle">
        <button class="logbtn" onclick="window.location.href='writeLog.jsp'">д��־</button>
        <from>
            <table border="0" cellpadding="10" width="80%">
                <tr>
                    <td>���</td>
                    <td>����</td>
                    <td>����</td>
                    <td>����ʱ��</td>
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
                        <a href="readLog.jsp?id=<%=logs.getId()%>">�鿴</a>
                    </td>
                </tr>
                <%}%>
            </table>
        </from>
    </div>
</div>
</body>
</html>