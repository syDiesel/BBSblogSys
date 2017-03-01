/**
 * 
 */
package com.bbsBlog.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bbsBlog.entity.FilterWord;
import com.bbsBlog.entity.Label;
import com.bbsBlog.entity.Message;
import com.bbsBlog.entity.MessageText;
import com.bbsBlog.entity.UserInfo;
import com.bbsBlog.service.FilterWordService;
import com.bbsBlog.service.MessageService;
import com.bbsBlog.service.MessageTextService;
import com.bbsBlog.service.UserInfoService;
import com.bbsBlog.util.HtmlSpecialChars;
import com.bbsBlog.util.PageModel;

/**
 * @author Robust
 *
 * @date 2014年9月9日
 *
 */
@Controller
@RequestMapping("/web/PrivateMsg")
public class TextMessageController {

	@Resource
	private MessageService messageService;

	@Resource
	private MessageTextService messageTextService;

	@Resource
	private UserInfoService userInfoService;
	
	@Resource
	private FilterWordService filterWordService;

	private final String LIST_SENTBOX = "redirect:/web/PrivateMsg/sendBox";

	private final String LIST_RECBOX = "redirect:/web/PrivateMsg/RecBox";

	// =============================发送私信==========================、
	@RequestMapping(value="/toSendPM")
	public String toSend(HttpServletRequest request){
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

			

		return "sendPM";
	}
	/**
	 * 发送新私信
	 * 
	 * @author Robust
	 *
	 * @date 2014年9月11日
	 *
	 * @param request
	 * @param messageText
	 * @param sendId
	 * @param recName
	 * @return
	 */
	@RequestMapping(value = "/sendPM")
	public String sendPM(HttpServletRequest request, MessageText messageText,
			String recName) {
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

		if(StringUtils.isBlank(messageText.getMsgSubject())||StringUtils.isBlank(messageText.getMsgContent()))
		{
			request.setAttribute("result", "Private letter can not be empty");
			return "../ERROR/result";
		}
		
		//处理内容和标题的敏感词
		
		if (messageText.getMsgContent().trim() != null || messageText.getMsgContent().trim() != ""||messageText.getMsgSubject().trim() !=""||messageText.getMsgSubject().trim() !=null) {
			String msgContent = HtmlSpecialChars.htmlspecialchars(messageText.getMsgContent());
			String msgSubject = HtmlSpecialChars.htmlspecialchars(messageText.getMsgSubject());
			List<FilterWord> fw = filterWordService.listFilterWord();

			if (fw.size() > 0) {

				for (int i = 0; i < fw.size(); i++) {
					// System.out.println(fw.get(i).getFind()+"========================================tihuan"+fw.get(i).getReplacement());

					msgContent = msgContent.replace(fw.get(i).getFind(), fw
							.get(i).getReplacement());
					msgSubject = msgSubject.replace(fw.get(i).getFind(), fw
							.get(i).getReplacement());
				}
			}
			messageText.setMsgSubject(msgSubject);
			messageText.setMsgContent(msgContent);
		}

		
		long sendId = loginUser.getId();
		// set time
		String nowTime = getNowTime();
		messageText.setMsgTime(nowTime);
		// set Type Type: 0=普通私信 ； ； 2=举报信息 ……
		messageText.setMsgType("0");

		// 处理收信人
		List<UserInfo> listRecName = userInfoService
				.findUserByNickName(recName);
		UserInfo userInfo = null;
		if (listRecName.size() < 1) {
			request.setAttribute("result", "The recipient does not exist");
			return "../ERROR/result";
		}

		userInfo = listRecName.get(0);
		// 处理寄信人
		UserInfo userInfo2 = userInfoService.findById(sendId);

		Message message = new Message();
		message.setMessageText(messageText);
		message.setUserInfo1(userInfo);
		message.setUserInfo2(userInfo2);
		// 0=clear 1=done
		message.setIsRead("0");

		messageTextService.saveMessageText(messageText);
		messageService.saveMessage(message);

		

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

		
		
		return LIST_SENTBOX;
	}

