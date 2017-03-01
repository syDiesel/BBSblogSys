package com.bbsBlog.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bbsBlog.entity.Answer;
import com.bbsBlog.entity.Attachment;
import com.bbsBlog.entity.Audit;
import com.bbsBlog.entity.BlogLog;
import com.bbsBlog.entity.Favorite;
import com.bbsBlog.entity.ForumPost;
import com.bbsBlog.entity.ForumReply;
import com.bbsBlog.entity.Friend;
import com.bbsBlog.entity.Message;
import com.bbsBlog.entity.QAConcern;
import com.bbsBlog.entity.QAFavor;
import com.bbsBlog.entity.Question;
import com.bbsBlog.entity.UserInfo;
import com.bbsBlog.service.AnswerService;
import com.bbsBlog.service.AttachmentService;
import com.bbsBlog.service.AuditService;
import com.bbsBlog.service.BlogLogService;
import com.bbsBlog.service.FavoriteService;
import com.bbsBlog.service.Forum_postService;
import com.bbsBlog.service.Forum_replyService;
import com.bbsBlog.service.FriendService;
import com.bbsBlog.service.MessageService;
import com.bbsBlog.service.QuestionService;
import com.bbsBlog.service.UserInfoService;
import com.bbsBlog.serviceImpl.QAConcernServiceImpl;
import com.bbsBlog.serviceImpl.QAFavorServiceImpl;
import com.bbsBlog.util.Fenye;
import com.bbsBlog.util.HtmlSpecialChars;

@Controller
public class PersonalController {
	@Resource
	private UserInfoService userInfoService;

	@Resource
	private FriendService friendService;

	@Resource
	private AuditService auditService;

	@Resource
	private AnswerService answerService;

	@Resource
	private Forum_replyService forumReplyService;

	@Resource
	private BlogLogService blogLogService;

	@Resource
	private Forum_postService forum_postService;

	@Resource
	private QuestionService questionService;

	@Resource
	private FavoriteService favoriteService;

	@Resource
	private AttachmentService attachmentService;

	@Resource
	private MessageService messageService;

	@Resource
	private QAFavorServiceImpl qAFavorServiceImpl;
	
