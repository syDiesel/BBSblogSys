package com.bbsBlog.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bbsBlog.entity.Answer;
import com.bbsBlog.entity.Audit;
import com.bbsBlog.entity.Board;
import com.bbsBlog.entity.Friend;
import com.bbsBlog.entity.Label;
import com.bbsBlog.entity.Message;
import com.bbsBlog.entity.MessageText;
import com.bbsBlog.entity.QAConcern;
import com.bbsBlog.entity.Question;
import com.bbsBlog.entity.QuestionLabel;
import com.bbsBlog.entity.QuestionPJ;
import com.bbsBlog.entity.UserInfo;
import com.bbsBlog.service.AnswerService;
import com.bbsBlog.service.AuditService;
import com.bbsBlog.service.BlogLabelService;
import com.bbsBlog.service.BoardService;
import com.bbsBlog.service.FriendService;
import com.bbsBlog.service.LabelService;
import com.bbsBlog.service.MessageService;
import com.bbsBlog.service.MessageTextService;
import com.bbsBlog.service.QuestionLabelService;
import com.bbsBlog.service.QuestionPJService;
import com.bbsBlog.service.QuestionService;
import com.bbsBlog.service.UserInfoService;
import com.bbsBlog.serviceImpl.QAConcernServiceImpl;
import com.bbsBlog.util.HtmlSpecialChars;
import com.bbsBlog.util.PageModel;
import com.bbsBlog.util.QAHotUser;

@Controller
@RequestMapping("/web/QandA")
public class QuestionController {

	@Resource
	private QuestionService questionService;
	@Resource
	private BoardService boardService;
	@Resource
	private LabelService labelService;
	@Resource
	private UserInfoService userInfoService;
	@Resource
	private AnswerService answerService;
	@Resource
	private QuestionLabelService questionLabelSerivce;
	@Resource
	private QuestionPJService questionPJService;
	@Resource
	private AuditService auditService;
	@Resource
	private FriendService friendService;
	@Resource
	private UserController userController;
	@Resource
	private BlogLabelService blogLabelService;
	@Resource
	private MessageTextService messageTextService;
	@Resource
	private MessageService messageService;
	@Resource
	private JdbcTemplate  jdbcTemplate;
	@Resource 
	private QAConcernServiceImpl qAConcernServiceImpl;
	
	/*
	 * @author Zhou Junlong
	 * @time 2014-12-27 12:58
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/Home.html", method = RequestMethod.GET)
	public String Home(HttpServletRequest req) {
		getMesCount(req);
		
		//板块列表
		List<Board> Blist = this.boardService.listBoard();
		req.setAttribute("board", Blist);
		//取出全部标签
        List<List<Label>> listAllLabel=new ArrayList<List<Label>>();
        for(int i=0;i<Blist.size();i++)
        {
        	List<Label> listLabel=this.labelService.listLabelByBoard(Blist.get(i).getId());
        	listAllLabel.add(listLabel);
        }
        req.setAttribute("listAllLabel",listAllLabel);
		
		//热门问答
		String sql="from Question order by answerCount desc";
		List<Question> listHotQuestion=questionService.listQuestionBySql(sql);
		if (listHotQuestion.size() > 6) {
			listHotQuestion = listHotQuestion.subList(0, 6);
		}
		req.setAttribute("hotQA", listHotQuestion);
		
		// 获取最新问题，若最新问题超过10条则只显示10条
		sql = "from Question order by q_time desc";
		List<Question> listQuestion = this.questionService.listQuestionBySql(sql);
		List<Question> lastQ = listQuestion;
		if (listQuestion.size() > 10) {
			lastQ = listQuestion.subList(0, 10);
		}
		req.setAttribute("lastQ", lastQ);

/*		// 获取已解决的问题，就是说该问题的答案已经公布了，，at这些问题中随机选取10个问题，若没有10个则，随机取
		List<Question> doQ = new ArrayList<Question>();
		List<Question> openQ = new ArrayList<Question>();
		Random random = new Random(new Date().getTime());
		for (int j = 0; j < listQuestion.size(); j++) {
			List<Answer> answers = this.answerService.findAnswer(listQuestion.get(j).getId());
			int count = 0;
			for (int k = 0; k < answers.size(); k++) {
				if ("noPublic".equals(answers.get(k).getIsPublic()))
					count++;
			}
			if (count != answers.size())
				openQ.add(listQuestion.get(j));
		}
		for (int i = 0; i < 10; i++) {
			if (openQ.size() > 0) {
				int rad = random.nextInt(openQ.size());
				for (int j = 0; j < openQ.size(); j++)
					if (j == rad) {
						doQ.add(openQ.get(rad));
						openQ.remove(rad);
					}
			}
		}
		req.setAttribute("doQ", doQ);*/
		
		// 张嘉 2014/12/17
		//获取已解决的问题，就是说该问题的答案已经公布了
		sql = "from Answer a where a.isBest='isBest' order by a_time desc";
		List<Answer> doQ = this.answerService.listAnswerBySql(sql);
		if (doQ.size() > 10) {
			doQ = doQ.subList(0, 10);
		}
		req.setAttribute("doQ", doQ);
		
		// 获取没有解决的问题，就是说该问题的没有答案或者答案没有一个公布，也是随机获取10个，没有10个就随机取
		List<Question> undoQ = new ArrayList<Question>();
		List<Question> isOpenQ = new ArrayList<Question>();
		Random random = new Random(new Date().getTime());
		for (int i = 0; i < listQuestion.size(); i++) {
			List<Answer> answers = this.answerService.findAnswer(listQuestion.get(i).getId());
			int count = 0;
			for (int j = 0; j < answers.size(); j++) {
				if (answers.get(j).getIsPublic().equals("noPublic"))
					count++;
			}
			if (count == answers.size())
				isOpenQ.add(listQuestion.get(i));
		}
		for (int i = 0; i < 10; i++) {
			if (isOpenQ.size() > 0) {
				int rad = random.nextInt(isOpenQ.size());
				for (int j = 0; j < isOpenQ.size(); j++)
					if (j == rad) {
						undoQ.add(isOpenQ.get(rad));
						isOpenQ.remove(rad);
					}
			}
		}
		req.setAttribute("undoQ", undoQ);
		
