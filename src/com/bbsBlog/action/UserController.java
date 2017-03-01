package com.bbsBlog.action;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.bbsBlog.entity.Blog;
import com.bbsBlog.entity.Cash;
import com.bbsBlog.entity.Friend;
import com.bbsBlog.entity.Message;
import com.bbsBlog.entity.MessageText;
import com.bbsBlog.entity.PersonalInfo;
import com.bbsBlog.entity.UserInfo;
import com.bbsBlog.entity.UserSecurity;
import com.bbsBlog.service.BlogService;
import com.bbsBlog.service.CashService;
import com.bbsBlog.service.FriendService;
import com.bbsBlog.service.MessageService;
import com.bbsBlog.service.MessageTextService;
import com.bbsBlog.service.PersonalInfoService;
import com.bbsBlog.service.RoleService;
import com.bbsBlog.service.UserInfoService;
import com.bbsBlog.service.UserSecurityService;
import com.bbsBlog.util.Mail;
import com.bbsBlog.util.Pages;
import com.bbsBlog.util.Password;
import com.bbsBlog.util.ScoreLevel;
import com.bbsBlog.util.SessionListener;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

@Controller
public class UserController {
	@Resource
	private UserInfoService userInfoService;

	@Resource
	private PersonalInfoService personalInfoService;

	@Resource
	private UserSecurityService userSecurityService;

	@Resource
	private BlogService blogService;

	@Resource
	private FriendService friendService;

	@Resource
	private RoleService roleService;

	@Resource
	private MessageService messageService;

	@Resource
	private MessageTextService messageTextService;

	@Resource
	private CashService cashService;

	private final String LIST_PERSONINFO = "redirect:/PersonInfo";

	/**
	 * 
	 * 
	 * @author swh
	 * 
	 * @date 2014-9-2
	 * 
	 * @param ajax注册
	 *            , 验证用户名是否存在
	 */
	@RequestMapping("checkUserName.do")
	public void checkUserName(HttpServletResponse resp, String userName)
			throws Exception {

		System.out.println("checkUserName.do");

		List<UserInfo> listUserInfo = userInfoService.findUserByName(userName);

		PrintWriter out;
		out = resp.getWriter();

		if (listUserInfo.size() > 0)
			out.print("1"); // 用on返回，用户名存在

		else
			out.print("0"); // 用on返回，Username does not exist

		out.close();

	}

	/**
	 * 
	 * @author swh
	 * 
	 * @date 2014-9-2
	 * 
	 * @param ajax注册
	 *            验证邮箱是否被注册
	 */
	@RequestMapping("checkEmail.do")
	public void checkEmail(HttpServletResponse resp, String email)
			throws Exception {

		List<UserInfo> listUserInfo1 = userInfoService.findUserByEmail(email);
		System.out.println("listUserInfo:" + listUserInfo1 + " email:" + email);

		int m = email.lastIndexOf("@");
		int n = email.lastIndexOf(".");

		PrintWriter out;
		out = resp.getWriter();

		if (m < 0 || n < 0 || n - m <= 0) {
			out.print("wrong"); // 用on返回，表示email格式不对
		} else {
			if (listUserInfo1.size() > 0)
				out.print("error"); // 用on返回，表示email已经被注册
			else
				out.print("ok"); // 用on返回，可以注册
		}

		out.close();

	}

	/**
	 * 
	 * @author swh
	 * 
	 * @date 2014-9-2
	 * 
	 * @param ajax注册
	 *            &登录, 验证码
	 */
	@RequestMapping("checkCode.do")
	public void checkCode(HttpServletRequest req, HttpServletResponse resp,
			String mycode) throws Exception {

		String certCode = (String) req.getSession().getAttribute("certCode");
		System.out.println("mycode:" + mycode + "---------------certCode:"
				+ certCode);

		PrintWriter out;
		out = resp.getWriter();

		if (!certCode.equalsIgnoreCase(mycode))
			out.print("error"); // 用on返回， 验证码输入错误

		else
			out.print("ok"); // 用on返回，验证码输入正确

		out.close();

	}

	// 跳转换字体用
	@RequestMapping("isAgree.do")
	public String isAgree(HttpServletRequest request,
			HttpServletResponse response) {
		String languageLocale = "";
		if (request.getSession().getAttribute(
				SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME) != null) {
			languageLocale = request
					.getSession()
					.getAttribute(
							SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME)
					.toString();
			System.out
					.println("languageLocale1"
							+ request
									.getSession()
									.getAttribute(
											SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME));
			// System.out.println(languageLocale);
		}
		if (languageLocale.equalsIgnoreCase("en_Us")) {
			return "web/user/agreement-en";
		} else if (languageLocale.equalsIgnoreCase("zh_TW")) {
			return "web/user/agreement-tw";
		} else
			System.out
					.println("languageLocale2"
							+ request
									.getSession()
									.getAttribute(
											SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME));

		return "web/user/agreement-en";
	}

	/**
	 * 
	 * @author swh
	 * 
	 * @date 2014-9-3
	 * 
	 * @param 注册
	 */

