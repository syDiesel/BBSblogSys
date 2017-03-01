/**
 * 
 */
package com.bbsBlog.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bbsBlog.dao.SuggestionDao;
import com.bbsBlog.entity.Suggestion;
import com.bbsBlog.service.SuggestionService;

/**
 * 
 * @author 曦风
 *
 * @date 2014-9-14
 *
 * @param 下午9:41:47
 */
@Service("suggestionService")
public class SuggestionServiceImpl implements SuggestionService {

	@Resource
	private SuggestionDao suggestionDao;

	public SuggestionDao getSuggestionDao() {
		return suggestionDao;
	}

	public void setSuggestionDao(SuggestionDao suggestionDao) {
		this.suggestionDao = suggestionDao;
	}

	
	@Override
	public void saveSuggestion(Suggestion suggestion) {
		// TODO 自动生成的方法存根

		this.suggestionDao.saveSuggestion(suggestion);
	}

	
	@Override
	public void updateSuggestion(Suggestion suggestion) {
		// TODO 自动生成的方法存根
		this.suggestionDao.updateSuggestion(suggestion);

	}

	
	@Override
	public void deleteSuggestion(long id) {
		// TODO 自动生成的方法存根

		this.suggestionDao.deleteSuggestion(id);
	}

	
	@Override
	public List<Suggestion> listSuggestion() {
		// TODO 自动生成的方法存根
		return this.suggestionDao.listSuggestion();
	}

	@Override
	public List<Suggestion> findById(long id) {
		// TODO Auto-generated method stub
		return this.suggestionDao.findById(id);
	}

}
