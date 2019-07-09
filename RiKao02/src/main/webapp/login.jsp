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

	function denglu(){
		
		var check=true;
		
		var uname=$("[name=uname]").val()
		
		var upwd=$("[name=upwd]").val();
		
		if(uname == ''){
			check=false;
			alert("用户名不能为空")
		}
		if(upwd == ''){
			check=false;
			alert("密码不能为空")
		}
		
		if(check){
			
			$.post("login.do",$("form").serialize(),function(date){
				if(date.status==0){
					alert(date.msg);
					location.href="list.do";
				}else if(date.status==1){
					alert(date.msg);
				}else if(date.status==2){
					alert(date.msg);
				}
			},"json")
		}
		
	}

</script>
</head>
<body>
<form>
	<table>
		<tr>
			<td>
				用户名称：<input type="text" name="uname">
			</td>
		</tr>
		<tr>
			<td>
				用户密码：<input type="text" name="upwd">
			</td>
		</tr>
		<tr>
			<td>
				<input type="button" value="登录" onclick="denglu()">
				<input type="button" value="注册" onclick="zhuce()">
			</td>
		</tr>
	</table>
</form>
</body>
</html>