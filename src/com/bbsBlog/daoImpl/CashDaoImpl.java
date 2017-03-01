/**
 * 
 */
package com.bbsBlog.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.bbsBlog.dao.CashDao;
import com.bbsBlog.entity.Cash;


/**
 * 
 * @author 曦风
 *
 * @date 2014-9-14
 *
 * @param 下午9:34:58
 */
@Repository("cashDao")
public class CashDaoImpl implements CashDao {
	
	@Resource
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	
	@Override
	public void saveCash(Cash cash) {
		// TODO 自动生成的方法存根
		this.hibernateTemplate.save(cash);

	}

	
	@Override
	public void updateCash(Cash cash) {
		// TODO 自动生成的方法存根
		this.hibernateTemplate.update(cash);

	}

	
	@Override
	public void deleteCash(long id) {
		// TODO 自动生成的方法存根
		this.hibernateTemplate.delete(this.hibernateTemplate.get(Cash.class, id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cash> listCash() {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.find("from Cash");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cash> listCashBySql(String sql) {
		// TODO Auto-generated method stub
		List<Cash> listCash = this.hibernateTemplate.find(sql);
		return listCash;
	}
}
