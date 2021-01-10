<%--
  Created by IntelliJ IDEA.
  User: 陈昕
  Date: 2020/12/8
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*" language="java" %>
<html>
<head>
    <title>example_2020120804 include实例</title>
</head>
<body>
    <p>现在的日期和时间是：<%=new Date()%></p>
    <hr>
    <%@include file="example_2020120803.jsp"%>
</body>
</html>
