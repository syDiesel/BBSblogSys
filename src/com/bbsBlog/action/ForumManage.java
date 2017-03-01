package com.bbsBlog.action;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bbsBlog.entity.Audit;
import com.bbsBlog.entity.BlogLog;
import com.bbsBlog.entity.Board;
import com.bbsBlog.entity.ForumLabel;
import com.bbsBlog.entity.ForumPost;
import com.bbsBlog.entity.Label;
import com.bbsBlog.entity.Master;
import com.bbsBlog.entity.MasterApply;
import com.bbsBlog.entity.Message;
import com.bbsBlog.entity.MessageText;
import com.bbsBlog.entity.PostStatus;
import com.bbsBlog.entity.UserInfo;
import com.bbsBlog.entity.UserUpHi;
import com.bbsBlog.entity.WealthBoard;
import com.bbsBlog.service.AuditService;
import com.bbsBlog.service.BlogLogService;
import com.bbsBlog.service.BoardService;
import com.bbsBlog.service.Forum_postService;
import com.bbsBlog.service.LabelService;
import com.bbsBlog.service.MasterApplyService;
import com.bbsBlog.service.MasterService;
import com.bbsBlog.service.MessageService;
import com.bbsBlog.service.MessageTextService;
import com.bbsBlog.service.PostStatusService;
import com.bbsBlog.service.UserInfoService;
import com.bbsBlog.service.UserUpHisService;
import com.bbsBlog.service.WealthBoardService;
import com.bbsBlog.util.PageModel;
import com.bbsBlog.util.ScoreLevel;

@Controller
public class ForumManage {
	@Resource
	private Forum_postService forum_postService;

	@Resource
	private MasterApplyService masterApplyService;
	@Resource
	private MasterService masterService;
	@Resource
	private PostStatusService postStatusService;
	@Resource
	private LabelService labelService;
	@Resource
	private BoardService boardService;
	@Resource
	private AuditService auditService;
	@Resource
	private UserInfoService userInfoService;
	@Resource
	private WealthBoardService wealthBoardService;
	@Resource
	private MessageTextService messageTextService;
	@Resource
	private BlogLogService blogLogService;
	@Resource
	private MessageService messageService;
	@Resource
	private UserUpHisService userUpHisService;
	private List<Label> listlabelByBoard;
	private List<Board> listBoard;
	private List<ForumPost> listForum;
	private List<ForumLabel> listForumLabelByPostId;
	private List<MasterApply> listMasterApply;
	private List<Master> listMaster;

