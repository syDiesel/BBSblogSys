/**
 * 
 */
package com.bbsBlog.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bbsBlog.entity.Answer;
import com.bbsBlog.entity.AttachDownload;
import com.bbsBlog.entity.Attachment;
import com.bbsBlog.entity.Audit;
import com.bbsBlog.entity.Blog;
import com.bbsBlog.entity.BlogHI;
import com.bbsBlog.entity.BlogLabel;
import com.bbsBlog.entity.BlogLog;
import com.bbsBlog.entity.BlogStatus;
import com.bbsBlog.entity.Board;
import com.bbsBlog.entity.Favorite;
import com.bbsBlog.entity.FilterWord;
import com.bbsBlog.entity.ForumPost;
import com.bbsBlog.entity.Friend;
import com.bbsBlog.entity.Label;
import com.bbsBlog.entity.Message;
import com.bbsBlog.entity.MessageText;
import com.bbsBlog.entity.PersonalInfo;
import com.bbsBlog.entity.Question;
import com.bbsBlog.entity.UserAlbum;
import com.bbsBlog.entity.UserAlbumPhoto;
import com.bbsBlog.entity.UserInfo;
import com.bbsBlog.entity.UserUpHi;
import com.bbsBlog.entity.WealthBoard;
import com.bbsBlog.service.AnswerService;
import com.bbsBlog.service.AttachDownloadService;
import com.bbsBlog.service.AttachmentService;
import com.bbsBlog.service.AuditService;
import com.bbsBlog.service.BlogHiService;
import com.bbsBlog.service.BlogLabelService;
import com.bbsBlog.service.BlogLogService;
import com.bbsBlog.service.BlogService;
import com.bbsBlog.service.BlogStatusService;
import com.bbsBlog.service.BoardService;
import com.bbsBlog.service.CashService;
import com.bbsBlog.service.FavoriteService;
import com.bbsBlog.service.FilterWordService;
import com.bbsBlog.service.Forum_postService;
import com.bbsBlog.service.FriendService;
import com.bbsBlog.service.LabelService;
import com.bbsBlog.service.MessageService;
import com.bbsBlog.service.MessageTextService;
import com.bbsBlog.service.PersonalInfoService;
import com.bbsBlog.service.QuestionService;
import com.bbsBlog.service.UserAlbumPhotoService;
import com.bbsBlog.service.UserAlbumService;
import com.bbsBlog.service.UserInfoService;
import com.bbsBlog.service.UserUpHisService;
import com.bbsBlog.service.WealthBoardService;
import com.bbsBlog.util.HtmlSpecialChars;
import com.bbsBlog.util.LabelSorter;
import com.bbsBlog.util.PageModel;
import com.bbsBlog.util.ScoreLevel;

/**
 * @author Robust
 * 
 * @date 2014年8月14日
 * 
 */
@Controller
@RequestMapping("/web/Blog")
public class BlogController {
	@Resource
	private BlogService blogService;

	@Resource
	private BlogLogService blogLogService;

	@Resource
	private BoardService boardService;

	@Resource
	private LabelService labelService;

	@Resource
	private BlogLabelService blogLabelService;

	@Resource
	private AttachmentService attachmentService;

	@Resource
	private UserUpHisService userUpHisService;

	@Resource
	private UserInfoService userInfoService;

	@Resource
	private AuditService auditService;

	@Resource
	private BlogHiService blogHiService;

	@Resource
	private WealthBoardService wealthBoardService;

	@Resource
	private AttachDownloadService attachDownloadService;

	@Resource
	private FriendService friendService;

	@Resource
	private QuestionService questionService;

	@Resource
	private Forum_postService forum_postService;

	@Resource
	private FavoriteService favoriteService;
	@Resource
	private PersonalInfoService personalService;

	@Resource
	private FilterWordService filterWordService;

	@Resource
	private MessageService messageService;
	
	@Resource
	private MessageTextService messageTextService;

	@Resource
	private UserAlbumService userAlbumService;

	@Resource
	private UserAlbumPhotoService userAlbumPhotoService;

	@Resource
	private BlogStatusService blogStatusService;

	@Resource
	private AnswerService answerService;

	@Resource
	private CashService cashService;

	private final String List_ACTION = "redirect:/web/Blog/list";

	// private final String List_LOG = "redirect:/web/Blog/Log";
	// private final String List_ATTACH = "redirect:/web/Blog/Attach";

	// 博客板块主页
	@RequestMapping(value = "/index.html")
	public String listAllBlog(HttpServletRequest request,
			HttpServletResponse response) {

		// 板块内容
		List<Board> boards = boardService.listBoard();
		request.setAttribute("boards", boards);

		// 取出全部标签
		List<List<Label>> listAllLabel = new ArrayList<List<Label>>();
		for (int i = 0; i < boards.size(); i++) {
			List<Label> listLabel = this.labelService.listLabelByBoard(boards
					.get(i).getId());
			listAllLabel.add(listLabel);
		}
		request.setAttribute("listAllLabel", listAllLabel);

		// 博主动态
		String hqlBlogdt = "from BlogLog where blogStatus.id='2' order by blogTime desc";
		List<BlogLog> blogdt = blogLogService.listBlogLogBySql(hqlBlogdt);
		// 下方排序
		List<BlogLog> blogF2 = blogdt;
		if (blogdt.size() > 15) {
			blogF2 = blogdt.subList(0, 15);
		}
		for (int i = 0; i < blogF2.size(); i++) {
			// 标签
			List<BlogLabel> labelList = blogLabelService
					.listBlogLabelByLog(blogdt.get(i).getId());
			//
			if (labelList.size() > 0) {
				String logLabel = labelList.get(0).getLabel().getLabelName();

				blogF2.get(i).setKeywordA(logLabel);
			}
		}
		request.setAttribute("blogF2", blogF2);

		if (blogdt.size() > 4) {
			blogdt = blogdt.subList(0, 4);
		}
		if (blogdt.size() != 0) {

			for (int i = 0; i < blogdt.size(); i++) {

				// 去掉HTML标签
				String logContent = HtmlSpecialChars.htmlspecialchars2(blogdt
						.get(i).getBlogContent());
				// 缩短字符
				if (logContent.length() > 100) {
					logContent = logContent.substring(0, 80);
				}

				blogdt.get(i).setBlogContent(logContent);

				// 标签
				List<BlogLabel> labelList = blogLabelService
						.listBlogLabelByLog(blogdt.get(i).getId());
				//
				if (labelList.size() > 0) {
					String logLabel = labelList.get(0).getLabel()
							.getLabelName();

					blogdt.get(i).setKeywordA(logLabel);
				}
				if (labelList.size() > 1) {
					String logLabel = labelList.get(1).getLabel()
							.getLabelName();

					blogdt.get(i).setKeywordB(logLabel);
				}
				if (labelList.size() > 2) {
					String logLabel = labelList.get(2).getLabel()
							.getLabelName();

					blogdt.get(i).setKeywordC(logLabel);
				}
			}
		}
		request.setAttribute("blogdt", blogdt);

		// 活跃标签
		String hotlabelSqlCount = "from Label l  order by  l.blogCount desc";
		List<Label> labels = labelService.listLabelBySql(hotlabelSqlCount);

		/*
		 * for (int i = 0; i < labels.size(); i++) { String labelTotalHql =
		 * "select count(*) from BlogLabel where label.id='" +
		 * labels.get(i).getId() + "'"; String forumTotalHql =
		 * "select count(*) from ForumLabel where label.id='" +
		 * labels.get(i).getId() + "'"; String questionTotalHql =
		 * "select count(*) from QuestionLabel where label.id='" +
		 * labels.get(i).getId() + "'";
		 * 
		 * int blogLabelTotal = blogLabelService.listCount(labelTotalHql); int
		 * forumLabelTotal = blogLabelService.listCount(forumTotalHql); int
		 * questionLabelTotal = blogLabelService .listCount(questionTotalHql);
		 * 
		 * int LabelTotal = blogLabelTotal + forumLabelTotal +
		 * questionLabelTotal; labels.get(i).setLabelDesc(LabelTotal + "");
		 * 
		 * // labels.get(i).setLabelDesc(Math.floor(i+Math.random()*10)+"");
		 * 
		 * //
		 * System.out.println(labels.get(i).getLabelName()+"===="+labels.get(i
		 * ).getLabelDesc()); } Collections.sort(labels, new LabelSorter());
		 * 
		 * 
		 * //如果要按照降序排列再加上这一行代码即可 Collections.reverse(list);
		 * 
		 * Collections.reverse(labels);
		 */

		if (labels.size() > 10) {
			labels = labels.subList(0, 10);

		}
		request.setAttribute("hotLabels", labels);

		// 最多热门博主
		String blogMostVisitedSql = "from Blog order by visited+0 desc";
		List<Blog> blogMostVisited = blogService
				.listBlogBySql(blogMostVisitedSql);

		if (blogMostVisited.size() > 6) {

			blogMostVisited = blogMostVisited.subList(0, 7);
		}

		request.setAttribute("blogMostVisited", blogMostVisited);

		// 最多点赞博主
		String blogListSql = "from Blog order by blogUp+0 desc";
		List<Blog> blogMostUp = blogService.listBlogBySql(blogListSql);

		if (blogMostUp.size() > 6) {
			blogMostUp = blogMostUp.subList(0, 7);
		}
		/*
		 * System.out .println("blogMostUp.size()=============4=" +
		 * blogMostUp.size());
		 */
		request.setAttribute("blogMostUp", blogMostUp);
		request.setAttribute("boardName", "allBoard");

		// 私信
		UserInfo loginUser = (UserInfo) request.getSession().getAttribute(
				"userInfo");

		int newMsg = 0;
		if (loginUser != null) {
			loginUser = userInfoService.findById(loginUser.getId());
			String messageSql = "from Message where userInfo1.id = '"
					+ loginUser.getId() + "' and isRead = '0'";
			List<Message> messageList = messageService
					.listMessageBySql(messageSql);
			newMsg = messageList.size();
			// 更新session
			request.getSession().setAttribute("userInfo",
					this.userInfoService.findById(loginUser.getId()));
		}
		request.setAttribute("newMsgCount", newMsg);

		return "Index";
	}

	// 博客板块主页按板块分类
	@RequestMapping(value = "/index/{boardName}.html", method = RequestMethod.GET)
	public String listAllBlogByBoardId(HttpServletRequest request,
			HttpServletResponse response, @PathVariable String boardName) {

		try {
			boardName = URLDecoder.decode(boardName, "UTF-8");

		} catch (UnsupportedEncodingException e1) {

			e1.printStackTrace();
		}

		// 板块内容
		List<Board> boards = boardService.listBoard();
		request.setAttribute("boards", boards);
		// 取出全部标签
		List<List<Label>> listAllLabel = new ArrayList<List<Label>>();
		for (int i = 0; i < boards.size(); i++) {
			List<Label> listLabel = this.labelService.listLabelByBoard(boards
					.get(i).getId());
			listAllLabel.add(listLabel);
		}
		request.setAttribute("listAllLabel", listAllLabel);

		request.setAttribute("boardName", boardName);
		// 博主动态

		// 分页
		int page = 1;

		try {
			page = Integer.parseInt(request.getParameter("page"));
		} catch (Exception e) {

			page = 1;
		}

		/*
		 * String totalHql = "select count(*) from BlogLog";
		 * 
		 * if (boardName.trim() == null || boardName.trim() == "") { totalHql =
		 * "select count(*) from BlogLog"; } else { totalHql =
		 * "select count(*) from BlogLog"; if
		 * (!boardName.trim().equalsIgnoreCase("allboard")) { totalHql =
		 * "select count(*) from BlogLog where board.boardName='" + boardName +
		 * "'"; } }
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * int totalPage = blogLogService.listCount(totalHql);
		 */

		String hqlBlogdt = "from BlogLog where blogStatus.id='2' order by blogTime desc";
		if (boardName.trim() == null || boardName.trim() == "") {
			hqlBlogdt = "from BlogLog order by blogTime desc";
		} else {
			hqlBlogdt = "from BlogLog where blogStatus.id='2' order by blogTime desc";
			if (!boardName.trim().equalsIgnoreCase("allboard")) {
				hqlBlogdt = "from BlogLog where blogStatus.id='2' and board.boardName='"
						+ boardName + "' order by blogTime desc";
			}
		}

		List<BlogLog> blogdtArray = blogLogService.listBlogLogBySql(hqlBlogdt);
		List<BlogLog> blogdt = null;

		int totalPage = blogdtArray.size();

		int pageSize = 8;
		// 最后一页
		int lastPage = 1;
		if (totalPage % pageSize == 0) {
			lastPage = totalPage / pageSize;
		} else
			lastPage = totalPage / pageSize + 1;

		if (page > lastPage) {
			page = lastPage;
		}
		if (page <= 0) {
			page = 1;
		}
		request.setAttribute("lastPage", lastPage);
		request.setAttribute("page", page);

		// 当前页第一个的位置
		int firstSet = (page - 1) * pageSize;

		// 下方排序
		if (blogdtArray.size() > pageSize) {
			if ((firstSet + pageSize) < (totalPage - 1)) {
				blogdt = blogdtArray.subList(firstSet, firstSet + pageSize);
			} else {
				blogdt = blogdtArray.subList(firstSet, totalPage);
			}
		} else {
			blogdt = blogdtArray;
		}

		if (blogdt.size() != 0) {

			for (int i = 0; i < blogdt.size(); i++) {

				// 去掉HTML标签
				String logContent = HtmlSpecialChars.htmlspecialchars2(blogdt
						.get(i).getBlogContent());
				// 缩短字符
				if (logContent.length() > 100) {
					logContent = logContent.substring(0, 80);
				}

				blogdt.get(i).setBlogContent(logContent);

				// 标签
				List<BlogLabel> labelList = blogLabelService
						.listBlogLabelByLog(blogdt.get(i).getId());
				//
				if (labelList.size() > 0) {
					String logLabel = labelList.get(0).getLabel()
							.getLabelName();

					blogdt.get(i).setKeywordA(logLabel);
				}
				if (labelList.size() > 1) {
					String logLabel = labelList.get(1).getLabel()
							.getLabelName();

					blogdt.get(i).setKeywordB(logLabel);
				}
				if (labelList.size() > 2) {
					String logLabel = labelList.get(2).getLabel()
							.getLabelName();

					blogdt.get(i).setKeywordC(logLabel);
				}

			}
		}
		request.setAttribute("blogdt", blogdt);

		/*
		 * // 板块内容 List<Board> boards = boardService.listBoard();
		 * request.setAttribute("boards", boards);
		 * 
		 * List<Board> nowBoardList =
		 * boardService.listBoardByBoardName(boardName);
		 * 
		 * if (nowBoardList.size() == 0) { return "redirect:../index.html"; }
		 * 
		 * Board nowBoard = nowBoardList.get(0); long boardId =
		 * nowBoard.getId(); request.setAttribute("boardName", boardName); //
		 * 博主动态 String hqlBlogdt = "from BlogLog where board.id=" + boardId +
		 * "and blogStatus.id='2' order by blogTime desc"; List<BlogLog> blogdt
		 * = blogLogService.listBlogLogBySql(hqlBlogdt); // 下方排序 List<BlogLog>
		 * blogF2 = blogdt; if (blogdt.size() > 15) { blogF2 = blogdt.subList(0,
		 * 15); } for (int i = 0; i < blogF2.size(); i++) { // 标签
		 * List<BlogLabel> labelList = blogLabelService
		 * .listBlogLabelByLog(blogdt.get(i).getId()); // String logLabel =
		 * labelList.get(0).getLabel().getLabelName();
		 * 
		 * blogF2.get(i).setKeywordA(logLabel); } request.setAttribute("blogF2",
		 * blogF2);
		 * 
		 * if (blogdt.size() > 4) { blogdt = blogdt.subList(0, 4); } if
		 * (blogdt.size() != 0) {
		 * 
		 * for (int i = 0; i < blogdt.size(); i++) {
		 * 
		 * // 去掉HTML标签 String logContent =
		 * HtmlSpecialChars.htmlspecialchars2(blogdt .get(i).getBlogContent());
		 * // 缩短字符 if (logContent.length() > 100) { logContent =
		 * logContent.substring(0, 80); }
		 * 
		 * blogdt.get(i).setBlogContent(logContent);
		 * 
		 * // 标签 List<BlogLabel> labelList = blogLabelService
		 * .listBlogLabelByLog(blogdt.get(i).getId()); // String logLabel =
		 * labelList.get(0).getLabel().getLabelName();
		 * 
		 * blogdt.get(i).setKeywordA(logLabel); } }
		 * request.setAttribute("blogdt", blogdt);
		 */
		/*
		 * // 活跃标签 // String hotlabelSqlCount=""; List<Label> labels =
		 * labelService.listLabelByBoard(boardId);
		 * 
		 * for (int i = 0; i < labels.size(); i++) { String labelTotalHql =
		 * "select count(*) from BlogLabel where label.id='" +
		 * labels.get(i).getId() + "'"; String forumTotalHql =
		 * "select count(*) from ForumLabel where label.id='" +
		 * labels.get(i).getId() + "'"; String questionTotalHql =
		 * "select count(*) from QuestionLabel where label.id='" +
		 * labels.get(i).getId() + "'";
		 * 
		 * int blogLabelTotal = blogLabelService.listCount(labelTotalHql); int
		 * forumLabelTotal = blogLabelService.listCount(forumTotalHql); int
		 * questionLabelTotal = blogLabelService .listCount(questionTotalHql);
		 * 
		 * int LabelTotal = blogLabelTotal + forumLabelTotal +
		 * questionLabelTotal; labels.get(i).setLabelDesc(LabelTotal + "");
		 * 
		 * } Collections.sort(labels, new LabelSorter());
		 * 
		 * 
		 * //如果要按照降序排列再加上这一行代码即可 Collections.reverse(list);
		 * 
		 * Collections.reverse(labels);
		 * 
		 * if (labels.size() > 10) { labels = labels.subList(0, 10);
		 * 
		 * } request.setAttribute("hotLabels", labels);
		 * 
		 * // 最多热门博主 String blogMostVisitedSql =
		 * "from Blog order by visited+0 desc"; List<Blog> blogMostVisited =
		 * blogService .listBlogBySql(blogMostVisitedSql);
		 * 
		 * System.out.println("blogMostUp.size()=============" +
		 * blogMostVisited.size()); if (blogMostVisited.size() > 6) {
		 * blogMostVisited = blogMostVisited.subList(0, 7); }
		 * 
		 * request.setAttribute("blogMostVisited", blogMostVisited);
		 * 
		 * // 最多点赞博主 String blogListSql = "from Blog order by blogUp+0 desc";
		 * List<Blog> blogMostUp = blogService.listBlogBySql(blogListSql);
		 * 
		 * System.out .println("blogMostUp.size()=============" +
		 * blogMostUp.size()); if (blogMostUp.size() > 6) { blogMostUp =
		 * blogMostUp.subList(0, 7); }
		 * 
		 * request.setAttribute("blogMostUp", blogMostUp);
		 */
		// 私信
		UserInfo loginUser = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		int newMsg = 0;
		if (loginUser != null) {

			String messageSql = "from Message where userInfo1.id = '"
					+ loginUser.getId() + "' and isRead = '0'";
			List<Message> messageList = messageService
					.listMessageBySql(messageSql);
			newMsg = messageList.size();
			// 更新session
			request.getSession().setAttribute("userInfo",
					this.userInfoService.findById(loginUser.getId()));
		}
		request.setAttribute("newMsgCount", newMsg);

		return "../IndexMore";
	}

