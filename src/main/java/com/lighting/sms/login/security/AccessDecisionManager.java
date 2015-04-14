package com.lighting.sms.login.security;

import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;


/***
 * 
 * 
 * @author changhao
 *
 */
@Service("accessDecisionManager")
public class AccessDecisionManager implements org.springframework.security.access.AccessDecisionManager
{

	private Log logger = LogFactory.getLog(getClass());
	
	@Override
	public void decide(Authentication authentication, Object obj, Collection<ConfigAttribute> attrs) 
			throws AccessDeniedException, InsufficientAuthenticationException
	{
		if(attrs == null)
			return;
		
		logger.info(String.format("URL is %s",obj.toString()));
		
		Iterator<ConfigAttribute> it = attrs.iterator();
		
		while(it.hasNext())
		{
			ConfigAttribute attr = it.next();
			
			//String needRole = ((SecurityConfig)ca).getAttribute();
			String role = attr.getAttribute();
			
			for (GrantedAuthority grantedAuthority : authentication.getAuthorities())
			{
				if(role.equals(grantedAuthority.getAuthority()))
					return;
			}
			
		}
		
		throw new AccessDeniedException("No access");
	}

	@Override
	public boolean supports(ConfigAttribute arg0)
	{
		return true;
	}

	@Override
	public boolean supports(Class<?> arg0)
	{
		return true;
	}
	
}
