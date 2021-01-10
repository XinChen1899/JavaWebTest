<%--
  Created by IntelliJ IDEA.
  User: 陈昕
  Date: 2020/11/30
  Time: 22:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello World</title>
    <%response.setHeader("Cache-Control","no-store");%>
    <script type="text/javascript">
        function check(form) {
            var id = form.id.value;
            var password = form.password.value;
            if (id.length == 0 || password.length == 0||identity.length == 0) {
                sessionStorage.setItem("error",null);
                alert('id或密码未填写，请检查.');
                return false;
            } else {
                return true;
            }
        }

        var error="<%=session.getAttribute("error")%>";
        if(error!="null"&&error!=null)
            alert(error);
        <%session.setAttribute("error",null);%>
    </script>
    <style type="text/css">
        @import "css/css1.css";
    </style>
</head>
<body class="indexBody">
    <div>
        <ul>
            <li><a href="DisplayDept" method="post">注册</a></li>
            <li><a href="https://www.acmilan.com/en">关于我们</a></li>
        </ul>
    </div><br><br><br>
    <h1 style="text-align: center;color: #40646e;" >欢迎光临武汉609医院</h1>
    <form action="Login" method="post" onsubmit="return check(this)" style="text-align: center">
        id：<input type="text" name="id" class="text"/><br><br>
        密码：<input type="password" name="password" class="text"/><br><br>
        <input type="radio" name="identity" value="patient" checked/>病人
        <input type="radio" name="identity" value="doctor" />医生<br><br>
        <button type="submit" class="mainButton">登录</button>
    </form>

</body>
</html>