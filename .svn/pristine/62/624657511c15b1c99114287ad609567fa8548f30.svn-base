/**
 * 
 */
package com.bbsBlog.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.bbsBlog.dao.MessageTextDao;
import com.bbsBlog.entity.MessageText;

/**
 * @author Robust
 *
 * @date 2014年7月28日
 *
 */
@Repository("messageTextDao")
public class MessageTextDaoImpl implements MessageTextDao {
	
	@Resource
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.MessageTextDao#saveMessageText(com.bbsBlog.entity.MessageText)
	 */
	@Override
	public void saveMessageText(MessageText messageText) {
		// TODO 自动生成的方法存根
		this.hibernateTemplate.save(messageText);
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.MessageTextDao#updateMessageText(com.bbsBlog.entity.MessageText)
	 */
	@Override
	public void updateMessageText(MessageText messageText) {
		// TODO 自动生成的方法存根
		this.hibernateTemplate.update(messageText);
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.MessageTextDao#deleteMessageText(long)
	 */
	@Override
	public void deleteMessageText(long id) {
		// TODO 自动生成的方法存根
		this.hibernateTemplate.delete(this.hibernateTemplate.get(MessageText.class, id));
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.MessageTextDao#listMessageText()
	 */
	@Override
	public List<MessageText> listMessageText() {
		// TODO 自动生成的方法存根
		return null;
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.MessageTextDao#listMessageTextBySendId(long)
	 * @param id
	 * @return
	 *
	 * @author Robust
	 * @date 2014年9月9日
	 *
	 */
	@Override
	public List<MessageText> listMessageTextById(long id) {
		// TODO 自动生成的方法存根
		return this.hibernateTemplate.find("from MessageText where id='"+id+"'");
	}
	
	public List<MessageText> listLabelApply(String msgType)
	{
		return this.hibernateTemplate.find("from MessageText m where m.msgType='"+msgType+"'");
	}

}
