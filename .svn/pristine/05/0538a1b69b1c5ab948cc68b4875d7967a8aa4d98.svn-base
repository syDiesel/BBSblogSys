<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC"-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inbox</title>
<meta http-equiv="x-ua-compatible" content="ie=8" />



<link href="<%=basePath%>css/headfoot.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>css/index_default.css" rel="stylesheet"
	type="text/css" />
<link type="text/css" href="<%=basePath%>css/PersonalMessage.css"
	rel="stylesheet" />
<link href="<%=basePath%>css/qiantai/login.css" rel="stylesheet" type="text/css" />


<script type="text/javascript"
	src="<%=basePath%>js/jquery-1.10.2.min.js">
					</script>
<script type="text/javascript" src="<%=basePath%>js/index/language.js"></script>
<script type="text/javascript" src="<%=basePath%>js/PrivateMsg/box.js">
					</script>
<script type="text/javascript" src="<%=basePath%>js/login_all.js"></script>
</head>
<body style="overflow:auto;font-family: arial;">
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
	<!--私信功能选择栏-->
	<!--新私信-->
	<div class="mes">
		<div class="mes_notic">
			<ul class="notice_tab">
				<li><a href="<%=basePath%>web/PrivateMsg/toSendPM"> New DMS </a></li>
				<li class="curr-tab notify"><a
					href="<%=basePath%>web/PrivateMsg/RecBox"> Inbox </a></li>
				<li><a href="<%=basePath%>web/PrivateMsg/sendBox"> Outbox </a></li>
				<!--<li><a href="drafts.html">草稿箱</a></li>-->
			</ul>
		</div>
		<!--新建私信-->
		<div class="col-xs-8 col-content">
			<div class="private-new" style="display: block;">
				<div class="row nty-mas-rtop">
					<h3 class="noy-pl15">
						<i class="icon-envelope"> &nbsp; </i> Inbox
					</h3>
				</div>
				<!--私信内容-->


				<div id="content_my_notice_content" class="main-content-page"
					style="display: block;">
					<ul class="main-content-list-small" id="c_notifyList">
						<c:if test="${empty pm.datas}">

							<div align="center">The corresponding record not found</div>

						</c:if>
						<c:if test="${!empty pm.datas}">


							<c:forEach items="${ pm.datas}" var="item">

								<li onclick="blockDetails(${item.id })">
									<div class="main-content-list-message" id="title_${item.id }">
										<span class="main-content-list-notice-type"> <c:if
												test="${item.isRead ==0}">
												<i id="isReadIcon_${item.id }" class="icon-notice-ru">&nbsp;&nbsp;&nbsp;&nbsp;</i>
											</c:if> <c:if test="${item.isRead ==1}">
												<i id="isReadIcon_${item.id }" class="icon-notice-rd">&nbsp;&nbsp;&nbsp;&nbsp;</i>
											</c:if> &nbsp;&nbsp;${item.userInfo2.nickName}
										</span> <span class="main-content-list-title"> <c:if
												test="${item.userInfo2.role.id==1}">
												<span style="color: red">[News]</span>
											</c:if> ${item.messageText.msgSubject}
										</span> <span class="main-content-list-date">
											${item.messageText.msgTime} </span>

									</div>


								</li>
								<c:if test="${item.userInfo1.id==userInfo.id}">
									<span class="main-content-list-delete"> &nbsp;<a
										href="<%=basePath %>web/PrivateMsg/delete_${item.id}">Delete</a>
									</span>
								</c:if>
								<li>
									<div class="main-content-list-details" style="display: none;"
										id="details_${item.id }">
										<i class="icon-arrow-top"> </i>
										<div
											style="text-indent: 2em; white-space: normal; width: 700px;">${item.messageText.msgContent}</div>
										<c:if test="${item.messageText.msgType} ne 'QandA'">
										<span class="main-content-list-date">
										<a href="<%=basePath %>web/Blog/receiver.do?id=${item.userInfo2.id}">Reply</a>	
										</span>
										</c:if>
									</div>

								</li>
							</c:forEach>
						</c:if>

					</ul>

					<span id="notify_state" class="loading-state"
						style="cursor: pointer; display: none;"> <img
						src="http://static.hdslb.com/images/loadinglit.gif"
						style="display: none;"> <b> Loading....</b>
					</span>
					<ul class="page" id="notifyPageList" style="display: none;">
					</ul>
				</div>
				<!--私信内容结束-->



			</div>
			<div style="clear: both"></div>
			<c:if test="${!empty pm.datas}">
				<div align="center" style="margin-top: 80px;" class="art-pag">
					<pg:pager url="RecBox" items="${pm.total}"
						export="currentPageNumber=pageNumber" maxPageItems="10"
						maxIndexPages="10">
						<pg:first>
							<a href="${pageUrl}" mce_href="${pageUrl}">Homepage</a>
						</pg:first>
						<pg:prev>
							<a href="${pageUrl }" mce_href="${pageUrl }">Page up</a>
						</pg:prev>
						<pg:pages>
							<c:choose>
								<c:when test="${currentPageNumber eq pageNumber}">
									<font color="red">${pageNumber }</font>
								</c:when>
								<c:otherwise>
									<a href="${pageUrl }" mce_href="${pageUrl }">${pageNumber }</a>
								</c:otherwise>
							</c:choose>
						</pg:pages>
						<pg:next>
							<a href="${pageUrl }" mce_href="${pageUrl }">Page down</a>
						</pg:next>
						<pg:last>
							<a href="${pageUrl }" mce_href="${pageUrl }">Last page</a>
						</pg:last>
					</pg:pager>
				</div>
			</c:if>
		</div>
	</div>
	<!-- -->

<!--footer-->

	<div class="footer">
		<h3>Copyright © 2014 JIE & C DEV(HK)CO L.&nbsp;&nbsp;All Rights
			Reserved.</h3>
	</div>
	<!--footer end-->
</body>

</html>