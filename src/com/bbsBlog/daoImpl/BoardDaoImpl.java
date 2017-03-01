/**
 * 
 */
package com.bbsBlog.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.bbsBlog.dao.BoardDao;
import com.bbsBlog.entity.Board;
import com.bbsBlog.entity.Label;

/**
 * @author Robust
 *
 * @date 2014年7月28日
 *
 */
@Repository("boardDao")
public class BoardDaoImpl implements BoardDao {

	@Resource
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.BoardDao#saveBoard(com.bbsBlog.entity.Board)
	 */
	public void saveBoard(Board board) {
		this.hibernateTemplate.save(board);
		this.hibernateTemplate.save(board);

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.BoardDao#updateBoard(com.bbsBlog.entity.Board)
	 */
	public void updateBoard(Board board) {
		// TODO 自动生成的方法存根

		this.hibernateTemplate.update(board);

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.BoardDao#deleteBoard(long)
	 */
	public void deleteBoard(long id) {
		// TODO 自动生成的方法存根

		this.hibernateTemplate.delete(this.hibernateTemplate.get(Board.class,
				id));

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.BoardDao#listBoard()
	 */
	@SuppressWarnings("unchecked")
	public List<Board> listBoard() {
		// TODO 自动生成的方法存根

		List<Board> boards = this.hibernateTemplate.find("from Board");
		return boards;

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.BoardDao#listBoardBySQL(java.lang.String)
	 * 
	 * @param sql
	 * 
	 * @return
	 * 
	 * @author Robust
	 * 
	 * @date 2014年8月6日
	 */
	public Board listBoardById(long id) {
		// TODO 自动生成的方法存根
		return this.hibernateTemplate.get(Board.class, id);

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.BoardDao#listBoardByBoardName(java.lang.String)
	 * 
	 * @param boardName
	 * 
	 * @return
	 * 
	 * @author Robust
	 * 
	 * @date 2014年10月5日
	 */
	@Override
	public List<Board> listBoardByBoardName(String boardName) {
		// TODO 自动生成的方法存根
		return this.hibernateTemplate.find("from Board where boardName = '"
				+ boardName + "'");
	}


}