	// 查看更多，不分板块 只按分类区别
	@RequestMapping(value = "/index/more.html", method = RequestMethod.GET)
	public String listMoreLog(HttpServletRequest request, String boardName)
			throws Exception {

		// 板块内容
		List<Board> boards = boardService.listBoard();
		request.setAttribute("boards", boards);
		request.setAttribute("boardName", boardName);
		// 博主动态

		// 分页
		int page = 1;

		try {
			page = Integer.parseInt(request.getParameter("page"));
		} catch (Exception e) {

			page = 1;
		}

		/*
		 * String totalHql = "select count(*) from BlogLog";
		 * 
		 * if (boardName.trim() == null || boardName.trim() == "") { totalHql =
		 * "select count(*) from BlogLog"; } else { totalHql =
		 * "select count(*) from BlogLog"; if
		 * (!boardName.trim().equalsIgnoreCase("allboard")) { totalHql =
		 * "select count(*) from BlogLog where board.boardName='" + boardName +
		 * "'"; } }
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * int totalPage = blogLogService.listCount(totalHql);
		 */

		String hqlBlogdt = "from BlogLog where blogStatus.id='2' order by blogTime desc";
		if (boardName.trim() == null || boardName.trim() == "") {
			hqlBlogdt = "from BlogLog order by blogTime desc";
		} else {
			hqlBlogdt = "from BlogLog where blogStatus.id='2' order by blogTime desc";
			if (!boardName.trim().equalsIgnoreCase("allboard")) {
				hqlBlogdt = "from BlogLog where blogStatus.id='2' and board.boardName='"
						+ boardName + "' order by blogTime desc";
			}
		}

		List<BlogLog> blogdtArray = blogLogService.listBlogLogBySql(hqlBlogdt);
		List<BlogLog> blogdt = null;

		int totalPage = blogdtArray.size();

		int pageSize = 8;
		// 最后一页
		int lastPage = 1;
		if (totalPage % pageSize == 0) {
			lastPage = totalPage / pageSize;
		} else
			lastPage = totalPage / pageSize + 1;

		if (page > lastPage) {
			page = lastPage;
		}
		if (page <= 0) {
			page = 1;
		}
		request.setAttribute("lastPage", lastPage);
		request.setAttribute("page", page);

		// 当前页第一个的位置
		int firstSet = (page - 1) * pageSize;

		// 下方排序
		if (blogdtArray.size() > pageSize) {
			if ((firstSet + pageSize) < (totalPage - 1)) {
				blogdt = blogdtArray.subList(firstSet, firstSet + pageSize);
			} else {
				blogdt = blogdtArray.subList(firstSet, totalPage);
			}
		} else {
			blogdt = blogdtArray;
		}

		if (blogdt.size() != 0) {

			for (int i = 0; i < blogdt.size(); i++) {

				// 去掉HTML标签
				String logContent = HtmlSpecialChars.htmlspecialchars2(blogdt
						.get(i).getBlogContent());
				// 缩短字符
				if (logContent.length() > 100) {
					logContent = logContent.substring(0, 80);
				}

				blogdt.get(i).setBlogContent(logContent);

				// 标签
				List<BlogLabel> labelList = blogLabelService
						.listBlogLabelByLog(blogdt.get(i).getId());
				//
				if (labelList.size() > 0) {
					String logLabel = labelList.get(0).getLabel()
							.getLabelName();

					blogdt.get(i).setKeywordA(logLabel);
				}
				if (labelList.size() > 1) {
					String logLabel = labelList.get(1).getLabel()
							.getLabelName();

					blogdt.get(i).setKeywordB(logLabel);
				}
				if (labelList.size() > 2) {
					String logLabel = labelList.get(2).getLabel()
							.getLabelName();

					blogdt.get(i).setKeywordC(logLabel);
				}
			}
		}
		request.setAttribute("blogdt", blogdt);

		/*
		 * // 活跃标签 // String hotlabelSqlCount=""; List<Label> labels =
		 * labelService.listLabel();
		 * 
		 * for (int i = 0; i < labels.size(); i++) { String labelTotalHql =
		 * "select count(*) from BlogLabel where label.id='" +
		 * labels.get(i).getId() + "'"; String forumTotalHql =
		 * "select count(*) from ForumLabel where label.id='" +
		 * labels.get(i).getId() + "'"; String questionTotalHql =
		 * "select count(*) from QuestionLabel where label.id='" +
		 * labels.get(i).getId() + "'";
		 * 
		 * int blogLabelTotal = blogLabelService.listCount(labelTotalHql); int
		 * forumLabelTotal = blogLabelService.listCount(forumTotalHql); int
		 * questionLabelTotal = blogLabelService .listCount(questionTotalHql);
		 * 
		 * int LabelTotal = blogLabelTotal + forumLabelTotal +
		 * questionLabelTotal; labels.get(i).setLabelDesc(LabelTotal + "");
		 * 
		 * } Collections.sort(labels, new LabelSorter());
		 * 
		 * 
		 * //如果要按照降序排列再加上这一行代码即可 Collections.reverse(list);
		 * 
		 * Collections.reverse(labels);
		 * 
		 * if (labels.size() > 10) { labels = labels.subList(0, 10);
		 * 
		 * } request.setAttribute("hotLabels", labels);
		 * 
		 * // 最多热门博主 String blogMostVisitedSql =
		 * "from Blog order by visited+0 desc"; List<Blog> blogMostVisited =
		 * blogService .listBlogBySql(blogMostVisitedSql);
		 * 
		 * if (blogMostVisited.size() > 6) {
		 * 
		 * blogMostVisited.subList(0, 7); }
		 * 
		 * request.setAttribute("blogMostVisited", blogMostVisited);
		 * 
		 * // 最多点赞博主 String blogListSql = "from Blog order by blogUp+0 desc";
		 * List<Blog> blogMostUp = blogService.listBlogBySql(blogListSql);
		 * 
		 * if (blogMostUp.size() > 6) { blogMostUp.subList(0, 7); }
		 * 
		 * request.setAttribute("blogMostUp", blogMostUp);
		 */
		// 私信
		UserInfo loginUser = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		int newMsg = 0;
		if (loginUser != null) {

			String messageSql = "from Message where userInfo1.id = '"
					+ loginUser.getId() + "' and isRead = '0'";
			List<Message> messageList = messageService
					.listMessageBySql(messageSql);
			newMsg = messageList.size();
			// 更新session
			request.getSession().setAttribute("userInfo",
					this.userInfoService.findById(loginUser.getId()));
		}
		request.setAttribute("newMsgCount", newMsg);

		return "../IndexMore";
	}

	/*
	 * =====================================收藏相关==================================
	 * ===
	 */

	@RequestMapping(value = "/addCollect")
	public @ResponseBody String saveCollect(HttpServletRequest request,
			HttpServletResponse response, String logId, String url) {
		/*
		 * String newURL = url.replace("http://" + request.getServerName() + ":"
		 * + request.getServerPort() + request.getContextPath() + "/", "");
		 */
		UserInfo loginUser = (UserInfo) request.getSession().getAttribute(
				"userInfo");

		// 查看是否登录
		if (loginUser == null) {
			String strBackUrl = "http://" + request.getServerName() // 服务器地址
					+ ":" + request.getServerPort() // 端口号
					+ request.getContextPath() // 项目名称
					+ request.getServletPath() // 请求页面或其他地址
					+ "?" + (request.getQueryString()); // 参数
			request.getSession().setAttribute("strBackUrl", url);
			return "login";
		}
		loginUser = userInfoService.findById(loginUser.getId());
		// 查看是否已收藏
		String listFavoriteForCheckExist = "from Favorite where blogLog.id = '"
				+ logId + "' and userInfo.id = '" + loginUser.getId() + "'";
		List<Favorite> favoriteList = favoriteService
				.listFavoriteBySql(listFavoriteForCheckExist);
		if (favoriteList.size() > 0) {
			System.out.println("favorited");
			return "collected";
		}

		long logIdLong = Long.parseLong(logId);
		BlogLog blogLog = blogLogService.listBlogLogById(logIdLong);
		Favorite favorite = new Favorite();
		favorite.setBlogUrl(url);
		favorite.setUserInfo(loginUser);
		favorite.setTime(getNowTime());
		favorite.setBlogLog(blogLog);

		favoriteService.saveFavorite(favorite);

		return "favorite";
	}

	@RequestMapping(value = "/removeCollect")
	public @ResponseBody String removeCollect(HttpServletRequest request,
			HttpServletResponse response, String logId, String url) {

		String newURL = url.replace("http://" + request.getServerName() + ":"
				+ request.getServerPort() + request.getContextPath() + "/", "");

		UserInfo loginUser = (UserInfo) request.getSession().getAttribute(
				"userInfo");

		// 查看是否登录
		if (loginUser == null) {
			String strBackUrl = "http://" + request.getServerName() // 服务器地址
					+ ":" + request.getServerPort() // 端口号
					+ request.getContextPath() // 项目名称
					+ request.getServletPath(); // 请求页面或其他地址
			/* + "?" + (request.getQueryString()) */// 参数
			request.getSession().setAttribute("strBackUrl", url);
			return "login";
		}
		loginUser = userInfoService.findById(loginUser.getId());
		String listFavoriteForCheckExist = "from Favorite where blogLog.id = '"
				+ logId + "' and userInfo.id = '" + loginUser.getId() + "'";
		List<Favorite> favoriteList = favoriteService
				.listFavoriteBySql(listFavoriteForCheckExist);
		if (favoriteList.size() != 0) {
			Favorite favorite = favoriteList.get(0);
			favoriteService.deleteFavorite(favorite.getId());
			return "success";
		} else {
			return "unCollect";
		}

	}

	@RequestMapping(value = "/collect")
	public String listFavorite(HttpServletRequest request,
			HttpServletResponse response) {
		UserInfo loginUser = (UserInfo) request.getSession().getAttribute(
				"userInfo");

		// 查看是否登录
		if (loginUser == null) {
			String strBackUrl = "http://" + request.getServerName() // 服务器地址
					+ ":" + request.getServerPort() // 端口号
					+ request.getContextPath() // 项目名称
					+ request.getServletPath(); // 请求页面或其他地址
			/* + "?" + (request.getQueryString()) */// 参数
			request.getSession().setAttribute("strBackUrl", strBackUrl);
			return "redirect:../../login.html";
		}
		loginUser = userInfoService.findById(loginUser.getId());
		int offset = 0;
		int pageSize = 15;
		try {
			offset = Integer.parseInt(request.getParameter("pager.offset"));
		} catch (Exception e) {
		}

		PageModel pm = favoriteService.listFavorite(offset, pageSize,
				loginUser.getId());
		request.setAttribute("pm", pm);

		// 私信

		int newMsg = 0;
		if (loginUser != null) {

			String messageSql = "from Message where userInfo1.id = '"
					+ loginUser.getId() + "' and isRead = '0'";
			List<Message> messageList = messageService
					.listMessageBySql(messageSql);
			newMsg = messageList.size();
			// 更新session
			request.getSession().setAttribute("userInfo",
					this.userInfoService.findById(loginUser.getId()));
		}
		request.setAttribute("newMsgCount", newMsg);

		return "favorite";
	}

	// ========================================个人主页=================================
	// 这2个方法基本用不上
	@RequestMapping(value = "/new")
	public String saveBlog(Blog blog) {
		return List_ACTION;
	}

	@RequestMapping(value = "/delete_{id}")
	public String deleteBlog(@PathVariable long id) {
		return List_ACTION;
	}

	// ===================================分割线=========================
	/**
	 * 
	 * @author Robust
	 * 
	 * @date 2014年8月17日
	 * 
	 * @param blog
	 * @return
	 */
	@RequestMapping(value = "/update")
	public String updateBlog(Blog blog) {
		return List_ACTION;
	}

