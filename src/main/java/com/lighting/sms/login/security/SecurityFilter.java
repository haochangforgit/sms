package com.lighting.sms.login.security;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

/***
 * spring security 自定义过滤器
 * 
 * @author changhao
 *
 */
//@Service("securityFilter")
public class SecurityFilter extends AbstractSecurityInterceptor implements Filter
{
	/*** logger **/
	private static Log logger = LogFactory.getLog(SecurityFilter.class);
	
	/*** logger **/
	//@Autowired
	private FilterInvocationSecurityMetadataSource securityMetadataSource;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
	{
		FilterInvocation filterInvoke = new FilterInvocation(request, response, chain);
		
		InterceptorStatusToken token = super.beforeInvocation(filterInvoke);
		
		try
		{
			filterInvoke.getChain().doFilter(filterInvoke.getRequest(), filterInvoke.getResponse());
		}
		finally
		{
			super.afterInvocation(token, null);
		}
	}
	
	
	@Override
	public SecurityMetadataSource obtainSecurityMetadataSource()
	{
		return this.securityMetadataSource;
	}
	
	
	@Override
	public Class<? extends Object> getSecureObjectClass()
	{
		return FilterInvocation.class;
	}


	@Override
	public void destroy()
	{
		logger.info("spring security filter destroy");
	}


	@Override
	public void init(FilterConfig arg0) throws ServletException
	{
		logger.info("spring security filter init");
	}


	public void setSecurityMetadataSource(FilterInvocationSecurityMetadataSource securityMetadataSource)
	{
		this.securityMetadataSource = securityMetadataSource;
	}


}
