<%@page import="com.shenao.cms.metas.Gender"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>欢迎注册</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" type="text/css" href="/libs/bootstrap/css/bootstrap.min.css"/>
 	<link rel="stylesheet" type="text/css" href="/css/cms.css"/>
 
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style type="text/css">
    	.form-inline label{display: inline-block;}
    </style>
  </head>
  <body>
    <jsp:include page="/WEB-INF/inc/top.jsp"></jsp:include>
	
	<!-- 登录注册页面 -->
	<div style="height: 50px;"></div>
	
	<div class="container">
		<div class="row passport_bg">
			<div class="col-md-6">
				<div class="passport_panel">
					<div class="card">
					  <div class="card-header">欢迎注册</div>
					  <div class="card-body">
					    
					    <form:form modelAttribute="userForm" action="/reg" class="form-inline" method="post">
					    	<p class="w-100" align="center" class="red">${message}</p>
					    	<p class="w-100">　用户名：<form:input path="username" placeholder="请填写用户名" class="form-control"/></p>
					    	<p class="w-100">密　　码：<form:password path="password" placeholder="请填写密码" class="form-control"/></p>
					    	<p class="w-100">确认密码：<form:password path="rePassword" placeholder="重复密码" class="form-control"/></p>
					    	<p class="w-100">性　　别：<form:radiobuttons path="gender" items="<%=Gender.values()%>" itemLabel="description" itemValue="name" delimiter="&nbsp;&nbsp;"/>
					    	<p class="w-100">　　　　　<button type="submit" class="btn btn-info">开始注册</button></p>
				    		<p class="w-100" align="right">如果已有帐号，请<a href="/login">点这里登录</a></p>
					    </form:form>
					    
					  </div>
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<div class="passport_r">
					<h3>最新加入的用户：</h3>
					<p align="center">
					<img src="/images/guest.jpg" alt="..." class="rounded-circle img-thumbnail"/>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<img src="/images/guest1.jpg" alt="..." class="rounded-circle img-thumbnail"/>
					</p>
				</div>
			</div>
		</div>
	</div>
	<div><br/><br/></div>
	<jsp:include page="/WEB-INF/inc/footer.jsp"/>
	
	<script type="text/javascript">
		
	</script>
  </body>
</html>