	// nickName用以区别
	@RequestMapping(value = "/{nickName}")
	public String listBlogByUserId(HttpServletRequest request,
			@PathVariable String nickName) {

		UserInfo blogUser = userInfoService.findUserByNickName(nickName).get(0);

		// 判断BLOG是否存在，不存在就新建一个
		List<Blog> blogList = blogService.findBlogByUserInfo(blogUser);
		if (blogList.size() < 1) {
			Blog blogNew = new Blog();

			blogNew.setId(blogUser.getId());
			blogNew.setUserInfo(blogUser);
			blogNew.setBlogUp("0");
			blogNew.setBlogName(blogUser.getNickName() + "Homepage");
			blogNew.setVisited("0");
			blogNew.setBlog_Album("images/home/noHead.jpg");
			blogNew.setBlogDesc(blogUser.getUserName() + "Blog");
			blogService.saveBlog(blogNew);
		}

		// 登录用户
		UserInfo loginUser = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		if (loginUser != null) {
			loginUser = userInfoService.findById(loginUser.getId());
		}
		try {
			nickName = URLDecoder.decode(nickName, "UTF-8");
		} catch (UnsupportedEncodingException e1) {

			e1.printStackTrace();
		}
		try {
			PersonalInfo blogPersonal = personalService.findById(blogUser
					.getId());
			PersonalInfo loginPersonal = personalService.findById(loginUser
					.getId());
			String loginSex = loginPersonal.getSex();
			String blogSex = blogPersonal.getSex();
			// 比较两个人的性别是否一致
			// 1 是一致 0 不是一致
			if (blogSex.equals(loginSex)) {
				request.setAttribute("isSex", 1);
			} else
				request.setAttribute("isSex", 0);
		} catch (Exception e) {
		}
		try {
			// 比较是不是本人
			// 1 是本人 0 不是本人
			if (loginUser.getId() == blogUser.getId()) {
				request.setAttribute("owner", 1);
			} else {
				request.setAttribute("owner", 0);
				String friend = "false";
				if (this.friendService.IsFriend(loginUser.getId(),
						blogUser.getId()).size() > 0)// 已关注
					friend = "yes";
				else
					// 还未关注
					friend = "no";

				request.setAttribute("friend", friend);
			}
		} catch (Exception e) {
		}

		// 判断用户该月份是否还可以进行兑换灵丹 cash_value值用于表示是否可以兑换，0不行，1可以
		String cash_value = "0";
		Calendar now = Calendar.getInstance();
		int day = now.get(Calendar.DAY_OF_MONTH);
		Date date = new Date();
		String cashDate = new SimpleDateFormat("yyyy-MM").format(date);
		String sql_cash = "from Cash where cashDate = '" + cashDate
				+ "' and userInfo.id = '" + blogUser.getId() + "'";

		if ((day > 15) && (day < 18)
				&& cashService.listCashBySql(sql_cash).size() <= 0) {

			cash_value = "1";
		}
		request.setAttribute("cash_value", cash_value);

		// 博客信息
		Blog blog = blogService.findBlogByUserInfo(blogUser).get(0);
		request.setAttribute("blog", blog);
		// 查看博主信息
		request.setAttribute("blogUser", blogUser);

		// 好友动态

		List<Friend> listFriend = friendService
				.listFriendById(blogUser.getId());
		List<Audit> listAudit = new ArrayList<Audit>();
		if (!listFriend.isEmpty()) {
			Friend friend = new Friend();
			Iterator<Friend> it = listFriend.iterator();
			while (it.hasNext()) {
				friend = (Friend) it.next();
				List<Audit> listAudit1 = auditService
						.listAuditByUserInfo(friend.getUserInfo1().getId());
				listAudit.addAll(listAudit1);
				Collections.sort(listAudit, new Comparator<Audit>() {
					@Override
					public int compare(Audit o1, Audit o2) {
						return o2.getAuditTime().compareTo(o1.getAuditTime());

					}

				});

			}
			request.setAttribute("listAudit", listAudit);
		} else
			request.setAttribute("listAudit", "");

		// 个人首页相册（个人相册、资质相册）
		String albumName = "Qualification Proof";
		List<UserAlbum> listZzzm = userAlbumService.listByUserAndAlbumName(
				blogUser.getId(), albumName);
		List<UserAlbum> listAlbum = userAlbumService.listByUserAndNoName(
				blogUser.getId(), albumName);

		List<UserAlbumPhoto> listNor = new ArrayList<UserAlbumPhoto>();
		List<UserAlbumPhoto> listZi = new ArrayList<UserAlbumPhoto>();
		List<UserAlbumPhoto> listZz = new ArrayList<UserAlbumPhoto>();

		if (listAlbum.size() > 0) {
			for (UserAlbum norAlbum : listAlbum) {
				List<UserAlbumPhoto> list = userAlbumPhotoService
						.findByUserAlbumId(norAlbum.getId());
				listNor.addAll(list);
			}
		}

		String album = "0";
		if (listZzzm.size() > 0) {
			UserAlbum zzzm = listZzzm.get(0);
			request.setAttribute("zzzm", zzzm);

			String sql = "from UserAlbumPhoto u where u.userAlbum.id = '"
					+ zzzm.getId()
					+ "' and u.zzzm ='2' order by photoTime desc";
			listZi = userAlbumPhotoService.listBySql(sql);

			String sql2 = "from UserAlbumPhoto u where u.userAlbum.id = '"
					+ zzzm.getId()
					+ "' and (u.zzzm ='2' or u.zzzm = '1') order by photoTime desc";

			listZz = userAlbumPhotoService.listBySql(sql2);

			// 0没有，1通过不可看，2审核中，3可以查看
			if (listZz != null && listZz.size() > 0) {
				if (listZi != null && listZi.size() > 0) {
					if (zzzm.getIslocked().equals("1")) {
						album = "3";
					} else
						album = "1";
				} else {
					album = "2";
				}

			} else
				album = "0";

		}

		request.setAttribute("album", album);
		request.setAttribute("listZi", listZi);
		request.setAttribute("listNor", listNor);

		// lzw修改于2014-11-17
		// 热门标签排序

		String hotlabelSqlCount = "from Label l order by (l.blogCount+l.forumCount+l.questionCount) desc";
		List<Label> labels = labelService.listLabelBySql(hotlabelSqlCount);

		/*
		 * for (int i = 0; i < labels.size(); i++) { String labelTotalHql =
		 * "select count(*) from BlogLabel where label.id='" +
		 * labels.get(i).getId() + "'"; String forumTotalHql =
		 * "select count(*) from ForumLabel where label.id='" +
		 * labels.get(i).getId() + "'"; String questionTotalHql =
		 * "select count(*) from QuestionLabel where label.id='" +
		 * labels.get(i).getId() + "'";
		 * 
		 * int blogLabelTotal = blogLabelService.listCount(labelTotalHql); int
		 * forumLabelTotal = blogLabelService.listCount(forumTotalHql); int
		 * questionLabelTotal = blogLabelService .listCount(questionTotalHql);
		 * 
		 * int LabelTotal = blogLabelTotal + forumLabelTotal +
		 * questionLabelTotal; labels.get(i).setLabelDesc(LabelTotal + "");
		 * 
		 * // labels.get(i).setLabelDesc(Math.floor(i+Math.random()*10)+"");
		 * 
		 * //
		 * System.out.println(labels.get(i).getLabelName()+"===="+labels.get(i
		 * ).getLabelDesc()); } Collections.sort(labels, new LabelSorter());
		 */

		/*
		 * //如果要按照降序排列再加上这一行代码即可 Collections.reverse(list);
		 */
		/* Collections.reverse(labels); */

		if (labels.size() > 10) {
			labels = labels.subList(0, 10);

		}
		request.setAttribute("hotLabels", labels);

		// 博客bytime
		String blogLogByTimeSql = "from BlogLog where blogStatus.id='2' and blog.id='"
				+ blogUser.getId() + "' order by blogTime desc ";
		List<BlogLog> blogLogByTime = blogLogService
				.listBlogLogBySql(blogLogByTimeSql);
		if (blogLogByTime.size() > 8) {
			blogLogByTime = blogLogByTime.subList(0, 8);
		}
		request.setAttribute("blogLogByTime", blogLogByTime);

		// 论坛bytime
		String forumByTimeSql = "from ForumPost where (postStatus.id=4 or postStatus.id=5) and userInfo.id='"
				+ blogUser.getId() + "' order by postDate desc ";
		List<ForumPost> forumByTime = forum_postService
				.listPostBySql(forumByTimeSql);
		if (forumByTime.size() > 8) {
			forumByTime = forumByTime.subList(0, 8);
		}
		request.setAttribute("forumByTime", forumByTime);

		// 问答bytime
		String questionByTimeSql = "from Question where userInfo.id='"
				+ blogUser.getId() + "' order by qTime desc ";
		List<Question> questionByTime = questionService
				.listQuestionBySql(questionByTimeSql);
		if (questionByTime.size() > 8) {
			questionByTime = questionByTime.subList(0, 8);
		}
		request.setAttribute("questionByTime", questionByTime);

		// 资源区
		String attachByTimeSql = "from Attachment where userInfo.id='"
				+ blogUser.getId() + "' order by attachTime desc ";
		List<Attachment> attachByTime = attachmentService
				.listAttachBySql(attachByTimeSql);
		if (attachByTime.size() > 5) {
			attachByTime = attachByTime.subList(0, 5);
		}
		if (attachByTime.size() > 0) {
			for (int i = 0; i < attachByTime.size(); i++) {
				String attachDescNoHtml = HtmlSpecialChars
						.htmlspecialchars2(attachByTime.get(i).getAttachDesc());
				attachByTime.get(i).setAttachDesc(attachDescNoHtml);
			}
		}
		request.setAttribute("attachByTime", attachByTime);

		// 兴趣标签
		String favHql = "from Favorite where userInfo.id = '"
				+ blogUser.getId() + "' order by time desc";
		List<Favorite> fav = favoriteService.listFavoriteBySql(favHql);

		for (int i = 0; i < fav.size(); i++) {
			int favCount = blogLogService
					.listCount("select count(*) from Favorite where blogUrl = '"
							+ fav.get(i).getBlogUrl() + "'");

			fav.get(i).setId(favCount);

		}

		request.setAttribute("fav", fav);

		// 私信

		int newMsg = 0;
		if (loginUser != null) {

			String messageSql = "from Message where userInfo1.id = '"
					+ loginUser.getId() + "' and isRead = '0'";
			List<Message> messageList = messageService
					.listMessageBySql(messageSql);
			newMsg = messageList.size();
			// 更新session
			request.getSession().setAttribute("userInfo",
					this.userInfoService.findById(loginUser.getId()));
		}
		request.setAttribute("newMsgCount", newMsg);

		return "home";
	}

	/**
	 * 查看更多分类
	 * 
	 * @author Robust
	 * 
	 * @date 2014年10月8日
	 * 
	 * @param req
	 * @param res
	 * @param id
	 * @param type
	 * @return
	 */
	@RequestMapping(value = "/chakan", method = RequestMethod.GET)
	public String chakan(HttpServletRequest req, HttpServletResponse res,
			long id, String type) {

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

		Date date = new Date();
		SimpleDateFormat f = new SimpleDateFormat("MMyydd");
		String nowTime = f.format(date);
		if (type.equals("BK")) {
			return "redirect:article/" + nowTime + id + "";
		} else if (type.equals("LT")) {
			System.out.println("--------------------post_id" + id);
			return "redirect:/toTopics?post_id=" + id;
		} else if (type.equals("WD")) {
			return "redirect:/web/QandA/QuestionFind/" + id;
		} else if (type.equals("ZY")) {
			return "redirect:Attach/" + id;
		}

		return null;
	}

