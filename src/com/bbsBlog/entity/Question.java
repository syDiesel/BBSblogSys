package com.bbsBlog.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the Question database table.
 * 
 */
@Entity
@NamedQuery(name="Question.findAll", query="SELECT q FROM Question q")
public class Question implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="chargeType")
	private String moneyType;

	private String hiddenUser;

	private String keywordA;

	private String keywordB;

	private String keywordC;
	
	@Column(name="answerCount")
	private int answerCount;
	
	public int getAnswerCount() {
		return answerCount;
	}
	public void setAnswerCount(int answerCount) {
		this.answerCount = answerCount;
	}
	/**
	 * @return qContent
	 */
	public String getqContent() {
		return qContent;
	}
	
	//问题收藏
	@OneToMany(mappedBy="question",cascade=CascadeType.ALL)
	private List<QAFavor> qAfavorList;
	
	public List<QAFavor> getqAfavorList() {
		return qAfavorList;
	}
	public void setqAfavorList(List<QAFavor> qAfavorList) {
		this.qAfavorList = qAfavorList;
	}
	
	//问题关注
	@OneToMany(mappedBy="question",cascade=CascadeType.ALL)
	private List<QAConcern> qAConcernList;
	
	public List<QAConcern> getqAConcernList() {
		return qAConcernList;
	}
	public void setqAConcernList(List<QAConcern> qAConcernList) {
		this.qAConcernList = qAConcernList;
	}
	
	/**
	 * @param qContent 要设置的 qContent
	 */
	public void setqContent(String qContent) {
		this.qContent = qContent;
	}

	/**
	 * @return qSubject
	 */
	public String getqSubject() {
		return qSubject;
	}

	/**
	 * @param qSubject 要设置的 qSubject
	 */
	public void setqSubject(String qSubject) {
		this.qSubject = qSubject;
	}

	/**
	 * @return qTime
	 */
	public String getqTime() {
		return qTime;
	}

	/**
	 * @param qTime 要设置的 qTime
	 */
	public void setqTime(String qTime) {
		this.qTime = qTime;
	}

	@Column(name="q_access")
	private String qAccess;

	@Lob
	@Column(name="q_content")
	private String qContent;

	@Column(name="q_subject")
	private String qSubject;

	@Column(name="q_time")
	private String qTime;

	private String value;

	//bi-directional many-to-one association to Answer
	@OneToMany(mappedBy="question",cascade=CascadeType.ALL)
	private List<Answer> answers;

	//bi-directional many-to-one association to Board
	@ManyToOne
	@JoinColumn(name="boa_id")
	private Board board;

	//bi-directional many-to-one association to UserInfo
	@ManyToOne
	@JoinColumn(name="UserInfo_id")
	private UserInfo userInfo;

	//bi-directional many-to-one association to QuestionLabel
	@OneToMany(mappedBy="question",cascade=CascadeType.ALL)
	private List<QuestionLabel> questionLabels;

	public Question() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return qAccess
	 */
	public String getqAccess() {
		return qAccess;
	}

	/**
	 * @param qAccess 要设置的 qAccess
	 */
	public void setqAccess(String qAccess) {
		this.qAccess = qAccess;
	}

	/**
	 * @return moneyType
	 */
	public String getMoneyType() {
		return moneyType;
	}

	/**
	 * @param moneyType 要设置的 moneyType
	 */
	public void setMoneyType(String moneyType) {
		this.moneyType = moneyType;
	}

	public String getHiddenUser() {
		return this.hiddenUser;
	}

	public void setHiddenUser(String hiddenUser) {
		this.hiddenUser = hiddenUser;
	}

	public String getKeywordA() {
		return this.keywordA;
	}

	public void setKeywordA(String keywordA) {
		this.keywordA = keywordA;
	}

	public String getKeywordB() {
		return this.keywordB;
	}

	public void setKeywordB(String keywordB) {
		this.keywordB = keywordB;
	}

	public String getKeywordC() {
		return this.keywordC;
	}

	public void setKeywordC(String keywordC) {
		this.keywordC = keywordC;
	}

	public String getQAccess() {
		return this.qAccess;
	}

	public void setQAccess(String qAccess) {
		this.qAccess = qAccess;
	}

	public String getQContent() {
		return this.qContent;
	}

	public void setQContent(String qContent) {
		this.qContent = qContent;
	}

	public String getQSubject() {
		return this.qSubject;
	}

	public void setQSubject(String qSubject) {
		this.qSubject = qSubject;
	}

	public String getQTime() {
		return this.qTime;
	}

	public void setQTime(String qTime) {
		this.qTime = qTime;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<Answer> getAnswers() {
		return this.answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public Answer addAnswer(Answer answer) {
		getAnswers().add(answer);
		answer.setQuestion(this);

		return answer;
	}

	public Answer removeAnswer(Answer answer) {
		getAnswers().remove(answer);
		answer.setQuestion(null);

		return answer;
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

	public List<QuestionLabel> getQuestionLabels() {
		return this.questionLabels;
	}

	public void setQuestionLabels(List<QuestionLabel> questionLabels) {
		this.questionLabels = questionLabels;
	}

	public QuestionLabel addQuestionLabel(QuestionLabel questionLabel) {
		getQuestionLabels().add(questionLabel);
		questionLabel.setQuestion(this);

		return questionLabel;
	}

	public QuestionLabel removeQuestionLabel(QuestionLabel questionLabel) {
		getQuestionLabels().remove(questionLabel);
		questionLabel.setQuestion(null);

		return questionLabel;
	}

}