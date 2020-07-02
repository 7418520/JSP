<%--
  Created by IntelliJ IDEA.
  User: 20714
  Date: 2020/7/2/0002
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.*" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <form method="post" action="<%=request.getContextPath()%>/login.htm">
        <card>
            用户名：<input type="text" name="username"><br>
            密码 ： <input type="password" name="password"><br>
            <button type="submit">登录</button><br>
            <a href="register.html">没有账号，立即注册</a></card>
    </form>
</div>
</body>
</html>
