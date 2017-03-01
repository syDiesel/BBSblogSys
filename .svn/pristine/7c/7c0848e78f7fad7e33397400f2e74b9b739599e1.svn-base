/**
 * 
 */
package com.bbsBlog.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bbsBlog.dao.CashDao;
import com.bbsBlog.entity.Cash;
import com.bbsBlog.service.CashService;


/**
 * 
 * @author 曦风
 *
 * @date 2014-9-14
 *
 * @param 下午9:41:47
 */
@Service("cashService")
public class CashServiceImpl implements CashService {

	@Resource
	private CashDao cashDao;

	public CashDao getCashDao() {
		return cashDao;
	}

	public void setCashDao(CashDao cashDao) {
		this.cashDao = cashDao;
	}

	
	@Override
	public void saveCash(Cash cash) {
		// TODO 自动生成的方法存根

		this.cashDao.saveCash(cash);
	}

	
	@Override
	public void updateCash(Cash cash) {
		// TODO 自动生成的方法存根
		this.cashDao.updateCash(cash);

	}

	
	@Override
	public void deleteCash(long id) {
		// TODO 自动生成的方法存根

		this.cashDao.deleteCash(id);
	}

	@Override
	public List<Cash> listCash() {
		// TODO Auto-generated method stub
		return this.cashDao.listCash();
	}

	@Override
	public List<Cash> listCashBySql(String sql) {
		// TODO Auto-generated method stub
		return this.cashDao.listCashBySql(sql);
	}
}
