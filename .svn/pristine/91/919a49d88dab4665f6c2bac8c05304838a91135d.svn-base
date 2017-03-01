/**
 * 
 */
package com.bbsBlog.dao;

import java.util.List;

import com.bbsBlog.entity.ForumReply;
import com.bbsBlog.entity.ForumUpHi;

/**
 * @author Robust
 *
 * @date 2014年7月26日
 *
 */
public interface Forum_replyDao {
	
	public void saveForum_reply(ForumReply forumReply);

	public void updateForum_reply(ForumReply forumReply);

	public void deleteForum_reply(long id);

	public List<ForumReply> listForum_reply();
	
	public List<ForumReply> listReplyByForumId(long post_id);
	
	public List<ForumReply> listReplyBySql(String sql);
	
	public List<ForumReply> listReplyByPostId(long post_id,long user_id);
	
	public ForumReply findById(long id);
	
	public int countReply(long postId);
	
	
	//ForumUpHi
	
	public void saveForumUpHi(ForumUpHi forumUpHi);

	public void updateForumUpHi(ForumUpHi forumUpHi);

	public void deleteForumUpHi(long id);

	public List<ForumUpHi> listForumUpHi(long post_id,long user_id);
	
	public List<ForumUpHi> listForumUpHiByPost(long post_id);
	
	
	
	
	
}
