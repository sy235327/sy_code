<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/26 0026
  Time: 上午 2:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SUCCESS</title>
</head>
<body>
    <h2>获取域对象中的值(完全解耦合的方式)</h2>

    <h5>request中的</h5>
     <%=request.getAttribute("msg")%>

    <h5>session中的</h5>
    <%=request.getSession().getAttribute("msg")%>

    <h5>session中的</h5>
    <%=request.getServletContext().getAttribute("msg")%>
</body>
</html>
