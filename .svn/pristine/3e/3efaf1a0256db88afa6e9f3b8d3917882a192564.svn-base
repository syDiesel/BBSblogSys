/**
 * 
 */
package com.bbsBlog.action;


import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.Access;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bbsBlog.entity.Audit;
import com.bbsBlog.entity.BlogLabel;
import com.bbsBlog.entity.BlogLog;
import com.bbsBlog.entity.Board;
import com.bbsBlog.entity.FilterWord;
import com.bbsBlog.entity.ForumLabel;
import com.bbsBlog.entity.ForumPost;
import com.bbsBlog.entity.ForumReply;
import com.bbsBlog.entity.ForumTP;
import com.bbsBlog.entity.ForumUpHi;
import com.bbsBlog.entity.Label;
import com.bbsBlog.entity.Master;
import com.bbsBlog.entity.Message;
import com.bbsBlog.entity.MessageText;
import com.bbsBlog.entity.Tpjl;
import com.bbsBlog.entity.UserInfo;
import com.bbsBlog.entity.UserUpHi;
import com.bbsBlog.entity.WealthBoard;
import com.bbsBlog.service.AuditService;
import com.bbsBlog.service.BlogLabelService;
import com.bbsBlog.service.BlogLogService;
import com.bbsBlog.service.BoardService;
import com.bbsBlog.service.FilterWordService;
import com.bbsBlog.service.Forum_postService;
import com.bbsBlog.service.Forum_replyService;
import com.bbsBlog.service.LabelService;
import com.bbsBlog.service.MasterService;
import com.bbsBlog.service.MessageService;
import com.bbsBlog.service.MessageTextService;
import com.bbsBlog.service.PostStatusService;
import com.bbsBlog.service.UserInfoService;
import com.bbsBlog.service.UserUpHisService;
import com.bbsBlog.service.WealthBoardService;
import com.bbsBlog.util.HtmlSpecialChars;
import com.bbsBlog.util.LabelSorter;
import com.bbsBlog.util.PageModel;
import com.bbsBlog.util.ScoreLevel;



/**
 * @author Robust
 *
 * @date 2014年8月1日
 *
 */
@Controller

public class Forum_postController {

	@Resource
	private Forum_postService forum_postService;
	@Resource
	private MessageService messageService;

    @Resource
	private AuditService auditService;
	
	@Resource
	private LabelService labelService;
	
	@Resource
	private BoardService boardService;
	
	@Resource
	private UserUpHisService userUpHisService;
	
	
	@Resource
	private PostStatusService postStatusService;
	
	@Resource
	private UserInfoService userInfoService;
	
	@Resource
	private WealthBoardService wealthBoardService;
	
	@Resource
	private MasterService masterService;
	
	@Resource
	private FilterWordService filterWordService;
	
	@Resource
	private MessageTextService messageTextService;
	
	@Resource
	private BlogLogService blogLogService;
	
	@Resource
	private BlogLabelService blogLabelService;


	

	private List<ForumPost> listPost;
	private List<ForumPost>  postByBoard;
	private List<Label> listLabelByBoard;
	private List<Board> listboard;


	/**
	 * 
	 * @author Robust
	 *
	 * @date 2014年8月2日
	 *
	 *       发表帖子
	 * 
	 * @param request
	 * @param response
	 * @param post
	 * @return
	 */
	
