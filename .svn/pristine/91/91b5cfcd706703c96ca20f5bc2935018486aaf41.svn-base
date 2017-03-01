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

import com.bbsBlog.dao.MasterApplyDao;
import com.bbsBlog.entity.MasterApply;
import com.bbsBlog.util.PageModel;

/**
 * @author Robust
 *
 * @date 2014年8月11日
 *
 */
@Repository("masterApplyDao")
public class MasterApplyDaoImpl extends HibernateDaoSupport implements
		MasterApplyDao {

	@Resource
	public void setSessionFacotry(SessionFactory sessionFacotry) {
		super.setSessionFactory(sessionFacotry);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * com.bbsBlog.dao.MasterApplyDao#saveMasterApply(com.bbsBlog.entity.MasterApply
	 * )
	 * 
	 * @param masterApply
	 * 
	 * @author Robust
	 * 
	 * @date 2014年8月11日
	 */
	@Override
	public void saveMasterApply(MasterApply masterApply) {
		// TODO 自动生成的方法存根
		this.getHibernateTemplate().save(masterApply);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.MasterApplyDao#updateMasterApply(com.bbsBlog.entity.
	 * MasterApply)
	 * 
	 * @param masterApply
	 * 
	 * @author Robust
	 * 
	 * @date 2014年8月11日
	 */
	@Override
	public void updateMasterApply(MasterApply masterApply) {
		// TODO 自动生成的方法存根
		this.getHibernateTemplate().update(masterApply);

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.MasterApplyDao#deleteMasterApply(long)
	 * 
	 * @param id
	 * 
	 * @author Robust
	 * 
	 * @date 2014年8月11日
	 */
	@Override
	public void deleteMasterApply(long id) {
		// TODO 自动生成的方法存根
		this.getHibernateTemplate().delete(this.getHibernateTemplate().get(MasterApply.class, id));

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.MasterApplyDao#listMasterApplyById(long)
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @author Robust
	 * 
	 * @date 2014年8月11日
	 */
	@Override
	public MasterApply listMasterApplyById(long id) {
		// TODO 自动生成的方法存根
		return this.getHibernateTemplate().get(MasterApply.class, id);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.MasterApplyDao#listMasterApply()
	 * 
	 * @return
	 * 
	 * @author Robust
	 * 
	 * @date 2014年8月11日
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<MasterApply> listMasterApply() {
		// TODO 自动生成的方法存根
		return this.getHibernateTemplate().find("from MasterApply");
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.MasterApplyDao#listMasterApply(int, int)
	 * 
	 * @param offset
	 * 
	 * @param pageSize
	 * 
	 * @return
	 * 
	 * @author Robust
	 * 
	 * @date 2014年8月11日
	 */
	@Override
	public PageModel listMasterApply(int offset, int pageSize) {
		// TODO 自动生成的方法存根
		System.out.println("---------------------------------");
		// 得到总记录数
		String queryCountHql = "select count(*) from MasterApply";
		Query query = getSession().createQuery(queryCountHql);
		int total = ((Long) query.uniqueResult()).intValue();

		String hql = "from MasterApply order by label asc";
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