		//问答达人
		sql="SELECT UserInfo.id AS uid,UserInfo.nickName AS uname,Board.id AS bid,Board.board_name AS bname,SUM(Answer.up_count) AS sumup "+
			"FROM Answer,Question,UserInfo,Board "+
			"WHERE(Answer.q_id=Question.id) "+"AND(Answer.UserInfo_id=UserInfo.id)  "+
			"AND(Question.boa_id=Board.id) "+
			"AND Answer.UserInfo_id IN "+
			"(SELECT top 10 Answer.UserInfo_id FROM Answer GROUP BY Answer.UserInfo_id ORDER BY SUM(Answer.up_count) DESC ) "+
			"GROUP BY UserInfo.id,UserInfo.nickName,Board.id,Board.board_name ORDER BY SUM(Answer.up_count) DESC";
		List<QAHotUser> listuser=new ArrayList();
		List<Integer> listedid=new ArrayList();
		List rows = jdbcTemplate.queryForList(sql);
		Iterator it = rows.iterator();
		while(it.hasNext()) {
			int flag=1;
		    Map userMap = (Map) it.next();
		    int uid=Integer.valueOf (userMap.get("uid").toString());
		    String uname=userMap.get("uname").toString();
		    int bid=Integer.valueOf (userMap.get("bid").toString());
		    String bname=userMap.get("bname").toString();
		    for(int id:listedid){
		    	if(id==uid){
		    		flag=0;
		    		break;
		    	}
		    }
		    if(flag==1){
		    	listedid.add(uid);
		    	listuser.add(new QAHotUser(uid,uname,bid,bname));
		    }
		}
		req.setAttribute("hotuser", listuser);
		return "/web/QandA/newHome";
	}
	
	// 点击最新部分的更多，对应的处理部分。
	@RequestMapping(value = "/Home/more/last/{pageNum}", method = RequestMethod.GET)
	public String Last(@PathVariable int pageNum, HttpServletRequest req) {
		//获取MesCount值******author: 张嘉
		getMesCount(req);
		List<Board> Blist = this.boardService.listBoard();
		req.setAttribute("board", Blist);
		// 每一页显示5条记录
		int PageSize = 5;
		String type = "last";
		List<Question> question = this.questionService.listQuestionByTime();
		// 共多少条最新问题
		int lRowTotal = question.size();
		// 这些问题共有多少页
		int lpageTotal = (lRowTotal - 1) / PageSize + 1;
		// 根据需要显示第几页获取该页的内容，这里采用的hibernate自带的分页函数
		List<Question> currentPage = this.questionService.findQuestionPageByTime((pageNum - 1) * PageSize, PageSize);
		req.setAttribute("lpageTotal", lpageTotal);
		req.setAttribute("lastQ", currentPage);
		req.setAttribute("typeStr", type);
		req.setAttribute("pageNum", pageNum);
		return "/web/QandA/More";
	}

	// 点击最火部分的更多
	@RequestMapping(value = "/Home/more/hot/{pageNum}", method = RequestMethod.GET)
	public String Hot(@PathVariable int pageNum, HttpServletRequest req) {
		//获取MesCount值******author: 张嘉
		getMesCount(req);
				
		List<Board> Blist = this.boardService.listBoard();
		req.setAttribute("board", Blist);
		int PageSize = 5;
		String type = "hot";
		List<Question> question1 = this.questionService.listQuestion();
		int hRowTotal = question1.size();
		int hPageTotal = (hRowTotal - 1) / PageSize + 1;
		List<Question> currentPage1 = this.questionService.findQuestionPageByHot((pageNum - 1) * PageSize, PageSize);
		req.setAttribute("hpageTotal", hPageTotal);
		req.setAttribute("hotQ", currentPage1);
		req.setAttribute("typeStr", type);
		req.setAttribute("pageNum", pageNum);
		return "/web/QandA/More";
	}

	// 点击未解决部分的更多
	@RequestMapping(value = "/Home/more/undo/{pageNum}", method = RequestMethod.GET)
	public String undoQ(@PathVariable int pageNum, HttpServletRequest req) {
	    //获取MesCount值******author: 张嘉
		getMesCount(req);
				
		List<Board> Blist = this.boardService.listBoard();
		req.setAttribute("board", Blist);
		int PageSize = 5;
		String type = "undo";
		List<Question> question2 = this.questionService.listQuestion();
		List<Question> isOpenQ = new ArrayList<Question>();
		for (int i = 0; i < question2.size(); i++) {
			List<Answer> answers = this.answerService.findAnswer(question2.get(i).getId());
			int count = 0;
			for (int j = 0; j < answers.size(); j++) {
				if ("noPublic".equals(answers.get(j).getIsPublic()))
					count++;
			}
			if (count == answers.size())
				isOpenQ.add(question2.get(i));
		}
		// 获取未解决部分问题一共有多少条记录
		int uRowTotal = isOpenQ.size();
		// 得到未解决问题一共可以有多少页
		int uPageTotal = (uRowTotal - 1) / PageSize + 1;
		int lastNum = pageNum * PageSize;
		if (lastNum > uRowTotal)
			lastNum = uRowTotal;
		// 根据请求的具体的那一页获取该页的具体内容，不过这里的内容是通过subList方法获取的，所以最后一页需要进行判断处理
		List<Question> currentPage2 = isOpenQ.subList((pageNum - 1) * PageSize,
				lastNum);
		req.setAttribute("upageTotal", uPageTotal);
		req.setAttribute("undoQ", currentPage2);
		req.setAttribute("typeStr", type);
		req.setAttribute("pageNum", pageNum);
		return "/web/QandA/More";
	}

	// 点击已解决部分的更多
	@RequestMapping(value = "/Home/more/do/{pageNum}", method = RequestMethod.GET)
	public String doQ(@PathVariable int pageNum, HttpServletRequest req) {
		//获取MesCount值******author: 张嘉
		getMesCount(req);
				
		List<Board> Blist = this.boardService.listBoard();
		req.setAttribute("board", Blist);
		int PageSize = 5;
		String type = "do";
		List<Question> question3 = this.questionService.listQuestion();
		List<Question> openQ = new ArrayList<Question>();
		for (int j = 0; j < question3.size(); j++) {
			List<Answer> answers = this.answerService.findAnswer(question3.get(j).getId());
			int count = 0;
			for (int k = 0; k < answers.size(); k++) {
				if ("noPublic".equals(answers.get(k).getIsPublic()))
					count++;
			}
			if (count != answers.size())
				openQ.add(question3.get(j));
		}
		// 有多少条已解决的问题
		int dRowTotal = openQ.size();
		// 这些已解决问题一共有多少页
		int dPageTotal = (dRowTotal - 1) / PageSize + 1;
		int lastNum1 = pageNum * PageSize;
		if (lastNum1 > dRowTotal)
			lastNum1 = dRowTotal;
		// 同样是通过subList的方法去获取对应的请求页的具体内容
		List<Question> currentPage3 = openQ.subList((pageNum - 1) * PageSize,lastNum1);
		req.setAttribute("dpageTotal", dPageTotal);
		req.setAttribute("doQ", currentPage3);
		req.setAttribute("typeStr", type);
		req.setAttribute("pageNum", pageNum);
		return "/web/QandA/More";
	}

	// 点击具体的某一个板块之后进入的具体页面
	@RequestMapping(value = "/Home/{bId}/{pageNum}", method = RequestMethod.GET)
	public String ShowByBoard(@PathVariable long bId,@PathVariable int pageNum, HttpServletRequest req) {
		//获取MesCount值******author: 张嘉
		getMesCount(req);
		//将选择的boardId传到前台
		req.setAttribute("boardId", bId);
		List<Board> Blist = this.boardService.listBoard();
		req.setAttribute("board", Blist);
		
		//取出全部标签
        List<List<Label>> listAllLabel=new ArrayList<List<Label>>();
        for(int i=0;i<Blist.size();i++)
        {
        	List<Label> listLabel=this.labelService.listLabelByBoard(Blist.get(i).getId());
        	listAllLabel.add(listLabel);
        }
        req.setAttribute("listAllLabel",listAllLabel);
		Board board = this.boardService.listBoardById(bId);
		// 根据板块id去获取对应的问题集合
		//List<Question> questions = this.questionService.findQuestionByBoard(bId);
		List<Question> questions = this.questionService.listQuestionBySql("from Question where boa_id='"+bId+"' order by q_time desc");
		
		/*//转换时间
		SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 格式化时间  
		  
        String nowtime = d.format(new Date());// 按以上格式 将当前时间转换成字符串  
  
        System.out.println("当前时间：" + nowtime);  
        
        for (int i = 0; i < questions.size(); i++) {
        	 String qtime = questions.get(i).getqTime().toString();// 测试时间  
             System.out.println("提问时间：" + qtime);  
       
             try {  
                 long result = (d.parse(nowtime).getTime() - d.parse(qtime)  
                         .getTime()) / 1000;// 当前时间减去测试时间  
                                             // 这个的除以1000得到秒，相应的60000得到分，3600000得到小时  
                 System.out.println("当前时间减去提问时间=" + result + "秒");  
                 String time=qtime;
                 if(result<60){
                	 time="刚刚";
                 }else if(result>=60&&result<3600){
					time=(result/60)+"分钟前";
				}else if(result>=3600&&result<86400){
					time=(result/3600)+"小时前";
				}else if(result>=86400&&result<2592000){
					time=(result/86400)+"天前";
				}
                 questions.get(i).setqTime(time);
             } catch (ParseException e) {  
                 e.printStackTrace();  
             }  
		}*/
       
		
		// 同时根据板块的id 获取该板块下额所有标签的集合
		List<Label> labels = this.labelService.listLabelByBoard(bId);
		req.setAttribute("bod", board);
		req.setAttribute("labels", labels);
		// 还是每一页显示10条记录
		int pageSize = 10;
		// 该板块下的问题一共会有多少页
		int pageTotal = (questions.size() - 1) / pageSize + 1;
		int toIndex = pageNum * pageSize;
		if (toIndex > questions.size())
			toIndex = questions.size();
		List<Question> currentPage = questions.subList((pageNum - 1) * pageSize, toIndex);
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("pageTotal", pageTotal);
		req.setAttribute("pageNum", pageNum);
		
		UserInfo loginUser = (UserInfo) req.getSession().getAttribute("userInfo");
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

		
		return "/web/QandA/QuesList";
	}

	// 点击对应的板块下的标签之后进入的页面
	@RequestMapping(value = "/Home/{bId}/{lId}/{pageNum}", method = RequestMethod.GET)
	public String ShowByLabel(@PathVariable long bId, @PathVariable long lId,@PathVariable int pageNum, HttpServletRequest req) {
		//获取MesCount值******author: 张嘉
		getMesCount(req);
				
		List<Board> Blist = this.boardService.listBoard();
		req.setAttribute("board", Blist);
		Board board = this.boardService.listBoardById(bId);
		req.setAttribute("bod", board);
		List<Label> labels = this.labelService.listLabelByBoard(bId);
		req.setAttribute("labels", labels);
		Label label = this.labelService.listLabelById(lId);
		req.setAttribute("label", label);
		// 通过该标签额id去获取对应的问题记录
		List<QuestionLabel> questionlabels = this.questionLabelSerivce.findByLabel(lId);
		// 将这些问题记录放atquestions中
		List<Question> questions = new ArrayList<Question>();
		for (int j = 0; j < questionlabels.size(); j++) {
			questions.add(questionlabels.get(j).getQuestion());
		}
		// 相关的分页部分
		int pageSize = 5;
		int pageTotal = (questions.size() - 1) / pageSize + 1;
		int toIndex = pageSize * pageNum;
		if (toIndex > questions.size())
			toIndex = questions.size();
		List<Question> currentQuestionLabel = questions.subList((pageNum - 1)* pageSize, toIndex);
		req.setAttribute("pageLabelTotal", pageTotal);
		req.setAttribute("currentPage", currentQuestionLabel);
		req.setAttribute("pageTotal", pageTotal);
		req.setAttribute("pageNum", pageNum);
		req.setAttribute("labelId", lId);
		return "/web/QandA/QuesList";
	}

	// 点击"我要提问"的处理部分
	@RequestMapping(value = "/AskQ", method = RequestMethod.GET)
	public String QuestCommit(HttpServletRequest req) {
		//获取MesCount值******author: 张嘉
		getMesCount(req);
				
		/*// 当该提问人没有登录的时候，将会跳转到登陆界面
		if (req.getSession().getAttribute("userInfo") == null || req.getSession().getAttribute("userInfo") == "") {
			return "redirect:../../login.html";
		}*/
		//Author：张嘉
		UserInfo loginUser = (UserInfo) req.getSession().getAttribute(
				"userInfo");
		// Check是否登录 http://localhost:8080/BBSblogSys/
		if (loginUser == null) {
			String strBackUrl = "http://" + req.getServerName() // 服务器地址
					+ ":" + req.getServerPort() // 端口号
					+ req.getContextPath() // 项目名称
					+ req.getServletPath(); // 请求页面或其他地址
			/* + "?" + (request.getQueryString()) */// 参数
			req.getSession().setAttribute("strBackUrl", strBackUrl);
			return "redirect:../../login.html";
		}
		List<Board> Blist = this.boardService.listBoard();
		req.setAttribute("board", Blist);
		return "/web/QandA/AskQ";
	}

	// 根据板块id获取对应板块先的标签的Ajax
	@RequestMapping(value = "/{board_id}", method = RequestMethod.GET)
	public void getLabel(@PathVariable long board_id,HttpServletResponse response) {
		List<Label> listFromDB = this.labelService.listLabelByBoard(board_id);
		List<Label> list = new ArrayList<Label>();
		for (int i = 0; i < listFromDB.size(); i++) {
			Label l = new Label();
			l.setId(listFromDB.get(i).getId());
			l.setLabelName(listFromDB.get(i).getLabelName());
			l.setLabelDesc(listFromDB.get(i).getLabelDesc());
			list.add(l);
		}
		try {
			ObjectMapper mapper = new ObjectMapper();
			String result = mapper.writeValueAsString(list);
			response.setContentType("text/javascript;charset=utf-8");
			response.getWriter().print(result);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 这是判断用户的余额是否足够提问的Ajax
	@RequestMapping(value = "/jugde/{value}/{type}", method = RequestMethod.GET)
	public void Jugde(@PathVariable double value, @PathVariable String type,HttpServletRequest req, HttpServletResponse response) {
		UserInfo userinfo = (UserInfo) req.getSession().getAttribute("userInfo");
		double currentMoney = 0;
		if ("jinzhuan".equals(type)) {
			if (userinfo.getJinzhuan() != null)
				currentMoney = Double.parseDouble(userinfo.getJinzhuan());
			if (value > currentMoney) {
				try {
					ObjectMapper mapper = new ObjectMapper();
					String result = mapper.writeValueAsString("");
					response.setContentType("text/javascript;charset=utf-8");
					response.getWriter().print(result);
				} catch (JsonGenerationException e1) {
					e1.printStackTrace();
				} catch (JsonMappingException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		} else {
			if (userinfo.getLingdan() != null)
				currentMoney = Double.parseDouble(userinfo.getLingdan());
			if (value > currentMoney) {
				try {
					ObjectMapper mapper = new ObjectMapper();
					String result = mapper.writeValueAsString("");
					response.setContentType("text/javascript;charset=utf-8");
					response.getWriter().print(result);
				} catch (JsonGenerationException e1) {
					e1.printStackTrace();
				} catch (JsonMappingException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	// 这是进入具体提问页面点击提问按钮的处理部分
	@RequestMapping(value = "/AskQ", method = RequestMethod.POST)
	public String QuestCommit(HttpServletRequest req, Question question) {
		//获取MesCount值******author: 张嘉
		getMesCount(req);
				
		String qSubject = req.getParameter("qSubject");
		String qContent = req.getParameter("qContent");
		long board_id = Integer.parseInt(req.getParameter("board_id"));
		// 获取复选框中的标签集合，将这些标签的id放到labels_id中
		String[] labels_id = req.getParameterValues("labels");
		// 获取是否选择一定等级的人来回答
		String check = req.getParameter("check");
		// 先将等级初始化为0
		String qAccess = "0";
		// 获取悬赏的类型
		String ral = req.getParameter("radiovalue");
		// 初始悬赏额为0
		String value = "0";
		// 如果用户at悬赏栏中输入非法数字的时候，进行的后台处理
		String s = req.getParameter("value").trim();
		
		if("".equals(s)||s.equals(null)||"null".equals(s)){
			s="0";
		}
		// 输入值的前面的0去掉
		if (s.matches("[0-9]*"))
			if (!"0".equals(s))
				value = req.getParameter("value").replaceAll("^(0+)", "");
		String ishiddenUser = req.getParameter("hiddenUser");
		UserInfo userinfo = (UserInfo) req.getSession().getAttribute("userInfo");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String qTime = sdf.format(new Date());
		question.setQSubject(HtmlSpecialChars.htmlspecialchars(qSubject));
		question.setQContent(HtmlSpecialChars.htmlspecialchars(qContent));
		question.setBoard(this.boardService.listBoardById(board_id));
		// 若是选择了一定等级人来回答
		if ("ischeck".equals(check)) {
			if (req.getParameter("qAccess") != null || req.getParameter("qAccess") != "")
				// 获取对应的选择等级
				qAccess = req.getParameter("qAccess");
			/* ---------额外的对系统需要支持相对应的钱-------- */
			if (Integer.parseInt(qAccess) > Integer.parseInt(userinfo.getUserLevel())) {
				double lingdan = Double.parseDouble(userinfo.getLingdan());
				System.out.println("***********灵丹："+lingdan);
				if (lingdan >= 1) {
					userinfo.setLingdan(lingdan - 1 + "");
					this.userInfoService.updateUserInfo(userinfo);
				} else {
					req.setAttribute("result", "No enough panaceas, please recharge");
					return "/web/ERROR/error";
				}
			}
		}
		if ("checked".equals(ishiddenUser)) {
			ishiddenUser = "hidden";
		} else
			ishiddenUser = "show";
		question.setQAccess(qAccess);
		question.setMoneyType(ral);
		question.setValue(value);
		question.setUserInfo(userinfo);
		question.setQTime(qTime);
		question.setHiddenUser(ishiddenUser);
		this.questionService.saveQuestion(question);
		QuestionLabel questionLabel = new QuestionLabel();
		for (int i = 0; i < labels_id.length; i++) {
			Label label = this.labelService.listLabelById(Long.parseLong(labels_id[i]));
			label.setQuestionCount(label.getQuestionCount()+1);
			this.labelService.updateLabel(label);
			questionLabel.setLabel(label);
			questionLabel.setQuestion(question);
			this.questionLabelSerivce.save(questionLabel);
		}

		// 审计部分
		Audit audit = new Audit();
		audit.setAuditTime(question.getQTime());
		audit.setAuditContent(question.getQSubject());
		audit.setAuditType("WD");
		audit.setAuditId(question.getId() + "");
		audit.setUserInfo(question.getUserInfo());
		auditService.saveAduit(audit);
		return "redirect:/web/QandA/comSuccess/" + question.getId();
		// 这里若是采用return ComSuccess(req, question)
		// 这种跳转方法的话那么at进入到登录之后的页面，当你重新刷新页面的时候重新提交你刚刚提交的问题，这是用户不希望看到的;
	}

	// 跳转到提问成功之后额页面
	@RequestMapping(value = "/comSuccess/{qId}", method = RequestMethod.GET)
	public String ComSuccess(@PathVariable long qId, HttpServletRequest req) {
		//获取MesCount值******author: 张嘉
		getMesCount(req);
				
		req.setAttribute("question", this.questionService.findQuestion(qId));
		List<QuestionLabel> questionLabels = this.questionLabelSerivce.findByQuestion(qId);
		List<Label> labels = new ArrayList<Label>();
		for (int i = 0; i < questionLabels.size(); i++)
			labels.add(questionLabels.get(i).getLabel());
		req.setAttribute("labels", labels);
		return "redirect:/web/QandA/QuestionFind/" + qId;
	}

	// 这是问题的更新页面处理，只有当该问题没有人进行回答的之前提问者才能对问题进行更新
	@RequestMapping(value = "/QuesUpdate/{questionId}", method = RequestMethod.GET)
	public String UpdateQuestion(@PathVariable long questionId,HttpServletRequest req) {
		//获取MesCount值******author: 张嘉
		getMesCount(req);
				
		List<Answer> answer = this.answerService.findAnswer(questionId);
		// 判断该问题是否有人进行了回答，若没有则可以进行更新，若有则该问题是不能更新的
		if (answer.size() == 0) {
			Question question = this.questionService.findQuestion(questionId);
			req.setAttribute("question", question);
			return "redirect:/web/QandA/AskQ";
		} else
			return "redirect:/web/QandA/QuestionFind/" + questionId;
	}

	// 提交更新内容的相关处理部分
	@RequestMapping(value = "/QuesUpdate", method = RequestMethod.POST)
	public String UpdateQuestion(HttpServletRequest req) {
		//获取MesCount值******author: 张嘉
		getMesCount(req);
				
		String qSubject = req.getParameter("qSubject");
		String qContent = req.getParameter("qContent");
		long board_id = Integer.parseInt(req.getParameter("board_id"));
		String[] labels_id = req.getParameterValues("labels");
		String check = req.getParameter("check");
		String qAccess = "0";
		String ral = req.getParameter("radiovalue");
		String value = "0";
		String s = req.getParameter("value").trim();
		if (s.matches("[0-9]*"))
			if (!"0".equals(s))
				value = req.getParameter("value").replaceAll("^(0+)", "");
		UserInfo userinfo = new UserInfo();
		String ishiddenUser = req.getParameter("hiddenUser");
		userinfo = (UserInfo) req.getSession().getAttribute("userInfo");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String qTime = sdf.format(new Date());
		// 这里是直接从session中取刚刚更新问题的id
		long qId = Long.parseLong((req.getSession().getAttribute("questionId").toString()));
		Question question = this.questionService.findQuestion(qId);
		question.setQSubject(HtmlSpecialChars.htmlspecialchars(qSubject));
		question.setQContent(HtmlSpecialChars.htmlspecialchars(qContent));
		question.setBoard(this.boardService.listBoardById(board_id));

		if ("ischeck".equals(check)) {
			if (req.getParameter(qAccess) != null || req.getParameter(qAccess) != "")
				qAccess = req.getParameter(qAccess);
			// ========那么这里就不需要再对系统进行支付了========= //
		}
		if ("checked".equals(ishiddenUser)) {
			ishiddenUser = "hidden";
		} else
			ishiddenUser = "show";
		question.setQAccess(qAccess);
		question.setMoneyType(ral);
		question.setValue(value);
		question.setUserInfo(userinfo);
		question.setQTime(qTime);
		question.setHiddenUser(ishiddenUser);
		this.questionService.updateQuestion(question);

		List<QuestionLabel> questionLabels = this.questionLabelSerivce.findByQuestion(qId);
		for (int i = 0; i < questionLabels.size(); i++) {
			this.questionLabelSerivce.delete(questionLabels.get(i).getId());
		}
		for (int i = 0; i < labels_id.length; i++) {
			QuestionLabel questionLabel = new QuestionLabel();
			long label_id = Long.parseLong(labels_id[i]);
			questionLabel.setLabel(this.labelService.listLabelById(label_id));
			questionLabel.setQuestion(question);
			// this.questionLabelSerivce.update(questionLabel);
			this.questionLabelSerivce.save(questionLabel);
		}
		return "redirect:/web/QandA/comSuccess/" + question.getId();
	}

	// 对问题进行删除,删除成功之后跳转到问答版块的主界面
	@RequestMapping("/QuesDelete/{questionId}")
	public String DeleteQuestion(@PathVariable long questionId,HttpServletRequest req) {
		//获取MesCount值******author: 张嘉
		getMesCount(req);
				
		List<QuestionLabel> questionLabel = this.questionLabelSerivce.findByQuestion(questionId);
		for (int i = 0; i < questionLabel.size(); i++) {
			this.questionLabelSerivce.delete(questionLabel.get(i).getId());
		}
		this.questionService.deleteQuestion(questionId);
		return "redirect:/web/QandA/Home.jsp";
	}

	/*
	 * @RequestMapping("/QuestionList") public String
	 * ListQuestion(HttpServletRequest req) { List<Question> list =
	 * this.questionService.listQuestion(); req.setAttribute("list", list);
	 * return "/web/QandA/QuesList"; }
	 */

	// 根据问题的id找到具体的问题
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/QuestionFind/{id}")
	public String QuestionFind(@PathVariable long id, HttpServletRequest req) {
		//获取MesCount值******author: 张嘉
		getMesCount(req);
		
		//获取板块信息
		List<Board> Blist = this.boardService.listBoard();
		req.setAttribute("board", Blist);
		 //取出全部标签
        List<List<Label>> listAllLabel=new ArrayList<List<Label>>();
        for(int i=0;i< Blist.size();i++)
        {
        	List<Label> listLabel=this.labelService.listLabelByBoard( Blist.get(i).getId());
        	listAllLabel.add(listLabel);
        }
        req.setAttribute("listAllLabel",listAllLabel);
		
		Question question = this.questionService.findQuestion(id);
		req.setAttribute("question", question);
		List<QuestionLabel> questionLabels = this.questionLabelSerivce.findByQuestion(id);

		req.setAttribute("Labels", questionLabels);
		UserInfo userInfo = (UserInfo) req.getSession().getAttribute("userInfo");
		req.setAttribute("loginer", userInfo);

		/**
		 * @author LCY
		 * 最佳回答
		 */
		List<Answer>sortAnswers=this.answerService.listAnswerBySql("from Answer where q_id='"+id+"'order by up_count desc");
		
		List<Answer> bestanswer=new ArrayList<Answer>();
		List<Answer>bestanswerzhui=new ArrayList<Answer>();
		if(sortAnswers.size()!=0){
			// int maxup_count=sortAnswers.get(0).getUpCount();
			// bestanswer=this.answerService.listAnswerBySql("from Answer where up_count='"+maxup_count+"' and Qcommit='GOOD' and q_id='"+id+"'");
			 bestanswer=this.answerService.listAnswerBySql("from Answer where isBest='isBest' and q_id='"+id+"'");	
			 if (bestanswer.size()!=0) {
				 bestanswer=bestanswer.subList(0, 1);
				 bestanswerzhui=this.answerService.listAnswerBySql("from Answer where isReAsk='"+bestanswer.get(0).getId()+"' or related='"+bestanswer.get(0).getId()+"'");
			}
			
		}

		List<Answer> answer=new ArrayList<Answer>();
		if(bestanswer.size()!=0){
			answer = this.answerService.listAnswerBySql("from Answer where id<>'"+bestanswer.get(0).getId()+"' and q_id='"+id+"'");// 除最佳回答外的所有回答
		}else {
			answer = this.answerService.findAnswer(id);// 所有的回答
		}
		req.setAttribute("bestanswer", bestanswer);
		req.setAttribute("bestanswerzhui", bestanswerzhui);
		
		System.out.println("************************bestanswer.size="+bestanswer.size()+";answer.size"+answer.size());
		
		//List<Answer> answer = this.answerService.findAnswer(id);// 所有的回答
		
		List<Answer> showAnswer = new ArrayList<Answer>();// 已公开的答案
		List<Answer> zhuiwen = new ArrayList<Answer>();
		List<Answer> zhuida = new ArrayList<Answer>();
		List<QuestionPJ> comments = new ArrayList<QuestionPJ>();
		Map<Long, List> wenMap = new HashMap<Long, List>();
		Map<Long, List> daMap = new HashMap<Long, List>();
		Map<Long, String> noCom = new HashMap<Long, String>();

		for (int i = 0; i < answer.size(); i++) {
			// at答案表中，根据提问人的id和答案的id，就可以获取对应的追问内容，因为只有提问人的答案才算追问
			zhuiwen = this.answerService.findZhuiWen(question.getUserInfo().getId(), answer.get(i).getId());
			// at答案表中，根据这个答案的回答者id和答案额id获取对应的追答内容
			zhuida = this.answerService.findZhuiWen(answer.get(i).getUserInfo().getId(), answer.get(i).getId());
			// 将追问和追答的内容按照答案分类放到map中
			wenMap.put(answer.get(i).getId(), zhuiwen);
			daMap.put(answer.get(i).getId(), zhuida);
			this.answerService.updateAnswer(answer.get(i));
			// *******************************判断结束********************************
		}

		// 当登陆的这个人就是提问者本身的时候
		if (userInfo != null
				&& userInfo.getId() == question.getUserInfo().getId()) {

			// 开始分页
			int record = 1;
			if (req.getParameter("record") != null)
				record = Integer.parseInt(req.getParameter("record"));
			int pageRecords = 7; // 每页显示的记录数,这个可以自己设定
			int allRecords = answer.size(); // 总的记录
			int allPage = (allRecords - 1) / pageRecords + 1; // 总页数
			PageModel pages = new PageModel();
			answer = pages.fenYe(answer, pageRecords, record, allPage, allRecords);// 调用Pages的方法，进行分页
			req.setAttribute("record", record);// 当前页
			req.setAttribute("pageRecords", pageRecords);// 每页显示的记录数
			req.setAttribute("allPage", allPage);// 总的页数
			req.setAttribute("answerList", answer);
			req.setAttribute("zhuiwen", wenMap);
			req.setAttribute("zhuida", daMap);

			// 判断楼主是否有关注者
			List replyFriend = new ArrayList();
			for (int i = 0; i < answer.size(); i++) {
				List<Friend> isReplyFriend = this.friendService.IsFriend( userInfo.getId(), answer.get(i).getUserInfo().getId());
				if (isReplyFriend.size() > 0) {
					replyFriend.add("1");
				} else {
					replyFriend.add("0");
				}
			}
			req.setAttribute("replyFriend", replyFriend);
			return "/web/QandA/AnsQer";
		}

		// 如果看到这个问题的人不是提问者本身
		else {
			for (int i = 0; i < answer.size(); i++) {
				// 如果登陆者就是这个回答者本身，或者这个答案已经公布了，因为只要满足其中之一的条件，方可看到答案
				if ((userInfo != null && userInfo.getId() == answer.get(i).getUserInfo().getId()) || "Public".equals(answer.get(i).getIsPublic())) {
					// 将能看到的答案放到showAnswer中
					showAnswer.add(answer.get(i));
				}
			}
			for (int i = 0; i < showAnswer.size(); i++) {
				List<QuestionPJ> comment = this.questionPJService.findQuestionPJByA(showAnswer.get(i).getId());
				long count = 0;
				for (int j = 0; j < comment.size(); j++) {
					comments.add(comment.get(j));
					if (userInfo != null && comment.get(j).getUserInfo().getId() != userInfo.getId()) {
						count++;
					}
				}
				if (count == comment.size())
					noCom.put(showAnswer.get(i).getId(), "noCommented");
			}
			// 开始分页
			int record = 1;
			if (req.getParameter("record") != null)
				record = Integer.parseInt(req.getParameter("record"));
			int pageRecords = 7; // 每页显示的记录数,这个可以自己设定
			int allRecords = showAnswer.size(); // 总的记录
			int allPage = (allRecords - 1) / pageRecords + 1; // 总页数
			PageModel pages = new PageModel();
			showAnswer = pages.fenYe(showAnswer, pageRecords, record, allPage,allRecords);// 调用Pages的方法，进行分页
			req.setAttribute("record", record);// 当前页
			req.setAttribute("pageRecords", pageRecords);// 每页显示的记录数
			req.setAttribute("allPage", allPage);// 总的页数

			req.setAttribute("noCom", noCom);
			req.setAttribute("answerList", showAnswer);
			req.setAttribute("zhuiwen", wenMap);
			req.setAttribute("zhuida", daMap);
			req.setAttribute("comments", comments);

			// 判断访问者是否关注Reply者
			List replyFriend = new ArrayList();
			if (userInfo != null) {
				for (int i = 0; i < showAnswer.size(); i++) {
					List<Friend> isReplyFriend = this.friendService.IsFriend(
							userInfo.getId(), showAnswer.get(i).getUserInfo().getId());
					if (isReplyFriend.size() > 0) {
						replyFriend.add("1");
					} else {
						replyFriend.add("0");
					}
				}
			}
			req.setAttribute("replyFriend", replyFriend);

			// 判断访问者是否关注了提问者
			String postFriend = "nouser";
			if (userInfo != null) {
				List<Friend> isPostFriend = this.friendService.IsFriend(
						userInfo.getId(), question.getUserInfo().getId());
				if (isPostFriend.size() > 0) {
					postFriend = "1";
				} else {
					postFriend = "0";
				}
			}
			req.setAttribute("postFriend", postFriend);

			return "/web/QandA/AnsQ";
		}

	}

	// 对问题提交对应的回答的处理
	@RequestMapping(value = "/CommitAns", method = RequestMethod.POST)
	public String CommitAns(HttpServletRequest req) {
		//获取MesCount值******author: 张嘉
		getMesCount(req);
				
		long qId = Long.parseLong(req.getParameter("qId"));
		Question question = this.questionService.findQuestion(qId);
		question.setAnswerCount(question.getAnswerCount()+1);
		 this.questionService.updateQuestion(question);
		// 回答的内容
		String aContent = req.getParameter("aContent");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String aTime = sdf.format(new Date());
		Answer answer = new Answer();
		answer.setAContent(aContent);
		answer.setATime(aTime);
		answer.setQuestion(question);
		// 选择是否接受该提问者的悬赏
		String isAccept = req.getParameter("isAccept");
		answer.setBaochou(isAccept);

		answer.setIsPublic("noPublic");
		try {
			if (req.getSession().getAttribute("userInfo")!=null) {
				answer.setUserInfo((UserInfo) req.getSession().getAttribute("userInfo"));
			}else {
				return "redirect:/login.html";
			}
			
			// 这个表示的是上一级直接关联的追问或者追答。-1的时候表示该答案没有上一级答案而且该答案还没有被提问者打开过
			answer.setIsReAsk(-1);
			// 这个问题的追问次数统计，初始化为0，没有人追问
			answer.setReCount(0);
			// 这个是直接初始关联的那个答案，就是所有的追问或者是追答是对某个最初个那个答案额追寻。初始化为0，是不存at0号问题的所以表示它不是追问或者追问的内容，而是独立的一个答案
			answer.setRelated(0);
			// 对该问题的评价进行初始化
			answer.setDown("0");
			answer.setNormal("0");
			answer.setUpCount(0);
			this.answerService.saveAnswer(answer);
			MessageText messageText = new MessageText();
			String basePath = req.getParameter("basePath");
			UserInfo userInfo1 = new UserInfo();// 收信人
			// 回答者回答了提问者的追问后，发私信给提问者
			messageText.setMsgContent(answer.getUserInfo().getNickName()+"&nbsp;at<a href='" + basePath+ "web/QandA/QuestionFind/" + question.getId() + "'>" + "《"+ question.getQSubject() + "》</a>回答了您的问题，请及时Check！<br/><a href='" + basePath+ "web/QandA/QuestionFind/" + question.getId() + "'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;点击Check</a>");
			userInfo1 = question.getUserInfo();
			messageText.setMsgSubject("System Messages");
			String nowTime = getNowTime();
			messageText.setMsgTime(nowTime);
			messageText.setMsgType("QandA");
			this.messageTextService.saveMessageText(messageText);
			//设置发送信息对象***********Author：张嘉
			Message message = new Message();
			message.setIsRead("0");
			message.setMessageText(messageText);
			//获取管理员信息
			List<UserInfo> userInfoList=userInfoService.findUserByName("admin");
			UserInfo admin=userInfoList.get(0);
			//设置发信人为管理员
			message.setUserInfo2(admin);
			message.setUserInfo1(userInfo1);
			//发送信息
			this.messageService.saveMessage(message);
			
		} catch (Exception e) {
			// TODO: handle exception
			return "redirect:/login.html";
		}
		
		
		return "redirect:/web/QandA/QuestionFind/" + qId;
		
	}

	// 对追问或者追答内容额提交处理
	@RequestMapping(value = "/submitReAsk", method = RequestMethod.POST)
	public String SubReAsk(HttpServletRequest req, Answer reAnswer) {
		//获取MesCount值******author: 张嘉
		getMesCount(req);
				
		long reCount = 0;
		// 获取该问题的id
		long qId = Long.parseLong(req.getParameter("questionId"));
		// 获取该初答案的id
		long aId = Long.parseLong(req.getParameter("answerId"));
		// 是对那个追问进行再次的追问
		long zhuiId = Long.parseLong(req.getParameter("zhuiwenId"));
		// 判断是提问者提交的内容还是回答者提交的内容
		String useType = req.getParameter("userType");
		Question question = this.questionService.findQuestion(qId);
		Answer answer = new Answer();
		answer = this.answerService.findOneAnswer(aId);
		List<Answer> answers = this.answerService.findAnswer(qId);
		List<Answer> zhuiwen = new ArrayList<Answer>();
		// 先获取答案之前已经追问了多少次
		reCount = answer.getReCount();
		// 若是问题额提问者提交的内容，则属于追问的内容
		if ("Asker".equals(useType))
			// 追问次数加+1
			reCount = reCount + 1;
		for (int i = 0; i < answers.size(); i++) {
			zhuiwen = this.answerService.findZhuiWen(question.getUserInfo().getId(), answers.get(i).getId());
		}

		String ReAskText = req.getParameter("zhuiQuestion");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String aTime = simpleDateFormat.format(new Date());
		reAnswer.setAContent(ReAskText);
		reAnswer.setATime(aTime);
		reAnswer.setUserInfo((UserInfo) req.getSession().getAttribute("userInfo"));
		reAnswer.setIsReAsk(zhuiId);
		reAnswer.setReCount(0);
		reAnswer.setRelated(aId);
		this.answerService.saveAnswer(reAnswer);

		//提问的人和回答的人消息回发设置
		//设置发送信息的文本对象***********author:张嘉
		MessageText messageText = new MessageText();
		String basePath = req.getParameter("basePath");
		UserInfo userInfo1 = new UserInfo();// 收信人
		if (reAnswer.getUserInfo().getId() == question.getUserInfo().getId()) {// 发私信给回答者
			messageText.setMsgContent(question.getUserInfo().getNickName()+"&nbsp;at<a href='" + basePath+ "web/QandA/QuestionFind/" + question.getId() + "'>" + "《"+ question.getQSubject()+ "》</a>questioning in…to you, Please answer my question within 7 days to get reward！<br/><a href='" + basePath+ "web/QandA/QuestionFind/" + question.getId() + "'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Reply</a>");
			userInfo1 = answer.getUserInfo();
		} else {
			// 回答者回答了提问者的追问后，发私信给提问者
			messageText.setMsgContent(answer.getUserInfo().getNickName()+"&nbsp;at<a href='" + basePath+ "web/QandA/QuestionFind/" + question.getId() + "'>" + "《"+ question.getQSubject() + "》</a>Already answered your question, please check！<br/><a href='" + basePath+ "web/QandA/QuestionFind/" + question.getId() + "'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Check</a>");
			userInfo1 = question.getUserInfo();
		}
		messageText.setMsgSubject("System Messages");
		String nowTime = getNowTime();
		messageText.setMsgTime(nowTime);
		messageText.setMsgType("QandA");
		this.messageTextService.saveMessageText(messageText);
		//设置发送信息对象***********Author：张嘉
		Message message = new Message();
		message.setIsRead("0");
		message.setMessageText(messageText);
		//获取管理员信息
		List<UserInfo> userInfoList=userInfoService.findUserByName("admin");
		UserInfo admin=userInfoList.get(0);
		//设置发信人为管理员
		message.setUserInfo2(admin);
		message.setUserInfo1(userInfo1);
		//发送信息
		this.messageService.saveMessage(message);
		
		/*
		 * //当提问者对该答案没有进行评论之前
		 * if(answer.getqComment()==null||"".equals(answer.getqComment())){
		 * //若追问的次数有了3次 if("Answer".equals(useType)&&zhuiwen.size()==3){
		 * //该答案将自动变成公布的答案 answer.setIsPublic("Public"); //该提问者的悬赏的金额将自动先转到第三方
		 * UserInfo uAnswer=new UserInfo(); uAnswer=answer.getUserInfo(); long
		 * current=0; if("jinzhuan".equals(monType)){
		 * current=Long.parseLong(uAnswer
		 * .getJinzhuan())+Long.parseLong(monValue);
		 * uAnswer.setJinzhuan(String.valueOf(current)); } else{
		 * current=Long.parseLong
		 * (uAnswer.getLingdan())+Long.parseLong(monValue);
		 * uAnswer.setLingdan(String.valueOf(current)); }
		 * this.userInfoService.updateUserInfo(uAnswer); } }
		 */
		if (answer.getIsPublic().equals("noPublic")) {
			// 此问题还未被公开
			if ("Answer".equals(useType) && zhuiwen.size() == 3) {
				long zhuidaCount = 0;
				// 追问已达到三次(有可能回答者Reply了一个追问多次，有些追问一次都没有Reply)
				for (int k = 0; k < zhuiwen.size(); k++) {
					String sql1 = "from Answer a where a.related="+ answer.getId() + " and a.isReAsk="+ zhuiwen.get(k).getId();
					List<Answer> lastZhuiDa = this.answerService.listAnswerBySql(sql1);
					if (lastZhuiDa.size() > 0) {
						zhuidaCount++;
					}
				}
				if (zhuidaCount == 3) {// 用户已回答了每一次追问
					answer.setIsPublic("Public");
					if (answer.getBaochou().equals("accept")) {
						UserInfo answerUser = answer.getUserInfo();
						// 如果用户接受悬赏
						if (question.getMoneyType().equals("jinzhuan"))
							answerUser.setJinzhuan(Double.parseDouble(answerUser.getJinzhuan())+ Double.parseDouble(question.getValue())+ "");
						if (question.getMoneyType().equals("lingdan"))
							answerUser.setLingdan(Double.parseDouble(answerUser.getLingdan())+ Double.parseDouble(question.getValue())*0.9+ "");
						this.userInfoService.updateUserInfo(answerUser);
					}
				}
			}
		}
		answer.setReCount(reCount);
		this.answerService.updateAnswer(answer);
		return "redirect:/web/QandA/QuestionFind/" + qId;
	}

	// 点击Check答案按钮的处理
	@RequestMapping(value = "/isLookAnswer", method = RequestMethod.POST)
	public String JungeCurrnet(HttpServletRequest req) {
		//获取MesCount值******author: 张嘉
		getMesCount(req);
				
		String ral = req.getParameter("moneyType");
		String value = req.getParameter("moneyValue");
		/* String uId=req.getParameter("userId"); */
		String qId = req.getParameter("questionId");
		String aId = req.getParameter("answerId");
		
		Answer answer = this.answerService.findOneAnswer(Long.parseLong(aId));
		
		/***
		 * 判断是否要报酬，不要则将value置为0
		 * @author LCY
		 */
		if (answer.getBaochou().equals("noAccept")) {
			value="0";	
		}
		
		System.out.println("**************vlaue="+value);
		
		UserInfo userinfo = (UserInfo) req.getSession().getAttribute("userInfo");
		if (userinfo == null)
			return "redirect:login.html";
		double current = 0;
		if (ral.equals("jinzhuan")) {
			current = Double.parseDouble(userinfo.getJinzhuan());
			double balance = current - Double.parseDouble(value);
			if (balance < 0)
			/* return "/web/QandA/chongzhi"; */
			{
				req.setAttribute("result", "Insufficient account balance");
				//获取当前页码
				String recordString=req.getParameter("record");
				System.out.println("************************record="+recordString);
				if (recordString.equals("")||recordString.equals(null)||recordString.equals("null")) {
					return "redirect:/web/QandA/QuestionFind/"+ Long.parseLong(qId);
				}else {
					return "redirect:/web/QandA/QuestionFind/"+ Long.parseLong(qId)+"?record="+recordString;
				}
			} else {
				// 将isReAsk的值设置为0时候则表示该答案点开过了
				answer.setIsReAsk(0);
				answer.setLtime(getNowTime());
				this.answerService.updateAnswer(answer);
				userinfo.setJinzhuan(balance + "");
				this.userInfoService.updateUserInfo(userinfo);
				
				//获取当前页码
				String recordString=req.getParameter("record");
				System.out.println("************************record="+recordString);
				if (recordString.equals("")||recordString.equals(null)||recordString.equals("null")) {
					return "redirect:/web/QandA/QuestionFind/"+ Long.parseLong(qId);
				}else {
					return "redirect:/web/QandA/QuestionFind/"+ Long.parseLong(qId)+"?record="+recordString;
				}
				
			}
		}

		else {
			if (userinfo.getLingdan() != null)
				current = Double.parseDouble(userinfo.getLingdan());
			double balance = current - Double.parseDouble(value);
			if (balance < 0)
			/* return "/web/QandA/chongzhi"; */
			{
				req.setAttribute("result", "No enough panaceas, please recharge");
				//获取当前页码
				String recordString=req.getParameter("record");
				System.out.println("************************record="+recordString);
				if (recordString.equals("")||recordString.equals(null)||recordString.equals("null")) {
					return "redirect:/web/QandA/QuestionFind/"+ Long.parseLong(qId);
				}else {
					return "redirect:/web/QandA/QuestionFind/"+ Long.parseLong(qId)+"?record="+recordString;
				}
			} else {
				answer.setIsReAsk(0);
				answer.setLtime(getNowTime());
				this.answerService.updateAnswer(answer);
				userinfo.setLingdan(balance + "");
				this.userInfoService.updateUserInfo(userinfo);
				//获取当前页码
				String recordString=req.getParameter("record");
				System.out.println("************************record="+recordString);
				if (recordString.equals("")||recordString.equals(null)||recordString.equals("null")) {
					return "redirect:/web/QandA/QuestionFind/"+ Long.parseLong(qId);
				}else {
					return "redirect:/web/QandA/QuestionFind/"+ Long.parseLong(qId)+"?record="+recordString;
				}
			}
		}

	}

	// 评价处理额Ajax
		@RequestMapping(value = "/common/{aId}/{qId}/{uId}/{comment}/{type}", method = RequestMethod.GET)
		public void comment(@PathVariable long aId, @PathVariable long qId,
				@PathVariable long uId, @PathVariable String comment,
				@PathVariable String type,HttpServletResponse response,HttpSession session) {
			System.out.println("WWWW" + aId);
			System.out.println("WWWW" + qId);
			System.out.println("WWWW" + uId);
			System.out.println("WWWW" + comment);
			System.out.println("WWWW" + type);
			Answer answer = this.answerService.findOneAnswer(aId);
			Question question = this.questionService.findQuestion(qId);
			String monType = question.getMoneyType();
			String monValue = question.getValue();
			
			/**
			 * @author LCY
			 * 判断是否要报酬，不要报酬将monValue置为0
			 */
			if (answer.getBaochou().endsWith("noAccept")) {
				monValue="0";
			}
			
			
			
			UserInfo userInfo = this.userInfoService.findById(uId);
			QuestionPJ commented = new QuestionPJ();
			commented.setAnswer(answer);
			commented.setUserInfo(userInfo);
			String commentStr = null;

			if ("Questioner".equals(type)) {
				
				//获取回答的用户
				UserInfo userInfoAnswer=answer.getUserInfo();
				
				if ("downQ".equals(comment)){
					commentStr = "Sorry";

				//回答者downNum数量加1
				long userDownNum=userInfoAnswer.getDownNum()+1;
				userInfoAnswer.setDownNum(userDownNum);
				//提问者评价，回答者quizzerDown加1
				long quizzerDown=userInfoAnswer.getQuizzerDown()+1;
				userInfoAnswer.setQuizzerDown(quizzerDown);

				}else if ("normalQ".equals(comment)){
					
					//回答者downNum数量加1
					long userNormalNum=userInfoAnswer.getNormalNum()+1;
					userInfoAnswer.setNormalNum(userNormalNum);
					//提问者评价，回答者quizzerDown加1
					long quizzerNormal=userInfoAnswer.getQuizzerNormal()+1;
					userInfoAnswer.setQuizzerNormal(quizzerNormal);
					
					commentStr = "SO SO";
				}
				else if ("upQ".equals(comment)){
					
					//回答者downNum数量加1
					long userUpNum=userInfoAnswer.getUpNum()+1;
					userInfoAnswer.setUpNum(userUpNum);
					//提问者评价，回答者quizzerDown加1
					long quizzerUp=userInfoAnswer.getQuizzerUp()+1;
					userInfoAnswer.setQuizzerUp(quizzerUp);
					
					commentStr = "GOOD";
				}
				answer.setqComment(commentStr);
				answer.setIsPublic("Public");

				double current = 0;
				if ("jinzhuan".equals(monType)) {
					current = Double.parseDouble(answer.getUserInfo().getJinzhuan())+ Double.parseDouble(monValue);
					answer.getUserInfo().setJinzhuan(current + "");

				} else {
					current = Double.parseDouble(answer.getUserInfo().getLingdan())+ Double.parseDouble(monValue);
					answer.getUserInfo().setLingdan(current + "");
				}
				this.userInfoService.updateUserInfo(answer.getUserInfo());
				this.answerService.updateAnswer(answer);
				
				
				//提问题的人评价答案，将但公开之后给关注的人发送站内信
				//设置发送信息的文本对象***********author:张嘉
				MessageText messageText = new MessageText();
				UserInfo userInfo1 = new UserInfo();// 收信人
				//设置收信人
				List<QAConcern> qaConcernsList=qAConcernServiceImpl.getQAConcernsByQuestionId(question.getId());
				//遍历所有关注的人，给每个人发站内信
				for(int i=0;i<qaConcernsList.size();i++){
					userInfo1 = qaConcernsList.get(i).getUserInfo();
					//回答的人不是关注的人才发消息
					if(userInfo1.getNickName().equals((answer.getUserInfo()).getNickName())){
						//设置信息内容
						messageText.setMsgContent("Your  answered questions<a href='/BBS/web/QandA/QuestionFind/" + question.getId() + "'>" + "《"+ question.getQSubject()+ "》</a>The asker has been commonted, please check！");
						messageText.setMsgSubject("System Messages");
						String nowTime = getNowTime();
						messageText.setMsgTime(nowTime);
						messageText.setMsgType("0");
						this.messageTextService.saveMessageText(messageText);
						//设置发送信息对象***********Author：张嘉
						Message message = new Message();
						message.setIsRead("0");
						message.setMessageText(messageText);
						//获取管理员信息
						List<UserInfo> userInfoList=userInfoService.findUserByName("admin");
						UserInfo admin=userInfoList.get(0);
						//发信人管理员
						message.setUserInfo2(admin);
						//收信人userInfo1
						message.setUserInfo1(userInfo1);
						//发送信息
						this.messageService.saveMessage(message);
					}else{
						//设置信息内容
						messageText.setMsgContent("Your concerns<a href='/BBS/web/QandA/QuestionFind/" + question.getId() + "'>" + "《"+ question.getQSubject()+ "》</a>There are new answers,please check！");
						messageText.setMsgSubject("System Messages");
						String nowTime = getNowTime();
						messageText.setMsgTime(nowTime);
						messageText.setMsgType("0");
						this.messageTextService.saveMessageText(messageText);
						//设置发送信息对象***********Author：张嘉
						Message message = new Message();
						message.setIsRead("0");
						message.setMessageText(messageText);
						//获取管理员信息
						List<UserInfo> userInfoList=userInfoService.findUserByName("admin");
						UserInfo admin=userInfoList.get(0);
						//发信人管理员
						message.setUserInfo2(admin);
						//收信人userInfo1
						message.setUserInfo1(userInfo1);
						//发送信息
						this.messageService.saveMessage(message);
					}
				}
			}

			/**
			 * @2014-12-30
			 * @author LCY
			 * 增加统计用户通过回答问题获得的总的GOOD，中，Sorry的数量，保存atuserinfo表中upNum，normalNum，downNum
			 */
			else {
				//获取回答的用户
				UserInfo userInfoAnswer=answer.getUserInfo();
				//获取提问的用户信息
				UserInfo quizzerInfo=this.questionService.findQuestion(qId).getUserInfo();
				
				// 检验用户是否评价过
				if (this.questionPJService.checkExit(uId, aId).size() > 0) {
					commentStr = "error";
					commented.setCommentText("error");
				} else if ("down".equals(comment)) {
					commentStr = "down";
					long down = 0;
					if (answer.getDown() != null)
						down = Long.parseLong(answer.getDown());
					down++;
					answer.setDown(String.valueOf(down));
					commented.setCommentText("down");
					
					//回答者downNum数量加1
					long userDownNum=userInfoAnswer.getDownNum()+1;
					userInfoAnswer.setDownNum(userDownNum);
					
				} else if ("normal".equals(comment)) {
					commentStr = "normal";
					long normal = 0;
					if (answer.getNormal() != null)
						normal = Long.parseLong(answer.getNormal());
					normal++;
					answer.setNormal(String.valueOf(normal));
					commented.setCommentText("normal");
					
					//回答者normalNum数量加1
					long userNormalNum=userInfoAnswer.getNormalNum()+1;
					userInfoAnswer.setNormalNum(userNormalNum);
					
				} else if ("up".equals(comment)) {
					commentStr = "up";
					int up = 0;
					if (answer.getUpCount() != 0)
						up = answer.getUpCount();
					up++;
					answer.setUpCount(up);
					commented.setCommentText("up");
					
					//回答者upNum数量加1
					long userUpNum=userInfoAnswer.getUpNum()+1;
					userInfoAnswer.setUpNum(userUpNum);
					
				}
				this.answerService.updateAnswer(answer);
				this.questionPJService.saveComment(commented);
				this.userInfoService.updateUserInfo(userInfoAnswer);
				
				session.setAttribute("userInfo", userInfoAnswer);
			}

			try {
				ObjectMapper mapper = new ObjectMapper();
				String result = mapper.writeValueAsString(commentStr);
				response.setContentType("text/javascript;charset=utf-8");
				response.getWriter().print(result);
			} catch (JsonGenerationException e1) {
				e1.printStackTrace();
			} catch (JsonMappingException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

	@RequestMapping("/saveFriend")
	public String saveFriend(HttpServletRequest request,
			HttpServletResponse response, long guest_id, long qId, int record) {
		//获取MesCount值******author: 张嘉
		getMesCount(request);
				
		try {
			userController.addFriend(request, guest_id);
			return "redirect:/web/QandA/QuestionFind/" + qId + "?record="+ record;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("result", "error");
			return "web/Forums/result";
		}
	}

	@RequestMapping("/deleteFriend")
	public String deleteFriend(HttpServletRequest request,
			HttpServletResponse response, long guest_id, long qId, int record) {
		//获取MesCount值******author: 张嘉
		getMesCount(request);
		try {
			userController.deleteFriend(request, guest_id);
			return "redirect:/web/QandA/QuestionFind/" + qId + "?record="+ record;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("result", "error");
			return "web/Forums/result";
		}

	}
	

	@RequestMapping("/AnsLogin")
	public String AnsLogin(HttpServletRequest req) {
		// Check是否登录 http://localhost:8080/BBSblogSys/
		//根据分页参数是否为空返回不同的str
		String str=null;
		if(req.getParameter("record")!=null){
			str=req.getParameter("qId")+"?record="+req.getParameter("record");
		}else{
			str=req.getParameter("qId");
		}
		String strBackUrl = "http://" + req.getServerName() // 服务器地址
				+ ":" + req.getServerPort() // 端口号
				+ req.getContextPath() // 项目名称
				+"/web/QandA/QuestionFind/"+str;
				//+ req.getServletPath(); // 请求页面或其他地址
		/* + "?" + (request.getQueryString()) */// 参数
		req.getSession().setAttribute("strBackUrl", strBackUrl);
		return "redirect:../../login.html";
	}
	

		//选择最佳答案
		@RequestMapping("/ChooseBestAnswer")
		public String ChooseBestAnswer(int answerId,int qId,HttpServletRequest request){
			Answer answer=answerService.findOneAnswer(answerId);
			answer.setIsBest("isBest");
			answerService.updateAnswer(answer);
			return "redirect:/web/QandA/QuestionFind/" + qId;
		}

	
	public BoardService getBoardService() {
		return boardService;
	}

	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}

	public LabelService getLabelService() {
		return labelService;
	}

	public void setLabelService(LabelService labelService) {
		this.labelService = labelService;
	}

	public UserInfoService getUserInfoService() {
		return userInfoService;
	}

	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	public QuestionService getQuestionService() {
		return questionService;
	}

	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}

	public AnswerService getAnswervice() {
		return answerService;
	}

	public void setAnswervice(AnswerService answervice) {
		this.answerService = answervice;
	}

	public QuestionLabelService getQuestionLabelSerivce() {
		return questionLabelSerivce;
	}

	public void setQuestionLabelSerivce(
			QuestionLabelService questionLabelSerivce) {
		this.questionLabelSerivce = questionLabelSerivce;
	}

	public QuestionPJService getQuestionPJService() {
		return questionPJService;
	}

	public void setQuestionPJService(QuestionPJService questionPJService) {
		this.questionPJService = questionPJService;
	}

	// 服务器时间
	public static String getNowTime() {
		Date date = new Date();
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowTime = f.format(date);
		return nowTime;
	}
	
	//每个方法获取msgCont
	//author:张嘉
	public void getMesCount(HttpServletRequest request){
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
			request.getSession().setAttribute("userInfo",loginUser);
		}
		request.setAttribute("newMsgCount", newMsg);
	}
}