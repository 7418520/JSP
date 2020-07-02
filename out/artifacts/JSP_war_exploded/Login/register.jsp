<%@ page import="java.util.*" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <title>注册</title>
</head>
<body>
<div align="center">
    <form method="post" action="<%=request.getContextPath()%>/register.htm">
        用户名：<input type="text" name="username"><br>
        密码 ：<input type="password" name="password"><br>
        <button type="submit">注册</button>
        <a href="login.jsp">请登录</a>
    </form></div>
</body>
</html>