	@RequestMapping("register.do")
	public String register(HttpServletRequest req, HttpServletResponse resp,
			UserInfo userInfo) throws Exception {

		System.out
				.println("----------------------开始注册:register.do-----------------------------");
		System.out.println(userInfo.getUserName() + " "
				+ userInfo.getPassword() + " " + userInfo.getE_mail() + " "
				+ userInfo.getHeadImg());

		String password0 = req.getParameter("Password");
		String password1 = req.getParameter("Password1");

		// 用户信息
		userInfo.setUserLevel("0");
		userInfo.setJinzhuan("1.0");
		userInfo.setLingdan("0");
		userInfo.setIsSay("0");
		userInfo.setUser_show(RandomStringUtils.random(20, true, true));
		userInfo.setIsBreak("0");
		userInfo.setXianhua("0");
		userInfo.setYangmu("0");
		// TODO 待测试。这里加限制
		/*
		 * if (!Pattern.matches("^[a-zA-Z0-9_\u4e00-\u9fa5]{4,10}$",
		 * userInfo.getNickName())) { req.setAttribute("result",
		 * "Nickname can only be 4-10 digits Chinese, numbers, letters and underline"); }
		 */

		userInfo.setNickName(userInfo.getNickName());
		userInfo.setUserName(userInfo.getUserName());
		userInfo.setPassword(Password.createPassword(userInfo.getPassword()));
		userInfo.setE_mail(userInfo.getE_mail());
		userInfo.setHeadImg(userInfo.getHeadImg());

		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("time now:" + df.format(date));
		String nowTime = df.format(date);

		userInfo.setRegisterDate(nowTime);
		userInfo.setRole(roleService.listRoleById(2));

		List<UserInfo> listUserInfo = userInfoService.findUserByName(userInfo
				.getUserName());
		List<UserInfo> listUserInfo1 = userInfoService.findUserByEmail(userInfo
				.getE_mail());
		List<UserInfo> listUserInfo2 = this.userInfoService
				.findUserByNickName(userInfo.getNickName());

		// 正则表达式匹配
		String pattern = "^[A-Za-z0-9]{6,20}$";
		boolean result = Pattern.matches(pattern, userInfo.getUserName());

		int m = req.getParameter("e_mail").lastIndexOf("@");
		int n = req.getParameter("e_mail").lastIndexOf(".");

		if (userInfo.getUserName().equals(" ") || password0.equals(" ")
				|| password1.equals(" ") || userInfo.getE_mail().equals(" ")
				|| userInfo.getNickName().equals(" "))
			req.setAttribute("result", "User name, account number, nickname or email can not be empty");
		else if (!result) {
			req.setAttribute("result", "Username can only be 6-20 letters & numbers, pls re-enter！！！");
		} else if (!Pattern.matches("^[a-zA-Z0-9_\u4e00-\u9fa5]{4,10}$",
				userInfo.getNickName())) {
			req.setAttribute("result", "Nickname can only be 4-10 digits Chinese, numbers, letters and underline");
		} else if (!password0.equals(password1)) {
			req.setAttribute("result", "Passwords are unsame！");
		} else if (password0.length() < 6) {
			req.setAttribute("result", "Password length cannot be less than 6 digits！");
		} else if (m < 0 || n < 0 || n - m < 0) // (m < 0 || n < 0 || n - m < 2)
			req.setAttribute("result", "Invalid Email Address Format！");

		// else if(userInfoService.register(userInfo).equals("error"))
		else if (listUserInfo.size() > 0)
			req.setAttribute("result", "username already registered！");
		else if (listUserInfo1.size() > 0)
			req.setAttribute("result", "e-mail address already used！");
		else if (listUserInfo2.size() > 0)
			req.setAttribute("result", "nickname already used！");
		else {
			req.setAttribute("result", "success");
			String password = Password.createPassword(password0);
			userInfo.setPassword(password);

			userInfoService.saveUserInfo(userInfo);

			PersonalInfo personalInfo = new PersonalInfo();
			personalInfo.setId(userInfo.getId());
			// System.out.println(userInfo.getId());
			personalInfo.setUserInfo(userInfo);
			personalInfoService.savePersonalInfo(personalInfo);
			Blog blog = new Blog();
			blog.setId(userInfo.getId());
			blog.setUserInfo(userInfo);
			blog.setBlogUp("0");
			blog.setBlogName(userInfo.getNickName() + "personal homepage");
			blog.setVisited("0");
			blog.setBlog_Album("images/home/noHead.jpg");
			blog.setBlogDesc(userInfo.getUserName() + "Blog");
			blogService.saveBlog(blog);

			// userInfoService.saveUserInfo(userInfo);

			// 注册邮件

			String basePath = "http://" + req.getServerName() // 服务器地址
					+ ":" + req.getServerPort() // 端口号
					+ req.getContextPath(); // 项目名称
			// + req.getServletPath(); // 请求页面或其他地址
			/* + "?" + (req.getQueryString()) */// 参数

			String esmtp = "mail.youshizhishi.com"; //stmp.qq.com
			String efrom = "sflc3@youshizhishi.com";
			String eto = userInfo.getE_mail(); // userInfo.getE_mail()
			String ecopyto = ""; // 抄送人
			String esubject = "Unionjoyers    Registration confirmation";// 邮件主题
			String econtent = getMailContent(userInfo.getUserName(),
					userInfo.getNickName(), basePath + "/confirm.html?code="
							+ userInfo.getUser_show() + "&from=" + efrom
							+ "&email=" + eto); // 邮件内容
			String eusername = "sflc3@youshizhishi.com";
			String epassword = "jiechenfazhan";
			String efilename = ""; // 附件路径，如：F:\\笔记<a>\\struts2</a>与mvc.txt
			boolean emailresult = Mail.send(esmtp, efrom, eto, esubject,
					econtent, eusername, epassword);

			return "redirect:/login.html";

		}
		return "/web/ERROR/result";

	}

	// 匹配邮箱中获得的Password。如果equals将userShow改为0
	@RequestMapping(value = "/confirm.html")
	public String confirm(HttpServletRequest request,
			HttpServletResponse response, String code, String email, String from) {

		List<UserInfo> loginUserList = userInfoService.findUserByEmail(email);

		UserInfo loginUser = loginUserList.get(0);

		String userShow = loginUser.getUser_show();
		if (userShow.trim().equalsIgnoreCase(code)
				&& from.trim().equalsIgnoreCase("sflc3@youshizhishi.com")) {
			loginUser.setUser_show("0");
			userInfoService.updateUserInfo(loginUser);
			// request.setAttribute("JihuoStatus", "success");
		}

		return "redirect:/login.html?JihuoStatus=success";
		// return login(request, response);
	}

	@RequestMapping(value = "/login.html")
	public String login(HttpServletRequest request,
			HttpServletResponse response, String JihuoStatus) {

		request.setAttribute("JihuoStatus", JihuoStatus);

		return "/web/user/login";

	}

	/**
	 * 
	 * @author swh
	 * 
	 * @date 2014-9-3
	 * 
	 * @param ajax登录
	 *            , 验证用户名或Email是否存在
	 */
	@RequestMapping("checkUserNameOrEmail.do")
	public void checkUserNameOrEmail(HttpServletResponse resp, String userName,
			String passWord) throws Exception {

		System.out
				.println("----------------------checkUserNameOrEmail.do-------------------");

		List<UserInfo> listUserInfo = userInfoService.findUserByName(userName);
		List<UserInfo> listUserInfo1 = userInfoService
				.findUserByEmail(userName);

		PrintWriter out;
		out = resp.getWriter();

		if (passWord.length() < 5) {

			if ((listUserInfo.size() > 0) || (listUserInfo1.size() > 0)) {
				out.print("1");
			}// 用on返回，用户名或Email存在 Password不合法

			else {
				out.print("0");
			} // 用on返回，用户名和Email都不存在 Password不合法

		} else {

			if ((listUserInfo.size() > 0) || (listUserInfo1.size() > 0)) {

				String password = Password.createPassword(passWord);

				if (userInfoService.checkExistUserByName(userName, password)
						|| userInfoService.checkExistUserByEmail(userName,
								password)) {

					out.print("ok"); // 用on返回，用户名或Email存在 Password合法

				} else {
					out.print("2"); // 用on返回，用户名或Email存在 Password不合法

				}

			} else {
				out.print("0"); // 用on返回，用户名和Email都不存在 Password不合法

			}

		}

		out.close();

	}

	// 验证Nickname的合法性
	@RequestMapping("checkNickName.do")
	public void checkNickName(HttpServletResponse resp, String nickName)
			throws Exception {

		System.out
				.println("----------------------checkcheckNickName.do-------------------");
		PrintWriter out;
		out = resp.getWriter();
		List<UserInfo> listUserInfo = this.userInfoService
				.findUserByNickName(nickName);

		if (listUserInfo.size() > 0) {
			out.print("0");// 此Nickname已存在
		} else {
			out.print("1");// 此Nickname可用
		}

		out.close();

	}

	/**
	 * 
	 * 
	 * @author swh
	 * 
	 * @date 2014-9-3
	 * 
	 * @param ajax登录
	 *            , 验证Password是否匹配
	 */
	@RequestMapping("checkUserPassword.do")
	public void checkUserPassword(HttpServletResponse resp, String userName,
			String passWord) throws Exception {

		System.out
				.println("-----------------------checkUserPassword.do--------------------------");

		List<UserInfo> listUserInfo = userInfoService.findUserByName(userName);
		List<UserInfo> listUserInfo1 = userInfoService
				.findUserByEmail(userName);

		PrintWriter out;
		out = resp.getWriter();

		if ((listUserInfo.size() <= 0) && (listUserInfo1.size() <= 0)) {

			out.print("0"); // 用on返回，用户名和Email都不存在 Password不合法

		} else {

			String password = Password.createPassword(passWord);

			if (userInfoService.checkExistUserByName(userName, password)
					|| userInfoService
							.checkExistUserByEmail(userName, password)) {

				out.print("ok"); // 用on返回，用户名或Email存在 Password合法

			} else {
				out.print("1"); // 用on返回，用户名或Email存在 Password不合法

			}

		}

		out.close();

	}

