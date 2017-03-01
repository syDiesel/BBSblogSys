package com.bbsBlog.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the UserAlbumPhoto database table.
 * 
 */
@Entity
@NamedQuery(name="UserAlbumPhoto.findAll", query="SELECT u FROM UserAlbumPhoto u")
public class UserAlbumPhoto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String down;

	private String normal;

	private String photo;

	@Lob
	@Column(name="photo_desc")
	private String photoDesc;

	@Column(name="photo_time")
	private String photoTime;

	private String root;

	private String up;

	@Column(name="ZZZM")
	private String zzzm;

	//bi-directional many-to-one association to UserAlbum
	@OneToMany(mappedBy="userAlbumPhoto")
	private List<UserAlbum> userAlbums;

	//bi-directional many-to-one association to UserAlbum
	@ManyToOne
	@JoinColumn(name="album_id")
	private UserAlbum userAlbum;

	//bi-directional many-to-one association to PhotoPJ
	@OneToMany(mappedBy="userAlbumPhoto",cascade=CascadeType.ALL)
	private List<PhotoPJ> photoPjs;

	public UserAlbumPhoto() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDown() {
		return this.down;
	}

	public void setDown(String down) {
		this.down = down;
	}

	public String getNormal() {
		return this.normal;
	}

	public void setNormal(String normal) {
		this.normal = normal;
	}

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getPhotoDesc() {
		return this.photoDesc;
	}

	public void setPhotoDesc(String photoDesc) {
		this.photoDesc = photoDesc;
	}

	public String getPhotoTime() {
		return this.photoTime;
	}

	public void setPhotoTime(String photoTime) {
		this.photoTime = photoTime;
	}

	public String getRoot() {
		return this.root;
	}

	public void setRoot(String root) {
		this.root = root;
	}

	public String getUp() {
		return this.up;
	}

	public void setUp(String up) {
		this.up = up;
	}

	public String getZzzm() {
		return this.zzzm;
	}

	public void setZzzm(String zzzm) {
		this.zzzm = zzzm;
	}

	public List<UserAlbum> getUserAlbums() {
		return this.userAlbums;
	}

	public void setUserAlbums(List<UserAlbum> userAlbums) {
		this.userAlbums = userAlbums;
	}

	public UserAlbum addUserAlbum(UserAlbum userAlbum) {
		getUserAlbums().add(userAlbum);
		userAlbum.setUserAlbumPhoto(this);

		return userAlbum;
	}

	public UserAlbum removeUserAlbum(UserAlbum userAlbum) {
		getUserAlbums().remove(userAlbum);
		userAlbum.setUserAlbumPhoto(null);

		return userAlbum;
	}

	public UserAlbum getUserAlbum() {
		return this.userAlbum;
	}

	public void setUserAlbum(UserAlbum userAlbum) {
		this.userAlbum = userAlbum;
	}

	public List<PhotoPJ> getPhotoPjs() {
		return this.photoPjs;
	}

	public void setPhotoPjs(List<PhotoPJ> photoPjs) {
		this.photoPjs = photoPjs;
	}

	public PhotoPJ addPhotoPj(PhotoPJ photoPj) {
		getPhotoPjs().add(photoPj);
		photoPj.setUserAlbumPhoto(this);

		return photoPj;
	}

	public PhotoPJ removePhotoPj(PhotoPJ photoPj) {
		getPhotoPjs().remove(photoPj);
		photoPj.setUserAlbumPhoto(null);

		return photoPj;
	}

}