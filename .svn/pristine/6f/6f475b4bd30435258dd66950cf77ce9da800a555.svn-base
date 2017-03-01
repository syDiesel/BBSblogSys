package com.bbsBlog.util;

import java.util.List;

import com.bbsBlog.entity.ForumPost;



public class PageModel {
	/**
	 * 总记录数
	 * */

	private int total;
	/**
	 * 当前页的记录集
	 * */
	private List datas;
	private int offset;// 新加

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List getDatas() {
		return datas;
	}

	public void setDatas(List datas) {
		this.datas = datas;
	}
   
	public PageModel(){}
	
	

	public List fenYe(List listInfo,int pageRecords,int currentPage,int allPage,int allRecords){
		
		if(currentPage<allPage){
			listInfo=listInfo.subList((currentPage-1)*pageRecords, currentPage*pageRecords);
		}else if(currentPage==allPage){
			listInfo=listInfo.subList((currentPage-1)*pageRecords, allRecords);
		}
		
		return listInfo;
		
		
	}
}
