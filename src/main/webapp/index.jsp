<%--
  Created by IntelliJ IDEA.
  User: jindoc
  Date: 2020/8/24
  Time: 9:10 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath=request.getScheme() + "://" +
            request.getServerName() + ":" +request.getServerPort() +
            request.getContextPath() + "/";
%>
<html>
<head>
    <title>Main Page</title>
    <base href="<%=basePath%>" />
</head>
<body>
    <div align="center">
        <img src="imgs/panda.jpg"/>
        <p>SSM Hello World!</p>
        <table>
            <tr>
                <td><a href="addStudent.jsp">注册学生</a></td>
            </tr>
            <tr>
                <td><a href="listStudent.jsp">浏览学生</a></td>
            </tr>
        </table>
        <form action="student/redirect.do" method="post">
            <input type="submit" value="百度一下">
        </form>
    </div>
</body>
</html>
