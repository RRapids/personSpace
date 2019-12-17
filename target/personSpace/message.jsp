<%@ page import="java.util.List" %>
<%@ page import="com.soft7.web.personSpace.entity.Message" %>
<%@ page import="com.soft7.web.personSpace.factory.DaoFactory" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.soft7.web.personSpace.dao.MessageDAO" %>
<%@ page import="com.soft7.web.personSpace.daoImpl.MessageDAOImpl" %>
<%@ page import="com.soft7.web.personSpace.util.SplitPage" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <title>留言板</title>
    <style type="text/css">

        .zoneName {
            position: absolute;
            top: 20px;
            left: 185px;
            color: white;
            width: 280px;
            height: 60px;
        }

        .zoneName p {
            font-size: 14px;
            margin-top: 3px;
        }

        .zoneName h2 {
            font-size: 28px;
            font-weight: normal;
        }

        .top_bottom {
            width: 100%;
            height: 50px;
            background-image: url("http://i.gtimg.cn/qzone/space_item/orig/5/97349_menu_bg.png");
            position: absolute;
            bottom: 0;
        }

        .top_bottom ul.section {
            list-style: none;
            margin-left: 165px;
            float: left;
        }

        .title {
            width: 858px;
            height: 52px;
            line-height: 52px;
            font-size: 14px;
            color: #26709A;
            margin: 0 auto;
            border-bottom: 1px solid rgb(221, 221, 221);
        }

        .info {
            width: 858px;
            height: 180px;
            color: #26709A;
            margin: 0 auto;
            line-height: 30px;
            border-bottom: 1px solid rgb(221, 221, 221);
            font-size: 16px;
        }

        .message {
            width: 858px;
            height: 35px;
            line-height: 35px;
            margin: 0 auto;
            border-bottom: 1px solid rgb(221, 221, 221);
        }

        .content {
            width: 858px;
            height: 100px;
            word-break: break-all;
            margin: 0 auto;
            border: 2px solid rgb(221, 221, 221);
            border-top: 0px;
            background-color: #e2e2e2;
            color: black;
            text-indent: 2px;
            font-size: 14px;
        }

        .subbtn {
            width: 72px;
            height: 28px;
            line-height: 28px;
            font-size: 14px;
            border-radius: 2px;
            background-color: #46B2EF;
            border: 1px solid rgb(221, 221, 221);
            cursor: pointer;
            margin-left: 20px;
            margin-bottom: 50px;
            border: none;
            position: relative;
            left: 790px;
            top: 15px;
        }

        .numofmessage {
            width: 858px;
            height: 20px;
            line-height: 20px;
            margin: 0 auto;
            border-bottom: 2px solid rgb(255, 255, 255);
        }

        .msgFrame {
            width: 858px;
            height: 2200px;
            margin: 0 auto;
        }

        .userId {
            width: 100%;
            height: 20px;
            font-size: 14px;
            color: #0096E6;
        }

        a {
            color: #70CCFF;
            text-decoration: none;
        }

        .time {
            width: 100%;
            height: 20px;
            font-size: 12px;
            margin-bottom: 20px;
            text-align: right;
        }

        .mainframe {
            width: 900px;
            height: 2703px;
            margin: 20px auto;
            background-color: rgb(221, 221, 221);
        }
    </style>
    <script type="text/javascript">
        function go() {
            var goPage = document.all.selectPage.value;
            alert("我们将去页面:message.jsp?flag=" + goPage);
            document.open("message.jsp?flag=" + goPage, "_self", "");
        }
    </script>
</head>

<body style="background: rgb(255,255,255);">

<%--声明SplitPage类--%>
<jsp:useBean id="spage" class="com.soft7.web.personSpace.util.SplitPage" scope="session">
</jsp:useBean>
<%--保留top.jsp--%>
<div>
    <jsp:include page="Top.jsp" flush="true"></jsp:include>
</div>

<!-- 下面实现留言板功能 -->
<div class="mainframe">
    <div class="title">留言板</div>
    <div class="message">主人寄语</div>
    <div class="info">
        直到我找回你<br>才知道你一直<br>在我身后<br>只是我不敢开口<br>怕你从我身后<br>溜走
    </div>
    <form action="message.jsp?flag=first" method="post">
        <textarea class="content" name="messageContent"></textarea>
        <input type="submit" value="发表" class="subbtn">
        <%
            request.setCharacterEncoding("UTF-8");
            MessageDAO messageDAO = new MessageDAOImpl();
            String strContent = request.getParameter("messageContent");
            String flag = request.getParameter("flag");
            List<Message> messageList = null;
            HashMap<String, String> tm = new HashMap<>();
            int totalRows = 0;
            if (strContent == null || strContent == "" || strContent.equals("null")) {
                totalRows = messageDAO.getRows(tm);
                spage.setTotalRows(totalRows);
                spage.confirmPage(flag);
                messageList = messageDAO.findAll(spage);
            } else {
                Message messages = new Message();
                messages.setName((String) session.getAttribute("username"));
                messages.setContent(strContent);
                messages.setDatetime(new Date());
                messageDAO.insertMessages(messages);
                //重新记录留言数
                totalRows = messageDAO.getRows(tm);
                spage.setTotalRows(totalRows);
                spage.confirmPage(flag);
                messageList = messageDAO.findAll(spage);

            }
        %>
    </form>

    <div class="numofmessage">留言</div>
    <!-- 下面是留言区 -->
    <div class="msgFrame">
        <table bgcolor="#dcdcdc" cellpadding="0">
            <%
                request.setCharacterEncoding("gb2312");
                for (Message message : messageList) {%>
            <tr>
                <td class="userId"><%=message.getName()%>
                </td>
            </tr>
            <tr>
                <td class="conInfo"><%=message.getContent()%>
                </td>
            </tr>
            <tr>
                <td class="time"><%=message.getDatetime()%>
                </td>
            </tr>
            <tr>
                <td>
                    <HR style="width: 800px" color="#ffffff">
                </td>
            </tr>
            <%}%>
            <tr>
                <td align="right">
                    <a href="message.jsp?flag=<%=SplitPage.FirstPAGE%>&content=<%=strContent%>">首页 </a>
                    <a href="message.jsp?flag=<%=SplitPage.PreviousPAGE%>&content=<%=strContent%>">上一页</a>
                    <a href="message.jsp?flag=<%=SplitPage.NextPAGE%>&content=<%=strContent%>">下一页</a>
                    <a href="message.jsp?flag=<%=SplitPage.LastPAGE%>&content=<%=strContent%>">尾页</a>
                    <select id="selectPage" name="gsPage" onchange="go()">
                        <%for (int i = 1; i < spage.getTotalPages(); i++) {%>
                        <option value=<%=i%> <%=spage.getCurrentPage() == i ? "selected='selected'" : " "%>>
                            <%=i%>/<%=spage.getTotalPages()%>
                        </option>
                        <%}%>
                    </select>
                </td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
