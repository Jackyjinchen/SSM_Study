<%--
  Created by IntelliJ IDEA.
  User: jindoc
  Date: 2020/8/22
  Time: 7:03 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-3.5.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#btn").click(function () {
                // alert("button click!");
                $.ajax({
                    url: "user/returnvoid.do",
                    data: {
                        name: "zhangsan",
                        age: 20,
                    },
                    type: "post",
                    dataType: "json",
                    success: function (resp) {
                        // alert(resp.name + "   " + resp.age);
                    }
                })
            });

            $("#btn1").click(function () {
                // alert("button click!");
                $.ajax({
                    url: "user/returnobject.do",
                    data: {
                        name: "zhangsan",
                        age: 20,
                    },
                    type: "post",
                    dataType: "json",
                    success: function (resp) {
                        alert(resp.name + "   " + resp.age);
                    }
                })
            });

            $("#btn2").click(function () {
                // alert("button click!");
                $.ajax({
                    url: "user/returnlist.do",
                    data: {
                        name: "zhangsan",
                        age: 20,
                    },
                    type: "post",
                    dataType: "json",
                    success: function (resp) {
                        $.each(resp,function (i,n) {
                            alert(n.name + "   " + n.age);
                        })
                    }
                })
            });
        });
    </script>
</head>
<body>
<p>Hello SpringMVC</p>
<a href="user/some.do">发起GET请求</a>
<form action="user/other.do" method="post">
    姓名：<input type="text" name="name"/><br/>
    年龄：<input type="text" name="age"><br/>
    <input type="submit" value="发送POST请求"/>
</form>
<p>使用java对象请求参数</p>
<form action="user/object.do" method="post">
    姓名：<input type="text" name="name"/><br/>
    年龄：<input type="text" name="age"><br/>
    <input type="submit" value="发送POST请求"/>
</form>
<p>使用String return</p>
<form action="user/returnstring.do" method="post">
    <input type="submit" value="Request StringReturn"/>
</form>
<br/>
<br/>
<p>使用void return Ajax</p>
<button id="btn">Ajax Request</button>
<br/>
<p>使用object return Ajax</p>
<button id="btn1">Ajax Request</button>
<br/>
<p>使用list return Ajax</p>
<button id="btn2">Ajax Request</button>
</body>
</html>
