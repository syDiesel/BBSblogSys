<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>Q & A page</title>
<meta http-equiv="x-ua-compatible" content="ie=8" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
-->
<script type="text/javascript" src="<%=basePath%>js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/index/index.js"></script>
<script type="text/javascript" src="<%=basePath%>js/index/language.js"></script>
<script type="text/javascript" src="<%=basePath%>js/QandA/newHome.js"></script>
<script type="text/javascript" src="<%=basePath%>js/Forum/board.js"></script>
<script type="text/javascript" src="<%=basePath%>js/login_all.js"></script>
</head>
<link type="image/x-icon" href="<%=basePath%>img/bitbug_favicon.ico" rel="shortcut icon" />
<link href="<%=basePath%>css/headfoot.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>css/QandA/newHome.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>css/QandA/QandA.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>css/index_default.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>css/Index/index.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>css/button.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>css/Forums1/post/board.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>css/qiantai/login.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function addFavor(qid) {
	if($('.favorbtn'+qid).text()=='save') {
		var xml=new XMLHttpRequest();
		xml.onreadystatechange=function() {
			if(xml.readyState==4 && xml.status==200) {
				if(xml.responseText==1)
					$('.favorbtn'+qid).text('unsave');
				if(xml.responseText==2)
					alert('no more save');
			}
		}
		xml.open('GET','<%=basePath%>addfavor?qid='+qid+'&r='+Math.random(),false);
		xml.setRequestHeader("Content-Type","application/x-www-form-urlencoded; charset=utf-8");
		xml.send();
		return;
	}
	
	if($('.favorbtn'+qid).text()=='unsave') {
		var xml=new XMLHttpRequest();
		xml.onreadystatechange=function() {
			if(xml.readyState==4 && xml.status==200) {
				if(xml.responseText==1)
					$('.favorbtn'+qid).text('save');
				if(xml.responseText==2)
					alert('fail to cancel');
			}
		}
		xml.open('GET','<%=basePath%>deletefavor?qid='+qid+'&r='+Math.random(),false);
		xml.setRequestHeader("Content-Type","application/x-www-form-urlencoded; charset=utf-8");
		xml.send();
		return;
	}
}

function initFavorBtn(qid){
	var xml=new XMLHttpRequest();
	xml.onreadystatechange=function() {
		if(xml.readyState==4 && xml.status==200) {
			if(xml.responseText==1)
				$('.favorbtn'+qid).text('unsave');
		}
	}
	xml.open('GET','<%=basePath%>checkfavor?qid='+qid+'&r='+Math.random(),false);
	xml.setRequestHeader("Content-Type","application/x-www-form-urlencoded; charset=utf-8");
	xml.send();
	return;
}

function addConcern(qid) {
	if($('.concernbtn'+qid).text()=='+follow question') {
		var xml=new XMLHttpRequest();
		xml.onreadystatechange=function() {
			if(xml.readyState==4 && xml.status==200) {
				if(xml.responseText==1)
					$('.concernbtn'+qid).text('unfollow question');
				if(xml.responseText==2)
					alert('no more follow');
			}
		}
		xml.open('GET','<%=basePath%>addconcern?qid='+qid+'&r='+Math.random(),false);
		xml.setRequestHeader("Content-Type","application/x-www-form-urlencoded; charset=utf-8");
		xml.send();
		return;
	}
	
	if($('.concernbtn'+qid).text()=='unfollow question') {
		var xml=new XMLHttpRequest();
		xml.onreadystatechange=function() {
			if(xml.readyState==4 && xml.status==200) {
				if(xml.responseText==1)
					$('.concernbtn'+qid).text('+follow question');
				if(xml.responseText==2)
					alert('fail to cancel');
			}
		}
		xml.open('GET','<%=basePath%>deleteconcern?qid='+qid+'&r='+Math.random(),false);
		xml.setRequestHeader("Content-Type","application/x-www-form-urlencoded; charset=utf-8");
		xml.send();
		return;
	}
}

