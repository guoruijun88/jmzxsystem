package com.jm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

	@RequestMapping("/")
	public String showIndex(){
		System.out.println("====================");
		return "login";
	}
	
	/**
	 * 页面跳转
	 */
	@RequestMapping("{page}")
	public String showPage(@PathVariable String page){
        return page;
	}
	
	/**
	 * 页面跳转
	 */
	@RequestMapping("user/{page}")
	public String showUserPage(@PathVariable String page){
        return "user"+"/"+page;
	}
	public static void main(String[] args) {
		System.out.println("dfdfd");
	}
}
