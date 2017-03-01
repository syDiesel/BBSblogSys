/**
 * 
 */
package com.bbsBlog.dao;

import java.util.List;

import com.bbsBlog.entity.Message;
import com.bbsBlog.util.PageModel;

/**
 * @author Robust
 *
 * @date 2014年7月26日
 *
 */
public interface MessageDao {

	public void saveMessage(Message message);

	public void updateMessage(Message message);

	public void deleteMessage(long id);

	public PageModel listMessage(int offset,int pageSize);
	
	public PageModel listMessageByS(int offset,int pageSize,long id);
	
	public PageModel listMessageByR(int offset,int pageSize,long id);
	
	public Message listMessageById(long id);
	
	public List<Message> listMessageBySql(String Sql);
	
}
