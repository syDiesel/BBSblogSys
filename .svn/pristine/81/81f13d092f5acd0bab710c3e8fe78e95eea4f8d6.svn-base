/**
 * 
 */
package com.bbsBlog.action;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bbsBlog.entity.Board;
import com.bbsBlog.entity.Label;
import com.bbsBlog.entity.PersonalInfo;
import com.bbsBlog.entity.Role;
import com.bbsBlog.entity.UserInfo;
import com.bbsBlog.service.BlogHiService;
import com.bbsBlog.service.BlogLabelService;
import com.bbsBlog.service.BlogLogService;
import com.bbsBlog.service.BoardService;
import com.bbsBlog.service.Forum_postService;
import com.bbsBlog.service.LabelService;
import com.bbsBlog.service.PersonalInfoService;
import com.bbsBlog.service.RoleService;
import com.bbsBlog.service.UserInfoService;
import com.bbsBlog.util.CountModel;
import com.bbsBlog.util.PageModel;

/**
 * @author Robust
 *
 * @date 2014年10月8日
 *
 */
@Controller
@RequestMapping(value = "/web/management")
public class CountController {

	@Resource
	private UserInfoService userInfoService;

	@Resource
	private RoleService roleService;

	@Resource
	private PersonalInfoService personalInfoService;

	@Resource
	private BoardService boardService;

	@Resource
	private LabelService labelService;

	@Resource
	private BlogHiService blogHiService;

	@Resource
	private BlogLabelService blogLabelService;

	@Resource
	private BlogLogService blogLogService;

	@Resource
	private Forum_postService forum_postService;

	private final String LIST_ACTION = "redirect:/web/management/Role/listUser";

	// ===========================/用户统计/=========================================
	// 查找用户
	@RequestMapping(value = "/Role/findUser")
	public String findUserByNickName(HttpServletRequest request, String nickName) {

		// 这里开始为权限认证
		// loginUser
		UserInfo loginUser = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		if (loginUser == null) {

			return "redirect:../../../login.html";

		}

		else if (loginUser.getRole() == null
				|| loginUser.getRole().getId() != 1) {
			// return "redirect:/addBoard";
			System.out.println("非管理员权限");
			return LIST_ACTION;
		}

		List<UserInfo> foundUsers = userInfoService
				.findUserByNickName(nickName);

		request.setAttribute("foundUsers", foundUsers);

		return "listUser";
	}

