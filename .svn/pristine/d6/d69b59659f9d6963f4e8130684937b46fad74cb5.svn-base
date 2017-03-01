<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager"%>
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

<title>hubu713</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script type="text/javascript">
	function url() {
		var s = document.getElementById("list").value;
		//window.open("listMsg.do?record="+s);
		location.href = "listMsg.do?record=" + s;
	}

	function go() {
		var s = document.getElementById("rs").value;
		var count = <s:property value="pageCount"/>;
		if (s == "")
			alert("请输入页码");
		else if (s <= count)
			location.href = "listMsg.do?record=" + s;
		else
			alert("超出最大页数！");
	}
</script>

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

</head>

<body>


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
														您当前的位置是：分类管理 -> 列出信息</span></td>
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
			<td align="center">
				<table width="95%" border="0" cellpadding="0" cellspacing="1"
					bgcolor="#a8c7ce">
					<tr>
						<th width="3%" height="20" bgcolor="d3eaef" class="STYLE6">
							<div align="center">
								<span class="STYLE10">序号</span>
							</div>
						</th>
						<th width="10%" height="20" bgcolor="d3eaef" class="STYLE6">
							<div align="center">
								<span class="STYLE10">申请人</span>
							</div>
						</th>
						<th width="10%" height="20" bgcolor="d3eaef" class="STYLE6">
							<div align="center">
								<span class="STYLE10">申请标签</span>
							</div>
						</th>
						<th width="15%" height="20" bgcolor="d3eaef" class="STYLE6">
							<div align="center">
								<span class="STYLE10">申请标签</span>
							</div>
						</th>
						<th width="55%" height="20" bgcolor="d3eaef" class="STYLE6">
							<div align="center">
								<span class="STYLE10">说明</span>
							</div>
						</th>

						<th width="12%" height="20" bgcolor="d3eaef" class="STYLE6">
							<div align="center">
								<span class="STYLE10">基本操作</span>
							</div>
						</th>
					</tr>

					<!-- 这里开始从数据库循坏取数据..jstl标签 -->
					<c:if test="${!empty pm.datas}">
						<%
							int i = 1;
						%>
						<c:forEach items="${pm.datas}" var="item">


							<tr>
								<td height="20" bgcolor="#FFFFFF" class="STYLE6">
									<div align="center">
										<span class="STYLE19"><%=i++%></span>
									</div>
									<div>
										<span class="STYLE19"></span>
									</div>
								</td>
								<td height="20" bgcolor="#FFFFFF" class="STYLE19">
									<div align="center" style="margin-left: 5px">${ item}
									</div>
								</td>
								<td height="20" bgcolor="#FFFFFF" class="STYLE19">
									<div align="center">${ item}</div>
								</td>
								<td height="20" bgcolor="#FFFFFF" class="STYLE19">
									<div align="center">${ item}</div>
								</td>
								<td height="20" bgcolor="#FFFFFF" class="STYLE19">
									<div align="center">${ item}</div>
								</td>

								<td height="20" bgcolor="#FFFFFF">
									<div class="STYLE21" align="center">
										<a href="web/management/Flag/list_${item.id }">批准</a>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;
										<a href="web/management/Flag/delete_${item.id }">删除</a>
									</div>
								</td>
							</tr>

						</c:forEach>
					</c:if>
					<c:if test="${empty pm.datas}">
						<tr>
							<td colspan="6" align="center" bgcolor="#EFF3F7">没有找到相应的记录</td>
						</tr>
					</c:if>
				</table>
			</td>
		</tr>
	</table>
	<c:if test="${!empty pm.datas}">
	<div align="center" style="margin-top: 80px;">
		<pg:pager url="web/management/Flag/list" items="${pm.total}"
			export="currentPageNumber=pageNumber" maxPageItems="15"
			maxIndexPages="15">
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
</body>
</html>
