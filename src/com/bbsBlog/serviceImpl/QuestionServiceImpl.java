/**
 * 
 */
package com.bbsBlog.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bbsBlog.dao.QuestionDao;
import com.bbsBlog.entity.Question;
import com.bbsBlog.service.QuestionService;
import com.bbsBlog.util.PageModel;

/**
 * @author Robust
 *
 * @date 2014骞�鏈�0鏃�
 *
 */
@Service("questionService")
public class QuestionServiceImpl implements QuestionService {

	@Resource
	private QuestionDao questionDao;

	/**
	 * @return questionDao
	 */
	public QuestionDao getQuestionDao() {
		return questionDao;
	}

	/**
	 * @param questionDao
	 *            瑕佽缃殑 questionDao
	 */
	public void setQuestionDao(QuestionDao questionDao) {
		this.questionDao = questionDao;
	}

	/*
	 * 锛堥潪 Javadoc锛�
	 * 
	 * @see
	 * com.bbsBlog.service.QuestionService#saveQuestion(com.bbsBlog.entity.Question
	 * )
	 */
	public void saveQuestion(Question question) {
		
		this.questionDao.saveQuestion(question);
		this.questionDao.saveQuestion(question);

	}

	/*
	 * 锛堥潪 Javadoc锛�
	 * 
	 * @see
	 * com.bbsBlog.service.QuestionService#updateQuestion(com.bbsBlog.entity
	 * .Question)
	 */
	public void updateQuestion(Question question) {

         this.questionDao.updateQuestion(question);

	}

	/*
	 * 锛堥潪 Javadoc锛�
	 * 
	 * @see com.bbsBlog.service.QuestionService#deleteQuestion(long)
	 */
	public void deleteQuestion(long id) {
              this.questionDao.deleteQuestion(id);
	}

	/*
	 * 锛堥潪 Javadoc锛�
	 * 
	 * @see com.bbsBlog.service.QuestionService#listQuestion()
	 */
	public List<Question> listQuestion() {

		return  this.questionDao.listQuestion();

	}
	
	
	

	public List<Question> findQuestionByUserInfo(long userId) {

		
		return this.questionDao.findQuestionByUser(userId);
	}


	public Question findQuestion(long id) {
		return this.questionDao.findQuestion(id);
	}
	
	public List<Question> listQuestionByBoard(long board_id){
		return this.questionDao.listQuestionByBoard(board_id);
	}

	//-------------------------------------鎺掑簭-----------------------------------------
	@Override
	public List<Question> listQuestionByKey(String keyword, String lab, String sub, String con) {
		// TODO Auto-generated method stub
		return this.questionDao.listQuestionByKey(keyword,lab,sub,con);
	}

	@Override
	public List<Question> listQuestionByTime(String keyword, String lab, String sub, String con) {
		// TODO Auto-generated method stub
		return this.questionDao.listQuestionByTime(keyword,lab,sub,con);
	}

	@Override
	public List<Question> listQuestionByTime() {
		
		return this.questionDao.listQuestionByTime();
	}

	@Override
	public List<Question> findQuestionPageByTime(int firstResult, int MaxResult) {
		
		return this.questionDao.findQuestionPageByTime(firstResult, MaxResult);
	}

	@Override
	public List<Question> findQuestionPageByHot(int firstResult, int MaxResult) {

		return this.questionDao.findQuestionPageByHot(firstResult, MaxResult);
	}

	@Override
	public List<Question> findQuestionByBoard(long board_id) {

		return this.questionDao.findQuestionByBoard(board_id);
	}


	@Override
	public PageModel listQuestion(int offset, int pageSize, long questionId) {
		// TODO Auto-generated method stub
		return this.questionDao.listQuestion(offset,pageSize,questionId);
	}

	@Override
	public List<Question> listQuestionBySql(String sql) {
		// TODO Auto-generated method stub
		
		return this.questionDao.listQuestionBySql(sql);
	}

	@Override
	public PageModel listQuestionBySQL(int offset, int pageSize,
			String queryCountHql, String hql) {
		// TODO Auto-generated method stub
		
		return this.questionDao.listQuestionBySQL(offset,pageSize,queryCountHql,hql);
	}

	@Override
	public int listCount(String queryCountHql) {
		// TODO Auto-generated method stub
		return this.questionDao.listCount(queryCountHql);
	}



}
