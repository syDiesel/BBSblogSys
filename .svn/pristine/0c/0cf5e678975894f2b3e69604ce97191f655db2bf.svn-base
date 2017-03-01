package com.bbsBlog.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bbsBlog.entity.Message;
import com.bbsBlog.entity.Suggestion;
import com.bbsBlog.entity.UserInfo;
import com.bbsBlog.service.MessageService;
import com.bbsBlog.service.SuggestionService;
import com.bbsBlog.util.Pages;

@Controller
public class SuggestionController {

	@Resource
	private SuggestionService suggestionService;

	@Resource
	private MessageService messageService;

	@RequestMapping(value = "advice.do", method = RequestMethod.POST)
	public String addSuggestion(HttpServletRequest req, HttpServletResponse res) {

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

		UserInfo userInfo = (UserInfo) req.getSession()
				.getAttribute("userInfo");
		if (userInfo == null) {
			req.setAttribute("result", "Cannot submit without login。");
			return "/web/ERROR/result";
		}
		String suggestionContent = req.getParameter("advice");
		String suggestionType = req.getParameter("select_advice");
		String subject = req.getParameter("advice_subject");

		if (StringUtils.isBlank(suggestionContent)) {
			req.setAttribute("result", "Content can not be empty");
			return "/web/ERROR/result";
		}

		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("time now:" + df.format(date));
		String nowTime = df.format(date);

		Suggestion suggestion = new Suggestion();
		suggestion.setUserInfo(userInfo);
		suggestion.setSubject(subject);
		suggestion.setSuggestTime(nowTime);
		suggestion.setSuggestContent(suggestionContent);
		suggestion.setSuggestionType(suggestionType);

		suggestionService.saveSuggestion(suggestion);
		

		return "redirect:tijiao.html";
	}
	
	//防止意见一致提交
	@RequestMapping(value = "tijiao.html")
	public String tijiao(HttpServletRequest req, HttpServletResponse res){
		
		req.setAttribute("result", "Suggestion submitted successfully！！！");
		return "/web/ERROR/result";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "listSuggestion.do", method = RequestMethod.GET)
	public String listSuggest(HttpServletRequest req, HttpServletResponse res,
			int record) {

		List<Suggestion> listSuggest = suggestionService.listSuggestion();

		int pageRecords = 10; // 每页显示的记录数,这个可以自己设定
		int allRecords = listSuggest.size(); // 总的记录
		int allPage = (allRecords - 1) / pageRecords + 1; // 总页数

		Pages pages = new Pages();
		listSuggest = pages.fenYe(listSuggest, pageRecords, record, allPage,
				allRecords);// 调用Pages的方法，进行分页
		req.setAttribute("record", record);// 当前页
		req.setAttribute("pageRecords", pageRecords);// 每页显示的记录数
		req.setAttribute("allPage", allPage);// 总的页数
		req.setAttribute("listAdvice", listSuggest);

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

		return "web/management/Suggestion/listAdvice";
	}

	@RequestMapping(value = "Suggestion.do", method = RequestMethod.GET)
	public String suggestion(HttpServletRequest req, HttpServletResponse res,
			long id) {

		Suggestion suggestion = suggestionService.findById(id).get(0);
		req.setAttribute("suggestion", suggestion);

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

		return "web/management/Suggestion/advice";
	}

	@RequestMapping(value = "deleteSuggestion.do", method = RequestMethod.GET)
	public String deleteSuggestion(HttpServletRequest req,
			HttpServletResponse res, long id, int record) {
		suggestionService.deleteSuggestion(id);

		return listSuggest(req, res, record);
	}
}
