package com.bbsBlog.dao;

import java.util.List;

import com.bbsBlog.entity.QuestionLabel;


/**
 * @author yp
 *
 * @date 2014骞�鏈�鏃�
 *
 */
public interface QuestionLabelDao {
 
	public void save(QuestionLabel questionLabel);
	
	public void update(QuestionLabel questionLabel);
	
	public void delete(long id);
	
	public List<QuestionLabel>  findByQuestion(long qId);
	
	public List<QuestionLabel>  findByLabel(long lId);
	
	
}
