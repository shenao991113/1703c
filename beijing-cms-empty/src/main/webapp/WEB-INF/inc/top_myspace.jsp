<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="/">
      	<img alt="" src="/images/logo.png">
	  </a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="/">首页 <span class="sr-only">(current)</span></a></li>
        <c:forEach items="${__CATEGORIES__}" var="category">
	        <li><a href="/channel/${category.id}">${category.name}</a></li>
        </c:forEach>
      </ul>
      <form class="navbar-form navbar-left">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">搜索</button>
      </form>
      <ul class="nav navbar-nav navbar-right">
      	<c:choose>
      		<c:when test="${_LOGIN_USER_  != null}">
      			<li class="dropdown">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${_LOGIN_USER_.nickname}<span class="caret"></span></a>
		          <ul class="dropdown-menu">
		            <li><a href="/my/home">个人主页</a></li>
		            <li><a href="/my/profile">个人设置</a></li>
		            <li><a href="/my/blogs">我的博客</a></li>
		            <li role="separator" class="divider"></li>
		            <li><a href="/logout">退出</a></li>
		          </ul>
		        </li>
      		</c:when>
      		<c:otherwise>
		        <li><a href="/reg">注册</a></li>
		        <li><a href="/login">登录</a></li>
      		</c:otherwise>
      	</c:choose>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>