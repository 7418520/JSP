<%--
  Created by IntelliJ IDEA.
  User: 20714
  Date: 2020/7/2/0002
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.*" language="java" pageEncoding="UTF-8" %>

<!DOCTYPE HTML>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0, initial-scale=1.0, user-scalable=no">
    <!-- 引入 FrozenUI -->
    <title>欢迎登录</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div align="center">
    <form method="post" action="<%=request.getContextPath()%>/update.htm">
        <card>
            密码 ： <input type="password" name="password"><br>
            <button class="btn btn-info">确认</button>
           </card>
    </form>
</div>
</body>
</html>
