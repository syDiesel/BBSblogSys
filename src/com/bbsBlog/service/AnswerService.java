/**
 * 
 */
package com.bbsBlog.service;

import java.util.List;

import com.bbsBlog.entity.Answer;

/**
 * @author Robust
 *
 * @date 2014年7月29日
 *
 */
public interface AnswerService {
	
	public void saveAnswer(Answer answer);

	public void updateAnswer(Answer answer);

	public void deleteAnswer(long id);
	
	public Answer findOneAnswer(long aId);
	
	public List<Answer> findAnswer(long qId);
	
	public List<Answer> findAnswerByReA(long aId);
	
	public List<Answer> findZhuiWen(long userInfoId,long zhuiId);

	public List<Answer> listAnswer();
	
	public List<Answer> listAnswerBySql(String sql) ;
}
