<%@ page contentType="text/html;charset=gb2312" pageEncoding="gb2312" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=gb2312"/>
    <title>留言板</title>
    <style type="text/css">
        .header {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 41px;
            background: #001e3b;
            text-align: center;
            line-height: 41px;
            font-size: 16px;
            color: grey;
            z-index: 100;
        }

        .topInfo {
            width: 100%;
            height: 300px;
            background-repeat: no-repeat;
            margin-top: 41px;
            background-position: -275px top;
            background-attachment: scroll;
            background-image: url(http://i.gtimg.cn/qzone/space_item/orig/5/97349_top.jpg);
            position: relative;
        }

        .edit {
            position: absolute;
            left: 417px;
            height: 18px;
            background: #54B3E3;
            color: white;
            font-size: 14px;
            display: none;
        }

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

        .support {
            width: 58px;
            height: 33px;
            position: absolute;
            right: 183px;
            top: 50px;
            background-color: rgba(0, 0, 0, 0.4);
            border-radius: 18px;
            color: white;
            line-height: 30px;
            cursor: pointer;
        }

        .num {
            margin-top: -33px;
            width: 18px;
            height: 18px;
            margin-left: 40px;
            display: block;
            margin-bottom: 2px;
            cursor: pointer;
        }

        .tips {
            width: 60px;
            height: 20px;
            font-size: 12px;
            background-color: white;
            color: black;
            text-align: center;
            line-height: 20px;
            position: absolute;
            left: 0;
            right: 0;
            display: none;
        }

        .top_bottom {
            width: 100%;
            height: 50px;
            background-image: url("http://i.gtimg.cn/qzone/space_item/orig/5/97349_menu_bg.png");
            position: absolute;
            bottom: 0;
        }

        .photo {
            width: 128px;
            height: 128px;
            position: absolute;
            left: 185px;
            top: 96px;
            padding: 1px;
        }

        .uploadphoto {
            width: 100px;
            height: 20px;
            font-size: 12px;
            color: #eee;
            background-color: rgba(0, 0, 0, 0.8);
            text-align: center;
            line-height: 20px;
            position: absolute;
            left: 200px;
            top: 8px;
            display: none;
            cursor: pointer;
        }

        .container {
            width: 980px;
            margin: 0 auto;
            height: 100%;
            line-height: 50px;
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
            font-family: 微软雅黑, Tohoma;
            font-size: 14px;
            color: rgb(43, 157, 230);
            margin: 0 auto;
            border-bottom: 2px solid rgb(31, 112, 187);
        }

        .info {
            width: 858px;
            height: 140px;
            color: #EDEFF0;
            margin: 0 auto;
            line-height: 40px;
            border-bottom: 2px solid #1f70bb;
            font-size: 12px;
        }

        .info {
            width: 858px;
            height: 140px;
            color: #EDEFF0;
            margin: 0 auto;
            line-height: 40px;
            border-bottom: 2px solid #1f70bb;
            font-size: 12px;
        }

        .message {
            width: 858px;
            height: 35px;
            line-height: 35px;
            color: rgb(238, 238, 238);
            font-family: 微软雅黑, Tohoma;
            margin: 0 auto;
            border-bottom: 2px solid rgb(31, 112, 187);
        }

        .content {
            width: 858px;
            height: 100px;
            word-break: break-all;
            margin: 0 auto;
            border: 2px solid #1f70bb;
            border-top: 0px;
            background-color: #e2e2e2;
            color: black;
            text-indent: 2px;
            font-size: 14px;
        }

        .content {
            width: 858px;
            height: 100px;
            word-break: break-all;
            margin: 0 auto;
            border: 2px solid #1f70bb;
            border-top: 0px;
            background-color: #e2e2e2;
            color: black;
            text-indent: 2px;
            font-size: 14px;
        }

        .content {
            width: 858px;
            height: 100px;
            word-break: break-all;
            margin: 0 auto;
            border: 2px solid #1f70bb;
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
            border: 1px solid #3686B3;
            cursor: pointer;
            margin-left: 20px;
            margin-bottom: 50px;
        }

        .numofmessage {
            width: 858px;
            height: 20px;
            color: rgb(237, 239, 240);
            line-height: 20px;
            font-family: 微软雅黑;
            margin: 0 auto;
            border-bottom: 2px solid rgb(31, 112, 187);
        }

        .numofmessage {
            width: 858px;
            height: 20px;
            color: rgb(237, 239, 240);
            line-height: 20px;
            font-family: 微软雅黑;
            margin: 0 auto;
            border-bottom: 2px solid rgb(31, 112, 187);
        }

        .msgFrame {
            width: 858px;
            height: 2200px;
            margin: 0 auto;
        }

        .msgFrame {
            width: 858px;
            height: 2200px;
            margin: 0 auto;
        }

        .content_1 {
            width: 858px;
            height: 190px;
            color: #EDEFF0;
            margin: 0 auto;
            border-bottom: 2px solid #1f70bb;
        }

        .name {
            width: 50px;
            height: 50px;
            margin: 20px 20px;
            border-radius: 5px;
        }

        .mainInfo {
            width: 766px;
            height: 143px;
            float: right;
            margin-top: 20px;
        }

        .userId {
            width: 100%;
            height: 20px;
            font-size: 14px;
        }

        a {
            color: #70CCFF;
            text-decoration: none;
        }

        .conInfo {
            width: 100%;
            height: 100px;
            margin-top: 12px;
            font-size: 12px;
        }

        .time {
            width: 100%;
            height: 20px;
            font-size: 12px;
            margin-bottom: 20px;
            color: #8AB8E3;
        }

        .mainframe {
            width: 900px;
            height: 2703px;
            margin: 20px auto;
            background-color: #24639D;
        }
    </style>
</head>
<body>
<div>
    <jsp:include page="Top.jsp" flush="true"></jsp:include>
</div>
<div class="header">
    欢迎来到留言板
</div>
<div class="topInfo">
    <span class="edit">编辑</span>
    <div class="zoneName">
        <h2><%=session.getAttribute("username")%>的空间</h2>
        <p>书里总是写到喜出望外的傍晚。</p>
    </div>
</div>
<!-- 下面实现留言板功能 -->
<div class="mainframe">
    <div class="title">留言板</div>
    <div class="message">主人寄语</div>
    <div class="info">
        这是主人留下的寄语~
    </div>
    <div class="content" contenteditable="true"></div>
    <input type="button" name="submit" value="发表" class="subbtn">
    <div class="numofmessage">留言(3)</div>
    <!-- 下面是留言区 -->
    <div class="msgFrame">
        <div class="content_1">
            <div class="mainInfo">
                <div class="userId"><a href="#">zipple</a></div>
                <div class="conInfo">
                    新年快乐。
                </div>
                <div class="time">2016-12-19 23:46:11</div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
