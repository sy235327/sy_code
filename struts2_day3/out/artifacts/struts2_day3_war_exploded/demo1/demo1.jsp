<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/26 0026
  Time: 上午 1:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>demo1</title>
</head>
<body>
<h2>演示Servlet的API的第一种方式(完全解耦合的方式)</h2>

<form action="${ pageContext.request.contextPath }/demo1Action.action" method="post">
    名称:<input type="text" name="name"><br/>
    年龄:<input type="text" name="age"><br/>
    <input type="submit" value="提交">
</form>


<h2>使用ServletActionContext类方法</h2>

<form action="${ pageContext.request.contextPath }/demo2Action.action" method="post">
    名称:<input type="text" name="name"><br/>
    年龄:<input type="text" name="age"><br/>
    <input type="submit" value="提交">
</form>
</body>
</html>
