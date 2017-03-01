/**
 * 
 */
package com.bbsBlog.service;

import java.util.List;

import com.bbsBlog.entity.Label;
import com.bbsBlog.util.PageModel;

/**
 * @author Robust
 *
 * @date 2014年7月29日
 *
 */
public interface LabelService {

	public void saveLabel(Label label);

	public void updateLabel(Label label);

	public void deleteLabel(long id);

	public List<Label> listLabel();

	public Label listLabelById(long id);
	
	public List<Label> listLabelBySql(String sql );

	public List<Label> listLabelByBoard(long id);
	
	public PageModel listLabel(int offset, int pageSize);
}
