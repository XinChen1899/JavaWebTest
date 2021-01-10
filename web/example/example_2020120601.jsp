<%--
  Created by IntelliJ IDEA.
  User: 陈昕
  Date: 2020/12/6
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*" language="java" %>
<html>
<head>
    <title>example_2020120601</title>
</head>
<body>
    <%!int sum=0,x=1;%>
    <% while(x<=10) {
        sum += x;
        x++;
    }
    %>
    <h3>该程序的功能是计算1到10的累加和，并显示运行时间！</h3>
    <p> 1加到10的结果是: <%=sum%>                 </p>
    <p> 程序的运行日期是: <%=new Date()%>          </p>
</body>
</html>
