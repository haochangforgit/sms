
////全局的ajax访问，处理ajax清求时sesion超时
// $.ajaxSetup({
//     contentType:"application/x-www-form-urlencoded;charset=utf-8", 
//     complete:function(XMLHttpRequest,textStatus){
//             var sessionstatus=XMLHttpRequest.getResponseHeader("sessionstatus"); // 通过XMLHttpRequest取得响应头，sessionstatus，
//             if(sessionstatus=="timeout")
//             {
//                         // 如果超时就处理 ，指定要跳转的页面
//                         window.location.replace("${path}/auth/login.go"); 
//             }
//     }
//   });
$(document).ajaxComplete
	(
		function(event, xhr, settings)
		{
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
jQuery(document).ready(function() {

    $('.page-container form').submit(function(){
        var username = $(this).find('.username').val();
        var password = $(this).find('.password').val();
        if(username == '') {
            $(this).find('.error').fadeOut('fast', function(){
                $(this).css('top', '27px');
            });
            $(this).find('.error').fadeIn('fast', function(){
                $(this).parent().find('.username').focus();
            });
            return false;
        }
        if(password == '') {
            $(this).find('.error').fadeOut('fast', function(){
                $(this).css('top', '96px');
            });
            $(this).find('.error').fadeIn('fast', function(){
                $(this).parent().find('.password').focus();
            });
            return false;
        }
    });

    $('.page-container form .username, .page-container form .password').keyup(function(){
        $(this).parent().find('.error').fadeOut('fast');
    });

});
