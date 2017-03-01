/**
 * 
 */
package com.bbsBlog.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.bbsBlog.dao.Forum_replyDao;
import com.bbsBlog.entity.ForumReply;
import com.bbsBlog.entity.ForumUpHi;

/**
 * @author Robust
 *
 * @date 2014年7月28日
 *
 */
@Repository("forum_replyDao")
public class Forum_replyDaoImpl implements Forum_replyDao {
	
	@Resource
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.Forum_replyDao#saveForum_reply(com.bbsBlog.entity.Forum_reply)
	 */
	@Override
	public void saveForum_reply(ForumReply forumReply) {
		// TODO 自动生成的方法存根
		this.hibernateTemplate.save(forumReply);

	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.Forum_replyDao#updateForum_reply(com.bbsBlog.entity.Forum_reply)
	 */
	@Override
	public void updateForum_reply(ForumReply forumReply) {
		// TODO 自动生成的方法存根
		this.hibernateTemplate.update(forumReply);

	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.Forum_replyDao#deleteForum_reply(long)
	 */
	@Override
	public void deleteForum_reply(long id) {
		// TODO 自动生成的方法存根
		this.hibernateTemplate.delete(this.hibernateTemplate.get(ForumReply.class, id));

	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.Forum_replyDao#listForum_reply()
	 */
	@Override
	public List<ForumReply> listForum_reply() {
		// TODO 自动生成的方法存根
		return this.hibernateTemplate.find("from ForumReply");
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ForumReply> listReplyByForumId(long post_id)
	{
		return this.hibernateTemplate.find("from ForumReply r where r.forumPost.id="+post_id+"  order by replyTime ");
	}
	
	@Override
	public List<ForumReply> listReplyByPostId(long post_id,long user_id)
	{
		return this.hibernateTemplate.find("from ForumReply r where r.forumPost.id="+post_id+"and r.userInfo.id="+user_id+" order by replyTime ");
	}
	
	@Override
	public ForumReply findById(long id)
	{
		return this.hibernateTemplate.get(ForumReply.class, id);
	}
	@Override
	public int countReply(long postId){
		
		return Integer.parseInt(this.hibernateTemplate.find("select count(*) from ForumReply f where f.forumPost.id="+postId).listIterator().next().toString());
	}
	
	
	
	
	
	//--------------------------------------ForumUpHi---------------------------------------------------------
	@Override
	public void saveForumUpHi(ForumUpHi forumUpHi) {
		// TODO 自动生成的方法存根
		this.hibernateTemplate.save(forumUpHi);

	}

	@Override
	public void updateForumUpHi(ForumUpHi forumUpHi) {
		// TODO 自动生成的方法存根
		this.hibernateTemplate.update(forumUpHi);

	}

	@Override
	public void deleteForumUpHi(long id) {
		// TODO 自动生成的方法存根
		this.hibernateTemplate.delete(this.hibernateTemplate.get(ForumUpHi.class, id));

	}


	@SuppressWarnings("unchecked")
	@Override
	public List<ForumUpHi> listForumUpHi(long post_id,long user_id){
		// TODO 自动生成的方法存根
		return this.hibernateTemplate.find("from ForumUpHi f where f.forumPost.id="+post_id+" and f.userInfo.id="+user_id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ForumUpHi> listForumUpHiByPost(long post_id){
		// TODO 自动生成的方法存根
		return this.hibernateTemplate.find("from ForumUpHi f where f.forumPost.id="+post_id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ForumReply> listReplyBySql(String sql) {
		// TODO Auto-generated method stub
		List<ForumReply> list = this.hibernateTemplate.find(sql);
		return list;
	}
	


}
