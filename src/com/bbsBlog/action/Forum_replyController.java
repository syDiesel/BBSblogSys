package com.bbsBlog.action;


import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bbsBlog.entity.FilterWord;
import com.bbsBlog.entity.ForumLabel;
import com.bbsBlog.entity.ForumPost;
import com.bbsBlog.entity.ForumReply;
import com.bbsBlog.entity.ForumTP;
import com.bbsBlog.entity.ForumUpHi;
import com.bbsBlog.entity.Friend;
import com.bbsBlog.entity.Master;
import com.bbsBlog.entity.Message;
import com.bbsBlog.entity.MessageText;
import com.bbsBlog.entity.Tpjl;
import com.bbsBlog.entity.UserInfo;
import com.bbsBlog.entity.UserUpHi;
import com.bbsBlog.entity.WealthBoard;
import com.bbsBlog.service.BoardService;
import com.bbsBlog.service.FilterWordService;
import com.bbsBlog.service.Forum_postService;
import com.bbsBlog.service.Forum_replyService;
import com.bbsBlog.service.FriendService;
import com.bbsBlog.service.MasterService;
import com.bbsBlog.service.MessageService;
import com.bbsBlog.service.MessageTextService;
import com.bbsBlog.service.PostStatusService;
import com.bbsBlog.service.UserInfoService;
import com.bbsBlog.service.UserUpHisService;
import com.bbsBlog.service.WealthBoardService;
import com.bbsBlog.util.HtmlSpecialChars;
import com.bbsBlog.util.PageModel;
import com.bbsBlog.util.ScoreLevel;




@Controller

public class Forum_replyController {
	@Resource
	private Forum_replyService forum_replyService;
	@Resource
	private Forum_postService forum_postService;
	@Resource
	private PostStatusService postStatusService;
	@Resource
	private BoardService boardService;
	@Resource
	private UserInfoService userInfoService;
	@Resource
	private UserController userController;
	@Resource
	private WealthBoardService wealthBoardService;
	@Resource
	private FriendService friendService;
	@Resource
	private MasterService masterService;
	@Resource
	private UserUpHisService userUpHisService;
	@Resource
	private FilterWordService filterWordService;
	
	@Resource
	private MessageService messageService;
	@Resource
	private MessageTextService messageTextService;


	
	private List<ForumReply> listReply;
	
	@RequestMapping(value="/addReply",method=RequestMethod.GET)
	public String saveReply(HttpServletRequest request,
			HttpServletResponse response,long post_id){
		ForumPost post=new ForumPost();
		post=this.forum_postService.findById(post_id);	
		return  "redirect:/listReplyByPostId?post_id=" + post.getId() + "&record=" + 1;
		
	
	}
	
