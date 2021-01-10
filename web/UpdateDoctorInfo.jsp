<%--
  Created by IntelliJ IDEA.
  User: 陈昕
  Date: 2020/12/19
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改个人信息</title>
    <%response.setHeader("Cache-Control","no-store");%>
    <script type="text/javascript">
        function check(form){
            var name=form.name.value;
            var dept=form.dept_id.value;
            var sex=form.sex.value;
            if(name.length==0||sex.length==0||dept.length==0){
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
            <li><a href="DoctorInfo.jsp">退出修改</a></li>
            <li><a href="DoctorHome.jsp">主页面</a></li>
            <li><a href="UpdateDeptInfo.jsp">维护科室信息</a></li>
            <li><a href="DeptReg">处理挂号</a></li>
        </ul>
    </div><br>
    <form action="DoctorUpdate" method="post" onsubmit="return check(this)">
        <table style="text-align: left; width: 100%;" border="0">
            <tbody>
            <tr>
                <td style="background-color: rgb(219,201,92);">姓名</td>
                <td style="background-color: rgb(219,201,92);">性别</td>
                <td style="background-color: rgb(219,201,92);">科室</td>
            </tr>
            <tr>
                <td><input type="text" name="name" value="${sessionScope.doctor.name}" class="text"></td>
                <td><input type="radio" name="sex" value="男" checked>男
                    <input type="radio" name="sex" value="女" >女
                </td>
                <td>
                    <select name="dept_id">
                        <c:forEach var="deptList" items="${applicationScope.deptList}">
                            <option value="${deptList.id}">${deptList.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            </tbody>
        </table>
        <button type="submit" class="operateButton">保存</button>
    </form>
</body>
</html>
