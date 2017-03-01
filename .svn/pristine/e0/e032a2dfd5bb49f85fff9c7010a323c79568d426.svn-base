<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>photo
</title>
<meta http-equiv="x-ua-compatible" content="ie=8" />
<link type="image/x-icon" href="<%=basePath%>img/bitbug_favicon.ico"
	rel="shortcut icon" />

<link href="<%=basePath%>css/newPersonalInfo/head.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>css/newPersonalInfo/personalPhoto.css"
	rel="stylesheet" type="text/css" />

<link href="<%=basePath%>css/index_default.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>css/Index/index.css" rel="stylesheet"
	type="text/css" />
<link type="text/css" href="<%=basePath%>css/qiantai/photo.css"
	rel="stylesheet" />
<link type="text/css" href="<%=basePath%>css/button.css"
	rel="stylesheet" />
<link type="image/x-icon" href="<%=basePath%>img/bitbug_favicon.ico"
	rel="shortcut icon" />


<link href="<%=basePath%>css/qiantai/login.css" rel="stylesheet" type="text/css" />

<script type="text/javascript"
	src="<%=basePath%>js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/index/index.js"></script>
<script type="text/javascript" src="<%=basePath%>js/index/language.js"></script>

<meta http-equiv="x-ua-compatible" content="ie=8" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="<%=basePath%>js/album.js"></script>
<script type="text/javascript" src="<%=basePath%>js/login_all.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/jquery-1.10.2.min.js">
					</script>
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<script type="text/javascript">

  		function reloadcode(){
  			
                    var verify=document.getElementById('code');
              
                verify.setAttribute('src','<%=basePath%>web/user/makeCertPic.jsp?id='
				+ new Date().getTime());
	};
</script>

</head>

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

	<center>
		<div class="main">
			<div class="head0">
				<a class="submitButton"
					style="float:right;margin-top:0px;"
					href="javascript:history.go(-1);">return</a>
				<c:if
						test="${userAlbumPhoto.zzzm == '1'}">
                  pending review
    </c:if> <c:if test="${userAlbumPhoto.zzzm == '2'}">
                approved
    </c:if> <c:if test="${userAlbumPhoto.zzzm == '3'}">
              not pass
    </c:if>
				<c:if test="${blogUser.id eq userInfo.id }">
					<a href="<%=basePath%>fileupload.do" class="submitButton"
						name="submit"
						style="margin-top:0px; float: right;"> upload</a>
				</c:if>
			</div>
			<c:if test="${!empty userAlbumPhoto }">
				<img src="<%=basePath %>${userAlbumPhoto.photo }" width=600px
					style="margin: 6px auto;" />
				<br>
				<span style="font-size: 15px;">${userAlbumPhoto.photoDesc }</span>
			</c:if>

			<c:if test="${userAlbumPhoto.zzzm=='2'}">
				<div style="border-bottom: solid 1px #999;"></div>
				<input type="hidden" id="logId" value="${userAlbumPhoto.id}">
				<div id="digg">
					<dl id="btnGood" class="digg digg_enable" onclick="pingjia(this)">
						<dt onclick="">
							good
							<%-- 好 --%>
						</dt>
						<dd id="btnGoodCount">${userAlbumPhoto.up }</dd>
					</dl>
					<dl id="btnMid" class="digg digg_enable" onclick="pingjia(this)">
						<dt onclick="">
							soso
							<%--中 --%>
						</dt>
						<dd id="btnMidCount">${userAlbumPhoto.normal}</dd>
					</dl>
					<dl id="btnBad" class="digg digg_enable" onclick="pingjia(this)">
						<dt onclick="">
							sorry
							<%-- 差 --%>
						</dt>
						<dd id="btnBadCount">${userAlbumPhoto.down }</dd>
					</dl>
				</div>
			</c:if>
			<c:if test="${blogUser.id eq userInfo.id && userAlbumPhoto.zzzm == '0'}">
					<%-- <table style="margin-top: 30px; padding-bottom: 40px;">
						<tr>
							<td><a href="blogAlbum.do?photoId=${userAlbumPhoto.id }"
								class="submitButton">as blog cover</a></td> --%>
				<div style="margin-top:15px; padding-bottom: 20px;">
				<a
					href="photoAlbum.do?photoId=${userAlbumPhoto.id }"
					class="submitButton">as album cover</a>
               </div>
			</c:if>
		</div>
	</center>

	<!--footer-->
	<script>
		var reMarks = {
			"print" : "do not evaluate again"
		}
	</script>
<!--footer-->

	<div class="footer">
		<h3>Copyright © 2014 JIE & C DEV(HK)CO L.&nbsp;&nbsp;All Rights Reserved.</h3>
	</div>
	<!--footer end-->
</body>
</html>
