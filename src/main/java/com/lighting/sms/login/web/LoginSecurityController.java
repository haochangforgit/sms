package com.lighting.sms.login.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lighting.platform.base.web.controller.BaseController;

/***
 * 登录控制器
 * @author changhao
 *
 */
@Controller
public class LoginSecurityController extends BaseController
{
	/*** log **/
	private Log logger = LogFactory.getLog(getClass());
	
    /** 
     * 指向登录页面 
     */  
    @RequestMapping(value = "/login.go")
    public String loginPageInit(@RequestParam(value = "error", required = false) boolean error ,String type, ModelMap model,HttpServletRequest request)
    {
    	//跟踪原有的客户端IP地址和原来客户端请求的服务器地址
    	String forwarded = request.getHeader("x-forwarded-for");
    	String requestIp = forwarded == null ? request.getRemoteAddr() : forwarded;
    	
        logger.debug(String.format("Received request to show login page [%s]", requestIp));
   
        return "/login";  
    }
    
    /** 
     * 登录失败
     */  
    @RequestMapping(value = "/denied.go")
    public String denied()
    {
        return "/denied";  
    }
    
    /** 
     * 登录成功
     */  
    @RequestMapping(value = "/undefined.go")
    public String loginSuccess(@RequestParam(value = "error", required = false) boolean error ,String type, ModelMap model,HttpServletRequest request)
    {
    	//跟踪原有的客户端IP地址和原来客户端请求的服务器地址
    	String forwarded = request.getHeader("x-forwarded-for");
    	String requestIp = forwarded == null ? request.getRemoteAddr() : forwarded;
    	
        logger.debug(String.format("Received request to show login page [%s]", requestIp));
   
        return "/admin";  
    }
    
    /***
     * session 超时跳转页面
     * @param request  请求
     * @param response 响应
     * @param model    mvc模型
     * @throws IOException 写入失败或获取输出流失败后抛出
     */
    @RequestMapping(value = "/sessionTimeout.go")
    public void sessionTimeout(HttpServletRequest request,HttpServletResponse response,ModelMap model) throws IOException
    {
    	//获取context uri
    	String uri = request.getContextPath();
    	//获取请求头
    	//x-requested-with  XMLHttpRequest  //表明是AJax异步请求
    	String requestHeader = request.getHeader("x-requested-with");
    	if(requestHeader != null && requestHeader.equalsIgnoreCase("XMLHttpRequest"))
    	{
    		//model.
    		PrintWriter out = response.getWriter();
    		out.print("{timeout:true}");
    		out.flush();
    		out.close();
    	}
    	else
    	{
    		response.sendRedirect(String.format("%s/auth/login.go", uri));
    	}
    	//return "redirect:auth/login.go";
    }
    
    @RequestMapping("/a.go")
    public String a()
    {
    	return "/a";
    }
}