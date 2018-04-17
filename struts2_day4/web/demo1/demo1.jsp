<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/28 0028
  Time: 上午 2:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入struts2标签库--%>
<%@taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>条件:加入值栈中已经存入值了,在jsp页面上从值栈中获取值</h3>
<%--
    1.先引入struts2框架中提供的标签库.s标签
    2.可以使用提供的标签(掌握重点标签)
--%>

<%--从值栈中获取值<s:property value="ognl表达式"> value属性中标签就是ognl表达式--%>
<s:property value="'username'.length()"/>
</body>
</html>
