,<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet" type="text/css" href="/libs/font-awesome/css/font-awesome.css">
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>豪哥博客</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" type="text/css" href="/libs/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="/css/blog.css"/>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style type="text/css">
    </style>
  </head>
  <body>
    <jsp:include page="/WEB-INF/inc/top.jsp"></jsp:include>
	
	<!-- 横幅 -->
	<div class="container">
		<div class="row">
			<div class="col-xs-12 banner">
			</div>
		</div>
	</div>
	
	<br/>
	<!-- 主体内容区 -->
	<div class="container">
		<div class="row">
			<div class="col-md-8">
				
				<!-- 文章 -->
				<h2 align="center">${blog.title}</h2>
				<div class="text-center">
					作者：${blog.author.nickname}&nbsp;&nbsp;&nbsp;&nbsp;
					浏览：${blog.hits}
					<input type="hidden" id="articleId" value="${blog.id }"
					<!--btn-success  -->
					 <a id="mir" class="btn btn-success" href="javascript:void(0)" style="color:#000;">
        				<span id="sctxt">收藏</span><i class="glyphicon glyphicon-align-left"></i>
    				 </a>
				</div>
				<hr/>
				<div class="content">
					${blog.content}
				</div>
				<div class="text-right">发布时间：<fmt:formatDate value="${blog.created}" pattern="yyyy-MM-dd HH:mm:ss"/></div>
				
				<hr/>
				
				<h4>最新评论</h4>
				<div class="comments" id="comments">
					<c:forEach items="${comments}" var="comment">
						<div class="media">
						  <div class="media-left">
						    <a href="#">
						      <img class="media-object" src="/images/default_avatar.png" style="max-height: 50px" alt="...">
						    </a>
						  </div>
						  <div class="media-body">
						    <h4 class="media-heading">${comment.author.nickname}：</h4>
						    <p>${comment.content}</p>
						    <p>评论时间：<fmt:formatDate value="${comment.diplayTime}" pattern="yyyy-MM-dd HH:mm:ss"/></p>
						  </div>
						</div>
					</c:forEach>
				</div>
				<div>
					<form id="comment" name="comment" method="post">
						<input type="hidden" name="blog.id" id="blogId" value="${ blog.id}"/>
						<textarea id="content" name="content" cols="3" class="form-control" placeholder="${_LOGIN_USER_.nickname}发表评论"></textarea>
						<button type="submit" class="btn btn-info btn-block">发表</button>
					</form>
				</div>
				<br/>
			</div>
			<div class="col-md-4">
				<div class="panel panel-default">
				  <div class="panel-heading">
				    <h3 class="panel-title">热门文章</h3>
				  </div>
				  <div class="panel-body">
				  	<c:forEach items="${hitBlogs}" var="blog">
					    <p><a href="/blog/${blog.id}">${blog.title}</a></p>
				  	</c:forEach>
				  </div>
				</div>
				
			</div>
		</div>
	</div>
	
	<jsp:include page="/WEB-INF/inc/footer.jsp"/>
	
	<script type="text/javascript">
	
		var authorNickname = "${_LOGIN_USER_.nickname}";
		
		var template = "<div class=\"media\">"
		  +"<div class=\"media-left\">"
		  +"<a href=\"#\">"
		  +"<img class=\"media-object\" src=\"/images/default_avatar.png\" style=\"max-height: 50px\" alt=\"...\">"
		  +"</a>"
		  +"</div>"
		  +"<div class=\"media-body\">"
		  +"<h4 class=\"media-heading\">${_LOGIN_USER_.nickname}：</h4>"
		  +"<p>{{comment_content}}</p>"
		  +"<p>评论时间："+new Date().toLocaleString()+"</p>"
		  +"</div>"
		  +"</div>";
		  
		$(document).ready(function(){
			if(authorNickname.length==0){
				$("#content").attr("disabled", "disabled").attr("placeholder", "请登录后发表评论");
			}
			
			$("#comment").submit(function(){
				var content = $("#content").val();
				//var blogId = $("#blogId").val();
				
				if(content.length==0){
					alert('请填写评论内容');
					return false;
				}
				
				//$(this).serialize():表单序列化
				$.ajax({
					//url:'/my/comment/' + '${blog.id}',
					url:'/comment/save',
					type:'post',
					data:$(this).serialize(),
					/* error: function(){alert('发表失败');}, */
					success:function(data){
						console.log(data);
						if(data.status){
							alert(data.msg);
							var comments = $("#comments").html();
							$("#comments").html(template.replace("{{comment_content}}", content) + comments);
							$("#content").val("");
						}else{
							alert(data.msg);
						}
					}
					
				});
				return false;
			});
			
             $("#mir").click(function(){
    			
				if(authorNickname.length==0){
					alert("请登录");
					return ;
				}
				
    			if($("#sctxt").html()=="收藏"){
    				
    				$.ajax({
        				
        				url:'/collect',
        				data:{"articleId":$("#articleId").val()},
        				dataType:'json',
        				type:'post',
        				success:function(data){
        					
        					if(data.status){
        						
        						$("#sctxt").html("取消收藏");
        						$("#mir").addClass("btn-danger");
        						$("#mir").removeClass("btn-success");
        						
        					}
        				}
        				
        			});
    			}else{
    				
    				$.ajax({
        				
        				url:'/del',
        				data:{"articleId":$("#articleId").val()},
        				dataType:'json',
        				type:'post',
        				success:function(data){
        					
        					if(data.status){
        						
        						$("#sctxt").html("收藏");
        						$("#mir").addClass("btn-success");
        						$("#mir").removeClass("btn-danger");
        						
        					}
        				}
        				
        			});
        			
    				
    			}
    			
    			
    			
    			
				
    		});
			
			
			
			
		});
	</script>
  </body>
</html>