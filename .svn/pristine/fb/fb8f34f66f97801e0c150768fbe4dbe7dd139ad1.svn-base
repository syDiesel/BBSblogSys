<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.*"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<title>Resource Download</title>
<meta http-equiv="x-ua-compatible" content="ie=8" />



<link type="image/x-icon" href="../../bitbug_favicon.ico"
	rel=”shortcuticon”>




<link rel="stylesheet"
	href="<%=basePath%>kindeditor/themes/default/default.css" />
<link rel="stylesheet"
	href="<%=basePath%>kindeditor/plugins/code/prettify.css" />
<link rel="stylesheet"
	href="<%=basePath%>kindeditor/themes/default/default.css" />
<link rel="stylesheet"
	href="<%=basePath%>kindeditor/plugins/code/prettify.css" />
<link type="text/css" href="<%=basePath%>css/headfoot.css"
	rel="stylesheet" />
<link type="text/css" href="<%=basePath%>css/index_default.css"
	rel="stylesheet" />
<link href="<%=basePath%>css/Blog/blog_article.css" rel="stylesheet"
	type="text/css">
<link href="<%=basePath%>css/button.css" rel="stylesheet"
	type="text/css">
<link href="<%=basePath%>css/qiantai/login.css" rel="stylesheet" type="text/css" />


<script type="text/javascript"
	src="<%=basePath%>js/jquery-1.10.2.min.js">
	
