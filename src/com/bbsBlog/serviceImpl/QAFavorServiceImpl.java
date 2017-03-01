package com.bbsBlog.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bbsBlog.daoImpl.QAFavorDaoImpl;
import com.bbsBlog.entity.QAFavor;

@Service("qAFavorServiceImpl")
public class QAFavorServiceImpl {
	@Resource
	QAFavorDaoImpl qAFavorDaoImpl;
	
	public void addQAFavor(QAFavor qAFavor){
		qAFavorDaoImpl.addQAFavor(qAFavor);
	}
	
	public void deleteQAFavor(QAFavor qAFavor) {
		qAFavorDaoImpl.deleteQAFavor(qAFavor);
	}
	
	public QAFavor getQAFavorById(Long id) {
		return qAFavorDaoImpl.getQAFavorById(id);
	}
	
	public List<QAFavor> getQAFavorsByUserId(Long userid) {
		return qAFavorDaoImpl.getQAFavorsByUserId(userid);
	}
	
	public List<QAFavor> getQAFavorsByQuestionId(Long questionid) {
		return qAFavorDaoImpl.getQAFavorsByQuestionId(questionid);
	}
	
	public List<QAFavor> listQAFavorsBySql(String sql){
		return qAFavorDaoImpl.listQAFavorsBySql(sql);
	}
	
	public int listCount(String queryCountHql){
		return qAFavorDaoImpl.listCount(queryCountHql);
	}
}