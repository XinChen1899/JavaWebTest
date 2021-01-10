<%--
  Created by IntelliJ IDEA.
  User: 陈昕
  Date: 2020/12/18
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
    <%response.setHeader("Cache-Control","no-store");%>
    <script type="text/javascript">
        function checkSignOut(){
            var check=confirm("您确定要注销账户吗？");
            if(check==true)
                return true;
            else
                return false;
        }
    </script>
    <style type="text/css">
        @import "css/css1.css";
    </style>
</head>
<body class="doctorBody">
    <div>
        <ul>
            <li><a href="Logout">退出登录</a></li>
            <li><a href="DelUser" onclick="return checkSignOut()">注销账户</a></li>
        </ul>
    </div><br>
    <h1 style="text-align: center">
        <%=session.getAttribute("outputMassage")%>
    </h1>
    <form style="text-align: center">
        <a href="DoctorInfo.jsp">
            <button type="button" class="mainButton">个人信息</button>
        </a><br><br><br>
        <a href="UpdateDeptInfo.jsp">
            <button type="button" class="mainButton">维护科室信息</button>
        </a><br><br><br>
        <a href="DeptReg">
            <button type="button" class="mainButton">处理挂号</button>
        </a>
    </form>
</body>
</html>
