<%@ page import="com.soft7.web.personSpace.entity.User" %>
<%@ page import="com.soft7.web.personSpace.factory.DaoFactory" %>
<%@ page contentType="text/html;charset=GB2312" language="java" %>
<html>
<head>
    <meta charset="GB2312"/>
    <meta http-equiv="content-type" content="text/html; charset=GB2312"/>
    <title>���˿ռ��ϲ���</title>
    <style type="text/css">
        .dropbtn {
            width: 112px;
            height: 39px;
            font-size: 13px;
            background-color: rgb(31, 31, 31);
            color: white;
            padding-top: 5px;
            padding-left: 10px;
            border: none;
            cursor: pointer;
            position: relative;
            left: -25px;
            top: -12px;
        }

        .dropbtn1 {
            width: 77px;
            height: 39px;
            font-size: 13px;
            background-color: rgb(31, 31, 31);
            color: white;
            padding-top: 5px;
            padding-left: 10px;
            border: none;
            cursor: pointer;
            position: relative;
            left: -25px;
            top: -12px;
        }

        .dropdown {
            position: relative;
            display: inline-block;
            z-index: 9999
        }

        .dropdown-content {
            display: none;
            position: absolute;
            background-color: #FFFFFF;
            min-width: 140px;
            box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
        }

        .dropdown-content a {
            color: black;
            padding: 12px 16px;
            text-decoration: none;
            display: block;
        }

        .dropdown-content a:hover {
            background-color: #FFFFFF
        }

        .dropdown:hover .dropdown-content {
            display: block;
        }

        .dropdown:hover .dropbtn {
            background-color: rgb(31, 31, 31);
        }

        .tupiapn1 {
            height: 40px;
            width: 336px;
            position: relative;
            top: 0px;
            left: -20px;
        }

        .tupiapn2 {
            height: 39px;
            width: 105px;
            position: relative;
            top: 0px;
            left: -27px;
        }

        .tupiapn3 {
            height: 39px;
            width: 103px;
            position: relative;
            top: 0px;
            left: -32px;
        }

        .tupiapn4 {
            height: 39px;
            width: 94px;
            position: relative;
            top: 0px;
            left: -38px;
        }

        .tupiapn5 {
            height: 39px;
            width: 80px;
            position: relative;
            top: 0px;
            left: -44px;
        }

        .tupiapn6 {
            height: 39px;
            width: 79px;
            position: relative;
            top: 0px;
            left: -49px;
        }

        .tupiapn7 {
            width: 140px;
            height: 39px;
            position: relative;
            top: 0px;
            left: -54px;
        }

        .div1 {
            height: 39px;
            width: 230px;
            position: relative;
            top: -49px;
            left: 910px;
        }

        .div2 {
            height: 39px;
            width: 400px;
            position: relative;
            top: -87px;
            left: 1138px;
        }

        .input1 {
            border-radius: 3px;
            height: 19px;
            position: relative;
            top: 7px;
            left: 10px;
        }

        .input2 {
            border-radius: 3px;
            position: relative;
            top: 7px;
            left: 10px;
        }

        .tupian8 {
            height: 28px;
            position: relative;
            top: 5px;
            left: 10px;
        }

        .tupian9 {
            height: 270px;
            width: 1560px;
            position: relative;
            top: -13px;
            left: -30px;
        }

        .tupian10 {
            height: 110px;
            width: 110px;
            position: relative;
            top: 160px;
            left: 270px;
        }

        .tupian11 {
            height: 24px;
            width: 24px;
            position: relative;
            top: -40px;
            left: 960px;
        }

        .label1 {
            position: relative;
            top: 140px;
            left: 260px;
        }

        .div3 {
            height: 39px;
            width: 1700px;
            position: relative;
            top: -15px;
            left: -10px;
        }

        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
        }

        li {
            display: inline;
        }

        li a {
            position: relative;
            top: 10px;
            left: 340px;
            color: #000;
            padding: 8px 30px;
            text-decoration: none;
        }

        .div4 {
            height: 44px;
            width: inherit;
            background-color: rgb(31, 31, 31);
            position: relative;
            top: -10px;
        }
    </style>
</head>
<body>
<%
    String account = (String) session.getAttribute("account");
    User user = DaoFactory.getUserDAOInstance().getUserByAccount(account);
