package com.bbsBlog.service;

import java.util.List;

import com.bbsBlog.entity.QuestionPJ;

public interface QuestionPJService {

	public void saveComment(QuestionPJ comment);
	
	public List<QuestionPJ> findQuestionPJByA(long aId);
	
	public List<QuestionPJ> checkExit(long uId,long aId);
	
}
