<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 陈昕
  Date: 2020/12/9
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>example_2020120901</title>
</head>
<body>
    <hr>
    session的创建时间是：<%=new Date(session.getCreationTime())%><br>
    session的ID号：<%=session.getId()%><br>
    客户最近一次访问时间是：
    <%=new java.sql.Time(session.getLastAccessedTime())%><br>
    两次请求间隔多长时间session将被取消(ms)：
    <%=session.getMaxInactiveInterval()%><br>
    是否是新创建的session：<%=session.isNew()?"是":"否"%>
    <hr>
</body>
</html>
