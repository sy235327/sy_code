<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/3
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>默认页面</title>
</head>
<script>
    $(function(){
        <%
            response.sendRedirect(request.getContextPath()+"/product?method=index");
        %>
    })
</script>
<body>

</body>
</html>
