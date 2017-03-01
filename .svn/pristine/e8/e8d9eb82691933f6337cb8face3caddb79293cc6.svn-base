package com.bbsBlog.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bbsBlog.entity.Attachment;
import com.bbsBlog.entity.BlogLog;
import com.bbsBlog.entity.ForumPost;
import com.bbsBlog.entity.Message;
import com.bbsBlog.entity.Question;
import com.bbsBlog.entity.UserInfo;
import com.bbsBlog.service.AttachmentService;
import com.bbsBlog.service.BlogLogService;
import com.bbsBlog.service.Forum_postService;
import com.bbsBlog.service.MessageService;
import com.bbsBlog.service.QuestionService;
import com.bbsBlog.service.UserInfoService;
import com.bbsBlog.util.HtmlSpecialChars;
import com.bbsBlog.util.PageModel;
import com.bbsBlog.util.Pages;
import com.bbsBlog.util.SearchModel;

@Controller
public class SearchController {

	@Resource
	private BlogLogService blogLogService;

	@Resource
	private AttachmentService attachmentService;

	@Resource
	private Forum_postService forumPostService;

	@Resource
	private QuestionService questionService;

	@Resource
	private MessageService messageService;

	@Resource
	private UserInfoService userInfoService;

	public BlogLogService getBlogLogService() {

		return blogLogService;
	}

	public void setBlogLogService(BlogLogService blogLogService) {

		this.blogLogService = blogLogService;

	}

	public AttachmentService getAttachmentService() {

		return attachmentService;
	}

	public void setAttachmentService(AttachmentService attachmentService) {

		this.attachmentService = attachmentService;

	}

	public Forum_postService getForum_postService() {

		return forumPostService;
	}

	public void setForum_postService(Forum_postService forumPostService) {

		this.forumPostService = forumPostService;

	}

	public QuestionService getQuestionService() {

		return questionService;
	}

	public void setQuestionService(QuestionService questionService) {

		this.questionService = questionService;

	}

	@RequestMapping(value = "/q")
	public String a() {

		return "/web/search/search";
	}

	/**
	 * 
	 * @author 曦风
	 * 
	 * @date 2014-9-15
	 * 
	 * @param
	 * @throws IOException
	 */

	@RequestMapping(value = "search.do")
	public String search(HttpServletRequest req, HttpServletResponse res)
			throws IOException {

		String searchMethod = req.getParameter("searchMethod");
		String search = req.getParameter("search");
		// lab、sub、con的值分别表示标签、主题、内容是否选中；1 表示选中，0表示未选中

		String lab = req.getParameter("lab");
		if (lab == null) {
			lab = "1";
		}
		String sub = req.getParameter("sub");
		if (sub == null) {
			sub = "1";
		}
		String con = req.getParameter("con");
		if (con == null) {
			con = "1";
		}

		System.out.println("lab:" + lab + "sub:" + sub + "con:" + con);
		int record = 1;
		req.setAttribute("search", search);

		if (searchMethod.equals("0"))
			return searchAll(req, res, record, search, lab, sub, con);

		if (searchMethod.equals("1"))
			return searchBlog(req, res, record, search, lab, sub, con);

		else if (searchMethod.equals("2"))
			return searchForum(req, res, record, search, lab, sub, con);

		else if (searchMethod.equals("3"))
			return searchQuestion(req, res, record, search, lab, sub, con);

		else
			return searchAttachment(req, res, record, search, lab, sub, con);
	}

