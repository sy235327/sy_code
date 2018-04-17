<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/27 0027
  Time: 上午 12:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>属性驱动的方式1</h2>
<form action="${ pageContext.request.contextPath }/regist1.action" method="post">
    名称:<input type="text" name="username"><br/>
    密码:<input type="text" name="password"><br/>
    年龄:<input type="text" name="age"><br/>
    <input type="submit" value="注册">
</form>

<h2>属性驱动的方式2(把数据封装到JavaBean的对象中)</h2>
<%--注意一: 页面的编写规则,发生了变化,使用OGNL表达式的写法  对象名称.属性  javabean导航类似--%>
<form action="${ pageContext.request.contextPath }/regist2.action" method="post">
    名称:<input type="text" name="user.username"><br/>
    密码:<input type="text" name="user.password"><br/>
    年龄:<input type="text" name="user.age"><br/>
    <input type="submit" value="注册">
</form>


<h2>模型驱动方式</h2>
<form action="${ pageContext.request.contextPath }/regist3.action" method="post">
    名称:<input type="text" name="username"><br/>
    密码:<input type="text" name="password"><br/>
    年龄:<input type="text" name="age"><br/>
    <input type="submit" value="注册">
</form>


<h2>向List集合封装数据(默认使用,属性驱动的方式)</h2>
<%--后台: List<User> list 在action中提供List集合属性和set,get方法前端使用OGNL表达式--%>
<form action="${ pageContext.request.contextPath }/regist4.action" method="post">
    名称:<input type="text" name="list[0].username"><br/>
    密码:<input type="text" name="list[0].password"><br/>
    年龄:<input type="text" name="list[0].age"><br/>

    名称:<input type="text" name="list[1].username"><br/>
    密码:<input type="text" name="list[1].password"><br/>
    年龄:<input type="text" name="list[1].age"><br/>
    <input type="submit" value="注册">
</form>


<h2>向Map集合封装数据(默认使用,属性驱动的方式)</h2>
<%--后台: Map<User> map 在action中提供Map集合属性和set,get方法前端使用OGNL表达式 Map.set(key,value) key在前端设置--%>
<form action="${ pageContext.request.contextPath }/regist5.action" method="post">
    名称:<input type="text" name="map['one'].username"><br/>
    密码:<input type="text" name="map['one'].password"><br/>
    年龄:<input type="text" name="map['one'].age"><br/>

    名称:<input type="text" name="map['two'].username"><br/>
    密码:<input type="text" name="map['two'].password"><br/>
    年龄:<input type="text" name="map['two'].age"><br/>
    <input type="submit" value="注册">
</form>
</body>
</html>
