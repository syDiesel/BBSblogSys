<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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

<title>regulation</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript"
	src="<%=basePath%>js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/index/index.js"></script>
<script type="text/javascript" src="<%=basePath%>js/index/language.js"></script>
<script type="text/javascript" src="<%=basePath%>js/login_all.js"></script>

</head>
<link type="image/x-icon" href="<%=basePath%>img/bitbug_favicon.ico"
	rel="shortcut icon" />



<link href="<%=basePath%>css/headfoot.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>css/index_default.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>css/Index/index.css" rel="stylesheet"
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
	<style>
.main {
	height: auto;
	overflow: hidden;
}
.main{
	width:900px;
	min-height:650px;
	margin:10px auto;
	background-color: white;
	
}
.main_head h2{
	font-size:18px;
	margin: 5px auto;
}
.main_head h2{
	text-align:center;
}
.main_content p {
	width: 800px;
	white-space: normal;
	margin: 5px auto;
}
</style>
	<!--main start-->
	<div class="main">
		<div class="main_head">
			<h2 style="font-size: 30px;">User Guide</h2>
		</div>

		<div class="main_content" style="font-family: 'Microsoft YaHei','New York', serif;font-size: 16px;margin-top:50px;">



			<p class="MsoListParagraph"
				style="margin-left: 50.35pt; text-indent: -24.0pt;">
				<b></b>
			</p>
			<p class="MsoNormal" style="text-indent: 154.6pt;">
			<p class="MsoNormal">
				<b>Ranking System</b>
			</p>
			<p class="MsoNormal" align="left" style="background: white;">
				Members are ranked as 7 levels (seven stars at most), based on the
				scores they earn within the website.</p>
			<p class="MsoNormal" align="left" style="background: white;">
				&nbsp;</p>
			<p class="MsoNormal" align="left" style="background: white;">
				Every N-level is equal to the score of 10<sup>n</sup> points. Every
				point is equal to a virtual “Golden Brick”.
			</p>
			<p class="MsoNormal" align="left" style="background: white;">
				&nbsp;</p>
			<p class="MsoNormal" align="left" style="background: white;">
				&nbsp;</p>
			<p class="MsoNormal" align="left" style="background: white;">
				<b>Virtual Transactions</b>
			</p>
			<p class="MsoNormal" align="left" style="background: white;">
				There is two methods to virtually transact/pay here: “Golden Brick”
				means the points one member is earning, symbolizing his ability;
				“Panacea” reflects the actual money transaction, symbolizing the
				price to break the usual rule.</p>
			<p class="MsoNormal" align="left" style="background: white;">
				&nbsp;</p>
			<p class="MsoNormal" align="left" style="background: white;">
				From the point of virtual value, 1 Golden Brick = 1 point = 1
				Panacea = 1 RMB Yuan. But “Golden Brick” hasn’t something to do with
				actual money transaction, while “Panacea” has. You need recharge
				money to your virtual account to get “Panacea”, and for every
				transaction members make by “Panacea”, the website will retain ten
				percent of the value as management fee.&nbsp; &nbsp;</p>
			<p class="MsoNormal" align="left" style="background: white;">
				&nbsp;</p>
			<p class="MsoNormal">&nbsp;</p>
			<p class="MsoNormal" align="left" style="background: white;">
				<b>Scoring Rule</b>
			</p>
			<p class="MsoNormal" align="left" style="background: white;">
				Generally, for every article, qualification picture, or other works
				the member creates and issues, he earns one point under one certain
				tag. When the article is commented as “Good” by a one-star member,
				the author earns one more point. When the author earns 10 points, he
				becomes the one-star member.&nbsp; &nbsp;</p>
			<p class="MsoNormal" align="left" style="background: white;">
				&nbsp;</p>
			<p class="MsoNormal" align="left" style="background: white;">
				Likewise, when the article is commented as “Good” by a 7-star
				member, the author earns 7 points at one time.</p>
			<p class="MsoNormal" align="left" style="background: white;">
				&nbsp;</p>
			<p class="MsoNormal" align="left" style="background: white;">If
				the article is reprinted from somewhere else, the author must mark
				clearly, and earns 1/10 point for every comment of “good” his
				article receives from a one-star member.</p>
			<p class="MsoNormal" align="left" style="background: white;">
				&nbsp;</p>
			<p class="MsoNormal" align="left" style="background: white;">
				&nbsp;</p>
			<p class="MsoNoSpacing">
				<span>Guide dated October 27, 2014.</span>
			</p>
			</p>
			<p class="MsoNormal" style="text-indent: 390.0pt;">
				<br />
			</p>





		</div>

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
