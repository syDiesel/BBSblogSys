/**
 * 
 */
package com.bbsBlog.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.bbsBlog.dao.BlogLogDao;
import com.bbsBlog.entity.Blog;
import com.bbsBlog.entity.BlogLog;
import com.bbsBlog.util.PageModel;

/**
 * @author Robust
 *
 * @date 2014年7月28日
 *
 */
@Repository("blogLogDao")
public class BlogLogDaoImpl extends HibernateDaoSupport implements BlogLogDao {

	@Resource
	public void setSessionFacotry(SessionFactory sessionFacotry) {
		super.setSessionFactory(sessionFacotry);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.BlogLogDao#saveBlogLog(com.bbsBlog.entity.BlogLog)
	 */
	@Override
	public void saveBlogLog(BlogLog blogLog) {
		// TODO 自动生成的方法存根
		this.getHibernateTemplate().save(blogLog);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.BlogLogDao#updateBlogLog(com.bbsBlog.entity.BlogLog)
	 */
	@Override
	public void updateBlogLog(BlogLog blogLog) {
		// TODO 自动生成的方法存根
		this.getHibernateTemplate().update(blogLog);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.BlogLogDao#deleteBlogLog(long)
	 */
	@Override
	public void deleteBlogLog(long id) {
		// TODO 自动生成的方法存根
		this.getHibernateTemplate().delete(
				this.getHibernateTemplate().get(BlogLog.class, id));
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.BlogLogDao#listBlogLog()
	 */
	@Override
	public List<BlogLog> listBlogLog() {
		// TODO 自动生成的方法存根
		return this.getHibernateTemplate().find(
				"from BlogLog where blogStatus.id = '2' order by blogTime desc");
	}

	public PageModel listBloglog(int offset, int pageSize) {
		// TODO 自动生成的方法存根

		// 得到总记录数
		String queryCountHql = "select count(*) from BlogLog where blogStatus.id = '2'";
		Query query = getSession().createQuery(queryCountHql);
		int total = ((Long) query.uniqueResult()).intValue();

		String hql = "from BlogLog where blogStatus.id = '2' order by blogTime desc ";
		List datas = this.getSession().createQuery(hql).setFirstResult(offset)
				.setMaxResults(pageSize).list();

		// 得到结果集
		PageModel pm = new PageModel();
		pm.setTotal(total);
		pm.setDatas(datas);
		pm.setOffset(offset);

		return pm;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.BlogLogDao#listBlogLogById(long)
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @author Robust
	 * 
	 * @date 2014年8月14日
	 */
	@Override
	public BlogLog listBlogLogById(long id) {
		// TODO 自动生成的方法存根
		return this.getHibernateTemplate().get(BlogLog.class, id);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.BlogLogDao#listBloglogByBlog(int, int, long)
	 * 
	 * @param offset
	 * 
	 * @param pageSize
	 * 
	 * @param BlogId
	 * 
	 * @return
	 * 
	 * @author Robust
	 * 
	 * @date 2014年9月16日
	 */
	@Override
	public PageModel listBloglogByBlog(int offset, int pageSize, long BlogId) {
		// TODO 自动生成的方法存根

		// 得到总记录数
		String queryCountHql = "select count(*) from BlogLog where blogStatus.id = '2' and blog.id='"
				+ BlogId + "'";
		Query query = getSession().createQuery(queryCountHql);
		int total = ((Long) query.uniqueResult()).intValue();

		String hql = "from BlogLog where blog.id='" + BlogId
				+ "' order by blogTime desc";
		List datas = this.getSession().createQuery(hql).setFirstResult(offset)
				.setMaxResults(pageSize).list();

		// 得到结果集
		PageModel pm = new PageModel();
		pm.setTotal(total);
		pm.setDatas(datas);
		pm.setOffset(offset);

		return pm;
	}

	/**
	 * 按相关度进行排序
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<BlogLog> listBlogLogByKey(String keyword, String lab, String sub, String con) {
		// TODO Auto-generated method stub
		List<BlogLog> list = new ArrayList<BlogLog>();
		List<BlogLog> list1 = new ArrayList<BlogLog>();
		List<BlogLog> list2 = new ArrayList<BlogLog>();
		List<BlogLog> list3 = new ArrayList<BlogLog>();
		List<BlogLog> list4 = new ArrayList<BlogLog>();
		List<BlogLog> list5 = new ArrayList<BlogLog>();
		
		if(lab.equals("1")){
			list4 = this.getHibernateTemplate().find(
					"from BlogLog where keywordA  = '" + keyword + "' and blogStatus = 2");
			list5 = this.getHibernateTemplate().find(
					"from BlogLog where (keywordB = '" + keyword + "' " +
							"or keywordC = '"+keyword+"') and (keywordA <> '"+keyword+"' " +
									"or keywordA is null) and blogStatus = 2");
			
			if(sub.equals("1")&&con.equals("1")){
				list1 = this.getHibernateTemplate().find(
						"from BlogLog where subject like '%" + keyword + "%' "
								+ "and blogContent like '%" + keyword + "%' and (keywordA <> '"
								+ keyword + "' or keywordA is null) and (keywordB <> '"
								+ keyword + "' or keywordB is null) and (keywordC <> '"
								+ keyword + "' or keywordC is null) and blogStatus = 2");
				list2 = this.getHibernateTemplate().find(
						"from BlogLog where subject like '%" + keyword + "%' "
								+ "and blogContent not like '%" + keyword + "%' and (keywordA <> '"
								+ keyword + "' or keywordA is null) and (keywordB <> '"
								+ keyword + "' or keywordB is null) and (keywordC <> '"
								+ keyword + "' or keywordC is null) and blogStatus = 2");
				list3 = this.getHibernateTemplate().find(
						"from BlogLog where blogContent like '%" + keyword + "%' "
								+ "and subject not like '%" + keyword + "%' and (keywordA <> '"
								+ keyword + "' or keywordA is null) and (keywordB <> '"
								+ keyword + "' or keywordB is null) and (keywordC <> '"
								+ keyword + "' or keywordC is null) and blogStatus = 2");
				
			}else if(sub.equals("1")&&!con.equals("1")){
				list2 = this.getHibernateTemplate().find(
						"from BlogLog where subject like '%" + keyword + "%' "
								+ "and (keywordA <> '"
								+ keyword + "' or keywordA is null) and (keywordB <> '"
								+ keyword + "' or keywordB is null) and (keywordC <> '"
								+ keyword + "' or keywordC is null) and blogStatus = 2");
				
			}else if(!sub.equals("1")&&con.equals("1")){
				list3 = this.getHibernateTemplate().find(
						"from BlogLog where blogContent like '%" + keyword + "%' and (keywordA <> '"
								+ keyword + "' or keywordA is null) and (keywordB <> '"
								+ keyword + "' or keywordB is null) and (keywordC <> '"
								+ keyword + "' or keywordC is null) and blogStatus = 2");
				
			}
			
		}else{
			if(sub.equals("1")&&con.equals("1")){
				list1 = this.getHibernateTemplate().find(
						"from BlogLog where subject like '%" + keyword + "%' "
								+ "and blogContent like '%" + keyword + "%' and blogStatus = 2");
				list2 = this.getHibernateTemplate().find(
						"from BlogLog where subject like '%" + keyword + "%' "
								+ "and blogContent not like '%" + keyword + "%' and blogStatus = 2");
				list3 = this.getHibernateTemplate().find(
						"from BlogLog where subject not like '%" + keyword + "%' "
								+ "and blogContent like '%" + keyword + "%' and blogStatus = 2");
				
			}else if(sub.equals("1")&&!con.equals("1")){
				list2 = this.getHibernateTemplate().find(
						"from BlogLog where subject like '%" + keyword + "%' "
								+ "and blogStatus = 2");
				
			}else if(!sub.equals("1")&&con.equals("1")){
				list3 = this.getHibernateTemplate().find(
						"from BlogLog where blogContent like '%" + keyword + "%' and blogStatus = 2");
			}
		}

		list.addAll(list4);
		list.addAll(list5);
		list.addAll(list1);
		list.addAll(list2);
		list.addAll(list3);
		return list;
	}

	/**
	 * 按照时间进行排序
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<BlogLog> listBlogLogByTime(String keyword, String lab, String sub, String con) {
		// TODO Auto-generated method stub

		List<BlogLog> list = new ArrayList<BlogLog>();
		System.out.println("lab:"+lab+"sub:"+sub+"con:"+con);
		if(lab.equals("1")){
			if(sub.equals("1")&&con.equals("1")){
				list = this.getHibernateTemplate().find(
						"from BlogLog where (subject like '%" + keyword + "%' "
								+ "or blogContent like '%" + keyword
								+ "%' or keywordA = '"+keyword+"' or keywordC = '"+keyword+"' or keywordB = '"+keyword+"') " +
										"  and blogStatus = 2 order by blogTime desc");
				
			}else if(sub.equals("1")&&!con.equals("1")){
				list = this.getHibernateTemplate().find(
						"from BlogLog where (subject like '%" + keyword + "%' "
								+ "or keywordA = '"+keyword+"' or keywordC = '"+keyword+"' or keywordB = '"+keyword+"') " +
										" and blogStatus = 2 order by blogTime desc");
				
			}else if(!sub.equals("1")&&con.equals("1")){
				list = this.getHibernateTemplate().find(
						"from BlogLog where (blogContent like '%" + keyword
								+ "%' or keywordA = '"+keyword+"' or keywordC = '"+keyword+"' or keywordB = '"+keyword+"') " +
										" and blogStatus = 2 order by blogTime desc");
				
			}	
		}else{
			if(sub.equals("1")&&con.equals("1")){
				list = this.getHibernateTemplate().find(
						"from BlogLog where (subject like '%" + keyword + "%' "
								+ "or blogContent like '%" + keyword
								+ "%') and blogStatus = 2 order by blogTime desc");
				
			}else if(sub.equals("1")&&!con.equals("1")){
				list = this.getHibernateTemplate().find(
						"from BlogLog where subject like '%" + keyword + "%' and blogStatus = 2 order by blogTime desc");
				
			}else if(!sub.equals("1")&&con.equals("1")){
				list = this.getHibernateTemplate().find(
						"from BlogLog where blogContent like '%" + keyword
								+ "%' and blogStatus = 2 order by blogTime desc");
				
			}
		}
		
		return list;
	}

	/*
	 * @SuppressWarnings({ "unchecked", "rawtypes" })
	 * 
	 * @Override public List listAllByKey(String keyword) { // TODO
	 * Auto-generated method stub List<Object[]> list= new ArrayList();
	 * List<Object[]> list1=this.getHibernateTemplate().find(
	 * "select subject,blogContent as content,blogTime as time from BlogLog " +
	 * "where subject like '%"
	 * +keyword+"%' and blogContent like '%"+keyword+"%' union " +
	 * "(select subject,postContent as content,postDate as time from  ForumPost "
	 * + "where subject like '%"+keyword+"%' and postContent like '%"+keyword+
	 * "%') union " +
	 * "(select qSubject as subject,qContent as content,qTime as time from Question "
	 * + "where qSubject like '%"+keyword+"%' and qContent like '%"+keyword+
	 * "%') union " +
	 * "(select attachName as subject,attachDesc as content,attachTime as time from Attachment"
	 * +
	 * "where attachName like '%"+keyword+"%' and attachDesc like '%"+keyword+"%')"
	 * ); List<Object[]> list2=this.getHibernateTemplate().find(
	 * "select subject,blogContent as content,blogTime as time from BlogLog " +
	 * "where subject like '%"
	 * +keyword+"%' and blogContent not like '%"+keyword+"%' union " +
	 * "(select subject,postContent as content,postDate as time from  ForumPost "
	 * +
	 * "where subject like '%"+keyword+"%' and postContent not like '%"+keyword
	 * +"%') union " +
	 * "(select qSubject as subject,qContent as content,qTime as time from Question "
	 * + "where qSubject like '%"+keyword+"%' and qContent not like '%"+keyword+
	 * "%') union " +
	 * "(select attachName as subject,attachDesc as content,attachTime as time from Attachment"
	 * +
	 * "where attachName like '%"+keyword+"%' and attachDesc not like '%"+keyword
	 * +"%')"); List<Object[]> list3=this.getHibernateTemplate().find(
	 * "select subject,blogContent as content,blogTime as time from BlogLog " +
	 * "where subject not like '%"
	 * +keyword+"%' and blogContent like '%"+keyword+"%' union " +
	 * "(select subject,postContent as content,postDate as time from  ForumPost "
	 * +
	 * "where subject not like '%"+keyword+"%' and postContent like '%"+keyword
	 * +"%') union " +
	 * "(select qSubject as subject,qContent as content,qTime as time from Question "
	 * + "where qSubject not like '%"+keyword+"%' and qContent like '%"+keyword+
	 * "%') union " +
	 * "(select attachName as subject,attachDesc as content,attachTime as time from Attachment"
	 * +
	 * "where attachName not like '%"+keyword+"%' and attachDesc like '%"+keyword
	 * +"%')");
	 * 
	 * list.addAll(list1); list.addAll(list2); list.addAll(list3); return list;
	 * }
	 * 
	 * @SuppressWarnings({ "rawtypes", "unchecked" })
	 * 
	 * @Override public List listAllByTime(String keyword) { // TODO
	 * Auto-generated method stub List<Object[]> list=
	 * this.getSession().createSQLQuery
	 * ("select subject,blog_content as content,blog_time as time from BlogLog "
	 * +
	 * "where subject like '%三方%' or blog_content like '%三方%' order by time desc"
	 * +
	 * "(select subject,post_content as content,post_date as time from  ForumPost "
	 * + "where subject like '%三方%' or post_content like '%三方%') " +
	 * "(select q_subject as subject,q_content as content,q_time as time from Question "
	 * + "where q_subject like '%三方%' or q_content like '%三方%')" +
	 * "(select attach_name as subject,attach_desc as content,attach_time as time from Attachment"
	 * + "where attach_name like '%三方%' or attach_desc like '%三方%') ").list();
	 * return list; }
	 */

	@Override
	public List<BlogLog> listBlogByBoard(long board_id) {
		// TODO 自动生成的方法存根
		return this.getHibernateTemplate().find(
				"from BlogLog b1 where b1.board.id=" + board_id
						+ " and blogStatus.id = '2' order by cast(b1.blog.visited as integer) desc");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BlogLog> listBlogLogByBlogId(long id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find(
				"from BlogLog b where b.blog.id='" + id + "' and blogStatus.id = '2' ");
	}

	public PageModel listBloglogBySQL(int offset, int pageSize,
			String queryCountHql, String hql) {
		// TODO 自动生成的方法存根

		// 得到总记录数
		/*
		 * String queryCountHql = "select count(*) from BlogLog where blog.id='"
		 * + BlogId + "'";
		 */
		Query query = getSession().createQuery(queryCountHql);
		int total = ((Long) query.uniqueResult()).intValue();
		/*
		 * String hql = "from BlogLog where blog.id='" + BlogId +
		 * "' order by blogTime desc";
		 */
		List datas = this.getSession().createQuery(hql).setFirstResult(offset)
				.setMaxResults(pageSize).list();

		// 得到结果集
		PageModel pm = new PageModel();
		pm.setTotal(total);
		pm.setDatas(datas);
		pm.setOffset(offset);

		return pm;
	}

	public int listCount(String queryCountHql) {
		// TODO 自动生成的方法存根

		// 得到总记录数

		Query query = getSession().createQuery(queryCountHql);
		int total = ((Long) query.uniqueResult()).intValue();
		return total;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BlogLog> listBlogLogBySql(String sql) {
		// TODO Auto-generated method stub

		List<BlogLog> listBlog = this.getHibernateTemplate().find(sql);
		return listBlog;
	}

}
