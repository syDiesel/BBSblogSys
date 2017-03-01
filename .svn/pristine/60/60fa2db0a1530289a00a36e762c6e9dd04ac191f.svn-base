package com.bbsBlog.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.bbsBlog.entity.BlogLog;
import com.bbsBlog.entity.ForumPost;
import com.bbsBlog.entity.Label;
import com.bbsBlog.entity.Message;
import com.bbsBlog.entity.Notice;
import com.bbsBlog.entity.Question;
import com.bbsBlog.entity.UserInfo;
import com.bbsBlog.service.BlogLabelService;
import com.bbsBlog.service.BlogLogService;
import com.bbsBlog.service.BoardService;
import com.bbsBlog.service.Forum_postService;
import com.bbsBlog.service.FriendService;
import com.bbsBlog.service.LabelService;
import com.bbsBlog.service.MessageService;
import com.bbsBlog.service.NoticeService;
import com.bbsBlog.service.QuestionService;
import com.bbsBlog.service.UserInfoService;
import com.bbsBlog.util.LabelSorter;
import com.bbsBlog.util.PageModel;

@Controller
public class homeController {

	@Resource
	private UserInfoService userInfoService;

	@Resource
	private NoticeService noticeService;

	@Resource
	private BoardService boardService;

	@Resource
	private BlogLogService blogLogService;

	@Resource
	private Forum_postService forumPostService;

	@Resource
	private QuestionService questionService;

	@Resource
	private FriendService friendService;
	@Resource
	private LabelService labelService;

	@Resource
	private BlogLabelService blogLabelService;

	@Resource
	private MessageService messageService;

	@RequestMapping(value = "toIndexHome")
	public String toIndexHome(HttpServletRequest request,
			HttpServletResponse response) {
		
		long pre=System.currentTimeMillis();
		// 公告栏
		List<Notice> listNotice = this.noticeService.listNotice();
		request.setAttribute("listNotice", listNotice);


		String listVUserSql = "from UserInfo order by userLevel+0 desc";
		List<UserInfo> listVUser = userInfoService.listUserBySql(listVUserSql);
		
		if (listVUser.size() > 0) {
			request.setAttribute("listVUser", listVUser);
		}
		// 新会员
		List<UserInfo> listNewUser = this.userInfoService.listUserByRegister();
		if (listNewUser.size() > 0)
			request.setAttribute("listNewUser", listNewUser);

		// 最新博文
		List<BlogLog> listBlog = this.blogLogService.listBlogLog();
		if (listBlog.size() > 16)
			listBlog = listBlog.subList(0, 16);
		if (listBlog.size() > 0)
			request.setAttribute("listBlog", listBlog);
		// 最新话题
		String sql="from ForumPost f where (f.postStatus.id=4 or f.postStatus.id=5) " +
				"order by f.postDate desc";
		List<ForumPost> listForum = this.forumPostService.listPostBySql(sql);
		if (listForum.size() > 8)
			listForum = listForum.subList(0, 8);
		if (listForum.size() > 0)
			request.setAttribute("listForum", listForum);
		// 最新问答
		List<Question> listQuestion = this.questionService.listQuestion();
		if (listQuestion.size() > 12)
			listQuestion = listQuestion.subList(0, 12);
		if (listQuestion.size() != 0)

			request.setAttribute("listQuestion", listQuestion);

		// lzw 20141105
		// 权威回答，按照personInfo里面的questionUp排序
		String quanweiUserSql = "from UserInfo order by quizzerUp+0 asc";
		List<UserInfo> quanweiUser = userInfoService
				.listUserBySql(quanweiUserSql);

		if (quanweiUser.size() > 3) {
			quanweiUser = quanweiUser.subList(0, 3);
		}

		request.setAttribute("quanweiUser", quanweiUser);

		// 热门标签排序

		long biaoqianqian= System.currentTimeMillis();
		
		 String hotlabelSql="from Label l order by (l.forumCount+l.blogCount+l.questionCount) desc";
		 List<Label> labels=this.labelService.listLabelBySql(hotlabelSql);
		/*List<Label> labels = labelService.listLabel();

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

			// labels.get(i).setLabelDesc(Math.floor(i+Math.random()*10)+"");

			// System.out.println(labels.get(i).getLabelName()+"===="+labels.get(i).getLabelDesc());
		}
		Collections.sort(labels, new LabelSorter());

		
		 * //如果要按照降序排列再加上这一行代码即可 Collections.reverse(list);
		 
		Collections.reverse(labels);*/

		if (labels.size() > 8) {
			labels = labels.subList(0, 8);

		}
		request.setAttribute("hotLabels", labels);

		long biaoqianhou= System.currentTimeMillis();
		
		// 公告
		Notice notice = new Notice();
		List<Notice> noticeList = noticeService.listNotice();
		if (noticeList.size() > 0) {
			notice = noticeList.get(0);

		} else {
			notice.setNoticeContent(null);
		}
		request.setAttribute("notice", notice);

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
			//更新session
			request.getSession().setAttribute("userInfo",this.userInfoService.findById(loginUser.getId()));
		}
		request.setAttribute("newMsgCount", newMsg);

		
		long post=System.currentTimeMillis();
		
		
		
