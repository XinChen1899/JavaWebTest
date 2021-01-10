<%--
  Created by IntelliJ IDEA.
  User: 陈昕
  Date: 2020/12/9
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*"%>
<html>
<head>
    <title>简单的网上试题自动评测——试题</title>
</head>
<body>
    <form action="example_2020120903.jsp" mothod="post">
        一、2+3=？<br>
        <input type="radio" name="r1" value="2" checked="checked">2&nbsp;
        <input type="radio" name="r1" value="3">3&nbsp;&nbsp;
        <input type="radio" name="r1" value="4">4&nbsp;
        <input type="radio" name="r1" value="5">5<br>
        二、下列哪些数是偶数？<br>
        <input type="checkbox" name="c1" value="2">2&nbsp;
        <input type="checkbox" name="c1" value="3">3&nbsp;
        <input type="checkbox" name="c1" value="4">4&nbsp;
        <input type="checkbox" name="c1" value="5">5<br>
        三、下列哪些是动态网页？<br>
        <select size="4" name="list1" multiple="multiple">
            <option value="asp">ASP</option>
            <option value="php">PHP</option>
            <option value="HTML">HTML</option>
            <option value="jsp">JSP</option>
            <option value="xyz" selected="selected">xyz</option>
        </select>
        四、下列哪个组件是服务器端的？<br>
        <select size="1" name="list5">
            <option value="jsp">JSP</option>
            <option value="servlet">Servlet</option>
            <option value="java">JAVA</option>
            <option value="jdbc">JDBC</option>
        </select>
        五、在服务器端用来接收用户请求的对象是：
        <input type="text" size="20" name="text1"><br>
        <div align="left">
            <blockquote>
                <input type="submit" value="提交" name="button1">
                <input type="submit" value="重置" name="button2">
            </blockquote>
        </div>
    </form>
</body>
</html>
