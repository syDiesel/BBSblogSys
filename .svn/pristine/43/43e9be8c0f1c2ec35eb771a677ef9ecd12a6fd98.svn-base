/**
 * 
 */
package com.bbsBlog.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.bbsBlog.dao.Forum_postDao;
import com.bbsBlog.entity.BlogLog;
import com.bbsBlog.entity.ForumLabel;
import com.bbsBlog.entity.ForumPost;
import com.bbsBlog.entity.ForumTP;
import com.bbsBlog.entity.Question;
import com.bbsBlog.entity.Tpjl;
import com.bbsBlog.util.PageModel;



/**
 * @author Robust
 *
 * @date 2014年7月28日
 *
 */
@Repository("forum_postDao")
public class Forum_PostDaoImpl extends HibernateDaoSupport implements Forum_postDao {
	
	@Resource
	public void setSessionFacotry(SessionFactory sessionFacotry) {
		super.setSessionFactory(sessionFacotry);
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.Forum_postDao#saveForum_post(com.bbsBlog.entity.Forum_post)
	 */
	@Override
	public void saveForum_post(ForumPost forumPost) {
		// TODO 自动生成的方法存根
           this.getHibernateTemplate() .save(forumPost);
	}
	

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.Forum_postDao#updateForum_post(com.bbsBlog.entity.Forum_post)
	 */
	@Override
	public void updateForum_post(ForumPost forumPost) {
		// TODO 自动生成的方法存根
		this.getHibernateTemplate() .update(forumPost);

	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.Forum_postDao#deleteForum_post(long)
	 */
	@Override
	public void deleteForum_post(long id) {
		// TODO 自动生成的方法存根
		this.getHibernateTemplate() .delete(this.getHibernateTemplate() .get(ForumPost.class, id));

	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.Forum_postDao#listForum_post()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ForumPost> listForum_post() {
		// TODO 自动生成的方法存根
		return this.getHibernateTemplate() .find("from ForumPost f order by f.postDate desc");
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ForumPost> listForum_postByPostCount(long board_id) {
		// TODO 自动生成的方法存根
		return this.getHibernateTemplate() .find("from ForumPost f where f.board.id="+board_id+"and (f.postStatus.id=4 or f.postStatus.id=5) order by cast(f.postCount as integer) desc");
	}
	
	@SuppressWarnings("unchecked")
	@Override

	public List<ForumPost> listPostTop(long board_id){
		// TODO 自动生成的方法存根
		return this.getHibernateTemplate() .find("from ForumPost p where p.isTop=1 and p.board.id="+board_id+"and (p.postStatus.id=4 or p.postStatus.id=5) order by p.replyTime desc");
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ForumPost> listPostWell(long board_id){
		// TODO 自动生成的方法存根
		return this.getHibernateTemplate() .find("from ForumPost p where p.isWell=1 and p.board.id="+board_id+"and (p.postStatus.id=4 or p.postStatus.id=5) order by p.replyTime desc");
	}
	
	
	@Override
	public ForumPost findById(long id)

	{
		return this.getHibernateTemplate() .get(ForumPost.class, id);
	}
	
	
	@SuppressWarnings("rawtypes")
	@Override
	public List listPostByLabelTimeDesc(long label_id)
	{
		return this.getHibernateTemplate() .find("select p.id from ForumPost p,ForumLabel l where l.forumPost.id=p.id and l.label.id="+label_id+" and (p.postStatus.id=4 or p.postStatus.id=5) order by p.replyTime desc");
	}
	
	
	
	@SuppressWarnings("rawtypes")
	@Override
	public List listPostByLabelTimeAsc(long label_id)
	{
		return this.getHibernateTemplate() .find("select p.id from ForumPost p,ForumLabel l where l.forumPost.id=p.id and l.label.id="+label_id+" and (p.postStatus.id=4 or p.postStatus.id=5) order by p.replyTime");
	}
	
	
	@SuppressWarnings("rawtypes")
	@Override
	public List listPostByLabelReplyDesc(long label_id)
	{
		return this.getHibernateTemplate() .find("select p.id from ForumPost p,ForumLabel l where l.forumPost.id=p.id and l.label.id="+label_id+" and (p.postStatus.id=4 or p.postStatus.id=5) order by cast(p.replyCount as integer) desc");
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public List listPostByLabelReplyDesc(long label_id,long statu_id)
	{
		return this.getHibernateTemplate() .find("select p.id from ForumPost p,ForumLabel l where l.forumPost.id=p.id and l.label.id="+label_id+" and p.postStatus.id="+statu_id+" order by cast(p.replyCount as integer) desc");
	}
	
	
	@SuppressWarnings("rawtypes")
	@Override
	public List listPostByLabelReplyAsc(long label_id)
	{
		return this.getHibernateTemplate() .find("select p.id from ForumPost p,ForumLabel l where l.forumPost.id=p.id and l.label.id="+label_id+" and (p.postStatus.id=4 or p.postStatus.id=5) order by cast(p.replyCount as integer)");
	}
	
	
	@SuppressWarnings("unchecked")
	@Override

	public List<ForumPost> listPostByBoardReplyDesc(long board_id,long statu_id)

	{
		return this.getHibernateTemplate() .find("from ForumPost p where p.board.id="+board_id+" and p.postStatus.id="+statu_id+" order by cast(p.replyCount as integer) desc");
	}
	
	
	@SuppressWarnings("unchecked")
	@Override

	public List<ForumPost> listPostByBoardReplyDesc(long board_id)

	{
		return this.getHibernateTemplate() .find("from ForumPost p where p.board.id="+board_id+" and (p.postStatus.id=4 or p.postStatus.id=5) order by cast(p.replyCount as integer) desc");
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ForumPost> listPostByBoardReplyAsc(long board_id)
	{
		return this.getHibernateTemplate() .find("from ForumPost p where p.board.id="+board_id+" and (p.postStatus.id=4 or p.postStatus.id=5) order by cast(p.replyCount as integer)");
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ForumPost> listPostByBoardTimeDesc(long board_id)
	{
		return this.getHibernateTemplate() .find("from ForumPost p where p.board.id="+board_id+" and (p.postStatus.id=4 or p.postStatus.id=5) order by replyTime desc");
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ForumPost> listPostByBoardTimeAsc(long board_id)
	{
		return this.getHibernateTemplate() .find("from ForumPost p where p.board.id="+board_id+" and (p.postStatus.id=4 or p.postStatus.id=5) order by replyTime");
	}

	
	
	
	//-----------------------ForumLabel-----------------------------------

	@Override
	public void saveForumLabel(ForumLabel forumLabel) {
		// TODO 自动生成的方法存根
           this.getHibernateTemplate() .save(forumLabel);
	}
	

	
	@Override
	public void updateForumLabel(ForumLabel forumLabel) {
		// TODO 自动生成的方法存根
		this.getHibernateTemplate() .update(forumLabel);

	}


	@Override
	public void deleteForumLabel(long id) {
		// TODO 自动生成的方法存根
		this.getHibernateTemplate() .delete(this.getHibernateTemplate() .get(ForumLabel.class, id));

	}
	
	@SuppressWarnings("unchecked")
	public List<ForumLabel> listForumLabelBySql(String sql){
		return this.getHibernateTemplate().find(sql);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ForumLabel> listForumLabelByPostId(long post_id)
	{
		return this.getHibernateTemplate() .find("from ForumLabel l where l.forumPost.id="+post_id);
	}
	
	public int listCount(String queryCountHql) {
		// TODO 自动生成的方法存根

		// 得到总记录数

		Query query = getSession().createQuery(queryCountHql);
		int total = ((Long) query.uniqueResult()).intValue();
		return total;
	}
	
	

	
	//------------------------------------ForumTP-------------------------------------------
	
	
	@Override
   public void saveForumTP(ForumTP forumTP) {
		// TODO 自动生成的方法存根
           this.getHibernateTemplate() .save(forumTP);
	}
	

	
	@Override
	public void updateForumTP(ForumTP forumTP) {
		// TODO 自动生成的方法存根
		this.getHibernateTemplate() .update(forumTP);

	}


	@Override
	public void deleteForumTP(long id){
		// TODO 自动生成的方法存根
		this.getHibernateTemplate() .delete(this.getHibernateTemplate() .get(ForumTP.class, id));

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ForumTP> listForumTPByPostId(long post_id)
	{
		return this.getHibernateTemplate() .find("from ForumTP l where l.forumPost.id="+post_id);
	}
	
	@Override
	public ForumTP listForumTPById(long id)

	{
		return this.getHibernateTemplate() .get(ForumTP.class, id);
	}
	
	
	
	//----------------------------------------Tpjl-----------------------------------
	
	@Override
	public void saveTpjl(Tpjl tpjl) {
			// TODO 自动生成的方法存根
	           this.getHibernateTemplate() .save(tpjl);
		}
	
	@Override
	public void deleteTpjl(long id){
		// TODO 自动生成的方法存根
		this.getHibernateTemplate() .delete(this.getHibernateTemplate() .get(Tpjl.class, id));

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Tpjl> listTpjlByUser(long id){
		// TODO 自动生成的方法存根
		return this.getHibernateTemplate() .find("from Tpjl p where p.userInfo.id="+id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Tpjl> listTpjlByForumTP(long id){
		// TODO 自动生成的方法存根
		return this.getHibernateTemplate() .find("from Tpjl p where p.forumTp.id="+id);
	}
	

	// -----------------------------排序-------------------------------------------
		@SuppressWarnings("unchecked")
		@Override
		public List<ForumPost> listPostByKey(String keyword, String lab, String sub, String con) {
			// TODO Auto-generated method stub
			List<ForumPost> list = new ArrayList<ForumPost>();
			List<ForumPost> list1 = new ArrayList<ForumPost>();
			List<ForumPost> list2 = new ArrayList<ForumPost>();
			List<ForumPost> list3 = new ArrayList<ForumPost>();
			List<ForumPost> list4 = new ArrayList<ForumPost>();
			List<ForumPost> list5 = new ArrayList<ForumPost>();

            if(lab.equals("1")){
            	list4 = this.getHibernateTemplate().find(
    					"from ForumPost where keywordA = '" + keyword + "' and "
    							+ "(postStatus = 4 or postStatus = 5)");
            	list5 = this.getHibernateTemplate().find(
    					"from ForumPost where (keywordB = '" + keyword + "' or "
    							+ "keywordC = '" + keyword+"') and (postStatus = 4 or postStatus = 5) and (keywordA <> '"+keyword+"' " +
    									"or keywordA is null)");
            	if(sub.equals("1")&&con.equals("1")){
            		list1 = this
        					.getHibernateTemplate()
        					.find("from ForumPost where (subject like '%"+ keyword + "%' and "
        							+ "postContent like '%"+ keyword + "%') and (postStatus = 4 or postStatus = 5) and (keywordA <> '"
        							+ keyword + "' or keywordA is null) and (keywordB <> '"
        							+ keyword + "' or keywordB is null) and (keywordC <> '"
        							+ keyword + "' or keywordC is null)");
            		list2 = this
        					.getHibernateTemplate()
        					.find("from ForumPost where (subject like '%"+ keyword + "%' and "
        							+ "postContent not like '%"+ keyword
        							+ "%') and (postStatus = 4 or postStatus = 5) and (keywordA <> '"
        							+ keyword + "' or keywordA is null) and (keywordB <> '"
        							+ keyword + "' or keywordB is null) and (keywordC <> '"
        							+ keyword + "' or keywordC is null)");
            		list3 = this
        					.getHibernateTemplate()
        					.find("from ForumPost where (subject not like '%"+ keyword
        							+ "%' and postContent like '%"+ keyword
        							+ "%') and (postStatus = 4 or postStatus = 5) and (keywordA <> '"
        							+ keyword + "' or keywordA is null) and (keywordB <> '"
        							+ keyword + "' or keywordB is null) and (keywordC <> '"
        							+ keyword + "' or keywordC is null)");
            		
            	}else if(sub.equals("1")&&!con.equals("1")){
            		list2 = this
        					.getHibernateTemplate()
        					.find("from ForumPost where subject like '%"+ keyword + "%' " +
        							"and (postStatus = 4 or postStatus = 5) and (keywordA <> '"
        							+ keyword + "' or keywordA is null) and (keywordB <> '"
        							+ keyword + "' or keywordB is null) and (keywordC <> '"
        							+ keyword + "' or keywordC is null)");
            		
            	}else if(!sub.equals("1")&&con.equals("1")){
            		list3 = this
        					.getHibernateTemplate()
        					.find("from ForumPost where (postContent like '%"+ keyword
        							+ "%') and (postStatus = 4 or postStatus = 5) and (keywordA <> '"
        							+ keyword + "' or keywordA is null) and (keywordB <> '"
        							+ keyword + "' or keywordB is null) and (keywordC <> '"
        							+ keyword + "' or keywordC is null)");
            	}
            	
            }else{
            	
            	if(sub.equals("1")&&con.equals("1")){
            		list1 = this
        					.getHibernateTemplate()
        					.find("from ForumPost where (subject like '%"+ keyword + "%' and "
        							+ "postContent like '%"+ keyword + "%') and (postStatus = 4 or postStatus = 5)");
            		list2 = this
        					.getHibernateTemplate()
        					.find("from ForumPost where (subject like '%"+ keyword + "%' and "
        							+ "postContent not like '%"+ keyword
        							+ "%') and (postStatus = 4 or postStatus = 5)");
            		list3 = this
        					.getHibernateTemplate()
        					.find("from ForumPost where (subject not like '%"+ keyword
        							+ "%' and postContent like '%"+ keyword
        							+ "%') and (postStatus = 4 or postStatus = 5)");
            	}else if(sub.equals("1")&&!con.equals("1")){
            		list2 = this
        					.getHibernateTemplate()
        					.find("from ForumPost where subject like '%"+ keyword + "%' and (postStatus = 4 or postStatus = 5)");
            	}else if(!sub.equals("1")&&con.equals("1")){
            		list3 = this
        					.getHibernateTemplate()
        					.find("from ForumPost where postContent like '%"+ keyword
        							+ "%' and (postStatus = 4 or postStatus = 5)");
            	}
            }
				
			list.addAll(list4);
			list.addAll(list5);
			list.addAll(list1);
			list.addAll(list2);
			list.addAll(list3);

			return list;
		}

		@SuppressWarnings("unchecked")
		@Override
		public List<ForumPost> listPostByTime(String keyword, String lab, String sub, String con) {
			// TODO Auto-generated method stub
			List<ForumPost> list = new ArrayList<ForumPost>();
			if(lab.equals("1")){
				if(sub.equals("1")&&con.equals("1")){
					list = this.getHibernateTemplate().find(
							"from ForumPost where subject like '%" + keyword + "%' or "
									+ "postContent like '%" + keyword
									+ "%' or keywordA = '" + keyword + "' or keywordC = '"
									+ keyword + "' or keywordB = '" + keyword + "' "
									+ " and (postStatus = 4 or postStatus = 5) order by postDate desc");
					
				}else if(sub.equals("1")&&!con.equals("1")){
					list = this.getHibernateTemplate().find(
							"from ForumPost where subject like '%" + keyword + "%' or "
									+ "keywordA = '" + keyword + "' or keywordC = '"
									+ keyword + "' or keywordB = '" + keyword + "' "
									+ " and (postStatus = 4 or postStatus = 5) order by postDate desc");
					
				}else if(!sub.equals("1")&&con.equals("1")){
					list = this.getHibernateTemplate().find(
							"from ForumPost where postContent like '%" + keyword
									+ "%' or keywordA = '" + keyword + "' or keywordC = '"
									+ keyword + "' or keywordB = '" + keyword + "' "
									+ " and (postStatus = 4 or postStatus = 5) order by postDate desc");
					
				}	
			}else{
				if(sub.equals("1")&&con.equals("1")){
					list = this.getHibernateTemplate().find(
							"from ForumPost where subject like '%" + keyword + "%' or "
									+ "postContent like '%" + keyword +"%'"
									+ " and (postStatus = 4 or postStatus = 5) order by postDate desc");
					
				}else if(sub.equals("1")&&!con.equals("1")){
					list = this.getHibernateTemplate().find(
							"from ForumPost where subject like '%" + keyword + "%' or "
									+ "and (postStatus = 4 or postStatus = 5) order by postDate desc");
					
				}else if(!sub.equals("1")&&con.equals("1")){
					list = this.getHibernateTemplate().find(
							"from ForumPost where postContent like '%" + keyword +"%'"
									+ " and (postStatus = 4 or postStatus = 5) order by postDate desc");
					
				}
			}
			
			return list;
		}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.Forum_postDao#listPostByUser(long)
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
		return this.getHibernateTemplate().find("from ForumPost where userInfo.id = '"+userId+"'");
	}

	@Override
	public PageModel listPostByPost(int offset, int pageSize, long postId) {
		// TODO Auto-generated method stub
		// 得到总记录数
				String queryCountHql = "select count(*) from ForumPost where userInfo.id='"
						+ postId + "'";
				Query query = getSession().createQuery(queryCountHql);
				int total = ((Long) query.uniqueResult()).intValue();

				String hql = "from ForumPost where userInfo.id='" + postId
						+ "' order by postDate desc";
				List datas = this.getSession().createQuery(hql).setFirstResult(offset)
						.setMaxResults(pageSize).list();

				// 得到结果集
				PageModel pm = new PageModel();
				pm.setTotal(total);
				pm.setDatas(datas);
				pm.setOffset(offset);

				return pm;
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.Forum_postDao#listPostBySql(java.lang.String)
	 * @param sql
	 * @return
	 *
	 * @author Robust
	 * @date 2014年11月5日
	 *
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ForumPost> listPostBySql(String sql) {
		// TODO 自动生成的方法存根
		List<ForumPost> listQuestion=this.getHibernateTemplate().find(sql);
		return listQuestion;
	}

	@Override
	public PageModel listPostBySQL(int offset, int pageSize,
			String queryCountHql, String hql) {
		// TODO Auto-generated method stub
		
		Query query = getSession().createQuery(queryCountHql);
		int total = ((Long) query.uniqueResult()).intValue();
	
		List datas = this.getSession().createQuery(hql).setFirstResult(offset)
				.setMaxResults(pageSize).list();

		// 得到结果集
		PageModel pm = new PageModel();
		pm.setTotal(total);
		pm.setDatas(datas);
		pm.setOffset(offset);

		return pm;
	}


	
	
}