	/**
	 * 
	 * @author 乐风
	 * 
	 * @author Robust
	 * 
	 * 
	 * @date 2014年9月15日
	 * 
	 * @param request
	 * @param response
	 * @param userInfo
	 * @return
	 * @throws Exception
	 */

	@RequestMapping(value = "/login.do" , method = RequestMethod.POST )
	public String login(HttpServletRequest request, HttpServletResponse response/*
																				 * ,
																				 * String
																				 * userName
																				 * ,
																				 * String
																				 * password
																				 */)
			throws Exception {

		HttpSession session = request.getSession();
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		if (userName == null) {
			request.setAttribute("result", "Please Enter User Name");
			return "/web/ERROR/result";
		}
		List<UserInfo> loginUserList = null;
		// 判断用的是用户名登录还是Email登录

		if (!userName.contains("@")) {
			// 用户名登录
			loginUserList = userInfoService.findUserByName(userName);
		} else {
			// email登录
			loginUserList = userInfoService.findUserByEmail(userName);

		}

		if (loginUserList.size() < 1) {
			request.setAttribute("result", "User name or password is incorrect");
			return "web/ERROR/result";
		}

		UserInfo loginUser = loginUserList.get(0);
		String loginName = loginUser.getUserName();

		// TODO
		// 验证是否激活
		if (loginUser.getUser_show() == null) {
			request.setAttribute("result",
					"Your account has not been activated" + loginUser.getE_mail() + "Activate the account！");
			return "web/ERROR/result";
		}

		if (!loginUser.getUser_show().equalsIgnoreCase("0")) {
			request.setAttribute("result",
					"Your account has not been activated" + loginUser.getE_mail() + "Activate the account！");
			return "web/ERROR/result";
		}

		if (loginUserList.size() > 1) {
			System.out.print("same name user");
		}
		// 验证Password
		if (loginUser.getPassword().equals(Password.createPassword(password))) {

			System.out.println("userlogin");
			// 将用户名存入session
			SessionListener.isLogined(session, loginName);
			request.getSession().setAttribute("userInfo",this.userInfoService.findById(loginUser.getId()));
			request.getSession().setAttribute("applyerName",
					loginUser.getUserName());
			// 更新最后登录时间
			loginUser.setLastLogin_date(getNowTime());
			// 更新等级
			loginUser.setUserLevel(ScoreLevel.scoreLevel(loginUser
					.getJinzhuan() + ""));

			userInfoService.updateUserInfo(loginUser);
			/*
			 * String strBackUrl = (String) request.getSession().getAttribute(
			 * "strBackUrl");
			 */
			String str = (String) request.getSession().getAttribute("strBackUrl");
			String strBackUrl = request.getParameter("login_href");
			String regex = "([\u4e00-\u9fa5]+)";

			if (strBackUrl != null && strBackUrl != "") {
				int begin = strBackUrl.indexOf("web/Blog");
				Matcher matcher = Pattern.compile(regex).matcher(strBackUrl);
				if (matcher.find() && begin > 0) {
					return "redirect:/web/Blog/"
							+ URLEncoder.encode(loginUser.getNickName(),
									"UTF-8");
				} else {
					return "redirect:" + strBackUrl;
				}
			}else{
				if(str!=null){
					return "redirect:"+str;
				}
			}
			return "redirect:toIndexHome";
			/*
			 * if (strBackUrl != null && strBackUrl != "") { return "redirect:"
			 * + strBackUrl; }
			 */

			/* return "redirect:toIndexHome"; */
		}

		else {
			request.setAttribute("result", "User name or password is incorrect");
			return "web/ERROR/result";
		}
	}

	/**
	 * 
	 * @author 乐风
	 * 
	 * @date 2014-8-15
	 * 
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value = "logout.do")
	public String logout(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		UserInfo userInfo = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		if (userInfo != null) {
			if (SessionListener.isOnline(request.getSession(),
					String.valueOf(userInfo.getId()))) {
				System.out
						.println("--------------------------用户已经掉线-------------------------------");

			} else {
				/*
				 * request.getSession().removeAttribute("applyerName");
				 * request.getSession().removeAttribute("loginUser"); long id =
				 * userInfo.getId();
				 */

				SessionListener.deleteUserName(request.getSession(),
						userInfo.getUserName(), userInfo);

