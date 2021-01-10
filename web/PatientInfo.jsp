<%--
  Created by IntelliJ IDEA.
  User: 陈昕
  Date: 2020/12/15
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>个人信息</title>
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
            <li><a href="DelUser" onclick="return checkSignOut()">注销账户</a></li>
            <li><a href="PatientHome.jsp">主页</a></li>
            <li><a href="PatientReg">挂号</a></li>
            <li><a href="https://www.acmilan.com/en">关于我们</a></li>
        </ul>
    </div><br><br>
    <table style="text-align: left; width: 100%;" border="0">
        <tbody>
        <tr>
            <td style="background-color: rgb(52,72,88);color: rgb(252,255,250)">id</td>
            <td style="background-color: rgb(62,85,104);color: rgb(253,255,253)">姓名</td>
            <td style="background-color: rgb(62,85,104);color: rgb(253,255,251)">性别</td>
            <td style="background-color: rgb(62,85,104);color: rgb(255,255,247)">年龄</td>
            <td style="background-color: rgb(62,85,104);color: rgb(251,255,255)">操作</td>
        </tr>
        <tr>
            <td>${sessionScope.patient.id}</td>
            <td>${sessionScope.patient.name}</td>
            <td>${sessionScope.patient.sex}</td>
            <td>${sessionScope.patient.age}</td>
            <td>
                <a href="UpdatePatientInfo.jsp">
                    <button class="operateButton">修改信息</button>
                </a>
            </td>
        </tr>
        </tbody>
    </table>
</body>
</html>
