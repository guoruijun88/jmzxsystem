package com.jm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jm.exception.UserNotFoundException;
import com.jm.mapper.UserCustomMapper;
import com.jm.pojo.UserCustom;
import com.jm.service.UserLoginService;

@Service
public class UserLoginServiceImpl implements UserLoginService{

	@Autowired
	private UserCustomMapper userCustomMapper;
	@Override
	public UserCustom userLogin(String username, String userpwd) {
		// TODO Auto-generated method stub
		UserCustom userCustom = userCustomMapper.userLogin(username);
		if(userCustom == null){
			throw new UserNotFoundException("用户不存在");
		}else{

			if(!userCustom.getUserpwd().equals(userpwd)){
				throw new UserNotFoundException("密码不正确");
			}
			
		}
		
		return userCustom;
	}

}
