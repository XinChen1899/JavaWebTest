<%--
  Created by IntelliJ IDEA.
  User: 陈昕
  Date: 2020/12/15
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
    <%response.setHeader("Cache-Control","no-store");%>
    <style type="text/css">
        @import "css/css1.css";
    </style>
    <script type="text/javascript">
        function checkSignOut(){
            var check=confirm("您确定要注销账户吗？");
            if(check==true)
                return true;
            else
                return false;
        }
    </script>
</head>
<body class="patientBody">
    <div>
        <ul>
            <li><a href="Logout">退出登录</a></li>
            <li><a href="DelUser"  onclick="return checkSignOut()">注销账户</a></li>
            <li><a href="https://www.acmilan.com/en">关于我们</a></li>
        </ul>
    </div><br><br><br><br>
    <h1 style="text-align: center">
        <%=session.getAttribute("outputMassage")%>
    </h1>
    <form style="text-align: center">
        <a href="PatientInfo.jsp">
            <button type="button" class="mainButton">个人信息</button>
        </a><br>
    </form>
    <form action="PatientReg" method="post" style="text-align: center">
        <button type="submit" class="mainButton">挂号</button>
    </form>
</body>
</html>
