<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>">
	<!-- 能获取此页面证明权限验证陈功 -->
	<!-- 加载此页面后自动跳转 -至登录成功action -->
	<meta http-equiv='refresh' content='0;url=loginSuccess.go'>
</head>
<body>
</body>
</html>