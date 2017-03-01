/**
 * 
 */
package com.bbsBlog.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.bbsBlog.dao.AttachmentDao;
import com.bbsBlog.entity.Attachment;
import com.bbsBlog.util.PageModel;

/**
 * @author Robust
 *
 * @date 2014年7月28日
 *
 */
@Repository("attachmentDao")
public class AttachmentDaoImpl extends HibernateDaoSupport implements
		AttachmentDao {

	@Resource
	public void setSessionFacotry(SessionFactory sessionFacotry) {
		super.setSessionFactory(sessionFacotry);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * com.bbsBlog.dao.AttachmentDao#saveAttachment(com.bbsBlog.entity.Attachment
	 * )
	 */
	@Override
	public void saveAttachment(Attachment attachment) {
		// TODO 自动生成的方法存根

		this.getHibernateTemplate().save(attachment);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * com.bbsBlog.dao.AttachmentDao#updateAttachment(com.bbsBlog.entity.Attachment
	 * )
	 */
	@Override
	public void updateAttachment(Attachment attachment) {
		// TODO 自动生成的方法存根
		this.getHibernateTemplate().update(attachment);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.AttachmentDao#deleteAttachment(long)
	 */
	@Override
	public void deleteAttachment(long id) {
		// TODO 自动生成的方法存根
		this.getHibernateTemplate().delete(
				this.getHibernateTemplate().get(Attachment.class, id));
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.AttachmentDao#listAttachment()
	 */
	@Override
	public List<Attachment> listAttachment() {
		// TODO 自动生成的方法存根
		return this.getHibernateTemplate().find("from Attachment");
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.AttachmentDao#listAttachment(int, int)
	 * 
	 * @param offset
	 * 
	 * @param pageSize
	 * 
	 * @return
	 * 
	 * @author Robust
	 * 
	 * @date 2014年8月31日
	 */
	@Override
	public PageModel listAttachment(int offset, int pageSize) {
		// TODO 自动生成的方法存根

		// 得到总记录数
		String queryCountHql = "select count(*) from Attachment";
		Query query = getSession().createQuery(queryCountHql);
		int total = ((Long) query.uniqueResult()).intValue();

		String hql = "from Attachment order by attachTime asc";
		List datas = this.getSession().createQuery(hql).setFirstResult(offset)
				.setMaxResults(pageSize).list();

		// 得到结果集
		PageModel pm = new PageModel();
		pm.setTotal(total);
		pm.setDatas(datas);
		pm.setOffset(offset);

		return pm;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.AttachmentDao#listAttachmentById(long)
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @author Robust
	 * 
	 * @date 2014年9月3日
	 */
	@Override
	public Attachment listAttachmentById(long id) {
		// TODO 自动生成的方法存根
		return this.getHibernateTemplate().get(Attachment.class, id);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.AttachmentDao#listAttachmentByBlogId(int, int, long)
	 * 
	 * @param offset
	 * 
	 * @param pageSize
	 * 
	 * @param BlogId
	 * 
	 * @return
	 * 
	 * @author Robust
	 * 
	 * @date 2014年9月16日
	 */
	@Override
	public PageModel listAttachmentByBlogId(int offset, int pageSize,
			long BlogId) {
		// TODO 自动生成的方法存根

		// 得到总记录数
		String queryCountHql = "select count(*) from Attachment where userInfo.id='"
				+ BlogId + "'";
		Query query = getSession().createQuery(queryCountHql);
		int total = ((Long) query.uniqueResult()).intValue();

		String hql = "from Attachment where userInfo.id='" + BlogId
				+ "' order by attachTime desc";
		List datas = this.getSession().createQuery(hql).setFirstResult(offset)
				.setMaxResults(pageSize).list();

		// 得到结果集
		PageModel pm = new PageModel();
		pm.setTotal(total);
		pm.setDatas(datas);
		pm.setOffset(offset);

		return pm;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Attachment> listAttachmentByKey(String keyword, String lab, String sub, String con) {
		// TODO Auto-generated method stub
		List<Attachment> list=new ArrayList<Attachment>();
		List<Attachment> list1=new ArrayList<Attachment>();
		List<Attachment> list2=new ArrayList<Attachment>();
		List<Attachment> list3=new ArrayList<Attachment>();

		if(sub.equals("1")&&sub.equals("1")){
			
			list1=this.getHibernateTemplate().find("from Attachment where attachName like '%"+keyword+"%' " +
					"and attachDesc like '%"+keyword+"%'");
			list2=this.getHibernateTemplate().find("from Attachment where attachName like '%"+keyword+"%' " +
					"and attachDesc not like '%"+keyword+"%'");
			list3=this.getHibernateTemplate().find("from Attachment where attachDesc like '%"+keyword+"%' " +
					"and attachName not like '%"+keyword+"%'");
			
		}else if(sub.equals("1")&&!sub.equals("1")){
			list2=this.getHibernateTemplate().find("from Attachment where attachName like '%"+keyword+"%'");
			
		}else if(!sub.equals("1")&&sub.equals("1")){
			list3=this.getHibernateTemplate().find("from Attachment where attachDesc like '%"+keyword+"%'");
		}
		
		list.addAll(list1);
		list.addAll(list2);
		list.addAll(list3);
		
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Attachment> listAttachmentByTime(String keyword, String lab, String sub, String con) {
		// TODO Auto-generated method stub
		List<Attachment> list = new ArrayList<Attachment>();
		if(sub.equals("1")&&con.equals("1")){
			list=this.getHibernateTemplate().find("from Attachment where attachName like '%"+keyword+"%' " +
					"or attachDesc like '%"+keyword+"%' order by attachTime desc");
			
		}else if(sub.equals("1")&&!con.equals("1")){
			list=this.getHibernateTemplate().find("from Attachment where attachName like '%"+keyword+"%' " +
					"order by attachTime desc");
			
		}else if(!sub.equals("1")&&con.equals("1")){
			list=this.getHibernateTemplate().find("from Attachment where attachDesc like '%"+keyword+"%' order by attachTime desc");
			
		}
		
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Attachment> listAttachBySql(String sql) {
		// TODO Auto-generated method stub
		List<Attachment> listAttach = this.getHibernateTemplate().find(sql);
		return listAttach;
	}

}
