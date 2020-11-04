<%--
  Created by IntelliJ IDEA.
  User: jindoc
  Date: 2020/8/24
  Time: 10:52 上午
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
    <title>Ajax查询学生信息</title>
    <base href="<%=basePath%>" />
    <script type="text/javascript" src="js/jquery-3.5.1.min.js"></script>
    <script type="text/javascript">
        $(function (){
            loadStudent();
            $("#btn").click(function () {
                loadStudent();
            })
        })

        function loadStudent(){
            $.ajax({
                url:"student/listStudent.do",
                type:"get",
                dataType:"json",
                success:function (data){
                    $("#info").html("");
                    $.each(data,function (i,n){
                        $("#info").append("<tr>")
                            .append("<td>"+n.id+"</td>")
                            .append("<td>"+n.name+"</td>")
                            .append("<td>"+n.age+"</td>")
                            .append("<tr>")
                    })
                }
            })
        }
    </script>
</head>
<body>
    <div align="center">
        <input type="button" id="btn" value="查询数据">
        <table border="1">
            <thead>
                <tr>
                    <td>学号</td>
                    <td>姓名</td>
                    <td>年龄</td>
                </tr>
            </thead>
            <tbody id="info"></tbody>
        </table>
    </div>
</body>
</html>
