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

import com.bbsBlog.dao.FlagHiDao;
import com.bbsBlog.entity.FlagHi;
import com.bbsBlog.util.PageModel;

/**
 * @author Robust
 *
 * @date 2014年7月28日
 *
 */
@Repository("flagHiDao")
public class FlagHiDaoImpl extends HibernateDaoSupport implements FlagHiDao {

	@Resource
	public void setSessionFacotry(SessionFactory sessionFacotry) {
		super.setSessionFactory(sessionFacotry);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.FlagHiDao#saveFlagHi(com.bbsBlog.entity.FlagHi)
	 */
	@Override
	public void saveFlagHi(FlagHi flagHi) {
		// TODO 自动生成的方法存根

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.FlagHiDao#updateFlagHi(com.bbsBlog.entity.FlagHi)
	 */
	@Override
	public void updateFlagHi(FlagHi flagHi) {
		// TODO 自动生成的方法存根

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.FlagHiDao#deleteFlagHi(long)
	 */
	@Override
	public void deleteFlagHi(long id) {
		// TODO 自动生成的方法存根

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.FlagHiDao#listFlagHi()
	 */
	@Override
	public List<FlagHi> listFlagHi() {
		// TODO 自动生成的方法存根
		return null;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.FlagHiDao#listFlagHi(int, int)
	 * 
	 * @param offset
	 * 
	 * @param pageSize
	 * 
	 * @return
	 * 
	 * @author Robust
	 * 
	 * @date 2014年8月13日
	 */
	@Override
	public PageModel listFlagHi(int offset, int pageSize) {
		// TODO 自动生成的方法存根

		// 得到总记录数
		String queryCountHql = "select count(*) from FlagHi";
		Query query = getSession().createQuery(queryCountHql);
		int total = ((Long) query.uniqueResult()).intValue();

		String hql = "from FlagHi order by doTime desc";
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
