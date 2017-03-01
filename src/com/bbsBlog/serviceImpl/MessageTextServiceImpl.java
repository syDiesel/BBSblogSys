/**
 * 
 */
package com.bbsBlog.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bbsBlog.dao.MessageTextDao;
import com.bbsBlog.entity.MessageText;
import com.bbsBlog.service.MessageTextService;

/**
 * @author Robust
 *
 * @date 2014年7月30日
 *
 */
@Service("messageTextService")
public class MessageTextServiceImpl implements MessageTextService {

	@Resource
	private MessageTextDao messageTextDao;

	/**
	 * @return messageTextDao
	 */
	public MessageTextDao getMessageTextDao() {
		return messageTextDao;
	}

	/**
	 * @param messageTextDao
	 *            要设置的 messageTextDao
	 */
	public void setMessageTextDao(MessageTextDao messageTextDao) {
		this.messageTextDao = messageTextDao;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * com.bbsBlog.service.MessageTextService#saveMessageText(com.bbsBlog.entity
	 * .MessageText)
	 */
	@Override
	public void saveMessageText(MessageText messageText) {
		// TODO 自动生成的方法存根
		this.messageTextDao.saveMessageText(messageText);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * com.bbsBlog.service.MessageTextService#updateMessageText(com.bbsBlog.
	 * entity.MessageText)
	 */
	@Override
	public void updateMessageText(MessageText messageText) {
		// TODO 自动生成的方法存根
		this.messageTextDao.updateMessageText(messageText);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.service.MessageTextService#deleteMessageText(long)
	 */
	@Override
	public void deleteMessageText(long id) {
		// TODO 自动生成的方法存根
		this.messageTextDao.deleteMessageText(id);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.service.MessageTextService#listMessageText()
	 */
	@Override
	public List<MessageText> listMessageText() {
		// TODO 自动生成的方法存根
		return null;
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.service.MessageTextService#listMessageTextById(long)
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
		return this.messageTextDao.listMessageTextById(id);
	}
	
	public List<MessageText> listLabelApply(String msgType){
		return this.messageTextDao.listLabelApply(msgType);
	}

}
