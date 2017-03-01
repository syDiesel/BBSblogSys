/**
 * 
 */
package com.bbsBlog.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.bbsBlog.dao.BlogDao;
import com.bbsBlog.entity.Blog;
import com.bbsBlog.entity.UserInfo;
import com.bbsBlog.util.PageModel;

/**
 * @author Robust
 *
 * @date 2014年7月28日
 *
 */
@Repository("blogDao")
public class BlogDaoImpl extends HibernateDaoSupport implements BlogDao {

	@Resource
	public void setSessionFacotry(SessionFactory sessionFacotry) {
		super.setSessionFactory(sessionFacotry);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.BlogDao#saveBlog(com.bbsBlog.entity.Blog)
	 */
	@Override
	public void saveBlog(Blog blog) {
		// TODO 自动生成的方法存根
		this.getHibernateTemplate().save(blog);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.BlogDao#updateBlog(com.bbsBlog.entity.Blog)
	 */
	@Override
	public void updateBlog(Blog blog) {
		// TODO 自动生成的方法存根
		this.getHibernateTemplate().update(blog);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.BlogDao#deleteBlog(long)
	 */
	@Override
	public void deleteBlog(long id) {
		// TODO 自动生成的方法存根
		this.getHibernateTemplate().delete(
				this.getHibernateTemplate().get(Blog.class, id));
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.BlogDao#listBlog()
	 */
	@Override
	public List<Blog> listBlog() {
		// TODO 自动生成的方法存根
		return this.getHibernateTemplate().find("from Blog ");
	}

	public PageModel listBlog(int offset, int pageSize) {
		// TODO 自动生成的方法存根

		// 得到总记录数
		String queryCountHql = "select count(*) from Blog";
		Query query = getSession().createQuery(queryCountHql);
		int total = ((Long) query.uniqueResult()).intValue();

		/*String hql = "from Blog order by blogUp+0 asc";*/
		String hql = "from Blog";
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
	 * @see com.bbsBlog.dao.BlogDao#listBlogBySql(java.lang.String)
	 * 
	 * @param sql
	 * 
	 * @return
	 * 
	 * @author Robust
	 * 
	 * @date 2014年8月14日
	 */
	@Override
	public List<Blog> listBlogBySql(String sql) {
		// TODO 自动生成的方法存根

		return this.getHibernateTemplate().find(sql);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.BlogDao#listBlogById(long)
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @author Robust
	 * 
	 * @date 2014年9月16日
	 */
	@Override
	public Blog listBlogById(long id) {
		// TODO 自动生成的方法存根
		return this.getHibernateTemplate().get(Blog.class, id);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.BlogDao#listBlog(int, int, java.lang.String,
	 * java.lang.String)
	 * 
	 * @param offset
	 * 
	 * @param pageSize
	 * 
	 * @param queryCountHql
	 * 
	 * @param hql
	 * 
	 * @return
	 * 
	 * @author Robust
	 * 
	 * @date 2014年10月5日
	 */
	@Override
	public PageModel listBlog(int offset, int pageSize, String queryCountHql,
			String hql) {
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Blog> findBlogByUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from Blog b where b.userInfo.id='"+userInfo.getId()+"'");
	}
}
