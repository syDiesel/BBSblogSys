<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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

<title>search all</title>
<meta http-equiv="x-ua-compatible" content="ie=8" />
<link href="<%=basePath%>css/search.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>css/search/bootstrap.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>css/search/common.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>css/search/index.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>css/search/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>css/search/bootstrap-responsive.css"
	rel="stylesheet" type="text/css" />
<link href="<%=basePath%>css/search/main.css" rel="stylesheet"
	type="text/css" />
<link type="image/x-icon" href="<%=basePath%>img/bitbug_favicon.ico"
	rel="shortcut icon" />

<link href="<%=basePath%>css/headfoot.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>css/index_default.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>css/Index/index.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>css/button.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>css/qiantai/login.css" rel="stylesheet" type="text/css" />

<script type="text/javascript"
	src="<%=basePath%>js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/index/index.js"></script>
<script type="text/javascript" src="<%=basePath%>js/index/language.js"></script>
<script type="text/javascript" src="<%=basePath%>js/login_all.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<script type="text/javascript">

  		function reloadcode(){
  			
                    var verify=document.getElementById('code');
              
                verify.setAttribute('src','<%=basePath%>web/user/makeCertPic.jsp?id='
				+ new Date().getTime());
	}
	
	$(function(){
	    $("#searchMethod").change(function(){
	       var a =$("#searchMethod option:selected").val();
	       $("#txtSear_").val(a);
	    });
	});
	
	function checkl(obj){

	    var flag = obj.checked;
	    if(!flag){
	       document.getElementById("lab").value=0;
	        obj.val("0");
	    }else{
	     document.getElementById("lab").value=1;
	        obj.val("1");
	    }
	}
	function checks(obj){

	    var flag = obj.checked;
	    if(!flag){
	       document.getElementById("sub").value=0;
	        obj.val("0");
	    }else{
	     document.getElementById("sub").value=1;
	        obj.val("1");
	    }
	}
	function checkc(obj){

	    var flag = obj.checked;
	    if(!flag){
	       document.getElementById("con").value=0;
	        obj.val("0");
	    }else{
	     document.getElementById("con").value=1;
	        obj.val("1");
	    }
	}
	
	$(function(){
	
	    var value = $("#txtSear_").val();
	    searchMethod.options[value].selected = true;
	});
	
	/* $(document).ready(function(){
	    $(".submitButton").click(function(){
	          var value = $.trim($("#search_text2").val());
	          if(value == null || value == ""){
	               alert("input keyword(no space)");
	               return false;
	          }
	    });
	   
	}); */
</script>

</head>

