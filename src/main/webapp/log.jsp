<%@ page contentType="text/html;charset=gb2312" pageEncoding="gb2312" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=gb2312"/>
    <title>��־</title>
    <style type="text/css">
        /* ҳ��������ʽ */
        .body {
            background-color: #3E064B;
            width: 95%;
            height: 95%;
        }

        /* ҳ�涥����ʽ */
        .mainbox_top {
            color: #3E064B;
            width: 95%;
            height: 3.125rem;
        }

        /* ҳ���в���ʽ */
        .mainbox_middle {
            color: #3E064B;
            width: 95%;
            height: 75%;
        }


        /* ����������ʽ */
        .font_top {
            color: #BD459D;
            margin-left: 10.125%;
            position: relative;
            text-decoration: none;
        }

        /* ҳ�����������ʽ */
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

        /* ��д��־���롰ģ����־����ť��ʽ */
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

        /* ������ť��ʽ */
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
            <a href="#mine" class="font_top">�ҵ���־</a>
            <a href="#draft" class="font_top">�ݸ���</a>
            <a href="#bin" class="font_top">����վ</a>
            <a href="#bin" class="font_top">������־</a>
            <input type="text" placeholder="��������Ҫ����������...">
        </li>
    </div>
    <div class="mainbox_middle">
        <button class="logbtn"><img src="images/other/write.png" style="height: 1.375rem;width: 1.375rem;">д��־</button>
        <button class="logbtn2"><img src="images/other/dropdown-triangle.png" style="height: 1.375rem;width: 1.375rem;"></button>
    </div>
</div>
</body>
</html>