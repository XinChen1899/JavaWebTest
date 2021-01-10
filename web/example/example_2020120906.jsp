<%--
  Created by IntelliJ IDEA.
  User: 陈昕
  Date: 2020/12/10
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>显示购物车购物信息</title>
</head>
<body>
    你的选择是：<br>
    <%request.setCharacterEncoding("UTF-8");
    String str="";
    if(session.getAttribute("s1")!=null){
        str=(String)session.getAttribute("s1");
        out.println(str+"<br>");
    }
    if(session.getAttribute("s2")!=null){
        str=(String)session.getAttribute("s2");
        out.println(str+"<br>");
    }
    if(session.getAttribute("s3")!=null){
        str=(String)session.getAttribute("s3");
        out.println(str+"<br>");
    }
    if(session.getAttribute("s4")!=null){
        str=(String)session.getAttribute("s4");
        out.println(str+"<br>");
    }
    if(session.getAttribute("s5")!=null){
        str=(String)session.getAttribute("s5");
        out.println(str+"<br>");
    }
    if(session.getAttribute("s6")!=null){
        str=(String)session.getAttribute("s6");
        out.println(str+"<br>");
    }
    %>
</body>
</html>
