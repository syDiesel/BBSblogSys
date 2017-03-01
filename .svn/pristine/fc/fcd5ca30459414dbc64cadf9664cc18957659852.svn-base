/**
 * 
 */
package com.bbsBlog.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bbsBlog.dao.FilterWordDao;
import com.bbsBlog.entity.FilterWord;
import com.bbsBlog.service.FilterWordService;
import com.bbsBlog.util.PageModel;

/**
 * @author Robust
 *
 * @date 2014年7月30日
 *
 */
@Service("filterWordService")
public class FilterWordServiceImpl implements FilterWordService {

	@Resource
	private FilterWordDao filterWordDao;

	/**
	 * @return filterWordDao
	 */
	public FilterWordDao getFilterWordDao() {
		return filterWordDao;
	}

	/**
	 * @param filterWordDao
	 *            要设置的 filterWordDao
	 */
	public void setFilterWordDao(FilterWordDao filterWordDao) {
		this.filterWordDao = filterWordDao;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * com.bbsBlog.service.FilterWordService#saveFilterWord(com.bbsBlog.entity
	 * .FilterWord)
	 */
	@Override
	public void saveFilterWord(FilterWord filterWord) {
		// TODO 自动生成的方法存根
		filterWordDao.saveFilterWord(filterWord);

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * com.bbsBlog.service.FilterWordService#updateFilterWord(com.bbsBlog.entity
	 * .FilterWord)
	 */
	@Override
	public void updateFilterWord(FilterWord filterWord) {
		// TODO 自动生成的方法存根
		filterWordDao.updateFilterWord(filterWord);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.service.FilterWordService#deleteFilterWord(long)
	 */
	@Override
	public void deleteFilterWord(long id) {
		// TODO 自动生成的方法存根
		filterWordDao.deleteFilterWord(id);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.service.FilterWordService#listFilterWord()
	 */
	@Override
	public PageModel listFilterWord(int offset, int pageSize) {
		// TODO 自动生成的方法存根
		return filterWordDao.listFilterWord(offset, pageSize);
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.service.FilterWordService#listFilterWordByID(long)
	 * @param id
	 * @return
	 *
	 * @author Robust
	 * @date 2014年8月10日
	 *
	 */
	@Override
	public FilterWord listFilterWordByID(long id) {
		// TODO 自动生成的方法存根
		return filterWordDao.listFilterWordByID(id);
	}
	
	public List<FilterWord> listFilterWord(){
		return this.filterWordDao.listFilterWord();
	}

}
