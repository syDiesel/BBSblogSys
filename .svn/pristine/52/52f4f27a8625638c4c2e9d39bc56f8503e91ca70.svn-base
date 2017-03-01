/**
 * 
 */
package com.bbsBlog.dao;

import java.util.List;

import com.bbsBlog.entity.Answer;

/**
 * @author Robust
 *
 * @date 2014年7月23日
 *
 */
public interface AnswerDao {

	public void saveAnswer(Answer answer);

	public void updateAnswer(Answer answer);

	public void deleteAnswer(long id);

	public Answer findOneAnswer(long aId);
	
	public List<Answer> findAnswer(long qId);
	
	public List<Answer> findAnswerByReId(long aId);
	
	public List<Answer> findZhuiWen(long userInfoId,long zhuiId);
	
	public List<Answer> listAnswer();
	
	public List<Answer> listAnswerBySql(String sql) ;
}