	@SuppressWarnings("static-access")
	@RequestMapping(value="/addReply",method=RequestMethod.POST)
	public String saveReply(HttpServletRequest request,
			HttpServletResponse response, ForumReply reply,long post_id){
		
		ForumPost post=new ForumPost();
	    post=forum_postService.findById(post_id);
	    UserInfo userinfo=new UserInfo();
		userinfo=(UserInfo) request.getSession().getAttribute("userInfo");
		
		if(userinfo==null)
		{
			request.getSession().setAttribute("errorResult","You can reply after login");
			return "redirect:toResult.do";
		}
		HtmlSpecialChars html=new HtmlSpecialChars();
		//检验回复内容是否合格
		String inputString=html.htmlspecialchars2(request.getParameter("replyContent"));
		if(inputString.trim().length()>4000||inputString.trim().length()<10)
		{
			request.getSession().setAttribute("errorResult","Invalid Word Count");
			return "redirect:toResult.do";
		}
		
		String reply_content=html.htmlspecialchars(request.getParameter("replyContent"));
		//敏感词过滤
				List<FilterWord> listFilterWord=this.filterWordService.listFilterWord();
				if(listFilterWord.size()>0)
				{
					for(int i=0;i<listFilterWord.size();i++)
					{
						
						if(reply_content.contains(listFilterWord.get(i).getFind()))
							reply_content=reply_content.replaceAll(listFilterWord.get(i).getFind(),listFilterWord.get(i).getReplacement());
					}
				}
			
			reply.setReplyContent(reply_content);
		    
		    
		    Date date = new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			System.out.println("time now:"+df.format(date));
			String nowTime = df.format(date);
			
			
			
			reply.setForumPost(post);
			reply.setReplyTime(nowTime);	
			reply.setUserInfo(userinfo);
			reply.setDown("0");
			reply.setUp("0");
			reply.setNormal("0");
			reply.setPostStatus(this.postStatusService.listPostStatusById(4));
			
			//若用户无视等级回复，扣除一定灵丹
			
			if(userinfo.getId()!=post.getUserInfo().getId())//如果回复者为楼主则不用扣除灵丹
			{
			if((Integer.parseInt(userinfo.getUserLevel())+1)<Integer.parseInt(post.getReplyAccess()))
			{//因为存储回复权限是从1开始的
				String pay_type=request.getParameter("pay_type");
				System.out.println("-----------------pay_type:"+pay_type+"-----------");
				if(pay_type.equals("lingdan"))
				{
				if(Double.parseDouble(userinfo.getLingdan())<1)
				{
					request.getSession().setAttribute("errorResult","no panacea, use brick");
					return "redirect:toResult.do";
				}
				userinfo.setLingdan(Double.parseDouble(userinfo.getLingdan())-1+"");
				this.userInfoService.updateUserInfo(userinfo);
				}else{
					if(Double.parseDouble(userinfo.getJinzhuan())<1)
					{
						request.getSession().setAttribute("errorResult","no brick, use panacea");
						return "redirect:toResult.do";
					}
					System.out.println("----------------支付金砖前："+userinfo.getJinzhuan());
					userinfo.setJinzhuan(Double.parseDouble(userinfo.getJinzhuan())-1+"");
					this.userInfoService.updateUserInfo(userinfo);
					System.out.println("----------------支付金砖后："+userinfo.getJinzhuan());
					
				}
				
			}
			}
			
			this.forum_replyService.saveForum_reply(reply);
			
			this.forum_postService.updateForum_postReplyCount(post.getId(),Integer.parseInt(post.getReplyCount())+1+"");
			this.forum_postService.updateForum_postReplyTime(post_id, nowTime);
			
			request.setAttribute("post", post);
			request.setAttribute("reply", reply);
			
			//字数大on100字才可以获得积分
            if(reply_content.length()>100)
			addWealth(request,reply.getUserInfo().getId(),post.getBoard().getId(),1);
            
            
          //回复时发信息给楼主
            if(userinfo.getId()!=post.getUserInfo().getId())
            {
            String basePath=request.getParameter("basePath");
			MessageText messageText = new MessageText();
			messageText.setMsgSubject("System News");			
			messageText.setMsgContent(reply.getUserInfo().getNickName()+" on  "+nowTime+" at post   " +
					"<a href='"+basePath+"toTopics?post_id="+post.getId()+"'>"+post.getSubject()+"</a>  replying u");
			messageText.setMsgTime(nowTime);
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
            }
        return  "redirect:/listReplyByPostId?post_id=" + post.getId() + "&record=" + 1;
		
	}
	
