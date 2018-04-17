<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/30 0030
  Time: 下午 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>编写表单</title>
</head>
<body>
  <h3>%</h3>
    <form action="" method="port">
        性别<input type="radio" name="sex" value="男"/>男
        <input type="radio" name="sex" value="女"/>女
    </form>

    <h3>使用UI标签方式</h3>
    <s:form action="" method="post">
        <%--性别<s:radio name="sex" list="{'男','女'}" /> 如果value和显示的值一致可以使用这个写法--%>

        <%--如果value和展示的值不一致可以使用下面的方式,#号在struts2中有两个作用,一个取值,还有一个创建一个map集合--%>
        <s:radio name="sex" list="#{'1':'男','2':'女'}" />
    </s:form>

    <%--使用百分号解析字符串--%>
    <s:property value="%[0].top.user.username" />
    <s:property value="%user.username" />
    <s:property value="'user.username'" />
</body>
</html>
