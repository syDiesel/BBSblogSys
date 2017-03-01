<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
<meta http-equiv="x-ua-compatible" content="ie=8" />
<link type="text/css" href="<%=basePath%>css/home.css" rel="stylesheet" />
<link type="text/css" href="<%=basePath%>css/index_default.css" rel="stylesheet" />
<link type="text/css" href="<%=basePath%>css/QandA/QandA.css" rel="stylesheet" />
<link type="text/css" href="<%=basePath%>css/home_search.css" rel="stylesheet" />
<link type="text/css" href="<%=basePath%>css/QandA/home.css" rel="stylesheet" />
<link href="<%=basePath%>css/qiantai/login.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="../../js/jquery-1.10.2.min.js"></script>
<script src="../../js/blog/home.js"></script>
<script type="text/javascript" src="<%=basePath%>js/login_all.js"></script>
</head>

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

	<!--mainbox beginning-->
	<div class="mainbox">
		<div class="board-right">
			<div class="board-name">
				<a href="<%=basePath%>web/QandA/AskQ">I will ask</a>
			</div>
			<hr>
			<p>hot answers</p>
		</div>

		<!--left-->
		<div class="board-left">
			<!--1  S-->
			<div class="QandA">
				<div class="QandA_head">
					<h3>new questions</h3>
					<div class="more">
						<a href="<%=basePath%>web/QandA/Home/more/last/1">see more+</a>
					</div>
				</div>
				<div class="QandA_content">
					<ul>
						<c:forEach items="${lastQ}" var="l" varStatus="s">
							<c:choose>
								<c:when test="${s.count==1 }">
									<li class="rank1">
										<span>1</span><a href="<%=basePath%>web/QandA/QuestionFind/${l.getId() }">${l.getQSubject()}</a>
									</li>
								</c:when>
								<c:when test="${s.count==2 }">
									<li class="rank2">
										<span>2</span><a href="<%=basePath%>web/QandA/QuestionFind/${l.getId() }">${l.getQSubject()}</a>
									</li>
								</c:when>
								<c:when test="${s.count==3 }">
									<li class="rank3">
										<span>3</span><a href="<%=basePath%>web/QandA/QuestionFind/${l.getId() }">${l.getQSubject()}</a>
									</li>
								</c:when>
								<c:otherwise>
									<li class="rank4">
										<span>${s.count}</span><a href="<%=basePath%>web/QandA/QuestionFind/${l.getId() }">${l.getQSubject()}</a>
									</li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</ul>
				</div>
			</div>
			<!--1 e-->
			
			<!--1  S-->
			<div class="QandA">
				<div class="QandA_head">
					<h3>unsolved questions</h3>
					<div class="more">
						<a href="<%=basePath%>web/QandA/Home/more/undo/1">see more+</a>
					</div>
				</div>
				<div class="QandA_content">
					<ul>
						<c:forEach items="${undoQ}" var="u" varStatus="s">
							<c:choose>
								<c:when test="${s.count==1 }">
									<li class="rank1"><span>1</span><a
										href="<%=basePath%>web/QandA/QuestionFind/${u.getId() }">${u.getQSubject()}</a></li>
								</c:when>
								<c:when test="${s.count==2 }">
									<li class="rank2"><span>2</span><a
										href="<%=basePath%>web/QandA/QuestionFind/${u.getId() }">${u.getQSubject()}</a></li>
								</c:when>
								<c:when test="${s.count==3 }">
									<li class="rank3"><span>3</span><a
										href="<%=basePath%>web/QandA/QuestionFind/${u.getId() }">${u.getQSubject()}</a></li>
								</c:when>
								<c:otherwise>
									<li class="rank4"><span>${s.count}</span><a
										href="<%=basePath%>web/QandA/QuestionFind/${u.getId() }">${u.getQSubject()}</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</ul>
				</div>
			</div>
			<!--1 e-->

			<!--1  S-->
			<div class="QandA">
				<div class="QandA_head">
					<h3>solved questions</h3>
					<div class="more">
						<a href="<%=basePath%>web/QandA/Home/more/do/1">see more+</a>
					</div>
				</div>
				<div class="QandA_content">
					<ul>
						<c:forEach items="${doQ}" var="d" varStatus="s">
							<c:choose>
								<c:when test="${s.count==1 }">
									<li class="rank1">
										<span>1</span><a href="<%=basePath%>web/QandA/QuestionFind/${d.getId() }">${d.getQSubject()}</a>
									</li>
								</c:when>
								<c:when test="${s.count==2 }">
									<li class="rank2">
										<span>2</span><a href="<%=basePath%>web/QandA/QuestionFind/${d.getId() }">${d.getQSubject()}</a>
									</li>
								</c:when>
								<c:when test="${s.count==3 }">
									<li class="rank3">
										<span>3</span><a href="<%=basePath%>web/QandA/QuestionFind/${d.getId() }">${d.getQSubject()}</a>
									</li>
								</c:when>
								<c:otherwise>
									<li class="rank4">
										<span>${s.count}</span><a href="<%=basePath%>web/QandA/QuestionFind/${d.getId() }">${d.getQSubject()}</a>
									</li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</ul>
				</div>
			</div>
			<!--1 e-->
		</div>
	</div>
	<!--mainbox end-->
<!--footer-->

	<div class="footer">
		<h3>Copyright © 2014 JIE & C DEV(HK)CO L.&nbsp;&nbsp;All Rights Reserved.</h3>
	</div>
	<!--footer end-->
</body>
</html>