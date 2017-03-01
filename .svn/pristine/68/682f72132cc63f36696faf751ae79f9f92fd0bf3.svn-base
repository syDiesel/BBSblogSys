package com.bbsBlog.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the WealthTradeHis database table.
 * 
 */
@Entity
@Table(name="WealthTradeHis")
@NamedQuery(name="WealthTradeHi.findAll", query="SELECT w FROM WealthTradeHi w")
public class WealthTradeHi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	//bi-directional many-to-one association to Attachment
	@ManyToOne
	@JoinColumn(name="Attach_id")
	private Attachment attachment;

	//bi-directional many-to-one association to UserInfo
	@ManyToOne
	@JoinColumn(name="buyer_id2")
	private UserInfo userInfo1;

	//bi-directional many-to-one association to UserInfo
	@ManyToOne
	@JoinColumn(name="seller_id")
	private UserInfo userInfo2;

	public WealthTradeHi() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Attachment getAttachment() {
		return this.attachment;
	}

	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
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