	@Resource
	private  QAConcernServiceImpl qAConcernServiceImpl;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/auditShow/{id}.html")
	public String AuditShow(HttpServletRequest request,
			HttpServletResponse response, @PathVariable long id) {

		UserInfo blogUser = this.userInfoService.findById(id);

		String value = "1";

		try {

			value = request.getParameter("value");
		} catch (Exception e) {

		}
		request.setAttribute("value", value);
		// ----------------------关注的人------------------------------------------------------------------
		// 关注的人
		List<Friend> listConcern = friendService.listFriendById(id);
		List<Friend> item1 = null;
		// 分页
		int page1 = 1;
		int totalPage1 = listConcern.size();
		try {
			page1 = Integer.parseInt(request.getParameter("page1"));
		} catch (Exception e) {
			page1 = 1;
		}
		int pageSize1 = 21;
		// 最后一页
		int lastPage1 = Fenye.lastPage(totalPage1, page1, pageSize1);

		request.setAttribute("lastPage1", lastPage1);
		request.setAttribute("page1", page1);

		// 当前页第一个的位置
		item1 = Fenye.fenye(listConcern, totalPage1, page1, pageSize1,
				lastPage1);
		request.setAttribute("listConcern", item1);

		// --------------------------关注人的动态--------------------------------------------------------------
		// 关注人的动态
		List<Audit> list_conAudit = new ArrayList<Audit>();
		for (Friend f : listConcern) {

			List<Audit> list = auditService.listAuditByUserInfo(f
					.getUserInfo1().getId());
			list_conAudit.addAll(list);
		}

		// 时间排序
		Collections.sort(list_conAudit, new Comparator<Audit>() {
			public int compare(Audit o1, Audit o2) {
				// TODO Auto-generated method stub
				return o2.getAuditTime().compareTo(o1.getAuditTime());
			}

		});

		List<Audit> item2 = null;
		// 分页
		int page2 = 1;
		int totalPage2 = list_conAudit.size();
		try {
			page2 = Integer.parseInt(request.getParameter("page2"));
		} catch (Exception e) {
			page2 = 1;
		}
		int pageSize2 = 9;
		// 最后一页
		int lastPage2 = Fenye.lastPage(totalPage2, page2, pageSize2);

		request.setAttribute("lastPage2", lastPage2);
		request.setAttribute("page2", page2);

		// 当前页第一个的位置
		item2 = Fenye.fenye(list_conAudit, totalPage2, page2, pageSize2,
				lastPage2);
		request.setAttribute("list_conAudit", item2);

		// --------------------------好友--------------------------------------------------------------
		// 好友
		List<UserInfo> listFriend = new ArrayList<UserInfo>();
		for (Friend f : listConcern) {

			boolean flag = friendService.isFriend(f.getUserInfo1().getId(), id);
			if (flag) {
				listFriend.add(f.getUserInfo1());
			}
		}

		List<UserInfo> item3 = null;
		// 分页
		int page3 = 1;
		int totalPage3 = listFriend.size();
		try {
			page3 = Integer.parseInt(request.getParameter("page3"));
		} catch (Exception e) {
			page3 = 1;
		}
		int pageSize3 = 21;
		// 最后一页
		int lastPage3 = Fenye.lastPage(totalPage3, page3, pageSize3);

		request.setAttribute("lastPage3", lastPage3);
		request.setAttribute("page3", page3);

		// 当前页第一个的位置
		item3 = Fenye
				.fenye(listFriend, totalPage3, page3, pageSize3, lastPage3);
		request.setAttribute("listFriend", item3);
		// -----------------------好友动态-----------------------------------------------------------------
		// 好友动态
		List<Audit> list_friAudit = new ArrayList<Audit>();
		for (UserInfo u : listFriend) {

			List<Audit> list = auditService.listAuditByUserInfo(u.getId());
			list_friAudit.addAll(list);
		}
		// 时间排序
		Collections.sort(list_friAudit, new Comparator<Audit>() {
			public int compare(Audit o1, Audit o2) {
				// TODO Auto-generated method stub
				return o2.getAuditTime().compareTo(o1.getAuditTime());
			}

		});
		List<Audit> item4 = null;
		// 分页
		int page4 = 1;
		int totalPage4 = list_friAudit.size();
		try {
			page4 = Integer.parseInt(request.getParameter("page4"));
		} catch (Exception e) {
			page4 = 1;
		}
		int pageSize4 = 9;
		// 最后一页
		int lastPage4 = Fenye.lastPage(totalPage4, page4, pageSize4);

		request.setAttribute("lastPage4", lastPage4);
		request.setAttribute("page4", page4);

		// 当前页第一个的位置
		item4 = Fenye.fenye(list_friAudit, totalPage4, page4, pageSize4,
				lastPage4);
		request.setAttribute("list_friAudit", item4);
		// ---------------------------他回答的问题-------------------------------------------------------------
		// 他回答的问题
		String sql = "from Answer a where a.userInfo.id = '" + id
				+ "' order by aTime desc";
		List<Answer> listAnswer = answerService.listAnswerBySql(sql);

		List<Answer> item5 = null;
		// 分页
		int page5 = 1;
		int totalPage5 = listAnswer.size();
		try {
			page5 = Integer.parseInt(request.getParameter("page5"));
		} catch (Exception e) {
			page5 = 1;
		}
		int pageSize5 = 9;
		// 最后一页
		int lastPage5 = Fenye.lastPage(totalPage5, page5, pageSize5);

		request.setAttribute("lastPage5", lastPage5);
		request.setAttribute("page5", page5);

		// 当前页第一个的位置
		item5 = Fenye
				.fenye(listAnswer, totalPage5, page5, pageSize5, lastPage5);
		request.setAttribute("listAnswer", item5);
		// ----------------------------他评论过的话题------------------------------------------------------------
		// 他评论过的话题
		String sql_ = "from ForumReply reply where reply.userInfo.id = '" + id
				+ "' order by replyTime desc";
		List<ForumReply> listReply = forumReplyService.listReplyBySql(sql_);

		List<ForumReply> item6 = null;
		// 分页
		int page6 = 1;
		int totalPage6 = listReply.size();
		try {
			page6 = Integer.parseInt(request.getParameter("page6"));
		} catch (Exception e) {
			page6 = 1;
		}
		int pageSize6 = 9;
		// 最后一页
		int lastPage6 = Fenye.lastPage(totalPage6, page6, pageSize6);

		request.setAttribute("lastPage6", lastPage6);
		request.setAttribute("page6", page6);

		// 当前页第一个的位置
		item6 = Fenye.fenye(listReply, totalPage6, page6, pageSize6, lastPage6);
		request.setAttribute("listReply", item6);

		request.setAttribute("blogUser", blogUser);

		// 私信

		int newMsg = 0;
		UserInfo loginUser = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		if (loginUser != null) {

			String messageSql = "from Message where userInfo1.id = '"
					+ loginUser.getId() + "' and isRead = '0'";
			List<Message> messageList = messageService
					.listMessageBySql(messageSql);
			newMsg = messageList.size();
			// 更新session
			request.getSession().setAttribute("userInfo",this.userInfoService.findById(loginUser.getId()));

			// 判断登陆者与博主是不是好友
			boolean isFriend = this.friendService.isFriend(loginUser.getId(),
					blogUser.getId());
			request.setAttribute("isFriend", isFriend);
		}
		request.setAttribute("newMsgCount", newMsg);

		return "/web/PersonalInfo/personalAudit";
	}