function initConcernBtn(qid){
	var xml=new XMLHttpRequest();
	xml.onreadystatechange=function() {
		if(xml.readyState==4 && xml.status==200) {
			if(xml.responseText==1)
				$('.concernbtn'+qid).text('unfollow question');
		}
	}
	xml.open('GET','<%=basePath%>checkconcern?qid='+qid+'&r='+Math.random(),false);
	xml.setRequestHeader("Content-Type","application/x-www-form-urlencoded; charset=utf-8");
	xml.send();
	return;
}
</script>
<body style="font-family:Arial,verdana,tahoma;">
<!---------------------------login_begin  ------------------------->
	<div id="main_login" class="main_login"></div>
	<div class="login_div" id="login_div">
		<div class="login_head">
			<h1>Login</h1>
			<span class="login_head_right"> <span
				class="login_head_right_none">No Account</span>&nbsp;&nbsp;&nbsp;<a
				href="<%=basePath%>isAgree.do">Register</a> </span>
		</div>
		<div class="login_form">
			<form action="<%=basePath%>login.do" method="post">
				<input type="hidden" value="" id="login_href" name="login_href">
				<table>
					<tr>
						<td><input type="text" name="userName" placeholder="User Name"
							class="login_td"></td>
					</tr>
					<tr>
						<td><input type="password" name="password" placeholder="Cipher"
							class="login_td"></td>
					</tr>
					<tr>
						<td><input class="login_but" accesskey="l" value="Login"
							tabindex="5" type="submit"> <!-- <span class="login_span"><input type="checkbox" name="">保持登录</span> -->
							<span class="login_span"><a
								href="<%=basePath%>ToGetBackPwd.do">Forget Cipher？</a>
						</span></td>
					</tr>
				</table>
			</form>
		</div>
		<!-- <div class="login_other">
			<p>login other way</p>
			<div style="width:380px;height:80px;padding-top:20px;">
				<button class="login_sina"></button>
				<button class="login_qq"></button>
			</div>
		</div> -->
	</div>
	<!---------------------------login_end  ------------------------->
	<!--head begin-->
	<div ID="head" class="head">
		<!--top-->
		<div id="top" class="top">
			<div class="top-btn-left">
				<a href="javascript:AddFavorite(window.location,document.title)">Save Us</a>
				<!-- <a href="javascript:void(0)">联系我们</a> -->
			</div>

			<div class="top-btn-right">

				<!-- <div class="language">
					<a href="javascript:changeLocale('locale=zh_CN')">简</a> 
					<a href="javascript:changeLocale('locale=zh_TW')">繁</a>
					<a href="javascript:changeLocale('locale=en_US')">EN</a>
				</div>  -->
				<c:if test="${!empty userInfo }">
					<div class="user-btn">
						<ul>
							<span class="ban">&nbsp;</span>
							<li id="personPic"><a><img
									src="<%=basePath%>${userInfo.headImg}" width="20" height="20" />
							</a>
								<div class="personInfo" id="personInfo">
									<div class="personInfoPart1">
										<a href="<%=basePath%>web/Blog/${userInfo.nickName}"> <img
											src="<%=basePath%>${userInfo.headImg}" width="90" height="90" />
										</a>
										<div class="personInfoDetail">
											<p>
											<h3>${userInfo.nickName}</h3>
											</p>
											<p>

												<span>Level：</span>

												<c:forEach begin="1" end="${userInfo.userLevel}" step="1">
													<img src="<%=basePath%>images/Forums/star.png" width="10px"
														height="10px" />
												</c:forEach>
												<c:forEach begin="${userInfo.userLevel+1}" end="7" step="1">
													<img src="<%=basePath%>images/Forums/0star.png"
														width="10px" height="10px" />
												</c:forEach>

											</p>
											<br /> <a class="pConfig"
												href="<%=basePath%>u/detail/${userInfo.id}.html"><span
												class="icon-pConfig"></span>Edit</a>
										</div>
									</div>
									<div class="personInfoPart2">
										<div class="config">
											<a href="<%=basePath%>u/setting/password"><span
												class="icon-cog"></span>Setting</a>

										</div>
										<div class="logout">
											<a href="<%=basePath%>logout.do" title="Exit"><span
												class="icon-logout"></span> </a>
										</div>

									</div>

								</div></li>


							<span class="ban">&nbsp;</span>
							<li style="height: 30px;"><div class="config">
									<a href="<%=basePath%>/web/PrivateMsg/RecBox"><span
										class="icon-msg"></span><em>${newMsgCount }</em> </a>

								</div></li>
							<span class="ban">&nbsp;</span>
						</ul>



					</div>
				</c:if>




				<div class="charge">
					<c:if test="${empty userInfo }">
						<span class="ban">&nbsp;</span>
						<a href="javascript:void(0)" id="login_all">Log in</a>
						<span class="ban">&nbsp;</span>
						<a href="<%=basePath%>isAgree.do">Register</a>
					</c:if>
					<span class="ban">&nbsp;</span> <a
						href="<%=basePath%>ToGetBackPwd.do">Find Cipher</a> <span class="ban">&nbsp;</span>
					<a href="javascript:void(0)">Voucher Center</a> <span class="ban">&nbsp;</span>
				</div>
			</div>
			<!---top-btn-right  end-->
		</div>
		<!--top end-->
		<!--logo-->
		<div class="logo">
			<div class="yszs">
				<a href="#"><img src="<%=basePath%>img/Index-logo.png" /> </a>
			</div>
			<div class="searchBanner">
				<FORM name="search_form_1" id="search_form_1"
					action="<%=basePath%>search.do">
					<DIV class="search-text-con2">
						<INPUT name="search" class="search-text2" id="q1" type="text"
							value="" autocomplete="off" path="q" placeholder="  input keyword">
						<input type="hidden" id="txtSear" value="0" name="searchMethod" />
					</DIV>
					<DIV class="search-btn-con2">
						<INPUT class="search-btn2" type="submit" value="Search">
					</DIV>
				</FORM>
			</div>
			<div class="app">
				<a href="javascript:void(0)"></a>
				<h3 style="font-size:14px;">App Download</h3>
			</div>

		</div>
		<!--logo end-->
		<!--nav-->
		<div class="nav">
			<ul>
				<li><a href="<%=basePath%>toIndexHome">Frontpage</a></li>
				<li><a href="<%=basePath%>web/Blog/index.html">Blog</a></li>
				<li><a href="<%=basePath%>listPostByBoard">Forum</a></li>
				<li><a href="<%=basePath%>web/QandA/Home.html">Q & A</a></li>
				<li><c:if test="${userInfo.role.id!=1 }">
						<a href="<%=basePath%>contact.do">Service Center</a>
						</c:if>
						<c:if test="${userInfo.role.id==1 }">
						<a href="<%=basePath%>toManagement">Supervision</a>
						</c:if></li>
				<li><a href="<%=basePath%>faq.do">Regulation</a></li>
			</ul>
		</div>
		<!--nav end-->
		<!--pic-->
		<div class="Logo_pic"></div>
		<!--pic end-->



	</div>
	<!--head end-->

	<div class="mainBox" style="width:1050px;">
		<%-- <div class="BoardIndex">
			<div id="demo" >
				<div id="demo1">
					<c:forEach items="${listboard}" var="board">
						<a href="<%=basePath%>web/QandA/Home/${board.id}/1">
							<div id="indexBg"><span id="boardName">${board.boardName}</span></div>
						</a>
					</c:forEach>
				</div>
				<div id="demo2"> </div>
			</div>
		</div> --%>
		 <ul class="BoardIndex">
		  <div class="boardSubject" >
		         <span class="font">unions</span>
		  </div>
		  <c:forEach end="${board.size()}" begin="1" step="1" var="i">
              
              <c:if test="${ board.get(i-1).id!=question.board.id}">
		      <li class="boardBg" id="one" onmouseover="over('${i}')" onmouseout="out('${i}')">
		       <a href="<%=basePath%>web/QandA/Home/${board.get(i-1).getId() }/1">	
		      <div id="boardName" >	
		             
		       <span class="board_title_font">
		       <img src="<%=basePath%>images/Forums/new/${board.get(i-1).boardLogo}.png" 
		       class="board_index" id="noSelectIndex${i}">
		       <img src="<%=basePath%>images/Forums/new/${board.get(i-1).boardLogo}_1.png" 
		       class="board_index" id="selectIndex${i}" style="display:none;">
		       ${board.get(i-1).boardName}</span>		       
		       
		       <div style="background:url(images/Forums/new/go.png);display:none;" class="go" id="go${i }"></div>		       
		      </div>
		       </a>
				<div class="labelIndex">
		         <c:forEach end="${listAllLabel.get(i-1).size()}" begin="1" var="j" step="1">
		            <div class="everyLabel"><a href="<%=basePath%>search.do?search=${listAllLabel.get(i-1).get(j-1).labelName}&searchMethod=0&lab=1&sub=1&con=1">${listAllLabel.get(i-1).get(j-1).labelName}</a></div>
		         </c:forEach>
		      </div>
		      </li>
		      
		      </c:if> 
		      
		      
		      
		      <c:if test="${board.get(i-1).id==question.board.id}">
		      <li class="boardBg" id="one" style="background:#087ec4;">
		       <a href="<%=basePath%>web/QandA/Home/${board.get(i-1).getId() }/1"
		         style="color:#fff;">	
		      <div id="boardName" >	
		             
		       <span class="board_title_font">
		       
		       <img src="<%=basePath%>images/Forums/new/${board.get(i-1).boardLogo}_1.png" 
		       class="board_index" id="selectIndex${i}">
		       ${board.get(i-1).boardName}</span>		       
		       
		       <div style="background:url(images/Forums/new/go.png);" class="go" id="go${i }"></div>		       
		      </div>
		       </a>
		      <div class="labelIndex">
		         <c:forEach end="${listAllLabel.get(i-1).size()}" begin="1" var="j" step="1">
		            <div class="everyLabel">${listAllLabel.get(i-1).get(j-1).labelName}</div>
		         </c:forEach>
		      </div>
		      </li>
		      </c:if> 
		  </c:forEach>
		</ul>
		<div class="rightContent">
			<!-- 热门问答 -->
			<div class="hotQandA" style="min-height: 595px; max-height: 1350px;">
				<div class="hotQandATitle">
					<h3 id="hotTitle">hot answers</h3>
					<a href="<%=basePath %>web/QandA/AskQ" style="color:#fff;" class="addQuestion">issue new question</a>
				</div>
				<br/>
				<div id="contentQandA">
						<c:if test="${hotQA.size()!=0&&hotQA.size()!=NULL}">
							<c:forEach items="${hotQA}" var="l" end="4">
								<table class="questionQ" summary="forum_30" cellpadding="0" cellspacing="0" width="100%"
									style="font-size: 12px;">
									<!-- <tbody id="normalthread_5385487"> -->
									
									<div class="questionArea">
									
									<tr width="100%">
									<td style="width:60px;height:60px" valign="top">
										
										<c:if test="${l.getHiddenUser() =='show'}">
												<a href="<%=basePath%>web/Blog/${l.getUserInfo().getNickName()}">
												<img  class="questionHeadImg" alt="" src="${l.getUserInfo().getHeadImg() }"/> </a>
												</c:if>
												<c:if test="${l.getHiddenUser() =='hidden'}">
												<img  class="questionHeadImg" alt="" src="<%=basePath%>images/home/noHead.jpg"/>
												</c:if>
									</td>
										<td>								
									<table width="95%">
									<tr style="height:25px;margin-top:0">
									
											<td class="questionOperate" class="by"  text-align="left" width="75%">
											<c:if test="${l.getHiddenUser() =='show'}">
												<a href="<%=basePath%>web/Blog/${l.getUserInfo().getNickName()}">${l.getUserInfo().getNickName() } </a>
												</c:if>
												<c:if test="${l.getHiddenUser() =='hidden'}">
												anynomous
												</c:if>
											</td>
											<td style="font-size:13px;color: #999;font-family:STSong;" class="by" text-align="right" width="25%">
											<em style="	font: normal 10px/12px Arial;">${l.getQTime() }</em>
											&nbsp;&nbsp;</td>
											
										</tr>
										
										<tr >
											<th style="text-align:left;" >
											 <a class="questionList" href="<%=basePath%>web/QandA/QuestionFind/${l.getId() }">${l.getQSubject()}</a>
											</th>
										</tr>
										<tr>
											<td></td>
										</tr>
										<tr style="height:5px">
										<td></td>
										</tr>
										<tr>
							
										<td class="questionOperate" >
										
											<span style="display: inline-block;width:85px">
												<c:choose>
											<c:when test="${empty userInfo}">
												<a style="font-size:14px;color: #999;font-family:STSong;" onclick="alert('log in');" class="concernbtn${l.id}">+follow question</a>
											</c:when>
											<c:when test="${!empty userInfo}">
												<a style="font-size:14px;color: #999;font-family:STSong;" class='concernbtn${l.id}' onclick='javascript:addConcern(${l.id})'>+follow question</a>
												<script type="text/javascript">
													$(initConcernBtn(${l.id}));
												</script>
											</c:when>
										</c:choose>
											</span>
											<span style="display: inline-block;width:30px;text-align:right">
												<label style="color:blue">${l.getAnswerCount()}</label>
											</span>
											<span>
												<label>replies</label>
											</span>
											<span style="display: inline-block;width:70px;text-align:center">
												<c:choose>
											<c:when test="${empty userInfo}">
												<a style="font-size:14px;color: #999;font-family:STSong;" class="favorbtn${l.id}" onclick="alert('log in');">save</a>
											</c:when>
											<c:when test="${!empty userInfo}">
												<a style="font-size:14px;color: #999;font-family:STSong;" class='favorbtn${l.id}' onclick='addFavor(${l.id})'>save</a>
												<script type="text/javascript">
													$(initFavorBtn(${l.id}));
												</script>
											</c:when>
										</c:choose>
											</span>
											<span>
												<label>reward:</label><label style="color:blue">${l.getValue()}</label>
											</span>
											<c:if test="${l.getMoneyType() =='jinzhuan' && l.getValue()!=0}"><label>brick</label></c:if>
											<c:if test="${l.getMoneyType() =='lingdan' && l.getValue()!=0}"><label>panacea</label></c:if>
											<br/>
											<br/>
										</td>
										</tr>
										</table>
										</td>
										</tr>
										</div>
									<!-- </tbody> -->
								</table>
							</c:forEach>
						</c:if>
				</div>
			</div>
			<br>
			<!--右下部分-->
			<!-- 问题达人Begin -->
			<!-- <div id="QuestionKiller" style=" width:30%; float:left; margin-right:1%;min-height: 595px; max-height: 1350px;">
				<div class="QuestionKillerTitle">
					<h3 id="QuestionKillerTitle">active askers</h3>
				</div>
				<br/>
				<div id="QuestionKillerContent">
				</div>
			</div> -->
			<div class="killerLabel"style="width:270px; float:left;">
					<div class="killerTitle" >
						<h3>active askers</h3>
					</div>
					<div class="killerLabelContent">
						<table style="font-size:12px;" class="killerLabelInfo" border="0" width="100%"
							cellspacing="0" cellpadding="0">
							<tr class="tr1">
								<th width="10%"></th>
								<th width="50%">name</th>
								<th width="40%">active unions</th>
							</tr>		
							<c:forEach items="${hotuser}" var="u">
								<tr style="height:30px;">
									<td><span class="hotuser">1</span></td>
									<td><a href="<%=basePath%>web/Blog/${u.uname}">${u.uname}</a></td>
									<td><a href="<%=basePath%>web/QandA/Home/${u.bid}/1">${u.bname}</a></td>
								</tr>
							</c:forEach>							
						</table>
						<script type="text/javascript">
							$($('.hotuser').get(0)).addClass('rank1').html('1');
							$($('.hotuser').get(1)).addClass('rank2').html('2');
							$($('.hotuser').get(2)).addClass('rank3').html('3');
							$($('.hotuser').get(3)).addClass('rank4').html('4');
							$($('.hotuser').get(4)).addClass('rank4').html('5');
							$($('.hotuser').get(5)).addClass('rank4').html('6');
							$($('.hotuser').get(6)).addClass('rank4').html('7');
							$($('.hotuser').get(7)).addClass('rank4').html('8');
							$($('.hotuser').get(8)).addClass('rank4').html('9');
							$($('.hotuser').get(9)).addClass('rank4').html('10');
						</script>
					</div>
				</div>
			
			<!-- 问题达人End -->
			<div class="interest" style=" width:520px; float:right;">
			<div class="interestTitle">
					<div class="interest_blog" id="newQ">
						<a>new questions</a>
					</div>
					<div class="interest_forum" id="doQ">
						<a>solved questions</a>
					</div>
					<div class="interest_question" id="undoQ">
						<a>unsolved questions</a>
					</div>
				</div>
				<div id="content" class="interestContent">
						<div id="listNew" style="interest_blog_Info_left;">
						<br/>
						<table style="font-size:12px;width:490px;"class="interest_blog_Info_left_Info" border="0" cellspacing="0" cellpadding="0">
							<tr class="tr1">
								<td width="45%">question</td>
								<td width="30%">asker</td>
								<td width="25%">time</td>
							</tr>
							<c:forEach items="${lastQ}" var="items">
								<tr>
									<td  style="text-align:left;"><a href="<%=basePath%>web/QandA/QuestionFind/${items.id}"> ${items.getQSubject()} </a></td>
									<td>
									<c:if test="${items.getHiddenUser() =='hidden'}">
												anonymous
									</c:if>
									<c:if test="${items.getHiddenUser() =='show'}">
												<a href="<%=basePath%>web/Blog/${items.userInfo.nickName}"> ${items.userInfo.nickName} </a>
									</c:if>
									</td>
									<td>${items.qTime}</td>
								</tr>
							</c:forEach>
						</table>
					</div>
					<div id="listDoQ" style="interest_blog_Info_left;display:none;">
					<br/>
						<table style="font-size:12px;width:490px;"class="interest_blog_Info_left_Info" border="0" cellspacing="0" cellpadding="0">
							<tr class="tr1">
								<td width="45%">question</td>
								<td width="30%">asker</td>
								<td width="25%">time</td>
							</tr>
							<c:forEach items="${doQ}" var="items">
								<tr>
									<td style="text-align:left;"><a href="<%=basePath%>web/QandA/QuestionFind/${items.question.id}"> ${items.question.getQSubject()} </a></td>
									<td>
									<c:if test="${items.question.getHiddenUser() =='hidden'}">
												anynomous
									</c:if>
									<c:if test="${items.question.getHiddenUser() =='show'}">
												<a href="<%=basePath%>web/Blog/${items.question.userInfo.nickName}"> ${items.question.userInfo.nickName} </a>
									</c:if>
									</td>
									<td>${items.question.qTime}</td>
								</tr>
							</c:forEach>
						</table>
					</div>
					<div id="listUnDoQ" style="interest_blog_Info_left;display:none;">
					<br/>
						<table style="font-size:12px;width:490px;"class="interest_blog_Info_left_Info" border="0" cellspacing="0" cellpadding="0">
							<tr class="tr1">
								<td width="45%">question</td>
								<td width="30%">asker</td>
								<td width="25%">time</td>
							</tr>
							<c:forEach items="${undoQ}" var="items">
								<tr>
									<td style="text-align:left;"><a href="<%=basePath%>web/QandA/QuestionFind/${items.id}"> ${items.getQSubject()} </a></td>
									<td>
									<c:if test="${items.getHiddenUser() =='hidden'}">
												anynomous
									</c:if>
									<c:if test="${items.getHiddenUser() =='show'}">
												<a href="<%=basePath%>web/Blog/${items.userInfo.nickName}"> ${items.userInfo.nickName} </a>
									</c:if>
									</td>
									<td>${items.qTime}</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
				<%-- <a class="submitButton" style="float:right;margin-right:30px;"href="<%=basePath%>web/QandA/Home/${boardId}/1">see more</a> --%>
	 		</div>
		</div>
	</div>
</div>
<!--footer-->

	<div class="footer">
		<h3>Copyright © 2014 JIE & C DEV(HK)CO L.&nbsp;&nbsp;All Rights Reserved.</h3>
	</div>
	<!--footer end-->
</body>
</html>