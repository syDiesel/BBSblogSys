package com.bbsBlog.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the UserInfo database table.
 * 
 */
@Entity
@NamedQuery(name="UserInfo.findAll", query="SELECT u FROM UserInfo u")
public class UserInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Column(name="[E-mail]")
	private String e_mail;

	@Column(name="head_img")
	private String headImg;

	private String isBreak;

	private String isSay;

	private String jinzhuan;

	@Column(name="LastLogin_date")
	private String lastLogin_date;

	private String lingdan;

	private String nickName;

	@Column(name="Password")
	private String password;

	@Column(name="register_date")
	private String registerDate;

	@Column(name="user_level")
	private String userLevel;

	@Column(name="User_show")
	private String user_show;

	@Column(name="user_status")
	private String userStatus;

	@Column(name="UserName")
	private String userName;

	private String xianhua;

	private String yangmu;
	
	@Column(name="upNum")
	private long upNum;
	
	@Column(name="normalNum")
	private long normalNum;
	
	@Column(name="downNum")
	private long downNum;

	@Column(name="quizzerUp")
	private long quizzerUp;
	
	@Column(name="quizzerNormal")
	private long quizzerNormal;
	
	@Column(name="quizzerDown")
	private long quizzerDown;

	
	public long getQuizzerUp() {
		return quizzerUp;
	}
	public void setQuizzerUp(long quizzerUp) {
		this.quizzerUp = quizzerUp;
	}
	public long getQuizzerNormal() {
		return quizzerNormal;
	}
	public void setQuizzerNormal(long quizzerNormal) {
		this.quizzerNormal = quizzerNormal;
	}
	public long getQuizzerDown() {
		return quizzerDown;
	}
	public void setQuizzerDown(long quizzerDown) {
		this.quizzerDown = quizzerDown;
	}
	public long getUpNum() {
		return upNum;
	}
	public void setUpNum(long upNum) {
		this.upNum = upNum;
	}
	public long getNormalNum() {
		return normalNum;
	}
	public void setNormalNum(long normalNum) {
		this.normalNum = normalNum;
	}
	public long getDownNum() {
		return downNum;
	}
	public void setDownNum(long downNum) {
		this.downNum = downNum;
	}

	//问题收藏
	@OneToMany(mappedBy="userInfo")
	private List<QAFavor> qAfavorList;
	
	public List<QAFavor> getqAfavorList() {
		return qAfavorList;
	}
	public void setqAfavorList(List<QAFavor> qAfavorList) {
		this.qAfavorList = qAfavorList;
	}
	
	//问题关注
	@OneToMany(mappedBy="userInfo")
	private List<QAConcern> qAConcernList;
	
	public List<QAConcern> getqAConcernList() {
		return qAConcernList;
	}
	public void setqAConcernList(List<QAConcern> qAConcernList) {
		this.qAConcernList = qAConcernList;
	}
	
	//bi-directional many-to-one association to Answer
	@OneToMany(mappedBy="userInfo")
	private List<Answer> answers;

	//bi-directional many-to-one association to Attachment
	@OneToMany(mappedBy="userInfo")
	private List<Attachment> attachments;

	//bi-directional many-to-one association to Audit
	@OneToMany(mappedBy="userInfo")
	private List<Audit> audits;

	//bi-directional one-to-one association to Blog
	@OneToOne(mappedBy="userInfo")
	private Blog blog;

	//bi-directional many-to-one association to BlogHI
	@OneToMany(mappedBy="userInfo")
	private List<BlogHI> blogHis;

	//bi-directional many-to-one association to Favorite
	@OneToMany(mappedBy="userInfo")
	private List<Favorite> favorites;

	//bi-directional many-to-one association to ForumPost
	@OneToMany(mappedBy="userInfo")
	private List<ForumPost> forumPosts;

	//bi-directional many-to-one association to ForumReply
	@OneToMany(mappedBy="userInfo")
	private List<ForumReply> forumReplies;

	//bi-directional many-to-one association to ForumUpHi
	@OneToMany(mappedBy="userInfo")
	private List<ForumUpHi> forumUpHis;

	//bi-directional many-to-one association to Friend
	@OneToMany(mappedBy="userInfo1")
	private List<Friend> friends1;

	//bi-directional many-to-one association to Friend
	@OneToMany(mappedBy="userInfo2")
	private List<Friend> friends2;

	//bi-directional many-to-one association to MasterApply
	@OneToMany(mappedBy="userInfo")
	private List<MasterApply> masterApplies;

	//bi-directional many-to-one association to Master
	@OneToMany(mappedBy="userInfo")
	private List<Master> masters;

	//bi-directional many-to-one association to Message
	@OneToMany(mappedBy="userInfo1")
	private List<Message> messages1;

	//bi-directional many-to-one association to Message
	@OneToMany(mappedBy="userInfo2")
	private List<Message> messages2;

	//bi-directional many-to-one association to Notice
	@OneToMany(mappedBy="userInfo")
	private List<Notice> notices;

	//bi-directional one-to-one association to PersonalInfo
	@OneToOne(mappedBy="userInfo")
	private PersonalInfo personalInfo;

	//bi-directional many-to-one association to Question
	@OneToMany(mappedBy="userInfo")
	private List<Question> questions;

	//bi-directional many-to-one association to QuestionPJ
	@OneToMany(mappedBy="userInfo")
	private List<QuestionPJ> questionPjs;

	//bi-directional many-to-one association to RechargeHi
	@OneToMany(mappedBy="userInfo")
	private List<RechargeHi> rechargeHis;

	//bi-directional many-to-one association to Suggestion
	@OneToMany(mappedBy="userInfo")
	private List<Suggestion> suggestions;

	//bi-directional many-to-one association to Tpjl
	@OneToMany(mappedBy="userInfo")
	private List<Tpjl> tpjls;

	//bi-directional many-to-one association to UserAlbum
	@OneToMany(mappedBy="userInfo")
	private List<UserAlbum> userAlbums;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="Rol_id")
	private Role role;

	//bi-directional many-to-one association to UserSecurity
	@OneToMany(mappedBy="userInfo")
	private List<UserSecurity> userSecurities;

	//bi-directional many-to-one association to UserUpHi
	@OneToMany(mappedBy="userInfo")
	private List<UserUpHi> userUpHis;

	//bi-directional many-to-one association to WealthBoard
	@OneToMany(mappedBy="userInfo")
	private List<WealthBoard> wealthBoards;

	//bi-directional many-to-one association to WealthTradeHi
	@OneToMany(mappedBy="userInfo1")
	private List<WealthTradeHi> wealthTradeHis1;

	//bi-directional many-to-one association to WealthTradeHi
	@OneToMany(mappedBy="userInfo2")
	private List<WealthTradeHi> wealthTradeHis2;

	//bi-directional many-to-one association to AttachDownload
	@OneToMany(mappedBy="userInfo")
	private List<AttachDownload> attachDownloads;

	//bi-directional many-to-one association to PhotoPJ
	@OneToMany(mappedBy="userInfo")
	private List<PhotoPJ> photoPjs;
	
	
	//bi-directional many-to-one association to Suggestion
	@OneToMany(mappedBy="userInfo")
	private List<Cash> cashs;

	/**
	 * @return cashs
	 */
	public List<Cash> getCashs() {
		return cashs;
	}
	/**
	 * @param cashs 要设置的 cashs
	 */
	public void setCashs(List<Cash> cashs) {
		this.cashs = cashs;
	}
	public UserInfo() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getE_mail() {
		return this.e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	public String getHeadImg() {
		return this.headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	public String getIsBreak() {
		return this.isBreak;
	}

	public void setIsBreak(String isBreak) {
		this.isBreak = isBreak;
	}

	public String getIsSay() {
		return this.isSay;
	}

	public void setIsSay(String isSay) {
		this.isSay = isSay;
	}

	public String getJinzhuan() {
		return this.jinzhuan;
	}

	public void setJinzhuan(String jinzhuan) {
		this.jinzhuan = jinzhuan;
	}

	public String getLastLogin_date() {
		return this.lastLogin_date;
	}

	public void setLastLogin_date(String lastLogin_date) {
		this.lastLogin_date = lastLogin_date;
	}

	public String getLingdan() {
		return this.lingdan;
	}

	public void setLingdan(String lingdan) {
		this.lingdan = lingdan;
	}

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRegisterDate() {
		return this.registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public String getUserLevel() {
		return this.userLevel;
	}

	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}

	public String getUser_show() {
		return this.user_show;
	}

	public void setUser_show(String user_show) {
		this.user_show = user_show;
	}

	public String getUserStatus() {
		return this.userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getXianhua() {
		return this.xianhua;
	}

	public void setXianhua(String xianhua) {
		this.xianhua = xianhua;
	}

	public String getYangmu() {
		return this.yangmu;
	}

	public void setYangmu(String yangmu) {
		this.yangmu = yangmu;
	}

	public List<Answer> getAnswers() {
		return this.answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public Answer addAnswer(Answer answer) {
		getAnswers().add(answer);
		answer.setUserInfo(this);

		return answer;
	}

	public Answer removeAnswer(Answer answer) {
		getAnswers().remove(answer);
		answer.setUserInfo(null);

		return answer;
	}

	public List<Attachment> getAttachments() {
		return this.attachments;
	}

	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}

	public Attachment addAttachment(Attachment attachment) {
		getAttachments().add(attachment);
		attachment.setUserInfo(this);

		return attachment;
	}

	public Attachment removeAttachment(Attachment attachment) {
		getAttachments().remove(attachment);
		attachment.setUserInfo(null);

		return attachment;
	}

	public List<Audit> getAudits() {
		return this.audits;
	}

	public void setAudits(List<Audit> audits) {
		this.audits = audits;
	}

	public Audit addAudit(Audit audit) {
		getAudits().add(audit);
		audit.setUserInfo(this);

		return audit;
	}

	public Audit removeAudit(Audit audit) {
		getAudits().remove(audit);
		audit.setUserInfo(null);

		return audit;
	}

	public Blog getBlog() {
		return this.blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public List<BlogHI> getBlogHis() {
		return this.blogHis;
	}

	public void setBlogHis(List<BlogHI> blogHis) {
		this.blogHis = blogHis;
	}

	public BlogHI addBlogHi(BlogHI blogHi) {
		getBlogHis().add(blogHi);
		blogHi.setUserInfo(this);

		return blogHi;
	}

	public BlogHI removeBlogHi(BlogHI blogHi) {
		getBlogHis().remove(blogHi);
		blogHi.setUserInfo(null);

		return blogHi;
	}

	public List<Favorite> getFavorites() {
		return this.favorites;
	}

	public void setFavorites(List<Favorite> favorites) {
		this.favorites = favorites;
	}

	public Favorite addFavorite(Favorite favorite) {
		getFavorites().add(favorite);
		favorite.setUserInfo(this);

		return favorite;
	}

	public Favorite removeFavorite(Favorite favorite) {
		getFavorites().remove(favorite);
		favorite.setUserInfo(null);

		return favorite;
	}

	public List<ForumPost> getForumPosts() {
		return this.forumPosts;
	}

	public void setForumPosts(List<ForumPost> forumPosts) {
		this.forumPosts = forumPosts;
	}

	public ForumPost addForumPost(ForumPost forumPost) {
		getForumPosts().add(forumPost);
		forumPost.setUserInfo(this);

		return forumPost;
	}

	public ForumPost removeForumPost(ForumPost forumPost) {
		getForumPosts().remove(forumPost);
		forumPost.setUserInfo(null);

		return forumPost;
	}

	public List<ForumReply> getForumReplies() {
		return this.forumReplies;
	}

	public void setForumReplies(List<ForumReply> forumReplies) {
		this.forumReplies = forumReplies;
	}

	public ForumReply addForumReply(ForumReply forumReply) {
		getForumReplies().add(forumReply);
		forumReply.setUserInfo(this);

		return forumReply;
	}

	public ForumReply removeForumReply(ForumReply forumReply) {
		getForumReplies().remove(forumReply);
		forumReply.setUserInfo(null);

		return forumReply;
	}

	public List<ForumUpHi> getForumUpHis() {
		return this.forumUpHis;
	}

	public void setForumUpHis(List<ForumUpHi> forumUpHis) {
		this.forumUpHis = forumUpHis;
	}

	public ForumUpHi addForumUpHi(ForumUpHi forumUpHi) {
		getForumUpHis().add(forumUpHi);
		forumUpHi.setUserInfo(this);

		return forumUpHi;
	}

	public ForumUpHi removeForumUpHi(ForumUpHi forumUpHi) {
		getForumUpHis().remove(forumUpHi);
		forumUpHi.setUserInfo(null);

		return forumUpHi;
	}

	public List<Friend> getFriends1() {
		return this.friends1;
	}

	public void setFriends1(List<Friend> friends1) {
		this.friends1 = friends1;
	}

	public Friend addFriends1(Friend friends1) {
		getFriends1().add(friends1);
		friends1.setUserInfo1(this);

		return friends1;
	}

	public Friend removeFriends1(Friend friends1) {
		getFriends1().remove(friends1);
		friends1.setUserInfo1(null);

		return friends1;
	}

	public List<Friend> getFriends2() {
		return this.friends2;
	}

	public void setFriends2(List<Friend> friends2) {
		this.friends2 = friends2;
	}

	public Friend addFriends2(Friend friends2) {
		getFriends2().add(friends2);
		friends2.setUserInfo2(this);

		return friends2;
	}

	public Friend removeFriends2(Friend friends2) {
		getFriends2().remove(friends2);
		friends2.setUserInfo2(null);

		return friends2;
	}

	public List<MasterApply> getMasterApplies() {
		return this.masterApplies;
	}

	public void setMasterApplies(List<MasterApply> masterApplies) {
		this.masterApplies = masterApplies;
	}

	public MasterApply addMasterApply(MasterApply masterApply) {
		getMasterApplies().add(masterApply);
		masterApply.setUserInfo(this);

		return masterApply;
	}

	public MasterApply removeMasterApply(MasterApply masterApply) {
		getMasterApplies().remove(masterApply);
		masterApply.setUserInfo(null);

		return masterApply;
	}

	public List<Master> getMasters() {
		return this.masters;
	}

	public void setMasters(List<Master> masters) {
		this.masters = masters;
	}

	public Master addMaster(Master master) {
		getMasters().add(master);
		master.setUserInfo(this);

		return master;
	}

	public Master removeMaster(Master master) {
		getMasters().remove(master);
		master.setUserInfo(null);

		return master;
	}

	public List<Message> getMessages1() {
		return this.messages1;
	}

	public void setMessages1(List<Message> messages1) {
		this.messages1 = messages1;
	}

	public Message addMessages1(Message messages1) {
		getMessages1().add(messages1);
		messages1.setUserInfo1(this);

		return messages1;
	}

	public Message removeMessages1(Message messages1) {
		getMessages1().remove(messages1);
		messages1.setUserInfo1(null);

		return messages1;
	}

	public List<Message> getMessages2() {
		return this.messages2;
	}

	public void setMessages2(List<Message> messages2) {
		this.messages2 = messages2;
	}

	public Message addMessages2(Message messages2) {
		getMessages2().add(messages2);
		messages2.setUserInfo2(this);

		return messages2;
	}

	public Message removeMessages2(Message messages2) {
		getMessages2().remove(messages2);
		messages2.setUserInfo2(null);

		return messages2;
	}

	public List<Notice> getNotices() {
		return this.notices;
	}

	public void setNotices(List<Notice> notices) {
		this.notices = notices;
	}

	public Notice addNotice(Notice notice) {
		getNotices().add(notice);
		notice.setUserInfo(this);

		return notice;
	}

	public Notice removeNotice(Notice notice) {
		getNotices().remove(notice);
		notice.setUserInfo(null);

		return notice;
	}

	public PersonalInfo getPersonalInfo() {
		return this.personalInfo;
	}

	public void setPersonalInfo(PersonalInfo personalInfo) {
		this.personalInfo = personalInfo;
	}

	public List<Question> getQuestions() {
		return this.questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Question addQuestion(Question question) {
		getQuestions().add(question);
		question.setUserInfo(this);

		return question;
	}

	public Question removeQuestion(Question question) {
		getQuestions().remove(question);
		question.setUserInfo(null);

		return question;
	}

	public List<QuestionPJ> getQuestionPjs() {
		return this.questionPjs;
	}

	public void setQuestionPjs(List<QuestionPJ> questionPjs) {
		this.questionPjs = questionPjs;
	}

	public QuestionPJ addQuestionPj(QuestionPJ questionPj) {
		getQuestionPjs().add(questionPj);
		questionPj.setUserInfo(this);

		return questionPj;
	}

	public QuestionPJ removeQuestionPj(QuestionPJ questionPj) {
		getQuestionPjs().remove(questionPj);
		questionPj.setUserInfo(null);

		return questionPj;
	}

	public List<RechargeHi> getRechargeHis() {
		return this.rechargeHis;
	}

	public void setRechargeHis(List<RechargeHi> rechargeHis) {
		this.rechargeHis = rechargeHis;
	}

	public RechargeHi addRechargeHi(RechargeHi rechargeHi) {
		getRechargeHis().add(rechargeHi);
		rechargeHi.setUserInfo(this);

		return rechargeHi;
	}

	public RechargeHi removeRechargeHi(RechargeHi rechargeHi) {
		getRechargeHis().remove(rechargeHi);
		rechargeHi.setUserInfo(null);

		return rechargeHi;
	}

	public List<Suggestion> getSuggestions() {
		return this.suggestions;
	}

	public void setSuggestions(List<Suggestion> suggestions) {
		this.suggestions = suggestions;
	}

	public Suggestion addSuggestion(Suggestion suggestion) {
		getSuggestions().add(suggestion);
		suggestion.setUserInfo(this);

		return suggestion;
	}

	public Suggestion removeSuggestion(Suggestion suggestion) {
		getSuggestions().remove(suggestion);
		suggestion.setUserInfo(null);

		return suggestion;
	}

	public List<Tpjl> getTpjls() {
		return this.tpjls;
	}

	public void setTpjls(List<Tpjl> tpjls) {
		this.tpjls = tpjls;
	}

	public Tpjl addTpjl(Tpjl tpjl) {
		getTpjls().add(tpjl);
		tpjl.setUserInfo(this);

		return tpjl;
	}

	public Tpjl removeTpjl(Tpjl tpjl) {
		getTpjls().remove(tpjl);
		tpjl.setUserInfo(null);

		return tpjl;
	}

	public List<UserAlbum> getUserAlbums() {
		return this.userAlbums;
	}

	public void setUserAlbums(List<UserAlbum> userAlbums) {
		this.userAlbums = userAlbums;
	}

	public UserAlbum addUserAlbum(UserAlbum userAlbum) {
		getUserAlbums().add(userAlbum);
		userAlbum.setUserInfo(this);

		return userAlbum;
	}

	public UserAlbum removeUserAlbum(UserAlbum userAlbum) {
		getUserAlbums().remove(userAlbum);
		userAlbum.setUserInfo(null);

		return userAlbum;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<UserSecurity> getUserSecurities() {
		return this.userSecurities;
	}

	public void setUserSecurities(List<UserSecurity> userSecurities) {
		this.userSecurities = userSecurities;
	}

	public UserSecurity addUserSecurity(UserSecurity userSecurity) {
		getUserSecurities().add(userSecurity);
		userSecurity.setUserInfo(this);

		return userSecurity;
	}

	public UserSecurity removeUserSecurity(UserSecurity userSecurity) {
		getUserSecurities().remove(userSecurity);
		userSecurity.setUserInfo(null);

		return userSecurity;
	}

	public List<UserUpHi> getUserUpHis() {
		return this.userUpHis;
	}

	public void setUserUpHis(List<UserUpHi> userUpHis) {
		this.userUpHis = userUpHis;
	}

	public UserUpHi addUserUpHi(UserUpHi userUpHi) {
		getUserUpHis().add(userUpHi);
		userUpHi.setUserInfo(this);

		return userUpHi;
	}

	public UserUpHi removeUserUpHi(UserUpHi userUpHi) {
		getUserUpHis().remove(userUpHi);
		userUpHi.setUserInfo(null);

		return userUpHi;
	}

	public List<WealthBoard> getWealthBoards() {
		return this.wealthBoards;
	}

	public void setWealthBoards(List<WealthBoard> wealthBoards) {
		this.wealthBoards = wealthBoards;
	}

	public WealthBoard addWealthBoard(WealthBoard wealthBoard) {
		getWealthBoards().add(wealthBoard);
		wealthBoard.setUserInfo(this);

		return wealthBoard;
	}

	public WealthBoard removeWealthBoard(WealthBoard wealthBoard) {
		getWealthBoards().remove(wealthBoard);
		wealthBoard.setUserInfo(null);

		return wealthBoard;
	}

	public List<WealthTradeHi> getWealthTradeHis1() {
		return this.wealthTradeHis1;
	}

	public void setWealthTradeHis1(List<WealthTradeHi> wealthTradeHis1) {
		this.wealthTradeHis1 = wealthTradeHis1;
	}

	public WealthTradeHi addWealthTradeHis1(WealthTradeHi wealthTradeHis1) {
		getWealthTradeHis1().add(wealthTradeHis1);
		wealthTradeHis1.setUserInfo1(this);

		return wealthTradeHis1;
	}

	public WealthTradeHi removeWealthTradeHis1(WealthTradeHi wealthTradeHis1) {
		getWealthTradeHis1().remove(wealthTradeHis1);
		wealthTradeHis1.setUserInfo1(null);

		return wealthTradeHis1;
	}

	public List<WealthTradeHi> getWealthTradeHis2() {
		return this.wealthTradeHis2;
	}

	public void setWealthTradeHis2(List<WealthTradeHi> wealthTradeHis2) {
		this.wealthTradeHis2 = wealthTradeHis2;
	}

	public WealthTradeHi addWealthTradeHis2(WealthTradeHi wealthTradeHis2) {
		getWealthTradeHis2().add(wealthTradeHis2);
		wealthTradeHis2.setUserInfo2(this);

		return wealthTradeHis2;
	}

	public WealthTradeHi removeWealthTradeHis2(WealthTradeHi wealthTradeHis2) {
		getWealthTradeHis2().remove(wealthTradeHis2);
		wealthTradeHis2.setUserInfo2(null);

		return wealthTradeHis2;
	}

	public List<AttachDownload> getAttachDownloads() {
		return this.attachDownloads;
	}

	public void setAttachDownloads(List<AttachDownload> attachDownloads) {
		this.attachDownloads = attachDownloads;
	}

	public AttachDownload addAttachDownload(AttachDownload attachDownload) {
		getAttachDownloads().add(attachDownload);
		attachDownload.setUserInfo(this);

		return attachDownload;
	}

	public AttachDownload removeAttachDownload(AttachDownload attachDownload) {
		getAttachDownloads().remove(attachDownload);
		attachDownload.setUserInfo(null);

		return attachDownload;
	}

	public List<PhotoPJ> getPhotoPjs() {
		return this.photoPjs;
	}

	public void setPhotoPjs(List<PhotoPJ> photoPjs) {
		this.photoPjs = photoPjs;
	}

	public PhotoPJ addPhotoPj(PhotoPJ photoPj) {
		getPhotoPjs().add(photoPj);
		photoPj.setUserInfo(this);

		return photoPj;
	}

	public PhotoPJ removePhotoPj(PhotoPJ photoPj) {
		getPhotoPjs().remove(photoPj);
		photoPj.setUserInfo(null);

		return photoPj;
	}

}