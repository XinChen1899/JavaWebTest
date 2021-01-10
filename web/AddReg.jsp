<%--
  Created by IntelliJ IDEA.
  User: 陈昕
  Date: 2020/12/15
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>挂号</title>
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
            <li><a href="PatientHome.jsp">主页面</a></li>
            <li><a href="PatientInfo.jsp">个人信息</a></li>
            <li><a href="https://www.acmilan.com/en">关于我们</a></li>
        </ul>
    </div>
    <h2>您的挂号记录</h2>
    <table style="text-align: left;width: 100%;" border="0">
        <tbody>
            <tr>
                <td style="background-color: rgb(56,200,125)">单号</td>
                <td style="background-color: rgb(56,200,125)">科室</td>
                <td style="background-color: rgb(56,200,125)">日期</td>
                <td style="background-color: rgb(56,200,125)">是否受理</td>
            </tr>
            <c:forEach var="regList" items="${requestScope.regList}">
                <tr>
                    <td>${regList.id}</td>
                    <td>${regList.deptName}</td>
                    <td>${regList.regTime}</td>
                    <td>${regList.accept}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <h2>所有科室名单</h2>
    <table style="text-align: left;width: 100%;" border="0">
        <tbody>
            <tr>
                <td style="background-color: rgb(41,145,151)">id</td>
                <td style="background-color: rgb(41,145,151)">名称</td>
                <td style="background-color: rgb(41,145,151)">类型</td>
                <td style="background-color: rgb(41,145,151)">描述</td>
                <td style="background-color: rgb(41,145,151)">地址</td>
            </tr>
            <c:forEach var="deptList" items="${applicationScope.deptList}">
                <tr>
                    <td>${deptList.id}</td>
                    <td>${deptList.name}</td>
                    <td>${deptList.type}</td>
                    <td>${deptList.description}</td>
                    <td>${deptList.address}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <hr>
    <h2>挂号</h2>
    <form action="AddReg" method=post>
        <table style="text-align: left;width: 100%;" border="0">
            <tbody>
            <tr>
                <td style="background-color: rgb(255,196,52)">科室id</td>
                <td style="background-color: rgb(255,198,62)">日期</td>
            </tr>
            <tr>
                <td>
                    <select name="deptid">
                        <c:forEach var="deptList" items="${applicationScope.deptList}">
                            <option value="${deptList.id}">${deptList.name}</option>
                        </c:forEach>
                    </select>
                </td>
                <td><input type="date" name="date" class="text"></td>
            </tr>
            </tbody>
        </table>
        <button type="submit" value="确定" class="operateButton">确认</button>
    </form>
</body>
</html>
