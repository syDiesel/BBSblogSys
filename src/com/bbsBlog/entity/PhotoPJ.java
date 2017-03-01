package com.bbsBlog.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the photoPJ database table.
 * 
 */
@Entity
@Table(name="photoPJ")
@NamedQuery(name="PhotoPJ.findAll", query="SELECT p FROM PhotoPJ p")
public class PhotoPJ implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String time;

	//bi-directional many-to-one association to UserAlbumPhoto
	@ManyToOne
	@JoinColumn(name="photo_id")
	private UserAlbumPhoto userAlbumPhoto;

	//bi-directional many-to-one association to UserInfo
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserInfo userInfo;

	public PhotoPJ() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
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

}