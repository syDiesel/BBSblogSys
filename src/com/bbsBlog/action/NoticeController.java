package com.bbsBlog.action;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bbsBlog.entity.Notice;
import com.bbsBlog.entity.UserInfo;
import com.bbsBlog.service.NoticeService;
import com.bbsBlog.service.UserInfoService;
import com.bbsBlog.util.PageModel;

@Controller
public class NoticeController {
	
	@Resource
	private UserInfoService userInfoService;
	@Resource 
	private NoticeService noticeService;

	public UserInfoService getUserInfoService() {
		return userInfoService;
	}

	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}
	
	public NoticeService getNoticeService() {
		return noticeService;
	}

	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}
	/**
	 * 
	 * @author 曦风
	 *
	 * @date 2014-9-14
	 *
	 * @param
	 */
	@RequestMapping(value="addMsgByType.do")	
	public ModelAndView addMsgByType(HttpServletRequest req,HttpServletResponse resp) throws Exception{
		
		
		return new ModelAndView("/web/management/notice/addNotice");
		
	}
	
	/**
	 * 
	 * @author 曦风
	 *
	 * @date 2014-9-14
	 *
	 * @param
	 */
	@RequestMapping(value="saveMsg.do")
	public String saveMsg(HttpServletRequest req,HttpServletResponse resp,Notice notice){
		
		String msgTitle=req.getParameter("msgTitle");
		String msgContent=req.getParameter("msg");
		
		//时间
		Date date=new Date();
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("time now:" + df.format(date));
		String nowTime=df.format(date);
		
		UserInfo userInfo=(UserInfo) req.getSession().getAttribute("userInfo");
		
		notice.setNoticeSubject(msgTitle);
		
		notice.setUserInfo(userInfo);
		notice.setNoticeContent(msgContent);
		notice.setNoticeTime(nowTime);
		
		noticeService.saveNotice(notice);
		
		return "redirect:listNotice.do?record=1";
	}
	
	
	@RequestMapping(value="listNotice.do")
	public String listNotice(HttpServletRequest req,HttpServletResponse resp,int record){
		
		List<Notice> listNotice=this.noticeService.listNotice();
		
		//开始分页
		int pageRecords=10;	//每页显示的记录数,这个可以自己设定
		int allRecords=listNotice.size();	//总的记录
		int allPage=(allRecords-1)/pageRecords+1;	//总页数
		
		PageModel pages=new PageModel();

		listNotice=pages.fenYe(listNotice, pageRecords, record,allPage,allRecords);//调用Pages的方法，进行分页	
		req.setAttribute("record", record);//当前页		
		req.setAttribute("pageRecords", pageRecords);//每页显示的记录数
		req.setAttribute("allPage", allPage);//总的页数
		req.setAttribute("listNotice", listNotice);
		
		
		return "/web/management/notice/listNotice";
	}
	
	
	
	@RequestMapping(value="toUpdateNotice.do")
	public String toUpdateNotice(HttpServletRequest req,HttpServletResponse resp,long id){
		
		Notice notice=(Notice) this.noticeService.findById(id);
		req.setAttribute("notice",notice);
		return "/web/management/notice/updateNotice";
	}
	
	
	@RequestMapping(value="updateNotice.do")
	public String updateNotice(HttpServletRequest req,HttpServletResponse resp,long id){
		
		Notice notice=(Notice) this.noticeService.findById(id);
		UserInfo user=(UserInfo) req.getSession().getAttribute("userInfo");
		notice.setNoticeContent(req.getParameter("msg"));
		notice.setNoticeSubject(req.getParameter("msgTitle"));
		notice.setUserInfo(user);
		this.noticeService.updateNotice(notice);	
		
		return "redirect:listNotice.do?record=1";
	}
	
	
	
	@RequestMapping(value="deleteNotice.do")
	public String deleteNotice(HttpServletRequest req,HttpServletResponse resp,long id){

		this.noticeService.deleteNotice(id);
		
		return "redirect:listNotice.do?record=1";
	}
	
}
