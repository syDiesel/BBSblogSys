/**
 * 
 */
package com.bbsBlog.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bbsBlog.dao.WealthTradeHiDao;
import com.bbsBlog.entity.WealthTradeHi;
import com.bbsBlog.service.WealthTradeHiService;

/**
 * @author Robust
 *
 * @date 2014年7月31日
 *
 */
@Service("wealthTradeHiService")
public class WealthTradeHiServiceImpl implements WealthTradeHiService {

	@Resource
	private WealthTradeHiDao wealthTradeHiDao;

	/**
	 * @return wealthTradeHiDao
	 */
	public WealthTradeHiDao getWealthTradeHiDao() {
		return wealthTradeHiDao;
	}

	/**
	 * @param wealthTradeHiDao
	 *            要设置的 wealthTradeHiDao
	 */
	public void setWealthTradeHiDao(WealthTradeHiDao wealthTradeHiDao) {
		this.wealthTradeHiDao = wealthTradeHiDao;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * com.bbsBlog.service.WealthTradeHiService#saveWealthTradeHi(com.bbsBlog
	 * .entity.WealthTradeHi)
	 * 
	 * @param wealthTrade
	 * 
	 * @author Robust
	 * 
	 * @date 2014年7月31日
	 */
	@Override
	public void saveWealthTradeHi(WealthTradeHi wealthTrade) {
		// TODO 自动生成的方法存根

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * com.bbsBlog.service.WealthTradeHiService#updateWealthTradeHi(com.bbsBlog
	 * .entity.WealthTradeHi)
	 * 
	 * @param wealthTrade
	 * 
	 * @author Robust
	 * 
	 * @date 2014年7月31日
	 */
	@Override
	public void updateWealthTradeHi(WealthTradeHi wealthTrade) {
		// TODO 自动生成的方法存根

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.service.WealthTradeHiService#deleteWealthTradeHi(long)
	 * 
	 * @param id
	 * 
	 * @author Robust
	 * 
	 * @date 2014年7月31日
	 */
	@Override
	public void deleteWealthTradeHi(long id) {
		// TODO 自动生成的方法存根

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.service.WealthTradeHiService#listWealthTradeHi()
	 * 
	 * @return
	 * 
	 * @author Robust
	 * 
	 * @date 2014年7月31日
	 */
	@Override
	public List<WealthTradeHi> listWealthTradeHi() {
		// TODO 自动生成的方法存根
		return null;
	}

}
