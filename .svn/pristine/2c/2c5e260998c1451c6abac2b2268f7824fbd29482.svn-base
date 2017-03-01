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

import com.bbsBlog.dao.MasterDao;
import com.bbsBlog.entity.Master;
import com.bbsBlog.util.PageModel;

/**
 * @author Robust
 *
 * @date 2014年7月28日
 *
 */
@Repository("masterDao")
public class MasterDaoImpl extends HibernateDaoSupport implements MasterDao {
	
	@Resource
	public void setSessionFacotry(SessionFactory sessionFacotry) {
		super.setSessionFactory(sessionFacotry);
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.MasterDao#saveMaster(com.bbsBlog.entity.Master)
	 */
	@Override
	public void saveMaster(Master master) {
		// TODO 自动生成的方法存根
		this.getHibernateTemplate().save(master);
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.MasterDao#updateMaster(com.bbsBlog.entity.Master)
	 */
	@Override
	public void updateMaster(Master master) {
		// TODO 自动生成的方法存根
		this.getHibernateTemplate().update(master);
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.MasterDao#deleteMaster(long)
	 */
	@Override
	public void deleteMaster(long id) {
		// TODO 自动生成的方法存根
		this.getHibernateTemplate().delete(getHibernateTemplate().get(Master.class, id));
	}
	
	@Override
	public List<Master> listMaster() {
		// TODO 自动生成的方法存根
		return this.getHibernateTemplate().find("from Master");
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.MasterDao#listMaster()
	 */
	@Override
	public PageModel listMaster(int offset, int pageSize) {
		// TODO 自动生成的方法存根

		// 得到总记录数
		String queryCountHql = "select count(*) from Master";
		Query query = getSession().createQuery(queryCountHql);
		int total = ((Long) query.uniqueResult()).intValue();

		String hql = "from Master order by label asc";
		List datas = this.getSession().createQuery(hql).setFirstResult(offset)
				.setMaxResults(pageSize).list();
		
		//得到结果集
		PageModel pm = new PageModel();
		pm.setTotal(total);
		pm.setDatas(datas);
		pm.setOffset(offset);
		
		
		return pm;
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.MasterDao#listMasterById(long)
	 * @param id
	 * @return
	 *
	 * @author Robust
	 * @date 2014年8月11日
	 *
	 */
	@Override
	public Master listMasterById(long id) {
		// TODO 自动生成的方法存根
		return this.getHibernateTemplate().get(Master.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Master> listMasterByBoard(long board_id){
	
		// TODO 自动生成的方法存根
		return this.getHibernateTemplate().find("from Master  m where m.board.id="+board_id);
	}

}
