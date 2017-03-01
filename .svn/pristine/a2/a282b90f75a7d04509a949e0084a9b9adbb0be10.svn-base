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
<title>Blog Homepage</title>
<meta http-equiv="x-ua-compatible" content="ie=8" />
<link type="image/x-icon" href="<%=basePath%>img/bitbug_favicon.ico"
	rel="shortcut icon" />


<link type="text/css" href="<%=basePath%>css/index_default.css"
	rel="stylesheet" />
<link type="text/css" href="<%=basePath%>css/headfoot.css"
	rel="stylesheet" />
<link href="<%=basePath%>css/Blog/blog_IndexMore.css" rel="stylesheet"
	type="text/css">
<link href="<%=basePath%>css/Forums1/post/board.css"  rel="stylesheet"
	type="text/css">
<link href="<%=basePath%>css/qiantai/login.css" rel="stylesheet" type="text/css" />

<script src="<%=basePath%>js/jquery-1.10.2.min.js"></script>
<script src="<%=basePath%>js/blog/home.js"></script>
<script type="text/javascript" src="<%=basePath%>js/index/language.js"></script>
<script type="text/javascript" src="<%=basePath%>js/Forum/board.js"></script>
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
		<!--left floor--> 
<c:if test="${isDraft!='yes' }">
		<ul class="BoardIndex">
		  <div class="boardSubject" >
		         <span class="font">Union Classification</span>
		  </div>
		 
		  <c:forEach end="${boards.size()}" begin="1" step="1" var="i">
              
              <c:if test="${boards.get(i-1).boardName!=boardName}">
		      <li class="boardBg" id="one" onmouseover="over('${i}')" onmouseout="out('${i}')">
		       <a href="<%=basePath%>web/Blog/index/${boards.get(i-1).boardName }.html">	
		      <div id="boardName" >	
		             
		       <span class="board_title_font">
		       <img src="<%=basePath%>images/Forums/new/${boards.get(i-1).boardLogo}.png" 
		       class="board_index" id="noSelectIndex${i}">
		       <img src="<%=basePath%>images/Forums/new/${boards.get(i-1).boardLogo}_1.png" 
		       class="board_index" id="selectIndex${i}" style="display:none;">
		       ${boards.get(i-1).boardName}</span>		       
		       
		       <div style="background:url(<%=basePath%>images/Forums/new/go.png);display:none;" class="go" id="go${i }"></div>		       
		      </div>
		       </a>
		      <div class="labelIndex">
		         <c:forEach end="${listAllLabel.get(i-1).size()}" begin="1" var="j" step="1">
		            <div class="everyLabel">
		            <a href="<%=basePath%>search.do?search=${listAllLabel.get(i-1).get(j-1).labelName}&searchMethod=0&lab=1&sub=1&con=1">
		            ${listAllLabel.get(i-1).get(j-1).labelName}
		            </a></div>
		         </c:forEach>
		      </div>
		      </li>
		      
		      </c:if> 
		      
		      
		      
		      <c:if test="${boards.get(i-1).boardName==boardName}">
		      <li class="boardBg" id="one" style="background:#087ec4;">
		       <a href="<%=basePath%>web/Blog/index/${boards.get(i-1).boardName }.html"
		         style="color:#fff;">	
		      <div id="boardName" >	
		             
		       <span class="board_title_font">
		       
		       <img src="<%=basePath%>images/Forums/new/${boards.get(i-1).boardLogo}_1.png" 
		       class="board_index" id="selectIndex${i}">
		       ${boards.get(i-1).boardName}</span>		       
		       
		       <div style="background:url(<%=basePath%>images/Forums/new/go.png);" class="go" id="go${i }"></div>		       
		      </div>
		       </a>
		      <div class="labelIndex">
		         <c:forEach end="${listAllLabel.get(i-1).size()}" begin="1" var="j" step="1">
		            <div class="everyLabel"><a href="<%=basePath%>search.do?search=${listAllLabel.get(i-1).get(j-1).labelName}&searchMethod=0&lab=1&sub=1&con=1">${listAllLabel.get(i-1).get(j-1).labelName}</a></div>
		         </c:forEach>
		      </div>
		      </li>
		      
		      </c:if> 
		      
		      
		    
		  </c:forEach>
		
		
		</ul>
</c:if>


		<!--left end-->
		<!--right -->
		<div class="InfoBox">
			<!--infoLeft-->
			<div class="leftInfo">
				<!--blogdt-->
				<div class="blogdt" style="min-height: 595px; max-height: 1350px;">
					<div class="blogdtTitle">
						<h3>
						
						<c:if test="${isDraft=='yes' }">
						Drafts
						</c:if>
						<c:if test="${isDraft!='yes' }">
						Blogger Dynamic
						</c:if>
						</h3>

						<!-- 			<a class="blogMore">more</a> -->
					</div>
					
					<div class="blogdtContent">

						<c:forEach items="${blogdt }" var="item">
							<!--infodetails-->
							<div class="blogdtInfo">
								<c:if test="${!empty  item.firstImg}">
									<div class="imgInfo">
										<img src="${item.firstImg}" />
									</div>
								</c:if>
								<%-- 							

