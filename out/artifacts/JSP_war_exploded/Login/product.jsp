<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: 20714
  Date: 2020/6/30/0030
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="LI.product" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String name=request.getParameter("product");
    String num=request.getParameter("num");
    String price=request.getParameter("price");
    out.print(name);
    out.print(num);
    out.print(price);
    product.productlict(name,num,price);
product.print();
%>
</body>
</html>
