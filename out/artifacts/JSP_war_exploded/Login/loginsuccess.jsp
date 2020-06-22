<%--
  Created by IntelliJ IDEA.
  User: 20714
  Date: 2020/6/22/0022
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="LI.Person" %>
<html>
<head>
    <title>欢迎</title>
</head>
<body>
<%  String username=request.getParameter("username");
    String password=request.getParameter("password");

    if(Person.login(username,password))
    {
        out.println("welcome "+username);
        session.setAttribute("name",username);//创建session 并向表中增加一行name(如果已经存在就会覆盖)

    }else{
        out.println("登陆失败");

    }

%>
</body>
</html>
