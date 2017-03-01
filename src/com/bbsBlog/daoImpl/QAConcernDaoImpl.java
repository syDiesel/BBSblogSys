package com.bbsBlog.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.bbsBlog.entity.QAConcern;

@Repository("qAConcernDaoImpl")
public class QAConcernDaoImpl {
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	public void addQAConcern(QAConcern qAConcern){
		hibernateTemplate.save(qAConcern);
	}
	
	public void deleteQAConcern(QAConcern qAConcern) {
		hibernateTemplate.delete(qAConcern);
	}
	
	public QAConcern getQAConcernById(Long id) {
		return (QAConcern)hibernateTemplate.find("from QAConcern where id="+id).get(0);
	}
	
	@SuppressWarnings("unchecked")
	public List<QAConcern> getQAConcernsByUserId(Long userid) {
		return (List<QAConcern>)hibernateTemplate.find("from QAConcern where userinfo.id="+userid);
	}
	
	@SuppressWarnings("unchecked")
	public List<QAConcern> getQAConcernsByQuestionId(Long questionid) {
		return (List<QAConcern>)hibernateTemplate.find("from QAConcern where question.id="+questionid);
	}
	
	@SuppressWarnings("unchecked")
	public List<QAConcern> listQAConcernsBySql(String sql){
		return (List<QAConcern>)hibernateTemplate.find(sql);
	}
}