/**
 * 
 */
package com.bbsBlog.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bbsBlog.dao.MessageDao;
import com.bbsBlog.entity.Message;
import com.bbsBlog.service.MessageService;
import com.bbsBlog.util.PageModel;

/**
 * @author Robust
 *
 * @date 2014年7月30日
 *
 */
@Service("messageService")
public class MessageServiceImpl implements MessageService {

	@Resource
	private MessageDao messageDao;

	/**
	 * @return messageDao
	 */
	public MessageDao getMessageDao() {
		return messageDao;
	}

	/**
	 * @param messageDao
	 *            要设置的 messageDao
	 */
	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * com.bbsBlog.service.MessageService#saveMessage(com.bbsBlog.entity.Message
	 * )
	 */
	@Override
	public void saveMessage(Message message) {
		// TODO 自动生成的方法存根
		this.messageDao.saveMessage(message);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * com.bbsBlog.service.MessageService#updateMessage(com.bbsBlog.entity.Message
	 * )
	 */
	@Override
	public void updateMessage(Message message) {
		// TODO 自动生成的方法存根
		this.messageDao.updateMessage(message);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.service.MessageService#deleteMessage(long)
	 */
	@Override
	public void deleteMessage(long id) {
		// TODO 自动生成的方法存根
		this.messageDao.deleteMessage(id);
		
	}


	/* （非 Javadoc）
	 * @see com.bbsBlog.service.MessageService#listMessage(int, int)
	 * @param offset
	 * @param pageSize
	 * @return
	 *
	 * @author Robust
	 * @date 2014年9月9日
	 *
	 */
	@Override
	public PageModel listMessage(int offset, int pageSize) {
		// TODO 自动生成的方法存根
		return this.messageDao.listMessage(offset, pageSize);
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.service.MessageService#listMessageByS(int, int, long)
	 * @param offset
	 * @param pageSize
	 * @param id
	 * @return
	 *
	 * @author Robust
	 * @date 2014年9月9日
	 *
	 */
	@Override
	public PageModel listMessageByS(int offset, int pageSize, long id) {
		// TODO 自动生成的方法存根
		return this.messageDao.listMessageByS(offset, pageSize, id);
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.service.MessageService#listMessageByR(int, int, long)
	 * @param offset
	 * @param pageSize
	 * @param id
	 * @return
	 *
	 * @author Robust
	 * @date 2014年9月9日
	 *
	 */
	@Override
	public PageModel listMessageByR(int offset, int pageSize, long id) {
		// TODO 自动生成的方法存根
		return this.messageDao.listMessageByR(offset, pageSize, id);
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.service.MessageService#listMessageById(long)
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
		return this.messageDao.listMessageById(id);
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.service.MessageService#listMessageBySql(java.lang.String)
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
		return this.messageDao.listMessageBySql(Sql);
	}

}
