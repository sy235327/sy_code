<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
主页面
<br/>
<a href="${pageContext.request.contextPath}/admin.jsp">后台管理</a>
<br/>
<a href="${pageContext.request.contextPath}/register.jsp">注册</a>
<a href="${pageContext.request.contextPath}/login.jsp">登陆</a>
<a href="${pageContext.request.contextPath}/choose.jsp">选课</a>
</body>
</html>