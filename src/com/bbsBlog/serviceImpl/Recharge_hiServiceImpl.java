/**
 * 
 */
package com.bbsBlog.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bbsBlog.dao.RechargeHiDao;
import com.bbsBlog.entity.RechargeHi;
import com.bbsBlog.service.Recharge_hiService;

/**
 * @author Robust
 *
 * @date 2014年7月30日
 *
 */
@Service("recharge_hiService")
public class Recharge_hiServiceImpl implements Recharge_hiService {

	@Resource
	private RechargeHiDao rechargeHiDao;

	/**
	 * @return recharge_hiDao
	 */
	public RechargeHiDao getRecharge_hiDao() {
		return rechargeHiDao;
	}

	/**
	 * @param rechargeHiDao
	 *            要设置的 recharge_hiDao
	 */
	public void setRecharge_hiDao(RechargeHiDao rechargeHiDao) {
		this.rechargeHiDao = rechargeHiDao;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * com.bbsBlog.service.Recharge_hiService#saveRecharge_hi(com.bbsBlog.entity
	 * .Recharge_hi)
	 */
	@Override
	public void saveRecharge_hi(RechargeHi recharge) {
		// TODO 自动生成的方法存根

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * com.bbsBlog.service.Recharge_hiService#updateRecharge_hi(com.bbsBlog.
	 * entity.Recharge_hi)
	 */
	@Override
	public void updateRecharge_hi(RechargeHi recharge) {
		// TODO 自动生成的方法存根

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.service.Recharge_hiService#deleteRecharge_hi(long)
	 */
	@Override
	public void deleteRecharge_hi(long id) {
		// TODO 自动生成的方法存根

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.service.Recharge_hiService#listRecharge_hi()
	 */
	@Override
	public List<RechargeHi> listRecharge_hi() {
		// TODO 自动生成的方法存根
		return null;
	}

}
