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
		
		$.post("findType.do",function(msg){
			
			ms=msg.list;
			for(var i in ms){
				$("[name=tid]").append("<option value="+ms[i].tid+">"+ms[i].tname+"</option>")
			}
			
		},"json")
		
	})
	
	function addOne(){
		
		$.post("addOne.do",$("form").serialize(),function(msg){
			if(msg>0){
				alert("添加成功");
				location.href="list.do";
			}
		},"json")
		
	}
	
</script>
</head>
<body>
<form>
	<table>
		<tr>
			<td>
				商品名称：<input type="text" name="sname">
			</td>
		</tr>
		<tr>
			<td>
				商品价格：<input type="text" name="price">
			</td>
		</tr>
		<tr>
			<td>
				商品上架时间：<input type="date" name="stime">
			</td>
		</tr>
		<tr>
			<td>
				商品介绍：<input type="text" name="context">
			</td>
		</tr>
		<tr>
			<td>
				商品类型：<select name="tid">
					
				</select>
			</td>
		</tr>
		<tr>
			<td>
				<input type="button" value="添加" onclick="addOne()">
			</td>
		</tr>
	</table>
</form>
</body>
</html>