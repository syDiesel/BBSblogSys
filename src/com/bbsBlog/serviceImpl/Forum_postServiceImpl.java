/**
 * 
 */
package com.bbsBlog.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bbsBlog.dao.Forum_postDao;
import com.bbsBlog.entity.ForumLabel;
import com.bbsBlog.entity.ForumPost;
import com.bbsBlog.entity.ForumTP;
import com.bbsBlog.entity.Tpjl;
import com.bbsBlog.entity.UserInfo;
import com.bbsBlog.service.Forum_postService;
import com.bbsBlog.util.PageModel;

/**
 * @author Robust
 *
 * @date 2014年7月30日
 *
 */
@Service("forum_postService")
public class Forum_postServiceImpl implements Forum_postService {

	@Resource
	private Forum_postDao forum_postDao;

	/**
	 * @return forum_postDao
	 */
	public Forum_postDao getForum_postDao() {
		return forum_postDao;
	}

	/**
	 * @param forum_postDao
	 *            要设置的 forum_postDao
	 */
	public void setForum_postDao(Forum_postDao forum_postDao) {
		this.forum_postDao = forum_postDao;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * com.bbsBlog.service.Forum_postService#saveForum_post(com.bbsBlog.entity
	 * .Forum_post)
	 */
	@Override
	public void saveForum_post(ForumPost forumPost) {
		// TODO 自动生成的方法存根
             this.forum_postDao.saveForum_post(forumPost);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * com.bbsBlog.service.Forum_postService#updateForum_post(com.bbsBlog.entity
	 * .Forum_post)
	 */
	@Override
	public void updateForum_post(ForumPost forumPost) {
		// TODO 自动生成的方法存根
           this.forum_postDao.updateForum_post(forumPost);
	}
	
	

	@Override
	public void updateForum_postReplyCount(long post_id,String replyCount){
		
		ForumPost post=this.forum_postDao.findById(post_id);
		post.setReplyCount(replyCount);
		this.forum_postDao.updateForum_post(post);
	}
	

	@Override
	public void updateForum_postPostCount(long post_id,String PostCount){
		ForumPost post=this.forum_postDao.findById(post_id);
		post.setPostCount(PostCount);
		this.forum_postDao.updateForum_post(post);
	}
	
	@Override
	public void updateForum_postIsTop(long post_id,String isTop){
		ForumPost post=this.forum_postDao.findById(post_id);
		post.setIsTop(isTop);
		this.forum_postDao.updateForum_post(post);
	}
	

	@Override
	public void updateForum_postIsWell(long post_id,String isWell){
		ForumPost post=this.forum_postDao.findById(post_id);
		post.setIsWell(isWell);
		this.forum_postDao.updateForum_post(post);
	}
	

