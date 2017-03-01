/**
 * 
 */
package com.bbsBlog.service;

import java.util.List;

import com.bbsBlog.entity.WealthTradeHi;

/**
 * @author Robust
 *
 * @date 2014年7月30日
 *
 */
public interface WealthTradeHiService {
	
	public void saveWealthTradeHi(WealthTradeHi wealthTrade);

	public void updateWealthTradeHi(WealthTradeHi wealthTrade);

	public void deleteWealthTradeHi(long id);

	public List<WealthTradeHi> listWealthTradeHi();
}