<body style="font-family: Arial">
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
						<a href="<%=basePath%>login.html">Log in</a>
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
					action="<%=basePath%>search.do" >
					<DIV class="search-text-con2">
						<INPUT name="search" class="search-text2" id="q1" type="text"
							value="" autocomplete="off" path="q" placeholder="input keyword">
						<input type="hidden" id="txtSear" value="0" name="searchMethod" />
					</DIV>
					<DIV class="search-btn-con2">
						<INPUT class="search-btn2" type="submit" value="search">
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
		int i = 1;
	%>
	<%
		Date date = new Date();
		SimpleDateFormat f = new SimpleDateFormat("MMyydd");
		String nowTime = f.format(date);
	%>

	<DIV class="main-container">
		<DIV class="con-l">
			<UL class="search-type">
			</UL>
			<DIV class="search-from2" style="position: relative;">
				<FORM name="search_form_1" id="search_form_1"
					action="<%=basePath%>search.do?record=1&keyword=<%=request.getAttribute("keyword")%>&lab=${lab}&sub=${sub}&con=${con}">
					
					<select name="searchMethod" style="width:80px;float:left;height:32px;margin-left:50px;" id="searchMethod">
					   <option value="0">All</option>
					   <option value="1">Blog</option>
					   <option value="2">Forum</option>
					   <option value="3">Q&A</option>
					   <option value="4">Resource</option>
					</select>
					
					<DIV class="search-text-con2" style="width:350px;">
						<INPUT name="search" class="search-text2" id="search_text2" type="text"
							value="${keyword }" autocomplete="off" path="q"
							placeholder="input keyword" style="width:350px;">
                  <c:if test="${!empty searchMethod }">
				      <input type="hidden" id="txtSear_"
							value="${searchMethod }" name="searchMethod" />
				   </c:if>
				   <c:if test="${empty searchMethod }">
				      <input type="hidden" id="txtSear_"
							value="0" name="searchMethod" />
				   </c:if>
				   <c:if test="${!empty lab }">
				       <input type="hidden" value="${lab }" name="lab" id="lab">
				   </c:if>
				   <c:if test="${empty lab }">
				       <input type="hidden" value="1" name="lab" id="lab">
				   </c:if>
				   <c:if test="${!empty sub }">
				       <input type="hidden" value="${sub }" name="sub" id="sub">
				   </c:if>
				   <c:if test="${empty sub }">
				       <input type="hidden" value="1" name="sub" id="sub">
				   </c:if>
				   <c:if test="${!empty con }">
				       <input type="hidden" value="${con }" name="con" id="con">
				   </c:if>
				   <c:if test="${empty con }">
				       <input type="hidden" value="1" name="con" id="con">
				   </c:if>
					</DIV>
					<DIV class="search-btn-con2">
						<INPUT class="submitButton" type="Submit" value="search" style="line-height: 20px;width:120px;">
					</DIV>
					</FORM>
					<div class="search_xuanxiang">
					  <c:if test="${lab != '0' }">
					     <input type="checkbox" checked onclick="checkl(this)" style="margin-left:-525px;">tag&nbsp;&nbsp;&nbsp;
					  </c:if>
					  <c:if test="${lab == '0' }">
					     <input type="checkbox" onclick="checkl(this)" style="margin-left:-525px;">tag&nbsp;&nbsp;&nbsp;
					  </c:if>
					  <c:if test="${sub != '0' }">
					     <input type="checkbox" checked onclick="checks(this)">title&nbsp;&nbsp;&nbsp;
					  </c:if>
					  <c:if test="${sub == '0' }">
					     <input type="checkbox" onclick="checks(this)">title&nbsp;&nbsp;&nbsp;
					  </c:if>
					  <c:if test="${con != '0' }">
					     <input type="checkbox" checked onclick="checkc(this)">content
					  </c:if>
					  <c:if test="${con == '0' }">
					     <input type="checkbox" onclick="checkc(this)">content
					  </c:if>
					    
					    
					</div>
					
				<DIV class="search-addition-con">
                    <c:if test="${value=='0'}">
                        <SPAN> <a
						href="<%=basePath%>all.do?record=1&keyword=${keyword }&lab=${lab}&sub=${sub}&con=${con}" 
						class="submitButton_"  style="font-size:14px;">
						relevancy rank</a>
					</SPAN><SPAN> &nbsp;&nbsp;&nbsp;<a
						href="<%=basePath%>orderByAllTime.do?record=1&keyword=${keyword }&lab=${lab}&sub=${sub}&con=${con}"
						style="font-size:14px;color:#333;">
						time rank</a>
					</SPAN>
                    </c:if>
                    <c:if test="${value=='1'}">
                       <SPAN> <a
						href="<%=basePath%>all.do?record=1&keyword=${keyword }&lab=${lab}&sub=${sub}&con=${con}"
						style="font-size:14px;color:#333;">
						relevancy rank</a>
					</SPAN><SPAN> &nbsp;&nbsp;&nbsp;<a
						href="<%=basePath%>orderByAllTime.do?record=1&keyword=${keyword }&lab=${lab}&sub=${sub}&con=${con}" 
						class="submitButton_" style="font-size:14px;">time rank</a>
					</SPAN>
                    </c:if>
				</DIV>
			</DIV>
			<DIV class="add-tag-con" style="display: none;"></DIV>
			<div class="search_content">
			  <div class="searchContent_left">
			<c:if test="${!empty listAll }">
				<c:forEach items="${listAll }" var="listAll">
					<DIV class="search-list-con">
						<DL class="search-list">

							<c:if test="${listAll.type=='BK' }">
								<DT>
									<A href="<%=basePath%>web/Blog/article/<%=nowTime %>${listAll.typeId }"
										target="_blank"><%=i++%>、${listAll.subject }</A>
								</DT>
								<DD class="author-time">
									author:<A href="<%=basePath %>web/Blog/${listAll.nickName}"
										target="_blank">${listAll.nickName }</A>&nbsp;&nbsp;&nbsp;kind: blog&nbsp;&nbsp;&nbsp;time:${listAll.date
									} &nbsp;&nbsp;&nbsp;read&nbsp;${listAll.count }&nbsp;次
								</DD>
								<DD class="search-detail">${listAll.content }</DD>
								<DD class="search-link">
									<A href="<%=basePath%>web/Blog/article/<%=nowTime %>${listAll.typeId }"
										target="_blank"><%=basePath%>web/Blog/article/<%=nowTime%>${listAll.typeId }</A>
								</DD>
							</c:if>
							<c:if test="${listAll.type=='LT' }">
								<DT>
									<A href="<%=basePath %>toTopics?post_id=${listAll.typeId }"
										target="_blank"><%=i++%>、${listAll.subject }</A>
								</DT>
								<DD class="author-time">
									author:<A href="<%=basePath %>web/Blog/${listAll.nickName}"
										target="_blank">${listAll.nickName }</A>&nbsp;&nbsp;&nbsp;kind: post&nbsp;&nbsp;&nbsp;time:${listAll.date
									} &nbsp;&nbsp;&nbsp;reply&nbsp;${listAll.count }&nbsp;post
								</DD>
								<DD class="search-detail">${listAll.content }</DD>
								<DD class="search-link">
									<A href="<%=basePath %>toTopics?post_id=${listAll.typeId }"
										target="_blank"><%=basePath%>toTopics?post_id=${listAll.typeId
										}</A>
								</DD>
							</c:if>
							<c:if test="${listAll.type=='WD' }">
								<DT>
									<A
										href="<%=basePath %>web/QandA/QuestionFind/${listAll.typeId }"
										target="_blank"><%=i++%>、${listAll.subject }</A>
								</DT>
								<DD class="author-time">
									author:<A href="<%=basePath %>web/Blog/${listAll.nickName}"
										target="_blank">${listAll.nickName }</A>&nbsp;&nbsp;&nbsp;kind: Q&A&nbsp;&nbsp;&nbsp;time:${listAll.date
									}
								</DD>
								<DD class="search-detail">${listAll.content }</DD>
								<DD class="search-link">
									<A
										href="<%=basePath %>web/QandA/QuestionFind/${listAll.typeId }"
										target="_blank"><%=basePath%>web/QandA/QuestionFind/${listAll.typeId
										}</A>
								</DD>
							</c:if>
							<c:if test="${listAll.type=='ZY' }">
								<DT>
									<A href="<%=basePath%>web/Blog/Attach/${listAll.typeId }"
										target="_blank"><%=i++%>、${listAll.subject }</A>
								</DT>
								<DD class="author-time">
									author:<A href="<%=basePath %>web/Blog/${listAll.nickName}"
										target="_blank">${listAll.nickName }</A>&nbsp;&nbsp;&nbsp;kind: resource&nbsp;&nbsp;&nbsp;time:${listAll.date
									} &nbsp;&nbsp;&nbsp;download&nbsp;${listAll.count }&nbsp;次
								</DD>
								<DD class="search-detail">${listAll.content }</DD>
								<DD class="search-link">
									<A href="<%=basePath%>web/Blog/Attach/${listAll.typeId }"
										target="_blank"><%=basePath%>web/Blog/Attach/${listAll.typeId
										}</A>
								</DD>
							</c:if>
						</DL>
					</DIV>
				</c:forEach>
				<DIV class="csdn-pagination hide-set">
					<ul class="fenye">
						<br />
						<!------------------------------------------------------分页--------------------------------------------------->
						<c:choose>
							<c:when test="${record>1 }">
								<c:if test="${value=='0'}">
									<a
										href="<%=basePath%>all.do?record=1&keyword=<%=request.getAttribute("keyword")%>&lab=${lab}&sub=${sub}&con=${con}"
										style="text-decoration: none;color:#0c87c9;">Homepage
									</a>&nbsp;&nbsp;</c:if>
								<c:if test="${value=='1'}">
									<a
										href="<%=basePath%>orderByAllTime.do?record=1&keyword=<%=request.getAttribute("keyword")%>&lab=${lab}&sub=${sub}&con=${con}"
										style="text-decoration: none;color:#0c87c9;">Homepage
									</a>&nbsp;&nbsp;</c:if>
							</c:when>
							<c:otherwise>
								<a style="color:#0c87c9;">Homepage
								</a>&nbsp;&nbsp;</c:otherwise>
						</c:choose>

						<c:choose>
							<c:when test="${record>1 }">
								<c:if test="${value=='0'}">
									<a
										href="<%=basePath%>all.do?record=${record-1}&keyword=<%=request.getAttribute("keyword")%>&lab=${lab}&sub=${sub}&con=${con}"
										style="text-decoration: none;color:#0c87c9;">Page up
									</a>&nbsp;&nbsp;</c:if>
								<c:if test="${value=='1'}">
									<a
										href="<%=basePath%>orderByAllTime.do?record=${record-1}&keyword=<%=request.getAttribute("keyword")%>&lab=${lab}&sub=${sub}&con=${con}"
										style="text-decoration: none;color:#0c87c9;">Page up
									</a>&nbsp;&nbsp;</c:if>
							</c:when>
							<c:otherwise>
								<a style="color:#0c87c9;">Page up
								</a>&nbsp;&nbsp;</c:otherwise>
						</c:choose>

						${record}/${allPage} &nbsp;

						<c:choose>
							<c:when test="${record<allPage }">
								<c:if test="${value=='0'}">
									<a
										href="<%=basePath%>all.do?record=${record+1}&keyword=<%=request.getAttribute("keyword")%>&lab=${lab}&sub=${sub}&con=${con}"
										style="text-decoration: none;color:#0c87c9;">Page down
									</a>&nbsp;&nbsp;</c:if>
								<c:if test="${value=='1'}">
									<a
										href="<%=basePath%>orderByAllTime.do?record=${record+1}&keyword=<%=request.getAttribute("keyword")%>&lab=${lab}&sub=${sub}&con=${con}"
										style="text-decoration: none;color:#0c87c9;">Page down
									</a>&nbsp;&nbsp;</c:if>
							</c:when>
							<c:otherwise>
								<a style="color:#0c87c9;">Page down
								</a>&nbsp;&nbsp;</c:otherwise>
						</c:choose>

						<c:choose>
							<c:when test="${record<allPage }">
								<c:if test="${value=='0'}">
									<a
										href="<%=basePath%>all.do?record=${allPage}&keyword=<%=request.getAttribute("keyword")%>&lab=${lab}&sub=${sub}&con=${con}"
										style="text-decoration: none;color:#0c87c9;">Last page
									</a>&nbsp;&nbsp;</c:if>
								<c:if test="${value=='1'}">
									<a
										href="<%=basePath%>orderByAllTime.do?record=${allPage}&keyword=<%=request.getAttribute("keyword")%>&lab=${lab}&sub=${sub}&con=${con}"
										style="text-decoration: none;color:#0c87c9;">Last page
									</a>&nbsp;&nbsp;</c:if>
							</c:when>
							<c:otherwise>
								<a style="color:#0c87c9;">Last page
								</a>&nbsp;&nbsp;</c:otherwise>
						</c:choose>
					</ul>
				</DIV>
			</c:if>
			<center>
				<c:if test="${empty listAll }">
				   <c:if test="${!empty the_user }">
				       <div style="width:640px;height:400px;background-color: white;">
				         <div style="float:left;margin:20px 20px;">
							<a href="<%=basePath%>web/Blog/${the_user.nickName}"> <img
								src="<%=basePath %>${the_user.headImg}" width=120px height=120px>
							</a>
							<div style="font-size: 15px;">${the_user.nickName }</div>
						 </div>
						</div>
				   </c:if>
				   <c:if test="${empty the_user }">
				    <div style="width:640px;height:400px;background-color: white;">
					<img src="<%=basePath%>images/home/error.jpg" width=50px
						height=50px style="margin-top:80px;"/>
					<h4 style="font-family: serif;margin-top:20px;">
						no record found
					</h4>
					</div>
				  </c:if>
				</c:if>
			</center>
			</div>
		 </div>
		</DIV>
		<c:if test="${!empty listAll }">
		<div class="searchContent_right">
		   <h3 style="margin:20px 0;text-align: center;">search user</h3>
		     <c:if test="${!empty the_user }">
				         <div style="text-align: center;margin-top:40px;">
							<a href="<%=basePath%>web/Blog/${the_user.nickName}"> <img
								src="<%=basePath %>${the_user.headImg}" width=120px height=120px>
							</a>
							<div style="font-size: 15px;text-align: center;">${the_user.nickName }</div>
						 </div>
				   </c:if>
		</div></c:if>
	</DIV>
<!--footer-->

	<div class="footer">
		<h3>Copyright © 2014 JIE & C DEV(HK)CO L.&nbsp;&nbsp;All Rights Reserved.</h3>
	</div>
	<!--footer end-->

</body>
</html>