<c:if test="${empty  item.firstImg}">
								<style>
									.textInfo{width:500px;} 
									.textTitle{width:480px;}
									.textTitle h3{width:480px;}
									.textContent{width:480px;}
									.textFunction{width:480px;}
									
								</style>
							</c:if> --%>
								<div
									class="textInfo <c:if test="${empty  

item.firstImg}">textInfoImged</c:if>">
									<div
										class="textTitle <c:if test="${empty  

item.firstImg}">textTitleImged</c:if>">
										<a
											href="<%=basePath

%>web/Blog/Draft/${item.id }"
											title="${item.subject }"><h3>${item.subject }</h3></a>
									</div>
									<div
										class="textContent <c:if test="${empty  

item.firstImg}">textContentImged</c:if>">
										<%--  ${fn:substringBefore

(item.blogContent,'<img')} --%>
										${ item.blogContent}
									</div>


								</div>
								<div
									class="textFunction <c:if test="${empty  

item.firstImg}">textFunctionImged</c:if>">

									<div class="author">
										<a>${item.blog.userInfo.nickName }</a>
									</div>
									<div class="readCount">Rading（${item.visited }）</div>
									<div class="postTime">${item.blogTime }</div>
									<div class="postLabel">
										<c:if test="${!empty  item.keywordA}">
											<a
												href="<%=basePath%>search.do?

searchMethod=0&search=${item.keywordA }"
												target="_blank"><label> ${item.keywordA }</label></a>
										</c:if>
										<c:if test="${!empty  item.keywordB}">
											<a
												href="<%=basePath%>search.do?

searchMethod=0&search=${item.keywordB }"
												target="_blank"><label> ${item.keywordB }</label></a>
										</c:if>
										<c:if test="${!empty   item.keywordC}">
											<a
												href="<%=basePath%>search.do?

searchMethod=0&search=${item.keywordC }"
												target="_blank"><label> ${item.keywordC }</label></a>
										</c:if>
									</div>

								</div>
							</div>
							<!--infodetails-->
						</c:forEach>

					</div>
					<style>
.page {
	text-align: center;
	height: 35px;
}

.page ul {
	margin: 0 auto;
	overflow: hidden;
	text-align:center;
}

.page ul li{
	display:inline-block;
}

.page a {
	float: left;
	margin-right: 5px;
	padding: 4px 8px 3px;
	height: 18px;
	border: 1px solid #CDCDCD;
	white-space: nowrap;
}

.page a:hover {
	border: 0;
	padding: 5px 9px 4px;
	color: #fff;
	background: #1C86EE;
}

.nowpage {
	color: #fff;
	background: #1C86EE;
	border: 0;
	padding: 5px 9px 4px;
}
</style>
					<div class="page">

						<ul>
							<li><a
								href="<%=basePath %>web/Blog/index/more.html?boardName=

${boardName }&page=1">Homepage</a></li>
							<c:if test="${page-1 >0}">
								<li><a
									href="<%=basePath %>web/Blog/index/more.html?

boardName=${boardName }&page=${page-1}">Page Up</a></li>
							</c:if>
							<c:if test="${page-3 >0}">
								<li><a
									href="<%=basePath %>web/Blog/index/more.html?

boardName=${boardName }&page=${page-3}">${page-3 }</a></li>
							</c:if>
							<c:if test="${page-2 >0}">
								<li><a
									href="<%=basePath %>web/Blog/index/more.html?

boardName=${boardName }&page=${page-2}">${page-2 }</a></li>
							</c:if>
							<c:if test="${page-1 >0}">
								<li><a
									href="<%=basePath %>web/Blog/index/more.html?

boardName=${boardName }&page=${page-1}">${page-1 }</a></li>
							</c:if>
							<li><a class="nowpage">${page }</a></li>
							<c:if test="${page<lastPage}">
								<li><a
									href="<%=basePath %>web/Blog/index/more.html?

boardName=${boardName }&page=${page+1}">${page+1 }</a></li>
							</c:if>
							<c:if test="${page+1<lastPage}">
								<li><a
									href="<%=basePath %>web/Blog/index/more.html?

boardName=${boardName }&page=${page+2}">${page+2 }</a></li>
							</c:if>
							<c:if test="${page+2<lastPage}">
								<li><a
									href="<%=basePath %>web/Blog/index/more.html?

boardName=${boardName }&page=${page+3}">${page+3 }</a></li>
							</c:if>
							<c:if test="${page<lastPage}">
								<li><a
									href="<%=basePath %>web/Blog/index/more.html?

boardName=${boardName }&page=${page+1}">Page Down</a></li>
							</c:if>
							<li><a
								href="<%=basePath %>web/Blog/index/more.html?boardName=

${boardName }&page=${lastPage}">Last Page</a></li>
						</ul>

					</div>
				</div>
				<!--blogdt-->
			</div>
			<!--infoLeft end-->






		</div>
		<!--right -->





	</div>
	<!--mainbox-->
<!--footer-->

	<div class="footer">
		<h3>Copyright © 2014 JIE & C DEV(HK)CO L.&nbsp;&nbsp;All Rights
			Reserved.</h3>
	</div>
	<!--footer end-->
</body>
</html>