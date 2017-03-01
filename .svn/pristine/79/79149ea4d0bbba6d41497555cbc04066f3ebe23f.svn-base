<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>Personal Information</title>

<meta http-equiv="x-ua-compatible" content="ie=8" />


<script type="text/javascript"
	src="<%=basePath%>js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/index/index.js"></script>
<script type="text/javascript" src="<%=basePath%>js/index/language.js"></script>
<script type="text/javascript" src="<%=basePath%>js/login_all.js"></script>
<link type="text/css" rel="stylesheet"
	href="<%=basePath%>css/personInfo/detail.css">

</head>
<link type="image/x-icon" href="<%=basePath%>img/bitbug_favicon.ico"
	rel="shortcut icon" />

<link href="<%=basePath%>css/headfoot.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>css/index_default.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>css/qiantai/login.css" rel="stylesheet" type="text/css" />

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
	<div class="mainBox">
		<div class="main" style="text-align: left;">
			<div id="wrapper">

				<div id="content" class="clearfix">
					<div class="mod-avator clearfix">
						<div class="avator">
							<div class="avator-img">
								<div class="portrait-bg"></div>
								<div class="portrait">
									<img class="portrait-img"
										src="<%=basePath %>${personInfo.userInfo.headImg}"><span></span>
								</div>
								<%--            <div class="info-status-bg"></div>
          <div class="info-online">${personInfo.userInfo.nickName}</div> --%>
								<div>
									<p class="uname wordwrap">
										<a
											href="<%=basePath %>web/Blog/${personInfo.userInfo.nickName}"
											class="link">${personInfo.userInfo.nickName}</a>
									</p>
									<p class="clearfix"></p>

								</div>

							</div>
							<div style="text-align: center; margin-top: 5px;">
								<c:forEach begin="1" end="${userInfo.userLevel}" step="1">
									<img src="<%=basePath%>images/Forums/star.png" width="12px"
										height="12px" />
								</c:forEach>
								<c:forEach begin="${userInfo.userLevel+1}" end="7" step="1">
									<img src="<%=basePath%>images/Forums/0star.png" width="12px"
										height="12px" />
								</c:forEach>
							</div>
							<style>
							.userCount{
							width:160px;
							}
							.userCount span{
								display:block;
								float:left;
								width:75px; 
							}
							
							</style>
							<div class="userCount" style="text-align:left; margin-top: 5px;">
								<span>Flowers：${userInfo.xianhua }</span><span>Respect：${userInfo.yangmu }</span>
								<br/>
								<span>Brick：${userInfo.jinzhuan }</span><span>Panaceas：${userInfo.lingdan }</span>
							</div>
							<!--         <div>
          <p class="uname wordwrap"><a href="http://www.baidu.com/p/lzw4284" class="link"></a></p>
          <p class="clearfix"> </p>
        </div> -->
						</div>
					</div>
					<div class="mod-profile">
						<a href="<%=basePath%>u/setting/basic" class="edit-btn">Edit info</a>
						<div class="split-line-top"></div>
						<dl class="userdetail-profile-basic">
							<a href="<%=basePath%>u/setting/basic" class="edit-link">Edit</a>
							<dt>Profile</dt>
							<dd>
								<span class="profile-attr">Gender</span> <span class="profile-cnt">${personInfo.sex }</span>
							</dd>
							<dd>
								<span class="profile-attr">Birthday</span> <span class="profile-cnt">
									${personInfo.birthday }</span>
							</dd>
							<dd>
								<span class="profile-attr">Height</span> <span class="profile-cnt">${personInfo.shengao }</span>
							</dd>
							<dd>
								<span class="profile-attr">Birthplace</span> <span class="profile-cnt">${personInfo.jiguan }</span>
							</dd>
							<dd>
								<span class="profile-attr">Residence</span> <span class="profile-cnt">${personInfo.address }</span>
							</dd>
							<dd>
								<span class="profile-attr">Individual resume</span> <span class="profile-cnt">${personInfo.personalDesc }</span>
							</dd>
						</dl>
						<div class="split-line"></div>
						<dl>
							<a href="<%=basePath%>u/setting/details" class="edit-link">Edit</a>
							<dt>Details</dt>
							<dd>
								<span class="profile-attr">Real name</span> <span>${personInfo.realname }</span>
							</dd>
							<dd>
								<span class="profile-attr">ID number</span> <span>${personInfo.idno }</span>
							</dd>
							<dd>
								<span class="profile-attr">Hobby</span> <span>${personInfo.aihao }</span>
							</dd>
							<dd>
								<span class="profile-attr">Talent</span> <span>${personInfo.shanchang }</span>
							</dd>


						</dl>

						<div class="split-line"></div>
						<dl>
							<a href="<%=basePath%>u/setting/education" class="edit-link">Edit</a>
							<dt>educational background</dt>
							<dd>
								<span class="profile-attr">School</span> <span>${personInfo.graduate }</span>
							</dd>
							<dd>
								<span class="profile-attr">Major</span> <span>${personInfo.zhuanye }</span>
							</dd>
							<dd>
								<span class="profile-attr">Education</span> <span>${personInfo.xueli }</span>
							</dd>
							<dd>
								<span class="profile-attr">Degree</span> <span>${personInfo.degree }</span>
							</dd>


						</dl>

						<div class="split-line"></div>
						<dl>
							<a href="<%=basePath%>u/setting/career" class="edit-link">Edit</a>
							<dt>Work experience</dt>
							<dd>
								<span class="profile-attr">Industry</span> <span>${personInfo.hangye }</span>
							</dd>
							<dd>
								<span class="profile-attr">Company</span> <span>${personInfo.company }</span>
							</dd>
							<dd>
								<span class="profile-attr">Occupation</span> <span>${personInfo.job}</span>
							</dd>



						</dl>

					</div>
				</div>
				<div id="foot">
					<div class="mod-footer"></div>
				</div>
			</div>


		</div>






	</div>


<!--footer-->

	<div class="footer">
		<h3>Copyright © 2014 JIE & C DEV(HK)CO L.&nbsp;&nbsp;All Rights
			Reserved.</h3>
	</div>
	<!--footer end-->
</body>
</html>
