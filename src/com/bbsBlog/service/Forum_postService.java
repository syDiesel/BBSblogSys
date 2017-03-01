/**
 * 
 */
package com.bbsBlog.service;

import java.util.List;

import com.bbsBlog.entity.ForumLabel;
import com.bbsBlog.entity.ForumPost;
import com.bbsBlog.entity.ForumTP;
import com.bbsBlog.entity.Tpjl;
import com.bbsBlog.util.PageModel;

/**
 * @author Robust
 *
 * @date 2014年7月29日
 *
 */
public interface Forum_postService {

	public void saveForum_post(ForumPost forumPost);

	public void updateForum_post(ForumPost forumPost);
	
	public void updateForum_postReplyCount(long post_id,String replyCount);
	
	public void updateForum_postPostCount(long post_id,String PostCount);
	
	public void updateForum_postIsTop(long post_id,String isTop);
	
	public void updateForum_postIsWell(long post_id,String isWell);
	
	public void updateForum_postReplyTime(long post_id,String replyTime);
	
	public List<ForumPost> listPostByUser(long userId);

	public void deleteForum_post(long id);

	public List<ForumPost> listForum_post();	
	
	public List<ForumPost> listForum_postByPostCount(long board_id);

	public List<ForumPost> listPostTop(long board_id);
	
	public List<ForumPost> listPostWell(long board_id);
	
	public List<ForumPost> listPostByKey(String keyword, String lab, String sub, String con);
	
	public List<ForumPost> listPostByTime(String keyword, String lab, String sub, String con);
	
	public List<ForumPost> listPostBySql(String sql);
	
	public ForumPost findById(long id);
	
	public List listPostByLabelReplyDesc(long label_id,long statu_id);
	
	public List listPostByLabelTimeDesc(long label_id);

	public List listPostByLabelTimeAsc(long label_id);

	public List listPostByLabelReplyDesc(long label_id);
	
	public List listPostByLabelReplyAsc(long label_id);

	
	public List<ForumPost> listPostByBoardReplyDesc(long board_id,long statu_id);
	
	public List<ForumPost> listPostByBoardReplyDesc(long board_id);
	
	public List<ForumPost> listPostByBoardReplyAsc(long board_id);
	
	public List<ForumPost> listPostByBoardTimeDesc(long board_id);
	
	public List<ForumPost> listPostByBoardTimeAsc(long board_id);
	
	//ForumLabel
	public void saveForumLabel(ForumLabel forumLabel);
	
	public void updateForumLabel(ForumLabel forumLabel);
	
	public void deleteForumLabel(long id);
	
	public List<ForumLabel> listForumLabelByPostId(long post_id);
	
	public List<ForumLabel> listForumLabelBySql(String sql);
	
	public int listCount(String queryCountHql);
	
	
	//ForumTP
    public void saveForumTP(ForumTP forumTP);
	
	public void updateForumTP(ForumTP forumTP);
	
	public void deleteForumTP(long id);
	
	public List<ForumTP> listForumTPByPostId(long post_id);
	
	public ForumTP listForumTPById(long id);
	
	public PageModel listPostBySQL(int offset, int pageSize, String queryCountHql,String hql);
	
	//Tpjl
		public void saveTpjl(Tpjl tpjl);
		
		public void deleteTpjl(long id);
		
		public List<Tpjl> listTpjlByUser(long id);
		
		public List<Tpjl> listTpjlByForumTP(long id);
		
		public PageModel listPostByPost(int offset, int pageSize, long postId);
}