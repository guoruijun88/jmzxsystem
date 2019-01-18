package com.jm.service;

import java.util.List;

import com.jm.pojo.Roles;
import com.jm.pojo.UserCustom;
import com.jm.utils.PageUtils;
	
public interface UserManagerService {

	List<Roles> findAllRole();

	void addUser(UserCustom userCustom);

	List<UserCustom> findAllUsers(UserCustom userCustom);

	PageUtils findUsersByProperty(UserCustom userCustom, Integer currentNum);

	UserCustom findUserByName(String username);

	void updateUser(UserCustom userCustom);

	void deleteUser(UserCustom userCustom);

	
}
