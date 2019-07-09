<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/css.css" rel="stylesheet">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">

	$(function(){
		
		$("#qx").toggle(function(){
			$("[type=checkbox]").attr("checked",true);
		},function(){
			$("[type=checkbox]").attr("checked",false);
		})
		
	})
	
	
	function ps(){
		
		var sid=$("[type=checkbox]").map(function(){
			return this.value;
		}).get().join()
		
		$.post("deleteAll.do",{sid:sid},function(msg){
			if(msg>0){
				alert("删除成功");
				location.href="list.do";
			}
		},"json")
		
	}
	
	
	function add(){
		
		location.href="add.jsp";
		
	}
	
</script>
</head>
<body>
<p>欢迎${user.uname }进入</p>
<form action="list.do" method="post">
	小于：<input type="text" name="Minprice">大于：<input type="text" name="Maxprice">
	根据名称查询：<input type="text" name="sname"><input type="submit" value="搜索">
</form>
<table>
	<tr>
		<td>
			<input type="button" value="全选/全不选" id="qx">
			<input type="button" value="批删" onclick="ps()">
		</td>
		<td>商品编号</td>
		<td>商品名称</td>
		<td>商品价格</td>
		<td>商品上架时间</td>
		<td>商品详情</td>
		<td>商品类型</td>
		<td>
			<input type="button" value="添加商品" onclick="add()">
		</td>
	</tr>
	<c:forEach items="${list }" var="s">
		<tr>
			<td>
				<input type="checkbox" value="${s.sid }">
			</td>
			<td>${s.sid }</td>
			<td>${s.sname }</td>
			<td>${s.price }</td>
			<td>${s.stime }</td>
			<td>${s.context }</td>
			<td>${s.tname }</td>
			<td>
				<input type="button" value="修改">
				<input type="button" value="删除">
			</td>
		</tr>
	</c:forEach>
	<tr>
		<td colspan="10">
			<a href="list.do?pageNum=1">首页</a>
			<a href="list.do?pageNum=${page == 1 ? 1: page-1}">上一页</a>
			<a href="list.do?pageNum=${page == pages ? pages: page+1}">下一页</a>
			<a href="list.do?pageNum=${pages}">尾页</a>
		</td>
	</tr>
</table>
</body>
</html>