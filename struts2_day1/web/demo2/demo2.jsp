<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/25 0025
  Time: 上午 12:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>demo2</title>
</head>
<body>
    <h1>传统的配置文件方式</h1>
    <a href="${pageContext.request.contextPath}/save.action">保存客户</a>
    <a href="${pageContext.request.contextPath}/delete.action">删除客户</a>

    <h1>通配符的配置文件方式</h1>
    <a href="${pageContext.request.contextPath}/linkman_save.action">保存联系人</a>
    <a href="${pageContext.request.contextPath}/linkman_delete.action">删除联系人</a>

    <%--
        动态方法访问
        路径写法: action配置路径!函数名称.action
        需要在配置中开启一个常量
        在struts.xml中配置
        <constant name="struts.enable.DynamicMethodInvocation" value="true" />
    --%>
    <h2>动态方法访问的方式</h2>
    <a href="${pageContext.request.contextPath}/user!save.action">保存客户</a>
    <a href="${pageContext.request.contextPath}/user!delete.action">删除客户</a>
</body>
</html>
