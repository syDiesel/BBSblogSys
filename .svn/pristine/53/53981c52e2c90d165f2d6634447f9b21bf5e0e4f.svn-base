/**
 * 
 */
package com.bbsBlog.dao;

import java.util.List;

import com.bbsBlog.entity.FilterWord;
import com.bbsBlog.util.PageModel;

/**
 * @author Robust
 *
 * @date 2014年7月26日
 *
 */
public interface FilterWordDao {

	public void saveFilterWord(FilterWord filterWord);

	public void updateFilterWord(FilterWord filterWord);

	public void deleteFilterWord(long id);

	/**
	 * @author Robust
	 *
	 * @date 2014年8月10日
	 *
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	PageModel listFilterWord(int offset, int pageSize);

	public FilterWord listFilterWordByID(long id);
	
	public List<FilterWord> listFilterWord();
}