				System.out
						.println("-------------------------------该用户已经退出---------------------------");

			}
		}
		return "redirect:toIndexHome";
	}

	/* 用户资料 */
	/**
	 * 查看用户资料
	 * 
	 * @author Robust
	 * 
	 * @date 2014年10月31日
	 * 
	 * @param request
	 * @param response
	 * @param personInfo
	 * @return
	 */
	@RequestMapping(value = "/u/detail/{id}.html", method = RequestMethod.GET)
	public String listDetail(HttpServletRequest request,
			HttpServletResponse response, PersonalInfo personInfo,
			@PathVariable long id) {
		UserInfo blogUser = this.userInfoService.findById(id);
		request.setAttribute("blogUser", blogUser);

		if (personalInfoService.findById(id) != null) {
			personInfo = personalInfoService.findById(id);
		} else {
			personInfo = new PersonalInfo();
			personInfo.setId(id);
			this.personalInfoService.savePersonalInfo(personInfo);
		}
		request.setAttribute("personInfo", personInfo);

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

		return "/web/PersonalInfo/personalInfo";

	}

	@RequestMapping(value = "/u/setting/{pType}", method = RequestMethod.GET)
	public String modifypersonalinfomore(HttpServletRequest request,
			HttpServletResponse response, PersonalInfo personInfo,
			@PathVariable String pType, String modify) {

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

		long id = loginUser.getId();

		if (personalInfoService.findById(id) != null) {
			personInfo = personalInfoService.findById(id);
		} else {
			personInfo = new PersonalInfo();
			personInfo.setId(id);
			this.personalInfoService.savePersonalInfo(personInfo);
		}

		if (pType.equals("protect")) {
			if (this.userSecurityService.listUserSecurityByUserId(id).size() > 0) {
				List<UserSecurity> listUserSecurity = this.userSecurityService
						.listUserSecurityByUserId(id);

				request.setAttribute("listUserSecurity",
						listUserSecurity.get(0));
			} else {
				request.setAttribute("listUserSecurity", null);
			}
		}

		request.setAttribute("personInfo", personInfo);

		request.setAttribute("modifySuccess", modify);

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
		}
		request.setAttribute("newMsgCount", newMsg);

		return "../../web/UserSetting/" + pType;

	}

	@RequestMapping(value = "/u/update/{pType}")
	public String updatePersonInfo(HttpServletRequest request,
			HttpServletResponse response, PersonalInfo personInfo,
			@PathVariable String pType) {

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

		long id = loginUser.getId();

		PersonalInfo NewpersonInfo = personalInfoService.findById(id);

		if (pType.equalsIgnoreCase("basic")) {

			// basic
			// info
			NewpersonInfo.setSex(personInfo.getSex());
			NewpersonInfo.setBirthday(personInfo.getBirthday());
			NewpersonInfo.setShengao(personInfo.getShengao());
			NewpersonInfo.setJiguan(personInfo.getJiguan());
			NewpersonInfo.setAddress(personInfo.getAddress());
			NewpersonInfo.setTizhong(personInfo.getTizhong());
			NewpersonInfo.setXuexing(personInfo.getXuexing());
			NewpersonInfo.setGuoji(personInfo.getGuoji());
			if (personInfo.getPersonalDesc().length() < 101) {
				NewpersonInfo.setPersonalDesc(personInfo.getPersonalDesc());
			} else {
				request.setAttribute("result", "Words of profile over the limit");
				return "../../web/ERROR/result";
			}
			// infoShare
			NewpersonInfo.setBirthdayShare(personInfo.getBirthdayShare());
			NewpersonInfo.setShengaoShare(personInfo.getShengaoShare());
			NewpersonInfo.setJiguanShare(personInfo.getJiguanShare());
			NewpersonInfo.setAddressShare(personInfo.getAddressShare());
			NewpersonInfo.setDescShare(personInfo.getDescShare());
			NewpersonInfo.setTizhongShare(personInfo.getTizhongShare());
			NewpersonInfo.setXuexingShare(personInfo.getXuexingShare());
			NewpersonInfo.setGuojiShare(personInfo.getGuojiShare());
		} else if (pType.equalsIgnoreCase("details")) {
			// info
			NewpersonInfo.setRealname(personInfo.getRealname());
			NewpersonInfo.setIdno(personInfo.getIdno());
			NewpersonInfo.setAihao(personInfo.getAihao());
			NewpersonInfo.setShanchang(personInfo.getShanchang());
			NewpersonInfo.setMarry(personInfo.getMarry());
			NewpersonInfo.setZongjiao(personInfo.getZongjiao());
			NewpersonInfo.setPhone(personInfo.getPhone());

			String[] listXingGe = request.getParameterValues("xingge");
			String xingge = "";
			if (listXingGe.length > 0) {
				for (int i = 0; i < listXingGe.length; i++) {
					xingge = xingge + listXingGe[i] + ";  ";
				}
			}
			NewpersonInfo.setXingge(xingge);

			// infoShare
			NewpersonInfo.setRealnameShare(personInfo.getRealnameShare());
			NewpersonInfo.setIdnoShare(personInfo.getIdnoShare());
			NewpersonInfo.setAihaoShare(personInfo.getAihaoShare());
			NewpersonInfo.setShanchangShare(personInfo.getShanchangShare());
			NewpersonInfo.setMarryShare(personInfo.getMarryShare());
			NewpersonInfo.setZongjiao(personInfo.getZongjiaoShare());
			NewpersonInfo.setPhoneShare(personInfo.getPhoneShare());
			NewpersonInfo.setXinggeShare(personInfo.getXinggeShare());
		}

		else if (pType.equalsIgnoreCase("education")) {
			// info
			NewpersonInfo.setGraduate(personInfo.getGraduate());
			NewpersonInfo.setZhuanye(personInfo.getZhuanye());
			NewpersonInfo.setXueli(personInfo.getXueli());
			NewpersonInfo.setDegree(personInfo.getDegree());
			// infoShare
			NewpersonInfo.setGraduateShare(personInfo.getGraduateShare());
			NewpersonInfo.setZhuanyeShare(personInfo.getZhuanyeShare());
			NewpersonInfo.setXueliShare(personInfo.getXueliShare());
			NewpersonInfo.setXueweiShare(personInfo.getXueweiShare());
		} else if (pType.equalsIgnoreCase("career")) {
			// info
			NewpersonInfo.setCompany(personInfo.getCompany());
			NewpersonInfo.setHangye(personInfo.getHangye());
			NewpersonInfo.setJob(personInfo.getJob());
			NewpersonInfo.setWorkYear(personInfo.getWorkYear());
			NewpersonInfo.setJobLevel(personInfo.getJobLevel());
			if (personInfo.getJobPlan().length() < 101) {
				NewpersonInfo.setJobPlan(personInfo.getJobPlan());
			} else {
				request.setAttribute("result", "Words of profile over the limit");
				return "../../web/ERROR/result";
			}

			// infoShare
			NewpersonInfo.setCompanyShare(personInfo.getCompanyShare());
			NewpersonInfo.setHangyeShare(personInfo.getHangyeShare());
			NewpersonInfo.setJobShare(personInfo.getJobShare());
			NewpersonInfo.setWorkYearShare(personInfo.getWorkYearShare());
			NewpersonInfo.setJobLevelShare(personInfo.getJobLevelShare());
			NewpersonInfo.setJobPlanShare(personInfo.getJobPlanShare());

		}

		String modifySuccess;
		try {
			// update
			personalInfoService.updatePersonalInfo(NewpersonInfo);
			modifySuccess = "success";
		} catch (Exception e) {
			modifySuccess = "error";
		}

		return "redirect:../setting/" + pType + "?modify=" + modifySuccess;
	}

	// TODO 更新个人资料

	@RequestMapping(value = "showProtectPassword.do", method = RequestMethod.GET)
	public String showProtectPassword(HttpServletRequest request,
			HttpServletResponse response, long id) {
		// 验证用户身份
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		if ((userInfo != null && userInfo.getId() != id) || userInfo == null) {
			request.setAttribute("result", "error");
			return "web/ERROR/result";
		}

		if (this.userSecurityService.listUserSecurityByUserId(id).size() > 0) {
			List<UserSecurity> listUserSecurity = this.userSecurityService
					.listUserSecurityByUserId(id);

			request.setAttribute("listUserSecurity", listUserSecurity.get(0));
		} else {
			request.setAttribute("listUserSecurity", null);
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
			// 更新session
			request.getSession().setAttribute("userInfo",this.userInfoService.findById(loginUser.getId()));
		}
		request.setAttribute("newMsgCount", newMsg);

		return "web/user/protectpassword";

	}

	// 上传头像
	@RequestMapping(value = "uploadHeadImg.do", method = RequestMethod.POST)
	public String uploadHeadImg(HttpServletRequest request,
			HttpServletResponse response, MultipartFile file) {

		// 用户设置图像

		if (file.getOriginalFilename() != null) {

			String fileName = file.getOriginalFilename();
			String type = fileName.substring(fileName.lastIndexOf(".") + 1);
			String realName = fileName.substring(0, fileName.lastIndexOf("."));

			Date date = new Date();
			SimpleDateFormat f = new SimpleDateFormat("yyyyMMddHHmmss");
			String fileTime = f.format(date);

			fileName = realName + fileTime + Math.round(Math.random() * 9)
					+ "." + type;

			System.out.println("----------------------------type:" + type
					+ "---------------------------");
			if (!type.equals("jpg") && !type.equals("bmp")
					&& !type.equals("gif") && !type.equals("png")
					&& !type.equals("jpeg")) {
				request.setAttribute("result", "Picture format error");
				return "web/ERROR/result";
			}
			String realPath1 = request.getSession().getServletContext()
					.getRealPath("web/home/head");

			// 存入照片
			try {
				FileUtils.copyInputStreamToFile(file.getInputStream(),
						new File(realPath1, fileName));
				// 相片路径
				String realPath = realPath1 + "\\" + fileName;

				// 设置头像的长宽
				BufferedImage originalImage = ImageIO.read(new FileInputStream(
						realPath));
				int width = originalImage.getWidth();
				int height = originalImage.getHeight();
				if (originalImage.getWidth() > 300)
					width = 300;
				if (originalImage.getHeight() > 300)
					height = 300;
				BufferedImage picture = new BufferedImage(width, height,
						originalImage.getType());
				picture.getGraphics().drawImage(originalImage, 0, 0, width,
						height, null);
				FileOutputStream out1 = null;
				out1 = new FileOutputStream(realPath);
				JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out1);
				encoder.encode(picture);

				int beginIndex = realPath.lastIndexOf("web");
				realPath = realPath.substring(beginIndex, realPath.length());
				request.setAttribute("head", realPath.replace("\\", "/"));

				// 私信
				UserInfo loginUser = (UserInfo) request.getSession()
						.getAttribute("userInfo");
				int newMsg = 0;
				if (loginUser != null) {

					String messageSql = "from Message where userInfo1.id = '"
							+ loginUser.getId() + "' and isRead = '0'";
					List<Message> messageList = messageService
							.listMessageBySql(messageSql);
					newMsg = messageList.size();
					// 更新session
					request.getSession().setAttribute("userInfo",this.userInfoService.findById(loginUser.getId()));
				}
				request.setAttribute("newMsgCount", newMsg);

				return "web/UserSetting/portrait";

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("result", "error");
				return "web/ERROR/result";
			}
		} else {
			request.setAttribute("result", "error");
			return "web/ERROR/result";
		}

	}

	@RequestMapping(value = "saveHeadImg.do", method = RequestMethod.GET)
	public String saveHeadImg(HttpServletRequest request,
			HttpServletResponse response, String head) {
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute(
				"userInfo");

		if (userInfo != null) {
			if (head.length() > 0) {
				userInfo.setHeadImg(head);
				this.userInfoService.updateUserInfo(userInfo);
			}
			return "redirect:/u/setting/portrait";
		} else {
			request.setAttribute("result", "error");
			return "web/ERROR/result";
		}

	}

	@RequestMapping(value = "addProtectPassword.do", method = RequestMethod.POST)
	public String addProtectPassword(HttpServletRequest request,
			HttpServletResponse response) {

		UserSecurity userSecurity = new UserSecurity();
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		userSecurity.setUserInfo(userInfo);
		String question1 = request.getParameter("question1").trim();
		String answer1 = request.getParameter("answer1").trim();
		String question2 = request.getParameter("question2").trim();
		String answer2 = request.getParameter("answer2").trim();
		String question3 = request.getParameter("question3").trim();
		String answer3 = request.getParameter("answer3").trim();
		if (question1 == "" || question2 == "" || question3 == ""
				|| answer1 == "" || answer2 == "" || answer3 == "") {
			request.setAttribute("result", "error");
			return "web/ERROR/result";
		}
		userSecurity.setAnswer1(answer1);
		userSecurity.setAnswer2(answer2);
		userSecurity.setAnswer3(answer3);
		userSecurity.setQuestion1(question1);
		userSecurity.setQuestion2(question2);
		userSecurity.setQuestion3(question3);
		this.userSecurityService.saveUserSecurity(userSecurity);

		return "redirect:u/setting/protect";

	}

	@RequestMapping(value = "ToUpdatepassword.do", method = RequestMethod.GET)
	public String ToUpdatepassword(HttpServletRequest request,
			HttpServletResponse response) {
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
			request.getSession().setAttribute("userInfo",this.userInfoService.findById(loginUser.getId()));
		}
		request.setAttribute("newMsgCount", newMsg);
		return "web/user/updatepassword";
	}

	@RequestMapping(value = "updatePassword.do", method = RequestMethod.POST)
	public String updatePassword(HttpServletRequest request,
			HttpServletResponse response) {
		System.out
				.println("-----------------------updatePassword.do------------");
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		String oldpass = request.getParameter("oldpass").trim();
		String password1 = request.getParameter("newpass1").trim();
		String password2 = request.getParameter("newpass2").trim();
		String result;
		// 检验原Password是否正确
		String password = Password.createPassword(oldpass);
		if (!userInfoService.checkExistUserByName(userInfo.getUserName(),
				password)) {
			result = "error";
			return "redirect:u/setting/password?modify=" + result;
		}
		// 检验新Password是否合格
		if (password1.length() < 6) {
			result = "error";
			return "redirect:u/setting/password?modify=" + result;
		}
		// 检验两个新Password是否一致
		if (!password1.equals(password2)) {
			result = "error";
			return "redirect:u/setting/password?modify=" + result;
		}

		this.userInfoService.updatePassword(userInfo.getUserName(),
				Password.createPassword(password1));

		result = "success";
		return "redirect:u/setting/password?modify=" + result;

	}

	@RequestMapping(value = "getProtectQuestion.do", method = RequestMethod.GET)
	public @ResponseBody
	String getProtectQuestion(HttpServletRequest request,
			HttpServletResponse response, String userName) {

		UserInfo user = new UserInfo();
		List<UserInfo> listUser1 = this.userInfoService
				.findUserByEmail(userName);
		List<UserInfo> listUser2 = this.userInfoService
				.findUserByName(userName);
		if (listUser1.size() < 1 && listUser2.size() < 1) {
			return "null";// Username does not exist
		} else {
			if (listUser1.size() > 0)
				user = listUser1.get(0);
			else
				user = listUser2.get(0);

			List<UserSecurity> listUserSecurity = this.userSecurityService
					.listUserSecurityByUserId(user.getId());
			if (listUserSecurity.size() < 1)
				return "null";// No Security Question
			else {

				List<String> protectQuestion = new ArrayList<String>();
				protectQuestion.add(listUserSecurity.get(0).getQuestion1());
				protectQuestion.add(listUserSecurity.get(0).getQuestion2());
				protectQuestion.add(listUserSecurity.get(0).getQuestion3());

				net.sf.json.JSONArray jsonArray = net.sf.json.JSONArray
						.fromObject(protectQuestion);
				String jsonProtectQues = jsonArray.toString();

				return jsonProtectQues;

			}
		}

	}

	@RequestMapping(value = "ToGetBackPwd.do", method = RequestMethod.GET)
	public String ToGetBackPwd(HttpServletRequest request,
			HttpServletResponse response) {
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
			request.getSession().setAttribute("userInfo",this.userInfoService.findById(loginUser.getId()));
		}
		request.setAttribute("newMsgCount", newMsg);
		return "web/UserSetting/getBackPassword";
	}

	@RequestMapping(value = "updatePWDbyQuestion.do", method = RequestMethod.POST)
	public String updatePWDbyQuestion(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			UserInfo user = new UserInfo();
			String userName = request.getParameter("userName");
			int question = Integer.parseInt(request.getParameter("question"));
			String answer = request.getParameter("answer").trim();
			String password1 = request.getParameter("newpass1").trim();
			String password2 = request.getParameter("newpass2").trim();

			// 检验问题是否正确
			List<UserInfo> listUser1 = this.userInfoService
					.findUserByEmail(userName);
			List<UserInfo> listUser2 = this.userInfoService
					.findUserByName(userName);
			if (listUser1.size() < 1 && listUser2.size() < 1) {
				request.setAttribute("result", "Username does not exist");
				return "web/ERROR/result";// Username does not exist
			} else {
				if (listUser1.size() > 0)
					user = listUser1.get(0);
				else
					user = listUser2.get(0);

				List<UserSecurity> listUserSecurity = this.userSecurityService
						.listUserSecurityByUserId(user.getId());
				if (listUserSecurity.size() < 1) {
					request.setAttribute("result", "No Security Question");
					return "web/ERROR/result";
				}// No Security Question
				else {

					if ((question == 0 && answer.equals(listUserSecurity.get(0)
							.getAnswer1()))
							|| (question == 1 && answer.equals(listUserSecurity
									.get(0).getAnswer2()))
							|| (question == 2 && answer.equals(listUserSecurity
									.get(0).getAnswer3()))) {

					} else {

						return "redirect:login.html";
					}
				}

			}
			// 检验新Password是否合格
			if (password1.length() < 6) {
				request.setAttribute("result", "Password at least 6 digits！");
				return "web/ERROR/result";
			}
			// 检验两个新Password是否一致
			if (!password1.equals(password2)) {
				request.setAttribute("result", "两个新Passwords are unsame！");
				return "web/ERROR/result";
			}

			this.userInfoService.updatePassword(userName,
					Password.createPassword(password1));
			request.setAttribute("result", "Changed successfully！");
			return "web/ERROR/result";

		} catch (Exception e) {

			request.setAttribute("result", "error");
			return "web/ERROR/result";

		}

	}

	@RequestMapping(value = "addFriend.do", method = RequestMethod.GET)
	public String addFriend(HttpServletRequest request,
			HttpServletResponse response, long guest_id)
			throws UnsupportedEncodingException {

		UserInfo loginUser = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		// 查看是否登录
		if (loginUser == null) {
			String strBackUrl = "http://" + request.getServerName() // 服务器地址
					+ ":" + request.getServerPort() // 端口号
					+ request.getContextPath() // 项目名称
					+ request.getServletPath() // 请求页面或其他地址
					+ "?" + (request.getQueryString()); // 参数
			request.getSession().setAttribute("strBackUrl", strBackUrl);
			return "redirect:login.html";
		}
		UserInfo guest = userInfoService.findById(guest_id);

		/*
		 * String listFriendForCheckExist = "from Friend where userInfo1.id = '"
		 * + guest_id + "' and userInfo2.id = '" + loginUser.getId() + "'";
		 */
		List<Friend> listFriend = friendService.IsFriend(guest_id,
				loginUser.getId());

		if (listFriend.size() > 0) {
			System.out.println("已关注");
		}

		addFriend(request, guest_id);

		return "redirect:/web/Blog/"
				+ URLEncoder.encode(guest.getNickName(), "UTF-8");

	}

	@RequestMapping(value = "deleteFriend.do", method = RequestMethod.GET)
	public String deleteFriend(HttpServletRequest request,
			HttpServletResponse response, long guest_id)
			throws UnsupportedEncodingException {

		UserInfo loginUser = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		// 查看是否登录
		if (loginUser == null) {
			String strBackUrl = "http://" + request.getServerName() // 服务器地址
					+ ":" + request.getServerPort() // 端口号
					+ request.getContextPath() // 项目名称
					+ request.getServletPath() // 请求页面或其他地址
					+ "?" + (request.getQueryString()); // 参数
			request.getSession().setAttribute("strBackUrl", strBackUrl);
			return "redirect:login.html";
		}
		UserInfo guest = userInfoService.findById(guest_id);

		/*
		 * String listFriendForCheckExist = "from Friend where userInfo1.id = '"
		 * + guest_id + "' and userInfo2.id = '" + loginUser.getId() + "'";
		 */
		List<Friend> listFriend = friendService.IsFriend(loginUser.getId(),
				guest_id);
		System.out.println(listFriend.size());
		if (listFriend.size() > 0) {

			deleteFriend(request, guest_id);
		}
		return "redirect:/web/Blog/"
				+ URLEncoder.encode(guest.getNickName(), "UTF-8");

	}

	/* FRIEND */

	@RequestMapping(value = "addFriendInPerShow.do", method = RequestMethod.GET)
	public String addFriendInPerShow(HttpServletRequest request,
			HttpServletResponse response, long guest_id) {

		addFriend(request, guest_id);

		return "redirect:/PersonInfo?id=" + guest_id;

	}

	@RequestMapping(value = "deleteFriendInPerShow.do", method = RequestMethod.GET)
	public String deleteFriendInPerShow(HttpServletRequest request,
			HttpServletResponse response, long guest_id) {

		deleteFriend(request, guest_id);

		return "redirect:/PersonInfo?id=" + guest_id;

	}

	// article页面添加删除好友
	@RequestMapping(value = "addFriendInArticle.do", method = RequestMethod.GET)
	public String addFriendInArticle(HttpServletRequest request,
			HttpServletResponse response, long guest_id, long logId) {

		addFriend(request, guest_id);

		return "redirect:/web/Blog/article/" + logId;

	}

	@RequestMapping(value = "deleteFriendInArticle.do", method = RequestMethod.GET)
	public String deleteFriendInArticle(HttpServletRequest request,
			HttpServletResponse response, long guest_id, long logId) {

		deleteFriend(request, guest_id);

		return "redirect:/web/Blog/article/" + logId;

	}

	// attachDetail页面添加删除好友
	@RequestMapping(value = "addFriendInAttach.do", method = RequestMethod.GET)
	public String addFriendInAttach(HttpServletRequest request,
			HttpServletResponse response, long guest_id, long id) {

		addFriend(request, guest_id);

		return "redirect:/web/Blog/AttachDetail/" + id;

	}

	@RequestMapping(value = "deleteFriendInAttach.do", method = RequestMethod.GET)
	public String deleteFriendInAttach(HttpServletRequest request,
			HttpServletResponse response, long guest_id, long id) {

		deleteFriend(request, guest_id);

		return "redirect:/web/Blog/AttachDetail/" + id;

	}

	// detail页面添加删除好友
	@RequestMapping(value = "addFriendInDetail.do", method = RequestMethod.GET)
	public String addFriendInDetail(HttpServletRequest request,
			HttpServletResponse response, long guest_id, long id) {

		addFriend(request, guest_id);

		return "redirect:/web/Blog/Attach/" + id;

	}

	@RequestMapping(value = "deleteFriendInDetail.do", method = RequestMethod.GET)
	public String deleteFriendInDetail(HttpServletRequest request,
			HttpServletResponse response, long guest_id, long id) {

		deleteFriend(request, guest_id);

		return "redirect:/web/Blog/Attach/" + id;

	}

	public void addFriend(HttpServletRequest request, long guest_id) {
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		// 判断是否已关注
		if (userInfo != null
				&& this.friendService.IsFriend(userInfo.getId(), guest_id)
						.size() < 1) {
			Friend friend = new Friend();
			friend.setUserInfo2(userInfo);
			friend.setUserInfo1(this.userInfoService.findById(guest_id));
			this.friendService.saveFriend(friend);

			// 发送信息给被关注者
			MessageText messageText = new MessageText();
			messageText.setMsgSubject("System Messages");
			String nowTime = getNowTime();
			messageText.setMsgContent(userInfo.getNickName() + " on  " + nowTime
					+ "  Followed you！");
			messageText.setMsgTime(nowTime);
			messageText.setMsgType("0");
			this.messageTextService.saveMessageText(messageText);
			// 设置发送信息对象
			Message message = new Message();
			message.setIsRead("0");
			message.setMessageText(messageText);
			// 获取管理员信息
			List<UserInfo> userInfoList = userInfoService
					.findUserByName("admin");
			UserInfo admin = userInfoList.get(0);
			// 设置发信人为管理员
			message.setUserInfo2(admin);
			message.setUserInfo1(this.userInfoService.findById(guest_id));
			// 发送信息
			this.messageService.saveMessage(message);
		}
	}

	@RequestMapping(value = "addFriendInHome.do")
	public String addFriendInHome(HttpServletRequest request, long guest_id)
			throws UnsupportedEncodingException {
		addFriend(request, guest_id);
		UserInfo guest = this.userInfoService.findById(guest_id);
		// System.out.println("guest.getNickName();========================================="+guest.getNickName());
		return "redirect:web/Blog/"
				+ URLEncoder.encode(guest.getNickName(), "UTF-8");

	}

	@RequestMapping(value = "deleteFriendInHome.do")
	public String deleteFriendInHome(HttpServletRequest request, long guest_id)
			throws UnsupportedEncodingException {
		deleteFriend(request, guest_id);
		UserInfo guest = this.userInfoService.findById(guest_id);

		return "redirect:web/Blog/"
				+ URLEncoder.encode(guest.getNickName(), "UTF-8");

	}

	@RequestMapping("ajaxFriend.do")
	public void ajaxFriend(HttpServletRequest request,
			HttpServletResponse response, long id) throws Exception {

		PrintWriter out;
		out = response.getWriter();
		UserInfo loginUser = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		UserInfo blogUser = this.userInfoService.findById(id);

		if (loginUser == null) {
			out.print("0");// 没有登录
		}
		List<Friend> listFriend = this.friendService.IsFriend(
				loginUser.getId(), blogUser.getId());
		if (listFriend.size() > 0) {
			// 取消关注
			this.friendService.deleteFriend(listFriend.get(0).getId());
			out.print("delete");
		} else {
			Friend friend = new Friend();
			friend.setUserInfo2(loginUser);
			friend.setUserInfo1(blogUser);
			this.friendService.saveFriend(friend);
			// 发送信息给被关注者
			MessageText messageText = new MessageText();
			messageText.setMsgSubject("System Messages");
			String nowTime = getNowTime();
			messageText.setMsgContent(loginUser.getNickName() + " on  "
					+ nowTime + "  Followed you！");
			messageText.setMsgTime(nowTime);
			messageText.setMsgType("0");
			this.messageTextService.saveMessageText(messageText);
			// 设置发送信息对象
			Message message = new Message();
			message.setIsRead("0");
			message.setMessageText(messageText);
			// 获取管理员信息
			List<UserInfo> userInfoList = userInfoService
					.findUserByName("admin");
			UserInfo admin = userInfoList.get(0);
			// 设置发信人为管理员
			message.setUserInfo2(admin);
			message.setUserInfo1(blogUser);
			// 发送信息
			this.messageService.saveMessage(message);
			out.print("add");

		}
		out.close();

	}

	public void deleteFriend(HttpServletRequest request, long guest_id) {
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute(
				"userInfo");

		if (userInfo != null
				&& this.friendService.IsFriend(userInfo.getId(), guest_id)
						.size() > 0) {
			List<Friend> listFriend = this.friendService.IsFriend(
					userInfo.getId(), guest_id);
			if (listFriend.size() > 0) {
				this.friendService.deleteFriend(listFriend.get(0).getId());
			}
		}
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
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowTime = f.format(date);

		return nowTime;
	}

	@RequestMapping(value = "agree.do")
	public String agree(HttpServletRequest request, HttpServletResponse response) {

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
			request.getSession().setAttribute("userInfo",this.userInfoService.findById(loginUser.getId()));
		}
		request.setAttribute("newMsgCount", newMsg);
		return "web/user/register";

	}

	@RequestMapping(value = "unagree.do")
	public String unagree(HttpServletRequest request,
			HttpServletResponse response) {

		return "redirect:/toIndexHome";

	}

	// 联系客服
	@RequestMapping(value = "contact.do")
	public String yijian(HttpServletRequest request,
			HttpServletResponse response) {
		UserInfo loginUser = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		// 查看是否登录
		if (loginUser == null) {
			String strBackUrl = "http://" + request.getServerName() // 服务器地址
					+ ":" + request.getServerPort() // 端口号
					+ request.getContextPath() // 项目名称
					+ request.getServletPath() // 请求页面或其他地址
					+ "?" + (request.getQueryString()); // 参数
			request.getSession().setAttribute("strBackUrl", strBackUrl);
			return "redirect:login.html";
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
			request.getSession().setAttribute("userInfo",this.userInfoService.findById(loginUser.getId()));
		}
		request.setAttribute("newMsgCount", newMsg);

		return "/web/management/Suggestion/addAdvice";
	}
	
	//专门用来测试邮件发送功能
