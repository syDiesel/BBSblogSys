/**
 * 
 */
package com.bbsBlog.dao;

import java.util.List;

import com.bbsBlog.entity.WealthTradeHi;

/**
 * @author Robust
 *
 * @date 2014年7月26日
 *
 */
public interface WealthTradeHiDao {
	
	public void saveWealthTradeHi(WealthTradeHi wealthTrade);

	public void updateWealthTradeHi(WealthTradeHi wealthTrade);

	public void deleteWealthTradeHi(long id);

	public List<WealthTradeHi> listWealthTradeHi();
}
