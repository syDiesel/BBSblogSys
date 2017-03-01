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

import com.bbsBlog.dao.FilterWordDao;
import com.bbsBlog.entity.FilterWord;
import com.bbsBlog.util.PageModel;

/**
 * @author Robust
 *
 * @date 2014年7月28日
 *
 */
@Repository("filterWordDao")
public class FilterWordDaoImpl extends HibernateDaoSupport implements
		FilterWordDao {

	@Resource
	public void setSessionFacotry(SessionFactory sessionFacotry) {
		super.setSessionFactory(sessionFacotry);
	}

	/**
	 * @return hibernateTemplate
	 */

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * com.bbsBlog.dao.FilterWordDao#saveFilterWord(com.bbsBlog.entity.FilterWord
	 * )
	 */
	@Override
	public void saveFilterWord(FilterWord filterWord) {
		// TODO 自动生成的方法存根
		this.getHibernateTemplate().save(filterWord);

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * com.bbsBlog.dao.FilterWordDao#updateFilterWord(com.bbsBlog.entity.FilterWord
	 * )
	 */
	@Override
	public void updateFilterWord(FilterWord filterWord) {
		// TODO 自动生成的方法存根
		this.getHibernateTemplate().update(filterWord);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.FilterWordDao#deleteFilterWord(long)
	 */
	@Override
	public void deleteFilterWord(long id) {
		// TODO 自动生成的方法存根
		this.getHibernateTemplate().delete(
				this.getHibernateTemplate().get(FilterWord.class, id));
	}
	
	

	@Override
	public FilterWord listFilterWordByID(long id){
		return this.getHibernateTemplate().get(FilterWord.class, id);
	}
	
	@Override
	public List<FilterWord> listFilterWord(){
		return this.getHibernateTemplate().find("from FilterWord");
	}
	
	
	
	
	

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.FilterWordDao#listFilterWord()
	 * 
	 * @param  offset 起始页码
	 *         pagesize 每一页的数量
	 *         
	 * desc 分页列出信息
	 */
	
	@Override
	public PageModel listFilterWord(int offset, int pageSize) {
		// TODO 自动生成的方法存根

		// 得到总记录数
		String queryCountHql = "select count(*) from FilterWord";
		Query query = getSession().createQuery(queryCountHql);
		int total = ((Long) query.uniqueResult()).intValue();

		String hql = "from FilterWord order by find asc";
		List datas = this.getSession().createQuery(hql).setFirstResult(offset)
				.setMaxResults(pageSize).list();
		
		//得到结果集
		PageModel pm = new PageModel();
		pm.setTotal(total);
		pm.setDatas(datas);
		pm.setOffset(offset);
		
		
		return pm;
	}
	
	

}
