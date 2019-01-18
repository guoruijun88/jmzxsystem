package com.jm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jm.exception.UserException;
import com.jm.mapper.RolesMapper;
import com.jm.mapper.UsersMapper;
import com.jm.pojo.Roles;
import com.jm.pojo.RolesExample;
import com.jm.pojo.UserCustom;
import com.jm.pojo.Users;
import com.jm.pojo.UsersExample;
import com.jm.pojo.UsersExample.Criteria;
import com.jm.service.UserManagerService;
import com.jm.utils.PageUtils;

@Service
public class UserManagerServiceImpl implements UserManagerService{

	@Autowired
	private RolesMapper rolesMapper;
	@Autowired
	private UsersMapper usersMapper;
	
	@Override
	public List<Roles> findAllRole() {
		// TODO Auto-generated method stub
		RolesExample roleExample = new RolesExample();
		List<Roles> roles = rolesMapper.selectByExample(roleExample);
		return roles;
	}
	@Override
	public void addUser(UserCustom userCustom) {
		// TODO Auto-generated method stub
		Users user = new Users();
		BeanUtils.copyProperties(userCustom, user);
		int result = usersMapper.insert(user);
		if(result==0){
			throw new UserException("添加用户失败，请重新添加");
		}
	}
	@Override
	public List<UserCustom> findAllUsers(UserCustom userCustom) {
		
		Users user = new Users();
		List<UserCustom> userCustoms = new ArrayList<UserCustom>();
		BeanUtils.copyProperties(userCustom, user);
		UsersExample example = this.createUsersExample(user);
		List<Users> list = this.usersMapper.selectByExample(example);
		
		//获得角色的名称和封装UserCustom
		for(Users u:list){
			UserCustom newuserCustom = new UserCustom();
			BeanUtils.copyProperties(u, newuserCustom);
			Roles role = rolesMapper.selectByPrimaryKey(u.getRoleid());
			newuserCustom.setRole(role);
			userCustoms.add(newuserCustom);
		}

		return userCustoms;
	}
	/**
	 * 拼接查询条件
	 */
	private UsersExample createUsersExample(Users user){
		
		UsersExample userExample = new UsersExample();
		Criteria criteria = userExample.createCriteria();
		//根据用户名模糊查找
		if(user.getUsername()!=null&&user.getUsername().length()>0){
			criteria.andUsernameLike("%"+user.getUsername()+"%");
		}
		//根据地址模糊查找
		if(user.getAddress()!=null&&user.getAddress().length()>0){
			criteria.andAddressLike("%"+user.getAddress()+"%");
		}
		//根据电话模糊查找
		if(user.getPhone()!=null&&user.getPhone().length()>0){
			criteria.andPhoneLike("%"+user.getPhone()+"%");
		}
		//根据职位查找
		if(user.getPosition()!=null&&user.getPosition().length()>0){
			criteria.andPositionLike("%"+user.getPosition()+"%");
		}
		//根据真实姓名查找
		if(user.getRealname()!=null&&user.getRealname().length()>0){
			criteria.andRealnameEqualTo(user.getRealname());
		}
		//根据性别查询
		if(user.getSex()!=null&&!user.getSex().equals("no")){
			criteria.andSexEqualTo(user.getSex());
		}
		//根据角色查询
		if(user.getRoleid()!=null&&user.getRoleid()!=-1){
			criteria.andRoleidEqualTo(user.getRoleid());
		}
		//根据身份证号查询
		if(user.getUid()!=null&& user.getUid().length()>0){
			criteria.andUidEqualTo(user.getUid());
		}
		
		return userExample;
	}
	@Value("${prePageNum}")
	private Integer prePageNum;//每页显示多少条数据
	@Override
	public PageUtils findUsersByProperty(UserCustom userCustom, Integer currentNum) {
		// TODO Auto-generated method stub
		PageUtils pageUtils = new PageUtils(); 
		
		PageHelper.startPage(currentNum, prePageNum);
		
		Users user = new Users();
		List<UserCustom> userCustoms = new ArrayList<UserCustom>();
		BeanUtils.copyProperties(userCustom, user);
		UsersExample example = this.createUsersExample(user);
		List<Users> list = this.usersMapper.selectByExample(example);
		
		//获得角色的名称和封装UserCustom
		for(Users u:list){
			UserCustom newuserCustom = new UserCustom();
			BeanUtils.copyProperties(u, newuserCustom);
			Roles role = rolesMapper.selectByPrimaryKey(u.getRoleid());
			newuserCustom.setRole(role);
			userCustoms.add(newuserCustom);
		}
		
		//创建获取总条数的对象
		PageInfo info = new PageInfo<>(list);
		pageUtils.setPageInfo(info);
		pageUtils.setResults(userCustoms);
		return pageUtils;
	}
	
	/**
	 * 预更新用户信息
	 */
	@Override
	public UserCustom findUserByName(String username) {
		
		Users user = usersMapper.selectByPrimaryKey(username);
		UserCustom userCustom = new UserCustom();
		BeanUtils.copyProperties(user, userCustom);
		
		return userCustom;
	}
	
	/**
	 * 用户更新
	 */
	@Override
	public void updateUser(UserCustom userCustom) {
		// TODO Auto-generated method stub
		Users user = new Users();
		BeanUtils.copyProperties(userCustom, user);
		int result = usersMapper.updateByPrimaryKey(user);
		if(result<=0){
			throw new UserException("更新用户失败，请重新更新");
		}
	}
	@Override
	public void deleteUser(UserCustom userCustom) {
		// TODO Auto-generated method stub
		String username = userCustom.getUsername();
		int result = usersMapper.deleteByPrimaryKey(username);
		if(result<=0){
			throw new UserException("删除用户失败，请重新删除");
		}
	}
	
	
}	

