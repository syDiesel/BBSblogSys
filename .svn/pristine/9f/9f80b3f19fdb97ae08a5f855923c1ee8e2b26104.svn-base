package com.bbsBlog.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the MessageText database table.
 * 
 */
@Entity
@NamedQuery(name="MessageText.findAll", query="SELECT m FROM MessageText m")
public class MessageText implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Lob
	@Column(name="msg_content")
	private String msgContent;

	@Column(name="msg_subject")
	private String msgSubject;

	@Column(name="msg_time")
	private String msgTime;

	@Column(name="msg_type")
	private String msgType;

	//bi-directional many-to-one association to Message
	@OneToMany(mappedBy="messageText")
	private List<Message> messages;

	public MessageText() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMsgContent() {
		return this.msgContent;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}

	public String getMsgSubject() {
		return this.msgSubject;
	}

	public void setMsgSubject(String msgSubject) {
		this.msgSubject = msgSubject;
	}

	public String getMsgTime() {
		return this.msgTime;
	}

	public void setMsgTime(String msgTime) {
		this.msgTime = msgTime;
	}

	public String getMsgType() {
		return this.msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public List<Message> getMessages() {
		return this.messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public Message addMessage(Message message) {
		getMessages().add(message);
		message.setMessageText(this);

		return message;
	}

	public Message removeMessage(Message message) {
		getMessages().remove(message);
		message.setMessageText(null);

		return message;
	}

}