	@RequestMapping(value = "/addMasterApply", method = RequestMethod.GET)
	public String addMasterApply(HttpServletRequest request,
			HttpServletResponse response) {

		listBoard = this.boardService.listBoard();
		request.setAttribute("listBoard", listBoard);
	    
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
		}else{
			String strBackUrl = "http://" + request.getServerName() // 服务器地址
					+ ":" + request.getServerPort() // 端口号
					+ request.getContextPath() // 项目名称
					+ request.getServletPath(); // 请求页面或其他地址
			/* + "?" + (request.getQueryString()) */// 参数
			request.getSession().setAttribute("strBackUrl", strBackUrl);
			return "redirect:login.html";
		}
		request.setAttribute("newMsgCount", newMsg);
		return "/web/Forums/masterApply";
	}

	@RequestMapping(value = "/saveMasterApply", method = RequestMethod.POST)
	public String saveMasterApply(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			long board_id = Integer.parseInt(request.getParameter("board"));
			String applyReason = request.getParameter("applyReason");
			// 检查字数
			if (applyReason.length() < 1) {
				request.getSession().setAttribute("errorResult", "error");
				return "redirect:toResult.do";
			}
			if (applyReason.length() > 100) {
				applyReason.substring(0, 100);
			}
			MasterApply masterApply = new MasterApply();

			UserInfo userInfo = new UserInfo();
			userInfo = (UserInfo) request.getSession().getAttribute("userInfo");

			Date date = new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			String nowTime = df.format(date);

			masterApply.setApplyDesc(applyReason);
			masterApply.setTime(nowTime);
			masterApply.setUserInfo(userInfo);
			masterApply.setBoard(this.boardService.listBoardById(board_id));

			this.masterApplyService.saveMasterApply(masterApply);
			request.getSession().setAttribute("errorResult", "Successfully, please wait for verification");

		} catch (Exception e) {
			request.getSession().setAttribute("errorResult", "fail");
		}

		return "redirect:toResult.do";
	}

	
	
	
	
	@RequestMapping(value="/addLabelApply",method=RequestMethod.GET)
	public String addLabelApply(HttpServletRequest request,HttpServletResponse response)
	{
	    listBoard=this.boardService.listBoard();
	    request.setAttribute("listBoard", listBoard);
	    
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
			}else{
				String strBackUrl = "http://" + request.getServerName() // 服务器地址
						+ ":" + request.getServerPort() // 端口号
						+ request.getContextPath() // 项目名称
						+ request.getServletPath(); // 请求页面或其他地址
				/* + "?" + (request.getQueryString()) */// 参数
				request.getSession().setAttribute("strBackUrl", strBackUrl);
				return "redirect:login.html";
			}
			request.setAttribute("newMsgCount", newMsg);
	   

		return "/web/Forums/labelApply";
	}

	@RequestMapping(value = "/saveLabelApply", method = RequestMethod.POST)
	public String saveLabelApply(HttpServletRequest request,
			HttpServletResponse response) {

		UserInfo loginUser = (UserInfo) request.getSession().getAttribute(
				"userInfo");

		if (loginUser == null) {
			String strBackUrl = "http://" + request.getServerName() // 服务器地址
					+ ":" + request.getServerPort() // 端口号
					+ request.getContextPath() // 项目名称
					+ request.getServletPath() // 请求页面或其他地址
					+ "?" + (request.getQueryString());// / 参数
			request.getSession().setAttribute("strBackUrl", strBackUrl);
			return "redirect:login.html";
		}

		try {
			String board_id = request.getParameter("board");
			Board board = this.boardService.listBoardById(Integer
					.parseInt(board_id));
			String label = request.getParameter("label");
			// 检查字数
			if (label.length() > 20) {
				label = label.substring(0, 20);
			}
			if (label.length() < 1) {
				request.getSession().setAttribute("errorResult", "error");
				return "redirect:toResult.do";
			}
			Date date = new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			String nowTime = df.format(date);
			MessageText labelApply = new MessageText();
			labelApply.setMsgSubject(board.getBoardName());
			labelApply.setMsgType("labelApply");
			labelApply.setMsgContent(label);
			labelApply.setMsgTime(nowTime);

			Message labelApplyMsg = new Message();
			labelApplyMsg.setIsRead("0");
			labelApplyMsg.setMessageText(labelApply);
			labelApplyMsg.setUserInfo1(userInfoService.findById(1));// 收信人
			labelApplyMsg.setUserInfo2(userInfoService.findById(loginUser
					.getId()));// 发信人

			this.messageTextService.saveMessageText(labelApply);
			messageService.saveMessage(labelApplyMsg);

			request.setAttribute("resultType", "saveLabelApply");
			
			request.getSession().setAttribute("errorResult", "Successful, please wait for verification in 1~2 days");

		} catch (Exception e) {
			// TODO: handle exception
			request.getSession().setAttribute("errorResult", "fail");
		}

		return "redirect:toResult.do";
	}

	@RequestMapping(value = "approveLabelApply.do", method = RequestMethod.GET)
	public String approveLabelApply(HttpServletRequest request,
			HttpServletResponse response, long msgId, int record) {

		UserInfo loginUser = (UserInfo) request.getSession().getAttribute(
				"userInfo");

		if (loginUser == null) {
			return "redirect:login.html";
		}

		Message message = messageService.listMessageById(msgId);
		MessageText msg = message.getMessageText();

		Label label = new Label();
		Board board = this.boardService.listBoardByBoardName(
				msg.getMsgSubject()).get(0);
		label.setBoard(board);
		label.setLabelName(msg.getMsgContent());
		label.setForumCount(0);
		label.setBlogCount(0);
		label.setQuestionCount(0);
		this.labelService.saveLabel(label);

		// 通知申请人申请Successfully
		MessageText applyResultMsgText = new MessageText();
		Message applyResultMsg = new Message();

		applyResultMsgText.setMsgContent("The tag you applied：<span style='color:red'>"
				+ msg.getMsgContent() + "</span>approved");
		applyResultMsgText.setMsgType("0");
		applyResultMsgText.setMsgSubject("Approved");
		applyResultMsgText.setMsgTime(getNowTime());

		applyResultMsg.setUserInfo2(userInfoService.findById(1));// 发信人
		applyResultMsg.setUserInfo1(message.getUserInfo2());// 收信人
		applyResultMsg.setIsRead("0");
		applyResultMsg.setMessageText(applyResultMsgText);

		messageTextService.saveMessageText(applyResultMsgText);
		messageService.saveMessage(applyResultMsg);

		long messageTextId =message.getMessageText()
				.getId();
		
		this.messageService.deleteMessage(msgId);
		this.messageTextService.deleteMessageText(messageTextId);

		return "redirect:listLabelApply.do?record=" + record;

	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/toForumManage_{board_id}", method = RequestMethod.GET)
	public String toForumManage(HttpServletRequest request,
			HttpServletResponse response, int record,
			@PathVariable long board_id) {
		// 验证用户是否是该板块的版主
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		List<Master> listMaster = this.masterService
				.listMasterByBoard(board_id);
		boolean trueMaster = false;
		if (listMaster.size() > 0)
			for (int i = 0; i < listMaster.size(); i++) {

				if (userInfo != null
						&& listMaster.get(i).getUserInfo().getId() == userInfo
								.getId()) {
					trueMaster = true;
				}

			}
		if (!trueMaster) {
			request.getSession().setAttribute("errorResult", "error");
			return "redirect:toResult.do";
		}

		request.setAttribute("masterBoardId", board_id);

		listForum = this.forum_postService.listPostByBoardTimeDesc(board_id);
		/*listlabelByBoard = this.labelService.listLabelByBoard(board_id);*/

		// 开始分页
		int pageRecords = 20; // 每页显示的记录数,这个可以自己设定
		int allRecords = listForum.size(); // 总的记录
		int allPage = (allRecords - 1) / pageRecords + 1; // 总页数

		PageModel pages = new PageModel();

		listForum = pages.fenYe(listForum, pageRecords, record, allPage,
				allRecords);// 调用Pages的方法，进行分页
		request.setAttribute("record", record);// 当前页
		request.setAttribute("pageRecords", pageRecords);// 每页显示的记录数
		request.setAttribute("allPage", allPage);// 总的页数

		/*List<List<ForumLabel>> listForumLabel = new ArrayList<List<ForumLabel>>();
		for (int i = 0; i < listForum.size(); i++) {
			listForumLabelByPostId = this.forum_postService
					.listForumLabelByPostId(listForum.get(i).getId());
			listForumLabel.add(listForumLabelByPostId);
		}*/

		/*request.setAttribute("listlabelByBoard", listlabelByBoard);*/
		request.setAttribute("listForum", listForum);
		/*request.setAttribute("listForumLabel", listForumLabel);*/

		
		
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
		
		
		
		
        

		return "/web/Forums/ForumManage";
	}

	@RequestMapping(value = "/setTop", method = RequestMethod.GET)
	public String setTop(HttpServletRequest request,
			HttpServletResponse response, int record) {

		long post_id = Integer.parseInt(request.getParameter("post_id"));
		ForumPost post = new ForumPost();
		post = this.forum_postService.findById(post_id);
		long board_id = post.getBoard().getId();
		this.forum_postService.updateForum_postIsTop(post_id, "1");
		request.setAttribute("board_id", board_id);

		return "redirect:toForumManage_" + board_id + "?record=" + record;
	}

	@RequestMapping(value = "/setWell", method = RequestMethod.GET)
	public String setWell(HttpServletRequest request,
			HttpServletResponse response, int record) {

		long post_id = Integer.parseInt(request.getParameter("post_id"));
		ForumPost post = new ForumPost();
		post = this.forum_postService.findById(post_id);
		long board_id = post.getBoard().getId();
		this.forum_postService.updateForum_postIsWell(post_id, "1");

		return "redirect:toForumManage_" + board_id + "?record=" + record;
	}


	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/manageByLabel", method = RequestMethod.GET)
	public String manageByLabel(HttpServletRequest request,
			HttpServletResponse response, int record, long board_id) {
		// 验证用户是否是该板块的版主
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		List<Master> listMaster = this.masterService
				.listMasterByBoard(board_id);
		boolean trueMaster = false;
		if (listMaster.size() > 0)
			for (int i = 0; i < listMaster.size(); i++) {

				if (userInfo != null
						&& listMaster.get(i).getUserInfo().getId() == userInfo
								.getId()) {
					trueMaster = true;
				}

			}
		if (!trueMaster) {
			request.getSession().setAttribute("errorResult", "error");
			return "redirect:toResult.do";
		}

		long label_id = Integer.parseInt(request.getParameter("label_id"));

		List post_ids = new ArrayList();
		List<ForumPost> listForum1 = new ArrayList<ForumPost>();
		post_ids = this.forum_postService.listPostByLabelTimeDesc(label_id);
		for (int i = 0; i < post_ids.size(); i++) {
			listForum1.add(this.forum_postService.findById((Long) post_ids
					.get(i)));
		}
		listlabelByBoard = this.labelService.listLabelByBoard(board_id);

		List<List<ForumLabel>> listForumLabel = new ArrayList<List<ForumLabel>>();
		for (int i = 0; i < listForum1.size(); i++) {
			listForumLabelByPostId = this.forum_postService
					.listForumLabelByPostId(listForum1.get(i).getId());
			listForumLabel.add(listForumLabelByPostId);
		}

		// 开始分页
		int pageRecords = 20; // 每页显示的记录数,这个可以自己设定
		int allRecords = listForum1.size(); // 总的记录
		int allPage = (allRecords - 1) / pageRecords + 1; // 总页数

		PageModel pages = new PageModel();

		listForum1 = pages.fenYe(listForum1, pageRecords, record, allPage,
				allRecords);// 调用Pages的方法，进行分页
		request.setAttribute("record", record);// 当前页
		request.setAttribute("pageRecords", pageRecords);// 每页显示的记录数
		request.setAttribute("allPage", allPage);// 总的页数

		request.setAttribute("listlabelByBoard", listlabelByBoard);
		request.setAttribute("listForum", listForum1);
		request.setAttribute("listForumLabel", listForumLabel);
		request.setAttribute("masterBoardId", board_id);
		request.setAttribute("label_id", label_id);

		return "/web/Forums/ForumManageByLabel";
	}


	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/listWellorTop_{board_id}", method = RequestMethod.GET)
	public String listWellorTop(HttpServletRequest request,
			HttpServletResponse response, int record,
			@PathVariable long board_id, String type) {
		// 验证用户是否是该板块的版主
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		List<Master> listMaster = this.masterService
				.listMasterByBoard(board_id);
		boolean trueMaster = false;
		if (listMaster.size() > 0)
			for (int i = 0; i < listMaster.size(); i++) {

				if (userInfo != null
						&& listMaster.get(i).getUserInfo().getId() == userInfo
								.getId()) {
					trueMaster = true;
				}

			}
		if (!trueMaster) {
			request.getSession().setAttribute("errorResult", "error");
			return "redirect:toResult.do";
		}

		request.setAttribute("masterBoardId", board_id);

		if (type == null) {
			request.getSession().setAttribute("errorResult", "error");
			return "redirect:toResult.do";
		}
		List<ForumPost> listForumTop = this.forum_postService
				.listPostTop(board_id);
		List<ForumPost> listForumWell = this.forum_postService
				.listPostWell(board_id);
		List<ForumPost> listForumLock = this.forum_postService
				.listPostByBoardReplyDesc(board_id, 5);

		if (type.equals("lock"))
			listForum = listForumLock;
		if (type.equals("top"))
			listForum = listForumTop;
		if (type.equals("well"))
			listForum = listForumWell;
/*
		List<List<ForumLabel>> listForumLabel = new ArrayList<List<ForumLabel>>();
		for (int i = 0; i < listForum.size(); i++) {
			listForumLabelByPostId = this.forum_postService
					.listForumLabelByPostId(listForum.get(i).getId());
			listForumLabel.add(listForumLabelByPostId);
		}*/

		// 开始分页
		int pageRecords = 20; // 每页显示的记录数,这个可以自己设定
		int allRecords;

		allRecords = listForum.size(); // 总的记录

		int allPage = (allRecords - 1) / pageRecords + 1; // 总页数

		PageModel pages = new PageModel();

		listForum = pages.fenYe(listForum, pageRecords, record, allPage,
				allRecords);// 调用Pages的方法，进行分页

		request.setAttribute("record", record);// 当前页
		request.setAttribute("pageRecords", pageRecords);// 每页显示的记录数
		request.setAttribute("allPage", allPage);// 总的页数

		request.setAttribute("listForum", listForum);
		request.setAttribute("type", type);
		/*request.setAttribute("listForumLabel", listForumLabel);*/

		
		
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
		
        

		return "/web/Forums/listWellorTop";
	}

	@RequestMapping(value = "/cancelWellorTop", method = RequestMethod.GET)
	public String cancelWellorTop(HttpServletRequest request,
			HttpServletResponse response) {
		String type = request.getParameter("type");
		ForumPost post = new ForumPost();
		long post_id = Integer.parseInt(request.getParameter("post_id"));
		post = this.forum_postService.findById(post_id);
		long board_id = post.getBoard().getId();

		if (type.equals("well")) {
			this.forum_postService.updateForum_postIsWell(post_id, "0");
		}

		if (type.equals("top")) {
			this.forum_postService.updateForum_postIsTop(post_id, "0");
		}

		if (type.equals("lock")) {
			UnLockForum(request, post_id);
		}
		request.setAttribute("board_id", board_id);
		return "redirect:/listWellorTop_" + board_id + "?record=1&type=" + type;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/setVerify_{board_id}", method = RequestMethod.GET)
	public String setVerify(HttpServletRequest request,
			HttpServletResponse response, int record,
			@PathVariable long board_id) {
		// 验证用户是否是该板块的版主
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		List<Master> listMaster = this.masterService
				.listMasterByBoard(board_id);
		boolean trueMaster = false;
		if (listMaster.size() > 0)

			for (int i = 0; i < listMaster.size(); i++) {

				if (userInfo != null
						&& listMaster.get(i).getUserInfo().getId() == userInfo
								.getId()) {
					trueMaster = true;
				}

			}
		if (!trueMaster) {
			request.getSession().setAttribute("errorResult", "error");
			return "redirect:toResult.do";
		}

		request.setAttribute("masterBoardId", board_id);
		Board board=this.boardService.listBoardById(board_id);
		request.setAttribute("board",board);
		String sql="from ForumPost p where p.board.id="+board_id+" and p.postStatus.id=1 order by p.postDate desc";
			listForum = this.forum_postService.listPostBySql(sql);

		int pageRecords = 20; // 每页显示的记录数,这个可以自己设定
		int allRecords;
		int allPage;

		allRecords = listForum.size(); // 总的记录
		allPage = (allRecords - 1) / pageRecords + 1;
		PageModel pages = new PageModel();
		listForum = pages.fenYe(listForum, pageRecords, record, allPage,
				allRecords);// 调用Pages的方法，进行分页


		request.setAttribute("record", record);// 当前页
		request.setAttribute("pageRecords", pageRecords);// 每页显示的记录数
		request.setAttribute("allPage", allPage);// 总的页数

		request.setAttribute("listForum", listForum);
		
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
		

		return "/web/Forums/setVerify";
	}

	@RequestMapping("passForum{id}.do")
	public String passForum(HttpServletRequest request,
			HttpServletResponse response,long msg,@PathVariable long id,int record) {

		 ForumPost post=this.forum_postService.findById(id);
		// 验证用户是否是该板块的版主
				UserInfo userInfo = (UserInfo) request.getSession().getAttribute(
						"userInfo");
				List<Master> listMaster = this.masterService
						.listMasterByBoard(post.getBoard().getId());
				boolean trueMaster = false;
				if (listMaster.size() > 0)

					for (int i = 0; i < listMaster.size(); i++) {

						if (userInfo != null
								&& listMaster.get(i).getUserInfo().getId() == userInfo
										.getId()) {
							trueMaster = true;
						}

					}
				if (!trueMaster) {
					request.getSession().setAttribute("errorResult", "error");
					return "redirect:toResult.do";
				}

		MessageText messageText = new MessageText();
		messageText.setMsgSubject("System Messages");	
		String basePath = "http://" + request.getServerName() // 服务器地址
				+ ":" + request.getServerPort() // 端口号
				+ request.getContextPath();
	    if(msg==1)
	    {
	    	post.setPostStatus(this.postStatusService.listPostStatusById(4));
	    	post.setProcessHis(post.getProcessHis()+"->"+userInfo.getNickName()+"on"+getNowTime()+"post approved");
	    	
	    	//积分及动态
			Audit audit = new Audit();
			 //动态时间
			audit.setAuditTime(post.getPostDate());
			 //动态内容
			audit.setAuditContent(post.getSubject());
			// 动态类型（博客/论坛/问答）
			audit.setAuditType("LT");
			// 动态所在表的ID
			audit.setAuditId(post.getId()+"");
			audit.setUserInfo(post.getUserInfo());
			auditService.saveAduit(audit);
	    	this.addWealth(request,post.getUserInfo().getId(),post.getBoard().getId(),1);
	    	
	    	//文章Approved，发信息给发帖人
	    	messageText.setMsgContent("Your topic<a href='"+basePath+"/toTopics?post_id="+post.getId()+"'>《"+post.getSubject()+"》</a>Approved");
	    	
	    	if(!post.getPostType().equals("origin"))
	    	{
	    		long blog_id=Integer.parseInt(post.getPostType());
				BlogLog blog=this.blogLogService.listBlogLogById(blog_id);
	    		//讨论帖Approved后发信息通知原博主
	    		MessageText text = new MessageText();
				text.setMsgSubject("System Messages");			
				text.setMsgContent(post.getUserInfo().getNickName()+"Reprint your blog to forum,it is  " +
						"<a href='"+basePath+"/toTopics?post_id="+post.getId()+"'>"+post.getSubject()+"</a>");
				text.setMsgTime(getNowTime());
				text.setMsgType("0");
				this.messageTextService.saveMessageText(text);
				//设置发送信息对象
				Message message1 = new Message();
				message1.setIsRead("0");
				message1.setMessageText(text);
				//获取管理员信息
				List<UserInfo> userInfoList=userInfoService.findUserByName("admin");
				UserInfo admin=userInfoList.get(0);
				//设置发信人为管理员
				message1.setUserInfo2(admin);
				message1.setUserInfo1(blog.getBlog().getUserInfo());
				//发送信息
				this.messageService.saveMessage(message1);
	    	}
	    	
	    }else{
	    	post.setPostStatus(this.postStatusService.listPostStatusById(3));
	    	post.setProcessHis(post.getProcessHis()+"->"+userInfo.getNickName()+"on"+getNowTime()+"notpost approved");
	    	
	    	//文章notApproved，发信息给发帖人	    			
			messageText.setMsgContent("Your topic《"+post.getSubject()+"》notApproved");
	    	
	    }
	    
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
		message.setUserInfo1(post.getUserInfo());
		//发送信息
		this.messageService.saveMessage(message);
	    
	    post.setProcessUser(userInfo.getNickName());
        post.setProcessTime(getNowTime());
        this.forum_postService.updateForum_post(post);
	    
		return "redirect:setVerify_"+post.getBoard().getId()+"?record="+record;

	}

	@RequestMapping(value = "/setNotSay", method = RequestMethod.GET)
	public String setNotSay(HttpServletRequest request,
			HttpServletResponse response, long forumUser_id) {

		UserInfo forumUser = new UserInfo();
		forumUser = this.userInfoService.findById(forumUser_id);
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		String nowTime = df.format(date);
		request.setAttribute("nowTime", nowTime);
		request.setAttribute("forumUser", forumUser);
		
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

		return "/web/Forums/setNotSay";
	}

	@RequestMapping(value = "/setNotSay", method = RequestMethod.POST)
	public String setNotSay(HttpServletRequest request,
			HttpServletResponse response) {

		try {

			long forumUser_id = Integer.parseInt(request
					.getParameter("forumUser_id"));
			UserInfo forumUser = new UserInfo();
			forumUser = this.userInfoService.findById(forumUser_id);

			String time = request.getParameter("time");
			if (time.trim() == "") {
				request.getSession().setAttribute("errorResult", "Time Cannot Be Empty");
				return "redirect:toResult.do";
			}
			String time1[] = time.split("-");
			for (int i = 1; i < time1.length; i++) {
				if (time1[i].length() < 2)
					time1[i] = "0" + time1[i];
			}
			time = time1[0] + "-" + time1[1] + "-" + time1[2];

			String sayTime = time + " 0:0:0";
			this.userInfoService.updateIsSay(forumUser.getUserName(), sayTime);
			request.getSession().setAttribute("errorResult", "Successfully");

		} catch (Exception e) {
			// TODO: handle exception
			request.getSession().setAttribute("errorResult", "error");
		}

		return "redirect:toResult.do";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/listNotSay_{board_id}", method = RequestMethod.GET)
	public String listNotSay(HttpServletRequest request,
			HttpServletResponse response, int record,
			@PathVariable long board_id) {
		// 验证用户是否是该板块的版主
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		List<Master> listMaster = this.masterService
				.listMasterByBoard(board_id);
		boolean trueMaster = false;
		if (listMaster.size() > 0)
			for (int i = 0; i < listMaster.size(); i++) {

				if (userInfo != null
						&& listMaster.get(i).getUserInfo().getId() == userInfo
								.getId()) {
					trueMaster = true;
				}

			}
		if (!trueMaster) {
			request.getSession().setAttribute("errorResult", "error");
			return "redirect:toResult.do";
		}
		List<UserInfo> listNotSayUser = this.userInfoService.findUserNotSay();

		// 开始分页
		int pageRecords = 3; // 每页显示的记录数,这个可以自己设定
		int allRecords = listNotSayUser.size(); // 总的记录
		int allPage = (allRecords - 1) / pageRecords + 1; // 总页数

		PageModel pages = new PageModel();

		listNotSayUser = pages.fenYe(listNotSayUser, pageRecords, record,
				allPage, allRecords);// 调用Pages的方法，进行分页

		request.setAttribute("record", record);// 当前页
		request.setAttribute("pageRecords", pageRecords);// 每页显示的记录数
		request.setAttribute("allPage", allPage);// 总的页数
		request.setAttribute("masterBoardId", board_id);
		request.setAttribute("listNotSayUser", listNotSayUser);

		
		
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

		return "/web/Forums/listNotSayUser";
	}

	@RequestMapping(value = "/cancelNotSay_{board_id}", method = RequestMethod.GET)
	public String cancelNotSay(HttpServletRequest request,
			HttpServletResponse response, long notSayUser_id,
			@PathVariable long board_id) {
		UserInfo notSayUser = new UserInfo();
		notSayUser = this.userInfoService.findById(notSayUser_id);
		notSayUser.setIsSay("0");
		this.userInfoService.updateUserInfo(notSayUser);

		return "redirect:/listNotSay_" + board_id + "?record=1";
	}

	@RequestMapping(value = "/toLockForum", method = RequestMethod.GET)
	public String toLockForum(HttpServletRequest request,
			HttpServletResponse response, int record, long post_id) {
		ForumPost post = this.forum_postService.findById(post_id);
		// 验证用户是否是该板块的版主
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		List<Master> listMaster = this.masterService.listMasterByBoard(post
				.getBoard().getId());
		boolean trueMaster = false;
		if (listMaster.size() > 0)
			for (int i = 0; i < listMaster.size(); i++) {

				if (userInfo != null
						&& listMaster.get(i).getUserInfo().getId() == userInfo
								.getId()) {
					trueMaster = true;
				}

			}
		if (!trueMaster) {
			request.getSession().setAttribute("errorResult", "error");
			return "redirect:toResult.do";
		}
		LockForum(request, post_id);
		return "redirect:/toForumManage_" + post.getBoard().getId()
				+ "?record=" + record;
	}

	// 在topics界面封锁帖子
	@RequestMapping(value = "/toLockForumTopics", method = RequestMethod.GET)
	public String toLockForumTopics(HttpServletRequest request,
			HttpServletResponse response, long post_id) {
		ForumPost post = this.forum_postService.findById(post_id);
		// 验证用户是否是该板块的版主
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		List<Master> listMaster = this.masterService.listMasterByBoard(post
				.getBoard().getId());
		boolean trueMaster = false;
		if (listMaster.size() > 0)
			for (int i = 0; i < listMaster.size(); i++) {

				if (userInfo != null
						&& listMaster.get(i).getUserInfo().getId() == userInfo
								.getId()) {
					trueMaster = true;
				}

			}
		if (!trueMaster) {
			request.getSession().setAttribute("errorResult", "error");
			return "redirect:toResult.do";
		}

		LockForum(request, post_id);
		return "redirect:toTopics?post_id=" + post_id;
	}

	// 在topics界面解封帖子
	@RequestMapping(value = "/toUnLockForumTopics", method = RequestMethod.GET)
	public String toUnLockForumTopics(HttpServletRequest request,
			HttpServletResponse response, long post_id) {

		ForumPost post = this.forum_postService.findById(post_id);
		// 验证用户是否是该板块的版主
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		List<Master> listMaster = this.masterService.listMasterByBoard(post
				.getBoard().getId());
		boolean trueMaster = false;
		if (listMaster.size() > 0)
			for (int i = 0; i < listMaster.size(); i++) {

				if (userInfo != null
						&& listMaster.get(i).getUserInfo().getId() == userInfo
								.getId()) {
					trueMaster = true;
				}

			}
		if (!trueMaster) {
			request.getSession().setAttribute("errorResult", "error");
			return "redirect:toResult.do";
		}

		UnLockForum(request, post_id);
		return "redirect:toTopics?post_id=" + post_id;
	}

	// #################################后台版主部分#########################################
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/listApply", method = RequestMethod.GET)
	public String listApply(HttpServletRequest request,
			HttpServletResponse response, int record) {
		listMasterApply = this.masterApplyService.listMasterApply();

		// 开始分页
		int pageRecords = 20; // 每页显示的记录数,这个可以自己设定
		int allRecords = listMasterApply.size(); // 总的记录
		int allPage = (allRecords - 1) / pageRecords + 1; // 总页数

		PageModel pages = new PageModel();

		listMasterApply = pages.fenYe(listMasterApply, pageRecords, record,
				allPage, allRecords);// 调用Pages的方法，进行分页
		request.setAttribute("record", record);// 当前页
		request.setAttribute("pageRecords", pageRecords);// 每页显示的记录数
		request.setAttribute("allPage", allPage);// 总的页数
		request.setAttribute("listMasterApply", listMasterApply);

		return "/web/management/Master/listMasterApply";
	}

	@RequestMapping(value = "/setApplyOk", method = RequestMethod.GET)
	public String setApplyOk(HttpServletRequest request,
			HttpServletResponse response) {
		long apply_id = Integer.parseInt(request.getParameter("apply_id"));
		MasterApply masterApply = new MasterApply();
		masterApply = this.masterApplyService.listMasterApplyById(apply_id);
		Master master = new Master();
		master.setBoard(masterApply.getBoard());
		master.setUserInfo(masterApply.getUserInfo());
		this.masterService.saveMaster(master);
		this.masterApplyService.deleteMasterApply(apply_id);

		return "redirect:/listApply?record=1";
	}

	@RequestMapping(value = "/deleteApply", method = RequestMethod.GET)
	public String deleteApply(HttpServletRequest request,
			HttpServletResponse response) {

		long apply_id = Integer.parseInt(request.getParameter("apply_id"));
		this.masterApplyService.deleteMasterApply(apply_id);
		return "redirect:/listApply?record=1";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/listMaster", method = RequestMethod.GET)
	public String listMaster(HttpServletRequest request,
			HttpServletResponse response, int record) {

		listMaster = this.masterService.listMaster();

		// 开始分页
		int pageRecords = 20; // 每页显示的记录数,这个可以自己设定
		int allRecords = listMaster.size(); // 总的记录
		int allPage = (allRecords - 1) / pageRecords + 1; // 总页数

		PageModel pages = new PageModel();

		listMaster = pages.fenYe(listMaster, pageRecords, record, allPage,
				allRecords);// 调用Pages的方法，进行分页
		request.setAttribute("record", record);// 当前页
		request.setAttribute("pageRecords", pageRecords);// 每页显示的记录数
		request.setAttribute("allPage", allPage);// 总的页数
		request.setAttribute("listMaster", listMaster);

		return "/web/management/Master/listMaster";
	}

	@RequestMapping(value = "/modifyMaster", method = RequestMethod.GET)
	public String modifyMaster(HttpServletRequest request,
			HttpServletResponse response) {

		long master_id = Integer.parseInt(request.getParameter("master_id"));
		Master master = new Master();
		master = this.masterService.listMasterById(master_id);
		request.setAttribute("master", master);

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
		
		return "/web/management/Master/modifyMaster";
	}

	@RequestMapping(value = "/updateMaster", method = RequestMethod.POST)
	public String updateMaster(HttpServletRequest request,
			HttpServletResponse response) {

		long master_id = Integer.parseInt(request.getParameter("master_id"));
		Master master = new Master();
		master = this.masterService.listMasterById(master_id);

		String masterExplain = request.getParameter("masterExplain");
		master.setMasterExplain(masterExplain);
		this.masterService.updateMaster(master);

		return "redirect:/listMaster?record=1";
	}

	@RequestMapping(value = "/deleteMaster", method = RequestMethod.GET)
	public String deleteMaster(HttpServletRequest request,
			HttpServletResponse response) {

		long master_id = Integer.parseInt(request.getParameter("master_id"));
		this.masterService.deleteMaster(master_id);

		return "redirect:/listMaster?record=1";
	}

	@RequestMapping(value = "listLabelApply.do", method = RequestMethod.GET)
	public String listLabelApply(HttpServletRequest request,
			HttpServletResponse response, int record) {

		// List<MessageText>
		// listLabelApply=this.messageTextService.listLabelApply("labelApply");
		String LabelApplyMsgSql = "from Message where messageText.msgType='labelApply'";
		List<Message> listLabelApplyMsg = this.messageService
				.listMessageBySql(LabelApplyMsgSql);

		// 开始分页
		int pageRecords = 20; // 每页显示的记录数,这个可以自己设定
		int allRecords = listLabelApplyMsg.size(); // 总的记录
		int allPage = (allRecords - 1) / pageRecords + 1; // 总页数

		PageModel pages = new PageModel();

		listLabelApplyMsg = pages.fenYe(listLabelApplyMsg, pageRecords, record,
				allPage, allRecords);// 调用Pages的方法，进行分页
		request.setAttribute("record", record);// 当前页
		request.setAttribute("pageRecords", pageRecords);// 每页显示的记录数
		request.setAttribute("allPage", allPage);// 总的页数
		request.setAttribute("listLabelApplyMsg", listLabelApplyMsg);

		return "web/management/Label/listLabelApply";
	}

	@RequestMapping(value = "/deleteLabelApply", method = RequestMethod.GET)
	public String deleteLabelApply(HttpServletRequest request,
			HttpServletResponse response, long msgId, int record) {

		UserInfo loginUser = (UserInfo) request.getSession().getAttribute(
				"userInfo");

		Message message = messageService.listMessageById(msgId);
		MessageText msg = message.getMessageText();
		

			// 通知申请人申请fail
			MessageText applyResultMsgText = new MessageText();
			Message applyResultMsg = new Message();

			applyResultMsgText.setMsgContent("The tag you applied：<span style='color:red'>"
					+ msg.getMsgContent() + "</span>not approved,please re-apply");
			applyResultMsgText.setMsgType("0");
			applyResultMsgText.setMsgSubject("审核fail");
			applyResultMsgText.setMsgTime(getNowTime());

			applyResultMsg.setUserInfo2(userInfoService.findById(1));// 发信人
			applyResultMsg.setUserInfo1(message.getUserInfo2());// 收信人
			applyResultMsg.setIsRead("0");
			applyResultMsg.setMessageText(applyResultMsgText);

			messageTextService.saveMessageText(applyResultMsgText);
			messageService.saveMessage(applyResultMsg);

			long messageTextId= message.getMessageText().getId();
			
			this.messageService.deleteMessage(msgId);
			this.messageTextService.deleteMessageText(messageTextId);
			return "redirect:listLabelApply.do?record=" + record;

	

	}

	
	
	@SuppressWarnings("static-access")
	@RequestMapping(value = "/sendJinzhuan", method = RequestMethod.POST)
	public String sendJinzhuan(HttpServletRequest request,
			HttpServletResponse response) {

		String toUser=request.getParameter("toUser");
		double jinzhuan=Double.parseDouble(request.getParameter("jinzhuan"));
		if(toUser.equals("one"))
		{
			String nickName=request.getParameter("nickName");
			List<UserInfo> listUser=this.userInfoService.findUserByNickName(nickName);
			if(listUser.size()==0)
				{
				request.setAttribute("msg","The user does not exist, giving failed");
				return "web/management/jinzhuan/sendJinzhuan";
				}else{
					UserInfo user=listUser.get(0);					
					user.setJinzhuan(Double.parseDouble(user.getJinzhuan())+jinzhuan+"");
					 ScoreLevel scoreLevel=new ScoreLevel();
					 String userLevel=scoreLevel.scoreLevel(user.getJinzhuan());
					 user.setUserLevel(userLevel);
					this.userInfoService.updateUserInfo(user);
				}
				
		}else{
			List<UserInfo> listUser=this.userInfoService.listUserInfo();
			for(int i=0;i<listUser.size();i++)
			{
				
				listUser.get(i).setJinzhuan(Double.parseDouble(listUser.get(i).getJinzhuan())+jinzhuan+"");
				 ScoreLevel scoreLevel=new ScoreLevel();
				 String userLevel=scoreLevel.scoreLevel(listUser.get(i).getJinzhuan());
				 listUser.get(i).setUserLevel(userLevel);
				this.userInfoService.updateUserInfo(listUser.get(i));
			}
		}
		request.setAttribute("msg","Giving successfully");
		return "web/management/jinzhuan/sendJinzhuan";
	

	}

	// -----------------------------------静态方法------------------------------------------
	@SuppressWarnings("static-access")
	public void addWealth(HttpServletRequest request,long userId, long board_id, double addScore) {

		UserInfo user = userInfoService.findById(userId);
		String newJinzhuan = Double.parseDouble(user.getJinzhuan()) + 1 + "";

		if (user != null) {
			
			double userJinzhuan=Double.parseDouble(user.getJinzhuan());
			List<UserUpHi> userUpHis = userUpHisService
					.listUserUpHiByBlog(user.getId());
			if(userJinzhuan<7||(userJinzhuan>=7&&userUpHis.size() > 0))
			{
			userInfoService.updateJinzhuan(user.getUserName(), newJinzhuan);

			if (this.wealthBoardService.findByUser(user.getId(), board_id)
					.size() > 0) {
				WealthBoard wealthBoard = this.wealthBoardService.findByUser(
						user.getId(), board_id).get(0);
				double board_wealth = Double.parseDouble(wealthBoard
						.getWealthQuantity());
				wealthBoard.setWealthQuantity(board_wealth + addScore + "");
				this.wealthBoardService.updateWealthBoard(wealthBoard);
			} else {
				WealthBoard wealthBoard = new WealthBoard();
				wealthBoard.setUserInfo(user);
				wealthBoard.setBoard(this.boardService.listBoardById(board_id));
				wealthBoard.setWealthQuantity(addScore + "");

				this.wealthBoardService.saveWealthBoard(wealthBoard);
			}

			ScoreLevel scoreLevel = new ScoreLevel();
			String userLevel = scoreLevel.scoreLevel(newJinzhuan);
			this.userInfoService.updateUserLevel(user.getUserName(), userLevel);
			}	
		}
	}

	@SuppressWarnings("static-access")
	public void LockForum(HttpServletRequest request, long post_id) {

		UserInfo user = (UserInfo) request.getSession()
				.getAttribute("userInfo");

		if (user != null) {
			ForumPost post = this.forum_postService.findById(post_id);

			Date date = new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			System.out.println("time now:" + df.format(date));
			String nowTime = df.format(date);

			post.setPostStatus(this.postStatusService.listPostStatusById(5));
			post.setProcessUser(user.getNickName());
			post.setProcessTime(nowTime);
			post.setProcessHis(post.getProcessHis() + user.getNickName() + "on"
					+ nowTime + "Lock this post");

			this.forum_postService.updateForum_post(post);
		}

	}

	@SuppressWarnings("static-access")
	public void UnLockForum(HttpServletRequest request, long post_id) {

		UserInfo user = (UserInfo) request.getSession()
				.getAttribute("userInfo");

		if (user != null) {
			ForumPost post = this.forum_postService.findById(post_id);

			Date date = new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			System.out.println("time now:" + df.format(date));
			String nowTime = df.format(date);

			post.setPostStatus(this.postStatusService.listPostStatusById(4));
			post.setProcessUser(user.getNickName());
			post.setProcessTime(nowTime);

			post.setProcessHis(post.getProcessHis() + "->" + user.getNickName()
					+ "on" + nowTime + "Unlock this post");

			this.forum_postService.updateForum_post(post);
		}

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
