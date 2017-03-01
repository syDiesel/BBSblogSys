package com.bbsBlog.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bbsBlog.entity.QAConcern;
import com.bbsBlog.entity.QAFavor;
import com.bbsBlog.entity.UserInfo;
import com.bbsBlog.service.UserInfoService;
import com.bbsBlog.service.QuestionService;
import com.bbsBlog.serviceImpl.QAConcernServiceImpl;
import com.bbsBlog.serviceImpl.QAFavorServiceImpl;
/*
 * @author Zhou Junlong
 * @time 2014-12-27 12:58
 */
@Controller
public class QAAjaxController {
	@Resource 
	private QAFavorServiceImpl qAFavorServiceImpl;
	@Resource 
	private QAConcernServiceImpl qAConcernServiceImpl;
	@Resource 
	private UserInfoService userInfoService;
	@Resource 
	private QuestionService questionService;
	
	//添加收藏
	@RequestMapping(value="addfavor")
	public void addFavorAjax(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute("userInfo");
		Long qid=Long.parseLong(request.getParameter("qid"));
		PrintWriter out=response.getWriter();
		if(qAFavorServiceImpl.listQAFavorsBySql("from QAFavor where userInfo.id="+userInfo.getId()+" and question.id="+qid).size()==0) {
			QAFavor qafavor=new QAFavor();
			qafavor.setUserInfo(userInfo);
			qafavor.setQuestion(questionService.findQuestion(qid));
			qafavor.setTime(getNowTime());
			qAFavorServiceImpl.addQAFavor(qafavor);
			response.setContentType("text/html;charset=utf-8");
			out.print("1");
		}
		else
			out.print("2");
		out.flush();
		out.close();
	}
	
	//添加关注
	@RequestMapping(value="addconcern")
	public void addConcernAjax(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute("userInfo");
		Long qid=Long.parseLong(request.getParameter("qid"));
		PrintWriter out=response.getWriter();
		if(qAConcernServiceImpl.listQAConcernsBySql("from QAConcern where userInfo.id="+userInfo.getId()+" and question.id="+qid).size()==0) {
			QAConcern qaConcern=new QAConcern();
			qaConcern.setUserInfo(userInfo);
			qaConcern.setQuestion(questionService.findQuestion(qid));
			qaConcern.setTime(getNowTime());
			qAConcernServiceImpl.addQAConcern(qaConcern);
			response.setContentType("text/html;charset=utf-8");
			out.print("1");
		}
		else
			out.print("2");
		out.flush();
		out.close();
	}
	
	//取消收藏
	@RequestMapping(value="deletefavor")
	public void deleteFavorAjax(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute("userInfo");
		Long qid=Long.parseLong(request.getParameter("qid"));
		PrintWriter out=response.getWriter();
		List<QAFavor> listQAFavor=qAFavorServiceImpl.listQAFavorsBySql("from QAFavor where userInfo.id="+userInfo.getId()+" and question.id="+qid);
		if( listQAFavor.size()!=0) {
			qAFavorServiceImpl.deleteQAFavor( listQAFavor.get(0));
			response.setContentType("text/html;charset=utf-8");
			out.print("1");
		}
		else
			out.print("2");
		out.flush();
		out.close();
	}
	
	//取消关注
	@RequestMapping(value="deleteconcern")
	public void deleteConcernAjax(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute("userInfo");
		Long qid=Long.parseLong(request.getParameter("qid"));
		PrintWriter out=response.getWriter();
		List<QAConcern> listQAConcern=qAConcernServiceImpl.listQAConcernsBySql("from QAConcern where userInfo.id="+userInfo.getId()+" and question.id="+qid);
		if(listQAConcern.size()!=0){
			qAConcernServiceImpl.deleteQAConcern(listQAConcern.get(0));
			response.setContentType("text/html;charset=utf-8");
			out.print("1");
		}
		else
			out.print("2");
		out.flush();
		out.close();
	}
	
	//检查收藏
	@RequestMapping(value="checkfavor")
	public void checkFavorAjax(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute("userInfo");
		Long qid=Long.parseLong(request.getParameter("qid"));
		PrintWriter out=response.getWriter();
		List<QAFavor> listQAFavor=qAFavorServiceImpl.listQAFavorsBySql("from QAFavor where userInfo.id="+userInfo.getId()+" and question.id="+qid);
		if( listQAFavor.size()!=0)
			out.print("1");
		else
			out.print("2");
		out.flush();
		out.close();
	}
	
	//检查关注
	@RequestMapping(value="checkconcern")
	public void checkConcernAjax(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute("userInfo");
		Long qid=Long.parseLong(request.getParameter("qid"));
		PrintWriter out=response.getWriter();
		List<QAConcern> listQAConcern=qAConcernServiceImpl.listQAConcernsBySql("from QAConcern where userInfo.id="+userInfo.getId()+" and question.id="+qid);
		if(listQAConcern.size()!=0)
			out.print("1");
		else
			out.print("2");
		out.flush();
		out.close();
	}
	
	//获取时间
	public String getNowTime() {
		Date date = new Date();
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowTime = f.format(date);
		return nowTime;
	}
}