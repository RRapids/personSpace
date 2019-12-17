<%--
  Created by IntelliJ IDEA.
  User: tengf
  Date: 2019/12/3
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>测试</title>
    <script type="text/javascript">
      function diag()
      {
        var str=prompt("随便写点儿啥吧","比如我叫啥");
        if(str)
        {
          alert("您刚输入的是："+ str)
        }
      }
    </script>
  </head>
  <body>
  <p>
    <input type="submit" value="Sumit" name="Su1" onclick="diag()" />
  </p>
  <form action="login.html" method="get">
    <input type="submit">
  </form>
  </body>
</html>
