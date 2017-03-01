package com.bbsBlog.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Cash database table.
 * 
 */
@Entity
@Table(name = "Cash")
@NamedQuery(name="Cash.findAll", query="SELECT c FROM Cash c")
public class Cash implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Lob
	private String amount;

	private String date;
	
	private String isDeal;
	
	private String dealDate;
	
	private String cashDate;

	public String getCashDate() {
		return cashDate;
	}

	public void setCashDate(String cashDate) {
		this.cashDate = cashDate;
	}

	public String getIsDeal() {
		return isDeal;
	}

	public String getDealDate() {
		return dealDate;
	}

	public void setDealDate(String dealDate) {
		this.dealDate = dealDate;
	}

	public void setIsDeal(String isDeal) {
		this.isDeal = isDeal;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	//bi-directional many-to-one association to UserInfo
	@ManyToOne
	@JoinColumn(name="Use_id")
	private UserInfo userInfo;

	}