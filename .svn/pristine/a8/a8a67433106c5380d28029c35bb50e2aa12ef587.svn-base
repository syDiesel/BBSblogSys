package com.bbsBlog.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Masters database table.
 * 
 */
@Entity
@Table(name="Masters")
@NamedQuery(name="Master.findAll", query="SELECT m FROM Master m")
public class Master implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Lob
	@Column(name="MasterExplain")
	private String masterExplain;

	//bi-directional many-to-one association to Board
	@ManyToOne
	@JoinColumn(name="boa_id")
	private Board board;

	//bi-directional many-to-one association to UserInfo
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="UserInfo_id")
	private UserInfo userInfo;

	public Master() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMasterExplain() {
		return this.masterExplain;
	}

	public void setMasterExplain(String masterExplain) {
		this.masterExplain = masterExplain;
	}

	public Board getBoard() {
		return this.board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

}