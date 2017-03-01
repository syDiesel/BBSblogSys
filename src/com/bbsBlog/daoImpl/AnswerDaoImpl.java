/**
 * 
 */
package com.bbsBlog.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.bbsBlog.dao.AnswerDao;
import com.bbsBlog.entity.Answer;

/**
 * @author Robust
 *
 * @date 2014骞�鏈�8鏃�
 *
 */
@Repository("answerDao")
public class AnswerDaoImpl implements AnswerDao {
	
	@Resource
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/*
	 * 锛堥潪 Javadoc锛�
	 * 
	 * @see com.bbsBlog.dao.AnswerDao#saveAnswer(com.bbsBlog.entity.Answer)
	 */
	public void saveAnswer(Answer answer) {
		hibernateTemplate.save(answer);

	}

	/*
	 * 锛堥潪 Javadoc锛�
	 * 
	 * @see com.bbsBlog.dao.AnswerDao#updateAnswer(com.bbsBlog.entity.Answer)
	 */
	public void updateAnswer(Answer answer) {
		hibernateTemplate.update(answer);

	}

	/*
	 * 锛堥潪 Javadoc锛�
	 * 
	 * @see com.bbsBlog.dao.AnswerDao#deleteAnswer(long)
	 */
	public void deleteAnswer(long id) {
 		
 		this.hibernateTemplate.update(this.hibernateTemplate.get(Answer.class, id));
	}

	/*
	 * 锛堥潪 Javadoc锛�
	 * 
	 * @see com.bbsBlog.dao.AnswerDao#listAnswer()
	 */
	@SuppressWarnings("unchecked")
	public List<Answer> listAnswer() {
	 	String queryString="from Answer ";
		return hibernateTemplate.find(queryString);
	}

	@Override
	public Answer findOneAnswer(long aId) {
		return this.hibernateTemplate.get(Answer.class, aId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Answer> findAnswer(long qId) {
		return this.hibernateTemplate.find("from Answer where q_id="+qId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Answer> findAnswerByReId(long aId) {
		
		return this.hibernateTemplate.find("from Answer where isReAsk="+aId);
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Answer> findZhuiWen(long userInfoId, long zhuiId) {

		return this.hibernateTemplate.find("from Answer where UserInfo_id="+userInfoId+"and related="+zhuiId);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Answer> listAnswerBySql(String sql) {

		return this.hibernateTemplate.find(sql);
	}

}
