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

import com.bbsBlog.dao.BlogHiDao;
import com.bbsBlog.entity.BlogHI;
import com.bbsBlog.entity.UserInfo;

/**
 * @author Robust
 *
 * @date 2014年9月17日
 *
 */
@Repository("blogHiDao")
public class BlogHiDaoImpl extends HibernateDaoSupport implements BlogHiDao {

	@Resource
	public void setSessionFacotry(SessionFactory sessionFacotry) {
		super.setSessionFactory(sessionFacotry);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.BlogHiDao#saveBlogHi(com.bbsBlog.entity.BlogHI)
	 * 
	 * @param blogHi
	 * 
	 * @author Robust
	 * 
	 * @date 2014年9月17日
	 */
	@Override
	public void saveBlogHi(BlogHI blogHi) {
		// TODO 自动生成的方法存根
		this.getHibernateTemplate().save(blogHi);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.BlogHiDao#deleteBlogHi(long)
	 * 
	 * @param id
	 * 
	 * @author Robust
	 * 
	 * @date 2014年9月17日
	 */
	@Override
	public void deleteBlogHi(long id) {
		// TODO 自动生成的方法存根
		this.getHibernateTemplate().delete(this.getHibernateTemplate().get(BlogHI.class,
				id));
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.BlogHiDao#updateBlogHi(com.bbsBlog.entity.BlogHI)
	 * 
	 * @param blogHi
	 * 
	 * @author Robust
	 * 
	 * @date 2014年9月17日
	 */
	@Override
	public void updateBlogHi(BlogHI blogHi) {
		// TODO 自动生成的方法存根
		this.getHibernateTemplate().update(blogHi);
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.BlogHiDao#listBlogHiByUserAndBlog(long, long)
	 * @param UserInfoId
	 * @param BlogId
	 * @return
	 *
	 * @author Robust
	 * @date 2014年9月17日
	 *
	 */
	@Override
	public List<BlogHI> listBlogHiByUserAndBlog(long userInfoId, long blogId,String time) {
		// TODO 自动生成的方法存根
		String sql = "from BlogHI where userInfo.id = '"+userInfoId+"' and blogLog.id = '"+blogId+"' and time='"+time+"'";
		List<BlogHI> blogHis  = this.getHibernateTemplate().find(sql);
		
		
		return blogHis;
	}

	@Override
	public UserInfo listUserByBlogLog(long id) {
		// TODO Auto-generated method stub
		return (UserInfo) this.getHibernateTemplate().find("select b.userInfo from BlogHI b where b.bloglog.id='"+id+"'");
	}
	
	
	public int listCount(String queryCountHql) {
		// TODO 自动生成的方法存根

		// 得到总记录数

		Query query = getSession().createQuery(queryCountHql);
		int total = ((Long) query.uniqueResult()).intValue();
		return total;
	}

}
