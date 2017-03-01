/**
 * 
 */
package com.bbsBlog.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.bbsBlog.dao.SuggestionDao;
import com.bbsBlog.entity.Suggestion;

/**
 * 
 * @author 曦风
 *
 * @date 2014-9-14
 *
 * @param 下午9:34:58
 */
@Repository("suggestionDao")
public class SuggestionDaoImpl implements SuggestionDao {
	
	@Resource
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	
	@Override
	public void saveSuggestion(Suggestion suggestion) {
		// TODO 自动生成的方法存根
		this.hibernateTemplate.save(suggestion);

	}

	
	@Override
	public void updateSuggestion(Suggestion suggestion) {
		// TODO 自动生成的方法存根
		this.hibernateTemplate.update(suggestion);

	}

	
	@Override
	public void deleteSuggestion(long id) {
		// TODO 自动生成的方法存根
		this.hibernateTemplate.delete(this.hibernateTemplate.get(Suggestion.class, id));
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Suggestion> listSuggestion() {
		// TODO 自动生成的方法存根
		return this.hibernateTemplate.find("from Suggestion");
	}

	@Override
	public List<Suggestion> findById(long id) {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.find("from Suggestion where id='"+id+"'");
	}

}
