package com.jm.vo;

import java.util.List;

import com.jm.pojo.Menus;



public class TreeMenu {
	
	private String treeNodeName ;
	
	private List<Menus> menu;
	
	private String icon;

	public String getTreeNodeName() {
		return treeNodeName;
	}

	public void setTreeNodeName(String treeNodeName) {
		this.treeNodeName = treeNodeName;
	}

	public List<Menus> getMenu() {
		return menu;
	}

	public void setMenu(List<Menus> menu) {
		this.menu = menu;
	}
	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
}
