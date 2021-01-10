<%--
  Created by IntelliJ IDEA.
  User: 陈昕
  Date: 2020/12/8
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>example_2020120806 接收参数页面</title>
</head>
<body>
    接收参数，并显示结果页面<br/>
    <%String str=request.getParameter("userName");%>
    <p><%=str%>你好，欢迎你访问</p>
</body>
</html>
