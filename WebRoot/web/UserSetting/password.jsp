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

<title>Change Password</title>

<meta http-equiv="x-ua-compatible" content="ie=8" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript"
	src="<%=basePath%>js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/index/index.js"></script>
<script type="text/javascript" src="<%=basePath%>js/index/language.js"></script>
<script type="text/javascript" src="<%=basePath%>js/houtai/updatePassword.js"></script>
<script type="text/javascript" src="<%=basePath%>js/login_all.js"></script>

<link type="image/x-icon" href="<%=basePath%>img/bitbug_favicon.ico"
	rel="shortcut icon" />

<link href="<%=basePath%>css/headfoot.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>css/index_default.css" rel="stylesheet"
	type="text/css" />
<link type="text/css" rel="stylesheet"
	href="<%=basePath%>css/personInfo/basic.css">
<link href="<%=basePath%>css/qiantai/login.css" rel="stylesheet" type="text/css" />
<script>
	var a = {
		"1" : "<fmt:message key="登录密码不合法！"></fmt:message>",
		"2" : "<fmt:message key="密码长度不能少于6位！"></fmt:message>",
		"3" : "<fmt:message key="密码不一致！"></fmt:message>"
	};
</script>

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
	<!--main start-->
	<div class="mainBox">
		<div id="content">
			<div class="mod-setting clearfix">
				<div class="setting-title yahei">Personal Settings</div>
				<div class="setting-content clearfix">
					<div class="setting-menu">
						<div class="menu-title menu-profile-current active">
							<h3>Personal Info</h3>
						</div>
						<ul class="menu-list">
							<li class="menu-item basic-link on"><a
								href="<%=basePath%>u/setting/basic">Profile</a></li>
							<li class="menu-split"></li>
							<li class="menu-item details-link"><a
								href="<%=basePath%>u/setting/details">Details</a></li>

							<li class="menu-split"></li>
							<li class="menu-item education-link"><a
								href="<%=basePath%>u/setting/education">educational background</a></li>
							<li class="menu-split"></li>
							<li class="menu-item career-link"><a
								href="<%=basePath%>u/setting/career">Work experience</a></li>
							<li class="menu-split"></li>
							<li class="menu-item portrait-link"><a
								href="<%=basePath%>u/setting/portrait">Portrait settings</a></li>
						</ul>

						<div class="menu-title menu-privacy-current">
							<h3>Account Info</h3>
						</div>
						<ul class="menu-list">
							<li class="menu-item basic-link"><a
								href="<%=basePath%>u/setting/password">Change Password</a></li>
							<li class="menu-split"></li>
							<li class="menu-item details-link"><a
								href="<%=basePath%>u/setting/protect">Password Tip</a></li>


						</ul>


					</div>
					<div class="setting-detail" id="stthld" style="display: block;">
						<div class="detail-bg"></div>
						<div class="plzhld clearfix">
							<div class="mod-setting-profile" id="1000001"
								style="display: block;">
								<div class="setting-profile-title yahei">Change Password</div>
								<input type="hidden" value="${userInfo.userName}"
									name="userName" id="userName">
								<form id="profile" class="setting-profile-form" method="POST"
									action="updatePassword.do">
									<table class="setting-profile-table">
										<tbody>

											<tr>
												<th>Original password:</th>
												<td>
													<div class="mod-cus-sel " id="cussel1000000">
														<input class="cus-sel-opt-panel" name="oldpass"
															id="oldPWD" type="password" />

													</div>
												</td>
												<td><span class="errorTip"
													style="color: red; font-size: 12px;"><label
														class="oldPWD"></label></span></td>

											</tr>
											<tr>
												<th>New Password:</th>
												<td>
													<div class="mod-cus-sel " id="cussel1000003">
														<input class="cus-sel-opt-panel" name="newpass1"
															id="newPWD1" type="password">

													</div>
												</td>
												<td><span class="errorTip"
													style="color: red; font-size: 12px;"><label
														class="newPWD1"></label></span></td>

											</tr>
											<tr>
												<th>Confirm New Password:</th>
												<td>
													<div class="mod-cus-sel " id="cussel1000004">
														<input class="cus-sel-opt-panel" id="newPWD2"
															name="newpass2" type="password">


													</div>
												</td>
												<td><span class="errorTip"
													style="color: red; font-size: 12px;"><label
														class="newPWD2"></label></span></td>

											</tr>

										</tbody>
									</table>


								</form>

								<input type="button"
									class="setting-submit-btn setting-submit-ml100" value="save"
									id="toUpdatePWD">
								<c:if test="${modifySuccess.equals('success')}">
									<span id="msg"
										style="color: red; height: 20px; width: 100px; float: left; margin-top: 20px; margin-left: 20px;">
										Password is changed </span>
								</c:if>

								<c:if test="${modifySuccess.equals('error')}">
									<span id="msg"
										style="color: red; height: 20px; width: 100px; float: left; margin-top: 20px; margin-left: 20px;">
										Change password failed </span>
								</c:if>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div id="foot">
			<div class="mod-footer"></div>
		</div>
		<!--main_body end-->
	</div>
	<!--main end-->

<!--footer-->

	<div class="footer">
		<h3>Copyright © 2014 JIE & C DEV(HK)CO L.&nbsp;&nbsp;All Rights
			Reserved.</h3>
	</div>
	<!--footer end-->

</body>
</body>
</html>
