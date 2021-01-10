<%--
  Created by IntelliJ IDEA.
  User: 陈昕
  Date: 2020/12/9
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物肉类商品页面</title>
</head>
<body>
    <%request.setCharacterEncoding("UTF-8");
    if(request.getParameter("c1")!=null)
        session.setAttribute("s1",request.getParameter("c1"));
    if(request.getParameter("c2")!=null)
        session.setAttribute("s2",request.getParameter("c2"));
    if(request.getParameter("c3")!=null)
        session.setAttribute("s3",request.getParameter("c3"));
    %>
    各种肉类大甩卖，一律十块：<br>
    <form action="example_2020120904.jsp" method="post">
        <p>
            <input type="checkbox" name="c1" value="猪肉">猪肉&nbsp;
            <input type="checkbox" name="c2" value="牛肉">牛肉&nbsp;
            <input type="checkbox" name="c3" value="羊肉">羊肉
        </p>
        <p>
            <input type="submit" value="提交" name="B1">
            <a href="example_2020120905.jsp">买点别的</a>&nbsp;
            <a href="example_2020120906.jsp">购物车</a>&nbsp;
        </p>
    </form>
</body>
</html>
