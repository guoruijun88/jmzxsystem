package com.jm.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import com.github.pagehelper.PageInfo;

public class PageUtils {

	
	private List<?> results;//分页好的数据
	@Value("${prePageNum}")
	private Integer prePageNum;//每页显示多少条数据
	private Integer currentNum;	//当前页
	@Value("${everyPageCount}")
	private Integer everyPageCount;//每页多少页
	private PageInfo<?> pageInfo;
	public Integer getPrePageNum() {
		return prePageNum;
	}
	public void setPrePageNum(Integer prePageNum) {
		this.prePageNum = prePageNum;
	}
	public List<?> getResults() {
		return results;
	}
	public void setResults(List<?> results) {
		this.results = results;
	}
	public Integer getCurrentNum() {
		return currentNum;
	}
	public void setCurrentNum(Integer currentNum) {
		this.currentNum = currentNum;
	}
	public Integer getEveryPageCount() {
		return everyPageCount;
	}
	public void setEveryPageCount(Integer everyPageCount) {
		this.everyPageCount = everyPageCount;
	}
	public PageInfo<?> getPageInfo() {
		return pageInfo;
	}
	public void setPageInfo(PageInfo<?> pageInfo) {
		this.pageInfo = pageInfo;
	}
	
	
//	private Integer totalPageNum;//总页数
//	private boolean hasFrontPage; //是否有上一页
//	private Integer frontPage; //上一页
//	private Integer firstPage; //首页
//	private boolean hasNextPage; //是否有下一页
//	private Integer nextPage; //下一页
//	private Integer lastPage;//尾页
//	private Integer everyStartPage; //每页的起始页
//	private Integer everyEndPage; //每页的结束页
	
	
	
	

}
