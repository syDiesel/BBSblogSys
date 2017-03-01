package com.bbsBlog.util;

import java.util.List;

import com.bbsBlog.entity.Suggestion;
import com.bbsBlog.entity.UserAlbumPhoto;
import com.bbsBlog.entity.UserAlbum;


public class Pages {
	
   public List fenYe(List listInfo,int pageRecords,int currentPage,int allPage,int allRecords){
		
		if(currentPage<allPage){
			listInfo=listInfo.subList((currentPage-1)*pageRecords, currentPage*pageRecords);
		}else if(currentPage==allPage){
			listInfo=listInfo.subList((currentPage-1)*pageRecords, allRecords);
		}
		return listInfo;
	}
   
}