</script>
<script src="<%=basePath%>js/blog/Attachment-download.js"></script>
<script type="text/javascript" src="<%=basePath%>js/index/index.js"></script>
<script type="text/javascript" src="<%=basePath%>js/index/language.js"></script>
<script type="text/javascript" src="<%=basePath%>js/blog/blogArticle.js"></script>
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


	<!--mainbox-->
	<div class="mainBox">
		<!--left floor-->
		<div class="leftPart">
			<!--会员头衔-->
			<div class="hytx">
				<div class="leftTitle">
					<h3>Member Info</h3>
				</div>
				<div class="hytxContent">
					<!-- 上半部分开始 -->
					<div class="hytxPic">
						<div class="hytxPic_pic">
							<a href="<%=basePath%>web/Blog/${blogUser.nickName }"><img
								src="<%=basePath%>${blogUser.headImg}" width="135" height="135" />
							</a>
						</div>
						<div class="hytxPic_right">
							<div class="hytxPic_user">
								<a href="<%=basePath%>web/Blog/${blogUser.nickName }"><h3>${blogUser.nickName
										}</h3> </a>

								<div style="margin: 5px"></div>
								<c:forEach begin="1" end="${blogUser.userLevel}" step="1">
									<img src="<%=basePath%>img/Blog/star.png" width="12px"
										height="15px" />
								</c:forEach>
								<c:forEach begin="${blogUser.userLevel+1}" end="7" step="1">
									<img src="<%=basePath%>img/Blog/0star.png" width="12px"
										height="15px" />
								</c:forEach>

							</div>
							<div class="hytxBtn">

								<%
									Date date = new Date();
									SimpleDateFormat f = new SimpleDateFormat("MMyydd");
									String nowTime = f.format(date);
								%>
								<c:if test="${userInfo!=null&&userInfo.id!=blogUser.id }">
									<c:if test="${friend.equals('no') }">
										<a
											href="<%=basePath%>addFriendInArticle.do?guest_id=${blogUser.id}&logId=<%=nowTime %>${log.id}"
											class="AddFriendBtn"><span>+Follow</span> </a>
									</c:if>
									<c:if test="${friend.equals('yes') }">
										<a
											href="<%=basePath%>deleteFriendInArticle.do?guest_id=${blogUser.id}&logId=<%=nowTime %>${log.id}"
											class="delFriendBtn"><span style="color:#999;">Unfollow</span> </a>
									</c:if>
									<a class="PrivateMsgBtn"
										href="<%=basePath %>web/Blog/receiver.do?id=${blogUser.id}"><span>Message</span>
									</a>
								</c:if>

							</div>
							<div class="hytx_littleInfo">
								<ul>

									<li>Gender：${blogUser.personalInfo.sex }</li>
									<li>Residence：${blogUser.personalInfo.address }</li>
								</ul>
							</div>
						</div>
					</div>
					<!-- 上半部分结束 -->
					<div class="hyzlContent">
						<table border="0" width="100%" cellspacing="0" cellpadding="0">
							<tr>
								<td width="20%">Flower：</td>
								<td width="25%" class="countNum">${blogUser.xianhua }</td>
								<td width="30%">Visit Blog:</td>
								<td width="25%" class="countNum">${log.blog.visited }</td>
							</tr>
							<tr>
								<td>Respect：</td>
								<td class="countNum">${blogUser.xianhua }</td>
								<td>Original Blog:</td>
								<td class="countNum">${ycCount }</td>
							</tr>
							<tr>
								<td>Brick：</td>
								<td class="countNum"><a title="${blogUser.jinzhuan }">${blogUser.jinzhuan
										}</a>
								</td>
								<td>Reprint Article：</td>
								<td class="countNum">${zzCount }</td>
							</tr>



						</table>
					</div>






				</div>
			</div>
			<!--会员头衔-->



			<!--会员头衔-->
			<div class="zzrzq">
				<div class="leftTitle">
					<h3>Qualification Area</h3>
				</div>
				<div class="zzrzqContent" style="text-align: center;">
					<c:if test="${album == '3' }">
					                <c:if test="${listZi.size() >= 2 }">
										<a
											href="<%=basePath%>listAlbumPhoto.do?id=${listZi.get(0).userAlbum.id }&blId=${blogUser.id}">
											<img src="<%=basePath %>${listZi.get(0).photo}" width="115"
											height="145" /> </a>
										<a
											href="<%=basePath%>listAlbumPhoto.do?id=${listZi.get(1).userAlbum.id }&blId=${blogUser.id}">
											<img src="<%=basePath %>${listZi.get(1).photo}" width="115"
											height="145" /> </a>
									</c:if>
									 <c:if test="${listZi.size() < 2 && listZi.size() > 0 }">
										<a href="<%=basePath%>listAlbumPhoto.do?id=${listZi.get(0).userAlbum.id }&blId=${blogUser.id}">
											<img src="<%=basePath %>${listZi.get(0).photo}" width="200"	height="200" /> </a>
									</c:if> 
					   </c:if>
					   <c:if test="${album == '2' }">
					       <p
								style="font-family: 'arial'; font-size: 20px; margin-top: 80px;text-align: center;">To be approved</p>
					   </c:if>
					   <c:if test="${album == '1' }">
					       <p
								style="font-family: 'arial'; font-size: 20px; margin-top: 80px;text-align: center;">Approved, not public</p>
					   </c:if>
					   <c:if test="${album == '0' }">
					       <p
								style="font-family: 'arial'; font-size: 20px; margin-top: 80px;text-align: center;">No Albums Yet</p>
					   </c:if>

				</div>

			</div>
			<!--会员头衔-->


			<!--会员头衔-->
			<div class="zyq">
				<div class="leftTitle">
					<h3>Resource Area</h3>
					<a href="<%=basePath %>attachMore/${blogUser.id }.html"
						class="blogMore">more</a>
				</div>
				<div class="zyqContent">
					<ul>

						<c:forEach items="${listAttachment }" var="item">
							<li><a href="<%=basePath %>web/Blog/AttachDetail/${item.id }.html">${item.attachName}</a>
							</li>
						</c:forEach>

					</ul>

				</div>

			</div>
			<!--会员头衔-->

			<!--会员头衔-->
			<div class="tdtw">


				<div
					style="border-bottom: 1px #e1e1e1 solid; width: 300px; height: 40px;">
					<div class="twTitle" id="tdtwBtn">
						<a>Questions</a>
					</div>

					<div class="hdTitle" id="tdhdBtn">
						<a>Answers</a>
					</div>
					<a href="<%=basePath%>questionMore/${blogUser.id }.html"
						class="more30-15" id="wendaANDtiwen">more</a>
				</div>



				<div class="tdtwContent" id="tdtwInfo">

					<ul>

						<c:forEach items="${question }" var="item" end="4">
							<li><a href="<%=basePath%>web/QandA/QuestionFind/${item.id}">${item.qSubject }</a></li>
						</c:forEach>
					</ul>


				</div>

				<div class="tdtwContent" style="display: none" id="tdhdInfo">

					<ul>

						<c:forEach items="${answer }" var="item" end="4">
							<li><a href="<%=basePath%>web/QandA/QuestionFind/${item.question.id}">${item.question.qSubject}									}</a>
							</li>
						</c:forEach>

					</ul>
				</div>
			</div>
			<!--会员头衔-->
			<!--会员头衔-->
	<%-- 		<div class="hybq">
				<div class="leftTitle">
					<h3>活跃标签</h3>





				</div>
				<div class="hybqContent">
					<table class="hybqInfo" border="0" width="100%" cellspacing="0"
						cellpadding="0">
						<tr class="firstTr">
							<th width="10%"></th>
							<th width="50%">标签名称</th>

							<th width="40%">所属联盟</th>
						</tr>

						<%
							int rank = 0;
							int rankCount = 0;
						%>
						<c:forEach items="${activeLabels }" var="item">
							<%
								if (rank < 4) {
										rank++;
									}
									rankCount++;
							%>



							<tr>
								<td><span class="rank<%=rank%>"><%=rankCount%></span></td>
								<td><a href="#">${item.label.labelName }</a></td>
								<td><a href="#">${item.label.board.boardName }${item.labelDesc }
								</a></td>
							</tr>
						</c:forEach>


					</table>
				</div>


			</div> --%>
			<!--会员头衔-->






			<!--会员头衔-->
			<!-- 			<div class="tdtw">


			</div> --> 
			<!--会员头衔-->

		</div>
		<!--left end-->
		<!--right --><div class="rightPart">
			
				
					
					
					
				
					<div class="articleInfo">
				<div class="article_Title">
					<h3>Resource Download</h3>
				</div>
				<div class="articleInfo_title">
					<h3>${attachment.attachName}</h3>
				</div>
				<div class="articleInfo_label">
					<div class="postDate">
						issued on <span>${attachment.attachTime }</span>
					</div>

					<div class="readCount">
						<img src="<%=basePath%>images/Forums/new/visitcount.png"
							width="16px" height="12px"> <em>${attachment.attachDownload }</em>
					</div>


					<div class="postBtn">
						<c:if test="${owner==1 }">
							<a href="<%=basePath %>web/Blog/deleteAttach_${attachment.id }"
								onclick="return confirm('Unable to retrieve once deleted.')"><span>Delete</span></a>
						</c:if>

					</div>


				</div>
				
				<div class="articleInfo_Content">
				<p>
						Resource Size：${attachment.attachSize }</p>
				<p>
						Resource Description：${attachment.attachDesc }</p>
				<p>downloads：${attachment.attachDownload}人</p>
				<p>Panacea：${attachment.lingdanWealth}</p>
				<p>Brick：${attachment.jinzhuanWealth}</p>
					<br>
				
			<%-- 	<form action="<%=basePath%>web/Blog/downloadAttachment"
						method="post">
						<input type="hidden" name="userId" value="${userInfo.id }" /> 
						<input type="hidden" name="attachId" value="${attachment.id }" />
						
						<button type="submit" class="submitButton" style="float:right">
						<fmt:message key="点击下载"></fmt:message>
						</button>
					
					</form> --%>
				<span style="float:right;">
				<a class="submitButton" href="<%=basePath%>web/Blog/Attach/${attachment.id}" onclick="return confirm('Note: the initial download will consume your brick or panaceas.')">Confirm Download

</a></span>
				</div>
				
			</div>

		<!--right -->

		<!--right -->


</div>


	</div>
	<!--mainbox-->

<!--footer-->

	<div class="footer">
		<h3>Copyright © 2014 JIE & C DEV(HK)CO L.&nbsp;&nbsp;All Rights
			Reserved.</h3>
	</div>
	<!--footer end-->
</body>
<script>
	var reMarks = {
		"print" : "<fmt:message key="您已经评价过这篇文章了，请不要重复评价"></fmt:message>"
	}
</script>
</html>