	/**
	 * 查看发件箱
	 * 
	 * @author Robust
	 *
	 * @date 2014年9月15日
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/sendBox")
	public String listSendBox(HttpServletRequest request) {

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

		int offset = 0;
		int pageSize = 10;
		try{
			offset = Integer.parseInt(request.getParameter("pager.offset"));
		}catch(Exception e){
			
		}
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		long sendId = userInfo.getId();
		PageModel pm = messageService.listMessageByS(offset, pageSize, sendId);
		request.setAttribute("pm", pm);

		
		

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

		
		

		return "sendBox";
	}

	/**
	 * 查看收件箱
	 * 
	 * @author Robust
	 *
	 * @date 2014年9月15日
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/RecBox")
	public String listRecBox(HttpServletRequest request) {
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

		int offset = 0;
		int pageSize = 10;
		
		try{
			offset = Integer.parseInt(request.getParameter("pager.offset"));
		}catch(Exception e){
			
		}
		
		
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		long recId = userInfo.getId();

		PageModel pm = messageService.listMessageByR(offset, pageSize, recId);
		request.setAttribute("pm", pm);

		
		

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


		return "RecBox";
	}
	
	
	
	@RequestMapping(value = "/adminRecBox")
	public String listAdminRecBox(HttpServletRequest request) {
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

		int offset = 0;
		int pageSize = 10;
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		long recId = userInfo.getId();

		PageModel pm = messageService.listMessageByR(offset, pageSize, recId);
		request.setAttribute("pm", pm);
		
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
	
			return "../management/PrivateMsg/recBox";

	}

	/**
	 * 查看私信具体内容，并标记为已读
	 * 
	 * @author Robust
	 *
	 * @date 2014年9月15日
	 *
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/RecBox/{id}")
	public @ResponseBody String listMsgById(HttpServletRequest request, @PathVariable long id) {

		Message msg = messageService.listMessageById(id);
		if (msg.getIsRead() == "1") {
			System.out.println("Read Messages");
		} else {
			msg.setIsRead("1");
			messageService.updateMessage(msg);
		}
		
		String readStatus = msg.getIsRead(); 

		return readStatus;
	}

	/**
	 * 管理员发送信息
	 * 
	 * @author Robust
	 *
	 * @date 2014年9月27日
	 *
	 * @param request
	 * @param messageText
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value = "/sendPMtoAll")
	public String sendPMtoALL(HttpServletRequest request,
			MessageText messageText) throws Throwable {
		// 拿到登录用户信息（管理员）
		UserInfo loginUser = (UserInfo) request.getSession().getAttribute(
				"userInfo");

		// 过滤僵尸用户,只给去年登录过的用户发送信息
		String lastLoginTime = getNowTime().substring(0, 10);

		//处理内容和标题的敏感词
		
		if (messageText.getMsgContent().trim() != null || messageText.getMsgContent().trim() != ""||messageText.getMsgSubject().trim() !=""||messageText.getMsgSubject().trim() !=null) {
			String msgContent = HtmlSpecialChars.htmlspecialchars(messageText.getMsgContent());
			String msgSubject = HtmlSpecialChars.htmlspecialchars(messageText.getMsgContent());
			List<FilterWord> fw = filterWordService.listFilterWord();

			if (fw.size() > 0) {

				for (int i = 0; i < fw.size(); i++) {
					// System.out.println(fw.get(i).getFind()+"========================================tihuan"+fw.get(i).getReplacement());

					msgContent = msgContent.replace(fw.get(i).getFind(), fw
							.get(i).getReplacement());
					msgSubject = msgSubject.replace(fw.get(i).getFind(), fw
							.get(i).getReplacement());
				}
			}
			messageText.setMsgSubject(msgSubject);
			messageText.setMsgContent(msgContent);
		}
		
		
		// 设置私信内容
		// set time
		String nowTime = getNowTime();
		messageText.setMsgTime(nowTime);
		// set Type Type: 0=普通私信 ； 1=系统通知 ； 2=举报信息 ……
		messageText.setMsgType("0");
		messageTextService.saveMessageText(messageText);

		int yearNow = Integer.parseInt(lastLoginTime.substring(0, 4));
		int year = yearNow - 1;
		String lastLoginYear = String.valueOf(year);

		List<UserInfo> recUserList = this.userInfoService
				.findUserByLastLoginTime(lastLoginYear, yearNow + "");
		System.out.println("No. of user meeting the standards is:" + recUserList.size());

		if (recUserList.size() > 0) {
			// 存在用户组
			// 群发私信
			for (int i = 0; i < recUserList.size(); i++) {
				UserInfo recUser = recUserList.get(i);
				Message msg = new Message();
				msg.setUserInfo1(recUser);
				msg.setUserInfo2(loginUser);
				msg.setMessageText(messageText);
				msg.setIsRead("0");
				messageService.saveMessage(msg);

			}
		}

		// management success
		return null;

	}

	//
	@RequestMapping(value = "/delete_{id}")
	public String deletePM(HttpServletRequest request, @PathVariable long id) {

		messageService.deleteMessage(id);

		return LIST_RECBOX;
	}

	@RequestMapping(value = "/checkNickNameExist")
	public void listLabelByBoard(HttpServletRequest request,HttpServletResponse resp,
			String recName) throws IOException {
			List<UserInfo> recUserInfos = userInfoService.findUserByNickName(recName);
			PrintWriter out;
			out = resp.getWriter();
			if(recUserInfos.size()>0){
				
				out.write("exist");
			}else{
				
				out.write("unexist");
			}
			out.close();
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

	/**
	 * 将字符串的指定位置替换成新的字符
	 * 
	 * @param str
	 *            原字符串
	 * @param n
	 *            指定要替换的位数
	 * @param newChar
	 *            要替换的字符
	 * @return String 替换后的字符串
	 * @throws Throwable
	 */
	public static String replace(String str, int n, String newChar)
			throws Throwable {
		String s1 = "";
		String s2 = "";
		try {
			s1 = str.substring(0, n - 1);
			s2 = str.substring(n, str.length());
		} catch (Exception ex) {
			throw new Throwable("Replacing digits are more than character string");
		}
		return s1 + newChar + s2;
	}

}
