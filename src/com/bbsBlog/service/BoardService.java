/**
 * 
 */
package com.bbsBlog.service;

import java.util.List;

import com.bbsBlog.entity.Board;

/**
 * @author Robust
 *
 * @date 2014年7月29日
 *
 */
public interface BoardService {

	public void saveBoard(Board board);

	public void updateBoard(Board boadr);

	public void deleteBoard(long id);

	public List<Board> listBoard();

	public List<Board> listBoardByBoardName(String boardName);
	
	public Board listBoardById(long id);
	


}
