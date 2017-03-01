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
<meta http-equiv="x-ua-compatible" content="ie=8" />
<title>User Opinions
</title>
<script type="text/javascript"
	src="<%=basePath%>js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/index/index.js"></script>
<script type="text/javascript" src="<%=basePath%>js/index/language.js"></script>


</head>
<link type="image/x-icon" href="<%=basePath%>img/bitbug_favicon.ico"
	rel="shortcut icon" />

<link href="<%=basePath%>css/headfoot.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>css/index_default.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>css/Index/index.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>css/qiantai/advice.css" rel="stylesheet"
	type="text/css" />
<link type="text/css" href="<%=basePath%>css/button.css"
	rel="stylesheet" />
<link href="<%=basePath%>css/qiantai/login.css" rel="stylesheet" type="text/css" />

<script type="text/javascript"
	src="<%=basePath%>js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/login.js"></script>
<script type="text/javascript" src="<%=basePath%>js/advice/advice.js"></script>
<script type="text/javascript" src="<%=basePath%>js/login_all.js"></script>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript">

  		function reloadcode(){
  			
                    var verify=document.getElementById('code');
              
                verify.setAttribute('src','<%=basePath%>web/user/makeCertPic.jsp?id='
				+ new Date().getTime());
	}

	function testjie(obj, maxlimit) {
		var len = byteLength(obj.value);
		if (len > maxlimit) {
			document.getElementById('maxlimitdiv').innerHTML = "Beyond <b style='color:red'>"
					+ parseInt(len - maxlimit + 1) + "</b> words";
		    $("#is_message").val("0");

		} else {
			document.getElementById('maxlimitdiv').innerHTML = "It can be input <b style='color:yellow'>"
					+ parseInt(maxlimit - len) + "</b> words";
			$("#is_message").val("1");
		}
	}

	function byteLength(sStr) {
		aMatch = sStr.match(/[^\x00-\x80]/g);
		return (sStr.length + (!aMatch ? 0 : aMatch.length));
	}
</script>
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body style="font-family: arial;">
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

	<center style="margin-top:20px;margin-bottom:20px;">

		<div
			style="width: 900px;border-top: #087EC4 solid 3px;margin: 0px auto; background-color: #fff; text-align: center;">
			<h2 style="height:40px;line-height:40px;text-align: left;">
				&nbsp;&nbsp;&nbsp;
				User Opinions
			</h2>
			<br> <br>
			<form action="advice.do?id=${userInfo.id}" method="post"
				enctype="multipart/form-data" style="display: inline-block;"
				id="form_advice">

				<table>
					<tr>
						<td class="td1">Message Type：</td>
						<td><select name="select_advice"
							style="float:left;font-size: 15px;font-family: 'Microsoft YaHei';">
								<option value="1">Suggestion</option>
								<option value="2">Report errors</option>
								<option value="3">Cooperation</option>
								<option value="4">Complaint</option>
								<option value="5">Others</option>
						</select>
						</td>
					</tr>
					<tr>
						<td class="td1">Message title：</td>
						<td><input type="text" style="width:250px;height:30px;" name="advice_subject">
						</td>
					</tr>
					<tr>
						<td class="td1" style="vertical-align: top;">Message details：</td>
						<td><textarea name="advice"
								placeholder="Click to add text information"
								style="width: 520px; height: 120px; font-size: 15px;" onkeyup="testjie(this, 600)"></textarea>
							<div class="count" id="maxlimitdiv">
								It can be input<b style="color: yellow;">600</b>words
							</div></td>
					</tr>
					
					<tr>
						<td class="td1">Verification Code：</td>
						<td><input type="text" name="mycode" id="mycode" class="td2"
							maxlength="4" style="width:100px;height:30px;float:left; ">
							<img src="<%=basePath%>web/user/makeCertPic.jsp" id="code"
							onclick="reloadcode()"
							style="cursor:pointer;height: 30px;margin-left:5px;float:left;"
							title="Load new image" />
							<p class="td3 code_info1"></p></td>
					</tr>
				</table>
				<%-- <div style="padding-top:15px;">
					<p style="float:left;font-size:15px;">
						<label><fmt:message key="验证码"></fmt:message>：</label> <input
							type="text" name="mycode" id="mycode" class="td2" maxlength="4"
							style="width:100px;height:30px; "> <img
							src="<%=basePath%>web/user/makeCertPic.jsp" id="code"
							onclick="reloadcode()"
							style="cursor:pointer;height: 30px;float:right;margin-left:5px;"
							title="<fmt:message key="看不清楚,换一张"></fmt:message>" />
					<p class="td3 code_info1"></p>
				</div> --%>
			</form><input type="hidden" id="is_message" value="1"/>
			<br /> <br> <input type="submit" class="submitButton_tijiao"
				name="submit" id="tijiao"
				value="Submit"
				style="float: left;margin-left:240px;width:80px;" /> <br> <br>
			<br>

		</div>
	</center>


	<!--footer-->

	<div class="footer">
		<h3>Copyright © 2014 JIE & C DEV(HK)CO L.&nbsp;&nbsp;All Rights
			Reserved.</h3>
	</div>
	<!--footer end-->
</body>
</html>
