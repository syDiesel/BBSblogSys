/**
 * 
 */
package com.bbsBlog.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.bbsBlog.dao.NoticeDao;
import com.bbsBlog.entity.Notice;

/**
 * 
 * @author 曦风
 *
 * @date 2014-9-14
 *
 * @param 下午9:34:58
 */
@Repository("noticeDao")
public class NoticeDaoImpl implements NoticeDao {
	
	@Resource
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	
	@Override
	public void saveNotice(Notice notice) {
		// TODO 自动生成的方法存根
		this.hibernateTemplate.save(notice);

	}

	
	@Override
	public void updateNotice(Notice notice) {
		// TODO 自动生成的方法存根
		this.hibernateTemplate.update(notice);

	}

	
	@Override
	public void deleteNotice(long id) {
		// TODO 自动生成的方法存根
		this.hibernateTemplate.delete(this.hibernateTemplate.get(Notice.class, id));
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Notice> listNotice() {
		// TODO 自动生成的方法存根
		return this.hibernateTemplate.find("from Notice n order by n.noticeTime desc");
	}

	@SuppressWarnings("unchecked")
	@Override
	public Notice findById(long id) {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.get(Notice.class, id);
	}

}
