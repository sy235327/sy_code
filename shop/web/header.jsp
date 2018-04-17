<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript" src="./js/jquery-1.11.3.min.js"></script>
<!-- 登录 注册 购物车... -->
<div class="container-fluid">
	<div class="col-md-4">
		<img src="img/logo2.png" />
	</div>
	<div class="col-md-5">
		<img src="img/header.png" />
	</div>
	<div class="col-md-3" style="padding-top:20px">
		<ol class="list-inline">
			<li><a href="login.jsp">登录</a></li>
			<li><a href="register.jsp">注册</a></li>
			<li><a href="cart.jsp">购物车</a></li>
			<li><a href="order_list.jsp">我的订单</a></li>
		</ol>
	</div>
</div>

<!-- 导航条 -->
<div class="container-fluid">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">首页</a>
			</div>

			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav" id="categoryUL">

<%--				再其他页面加载时 不会访问servlet,就不会调用后端查询分类数据,解决办法使用ajax页面加载完毕后调用后端代码实现,直接再jsp中写java代码
					<c:forEach items="${categoryList}" var="categroy">
						<li><a href="#">${categroy.cname}</a></li>
					</c:forEach>--%>

				</ul>
				<form class="navbar-form navbar-right" role="search">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
			</div>
		</div>
		<script type="text/javascript">
			//header.jsp加载完毕后, 去服务器端获得所有的 分类数据
			$(function(){
				var content="";
				//ajax请求
				$.post(
						"${pageContext.request.contextPath}/product?method=cateGoryList",//ajax请求路径
						//由于没有请求参数所以忽略
						function(value){//回调函数
							//value: [{cid:"xxx","cname":"xxx"},{},{}]数据格式 json
							//动态创建<li><a href="#">${categroy.cname}</a></li>
							//遍历json中的对象
							for (var i=0;i<value.length;i++){
								content+="<li><a href='${pageContext.request.contextPath}/product?method=productList&cid="+value[i].cid+"'>"+value[i].cname+"</a></li>";
							}
							//将拼接好的li放入ul中
							$("#categoryUL").html(content);
						},
						"json"//数据格式
				);
			});
		</script>
	</nav>
</div>