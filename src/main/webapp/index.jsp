<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

</head>
<body>
<h2>Hello World!</h2>
	<a href="${pageContext.request.contextPath}/auth/admin.go"><h2>welcome to admin.jsp</h2></a>

	<a href="j_spring_security_logout">退出系统</a>
	        <!-- Javascript -->
</body>
</html>
	<script src="<%=basePath%>static/js/jquery-1.8.2.min.js"></script>
	<script type="text/javascript">
		$(document).ajaxComplete(function(event, xhr, settings){
				alert(xhr.getResponseHeader("sessionstatus"));
				if(xhr.getResponseHeader("sessionstatus")=="timeOut")
				{
					if(xhr.getResponseHeader("loginPath"))
					{
						alert("会话过期，请重新登陆!");
						window.location.replace(xhr.getResponseHeader("loginPath"));  
					}
					else
					{  
						alert("请求超时请重新登陆 !");  
					}  
				}
			}
		);
	</script>