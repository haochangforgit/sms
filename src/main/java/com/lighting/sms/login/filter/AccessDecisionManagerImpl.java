package com.lighting.sms.login.filter;

import java.util.Collection;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service("accessDecisionManager")
public class AccessDecisionManagerImpl implements AccessDecisionManager
{

	@Override
	public void decide(Authentication arg0, Object arg1, Collection<ConfigAttribute> arg2) 
			throws AccessDeniedException, InsufficientAuthenticationException
	{
		
	}

	@Override
	public boolean supports(ConfigAttribute arg0)
	{
		return false;
	}

	@Override
	public boolean supports(Class<?> arg0)
	{
		return false;
	}
	
}