		System.out.print((post-pre)+":"+(biaoqianqian-pre)+":"+(biaoqianhou-biaoqianqian)+":"+(post-biaoqianhou));
		
		return "web/Index/index";

	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "listQuestionMore.do")
	public String listQuestionMore(HttpServletRequest request,
			HttpServletResponse response, long board_id, int record) {

		List<Question> Question = this.questionService
				.listQuestionByBoard(board_id);

		// 开始分页
		int pageRecords = 10; // 每页显示的记录数,这个可以自己设定
		int allRecords = Question.size(); // 总的记录
		int allPage = (allRecords - 1) / pageRecords + 1; // 总页数

		PageModel pages = new PageModel();

		Question = pages.fenYe(Question, pageRecords, record, allPage,
				allRecords);// 调用Pages的方法，进行分页
		request.setAttribute("record", record);// 当前页
		request.setAttribute("pageRecords", pageRecords);// 每页显示的记录数
		request.setAttribute("allPage", allPage);// 总的页数
		request.setAttribute("Question", Question);
		request.setAttribute("board_id", board_id);

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
			//更新session
			request.getSession().setAttribute("userInfo",this.userInfoService.findById(loginUser.getId()));
		}
		request.setAttribute("newMsgCount", newMsg);

		
		return "web/Index/listQuestion";

	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "listUserMore.do")
	public String listUserMore(HttpServletRequest request,
			HttpServletResponse response, long board_id, int record) {

		List user_ids = new ArrayList();
		user_ids = this.userInfoService.listUserByBoardWealth(board_id);
		List<UserInfo> listUser = new ArrayList<UserInfo>();
		for (int m = 0; m < user_ids.size(); m++) {
			listUser.add(this.userInfoService.findById((Long) user_ids.get(m)));
		}

		// 开始分页
		int pageRecords = 12; // 每页显示的记录数,这个可以自己设定
		int allRecords = listUser.size(); // 总的记录
		int allPage = (allRecords - 1) / pageRecords + 1; // 总页数

		PageModel pages = new PageModel();

		listUser = pages.fenYe(listUser, pageRecords, record, allPage,
				allRecords);// 调用Pages的方法，进行分页
		request.setAttribute("record", record);// 当前页
		request.setAttribute("pageRecords", pageRecords);// 每页显示的记录数
		request.setAttribute("allPage", allPage);// 总的页数

		request.setAttribute("listUser", listUser);
		request.setAttribute("board_id", board_id);

		
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
			//更新session
			request.getSession().setAttribute("userInfo",this.userInfoService.findById(loginUser.getId()));
		}
		request.setAttribute("newMsgCount", newMsg);

		return "web/Index/listUser";

	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "listBlogMore.do")
	public String listBlogMore(HttpServletRequest request,
			HttpServletResponse response, long board_id, int record) {

		List<BlogLog> BlogLog = this.blogLogService.listBlogByBoard(board_id);

		// 开始分页
		int pageRecords = 10; // 每页显示的记录数,这个可以自己设定
		int allRecords = BlogLog.size(); // 总的记录
		int allPage = (allRecords - 1) / pageRecords + 1; // 总页数

		PageModel pages = new PageModel();

		BlogLog = pages
				.fenYe(BlogLog, pageRecords, record, allPage, allRecords);// 调用Pages的方法，进行分页
		request.setAttribute("record", record);// 当前页
		request.setAttribute("pageRecords", pageRecords);// 每页显示的记录数
		request.setAttribute("allPage", allPage);// 总的页数
		request.setAttribute("BlogLog", BlogLog);
		request.setAttribute("board_id", board_id);

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
			//更新session
			request.getSession().setAttribute("userInfo",this.userInfoService.findById(loginUser.getId()));
		}
		request.setAttribute("newMsgCount", newMsg);

		
		
		return "web/Index/listBlog";

	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "listForumMore.do")
	public String listForumMore(HttpServletRequest request,
			HttpServletResponse response, long board_id, int record) {

		List<ForumPost> listForum = this.forumPostService
				.listForum_postByPostCount(board_id);

		// 开始分页
		int pageRecords = 10; // 每页显示的记录数,这个可以自己设定
		int allRecords = listForum.size(); // 总的记录
		int allPage = (allRecords - 1) / pageRecords + 1; // 总页数

		PageModel pages = new PageModel();

		listForum = pages.fenYe(listForum, pageRecords, record, allPage,
				allRecords);// 调用Pages的方法，进行分页
		request.setAttribute("record", record);// 当前页
		request.setAttribute("pageRecords", pageRecords);// 每页显示的记录数
		request.setAttribute("allPage", allPage);// 总的页数
		request.setAttribute("listForum", listForum);
		request.setAttribute("board_id", board_id);

		
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
			//更新session
			request.getSession().setAttribute("userInfo",this.userInfoService.findById(loginUser.getId()));
		}
		request.setAttribute("newMsgCount", newMsg);

		
		
		
		return "web/Index/listForum";

	}

	@RequestMapping(value = "/toManagement")
	public String toManagement(HttpServletRequest request) {
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
			return "redirect:login.html";
		}

		else if (loginUser.getRole().getId() != 1) {
			return "toIndexHome";
		}

		return "/web/management/main";
	}

	@RequestMapping(value = "/toBuilding")
	public String toBuilding(HttpServletRequest request) {
		UserInfo loginUser = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		// 查看是否登录

		
		// 私信
	
		int newMsg = 0;
		if (loginUser != null) {

			String messageSql = "from Message where userInfo1.id = '"
					+ loginUser.getId() + "' and isRead = '0'";
			List<Message> messageList = messageService
					.listMessageBySql(messageSql);
			newMsg = messageList.size();
			//更新session
			request.getSession().setAttribute("userInfo",this.userInfoService.findById(loginUser.getId()));
		}
		request.setAttribute("newMsgCount", newMsg);

		
		
		return "web/ERROR/building";
	}

	// 常见问题跳转
	@RequestMapping(value = "faq.do")
	public String faq(HttpServletRequest request) {
		String languageLocale = " ";
		if (request.getSession().getAttribute(
				SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME) != null) {
			languageLocale = request
					.getSession()
					.getAttribute(
							SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME)
					.toString();
			// System.out.println("languageLocale1"+request.getSession().getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME));
			// System.out.println(languageLocale);
		}
		
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
			//更新session
			request.getSession().setAttribute("userInfo",this.userInfoService.findById(loginUser.getId()));
		}
		request.setAttribute("newMsgCount", newMsg);

		
		
		if (languageLocale.equalsIgnoreCase("en_Us")) {
			return "web/user/FAQ-en";
		} else if (languageLocale.equalsIgnoreCase("zh_TW")) {
			return "web/user/FAQ-tw";
		} else
			// System.out.println("languageLocale2"+request.getSession().getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME));

			
			
			
			
			return "/web/user/FAQ-en";
	}


	// 查看更多
	@RequestMapping(value = "/indexHome/more.html")
	public String more(HttpServletRequest request, String type) {

		
		
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
			//更新session
			request.getSession().setAttribute("userInfo",this.userInfoService.findById(loginUser.getId()));
		}
		request.setAttribute("newMsgCount", newMsg);
		
		
		
		int typeInt = Integer.parseInt(type);

		
		
		
		
		switch (typeInt) {
		case 3:
			// 最新话题
			String postCountHql = "select count(*) from ForumPost";
			String hqlPostByTime = "from ForumPost order by postDate desc";
			PageModel postByTime = forumPostService.listPostBySQL(0, 10,
					postCountHql, hqlPostByTime);
			request.setAttribute("pm", postByTime);
			return "/web/more/postMore";
		case 5:
			// 最新回答
			String questionCountHql = "select count(*) from Question";
			String hqlQuestionByTime = "from Question order by qTime desc";
			PageModel questionByTime = forumPostService.listPostBySQL(0, 10,
					questionCountHql, hqlQuestionByTime);
			request.setAttribute("pm", questionByTime);
			return "/web/more/questionMore";
		}

		return null;
	}

	// ==========================静态方法===============
	// labelSort
	
	
	//刷Label中的forumCount,blogCount,questionCount

	@RequestMapping(value = "/updateLabelCount")
	public String updateLabelCount(HttpServletRequest request) {
		List<Label> listLabel=this.labelService.listLabel();
		System.out.println("-------------------updateLabelCount----------------");
		for(int i=0;i<listLabel.size();i++)
		{
			String forumSql="select count(*) from ForumLabel where label.id='"
					+ listLabel.get(i).getId() + "'";
			int forumCount=this.forumPostService.listCount(forumSql);
			listLabel.get(i).setForumCount(forumCount);
			
			String blogSql="select count(*) from BlogLabel where label.id='"
					+ listLabel.get(i).getId() + "'";
			int blogCount=this.blogLabelService.listCount(blogSql);
			listLabel.get(i).setBlogCount(blogCount);
			
			String questionSql="select count(*) from QuestionLabel where label.id='"
					+ listLabel.get(i).getId() + "'";
			int questionCount=this.questionService.listCount(questionSql);
			listLabel.get(i).setQuestionCount(questionCount);
			
			this.labelService.updateLabel(listLabel.get(i));
		}
		return "redirect:/toIndexHome";
		
	}
	

}
