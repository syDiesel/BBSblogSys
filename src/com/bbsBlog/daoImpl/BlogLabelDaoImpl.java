/**
 * 
 */
package com.bbsBlog.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.bbsBlog.dao.BlogLabelDao;
import com.bbsBlog.entity.BlogLabel;

/**
 * @author Robust
 *
 * @date 2014年8月20日
 *
 */
@Repository("blogLabelDao")
public class BlogLabelDaoImpl extends HibernateDaoSupport implements
		BlogLabelDao {
	@Resource
	public void setSessionFacotry(SessionFactory sessionFacotry) {
		super.setSessionFactory(sessionFacotry);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * com.bbsBlog.dao.BlogLabelDao#saveBlogLabel(com.bbsBlog.entity.BlogLabel)
	 * 
	 * @param blogLabel
	 * 
	 * @author Robust
	 * 
	 * @date 2014年8月20日
	 */
	@Override
	public void saveBlogLabel(BlogLabel blogLabel) {
		// TODO 自动生成的方法存根
		this.getHibernateTemplate().save(blogLabel);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * com.bbsBlog.dao.BlogLabelDao#updateBlogLabel(com.bbsBlog.entity.BlogLabel
	 * )
	 * 
	 * @param blogLabel
	 * 
	 * @author Robust
	 * 
	 * @date 2014年8月20日
	 */
	@Override
	public void updateBlogLabel(BlogLabel blogLabel) {
		// TODO 自动生成的方法存根

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.BlogLabelDao#deleteBlogLabel(long)
	 * 
	 * @param id
	 * 
	 * @author Robust
	 * 
	 * @date 2014年8月20日
	 */
	@Override
	public void deleteBlogLabel(long id) {
		// TODO 自动生成的方法存根
		this.getHibernateTemplate().delete(this.getHibernateTemplate().get(
				BlogLabel.class, id));
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.BlogLabelDao#listBlogLabel()
	 * 
	 * @author Robust
	 * 
	 * @date 2014年8月28日
	 */
	@Override
	public List<BlogLabel> listBlogLabel() {
		// TODO 自动生成的方法存根
		return this.getHibernateTemplate().find("from BlogLabel");
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.BlogLabelDao#listBlogLabelByLog()
	 * 
	 * @return
	 * 
	 * @author Robust
	 * 
	 * @date 2014年8月28日
	 */
	@Override
	public List<BlogLabel> listBlogLabelByLog(long id) {
		// TODO 自动生成的方法存根
		return this.getHibernateTemplate().find("from BlogLabel where blogLog.id='"
				+ id + "'");
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.BlogLabelDao#listBlogLabelByLabel(long)
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @author Robust
	 * 
	 * @date 2014年10月9日
	 */
	@Override
	public List<BlogLabel> listBlogLabelByLabel(long id) {
		// TODO 自动生成的方法存根
		return this.getHibernateTemplate().find("from BlogLabel where label.id='"
				+ id + "'");
	}

	public int listCount(String queryCountHql) {
		// TODO 自动生成的方法存根

		// 得到总记录数

		Query query = getSession().createQuery(queryCountHql);
		int total = ((Long) query.uniqueResult()).intValue();
		return total;
	}

}
