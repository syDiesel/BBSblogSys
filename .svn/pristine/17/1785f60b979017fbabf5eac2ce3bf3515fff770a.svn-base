package com.bbsBlog.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bbsBlog.dao.QuestionLabelDao;
import com.bbsBlog.entity.QuestionLabel;
import com.bbsBlog.service.QuestionLabelService;

@Service("questionLabelService")
public class QuestionLabelServiceImpl implements QuestionLabelService {

	/**
	 * @author Robust
	 *
	 * @date 2014骞�鏈�0鏃�
	 *
	 */
	@Resource
	private QuestionLabelDao  questionLabelDao;

	
	public void save(QuestionLabel questionLabel) {
   
		this.questionLabelDao.save(questionLabel);
		
	}


	public QuestionLabelDao getQuestionLabelDao() {
		return questionLabelDao;
	}


	public void setQuestionLabelDao(QuestionLabelDao questionLabelDao) {
		this.questionLabelDao = questionLabelDao;
	}


	@Override
	public void update(QuestionLabel questionLabel) {

		this.questionLabelDao.update(questionLabel);
	}


	@Override
	public void delete(long id) {

		this.questionLabelDao.delete(id);
	}


	@Override
	public List<QuestionLabel> findByQuestion(long qId) {

		return this.questionLabelDao.findByQuestion(qId);
	}


	@Override
	public List<QuestionLabel> findByLabel(long lId) {

		return this.questionLabelDao.findByLabel(lId);
	}

}