	// 博文more
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/blogMore/{id}.html")
	public String BlogMore(HttpServletRequest request,
			HttpServletResponse response, @PathVariable long id) {

		UserInfo blogUser = this.userInfoService.findById(id);
		UserInfo loginUser = (UserInfo) request.getSession().getAttribute(
				"userInfo");

		String blogLogByTimeSql = null;
		if (loginUser != null) {
			if (loginUser.getId() != blogUser.getId())
				blogLogByTimeSql = "from BlogLog where blogStatus.id='2' and blog.id='"
						+ blogUser.getId() + "' order by blogTime desc ";
			else
				blogLogByTimeSql = "from BlogLog where blog.id='"
						+ blogUser.getId() + "' order by blogTime desc ";

		} else
			blogLogByTimeSql = "from BlogLog where blogStatus.id='2' and blog.id='"
					+ blogUser.getId() + "' order by blogTime desc ";

		List<BlogLog> blogLogByTime = blogLogService
				.listBlogLogBySql(blogLogByTimeSql);

		List<BlogLog> item = null;
		// 分页
		int page = 1;
		int totalPage = blogLogByTime.size();
		try {
			page = Integer.parseInt(request.getParameter("page"));
		} catch (Exception e) {
			page = 1;
		}
		int pageSize = 15;
		// 最后一页
		int lastPage = Fenye.lastPage(totalPage, page, pageSize);

		request.setAttribute("lastPage", lastPage);
		request.setAttribute("page", page);

		// 当前页第一个的位置
		item = Fenye.fenye(blogLogByTime, totalPage, page, pageSize, lastPage);

		request.setAttribute("blogLogByTime", item);
		request.setAttribute("blogUser", blogUser);

		// 私信

		int newMsg = 0;
		if (loginUser != null) {

			String messageSql = "from Message where userInfo1.id = '"
					+ loginUser.getId() + "' and isRead = '0'";
			List<Message> messageList = messageService
					.listMessageBySql(messageSql);
			newMsg = messageList.size();
			// 更新session
			request.getSession().setAttribute("userInfo",this.userInfoService.findById(loginUser.getId()));

			// 判断登陆者与博主是不是好友
			boolean isFriend = this.friendService.isFriend(loginUser.getId(),
					blogUser.getId());
			request.setAttribute("isFriend", isFriend);
		}
		request.setAttribute("newMsgCount", newMsg);

		return "/web/PersonalInfo/personalBlog";
	}

