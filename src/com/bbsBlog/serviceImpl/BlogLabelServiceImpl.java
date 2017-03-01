/**
 * 
 */
package com.bbsBlog.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bbsBlog.dao.BlogLabelDao;
import com.bbsBlog.entity.BlogLabel;
import com.bbsBlog.service.BlogLabelService;

/**
 * @author Robust
 *
 * @date 2014年8月20日
 *
 */
@Service("blogLabelService")
public class BlogLabelServiceImpl implements BlogLabelService  {

	@Resource
	private BlogLabelDao blogLabelDao;
	/* （非 Javadoc）
	 * @see com.bbsBlog.service.BlogLabelService#saveBlogLabel(com.bbsBlog.entity.BlogLabel)
	 * @param blogLabel
	 *
	 * @author Robust
	 * @date 2014年8月20日
	 *
	 */
	@Override
	public void saveBlogLabel(BlogLabel blogLabel) {
		// TODO 自动生成的方法存根
		//System.out.println("开始saveBlogLabel");
		this.blogLabelDao.saveBlogLabel(blogLabel);
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.service.BlogLabelService#updateBlogLabel(com.bbsBlog.entity.BlogLabel)
	 * @param blogLabel
	 *
	 * @author Robust
	 * @date 2014年8月20日
	 *
	 */
	@Override
	public void updateBlogLabel(BlogLabel blogLabel) {
		// TODO 自动生成的方法存根
		
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.service.BlogLabelService#deleteBlogLabel(long)
	 * @param id
	 *
	 * @author Robust
	 * @date 2014年8月20日
	 *
	 */
	@Override
	public void deleteBlogLabel(long id) {
		// TODO 自动生成的方法存根
		this.blogLabelDao.deleteBlogLabel(id);
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.service.BlogLabelService#listBlogLabel()
	 *
	 * @author Robust
	 * @date 2014年8月28日
	 *
	 */
	@Override
	public List<BlogLabel> listBlogLabel() {
		// TODO 自动生成的方法存根
		return this.blogLabelDao.listBlogLabel();
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.service.BlogLabelService#listBlogLabelByLog(long)
	 * @param id
	 * @return
	 *
	 * @author Robust
	 * @date 2014年8月28日
	 *
	 */
	@Override
	public List<BlogLabel> listBlogLabelByLog(long id) {
		// TODO 自动生成的方法存根
		return this.blogLabelDao.listBlogLabelByLog(id);
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.service.BlogLabelService#listBlogLabelByLabel(long)
	 * @param id
	 * @return
	 *
	 * @author Robust
	 * @date 2014年10月9日
	 *
	 */
	@Override
	public List<BlogLabel> listBlogLabelByLabel(long id) {
		// TODO 自动生成的方法存根
		return this.blogLabelDao.listBlogLabelByLabel(id);
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.service.BlogLabelService#listCount(java.lang.String)
	 * @param queryCountHql
	 * @return
	 *
	 * @author Robust
	 * @date 2014年10月10日
	 *
	 */
	@Override
	public int listCount(String queryCountHql) {
		// TODO 自动生成的方法存根
		return this.blogLabelDao.listCount(queryCountHql);
	}

}
