package com.lighting.sms.login.security;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lighting.platform.base.entity.User;
import com.lighting.service.service.IAuthService;
import com.lighting.service.service.IUserService;

@Service("userDetailsSecurityService")
public class UserDetailsSecurityService implements UserDetailsService
{
	private Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	@Qualifier("userService")
	private IUserService userService;
	
	@Autowired
	@Qualifier("authService")
	private IAuthService authService;

	@Override
	public UserDetails loadUserByUsername(String userId)
			throws UsernameNotFoundException, DataAccessException
	{
		UserDetails userDetail = null;
		try
		{
			//sethideUserNotFoundExceptions
			User loginUser = userService.getById(userId);
			
			userDetail = new org.springframework.security.core.userdetails.User
					(loginUser.getId(), loginUser.getPassword(), true, true, false, true, authService.getGrantedAuthorityById(""));
		}
		catch (Exception e)
		{
			logger.error(String.format("%s||登陆错误",e.getMessage()));
			throw new UsernameNotFoundException("用户名或密码错误");
		}
		
		return userDetail;
	}
	
}
