<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" class="no-js">
    <head>
    	<base href="<%=basePath%>">
    		
        <meta charset="utf-8">
        <title>Login</title>
		<meta name="keywords" content="Login" />
		<meta name="description" content="Login" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- CSS -->
        <link rel="stylesheet" href="<%=basePath%>static/css/reset.css">
        <link rel="stylesheet" href="<%=basePath%>static/css/supersized.css">
        <link rel="stylesheet" href="<%=basePath%>static/css/style.css">

    </head>

    <body>
        <div class="page-container">
            <h1>登录</h1>
            <form action="j_spring_security_check" method="post">
                <input type="text" name="j_username" class="j_username" placeholder="用户名" value="${sessionScope['SPRING_SECURITY_LAST_USERNAME']}">
                <input type="password" name="j_password" class="j_password" placeholder="密码">
                <div><span>${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}</span></div>
                <button type="submit">提交</button>
                
            </form>
            
            <div class="connect">
                <p>Or connect with:</p>
                <p>
                    <a class="facebook" href=""></a>
                    <a class="twitter" href=""></a>
                </p>
            </div>
        </div>
		
        <!-- Javascript -->
        <script src="<%=basePath%>static/js/jquery-1.8.2.min.js"></script>
        <script src="<%=basePath%>static/js/supersized.3.2.7.min.js"></script>
        <script src="<%=basePath%>static/js/supersized-init.js"></script>
        <script src="<%=basePath%>static/js/scripts.js"></script>

    </body>

</html>
<script >
	window.onload = function ()
	{
		//alert('${error}');
	}
</script>

