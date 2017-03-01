package com.bbsBlog.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PersonalInfo database table.
 * 
 */
@Entity
@NamedQuery(name="PersonalInfo.findAll", query="SELECT p FROM PersonalInfo p")
public class PersonalInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String address;

	private String addressShare;

	private String aihao;

	private String aihaoShare;

	private String answerDown;

	private String answerSo;

	private String answerUp;

	private String birthday;

	private String birthdayShare;

	private String company;

	private String companyShare;

	private String degree;

	private String descShare;

	private String graduate;

	private String graduateShare;

	private String hangye;

	private String hangyeShare;

	private String idno;

	private String idnoShare;

	private String jiguan;

	private String jiguanShare;

	private String job;

	private String jobShare;

	@Lob
	@Column(name="personal_desc")
	private String personalDesc;

	private String questionDown;

	private String questionSo;

	private String questionUp;

	private String realname;

	private String realnameShare;

	private String sex;

	private String shanchang;

	private String shanchangShare;

	private String shengao;

	private String shengaoShare;

	private String xueli;

	private String xueliShare;

	private String xueweiShare;

	private String zhuanye;

	private String zhuanyeShare;
	
	
	
	
	private String tizhong;
	
	private String xuexing;
	
	private String guoji;
	
	private String marry;
	
	private String zongjiao;
	
	private String phone;
	
	private String xingge;
	
	private String workYear;
	
	private String jobLevel;
	
	private String jobPlan;
	
	
    private String tizhongShare;
	
	private String xuexingShare;
	
	private String guojiShare;
	
	private String marryShare;
	
	private String zongjiaoShare;
	
	private String phoneShare;
	
	private String xinggeShare;
	
	private String workYearShare;
	
	private String jobLevelShare;
	
	private String jobPlanShare;
	
	
	

	//bi-directional one-to-one association to UserInfo
	@OneToOne
	@JoinColumn(name="id")
	private UserInfo userInfo;

	public PersonalInfo() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressShare() {
		return this.addressShare;
	}

	public void setAddressShare(String addressShare) {
		this.addressShare = addressShare;
	}

	public String getAihao() {
		return this.aihao;
	}

	public void setAihao(String aihao) {
		this.aihao = aihao;
	}

	public String getAihaoShare() {
		return this.aihaoShare;
	}

	public void setAihaoShare(String aihaoShare) {
		this.aihaoShare = aihaoShare;
	}

	public String getAnswerDown() {
		return this.answerDown;
	}

	public void setAnswerDown(String answerDown) {
		this.answerDown = answerDown;
	}

	public String getAnswerSo() {
		return this.answerSo;
	}

	public void setAnswerSo(String answerSo) {
		this.answerSo = answerSo;
	}

	public String getAnswerUp() {
		return this.answerUp;
	}

	public void setAnswerUp(String answerUp) {
		this.answerUp = answerUp;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getBirthdayShare() {
		return this.birthdayShare;
	}

	public void setBirthdayShare(String birthdayShare) {
		this.birthdayShare = birthdayShare;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCompanyShare() {
		return this.companyShare;
	}

	public void setCompanyShare(String companyShare) {
		this.companyShare = companyShare;
	}

	public String getDegree() {
		return this.degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getDescShare() {
		return this.descShare;
	}

	public void setDescShare(String descShare) {
		this.descShare = descShare;
	}

	public String getGraduate() {
		return this.graduate;
	}

	public void setGraduate(String graduate) {
		this.graduate = graduate;
	}

	public String getGraduateShare() {
		return this.graduateShare;
	}

	public void setGraduateShare(String graduateShare) {
		this.graduateShare = graduateShare;
	}

	public String getHangye() {
		return this.hangye;
	}

	public void setHangye(String hangye) {
		this.hangye = hangye;
	}

	public String getHangyeShare() {
		return this.hangyeShare;
	}

	public void setHangyeShare(String hangyeShare) {
		this.hangyeShare = hangyeShare;
	}

	public String getIdno() {
		return this.idno;
	}

	public void setIdno(String idno) {
		this.idno = idno;
	}

	public String getIdnoShare() {
		return this.idnoShare;
	}

	public void setIdnoShare(String idnoShare) {
		this.idnoShare = idnoShare;
	}

	public String getJiguan() {
		return this.jiguan;
	}

	public void setJiguan(String jiguan) {
		this.jiguan = jiguan;
	}

	public String getJiguanShare() {
		return this.jiguanShare;
	}

	public void setJiguanShare(String jiguanShare) {
		this.jiguanShare = jiguanShare;
	}

	public String getJob() {
		return this.job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getJobShare() {
		return this.jobShare;
	}

	public void setJobShare(String jobShare) {
		this.jobShare = jobShare;
	}

	public String getPersonalDesc() {
		return this.personalDesc;
	}

	public void setPersonalDesc(String personalDesc) {
		this.personalDesc = personalDesc;
	}

	public String getQuestionDown() {
		return this.questionDown;
	}

	public void setQuestionDown(String questionDown) {
		this.questionDown = questionDown;
	}

	public String getQuestionSo() {
		return this.questionSo;
	}

	public void setQuestionSo(String questionSo) {
		this.questionSo = questionSo;
	}

	public String getQuestionUp() {
		return this.questionUp;
	}

	public void setQuestionUp(String questionUp) {
		this.questionUp = questionUp;
	}

	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getRealnameShare() {
		return this.realnameShare;
	}

	public void setRealnameShare(String realnameShare) {
		this.realnameShare = realnameShare;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getShanchang() {
		return this.shanchang;
	}

	public void setShanchang(String shanchang) {
		this.shanchang = shanchang;
	}

	public String getShanchangShare() {
		return this.shanchangShare;
	}

	public void setShanchangShare(String shanchangShare) {
		this.shanchangShare = shanchangShare;
	}

	public String getShengao() {
		return this.shengao;
	}

	public void setShengao(String shengao) {
		this.shengao = shengao;
	}

	public String getShengaoShare() {
		return this.shengaoShare;
	}

	public void setShengaoShare(String shengaoShare) {
		this.shengaoShare = shengaoShare;
	}

	public String getXueli() {
		return this.xueli;
	}

	public void setXueli(String xueli) {
		this.xueli = xueli;
	}

	public String getXueliShare() {
		return this.xueliShare;
	}

	public void setXueliShare(String xueliShare) {
		this.xueliShare = xueliShare;
	}

	public String getXueweiShare() {
		return this.xueweiShare;
	}

	public void setXueweiShare(String xueweiShare) {
		this.xueweiShare = xueweiShare;
	}

	public String getZhuanye() {
		return this.zhuanye;
	}

	public void setZhuanye(String zhuanye) {
		this.zhuanye = zhuanye;
	}

	public String getZhuanyeShare() {
		return this.zhuanyeShare;
	}

	public void setZhuanyeShare(String zhuanyeShare) {
		this.zhuanyeShare = zhuanyeShare;
	}

	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public String getTizhong() {
		return tizhong;
	}

	public void setTizhong(String tizhong) {
		this.tizhong = tizhong;
	}

	public String getXuexing() {
		return xuexing;
	}

	public void setXuexing(String xuexing) {
		this.xuexing = xuexing;
	}

	public String getGuoji() {
		return guoji;
	}

	public void setGuoji(String guoji) {
		this.guoji = guoji;
	}

	public String getMarry() {
		return marry;
	}

	public void setMarry(String marry) {
		this.marry = marry;
	}

	public String getZongjiao() {
		return zongjiao;
	}

	public void setZongjiao(String zongjiao) {
		this.zongjiao = zongjiao;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getXingge() {
		return xingge;
	}

	public void setXingge(String xingge) {
		this.xingge = xingge;
	}

	public String getWorkYear() {
		return workYear;
	}

	public void setWorkYear(String workYear) {
		this.workYear = workYear;
	}

	public String getJobLevel() {
		return jobLevel;
	}

	public void setJobLevel(String jobLevel) {
		this.jobLevel = jobLevel;
	}

	public String getJobPlan() {
		return jobPlan;
	}

	public void setJobPlan(String jobPlan) {
		this.jobPlan = jobPlan;
	}

	public String getTizhongShare() {
		return tizhongShare;
	}

	public void setTizhongShare(String tizhongShare) {
		this.tizhongShare = tizhongShare;
	}

	public String getXuexingShare() {
		return xuexingShare;
	}

	public void setXuexingShare(String xuexingShare) {
		this.xuexingShare = xuexingShare;
	}

	public String getGuojiShare() {
		return guojiShare;
	}

	public void setGuojiShare(String guojiShare) {
		this.guojiShare = guojiShare;
	}

	public String getMarryShare() {
		return marryShare;
	}

	public void setMarryShare(String marryShare) {
		this.marryShare = marryShare;
	}

	public String getZongjiaoShare() {
		return zongjiaoShare;
	}

	public void setZongjiaoShare(String zongjiaoShare) {
		this.zongjiaoShare = zongjiaoShare;
	}

	public String getPhoneShare() {
		return phoneShare;
	}

	public void setPhoneShare(String phoneShare) {
		this.phoneShare = phoneShare;
	}

	public String getXinggeShare() {
		return xinggeShare;
	}

	public void setXinggeShare(String xinggeShare) {
		this.xinggeShare = xinggeShare;
	}

	public String getWorkYearShare() {
		return workYearShare;
	}

	public void setWorkYearShare(String workYearShare) {
		this.workYearShare = workYearShare;
	}

	public String getJobLevelShare() {
		return jobLevelShare;
	}

	public void setJobLevelShare(String jobLevelShare) {
		this.jobLevelShare = jobLevelShare;
	}

	public String getJobPlanShare() {
		return jobPlanShare;
	}

	public void setJobPlanShare(String jobPlanShare) {
		this.jobPlanShare = jobPlanShare;
	}
	
	
	

}