package com.lighting.sms.login.filter;

import java.util.Collection;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;

@Service("securityMetadataSource")
public class SecurityMetadataSourceImpl implements FilterInvocationSecurityMetadataSource
{

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes()
	{
		return null;
	}

	@Override
	public Collection<ConfigAttribute> getAttributes(Object arg0)
			throws IllegalArgumentException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
