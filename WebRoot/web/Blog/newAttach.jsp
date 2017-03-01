<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" import="java.util.*,com.bbsBlog.entity.ForumPost,java.text.SimpleDateFormat;" pageEncoding="utf-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path +  "/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Edit Articles</title>
<meta http-equiv="x-ua-compatible" content="ie=8" />

<link type="text/css" href="<%=basePath%>css/Forums1/MASK/mask.css" rel="stylesheet" />
<link type="text/css" href="<%=basePath%>css/Forums1/post/forum_post.css" rel="stylesheet" />
<link href="<%=basePath%>css/headfoot.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>css/index_default.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>css/Index/index.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>css/button.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>css/qiantai/login.css" rel="stylesheet" type="text/css" />

<script charset="utf-8" src="<%=basePath%>js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/index/index.js"></script>
<script type="text/javascript" src="<%=basePath%>js/index/language.js"></script>
<script charset="utf-8" src="<%=basePath%>kindeditor/kindeditor.js"></script>
<script charset="utf-8" src="<%=basePath%>kindeditor/lang/zh_CN.js"></script>
<script charset="utf-8"
	src="<%=basePath%>kindeditor/plugins/code/prettify.js"></script>

<script charset="utf-8" src="<%=basePath%>js/blog/attach-yzm.js"></script>
<script charset="utf-8" src="<%=basePath%>js/blog/newBlog.js"></script>
<script type="text/javascript" src="<%=basePath%>js/login_all.js"></script>
<script>
var editor;
	 KindEditor.ready(function(K) {
		editor = K.create('textarea[name="attachDesc"]', {
			cssPath : '<%=basePath%>kindeditor/plugins/code/prettify.css',
			uploadJson : '<%=basePath%>kindeditor/jsp/upload_json.jsp',
			fileManagerJson : '<%=basePath%>kindeditor/jsp/file_manager_json.jsp',
			//简单模式
			/* resizeType : 1,
			allowPreviewEmoticons : false,
			allowImageUpload : false,
			items : [
						'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
						'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
						'insertunorderedlist', '|', 'emoticons', 'image', 'link'],
 */
			//图片空间管理
			//allowFileManager : true,
			autoHeightMode : true,
			
			 
			afterCreate : function() {
				this.loadPlugin('autoheight');
				var self = this;
				K.ctrl(document, 13, function() {
					self.sync();
					document.forms['example'].submit();
				});
				K.ctrl(self.edit.doc, 13, function() {
					self.sync();
					document.forms['example'].submit();
				});
			},afterBlur: function(){this.sync();}
		});
		

		
		prettyPrint();
		

	}); 
	 
	
</script>
<script type="text/javascript">

  		function reloadcode(){
  			
                    var verify=document.getElementById('code');
              
                verify.setAttribute('src','<%=basePath%>web/management/makeCertPicSmall.jsp?id='
						+ new Date().getTime());
	}
</script>


</head>

<body style="text-align: center;font-family: arial;">
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

