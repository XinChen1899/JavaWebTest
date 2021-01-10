<%--
  Created by IntelliJ IDEA.
  User: 陈昕
  Date: 2020/12/19
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>挂号处理</title>
    <%response.setHeader("Cache-Control","no-store");%>
    <script type="text/javascript">
        function onSearch(obj){
            var tableId=document.getElementById('reg_record');
            var rowsLength=tableId.rows.length;
            var date=obj.value;
            var searchCol=2;
            for(var i=1;i<rowsLength;i++){
                var result=tableId.rows[i].cells[searchCol].innerHTML;
                if(result.match(date)){
                    tableId.rows[i].style.display='';
                }
                else{
                    tableId.rows[i].style.display='none';
                }
            }
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
            <li><a href="UpdateDeptInfo.jsp">维护科室信息</a></li>
        </ul>
    </div><br>
    日期：<input type="date" name="date" oninput="onSearch(this)" class="text">
    <table style="text-align: left;width: 100%;" border="0" id="reg_record">
        <tbody>
        <tr>
            <td style="background-color: rgb(219,201,92)">单号</td>
            <td style="background-color: rgb(219,201,92)">科室</td>
            <td style="background-color: rgb(219,201,92)">日期</td>
            <td style="background-color: rgb(219,201,92)">操作</td>
        </tr>
        <c:forEach var="regList" items="${requestScope.regList}">
            <tr>
                <form action="AcceptReg" method="get">
                    <td><input type="hidden" name="reg_id" value="${regList.id}">${regList.id}</td>
                    <td>${regList.deptName}</td>
                    <td>${regList.regTime}</td>
                    <td><button type="submit" class="operateButton">受理</button></td>
                </form>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