	@Override
	public void updateForum_postReplyTime(long post_id,String replyTime){
		ForumPost post=this.forum_postDao.findById(post_id);
		post.setReplyTime(replyTime);
		this.forum_postDao.updateForum_post(post);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.service.Forum_postService#deleteForum_post(long)
	 */
	@Override
	public void deleteForum_post(long id) {
		// TODO 自动生成的方法存根
           this.forum_postDao.deleteForum_post(id);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.service.Forum_postService#listForum_post()
	 */
	@Override
	public List<ForumPost> listForum_post() {
		// TODO 自动生成的方法存根
		return this.forum_postDao.listForum_post();
	}
	
	@Override
	public List<ForumPost> listForum_postByPostCount(long board_id) {
		// TODO 自动生成的方法存根
		return this.forum_postDao.listForum_postByPostCount(board_id);
	}
	
	@Override
	public List<ForumPost> listPostTop(long board_id){
		// TODO 自动生成的方法存根
		return this.forum_postDao.listPostTop(board_id);
	}
	
	@Override
	public List<ForumPost> listPostWell(long board_id){
		// TODO 自动生成的方法存根
		return this.forum_postDao.listPostWell(board_id);
	}
	
	
	@Override
	public ForumPost findById(long id)

	{
		return this.forum_postDao.findById(id);
	}
	
	
	@SuppressWarnings("rawtypes")
	@Override
	public List listPostByLabelTimeDesc(long label_id)
	{
		return this.forum_postDao.listPostByLabelTimeDesc(label_id);
	}
	
	
	
	@SuppressWarnings("rawtypes")
	@Override

	public List listPostByLabelTimeAsc(long label_id)
	{
		return this.forum_postDao.listPostByLabelTimeAsc(label_id);
	}
	
	
	@SuppressWarnings("rawtypes")
	@Override
	public List listPostByLabelReplyDesc(long label_id)
	{
		return this.forum_postDao.listPostByLabelReplyDesc(label_id);
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public List listPostByLabelReplyDesc(long label_id,long statu_id)
	{
		return this.forum_postDao.listPostByLabelReplyDesc(label_id,statu_id);
	}
	
	
	@SuppressWarnings("rawtypes")
	@Override
	public List listPostByLabelReplyAsc(long label_id)
	{
		return this.forum_postDao.listPostByLabelReplyAsc(label_id);
	}
	
	
	
	@Override
	public List<ForumPost> listPostByBoardReplyDesc(long board_id)
	{
		return this.forum_postDao.listPostByBoardReplyDesc(board_id);
	}
	
	@Override
	public List<ForumPost> listPostByBoardReplyDesc(long board_id,long statu_id)
	{
		return this.forum_postDao.listPostByBoardReplyDesc(board_id,statu_id);
	}
	
	
	@Override
	public List<ForumPost> listPostByBoardReplyAsc(long board_id)
	{
		return this.forum_postDao.listPostByBoardReplyAsc(board_id);
	}
	
	
	@Override
	public List<ForumPost> listPostByBoardTimeDesc(long board_id)
	{
		return this.forum_postDao.listPostByBoardTimeDesc(board_id);
	}
	
	
	@Override
	public List<ForumPost> listPostByBoardTimeAsc(long board_id)
	{
		return this.forum_postDao.listPostByBoardTimeAsc(board_id);
	}

	
	
	
	
	//-------------------------------ForumLabel---------------------------------
	
	@Override
	public void saveForumLabel(ForumLabel forumLabel) {
		// TODO 自动生成的方法存根
           this.forum_postDao.saveForumLabel(forumLabel);
	}
	


	@Override
	public void updateForumLabel(ForumLabel forumLabel) {
		// TODO 自动生成的方法存根
		this.forum_postDao.updateForumLabel(forumLabel);

	}

	
	@Override
	public void deleteForumLabel(long id) {
		// TODO 自动生成的方法存根
		this.forum_postDao.deleteForumLabel(id);

	}

	
	@Override
	public List<ForumLabel> listForumLabelByPostId(long post_id)
	{
		return this.forum_postDao.listForumLabelByPostId(post_id);
	}
	
	public List<ForumLabel> listForumLabelBySql(String sql){
		return this.forum_postDao.listForumLabelBySql(sql);
	}
	
	
	
	
	//----------------------------ForumTP-----------------------------
	@Override
	public void saveForumTP(ForumTP forumTP) {
		// TODO 自动生成的方法存根
           this.forum_postDao.saveForumTP(forumTP);
	}
	


	@Override
	public void updateForumTP(ForumTP forumTP) {
		// TODO 自动生成的方法存根
		this.forum_postDao.updateForumTP(forumTP);

	}

	
	@Override
	public void deleteForumTP(long id) {
		// TODO 自动生成的方法存根
		this.forum_postDao.deleteForumTP(id);

	}

	
	@Override
	public List<ForumTP> listForumTPByPostId(long post_id)
	{
		return this.forum_postDao.listForumTPByPostId(post_id);
	}
	
	@Override
	public ForumTP listForumTPById(long id)

	{
		return this.forum_postDao.listForumTPById(id);
	}
	
	
	//----------------------------------------Tpjl-----------------------------------
	
		@Override
		public void saveTpjl(Tpjl tpjl) {
				// TODO 自动生成的方法存根
		           this.forum_postDao.saveTpjl(tpjl);
			}
		
		@Override
		public void deleteTpjl(long id){
			// TODO 自动生成的方法存根
			this.forum_postDao.deleteTpjl(id);

		}
		
		@Override
		public List<Tpjl> listTpjlByUser(long id){
			// TODO 自动生成的方法存根
			return this.forum_postDao.listTpjlByUser(id);
		}
		
		@Override
		public List<Tpjl> listTpjlByForumTP(long id){
			// TODO 自动生成的方法存根
			return this.forum_postDao.listTpjlByForumTP(id);
		}
		
		
		//--------------------------------排序--------------------------------

		@Override
		public List<ForumPost> listPostByKey(String keyword, String lab, String sub, String con) {
			// TODO Auto-generated method stub
			return this.forum_postDao.listPostByKey(keyword,lab,sub,con);
		}

		@Override
		public List<ForumPost> listPostByTime(String keyword, String lab, String sub, String con) {
			// TODO Auto-generated method stub
			return this.forum_postDao.listPostByTime(keyword,lab,sub,con);
		}

		/* （非 Javadoc）
		 * @see com.bbsBlog.service.Forum_postService#listPostByUser(long)
		 * @param userId
		 * @return
		 *
		 * @author Robust
		 * @date 2014年10月8日
		 *
		 */
		@Override
		public List<ForumPost> listPostByUser(long userId) {
			// TODO 自动生成的方法存根
			return this.forum_postDao.listPostByUser(userId);
		}

		/* （非 Javadoc）
		 * @see com.bbsBlog.service.Forum_postService#listCount(java.lang.String)
		 * @param queryCountHql
		 * @return
		 *
		 * @author Robust
		 * @date 2014年10月11日
		 *
		 */
		@Override
		public int listCount(String queryCountHql) {
			// TODO 自动生成的方法存根
			return this.forum_postDao.listCount(queryCountHql);
		}

		@Override
		public PageModel listPostByPost(int offset, int pageSize, long postId) {
			// TODO Auto-generated method stub
			return this.forum_postDao.listPostByPost(offset,pageSize,postId);
		}

		@Override
		public List<ForumPost> listPostBySql(String sql) {
			// TODO Auto-generated method stub
			return this.forum_postDao.listPostBySql(sql);
		}

		@Override
		public PageModel listPostBySQL(int offset, int pageSize,
				String queryCountHql, String hql) {
			// TODO Auto-generated method stub
			return this.forum_postDao.listPostBySQL(offset, pageSize, queryCountHql, hql);
		}
	
	
	
	

}
