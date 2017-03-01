/**
 * 
 */
package com.bbsBlog.service;

import java.util.List;

import com.bbsBlog.entity.RechargeHi;

/**
 * @author Robust
 *
 * @date 2014年7月30日
 *
 */
public interface Recharge_hiService {
	
	public void saveRecharge_hi(RechargeHi recharge);

	public void updateRecharge_hi(RechargeHi recharge);

	public void deleteRecharge_hi(long id);

	public List<RechargeHi> listRecharge_hi();
}