package com.bbsBlog.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bbsBlog.dao.QuestionPJDao;
import com.bbsBlog.entity.QuestionPJ;
import com.bbsBlog.service.QuestionPJService;

@Service("questionPJService")
public class QuestionPJServiceImpl implements QuestionPJService {

	@Resource
	 private QuestionPJDao questionPJDao;
	
	
	public void saveComment(QuestionPJ comment) {

		this.questionPJDao.saveComment(comment);
	}

	@Override
	public List<QuestionPJ> findQuestionPJByA(long aId) {

		return this.questionPJDao.findCommentByA(aId);
	}
	
	public List<QuestionPJ> checkExit(long uId,long aId){
		return this.questionPJDao.checkExit(uId, aId);
	}


	public QuestionPJDao getquestionPJDao() {
		return questionPJDao;
	}

	public void setquestionPJDao(QuestionPJDao questionPJDao) {
		this.questionPJDao = questionPJDao;
	}

}
