package com.bbsBlog.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bbsBlog.daoImpl.QAConcernDaoImpl;
import com.bbsBlog.entity.QAConcern;

@Service("qAConcernServiceImpl")
public class QAConcernServiceImpl {
	@Resource
	QAConcernDaoImpl qAConcernDaoImpl;
	
	public void addQAConcern(QAConcern qAConcern){
		qAConcernDaoImpl.addQAConcern(qAConcern);
	}
	
	public void deleteQAConcern(QAConcern qAConcern) {
		qAConcernDaoImpl.deleteQAConcern(qAConcern);
	}
	
	public QAConcern getQAConcernById(Long id) {
		return qAConcernDaoImpl.getQAConcernById(id);
	}
	
	public List<QAConcern> getQAConcernsByUserId(Long userid) {
		return qAConcernDaoImpl.getQAConcernsByUserId(userid);
	}
	
	public List<QAConcern> getQAConcernsByQuestionId(Long questionid) {
		return qAConcernDaoImpl.getQAConcernsByQuestionId(questionid);
	}
	
	public List<QAConcern> listQAConcernsBySql(String sql){
		return qAConcernDaoImpl.listQAConcernsBySql(sql);
	}
}