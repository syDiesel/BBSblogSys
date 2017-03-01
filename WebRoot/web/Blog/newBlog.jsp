<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java"
	import="java.util.*,com.bbsBlog.entity.ForumPost,java.text.SimpleDateFormat;"
	pageEncoding="utf-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Edit Articles</title>
<meta http-equiv="x-ua-compatible" content="ie=8" />
<link type="text/css" href="<%=basePath%>css/Forums1/MASK/mask.css"
	rel="stylesheet" />
<link type="text/css"
	href="<%=basePath%>css/Forums1/post/forum_post.css" rel="stylesheet" />
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

<script charset="utf-8" src="<%=basePath%>js/blog/yzm.js"></script>
<script charset="utf-8" src="<%=basePath%>js/blog/newBlog.js"></script>
<script charset="utf-8" src="<%=basePath%>js/blog/newLogFormat.js"></script>
<script type="text/javascript" src="<%=basePath%>js/checkLable.js"></script>
<script type="text/javascript" src="<%=basePath%>js/login_all.js"></script>

<script>
var editor;
	 KindEditor.ready(function(K) {
		editor = K.create('textarea[name="blogContent"]', {
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
			allowFileManager : true,
			autoHeightMode : false,
			
			 
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
		
	    K('input[name=submit]').click(function(e) {
            var imgs = editor.edit.iframe.get().contentWindow.document.body.getElementsByTagName('img');
            if (imgs.length > 0) {
                document.getElementById('hiddenImg').value=imgs[0].src;
            }
        });
		
		prettyPrint();
		

	}); 
	 
	
</script>
<script type="text/javascript">
function setImg(){

    var imgs = editor.edit.iframe.get().contentWindow.document.body.getElementsByTagName('img');
    if (imgs.length > 0) {
        document.getElementById('hiddenImg').value=imgs[0].src;
    }

    
    return checkNum();
}
function reloadcode(){
  			
  var verify=document.getElementById('code');
              
 verify.setAttribute('src','<%=basePath%>'+'web/management/makeCertPicSmall.jsp?id='
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
		<font>Issue Blog</font>
		<a href="<%=basePath %>web/Blog/Draft.html" 
		style="margin-top:2px;font-size:12px;line-height:20px;float:right;margin-right:15px;
		color:#fff;border:1px #fff solid;padding:2px 10px;border-radius:5px;">
		Drafts
	</a>
	</div>
	 
	<div class="post_main">

		<form name="example" id="blogNew" method="post"
			 enctype="multipart/form-data">
			<input type="hidden" name="userInfo.id" value="${loginUser.id }" />
			<input type="hidden" name="blogLogId" value="${draft.id }" /> <input
				type="hidden" name="hiddenImg" id="hiddenImg" />

			<table style="border-bottom: none">
				<tr>
					<td id="td1">Category of the article</td>
					<td id="td2">
						<div class="ajaxBoard">
							<select name="board.id" id="boardId"
								onchange="listLabelByBoardAjax()">
								<option value="-1" selected>Please select</option>
								<c:forEach items="${boards}" var="item">

									<option value="${item.id}"
										<c:if test="${requestScope.draft.board.id==item.id }">selected</c:if>>${item.boardName}</option>
								</c:forEach>
							</select>

							<c:if test="${isDraft=='yes' }">
								<a href="javascript:void(0)"
									onclick="example.action='<%=basePath%>web/Blog/draftUpdate?toStatus=1';example.submit();"
									style="margin-left: 20px; padding: 1px 12px;"
									name="draftUpdateToApply">
									<button class="submitButton" name="draftToApply" type="button">
										Apply for adding tag
									</button>
								</a>

							</c:if>

							<c:if test="${isDraft!='yes' }">

								<a href="javascript:void(0)"
									onclick="example.action='<%=basePath%>web/Blog/logToDraft?toStatus=1';example.submit();"
									style="margin-left: 20px; padding: 1px 12px;"
									name="draftUpdateToApply">
									<button class="submitButton" name="draftToApply"  type="button">
										Apply for adding tag
									</button>
								</a>




							</c:if>


						</div> <span id="errorBod"
						style="display: none; color: red; font-size: 10px">*Union cannot be empty</span>
					</td>
				</tr>
				<tr>
					<td id="td1">Tag</td>
					<td id="td2"><div id="ajaxLabel">
							<c:if test="${!empty requestScope.draft}">
								<c:forEach items="${labelList }" var="item">
									<label><input type='checkbox' value='${item.id }'
										name='labelId'
										<c:if test="${fn:contains(draftLabel,item.labelName)}">checked </c:if>></input>${item.labelName }</label>

								</c:forEach>
							</c:if>
					</div>  <span id="errorLab"
						style="display: none; color: red; font-size: 10px">*Tag cannot be empty</span>

					</td>

				</tr>




				<tr>
					<td id="td1">Type</td>
					<td id="td2"><select name="blogType" id="blogType"
						style="width: 90px;" onchange="return listBlogType()">
							<option value="0"
								<c:if test="${requestScope.draft.blogType==0 }">selected</c:if>>Please select</option>
							<option value="1"
								<c:if test="${requestScope.draft.blogType==1 }">selected</c:if>>Original</option>
							<option value="2"
								<c:if test="${requestScope.draft.blogType==2 }">selected</c:if>>Reprint</option>
					</select><span id="errorType"
						style="display: none; color: red; font-size: 10px">*Type cannot be empty</span></td>
				</tr>

				<tr>

					<td id="td1">Source of the article</td>
					<td id="td2">
						<div id="ajaxType"
							<c:if test="${requestScope.draft.blogType!=2 }">style="display:none"</c:if>>
							<input type="text" id="wzcc" name="wzcc" style="width: 200px;"
								value="${requestScope.draft.wzcc }" /></div>
									<span id="errorWzcc"
						style="display: none; color: red; font-size: 10px">*Source of the article cannot be empty</span>
					</td>
					
				

				</tr>

				<tr>
					<td id="td1">Reprints Permission</td>

					<td id="td2"><select name="sfzz" id="sfzz"
						style="width: 110px;">
							<option value="-1"
								<c:if test="${requestScope.draft.sfzz==-1 }">selected</c:if>>Please select</option>
							<option value="0"
								<c:if test="${requestScope.draft.sfzz==0 }">selected</c:if>>No</option>
							<option value="1"
								<c:if test="${requestScope.draft.sfzz==1 }">selected</c:if>>Yes</option>
					</select>
					<span id="errorSfzz"
						style="display: none; color: red; font-size: 10px">*Reprints permission cannot be empty</span>
					
					
					</td>

				</tr>

				<tr>
					<td id="td1">Article Title</td>
					<td id="td2"><input type="text" id="subject" name="subject"
						style="width: 600px;" value="${requestScope.draft.subject }" />
						
						<span id="errorSubject"
						style="display: none; color: red; font-size: 10px">*Article title cannot be empty</span>
						
						<span id="errorSubjectOutOfBound"
						style="display: none; color: red; font-size: 10px">*Title within 50words</span>
						</td>
				</tr>


				<tr>
					<td id="td1">Content </td>
					<td id="td2"><textarea id="blogContent" name="blogContent"
							cols="100" rows="8" style="width: 700px; height: 300px;">${requestScope.draft.blogContent }</textarea>
					<span id="blogContentTip"style="font-size: 10px">*Article with 1000-10000 words can score</span></br>
					<span id="errorContent"
						style="display: none; color: red; font-size: 10px">*Words out of limit</span>
					
					</td>
				</tr>
				<%
					Date date = new Date();
					SimpleDateFormat f = new SimpleDateFormat("MMyydd");
					String nowTime = f.format(date);
				%>

				<tr>

					<td id="td1">Verification Code</td>
					<td id="td2"><input name="chknumber" type="text"
						id="chknumber" maxlength="4" class="chknumber_input"
						style="width: 50px; height: 28px; float: left;" /> <img
						src="<%=basePath%>web/management/makeCertPicSmall.jsp?time=<%=date%> %>"
						id="code" onclick="reloadcode()"
						style="cursor: pointer; margin-left: 10px;"
						title="Load new image" /></td>
				</tr>
				<tr style="line-height: 40px;">
					<td id="td1" style="width: 145px;">&nbsp;</td>
					<td id="td2"><a href="javascript:void(0)"
						onclick="example.action='<%=basePath%>web/Blog/newLog';return setImg()"><button
								class="submitButton" name="SubmitBtn" type="button">
								Sumbit
							</button></a>
							
							
							<a href="javascript:void(0)"
						onclick="return form_reset()"><button
								class="submitButton" name="resetBtn" type="button">
								Reset
							</button></a>
							
							
						
							
							
						 <a href="javascript:history.go(-1)"><button
								class="submitButton" name="getBack" type="button">
								Back
							</button></a> <c:if test="${isDraft=='yes' }">
							<a href="javascript:void(0)"
								onclick="example.action='<%=basePath%>web/Blog/draftUpdate?toStatus=0';example.submit();"><button
									class="submitButton" name="draftUpdate" type="button">Save to the drafts</button></a>

						</c:if> <c:if test="${isDraft!='yes' }">
							<a href="javascript:void(0)"
								onclick="example.action='<%=basePath%>web/Blog/logToDraft?toStatus=0';example.submit();"><button
									class="submitButton" name="draft" type="button">Save to the drafts</button></a>
						</c:if></td>
				</tr>











			</table>
		</form>
		<table style="border-top: none;">

		</table>




	</div>

	<script>
		var print = {
			"codeError" : "<fmt:message key='验证码错误'></fmt:message>",
			"subjectOutOfBound" : "<fmt:message key='文章标题长度过长'></fmt:message>",
			"subjectNull" : "<fmt:message key='文章标题不能为空'></fmt:message>",
			"sfzz" : "<fmt:message key='请选择是否允许转载'></fmt:message>",
			"wzcc" : "<fmt:message key='请正确填写文章出处'></fmt:message>",
			"type" : "<fmt:message key='请选择正确的类型'></fmt:message>",
			"label" : "<fmt:message key='请选择正确的标签'></fmt:message>"

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
