package com.bbsBlog.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
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
import com.bbsBlog.entity.Friend;
import com.bbsBlog.entity.Message;
import com.bbsBlog.entity.UserInfo;
import com.bbsBlog.entity.UserUpHi;
import com.bbsBlog.service.AuditService;
import com.bbsBlog.service.BlogHiService;
import com.bbsBlog.service.BlogLogService;
import com.bbsBlog.service.FriendService;
import com.bbsBlog.service.MessageService;
import com.bbsBlog.service.UserInfoService;
import com.bbsBlog.service.UserUpHisService;
import com.bbsBlog.util.Pages;

@Controller
public class AuditController {
	
	@Resource
	private FriendService friendService;
	
	@Resource 
	private AuditService auditService;
	
	@Resource
	private UserInfoService userInfoService;
	
	@Resource
	private BlogHiService bloghiService;
	
	@Resource
	private BlogLogService blogLogService;
	
	@Resource
	private UserUpHisService userUpHisService;
	
	@Resource
	private MessageService messageService;
	
	/*	*//**
	 * 
	 * @author 曦风
	 *
	 * @date 2014-9-21
	 *
	 * @param
	 *//*
	@RequestMapping(value="blogHome.do",method=RequestMethod.GET)
	public String blogHome(HttpServletRequest req,
			HttpServletResponse res,long id){
		try{
		List<Friend> listFriend=friendService.listFriendById(id);
		List<Audit> listAudit=new ArrayList<Audit>();
		if(!listFriend.isEmpty()){
			Friend friend=new Friend();
			Iterator<Friend> it=listFriend.iterator();
			 while(it.hasNext()){
				friend=(Friend)it.next();
				List<Audit> listAudit1=auditService.listAuditByUserInfo(friend.getUserInfo1().getId());
				listAudit.addAll(listAudit1);
				Collections.sort(listAudit,new Comparator<Audit>(){
					@Override
					public int compare(Audit o1, Audit o2) {
						// TODO Auto-generated method stub
						return o2.getAuditTime().compareTo(o1.getAuditTime());

					}
					
				});

			 }
			 req.setAttribute("listAudit",listAudit);
		}
		else 
			req.setAttribute("listAudit","");
		
		return "/web/Blog/home";
		}catch (Exception e) {
			// TODO: handle exception
			req.setAttribute("result","error");
			return "web/ERROR/result";
			
		}
	}
	
	*//**
	 * 
	 * @author 曦风
	 *
	 * @date 2014-9-21
	 *
	 * @param
	 *//*
	@RequestMapping(value="chakan.do",method=RequestMethod.GET)
	public String chakan(HttpServletRequest req,
			HttpServletResponse res,long id,String type){
		if(type.equals("blog")){
			return "redirect:web/Blog/article/'"+id+"'";
		}
		else if(type.equals("forum")){
			return "redirect:/toTopics?id='"+id+"'";
		}
		else if(type.equals("question")){
			return "redirect:web/QandA/QuestionFind/'"+id+"' ";
		}
		
		return null;
	}
	*/
	//更多好友
	@SuppressWarnings("unchecked")
	@RequestMapping(value="myFriend.do",method=RequestMethod.GET)
	public String myFriend(HttpServletRequest req,
			HttpServletResponse res,long id,int record){
		
		List<Friend> listFriend=friendService.listFriendById(id);
		List<UserInfo> listUserInfo0=new ArrayList<UserInfo>();
		UserInfo blogUser=userInfoService.findById(id);
		
		if(!listFriend.isEmpty()){
			Friend friend=new Friend();
			Iterator<Friend> it=listFriend.iterator();
			 while(it.hasNext()){
				friend=(Friend)it.next();
				//列出该用户好友信息
				UserInfo userInfo0=userInfoService.findById(friend.getUserInfo1().getId());
				listUserInfo0.add(userInfo0);
			 }
		}
		int pageRecords=8;	//每页显示的记录数,这个可以自己设定
		int allRecords=listUserInfo0.size();	//总的记录
		int allPage=(allRecords-1)/pageRecords+1;	//总页数
		
		Pages pages=new Pages();
		listUserInfo0=pages.fenYe(listUserInfo0, pageRecords, record,allPage,allRecords);//调用Pages的方法，进行分页			
		req.setAttribute("record", record);//当前页		
		req.setAttribute("pageRecords", pageRecords);//每页显示的记录数
		req.setAttribute("allPage", allPage);//总的页数			
		req.setAttribute("listUserInfo0", listUserInfo0);
		req.setAttribute("blogUser",blogUser);
		
		
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
 			//更新session
			req.getSession().setAttribute("userInfo",loginUser);
		}
		req.setAttribute("newMsgCount", newMsg);
		
		return "web/Blog/myFriend";
	}
	
