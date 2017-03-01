/**
 * 
 */
package com.bbsBlog.dao;

import java.util.List;

import com.bbsBlog.entity.Question;
import com.bbsBlog.util.PageModel;

/**
 * @author Robust
 *
 * @date 2014骞�鏈�6鏃�
 *
 */
public interface QuestionDao {

	
	public void saveQuestion(Question question);

	public void updateQuestion(Question question);

	public void deleteQuestion(long id);
	
	public Question findQuestion(long id);

	public List<Question> listQuestion();

	public List<Question> findQuestionPageByHot(int firstResult,int MaxResult);

	public List<Question> listQuestionByTime();
	
	public List<Question> findQuestionPageByTime(int firstResult,int MaxResult);

	public List<Question> findQuestionByUser(long userId );
	
	public List<Question> findQuestionByBoard(long board_id);
	
	public List<Question> listQuestionByBoard(long board_id);
	
	public List<Question> listQuestionByKey(String keyword, String lab, String sub, String con);
	
	public List<Question> listQuestionByTime(String keyword, String lab, String sub, String con);

	public PageModel listQuestion(int offset, int pageSize, long questionId);

    public List<Question> listQuestionBySql(String sql);
	
    public PageModel listQuestionBySQL(int offset, int pageSize, String queryCountHql,String hql);
    
    public int listCount(String queryCountHql);
	
}
