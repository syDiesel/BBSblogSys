<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.bbsBlog.util.PageModel"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Member Info</title>
<meta http-equiv="x-ua-compatible" content="ie=8" />

<link type="image/x-icon" href="<%=basePath%>img/bitbug_favicon.ico"
	rel="shortcut icon" />

<link href="<%=basePath%>css/qiantai/login.css" rel="stylesheet"
	type="text/css" />
<link type="text/css" href="<%=basePath%>css/index_default.css"
	rel="stylesheet" />
<link type="text/css" href="<%=basePath%>css/button1.css"
	rel="stylesheet" />

<link type="text/css" href="<%=basePath%>css/headfoot.css"
	rel="stylesheet" />
<link href="../../css/Blog/newBlog_User.css" rel="stylesheet"
	type="text/css">


<script src="<%=basePath%>js/jquery-1.10.2.min.js"></script>
<script src="<%=basePath%>js/blog/home.js"></script>
<script type="text/javascript" src="<%=basePath%>js/index/language.js"></script>
<script type="text/javascript" src="<%=basePath%>js/index/index.js"></script>
<script src="<%=basePath%>js/blog/blogYMXH.js"></script>
<script type="text/javascript" src="<%=basePath%>js/login_all.js"></script>


</head>



<body style="font-family: arial">
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

	<%
		Date date = new Date();
		SimpleDateFormat f = new SimpleDateFormat("MMyydd");
		String nowTime = f.format(date);
	%>


	<!--mainbox-->
	<div class="mainBox">
		<!--1 floor-->
		<div class="floor1">
			<div class="infoAndDt">
				<div class="infoAndDtTitle">
					<div class="infoTitle">
						<a href="javascript:void(0)" id="PersonInfoBtn">personal info</a>
					</div>
					<div class="dtTitle">
						<a href="javascript:void(0)" id="friendDtBtn">friends</a>
					</div>
					<a href="<%=basePath%>u/detail/${blogUser.id}.html"
						class="blogMore" id="PersonInfoBtn_more">more</a> <a
						href="<%=basePath%>auditShow/${blogUser.id}.html" class="blogMore"
						id="friendDtBtn_more" style="display: none;">more</a>
				</div>
				<div class="infoAndDtContent">
					<!--info-->
					<div class="main" id="PersonInfo"
						style="text-align: left; display: display;">
						<div id="wrapper">

							<div id="content" class="clearfix">
								<div class="mod-avator">
									<div class="headImg">
										<img class="portrait-img"
											src="<%=basePath%>${blogUser.headImg }">
									</div>
									<div class="uname wordwrap">
										<a
											href="<%=basePath%>web/Blog/${blogUser.nickName
														}"
											class="link">${blogUser.nickName }</a> <span class="uLevel">
											<c:forEach begin="1" end="${blogUser.userLevel}" step="1">
												<img src="<%=basePath%>images/Forums/new/star1.png"
													width="11px" height="12px" />
											</c:forEach> <c:forEach begin="${blogUser.userLevel+1}" end="7" step="1">
												<img src="<%=basePath%>images/Forums/new/star2.png"
													width="11px" height="12px" />
											</c:forEach> </span>
									</div>
									<div class="hytxBtn">

										<c:if test="${userInfo!=null&&userInfo.id!=blogUser.id }">
											<c:if test="${friend.equals('no') }">
												<a href="<%=basePath%>addFriend.do?guest_id=${blogUser.id}"
													class="AddFriendBtn"><span>+Follow</span> </a>
											</c:if>
											<c:if test="${friend.equals('yes') }">
												<a
													href="<%=basePath%>deleteFriend.do?guest_id=${blogUser.id}"
													class="delFriendBtn"><span>Unfollow</span> </a>
											</c:if>
											<a class="PrivateMsgBtn"
												href="<%=basePath %>web/Blog/receiver.do?id=${blogUser.id}"><span>Message</span>
											</a>
										</c:if>
										<div style="float:left;margin-left:8px;font-size: 12px;">
											<c:if
												test="${userInfo.personalInfo.sex!=null&&userInfo.personalInfo.sex.equals(blogUser.personalInfo.sex)&&userInfo.id!=blogUser.id&&blogUser.personalInfo.sex!=null&&userInfo!=null}">
												<button class="submitButton1" onclick="mark(this)"
													id="xianhua">+Flower</button>
											</c:if>
											<c:if
												test="${userInfo.personalInfo.sex!=null&&userInfo!=null&&userInfo.id!=blogUser.id&&!userInfo.personalInfo.sex.equals(blogUser.personalInfo.sex)&&blogUser.personalInfo.sex!=null}">
												<button class="submitButton1" onclick="mark(this)"
													id="yangmu">+Respect</button>
											</c:if>
										</div>

									</div>

									<input type="hidden" id="userId" value="${blogUser.id}" />
									<div class="userCount">
										<div id="XHcount">
											Flower：<em title="${blogUser.xianhua}">${blogUser.xianhua}</em>
										</div>
										<div id="YMcount">
											Respect：<em title="${blogUser.yangmu}">${blogUser.yangmu}</em>
										</div>
										<br />
										<div>
											Brick：<em title="${blogUser.jinzhuan}">${blogUser.jinzhuan}</em>
										</div>
										<c:if test="${owner==1}">
											<div>
												Panacea：<em title="${blogUser.lingdan}">${blogUser.lingdan}</em>
											</div>
										</c:if>
										<c:if test="${owner==1 && cash_value == '1'}">
											<div style="width:120px;margin-top: 15px;">
												<button class="submitButton_cash" id="cash_request">Apply to exchange panaceas</button>
											</div>
										</c:if>
										<div style="width:180px;display: none;" id="cash_put">
											<form action="<%=basePath%>cash/cashDeal.html" method="get">
												<input type="text" name="cash_size" id="cash_size"
													style="width:100px;float:left;height:20px;">
												<div style="margin-left:5px;width:70px;">
													<input type="submit" class="submitButton_cash2" value="Submit">
													<input type="button" class="submitButton_cash2" value="Cancel"
														id="cash_cancel">
												</div>
											</form>
										</div>
									</div>

									<div class="gerenjianjie">
										<span class="profile-attr">Introduction：</span> <br /> <span
											class="profile-cnt"
											style="display: block; text-indent: 2em; margin-top: 5px;">${blogUser.personalInfo.personalDesc}</span>

									</div>
								</div>
								<div class="mod-profile">




									<dl class="userdetail-profile-basic" style="margin-top: 30px;">

										<dt>Profile</dt>
										<div class="partLeftInpersonInfo">
											<dd>
												<span class="profile-attr">Gender</span> <span
													class="profile-cnt">${blogUser.personalInfo.sex}</span>
											</dd>
											<dd>
												<span class="profile-attr">Birthday</span> <span
													class="profile-cnt"> <c:if
														test="${blogUser.personalInfo.birthdayShare!='0'||userInfo.id==blogUser.id}">
	                ${blogUser.personalInfo.birthday}</c:if> <c:if
														test="${blogUser.personalInfo.birthdayShare=='0'&&userInfo.id!=blogUser.id}">
	                Secrect
	                </c:if> </span>
											</dd>
											<dd>
												<span class="profile-attr">Height</span> <span
													class="profile-cnt"> <c:if
														test="${blogUser.personalInfo.shengaoShare!='0'||userInfo.id==blogUser.id}">
	                ${blogUser.personalInfo.shengao}
	                </c:if> <c:if
														test="${blogUser.personalInfo.shengaoShare=='0'&&userInfo.id!=blogUser.id}">Secrect  </c:if>
												</span>
											</dd>
										</div>
										<!---->
										<div class="partRightInpersonInfo">
											<dd>
												<span class="profile-attr">Birthplace</span> <span
													class="profile-cnt"> <c:if
														test="${blogUser.personalInfo.jiguanShare!='0'||userInfo.id==blogUser.id}">
	                ${blogUser.personalInfo.jiguan}
	                </c:if> <c:if
														test="${blogUser.personalInfo.jiguanShare=='0'&&userInfo.id!=blogUser.id}">Secrect  </c:if>
												</span>
											</dd>
											<dd>
												<span class="profile-attr">Residence</span> <span
													class="profile-cnt"> <c:if
														test="${blogUser.personalInfo.addressShare!='0'||userInfo.id==blogUser.id}">
	                ${blogUser.personalInfo.address}
	                </c:if> <c:if
														test="${blogUser.personalInfo.addressShare=='0'&&userInfo.id!=blogUser.id}">Secrect  </c:if>
												</span>
											</dd>
										</div>

									</dl>
									<div class="split-line"></div>
									<dl>

										<dt>Details</dt>
										<div class="partLeftInpersonInfo">
											<dd>
												<span class="profile-attr">Real Name</span> <span> <c:if
														test="${blogUser.personalInfo.realnameShare!='0'||userInfo.id==blogUser.id}">
	                ${blogUser.personalInfo.realname}
	                </c:if> <c:if
														test="${blogUser.personalInfo.realnameShare=='0'&&userInfo.id!=blogUser.id}">Secrect  </c:if>



												</span>
											</dd>
											<dd>
												<span class="profile-attr">ID number</span> <span> <c:if
														test="${blogUser.personalInfo.idnoShare!='0'||userInfo.id==blogUser.id}">
	                ${blogUser.personalInfo.idno}
	                </c:if> <c:if
														test="${blogUser.personalInfo.idnoShare=='0'&&userInfo.id!=blogUser.id}">Secrect  </c:if>

												</span>
											</dd>
										</div>
										<div class="partRightInpersonInfo">
											<dd>
												<span class="profile-attr">Hobby</span> <span> <c:if
														test="${blogUser.personalInfo.aihaoShare!='0'||userInfo.id==blogUser.id}">
	                ${blogUser.personalInfo.aihao}
	                </c:if> <c:if
														test="${blogUser.personalInfo.aihaoShare=='0'&&userInfo.id!=blogUser.id}">Secrect  </c:if>

												</span>
											</dd>
											<dd>
												<span class="profile-attr">Talent</span> <span> <c:if
														test="${blogUser.personalInfo.shanchangShare!='0'||userInfo.id==blogUser.id}">
	                ${blogUser.personalInfo.shanchang}
	                </c:if> <c:if
														test="${blogUser.personalInfo.shanchangShare=='0'&&userInfo.id!=blogUser.id}">Secrect  </c:if>


												</span>
											</dd>
										</div>

									</dl>

									<div class="split-line"></div>
									<dl>

										<dt>Educational Background</dt>
										<div class="partLeftInpersonInfo">
											<dd>
												<span class="profile-attr">School</span> <span> <c:if
														test="${blogUser.personalInfo.graduateShare!='0'||userInfo.id==blogUser.id}">
	                ${blogUser.personalInfo.graduate}
	                </c:if> <c:if
														test="${blogUser.personalInfo.graduateShare=='0'&&userInfo.id!=blogUser.id}">Secrect  </c:if>
												</span>
											</dd>
											<dd>
												<span class="profile-attr">Major</span> <span> <c:if
														test="${blogUser.personalInfo.zhuanyeShare!='0'||userInfo.id==blogUser.id}">
	                ${blogUser.personalInfo.zhuanye}
	                </c:if> <c:if
														test="${blogUser.personalInfo.zhuanyeShare=='0'&&userInfo.id!=blogUser.id}">Secrect  </c:if>

												</span>
											</dd>
										</div>
										<div class="partRightInpersonInfo">
											<dd>
												<span class="profile-attr">Education</span> <span> <c:if
														test="${blogUser.personalInfo.xueliShare!='0'||userInfo.id==blogUser.id}">
	                ${blogUser.personalInfo.xueli}
	                </c:if> <c:if
														test="${blogUser.personalInfo.xueliShare=='0'&&userInfo.id!=blogUser.id}">Secrect  </c:if>


												</span>
											</dd>
											<dd>
												<span class="profile-attr">Degree</span> <span> <c:if
														test="${blogUser.personalInfo.xueweiShare!='0'||userInfo.id==blogUser.id}">
	                ${blogUser.personalInfo.degree}
	                </c:if> <c:if
														test="${blogUser.personalInfo.xueweiShare=='0'&&userInfo.id!=blogUser.id}">Secrect  </c:if>
												</span>
											</dd>
										</div>


									</dl>

									<div class="split-line"></div>
									<dl>

										<dt>Work Experience</dt>
										<div class="partLeftInpersonInfo">
											<dd>
												<span class="profile-attr">Industry</span> <span> <c:if
														test="${blogUser.personalInfo.hangyeShare!='0'||userInfo.id==blogUser.id}">
	                ${blogUser.personalInfo.hangye}
	                </c:if> <c:if
														test="${blogUser.personalInfo.hangyeShare=='0'&&userInfo.id!=blogUser.id}">Secrect  </c:if>


												</span>
											</dd>
											<dd>
												<span class="profile-attr">Company</span> <span> <c:if
														test="${blogUser.personalInfo.companyShare!='0'||userInfo.id==blogUser.id}">
	                ${blogUser.personalInfo.company}
	                </c:if> <c:if
														test="${blogUser.personalInfo.companyShare=='0'&&userInfo.id!=blogUser.id}">Secrect  </c:if>




												</span>
											</dd>
										</div>
										<div class="partRightInpersonInfo">
											<dd>
												<span class="profile-attr">Occupation</span> <span> <c:if
														test="${blogUser.personalInfo.jobShare!='0'||userInfo.id==blogUser.id}">
	                ${blogUser.personalInfo.job}
	                </c:if> <c:if
														test="${blogUser.personalInfo.jobShare=='0'&&userInfo.id!=blogUser.id}">Secrect  </c:if>


												</span>
											</dd>
										</div>


									</dl>

								</div>
							</div>

						</div>


					</div>
					<!--info end-->

					<!--dongtai-->
					<div class="friendDt" id="friendDt"
						style="text-align: left; display: none;">
						<c:if test="${!empty listAudit }">
							<ul class="friendDtInfo">
								<c:forEach begin="0" end="8" items="${listAudit }"
									var="listAudit">
									<c:if test="${listAudit.auditType=='BK' }">
										<li><span class="DTuser"><a
												href="<%=basePath%>web/Blog/${listAudit.userInfo.nickName}">${listAudit.userInfo.nickName}</a>
										</span><span class="DTtype">issued blog</span> <span class="DTname"><a
												href="<%=basePath%>web/Blog/article/<%=nowTime %>${listAudit.auditId}#footer">${listAudit.auditContent}</a>
										</span> <span class="DTtime">${listAudit.auditTime}</span></li>
									</c:if>
									<c:if test="${listAudit.auditType=='LT' }">
										<li><span class="DTuser"><a
												href="<%=basePath%>web/Blog/${listAudit.userInfo.nickName}">${listAudit.userInfo.nickName}</a>
										</span><span class="DTtype">launched a topic</span> <span class="DTname"><a
												href="<%=basePath %>toTopics?post_id=${listAudit.auditId}">${listAudit.auditContent}</a>
										</span> <span class="DTtime">${listAudit.auditTime}</span></li>
									</c:if>
									<c:if test="${listAudit.auditType=='WD' }">
										<li><span class="DTuser"><a
												href="<%=basePath%>web/Blog/${listAudit.userInfo.nickName}">${listAudit.userInfo.nickName}</a>
										</span><span class="DTtype">ask a question</span> <span class="DTname"><a
												href="<%=basePath %>web/QandA/QuestionFind/${listAudit.auditId}">${listAudit.auditContent}</a>
										</span> <span class="DTtime">${listAudit.auditTime}</span></li>
									</c:if>
									<c:if test="${listAudit.auditType=='ZY' }">
										<li><span class="DTuser"><a
												href="<%=basePath%>web/Blog/${listAudit.userInfo.nickName}">${listAudit.userInfo.nickName}</a>
										</span><span class="DTtype">upload a resource</span> <span class="DTname"><a
												href="<%=basePath%>web/Blog/Attach/${listAudit.auditId}">${listAudit.auditContent}</a>
										</span> <span class="DTtime">${listAudit.auditTime}</span></li>
									</c:if>
								</c:forEach>
							</ul>
						</c:if>

					</div>
					<!--dongtai end-->










				</div>

				<!--infoAndDtContent end-->





			</div>



			<!--分割线-->

			<div class="albumFloor">
				<div class="userAlbum">
					<c:if test="${!empty listNor }">
						<div class="albumTitle">
							<div class="albumTitle_1">
								<h3>My Album</h3>
							</div>
							<c:if test="${userInfo.id==blogUser.id }">
								<a class="blogMore" href="<%=basePath%>fileupload.do">Upload</a>
							</c:if>
						</div>
						<div class="albumContent" style="float:left;margin-left:5px;">
							<c:if test="${listNor.size() >= 2 }">
								<a
									href="<%=basePath%>listAlbumPhoto.do?id=${listNor.get(0).userAlbum.id }&blId=${blogUser.id}">
									<img src="<%=basePath %>${listNor.get(0).photo}" width="135"
									height="190" /> </a>
								<a
									href="<%=basePath%>listAlbumPhoto.do?record=1&id=${listNor.get(1).userAlbum.id }&blId=${blogUser.id}">
									<img src="<%=basePath %>${listNor.get(1).photo}" width="135"
									height="190" /> </a>
							</c:if>
						</div>
						<div class="albumContent">
							<c:if test="${listNor.size() < 2 }">
								<a
									href="<%=basePath%>listAlbumPhoto.do?id=${listNor.get(0).userAlbum.id }&blId=${blogUser.id}">
									<img src="<%=basePath %>${listNor.get(0).photo}" width="200"
									height="200" /> </a>
							</c:if>
						</div>
					</c:if>
					<c:if test="${empty listNor }">
						<div class="albumTitle">
							<div class="albumTitle_1">
								<h3>My Albums</h3>
							</div>
							<c:if test="${userInfo.id==blogUser.id }">
								<a class="blogMore" href="<%=basePath%>fileupload.do">Upload</a>
							</c:if>
						</div>
						<div class="albumContent">
							<p
								style="font-family: 'arial'; font-size: 20px; margin-top: 80px;">No Albums Yet</p>
						</div>
					</c:if>
				</div>

				<div class="userAlbum marginTop20">

					<div class="albumTitle">
						<div class="albumTitle_1">
							<h3>Aptness</h3>
						</div>
						<c:if test="${userInfo.id==blogUser.id }">
							<a class="blogMore" href="<%=basePath%>zizhi.do">Upload</a>
						</c:if>
					</div>
					<div class="albumContent">
					  <c:if test="${album == '3' }">
					                <c:if test="${listZi.size() >= 2 }">
										<a
											href="<%=basePath%>listAlbumPhoto.do?id=${listZi.get(0).userAlbum.id }&blId=${blogUser.id}">
											<img src="<%=basePath %>${listZi.get(0).photo}" width="135"
											height="190" /> </a>
										<a
											href="<%=basePath%>listAlbumPhoto.do?id=${listZi.get(1).userAlbum.id }&blId=${blogUser.id}">
											<img src="<%=basePath %>${listZi.get(1).photo}" width="135"
											height="190" /> </a>
									</c:if>
									 <c:if test="${listZi.size() < 2 && listZi.size() > 0 }">
										<a href="<%=basePath%>listAlbumPhoto.do?id=${listZi.get(0).userAlbum.id }&blId=${blogUser.id}">
											<img src="<%=basePath %>${listZi.get(0).photo}" width="200"	height="200" /> </a>
									</c:if> 
					   </c:if>
					   <c:if test="${album == '2' }">
					       <p
								style="font-family: 'arial'; font-size: 20px; margin-top: 80px;">To be approved</p>
					   </c:if>
					   <c:if test="${album == '1' }">
					       <p
								style="font-family: 'arial'; font-size: 20px; margin-top: 80px;">Approved, not public</p>
					   </c:if>
					   <c:if test="${album == '0' }">
					       <p
								style="font-family: 'arial'; font-size: 20px; margin-top: 80px;">No Albums Yet</p>
					   </c:if>
					</div>
				</div>
			</div>
		</div>
		<!--1 floor-->
		<!--2 floor-->
		<div class="floor2 marginTop20">
			<!--兴趣-->
			<div class="interest">
				<div class="interestTitle">
					<div class="interest_blog" id="interestBlogBtn">
						<a>Blog</a>
					</div>
					<div class="interest_forum" id="interestForumBtn">
						<a>Forum</a>
					</div>
					<div class="interest_question" id="interestQuestionBtn">
						<a>Q & A</a>
					</div>
					<div class="interest_label" id="interestLabelBtn">
						<a>Interests</a>
					</div>
				</div>
				<div class="interestContent">
					<!--blog-->
					<div class="interest_blog_Info interest_block" id="interestBlog">

						<div class="interest_blog_Info_left ">
							<table class="interest_blog_Info_left_Info" border="0"
								cellspacing="0" cellpadding="0" width="100%">
								<tr class="tr1">
									<th width="45%">Title</th>

									<th width="30%">Time</th>
									<th width="25%">Readings</th>
								</tr>
								<c:forEach items="${blogLogByTime}" var="item" end="4">
									<tr style="font-size:14px;">
										<td style="text-align: left;"><a
											href="<%=basePath %>web/Blog/article/<%=nowTime %>${item.id}#footer">${item.subject
												}</a></td>
										<td>${item.blogTime }</td>
										<td style="color: #087ec4;">${item.visited }</td>
									</tr>
								</c:forEach>




							</table>

						</div>

						<div class="interest_more">
							<a href="<%=basePath %>blogMore/${blogUser.id}.html">More>></a>
						</div>

					</div>
					<!--blog-->

					<!--blog-->
					<div class="interest_blog_Info" id="interestForum">

						<div class="interest_blog_Info_left">
							<table class="interest_blog_Info_left_Info" border="0"
								width="100%" cellspacing="0" cellpadding="0">
								<tr class="tr1 firstTr">
									<th width="45%">Title</th>

									<th width="30%">Time</th>
									<th width="25%">Readings</th>
								</tr>
								<c:forEach items="${forumByTime}" var="item" end="4">
									<tr style="font-size:14px;">
										<td style="text-align: left;"><a
											href="<%=basePath%>/listReplyByPostId?post_id=${item.id }&record=1">${item.subject
												}</a></td>
										<td>${item.postDate }</td>
										<td style="color: #087ec4;">${item.postCount }</td>
									</tr>
								</c:forEach>



							</table>

						</div>
						<div class="interest_more">
							<a href="<%=basePath %>forumMore/${blogUser.id}.html">More>></a>
						</div>
					</div>
					<!--blog-->

					<!--blog-->
					<div class="interest_blog_Info" id="interestQuestion">

						<div class="interest_blog_Info_left">
							<table class="interest_blog_Info_left_Info" border="0"
								width="100%" cellspacing="0" cellpadding="0">
								<tr class="tr1">
									<th width="45%">Title</th>

									<th width="30%">Time</th>
									<th width="25%"></th>
								</tr>
								<c:forEach items="${questionByTime}" var="item" end="4">
									<tr style="font-size:14px;">
										<td style="text-align: left;"><a
											href="<%=basePath %>web/QandA/QuestionFind/${item.id }">${item.qSubject
												}</a></td>
										<td>${item.qTime }</td>
										<td></td>
									</tr>
								</c:forEach>



							</table>

						</div>
						<div class="interest_more">
							<a href="<%=basePath %>questionMore/${blogUser.id}.html">More>></a>
						</div>
					</div>
					<!--blog-->


					<!--blog-->
					<div class="interest_blog_Info" id="interestLabel">
						<div class="interest_blog_Info_left">
							<table class="interest_blog_Info_left_Info" border="0"
								width="100%" cellspacing="0" cellpadding="0">
								<tr class="tr1">
									<th width="45%">Title</th>

									<th width="30%">Time</th>
									<th width="25%">Collection</th>
								</tr>
								<c:forEach items="${fav}" var="item" end="4">
									<tr style="font-size:14px;">
										<td style="text-align: left;"><a href="${item.blogUrl}">${item.blogLog.subject
												}</a></td>
										<td>${item.time }</td>
										<td>${item.id }</td>
									</tr>
								</c:forEach>



							</table>





						</div>
						<div class="interest_more">
							<a href="<%=basePath%>collectMore/${blogUser.id}.html">More>></a>
						</div>
					</div>
					<!--blog-->






				</div>
				<!--兴趣Content-->
			</div>
			<!--兴趣-->


			<!--hot label-->
			<div class="hotLabel" id="hotLabel">
				<div class="hotLabelTitle">
					<div class="hotLabelTitle_1">
						<h3> Tags</h3>
					</div>
				</div>
				<div class="hotLabelContent">
					<table class="hotLabelInfo" border="0" width="100%" cellspacing="0"
						cellpadding="0">
						<tr class="tr1">
							<th width="10%"></th>
							<th width="50%">Name of tag</th>

							<th width="40%">Union Belonged</th>
						</tr>
						</tr>
						<%
							int rank = 0;
							int rankCount = 0;
						%>
						<c:forEach items="${hotLabels }" var="item" end="9">
							<%
								if (rank < 4) {
										rank++;
									}
									rankCount++;
							%>
							<tr>
								<td><span class="rank<%=rank%>"><%=rankCount%></span></td>
								<td><a
									href="<%=basePath%>all.do?record=1&keyword=${item.labelName }">${item.labelName
										}</a></td>
								<td>${item.board.boardName }<%-- ${item.labelDesc } --%>
								</td>
							</tr>
						</c:forEach>


					</table>
				</div>
			</div>





		</div>
		<!--2 floor-->


		<!--3 floor-->
		<div class="floor3 marginTop20">
			<div class="attach" id="attach">
				<div class="attachTitle">

					<h3>Sharing resouces area</h3>
					<a class="blogMore"
						href="<%=basePath%>attachMore/${blogUser.id}.html">more</a>
				</div>
				<div class="attachContent">
					<table class="attachInfo" border="0" width="100%" cellspacing="0"
						cellpadding="0">
						<tr class="tr1">
							<th width="20%">Title</th>
							<th width="30%">Description</th>
							<th width="16%">Time</th>
							<th width="7%">Panacea</th>
							<th width="7%">Brick</th>
							<th width="10%">Level</th>
							<th width="10%">Downloads</th>
						</tr>

						<!--13123213113-->

						<c:forEach items="${attachByTime }" var="item" end="7">
							<tr>
								<th style="text-align: left;"><a
									href="<%=basePath %>web/Blog/AttachDetail/${item.id }">${item.attachName
										}</a></th>
								<th style="text-align: left;">${item.attachDesc }</th>
								<th>${item.attachTime }</th>
								<th class="th1">${item.lingdanWealth }</th>
								<th class="th1">${item.jinzhuanWealth }</th>
								<th><c:forEach begin="1" end="${item.access}" step="1">
										<img src="<%=basePath%>images/Forums/new/star1.png"
											width="10px" height="10px" />
									</c:forEach> <c:forEach begin="${item.access+1}" end="7" step="1">
										<img src="<%=basePath%>images/Forums/new/star2.png"
											width="10px" height="10px" />
									</c:forEach></th>
								<th class="th1">${item.attachDownload }</th>


							</tr>
						</c:forEach>


					</table>


				</div>
			</div>

		</div>

		<!--3 floor-->





	</div>
	<!--mainbox-->

	<!--footer-->

	<!--footer-->

	<div class="footer">
		<h3>Copyright © 2014 JIE & C DEV(HK)CO L.&nbsp;&nbsp;All Rights
			Reserved.</h3>
	</div>
	<!--footer end-->
</body>
</html>