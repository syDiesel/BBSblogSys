package com.bbsBlog.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the BlogLog database table.
 * 
 */
@Entity
@NamedQuery(name="BlogLog.findAll", query="SELECT b FROM BlogLog b")
public class BlogLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Lob
	@Column(name="blog_content")
	private String blogContent;

	@Column(name="blog_time")
	private String blogTime;

	@Column(name="blog_type")
	private String blogType;

	private String down;

	private String keywordA;

	private String keywordB;

	private String keywordC;
	
	private String firstImg;

	/**
	 * @return firstImg
	 */
	public String getFirstImg() {
		return firstImg;
	}

	/**
	 * @param firstImg 要设置的 firstImg
	 */
	public void setFirstImg(String firstImg) {
		this.firstImg = firstImg;
	}

	private String normal;

	@Column(name="process_cause")
	private String processCause;

	@Lob
	@Column(name="process_his")
	private String processHis;

	@Column(name="process_time")
	private String processTime;

	@Column(name="process_user")
	private String processUser;

	@Column(name="SFZZ")
	private String sfzz;

	private String subject;

	private String up;

	private String visited;

	@Column(name="WZCC")
	private String wzcc;

	//bi-directional many-to-one association to BlogHI
	@OneToMany(mappedBy="blogLog",cascade=CascadeType.ALL)
	private List<BlogHI> blogHis;

	//bi-directional many-to-one association to BlogLabel
	@OneToMany(mappedBy="blogLog",cascade=CascadeType.ALL)
	private List<BlogLabel> blogLabels;

	//bi-directional many-to-one association to Blog
	@ManyToOne
	private Blog blog;

	//bi-directional many-to-one association to BlogStatus
	@ManyToOne
	@JoinColumn(name="status_id")
	private BlogStatus blogStatus;

	//bi-directional many-to-one association to Board
	@ManyToOne
	@JoinColumn(name="boa_id")
	private Board board;

	//bi-directional many-to-one association to Favorite
	@OneToMany(mappedBy="blogLog",cascade=CascadeType.ALL)
	private List<Favorite> favorites;

	//bi-directional many-to-one association to UserUpHi
	@OneToMany(mappedBy="blogLog",cascade=CascadeType.ALL)
	private List<UserUpHi> userUpHis;

	public BlogLog() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBlogContent() {
		return this.blogContent;
	}

	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}

	public String getBlogTime() {
		return this.blogTime;
	}

	public void setBlogTime(String blogTime) {
		this.blogTime = blogTime;
	}

	public String getBlogType() {
		return this.blogType;
	}

	public void setBlogType(String blogType) {
		this.blogType = blogType;
	}

	public String getDown() {
		return this.down;
	}

	public void setDown(String down) {
		this.down = down;
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

	public String getNormal() {
		return this.normal;
	}

	public void setNormal(String normal) {
		this.normal = normal;
	}

	public String getProcessCause() {
		return this.processCause;
	}

	public void setProcessCause(String processCause) {
		this.processCause = processCause;
	}

	public String getProcessHis() {
		return this.processHis;
	}

	public void setProcessHis(String processHis) {
		this.processHis = processHis;
	}

	public String getProcessTime() {
		return this.processTime;
	}

	public void setProcessTime(String processTime) {
		this.processTime = processTime;
	}

	public String getProcessUser() {
		return this.processUser;
	}

	public void setProcessUser(String processUser) {
		this.processUser = processUser;
	}

	public String getSfzz() {
		return this.sfzz;
	}

	public void setSfzz(String sfzz) {
		this.sfzz = sfzz;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getUp() {
		return this.up;
	}

	public void setUp(String up) {
		this.up = up;
	}

	public String getVisited() {
		return this.visited;
	}

	public void setVisited(String visited) {
		this.visited = visited;
	}

	public String getWzcc() {
		return this.wzcc;
	}

	public void setWzcc(String wzcc) {
		this.wzcc = wzcc;
	}

	public List<BlogHI> getBlogHis() {
		return this.blogHis;
	}

	public void setBlogHis(List<BlogHI> blogHis) {
		this.blogHis = blogHis;
	}

	public BlogHI addBlogHi(BlogHI blogHi) {
		getBlogHis().add(blogHi);
		blogHi.setBlogLog(this);

		return blogHi;
	}

	public BlogHI removeBlogHi(BlogHI blogHi) {
		getBlogHis().remove(blogHi);
		blogHi.setBlogLog(null);

		return blogHi;
	}

	public List<BlogLabel> getBlogLabels() {
		return this.blogLabels;
	}

	public void setBlogLabels(List<BlogLabel> blogLabels) {
		this.blogLabels = blogLabels;
	}

	public BlogLabel addBlogLabel(BlogLabel blogLabel) {
		getBlogLabels().add(blogLabel);
		blogLabel.setBlogLog(this);

		return blogLabel;
	}

	public BlogLabel removeBlogLabel(BlogLabel blogLabel) {
		getBlogLabels().remove(blogLabel);
		blogLabel.setBlogLog(null);

		return blogLabel;
	}

	public Blog getBlog() {
		return this.blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public BlogStatus getBlogStatus() {
		return this.blogStatus;
	}

	public void setBlogStatus(BlogStatus blogStatus) {
		this.blogStatus = blogStatus;
	}

	public Board getBoard() {
		return this.board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public List<Favorite> getFavorites() {
		return this.favorites;
	}

	public void setFavorites(List<Favorite> favorites) {
		this.favorites = favorites;
	}

	public Favorite addFavorite(Favorite favorite) {
		getFavorites().add(favorite);
		favorite.setBlogLog(this);

		return favorite;
	}

	public Favorite removeFavorite(Favorite favorite) {
		getFavorites().remove(favorite);
		favorite.setBlogLog(null);

		return favorite;
	}

	public List<UserUpHi> getUserUpHis() {
		return this.userUpHis;
	}

	public void setUserUpHis(List<UserUpHi> userUpHis) {
		this.userUpHis = userUpHis;
	}

	public UserUpHi addUserUpHi(UserUpHi userUpHi) {
		getUserUpHis().add(userUpHi);
		userUpHi.setBlogLog(this);

		return userUpHi;
	}

	public UserUpHi removeUserUpHi(UserUpHi userUpHi) {
		getUserUpHis().remove(userUpHi);
		userUpHi.setBlogLog(null);

		return userUpHi;
	}

}