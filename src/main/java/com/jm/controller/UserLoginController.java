package com.jm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jm.exception.UserNotFoundException;
import com.jm.pojo.Menus;
import com.jm.pojo.UserCustom;
import com.jm.service.UserLoginService;
import com.jm.vo.TreeMenu;

@Controller
public class UserLoginController {

	@Autowired
	private UserLoginService userLoginService;

	@RequestMapping("/userLogin")
	public String userLogin(String username, String userpwd, Model model, HttpSession session) {

		try {
			UserCustom userCustom = userLoginService.userLogin(username, userpwd);
			List<TreeMenu> listTreeNode = new ArrayList<TreeMenu>();
			List<Menus> resultMenus = userCustom.getMenus();
			
			for (Menus menus2 : resultMenus) {
				TreeMenu treeMenu = new TreeMenu();
				List<Menus> listMenus = new ArrayList<Menus>();
				for (Menus menus3 : resultMenus) {
					if (menus2.getMenuid() == menus3.getFatherid()) {
						listMenus.add(menus3);
					}
				}
				if(menus2.getFatherid()!=0) {
					continue;
				}
				treeMenu.setTreeNodeName(menus2.getMenuname());
				treeMenu.setIcon(menus2.getIcon());
				treeMenu.setMenu(listMenus);
				listTreeNode.add(treeMenu);
			}
			session.setAttribute("userCustom", userCustom);
			session.setAttribute("listTreeNode", listTreeNode);

		} catch (UserNotFoundException e) {
			model.addAttribute("username", username);
			model.addAttribute("userpwd", userpwd);
			model.addAttribute("msg", e.getMessage());
			return "login";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:error";
		}
		return "redirect:main";
	}
}
