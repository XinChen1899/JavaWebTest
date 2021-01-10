<%--
  Created by IntelliJ IDEA.
  User: 陈昕
  Date: 2020/12/15
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改个人信息</title>
    <%response.setHeader("Cache-Control","no-store");%>
    <script type="text/javascript">
        function check(form) {
            var name=form.name.value;
            var age=form.age.value;
            var sex=form.sex.value;
            if(name.length==0||age.length==0||sex.length==0){
                alert("请确认所有项目都不为空值");
                return false;
            }
            return true;
        }

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
<body class="patientBody">
<div>
    <ul>
        <li><a href="PatientInfo.jsp">退出修改</a></li>
        <li><a href="Logout">退出登录</a></li>
        <li><a href="DelUser" onclick="return checkSignOut()">注销账号</a></li>
        <li><a href="PatientHome.jsp">主页面</a></li>
        <li><a href="PatientReg">挂号</a></li>
        <li><a href="https://www.acmilan.com/en">关于我们</a></li>
    </ul>
</div><br><br>
<table style="text-align: left; width: 100%;" border="0">
    <tbody>
    <tr>
        <td style="background-color: rgb(72,100,122);color: rgb(252,255,250)">姓名</td>
        <td style="background-color: rgb(72,100,122);color: rgb(252,255,250)">年龄</td>
        <td style="background-color: rgb(72,100,122);color: rgb(252,255,250)">性别</td>
        <td style="background-color: rgb(72,100,122);color: rgb(252,255,250)">操作</td>
    </tr>
    <tr>
        <form action="PatientUpdate" method="post" onsubmit="return check(this)">
            <td>
                <input type="text" name="name" value="${sessionScope.patient.name}" class="text">
            </td>
            <td>
                <input type="text" name="age" value="${sessionScope.patient.age}" class="text">
            </td>
            <td>
                <input type="radio" name="sex" value="男" checked>男
                <input type="radio" name="sex" value="女">女
            </td>
            <td>
                <input type="submit" value="保存" class="operateButton">
            </td>
        </form>
    </tr>
    </tbody>
</table>
</body>
</html>
