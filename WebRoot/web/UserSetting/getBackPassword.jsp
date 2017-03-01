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

<title>Get back password</title>

<meta http-equiv="x-ua-compatible" content="ie=8" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 <link rel="stylesheet" type="text/css" href="<%=basePath%>css/management/main.css">
<script type="text/javascript"
	src="<%=basePath%>js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/index/index.js"></script>
<script type="text/javascript" src="<%=basePath%>js/index/language.js"></script>
<script type="text/javascript" src="<%=basePath%>js/houtai/getBackPassword.js"></script>
<script type="text/javascript" src="<%=basePath%>js/login_all.js"></script>
<script type="text/javascript">

  
      function check()
      {
        var reason=$.trim(document.getElementById("reason").value);
        if(reason.length<=0)
          {
            alert("Please fill out the reason");
            return false;
          }else if(reason.lengtn>200)
          {
            alert("Count exceeds the limit");
            return false;
          }else{
            return true;
          }
          
          

      }
      
      var a ={"a":"<fmt:message key="请填写理由"></fmt:message>"};
	var a1 ={"a1":"<fmt:message key="字数超过限制"></fmt:message>"};
	
</script>


</head>
<link type="image/x-icon" href="<%=basePath%>img/bitbug_favicon.ico"
	rel="shortcut icon" />

<link href="<%=basePath%>css/headfoot.css" rel="stylesheet"
	type="text/css" />
	<link href="<%=basePath%>css/Forums1/post/board.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>css/index_default.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>css/Index/index.css" rel="stylesheet"
	type="text/css" />
	<link type="text/css" rel="stylesheet" href="<%=basePath%>css/button.css">
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

	<div class="mainBox1"  id="mainBox"
	style="width:1050px;min-height:500px;background:#fff;
	border-top:3px solid #087ec4;margin:10px auto;font-family:'微软雅黑';">
	<span style="float:left;margin:10px 20px;font-size:20px;
	font-weight:bold;color:#000;text-shadow:1px 1px 2px #999;">
	Get back password</span>
	<div class="user-info" style="width:60%;margin:100px auto;">
    
     		 <form action="updatePWDbyQuestion.do" method="post" id="regForm">
		  <table width="770" height="100" >
            <tr>

              <td width="97" height="51">User name： </td>            
              <td width="198">
              <input name="userName" type="text" 
              class="TextH20 errorInput " id="userName" 
              style="width:200px;height: 35px;border-radius: 5px;font-size:14px;" value=""    /></td>
              <td>&nbsp;&nbsp;&nbsp;<a id="findQuestion" class="submitButton">Next </a></td>  
            </tr>
            <tr><td colspan="3" id="nameError" style="font-size:12px;color:red;"></td></tr>
           </table>
           
           <table width="750" height="257" id="questionTable" style="display:none;">
            <tr>

              <td height="36" width="100">Question：</td>
              <td width="200">
              <select name="question" id="listQuestion" 
              style="width:200px;height: 35px;border-radius: 5px;font-size:14px;"></select>
              </td>
              <td width="450"></td>
           
            </tr>
            <tr>

              <td height="36" width="100">Answer：</td>
              <td width="200"><input name="answer" type="text" 
              class="TextH20 errorInput " id="text" 
              style="width:200px;height: 35px;border-radius: 5px;font-size:14px;" value=""   /></td>
              <td width="450"></td>
            </tr>
            
            <tr>

              <td height="36" width="100" >New password：</td>
              <td width="200"><input name="newpass1" type="password" class="TextH20 errorInput " id="newPWD1" 
             style="width:200px;height: 35px;border-radius: 5px;font-size:14px;" value="" ></td>

              <td width="450"><span class="errorTip"><label class="newPWD1" ></label></span></td>
            </tr>
            <tr>

              <td height="36" width="100">Confirm New Password：</td>
              <td width="200"><input name="newpass2" type="password" class="TextH20" id="newPWD2" 
              style="width:200px;height: 35px;border-radius: 5px;font-size:14px;" value="" ></td>

              <td width="450"><span class="errorTip"><label class="newPWD2" ></label></span></td>
            </tr> 
            
            <tr>
            <td colspan="3">
               <button id="toUpdatePWD" class="submitButton">Submit</button>
            </td>
            </tr>
            
          </table> 
         </form>
    
  
    
    
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
