/**
 * 
 */
package com.bbsBlog.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.bbsBlog.dao.MessageDao;
import com.bbsBlog.entity.Message;
import com.bbsBlog.util.PageModel;

/**
 * @author Robust
 *
 * @date 2014年7月28日
 *
 */
@Repository("messageDao")
public class MessageDaoImpl extends HibernateDaoSupport implements MessageDao {

	@Resource
	public void setSessionFacotry(SessionFactory sessionFacotry) {
		super.setSessionFactory(sessionFacotry);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.MessageDao#saveMessage(com.bbsBlog.entity.Message)
	 */
	@Override
	public void saveMessage(Message message) {
		// TODO 自动生成的方法存根
		this.getHibernateTemplate().save(message);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.MessageDao#updateMessage(com.bbsBlog.entity.Message)
	 */
	@Override
	public void updateMessage(Message message) {
		// TODO 自动生成的方法存根
		this.getHibernateTemplate().update(message);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.MessageDao#deleteMessage(long)
	 */
	@Override
	public void deleteMessage(long id) {
		// TODO 自动生成的方法存根
		this.getHibernateTemplate().delete(
				this.getHibernateTemplate().get(Message.class, id));
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.MessageDao#listMessage()
	 */
	@Override
	public PageModel listMessage(int offset, int pageSize) {
		// TODO 自动生成的方法存根

		// 得到总记录数
		String queryCountHql = "select count(*) from Message";
		Query query = getSession().createQuery(queryCountHql);
		int total = ((Long) query.uniqueResult()).intValue();

		String hql = "from Message msg order by msg.msgTime desc";
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
	 * @see com.bbsBlog.dao.MessageDao#listMessageByS(int, int, long)
	 * 
	 * @param offset
	 * 
	 * @param pageSize
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @author Robust
	 * 
	 * @date 2014年9月9日
	 */
	@Override
	public PageModel listMessageByS(int offset, int pageSize, long id) {
		// TODO 自动生成的方法存根

		// 得到总记录数
		String queryCountHql = "select count(*) from Message where userInfo2.id='"
				+ id + "'";
		Query query = getSession().createQuery(queryCountHql);
		int total = ((Long) query.uniqueResult()).intValue();

		String hql = "from Message where userInfo2.id='" + id
				+ "'order by messageText.msgTime desc";
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
	 * @see com.bbsBlog.dao.MessageDao#listMessageByR(int, int, long)
	 * 
	 * @param offset
	 * 
	 * @param pageSize
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @author Robust
	 * 
	 * @date 2014年9月9日
	 */
	@Override
	public PageModel listMessageByR(int offset, int pageSize, long id) {
		// TODO 自动生成的方法存根

		// 得到总记录数
		String queryCountHql = "select count(*) from Message where userInfo1.id='"
				+ id + "' and messageText.msgType <> '2' ";
		Query query = getSession().createQuery(queryCountHql);
		int total = ((Long) query.uniqueResult()).intValue();

		String hql = "from Message where userInfo1.id='" + id
				+ "' and messageText.msgType <> '2' order by messageText.msgTime desc";
		List datas = this.getSession().createQuery(hql).setFirstResult(offset)
				.setMaxResults(pageSize).list();

		// 得到结果集
		PageModel pm = new PageModel();
		pm.setTotal(total);
		pm.setDatas(datas);
		pm.setOffset(offset);

		return pm;
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.MessageDao#listMessageById(long)
	 * @param id
	 * @return
	 *
	 * @author Robust
	 * @date 2014年9月11日
	 *
	 */
	@Override
	public Message listMessageById(long id) {
		// TODO 自动生成的方法存根
		return this.getHibernateTemplate().get(Message.class, id);
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.MessageDao#listMessageBySql(java.lang.String)
	 * @param Sql
	 * @return
	 *
	 * @author Robust
	 * @date 2014年11月18日
	 *
	 */
	@Override
	public List<Message> listMessageBySql(String Sql) {
		// TODO 自动生成的方法存根
		return this.getHibernateTemplate().find(Sql);
	}

}
