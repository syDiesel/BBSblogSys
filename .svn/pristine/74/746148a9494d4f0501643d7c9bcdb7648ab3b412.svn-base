package com.bbsBlog.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.bbsBlog.dao.QuestionPJDao;
import com.bbsBlog.entity.QuestionPJ;

@Repository("questionPJDao")
public class QuestionPJDaoImpl implements QuestionPJDao {

	@Resource
    private	HibernateTemplate hibernateTemplate; 
	
	
	public void saveComment(QuestionPJ comment) {
     		
		this.hibernateTemplate.save(comment);

	}

	public void updateComment(QuestionPJ comment) {
   
		 this.hibernateTemplate.update(comment);
	}
	
	@SuppressWarnings("unchecked")
	public List<QuestionPJ> checkExit(long uId,long aId){
		return this.hibernateTemplate.find("from QuestionPJ q where q.userInfo.id="+uId+" and q.answer.id="+aId);
	}

	@SuppressWarnings("unchecked")
	public List<QuestionPJ> findCommentByA(long aId) {

		return this.hibernateTemplate.find("from QuestionPJ where Ans_id="+aId);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
