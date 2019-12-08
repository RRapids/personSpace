<%@ page contentType="text/html;charset=gb2312" pageEncoding="gb2312" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=gb2312"/>
    <title>日志</title>
    <style type="text/css">
        /* 页面整体样式 */
        .body {
            background-color: #3E064B;
            width: 95%;
            height: 95%;
        }

        /* 页面顶部样式 */
        .mainbox_top {
            color: #3E064B;
            width: 95%;
            height: 3.125rem;
        }

        /* 页面中部样式 */
        .mainbox_middle {
            color: #3E064B;
            width: 95%;
            height: 75%;
        }


        /* 顶部字体样式 */
        .font_top {
            color: #BD459D;
            margin-left: 10.125%;
            position: relative;
            text-decoration: none;
        }

        /* 页面左边字体样式 */
        .font_left {
            color: #A43893;
            margin-left: 25rem;
            font-size: 0.75rem;
            padding: 1.25rem;
        }

        .font_left2 {
            color: #EEEEEE;
            margin-left: 25rem;
            font-size: 0.75rem;
            padding: 1.25rem;
        }

        /* “写日志”与“模板日志”按钮样式 */
        .logbtn {
            background-color: #CA3DA9;
            color: #FFFFFF;
            width: 13.7%;
            height: 7%;
            font-size: 1.125rem;
            border: none;
            padding-left: 0.3125rem;
            border-radius: 0.25rem;
            cursor: pointer;
            position: relative;
        }

        /* 下拉框按钮样式 */
        .logbtn2 {
            background-color: #CA3DA9;
            width: 3.342%;
            height: 3.342%;
            border: none;
            cursor: pointer;
            position: relative;
        }


    </style>
</head>
<body class="body">
<div>
    <div class="mainbox_top">
        <li>
            <a href="#mine" class="font_top">我的日志</a>
            <a href="#draft" class="font_top">草稿箱</a>
            <a href="#bin" class="font_top">回收站</a>
            <a href="#bin" class="font_top">搜索日志</a>
            <input type="text" placeholder="请输入您要搜索的内容...">
        </li>
    </div>
    <div class="mainbox_middle">
        <button class="logbtn"><img src="images/other/write.png" style="height: 1.375rem;width: 1.375rem;">写日志</button>
        <button class="logbtn2"><img src="images/other/dropdown-triangle.png" style="height: 1.375rem;width: 1.375rem;"></button>
    </div>
</div>
</body>
</html>