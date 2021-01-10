<%--
  Created by IntelliJ IDEA.
  User: 陈昕
  Date: 2020/12/19
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>注册新用户</title>
    <%response.setHeader("Cache-Control","no-store");%>
    <style type="text/css">
        @import "css/css1.css";
        #patient{
            display: block;
        }
        #doctor{
            display: none;
        }
        body{
            background-image: url("image/wuhanchangjiang.jpg");
            background-size: 100% 100%;
            background-repeat: no-repeat;
        }
    </style>
    <script type="text/javascript">
        function showHide(type){
            var patient=document.getElementById('patient');
            var doctor=document.getElementById('doctor');
            if(type=='patient')
            {
                patient.style.display='block';
                doctor.style.display='none';
            }
            else{
                doctor.style.display='block';
                patient.style.display='none';
            }
        }

        function check(form) {
            var id = form.id.value;
            var password = form.password.value;
            var name=form.name.value;
            var sex=form.sex.value;
            var userType=form.userType.value;
            var age=form.age.value;
            var deptid=form.deptid.value;
            if (id.length == 0 || password.length == 0||userType.length == 0||sex.length==0||name.length==0
                ||(age.length==0 && deptid.length==0)) {
                alert('id或密码未填写，请检查.');
                return false;
            } else {
                return true;
            }
        }
    </script>
</head>
<body class="indexBody">
    <div>
        <ul>
            <li><a href="index.jsp">主页面</a></li>
            <li><a href="https://www.acmilan.com/en">关于我们</a></li>
        </ul>
    </div>
    <br><br><br>
    <form action="AddUser" method="post" style="text-align: center" onsubmit="return check(this)">
        id：<input type="text" name="id" class="text"><br><br>
        密码：<input type="password" name="password" class="text"><br><br>
        姓名：<input type="text" name="name" class="text"><br><br>
        性别：<input type="radio" name="sex" value="男">男&nbsp;
        <input type="radio" name="sex" value="女">女<br><br>
        用户类型：<input type="radio" name="userType" value="patient" checked onclick="showHide('patient')">病人&nbsp;
        <input type="radio" name="userType" value="doctor" onclick="showHide('doctor')">医生<br><br>
        <div id="patient">
            年龄：<input type="text" name="age" class="text">
        </div>
        <div id="doctor">
            部门：
            <select name="deptid">
                <c:forEach var="deptList" items="${applicationScope.deptList}">
                    <option value="${deptList.id}">${deptList.name}</option>
                </c:forEach>
            </select>
        </div><br>
        <button type="submit" class="mainButton">确认</button>
    </form>
</body>
</html>
