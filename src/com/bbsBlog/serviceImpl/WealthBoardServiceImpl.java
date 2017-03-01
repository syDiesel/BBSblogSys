package com.bbsBlog.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bbsBlog.entity.WealthBoard;
import com.bbsBlog.service.WealthBoardService;
import com.bbsBlog.dao.WealthBoardDao;


@Service("WealthBoard")
public class WealthBoardServiceImpl implements WealthBoardService{
	@Resource
	private WealthBoardDao wealthBoardDao;
	public WealthBoardDao getWealthBoardDao() {
		return wealthBoardDao;
	}


	public void setWealthBoardDao(WealthBoardDao wealthBoardDao) {
		this.wealthBoardDao = wealthBoardDao;
	}


	@Override
	public void saveWealthBoard(WealthBoard wealthBoard) {
		// TODO 自动生成的方法存根
		this.wealthBoardDao.saveWealthBoard(wealthBoard);

	}

	
	@Override
	public void updateWealthBoard(WealthBoard wealthBoard) {
		// TODO 自动生成的方法存根
		this.wealthBoardDao.updateWealthBoard(wealthBoard);

	}


	@Override
	public void deleteWealthBoard(long id) {
		// TODO 自动生成的方法存根
		this.wealthBoardDao.deleteWealthBoard(id);

	}


	@Override
	public List<WealthBoard> listWealthBoard() {
		// TODO 自动生成的方法存根
		return this.wealthBoardDao.listWealthBoard();
	}
	@Override
	public WealthBoard findById(long id)
	{
		return this.wealthBoardDao.findById(id);
	}
	
	@Override
	public List<WealthBoard> findByUser(long user_id,long board_id)
	{
		return this.wealthBoardDao.findByUser(user_id,board_id);
	}
	@Override
	public List<WealthBoard> listWealthBoardByUser(long user_id)
	{
		return this.wealthBoardDao.listWealthBoardByUser(user_id);
	}
}
