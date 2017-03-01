package com.bbsBlog.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the Attachment database table.
 * 
 */
@Entity
@NamedQuery(name="Attachment.findAll", query="SELECT a FROM Attachment a")
public class Attachment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String access;

	@Lob
	@Column(name="attach_desc")
	private String attachDesc;

	@Column(name="attach_download")
	private String attachDownload;

	@Column(name="attach_name")
	private String attachName;

	@Column(name="attach_size")
	private String attachSize;

	@Column(name="attach_time")
	private String attachTime;

	@Column(name="attach_url")
	private String attachUrl;

	private String down;

	private String jinzhuanWealth;

	private String lingdanWealth;

	private String normal;

	@Column(name="up_count")
	private String upCount;

	//bi-directional many-to-one association to AttachStatus
	@ManyToOne
	@JoinColumn(name="status_id")
	private AttachStatus attachStatus;

	//bi-directional many-to-one association to UserInfo
	@ManyToOne
	@JoinColumn(name="UserInfo_id")
	private UserInfo userInfo;

	//bi-directional many-to-one association to WealthTradeHi
	@OneToMany(mappedBy="attachment",cascade=CascadeType.ALL)
	private List<WealthTradeHi> wealthTradeHis;

	//bi-directional many-to-one association to AttachDownload
	@OneToMany(mappedBy="attachment",cascade=CascadeType.ALL)
	private List<AttachDownload> attachDownloads;

	public Attachment() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAccess() {
		return this.access;
	}

	public void setAccess(String access) {
		this.access = access;
	}

	public String getAttachDesc() {
		return this.attachDesc;
	}

	public void setAttachDesc(String attachDesc) {
		this.attachDesc = attachDesc;
	}

	public String getAttachDownload() {
		return this.attachDownload;
	}

	public void setAttachDownload(String attachDownload) {
		this.attachDownload = attachDownload;
	}

	public String getAttachName() {
		return this.attachName;
	}

	public void setAttachName(String attachName) {
		this.attachName = attachName;
	}

	public String getAttachSize() {
		return this.attachSize;
	}

	public void setAttachSize(String attachSize) {
		this.attachSize = attachSize;
	}

	public String getAttachTime() {
		return this.attachTime;
	}

	public void setAttachTime(String attachTime) {
		this.attachTime = attachTime;
	}

	public String getAttachUrl() {
		return this.attachUrl;
	}

	public void setAttachUrl(String attachUrl) {
		this.attachUrl = attachUrl;
	}

	public String getDown() {
		return this.down;
	}

	public void setDown(String down) {
		this.down = down;
	}

	public String getJinzhuanWealth() {
		return this.jinzhuanWealth;
	}

	public void setJinzhuanWealth(String jinzhuanWealth) {
		this.jinzhuanWealth = jinzhuanWealth;
	}

	public String getLingdanWealth() {
		return this.lingdanWealth;
	}

	public void setLingdanWealth(String lingdanWealth) {
		this.lingdanWealth = lingdanWealth;
	}

	public String getNormal() {
		return this.normal;
	}

	public void setNormal(String normal) {
		this.normal = normal;
	}

	public String getUpCount() {
		return this.upCount;
	}

	public void setUpCount(String upCount) {
		this.upCount = upCount;
	}

	public AttachStatus getAttachStatus() {
		return this.attachStatus;
	}

	public void setAttachStatus(AttachStatus attachStatus) {
		this.attachStatus = attachStatus;
	}

	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public List<WealthTradeHi> getWealthTradeHis() {
		return this.wealthTradeHis;
	}

	public void setWealthTradeHis(List<WealthTradeHi> wealthTradeHis) {
		this.wealthTradeHis = wealthTradeHis;
	}

	public WealthTradeHi addWealthTradeHi(WealthTradeHi wealthTradeHi) {
		getWealthTradeHis().add(wealthTradeHi);
		wealthTradeHi.setAttachment(this);

		return wealthTradeHi;
	}

	public WealthTradeHi removeWealthTradeHi(WealthTradeHi wealthTradeHi) {
		getWealthTradeHis().remove(wealthTradeHi);
		wealthTradeHi.setAttachment(null);

		return wealthTradeHi;
	}

	public List<AttachDownload> getAttachDownloads() {
		return this.attachDownloads;
	}

	public void setAttachDownloads(List<AttachDownload> attachDownloads) {
		this.attachDownloads = attachDownloads;
	}

	public AttachDownload addAttachDownload(AttachDownload attachDownload) {
		getAttachDownloads().add(attachDownload);
		attachDownload.setAttachment(this);

		return attachDownload;
	}

	public AttachDownload removeAttachDownload(AttachDownload attachDownload) {
		getAttachDownloads().remove(attachDownload);
		attachDownload.setAttachment(null);

		return attachDownload;
	}

}