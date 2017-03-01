<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
<meta http-equiv="x-ua-compatible" content="ie=8" />
    <title>login</title> 
    
    <link type="text/css" href="<%=basePath%>css/index_default.css" rel="stylesheet" />
	<link href="<%=basePath%>css/headfoot.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>css/qiantai/login.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="<%=basePath%>js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/houtai/login.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/index/language.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/login_all.js"></script>
    
    
   <link type="text/css" rel="stylesheet" href="<%=basePath%>css/personInfo/basic.css">
   <link type="text/css" rel="stylesheet" href="<%=basePath%>css/NewUser/login.css">
   
   <link type="image/x-icon" href="<%=basePath%>img/bitbug_favicon.ico"
	rel="shortcut icon" />

   <link href="<%=basePath%>css/Index/index.css" rel="stylesheet"
	type="text/css" />
	<link href="<%=basePath%>css/qiantai/login.css" rel="stylesheet" type="text/css" />
	
	<script type="text/javascript">

  		function reloadcode(){
  			
                    var verify=document.getElementById('code');
              
                verify.setAttribute('src','<%=basePath%>web/user/makeCertPic.jsp?id='+new Date().getTime());
        }      
       
	</script>

  </head>
 
 
  <body style="text-align:center;font-family: arial;"  <c:if test="${JihuoStatus=='success' }">onload="alert('successful activation, you can login now!！')" </c:if>>
  <input type="hidden" id="basePath" value="<%=basePath%>" / >
  
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
<div id="content" style="background:#fff;margin-bottom:30px;margin-top:20px;display:inline-block;">
  <div class="mod-setting clearfix" style="border:0px;">
 <div class="login-part">
              <h3 style="font-size:25px;height:40px;margin-top:45px;margin-left:30px;text-align:left;">
                                                                            Login</h3>
                  <span class="login_head_right" style="margin-top:-30px;margin-left:180px;">
              <span class="login_head_right_none">No Account</span>&nbsp;&nbsp;&nbsp;<a href="<%=basePath%>isAgree.do">Register</a>
          </span>
              <div class="user-info">
                <div class="user-pass">
                 <form action="<%=basePath %>login.do" method="post">
                   <table>
                      <tr>
                         <td class="td1" style="font-size: 14px;">User Name</td>
                         <td class="td2">
                          <input name="userName" id="username" tabindex="2" class="user-name"
                          value="" autocomplete="off" type="text">
					     </td>
                          <td class="td3"><span class="username_info1"></span></td>
                      </tr>
                      
                      <tr>
                         <td class="td1" style="font-size: 14px;">Cipher</td>
                         <td class="td2">
                         <input name="password" id="password" tabindex="2" class="pass-word"
                          value="" autocomplete="off" type="password"></td>
                          <td class="td3"><span class="password_info1"></span></td>
                      </tr>        
                     <%--  <tr>
                         <td class="td1">验证码</td>
                         <td class="td2">
                        <input type="text" name="mycode" id="mycode" maxlength="4" >
					     <img src="<%=basePath%>web/user/makeCertPic.jsp" id="code" onclick="reloadcode()"></td>
                          <td class="td3"><span class="code_info1"></span></td>
                      </tr> --%>

                   </table>
                    
                     <input style="margin-left:-170px;" class="login_but" id="toLogin" accesskey="l" value="login" tabindex="5" type="submit">
                    <!--  <span class="login_span" style="padding-left:60px;"><input type="checkbox" name="">保持登录</span> -->
                     <span class="login_span"><a href="<%=basePath%>ToGetBackPwd.do">Forget Cipher？</a></span>
                  </form>
                  <div class="login_other_">
           <!-- <p>login other way</p>
           <div style="width:380px;height:80px;padding-top:20px;">
               <button class="login_sina_"></button>
               <button class="login_qq_"></button>
           </div> -->
        </div>
                 
                  
                </div>
  </div>
</div>
</div>
<!--main_body end-->
</div>
<!--main end-->
	  
<!--footer-->

	<div class="footer">
		<h3>Copyright © 2014 JIE & C DEV(HK)CO L.&nbsp;&nbsp;All Rights Reserved.</h3>
	</div>
	<!--footer end-->
     
</body>
  </body>
</html>
