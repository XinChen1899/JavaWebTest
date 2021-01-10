<%--
  Created by IntelliJ IDEA.
  User: 陈昕
  Date: 2020/12/8
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>example_2020120802</title>
</head>
<body>
    <h3>以直角三角形形式显示数字</h3>
    <%
        for(int i=1;i<10;i++)
        {
            for(int j=1;j<i;j++)
                out.print(j+" ");
            out.println("<br/>");
        }
    %>
    <hr>
    <h3>根据随机产生的数据的不同，显示不同的问候</h3>
    <%
        if(Math.random()<0.5){%>
            <p>have a <B>nice</B> day</p>
        <%}
    else{%>
            <p>have a <B>lousy</B> day</p>
        <%}%>
</body>
</html>
