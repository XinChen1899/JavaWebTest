<%--
  Created by IntelliJ IDEA.
  User: 陈昕
  Date: 2020/12/9
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>简单的网上试题自动评测——评测</title>
</head>
<body>
    <%String s1=request.getParameter("r1");
    if(s1!=null)
    {
        out.println("一、解答为2+3="+s1+" ");
        if(s1.equals("5"))
            out.println("正确!"+"<br>");
        else
            out.println("错误!"+"<br>");
    }else
        out.println("一、没有解答");
    out.println("----------------------------<br>");
    String[] s21=request.getParameterValues("c1");
    if(s21!=null){
        out.println("二、解答为：");
        for(int i=0;i<s21.length;i++){
            out.println(s21[i]+" ");
        }
        if(s21.length==2&&s21[0].equals("2")&&s21[1].equals("4"))
            out.println("正确"+"<br>");
        else
            out.println("错误"+"<br>");
    }else
        out.println("二、没有解答");
    out.println("------------------------------<br>");
    String[] s31=request.getParameterValues("list1");
    if(s31!=null){
        out.println("三、解答为：");
        for(int i=0;i<s31.length;i++)
        {
            out.println(s31[i]+' ');
        }
        if(s31.length==3&&s31[0].equals("asp")&&s31[1].equals("php")&&s31[2].equals("jsp"))
            out.println("正确"+"<br>");
        else
            out.println("错误"+"<br>");
    }
    else
        out.println("三、没有解答");
    out.println("-------------------------------<br>");
    String s4=request.getParameter("list5");
    if(s4!=null){
        out.println("四、解答为：");
        out.println(s4+" ");
        if(s4!=null&&s4.equals("servlet"))
            out.println("正确"+"<br>");
        else
            out.println("错误"+"<br>");
    }
    else
        out.println("四、没有解答");
    out.println("---------------------------------<br>");
    String s5=request.getParameter("text1");
    if(s5!=null)
    {
        out.println("五、解答为：");
        out.println(s5+" ");
        if(s5!=null&&s5.equals("request"))
            out.println("正确"+"<br>");
        else
            out.println("错误"+"<br>");
    }
    else
        out.println("五、没有解答");
    out.println("----------------------------------<br>");
    %>
</body>
</html>
