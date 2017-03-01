/**
 * 
 */
package com.bbsBlog.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.bbsBlog.dao.PostStatusDao;
import com.bbsBlog.entity.PostStatus;

/**
 * @author Robust
 *
 * @date 2014年7月28日
 *
 */
@Repository("postStatusDao")
public class PostStatusDaoImpl implements PostStatusDao {
	
	@Resource
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.PostStatusDao#savePostStatus(com.bbsBlog.entity.PostStatus)
	 */
	@Override
	public void savePostStatus(PostStatus postStatus) {
		// TODO 自动生成的方法存根

	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.PostStatusDao#updatePostStatus(com.bbsBlog.entity.PostStatus)
	 */
	@Override
	public void updatePostStatus(PostStatus postStatus) {
		// TODO 自动生成的方法存根

	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.PostStatusDao#deletePostStatus(long)
	 */
	@Override
	public void deletePostStatus(long id) {
		// TODO 自动生成的方法存根

	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.PostStatusDao#listPostStatus()
	 */
	@Override
	public List<PostStatus> listPostStatus() {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public PostStatus listPostStatusById(long status_id){
		return this.hibernateTemplate.get(PostStatus.class, status_id);
	}

}