	@RequestMapping(value="/addPost",method=RequestMethod.GET)
	public String savePost(HttpServletRequest request)
	{
		/*long board_id=Integer.parseInt(request.getParameter("board_id"));*/
		
		/*Board board=new Board();
		board=this.boardService.listBoardById(board_id);
		listlabel=this.labelService.listLabelByBoard(board_id);
		
		request.setAttribute("listlabel", listlabel);
		
		request.setAttribute("board", board);*/
		request.setAttribute("discuss","origin");

		List<Board> boards=this.boardService.listBoard();
		request.setAttribute("boards",boards);
		
		
        //验证用户禁言时间是否到期 
       
        UserInfo userInfo=new UserInfo();
        userInfo=(UserInfo) request.getSession().getAttribute("userInfo");
        if(userInfo==null)
        {
        	String strBackUrl = "http://" + request.getServerName() // 服务器地址
					+ ":" + request.getServerPort() // 端口号
					+ request.getContextPath() // 项目名称
					+ request.getServletPath(); // 请求页面或其他地址
			/* + "?" + (request.getQueryString()) */// 参数
			request.getSession().setAttribute("strBackUrl", strBackUrl);
			return "redirect:login.html";
        }
        if(userInfo!=null){
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
		//验证用户是否有灵丹支付
        String lingdan;
        if(userInfo!=null)
        {
        if(Double.parseDouble(userInfo.getLingdan())<1)
        {
        	lingdan="0";
        }else{
        	
        	lingdan="1";
        }
        
		request.setAttribute("userLevel",userInfo.getUserLevel());
		request.setAttribute("lingdan",lingdan);
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
     			//更新session
    			request.getSession().setAttribute("userInfo",this.userInfoService.findById(loginUser.getId()));
    		}
    		request.setAttribute("newMsgCount", newMsg);
		return "/web/Forums/Forums_post";
	}
 
	
	@SuppressWarnings("static-access")
	@RequestMapping(value="/addPost",method=RequestMethod.POST)

	public String savePost(HttpServletRequest request,HttpServletResponse response){
		
		UserInfo userinfo=new UserInfo();
		userinfo=(UserInfo) request.getSession().getAttribute("userInfo");
		ForumPost post=new ForumPost();
		HtmlSpecialChars htmlSpecialChars=new HtmlSpecialChars();
		String post_title=request.getParameter("post_title");
		String content=request.getParameter("postContent");
		String post_content=htmlSpecialChars.htmlspecialchars2(content);//过滤掉html
		String msg="noTP";
		String discuss=request.getParameter("discuss");
		String firstImg=request.getParameter("hiddenImg");
		
		//敏感词过滤
		List<FilterWord> listFilterWord=this.filterWordService.listFilterWord();
		if(listFilterWord.size()>0)
		{
			for(int i=0;i<listFilterWord.size();i++)
			{
				if(content.contains(listFilterWord.get(i).getFind()))
					content=content.replace(listFilterWord.get(i).getFind(),listFilterWord.get(i).getReplacement());
				if(post_title.contains(listFilterWord.get(i).getFind()))
					post_title=post_title.replace(listFilterWord.get(i).getFind(),listFilterWord.get(i).getReplacement());
			}
		}
		
		String reply_access=request.getParameter("reply_access");
		String[] label_ids=request.getParameterValues("labelId");
		//检验帖子是否合格
		if(post_title.trim().length()<1)
		{
			request.getSession().setAttribute("errorResult","Word is unqualified");
			return "redirect:toResult.do";
		}
		if(post_content.trim().length()>15000)
		{
			request.getSession().setAttribute("errorResult","Word is unqualified");
			return "redirect:toResult.do";
		}
		
		if(discuss.equals("origin"))
		if(label_ids.length<1)
		{
			request.getSession().setAttribute("errorResult","Please select tag");
			return "redirect:toResult.do";
		}
		
		

		// 初始化参数

		long board_id=Integer.parseInt(request.getParameter("board_id"));		
		
		
		if(userinfo==null)
		{
			request.getSession().setAttribute("errorResult","error");
			return "redirect:toResult.do";
		}
		
		
			post.setIsTop("0");
			post.setIsWell("0");
			post.setReplyCount("0");
			post.setPostCount("0");
			post.setFirstImg(firstImg);
			
			if(!discuss.equals("origin"))
			   post.setPostType(discuss);
			else
				post.setPostType("origin");
			
			Date date = new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			System.out.println("time now:"+df.format(date));
			String nowTime = df.format(date);
			
		post.setPostDate(nowTime);
		post.setBoard(boardService.listBoardById(board_id));
		if(!discuss.equals("origin"))
		{
			long blog_id=Integer.parseInt(request.getParameter("blog_id"));
			BlogLog blog=this.blogLogService.listBlogLogById(blog_id);
			String blogContent=blog.getBlogContent();
			content="<fieldset><legend>Original</legend><br>"+blogContent+"</fieldset><br><br>"+content;
			
			post.setKeywordA(blog.getKeywordA());
			post.setKeywordB(blog.getKeywordB());
			post.setKeywordC(blog.getKeywordC());
		}
		//keyword的处理
		if(discuss.equals("origin"))	
	    {
	    if(label_ids.length==3)
    	{
    		post.setKeywordA(this.labelService.listLabelById(Integer.parseInt(label_ids[0])).getLabelName());
    		post.setKeywordB(this.labelService.listLabelById(Integer.parseInt(label_ids[1])).getLabelName());
    		post.setKeywordC(this.labelService.listLabelById(Integer.parseInt(label_ids[2])).getLabelName());
    	}else if(label_ids.length==2)
    	{
    		post.setKeywordA(this.labelService.listLabelById(Integer.parseInt(label_ids[0])).getLabelName());
    		post.setKeywordB(this.labelService.listLabelById(Integer.parseInt(label_ids[1])).getLabelName());
    	}else{
    		post.setKeywordA(this.labelService.listLabelById(Integer.parseInt(label_ids[0])).getLabelName());
    	}
	    }
		
		
		
		post.setPostContent(htmlSpecialChars.htmlspecialchars(content));
		post.setSubject(post_title);
		post.setReplyAccess(reply_access);
		post.setUserInfo(userinfo);
		post.setReplyTime(nowTime);
		
		//若用户无视等级，扣除一定灵丹
		if(Integer.parseInt(reply_access)>(Integer.parseInt(userinfo.getUserLevel())+1))
		{
			if(Double.parseDouble(userinfo.getLingdan())<1)
			{
				request.getSession().setAttribute("errorResult","No enough panaceas, please recharge");
				return "redirect:toResult.do";
			}
			this.userInfoService.updateLingdan(userinfo.getUserName(),Double.parseDouble(userinfo.getLingdan())-1+"");
		}
		
		//根据该模块审核是否开启来设置帖子的状态
	    if(boardService.listBoardById(board_id).getIsVerify().equals("1"))
		{
			post.setPostStatus(postStatusService.listPostStatusById(1));
		}else{
			post.setPostStatus(postStatusService.listPostStatusById(4));
		}
	    
	    
	    
    		
		
       this.forum_postService.saveForum_post(post);
		

		//帖子标签的处理
        if(discuss.equals("origin"))		
        {
        	for(int i=0;i<label_ids.length;i++)
		{
			long label_id=Integer.parseInt(label_ids[i]);
			Label label=new Label();
			label=this.labelService.listLabelById(label_id);
			label.setForumCount(label.getForumCount()+1);
			this.labelService.updateLabel(label);
			
			ForumLabel forumLabel=new ForumLabel();
			forumLabel.setForumPost(post);
			forumLabel.setLabel(label);
			this.forum_postService.saveForumLabel(forumLabel);			
		}
        	
        	
        }
        else
		{
			long blogLogId=Integer.parseInt(request.getParameter("blogLogId"));
			List<BlogLabel> listBlogLabel=this.blogLabelService.listBlogLabelByLog(blogLogId);
			 for(int i=0;i<listBlogLabel.size();i++)
				{
					Label label=new Label();
					label=listBlogLabel.get(i).getLabel();
					ForumLabel forumLabel=new ForumLabel();
					forumLabel.setForumPost(post);
					forumLabel.setLabel(label);
					this.forum_postService.saveForumLabel(forumLabel);
					
				}
		}
		request.setAttribute("post",post);
		
		
		//关to投票的相关处理
				if(request.getParameter("TP").equals("1"))
				{
					double lingdan=Double.parseDouble(userinfo.getLingdan());
					if(lingdan<10)
					{
						request.getSession().setAttribute("errorResult","No enough panaceas, please recharge");
						
						return "redirect:toResult.do";
					}
						
					
					
					String TPtitle=request.getParameter("TPtitle");
					
					String TPsubjects[]=request.getParameterValues("TP1");
					String TPtype=request.getParameter("oneORmore");

					String Btime=request.getParameter("time1");
					String Etime=request.getParameter("time2");	
					
					if(TPtitle.trim().length()==0)
					{
						request.getSession().setAttribute("errorResult","Voting theme can not be empty");
						return "redirect:toResult.do";
					}
					
					String time1[]=Btime.split("-");
    	    		String time2[]=Etime.split("-");
    	    		
    	    	    for(int i=1;i<time1.length;i++)
    	    	    {
    	    	       if(time1[i].length()<2)
    	    	          time1[i]="0"+time1[i];
    	    	       if(time2[i].length()<2)
	    	    	          time2[i]="0"+time2[i];
    	    	    }
    	    	    Btime=time1[0]+"-"+time1[1]+"-"+time1[2];
    	    	    Etime=time2[0]+"-"+time2[1]+"-"+time2[2];

					String beginTime=Btime+" 0:0:0";
					String endTime=Etime+" 0:0:0";
    	    	  
					try {
						Date d1 = df.parse(beginTime);
						Date d2 = df.parse(endTime);
						long n = d1.getTime() - d2.getTime();
	    	    	    if (n >= 0) {
	    	    	    	request.getSession().setAttribute("errorResult","Time Error");
							return "redirect:toResult.do";
	    	    	    } 
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						request.getSession().setAttribute("errorResult","Time Error");
						return "redirect:toResult.do";
					}
    	    		
					int k=0;
					//投票的处理
					for(int i=0;i<TPsubjects.length;i++)
					{
						if(TPsubjects[i].trim().length()>0)
						{
						ForumTP forumTP=new ForumTP();
						forumTP.setBeginTime(beginTime);
						forumTP.setEndTime(endTime);
						forumTP.setForumPost(post);
						forumTP.setTPsubject(TPsubjects[i]);
						forumTP.setTPcount("0");
						forumTP.setOther(TPtype);
						forumTP.setTPtitle(TPtitle);
						this.forum_postService.saveForumTP(forumTP);
						k++;
						}
					
					}
					if(k==0)
					{
						request.getSession().setAttribute("errorResult","Voting option can not empty");
						return "redirect:toResult.do";
					}
					
					this.userInfoService.updateLingdan(userinfo.getUserName(), lingdan-10+"");
					
					List<ForumTP> listForumTP=this.forum_postService.listForumTPByPostId(post.getId());
					System.out.println("listForumTP::"+listForumTP.size());
					request.setAttribute("listForumTP", listForumTP);
					msg="1";
					
					
				}
		
		
		//好友动态及积分的处理
		if(post.getPostStatus().getId()==4)
		{
			System.out.println("---------audit---------");
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
		
		addWealth(request,post.getUserInfo().getId(),post.getBoard().getId(),1);
		
		
		if(!discuss.equals("origin"))
		{
			long blog_id=Integer.parseInt(request.getParameter("blog_id"));
			BlogLog blog=this.blogLogService.listBlogLogById(blog_id);
			String basePath=request.getParameter("basePath");
			System.out.println("--------------basePath"+basePath);
			//博文被转载时发信息给博主
			MessageText messageText = new MessageText();
			messageText.setMsgSubject("System Messages");			
			messageText.setMsgContent(post.getUserInfo().getNickName()+" to  "+nowTime+"Reprint your blog to forum  ， " +
					"The post is<a href='"+basePath+"toTopics?post_id="+post.getId()+"'>"+post.getSubject()+"</a>");
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
			message.setUserInfo1(blog.getBlog().getUserInfo());
			//发送信息
			this.messageService.saveMessage(message);
		}
		
		
		
		}
        request.setAttribute("replyAccess",Integer.parseInt(post.getReplyAccess())-1);
		request.setAttribute("record",1);
		request.setAttribute("msg",msg);
		
		if(boardService.listBoardById(board_id).getIsVerify().equals("1"))
		{
			request.getSession().setAttribute("errorResult","Successful, please wait for verification");
			return "redirect:toResult.do";
		}else{
			return "redirect:toTopics?post_id="+post.getId();
		}
		
		
	}
	
	
	
	@RequestMapping("/listPost")
	public String listPost(HttpServletRequest request,
			HttpServletResponse response)
	{   
		listPost=forum_postService.listForum_post();
		request.setAttribute("listPost", listPost);
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
		
		return "/web/Forums/Forums";
	}
	
	
	@SuppressWarnings("static-access")
	@RequestMapping("/listPostByBoard")
	public String listPostByBoard(HttpServletRequest request,
			HttpServletResponse response)
	{   
        listboard=this.boardService.listBoard();   
        request.setAttribute("listboard",listboard);
        
        //取出全部标签
        List<List<Label>> listAllLabel=new ArrayList<List<Label>>();
        for(int i=0;i<listboard.size();i++)
        {
        	List<Label> listLabel=this.labelService.listLabelByBoard(listboard.get(i).getId());
        	listAllLabel.add(listLabel);
        }
        request.setAttribute("listAllLabel",listAllLabel);
      
        //热门标签
        List<Label> labels = new ArrayList<Label>();
      
           /*  labels = labelService.listLabel();
      
		for(int i = 0;i<labels.size();i++){
			
			String forumTotalHql = "select count(*) from ForumLabel where label.id='"
					+ labels.get(i).getId() + "'";
			
			int forumLabelTotal = blogLabelService.listCount(forumTotalHql);			
			labels.get(i).setLabelDesc(forumLabelTotal+"");
		}
		  Collections.sort(labels, new LabelSorter());  
          
	         
	        //如果要按照降序排列再加上这一行代码即可 
	        Collections.reverse(list); 
	          
		  Collections.reverse(labels); */
        
        String hotLabelSql="from Label l order by l.forumCount desc";
        labels=this.labelService.listLabelBySql(hotLabelSql);		  
		  if(labels.size()>3){
			  labels=labels.subList(0,3);
			  
		  }
		  request.setAttribute("hotLabels", labels);
		  
		  //热门标签下的文章
		     //有图片的文章
		  List<ForumLabel> listImg=new ArrayList<ForumLabel>();
		     for(int x=0;x<labels.size();x++)
		     {
		    	 System.out.println("--------"+x+"------------"+labels.get(x).getBoard().getBoardName()
		    			 +"     "+labels.get(x).getLabelName());
		    	 String hql="from ForumLabel l where l.label.id="
		     +labels.get(x).getId()
		     +" and (l.forumPost.postStatus.id=4 or l.forumPost.postStatus.id=5)" +
		     " and l.forumPost.firstImg!='' and l.forumPost.firstImg!=null order by cast(l.forumPost.replyCount as integer) desc";
		    	 
		    	 List<ForumLabel> listForumLabelImg=this.forum_postService.listForumLabelBySql(hql);
		    	 if(listForumLabelImg.size()>0)
		    	 {
		    		 listImg.add(listForumLabelImg.get(0));
		    		 System.out.println("----"+x+"------listForumLabelImg.get(0)"+listForumLabelImg.get(0).getForumPost().getSubject());
		    	 }
		    	 
		         
		     }
		     
		     request.setAttribute("listImg",listImg);
		     
		     //没有图片的文章
		     List<ForumLabel> listNoImg=new ArrayList<ForumLabel>();
		     for(int x=0;x<labels.size();x++)
		     {
		    	 String hql="from ForumLabel l where l.label.id="
		     +labels.get(x).getId()
		     +" and (l.forumPost.postStatus.id=4 or l.forumPost.postStatus.id=5)" +
		     " and (l.forumPost.firstImg='' or l.forumPost.firstImg=null) order by cast(l.forumPost.replyCount as integer) desc";
		    	 
		    List<ForumLabel> listForumLabelNoImg=this.forum_postService.listForumLabelBySql(hql);
		    if(listForumLabelNoImg.size()>3)
		    {
		    	listForumLabelNoImg=listForumLabelNoImg.subList(0,3);
		    }
		    for(int y=0;y<listForumLabelNoImg.size();y++)
		    	listNoImg.add(listForumLabelNoImg.get(y));
		     }
		     request.setAttribute("listNoImg",listNoImg); 

		     HtmlSpecialChars htmlSpecialChars=new  HtmlSpecialChars();
		     
		     String wellhql="";
		     String wellsql="";
		     String hothql="";
		     String hotsql="";
		     String discusshql="";
		     String discusssql="";
		     String originhql="";
		     String originsql="";
		       
		            wellhql="from ForumPost f where f.isWell='1' and " +
		    				" (f.postStatus.id=4 or f.postStatus.id=5) " +
		    				" and f.firstImg!='' and f.firstImg!=null order by f.postDate desc";
		        	
		            wellsql="from ForumPost f where f.isWell='1' and " +
		    				" (f.postStatus.id=4 or f.postStatus.id=5) " +
		    				" and (f.firstImg='' or f.firstImg=null) order by f.postDate desc";
		            hothql="from ForumPost f where cast(f.replyCount as integer)>30 " +
		            		"and (f.postStatus.id=4 or f.postStatus.id=5)" +
		            		" and f.firstImg!='' and f.firstImg!=null order by f.postDate desc";
		            hotsql="from ForumPost f where cast(f.replyCount as integer)>30 " +
		            		"and (f.postStatus.id=4 or f.postStatus.id=5)" +
		            		" and (f.firstImg='' or f.firstImg=null) order by f.postDate desc";
		            discusssql="from ForumPost f where f.postType!='origin' and" +
		            		" (f.postStatus.id=4 or f.postStatus.id=5) and " +
		            		"  (f.firstImg='' or f.firstImg=null) order by f.postDate desc";
		            discusshql="from ForumPost f where f.postType!='origin' and" +
		            		" (f.postStatus.id=4 or f.postStatus.id=5) and " +
		            		" f.firstImg!='' and f.firstImg!=null order by f.postDate desc";
		            originsql="from ForumPost f where f.postType='origin' and " +
		            		"(f.postStatus.id=4 or f.postStatus.id=5) and " +
		            		" (f.firstImg='' or f.firstImg=null) order by f.postDate desc";
		            originhql="from ForumPost f where f.postType='origin' and" +
		            		" (f.postStatus.id=4 or f.postStatus.id=5) and " +
		            		" f.firstImg!='' and f.firstImg!=null order by f.postDate desc";
		      
        
        //精华
		     //精华无图
		
        List<ForumPost> listWell=this.forum_postService.listPostBySql(wellsql);
        if(listWell.size()>10)
        {
        	listWell=listWell.subList(0, 10);
        }
        request.setAttribute("listWell",listWell);
          
       
        //精华有图
        
        List<ForumPost> listWellImg=this.forum_postService.listPostBySql(wellhql);
        if(listWellImg.size()>0)
        {
        	ForumPost WellImg=listWellImg.get(0);
        	request.setAttribute("WellImg",WellImg);
        	
        	//帖子内容过滤掉html
        	String wellContent=htmlSpecialChars.htmlspecialchars2(WellImg.getPostContent())
        			.replaceAll("<img.*>.*</img>", "").replaceAll("<img.*/>", "");
        	
        	request.setAttribute("wellContent",wellContent);
        	
        }
        
        
        //热门
        //有图片
        
        List<ForumPost> listHotImg=this.forum_postService.listPostBySql(hothql);
        if(listHotImg.size()>0)
        {
        	ForumPost HotImg=listHotImg.get(0);
        	request.setAttribute("HotImg",HotImg);
        	//帖子内容过滤掉html
        	String hotContent=htmlSpecialChars.htmlspecialchars2(HotImg.getPostContent())
        			.replaceAll("<img.*>.*</img>", "").replaceAll("<img.*/>", "");
        	request.setAttribute("hotContent",hotContent);
        }
        
        //无图片
        
        List<ForumPost> listHot=this.forum_postService.listPostBySql(hotsql);
        if(listHot.size()>10)
        {
        	listHot=listHot.subList(0, 10);
        }
        request.setAttribute("listHot",listHot);
        
       
        
        //转自博文
        //博文有图
        
        List<ForumPost> listDiscussImg=this.forum_postService.listPostBySql(discusshql);
        if(listDiscussImg.size()>0)
        {
        	ForumPost DiscussImg=listDiscussImg.get(0);
        	request.setAttribute("DiscussImg",DiscussImg);
        	
        	//帖子内容过滤掉html
        	String discussContent=htmlSpecialChars.htmlspecialchars2(DiscussImg.getPostContent())
        			.replaceAll("<img.*>.*</img>", "").replaceAll("<img.*/>", "").replaceAll("<fieldset>.*</fieldset>","");
        	request.setAttribute("discussContent",discussContent);
        }
        
        //博文无图
        
        List<ForumPost> listDiscuss=this.forum_postService.listPostBySql(discusssql);
        if(listDiscuss.size()>10)
        {
        	listDiscuss=listDiscuss.subList(0, 10);
        }
        request.setAttribute("listHot",listHot);
        request.setAttribute("listDiscuss",listDiscuss);
        
        
        //自发话题
        //自发有图
        
        List<ForumPost> listOriginImg=this.forum_postService.listPostBySql(originhql);
        if(listOriginImg.size()>0)
        {
        	ForumPost OriginImg=listOriginImg.get(0);
        	request.setAttribute("OriginImg",OriginImg);
        	//帖子内容过滤掉html
        	String originContent=htmlSpecialChars.htmlspecialchars2(OriginImg.getPostContent())
        			.replaceAll("<img.*>.*</img>","").replaceAll("<img.*/>","");
        	request.setAttribute("originContent",originContent);
        }
        //自发无图
       
        List<ForumPost> listOrigin=this.forum_postService.listPostBySql(originsql);
        if(listOrigin.size()>10)
        {
        	listOrigin=listOrigin.subList(0, 10);
        }
        request.setAttribute("listOrigin",listOrigin);
        
        
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
        
		return "/web/Forums/home";
	}
	

	
	@SuppressWarnings("unchecked")
	@RequestMapping("/listPostByLabel")
	public String listPostByLabelId(HttpServletRequest request,
			HttpServletResponse response,int record)
	{   
		/*String listType="timeDesc";
		  if(request.getParameter("listType")!=null)
		  {
			  listType=request.getParameter("listType");
		  }*/
	    long board_id=Integer.parseInt(request.getParameter("board_id"));
	    Board board=this.boardService.listBoardById(board_id);
	    request.setAttribute("board",board);
	  
		/*listLabelByBoard=this.labelService.listLabelByBoard(board_id);*/
		String forumType="all";
		 if(request.getParameter("forumType")!=null)
		  {
			 forumType=request.getParameter("forumType");
		  }
		 request.setAttribute("forumType",forumType);
		String sql="";
		/*if(listType.equals("replyAsc"))		
		{
			if(forumType.equals("all"))
				sql="from ForumPost p where p.board.id="+board.getId()
				+" and (p.postStatus.id=4 or p.postStatus.id=5) " +
				"order by cast(p.replyCount as integer)";
			else if(forumType.equals("well"))
				sql="from ForumPost p where p.board.id="+board.getId()+
				"and p.isWell=1 and (p.postStatus.id=4 or p.postStatus.id=5) " +
				"order by cast(p.replyCount as integer)";
			else if(forumType.equals("discuss"))
				sql="from ForumPost p where p.board.id="+board.getId()
				+"and p.postType!='origin' and (p.postStatus.id=4 or p.postStatus.id=5)" +
				" order by cast(p.replyCount as integer)";
			else if(forumType.equals("origin"))
				sql="from ForumPost p where p.board.id="+board.getId()+
				"and p.postType='origin' and (p.postStatus.id=4 or p.postStatus.id=5) " +
				"order by cast(p.replyCount as integer)";
			
			}else if(listType.equals("timeAsc"))
			{
				if(forumType.equals("all"))
					sql="from ForumPost p where p.board.id="+board.getId()+
					" and (p.postStatus.id=4 or p.postStatus.id=5)  order by replyTime";
				else if(forumType.equals("well"))
					sql="from ForumPost p where p.board.id="+board.getId()+
					"and p.isWell=1 and (p.postStatus.id=4 or p.postStatus.id=5) " +
					" order by replyTime";
				else if(forumType.equals("discuss"))
					sql="from ForumPost p where p.board.id="+board.getId()+
					"and p.postType!='origin' and (p.postStatus.id=4 or p.postStatus.id=5) " +
					" order by replyTime";
				else if(forumType.equals("origin"))
					sql="from ForumPost p where p.board.id="+board.getId()+
					"and p.postType='origin' and (p.postStatus.id=4 or p.postStatus.id=5) " +
					" order by replyTime";
			}else if(listType.equals("replyDesc"))
			{
				if(forumType.equals("all"))
					sql="from ForumPost p where p.board.id="+board.getId()+
					" and (p.postStatus.id=4 or p.postStatus.id=5) " +
					"order by cast(p.replyCount as integer) desc";
				else if(forumType.equals("well"))
					sql="from ForumPost p where p.board.id="+board.getId()+
					"and p.isWell=1 and (p.postStatus.id=4 or p.postStatus.id=5)" +
					" order by cast(p.replyCount as integer) desc";
				else if(forumType.equals("discuss"))
					sql="from ForumPost p where p.board.id="+board.getId()+
					"and p.postType!='origin' and (p.postStatus.id=4 or p.postStatus.id=5) " +
					"order by cast(p.replyCount as integer) desc";
				else if(forumType.equals("origin"))
					sql="from ForumPost p where p.board.id="+board.getId()+
					"and p.postType='origin' and (p.postStatus.id=4 or p.postStatus.id=5) " +
					"order by cast(p.replyCount as integer) desc";
			}else{*/
				if(forumType.equals("all"))
					sql="from ForumPost p where p.board.id="+board.getId()+
					" and (p.postStatus.id=4 or p.postStatus.id=5) and p.isTop!=1" +
					" order by replyTime desc";
				else if(forumType.equals("well"))
					sql="from ForumPost p where p.board.id="+board.getId()+
					"and p.isWell=1 and (p.postStatus.id=4 or p.postStatus.id=5) " +
					" order by replyTime desc";
				else if(forumType.equals("hot"))
					sql="from ForumPost f where cast(f.replyCount as integer)>30 " +
		            	"and (f.postStatus.id=4 or f.postStatus.id=5)" +
		            	" order by f.replyTime desc";
				else if(forumType.equals("discuss"))
					sql="from ForumPost p where p.board.id="+board.getId()+
					"and p.postType!='origin' and (p.postStatus.id=4 or p.postStatus.id=5) " +
					" order by replyTime desc";
				else if(forumType.equals("origin"))
					sql="from ForumPost p where p.board.id="+board.getId()+
					"and p.postType='origin' and (p.postStatus.id=4 or p.postStatus.id=5)  " +
					"order by replyTime desc";
			/*}*/
		postByBoard=this.forum_postService.listPostBySql(sql);
		
		
		
		
		
		       //开始分页
				int pageRecords=20;	//每页显示的记录数,这个可以自己设定
				int allRecords=postByBoard.size();	//总的记录
				int allPage=(allRecords-1)/pageRecords+1;	//总页数
				
				PageModel pages=new PageModel();
				
				postByBoard=pages.fenYe(postByBoard, pageRecords, record,allPage,allRecords);//调用Pages的方法，进行分页	
				List<ForumPost> listPostTop=this.forum_postService.listPostTop(board_id);
				request.setAttribute("listPostTop",listPostTop);			
				request.setAttribute("board_id", board_id);
				/*request.setAttribute("listType",listType);*/
				request.setAttribute("record", record);//当前页		
				request.setAttribute("pageRecords", pageRecords);//每页显示的记录数
				request.setAttribute("allPage", allPage);//总的页数	
				request.setAttribute("listLabelByBoard", listLabelByBoard);
				request.setAttribute("postByBoard", postByBoard);
				
				List<Master> listMaster=this.masterService.listMasterByBoard(board_id);
				request.setAttribute("listMaster",listMaster);
				
				
				//Stick帖标签
				List<List<ForumLabel>> listTopLable=new ArrayList<List<ForumLabel>>();
				
				for(int x=0;x<listPostTop.size();x++)
				{
					List<ForumLabel> topLabel=
							this.forum_postService.listForumLabelByPostId(listPostTop.get(x).getId());
					listTopLable.add(topLabel);
				}
				request.setAttribute("listTopLable",listTopLable);
				
				//其他帖标签
                List<List<ForumLabel>> listOtherLable=new ArrayList<List<ForumLabel>>();
				
				for(int i=0;i<postByBoard.size();i++)
				{
					List<ForumLabel> forumLabel=
							this.forum_postService.listForumLabelByPostId(postByBoard.get(i).getId());
					listOtherLable.add(forumLabel);
				}
				request.setAttribute("listOtherLable",listOtherLable);
				
				//判断用户是不是版主
				UserInfo userInfo=(UserInfo) request.getSession().getAttribute("userInfo");
				boolean trueMaster=false;
				if(listMaster.size()>0&&userInfo!=null)
				for(int i=0;i<listMaster.size();i++){
					
					if(listMaster.get(i).getUserInfo().getId()==userInfo.getId())
					{
						trueMaster=true;
					}
					
					
				}
				
				request.setAttribute("trueMaster",trueMaster);
				
				
				listboard=this.boardService.listBoard();   
		        request.setAttribute("listboard",listboard);
		        
		        //取出全部标签
		        List<List<Label>> listAllLabel=new ArrayList<List<Label>>();
		        for(int i=0;i<listboard.size();i++)
		        {
		        	List<Label> listLabel=this.labelService.listLabelByBoard(listboard.get(i).getId());
		        	listAllLabel.add(listLabel);
		        }
		        request.setAttribute("listAllLabel",listAllLabel);
				
				
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
				
		return "/web/Forums/listForum";
	}
	
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/hotLabelMore")
	public String hotLabelMore(HttpServletRequest request,
			HttpServletResponse response,int record)
	{   
		
		boolean trueMaster=false;
		
		
		
		 //热门标签
        List<Label> labels = new ArrayList<Label>();
      
             labels = labelService.listLabel();
      
		for(int i = 0;i<labels.size();i++){
			
			String forumTotalHql = "select count(*) from ForumLabel where label.id='"
					+ labels.get(i).getId() + "'";
			
			int forumLabelTotal = blogLabelService.listCount(forumTotalHql);			
			labels.get(i).setLabelDesc(forumLabelTotal+"");
		}
		  Collections.sort(labels, new LabelSorter());  
          
	        /* 
	        //如果要按照降序排列再加上这一行代码即可 
	        Collections.reverse(list); 
	        */  
		  Collections.reverse(labels); 
		  

		  
		  if(labels.size()>3){
			  labels=labels.subList(0,3);
			  
		  }
		  request.setAttribute("hotLabels", labels);
	  
		
		String forumType="all";
		 if(request.getParameter("forumType")!=null)
		  {
			 forumType=request.getParameter("forumType");
		  }
		 request.setAttribute("forumType",forumType);
		String sql="";
		
		
		List<ForumLabel> listAllForumLabel=new ArrayList<ForumLabel>();
		List<ForumLabel> listAllTopForumLabel=new ArrayList<ForumLabel>();
			for(int i=0;i<labels.size();i++)
		     {
				if(forumType.equals("all"))
					sql="from ForumLabel l where l.label.id="+labels.get(i).getId()+
					" and (l.forumPost.postStatus.id=4 or l.forumPost.postStatus.id=5)" +
					" and l.forumPost.isTop!=1" +
					" order by l.forumPost.replyTime desc";
				else if(forumType.equals("well"))
					sql="from ForumLabel l where l.label.id="+labels.get(i).getId()+
					" and (l.forumPost.postStatus.id=4 or l.forumPost.postStatus.id=5)" +
					" and l.forumPost.isWell=1" +
					" order by l.forumPost.replyTime desc";
				else if(forumType.equals("hot"))
					sql="from ForumLabel l where l.label.id="+labels.get(i).getId()+"and " +
							"cast(l.forumPost.replyCount as integer)>30 " +
		            	"and (l.forumPost.postStatus.id=4 or l.forumPost.postStatus.id=5)" +
		            	" order by l.forumPost.replyTime desc";
				else if(forumType.equals("discuss"))
					sql="from ForumLabel l where l.label.id="+labels.get(i).getId()+
					" and l.forumPost.postType!='origin' and " +
					"(l.forumPost.postStatus.id=4 or l.forumPost.postStatus.id=5) " +
					" order by l.forumPost.replyTime desc";
				else if(forumType.equals("origin"))
					sql="from ForumLabel l where l.label.id="+labels.get(i).getId()+
					"and l.forumPost.postType='origin' and " +
					"(l.forumPost.postStatus.id=4 or l.forumPost.postStatus.id=5)  " +
					"order by l.forumPost.replyTime desc";
				
				List<ForumLabel> listForumLabel=this.forum_postService.listForumLabelBySql(sql);
				listAllForumLabel.addAll(listForumLabel);
				
				String topSql="from ForumLabel l where l.label.id="+labels.get(i).getId()+
						"and l.forumPost.isTop=1 and " +
						"(l.forumPost.postStatus.id=4 or l.forumPost.postStatus.id=5)  " +
						"order by l.forumPost.replyTime desc";
				List<ForumLabel> listTopForumLabel=this.forum_postService.listForumLabelBySql(topSql);
				listAllTopForumLabel.addAll(listTopForumLabel);
				
		     }
			
			
			//开始分页
			int pageRecords=20;	//每页显示的记录数,这个可以自己设定
			int allRecords=listAllForumLabel.size();	//总的记录
			int allPage=(allRecords-1)/pageRecords+1;	//总页数
			
			PageModel pages=new PageModel();
			
			listAllForumLabel=pages.fenYe(listAllForumLabel, pageRecords, record,allPage,allRecords);//调用Pages的方法，进行分页	
			
			request.setAttribute("listAllTopForumLabel",listAllTopForumLabel);
			request.setAttribute("listAllForumLabel",listAllForumLabel);
			request.setAttribute("record", record);//当前页		
			request.setAttribute("pageRecords", pageRecords);//每页显示的记录数
			request.setAttribute("allPage", allPage);//总的页数	
			
		
		        request.setAttribute("trueMaster",trueMaster);
				
				listboard=this.boardService.listBoard();   
		        request.setAttribute("listboard",listboard);
		        
		        //取出全部标签
		        List<List<Label>> listAllLabel=new ArrayList<List<Label>>();
		        for(int i=0;i<listboard.size();i++)
		        {
		        	List<Label> listLabel=this.labelService.listLabelByBoard(listboard.get(i).getId());
		        	listAllLabel.add(listLabel);
		        }
		        request.setAttribute("listAllLabel",listAllLabel);
				
				
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
				
		return "/web/Forums/hotLabelMore";
	}
	
	
	

	
	@RequestMapping("/deletePost")
	public String deletePost(HttpServletRequest request,
			HttpServletResponse response,long p_id)
	{  
		try {
			/*listReply=this.forum_replyService.listReplyByForumId(p_id);
			listForumLabelByPostId=this.forum_postService.listForumLabelByPostId(p_id);
			List<ForumUpHi> listForumUpHiByPost=this.forum_replyService.listForumUpHiByPost(p_id);*/
			List<ForumTP> listForumTP=this.forum_postService.listForumTPByPostId(p_id);
			//关to用户身份的认证
			UserInfo userInfo=(UserInfo) request.getSession().getAttribute("userInfo");
			ForumPost post=this.forum_postService.findById(p_id);
			List<Master> listMaster=this.masterService.listMasterByBoard(post.getBoard().getId());
			boolean trueMaster=false;
			if(listMaster.size()>0)
			for(int i=0;i<listMaster.size();i++){
				
				if(userInfo!=null&&listMaster.get(i).getUserInfo().getId()==userInfo.getId())
				{
					trueMaster=true;
				}
				
			}
			
			
			
			if(userInfo==null||(userInfo!=null&&trueMaster==false&&userInfo.getId()!=post.getUserInfo().getId()))
			{
				request.getSession().setAttribute("errorResult","error");
				return "redirect:toResult.do";
			}
			
			//相关表的delete
			/*if(listReply!=null)
			{
				for(int i=0;i<listReply.size();i++)
				this.forum_replyService.deleteForum_reply(listReply.get(i).getId());
			}
			if(listForumLabelByPostId!=null)
			{
				for(int i=0;i<listForumLabelByPostId.size();i++)
				{
					this.forum_postService.deleteForumLabel(listForumLabelByPostId.get(i).getId());
				}
			}
			if(listForumUpHiByPost!=null)
			{
				for(int i=0;i<listForumUpHiByPost.size();i++)
				{
					this.forum_replyService.deleteForumUpHi(listForumUpHiByPost.get(i).getId());
				}
			}*/
			if(listForumTP!=null)
			{
				for(int i=0;i<listForumTP.size();i++)
				{
					List<Tpjl> listTpjl=this.forum_postService.listTpjlByForumTP(listForumTP.get(i).getId());
					if(listTpjl!=null)
					{
					for(int k=0;k<listTpjl.size();k++)
					{
						this.forum_postService.deleteTpjl(listTpjl.get(k).getId());
					}
					}
					this.forum_postService.deleteForumTP(listForumTP.get(i).getId());
					
				}
			}
			post.setPostContent(userInfo.getNickName()+"to"+getNowTime()+"delete");
		    this.forum_postService.updateForum_post(post);
		    return "redirect:listReplyByPostId?post_id="+post.getId()+"&record=1";
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.getSession().setAttribute("errorResult", "error");
			return "redirect:toResult.do";
		}
		
	}
	
	
	
	
	@RequestMapping("fromBlog{id}.do")
	public String fromBlog(HttpServletRequest request,@PathVariable long id)
	{
		//long id=Integer.parseInt(request.getParameter("blogId"));
		BlogLog blogLog=this.blogLogService.listBlogLogById(id);
		List<BlogLabel> listBlogLabel=this.blogLabelService.listBlogLabelByLog(id);
		if(blogLog==null||!blogLog.getSfzz().equals("1"))
			{request.getSession().setAttribute("errorResult","error");
		    return "redirect:toResult.do";}
		UserInfo userInfo=(UserInfo) request.getSession().getAttribute("userInfo");
		if(userInfo==null)
		{
			return "redirect:login.html";
		}
		
		//验证用户是否有灵丹支付
        String lingdan;
       
        if(Double.parseDouble(userInfo.getLingdan())<1)
        {
        	lingdan="0";
        }else{
        	
        	lingdan="1";
        }
        
		request.setAttribute("userLevel",userInfo.getUserLevel());
		request.setAttribute("lingdan",lingdan);
      
		
		request.setAttribute("blogLog",blogLog);
		//request.setAttribute("blogContent",blogLog.getBlogContent());
		request.setAttribute("discuss",blogLog.getId());
		request.setAttribute("listBlogLabel",listBlogLabel);
		request.setAttribute("board",blogLog.getBoard());
		
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
		
		return "/web/Forums/Forums_post";
	}
	
	@RequestMapping("checkBlog.do")
	public void checkBlog(HttpServletRequest request,HttpServletResponse response,long id)
			throws IOException
	{
		PrintWriter out;
		out = response.getWriter();
		String sql="from ForumPost f where f.postType='"+id+"' and " +
				"(f.postStatus.id=4 or f.postStatus.id=5) order by f.postDate desc";
		List<ForumPost> post=this.forum_postService.listPostBySql(sql);
		
		if(post.size()>0)
		{
			//把最新一篇转载的帖子id返回
			out.print(post.get(0).getId());//已经有人发表过
		}else{
			out.print("nobody");//还没有发表过
		}
		out.close();
	}
	
	
	

	//相关积分的处理
	@SuppressWarnings("static-access")
	public void addWealth(HttpServletRequest request,long userId,long board_id,double addScore)
			{   
	
		
		UserInfo user=userInfoService.findById(userId);
		if(user!=null)
		{
		double userJinzhuan=Double.parseDouble(user.getJinzhuan());
		List<UserUpHi> userUpHis = userUpHisService
				.listUserUpHiByBlog(user.getId());
		if(userJinzhuan<7||(userJinzhuan>=7&&userUpHis.size() > 0))
		{
			//如果金砖小to7和金砖>7且有人评论时才加分
		String newJinzhuan=Double.parseDouble(user.getJinzhuan())+1+"";
        userInfoService.updateJinzhuan(user.getUserName(),newJinzhuan );
        
		if(this.wealthBoardService.findByUser(user.getId(),board_id).size()>0)
		{
		WealthBoard wealthBoard=this.wealthBoardService.findByUser(user.getId(),board_id).get(0);
		double board_wealth=Double.parseDouble(wealthBoard.getWealthQuantity());
		wealthBoard.setWealthQuantity(board_wealth+addScore+"");
		this.wealthBoardService.updateWealthBoard(wealthBoard);
		}else
		{
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
	
	
	
	

	
	@RequestMapping("checkNum.do")
	public void checkNum(HttpServletRequest request,HttpServletResponse response,String mycode)
			throws Exception{   
		System.out.println(mycode);
		 System.out.println(request.getSession().getAttribute("certCode"));
		PrintWriter out;
		out = response.getWriter();
		if( mycode.equalsIgnoreCase((String) request.getSession().getAttribute("certCode"))){
			out.print("ok");		 
		 }else{
			 out.print("error");
		 }
		out.close();

	               }
	
	@RequestMapping(value="forumJubao.do",method=RequestMethod.GET)
	public String forumJubao(HttpServletRequest request,long postId)
	{
		ForumPost post=this.forum_postService.findById(postId);
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
				
		if(post!=null)
			{request.setAttribute("post",post);
			 return "web/Forums/jubao";
			}else
			{
				request.getSession().setAttribute("errorResult","error");
				return "redirect:toResult.do";
			}
		
		
	}
	
	@RequestMapping(value="forumJubao.do",method=RequestMethod.POST)
	public String forumJubao(HttpServletRequest request,
			HttpServletResponse response,long postId)
	{   
		UserInfo user=(UserInfo) request.getSession().getAttribute("userInfo");
		if(user==null)
		{
			request.getSession().setAttribute("errorResult","Only login users can report");
			return "redirect:toResult.do";
		}
		MessageText text=new MessageText();
		String reason=request.getParameter("reason").trim();
		if(reason.length()<=0||reason.length()>200)
		{
			request.getSession().setAttribute("errorResult","Word is unqualified");
			return "redirect:toResult.do";
		}
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("time now:"+df.format(date));
		String nowTime = df.format(date);
		text.setMsgType("jubao");
		text.setMsgSubject("toTopics?post_id="+postId);
		text.setMsgContent(reason);
		text.setMsgTime(nowTime);
		this.messageTextService.saveMessageText(text);
		
		request.getSession().setAttribute("errorResult","Successful, please wait for verification");
		return "redirect:toResult.do";
	}
	
	
	@RequestMapping(value="toResult.do")
	public String toResult(HttpServletRequest request,
			HttpServletResponse response)
	{  
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
		return "web/Forums/result";
	}
	
	
	@RequestMapping(value="manageInForums.html",method=RequestMethod.GET)
	public String manageInForums(HttpServletRequest request,
			HttpServletResponse response,long postId,String record,String message)
	{   
		int nowRecord=Integer.parseInt(record);
		ForumPost post=this.forum_postService.findById(postId);
		//检验用户是不是版主
		UserInfo userInfo=(UserInfo) request.getSession().getAttribute("userInfo");
		List<Master> listMaster=this.masterService.listMasterByBoard(post.getBoard().getId());
		boolean trueMaster=false;
		if(listMaster.size()>0&&userInfo!=null)
		for(int i=0;i<listMaster.size();i++){
			
			if(listMaster.get(i).getUserInfo().getId()==userInfo.getId())
			{
				trueMaster=true;
			}
	
		}
		if(trueMaster==false)
		{
			request.getSession().setAttribute("errorResult","Illegal Operation");
			return "redirect:toResult.do";
		}
		
		String manageType="";
		if(message.equals("well"))
		{
			if(post.getIsWell().equals("1"))
			{ post.setIsWell("0");
			  manageType="unhighlighted";
			}
			else
			{ post.setIsWell("1");
			  manageType="highlighted";
			}
			
		}else if(message.equals("top"))
		{
			if(post.getIsTop().equals("1"))
				{post.setIsTop("0");
				 manageType="Unstick";
				}
			else
			{post.setIsTop("1");
			 manageType="Stick";
			}
		}else if(message.equals("lock"))
		{
			
				post.setPostStatus(this.postStatusService.listPostStatusById(5));
				manageType="Locked";
			
		}else if(message.equals("unlock")){
			post.setPostStatus(this.postStatusService.listPostStatusById(4));
			manageType="Unlocked";
		}
		else if(message.equals("delete"))
		{
			post.setPostContent(userInfo.getNickName()+"to"+getNowTime()+"delete");
		}
		
		//记录操作信息
		post.setProcessUser(userInfo.getNickName());
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowTime = df.format(date);
		post.setProcessTime(nowTime);
		post.setProcessHis(post.getProcessHis()+"->"+userInfo.getNickName()+"to"+nowTime+" "+manageType+"This post");
		
		this.forum_postService.updateForum_post(post);
		return "redirect:listPostByLabel?record="+nowRecord+"&board_id="+post.getBoard().getId();
	}
	
	
	
	// 服务器时间
		public static String getNowTime() {
			Date date = new Date();
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String nowTime = f.format(date);

			return nowTime;
		}
		
		
		@RequestMapping(value="backToPage{id}.do")
		public String backTopage(HttpServletRequest request,
				HttpServletResponse response,@PathVariable long id)
		{  
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
			String strBackUrl="toTopics?post_id="+id;
			request.getSession().setAttribute("strBackUrl", strBackUrl);
			return "redirect:login.html";
		}


}