	// ----------------------------------------------搜索全部-----------------------------------------------
	/**
	 * 全部搜索方法
	 * 
	 * @author 曦风
	 * 
	 * @date 2014-9-15
	 * 
	 * @param
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "all.do")
	public String searchAll(HttpServletRequest req, HttpServletResponse res,
			int record, String keyword, String lab, String sub, String con) {
		// 私信
		UserInfo loginUser = (UserInfo) req.getSession().getAttribute(
				"userInfo");
		int newMsg = 0;
		if (loginUser != null) {

			String messageSql = "from Message where userInfo1.id = '"
					+ loginUser.getId() + "' and isRead = '0'";
			List<Message> messageList = messageService
					.listMessageBySql(messageSql);
			newMsg = messageList.size();
			// 更新session
			req.getSession().setAttribute("userInfo", loginUser);
		}
		req.setAttribute("newMsgCount", newMsg);

		try {

			List<SearchModel> listAll = new ArrayList<SearchModel>();

			String blogSql1 = null;
			String postSql1 = null;
			String qSql1 = null;

			String blogSql2 = null;
			String postSql2 = null;
			String qSql2 = null;

			String blogSql3 = null;
			String postSql3 = null;
			String qSql3 = null;
			String attSql3 = null;

			String blogSql4 = null;
			String postSql4 = null;
			String qSql4 = null;
			String attSql4 = null;

			String blogSql5 = null;
			String postSql5 = null;
			String qSql5 = null;
			String attSql5 = null;

			if (lab.equals("1")) {
				// 排序第一
				blogSql1 = "from BlogLog where keywordA = '" + keyword
						+ "' and blogStatus = 2";
				postSql1 = "from ForumPost where keywordA = '" + keyword
						+ "' and (postStatus = 4 or postStatus = 5)";
				qSql1 = "from Question where keywordA = '" + keyword + "'";

				// 排序第二
				blogSql2 = "from BlogLog where keywordB = '" + keyword
						+ "' or keywordC = '" + keyword
						+ "' and (keywordA <> '" + keyword + "' "
						+ "or keywordA is null) and blogStatus = 2";
				postSql2 = "from ForumPost where keywordB = '"
						+ keyword
						+ "' or keywordC = '"
						+ keyword
						+ "' and (postStatus = 4 or postStatus = 5) and (keywordA <> '"
						+ keyword + "' " + "or keywordA is null)";
				qSql2 = "from Question where (keywordB = '" + keyword + "' or "
						+ "keywordC = '" + keyword + "') and (keywordA <> '"
						+ keyword + "' " + "or keywordA is null)";

				if (sub.equals("1") && con.equals("1")) {
					// 排序第三
					blogSql3 = "from BlogLog where subject like '%" + keyword
							+ "%' and blogContent like '%" + keyword
							+ "%' and (keywordA <> '" + keyword
							+ "' or keywordA is null) and (keywordB <> '"
							+ keyword
							+ "' or keywordB is null) and (keywordC <> '"
							+ keyword
							+ "' or keywordC is null) and blogStatus = 2";
					postSql3 = "from ForumPost where subject like '%"
							+ keyword
							+ "%' and "
							+ "postContent like '%"
							+ keyword
							+ "%' and (postStatus = 4 or postStatus = 5) and (keywordA <> '"
							+ keyword
							+ "' or keywordA is null) and (keywordB <> '"
							+ keyword
							+ "' or keywordB is null) and (keywordC <> '"
							+ keyword + "' or keywordC is null)";
					qSql3 = "from Question where qSubject like '%" + keyword
							+ "%' and " + "qContent like '%" + keyword
							+ "%' and (keywordA <> '" + keyword
							+ "' or keywordA is null) and (keywordB <> '"
							+ keyword
							+ "' or keywordB is null) and (keywordC <> '"
							+ keyword + "' or keywordC is null)";
					attSql3 = "from Attachment where attachName like '%"
							+ keyword + "%' " + "and attachDesc like '%"
							+ keyword + "%'";

					// 排序第四
					blogSql4 = "from BlogLog where subject like '%" + keyword
							+ "%' " + "and blogContent not like '%" + keyword
							+ "%' and (keywordA <> '" + keyword
							+ "' or keywordA is null) and (keywordB <> '"
							+ keyword
							+ "' or keywordB is null) and (keywordC <> '"
							+ keyword
							+ "' or keywordC is null) and blogStatus = 2";
					postSql4 = "from ForumPost where subject like '%"
							+ keyword
							+ "%' and "
							+ "postContent not like '%"
							+ keyword
							+ "%' and (postStatus = 4 or postStatus = 5) and (keywordA <> '"
							+ keyword
							+ "' or  keywordA is null) and (keywordB <> '"
							+ keyword
							+ "' or keywordB is null) and (keywordC <> '"
							+ keyword + "' or keywordC is null)";
					qSql4 = "from Question where qSubject like '%" + keyword
							+ "%' and " + "qContent not like '%" + keyword
							+ "%' and (keywordA <> '" + keyword
							+ "' or keywordA is null) and (keywordB <> '"
							+ keyword
							+ "' or keywordB is null) and (keywordC <> '"
							+ keyword + "' or keywordC is null)";
					attSql4 = "from Attachment where attachName like '%"
							+ keyword + "%' and attachDesc not like '%"
							+ keyword + "%'";

					// 排序第五
					blogSql5 = "from BlogLog where blogContent like '%"
							+ keyword + "%' " + "and subject not like '%"
							+ keyword + "%' and (keywordA <> '" + keyword
							+ "' or keywordA is null) and (keywordB <> '"
							+ keyword
							+ "' or keywordB is null) and (keywordC <> '"
							+ keyword
							+ "' or keywordC is null) and blogStatus = 2";
					postSql5 = "from ForumPost where subject not like '%"
							+ keyword
							+ "%' and "
							+ "postContent like '%"
							+ keyword
							+ "%' and (postStatus = 4 or postStatus = 5) and (keywordA <> '"
							+ keyword
							+ "' or keywordA is null) and (keywordB <> '"
							+ keyword
							+ "' or keywordB is null) and (keywordC <> '"
							+ keyword + "' or keywordC is null)";
					qSql5 = "from Question where qSubject not like '%"
							+ keyword + "%' and " + "qContent like '%"
							+ keyword + "%' and (keywordA <> '" + keyword
							+ "' or keywordA is null) and (keywordB <> '"
							+ keyword
							+ "' or keywordB is null) and (keywordC <> '"
							+ keyword + "' or keywordC is null)";
					attSql5 = "from Attachment where attachDesc like '%"
							+ keyword + "%' and attachName not like '%"
							+ keyword + "%'";

				} else if (sub.equals("1") && con.equals("0")) {
					System.out.println((sub.equals("1") && con.equals("0")));
					blogSql4 = "from BlogLog where subject like '%" + keyword
							+ "%' and (keywordA <> '" + keyword
							+ "' or keywordA is null) and (keywordB <> '"
							+ keyword
							+ "' or keywordB is null) and (keywordC <> '"
							+ keyword
							+ "' or keywordC is null) and blogStatus = 2";
					postSql4 = "from ForumPost where subject like '%"
							+ keyword
							+ "%' and (postStatus = 4 or postStatus = 5) and (keywordA <> '"
							+ keyword
							+ "' or keywordA is null) and (keywordB <> '"
							+ keyword
							+ "' or keywordB is null) and (keywordC <> '"
							+ keyword + "' or keywordC is null)";
					qSql4 = "from Question where qSubject like '%" + keyword
							+ "%' and (keywordA <> '" + keyword
							+ "' or keywordA is null) and (keywordB <> '"
							+ keyword
							+ "' or keywordB is null) and (keywordC <> '"
							+ keyword + "' or keywordC is null)";
					attSql4 = "from Attachment where attachName like '%"
							+ keyword + "%' " + "and attachDesc like '%"
							+ keyword + "%'";
				} else if (!sub.equals("1") && con.equals("1")) {

					blogSql5 = "from BlogLog where blogContent like '%"
							+ keyword + "%' and (keywordA <> '" + keyword
							+ "' or keywordA is null) and (keywordB <> '"
							+ keyword
							+ "' or keywordB is null) and (keywordC <> '"
							+ keyword
							+ "' or keywordC is null) and blogStatus = 2";
					postSql5 = "from ForumPost where postContent like '%"
							+ keyword
							+ "%' and (postStatus = 4 or postStatus = 5) and (keywordA <> '"
							+ keyword
							+ "' or keywordA is null) and (keywordB <> '"
							+ keyword
							+ "' or keywordB is null) and (keywordC <> '"
							+ keyword + "' or keywordC is null)";
					qSql5 = "from Question where qContent like '%" + keyword
							+ "%' and (keywordA <> '" + keyword
							+ "' or keywordA is null) and (keywordB <> '"
							+ keyword
							+ "' or keywordB is null) and (keywordC <> '"
							+ keyword + "' or keywordC is null)";
					attSql5 = "from Attachment where attachDesc like '%"
							+ keyword + "%'";
				}
			} else {

				if (sub.equals("1") && con.equals("1")) {
					// 排在第一
					blogSql3 = "from BlogLog where subject like '%" + keyword
							+ "%' and blogContent like '%" + keyword
							+ "%' and blogStatus = 2";
					postSql3 = "from ForumPost where subject like '%" + keyword
							+ "%' and " + "postContent like '%" + keyword
							+ "%' and (postStatus = 4 or postStatus = 5)";
					qSql3 = "from Question where qSubject like '%" + keyword
							+ "%' and " + "qContent like '%" + keyword + "%'";
					attSql3 = "from Attachment where attachName like '%"
							+ keyword + "%' " + "and attachDesc like '%"
							+ keyword + "%'";

					// 排在第二
					blogSql4 = "from BlogLog where subject like '%" + keyword
							+ "%' and blogContent not like '%" + keyword
							+ "%' and blogStatus = 2";
					postSql4 = "from ForumPost where subject like '%" + keyword
							+ "%' and " + "postContent not like '%" + keyword
							+ "%' and (postStatus = 4 or postStatus = 5)";
					qSql4 = "from Question where qSubject like '%" + keyword
							+ "%' and " + "qContent not like '%" + keyword
							+ "%'";
					attSql4 = "from Attachment where attachName like '%"
							+ keyword + "%' " + "and attachDesc not like '%"
							+ keyword + "%'";

					// 排在第三
					blogSql5 = "from BlogLog where subject not like '%"
							+ keyword + "%' and blogContent like '%" + keyword
							+ "%' and blogStatus = 2";
					postSql5 = "from ForumPost where subject not like '%"
							+ keyword + "%' and " + "postContent like '%"
							+ keyword
							+ "%' and (postStatus = 4 or postStatus = 5)";
					qSql5 = "from Question where qSubject not like '%"
							+ keyword + "%' and " + "qContent like '%"
							+ keyword + "%'";
					attSql5 = "from Attachment where attachName not like '%"
							+ keyword + "%' " + "and attachDesc like '%"
							+ keyword + "%'";

				} else if (sub.equals("1") && !con.equals("1")) {

					blogSql3 = "from BlogLog where subject like '%" + keyword
							+ "%' and blogStatus = 2";
					postSql3 = "from ForumPost where subject like '%" + keyword
							+ "%' and (postStatus = 4 or postStatus = 5)";
					qSql3 = "from Question where qSubject like '%" + keyword
							+ "%'";
					attSql3 = "from Attachment where attachName like '%"
							+ keyword + "%'";

				} else if (!sub.equals("1") && con.equals("1")) {

					blogSql3 = "from BlogLog where blogContent like '%"
							+ keyword + "%' and blogStatus = 2";
					postSql3 = "from ForumPost where postContent like '%"
							+ keyword
							+ "%' and (postStatus = 4 or postStatus = 5)";
					qSql3 = "from Question where qContent like '%" + keyword
							+ "%'";
					attSql3 = "from Attachment where attachDesc like '%"
							+ keyword + "%'";
				}
			}

			// 添加排序第一
			if (blogSql1 != null) {
				List<BlogLog> listBlog1 = blogLogService
						.listBlogLogBySql(blogSql1);
				List<ForumPost> listPost1 = forumPostService
						.listPostBySql(postSql1);
				List<Question> listQ1 = questionService
						.listQuestionBySql(qSql1);

				if (listBlog1.size() > 0) {
					for (BlogLog log : listBlog1) {
						SearchModel searchModel = new SearchModel();
						searchModel.setTypeId(log.getId());
						searchModel.setSubject(log.getSubject());
						searchModel.setType("BK");
						searchModel.setContent(log.getBlogContent());
						searchModel.setDate(log.getBlogTime());
						searchModel.setNickName(log.getBlog().getUserInfo()
								.getNickName());
						searchModel.setCount(log.getVisited());
						listAll.add(searchModel);
					}
				}
				if (listPost1.size() > 0) {
					for (ForumPost post : listPost1) {
						SearchModel searchModel = new SearchModel();
						searchModel.setTypeId(post.getId());
						searchModel.setSubject(post.getSubject());
						searchModel.setType("LT");
						searchModel.setContent(post.getPostContent());
						searchModel.setDate(post.getPostDate());
						searchModel.setNickName(post.getUserInfo()
								.getNickName());
						searchModel.setCount(post.getReplyCount());
						listAll.add(searchModel);
					}
				}
				if (listQ1.size() > 0) {
					for (Question question : listQ1) {
						SearchModel searchModel = new SearchModel();
						searchModel.setTypeId(question.getId());
						searchModel.setSubject(question.getQSubject());
						searchModel.setType("WD");
						searchModel.setContent(question.getQContent());
						searchModel.setDate(question.getQTime());
						searchModel.setNickName(question.getUserInfo()
								.getNickName());
						listAll.add(searchModel);
					}
				}
			}

			// 排序第二
			if (blogSql2 != null) {
				List<BlogLog> listBlog2 = blogLogService
						.listBlogLogBySql(blogSql2);
				List<ForumPost> listPost2 = forumPostService
						.listPostBySql(postSql2);
				List<Question> listQ2 = questionService
						.listQuestionBySql(qSql2);
				if (listBlog2.size() > 0) {
					for (BlogLog log : listBlog2) {
						SearchModel searchModel = new SearchModel();
						searchModel.setTypeId(log.getId());
						searchModel.setSubject(log.getSubject());
						searchModel.setType("BK");
						searchModel.setContent(log.getBlogContent());
						searchModel.setDate(log.getBlogTime());
						searchModel.setNickName(log.getBlog().getUserInfo()
								.getNickName());
						searchModel.setCount(log.getVisited());
						listAll.add(searchModel);
					}
				}
				if (listPost2.size() > 0) {
					for (ForumPost post : listPost2) {
						SearchModel searchModel = new SearchModel();
						searchModel.setTypeId(post.getId());
						searchModel.setSubject(post.getSubject());
						searchModel.setType("LT");
						searchModel.setContent(post.getPostContent());
						searchModel.setDate(post.getPostDate());
						searchModel.setNickName(post.getUserInfo()
								.getNickName());
						searchModel.setCount(post.getReplyCount());
						listAll.add(searchModel);
					}
				}
				if (listQ2.size() > 0) {
					for (Question question : listQ2) {
						SearchModel searchModel = new SearchModel();
						searchModel.setTypeId(question.getId());
						searchModel.setSubject(question.getQSubject());
						searchModel.setType("WD");
						searchModel.setContent(question.getQContent());
						searchModel.setDate(question.getQTime());
						searchModel.setNickName(question.getUserInfo()
								.getNickName());
						listAll.add(searchModel);
					}
				}
			}

			// 排序第三
			if (blogSql3 != null) {
				List<BlogLog> listBlog3 = blogLogService
						.listBlogLogBySql(blogSql3);
				List<ForumPost> listPost3 = forumPostService
						.listPostBySql(postSql3);
				List<Question> listQ3 = questionService
						.listQuestionBySql(qSql3);
				List<Attachment> listAttach3 = attachmentService
						.listAttachBySql(attSql3);
				if (listBlog3.size() > 0) {
					for (BlogLog log : listBlog3) {
						SearchModel searchModel = new SearchModel();
						searchModel.setTypeId(log.getId());
						searchModel.setSubject(log.getSubject());
						searchModel.setType("BK");
						searchModel.setContent(log.getBlogContent());
						searchModel.setDate(log.getBlogTime());
						searchModel.setNickName(log.getBlog().getUserInfo()
								.getNickName());
						searchModel.setCount(log.getVisited());
						listAll.add(searchModel);
					}
				}
				if (listPost3.size() > 0) {
					for (ForumPost post : listPost3) {
						SearchModel searchModel = new SearchModel();
						searchModel.setTypeId(post.getId());
						searchModel.setSubject(post.getSubject());
						searchModel.setType("LT");
						searchModel.setContent(post.getPostContent());
						searchModel.setDate(post.getPostDate());
						searchModel.setNickName(post.getUserInfo()
								.getNickName());
						searchModel.setCount(post.getReplyCount());
						listAll.add(searchModel);
					}
				}
				if (listQ3.size() > 0) {
					for (Question question : listQ3) {
						SearchModel searchModel = new SearchModel();
						searchModel.setTypeId(question.getId());
						searchModel.setSubject(question.getQSubject());
						searchModel.setType("WD");
						searchModel.setContent(question.getQContent());
						searchModel.setDate(question.getQTime());
						searchModel.setNickName(question.getUserInfo()
								.getNickName());
						listAll.add(searchModel);
					}
				}
				if (listAttach3.size() > 0) {
					for (Attachment attach : listAttach3) {
						SearchModel searchModel = new SearchModel();
						searchModel.setTypeId(attach.getId());
						searchModel.setSubject(attach.getAttachName());
						searchModel.setType("ZY");
						searchModel.setContent(attach.getAttachDesc());
						searchModel.setDate(attach.getAttachTime());
						searchModel.setNickName(attach.getUserInfo()
								.getNickName());
						searchModel.setCount(attach.getAttachDownload());
						listAll.add(searchModel);
					}
				}
			}

			// 排序第四
			if (blogSql4 != null) {
				List<BlogLog> listBlog4 = blogLogService
						.listBlogLogBySql(blogSql4);
				List<ForumPost> listPost4 = forumPostService
						.listPostBySql(postSql4);
				List<Question> listQ4 = questionService
						.listQuestionBySql(qSql4);
				List<Attachment> listAttach4 = attachmentService
						.listAttachBySql(attSql4);
				if (listBlog4.size() > 0) {
					for (BlogLog log : listBlog4) {
						SearchModel searchModel = new SearchModel();
						searchModel.setTypeId(log.getId());
						searchModel.setSubject(log.getSubject());
						searchModel.setType("BK");
						searchModel.setContent(log.getBlogContent());
						searchModel.setDate(log.getBlogTime());
						searchModel.setNickName(log.getBlog().getUserInfo()
								.getNickName());
						searchModel.setCount(log.getVisited());
						listAll.add(searchModel);
					}
				}
				if (listPost4.size() > 0) {
					for (ForumPost post : listPost4) {
						SearchModel searchModel = new SearchModel();
						searchModel.setTypeId(post.getId());
						searchModel.setSubject(post.getSubject());
						searchModel.setType("LT");
						searchModel.setContent(post.getPostContent());
						searchModel.setDate(post.getPostDate());
						searchModel.setNickName(post.getUserInfo()
								.getNickName());
						searchModel.setCount(post.getReplyCount());
						listAll.add(searchModel);
					}
				}
				if (listQ4.size() > 0) {
					for (Question question : listQ4) {
						SearchModel searchModel = new SearchModel();
						searchModel.setTypeId(question.getId());
						searchModel.setSubject(question.getQSubject());
						searchModel.setType("WD");
						searchModel.setContent(question.getQContent());
						searchModel.setDate(question.getQTime());
						searchModel.setNickName(question.getUserInfo()
								.getNickName());
						listAll.add(searchModel);
					}
				}
				if (listAttach4.size() > 0) {
					for (Attachment attach : listAttach4) {
						SearchModel searchModel = new SearchModel();
						searchModel.setTypeId(attach.getId());
						searchModel.setSubject(attach.getAttachName());
						searchModel.setType("ZY");
						searchModel.setContent(attach.getAttachDesc());
						searchModel.setDate(attach.getAttachTime());
						searchModel.setNickName(attach.getUserInfo()
								.getNickName());
						searchModel.setCount(attach.getAttachDownload());
						listAll.add(searchModel);
					}
				}
			}

			// 排序第五
			if (blogSql5 != null) {
				List<BlogLog> listBlog5 = blogLogService
						.listBlogLogBySql(blogSql5);
				List<ForumPost> listPost5 = forumPostService
						.listPostBySql(postSql5);
				List<Question> listQ5 = questionService
						.listQuestionBySql(qSql5);
				List<Attachment> listAttach5 = attachmentService
						.listAttachBySql(attSql5);
				if (listBlog5.size() > 0) {
					for (BlogLog log : listBlog5) {
						SearchModel searchModel = new SearchModel();
						searchModel.setTypeId(log.getId());
						searchModel.setSubject(log.getSubject());
						searchModel.setType("BK");
						searchModel.setContent(log.getBlogContent());
						searchModel.setDate(log.getBlogTime());
						searchModel.setNickName(log.getBlog().getUserInfo()
								.getNickName());
						searchModel.setCount(log.getVisited());
						listAll.add(searchModel);
					}
				}
				if (listPost5.size() > 0) {
					for (ForumPost post : listPost5) {
						SearchModel searchModel = new SearchModel();
						searchModel.setTypeId(post.getId());
						searchModel.setSubject(post.getSubject());
						searchModel.setType("LT");
						searchModel.setContent(post.getPostContent());
						searchModel.setDate(post.getPostDate());
						searchModel.setNickName(post.getUserInfo()
								.getNickName());
						searchModel.setCount(post.getReplyCount());
						listAll.add(searchModel);
					}
				}
				if (listQ5.size() > 0) {
					for (Question question : listQ5) {
						SearchModel searchModel = new SearchModel();
						searchModel.setTypeId(question.getId());
						searchModel.setSubject(question.getQSubject());
						searchModel.setType("WD");
						searchModel.setContent(question.getQContent());
						searchModel.setDate(question.getQTime());
						searchModel.setNickName(question.getUserInfo()
								.getNickName());
						listAll.add(searchModel);
					}
				}
				if (listAttach5.size() > 0) {
					for (Attachment attach : listAttach5) {
						SearchModel searchModel = new SearchModel();
						searchModel.setTypeId(attach.getId());
						searchModel.setSubject(attach.getAttachName());
						searchModel.setType("ZY");
						searchModel.setContent(attach.getAttachDesc());
						searchModel.setDate(attach.getAttachTime());
						searchModel.setNickName(attach.getUserInfo()
								.getNickName());
						searchModel.setCount(attach.getAttachDownload());
						listAll.add(searchModel);
					}
				}
			}

			// 查找是否有该用户
			UserInfo the_user = new UserInfo();
			if (userInfoService.findUserByNickName(keyword).size() > 0) {
				the_user = userInfoService.findUserByNickName(keyword).get(0);
				req.setAttribute("the_user", the_user);
			} else
				req.setAttribute("the_user", "");

			// 开始分页
			int pageRecords = 5; // 每页显示的记录数,这个可以自己设定
			int allRecords = listAll.size(); // 总的记录
			int allPage = (allRecords - 1) / pageRecords + 1; // 总页数

			Pages pages = new Pages();
			listAll = pages.fenYe(listAll, pageRecords, record, allPage,
					allRecords);// 调用Pages的方法，进行分页
			req.setAttribute("record", record);// 当前页
			req.setAttribute("pageRecords", pageRecords);// 每页显示的记录数
			req.setAttribute("allPage", allPage);// 总的页数

			for (SearchModel page : listAll) {
				page.setContent(HtmlSpecialChars.htmlspecialchars2(page
						.getContent()));
			}
			req.setAttribute("listAll", listAll);
			req.setAttribute("keyword", keyword);
			req.setAttribute("value", "0");
			req.setAttribute("searchMethod", "0");
			req.setAttribute("lab", lab);
			req.setAttribute("sub", sub);
			req.setAttribute("con", con);

			return "/web/search/search";
		} catch (Exception e) {

			req.setAttribute("result", "error");
			return "/web/search/search";

		}
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "orderByAllTime.do", method = RequestMethod.GET)
	public String orderByAllTime(HttpServletRequest req,
			HttpServletResponse res, int record, String keyword, String lab,
			String sub, String con) {

		// 私信
		UserInfo loginUser = (UserInfo) req.getSession().getAttribute(
				"userInfo");
		int newMsg = 0;
		if (loginUser != null) {

			String messageSql = "from Message where userInfo1.id = '"
					+ loginUser.getId() + "' and isRead = '0'";
			List<Message> messageList = messageService
					.listMessageBySql(messageSql);
			newMsg = messageList.size();
			// 更新session
			req.getSession().setAttribute("userInfo", loginUser);
		}
		req.setAttribute("newMsgCount", newMsg);

		// 查找是否有该用户
		UserInfo the_user = new UserInfo();
		if (userInfoService.findUserByNickName(keyword).size() > 0) {
			the_user = userInfoService.findUserByNickName(keyword).get(0);
			req.setAttribute("the_user", the_user);
		} else
			req.setAttribute("the_user", "");

		try {
			List<BlogLog> listBlog = blogLogService.listBlogLogByTime(keyword,
					lab, sub, con);
			List<ForumPost> listPost = forumPostService.listPostByTime(keyword,
					lab, sub, con);
			List<Question> listQ = questionService.listQuestionByTime(keyword,
					lab, sub, con);
			List<Attachment> listAttach = attachmentService
					.listAttachmentByTime(keyword, lab, sub, con);

			List<SearchModel> listAll = new ArrayList<SearchModel>();

			if (listBlog.size() > 0) {
				for (BlogLog log : listBlog) {
					SearchModel searchModel = new SearchModel();
					searchModel.setTypeId(log.getId());
					searchModel.setSubject(log.getSubject());
					searchModel.setType("BK");
					searchModel.setContent(log.getBlogContent());
					searchModel.setDate(log.getBlogTime());
					searchModel.setNickName(log.getBlog().getUserInfo()
							.getNickName());
					searchModel.setCount(log.getVisited());
					listAll.add(searchModel);
				}
			}
			if (listPost.size() > 0) {
				for (ForumPost post : listPost) {
					SearchModel searchModel = new SearchModel();
					searchModel.setTypeId(post.getId());
					searchModel.setSubject(post.getSubject());
					searchModel.setType("LT");
					searchModel.setContent(post.getPostContent());
					searchModel.setDate(post.getPostDate());
					searchModel.setNickName(post.getUserInfo().getNickName());
					searchModel.setCount(post.getReplyCount());
					listAll.add(searchModel);
				}
			}
			if (listQ.size() > 0) {
				for (Question question : listQ) {
					SearchModel searchModel = new SearchModel();
					searchModel.setTypeId(question.getId());
					searchModel.setSubject(question.getQSubject());
					searchModel.setType("WD");
					searchModel.setContent(question.getQContent());
					searchModel.setDate(question.getQTime());
					searchModel.setNickName(question.getUserInfo()
							.getNickName());
					listAll.add(searchModel);
				}
			}
			if (listAttach.size() > 0) {
				for (Attachment attach : listAttach) {
					SearchModel searchModel = new SearchModel();
					searchModel.setTypeId(attach.getId());
					searchModel.setSubject(attach.getAttachName());
					searchModel.setType("ZY");
					searchModel.setContent(attach.getAttachDesc());
					searchModel.setDate(attach.getAttachTime());
					searchModel.setNickName(attach.getUserInfo().getNickName());
					searchModel.setCount(attach.getAttachDownload());
					listAll.add(searchModel);
				}
			}

			// 时间排序
			Collections.sort(listAll, new Comparator<SearchModel>() {
				public int compare(SearchModel o1, SearchModel o2) {
					// TODO Auto-generated method stub
					return o2.getDate().compareTo(o1.getDate());
				}

			});
			if (listAll.size() > 0)
				System.out.println("------------------qwe2----------------");
			// 开始分页
			int pageRecords = 5; // 每页显示的记录数,这个可以自己设定
			int allRecords = listAll.size(); // 总的记录
			int allPage = (allRecords - 1) / pageRecords + 1; // 总页数

			Pages pages = new Pages();
			listAll = pages.fenYe(listAll, pageRecords, record, allPage,
					allRecords);// 调用Pages的方法，进行分页
			req.setAttribute("record", record);// 当前页
			req.setAttribute("pageRecords", pageRecords);// 每页显示的记录数
			req.setAttribute("allPage", allPage);// 总的页数

			for (SearchModel page : listAll) {
				page.setContent(HtmlSpecialChars.htmlspecialchars2(page
						.getContent()));
			}
			if (listAll.size() > 0)
				System.out.println("------------------qwe----------------");
			req.setAttribute("listAll", listAll);
			req.setAttribute("keyword", keyword);
			req.setAttribute("value", "1");
			req.setAttribute("searchMethod", "0");
			req.setAttribute("lab", lab);
			req.setAttribute("sub", sub);
			req.setAttribute("con", con);

			return "/web/search/search";
		} catch (Exception e) {

			req.setAttribute("result", "error");
			return "/web/search/search";

		}

	}

	// ----------------------------------------------搜索博客-----------------------------------------------
	/**
	 * 博客搜索方法
	 * 
	 * @author 曦风
	 * 
	 * @date 2014-9-15
	 * 
	 * @param
	 * @throws UnsupportedEncodingException
	 */
	@SuppressWarnings({ "unchecked" })
	@RequestMapping(value = "blog.do")
	public String searchBlog(HttpServletRequest req, HttpServletResponse res,
			int record, String keyword, String lab, String sub, String con)
			throws IOException {
		// 私信
		UserInfo loginUser = (UserInfo) req.getSession().getAttribute(
				"userInfo");
		int newMsg = 0;
		if (loginUser != null) {

			String messageSql = "from Message where userInfo1.id = '"
					+ loginUser.getId() + "' and isRead = '0'";
			List<Message> messageList = messageService
					.listMessageBySql(messageSql);
			newMsg = messageList.size();
			// 更新session
			req.getSession().setAttribute("userInfo", loginUser);
		}
		req.setAttribute("newMsgCount", newMsg);

		try {
			List<BlogLog> listBlogLog = blogLogService.listBlogLogByKey(
					keyword, lab, sub, con);

			// 开始分页
			int pageRecords = 5; // 每页显示的记录数,这个可以自己设定
			int allRecords = listBlogLog.size(); // 总的记录
			int allPage = (allRecords - 1) / pageRecords + 1; // 总页数

			Pages pages = new Pages();
			listBlogLog = pages.fenYe(listBlogLog, pageRecords, record,
					allPage, allRecords);// 调用Pages的方法，进行分页
			req.setAttribute("record", record);// 当前页
			req.setAttribute("pageRecords", pageRecords);// 每页显示的记录数
			req.setAttribute("allPage", allPage);// 总的页数

			for (BlogLog bloglog : listBlogLog) {
				bloglog.setBlogContent(HtmlSpecialChars
						.htmlspecialchars2(bloglog.getBlogContent()));
			}
			req.setAttribute("listBlogLog", listBlogLog);
			req.setAttribute("keyword", keyword);
			req.setAttribute("value", "0");
			req.setAttribute("searchMethod", "1");
			req.setAttribute("lab", lab);
			req.setAttribute("sub", sub);
			req.setAttribute("con", con);

			return "/web/search/searchBlog";
		} catch (Exception e) {

			req.setAttribute("result", "error");
			return "/web/search/searchBlog";

		}
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "orderByBlogTime.do", method = RequestMethod.GET)
	public String orderByBlogTime(HttpServletRequest req,
			HttpServletResponse res, int record, String keyword, String lab,
			String sub, String con) throws IOException {
		// 私信
		UserInfo loginUser = (UserInfo) req.getSession().getAttribute(
				"userInfo");
		int newMsg = 0;
		if (loginUser != null) {

			String messageSql = "from Message where userInfo1.id = '"
					+ loginUser.getId() + "' and isRead = '0'";
			List<Message> messageList = messageService
					.listMessageBySql(messageSql);
			newMsg = messageList.size();
			// 更新session
			req.getSession().setAttribute("userInfo", loginUser);
		}
		req.setAttribute("newMsgCount", newMsg);

		try {
			List<BlogLog> listBlogLog = blogLogService.listBlogLogByTime(
					keyword, lab, sub, con);

			// 开始分页
			int pageRecords = 5; // 每页显示的记录数,这个可以自己设定
			int allRecords = listBlogLog.size(); // 总的记录
			int allPage = (allRecords - 1) / pageRecords + 1; // 总页数

			Pages pages = new Pages();
			listBlogLog = pages.fenYe(listBlogLog, pageRecords, record,
					allPage, allRecords);// 调用Pages的方法，进行分页
			req.setAttribute("record", record);// 当前页
			req.setAttribute("pageRecords", pageRecords);// 每页显示的记录数
			req.setAttribute("allPage", allPage);// 总的页数

			for (BlogLog bloglog : listBlogLog) {
				bloglog.setBlogContent(HtmlSpecialChars
						.htmlspecialchars2(bloglog.getBlogContent()));
			}
			req.setAttribute("listBlogLog", listBlogLog);
			req.setAttribute("keyword", keyword);
			req.setAttribute("value", "1");
			req.setAttribute("searchMethod", "1");
			req.setAttribute("lab", lab);
			req.setAttribute("sub", sub);
			req.setAttribute("con", con);

			return "/web/search/searchBlog";
		} catch (Exception e) {

			req.setAttribute("result", "error");
			return "/web/search/searchBlog";

		}

	}

