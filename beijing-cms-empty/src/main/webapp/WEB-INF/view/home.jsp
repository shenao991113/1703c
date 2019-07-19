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
    <title>CMS系统</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" type="text/css" href="/libs/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="/css/cms.css?v=1.1"/>

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
	
	<div><br/></div>
	<div class="container">
		<div class="row">
			<!-- 频道 -->
			<div class="col-md-2 ">	
				<ul class="list-group list-group-flush">
					<li class="list-group-item list-group-item-action text-center"><a class="channel active" href="/">热门</a></li>
					<c:forEach items="${_CHANNELS_AND_CATEGORIES_}" var="c">
					<li class="list-group-item list-group-item-action text-center"><a class="channel" href="/?channel=${c.key.id}">${c.key.name}</a></li>
					</c:forEach>
				</ul>
			</div>
			
			<!-- 主体区 -->
			<div class="col-md-7 split min_h_500">
				
				<!-- 分类 -->
				<c:choose>
					<c:when test="${channel != null}">
						<ul class="nav nav-tabs">
						<c:forEach items="${_CHANNELS_AND_CATEGORIES_}" var="c">
						<c:if test="${c.key eq channel}">
							<li class="nav-item"><a>  </a></li>
							<c:forEach items="${c.value}" var="cate">
							<li class="nav-item">
							    <a class="nav-link ${cate.id==category ? 'active' : ''}" href="/?channel=${c.key.id}&category=${cate.id}">${cate.name}</a>
							</li>
							</c:forEach>
						</c:if>
						</c:forEach>
					</ul>
					</c:when>
					<c:otherwise>
						<!-- 幻灯片 -->
						<c:if test="${not empty slides}">
						<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
						  <ol class="carousel-indicators">
						    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
						    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
						    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
						  </ol>
						  <div class="carousel-inner">
						  	<c:forEach items="${slides}" var="slide" varStatus="idx">
							    <div class="carousel-item ${idx.index==0 ? 'active' : ''}">
							      <img class="d-block w-100" src="${slide.picture}" alt="${slide.title}">
							      <div class="carousel-caption d-none d-md-block">
								    <h5><a href="${slide.url }">${slide.title}</a></h5>
								  </div>
							    </div>
						  	</c:forEach>
						  </div>
						  <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
						    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
						    <span class="sr-only">Previous</span>
						  </a>
						  <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
						    <span class="carousel-control-next-icon" aria-hidden="true"></span>
						    <span class="sr-only">Next</span>
						  </a>
						</div>
						</c:if>
					</c:otherwise>
				</c:choose>
				
				<br/>
				
				<!-- 文章 -->
				<c:forEach items="${articles}" var="article">
				<c:choose>
					<c:when test="${not empty article.picture}">
						<div class="media">
						  <div class="media-left">
						    <a href="#">
						      <img class="media-object" src="${article.picture}" width="120" alt="${article.title }">
						    </a>
						  </div>
						  <div class="media-body">
						    <h3 class="media-heading article_title"><a href="/article?id=${article.id}">${article.title }</a></h3>
						    <p>${article.summary}</p>
						    <p class="blog_item_footer">
						    	<span class="glyphicon glyphicon-user" title="作者"></span>作者：${article.author.nickname}&nbsp;&nbsp; &nbsp;
						    	<span class="glyphicon glyphicon-time" title="发布时间"></span>发布：&nbsp; <fmt:formatDate value="${article.updated}" pattern="yyyy-MM-dd HH:mm:ss"/>&nbsp;&nbsp;&nbsp;&nbsp;
						    	<span class="glyphicon glyphicon-eye-open" title="浏览量"></span>浏览量：&nbsp; ${article.hits}&nbsp;&nbsp;&nbsp;&nbsp;
						    </p>
						  </div>
						</div>
					</c:when>
					<c:otherwise>
						  <div>
						    <h3><a class="article_title" href="/blog/${article.id}">${article.title }</a></h3>
						    <p>${article.summary}</p>
						    <p class="blog_item_footer">
						    	<span class="glyphicon glyphicon-user" title="作者"></span>作者：${article.author.nickname}&nbsp;&nbsp;&nbsp;
						    	<span class="glyphicon glyphicon-time" title="发布时间"></span>发布：&nbsp; <fmt:formatDate value="${article.updated}" pattern="yyyy-MM-dd HH:mm:ss"/>&nbsp;&nbsp;&nbsp;&nbsp; 
						    	<span class="glyphicon glyphicon-eye-open" title="浏览量"></span>浏览量：&nbsp; ${article.hits}&nbsp;&nbsp;&nbsp;&nbsp;
						    </p>
						  </div>
					</c:otherwise>
				</c:choose>
				<hr/>
				</c:forEach>
			</div>
			
			<div class="col-md-3">
				<div class="card">
					<div class="card-header">最新文章</div>
					<div class="card-body">
						<ol>
							<c:forEach items="${lastArticles}" var="article">
							<li class="text-truncate"><a href="/article/${article.id}">${article.title}</a></li>
							</c:forEach>
						</ol>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<br/>
	
	<jsp:include page="/WEB-INF/inc/footer.jsp"/>
	
	<script type="text/javascript">
		
	</script>
  </body>
</html>