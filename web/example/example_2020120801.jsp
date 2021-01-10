<%--
  Created by IntelliJ IDEA.
  User: 陈昕
  Date: 2020/12/8
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>example_2020120801</title>
</head>
<body>
    <%!
        long fact(int y){
            if(y==0)
                return 1;
            else
                return y*y;
        }
    %>
    <h1>y=3时的fact值</h1>
    <p><%=fact(3)%></p>
</body>
</html>
