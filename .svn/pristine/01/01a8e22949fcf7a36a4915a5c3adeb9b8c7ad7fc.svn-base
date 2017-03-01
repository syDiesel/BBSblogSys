package com.bbsBlog.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the Role database table.
 * 
 */
@Entity
@NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String role;

	@Lob
	@Column(name = "role_desc")
	private String roleDesc;

	// bi-directional many-to-one association to UserInfo
	@OneToMany(mappedBy = "role")
	private List<UserInfo> userInfos;

	public Role() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getRoleDesc() {
		return this.roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public List<UserInfo> getUserInfos() {
		return this.userInfos;
	}

	public void setUserInfos(List<UserInfo> userInfos) {
		this.userInfos = userInfos;
	}

	public UserInfo addUserInfo(UserInfo userInfo) {
		getUserInfos().add(userInfo);
		userInfo.setRole(this);

		return userInfo;
	}

	public UserInfo removeUserInfo(UserInfo userInfo) {
		getUserInfos().remove(userInfo);
		userInfo.setRole(null);

		return userInfo;
	}

}