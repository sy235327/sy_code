<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/28 0028
  Time: 上午 1:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
    for(int i=0;i<2;i++){
    out.println("?");
    PrintWriter w=response.getWriter();
    w.println("*");
    w.println("*");
    w.close();
  }
  %>
  </body>
</html>
