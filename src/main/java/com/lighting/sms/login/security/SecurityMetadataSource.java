package com.lighting.sms.login.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.AntUrlPathMatcher;
import org.springframework.security.web.util.UrlMatcher;
import org.springframework.stereotype.Service;

@Service("securityMetadataSource")
public class SecurityMetadataSource implements FilterInvocationSecurityMetadataSource
{
	/*** url匹配对象 **/
	private UrlMatcher urlMatcher = new AntUrlPathMatcher();
	
	private Map<String, Collection<ConfigAttribute>> resourceMap = null;
	
	
	public SecurityMetadataSource()
	{
		resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
		
		Collection<ConfigAttribute> attrs = new ArrayList<ConfigAttribute>();
		
		attrs.add(new SecurityConfig("ROLE_USER"));
		
		resourceMap.put("/loginSuccess.go",attrs);
	}
	

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes()
	{
		return null;
	}

	@Override
	public Collection<ConfigAttribute> getAttributes(Object obj)
			throws IllegalArgumentException
	{
		String url = ((FilterInvocation) obj).getRequestUrl();
		Iterator<String> ite = resourceMap.keySet().iterator();
		while (ite.hasNext())
		{
			String resURL = ite.next();
			if (urlMatcher.pathMatchesUrl(url, resURL))
			{
				return resourceMap.get(resURL);
			}
		}
		return null;
	}

	@Override
	public boolean supports(Class<?> arg0)
	{
		return true;
	}
	
}