//好友及动态查看更多
	@SuppressWarnings("unchecked")
	@RequestMapping(value="auditMore.do",method=RequestMethod.GET)
    public String auditMore(HttpServletRequest req,
			HttpServletResponse res,long id,int record){
		try{
		//列出动态
		List<Friend> listFriend=friendService.listFriendById(id);
		List<Audit> listAudit=new ArrayList<Audit>();
		UserInfo blogUser=userInfoService.findById(id);
		
		//我的好友

		if(!listFriend.isEmpty()){
			Friend friend=new Friend();
			Iterator<Friend> it=listFriend.iterator();
			 while(it.hasNext()){
				friend=(Friend)it.next();
				List<Audit> listAudit1=auditService.listAuditByUserInfo(friend.getUserInfo1().getId());
				listAudit.addAll(listAudit1);
				
				Collections.sort(listAudit,new Comparator<Audit>(){
					@Override
					public int compare(Audit o1, Audit o2) {
						// TODO Auto-generated method stub
						return o2.getAuditTime().compareTo(o1.getAuditTime());

					}
					
				});

			 }
			 req.setAttribute("listAudit",listAudit);
		}
		else 
			req.setAttribute("listAudit","");
		
		
		int pageRecords=8;	//每页显示的记录数,这个可以自己设定
		int allRecords=listAudit.size();	//总的记录
		int allPage=(allRecords-1)/pageRecords+1;	//总页数
		
		Pages pages=new Pages();
		listAudit=pages.fenYe(listAudit, pageRecords, record,allPage,allRecords);//调用Pages的方法，进行分页			
		req.setAttribute("record", record);//当前页		
		req.setAttribute("pageRecords", pageRecords);//每页显示的记录数
		req.setAttribute("allPage", allPage);//总的页数			
		req.setAttribute("listAudit", listAudit);
		req.setAttribute("blogUser",blogUser);
		
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
 			//更新session
			req.getSession().setAttribute("userInfo",loginUser);
		}
		req.setAttribute("newMsgCount", newMsg);
		
    	return "/web/user/auditShow";
		
		}catch (Exception e) {
			// TODO: handle exception
			req.setAttribute("result","error");
			return "web/ERROR/result";
			
		}
    }
	
	
	//关注我的人
	@SuppressWarnings("unchecked")
	@RequestMapping(value="friendMore.do",method=RequestMethod.GET)
	public String friendMore(HttpServletRequest req,
			HttpServletResponse res,long id,int record){
		try{
		List<Friend> listMine=friendService.listMineById(id);
		UserInfo blogUser=userInfoService.findById(id);
		
		
		int pageRecords=8;	//每页显示的记录数,这个可以自己设定
		int allRecords=listMine.size();	//总的记录
		int allPage=(allRecords-1)/pageRecords+1;	//总页数
		
		Pages pages=new Pages();
		listMine=pages.fenYe(listMine, pageRecords, record,allPage,allRecords);//调用Pages的方法，进行分页			
		req.setAttribute("record", record);//当前页		
		req.setAttribute("pageRecords", pageRecords);//每页显示的记录数
		req.setAttribute("allPage", allPage);//总的页数			
		req.setAttribute("listMine", listMine);
		req.setAttribute("blogUser",blogUser);
		
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
 			//更新session
			req.getSession().setAttribute("userInfo",loginUser);
		}
		req.setAttribute("newMsgCount", newMsg);
		
		return "web/user/friendShow";
		}catch (Exception e) {
			// TODO: handle exception
			req.setAttribute("result","error");
			return "web/ERROR/result";
			
		}
	}
	
	/*//附件查看更多
	@SuppressWarnings("unchecked")
	@RequestMapping(value="attachMore.do",method=RequestMethod.GET)
	public String attachMore(HttpServletRequest req,
			HttpServletResponse res,long id,int record){
		try{
		List<Attachment> listAttach=attachmentService.listAttachment();
		
		
		int pageRecords=4;	//每页显示的记录数,这个可以自己设定
		int allRecords=listAttach.size();	//总的记录
		int allPage=(allRecords-1)/pageRecords+1;	//总页数
		
		Pages pages=new Pages();
		listAttach=pages.fenYe(listAttach, pageRecords, record,allPage,allRecords);//调用Pages的方法，进行分页			
		req.setAttribute("record", record);//当前页		
		req.setAttribute("pageRecords", pageRecords);//每页显示的记录数
		req.setAttribute("allPage", allPage);//总的页数			
		req.setAttribute("listMine", listAttach);
		
		req.setAttribute("listAttach",listAttach);
		
		return "web/user/attachShow";
		}catch (Exception e) {
			// TODO: handle exception
			req.setAttribute("result","error");
			return "web/ERROR/result";
			
		}
	}
*/
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/{nickName}",method=RequestMethod.GET)
	public String upUserMore(HttpServletRequest req,
			HttpServletResponse res,@PathVariable String nickName,int record){
		/*try{*/
		
		List<UserInfo> blogUserList = userInfoService
				.findUserByNickName(nickName);
		UserInfo blogUser = blogUserList.get(0);
		long BlogId = blogUser.getId();
		System.out.println("111111111111111111111"+BlogId);
		// 为我点赞的人
		List<UserUpHi> listUserUpHiByBlog = userUpHisService
						.listUserUpHiByBlog(BlogId);
		
		if(listUserUpHiByBlog.size()==0){
			req.setAttribute("result","no one comment good to me");
			return "web/ERROR/result";
		}
		System.out.println("2222222222222222222222222222"+listUserUpHiByBlog.size());
		List<UserInfo> listUserUpHi = new ArrayList<UserInfo>();
		List<UserInfo> listUserUpHi0 = new ArrayList<UserInfo>();
		for (UserUpHi userUp : listUserUpHiByBlog) {
			listUserUpHi.add(userUp.getUserInfo());
		}
		// ------去除点赞list中重复的人------
		for (int i = 0; i < listUserUpHi.size(); i++) {
			UserInfo user = listUserUpHi.get(i);
			if (!listUserUpHi0.contains(user))
				listUserUpHi0.add(user);
		}
		
		int pageRecords=8;	//每页显示的记录数,这个可以自己设定
		int allRecords=listUserUpHi0.size();	//总的记录
		int allPage=(allRecords-1)/pageRecords+1;	//总页数
		
		Pages pages=new Pages();
		listUserUpHi0=pages.fenYe(listUserUpHi0, pageRecords, record,allPage,allRecords);//调用Pages的方法，进行分页			
		req.setAttribute("record", record);//当前页		
		req.setAttribute("pageRecords", pageRecords);//每页显示的记录数
		req.setAttribute("allPage", allPage);//总的页数			
		req.setAttribute("listUserUpHiByBlog", listUserUpHi0);
		req.setAttribute("blogUser",blogUser);
		
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
 			//更新session
			req.getSession().setAttribute("userInfo",loginUser);
		}
		req.setAttribute("newMsgCount", newMsg);
		
		return "web/Blog/upUserShow";
		
		/*}catch (Exception e) {
			// TODO: handle exception
			req.setAttribute("result","error");
			return "web/ERROR/result";
			
		}*/
	}
	
	/*//大V会员更多
	@SuppressWarnings("unchecked")
	@RequestMapping(value="rechargeMore.do",method=RequestMethod.GET)
	public String rechargeMore(HttpServletRequest req,
			HttpServletResponse res,int record){
		
		List<RechargeHi> listRechargeHi=rechargeHiService.listRecharge_hi();
		
		List<RechargeHi> listRechargeHi0=new ArrayList<RechargeHi>();
		
		if(!listRechargeHi.isEmpty()){
			RechargeHi rechargeHi=new RechargeHi();
			Iterator<RechargeHi> it=listRechargeHi.iterator();
			 while(it.hasNext()){
				 rechargeHi=(RechargeHi)it.next();
				 if(!listRechargeHi0.contains(rechargeHi)){
					 listRechargeHi0.add(rechargeHi);
				 }
			 }
		}
		else 
			req.setAttribute("listRechargeHi0","");
		
		int pageRecords=4;	//每页显示的记录数,这个可以自己设定
		int allRecords=listRechargeHi0.size();	//总的记录
		int allPage=(allRecords-1)/pageRecords+1;	//总页数
		
		Pages pages=new Pages();
		listRechargeHi0=pages.fenYe(listRechargeHi0, pageRecords, record,allPage,allRecords);//调用Pages的方法，进行分页			
		req.setAttribute("record", record);//当前页		
		req.setAttribute("pageRecords", pageRecords);//每页显示的记录数
		req.setAttribute("allPage", allPage);//总的页数			
		req.setAttribute("listRechargeHi0", listRechargeHi0);
		
		return "web/user/rechargeShow";
		
	}
	
	
	//新进会员
	@SuppressWarnings("unchecked")
	@RequestMapping(value="newUserMore.do",method=RequestMethod.GET)
	public String newUserMore(HttpServletRequest req,
			HttpServletResponse res,int record) throws IOException{
		List<UserInfo> listNewUser=userInfoService.listNewUserInfo();
		
		//获取昨天的时间
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		String yesterday = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
		System.out.println(yesterday+"000000000000000000");
		
		if(!listNewUser.isEmpty()){
			UserInfo userInfo=new UserInfo();
			Iterator<UserInfo> it=listNewUser.iterator();
			 while(it.hasNext()){
				 userInfo=(UserInfo)it.next();
				 if((userInfo.getRegisterDate().hashCode()-yesterday.hashCode())<=86400000&&(userInfo.getRegisterDate().hashCode()-yesterday.hashCode())>=0){
					 listNewUser.add(userInfo);
				 }
			 }
		}
		else 
			req.setAttribute("listNewUser","");
		
		int pageRecords=4;	//每页显示的记录数,这个可以自己设定
		int allRecords=listNewUser.size();	//总的记录
		int allPage=(allRecords-1)/pageRecords+1;	//总页数
		
		Pages pages=new Pages();
		listNewUser=pages.fenYe(listNewUser, pageRecords, record,allPage,allRecords);//调用Pages的方法，进行分页			
		req.setAttribute("record", record);//当前页		
		req.setAttribute("pageRecords", pageRecords);//每页显示的记录数
		req.setAttribute("allPage", allPage);//总的页数			
		req.setAttribute("listNewUser", listNewUser);
		
		return "web/user/newUserShow";
	}*/
	
	
	

}
