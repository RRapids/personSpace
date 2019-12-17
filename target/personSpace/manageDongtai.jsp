<%@ page import="java.util.List" %>
<%@ page import="com.soft7.web.personSpace.entity.Dongtai" %>
<%@ page import="com.soft7.web.personSpace.factory.DaoFactory" %><%--
  Created by IntelliJ IDEA.
  User: tengf
  Date: 2019/12/15
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>说说管理</title>
    <style type="text/css">
        .contentImg {
            width: 200px;
            height: 200px;
        }
    </style>

    <script type="text/javascript">
        function del(dongtaiId) {
            var fdel = window.confirm("确认要删除吗？");
            if (fdel) {
                location.href="manageServlet.do?manageAction=deleteDongTai&dongTaiId="+dongtaiId;
            }else {
                return false;
            }
        }
    </script>

</head>
<body>
<center>
    <a href="AdminCenter.jsp" style="text-decoration: none;"><label style="position: relative;  left: 730px;font-size: 18px;color: #000000;"> 【返回】</label></a>
    <hr>
    <%
        request.setCharacterEncoding("UTF-8");
        List<Dongtai> dongtaiList = DaoFactory.getDongtaiDAOInstance().selectAllDongtai();
        for (Dongtai dongtai : dongtaiList) {%>
    <div>
        <table>
            <tr>
                <td>
                    <img src="<%=session.getAttribute("avatar")%>">
                </td>
                <td>
                    <p><%=session.getAttribute("username")%>
                    </p>
                </td>
                <td>
                    <p><%=dongtai.getDate()%>
                    </p>
                </td>
            </tr>
        </table>
    </div>
    <div>
        <p><%=dongtai.getContent()%>
        </p>
    </div>
    <div>
        <img src="<%=dongtai.getContentImg()%>" class="contentImg">
    </div>
    <button onclick="del(<%=dongtai.getId()%>)" style="position: relative;top: 6px; background-color:#70CCFF;border: none; width:80px ;height: 35px;">删除</button>
    <hr>
    <%}%>
</center>
</body>
</html>
