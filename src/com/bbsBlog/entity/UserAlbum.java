package com.bbsBlog.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the UserAlbum database table.
 * 
 */
@Entity
@NamedQuery(name="UserAlbum.findAll", query="SELECT u FROM UserAlbum u")
public class UserAlbum implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Column(name="album_date")
	private String albumDate;

	@Lob
	@Column(name="album_desc")
	private String albumDesc;

	@Column(name="album_name")
	private String albumName;

	@Column(name="album_password")
	private String albumPassword;

	private String islocked;
	
	@Column(name="level_limit")
	private String levelLimit;
	
	private String isConcern;
	
	private String isPass;

	public String getIsPass() {
		return isPass;
	}

	public void setIsPass(String isPass) {
		this.isPass = isPass;
	}

	public String getIsConcern() {
		return isConcern;
	}

	public void setIsConcern(String isConcern) {
		this.isConcern = isConcern;
	}

	public String getLevelLimit() {
		return levelLimit;
	}

	public void setLevelLimit(String levelLimit) {
		this.levelLimit = levelLimit;
	}

	//bi-directional many-to-one association to UserAlbumPhoto
	@ManyToOne
	@JoinColumn(name="cover_id")
	private UserAlbumPhoto userAlbumPhoto;

	//bi-directional many-to-one association to UserInfo
	@ManyToOne
	@JoinColumn(name="UserInfo_id")
	private UserInfo userInfo;

	//bi-directional many-to-one association to UserAlbumPhoto
	@OneToMany(mappedBy="userAlbum")
	private List<UserAlbumPhoto> userAlbumPhotos;

	public UserAlbum() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAlbumDate() {
		return this.albumDate;
	}

	public void setAlbumDate(String albumDate) {
		this.albumDate = albumDate;
	}

	public String getAlbumDesc() {
		return this.albumDesc;
	}

	public void setAlbumDesc(String albumDesc) {
		this.albumDesc = albumDesc;
	}

	public String getAlbumName() {
		return this.albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public String getAlbumPassword() {
		return this.albumPassword;
	}

	public void setAlbumPassword(String albumPassword) {
		this.albumPassword = albumPassword;
	}

	public String getIslocked() {
		return this.islocked;
	}

	public void setIslocked(String islocked) {
		this.islocked = islocked;
	}

	public UserAlbumPhoto getUserAlbumPhoto() {
		return this.userAlbumPhoto;
	}

	public void setUserAlbumPhoto(UserAlbumPhoto userAlbumPhoto) {
		this.userAlbumPhoto = userAlbumPhoto;
	}

	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public List<UserAlbumPhoto> getUserAlbumPhotos() {
		return this.userAlbumPhotos;
	}

	public void setUserAlbumPhotos(List<UserAlbumPhoto> userAlbumPhotos) {
		this.userAlbumPhotos = userAlbumPhotos;
	}

	public UserAlbumPhoto addUserAlbumPhoto(UserAlbumPhoto userAlbumPhoto) {
		getUserAlbumPhotos().add(userAlbumPhoto);
		userAlbumPhoto.setUserAlbum(this);

		return userAlbumPhoto;
	}

	public UserAlbumPhoto removeUserAlbumPhoto(UserAlbumPhoto userAlbumPhoto) {
		getUserAlbumPhotos().remove(userAlbumPhoto);
		userAlbumPhoto.setUserAlbum(null);

		return userAlbumPhoto;
	}

}