	// ---------------------------------------------搜索论坛-----------------------------------------------
	/**
	 * 论坛搜索方法
	 * 
	 * @author 曦风
	 * 
	 * @date 2014-9-15
	 * 
	 * @param
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "bbs.do")
	public String searchForum(HttpServletRequest req, HttpServletResponse res,
			int record, String keyword, String lab, String sub, String con) {
		// 私信
		UserInfo loginUser = (UserInfo) req.getSession().getAttribute(
				"userInfo");
		int newMsg = 0;
		if (loginUser != null) {

			String messageSql = "from Message where userInfo1.id = '"
					+ loginUser.getId() + "' and isRead = '0'";
			List<Message> messageList = messageService
					.listMessageBySql(messageSql);
			newMsg = messageList.size();
			// 更新session
			req.getSession().setAttribute("userInfo", loginUser);
		}
		req.setAttribute("newMsgCount", newMsg);

		try {
			List<ForumPost> listForum = forumPostService.listPostByKey(keyword,
					lab, sub, con);

			// 开始分页
			int pageRecords = 5; // 每页显示的记录数,这个可以自己设定
			int allRecords = listForum.size(); // 总的记录
			int allPage = (allRecords - 1) / pageRecords + 1; // 总页数

			Pages pages = new Pages();
			listForum = pages.fenYe(listForum, pageRecords, record, allPage,
					allRecords);// 调用Pages的方法，进行分页
			req.setAttribute("record", record);// 当前页
			req.setAttribute("pageRecords", pageRecords);// 每页显示的记录数
			req.setAttribute("allPage", allPage);// 总的页数

			for (ForumPost post : listForum) {
				post.setPostContent(HtmlSpecialChars.htmlspecialchars2(post
						.getPostContent()));
			}
			req.setAttribute("listForum", listForum);
			req.setAttribute("keyword", keyword);
			req.setAttribute("value", "0");
			req.setAttribute("searchMethod", "2");
			req.setAttribute("lab", lab);
			req.setAttribute("sub", sub);
			req.setAttribute("con", con);

			return "/web/search/searchForum";
		} catch (Exception e) {

			req.setAttribute("result", "error");
			return "/web/search/searchForum";

		}
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "orderByForumTime.do", method = RequestMethod.GET)
	public String orderByForumTime(HttpServletRequest req,
			HttpServletResponse res, int record, String keyword, String lab,
			String sub, String con) {
		// 私信
		UserInfo loginUser = (UserInfo) req.getSession().getAttribute(
				"userInfo");
		int newMsg = 0;
		if (loginUser != null) {

			String messageSql = "from Message where userInfo1.id = '"
					+ loginUser.getId() + "' and isRead = '0'";
			List<Message> messageList = messageService
					.listMessageBySql(messageSql);
			newMsg = messageList.size();
			// 更新session
			req.getSession().setAttribute("userInfo", loginUser);
		}
		req.setAttribute("newMsgCount", newMsg);

		try {
			List<ForumPost> listForum = forumPostService.listPostByTime(
					keyword, lab, sub, con);

			// 开始分页
			int pageRecords = 5; // 每页显示的记录数,这个可以自己设定
			int allRecords = listForum.size(); // 总的记录
			int allPage = (allRecords - 1) / pageRecords + 1; // 总页数

			Pages pages = new Pages();
			listForum = pages.fenYe(listForum, pageRecords, record, allPage,
					allRecords);// 调用Pages的方法，进行分页
			req.setAttribute("record", record);// 当前页
			req.setAttribute("pageRecords", pageRecords);// 每页显示的记录数
			req.setAttribute("allPage", allPage);// 总的页数

			for (ForumPost post : listForum) {
				post.setPostContent(HtmlSpecialChars.htmlspecialchars2(post
						.getPostContent()));
			}
			req.setAttribute("listForum", listForum);
			req.setAttribute("keyword", keyword);
			req.setAttribute("value", "1");
			req.setAttribute("searchMethod", "2");
			req.setAttribute("lab", lab);
			req.setAttribute("sub", sub);
			req.setAttribute("con", con);

			return "/web/search/searchForum";
		} catch (Exception e) {

			req.setAttribute("result", "error");
			return "/web/search/searchForum";

		}

	}

	// --------------------------------------------搜索问答-----------------------------------------------
	/**
	 * 问题搜索方法
	 * 
	 * @author 曦风
	 * 
	 * @date 2014-9-15
	 * 
	 * @param
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "question.do")
	public String searchQuestion(HttpServletRequest req,
			HttpServletResponse res, int record, String keyword, String lab,
			String sub, String con) {
		// 私信
		UserInfo loginUser = (UserInfo) req.getSession().getAttribute(
				"userInfo");
		int newMsg = 0;
		if (loginUser != null) {

			String messageSql = "from Message where userInfo1.id = '"
					+ loginUser.getId() + "' and isRead = '0'";
			List<Message> messageList = messageService
					.listMessageBySql(messageSql);
			newMsg = messageList.size();
			// 更新session
			req.getSession().setAttribute("userInfo", loginUser);
		}
		req.setAttribute("newMsgCount", newMsg);
		try {
			List<Question> listQuestion = questionService.listQuestionByKey(
					keyword, lab, sub, con);

			// 开始分页
			int pageRecords = 5; // 每页显示的记录数,这个可以自己设定
			int allRecords = listQuestion.size(); // 总的记录
			int allPage = (allRecords - 1) / pageRecords + 1; // 总页数

			Pages pages = new Pages();
			listQuestion = pages.fenYe(listQuestion, pageRecords, record,
					allPage, allRecords);// 调用Pages的方法，进行分页
			req.setAttribute("record", record);// 当前页
			req.setAttribute("pageRecords", pageRecords);// 每页显示的记录数
			req.setAttribute("allPage", allPage);// 总的页数

			for (Question question : listQuestion) {
				question.setQContent(HtmlSpecialChars
						.htmlspecialchars2(question.getQContent()));
			}
			req.setAttribute("listQuestion", listQuestion);
			req.setAttribute("keyword", keyword);
			req.setAttribute("value", "0");
			req.setAttribute("searchMethod", "3");
			req.setAttribute("lab", lab);
			req.setAttribute("sub", sub);
			req.setAttribute("con", con);

			return "/web/search/searchQuestion";
		} catch (Exception e) {

			req.setAttribute("result", "error");
			return "/web/search/searchQuestion";

		}
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "orderByQuestionTime.do", method = RequestMethod.GET)
	public String orderByQuestionTime(HttpServletRequest req,
			HttpServletResponse res, int record, String keyword, String lab,
			String sub, String con) {
		// 私信
		UserInfo loginUser = (UserInfo) req.getSession().getAttribute(
				"userInfo");
		int newMsg = 0;
		if (loginUser != null) {

			String messageSql = "from Message where userInfo1.id = '"
					+ loginUser.getId() + "' and isRead = '0'";
			List<Message> messageList = messageService
					.listMessageBySql(messageSql);
			newMsg = messageList.size();
			// 更新session
			req.getSession().setAttribute("userInfo", loginUser);
		}
		req.setAttribute("newMsgCount", newMsg);
		try {
			List<Question> listQuestion = questionService.listQuestionByTime(
					keyword, lab, sub, con);

			// 开始分页
			int pageRecords = 5; // 每页显示的记录数,这个可以自己设定
			int allRecords = listQuestion.size(); // 总的记录
			int allPage = (allRecords - 1) / pageRecords + 1; // 总页数

			Pages pages = new Pages();
			listQuestion = pages.fenYe(listQuestion, pageRecords, record,
					allPage, allRecords);// 调用Pages的方法，进行分页
			req.setAttribute("record", record);// 当前页
			req.setAttribute("pageRecords", pageRecords);// 每页显示的记录数
			req.setAttribute("allPage", allPage);// 总的页数

			for (Question question : listQuestion) {
				question.setQContent(HtmlSpecialChars
						.htmlspecialchars2(question.getQContent()));
			}
			req.setAttribute("listQuestion", listQuestion);
			req.setAttribute("keyword", keyword);
			req.setAttribute("value", "1");
			req.setAttribute("searchMethod", "3");
			req.setAttribute("lab", lab);
			req.setAttribute("sub", sub);
			req.setAttribute("con", con);

			return "/web/search/searchQuestion";
		} catch (Exception e) {

			req.setAttribute("result", "error");
			return "/web/search/searchQuestion";

		}

	}

	// -------------------------------------------搜索资源-----------------------------------------------
	/**
	 * 资源搜索方法
	 * 
	 * @author 曦风
	 * 
	 * @date 2014-9-15
	 * 
	 * @param
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "attachment.do")
	public String searchAttachment(HttpServletRequest req,
			HttpServletResponse res, int record, String keyword, String lab,
			String sub, String con) {
		// 私信
		UserInfo loginUser = (UserInfo) req.getSession().getAttribute(
				"userInfo");
		int newMsg = 0;
		if (loginUser != null) {

			String messageSql = "from Message where userInfo1.id = '"
					+ loginUser.getId() + "' and isRead = '0'";
			List<Message> messageList = messageService
					.listMessageBySql(messageSql);
			newMsg = messageList.size();
			// 更新session
			req.getSession().setAttribute("userInfo", loginUser);
		}
		req.setAttribute("newMsgCount", newMsg);
		try {
			List<Attachment> listAttach = attachmentService
					.listAttachmentByKey(keyword, lab, sub, con);

			// 开始分页
			int pageRecords = 5; // 每页显示的记录数,这个可以自己设定
			int allRecords = listAttach.size(); // 总的记录
			int allPage = (allRecords - 1) / pageRecords + 1; // 总页数

			Pages pages = new Pages();
			listAttach = pages.fenYe(listAttach, pageRecords, record, allPage,
					allRecords);// 调用Pages的方法，进行分页
			req.setAttribute("record", record);// 当前页
			req.setAttribute("pageRecords", pageRecords);// 每页显示的记录数
			req.setAttribute("allPage", allPage);// 总的页数

			for (Attachment attachment : listAttach) {
				attachment.setAttachDesc(HtmlSpecialChars
						.htmlspecialchars2(attachment.getAttachDesc()));
			}
			req.setAttribute("listAttach", listAttach);
			req.setAttribute("keyword", keyword);
			req.setAttribute("value", "0");
			req.setAttribute("searchMethod", "4");
			req.setAttribute("lab", lab);
			req.setAttribute("sub", sub);
			req.setAttribute("con", con);

			return "/web/search/searchAttachment";
		} catch (Exception e) {

			req.setAttribute("result", "error");
			return "/web/search/searchAttachment";

		}
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "orderByAttachTime.do", method = RequestMethod.GET)
	public String orderByAttachTime(HttpServletRequest req,
			HttpServletResponse res, int record, String keyword, String lab,
			String sub, String con) {
		// 私信
		UserInfo loginUser = (UserInfo) req.getSession().getAttribute(
				"userInfo");
		int newMsg = 0;
		if (loginUser != null) {

			String messageSql = "from Message where userInfo1.id = '"
					+ loginUser.getId() + "' and isRead = '0'";
			List<Message> messageList = messageService
					.listMessageBySql(messageSql);
			newMsg = messageList.size();
			// 更新session
			req.getSession().setAttribute("userInfo", loginUser);
		}
		req.setAttribute("newMsgCount", newMsg);
		try {
			List<Attachment> listAttach = attachmentService
					.listAttachmentByTime(keyword, lab, sub, con);

			// 开始分页
			int pageRecords = 5; // 每页显示的记录数,这个可以自己设定
			int allRecords = listAttach.size(); // 总的记录
			int allPage = (allRecords - 1) / pageRecords + 1; // 总页数

			Pages pages = new Pages();
			listAttach = pages.fenYe(listAttach, pageRecords, record, allPage,
					allRecords);// 调用Pages的方法，进行分页
			req.setAttribute("record", record);// 当前页
			req.setAttribute("pageRecords", pageRecords);// 每页显示的记录数
			req.setAttribute("allPage", allPage);// 总的页数

			for (Attachment attachment : listAttach) {
				attachment.setAttachDesc(HtmlSpecialChars
						.htmlspecialchars2(attachment.getAttachDesc()));
			}
			req.setAttribute("listAttach", listAttach);
			req.setAttribute("keyword", keyword);
			req.setAttribute("value", "1");
			req.setAttribute("searchMethod", "4");
			req.setAttribute("lab", lab);
			req.setAttribute("sub", sub);
			req.setAttribute("con", con);

			return "/web/search/searchAttachment";
		} catch (Exception e) {

			req.setAttribute("result", "error");
			return "/web/search/searchAttachment";

		}

	}

}
