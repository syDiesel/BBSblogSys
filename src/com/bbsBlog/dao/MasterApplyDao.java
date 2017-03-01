/**
 * 
 */
package com.bbsBlog.dao;

import java.util.List;

import com.bbsBlog.entity.MasterApply;
import com.bbsBlog.util.PageModel;

/**
 * @author Robust
 *
 * @date 2014年8月11日
 *
 */
public interface MasterApplyDao {
	public void saveMasterApply(MasterApply masterApply);

	public void updateMasterApply(MasterApply masterApply);

	public void deleteMasterApply(long id);

	public MasterApply listMasterApplyById(long id);

	public List<MasterApply> listMasterApply();
	
	public PageModel listMasterApply(int offset, int pageSize);
}
