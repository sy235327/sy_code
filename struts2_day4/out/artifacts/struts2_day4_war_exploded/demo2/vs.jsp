<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/29 0029
  Time: 上午 2:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>vs</title>
</head>
<body>
<h3>从值栈中取值</h3>

    <%--
        push压栈取值 栈顶是一个对象
        取值栈中的值(root栈)
        value取值:
        [0]如果写[0]默认从root栈顶到结束,写[1]从root栈的第二个到结束...
        [0].top .top关键字取[x]的第一个对象

        取栈顶的值
        <s:property value="[0].top" />
    --%>

    <%--
        set压栈取值(map) 栈顶是一个map 集合
        拿到栈顶的map集合
            <s:property value="[0].top"/>
        拿到栈顶的map集合中的value值
            <s:property value="[0].top.key名称"/>
    --%>


    <%--
        栈顶放user对象 栈顶存储一个对象
        value="[0].top.javabena导航" [0].top取出栈顶对象使用javbean导航取值对象中的值
        <s:property value="[0].top.username" />
        <s:property value="[0].top.password" />
    --%>

    <%--
        [0].top关键字是可以省略的(默认从栈顶找) findValue()
            <s:property value="username" />
    --%>


    <%--
        获取栈顶中的中的map中的对象 栈顶存储的是一个map集合
        [0].top.key名  获取到一个map中key对应的值 获取到了对象
        [0].top.key名称.属性名称 获取到对象的值
        <s:property value="[0].top.user.username" />
        <s:property value="[0].top.user.password" />
    --%>

    <%--省略关键字,使用的是全域查找,先从栈顶向下找--%>
    <%--<s:property value="user.username" />--%>

    <%--
        取值 取栈中action对象的属性user(action会一起进栈,使用ognl表达式(快捷查找)对象.属性查找栈中对应的对象取值和封装)
        <s:property value="user.username" /> 从栈顶开始向下查找 查询到的是大桥未久
        <s:property value="[1].top.user.username" /> 这个是从栈中第二个开始向下查找 查询到的是一个action中的属性user对象的属性username
    --%>

    <%--
        push压栈 将list集合压入栈中
        <s:property value="[0].top[0].username" />
        <s:property value="[0].top[1].username" />
    --%>

    <%--
        set压栈 将map集合压入栈中 map集合中放的是一个list
         <s:property value="userList[0].username" />
    --%>

    <%--
        迭代标签
        属性
            begin 开启
            end   结束
            id    弃用。使用“var”代替
            var   迭代过程中,遍历的对象,可以写或者不写,
                编写上把迭代产生的对象默认压入到context栈中,从context栈中取值需要加#
                不编写默认把迭代产生对象压入到root栈中,从root栈中取值不需要#
            status 状态描述 每次迭代时将迭代器状态的instanceof推入堆栈
            step  如果指定了迭代索引，将在每次迭代中增加这个值
            value 要迭代的集合,需要从值栈中获取

        相当于增强for循环
        for(User user : userList){}

        <s:iterator value="userList" var="user" >
            获取context栈中的对象
            <s:property value="#user.username" />
            <s:property value="#user.password" />
        </s:iterator>
--%>

    <%--<s:iterator value="userList">
        &lt;%&ndash;获取root栈中的对象&ndash;%&gt;
        <s:property value="username" />
        <s:property value="password" />
    </s:iterator>--%>


    <%--从context栈中获取值,加#号
    <s:property value="#request.msg" />
    <s:property value="#session.msg" />--%>

    <%--获取get请求参数,parameters对象
    <s:property value="#parameters.id" />--%>

    <%--快捷查找,从最小域开始
    <s:property value="#attr.msg" />--%>


    <%--
        在JSP页面上可以使用EL和JSTL标签库来取值
        使用装饰者模式
        getAttribute()增强了 直接快速查找
    --%>
    <c:forEach items="${userList}" var="user">
        ${user.username}<br/>
        ${user.password}<br/>
    </c:forEach>

    <%--JSP页面上,查看值栈的内部结构--%>
    <s:debug></s:debug>
</body>
</html>
