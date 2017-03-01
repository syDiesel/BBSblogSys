/**
 * 
 */
package com.bbsBlog.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bbsBlog.dao.BoardDao;
import com.bbsBlog.entity.Board;
import com.bbsBlog.service.BoardService;

/**
 * @author Robust
 *
 * @date 2014年7月30日
 *
 */
@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Resource
	private BoardDao boardDao;

	/**
	 * @return boardDao
	 */
	public BoardDao getBoardDao() {
		return boardDao;
	}

	/**
	 * @param boardDao
	 *            要设置的 boardDao
	 */
	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.service.BoardService#saveBoard(com.bbsBlog.entity.Board)
	 */
	@Override
	public void saveBoard(Board board) {
		this.boardDao.saveBoard(board);
		this.boardDao.saveBoard(board);

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * com.bbsBlog.service.BoardService#updateBoard(com.bbsBlog.entity.Board)
	 */
	@Override
	public void updateBoard(Board board) {
		// TODO 自动生成的方法存根

		this.boardDao.updateBoard(board);


	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.service.BoardService#deleteBoard(long)
	 */
	@Override
	public void deleteBoard(long id) {
		// TODO 自动生成的方法存根

		boardDao.deleteBoard(id);

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.service.BoardService#listBoard()
	 */
	public List<Board> listBoard() {
		// TODO 自动生成的方法存根

		return boardDao.listBoard();
		

	}
	
	
	
	public Board listBoardById(long id) {
		// TODO 自动生成的方法存根
		return boardDao.listBoardById(id);
	}
	

	/* （非 Javadoc）
	 * @see com.bbsBlog.service.BoardService#listBoardByBoardName(java.lang.String)
	 * @param boardName
	 * @return
	 *
	 * @author Robust
	 * @date 2014年10月5日
	 *
	 */
	@Override
	public List<Board> listBoardByBoardName(String boardName) {
		// TODO 自动生成的方法存根
		return this.boardDao.listBoardByBoardName(boardName);
	}

}
