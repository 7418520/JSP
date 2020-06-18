<%--
  Created by IntelliJ IDEA.
  User: 20714
  Date: 2020/5/31
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>JSP</title>
  </head>
  <body>
  <input name="in" type="text">
  <button type="submit" name="提交" action="index.jsp"></button>
  <%
    String s=request.getParameter("in");
    try{
      double t=Double.parseDouble(s);
    }catch (Exception e)
    {
        out.print("请输入合法数字");
    }


  %>12635
12345
  </body>
</html>
