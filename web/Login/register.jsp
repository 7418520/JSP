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
    if(Person.register(username,password))
    {
        out.print("注册成功");
    }else
    {
        response.sendRedirect("register.html");
    }
%>
</body>
</html>
