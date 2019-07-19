<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="avatar">
	<img alt="" src="/images/default_avatar.png" class="img-thumbnail">
	</div>
	<br/>
	<div>
	<div class="list-group">
	  <a href="/my/blogs" class="list-group-item ${param.module eq 'blogs' ? 'active' : ''}">我的文章<span class="badge">3</span> </a>
	  <a href="/my/blog/edit" class="list-group-item ${param.module eq 'blog' ? 'active' : ''}">发布文章</a>
	  <a href="/my/comments" class="list-group-item ${param.module eq 'comments' ? 'active' : ''}">我的评论</a>
	  <a href="/my/profile/avatar" class="list-group-item ${param.module eq 'avatar' ? 'active' : ''}">上传头像</a>
	  <a href="/my/profile" class="list-group-item ${param.module eq 'profile' ? 'active' : ''}">个人设置</a>
	</div>
</div>