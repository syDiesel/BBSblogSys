package com.bbsBlog.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Message database table.
 * 
 */
@Entity
@NamedQuery(name="Message.findAll", query="SELECT m FROM Message m")
public class Message implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String isRead;

	//bi-directional many-to-one association to MessageText
	@ManyToOne
	@JoinColumn(name="Msg_id")
	private MessageText messageText;

	//bi-directional many-to-one association to UserInfo
	@ManyToOne
	@JoinColumn(name="Rec_id")
	private UserInfo userInfo1;

	//bi-directional many-to-one association to UserInfo
	@ManyToOne
	@JoinColumn(name="Send_id")
	private UserInfo userInfo2;

	public Message() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIsRead() {
		return this.isRead;
	}

	public void setIsRead(String isRead) {
		this.isRead = isRead;
	}

	public MessageText getMessageText() {
		return this.messageText;
	}

	public void setMessageText(MessageText messageText) {
		this.messageText = messageText;
	}

	public UserInfo getUserInfo1() {
		return this.userInfo1;
	}

	public void setUserInfo1(UserInfo userInfo1) {
		this.userInfo1 = userInfo1;
	}

	public UserInfo getUserInfo2() {
		return this.userInfo2;
	}

	public void setUserInfo2(UserInfo userInfo2) {
		this.userInfo2 = userInfo2;
	}

}