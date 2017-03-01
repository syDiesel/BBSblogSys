package com.bbsBlog.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.bbsBlog.entity.QAFavor;

@Repository("qAFavorDaoImpl")
public class QAFavorDaoImpl extends HibernateDaoSupport{
	@Resource
	private HibernateTemplate hibernateTemplate;
	@Resource
	public void setSessionFacotry(SessionFactory sessionFacotry) {
		super.setSessionFactory(sessionFacotry);
	}
	
	public void addQAFavor(QAFavor qAFavor){
		hibernateTemplate.save(qAFavor);
	}
	
	public void deleteQAFavor(QAFavor qAFavor) {
		hibernateTemplate.delete(qAFavor);
	}
	
	public QAFavor getQAFavorById(Long id) {
		return (QAFavor)hibernateTemplate.find("from QAFavor where id="+id).get(0);
	}
	
	@SuppressWarnings("unchecked")
	public List<QAFavor> getQAFavorsByUserId(Long userid) {
		return (List<QAFavor>)hibernateTemplate.find("from QAFavor where userinfo.id="+userid);
	}
	
	@SuppressWarnings("unchecked")
	public List<QAFavor> getQAFavorsByQuestionId(Long questionid) {
		return (List<QAFavor>)hibernateTemplate.find("from QAFavor where question.id="+questionid);
	}
	
	@SuppressWarnings("unchecked")
	public List<QAFavor> listQAFavorsBySql(String sql){
		return (List<QAFavor>)hibernateTemplate.find(sql);
	}
	
	public int listCount(String queryCountHql){
		
		Query query = getSession().createQuery(queryCountHql);
		int total = ((Long) query.uniqueResult()).intValue();
		return total;
		
	}
}