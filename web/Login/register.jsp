<%--
  Created by IntelliJ IDEA.
  User: 20714
  Date: 2020/6/22/0022
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="LI.Person" %>
<html>
<head>
    <title>欢迎注册</title>
</head>
<body>
<%
    String username=request.getParameter("username");
    String password=request.getParameter("password");
   try{if(Person.register(username,password))
    {
        out.print("注册成功");
        out.print("<a href='login.html'>登录</a>");
    }else
    {
        out.print("用户名已存在，请重新注册");
        out.print("<a href='register.html'>重新注册</a>");
    }}catch (Exception e)
   {

   }
%>
</body>
</html>