	@RequestMapping(value = "/Role/updateRole")
	public @ResponseBody String updateRoleOrSex(HttpServletRequest request,
			String sex, long role, long userId, long say) {

		// 这里开始为权限认证
		// loginUser
		UserInfo loginUser = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		if (loginUser == null) {

			return "redirect:../../../login.html";

		}

		else if (loginUser.getRole() == null
				|| loginUser.getRole().getId() != 1) {
			// return "redirect:/addBoard";
			System.out.println("非管理员权限");
			return LIST_ACTION;
		}

		System.out.println(sex);

		System.out.println(role);

		System.out.println(userId);
		// 更新用户角色

		UserInfo updateUser = userInfoService.findById(userId);

		Role updateRole = roleService.listRoleById(role);

		updateUser.setRole(updateRole);

		// 更新禁言时间
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (say == -1) {
			updateUser.setIsSay("0");
		} else if (say != 0) {
			if (updateUser.getIsSay().equals("0")) {
				Calendar c = Calendar.getInstance();
				c.setTime(new Date()); // 设置当前日期
				c.add(Calendar.DATE, 1); // 日期加1
				Date date = c.getTime(); // 结果

				updateUser.setIsSay(df.format(date));
			} else {
				try {
					Date sayTime = df.parse(updateUser.getIsSay());
					Calendar c = Calendar.getInstance();
					c.setTime(sayTime); // 设置当前日期
					c.add(Calendar.DATE, (int) say); // 日期加1
					Date date = c.getTime(); // 结果
					updateUser.setIsSay(df.format(date));

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		userInfoService.updateUserInfo(updateUser);
		// 更新性别

		PersonalInfo personInfo = updateUser.getPersonalInfo();

		personInfo.setSex(sex);

		personalInfoService.updatePersonalInfo(personInfo);

		return updateUser.getIsSay();
	}

	@RequestMapping(value = "/Role/listRole")
	public String listRole(HttpServletRequest request) {
		// 这里开始为权限认证
		// loginUser
		UserInfo loginUser = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		if (loginUser == null) {

			return "redirect:../../../login.html";

		}

		else if (loginUser.getRole() == null
				|| loginUser.getRole().getId() != 1) {
			// return "redirect:/addBoard";
			System.out.println("非管理员权限");
			return LIST_ACTION;
		}

		int offset = 0;
		int pageSize = 15;
		try {
			offset = Integer.parseInt(request.getParameter("pager.offset"));
		} catch (Exception e) {
		}

		PageModel foundUsers = userInfoService.listUserByRole(offset, pageSize);

		request.setAttribute("foundUsers", foundUsers);

		return "listRole";
	}

	// ===============================统计开始===================================
	// userCount
	@RequestMapping(value = "/Count/userCount")
	public String userCount(HttpServletRequest request) {

		// loginUser
		UserInfo loginUser = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		if (loginUser == null) {

			return "redirect:../../../login.html";

		}

		else if (loginUser.getRole() == null
				|| loginUser.getRole().getId() != 1) {
			// return "redirect:/addBoard";
			System.out.println("非管理员权限");
			return LIST_ACTION;
		}
		// 查看今日登陆人数
		Date date = new Date();
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		String nowTime = f.format(date);

		int todayLoginUser = userInfoService.listUserBySql(
				"form UserInfo where lastLogin_date like '" + nowTime + "%'")
				.size();
		request.setAttribute("todayLoginUser", todayLoginUser);

		// 查看总用户数
		int LoginUser = userInfoService.listUserBySql("form UserInfo").size();
		request.setAttribute("LoginUser", LoginUser);

		return "userCount";
	}

	// blogCount
	@RequestMapping(value = "/Count/boardCount")
	public String blogCount(HttpServletRequest request, String countType) {

		request.setAttribute("countType", countType);

		// loginUser
		UserInfo loginUser = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		if (loginUser == null) {

			return "redirect:../../../login.html";

		}

		else if (loginUser.getRole() == null
				|| loginUser.getRole().getId() != 1) {
			// return "redirect:/addBoard";
			System.out.println("非管理员权限");
			return LIST_ACTION;
		}
		// 列出板块
		List<Board> boards = boardService.listBoard();
		request.setAttribute("boards", boards);

		List<CountModel> cmList = new ArrayList<CountModel>();

		// =============================blog====start=================

		if (countType.equalsIgnoreCase("BK")) {

			// 查看板块中帖子总数
			for (int i = 0; i < boards.size(); i++) {
				String boardTotalHql = "select count(*) from BlogLog where board.id='"
						+ boards.get(i).getId() + "'";
				int boardTotal = blogLogService.listCount(boardTotalHql);

				// 查看今日帖子

				String boardTodayHql = "select count(*) from BlogLog where board.id='"
						+ boards.get(i).getId()
						+ "' and blogTime like '"
						+ getNowTime() + "%'";
				int boardToday = blogLogService.listCount(boardTodayHql);

				// 浏览总数
				String boardVisitedHql = "select count(*) from BlogHI where blogLog.board.id='"
						+ boards.get(i).getId() + "'";
				int boardVisited = blogHiService.listCount(boardVisitedHql);

				// 今日浏览总数
				Date date = new Date();
				SimpleDateFormat sf = new SimpleDateFormat("yyMMdd");
				String blogHiTime = sf.format(date);

				String boardVisitedTodayHql = "select count(*) from BlogHI where blogLog.board.id='"
						+ boards.get(i).getId()
						+ "' and time like '"
						+ blogHiTime + "%'";
				int boardVisitedToday = blogHiService
						.listCount(boardVisitedTodayHql);

				CountModel cm = new CountModel();
				cm.setBoardId(boards.get(i).getId());
				cm.setBoardName(boards.get(i).getBoardName());
				cm.setBoardTotal(boardTotal + "");
				cm.setBoardToday(boardToday + "");
				cm.setBoardVisited(boardVisited + "");
				cm.setBoardVisitedToday(boardVisitedToday + "");

				cmList.add(cm);

			}
		}
		// ====================blog====end====================

		// =============================forum====start=================

		if (countType.equalsIgnoreCase("LT")) {
			// TODO
			// 查看板块中帖子总数
			for (int i = 0; i < boards.size(); i++) {
				String boardTotalHql = "select count(*) from ForumPost where board.id='"
						+ boards.get(i).getId() + "'";
				int boardTotal = forum_postService.listCount(boardTotalHql);

				// 查看今日帖子

				String boardTodayHql = "select count(*) from ForumPost where board.id='"
						+ boards.get(i).getId()
						+ "' and postDate like '"
						+ getNowTime() + "%'";
				int boardToday = forum_postService.listCount(boardTodayHql);

				// 浏览总数 TODO
				String boardVisitedHql = "select count(*) from ForumUpHi where forumPost.board.id='"
						+ boards.get(i).getId() + "'";
				int boardVisited = forum_postService.listCount(boardVisitedHql);

				String boardVisitedTodayHql = "select count(*) from ForumUpHi where forumPost.board.id='"
						+ boards.get(i).getId()
						+ "' and upTime like '"
						+ getNowTime() + "%'";
				int boardVisitedToday = forum_postService
						.listCount(boardVisitedTodayHql);

				CountModel cm = new CountModel();
				cm.setBoardId(boards.get(i).getId());
				cm.setBoardName(boards.get(i).getBoardName());
				cm.setBoardTotal(boardTotal + "");
				cm.setBoardToday(boardToday + "");
				cm.setBoardVisited(boardVisited + "");
				cm.setBoardVisitedToday(boardVisitedToday + "");

				cmList.add(cm);

			}
		}
		// ====================forum====end====================

		// =============================question====start=================

		if (countType.equalsIgnoreCase("WD")) {
			// TODO
			// 查看板块中帖子总数
			for (int i = 0; i < boards.size(); i++) {
				String boardTotalHql = "select count(*) from Question where board.id='"
						+ boards.get(i).getId() + "'";
				int boardTotal = blogLogService.listCount(boardTotalHql);

				// 查看今日帖子

				String boardTodayHql = "select count(*) from Question where board.id='"
						+ boards.get(i).getId()
						+ "' and qTime like '"
						+ getNowTime() + "%'";
				int boardToday = blogLogService.listCount(boardTodayHql);

				// 浏览总数 TODO
				String boardVisitedHql = "select count(*) from Answer where question.board.id='"
						+ boards.get(i).getId() + "'";
				int boardVisited = blogHiService.listCount(boardVisitedHql);

				String boardVisitedTodayHql = "select count(*) from Answer where question.board.id='"
						+ boards.get(i).getId()
						+ "' and aTime like '"
						+ getNowTime() + "%'";
				int boardVisitedToday = blogHiService
						.listCount(boardVisitedTodayHql);

				CountModel cm = new CountModel();
				cm.setBoardId(boards.get(i).getId());
				cm.setBoardName(boards.get(i).getBoardName());
				cm.setBoardTotal(boardTotal + "");
				cm.setBoardToday(boardToday + "");
				cm.setBoardVisited(boardVisited + "");
				cm.setBoardVisitedToday(boardVisitedToday + "");

				cmList.add(cm);

			}
		}
		// ====================question====end====================

		request.setAttribute("cmList", cmList);

		return "boardCount";
	}

	// blog LabelCount
	@RequestMapping(value = "/Count/labelCount")
	public String blogLabelCount(HttpServletRequest request, long boardId,
			String countType) {

		// loginUser
		UserInfo loginUser = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		if (loginUser == null) {

			return "redirect:../../../login.html";

		}

		else if (loginUser.getRole() == null
				|| loginUser.getRole().getId() != 1) {

			System.out.println("非管理员权限");
			return LIST_ACTION;
		}
		// 列出板块
		List<Label> labels = labelService.listLabelByBoard(boardId);
		request.setAttribute("labels", labels);

		//

		List<CountModel> cmList = new ArrayList<CountModel>();

		// ============================blog==========================
		if (countType.equalsIgnoreCase("BK")) {
			// 查看板块中帖子总数
			for (int i = 0; i < labels.size(); i++) {
				String labelTotalHql = "select count(*) from BlogLabel where label.id='"
						+ labels.get(i).getId() + "'";
				int labelTotal = blogLabelService.listCount(labelTotalHql);

				// 查看今日帖子

				String labelTodayHql = "select count(*) from BlogLabel where label.id='"
						+ labels.get(i).getId()
						+ "' and blogLog.blogTime like '" + getNowTime() + "%'";
				int labelToday = blogLogService.listCount(labelTodayHql);

				CountModel cm = new CountModel();
				cm.setBoardName(labels.get(i).getBoard().getBoardName());
				cm.setLabelName(labels.get(i).getLabelName());
				cm.setLabelTotal(labelTotal + "");
				cm.setLabelToday(labelToday + "");

				cmList.add(cm);

			}
		}
		// ============================blog==========================

		// ============================forum==========================
		if (countType.equalsIgnoreCase("LT")) {
			// 查看板块中帖子总数
			for (int i = 0; i < labels.size(); i++) {
				String labelTotalHql = "select count(*) from ForumLabel where label.id='"
						+ labels.get(i).getId() + "'";
				int labelTotal = forum_postService.listCount(labelTotalHql);

				// 查看今日帖子

				String labelTodayHql = "select count(*) from ForumLabel where label.id='"
						+ labels.get(i).getId()
						+ "' and forumPost.postDate like '"
						+ getNowTime()
						+ "%'";
				int labelToday = forum_postService.listCount(labelTodayHql);

				CountModel cm = new CountModel();
				cm.setBoardName(labels.get(i).getBoard().getBoardName());
				cm.setLabelName(labels.get(i).getLabelName());
				cm.setLabelTotal(labelTotal + "");
				cm.setLabelToday(labelToday + "");

				cmList.add(cm);

			}
		}
		// ============================forum==========================

		// ============================qandA==========================
		if (countType.equalsIgnoreCase("WD")) {
			// 查看板块中帖子总数
			for (int i = 0; i < labels.size(); i++) {
				String labelTotalHql = "select count(*) from QuestionLabel where label.id='"
						+ labels.get(i).getId() + "'";
				int labelTotal = forum_postService.listCount(labelTotalHql);

				// 查看今日帖子

				String labelTodayHql = "select count(*) from QuestionLabel where label.id='"
						+ labels.get(i).getId()
						+ "' and question.qTime like '"
						+ getNowTime() + "%'";
				int labelToday = forum_postService.listCount(labelTodayHql);

				CountModel cm = new CountModel();
				cm.setBoardName(labels.get(i).getBoard().getBoardName());
				cm.setLabelName(labels.get(i).getLabelName());
				cm.setLabelTotal(labelTotal + "");
				cm.setLabelToday(labelToday + "");

				cmList.add(cm);

			}
		}
		// ============================qandA==========================
		request.setAttribute("cmList", cmList);

		return "labelCount";
	}

	// =====================================静态方法==================================
	// doubel保留2位小数
	public static double get2Double(double a) {
		DecimalFormat df = new DecimalFormat("0.00");
		return new Double(df.format(a).toString());
	}

	// 服务器时间
	public static String getNowTime() {
		Date date = new Date();
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		String nowTime = f.format(date);

		return nowTime;
	}

}
