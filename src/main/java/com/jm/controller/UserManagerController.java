package com.jm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jm.exception.UserException;
import com.jm.pojo.Roles;
import com.jm.pojo.UserCustom;
import com.jm.service.UserManagerService;
import com.jm.utils.PageUtils;

/**
 * 用户管理模块
 * @author Administrator
 *
 */
@Controller
public class UserManagerController {

	//注入查询service
	@Autowired
	private UserManagerService userManagerService;
	
	/**
	 * 添加用户之前的角色查询
	 * @param model
	 * @return
	 */
	@RequestMapping("/findAllRoles.do")
	public String findAllRole(Model model){
		
		List<Roles> roles = userManagerService.findAllRole();
		model.addAttribute("roles", roles);
		
		return "/users/addUser";
	}
	
	/**
	 * 添加用户
	 * @param userCustom 封装用户的输入信息的vo
	 * @return
	 */
	@RequestMapping("/addUser.do")
	public String addUser(UserCustom userCustom){
		
		try{
			userManagerService.addUser(userCustom);
		}catch(UserException e){
			return "/erro.jsp";
		}
		
		return "/success";
	}
	
	/**
	 * 查询用户之前的角色查询
	 * @param model
	 * @return
	 */
	@RequestMapping("/findRolesAll.do")
	public String findRolesAll(Model model){
		
		List<Roles> roles = userManagerService.findAllRole();
		model.addAttribute("roles", roles);
		
		return "/users/findUser";
	}
	
	/**
	 * 根据查询条件查询用户
	 */
	@RequestMapping("/findUsersByProperty.do")
	public String findUsersByProperty(UserCustom userCustom,Model model,@RequestParam(defaultValue="1") Integer currentNum){
		
//		List<UserCustom> userCustoms = userManagerService.findAllUsers(userCustom);
//		model.addAttribute("userCustoms",userCustoms);
		
		PageUtils page = userManagerService.findUsersByProperty(userCustom,currentNum);
		model.addAttribute("page", page);
		model.addAttribute("userCustom",userCustom);
		model.addAttribute("currentNum",currentNum);
		return "users/showUsers";
	}
	
	/**
	 * 预更新用户信息
	 * @return
	 */
	@RequestMapping("/preUpdateUser.do")
	public String preUpdateUser(String username,Model model){
		UserCustom userCustom = userManagerService.findUserByName(username);
		List<Roles> roles = userManagerService.findAllRole();
		model.addAttribute("userCustom",userCustom);
		model.addAttribute("roles",roles);
		return "users/updateUser";
	}
	
	/**
	 * 更新用户
	 */
	@RequestMapping("/updateUser.do")
	public String updateUser(UserCustom userCustom,Model model){
		
		try{
			userManagerService.updateUser(userCustom);
		}catch(UserException e){
			return "/erro.jsp";
		}
		PageUtils page = getPageUtils();
		model.addAttribute("page", page);
		
		return "users/showUsers";
		
	}
	
	/**
	 * 删除用户
	 */
	@RequestMapping("/deleteUser.do")
	public String deleteUser(UserCustom userCustom,Model model){
		
		try{
			userManagerService.deleteUser(userCustom);
		}catch(UserException e){
			return "/erro.jsp";
		}
		PageUtils page = getPageUtils();
		model.addAttribute("page", page);
		
		return "users/showUsers";
	}
	
	/**
	 * 查询或删除后，返回到所有用户页面
	 */
	private PageUtils getPageUtils(){
		UserCustom userCustom = new UserCustom();
		PageUtils page = userManagerService.findUsersByProperty(userCustom,1);
		return page;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
