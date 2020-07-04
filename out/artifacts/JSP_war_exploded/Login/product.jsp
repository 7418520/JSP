<%@ page import="java.util.*" language="java" pageEncoding="UTF-8" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="LI.product" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>商品</title>
</head>
<body>
<div align="center">
<table border="1">
    <tr>
        <th>名称</th>
        <th>数量</th>
        <th>价格</th>
    </tr>
    <tr>
        <form action="<%=request.getContextPath()%>/produc.htm" method="post">
            <td><input value="apple" name="product" readonly></td>
            <td><input value="1" name="num" readonly></td>
            <td><input value="2" name="price" readonly></td>
            <td>
                <button class="btn btn-info" type="submit">购买</button>
            </td>
        </form>
    </tr>
    <tr>
        <form action="<%=request.getContextPath()%>/produc.htm" method="post">
            <td><input value="banana" name="product" readonly></td>
            <td><input value="1" name="num" readonly></td>
            <td><input value="2" name="price" readonly></td>
            <td>
                <button class="btn btn-info" type="submit">购买</button>
            </td>
        </form>
    </tr>
</table>
<div align="centet">购物车</div>
<%
    ResultSet re = product.product();
    out.print("<table border=\"1\">");
    out.print("<tr>");
    out.print("<th>名称</th>");
    out.print("<th>数量</th>");
    out.print("<th>价格</th>");
    out.print("</tr>");
    double sum=0;
    while (re.next()) {

        int num=Integer.parseInt(re.getString("num"));
        double price=Double.parseDouble(re.getString("price"));
        sum+=num*price;
        out.print("<tr>");
        out.print("<td> <input value=" + re.getString("name") + "></td>");
        out.print("<td><input value=" + re.getString("num") + "></td>");
        out.print("<td><input value=" + re.getString("price") + "></td>");
        out.print("</tr>");
    }
    out.print("<tr>");
    out.print("<td>总价</td>");
    out.print("<td>"+sum+"</td>");
    out.print("</tr>");
    out.print("</table>");
%>
    <a href="/del.htm">清空购物车</a>
</div>
</body>
</html>
