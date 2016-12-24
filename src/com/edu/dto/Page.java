package com.edu.dto;

import java.io.Serializable;
import java.util.List;


public class Page implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int currentPageIndex ; //当前页的索引
	
	private int pageCount ;   //总共有多少页
	
	private int count = 10;  //每页显示多少条数据
	
	private int totalDataCount ;   //表中公有多少条数据
	
	private int startIndex = 1;  //显示页面索引的起始索引
	
	private int endIndex = 5 ;  //显示页面索引的结束索引
	
	private List<Student> list  ; //页面要显示的所有数据的集合 
	
	public Page(int totalCount,int count){
		this.totalDataCount = totalCount ;
		this.count = count ;
		
		//计算公有多少页
		pageCount = (totalCount + count - 1)/count ;
	}

	public int getCurrentPageIndex() {
		return currentPageIndex;
	}

	public void setCurrentPageIndex(int currentPageIndex) {
		this.currentPageIndex = currentPageIndex;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCOunt) {
		this.pageCount = pageCOunt;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTotalDataCount() {
		return totalDataCount;
	}

	public void setTotalDataCount(int totalDataCount) {
		this.totalDataCount = totalDataCount;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}

	public List<Student> getList() {
		return list;
	}

	public void setList(List<Student> list) {
		this.list = list;
	}
}
