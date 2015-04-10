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
 * ��¼��ȫ������
 * @author changhao
 *
 */
@Controller
@RequestMapping("/auth")
public class LoginSecurityController extends BaseController
{
	/*** log **/
	private Log logger = LogFactory.getLog(getClass());
	
    /** 
     * ָ���¼ҳ�� 
     */  
    @RequestMapping(value = "/login.go")
    public String loginPageInit(@RequestParam(value = "error", required = false) boolean error , ModelMap model)
    {  
        logger.debug("Received request to show login page");  
   
        if (error == true)
        {  
            // Assign an error message  
            model.put("error","You have entered an invalid username or password!");  
        }
        else
        {  
            model.put("error", "");  
        }  
        return "/login";  
   
    }
    
    /** 
     * ָ���޷��ʶ�Ȩ��ҳ�� 
     *  
     * @return 
     */  
    @RequestMapping(value = "/denied.go")
    public String getDeniedPage()
    {  
        logger.debug("Received request to show denied page");  
   
        return "/deniedpage";  
    }  
	
    
    /** 
     * ָ���޷��ʶ�Ȩ��ҳ�� 
     *  
     * @return 
     */  
    @RequestMapping(value = "/common.go")
    public String commonPageInit()
    {  
        logger.debug("Received request to show denied page");  
   
        return "/common";  
    }
	
    /** 
     * ָ���޷��ʶ�Ȩ��ҳ�� 
     *  
     * @return 
     */  
    @RequestMapping(value = "/admin.go")
    public String adminPageInit()
    {  
        logger.debug("Received request to show denied page");  
   
        return "/admin";  
    }
    
    
    @RequestMapping(value = "/sessionTimeout.go")
    public void sessionTimeout(HttpServletRequest request,HttpServletResponse response,ModelMap model) throws IOException
    {
    	//��ȡcontext uri
    	String uri = request.getContextPath();
    	//��ȡ����ͷ
    	//x-requested-with  XMLHttpRequest  //������AJax�첽����
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
}