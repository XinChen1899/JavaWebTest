<%--
  Created by IntelliJ IDEA.
  User: 陈昕
  Date: 2020/12/8
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>example_2020120805 传参数页面</title>
</head>
<body>
    <h4>该页面传递一个参数QQ，直线下是接收参数页面的内容</h4>
    <hr>
    <jsp:include page="example_2020120806.jsp">
        <jsp:param name="userName" value="QQ"/>
    </jsp:include>
</body>
</html>
