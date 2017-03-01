/**
 * 
 */
package com.bbsBlog.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bbsBlog.dao.LabelDao;
import com.bbsBlog.entity.Label;
import com.bbsBlog.service.LabelService;
import com.bbsBlog.util.PageModel;

/**
 * @author Robust
 *
 * @date 2014年7月30日
 *
 */
@Service("labelService")
public class LabelServiceImpl implements LabelService {

	@Resource
	private LabelDao labelDao;

	/**
	 * @return labelDao
	 */
	public LabelDao getLabelDao() {
		return labelDao;
	}

	/**
	 * @param labelDao
	 *            要设置的 labelDao
	 */
	public void setLabelDao(LabelDao labelDao) {
		this.labelDao = labelDao;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.service.LabelService#saveLabel(com.bbsBlog.entity.Label)
	 */
	public void saveLabel(Label label) {
		// TODO 自动生成的方法存根

		this.labelDao.saveLabel(label);


	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * com.bbsBlog.service.LabelService#updateLabel(com.bbsBlog.entity.Label)
	 */
	public void updateLabel(Label label) {
		// TODO 自动生成的方法存根

		this.labelDao.updateLabel(label);

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.service.LabelService#deleteLabel(long)
	 */
	public void deleteLabel(long id) {
		// TODO 自动生成的方法存根

		this.labelDao.deleteLabel(id);


	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.service.LabelService#listLabel()
	 */
	public List<Label> listLabel() {
		// TODO 自动生成的方法存根

		return this.labelDao.listLabel();

	}
	

	/* （非 Javadoc）
	 * @see com.bbsBlog.service.LabelService#listLabelById(long)
	 * @param id
	 * @return
	 *
	 * @author Robust
	 * @date 2014年8月8日
	 *
	 */
	public Label listLabelById(long id) {
		// TODO 自动生成的方法存根
		return labelDao.listLabelById(id);
	}
	


	/* （非 Javadoc）
	 * @see com.bbsBlog.service.LabelService#listLabelByBoard(long)
	 * @param id
	 * @return
	 *
	 * @author Robust
	 * @date 2014年8月20日
	 *
	 */
	public List<Label> listLabelByBoard(long id) {
		// TODO 自动生成的方法存根
		return this.labelDao.listLabelByBoard(id);
	}

	public PageModel listLabel(int offset, int pageSize){
		return this.labelDao.listLabel(offset, pageSize);
	}
	
	public List<Label> listLabelBySql(String sql ){
		return this.labelDao.listLabelBySql(sql);
	}
}