<div id="index">
<font>Upload Resources</font>
</div>
<div class="post_main">
    
    <form name="example" id="blogNew" method="post" action="newAttach"
			enctype="multipart/form-data">
    <table  style="border-bottom:none;">
    <tr>
       <td id="td1">Resourse</td>
       <td id="td2">
          <input type="file" name="file" style="width: 190px;"
					value="select file" />
	   </td>
    </tr>
    <tr>
       <td id="td1">Download Permission</td>
       <td id="td2">
       <select name="access" style="width: 100px;">

					<option value="0">Level 0</option>
					<c:if test="${userInfo.userLevel>0 }">
						<option value="1">Level 1</option>

						<c:if test="${userInfo.userLevel>1 }">
							<option value="2">Level 2</option>
							<c:if test="${userInfo.userLevel>2 }">
								<option value="3">Level 3</option>
								<c:if test="${userInfo.userLevel>3 }">
									<option value="4">Level 4</option>
									<c:if test="${userInfo.userLevel>4 }">
										<option value="5">Level 5</option>
										<c:if test="${userInfo.userLevel>5 }">
											<option value="6">Level 6</option>
											<c:if test="${userInfo.userLevel>6 }">
												<option value="7">Level 7</option>
											</c:if>
										</c:if>
									</c:if>
								</c:if>
							</c:if>
						</c:if>
					</c:if>
				</select><span style="color: red">(under which level they will pay) </span>
	 
	  </td>
    </tr>
    <tr>
       <td id="td1">Whether member higher than u neither see</td>
       <td id="td2">
       <select name="killHighLevel" style="width: 100px;">

					<option value="1">No</option>
					<option value="0">Yes</option>
				</select> <span style="color: red">(Note: This function needs a panacea. The default value is No)</span>
       </td>
    </tr>
    
    <tr>
       <td id="td1">Download Cost</td>
       <td id="td2">
      Brick
				<input type="text" name="jinzhuanWealth" style="width: 100px;"
					value="0"/>
				Panaceas
				<input type="text" name="lingdanWealth" style="width: 100px;"
					value="0"/>
       </td>
    </tr>
    
    <tr>
       <td id="td1">Attachment Name</td>
       <td id="td2">
      <input type="text" id="subject" name="attachName"
					style="width: 700px;" value="${uesrInfo.id }"/>
       </td>
    </tr>
    
    
    <tr>
       <td id="td1">Resourse Description</td>
       <td id="td2">
       <textarea id="blogContent" name="attachDesc" cols="100" rows="8"
					style="width: 700px; height: 200px;"></textarea>
	   </td>
    </tr>
    <%
						Date date = new Date();
							SimpleDateFormat f = new SimpleDateFormat("MMyydd");
							String nowTime = f.format(date);
					%>
    
    
   
     <tr>

        <td id="td1">Verification Code</td>
		<td id="td2">
		<input name="chknumber" type="text"
					id="chknumber" maxlength="4" class="chknumber_input"
					style="width: 50px;height:28px;float:left;" />
		<img src="<%=basePath%>web/management/makeCertPicSmall.jsp?time=<%=date%> %>" id="code"
		onclick="reloadcode()" style="cursor: pointer;margin-left:10px;" title="Load new image" />
		</td>
        </tr>
         <tr style="line-height:40px;">
        <td id="td1" style="width:145px;">
        &nbsp;
        </td>
        <td id="td2">
			<button class="submitButton" name="button" onclick="return checkNum()">
				Submit
			</button>
			<a href="javascript:void(0)"
						onclick="return form_reset()"><button
								class="submitButton" name="resetBtn" type="button">
								Reset
							</button></a>
			<a href="javascript:history.go(-1)"><button class="submitButton"
					name="getBack">
					Back
				</button></a>
        </td>
        </tr>
    </table>
</form>
<table style="border-top:none;">
        
       
</table>    
    
    
    


</div>

<script>

var print = {"codeError":"<fmt:message key='验证码错误'></fmt:message>",
		"subjectOutOfBound":"<fmt:message key='文章标题长度过长'></fmt:message>",
		"subjectNull":"<fmt:message key='文章标题不能为空'></fmt:message>",
		"sfzz":"<fmt:message key='请选择是否允许转载'></fmt:message>",
		"wzcc":"<fmt:message key='请正确填写文章出处'></fmt:message>",
		"type":"<fmt:message key='请选择正确的类型'></fmt:message>",
		"label":"<fmt:message key='请选择正确的标签'></fmt:message>"
			
		};


</script>
	

<!--footer-->

	<div class="footer">
		<h3>Copyright © 2014 JIE & C DEV(HK)CO L.&nbsp;&nbsp;All Rights
			Reserved.</h3>
	</div>
	<!--footer end-->
  </body>
</html>
