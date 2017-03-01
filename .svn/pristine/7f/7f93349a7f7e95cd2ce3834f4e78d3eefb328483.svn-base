package com.bbsBlog.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the Answer database table.
 * 
 */
@Entity
@NamedQuery(name="Answer.findAll", query="SELECT a FROM Answer a")
public class Answer implements Serializable {
	/**
	 * @return aContent
	 */
	public String getaContent() {
		return aContent;
	}

	/**
	 * @param aContent 要设置的 aContent
	 */
	public void setaContent(String aContent) {
		this.aContent = aContent;
	}

	/**
	 * @return aTime
	 */
	public String getaTime() {
		return aTime;
	}

	/**
	 * @param aTime 要设置的 aTime
	 */
	public void setaTime(String aTime) {
		this.aTime = aTime;
	}

	/**
	 * @return qcommit
	 */
	public String getQcommit() {
		return qcommit;
	}

	/**
	 * @param qcommit 要设置的 qcommit
	 */
	public void setQcommit(String qcommit) {
		this.qcommit = qcommit;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Lob
	@Column(name="a_content")
	private String aContent;

	@Column(name="a_time")
	private String aTime;

	private String down;

	private String isPublic;

	private long isReAsk;
	
	private String normal;
	
	@Column(name="Qcommit")
	private String qcommit;

	private long reCount;

	private long related;
	
	private String baochou;

	@Column(name="ltime")
	private String ltime;

	public String getLtime() {
		return ltime;
	}

	public void setLtime(String ltime) {
		this.ltime = ltime;
	}

	@Column(name="up_count")
	private int upCount;

	@Column(name="isBest")
	private String isBest;
	
	public String getIsBest() {
		return isBest;
	}

	public void setIsBest(String isBest) {
		this.isBest = isBest;
	}

	//bi-directional many-to-one association to Question
	@ManyToOne
	@JoinColumn(name="q_id")
	private Question question;

	//bi-directional many-to-one association to UserInfo
	@ManyToOne
	@JoinColumn(name="UserInfo_id")
	private UserInfo userInfo;

	//bi-directional many-to-one association to QuestionPJ
	@OneToMany(mappedBy="answer",cascade=CascadeType.ALL)
	private List<QuestionPJ> questionPjs;

	public Answer() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAContent() {
		return this.aContent;
	}

	public void setAContent(String aContent) {
		this.aContent = aContent;
	}

	public String getATime() {
		return this.aTime;
	}

	public void setATime(String aTime) {
		this.aTime = aTime;
	}

	public String getDown() {
		return this.down;
	}

	public void setDown(String down) {
		this.down = down;
	}

	public String getIsPublic() {
		return this.isPublic;
	}

	public void setIsPublic(String isPublic) {
		this.isPublic = isPublic;
	}

	public long getIsReAsk() {
		return this.isReAsk;
	}

	public void setIsReAsk(long isReAsk) {
		this.isReAsk = isReAsk;
	}

	public String getNormal() {
		return this.normal;
	}

	public void setNormal(String normal) {
		this.normal = normal;
	}

	public String getqComment() {
		return this.qcommit;
	}

	public void setqComment(String qcommit) {
		this.qcommit = qcommit;
	}

	public long getReCount() {
		return this.reCount;
	}

	public void setReCount(long reCount) {
		this.reCount = reCount;
	}

	public long getRelated() {
		return this.related;
	}

	public void setRelated(long related) {
		this.related = related;
	}

	public int getUpCount() {
		return this.upCount;
	}

	public void setUpCount(int upCount) {
		this.upCount = upCount;
	}

	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public List<QuestionPJ> getQuestionPjs() {
		return this.questionPjs;
	}

	public void setQuestionPjs(List<QuestionPJ> questionPjs) {
		this.questionPjs = questionPjs;
	}

	public QuestionPJ addQuestionPj(QuestionPJ questionPj) {
		getQuestionPjs().add(questionPj);
		questionPj.setAnswer(this);

		return questionPj;
	}

	public QuestionPJ removeQuestionPj(QuestionPJ questionPj) {
		getQuestionPjs().remove(questionPj);
		questionPj.setAnswer(null);

		return questionPj;
	}
	
	
	public String getBaochou() {
		return baochou;
	}

	public void setBaochou(String baochou) {
		this.baochou = baochou;
	}

}