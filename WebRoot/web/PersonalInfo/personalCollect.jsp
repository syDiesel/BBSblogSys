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

<title>personal favorite</title>

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
<script type="text/javascript" src="<%=basePath%>js/newPersonalInfo/addFriend.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/Personal/personalCollect.js"></script>
<script type="text/javascript" src="<%=basePath%>js/login_all.js"></script>
<script type="text/javascript">
	function check() {
		var reason = $.trim(document.getElementById("reason").value);
		if (reason.length <= 0) {
			alert("write reason");
			return false;
		} else if (reason.lengtn > 200) {
			alert("exceeding limit");
			return false;
		} else {
			return true;
		}

	}

	
</script>


</head>
<link type="image/x-icon" href="<%=basePath%>img/bitbug_favicon.ico"
	rel="shortcut icon" />

<link href="<%=basePath%>css/newPersonalInfo/head.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>css/newPersonalInfo/personalBlog.css"
	rel="stylesheet" type="text/css" />

<link href="<%=basePath%>css/index_default.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>css/Index/index.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>css/button.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>css/qiantai/login.css" rel="stylesheet" type="text/css" />


<body style="font-family:Arial,verdana,tahoma;">
<!---------------------------login_begin  ------------------------->
<div id="main_login" class="main_login">
  </div>
  <div class="login_div" id="login_div">
        <div class="login_head">
          <h1>Login</h1>
          <span class="login_head_right">
              <span class="login_head_right_none">No Account</span>&nbsp;&nbsp;&nbsp;<a href="<%=basePath%>isAgree.do">Register</a>
          </span>
        </div>
        <div class="login_form">
           <form action="<%=basePath %>login.do" method="post">
            <input type="hidden" value="" id="login_href" name="login_href">
              <table>
                  <tr>
                     <td>
                         <input type="text" name="userName" placeholder="User Name" class="login_td">
                     </td>
                  </tr>
                  <tr>
                     <td>
                         <input type="password" name="password" placeholder="Cipher" class="login_td">
                     </td>
                  </tr>
                  <tr>
                     <td>
                          <input class="login_but" accesskey="l" value="Login" tabindex="5" type="submit">
                          <!-- <span class="login_span"><input type="checkbox" name="">in login</span> -->
                          <span class="login_span"><a href="<%=basePath%>ToGetBackPwd.do">Forget Cipher？</a></span>
                     </td>
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
				<!-- <a href="javascript:void(0)">contact us</a> -->
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

												<span>Level:</span>

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
												class="icon-logout"></span>
											</a>
										</div>

									</div>

								</div>
							</li>


							<span class="ban">&nbsp;</span>
							<li style="height: 30px;"><div class="config">
									<a href="<%=basePath%>/web/PrivateMsg/RecBox"><span
										class="icon-msg"></span><em>${newMsgCount }</em>
									</a>

								</div>
							</li>
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
				<a href="#"><img src="<%=basePath%>img/Index-logo.png" />
				</a>
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
				<li><a href="<%=basePath%>toIndexHome">Frontpage</a>
				</li>
				<li><a href="<%=basePath%>web/Blog/index.html">Blog</a>
				</li>
				<li><a href="<%=basePath%>listPostByBoard">Forum</a>
				</li>
				<li><a href="<%=basePath%>web/QandA/Home.html">Q & A</a>
				</li>
				<li><c:if test="${userInfo.role.id!=1 }">
						<a href="<%=basePath%>contact.do">Service Center</a>
					</c:if> <c:if test="${userInfo.role.id==1 }">
						<a href="<%=basePath%>toManagement">Supervision</a>
					</c:if>
				</li>
				<li><a href="<%=basePath%>faq.do">Regulation</a>
				</li>
			</ul>
		</div>
		<!--nav end-->
		<!--pic-->
		<div class="Logo_pic">
			<div class="head_info1">
				<table class="info_table">
					<tr>
						<td colspan="5" class="info_name">${blogUser.nickName}</td>
					</tr>
					<tr>
						<td class="info_level"><c:forEach begin="1"
								end="${blogUser.userLevel}" step="1">
								<img src="<%=basePath%>images/Forums/new/star1.png" width="10px"
									height="10px" />
							</c:forEach> <c:forEach begin="${blogUser.userLevel+1}" end="7" step="1">
								<img src="<%=basePath%>images/Forums/new/star2.png" width="10px"
									height="10px" />
							</c:forEach>
						</td>
						<td class="info_td1">Flower:<em>${blogUser.xianhua}</em>
						</td>
						<td class="info_td1">Respect:<em>${blogUser.yangmu}</em>
						</td>
						<td class="info_td1">Brick:<em>${blogUser.jinzhuan}</em>
						</td>
						<td class="info_td1">Panacea:<em>${blogUser.lingdan}</em>
						</td>
					</tr>
				</table>

				<c:if test="${userInfo!=null&&userInfo.id!=blogUser.id }">
				<div class="focus_Message">
					<a href="javascript:void(0);" id="info_addFriend">
					<c:if test="${isFriend==false}">Follow</c:if>
					<c:if test="${isFriend==true}">Unfollow</c:if>
					</a>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="hidden" value="${blogUser.id}" id="blogUser_id">
					<input type="hidden" value="<%=basePath%>" id="basePath">
					<a href="<%=basePath %>web/Blog/receiver.do?id=${blogUser.id}">Mail</a>
				</div>
				</c:if>
			</div>
			<div class="head_img">
				<img src="<%=basePath%>${blogUser.headImg}">
			</div>
		</div>

		<div class="personal_index">
			<ul>
				<li><a href="<%=basePath%>u/detail/${blogUser.id}.html">Personal</a>
				</li>
				<li><a href="<%=basePath%>auditShow/${blogUser.id }.html">Friends</a>
				</li>
				<li><a href="<%=basePath%>listAlbum.do?id=${blogUser.id }">Album</a>
				</li>
				<li><a href="<%=basePath %>permission.do?page=${page}&blId=${blogUser.id}">Aptness</a>
				</li>
				<li><a href="<%=basePath%>blogMore/${blogUser.id }.html">Blog</a>
				</li>
				<li><a href="<%=basePath%>forumMore/${blogUser.id }.html">Forum</a>
				</li>
				<li><a href="<%=basePath%>questionMore/${blogUser.id }.html">Q & A</a>
				</li>
				<li><a href="<%=basePath%>collectMore/${blogUser.id }.html">Save</a>
				</li>
				<li><a href="<%=basePath%>attachMore/${blogUser.id }.html">Share</a>
				</li>
			</ul>
		</div>

		<!--pic end-->
	</div>
	<!-- head end -->

	<%
		Date date = new Date();
		SimpleDateFormat f = new SimpleDateFormat("MMyydd");
		String nowTime = f.format(date);
	%>


	<div class="blog_main">
		<div class="blog_title">
			<h3>personal favorite</h3>
			<div class="title_right">
				<ul>
					<li><a href="javascript:void(0)" id="collect_blog">blog favorite</a>&nbsp;|&nbsp;</li>
					<li><a href="javascript:void(0)" id="collect_question">Q&A favorite</a>&nbsp;|&nbsp;</li>
				</ul>
			</div>
		</div>
		<input type="hidden" name="value_collect" value="${value_collect}" id="choose_collect">
		<br>
		<!-------------------------------------博客收藏 -------------------------------->
		<div class="interest_blog_Info interest_block" id="collect_blogContent">
			<div class="interest_blog_Info_left ">
				<div class="blog_content">
					<table class="interest_blog_Info_left_Info" border="0"
						cellspacing="0" cellpadding="0" width="100%">
						<tr class="tr1">
							<th width="45%">title</th>
							<th width="30%">time</th>
							<th width="25%">favorite</th>
						</tr>
						<c:if test="${!empty fav }">
							<c:forEach items="${fav}" var="item" end="14">
								<tr>
									<td style="text-align:left;"><a href="${item.blogUrl}">${item.blogLog.subject
											}</a>
									</td>
									<td>${item.time }</td>
									<td>${item.id }</td>
								</tr>
							</c:forEach>
						</c:if>
					</table>
				</div>
				<!-- fenye -->
				<c:if test="${!empty fav }">
					<div class="page">
						<ul>
							<li><a
								href="<%=basePath %>collectMore/${blogUser.id }.html?page=1&page1=${page1}&value_collect=0">Homepage</a>
							</li>
							<c:if test="${page-1 >0}">
								<li><a
									href="<%=basePath %>collectMore/${blogUser.id }.html?page=${page-1}&page1=${page1}&value_collect=0">Page up</a>
								</li>
							</c:if>
							<c:if test="${page-3 >0}">
								<li><a
									href="<%=basePath %>collectMore/${blogUser.id }.html?page=${page-3}&page1=${page1}&value_collect=0">${page-3
										}</a></li>
							</c:if>
							<c:if test="${page-2 >0}">
								<li><a
									href="<%=basePath %>collectMore/${blogUser.id }.html?page=${page-2}&page1=${page1}&value_collect=0">${page-2
										}</a></li>
							</c:if>
							<c:if test="${page-1 >0}">
								<li><a
									href="<%=basePath %>collectMore/${blogUser.id }.html?page=${page-1}&page1=${page1}&value_collect=0">${page-1
										}</a></li>
							</c:if>
							<li><a class="nowpage">${page }</a></li>
							<c:if test="${page<lastPage}">
								<li><a
									href="<%=basePath %>collectMore/${blogUser.id }.html?page=${page+1}&page1=${page1}&value_collect=0">${page+1
										}</a></li>
							</c:if>
							<c:if test="${page+1<lastPage}">
								<li><a
									href="<%=basePath %>collectMore/${blogUser.id }.html?page=${page+2}&page1=${page1}&value_collect=0">${page+2
										}</a></li>
							</c:if>
							<c:if test="${page+2<lastPage}">
								<li><a
									href="<%=basePath %>collectMore/${blogUser.id }.html?page=${page+3}&page1=${page1}&value_collect=0">${page+3
										}</a></li>
							</c:if>
							<c:if test="${page<lastPage}">
								<li><a
									href="<%=basePath %>collectMore/${blogUser.id }.html?page=${page+1}&page1=${page1}&value_collect=0">Page down</a>
								</li>
							</c:if>
							<li><a
								href="<%=basePath %>collectMore/${blogUser.id }.html?page=${lastPage}&page1=${page1}&value_collect=0">Last page</a>
							</li>
						</ul>

					</div>
				</c:if>
			</div>
		</div>
		
		<!-------------------------------------问答收藏 -------------------------------->
		
		<div class="interest_blog_Info interest_block" id="collect_questionContent">
			<div class="interest_blog_Info_left ">
				<div class="blog_content">
					<table class="interest_blog_Info_left_Info" border="0"
						cellspacing="0" cellpadding="0" width="100%">
						<tr class="tr1">
							<th width="45%">title</th>
							<th width="30%">time</th>
							<th width="25%">favorite</th>
						</tr>
						<c:if test="${!empty listQAFavor }">
							<c:forEach items="${listQAFavor}" var="item" end="14">
								<tr>
									<td style="text-align:left;"><a href="<%=basePath%>web/QandA/QuestionFind/${item.question.id }">${item.question.getQSubject()
											}</a>
									</td>
									<td>${item.question.getQTime() }</td>
									<td>${item.id }</td>
								</tr>
							</c:forEach>
						</c:if>
					</table>
				</div>
				<!-- fenye -->
				<c:if test="${!empty listQAFavor }">
					<div class="page">
						<ul>
							<li><a
								href="<%=basePath %>collectMore/${blogUser.id }.html?page1=1&page=${page}&value_collect=1">Homepage</a>
							</li>
							<c:if test="${page1-1 >0}">
								<li><a
									href="<%=basePath %>collectMore/${blogUser.id }.html?page1=${page1-1}&page=${page}&value_collect=1">Page up</a>
								</li>
							</c:if>
							<c:if test="${page1-3 >0}">
								<li><a
									href="<%=basePath %>collectMore/${blogUser.id }.html?page1=${page1-3}&page=${page}&value_collect=1">${page1-3
										}</a></li>
							</c:if>
							<c:if test="${page1-2 >0}">
								<li><a
									href="<%=basePath %>collectMore/${blogUser.id }.html?page1=${page1-2}&page=${page}&value_collect=1">${page1-2
										}</a></li>
							</c:if>
							<c:if test="${page1-1 >0}">
								<li><a
									href="<%=basePath %>collectMore/${blogUser.id }.html?page1=${page1-1}&page=${page}&value_collect=1">${page1-1
										}</a></li>
							</c:if>
							<li><a class="nowpage">${page1 }</a></li>
							<c:if test="${page1<lastPage1}">
								<li><a
									href="<%=basePath %>collectMore/${blogUser.id }.html?page1=${page1+1}&page=${page}&value_collect=1">${page1+1
										}</a></li>
							</c:if>
							<c:if test="${page1+1<lastPage1}">
								<li><a
									href="<%=basePath %>collectMore/${blogUser.id }.html?page1=${page1+2}&page=${page}&value_collect=1">${page1+2
										}</a></li>
							</c:if>
							<c:if test="${page1+2<lastPage1}">
								<li><a
									href="<%=basePath %>collectMore/${blogUser.id }.html?page1=${page1+3}&page=${page}&value_collect=1">${page1+3
										}</a></li>
							</c:if>
							<c:if test="${page1<lastPage1}">
								<li><a
									href="<%=basePath %>collectMore/${blogUser.id }.html?page1=${page1+1}&page=${page}&value_collect=1">Page down</a>
								</li>
							</c:if>
							<li><a
								href="<%=basePath %>collectMore/${blogUser.id }.html?page1=${lastPage1}&page=${page}&value_collect=1">Last page</a>
							</li>
						</ul>

					</div>
				</c:if>
			</div>
		</div>
	</div>

	<br>
<!--footer-->

	<div class="footer">
		<h3>Copyright © 2014 JIE & C DEV(HK)CO L.&nbsp;&nbsp;All Rights Reserved.</h3>
	</div>
	<!--footer end-->
</body>
</html>
