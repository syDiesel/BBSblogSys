package com.bbsBlog.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the MasterApply database table.
 * 
 */
@Entity
@NamedQuery(name="MasterApply.findAll", query="SELECT m FROM MasterApply m")
public class MasterApply implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Lob
	@Column(name="apply_desc")
	private String applyDesc;

	private String time;

	//bi-directional many-to-one association to Board
	@ManyToOne
	@JoinColumn(name="boa_id")
	private Board board;

	//bi-directional many-to-one association to UserInfo
	@ManyToOne
	@JoinColumn(name="Use_id")
	private UserInfo userInfo;

	public MasterApply() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getApplyDesc() {
		return this.applyDesc;
	}

	public void setApplyDesc(String applyDesc) {
		this.applyDesc = applyDesc;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
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