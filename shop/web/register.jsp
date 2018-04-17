<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head></head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>会员注册</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="js/jquery.validate.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="css/style.css" type="text/css" />

<style>
body {
	margin-top: 20px;
	margin: 0 auto;
}

.carousel-inner .item img {
	width: 100%;
	height: 300px;
}

font {
	color: #3164af;
	font-size: 18px;
	font-weight: normal;
	padding: 0 10px;
}

.error {
	color:red;
}
</style>

<script type="text/javascript">
	//自定义校验规则 , 完成vaildate和ajax结合校验
	$.validator.addMethod(
			//规则名称
			"checkUsername",
			//校验的函数
			function(value,element,params){
				//value: (用户输入给username属性元素的值)输入的内容
				//element: 被校验的元素对象
				//params: 规则对应的参数值

				//接受后端查询结果,判断校验是否成功
				var isExist = false;
				//目的: 对输入的username进行ajax校验
				$.ajax({
					"async":false,//是否异步,由于异步相当于开启一个新线程,所以在校验函数中返回的值,回接受不到ajax从后端查询到的结果,就返回需要开启同步
					"url":"${pageContext.request.contextPath}/user?method=checkUsername",
					"data":{"username":value},//传输的数据
					"type":"post",//请求方式
					"dataType":"json",//指定传输的数据格式 json格式
					//请求成功后,回调函数
					"success":function(date){
						//后端查询结果,
						isExist = date.isExist;
					},
				});

				//返回false代表该校验器没有通过,触发错误信息
				return isExist;
			}
	);

	//使用vaildate完成前端表单校验(类似java中的正则表达式)
	$(function(){
		$("#myform").validate({
			//给表单中指定的属性元素添加规则
			rules:{
				"username":{
					"required":true,
					//自定义校验规则
					"checkUsername":true
				},
				"password":{
					"required":true,
					"rangelength":[6,12]
				},
				"repassword":{
					"required":true,
					"rangelength":[6,12],
					"equalTo": "#inputPassword3"
				},
				"email":{
					"required":true,
					"email":true
				},
				"name":{
					"required":true,
				},
				"sex":{
					"required":true
				}
			},
			//设置触发规则给予的提示
			messages:{
				username:{
					"required":"用户名不能为空",
					"checkUsername":"用户名已存在"
				},
				password:{
					"required":"密码不能为空",
					"rangelength":"密码长度6~12位"
				},
				repassword:{
					"required":"密码不能为空",
					"rangelength":"密码长度6~12位",
					"equalTo":"两次密码不一致"
				},
				email:{
					"required":"邮箱不能为空",
					"email":"邮箱格式不正确"
				},
				name:{
					"required":"名字不能为空"
				},
				sex:{
					//在sex中设置了错误信息, 触发正则表达式后先查询指定name属性元素旁有没有和指定隐藏的name属性值一致的错误信息,如果有取消隐藏
					"required":"你确定要选择第三种选择么"
				}
			}
		})

		var code = ${msg};
		if (code==1){
			//将错误信息展示
			$("#errorcode").attr("style","display:inline")
			//重新刷新验证码
		}
	})
</script>

</head>
<body>

	<!-- 引入header.jsp -->
	<jsp:include page="/header.jsp"></jsp:include>

	<div class="container"
		style="width: 100%; background: url('image/regist_bg.jpg');">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8"
				style="background: #fff; padding: 40px 80px; margin: 30px; border: 7px solid #ccc;">
				<font>会员注册</font>USER REGISTER
				<form id="myform" class="form-horizontal" action="${pageContext.request.contextPath}/user?method=register" method="post" style="margin-top: 5px;">
					<div class="form-group">
						<label for="username" class="col-sm-2 control-label">用户名</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="username" name="username"
								placeholder="请输入用户名">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
						<div class="col-sm-6">
							<input type="password" class="form-control" id="inputPassword3" name="password"
								placeholder="请输入密码">
						</div>
					</div>
					<div class="form-group">
						<label for="confirmpwd" class="col-sm-2 control-label">确认密码</label>
						<div class="col-sm-6">
							<input type="password" class="form-control" id="confirmpwd" name="repassword"
								placeholder="请输入确认密码">
						</div>
					</div>
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">Email</label>
						<div class="col-sm-6">
							<input type="email" class="form-control" id="inputEmail3" name="email"
								placeholder="Email">
						</div>
					</div>
					<div class="form-group">
						<label for="usercaption" class="col-sm-2 control-label">姓名</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="usercaption" name="name"
								placeholder="请输入姓名">
						</div>
					</div>
					<div class="form-group opt">
						<label for="inlineRadio1" class="col-sm-2 control-label">性别</label>
						<div class="col-sm-6">
							<label class="radio-inline">
								<input type="radio" name="sex" id="sex1" value="male">
								男
							</label> <label class="radio-inline">
								<input type="radio" name="sex" id="sex2" value="female">
								女
							</label>
							<%--vaildate 设置sex的错误信息,隐藏 在触发正则表达式后 取消隐藏(如果没有设置错误信息,那就会调用messges中的错误信息)--%>
							<label class="error" for="sex" style="display:none">你确定要选择第三种选择么</label>
						</div>
					</div>
					<div class="form-group">
						<label for="date" class="col-sm-2 control-label">出生日期</label>
						<div class="col-sm-6">
							<input type="date" class="form-control" name="birthday">
						</div>
					</div>

					<div class="form-group">
						<label for="date" class="col-sm-2 control-label">验证码</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" name="checkCode">

						</div>
						<div class="col-sm-2">
							<img id="codeimg" src="${pageContext.request.contextPath }/user?method=code"/>&nabla;
							<h5 id="errorcode" class="error" style="display:none">验证码错误</h5>
						</div>

					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<input type="submit" width="100" value="注册" name="submit"
								style="background: url('./images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0); height: 35px; width: 100px; color: white;">
						</div>
					</div>
				</form>
			</div>

			<div class="col-md-2"></div>

		</div>
	</div>

	<!-- 引入footer.jsp -->
	<jsp:include page="/footer.jsp"></jsp:include>

</body>
</html>




