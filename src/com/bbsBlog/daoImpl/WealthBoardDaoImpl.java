package com.bbsBlog.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.bbsBlog.dao.WealthBoardDao;
import com.bbsBlog.entity.WealthBoard;


@Repository("WealthBoardDao")
public class WealthBoardDaoImpl implements WealthBoardDao {
	
	@Resource
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	
	@Override
	public void saveWealthBoard(WealthBoard wealthBoard) {
		// TODO 自动生成的方法存根
		this.hibernateTemplate.save(wealthBoard);

	}

	
	@Override
	public void updateWealthBoard(WealthBoard wealthBoard) {
		// TODO 自动生成的方法存根
		this.hibernateTemplate.update(wealthBoard);

	}


	@Override
	public void deleteWealthBoard(long id) {
		// TODO 自动生成的方法存根
		this.hibernateTemplate.delete(this.hibernateTemplate.get(WealthBoard.class, id));

	}


	@SuppressWarnings("unchecked")
	@Override
	public List<WealthBoard> listWealthBoard() {
		// TODO 自动生成的方法存根
		return this.hibernateTemplate.find("from WealthBoard");
	}
	@Override
	public WealthBoard findById(long id)
	{
		return this.hibernateTemplate.get(WealthBoard.class, id);
	}
    
	@SuppressWarnings("unchecked")
	@Override
	public List<WealthBoard> findByUser(long user_id,long board_id)
	{
		List<WealthBoard> listWealth=this.hibernateTemplate.find("from WealthBoard w where w.userInfo.id="+user_id+" and w.board.id="+board_id);
		return listWealth;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<WealthBoard> listWealthBoardByUser(long user_id)
	{
		List<WealthBoard> listWealth=this.hibernateTemplate.find("from WealthBoard w where w.userInfo.id="+user_id);
		return listWealth;
	}
}