%>

<div class="div4">
    <div class="dropdown">
        <span><img src="images/other/9.png" class="tupiapn1"/></span>
    </div>
    <div class="dropdown">
        <button class="dropbtn">
            <img src="images/other/man.png" style="position: relative;top: 4px;height: 60%;"/>
            ��������
        </button>
    </div>
    <div class="dropdown">
        <button class="dropbtn">
            <img src="images/other/home.png" style="position: relative;top: 10px;"/>
            �ҵ���ҳ
        </button>
        <div class="dropdown-content">
            <table>
                <tr>
                    <td><img src="images/other/��־.png" style="height: 32px;width: 32px;"/></td>
                    <td><a href="log.jsp">��־</a></td>
                </tr>
                <tr>
                    <td><img src="images/other/���.png" style="height: 32px;width: 32px;"/></td>
                    <td><a href="//www.runoob.com">���</a></td>
                </tr>
                <tr>
                    <td><img src="images/other/���԰�.png" style="height: 32px;width: 32px;"/></td>
                    <td><a href="message.jsp">���԰�</a></td>
                </tr>
            </table>
        </div>
    </div>
    <div class="dropdown">
        <button class="dropbtn1">
            <img src="images/other/friends.png" style="position: relative;top: 5px;height: 70%;"/>
            ����
        </button>
        <div class="dropdown-content">
        </div>
    </div>
    <div class="dropdown">
        <button class="dropbtn1">
            <img src="images/other/Ӧ��.png" style="position: relative;top: 5px;height: 70%;"/>
            ��Ϸ
        </button>
        <div class="dropdown-content">
            <table>
                <tr>
                    <td><img src="images/other/18.png" style="height: 32px;width: 32px;"/></td>
                    <td><a href="//www.runoob.com">Ӣ������</a></td>
                </tr>
                <tr>
                    <td><img src="images/other/19.png" style="height: 32px;width: 32px;"/></td>
                    <td><a href="//www.runoob.com">��ѩ֮��</a></td>
                </tr>
                <tr>
                    <td><img src="images/other/20.png" style="height: 32px;width: 32px;"/></td>
                    <td><a href="//www.runoob.com">ȭ��</a></td>
                </tr>
                <tr>
                    <td><img src="images/other/21.png" style="height: 32px;width: 32px;"/></td>
                    <td><a href="//www.runoob.com">����</a></td>
                </tr>
            </table>
        </div>
    </div>
    <div class="dropdown">
        <button class="dropbtn1">
            <img src="images/other/Ƥ��.png" style="position: relative;top: 5px;height: 60%;"/>
            װ��
        </button>
        <div class="dropdown-content">
        </div>
    </div>
    <div class="dropdown">
        <span><img src="images/other/15.png" class="tupiapn7"/></span>
    </div>
    <div class="div1" style="background-color: rgb(31,31,31);">
        <input class="input1" type="text" value="�û�/��̬"/>
        <input class="input2" type="button" value="����"/>
    </div>
    <div class="div2" style="background-color: rgb(31,31,31);">
        <img src="images/other/16.png" class="tupian8"/>
    </div>
</div>
<div style="background-image: url(images/other/26.jpg);" class="tupian9">

    <%-- ��ȡͷ��  --%>
    <a href="changeUserInfo.jsp"><img src="<%=user.getAvatar()%>" class="tupian10"/></a>
    <%--  ��ȡ�س�--%>
    <label class="label1"><%=user.getUsername()%>�ĸ��˿ռ�</label>

    <img src="images/other/��.png" alt="" class="tupian11"/>

</div>

<div class="div3" style="background-color: rgb(250,250,250);">
    <ul style="color: #F0F8FF;">
        <li><a href="main.jsp">��ҳ</a></li>
        <li><a href="log.jsp">��־</a></li>
        <li><a href="#">���</a></li>
        <li><a href="message.jsp">���԰�</a></li>
        <li><a href="#about">˵˵</a></li>
        <li><a href="userInfo.jsp">���˵�</a></li>
        <li><a href="https://y.qq.com/">����</a></li>
        <li><a href="http://www.4399.com/">����</a></li>
    </ul>
</div>
</body>
</html>