<%--
  Created by IntelliJ IDEA.
  User: 陈昕
  Date: 2020/12/19
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<body class="doctorBody">
    <div>
        <ul>
            <li><a href="Logout">退出登录</a></li>
            <li><a href="DelUser" onclick="return checkSignOut()">注销账户</a></li>
            <li><a href="DoctorHome.jsp">主页面</a></li>
            <li><a href="UpdateDeptInfo.jsp">维护科室信息</a></li>
            <li><a href="DeptReg">处理挂号</a></li>
        </ul>
    </div><br>
    <table style="text-align: left; width: 100%;" border="0">
        <tbody>
        <tr>
            <td style="background-color: rgb(219,201,92);">id</td>
            <td style="background-color: rgb(219,201,92);">姓名</td>
            <td style="background-color: rgb(219,201,92);">科室</td>
            <td style="background-color: rgb(219,201,92);">性别</td>
            <td style="background-color: rgb(219,201,92);">操作</td>
        </tr>
        <tr>
            <td>${sessionScope.doctor.id}</td>
            <td>${sessionScope.doctor.name}</td>
            <td>${sessionScope.doctorDept.name}</td>
            <td>${sessionScope.doctor.sex}</td>
            <td>
                <a href="UpdateDoctorInfo.jsp">
                    <button type="button" class="operateButton">修改信息</button>
                </a>
            </td>
        </tr>
        </tbody>
    </table>
</body>
</html>