	// =====================================blogContent==================================
	// 这里开始是博客文章内容
	/**
	 * 此方法用于携带部分参数进入发表文章页面 遍历所有板块
	 * 
	 * @author Robust
	 * 
	 * @date 2014年8月25日
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/toNewLog")
	public String toNew(HttpServletRequest request) {
		UserInfo loginUser = (UserInfo) request.getSession().getAttribute(
				"userInfo");

		// 查看是否登录 http://localhost:8080/BBSblogSys/
		if (loginUser == null) {
			String strBackUrl = "http://" + request.getServerName() // 服务器地址
					+ ":" + request.getServerPort() // 端口号
					+ request.getContextPath() // 项目名称
					+ request.getServletPath(); // 请求页面或其他地址
			/* + "?" + (request.getQueryString()) */// 参数
			request.getSession().setAttribute("strBackUrl", strBackUrl);
			return "redirect:../../login.html";
		}
		loginUser = userInfoService.findById(loginUser.getId());

		List<Board> boards = boardService.listBoard();

		request.setAttribute("boards", boards);

		// 私信

		int newMsg = 0;
		if (loginUser != null) {

			String messageSql = "from Message where userInfo1.id = '"
					+ loginUser.getId() + "' and isRead = '0'";
			List<Message> messageList = messageService
					.listMessageBySql(messageSql);
			newMsg = messageList.size();
			// 更新session
			request.getSession().setAttribute("userInfo",
					this.userInfoService.findById(loginUser.getId()));
		}
		request.setAttribute("newMsgCount", newMsg);
		return "newBlog";
	}

	/**
	 * 进入ajax根据板块查询标签
	 * 
	 * @author Robust
	 * 
	 * @date 2014年8月20日
	 * 
	 * @param request
	 * @param boardId
	 * @return
	 */

	@RequestMapping(value = "/listLabelByBoard")
	public @ResponseBody String listLabelByBoard(HttpServletRequest request,
			long boardId) {

		if (boardId != -1) {

			List<Label> labelFromDB = this.labelService
					.listLabelByBoard(boardId);

			List<Label> labels = new ArrayList<Label>();

			int labelSize = labelFromDB.size();
			// System.out.println(labelSize);
			for (int i = 0; i < labelSize; i++) {
				Label e = new Label();
				e.setId(labelFromDB.get(i).getId());
				e.setLabelName(labelFromDB.get(i).getLabelName());
				e.setLabelDesc(labelFromDB.get(i).getLabelDesc());
				labels.add(e);
			}

			System.out.println(labels);
			net.sf.json.JSONArray jsonArray = net.sf.json.JSONArray
					.fromObject(labels);
			String jsonLabel = jsonArray.toString();
			System.out.println(jsonArray);
			return jsonLabel;
		} else
			return "null";
	}

	/**
	 * 发表新Blog文章，初始化部分属性
	 * 
	 * @author Robust
	 * 
	 * @date 2014年8月25日
	 * 
	 * @param request
	 * @param blogLog
	 * @param labelId
	 * @return
	 * @throws UnsupportedEncodingException
	 */

	@RequestMapping(value = "/newLog")
	public String saveBlogLog(HttpServletRequest request, BlogLog blogLog,
			String labelId, String hiddenImg)
			throws UnsupportedEncodingException {

		/*
		 * hiddenImg = hiddenImg.replace("http://" + request.getServerName() //
		 * 服务器地址 + ":" + request.getServerPort() // 端口号 +
		 * request.getContextPath(), "");
		 */
		// hiddenImg=
		// " /kindeditor/attached/image/20141113/20141113174801_831.gif"
		blogLog.setFirstImg(hiddenImg);
		// System.out.println("============="+hiddenImg+"+++++++++++++++");

		UserInfo loginUser = (UserInfo) request.getSession().getAttribute(
				"userInfo");

		if (loginUser == null) {
			return "redirect:../../login.html";
		}
		loginUser = userInfoService.findById(loginUser.getId());
		// 草稿箱问题
		// 1=草稿箱 2=发布箱
		BlogStatus bs = blogStatusService.listBlogStatusById(2);

		blogLog.setBlogStatus(bs);

		// HTML特殊字符过滤，以防脚本代码

		if (blogLog.getBlogContent().length() < 500
				|| blogLog.getBlogContent().length() > 15000) {

			request.getSession().setAttribute("errorResult", "Your words do not conform to the standard");
			return "redirect:../ERROR/result";
		}
		if (StringUtils.isBlank(blogLog.getSubject())
				|| blogLog.getSubject().length() > 100) {

			request.setAttribute("result", "Your title do not conform to the standard");
			return "../ERROR/result";
		}

		if (blogLog.getBlogContent() != null || blogLog.getBlogContent() != "") {
			String blogContent = HtmlSpecialChars.htmlspecialchars(blogLog
					.getBlogContent());
			String blogSubject = HtmlSpecialChars.htmlspecialchars(blogLog
					.getSubject());
			List<FilterWord> fw = filterWordService.listFilterWord();

			if (fw.size() > 0) {

				for (int i = 0; i < fw.size(); i++) {
					// System.out.println(fw.get(i).getFind()+"========================================tihuan"+fw.get(i).getReplacement());

					blogContent = blogContent.replace(fw.get(i).getFind(), fw
							.get(i).getReplacement());
					blogSubject = blogSubject.replace(fw.get(i).getFind(), fw
							.get(i).getReplacement());
				}
			}
			blogLog.setSubject(blogSubject);
			blogLog.setBlogContent(blogContent);
		}

		blogLog.setBlogTime(getNowTime());

		// 设置所属Blog

		long userId = loginUser.getId();
		UserInfo blogUser = loginUser;

		Blog blog = blogService.listBlogById(userId);

		blogLog.setBlog(blog);

		// 初始化部分数据
		blogLog.setDown("0");
		blogLog.setUp("0");
		blogLog.setNormal("0");
		blogLog.setVisited("0");

		if (StringUtils.isBlank(blogLog.getWzcc())) {
			blogLog.setWzcc("From the internet");
		}

		// 标签管理

		System.out.println("=============开始标签管理=====================");
		if (labelId != null && labelId != "") {

			String[] labels = labelId.split(",");
			int labelSize = labels.length;

			// keyword的处理

			if (labelSize == 3) {
				blogLog.setKeywordA(this.labelService.listLabelById(
						Integer.parseInt(labels[0])).getLabelName());
				blogLog.setKeywordB(this.labelService.listLabelById(
						Integer.parseInt(labels[1])).getLabelName());
				blogLog.setKeywordC(this.labelService.listLabelById(
						Integer.parseInt(labels[2])).getLabelName());
			} else if (labelSize == 2) {
				blogLog.setKeywordA(this.labelService.listLabelById(
						Integer.parseInt(labels[0])).getLabelName());
				blogLog.setKeywordB(this.labelService.listLabelById(
						Integer.parseInt(labels[1])).getLabelName());
			} else {
				blogLog.setKeywordA(this.labelService.listLabelById(
						Integer.parseInt(labels[0])).getLabelName());
			}
			this.blogLogService.saveBlogLog(blogLog);

			// TODO testing
			List<BlogLabel> blogLabels = blogLabelService
					.listBlogLabelByLog(blogLog.getId());
			// 删除之前的标签
			for (int i = 0; i < blogLabels.size(); i++) {
				System.out.println("delete starting");
				blogLabelService.deleteBlogLabel(blogLabels.get(i).getId());
			}

			BlogLabel blogLabel = new BlogLabel();

			if (labelSize > 3) {
				request.setAttribute("result", "Choose 3 tags at most ");
				return "../ERROR/result";
			}

			for (int i = 0; i < labelSize; i++) {
				long blogLabelId = Long.parseLong(labels[i]);
				// System.out.println( blogLabelId);
				Label LabelInBlogLabel = labelService
						.listLabelById(blogLabelId);
				LabelInBlogLabel
						.setBlogCount(LabelInBlogLabel.getBlogCount() + 1);
				this.labelService.updateLabel(LabelInBlogLabel);
				BlogLog blogInBlogLabel = blogLog;

				blogLabel.setLabel(LabelInBlogLabel);
				blogLabel.setBlogLog(blogInBlogLabel);

				blogLabelService.saveBlogLabel(blogLabel);

			}

		} else {
			request.setAttribute("result", "choose at least 1 tag");
			return "../ERROR/result";
		}

		// 文章发表后积分管理
		// 1000~10000才有资格积分
		// 系统默认长度为500~15000范围

		// 判断字数是否达标
		if (blogLog.getBlogContent().length() > 1000) {
			// 判断帖子是否被评论,如未评论最高分不能超过7分，直到有某一帖被评论，解除7分上限

			System.out.println("Words conform to the standard");
			List<UserUpHi> userUpHis = userUpHisService
					.listUserUpHiByBlog(userId);
			String jinzhuan = blogUser.getJinzhuan();
			double jinzhuanInt = Double.parseDouble(jinzhuan);

			if (jinzhuanInt < 7) {
				// 金砖小于7，可以积累
				System.out.println("score when more than 7" + jinzhuanInt);
				jinzhuanInt++;
				blogUser.setJinzhuan(jinzhuanInt + "");
				blogUser.setUserLevel(ScoreLevel.scoreLevel(jinzhuanInt + ""));
				userInfoService.updateUserInfo(blogUser);

				// 开始板块积分===========================================================
				List<WealthBoard> wealthBoardList = wealthBoardService
						.findByUser(userId, blogLog.getBoard().getId());
				if (wealthBoardList.size() < 1) {
					WealthBoard wealthBoard = new WealthBoard();
					wealthBoard.setBoard(blogLog.getBoard());
					wealthBoard.setUserInfo(loginUser);
					wealthBoard.setWealthQuantity("1");
					wealthBoardService.saveWealthBoard(wealthBoard);
				} else {
					WealthBoard wealthBoard = wealthBoardList.get(0);
					double boardJifen = Double.parseDouble(wealthBoard
							.getWealthQuantity());
					boardJifen++;
					wealthBoard.setWealthQuantity(boardJifen + "");
					wealthBoardService.updateWealthBoard(wealthBoard);
				}

			} else {
				// 金砖大于7,判断是否评价。
				if (userUpHis.size() > 2) {
					System.out.println("score when less than 7");
					// 有至少一篇文章被给予评价
					jinzhuanInt++;
					blogUser.setJinzhuan(jinzhuanInt + "");
					blogUser.setUserLevel(ScoreLevel.scoreLevel(jinzhuanInt
							+ ""));
					userInfoService.updateUserInfo(blogUser);

					// bankuai jifen
					List<WealthBoard> wealthBoardList = wealthBoardService
							.findByUser(userId, blogLog.getBoard().getId());
					if (wealthBoardList.size() < 1) {
						WealthBoard wealthBoard = new WealthBoard();
						wealthBoard.setBoard(blogLog.getBoard());
						wealthBoard.setUserInfo(loginUser);
						wealthBoard.setWealthQuantity("1");
						wealthBoardService.saveWealthBoard(wealthBoard);
					} else {
						WealthBoard wealthBoard = wealthBoardList.get(0);
						double boardJifen = Double.parseDouble(wealthBoard
								.getWealthQuantity());
						boardJifen++;
						wealthBoard.setWealthQuantity(boardJifen + "");
						wealthBoardService.updateWealthBoard(wealthBoard);
					}
				} else
					System.out.println("exceeding 7 & no review");

			}

		}

		// 将发帖动作记录到好友动态表
		Audit blogAudit = new Audit();
		blogAudit.setAuditTime(getNowTime());
		blogAudit.setUserInfo(blogUser);
		// 动态内容,其实就是标题
		blogAudit.setAuditContent(blogLog.getSubject());
		// 动态Id,博客/论坛/问答/资源/等等表中的id
		blogAudit.setAuditId(blogLog.getId() + "");
		// 动态类型（论坛/博客/问答/资源/等等系列），这里什么都存
		blogAudit.setAuditType("BK");

		auditService.saveAduit(blogAudit);

		/*
		 * return "redirect:/web/Blog/" +
		 * URLEncoder.encode(blogUser.getNickName(), "UTF-8") + "/Log";
		 */

		Date date = new Date();
		SimpleDateFormat f = new SimpleDateFormat("yyMMdd");
		String nowTime = f.format(date);

		return "redirect:/web/Blog/article/" + nowTime + blogLog.getId();

	}

	@RequestMapping(value = "/deleteLog_{id}")
	public String deleteBlogLog(HttpServletRequest request,
			@PathVariable long id) throws UnsupportedEncodingException {
		UserInfo loginUser = (UserInfo) request.getSession().getAttribute(
				"userInfo");

		if (loginUser == null) {
			return "redirect:../../login.html";
		}
		loginUser = userInfoService.findById(loginUser.getId());
		String status = "log";
		try {
			status = (String) request.getParameter("status");
		} catch (Exception e) {

		}

		// 设置所属Blog
		UserInfo blogUser = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		this.blogLogService.deleteBlogLog(id);

		if (status == null) {
			return "redirect:/web/Blog/"
					+ URLEncoder.encode(blogUser.getNickName(), "UTF-8");
		}

		if (status.equalsIgnoreCase("draft")) {
			return "redirect:Draft.html";

		} else
			return "redirect:/web/Blog/"
					+ URLEncoder.encode(blogUser.getNickName(), "UTF-8");
	}

	/**
	 * 这个格式只是URL栏看起来舒服点
	 * 
	 * @author Robust
	 * 
	 * @date 2014年8月14日
	 * 
	 * @param id
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/article/{id}")
	public String listLogById(HttpServletRequest request,
			@PathVariable String id) {

		long realId = Long.parseLong(id.substring(6));

		BlogLog log = this.blogLogService.listBlogLogById(realId);

		if (log == null) {
			request.setAttribute("result", "Not exist or has been removed！");
			return "../../ERROR/result";
		}

		List<BlogLabel> blogLabels = blogLabelService
				.listBlogLabelByLog(realId);

		// 判断是否评价过，如评价过，不给评价界面
		List<UserUpHi> userUpHis = userUpHisService.listUserUpHiByUserAndBlog(
				realId, log.getId());
		// 如果评价过，不做操作直接返回
		if (userUpHis.size() > 0) {
			request.setAttribute("isMarks", "1");
		}
		request.setAttribute("isMarks", "0");

		Blog blog = log.getBlog();

		// 更新博客访问记录
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyMMdd");
		String blogHiTime = sf.format(date);
		UserInfo loginUser = (UserInfo) request.getSession().getAttribute(
				"userInfo");

		if (loginUser != null) {

			loginUser = userInfoService.findById(loginUser.getId());

			List<BlogHI> blogHis = blogHiService.listBlogHiByUserAndBlog(
					loginUser.getId(), realId, blogHiTime);
			if ((blogHis.size() < 1)
					&& (log.getBlog().getId() != loginUser.getId())) {
				// 保存浏览记录
				BlogHI blogHi = new BlogHI();
				blogHi.setBlogLog(log);
				blogHi.setUserInfo(loginUser);
				blogHi.setTime(blogHiTime);

				blogHiService.saveBlogHi(blogHi);
				// 更新blog访问量
				String visit = blog.getVisited();
				int visitInt = Integer.parseInt(visit);
				visitInt++;
				blog.setVisited(visitInt + "");
				blogService.updateBlog(blog);
				// 更新log访问量
				String logVisit = log.getVisited();
				int logVisitInt = Integer.parseInt(logVisit);
				logVisitInt++;
				log.setVisited(logVisitInt + "");
				blogLogService.updateBlogLog(log);
			}

			// 判断是否有关注博主
			String friend = "no";
			List<Friend> listFriend = this.friendService.IsFriend(
					loginUser.getId(), log.getBlog().getId());
			if (listFriend.size() > 0) {
				friend = "yes";
			}
			request.setAttribute("friend", friend);

		}
		request.setAttribute("blogLabels", blogLabels);
		request.setAttribute("log", log);

		// 博主
		request.setAttribute("blogUser", log.getBlog().getUserInfo());

		try {
			// 1 是本人 0 不是本人
			if (loginUser.getId() == log.getBlog().getId()) {
				request.setAttribute("owner", 1);
			} else
				request.setAttribute("owner", 0);
		} catch (Exception e) {
		}

		try {
			// 查看是否已收藏
			String listFavoriteForCheckExist = "from Favorite where blogLog.id = '"
					+ realId
					+ "' and userInfo.id = '"
					+ loginUser.getId()
					+ "'";
			List<Favorite> favoriteList = favoriteService
					.listFavoriteBySql(listFavoriteForCheckExist);
			// 1 是collect 0 collected
			if (favoriteList.size() > 0) {
				request.setAttribute("isCollect", 1);
			} else
				request.setAttribute("isCollect", 0);
		} catch (Exception e) {
		}

		// 博主的资质认证区
		UserInfo blogUser = log.getBlog().getUserInfo();

		// 个人首页相册（个人相册、资质相册）
		String albumName = "Qualification Proof";
		List<UserAlbum> listZzzm = userAlbumService.listByUserAndAlbumName(
				blogUser.getId(), albumName);

		List<UserAlbumPhoto> listZi = new ArrayList<UserAlbumPhoto>();
		List<UserAlbumPhoto> listZz = new ArrayList<UserAlbumPhoto>();

		String album = "0";
		if (listZzzm.size() > 0) {
			UserAlbum zzzm = listZzzm.get(0);
			request.setAttribute("zzzm", zzzm);
			String sql = "from UserAlbumPhoto u where u.userAlbum.id = '"
					+ zzzm.getId()
					+ "' and u.zzzm = '2' order by photoTime desc";
			listZi = userAlbumPhotoService.listBySql(sql);

			String sql2 = "from UserAlbumPhoto u where u.userAlbum.id = '"
					+ zzzm.getId()
					+ "' and (u.zzzm ='2' or u.zzzm = '1') order by photoTime desc";

			listZz = userAlbumPhotoService.listBySql(sql2);

			// 0没有，1通过不可看，2审核中，3可以查看
			if (listZz != null && listZz.size() > 0) {
				if (listZi != null && listZi.size() > 0) {
					if (zzzm.getIslocked().equals("1")) {
						album = "3";
					} else
						album = "1";
				} else {
					album = "2";
				}

			} else
				album = "0";

		}

		request.setAttribute("album", album);
		request.setAttribute("listZi", listZi);

		// 他的资源区
		String blogArticleAttach = "from Attachment where userInfo.id="
				+ log.getBlog().getId() + "order by attachTime desc";
		List<Attachment> attachment = attachmentService
				.listAttachBySql(blogArticleAttach);
		if (attachment.size() > 5) {
			attachment = attachment.subList(0, 5);
		}
		request.setAttribute("attachment", attachment);

		// 他的提问

		String blogArticleQuestion = "from Question where userInfo.id="
				+ log.getBlog().getId() + "order by qTime desc";
		List<Question> question = questionService
				.listQuestionBySql(blogArticleQuestion);
		if (question.size() > 5) {
			question = question.subList(0, 5);
		}
		request.setAttribute("question", question);

		// 他的提问
		String blogArticleAnswer = "from Answer where userInfo.id="
				+ log.getBlog().getId() + "order by aTime desc";
		List<Answer> answer = answerService.listAnswerBySql(blogArticleAnswer);
		if (answer.size() > 5) {
			answer = answer.subList(0, 5);
		}
		request.setAttribute("answer", answer);

		// 活跃标签
		List<BlogLabel> activeLabel = blogLabelService
				.listBlogLabelByLog(realId);

		request.setAttribute("activeLabels", activeLabel);

		// 原创和转载
		String ycCountHql = "select count(*) from BlogLog where blog.id='"
				+ blog.getId() + "' and blogType= '1' ";
		String zzCountHql = "select count(*) from BlogLog where blog.id='"
				+ blog.getId() + "' and blogType= '2' ";
		int ycCount = blogLogService.listCount(ycCountHql);
		int zzCount = blogLogService.listCount(zzCountHql);
		request.setAttribute("ycCount", ycCount);
		request.setAttribute("zzCount", zzCount);

		// 私信

		int newMsg = 0;
		if (loginUser != null) {

			String messageSql = "from Message where userInfo1.id = '"
					+ loginUser.getId() + "' and isRead = '0'";
			List<Message> messageList = messageService
					.listMessageBySql(messageSql);
			newMsg = messageList.size();
			// 更新session
			request.getSession().setAttribute("userInfo",
					this.userInfoService.findById(loginUser.getId()));
		}
		request.setAttribute("newMsgCount", newMsg);

		return "../article";

	}

	/**
	 * 对博客文章进行评价
	 * 
	 * @author Robust
	 * 
	 * @date 2014年8月28日
	 * 
	 * @param request
	 * @param id
	 * @param marks
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/article/Marks")
	public @ResponseBody String saveMarksToBlog(HttpServletRequest request,
			HttpServletResponse resp, String id, String marks, String url)
			throws IOException {
		// ajax

		// 拿到真实ID
		String strBackUrl = url;

		request.getSession().setAttribute("strBackUrl", strBackUrl);
		// System.out.println("strBackUrl========================="+strBackUrl);
		// System.out.println("id========================="+idString);
		long realId = Long.parseLong(id);

		// System.out.println("realid========================="+realId);
		BlogLog log = this.blogLogService.listBlogLogById(realId);

		// 刷新blog点赞总数

		Blog blog = log.getBlog();
		String blogUp = blog.getBlogUp();
		int blogUpInt = Integer.parseInt(blogUp);
		blogUpInt++;
		blog.setBlogUp(blogUpInt + "");
		blogService.updateBlog(blog);

		// 判断是否用户是否已经评价过
		// loginUser 登录用户（操作人）
		UserInfo loginUser = (UserInfo) request.getSession().getAttribute(
				"userInfo");

		if (loginUser == null) {
			//
			return "login";
		} else {

			loginUser = userInfoService.findById(loginUser.getId());
			// System.out.println("loginUser != null");
			List<UserUpHi> userUpHis = userUpHisService
					.listUserUpHiByUserAndBlog(loginUser.getId(), realId);
			// 如果评价过，不做操作直接返回
			// System.out.println("userUpHis.size()========================="+userUpHis.size());
			if (userUpHis.size() > 0) {

				//
				// out.write("userUpHis.size() > 0");
				return "error";
			} else {

				// System.out.println("marks========================="+marks);
				int marksInt = Integer.parseInt(marks);
				switch (marksInt) {
				case 1:
					String up = log.getUp();
					int upInt = Integer.parseInt(up);
					upInt++;
					// System.out.println("switch1========================="+upInt);
					log.setUp(upInt + "");

					// 好评才有积分
					// bankuai jifen
					//
					List<WealthBoard> wealthBoardList = wealthBoardService
							.findByUser(blog.getId(), log.getBoard().getId());

					UserInfo blogUser = userInfoService.findById(log.getBlog()
							.getId());

					/*
					 * System.out.println(log.getBlogType().equalsIgnoreCase("1")
					 * + "===" + log.getBlogType().equalsIgnoreCase("2") +
					 * "====" + log.getBlogType());
					 */
					// 原创得分
					if (log.getBlogType().equalsIgnoreCase("1")) {

						if (wealthBoardList.size() < 1) {
							WealthBoard wealthBoard = new WealthBoard();
							wealthBoard.setBoard(log.getBoard());
							wealthBoard.setUserInfo(loginUser);
							wealthBoard.setWealthQuantity("1");
							wealthBoardService.saveWealthBoard(wealthBoard);
						} else {

							WealthBoard wealthBoard = wealthBoardList.get(0);
							double boardJifen = Double.parseDouble(wealthBoard
									.getWealthQuantity());
							boardJifen = boardJifen
									+ Double.parseDouble(loginUser
											.getUserLevel());
							boardJifen = get1Double(boardJifen);
							wealthBoard.setWealthQuantity(boardJifen + "");
							wealthBoardService.updateWealthBoard(wealthBoard);

						}
						// 评价后博主得到level对应的金砖
						// blogUser 博主

						String jinzhuan = blogUser.getJinzhuan();
						double jinzhuanInt = Double.parseDouble(jinzhuan);
						jinzhuanInt = jinzhuanInt
								+ Double.parseDouble(loginUser.getUserLevel());
						jinzhuanInt = get1Double(jinzhuanInt);
						blogUser.setJinzhuan(jinzhuanInt + "");
						blogUser.setUserLevel(ScoreLevel.scoreLevel(jinzhuanInt
								+ ""));

					} else if (log.getBlogType().equalsIgnoreCase("2")) {
						if (wealthBoardList.size() < 1) {
							WealthBoard wealthBoard = new WealthBoard();
							wealthBoard.setBoard(log.getBoard());
							wealthBoard.setUserInfo(loginUser);
							wealthBoard.setWealthQuantity("0.1");
							wealthBoardService.saveWealthBoard(wealthBoard);
						} else {

							WealthBoard wealthBoard = wealthBoardList.get(0);
							double boardJifen = Double.parseDouble(wealthBoard
									.getWealthQuantity());
							boardJifen = boardJifen
									+ get2Double((Double.parseDouble(loginUser
											.getUserLevel())) / 10);
							boardJifen = get1Double(boardJifen);
							wealthBoard.setWealthQuantity(boardJifen + "");
							wealthBoardService.updateWealthBoard(wealthBoard);

						}
						// 评价后博主得到level对应的金砖
						// blogUser 博主
						//
						String jinzhuan = blogUser.getJinzhuan();
						double jinzhuanInt = Double.parseDouble(jinzhuan);
						jinzhuanInt = jinzhuanInt
								+ get2Double((Double.parseDouble(loginUser
										.getUserLevel())) / 10);
						jinzhuanInt = get1Double(jinzhuanInt);
						blogUser.setJinzhuan(jinzhuanInt + "");
						blogUser.setUserLevel(ScoreLevel.scoreLevel(jinzhuanInt
								+ ""));

					}

					// 保存得分
					userInfoService.updateUserInfo(blogUser);

					break;
				case 2:
					String normal = log.getNormal();
					int normalInt = Integer.parseInt(normal);
					normalInt++;
					// System.out.println("switch2========================="+normalInt);
					log.setNormal(normalInt + "");

					break;
				case 3:
					String down = log.getDown();
					int downInt = Integer.parseInt(down);
					downInt++;
					// System.out.println("switch3========================="+downInt);
					log.setDown(downInt + "");

					break;
				}
				blogLogService.updateBlogLog(log);

				// 没有评价过，执行评价，并保存到（用户&博文）表中，记录评价记录
				// 保存评价记录到评价记录表格
				UserUpHi userUp = new UserUpHi();
				userUp.setBlogLog(log);
				userUp.setUserInfo(loginUser);
				userUp.setTime(getNowTime());

				userUpHisService.saveUserUpHis(userUp);

				String marksCount = null;
				switch (marksInt) {
				case 1:
					String up = log.getUp();

					marksCount = up;
					break;
				case 2:
					String normal = log.getNormal();

					marksCount = normal;
					break;
				case 3:
					String down = log.getDown();

					marksCount = down;

					break;

				}

				return marksCount;
			}

		}
		// 返回
		/*
		 * String article = "redirect:" + id;
		 * 
		 * return article;
		 */

	}

	// 这里修改类型，用于判断是否为稿件;
	@RequestMapping(value = "/logToDraft")
	public String saveDraft(HttpServletRequest request, BlogLog blogLog,
			String labelId) {

		UserInfo loginUser = (UserInfo) request.getSession().getAttribute(
				"userInfo");

		// 查看是否登录 http://localhost:8080/BBSblogSys/
		if (loginUser == null) {
			String strBackUrl = "http://" + request.getServerName() // 服务器地址
					+ ":" + request.getServerPort() // 端口号
					+ request.getContextPath() // 项目名称
					+ request.getServletPath(); // 请求页面或其他地址
			/* + "?" + (request.getQueryString()) */// 参数
			request.getSession().setAttribute("strBackUrl", strBackUrl);
			return "redirect:../../login.html";
		}
		loginUser = userInfoService.findById(loginUser.getId());
		if (blogLog.getBoard().getId() == -1) {
			System.out.println("Union unselected, default is empty");
			blogLog.setBoard(null);
		}
		if (blogLog.getSubject().equalsIgnoreCase("")
				|| blogLog.getSubject() == null || blogLog.getSubject() == "") {
			blogLog.setSubject("Unnamed blog_" + getNowTime());
		}

		Blog blog = blogService.listBlogById(loginUser.getId());
		blogLog.setBlog(blog);

		BlogStatus bs = blogStatusService.listBlogStatusById(1);
		blogLog.setBlogStatus(bs);
		blogLogService.saveBlogLog(blogLog);
		// 标签管理
		if (labelId != null && labelId != "") {

			// this.blogLogService.saveBlogLog(blogLog);

			String[] labels = labelId.split(",");
			int labelSize = labels.length;
			BlogLabel blogLabel = new BlogLabel();

			if (labelSize > 3) {
				request.setAttribute("result", "Choose 3 tags at most ");
				return "../ERROR/result";
			}

			for (int i = 0; i < labelSize; i++) {
				long blogLabelId = Long.parseLong(labels[i]);
				// System.out.println( blogLabelId);
				Label LabelInBlogLabel = labelService
						.listLabelById(blogLabelId);
				BlogLog blogInBlogLabel = blogLog;

				blogLabel.setLabel(LabelInBlogLabel);
				blogLabel.setBlogLog(blogInBlogLabel);

				blogLabelService.saveBlogLabel(blogLabel);

			}

		}/*
		 * else { request.setAttribute("result", "choose at least 1 tag"); return
		 * "../ERROR/result"; }
		 */

		// 0=直接保存草稿箱，1=保存草稿箱后跳转到申请添加标签
		String toStatus = "0";

		try {
			toStatus = request.getParameter("toStatus");
		} catch (Exception e) {
		}

		if (toStatus.trim().equalsIgnoreCase("1")) {
			List<Board> listBoard = this.boardService.listBoard();
			request.setAttribute("listBoard", listBoard);

			return "redirect:../../addLabelApply";
		}

		return "redirect:Draft.html";// 返回到草稿箱

	}

	// 修改帖子，不过暂时未使用
	/*
	 * @RequestMapping(value = "/modifyLog{id}") public String
	 * modifyBlog(HttpServletRequest request, @PathVariable String id) {
	 * 
	 * long realId = Long.parseLong(id.substring(6));
	 * 
	 * BlogLog log = this.blogLogService.listBlogLogById(realId);
	 * List<BlogLabel> blogLabels = blogLabelService
	 * .listBlogLabelByLog(realId); List<Board> boards =
	 * boardService.listBoard();
	 * 
	 * request.setAttribute("boards", boards);
	 * request.setAttribute("blogLabels", blogLabels);
	 * request.setAttribute("log", log); request.setAttribute("blogUser",
	 * log.getBlog().getUserInfo()); request.setAttribute("fakeId", id);
	 * 
	 * return "modifyBlog"; }
	 */

	// 查看草稿箱
	@RequestMapping(value = "/Draft.html")
	public String listDraft(HttpServletRequest request) {

		UserInfo loginUser = (UserInfo) request.getSession().getAttribute(
				"userInfo");

		// 查看是否登录 http://localhost:8080/BBSblogSys/
		if (loginUser == null) {
			String strBackUrl = "http://" + request.getServerName() // 服务器地址
					+ ":" + request.getServerPort() // 端口号
					+ request.getContextPath() // 项目名称
					+ request.getServletPath(); // 请求页面或其他地址
			/* + "?" + (request.getQueryString()) */// 参数
			request.getSession().setAttribute("strBackUrl", strBackUrl);
			return "redirect:../../login.html";
		}
		loginUser = userInfoService.findById(loginUser.getId());
		// 板块内容
		List<Board> boards = boardService.listBoard();
		request.setAttribute("boards", boards);

		// 博主动态

		// 分页
		int page = 1;

		try {
			page = Integer.parseInt(request.getParameter("page"));
		} catch (Exception e) {

			page = 1;
		}

		String hqlBlogdt = "from BlogLog where blogStatus.id='1' and blog.id='"
				+ loginUser.getId() + "' order by blogTime desc";

		List<BlogLog> blogdtArray = blogLogService.listBlogLogBySql(hqlBlogdt);
		List<BlogLog> blogdt = null;

		int totalPage = blogdtArray.size();

		int pageSize = 6;
		// 最后一页
		int lastPage = 1;
		if (totalPage % pageSize == 0) {
			lastPage = totalPage / pageSize;
		} else
			lastPage = totalPage / pageSize + 1;

		if (page > lastPage) {
			page = lastPage;
		}
		if (page <= 0) {
			page = 1;
		}
		request.setAttribute("lastPage", lastPage);
		request.setAttribute("page", page);

		// 当前页第一个的位置
		int firstSet = (page - 1) * pageSize;

		// 下方排序
		if (blogdtArray.size() > pageSize) {
			if ((firstSet + pageSize) < (totalPage - 1)) {
				blogdt = blogdtArray.subList(firstSet, firstSet + pageSize);
			} else {
				blogdt = blogdtArray.subList(firstSet, totalPage);
			}
		} else {
			blogdt = blogdtArray;
		}

		if (blogdt.size() != 0) {

			for (int i = 0; i < blogdt.size(); i++) {

				// 去掉HTML标签
				String logContent = HtmlSpecialChars.htmlspecialchars2(blogdt
						.get(i).getBlogContent());
				// 缩短字符
				if (logContent.length() > 100) {
					logContent = logContent.substring(0, 80);
				}

				blogdt.get(i).setBlogContent(logContent);

				// 标签
				List<BlogLabel> labelList = blogLabelService
						.listBlogLabelByLog(blogdt.get(i).getId());
				//
				if (labelList.size() > 0) {

					String logLabelA = labelList.get(0).getLabel()
							.getLabelName();

					blogdt.get(i).setKeywordA(logLabelA);

				}
				if (labelList.size() > 1) {
					String logLabelB = labelList.get(1).getLabel()
							.getLabelName();

					blogdt.get(i).setKeywordB(logLabelB);

				}
				if (labelList.size() > 2) {
					String logLabelC = labelList.get(2).getLabel()
							.getLabelName();
					blogdt.get(i).setKeywordC(logLabelC);

				}
			}
		}
		request.setAttribute("blogdt", blogdt);

		// 私信

		int newMsg = 0;
		if (loginUser != null) {

			String messageSql = "from Message where userInfo1.id = '"
					+ loginUser.getId() + "' and isRead = '0'";
			List<Message> messageList = messageService
					.listMessageBySql(messageSql);
			newMsg = messageList.size();
			// 更新session
			request.getSession().setAttribute("userInfo",
					this.userInfoService.findById(loginUser.getId()));
		}
		request.setAttribute("newMsgCount", newMsg);

		// 告诉页面，区别草稿和正文
		request.setAttribute("isDraft", "yes");

		return "../Blog/IndexMore";
	}

	// 查看草稿文件
	@RequestMapping(value = "/Draft/{id}")
	public String listDraftById(HttpServletRequest request,
			@PathVariable String id) {

		List<Board> boards = boardService.listBoard();

		request.setAttribute("boards", boards);

		BlogLog draft = blogLogService.listBlogLogById(Long.parseLong(id));
		Board draftBoard = draft.getBoard();
		if (draftBoard != null) {
			List<Label> labelList = labelService.listLabelByBoard(draftBoard
					.getId());
			request.setAttribute("labelList", labelList);
		}

		// 查找标签
		List<BlogLabel> blogLabel = blogLabelService.listBlogLabelByLog(Long
				.parseLong(id));
		String draftLabel = "";

		System.out.println(blogLabel.size());
		if (blogLabel.size() == 0) {
			draftLabel = "";
		} else {
			for (int i = 0; i < blogLabel.size(); i++) {
				draftLabel += blogLabel.get(i).getLabel().getLabelName() + "%";
				System.out.println(draftLabel + "in" + i);
			}
		}
		System.out.println(draftLabel);
		request.setAttribute("draftLabel", draftLabel);
		request.setAttribute("draft", draft);
		request.setAttribute("isDraft", "yes");

		return "../newBlog";
	}

	//
	// 将草稿箱发布出去,暂时使用的newLog方法，因为不是发出去了就没了，1便于操作避免重复写方法；2这样即使发出去了，草稿箱里的东西依然在；3公用删除方法
	// 这个方法是之前的update方法，草稿功能可能用不上；
	// 20141123 修改为草稿更新，因为不可能让用户再次进入该文章的时候重新保存；
	@RequestMapping(value = "/draftUpdate")
	public String updatedraft(HttpServletRequest request, BlogLog blogLog,
			String labelId) {

		UserInfo loginUser = (UserInfo) request.getSession().getAttribute(
				"userInfo");

		// 查看是否登录 http://localhost:8080/BBSblogSys/
		if (loginUser == null) {
			String strBackUrl = "http://" + request.getServerName() // 服务器地址
					+ ":" + request.getServerPort() // 端口号
					+ request.getContextPath() // 项目名称
					+ request.getServletPath(); // 请求页面或其他地址
			/* + "?" + (request.getQueryString()) */// 参数
			request.getSession().setAttribute("strBackUrl", strBackUrl);
			return "redirect:../../login.html";
		}
		loginUser = userInfoService.findById(loginUser.getId());
		String blogId = request.getParameter("blogLogId");
		blogLog.setId(Long.parseLong(blogId));

		if (blogLog.getBoard().getId() == -1) {
			System.out.println("Union unselected, default is empty");
			blogLog.setBoard(null);
		}
		if (blogLog.getSubject().equalsIgnoreCase("")
				|| blogLog.getSubject() == null || blogLog.getSubject() == "") {
			blogLog.setSubject("Unnamed blog_" + getNowTime());
		}
		Blog blog = blogService.listBlogById(loginUser.getId());
		blogLog.setBlog(blog);

		BlogStatus bs = blogStatusService.listBlogStatusById(1);
		blogLog.setBlogStatus(bs);

		// 修改标签
		List<BlogLabel> blogLabels = blogLabelService
				.listBlogLabelByLog(blogLog.getId());
		// 删除之前的标签
		for (int i = 0; i < blogLabels.size(); i++) {
			// System.out.println("delete starting");
			blogLabelService.deleteBlogLabel(blogLabels.get(i).getId());
		}
		// 保存新的标签

		// 标签管理

		System.out
				.println("=============开始标签管理=====================" + labelId);
		if (labelId != null && labelId != "") {

			String[] labels = labelId.split(",");
			int labelSize = labels.length;
			BlogLabel blogLabel = new BlogLabel();

			if (labelSize > 3) {

				request.setAttribute("result", "Choose 3 tags at most ");
				return "../ERROR/result";

			}

			for (int i = 0; i < labelSize; i++) {
				long blogLabelId = Long.parseLong(labels[i]);
				// System.out.println( blogLabelId);
				Label LabelInBlogLabel = labelService
						.listLabelById(blogLabelId);
				BlogLog blogInBlogLabel = blogLogService
						.listBlogLogById(blogLog.getId());

				blogLabel.setLabel(LabelInBlogLabel);
				blogLabel.setBlogLog(blogInBlogLabel);

				blogLabelService.saveBlogLabel(blogLabel);

			}
		} /*
		 * else {
		 * 
		 * request.setAttribute("result", "choose at least 1 tag"); return
		 * "../ERROR/result";
		 * 
		 * }
		 */

		this.blogLogService.updateBlogLog(blogLog);

		// 0=直接保存草稿箱，1=保存草稿箱后跳转到申请添加标签
		String toStatus = "0";

		try {
			toStatus = request.getParameter("toStatus");
		} catch (Exception e) {
		}

		if (toStatus.trim().equalsIgnoreCase("1")) {
			List<Board> listBoard = this.boardService.listBoard();
			request.setAttribute("listBoard", listBoard);

			return "redirect:../../addLabelApply";
		}

		return "redirect:Draft.html";// 返回到草稿箱

	}

	/*
	 * ===================================分隔======================================
	 * ======
	 */
	/**
	 * 通过nickName找到Blog
	 * 
	 * @author Robust
	 * 
	 * @date 2014年9月16日
	 * 
	 * @param request
	 * @param nickName
	 * @return
	 */
	/*
	 * @RequestMapping(value = "/{nickName}/Log") public String
	 * listLogByNickName(HttpServletRequest request,
	 * 
	 * @PathVariable String nickName) { UserInfo loginUser = (UserInfo)
	 * request.getSession().getAttribute( "userInfo");
	 * 
	 * // 设置分页属性 int offset = 0; int pageSize = 10; try { offset =
	 * Integer.parseInt(request.getParameter("pager.offset")); } catch
	 * (Exception e) { } // 列出博文列表 List<UserInfo> blogUserList = userInfoService
	 * .findUserByNickName(nickName); UserInfo blogUser = blogUserList.get(0);
	 * long BlogId = blogUser.getId();
	 * 
	 * PageModel pm = blogLogService.listBloglogByBlog(offset, pageSize,
	 * BlogId); request.setAttribute("pm", pm);
	 * 
	 * // 判断是否显示删除/编辑按钮
	 * 
	 * try { // 1 是本人 0 不是本人 if (loginUser.getId() == BlogId) {
	 * request.setAttribute("owner", 1); } else request.setAttribute("owner",
	 * 0); } catch (Exception e) { }
	 * 
	 * // 私信
	 * 
	 * int newMsg = 0; if (loginUser != null) {
	 * 
	 * String messageSql = "from Message where userInfo1.id = '" +
	 * loginUser.getId() + "' and isRead = '0'"; List<Message> messageList =
	 * messageService .listMessageBySql(messageSql); newMsg =
	 * messageList.size(); } request.setAttribute("newMsgCount", newMsg);
	 * 
	 * return "../Log";
	 * 
	 * }
	 * 
	 * @RequestMapping(value = "/{nickName}/bbs") public String
	 * listBBsByNickName(HttpServletRequest request,
	 * 
	 * @PathVariable String nickName) { UserInfo loginUser = (UserInfo)
	 * request.getSession().getAttribute( "userInfo");
	 * 
	 * // 设置分页属性 int offset = 0; int pageSize = 10; try { offset =
	 * Integer.parseInt(request.getParameter("pager.offset")); } catch
	 * (Exception e) { } // 列出博文列表 List<UserInfo> postUserList = userInfoService
	 * .findUserByNickName(nickName); UserInfo postUser = postUserList.get(0);
	 * long postId = postUser.getId();
	 * 
	 * PageModel pm = forum_postService.listPostByPost(offset, pageSize,
	 * postId); request.setAttribute("pm", pm);
	 * 
	 * try { // 1 是本人 0 不是本人 if (loginUser.getId() == postId) {
	 * request.setAttribute("owner", 1); } else request.setAttribute("owner",
	 * 0); } catch (Exception e) { }
	 * 
	 * // 私信
	 * 
	 * int newMsg = 0; if (loginUser != null) {
	 * 
	 * String messageSql = "from Message where userInfo1.id = '" +
	 * loginUser.getId() + "' and isRead = '0'"; List<Message> messageList =
	 * messageService .listMessageBySql(messageSql); newMsg =
	 * messageList.size(); } request.setAttribute("newMsgCount", newMsg);
	 * 
	 * return "../post";
	 * 
	 * }
	 * 
	 * @RequestMapping(value = "/{nickName}/question") public String
	 * listQuestionByNickName(HttpServletRequest request,
	 * 
	 * @PathVariable String nickName) { UserInfo loginUser = (UserInfo)
	 * request.getSession().getAttribute( "userInfo");
	 * 
	 * // 设置分页属性 int offset = 0; int pageSize = 10; try { offset =
	 * Integer.parseInt(request.getParameter("pager.offset")); } catch
	 * (Exception e) { } // 列出博文列表 List<UserInfo> questionUserList =
	 * userInfoService .findUserByNickName(nickName); UserInfo questionUser =
	 * questionUserList.get(0); long questionId = questionUser.getId();
	 * 
	 * PageModel pm = questionService.listQuestion(offset, pageSize,
	 * questionId); request.setAttribute("pm", pm);
	 * 
	 * try { // 1 是本人 0 不是本人 if (loginUser.getId() == questionId) {
	 * request.setAttribute("owner", 1); } else request.setAttribute("owner",
	 * 0); } catch (Exception e) { }
	 * 
	 * // 私信
	 * 
	 * int newMsg = 0; if (loginUser != null) {
	 * 
	 * String messageSql = "from Message where userInfo1.id = '" +
	 * loginUser.getId() + "' and isRead = '0'"; List<Message> messageList =
	 * messageService .listMessageBySql(messageSql); newMsg =
	 * messageList.size(); } request.setAttribute("newMsgCount", newMsg);
	 * 
	 * return "../question";
	 * 
	 * }
	 */

	// =====================================attachContent==================================
	// 这里开始是资源区内容

	@RequestMapping(value = "/editAttach")
	public String toNewAttach(HttpServletRequest request) {
		UserInfo loginUser = (UserInfo) request.getSession().getAttribute(
				"userInfo");

		if (loginUser == null) {
			String strBackUrl = "http://" + request.getServerName() // 服务器地址
					+ ":" + request.getServerPort() // 端口号
					+ request.getContextPath() // 项目名称
					+ request.getServletPath(); // 请求页面或其他地址
			/* + "?" + (request.getQueryString()) */// 参数
			request.getSession().setAttribute("strBackUrl", strBackUrl);
			return "redirect:../../login.html";

		}
		loginUser = userInfoService.findById(loginUser.getId());
		// 私信

		int newMsg = 0;
		if (loginUser != null) {

			String messageSql = "from Message where userInfo1.id = '"
					+ loginUser.getId() + "' and isRead = '0'";
			List<Message> messageList = messageService
					.listMessageBySql(messageSql);
			newMsg = messageList.size();
			// 更新session
			request.getSession().setAttribute("userInfo",
					this.userInfoService.findById(loginUser.getId()));
		}
		request.setAttribute("newMsgCount", newMsg);

		return "newAttach";
	}

	/**
	 * 上传新附件
	 * 
	 * @author Robust
	 * 
	 * @date 2014年9月5日
	 * 
	 * @param request
	 * @param attachment
	 * @param file
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/newAttach")
	public String newAttach(HttpServletRequest request, Attachment attachment,
			MultipartFile file, String killHighLevel) throws IOException {

		UserInfo loginUser = (UserInfo) request.getSession().getAttribute(
				"userInfo");

		if (loginUser == null) {
			return "redirect:../../login.html";
		}
		loginUser = userInfoService.findById(loginUser.getId());
		if (file.getOriginalFilename().isEmpty()) {
			System.out.println("未上传附件");
			request.setAttribute("result", "Not upload files, please re-upload");
			return "../ERROR/result";
			// System.out.println("========================================");
		} else {

			// 这里开始判断killHighLevel

			if (killHighLevel.equalsIgnoreCase("0")) {
				// 观看权限设置为最高
				attachment.setAccess("7");
				// 扣除1灵丹的资费
				String lingdan = loginUser.getLingdan();
				double lingdanInt = Double.parseDouble(lingdan);
				if (lingdanInt < 1) {
					request.setAttribute("result", "Panacen insufficient");
					return "../ERROR/result";
				}
				lingdanInt = lingdanInt - 1;
				loginUser.setLingdan(lingdanInt + "");
				userInfoService.updateUserInfo(loginUser);
			}

			// 或许附件大小存入数据库

			double attachmentSizeDouble = get2Double(((double) file.getSize() / 1024) / 1024);

			String attachmentSize = attachmentSizeDouble + "MB";
			System.out.println("attachmentSize:" + attachmentSize + "MB");

			if (attachmentSizeDouble > 20.0) {
				request.setAttribute("result", "The uploaded file exceeds 20M, please re-upload");
				return "../ERROR/result";
			}
			// 获取当期时间，作为文件名，避免重复
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmSSSS");
			String fileTime = sdf.format(new Date());

			// 1、当前时间替换文件名=======2、获取后缀名
			String fileName = file.getOriginalFilename();
			int beginIndex = fileName.lastIndexOf(".");
			String extendName = fileName.substring(beginIndex,
					fileName.length())
					+ ".Renaming";

			String newFileName = file.getOriginalFilename().substring(0,
					beginIndex)
					+ "_" + fileTime + extendName;

			// 上传的文件放在“realPath”目录下
			String realPath = request.getSession().getServletContext()
					.getRealPath("web/Blog/upload");
			if ((new File(realPath).isDirectory())) {
				System.out.println("Folder already exists! Creation failed!");
			} else {
				new File(realPath).mkdir();
				System.out.println("Creating a folder successfully！");
			}

			// URLDecoder.decode("%E4%B8%96%E7%95%8C", "UTF-8");
			// URLEncoder.encode(s)
			// 这里文件名是中文需要转码，不然会出错

			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(
					realPath, newFileName));

			// 将文件名存入数据库
			String encodeName = URLEncoder.encode(newFileName, "UTF-8");

			attachment.setAttachUrl("web/Blog/upload/" + encodeName);

			attachment.setAttachSize(attachmentSize);
		}
		attachment.setUserInfo(loginUser);
		// 初始化部分数据
		attachment.setUpCount("0");
		attachment.setNormal("0");
		attachment.setDown("0");

		// download次数
		attachment.setAttachDownload("0");

		// set time

		attachment.setAttachTime(getNowTime());

		// 名字内容过滤

		String attachContent = HtmlSpecialChars.htmlspecialchars(attachment
				.getAttachDesc());
		String attachSubject = HtmlSpecialChars.htmlspecialchars(attachment
				.getAttachName());

		if (StringUtils.isBlank(attachSubject)) {
			request.setAttribute("result", "The title can not be empty");
			return "../ERROR/result";
		}

		List<FilterWord> fw = filterWordService.listFilterWord();
		if (fw.size() > 0) {
			for (int i = 0; i < fw.size(); i++) {
				attachContent = attachContent.replace(fw.get(i).getFind(), fw
						.get(i).getReplacement());
				attachSubject = attachSubject.replace(fw.get(i).getFind(), fw
						.get(i).getReplacement());
			}
		}
		attachment.setAttachDesc(attachContent);
		attachment.setAttachName(attachSubject);

		this.attachmentService.saveAttachment(attachment);

		UserInfo blogUser = loginUser;
		// 判断帖子是否被评论,如未评论最高分不能超过7分，直到有某一帖被评论，解除7分上限
		long userId = blogUser.getId();
		// System.out.println("Words conform to the standard");
		List<UserUpHi> userUpHis = userUpHisService.listUserUpHiByBlog(userId);
		String jinzhuan = blogUser.getJinzhuan();
		double jinzhuanInt = Double.parseDouble(jinzhuan);

		if (jinzhuanInt < 7) {
			// 金砖小于7，可以积累
			System.out.println("score when more than 7" + jinzhuanInt);
			jinzhuanInt++;
			blogUser.setJinzhuan(jinzhuanInt + "");
			blogUser.setUserLevel(ScoreLevel.scoreLevel(jinzhuanInt + ""));
			userInfoService.updateUserInfo(blogUser);

			// 开始板块积分

		} else {
			// 金砖大于7,判断是否评价。
			if (userUpHis.size() > 2) {
				System.out.println("score when less than 7");
				// 有至少一篇文章被给予评价
				jinzhuanInt++;
				blogUser.setJinzhuan(jinzhuanInt + "");
				blogUser.setUserLevel(ScoreLevel.scoreLevel(jinzhuanInt + ""));
				userInfoService.updateUserInfo(blogUser);
			} else
				System.out.println("exceeding 7 & no review");
		}

		// 将发帖动作记录到好友动态表
		Audit attachAudit = new Audit();
		attachAudit.setAuditTime(getNowTime());
		attachAudit.setUserInfo(loginUser);
		// 动态内容,其实就是标题
		attachAudit.setAuditContent(attachment.getAttachName());
		// 动态Id,博客/论坛/问答/资源/等等表中的id
		attachAudit.setAuditId(loginUser.getId() + "");
		// 动态类型（论坛/博客/问答/资源/等等系列），这里什么都存
		attachAudit.setAuditType("ZY");
		auditService.saveAduit(attachAudit);

		return "redirect:/web/Blog/AttachDetail/" + attachment.getId();
		/* + URLEncoder.encode(loginUser.getNickName(), "UTF-8") */
	}

	/**
	 * 查看附件列表
	 * 
	 * @author Robust
	 * 
	 * @date 2014年9月5日
	 * 
	 * @param request
	 * @return
	 */
	/*
	 * @RequestMapping(value = "/{nickName}/Attach") public String
	 * listAttach(HttpServletRequest request,
	 * 
	 * @PathVariable String nickName) {
	 * 
	 * UserInfo loginUser = (UserInfo) request.getSession().getAttribute(
	 * "userInfo");
	 * 
	 * int offset = 0; int pageSize = 15; try { offset =
	 * Integer.parseInt(request.getParameter("pager.offset")); } catch
	 * (Exception e) { } List<UserInfo> blogUserList = userInfoService
	 * .findUserByNickName(nickName); if (blogUserList.size() < 1) {
	 * System.out.println("wrong loginUserList"); } UserInfo blogUser =
	 * blogUserList.get(0); long blogId = blogUser.getId();
	 * 
	 * PageModel pm = attachmentService.listAttachmentByBlogId(offset, pageSize,
	 * blogId); request.setAttribute("pm", pm);
	 * request.setAttribute("blogNickName", blogUser.getNickName());
	 * 
	 * try { // 1 是本人 0 不是本人 if (loginUser.getId() == blogUser.getId()) {
	 * request.setAttribute("owner", 1); } else request.setAttribute("owner",
	 * 0); } catch (Exception e) { }
	 * 
	 * // 私信
	 * 
	 * int newMsg = 0; if (loginUser != null) {
	 * 
	 * String messageSql = "from Message where userInfo1.id = '" +
	 * loginUser.getId() + "' and isRead = '0'"; List<Message> messageList =
	 * messageService .listMessageBySql(messageSql); newMsg =
	 * messageList.size(); } request.setAttribute("newMsgCount", newMsg);
	 * 
	 * return "../attach"; }
	 */

	/**
	 * 
	 * @author Robust
	 * 
	 * @date 2014年9月5日
	 * 
	 * @param request
	 * @param id
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/deleteAttach_{id}")
	public String deleteAttach(HttpServletRequest request, @PathVariable long id)
			throws UnsupportedEncodingException {

		UserInfo loginUser = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		loginUser = userInfoService.findById(loginUser.getId());
		Attachment attachment = this.attachmentService.listAttachment(id);

		String attachUrl = attachment.getAttachUrl();
		if (attachUrl == null || attachUrl == "") {
			System.out.println("Cannot upload files");
		}

		else {
			String newFileName = attachUrl.substring(15);
			try {
				newFileName = URLDecoder.decode(newFileName, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			String realPath = request.getSession().getServletContext()
					.getRealPath("web/Blog/upload/");

			System.out.println(realPath + newFileName);

			File tarFile = new File(realPath + newFileName);

			System.out.println("tarFile.length()==============="
					+ tarFile.exists());
			if (tarFile.exists()) {
				tarFile.delete();

			}
		}

		this.attachmentService.deleteAttachment(id);
		return "redirect:/web/Blog/"
				+ URLEncoder.encode(loginUser.getNickName(), "Utf-8");
	}

	// 多加一个显示价格等信息的页面 以供选择
	@RequestMapping(value = "/AttachDetail/{id}")
	public String listAttachDetailById(HttpServletRequest request,
			@PathVariable long id) {

		// 拿到需要的各对象
		Attachment attachment = this.attachmentService.listAttachment(id);
		request.setAttribute("attachment", attachment);

		request.setAttribute("blogUser", attachment.getUserInfo());

		UserInfo loginUser = (UserInfo) request.getSession().getAttribute(
				"userInfo");

		// 判断是否有关注博主
		if (loginUser != null) {
			loginUser = userInfoService.findById(loginUser.getId());
			String friend = "no";
			List<Friend> listFriend = this.friendService.IsFriend(
					loginUser.getId(), attachment.getUserInfo().getId());
			if (listFriend.size() > 0) {
				friend = "yes";
			}
			request.setAttribute("friend", friend);
		}

		// 博主的资质认证区
		UserInfo blogUser = attachment.getUserInfo();

		// 个人首页相册（个人相册、资质相册）
		String albumName = "Qualification Proof";
		List<UserAlbum> listZzzm = userAlbumService.listByUserAndAlbumName(
				blogUser.getId(), albumName);

		List<UserAlbumPhoto> listZi = new ArrayList<UserAlbumPhoto>();
		List<UserAlbumPhoto> listZz = new ArrayList<UserAlbumPhoto>();

		String album = "0";
		if (listZzzm.size() > 0) {
			UserAlbum zzzm = listZzzm.get(0);
			request.setAttribute("zzzm", zzzm);
			String sql = "from UserAlbumPhoto u where u.userAlbum.id = '"
					+ zzzm.getId()
					+ "' and u.zzzm = '2' order by photoTime desc";
			listZi = userAlbumPhotoService.listBySql(sql);

			String sql2 = "from UserAlbumPhoto u where u.userAlbum.id = '"
					+ zzzm.getId()
					+ "' and (u.zzzm ='2' or u.zzzm = '1') order by photoTime desc";

			listZz = userAlbumPhotoService.listBySql(sql2);

			// 0没有，1通过不可看，2审核中，3可以查看
			if (listZz != null && listZz.size() > 0) {
				if (listZi != null && listZi.size() > 0) {
					if (zzzm.getIslocked().equals("1")) {
						album = "3";
					} else
						album = "1";
				} else {
					album = "2";
				}

			} else
				album = "0";

		}

		request.setAttribute("album", album);
		request.setAttribute("listZi", listZi);

		// 他的资源区
		String blogArticleAttach = "from Attachment where userInfo.id="
				+ attachment.getUserInfo().getId() + "order by attachTime desc";
		List<Attachment> attachmentList = attachmentService
				.listAttachBySql(blogArticleAttach);

		if (attachmentList.size() > 5) {
			attachmentList = attachmentList.subList(0, 5);
		}

		request.setAttribute("attachmentList", attachmentList);

		// 他的提问

		String blogArticleQuestion = "from Question where userInfo.id="
				+ attachment.getUserInfo().getId() + "order by qTime desc";
		List<Question> question = questionService
				.listQuestionBySql(blogArticleQuestion);

		if (question.size() > 5) {
			question = question.subList(0, 5);
		}

		request.setAttribute("question", question);

		// 他的提问
		String blogArticleAnswer = "from Answer where userInfo.id="
				+ attachment.getUserInfo().getId() + "order by aTime desc";
		List<Answer> answer = answerService.listAnswerBySql(blogArticleAnswer);

		if (answer.size() > 5) {
			answer = answer.subList(0, 5);
		}

		request.setAttribute("answer", answer);

		/*
		 * // 活跃标签 List<BlogLabel> activeLabel = blogLabelService
		 * .listBlogLabelByLog(realId);
		 * 
		 * request.setAttribute("activeLabels", activeLabel);
		 */

		// 原创和转载
		String ycCountHql = "select count(*) from BlogLog where blog.id='"
				+ attachment.getUserInfo().getId() + "' and blogType= '1' ";
		String zzCountHql = "select count(*) from BlogLog where blog.id='"
				+ attachment.getUserInfo().getId() + "' and blogType= '2' ";
		int ycCount = blogLogService.listCount(ycCountHql);
		int zzCount = blogLogService.listCount(zzCountHql);
		request.setAttribute("ycCount", ycCount);
		request.setAttribute("zzCount", zzCount);
		// 查看是否为本人
		try {

			// 判断是否有关注博主
			if (loginUser != null) {
				String friend = "no";
				List<Friend> listFriend = this.friendService.IsFriend(
						loginUser.getId(), attachment.getUserInfo().getId());
				if (listFriend.size() > 0) {
					friend = "yes";
				}
				request.setAttribute("friend", friend);
			}

			// 1 是本人 0 不是本人
			if (loginUser.getId() == attachment.getUserInfo().getId()) {
				request.setAttribute("owner", 1);
			} else
				request.setAttribute("owner", 0);
		} catch (Exception e) {
		}

		// 私信

		int newMsg = 0;
		if (loginUser != null) {

			String messageSql = "from Message where userInfo1.id = '"
					+ loginUser.getId() + "' and isRead = '0'";
			List<Message> messageList = messageService
					.listMessageBySql(messageSql);
			newMsg = messageList.size();
			// 更新session
			request.getSession().setAttribute("userInfo",
					this.userInfoService.findById(loginUser.getId()));
		}
		request.setAttribute("newMsgCount", newMsg);

		return "../attachDetail";

	}

	/**
	 * 列出附件详细内容，此时已经扣除所需积分
	 * 
	 * @author Robust
	 * 
	 * @date 2014年9月5日
	 * 
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/Attach/{id}")
	public String listAttachById(HttpServletRequest request,
			@PathVariable long id) {

		// 拿到需要的各对象
		Attachment attachment = this.attachmentService.listAttachment(id);
		request.setAttribute("attachment", attachment);

		request.setAttribute("blogUser", attachment.getUserInfo());

		UserInfo loginUser = (UserInfo) request.getSession().getAttribute(
				"userInfo");

		// 判断是否有关注博主
		if (loginUser != null) {
			loginUser = userInfoService.findById(loginUser.getId());
			String friend = "no";
			List<Friend> listFriend = this.friendService.IsFriend(
					loginUser.getId(), attachment.getUserInfo().getId());
			if (listFriend.size() > 0) {
				friend = "yes";
			}
			request.setAttribute("friend", friend);
		}

		// 博主的资质认证区
		UserInfo blogUser = attachment.getUserInfo();

		// 个人首页相册（个人相册、资质相册）
		String albumName = "Qualification Proof";
		List<UserAlbum> listZzzm = userAlbumService.listByUserAndAlbumName(
				blogUser.getId(), albumName);

		List<UserAlbumPhoto> listZi = new ArrayList<UserAlbumPhoto>();
		List<UserAlbumPhoto> listZz = new ArrayList<UserAlbumPhoto>();

		String album = "0";
		if (listZzzm.size() > 0) {
			UserAlbum zzzm = listZzzm.get(0);
			request.setAttribute("zzzm", zzzm);
			String sql = "from UserAlbumPhoto u where u.userAlbum.id = '"
					+ zzzm.getId()
					+ "' and u.zzzm = '2' order by photoTime desc";
			listZi = userAlbumPhotoService.listBySql(sql);

			String sql2 = "from UserAlbumPhoto u where u.userAlbum.id = '"
					+ zzzm.getId()
					+ "' and (u.zzzm ='2' or u.zzzm = '1') order by photoTime desc";

			listZz = userAlbumPhotoService.listBySql(sql2);

			// 0没有，1通过不可看，2审核中，3可以查看
			if (listZz != null && listZz.size() > 0) {
				if (listZi != null && listZi.size() > 0) {
					if (zzzm.getIslocked().equals("1")) {
						album = "3";
					} else
						album = "1";
				} else {
					album = "2";
				}

			} else
				album = "0";

		}

		request.setAttribute("album", album);
		request.setAttribute("listZi", listZi);

		// 他的资源区
		String blogArticleAttach = "from Attachment where userInfo.id="
				+ attachment.getUserInfo().getId() + "order by attachTime desc";
		List<Attachment> attachmentList = attachmentService
				.listAttachBySql(blogArticleAttach);

		if (attachmentList.size() > 5) {
			attachmentList = attachmentList.subList(0, 5);
		}

		request.setAttribute("attachmentList", attachmentList);

		// 他的提问

		String blogArticleQuestion = "from Question where userInfo.id="
				+ attachment.getUserInfo().getId() + "order by qTime desc";
		List<Question> question = questionService
				.listQuestionBySql(blogArticleQuestion);

		if (question.size() > 5) {
			question = question.subList(0, 5);
		}

		request.setAttribute("question", question);

		// 他的提问
		String blogArticleAnswer = "from Answer where userInfo.id="
				+ attachment.getUserInfo().getId() + "order by aTime desc";
		List<Answer> answer = answerService.listAnswerBySql(blogArticleAnswer);

		if (answer.size() > 5) {
			answer = answer.subList(0, 5);
		}

		request.setAttribute("answer", answer);

		/*
		 * // 活跃标签 List<BlogLabel> activeLabel = blogLabelService
		 * .listBlogLabelByLog(realId);
		 * 
		 * request.setAttribute("activeLabels", activeLabel);
		 */

		// 原创和转载
		String ycCountHql = "select count(*) from BlogLog where blog.id='"
				+ attachment.getUserInfo().getId() + "' and blogType= '1' ";
		String zzCountHql = "select count(*) from BlogLog where blog.id='"
				+ attachment.getUserInfo().getId() + "' and blogType= '2' ";
		int ycCount = blogLogService.listCount(ycCountHql);
		int zzCount = blogLogService.listCount(zzCountHql);
		request.setAttribute("ycCount", ycCount);
		request.setAttribute("zzCount", zzCount);

		// owner
		/* UserInfo blogUser = attachment.getUserInfo(); */
		// guest

		// 查看是否登录
		if (loginUser == null) {
			String strBackUrl = "http://" + request.getServerName() // 服务器地址
					+ ":" + request.getServerPort() // 端口号
					+ request.getContextPath() // 项目名称
					+ request.getServletPath(); // 请求页面或其他地址
			/* + "?" + (request.getQueryString()) */// 参数
			request.getSession().setAttribute("strBackUrl", strBackUrl);
			return "redirect:../../../login.html";
		}

		// 查看是否为本人
		try {

			// 判断是否有关注博主
			if (loginUser != null) {
				String friend = "no";
				List<Friend> listFriend = this.friendService.IsFriend(
						loginUser.getId(), attachment.getUserInfo().getId());
				if (listFriend.size() > 0) {
					friend = "yes";
				}
				request.setAttribute("friend", friend);
			}

			// 1 是本人 0 不是本人
			if (loginUser.getId() == attachment.getUserInfo().getId()) {
				request.setAttribute("owner", 1);
			} else
				request.setAttribute("owner", 0);
		} catch (Exception e) {
		}

		// 自己的内容随便看
		if (loginUser.getId() == blogUser.getId()) {
			return "../detail";
		}

		// time
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyMMdd");
		String attachDownloadTime = sf.format(date);

		// 如果今天没访问过，访问量/下载量+1，否则不加
		String findAttachDownloadByDateSql = "from AttachDownload where attachment.id='"
				+ attachment.getId()
				+ "' and userInfo = '"
				+ loginUser.getId()
				+ "' and time = '" + attachDownloadTime + "'";
		List<AttachDownload> attachDownloadForVisited = attachDownloadService
				.listAttachDownloadBySql(findAttachDownloadByDateSql);

		// 权限，高level权限可以无视规则。
		// 与access字段比较

		String blogAccess = attachment.getAccess();
		String loginAccess = loginUser.getUserLevel();

		double blogAccessInt = Double.parseDouble(blogAccess);
		double loginAccessInt = Double.parseDouble(loginAccess);

		if (blogAccessInt < loginAccessInt) {
			// 判断今天是否访问过
			if (attachDownloadForVisited.size() < 1) {
				String downloadCount = attachment.getAttachDownload();
				int downloadCountInt = Integer.parseInt(downloadCount);
				downloadCountInt++;
				attachment.setAttachDownload(downloadCountInt + "");
				attachmentService.updateAttachment(attachment);
				
				//发消息给上传资源者
				MessageText messageText = new MessageText();
				messageText.setMsgSubject("系统消息");			
				String strBackUrl = "http://" + request.getServerName() // 服务器地址
						+ ":" + request.getServerPort() // 端口号
						+ request.getContextPath();// 项目名称
				
				messageText.setMsgContent(loginUser.getNickName()+" 于  "+getNowTime()+"  下载了您的资源            <a href= " +
						strBackUrl+"/web/Blog/AttachDetail/"+attachment.getId()+">"+attachment.getAttachName()+"</a>");
				messageText.setMsgTime(getNowTime());
				messageText.setMsgType("0");
				this.messageTextService.saveMessageText(messageText);
				//设置发送信息对象
				Message message = new Message();
				message.setIsRead("0");
				message.setMessageText(messageText);
				//获取管理员信息
				List<UserInfo> userInfoList=userInfoService.findUserByName("admin");
				UserInfo admin=userInfoList.get(0);
				//设置发信人为管理员
				message.setUserInfo2(admin);
				message.setUserInfo1(attachment.getUserInfo());
				//发送信息
				this.messageService.saveMessage(message);

				// 保存访问记录
				AttachDownload attachDownload = new AttachDownload();
				attachDownload.setAttachment(attachment);
				attachDownload.setTime(attachDownloadTime);
				attachDownload.setUserInfo(loginUser);

				attachDownloadService.saveAttachDownload(attachDownload);
			}
			return "../detail";
		}

		/*
		 * 这里添加购买记录 如果已经购买过，下次可以直接进去 如果未购买，则会先进行购买动作
		 */
		String findAttachmentDownloadByUserInfoAndAttachmentSql = "from AttachDownload where attachment.id='"
				+ attachment.getId()
				+ "' and userInfo.id='"
				+ loginUser.getId() + "'";
		List<AttachDownload> downloadHis = attachDownloadService
				.listAttachDownloadBySql(findAttachmentDownloadByUserInfoAndAttachmentSql);

		if (downloadHis.size() > 0) {
			// 判断今天是否访问过
			if (attachDownloadForVisited.size() < 1) {
				String downloadCount = attachment.getAttachDownload();
				int downloadCountInt = Integer.parseInt(downloadCount);
				downloadCountInt++;
				attachment.setAttachDownload(downloadCountInt + "");
				attachmentService.updateAttachment(attachment);

			}
			return "../detail";
		}

		// 下面是需要购买的流程跳转
		try {

			// 扣除loginUser的积分加到owner上面
			// 拿到附件价值的jindan&lingdan
			String lingdan = attachment.getLingdanWealth();
			String jinzhuan = attachment.getJinzhuanWealth();
			// 得到owner原有值
			String blogLingdan = blogUser.getLingdan();
			String blogJinzhuan = blogUser.getJinzhuan();
			// 得到guest原有值
			String loginLingdan = loginUser.getLingdan();
			String loginJinzhuan = loginUser.getJinzhuan();

			// 转为int
			double lingdanInt = Double.parseDouble(lingdan);
			double jinzhuanInt = Double.parseDouble(jinzhuan);

			double loginLingdanInt = Double.parseDouble(loginLingdan);
			double loginJinzhuanInt = Double.parseDouble(loginJinzhuan);

			double blogLingdanInt = Double.parseDouble(blogLingdan);
			double blogJinzhuanInt = Double.parseDouble(blogJinzhuan);
			// 这里开始判断积分是否充足

			if (loginLingdanInt < lingdanInt) {
				System.out.println("Panacen insufficient");
				// TODO:返回充值页面
				request.setAttribute("result", "Panacen insufficient");
				return "../../ERROR/result";
			} else if (loginJinzhuanInt < jinzhuanInt) {
				System.out.println("brick insufficient");
				// 返回brick insufficient页面。页面上做“如何获取金砖”连接
				request.setAttribute("result", "brick insufficient");
				return "../../ERROR/result";
			}

			// guest减去
			loginLingdan = (loginLingdanInt - lingdanInt) + "";
			loginJinzhuan = (loginJinzhuanInt - jinzhuanInt) + "";
			// owner加上 收取10%
			blogLingdan = (blogLingdanInt + (lingdanInt * 0.9)) + "";
			blogJinzhuan = (blogJinzhuanInt + (jinzhuanInt)) + "";
			//
			blogUser.setLingdan(blogLingdan);
			blogUser.setJinzhuan(blogJinzhuan);
			//
			loginUser.setLingdan(loginLingdan);
			loginUser.setJinzhuan(loginJinzhuan);
			//
			blogUser.setUserLevel(ScoreLevel.scoreLevel(blogJinzhuan));
			loginUser.setUserLevel(ScoreLevel.scoreLevel(loginJinzhuan));

			userInfoService.updateUserInfo(blogUser);
			userInfoService.updateUserInfo(loginUser);
			
			
		} catch (Exception e) {

			request.setAttribute("result", "unknown error ");
			return "../ERROR/result";
		}

		// 已购买此资源，将购买记录存入attachDownload，以供下次进入不在购买

		AttachDownload attachDownload = new AttachDownload();
		attachDownload.setAttachment(attachment);
		attachDownload.setTime(attachDownloadTime);
		attachDownload.setUserInfo(loginUser);

		attachDownloadService.saveAttachDownload(attachDownload);

		// 刷新attachment的下载记录

		// 判断今天是否访问过
		if (attachDownloadForVisited.size() < 1) {
			String downloadCount = attachment.getAttachDownload();
			int downloadCountInt = Integer.parseInt(downloadCount);
			downloadCountInt++;
			attachment.setAttachDownload(downloadCountInt + "");
			attachmentService.updateAttachment(attachment);

		}

		// 私信

		int newMsg = 0;
		if (loginUser != null) {

			String messageSql = "from Message where userInfo1.id = '"
					+ loginUser.getId() + "' and isRead = '0'";
			List<Message> messageList = messageService
					.listMessageBySql(messageSql);
			newMsg = messageList.size();
			// 更新session
			request.getSession().setAttribute("userInfo",
					this.userInfoService.findById(loginUser.getId()));
		}
		request.setAttribute("newMsgCount", newMsg);

		// 私信通知购买

		return "../detail";

	}

	/**
	 * 下载文件，用IO避免暴露文件真实地址
	 * 
	 * @author Robust
	 * 
	 * @date 2014年9月16日
	 * 
	 * @param request
	 * @param response
	 * @param userId
	 * @param attachId
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/downloadAttachment")
	public String downloadAttachment(HttpServletRequest request,
			HttpServletResponse response, String attachId) throws IOException {

		long id = Long.parseLong(attachId);

		String attachUrl = this.attachmentService.listAttachment(id)
				.getAttachUrl();
		/*
		 * System.out.println(attachUrl); return attachUrl;
		 */

		// 这里开始是下载的action设置
		response.setContentType("text/html;charset=utf-8");
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		}
		java.io.BufferedInputStream bis = null;
		java.io.BufferedOutputStream bos = null;

		String ctxPath = request.getSession().getServletContext()
				.getRealPath("/web/Blog/upload/");

		if (attachUrl.length() < 1) {
			request.setAttribute("result", "Download file not found");
			return "../ERROR/result";
		}

		String downLoadPath = ctxPath + "\\" + attachUrl.substring(16);
		downLoadPath = URLDecoder.decode(downLoadPath, "UTF-8");
		System.out.println(downLoadPath);
		// 文件下载
		try {
			File f = new File(downLoadPath);
			if (f.exists()) {
				long fileLength = new File(downLoadPath).length();
				response.setContentType("application/x-msdownload;");
				response.setHeader(
						"Content-disposition",
						"attachment; filename="
								+ new String(attachUrl.substring(16).getBytes(
										"utf-8"), "ISO8859-1"));
				response.setHeader("Content-Length", String.valueOf(fileLength));

				bis = new BufferedInputStream(new FileInputStream(downLoadPath));
				bos = new BufferedOutputStream(response.getOutputStream());
				byte[] buff = new byte[2048];
				int bytesRead;
				while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
					bos.write(buff, 0, bytesRead);
				}

			} else {
				request.setAttribute("result", "Download file not found");
				return "../ERROR/result";
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bis != null)
				bis.close();
			if (bos != null)
				bos.close();
		}

		return null;

	}

	// 一次下载后修改名字重新保存
	// 已放弃使用，代码没删留着备用
	/*
	 * @RequestMapping(value = "/renameAfterDownload") public @ResponseBody
	 * String renameAfterDownload(HttpServletRequest request,
	 * HttpServletResponse response, String userId, String attachId) {
	 * 
	 * long id = Long.parseLong(attachId);
	 * 
	 * String attachUrl = this.attachmentService.listAttachment(id)
	 * .getAttachUrl();
	 * 
	 * String realPath = request.getSession().getServletContext()
	 * .getRealPath("web/Blog/upload/");
	 * 
	 * //System.out.println(realPath+"\\"+attachUrl.substring(16)); String
	 * fullPath=realPath+attachUrl.substring(16);
	 * 
	 * //filetime SimpleDateFormat sdf = new
	 * SimpleDateFormat("yyyyMMddHHmmSSSS"); String fileTime = sdf.format(new
	 * Date());
	 * 
	 * //rename File f = new File(fullPath);
	 * 
	 * String c = f.getParent(); double beginIndex = attachUrl.lastIndexOf(".");
	 * String houzhuiming = attachUrl.substring(beginIndex, attachUrl.length());
	 * String newName =
	 * attachUrl.substring(0,beginIndex-16)+fileTime+houzhuiming;
	 * 
	 * //System.out.println(newName.substring(16));
	 * 
	 * 
	 * File mm = new File(c + File.pathSeparator + newName.substring(16)); if
	 * (f.renameTo(mm)) { System.out.println("修改成功!"); } else {
	 * System.out.println("修改失败"); } return null; }
	 */

	@RequestMapping(value = "xiugai.do")
	public String xiugai(HttpServletRequest request,
			HttpServletResponse response, String nickName) throws Exception {

		UserInfo blogUser = userInfoService.findUserByNickName(nickName).get(0);

		String blogName = request.getParameter("blogName");
		URLEncoder.encode(blogName, "UTF-8");

		System.out.println("----------------------------" + blogName
				+ "---------------------------");
		Blog blog = blogService.findBlogByUserInfo(blogUser).get(0);

		if (blogName.equals("")) {
			blog.setBlogName("BBS");
		} else
			blog.setBlogName(blogName);

		blogService.updateBlog(blog);
		return "redirect:/web/Blog/" + blogUser.getNickName();
	}

	// 私信后台取出收信人
	@RequestMapping(value = "receiver.do", method = RequestMethod.GET)
	public String receiver(HttpServletRequest request,
			HttpServletResponse reponse, long id) {

		UserInfo blogUser = userInfoService.findById(id);
		String receiver = blogUser.getNickName();
		request.setAttribute("receiver", receiver);

		// 私信
		UserInfo loginUser = (UserInfo) request.getSession().getAttribute(
				"userInfo");

		int newMsg = 0;
		if (loginUser != null) {
			loginUser = userInfoService.findById(loginUser.getId());
			String messageSql = "from Message where userInfo1.id = '"
					+ loginUser.getId() + "' and isRead = '0'";
			List<Message> messageList = messageService
					.listMessageBySql(messageSql);
			newMsg = messageList.size();
			// 更新session
			request.getSession().setAttribute("userInfo",
					this.userInfoService.findById(loginUser.getId()));
		}
		request.setAttribute("newMsgCount", newMsg);

		return "/web/PrivateMsg/sendPM";
	}

	// 仰慕鲜花Ajax后台
	@RequestMapping(value = "/blogYMXH")
	public @ResponseBody String blogYMXH(HttpServletRequest request,
			HttpServletResponse resp, String id, String marks) {

		long realId = Long.parseLong(id);
		int markcount = Integer.parseInt(marks);

		System.out
				.println("--------------------------------------------------------------");
		UserInfo userInfo = userInfoService.findById(realId);
		String lingdan = userInfo.getLingdan();
		double lingdInt = Double.parseDouble(lingdan);

		// 判断用户是否有灵丹支付
		if (lingdInt <= 0) {
			return "error";
		} else {
			switch (markcount) {
			case 1:
				String yangmu = userInfo.getYangmu();
				int yangmuCount = Integer.parseInt(yangmu);
				yangmuCount++;
				userInfo.setYangmu(yangmuCount + "");
				lingdInt--;
				userInfo.setLingdan(lingdInt + "");

				break;
			case 2:
				String xianhua = userInfo.getXianhua();
				int xianhuaCount = Integer.parseInt(xianhua);
				xianhuaCount++;
				userInfo.setXianhua(xianhuaCount + "");
				lingdInt--;
				userInfo.setLingdan(lingdInt + "");

				break;
			}

			userInfoService.updateUserInfo(userInfo);

			String count = null;
			switch (markcount) {
			case 1:
				String yangmu = userInfo.getYangmu();
				count = yangmu;

				break;
			case 2:
				String xianhua = userInfo.getXianhua();
				count = xianhua;

				break;
			}

			return count;
		}
	}

	// ---------------------------------------------个人主页查看更多----------------------------
	// 个人主页页面Blog查看更多
	@RequestMapping(value = "/index/moreLog.html", method = RequestMethod.GET)
	public String MoreLog(HttpServletRequest request, long blogId)
			throws Exception {
		// 分页
		int page = 1;

		try {
			page = Integer.parseInt(request.getParameter("page"));
		} catch (Exception e) {

		}
		if (page < 0) {
			page = 1;
		}

		String totalHql = "select count(*) from BlogLog where blogStatus.id='2' and blog.id = '"
				+ blogId + "'";
		int totalPage = blogLogService.listCount(totalHql);

		int pageSize = 6;
		// 最后一页
		int lastPage = 1;
		if (totalPage % pageSize == 0) {
			lastPage = totalPage / pageSize;
		} else
			lastPage = totalPage / pageSize + 1;

		if (page > lastPage) {
			page = lastPage;
		}

		request.setAttribute("lastPage", lastPage);
		request.setAttribute("page", page);

		// 当前页第一个的位置
		int firstSet = (page - 1) * pageSize;

		String hqlBlogdt = "from BlogLog where blogStatus.id='2' and blog.id = '"
				+ blogId + "' order by blogTime desc";

		List<BlogLog> blogdtArray = blogLogService.listBlogLogBySql(hqlBlogdt);
		List<BlogLog> blogdt = null;
		// 下方排序
		if (blogdtArray.size() > pageSize) {
			if ((firstSet + pageSize) < (totalPage - 1)) {
				blogdt = blogdtArray.subList(firstSet, firstSet + pageSize);
			} else {
				blogdt = blogdtArray.subList(firstSet, totalPage);
			}
		} else {
			blogdt = blogdtArray;
		}

		if (blogdt.size() != 0) {

			for (int i = 0; i < blogdt.size(); i++) {

				// 去掉HTML标签
				String logContent = HtmlSpecialChars.htmlspecialchars2(blogdt
						.get(i).getBlogContent());
				// 缩短字符
				if (logContent.length() > 100) {
					logContent = logContent.substring(0, 80);
				}

				blogdt.get(i).setBlogContent(logContent);

				// 标签
				List<BlogLabel> labelList = blogLabelService
						.listBlogLabelByLog(blogdt.get(i).getId());
				//
				String logLabel = labelList.get(0).getLabel().getLabelName();

				blogdt.get(i).setKeywordA(logLabel);
			}
		}
		request.setAttribute("blogdt", blogdt);

		// 活跃标签
		// String hotlabelSqlCount="";
		List<Label> labels = labelService.listLabel();

		for (int i = 0; i < labels.size(); i++) {
			String labelTotalHql = "select count(*) from BlogLabel where label.id='"
					+ labels.get(i).getId() + "'";
			String forumTotalHql = "select count(*) from ForumLabel where label.id='"
					+ labels.get(i).getId() + "'";
			String questionTotalHql = "select count(*) from QuestionLabel where label.id='"
					+ labels.get(i).getId() + "'";

			int blogLabelTotal = blogLabelService.listCount(labelTotalHql);
			int forumLabelTotal = blogLabelService.listCount(forumTotalHql);
			int questionLabelTotal = blogLabelService
					.listCount(questionTotalHql);

			int LabelTotal = blogLabelTotal + forumLabelTotal
					+ questionLabelTotal;
			labels.get(i).setLabelDesc(LabelTotal + "");

		}
		Collections.sort(labels, new LabelSorter());

		/*
		 * //如果要按照降序排列再加上这一行代码即可 Collections.reverse(list);
		 */
		Collections.reverse(labels);

		if (labels.size() > 5) {
			labels = labels.subList(0, 5);

		}
		request.setAttribute("hotLabels", labels);

		// 最多热门博主
		String blogMostVisitedSql = "from Blog order by visited+0 desc";
		List<Blog> blogMostVisited = blogService
				.listBlogBySql(blogMostVisitedSql);

		if (blogMostVisited.size() > 6) {

			blogMostVisited.subList(0, 7);
		}

		request.setAttribute("blogMostVisited", blogMostVisited);

		// 最多点赞博主
		String blogListSql = "from Blog order by blogUp+0 desc";
		List<Blog> blogMostUp = blogService.listBlogBySql(blogListSql);

		if (blogMostUp.size() > 6) {
			blogMostUp.subList(0, 7);
		}

		request.setAttribute("blogMostUp", blogMostUp);
		request.setAttribute("blogId", blogId);

		// 私信
		UserInfo loginUser = (UserInfo) request.getSession().getAttribute(
				"userInfo");

		int newMsg = 0;
		if (loginUser != null) {
			loginUser = userInfoService.findById(loginUser.getId());
			String messageSql = "from Message where userInfo1.id = '"
					+ loginUser.getId() + "' and isRead = '0'";
			List<Message> messageList = messageService
					.listMessageBySql(messageSql);
			newMsg = messageList.size();
			// 更新session
			request.getSession().setAttribute("userInfo",
					this.userInfoService.findById(loginUser.getId()));
		}
		request.setAttribute("newMsgCount", newMsg);

		return "/web/more/IndexMore_log";
	}

	// 个人主页页面的论坛查看更多
	@RequestMapping(value = "/index/morePost.html", method = RequestMethod.GET)
	public String MorePost(HttpServletRequest request, long blogId)
			throws Exception {

		// 分页
		int page = 1;

		try {
			page = Integer.parseInt(request.getParameter("page"));
		} catch (Exception e) {

		}
		if (page < 0) {
			page = 1;
		}

		String totalHql = "select count(*) from ForumPost where userInfo.id = '"
				+ blogId + "'";
		int totalPage = forum_postService.listCount(totalHql);

		int pageSize = 10;
		// 最后一页
		int lastPage = 1;
		if (totalPage % pageSize == 0) {
			lastPage = totalPage / pageSize;
		} else
			lastPage = totalPage / pageSize + 1;

		if (page > lastPage) {
			page = lastPage;
		}

		request.setAttribute("lastPage", lastPage);
		request.setAttribute("page", page);

		// 当前页第一个的位置
		int firstSet = (page - 1) * pageSize;

		String hqlPostdt = "from ForumPost where userInfo.id = '" + blogId
				+ "' order by postDate desc";

		List<ForumPost> postdtArray = forum_postService
				.listPostBySql(hqlPostdt);
		List<ForumPost> postdt = null;
		// 下方排序
		if (postdtArray.size() > pageSize) {
			if ((firstSet + pageSize) < (totalPage - 1)) {
				postdt = postdtArray.subList(firstSet, firstSet + pageSize);
			} else {
				postdt = postdtArray.subList(firstSet, totalPage);
			}
		} else {
			postdt = postdtArray;
		}

		if (postdt.size() != 0) {

			for (int i = 0; i < postdt.size(); i++) {

				// 去掉HTML标签
				String logContent = HtmlSpecialChars.htmlspecialchars2(postdt
						.get(i).getPostContent());
				// 缩短字符
				if (logContent.length() > 100) {
					logContent = logContent.substring(0, 80);
				}

				postdt.get(i).setPostContent(logContent);
			}
		}
		request.setAttribute("postdt", postdt);

		// 活跃标签
		// String hotlabelSqlCount="";
		List<Label> labels = labelService.listLabel();

		for (int i = 0; i < labels.size(); i++) {
			String labelTotalHql = "select count(*) from BlogLabel where label.id='"
					+ labels.get(i).getId() + "'";
			String forumTotalHql = "select count(*) from ForumLabel where label.id='"
					+ labels.get(i).getId() + "'";
			String questionTotalHql = "select count(*) from QuestionLabel where label.id='"
					+ labels.get(i).getId() + "'";

			int blogLabelTotal = blogLabelService.listCount(labelTotalHql);
			int forumLabelTotal = blogLabelService.listCount(forumTotalHql);
			int questionLabelTotal = blogLabelService
					.listCount(questionTotalHql);

			int LabelTotal = blogLabelTotal + forumLabelTotal
					+ questionLabelTotal;
			labels.get(i).setLabelDesc(LabelTotal + "");

		}
		Collections.sort(labels, new LabelSorter());

		/*
		 * //如果要按照降序排列再加上这一行代码即可 Collections.reverse(list);
		 */
		Collections.reverse(labels);

		if (labels.size() > 5) {
			labels = labels.subList(0, 5);

		}
		request.setAttribute("hotLabels", labels);

		// 最多热门博主
		String blogMostVisitedSql = "from Blog order by visited+0 desc";
		List<Blog> blogMostVisited = blogService
				.listBlogBySql(blogMostVisitedSql);

		if (blogMostVisited.size() > 6) {

			blogMostVisited.subList(0, 7);
		}

		request.setAttribute("blogMostVisited", blogMostVisited);

		// 最多点赞博主
		String blogListSql = "from Blog order by blogUp+0 desc";
		List<Blog> blogMostUp = blogService.listBlogBySql(blogListSql);

		if (blogMostUp.size() > 6) {
			blogMostUp.subList(0, 7);
		}

		request.setAttribute("blogMostUp", blogMostUp);
		request.setAttribute("blogId", blogId);

		// 私信
		UserInfo loginUser = (UserInfo) request.getSession().getAttribute(
				"userInfo");

		int newMsg = 0;
		if (loginUser != null) {
			loginUser = userInfoService.findById(loginUser.getId());
			String messageSql = "from Message where userInfo1.id = '"
					+ loginUser.getId() + "' and isRead = '0'";
			List<Message> messageList = messageService
					.listMessageBySql(messageSql);
			newMsg = messageList.size();
			// 更新session
			request.getSession().setAttribute("userInfo",
					this.userInfoService.findById(loginUser.getId()));
		}
		request.setAttribute("newMsgCount", newMsg);

		return "/web/more/IndexMore_post";
	}

	// 个人主页页面的问答查看更多
	@RequestMapping(value = "/index/moreQuestion.html", method = RequestMethod.GET)
	public String MoreQuestion(HttpServletRequest request, long blogId)
			throws Exception {

		// 分页
		int page = 1;

		try {
			page = Integer.parseInt(request.getParameter("page"));
		} catch (Exception e) {

		}
		if (page < 0) {
			page = 1;
		}

		String totalHql = "select count(*) from Question where userInfo.id = '"
				+ blogId + "'";
		int totalPage = questionService.listCount(totalHql);

		int pageSize = 10;
		// 最后一页
		int lastPage = 1;
		if (totalPage % pageSize == 0) {
			lastPage = totalPage / pageSize;
		} else
			lastPage = totalPage / pageSize + 1;

		if (page > lastPage) {
			page = lastPage;
		}

		request.setAttribute("lastPage", lastPage);
		request.setAttribute("page", page);

		// 当前页第一个的位置
		int firstSet = (page - 1) * pageSize;

		String hqlQuestiondt = "from Question where userInfo.id = '" + blogId
				+ "' order by qTime desc";

		List<Question> questiondtArray = questionService
				.listQuestionBySql(hqlQuestiondt);
		List<Question> questiondt = null;
		// 下方排序
		if (questiondtArray.size() > pageSize) {
			if ((firstSet + pageSize) < (totalPage - 1)) {
				questiondt = questiondtArray.subList(firstSet, firstSet
						+ pageSize);
			} else {
				questiondt = questiondtArray.subList(firstSet, totalPage);
			}
		} else {
			questiondt = questiondtArray;
		}

		if (questiondt.size() != 0) {

			for (int i = 0; i < questiondt.size(); i++) {

				// 去掉HTML标签
				String logContent = HtmlSpecialChars
						.htmlspecialchars2(questiondt.get(i).getQContent());
				// 缩短字符
				if (logContent.length() > 100) {
					logContent = logContent.substring(0, 80);
				}

				questiondt.get(i).setQContent(logContent);
			}
		}
		request.setAttribute("questiondt", questiondt);

		// 活跃标签
		// String hotlabelSqlCount="";
		List<Label> labels = labelService.listLabel();

		for (int i = 0; i < labels.size(); i++) {
			String labelTotalHql = "select count(*) from BlogLabel where label.id='"
					+ labels.get(i).getId() + "'";
			String forumTotalHql = "select count(*) from ForumLabel where label.id='"
					+ labels.get(i).getId() + "'";
			String questionTotalHql = "select count(*) from QuestionLabel where label.id='"
					+ labels.get(i).getId() + "'";

			int blogLabelTotal = blogLabelService.listCount(labelTotalHql);
			int forumLabelTotal = blogLabelService.listCount(forumTotalHql);
			int questionLabelTotal = blogLabelService
					.listCount(questionTotalHql);

			int LabelTotal = blogLabelTotal + forumLabelTotal
					+ questionLabelTotal;
			labels.get(i).setLabelDesc(LabelTotal + "");

		}
		Collections.sort(labels, new LabelSorter());

		/*
		 * //如果要按照降序排列再加上这一行代码即可 Collections.reverse(list);
		 */
		Collections.reverse(labels);

		if (labels.size() > 5) {
			labels = labels.subList(0, 5);

		}
		request.setAttribute("hotLabels", labels);

		// 最多热门博主
		String blogMostVisitedSql = "from Blog order by visited+0 desc";
		List<Blog> blogMostVisited = blogService
				.listBlogBySql(blogMostVisitedSql);

		if (blogMostVisited.size() > 6) {

			blogMostVisited.subList(0, 7);
		}

		request.setAttribute("blogMostVisited", blogMostVisited);

		// 最多点赞博主
		String blogListSql = "from Blog order by blogUp+0 desc";
		List<Blog> blogMostUp = blogService.listBlogBySql(blogListSql);

		if (blogMostUp.size() > 6) {
			blogMostUp.subList(0, 7);
		}

		request.setAttribute("blogMostUp", blogMostUp);
		request.setAttribute("blogId", blogId);

		// 私信
		UserInfo loginUser = (UserInfo) request.getSession().getAttribute(
				"userInfo");

		int newMsg = 0;
		if (loginUser != null) {
			loginUser = userInfoService.findById(loginUser.getId());
			String messageSql = "from Message where userInfo1.id = '"
					+ loginUser.getId() + "' and isRead = '0'";
			List<Message> messageList = messageService
					.listMessageBySql(messageSql);
			newMsg = messageList.size();
			// 更新session
			request.getSession().setAttribute("userInfo",
					this.userInfoService.findById(loginUser.getId()));
		}
		request.setAttribute("newMsgCount", newMsg);

		return "/web/more/IndexMore_question";
	}

	// =====================================静态方法==================================
	// doubel保留2位小数
	public static double get2Double(double a) {
		DecimalFormat df = new DecimalFormat("0.00");
		return new Double(df.format(a).toString());
	}

	// doubel保留2位小数
	public static double get1Double(double a) {
		DecimalFormat df = new DecimalFormat("0.0");
		return new Double(df.format(a).toString());
	}

	// 服务器时间
	public static String getNowTime() {
		Date date = new Date();
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowTime = f.format(date);

		return nowTime;
	}
}
