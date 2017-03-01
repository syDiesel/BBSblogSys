<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<!-- saved from url=(0035)http://my.csdn.net/my/album/upload -->
<HTML>
<HEAD>
<META content="IE=11.0000" http-equiv="X-UA-Compatible">
<meta http-equiv="x-ua-compatible" content="ie=11" />
<TITLE>upload</TITLE>
<link type="text/css" href="<%=basePath%>css/Blog.css" rel="stylesheet" />

<link type="text/css" href="<%=basePath%>css/index_default.css"
	rel="stylesheet" />


<link href="<%=basePath%>css/album/bootstrap.css" rel="stylesheet">
<link href="<%=basePath%>css/album/csdn-themes-defalut.css"
	rel="stylesheet">
<link href="<%=basePath%>css/album/index.css" rel="stylesheet">
<link href="<%=basePath%>css/album/pagination.css" rel="stylesheet">
<link href="<%=basePath%>css/album/style.css" rel="stylesheet">
<link type="text/css" href="<%=basePath%>css/album/pagination.css"
	rel="stylesheet">
<link type="text/css" href="<%=basePath%>css/album/style(1).css"
	rel="stylesheet">
<link type="text/css" href="<%=basePath%>css/album/my-gallery.css"
	rel="stylesheet">

	<link type="image/x-icon" href="<%=basePath%>img/bitbug_favicon.ico"
	rel="shortcut icon" />

<link href="<%=basePath%>css/headfoot.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>css/index_default.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>css/Index/index.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>css/qiantai/login.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript"
	src="<%=basePath%>js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/index/index.js"></script>
<script type="text/javascript" src="<%=basePath%>js/index/language.js"></script>
<script type="text/javascript" src="<%=basePath%>js/login_all.js"></script>
<META name="GENERATOR" content="MSHTML 11.00.9600.16412">

<script>
	$(document).ready(function() {
		$("#new").hide();
		$(".cancle").click(function() {
			$("#new").toggle('2000000ms');
		});
		$("#cancle").click(function() {
			$("#new").toggle('2000000ms');
		});
	});
</script>
</HEAD>
<body style="font-family: Arial">
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


		<DIV class="container" id="main" style="background-color: white\9;margin-top:10px\9;padding-top: 20px\9;">
			<!--header beginning-->
			<DIV class="row">
				<DIV class="col-xs-12">
					<SECTION class="simple-box" id="my-gallery">
						<H2>
							<span
								style="float:left;font-size:20px;color:black;margin-left:-65px;margin-left:5px\9;">
								<a href="<%=basePath %>fileupload.do">upload</a></span>	
							<span style="float:left;font-size:20px;margin-left:20px;">
							<a href="<%=basePath %>zizhi.do" style="color: rgb(153, 153, 153);">upload</a></span>
							<A class="pull-right btn btn-ok"
								href="<%=basePath %>listAlbum.do?id=${userInfo.id}" data-toggle="modal" style="margin-right:20px\9;">back to album</A>
						</H2>
						<FORM action="fileUpload.do"
							enctype="multipart/form-data" method="post">
							<DIV class="simple-box-content" style="margin-left:10px\9;"><br>
								<DIV class="select-gallery">
								  <div style="margin-top:-20px;margin-top:30px\9;">
									<SPAN class="gallery-choose" style="font-size: 17px;">select:</SPAN>
									<DIV class="gallery-list" id="selectlist" style="margin-left:-20px;">
										<c:if test="${!empty listAlbum }">

											<select style="height:30px;margin-left:20px;" name="selectAlbum">
												<option value="please">select</option>
												<c:forEach items="${listAlbum }" var="listAlbum">
													<option value="${listAlbum.albumName }">${listAlbum.albumName
														}</option>
												</c:forEach>
											</select>

										</c:if>
										<c:if test="${empty listAlbum }">
										    <span style="font-size: 15px;color:red;line-height: 30px;margin-left:20px;">no album selected</span>
										</c:if>
									</DIV>
									<DIV class="create-list" id="popup-creat-gallery">
										<A style="font-size: 17px;" class="cancle">create</A> <span
											id="new"> <input type="text" name="albumName">
											<input type="reset" value="cancel" id="cancle"
											class="pull-right btn btn-ok" style="margin-left:10px;">
											&nbsp; <input type="submit" value="create"
											class="pull-right btn btn-ok"> </span>
									</DIV>
									</div>
									<br>
									<br>
									<br>
									<div style="float:left;font-size:17px;">
										pic description
										:
										<textarea name="albumDesc" cols="60" rows="10"
											value="${userAlbum.albumDesc}"
											style="width:230px;height:70px;margin-bottom:20px;font-style: normal;"></textarea>
									</div>
								</DIV>
								<DIV class="photo-upload-btn">
									<A class="photo-upload-wrap"> <INPUT name="file"
										class="photo-upload-input" id="uploads" type="file"> </A>
								</DIV>
								<div style="float:left;font-size:17px;">
								description
									:
									<textarea name="albumPhotoDesc" cols="60" rows="10"
										style="width:230px;height:50px;margin-bottom:20px;font-style: normal;"></textarea>
								</div>
								<DIV class="uploadtip" style="padding-bottom: 20px\9;padding-right:20px\9;">
									<SPAN>upload file: JPG,BMP, JPEG, GIF or PNG.(＜2M)</SPAN><INPUT
										class="pull-right btn btn-ok" type="submit" value="upload now"> <SPAN class="righttip"
										id="count_pic"></SPAN>
								</DIV>
							</DIV>
						</FORM>
					</SECTION>
				</DIV>
			</DIV>
		</DIV>
		<br>
<!--footer-->

	<div class="footer">
		<h3>Copyright © 2014 JIE & C DEV(HK)CO L.&nbsp;&nbsp;All Rights Reserved.</h3>
	</div>
	<!--footer end-->
</BODY>
</HTML>
