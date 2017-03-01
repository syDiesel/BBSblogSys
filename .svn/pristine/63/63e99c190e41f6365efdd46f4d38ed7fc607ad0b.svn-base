/**
 * 
 */
package com.bbsBlog.dao;

import java.util.List;

import com.bbsBlog.entity.ForumLabel;
import com.bbsBlog.entity.ForumPost;
import com.bbsBlog.entity.ForumTP;
import com.bbsBlog.entity.Tpjl;
import com.bbsBlog.util.PageModel;

/**
 * @author Robust
 *
 * @date 2014年7月26日
 *
 */
public interface Forum_postDao {
	public void saveForum_post(ForumPost forumPost);

	public void updateForum_post(ForumPost forumPost);

	public void deleteForum_post(long id);

	public List<ForumPost> listForum_post();
	
	public List<ForumPost> listForum_postByPostCount(long board_id);

	public List<ForumPost> listPostTop(long board_id);
	
	public List<ForumPost> listPostWell(long board_id);
	
	public List<ForumPost> listPostByKey(String keyword, String lab, String sub, String con);
	
	public List<ForumPost> listPostByTime(String keyword, String lab, String sub, String con);
	
	public List<ForumPost> listPostByUser(long userId);
	
	public PageModel listPostBySQL(int offset, int pageSize, String queryCountHql,String hql);
	

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
	
	public List<ForumPost> listPostBySql(String sql);
	
	//ForumLabel
	public void saveForumLabel(ForumLabel forumLabel);
	
	public void updateForumLabel(ForumLabel forumLabel);
	
	public void deleteForumLabel(long id);
	
	public List<ForumLabel> listForumLabelBySql(String sql);
	
	public List<ForumLabel> listForumLabelByPostId(long post_id);
	
	public int listCount(String queryCountHql);
	

	
	//ForumTP
    public void saveForumTP(ForumTP forumTP);
	
	public void updateForumTP(ForumTP forumTP);
	
	public void deleteForumTP(long id);
	
	public List<ForumTP> listForumTPByPostId(long post_id);
	
	public ForumTP listForumTPById(long id);
	
	
	//Tpjl
	public void saveTpjl(Tpjl tpjl);
	
	public void deleteTpjl(long id);
	
	public List<Tpjl> listTpjlByUser(long id);
	
	public List<Tpjl> listTpjlByForumTP(long id);
	
	public PageModel listPostByPost(int offset, int pageSize, long postId);
	
	
}
