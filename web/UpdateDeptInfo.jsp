<%--
  Created by IntelliJ IDEA.
  User: 陈昕
  Date: 2020/12/24
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>维护科室信息</title>
    <%response.setHeader("Cache-Control","no-store");%>
    <script type="text/javascript">
        function check(form){
            var id=form.id.value;
            var name=form.name.value;
            var type=form.type.value;
            var description=form.description.value;
            var address=form.address.value;
            if(id.length==0||name.length==0||type.length==0||address.length==0||description.length==0){
                alert("请不要留空值");
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
<body class="doctorBody">
    <div>
        <ul>
            <li><a href="Logout">退出登录</a></li>
            <li><a href="DelUser" onclick="return checkSignOut()">注销账户</a></li>
            <li><a href="DoctorHome.jsp">主页面</a></li>
            <li><a href="DoctorInfo.jsp">个人信息</a></li>
            <li><a href="DeptReg">处理挂号</a></li>
        </ul>
    </div><br>
    <form action="DeptUpdate" method="post" onsubmit="return check(this)">
        <table style="text-align: left; width: 100%;" border="0">
            <tbody>
            <tr>
                <td style="background-color: rgb(219,201,92);">id</td>
                <td style="background-color: rgb(219,201,92);">名称</td>
                <td style="background-color: rgb(219,201,92);">类型</td>
                <td style="background-color: rgb(219,201,92);">简介</td>
                <td style="background-color: rgb(219,201,92);">地址</td>
            </tr>
            <tr>
                <td>
                    <input type="hidden" name="id" value="${sessionScope.doctorDept.id}">${sessionScope.doctorDept.id}
                </td>
                <td><input type="text" name="name" value="${sessionScope.doctorDept.name}" class="text"></td>
                <td>
                    <select name="type">
                        <option value="门诊类">门诊类</option>
                        <option value="住院类">住院类</option>
                    </select>
                </td>
                <td><input type="text" name="description" value="${sessionScope.doctorDept.description}" class="text"></td>
                <td><input type="text" name="address" value="${sessionScope.doctorDept.address}" class="text"></td>
            </tr>
            </tbody>
        </table>
        <button type="submit" class="operateButton">确认</button>
    </form>
</body>
</html>