	@RequestMapping("/toTopics")
	public String toTopics(HttpServletRequest request,
			HttpServletResponse response,long post_id) 
	{
		ForumPost post=new ForumPost();
		post=this.forum_postService.findById(post_id);		
		this.forum_postService.updateForum_postPostCount(post_id, Integer.parseInt(post.getPostCount())+1+"");
		return "redirect:/listReplyByPostId?post_id=" + post.getId() + "&record=" + 1;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/listReplyByPostId")
	public String listReplyByPostId(HttpServletRequest request,
			HttpServletResponse response,long post_id,int record)
	{  
		ForumPost post=new ForumPost();
		post=this.forum_postService.findById(post_id);
		String focus="all";
		if(request.getParameter("focus")!=null)
		   focus=request.getParameter("focus");
		request.setAttribute("focus",focus);
		if(focus.equals("poster"))
			listReply=forum_replyService.listReplyByPostId(post_id,post.getUserInfo().getId());
		else if(focus.equals("replywell"))
		{
			String listSql="from ForumReply f where f.forumPost.id="+post.getId()+" order by cast(f.up as integer) desc";
			listReply=this.forum_replyService.listReplyBySql(listSql);
		}
		else
			listReply=forum_replyService.listReplyByForumId(post_id);
		int countReply;
		if(listReply!=null)
		{
			countReply=listReply.size();
		}else{
			countReply=0;
		}

		
		
		//标签
		List<ForumLabel> listLabel=this.forum_postService.listForumLabelByPostId(post.getId());
		request.setAttribute("listLabel",listLabel);
		
		
		 //开始分页
		int pageRecords=6;	//每页显示的记录数,这个可以自己设定
		int allRecords=listReply.size();	//总的记录
		int allPage=(allRecords-1)/pageRecords+1;	//总页数
		
		PageModel pages=new PageModel();
		listReply=pages.fenYe(listReply, pageRecords, record,allPage,allRecords);//调用Pages的方法，进行分页			
		request.setAttribute("record", record);//当前页		
		request.setAttribute("pageRecords", pageRecords);//每页显示的记录数
		request.setAttribute("allPage", allPage);//总的页数
		
		request.setAttribute("countReply",countReply);
		request.setAttribute("listReply", listReply);
		request.setAttribute("post", post);
		
		//讨论帖的相关帖
		if(!post.getPostType().equals("origin"))
		{
			String sql="from ForumPost f where f.postType='"+post.getPostType()+"' and f.id!="+post.getId()+" order by f.postDate desc";
			List<ForumPost> relateForum=this.forum_postService.listPostBySql(sql);
			if(relateForum.size()>5)
			{
				relateForum=relateForum.subList(0,5);
			}
			request.setAttribute("relateForum",relateForum);
		}
		
		
		
		//验证用户是否有权限回复
		
		UserInfo userInfo=(UserInfo) request.getSession().getAttribute("userInfo");
		String access;
		
		if(userInfo!=null)
		{
		if((Integer.parseInt(userInfo.getUserLevel())+1)<Integer.parseInt(post.getReplyAccess()))
		{
			access="no";
		}else{
			access="yes";
		}
		
		String lingdan;
   	    
        if((Double.parseDouble(userInfo.getLingdan()))<1)
        {
        	
        	lingdan="0";
        }else{
        	
        	lingdan="1";
        }
        request.setAttribute("access",access);
        request.setAttribute("lingdan",lingdan);
		}
		
		//检验用户是否的版主
		List<Master> listMaster=this.masterService.listMasterByBoard(post.getBoard().getId());
		boolean trueMaster=false;
		if(listMaster.size()>0&&userInfo!=null)
		for(int i=0;i<listMaster.size();i++){
			
			if(listMaster.get(i).getUserInfo().getId()==userInfo.getId())
			{
				trueMaster=true;
			}
			
			
		}
		
		request.setAttribute("trueMaster",trueMaster);
		
		//检验楼主是不是好友
		String postFriend;
		if(userInfo!=null){
		List<Friend> isPostFriend=this.friendService.IsFriend(userInfo.getId(), post.getUserInfo().getId());
		if(isPostFriend.size()>0)
		{
			postFriend="1";
		}else{postFriend="0";}
		
		request.setAttribute("postFriend",postFriend);
		//检验回复者是不是好友
		List replyFriend=new ArrayList();
		
		for(int i=0;i<listReply.size();i++)
		{
			List<Friend> isReplyFriend=this.friendService.IsFriend(userInfo.getId(),listReply.get(i).getUserInfo().getId());
			if(isReplyFriend.size()>0)
			{replyFriend.add("1");
			}else{
				replyFriend.add("0");
			}
			
		}
        request.setAttribute("replyFriend",replyFriend);
       
		
		//验证用户禁言时间是否到期 
     
      
        if(!userInfo.getIsSay().equals("0"))
        {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date nowDate =new Date();		

        
		
		try {
			Date sayTime = df.parse(userInfo.getIsSay());
			long n=nowDate.getTime()-sayTime.getTime();
			
	        if(n>=0)
	        {
	        	this.userInfoService.updateIsSay(userInfo.getUserName(), "0");
	        }
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
        
        }
        
      
       }
       
       //关on投票的检验
		List<ForumTP> listForumTP=this.forum_postService.listForumTPByPostId(post.getId());
		List percentageCount=new ArrayList();
		request.setAttribute("listForumTP",listForumTP);
		int AllTPCount=0;
		for(int i=0;i<listForumTP.size();i++)
		{
			AllTPCount=AllTPCount+Integer.parseInt(listForumTP.get(i).getTPcount());
		}
		
		java.text.DecimalFormat def =new   java.text.DecimalFormat("#.00");  
		
		for(int i=0;i<listForumTP.size();i++)
		{
			
			double perCount;
			if(Double.parseDouble(listForumTP.get(i).getTPcount())!=0)
			 perCount=Double.parseDouble(listForumTP.get(i).getTPcount())/AllTPCount*100;
			else
			 perCount=0;
			
			percentageCount.add(def.format(perCount));
		}
		request.setAttribute("percentageCount", percentageCount);
		
		
		
		
		String msg="0";
		
		if(listForumTP.size()>0)
		{
		if(userInfo!=null)
		{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date nowTime =new Date();
		Date beginTime;
		Date endTime;
		try {
			beginTime=df.parse(listForumTP.get(0).getBeginTime());
			endTime = df.parse(listForumTP.get(0).getEndTime());
			long m=nowTime.getTime()-beginTime.getTime();
			long n=nowTime.getTime()-endTime.getTime();
			
			if(m<0)
			{
				msg="notBegin";
			}else{
				
				if(n<0){
					
					
			
			for(int i=0;i<listForumTP.size();i++)
			{
				List<Tpjl> listTpjl=this.forum_postService.listTpjlByUser(userInfo.getId());
				if(listTpjl.size()>0)
				for(int k=0;k<listTpjl.size();k++)
				
					if(listTpjl.get(k).getForumTp().getId()==listForumTP.get(i).getId())
					
						msg="1";
				
			}
			
			if(userInfo.getId()==post.getUserInfo().getId())
				msg="1";
				}else{
					msg="TPEnd";
				}
			}
			  
			
			}
		 catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}else{
			msg="noUser";
		}
		
		}else{
			msg="noTP";
		}
		
		
		request.setAttribute("msg",msg);
		request.setAttribute("replyAccess",Integer.parseInt(post.getReplyAccess())-1);
		
		//博主发帖数
		String queryCountHql="select count(*) from ForumPost f where f.userInfo.id="
		                       +post.getUserInfo().getId();
		int forumCount=this.forum_postService.listCount(queryCountHql);
		request.setAttribute("forumCount",forumCount);
	   //回复者发帖数	
		List replyerForumCount=new ArrayList();
		for(int i=0;i<listReply.size();i++)
		{
			
			String countSql="select count(*) from ForumPost f where f.userInfo.id="
			                 +listReply.get(i).getUserInfo().getId();
			int count=this.forum_postService.listCount(countSql);
			replyerForumCount.add(count);
		}
      
        request.setAttribute("replyerForumCount",replyerForumCount);
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
	
		
		return "/web/Forums/Topics";
	}
	
	
	@RequestMapping("/deleteReply")
	public String toDeleteReply(HttpServletRequest request,
			HttpServletResponse response) 
	{   
		
		    long reply_id=Integer.parseInt(request.getParameter("reply_id"));    
		    ForumPost post =new ForumPost();
            post=this.forum_replyService.findById(reply_id).getForumPost();
            ForumReply reply=this.forum_replyService.findById(reply_id);
          //关on用户身份的认证
			UserInfo userInfo=(UserInfo) request.getSession().getAttribute("userInfo");
			List<Master> listMaster=this.masterService.listMasterByBoard(reply.getForumPost().getBoard().getId());
			boolean trueMaster=false;
			if(listMaster.size()>0)
			for(int i=0;i<listMaster.size();i++){
				
				if(userInfo!=null&&listMaster.get(i).getUserInfo().getId()==userInfo.getId())
				{
					trueMaster=true;
				}
				
			}
			
			
			if(userInfo==null||(userInfo!=null&&userInfo.getId()!=post.getUserInfo().getId()&&trueMaster==false&&userInfo.getId()!=reply.getUserInfo().getId()))
			{
				request.getSession().setAttribute("errorResult","error");
				return "redirect:toResult.do";
			}
			
			try {
				    
		    		reply.setReplyContent(userInfo.getNickName()+"on"+getNowTime()+"delete");
		    		this.forum_replyService.updateForum_reply(reply);
				    return "redirect:/listReplyByPostId?post_id=" + post.getId() + "&record=" + 1;		
			} catch (Exception e) {
				// TODO: handle exception
				request.getSession().setAttribute("errorResult", "error");
				return "redirect:toResult.do";
			}
           	
	}
	
	@RequestMapping("/saveFriend")
	public String saveFriend(HttpServletRequest request,
			HttpServletResponse response,long guest_id,long post_id,int record) 
	{   
		try {
			
			userController.addFriend(request, guest_id);
			return "redirect:/listReplyByPostId?post_id=" + post_id + "&record=" + record;	
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.getSession().setAttribute("errorResult","error");
			return "redirect:toResult.do";
		}
			
	}
	
	
	@RequestMapping("/deleteFriend")
	public String deleteFriend(HttpServletRequest request,
			HttpServletResponse response,long guest_id,long post_id,int record) 
	{   
		try {
			
			userController.deleteFriend(request, guest_id);
			
			return "redirect:/listReplyByPostId?post_id=" + post_id+ "&record=" + record;  
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.getSession().setAttribute("errorResult","error");
			return "redirect:toResult.do";
		}
			
	}
	
	
	
	@SuppressWarnings("static-access")
	@RequestMapping("comment.do")
	public void comment(HttpServletRequest request,HttpServletResponse response,String type,String reply_id,String basePath)
			throws Exception{   
		
		
		ForumReply reply=new ForumReply();
		reply=this.forum_replyService.findById(Integer.parseInt(reply_id));
		UserInfo user=(UserInfo) request.getSession().getAttribute("userInfo");
		PrintWriter out;
		out = response.getWriter();
		long newCount=0;
		
		if(user!=null)
		{
        List<ForumUpHi> listForumUpHi=this.forum_replyService.listForumUpHi(reply.getForumPost().getId(),user.getId());
		if (listForumUpHi.size()>0)
			{out.print("error"); // 用on返回，该用户已评价过
			}else{
			if(type.equals("up"))
			{
				long upCount=Integer.parseInt(reply.getUp());
				
				this.forum_replyService.updateReplyUp(reply.getId(),upCount+1+"");
				newCount=upCount+1;
				System.out.println("评价后所加金砖数:"+Double.parseDouble(reply.getUserInfo().getUserLevel())/10);
				HtmlSpecialChars html=new HtmlSpecialChars();
				if(html.htmlspecialchars2(reply.getReplyContent()).length()>=100)//只有评论大on一百字时点赞才能加积分
				    addWealth(request,reply.getUserInfo().getId(),reply.getForumPost().getBoard().getId(),Double.parseDouble(reply.getUserInfo().getUserLevel())/10);
				
				
				if(user.getId()!=reply.getUserInfo().getId())
	            {
					String strBackUrl = "http://" + request.getServerName() // 服务器地址
							+ ":" + request.getServerPort() // 端口号
							+ request.getContextPath(); // 项目名称
	            
				MessageText messageText = new MessageText();
				messageText.setMsgSubject("System News");	
				HtmlSpecialChars htmlSpecialChars=new  HtmlSpecialChars();
				String replyContent=htmlSpecialChars.htmlspecialchars2(reply.getReplyContent())
	        			.replaceAll("<img.*>.*</img>", "").replaceAll("<img.*/>", "");;
				messageText.setMsgContent(reply.getUserInfo().getNickName()+" on  "+getNowTime()+"  think your reply             " +
						"       <a href='"+strBackUrl+"/toTopics?post_id="+reply.getForumPost().getId()+"'>"
						+replyContent.substring(0, 10)+"...</a> is good ");
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
				message.setUserInfo1(reply.getUserInfo());
				//发送信息
				this.messageService.saveMessage(message);
	            }
			
				
			}else if(type.equals("normal"))
			{
				long normalCount=Integer.parseInt(reply.getNormal());
				
				this.forum_replyService.updateReplyNormal(reply.getId(),normalCount+1+"");
				newCount=normalCount+1;
			}else{
				long downCount=Integer.parseInt(reply.getDown());
				
				this.forum_replyService.updateReplyDown(reply.getId(),downCount+1+"");
				newCount=downCount+1;
			}
			
			ForumUpHi forumUpHi=new ForumUpHi();
			forumUpHi.setForumPost(reply.getForumPost());
			forumUpHi.setUpContent(type);
			
			Date date = new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			String nowTime = df.format(date);
			
			forumUpHi.setUpTime(nowTime);
			
			
			forumUpHi.setUserInfo(user);
			this.forum_replyService.saveForumUpHi(forumUpHi);
			
			
			
			
			out.print(newCount); // 用on返回，该用户还没有评价

		}
		}else{
			out.print("noLoginUser");//用户没有登录
		}
		
		
		out.close();

	               }
	
	
	
	@RequestMapping("YMorSH.do")
	public void YMorSH(HttpServletRequest request,HttpServletResponse response,String type,String receiver_id)
			throws Exception{   
		
		PrintWriter out;
		out = response.getWriter();
		UserInfo user=(UserInfo) request.getSession().getAttribute("userInfo");
		if(user!=null)
		if(Double.parseDouble(user.getLingdan())<1)
		{
			out.print("error");
		}else{
			this.userInfoService.updateLingdan(user.getUserName(),Double.parseDouble(user.getLingdan())-1+"");
			UserInfo receiver=new UserInfo();
			receiver=this.userInfoService.findById(Integer.parseInt(receiver_id));
			if(type.equals("yangmu"))
			{
				this.userInfoService.updateYangmu(receiver.getUserName(),Integer.parseInt(receiver.getYangmu())+1+"");
				
				
				MessageText messageText = new MessageText();
				messageText.setMsgSubject("System News");			
				messageText.setMsgContent(user.getNickName()+" on  "+getNowTime()+" respect u " );
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
				message.setUserInfo1(user);
				//发送信息
				this.messageService.saveMessage(message);
				
				
				out.print(Integer.parseInt(receiver.getYangmu())+1);
			}else{
				this.userInfoService.updateXianhua(receiver.getUserName(),Integer.parseInt(receiver.getXianhua())+1+"");	
				
				MessageText messageText = new MessageText();
				messageText.setMsgSubject("System News");			
				messageText.setMsgContent(user.getNickName()+" on  "+getNowTime()+" send u flower " );
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
				message.setUserInfo1(user);
				//发送信息
				this.messageService.saveMessage(message);
				out.print(Integer.parseInt(receiver.getXianhua())+1);
			}
			
		}

		out.close();

	               }
	
	
	
	@RequestMapping("/addTP")
	public String addTP(HttpServletRequest request,HttpServletResponse response)
		{
		long post_id=Integer.parseInt(request.getParameter("post_id"));
		System.out.println("post_id:"+post_id);
		String TPids[]=request.getParameterValues("forumTP");
		for(int i=0;i<TPids.length;i++)
		{
			ForumTP forumTP=new ForumTP();
			forumTP=this.forum_postService.listForumTPById(Integer.parseInt(TPids[i]));
			System.out.println("----TPids:"+TPids[i]+"-----");
			forumTP.setTPcount(Integer.parseInt(forumTP.getTPcount())+1+"");
			this.forum_postService.updateForumTP(forumTP);
			Tpjl tpjl=new Tpjl();
			tpjl.setForumTp(forumTP);
			UserInfo user=(UserInfo) request.getSession().getAttribute("userInfo");
			if(user!=null)
			{
			tpjl.setUserInfo(user);
			this.forum_postService.saveTpjl(tpjl);
			}
		}
		
		return "redirect:/listReplyByPostId?post_id=" + post_id + "&record=" + 1;
		
		
	}
	
	
	@SuppressWarnings("static-access")
	public void addWealth(HttpServletRequest request,long userId,long board_id,double addScore)
			{   
		
		
		UserInfo user=userInfoService.findById(userId);
		String newJinzhuan=Double.parseDouble(user.getJinzhuan())+addScore+"";
		
		if(user!=null)
		{
			double userJinzhuan=Double.parseDouble(user.getJinzhuan());
			List<UserUpHi> userUpHis = userUpHisService
					.listUserUpHiByBlog(user.getId());
			if(userJinzhuan<7||(userJinzhuan>=7&&userUpHis.size() > 0))
			{
        userInfoService.updateJinzhuan(user.getUserName(),newJinzhuan );
 
		if(this.wealthBoardService.findByUser(user.getId(),board_id).size()>0)
		{//如果该用户在版块积分里已经有记录则不用创建
		WealthBoard wealthBoard=this.wealthBoardService.findByUser(user.getId(),board_id).get(0);
		double board_wealth=Double.parseDouble(wealthBoard.getWealthQuantity());
		wealthBoard.setWealthQuantity(board_wealth+addScore+"");
		this.wealthBoardService.updateWealthBoard(wealthBoard);
		}else
		{//没有记录，需先创建
			WealthBoard wealthBoard=new WealthBoard();
			wealthBoard.setUserInfo(user);
			wealthBoard.setBoard(this.boardService.listBoardById(board_id));
			wealthBoard.setWealthQuantity(addScore+"");
			
			this.wealthBoardService.saveWealthBoard(wealthBoard);
		}
	
        ScoreLevel scoreLevel=new ScoreLevel();
		String userLevel=scoreLevel.scoreLevel(newJinzhuan);
		this.userInfoService.updateUserLevel(user.getUserName(), userLevel);
		
			}
	               }
			}
	
	
	// 服务器时间
			public static String getNowTime() {
				Date date = new Date();
				SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String nowTime = f.format(date);

				return nowTime;
			}
	
	
}