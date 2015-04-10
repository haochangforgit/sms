<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<h2>Hello World!</h2>
	<a href="${pageContext.request.contextPath}/auth/admin.go"><h2>welcome to admin.jsp</h2></a>
	</br>
	<a href="j_spring_security_logout">退出系统</a>
</body>
</html>
