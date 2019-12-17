<%@ page import="com.soft7.web.personSpace.entity.Friends" %>
<%@ page import="java.util.List" %>
<%@ page import="com.soft7.web.personSpace.factory.DaoFactory" %><%--
  Created by IntelliJ IDEA.
  User: tengf
  Date: 2019/12/15
  Time: 13:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>好友信息管理</title>
    <style type="text/css">
        .box {
            width: 10%;
            margin: 0 auto;
            padding: 28px;
            border: 1px #111 solid;
            display: none; /* 默认对话框隐藏 */
        }

        .box.show {
            display: block;
        }

        .box .x {
            font-size: 18px;
            text-align: right;
            display: block;
        }

        .box input {
            width: 80%;
            font-size: 18px;
            margin-top: 18px;
        }
    </style>

    <%--      点击按钮打开/关闭对话框--%>
    <script type="text/javascript">
        function msgbox(n) {
            document.getElementById('inputbox').style.display = n ? 'block' : 'none';
        }
    </script>
</head>
<body>
<center>
    <form action="manageServlet.do" method="post">
        <table border="1" cellpadding="10">
            <tr>
                <td>@</td>
                <td>好友昵称</td>
                <td>账号</td>
                <td>删除</td>
                <td><input type="button" onclick="msgbox(1)" value="添加好友"
                           style="background-color:#70CCFF;border: none; width: 80px;height: 35px;"></td>
            </tr>

            <%
                request.setCharacterEncoding("UTF-8");
                List<Friends> friendsList = DaoFactory.getFriendsDAOInstance().getAllFriends();
                for (Friends friends : friendsList) {%>
            <tr>
                <td><img src="<%=friends.getAvatar()%>"></td>
                <td><%=friends.getName()%>
                </td>
                <td><%=friends.getAccount()%>
                </td>
                <td>
                    <a href="manageServlet.do?manageAction=deleteFriend&friendId=<%=friends.getId()%>" style="background-color:#70CCFF;border: none;width:80px;height: 35px;">删除</a>
                </td>
            </tr>
            <%}%>
        </table>
        <div id="inputbox" class="box">
            <input type="hidden" name="manageAction" value="addFriend">
            <a class="x" onclick="msgbox(0); return false;">关闭</a>
            <input type="text" placeholder="输入添加账号" name="otherAccount">
            <input type="submit" value="添加">
        </div>
    </form>
    <a href="AdminCenter.jsp" style="list-style: none;color:black;font-size: 18px;">返回</a>
</center>
</body>
</html>
