<%--
  Created by IntelliJ IDEA.
  User: jindoc
  Date: 2020/8/24
  Time: 5:23 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>退出登录</title>
</head>
<body>
    <%
        session.removeAttribute("name");
    %>
</body>
</html>