@RequestMapping(value="testMail.do")
public void textMail(HttpServletRequest request){
	String esmtp = "mail.youshizhishi.com"; //stmp.qq.com
	String efrom = "sflc3@youshizhishi.com";
	String eto = "lzw4284@163.com"; // userInfo.getE_mail()
	String ecopyto = ""; // 抄送人
	String esubject = "Unionjoyers    Registration confirmation";// 邮件主题
	String econtent = "test"; // 邮件内容
	String eusername = "sflc3@youshizhishi.com";
	String epassword = "jiechenfazhan";
	String efilename = ""; // 附件路径，如：F:\\笔记<a>\\struts2</a>与mvc.txt
	boolean emailresult = Mail.send(esmtp, efrom, eto, esubject,
			econtent, eusername, epassword);
	
}


	public String getMailContent(String userName, String nickName, String url) {
		String ContentModel = "<table width='750' border='0' align='center' cellpadding='0' cellspacing='0' style='color:#000000;font-family:lucida Grande, Verdana, Microsoft YaHei;font-size:13.63636302948px;margin:0px auto;background-color:#FFFFFF;' class='ke-zeroborder'>"
				+ "<tbody>"
				+ "<tr>"
				+ "<td style='font-family:lucida Grande, Verdana, Microsoft YaHei;'>"
				+ "<table width='750' border='0' cellspacing='0' cellpadding='0' class='ke-zeroborder'>"
				+ "<tbody>"
				+ "<tr>"
				+ "<td colspan='3' style='font-family:lucida Grande, Verdana, Microsoft YaHei;'>"
				+ "<table width='750' border='0' cellspacing='0' cellpadding='0' class='ke-zeroborder'>"
				+ "<tbody>"
				+ "<tr>"
				+ "<td style='font-family:lucida Grande, Verdana, Microsoft YaHei;'>"
				+ "<br />"
				+ "</td>"
				+ "<td width='550' style='font-family:lucida Grande, Verdana, Microsoft YaHei;'>&nbsp;"
				+

				"</td>"
				+ "</tr></tbody></table></td>	</tr><tr>"
				+ "<td colspan='3' style='font-family:lucida Grande, Verdana, Microsoft YaHei;'>	<table width='750' border='0' cellspacing='0' cellpadding='0' class='ke-zeroborder'>									<tbody>										<tr>											<td width='40' height='90' style='font-family:lucida Grande, Verdana, Microsoft YaHei;'>												&nbsp;											</td>											<td style='font-family:微软雅黑, 宋体;font-size:20px;font-weight:700;color:#816439;text-align:center;'>"
				+ "Registration confirmation											</td>											<td width='40' style='font-family:lucida Grande, Verdana, Microsoft YaHei;'>"
				+ "	&nbsp;											</td>										</tr>									</tbody>"
				+ "	</table>							</td>						</tr>						<tr>							<td width='40' style='font-family:lucida Grande, Verdana, Microsoft YaHei;'>								&nbsp;							</td>							<td width='670' height='100' valign='top' style='font-family:lucida Grande, Verdana, Microsoft YaHei;'>								<table width='670' border='0' cellspacing='0' cellpadding='0' class='ke-zeroborder'>									<tbody>										<tr>											<td style='font-family:Arial, 宋体, Helvetica, sans-serif;font-size:14px;font-weight:700;color:#444040;'>"
				+ "		Dear user：											</td>										</tr>										<tr>											<td style='font-family:Arial, 宋体, Helvetica, sans-serif;font-size:14px;color:#444040;'>"
				+ "			Hello, please click on the verification link to complete the mail registration :<br />" + "<a href='"
				+ url
				+ "' target='_blank'>"
				+ url
				+ "</a><br />"
				+ "(Hello, please click on the verification link to complete the mail registration 。)"
				+ "</td>"
				+ "										</tr>"
				+ "										<tr>"
				+ "											<td style='font-family:lucida Grande, Verdana, Microsoft YaHei;border:1px solid #FDEEB8;color:#D28E5C;text-align:center;background-color:#FBF6E4;'>"
				+ "												Here is your important personal information. In order to secure your account, please save them securely."
				+ "											</td>"
				+ "										</tr>"
				+ "										<tr>"
				+ "											<td valign='middle' style='font-family:lucida Grande, Verdana, Microsoft YaHei;'>"
				+ "												<p style='color:#444040;'>"
				+ "													Account：<a target='_blank'>"
				+ userName
				+ "</a> "
				+ "												</p>"
				+ "												<p style='color:#444040;'>"
				+ "													Password：********************************"
				+ "												</p>"
				+ "												<p style='color:#444040;'>"
				+ "													Nickname："
				+ nickName
				+ "												</p>"
				+ "												<p style='color:#444040;'>"
				+ "													<br />"
				+ "												</p>"
				+ "		<p style='color:#847D7D;'>"
				+ "		in our dedicated service, improving customer satisfaction is our biggest goal, we would like to thank for your support and cooperation！！"
				+ "		</p>"
				+ "		<p style='text-align:right;color:#FF0000;'>"
				+ "		Unionjoyers"
				+ "		</p>"
				+ "		<p style='text-align:right;color:#FF0000;'>"
				+ "													<span>"
				+ getNowTime()
				+ "</span> "
				+ "												</p>"
				+ "											</td>"
				+ "										</tr>"
				+ "										<tr>"
				+ "											<td style='font-family:lucida Grande, Verdana, Microsoft YaHei;border:1px solid #FDEEB8;color:#D28E5C;text-align:center;background-color:#FBF6E4;'>"
				+ "												This message is automatically issued, please do not reply directly"
				+ "												</td>"
				+ "										</tr>"
				+ "									</tbody>"
				+ "								</table>"
				+ "							</td>"
				+ "							<td width='40' style='font-family:lucida Grande, Verdana, Microsoft YaHei;'>"
				+ "								&nbsp;"
				+ "							</td>			"
				+ "			</tr>"
				+ "					</tbody>"
				+ "				</table>"
				+ "			</td>"
				+ "		</tr>"
				+ "	</tbody>" + "</table>";

		return ContentModel;
	}

	// ---------------------------------------兑换管理-----------------------------------------
	@SuppressWarnings({ "unchecked" })
	@RequestMapping(value = "listCash.html")
	public String listCash(HttpServletRequest req, HttpServletResponse res,
			int record, String value) {

		List<Cash> listCash = new ArrayList<Cash>();
		String sql = null;
		String cash = null;
		if (value.equals("0")) {
			sql = "from Cash where isDeal = '0' order by date desc";
			cash = "0";
		} else {
			sql = "from Cash where isDeal = '1' order by dealDate desc";
			cash = "1";
		}
		req.setAttribute("cash", cash);
		try {
			listCash = cashService.listCashBySql(sql);
		} catch (NullPointerException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("发生异常的原因为   :" + e.getMessage());
		}

		int pageRecords = 20; // 每页显示的记录数,这个可以自己设定
		int allRecords = listCash.size(); // 总的记录
		int allPage = (allRecords - 1) / pageRecords + 1; // 总页数
		if (record > allPage) {
			record = allPage;
		}

		Pages pages = new Pages();
		listCash = pages.fenYe(listCash, pageRecords, record, allPage,
				allRecords);// 调用Pages的方法，进行分页
		req.setAttribute("record", record);// 当前页
		req.setAttribute("pageRecords", pageRecords);// 每页显示的记录数
		req.setAttribute("allPage", allPage);// 总的页数
		req.setAttribute("listCash", listCash);
		req.setAttribute("value", value);

		return "web/management/Cash/listCash";

	}

	// 受理兑换
	@RequestMapping(value = "dealCash.html")
	public String dealCash(HttpServletRequest req, HttpServletResponse res,
			long id, int record) {

		String sql = "from Cash where id = '" + id + "'";
		List<Cash> list = cashService.listCashBySql(sql);
		Cash cash = list.get(0);

		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("time now:" + df.format(date));
		String nowTime = df.format(date);

		cash.setIsDeal("1");
		cash.setDealDate(nowTime);
		cashService.updateCash(cash);
		String value = "0";
		return listCash(req, res, record, value);
	}

	@RequestMapping(value = "/cash/cashDeal.html")
	public String cashDeal(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {

		UserInfo loginUser = (UserInfo) request.getSession().getAttribute(
				"userInfo");
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
		}
		request.setAttribute("newMsgCount", newMsg);

		// 查看是否登录
		if (loginUser == null) {
			String strBackUrl = "http://" + request.getServerName() // 服务器地址
					+ ":" + request.getServerPort() // 端口号
					+ request.getContextPath() // 项目名称
					+ request.getServletPath() // 请求页面或其他地址
					+ "?" + (request.getQueryString()); // 参数
			request.getSession().setAttribute("strBackUrl", strBackUrl);
			return "redirect:login.html";
		}

		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("time now:" + df.format(date));
		String nowTime = df.format(date);

		// 交易所属的时间段，每个月只能兑换一次
		String cashDate = new SimpleDateFormat("yyyy-MM").format(date);

		String amount = request.getParameter("cash_size");
		Cash cash = new Cash();
		cash.setAmount(amount);
		cash.setDate(nowTime);
		cash.setUserInfo(loginUser);
		cash.setIsDeal("0");
		cash.setCashDate(cashDate);

		cashService.saveCash(cash);
		return "redirect:/web/Blog/"
				+ URLEncoder.encode(loginUser.getNickName(), "UTF-8");
	}

}
