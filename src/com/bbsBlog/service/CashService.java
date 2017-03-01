/**
 * 
 */
package com.bbsBlog.service;

import java.util.List;

import com.bbsBlog.entity.Cash;


/**
 * 
 * @author 曦风
 *
 * @date 2014-9-14
 *
 * @param 下午9:37:45
 */
public interface CashService {
	

	public void saveCash(Cash cash);

	public void updateCash(Cash cash);

	public void deleteCash(long id);

	public List<Cash> listCash();
	
	public List<Cash> listCashBySql(String sql);

}