	// 论坛more
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/forumMore/{id}.html")
	public String ForumMore(HttpServletRequest request,
			HttpServletResponse response, @PathVariable long id) {

		UserInfo blogUser = this.userInfoService.findById(id);
		UserInfo loginUser = (UserInfo) request.getSession().getAttribute(
				"userInfo");

		String forumByTimeSql = null;
		if (loginUser != null) {
			if (loginUser.getId() != blogUser.getId())
				forumByTimeSql = "from ForumPost where (postStatus = 4 or postStatus = 5) and userInfo.id='"
						+ blogUser.getId() + "' order by postDate desc ";
			else
				forumByTimeSql = "from ForumPost where userInfo.id='"
						+ blogUser.getId() + "' order by postDate desc ";
		} else
			forumByTimeSql = "from ForumPost where (postStatus = 4 or postStatus = 5) and userInfo.id='"
					+ blogUser.getId() + "' order by postDate desc ";

		List<ForumPost> forumByTime = forum_postService
				.listPostBySql(forumByTimeSql);

		List<ForumPost> item = null;
		// 分页
		int page = 1;
		int totalPage = forumByTime.size();
		try {
			page = Integer.parseInt(request.getParameter("page"));
		} catch (Exception e) {
			page = 1;
		}
		int pageSize = 15;
		// 最后一页
		int lastPage = Fenye.lastPage(totalPage, page, pageSize);

		request.setAttribute("lastPage", lastPage);
		request.setAttribute("page", page);

		// 当前页第一个的位置
		item = Fenye.fenye(forumByTime, totalPage, page, pageSize, lastPage);

		request.setAttribute("forumByTime", item);
		request.setAttribute("blogUser", blogUser);

		// 私信

		int newMsg = 0;
		if (loginUser != null) {

			String messageSql = "from Message where userInfo1.id = '"
					+ loginUser.getId() + "' and isRead = '0'";
			List<Message> messageList = messageService
					.listMessageBySql(messageSql);
			newMsg = messageList.size();
			// 更新session
			request.getSession().setAttribute("userInfo",this.userInfoService.findById(loginUser.getId()));

			// 判断登陆者与博主是不是好友
			boolean isFriend = this.friendService.isFriend(loginUser.getId(),
					blogUser.getId());
			request.setAttribute("isFriend", isFriend);
		}
		request.setAttribute("newMsgCount", newMsg);

		return "/web/PersonalInfo/personalForum";
	}

	// 问答
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/questionMore/{id}.html")
	public String QuestionMore(HttpServletRequest request,
			HttpServletResponse response, @PathVariable long id) {

		UserInfo blogUser = this.userInfoService.findById(id);

		String questionByTimeSql = "from Question where userInfo.id='"
				+ blogUser.getId() + "' order by qTime desc ";
		List<Question> questionByTime = questionService
				.listQuestionBySql(questionByTimeSql);

		List<Question> item = null;
		// 分页
		int page = 1;
		int totalPage = questionByTime.size();
		try {
			page = Integer.parseInt(request.getParameter("page"));
		} catch (Exception e) {
			page = 1;
		}
		int pageSize = 15;
		// 最后一页
		int lastPage = Fenye.lastPage(totalPage, page, pageSize);

		request.setAttribute("lastPage", lastPage);
		request.setAttribute("page", page);

		// 当前页第一个的位置
		item = Fenye.fenye(questionByTime, totalPage, page, pageSize, lastPage);

		request.setAttribute("questionByTime", item);
		request.setAttribute("blogUser", blogUser);

		// 私信

		int newMsg = 0;
		UserInfo loginUser = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		if (loginUser != null) {

			String messageSql = "from Message where userInfo1.id = '"
					+ loginUser.getId() + "' and isRead = '0'";
			List<Message> messageList = messageService
					.listMessageBySql(messageSql);
			newMsg = messageList.size();
			// 更新session
			request.getSession().setAttribute("userInfo",this.userInfoService.findById(loginUser.getId()));

			// 判断登陆者与博主是不是好友
			boolean isFriend = this.friendService.isFriend(loginUser.getId(),
					blogUser.getId());
			request.setAttribute("isFriend", isFriend);
		}
		request.setAttribute("newMsgCount", newMsg);

		return "/web/PersonalInfo/personalQuestion";
	}

