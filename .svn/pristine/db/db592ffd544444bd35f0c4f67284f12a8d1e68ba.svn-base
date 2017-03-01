<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC"-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<html>

<style type="text/css">
<!--
body {
	margin-left: 3px;
	margin-top: 0px;
	margin-right: 3px;
	margin-bottom: 0px;
}

.STYLE1 {
	color: #e1e2e3;
	font-size: 12px;
}

.STYLE6 {
	color: #000000;
	font-size: 12;
}

.STYLE10 {
	color: #000000;
	font-size: 12px;
}

.STYLE19 {
	color: #344b50;
	font-size: 12px;
}

.STYLE21 {
	font-size: 12px;
	color: #3b6375;
}

.STYLE22 {
	font-size: 12px;
	color: #295568;
}
-->
</style>





<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发件箱</title>
<link type="text/css" href="<%=basePath%>css/index_default.css"
	rel="stylesheet" />
<link type="text/css" href="<%=basePath%>css/home.css" rel="stylesheet" />
<link type="text/css" href="<%=basePath%>css/home_search.css"
	rel="stylesheet" />
<link type="text/css" href="<%=basePath%>css/PMtoAll.css"
	rel="stylesheet" />
<script type="text/javascript"
	src="<%=basePath%>js/jquery-1.10.2.min.js">
					</script>
<script type="text/javascript" src="<%=basePath%>js/PrivateMsg/box.js">
					</script>
</head>
<body style="text-align:left;">




	<%-- <c:if test="${!empty session.userName}"> --%>
	<table width="100%" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td height="30">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td height="24" bgcolor="#353c44">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td>
										<table width="100%" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td width="6%" height="19" valign="bottom">
													<div align="center">
														<img src="<%=basePath%>images/houtai/tb.gif" width="14"
															height="14" />
													</div>
												</td>
												<td width="94%" valign="bottom"><span class="STYLE1">
														您当前的位置是：私信管理-> 查看私信</span></td>
											</tr>
										</table>
									</td>

								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<!--新私信--> <!--新建私信-->
				<div class=" col-content">
					<div class="private-new" style="display: block;">
						<div class="row nty-mas-rtop">
							<h3 class="noy-pl15">
								<i class="icon-envelope">&nbsp; </i>查看私信
							</h3>
						</div>
						<!--私信内容-->


						<div id="content_my_notice_content" class="main-content-page"
							style="display: block;">
							<ul class="main-content-list-small" id="c_notifyList">
								<c:if test="${empty pm.datas}">

									<div align="center">没有找到相应的记录</div>

								</c:if>
								<c:if test="${!empty pm.datas}">


									<c:forEach items="${ pm.datas}" var="item">
										<li onclick="blockDetails(${item.id })">
											<div class="main-content-list-message" id="title_${item.id }">
												<span class="main-content-list-notice-type"> <c:if
														test="${item.isRead ==0}">
														<i class="icon-notice-ru">&nbsp;&nbsp;&nbsp;&nbsp;</i>
													</c:if> <c:if test="${item.isRead ==1}">
														<i class="icon-notice-rd">&nbsp;&nbsp;&nbsp;&nbsp;</i>
													</c:if> &nbsp;&nbsp;${item.userInfo1.nickName}
												</span> <span class="main-content-list-title">
													${item.messageText.msgSubject} </span> <span
													class="main-content-list-date">
													${item.messageText.msgTime} </span>
											</div> 
										</li>
										<li>
											<div class="main-content-list-details" style="display: none;"
												id="details_${item.id }">
												<i class="icon-arrow-top"> </i>
												<p>${item.messageText.msgContent}</p>

											</div>
										</li>
									</c:forEach>
								</c:if>

							</ul>

							<span id="notify_state" class="loading-state"
								style="cursor: pointer; display: none;"> <img
								src="http://static.hdslb.com/images/loadinglit.gif"
								style="display: none;"> <b> 正在载入中... </b>
							</span>
							<ul class="page" id="notifyPageList" style="display: none;">
							</ul>
						</div>
						<!--私信内容结束-->
					</div>
					<div style="clear: both"></div>
					<c:if test="${!empty pm.datas}">
						<div align="center" style="margin-top: 80px;" class="art-pag">
							<pg:pager url="sendBox" items="${pm.total}"
								export="currentPageNumber=pageNumber" maxPageItems="10"
								maxIndexPages="10">
								<pg:first>
									<a href="${pageUrl}" mce_href="${pageUrl}">首页</a>
								</pg:first>
								<pg:prev>
									<a href="${pageUrl }" mce_href="${pageUrl }">上一页</a>
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
									<a href="${pageUrl }" mce_href="${pageUrl }">下一页</a>
								</pg:next>
								<pg:last>
									<a href="${pageUrl }" mce_href="${pageUrl }">尾页</a>
								</pg:last>
							</pg:pager>
						</div>
					</c:if>
				</div> <!-- -->





			</td>
		</tr>
	</table>

</body>

</html>