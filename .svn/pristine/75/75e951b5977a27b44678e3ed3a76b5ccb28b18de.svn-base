/**
 * 
 */
package com.bbsBlog.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bbsBlog.dao.Forum_replyDao;
import com.bbsBlog.entity.ForumPost;
import com.bbsBlog.entity.ForumReply;
import com.bbsBlog.entity.ForumUpHi;
import com.bbsBlog.service.Forum_replyService;

/**
 * @author Robust
 *
 * @date 2014年7月30日
 *
 */
@Service("forum_replyService")
public class Forum_replyServiceImpl implements Forum_replyService {

	@Resource
	private Forum_replyDao forum_replyDao;



	/**
	 * @return forum_replyDao
	 */
	public Forum_replyDao getForum_replyDao() {
		return forum_replyDao;
	}

	/**
	 * @param forum_replyDao
	 *            要设置的 forum_replyDao
	 */
	public void setForum_replyDao(Forum_replyDao forum_replyDao) {
		this.forum_replyDao = forum_replyDao;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * com.bbsBlog.service.Forum_replyService#saveForum_reply(com.bbsBlog.entity
	 * .Forum_reply)
	 */
	@Override
	public void saveForum_reply(ForumReply forumReply) {
		// TODO 自动生成的方法存根
		this.forum_replyDao.saveForum_reply(forumReply);

	}
	
	public List<ForumReply> listReplyByPostId(long post_id,long user_id){
		return this.forum_replyDao.listReplyByPostId(post_id, user_id);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * com.bbsBlog.service.Forum_replyService#updateForum_reply(com.bbsBlog.
	 * entity.Forum_reply)
	 */
	@Override
	public void updateForum_reply(ForumReply forumReply) {
		// TODO 自动生成的方法存根
		this.forum_replyDao.updateForum_reply(forumReply);

	}
	
	@Override
	public void updateReplyUp(long id,String up){
		System.out.println("------updateReplyUp up:"+up);
		ForumReply reply=this.forum_replyDao.findById(id);
		reply.setUp(up);
		this.forum_replyDao.updateForum_reply(reply);
	}
	
	@Override
	public void updateReplyNormal(long id,String normal){
		System.out.println("------updateReplyNormal Normal:"+normal);
		ForumReply reply=this.forum_replyDao.findById(id);
		reply.setNormal(normal);
		this.forum_replyDao.updateForum_reply(reply);
	}
	
	@Override
	public void updateReplyDown(long id,String down){
		System.out.println("------updateReplyDown Down:"+down);
		ForumReply reply=this.forum_replyDao.findById(id);
		reply.setUp(down);
		this.forum_replyDao.updateForum_reply(reply);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.service.Forum_replyService#deleteForum_reply(long)
	 */
	@Override
	public void deleteForum_reply(long id) {
		// TODO 自动生成的方法存根
		this.forum_replyDao.deleteForum_reply(id);

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.service.Forum_replyService#listForum_reply()
	 */
	@Override
	public List<ForumReply> listForum_reply() {
		// TODO 自动生成的方法存根
		return this.forum_replyDao.listForum_reply();
	}
	
	@Override
	public List<ForumReply> listReplyByForumId(long post_id){
		// TODO 自动生成的方法存根
		return this.forum_replyDao.listReplyByForumId(post_id);
	}
	
	@Override
	public ForumReply findById(long id)
	{
		return this.forum_replyDao.findById(id);
	}
	
	public int countReply(long postId){
		return this.forum_replyDao.countReply(postId);
	}
	
	
	
	//--------------------------------------ForumUpHi---------------------------------------------------------
	@Override
	public void saveForumUpHi(ForumUpHi forumUpHi) {
		// TODO 自动生成的方法存根
		this.forum_replyDao.saveForumUpHi(forumUpHi);

	}

	@Override
	public void updateForumUpHi(ForumUpHi forumUpHi) {
		// TODO 自动生成的方法存根
		this.forum_replyDao.updateForumUpHi(forumUpHi);

	}

	@Override
	public void deleteForumUpHi(long id) {
		// TODO 自动生成的方法存根
		this.forum_replyDao.deleteForumUpHi(id);

	}


	@SuppressWarnings("unchecked")
	@Override
	public List<ForumUpHi> listForumUpHi(long post_id,long user_id){
		// TODO 自动生成的方法存根
		return this.forum_replyDao.listForumUpHi(post_id, user_id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ForumUpHi> listForumUpHiByPost(long post_id){
		// TODO 自动生成的方法存根
		return this.forum_replyDao.listForumUpHiByPost(post_id);
	}

	@Override
	public List<ForumReply> listReplyBySql(String sql) {
		// TODO Auto-generated method stub
		return this.forum_replyDao.listReplyBySql(sql);
	}

	
    

}
