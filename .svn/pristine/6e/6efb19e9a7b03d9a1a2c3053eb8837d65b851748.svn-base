package com.bbsBlog.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.bbsBlog.dao.QuestionLabelDao;
import com.bbsBlog.entity.QuestionLabel;

@Repository("questionLabelDao")
public class QuestionLabelDaoImpl implements QuestionLabelDao {

	@Resource
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	
	public void save(QuestionLabel questionLabel) {
      this.hibernateTemplate.save(questionLabel);
  		 
	}

	@Override
	public void update(QuestionLabel questionLabel) {
       
		this.hibernateTemplate.update(questionLabel);
	}

	@Override
	public void delete(long  id) {

		this.hibernateTemplate.delete(this.hibernateTemplate.get(QuestionLabel.class, id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<QuestionLabel> findByQuestion(long qId) {
		
		return  this.hibernateTemplate.find("from QuestionLabel where Que_id="+qId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<QuestionLabel> findByLabel(long lId) {

		return this.hibernateTemplate.find("from QuestionLabel where lab_id="+lId);
	}


}
