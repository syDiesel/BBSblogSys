/**
 * 
 */
package com.bbsBlog.service;

import java.util.List;

import com.bbsBlog.entity.MessageText;

/**
 * @author Robust
 *
 * @date 2014年7月29日
 *
 */
public interface MessageTextService {

	public void saveMessageText(MessageText messageText);

	public void updateMessageText(MessageText messageText);

	public void deleteMessageText(long id);

	public List<MessageText> listMessageText();

	public List<MessageText> listMessageTextById(long id) ;
	
	public List<MessageText> listLabelApply(String msgType);
}