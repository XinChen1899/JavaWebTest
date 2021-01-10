<%@ page import="java.util.Enumeration" %><%--
  Created by IntelliJ IDEA.
  User: 陈昕
  Date: 2020/12/8
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>example_2020120808</title>
</head>
<body>
    <!---%request.setCharacterEncoding("UTF-8");
    String str1=request.getParameter("rdName");
    String str2=request.getParameter("phName");
    %>
    <p>您输入的信息是：</p><br>
    <p>姓名：<!%=str1%></p><br>
    <p>电话：<!%=str2%></p><br>---->
    <%String current_param="";
    String current_vaul="";
    request.setCharacterEncoding("UTF-8");
    Enumeration params=request.getParameterNames();
    while(params.hasMoreElements()){
        current_param=(String)params.nextElement();
        current_vaul=request.getParameter(current_param);
        %>参数名称：<%=current_param%>参数值：<%=current_vaul%><br>
    <%}%>
</body>
</html>
