/**
 * 
 */
package com.bbsBlog.service;

import java.util.List;

import com.bbsBlog.entity.PostStatus;

/**
 * @author Robust
 *
 * @date 2014年7月30日
 *
 */
public interface PostStatusService {


	public void savePostStatus(PostStatus postStatus);

	public void updatePostStatus(PostStatus postStatus);

	public void deletePostStatus(long id);

	public List<PostStatus> listPostStatus();
	
	public PostStatus listPostStatusById(long status_id);
}