	// 收藏
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/collectMore/{id}.html")
	public String CollectMore(HttpServletRequest request,
			HttpServletResponse response, @PathVariable long id) {

		UserInfo loginUser = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		UserInfo blogUser = this.userInfoService.findById(id);
		request.setAttribute("blogUser", blogUser);

		int newMsg = 0;

		if (loginUser != null) {

			String messageSql = "from Message where userInfo1.id = '"
					+ loginUser.getId() + "' and isRead = '0'";
			List<Message> messageList = messageService
					.listMessageBySql(messageSql);
			newMsg = messageList.size();
			// 更新session
			request.getSession().setAttribute("userInfo",this.userInfoService.findById(loginUser.getId()));

			// 判断登陆者与博主是不是好友
			boolean isFriend = this.friendService.isFriend(loginUser.getId(),
					blogUser.getId());
			request.setAttribute("isFriend", isFriend);
		}
		request.setAttribute("newMsgCount", newMsg);
		
		
		String value_collect = "0";

		try {

			value_collect = request.getParameter("value_collect");
		} catch (Exception e) {

		}
		request.setAttribute("value_collect", value_collect);

		// -------------------------------------博客收藏---------------------------------------
		String favHql = "from Favorite where userInfo.id = '"
				+ blogUser.getId() + "' order by time desc";
		List<Favorite> fav = favoriteService.listFavoriteBySql(favHql);

		for (int i = 0; i < fav.size(); i++) {
			int favCount = blogLogService
					.listCount("select count(*) from Favorite where blogUrl = '"
							+ fav.get(i).getBlogUrl() + "'");

			fav.get(i).setId(favCount);

		}

		List<Favorite> item = null;
		// 分页
		int page = 1;
		int totalPage = fav.size();
		try {
			page = Integer.parseInt(request.getParameter("page"));
		} catch (Exception e) {
			page = 1;
		}
		int pageSize = 15;
		// 最后一页
		int lastPage = Fenye.lastPage(totalPage, page, pageSize);

		request.setAttribute("lastPage", lastPage);
		request.setAttribute("page", page);

		// 当前页第一个的位置
		item = Fenye.fenye(fav, totalPage, page, pageSize, lastPage);
		request.setAttribute("fav", item);

		// -------------------------------------问答收藏---------------------------------------
        String qSql = "from QAConcern where userInfo.id = '"+blogUser.getId()+"' order by time desc";
        List<QAConcern> listQAConcern = qAConcernServiceImpl.listQAConcernsBySql(qSql);
        for (int i = 0; i < listQAConcern.size(); i++) {
			int qFavorCount = qAFavorServiceImpl
					.listCount("select count(*) from QAConcern where question.id = '"
							+ listQAConcern.get(i).getQuestion().getId() + "'");

			listQAConcern.get(i).setId(qFavorCount);
 
		}
        
        List<QAFavor> item1 = null;
		// 分页
		int page1 = 1;
		int totalPage1 = listQAConcern.size();
		try {
			page1 = Integer.parseInt(request.getParameter("page1"));
		} catch (Exception e) {
			page1 = 1;
		}
		int pageSize1 = 15;
		// 最后一页
		int lastPage1 = Fenye.lastPage(totalPage1, page1, pageSize1);

		request.setAttribute("lastPage1", lastPage1);
		request.setAttribute("page1", page1);

		// 当前页第一个的位置
		item1 = Fenye.fenye(listQAConcern, totalPage1, page1, pageSize1, lastPage1);
		request.setAttribute("listQAFavor", item1);

		
		return "/web/PersonalInfo/personalCollect";
	}

	// 资源分享
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/attachMore/{id}.html")
	public String AttachMore(HttpServletRequest request,
			HttpServletResponse response, @PathVariable long id) {

		UserInfo blogUser = this.userInfoService.findById(id);

		String attachByTimeSql = "from Attachment where userInfo.id='"
				+ blogUser.getId() + "' order by attachTime desc ";
		List<Attachment> attachByTime = attachmentService
				.listAttachBySql(attachByTimeSql);

		if (attachByTime.size() > 0) {
			for (int i = 0; i < attachByTime.size(); i++) {
				String attachDescNoHtml = HtmlSpecialChars
						.htmlspecialchars2(attachByTime.get(i).getAttachDesc());
				attachByTime.get(i).setAttachDesc(attachDescNoHtml);
			}
		}

		List<Attachment> item = null;
		// 分页
		int page = 1;
		int totalPage = attachByTime.size();
		try {
			page = Integer.parseInt(request.getParameter("page"));
		} catch (Exception e) {
			page = 1;
		}
		int pageSize = 15;
		// 最后一页
		int lastPage = Fenye.lastPage(totalPage, page, pageSize);

		request.setAttribute("lastPage", lastPage);
		request.setAttribute("page", page);

		// 当前页第一个的位置
		item = Fenye.fenye(attachByTime, totalPage, page, pageSize, lastPage);

		request.setAttribute("attachByTime", item);
		request.setAttribute("blogUser", blogUser);

		// 私信

		int newMsg = 0;
		UserInfo loginUser = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		if (loginUser != null) {

			String messageSql = "from Message where userInfo1.id = '"
					+ loginUser.getId() + "' and isRead = '0'";
			List<Message> messageList = messageService
					.listMessageBySql(messageSql);
			newMsg = messageList.size();
			// 更新session
			request.getSession().setAttribute("userInfo",this.userInfoService.findById(loginUser.getId()));

			// 判断登陆者与博主是不是好友
			boolean isFriend = this.friendService.isFriend(loginUser.getId(),
					blogUser.getId());
			request.setAttribute("isFriend", isFriend);
		}
		request.setAttribute("newMsgCount", newMsg);

		return "/web/PersonalInfo/personalAttach";
	}

}
