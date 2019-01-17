package com.jm.pojo;

import java.util.List;

public class UserCustom extends Users{

	private Roles role;
	private List<Menus> menus;
	private List<Funs> funs;
	public Roles getRole() {
		return role;
	}
	public void setRole(Roles role) {
		this.role = role;
	}
	public List<Menus> getMenus() {
		return menus;
	}
	public void setMenus(List<Menus> menus) {
		this.menus = menus;
	}
	public List<Funs> getFuns() {
		return funs;
	}
	public void setFuns(List<Funs> funs) {
		this.funs = funs;
	}
	
	
}
