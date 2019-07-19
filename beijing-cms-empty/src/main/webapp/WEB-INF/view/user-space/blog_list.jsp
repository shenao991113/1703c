<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>我的博客</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" type="text/css" href="/libs/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="/css/cms.css"/>

    <style type="text/css">
    </style>
  </head>
  <body>
    <jsp:include page="/WEB-INF/inc/top.jsp"></jsp:include>
	<!-- 横幅 -->
	<div class="container">
		<div class="row">
			<div class="col-xs-12 my_banner">
			</div>
		</div>
	</div>
	<br/>
	<!-- 主体内容区 -->
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<jsp:include page="/WEB-INF/inc/my_left.jsp">
					<jsp:param value="blogs" name="module"/>
				</jsp:include>
			</div>
			<div class="col-md-9">
				<div class="panel panel-default">
				  <div class="panel-body">
				    	<h1>我的博客</h1>
				    	<hr/>
				    	<table class="table table-striped table-bordered table-hover">
				    		<thead>
				    			<tr class="info">
				    				<th>标题</th>
				    				<th>分类</th>
				    				<th>点击量</th>
				    				<th>评论数</th>
				    				<th>时间</th>
				    				<th>操作</th>
				    			</tr>
				    		</thead>
				    		<tbody class="">
				    		<c:forEach items="${blogs}" var="blog">
				    			<tr id="item_${blog.id}">
				    				<td>${blog.title}</td>
				    				<td>${blog.category.name}</td>
				    				<td>${blog.hits}</td>
				    				<td></td>
				    				<td><fmt:formatDate value="${blog.updated}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				    				<td><a class="btn btn-primary" href="/my/blog/edit?id=${blog.id}" title="编辑"><span class="glyphicon glyphicon-edit">编辑</span></a>&nbsp;&nbsp;
				    				<a class="btn btn-success" onclick="removeBlog(${blog.id});" title="删除"><span class="glyphicon glyphicon-remove">删除</span></a></td>
				    			</tr>
				    		</c:forEach>
				    		</tbody>
				    	</table>
				    	${pageList}
				  </div>
				</div>
			</div>
		</div>
	</div>
	
	<jsp:include page="/WEB-INF/inc/footer.jsp"/>
	
	<script type="text/javascript">
		function removeBlog(id){
			if(confirm("您是否要删除这篇博客？")){
				$.ajax({
					url:'/my/blog/remove?id=' + id,
					type:'get',
					success:function(data){
						/* if(data.status){
							$("#item_" + id).remove();
						}else{
							alert(data.message);
						} */
					}
				});
			}
			return false;
		}
	</script>
  </body>
</html>