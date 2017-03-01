/**
 * 
 */
package com.bbsBlog.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.bbsBlog.dao.RechargeHiDao;
import com.bbsBlog.entity.RechargeHi;

/**
 * @author Robust
 *
 * @date 2014年7月28日
 *
 */
@Repository("recharge_hiDap")
public class Recharge_hiDaoImpl implements RechargeHiDao {
	
	@Resource
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.Recharge_hiDao#saveRecharge_hi(com.bbsBlog.entity.Recharge_hi)
	 */
	@Override
	public void saveRecharge_hi(RechargeHi recharge) {
		// TODO 自动生成的方法存根

	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.Recharge_hiDao#updateRecharge_hi(com.bbsBlog.entity.Recharge_hi)
	 */
	@Override
	public void updateRecharge_hi(RechargeHi recharge) {
		// TODO 自动生成的方法存根

	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.Recharge_hiDao#deleteRecharge_hi(long)
	 */
	@Override
	public void deleteRecharge_hi(long id) {
		// TODO 自动生成的方法存根

	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.Recharge_hiDao#listRecharge_hi()
	 */
	@Override
	public List<RechargeHi> listRecharge_hi() {
		// TODO 自动生成的方法存根
		return null;
	}

}
