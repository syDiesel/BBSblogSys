package com.bbsBlog.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bbsBlog.entity.Answer;
import com.bbsBlog.entity.Message;
import com.bbsBlog.entity.MessageText;
import com.bbsBlog.entity.Question;
import com.bbsBlog.entity.UserInfo;
import com.bbsBlog.service.AnswerService;
import com.bbsBlog.service.MessageService;
import com.bbsBlog.service.MessageTextService;
import com.bbsBlog.service.UserInfoService;

/**
 * @author Zhou Junlong
 * @Date 2014年12月28日下午8:05:55
 * @Method 问答退款监视器
 */
@Service
public class AnswerListener {
	@Resource
	private UserInfoService userInfoService;
	
	@Resource
	private AnswerService answerService;

	@Resource
	private MessageTextService messageTextService;
	
	@Resource
	private MessageService messageService;

	private Timer timer;
	
	AnswerListener(){		
		timer = new Timer();	
		timer.schedule(new RemindTask(timer),3600*1000);
	}
	
	class RemindTask extends TimerTask {
		Timer timer;
		RemindTask(Timer timerToRun) {
			timer=timerToRun;
		}
        public void run() {
        	//定时器开始
        	try {
	        	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        	System.out.println("扫描");
	        	//扫描已查看但未公开的答案
				List<Answer> listAnswer=answerService.listAnswerBySql("from Answer where isReAsk=0 and isPublic = 'noPublic'");
	        	if(listAnswer.size()!=0) {
	        		for(Answer answer:listAnswer){
	        			int reCount=(int) answer.getReCount();
						Question question=answer.getQuestion();
						UserInfo answerUser=answer.getUserInfo();
						UserInfo questionUser=question.getUserInfo();
	        			//此条答案当无追问时
	        			if(reCount==0) {
							Date answerTime = df.parse(answer.getLtime());
	        				Date nowDate = new Date();
							long n = nowDate.getTime() - answerTime.getTime();
							//当提问人查看答案超过七天为评价时
							if (n >= (7 * 1000 * 24 * 60 * 60)) {
								if (answer.getBaochou().equals("accept")) {
									if (question.getMoneyType().equals("jinzhuan"))
										answerUser.setJinzhuan(Double.parseDouble(answerUser.getJinzhuan())+Double.parseDouble(question.getValue()) + "");
									else if (question.getMoneyType().equals("lingdan"))
										answerUser.setLingdan(Double.parseDouble(answerUser.getLingdan())+ 0.9*Double.parseDouble(question.getValue()) + "");
									userInfoService.updateUserInfo(answerUser);
									answer.setIsPublic("Public");
									answer.setQcommit("赞");
									answerService.updateAnswer(answer);
									
									//给提问人发送站内信
									MessageText messageText = new MessageText();
									messageText.setMsgSubject("系统消息");
									messageText.setMsgContent("您提出的问题<a href='/BBS/web/QandA/QuestionFind/" + question.getId() + "'>" + "《"+ question.getQSubject()+ "》</a>超时评价，系统已自动评价，奖励发放到对方账户中。");
									String nowTime = getNowTime();
									messageText.setMsgTime(nowTime);
									messageText.setMsgType("QandA");
									messageTextService.saveMessageText(messageText);
									Message message = new Message();
									message.setIsRead("0");
									message.setMessageText(messageText);
									List<UserInfo> userInfoList=userInfoService.findUserByName("admin");
									UserInfo admin=userInfoList.get(0);
									message.setUserInfo2(admin);
									message.setUserInfo1(questionUser);
									messageService.saveMessage(message);
									
									//给回答者发送站内信
									messageText = new MessageText();
									messageText.setMsgSubject("系统消息");
									messageText.setMsgContent("您回答的问题<a href='/BBS/web/QandA/QuestionFind/" + question.getId() + "'>" + "《"+ question.getQSubject()+ "》</a>提问人超时评价，系统已自动评价，奖励发放到你的账户中。");
									messageText.setMsgTime(nowTime);
									messageText.setMsgType("QandA");
									messageTextService.saveMessageText(messageText);
									message = new Message();
									message.setIsRead("0");
									message.setMessageText(messageText);
									message.setUserInfo2(admin);
									message.setUserInfo1(answerUser);
									messageService.saveMessage(message);
								}
							}
	        			}
	        			else {
	        				//当存在追问时
	        				List<Answer>zhuiDaList=answerService.listAnswerBySql("from Answer where isReAsk <> '"+answer.getId()+"' and related='"+answer.getId()+"'");
	        				List<Answer>zhuiWenList=answerService.listAnswerBySql("from Answer where isReAsk = '"+answer.getId()+"' and related='"+answer.getId()+"'");
	        				if(zhuiDaList.size()<zhuiWenList.size()) {
	        					//当回答者没有回答全部追问时
	        					Date answerTime = df.parse(zhuiWenList.get(zhuiWenList.size()-1).getATime());
		        				Date nowDate = new Date();
								long n = nowDate.getTime() - answerTime.getTime();
								//当距离最后一次追问超过七天时
								if (n >= (7 * 1000 * 24 * 60 * 60)) {
		        					if (answer.getBaochou().equals("accept")) {
										if (question.getMoneyType().equals("jinzhuan"))
											questionUser.setJinzhuan(Double.parseDouble(questionUser.getJinzhuan())+ Double.parseDouble(question.getValue()) + "");
										else if (question.getMoneyType().equals("lingdan"))
											questionUser.setLingdan(Double.parseDouble(questionUser.getLingdan())+ Double.parseDouble(question.getValue()) + "");
										userInfoService.updateUserInfo(questionUser);
										
										answer.setIsPublic("Public");
										answer.setQcommit("一般");
										answerService.updateAnswer(answer);
										//给提问人发送站内信
										MessageText messageText = new MessageText();
										messageText.setMsgSubject("系统消息");
										messageText.setMsgContent("您提出的问题<a href='/BBS/web/QandA/QuestionFind/" + question.getId() + "'>" + "《"+ question.getQSubject()+ "》</a>，对方未及时回答你的追问，奖励退回到账户中。");
										String nowTime = getNowTime();
										messageText.setMsgTime(nowTime);
										messageText.setMsgType("QandA");
										messageTextService.saveMessageText(messageText);
										Message message = new Message();
										message.setIsRead("0");
										message.setMessageText(messageText);
										List<UserInfo> userInfoList=userInfoService.findUserByName("admin");
										UserInfo admin=userInfoList.get(0);
										message.setUserInfo2(admin);
										message.setUserInfo1(questionUser);
										messageService.saveMessage(message);
										
										//给回答者发送站内信
										messageText = new MessageText();
										messageText.setMsgSubject("系统消息");
										messageText.setMsgContent("您回答的问题<a href='/BBS/web/QandA/QuestionFind/" + question.getId() + "'>" + "《"+ question.getQSubject()+ "》</a>，你未及时回答对方的追问，系统自动评价，无法收到奖励");
										messageText.setMsgTime(nowTime);
										messageText.setMsgType("QandA");
										messageTextService.saveMessageText(messageText);
										message = new Message();
										message.setIsRead("0");
										message.setMessageText(messageText);
										message.setUserInfo2(admin);
										message.setUserInfo1(answerUser);
										messageService.saveMessage(message);
		        					}
	        					}
	        				}
	        				else {
	        					//当回答者回答全部追问时
	        					Date answerTime = df.parse(zhuiDaList.get(zhuiDaList.size()-1).getATime());
		        				Date nowDate = new Date();
								long n = nowDate.getTime() - answerTime.getTime();
								//当回答人最后一次回答追问后超过七天，提问人未评价时
								if (n >= (7 * 1000 * 24 * 60 * 60)) {
									if (answer.getBaochou().equals("accept")) {
										if (question.getMoneyType().equals("jinzhuan"))
											answerUser.setJinzhuan(Double.parseDouble(answerUser.getJinzhuan())+Double.parseDouble(question.getValue()) + "");
										else if (question.getMoneyType().equals("lingdan"))
											answerUser.setLingdan(Double .parseDouble(answerUser.getLingdan())+ 0.9*Double.parseDouble(question.getValue()) + "");
										userInfoService.updateUserInfo(answerUser);
										
										answer.setIsPublic("Public");
										answer.setQcommit("赞");
										answerService.updateAnswer(answer);	
										
										//给提问人发送站内信
										MessageText messageText = new MessageText();
										messageText.setMsgSubject("系统消息");
										messageText.setMsgContent("您提出的问题<a href='/BBS/web/QandA/QuestionFind/" + question.getId() + "'>" + "《"+ question.getQSubject()+ "》</a>超时评价，系统已自动评价，奖励发放到对方账户中。");
										String nowTime = getNowTime();
										messageText.setMsgTime(nowTime);
										messageText.setMsgType("QandA");
										messageTextService.saveMessageText(messageText);
										Message message = new Message();
										message.setIsRead("0");
										message.setMessageText(messageText);
										List<UserInfo> userInfoList=userInfoService.findUserByName("admin");
										UserInfo admin=userInfoList.get(0);
										message.setUserInfo2(admin);
										message.setUserInfo1(questionUser);
										messageService.saveMessage(message);
										
										//给回答者发送站内信
										messageText = new MessageText();
										messageText.setMsgSubject("系统消息");
										messageText.setMsgContent("您回答的问题<a href='/BBS/web/QandA/QuestionFind/" + question.getId() + "'>" + "《"+ question.getQSubject()+ "》</a>提问人超时评价，系统已自动评价，奖励发放到你的账户中。");
										messageText.setMsgTime(nowTime);
										messageText.setMsgType("QandA");
										messageTextService.saveMessageText(messageText);
										message = new Message();
										message.setIsRead("0");
										message.setMessageText(messageText);
										message.setUserInfo2(admin);
										message.setUserInfo1(answerUser);
										messageService.saveMessage(message);
									}
								}
	        				}
	        			}
	        		}
	        	}
        	} catch (ParseException e) { }
        	//定时器结束,半小时后再次执行
        	timer.cancel();
            Timer newTimer = new Timer();
            newTimer.schedule(new RemindTask(newTimer),10*1000);
        }
    }
	
	// 服务器时间
	public String getNowTime() {
		Date date = new Date();
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowTime = f.format(date);
		return nowTime;
	}
}