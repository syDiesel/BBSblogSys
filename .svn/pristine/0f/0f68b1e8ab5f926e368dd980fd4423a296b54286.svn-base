<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<script src="<%=basePath%>js/jquery-1.10.2.min.js"></script>
<script src="<%=basePath%>js/updateRole.js"></script>


<script type="text/javascript">

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
														您当前的位置是：用户管理 -> 查看用户</span></td>
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
				<table width="85%" border="0" cellpadding="0" cellspacing="1"
					bgcolor="#a8c7ce">
					<tr>
						<th width="3%" height="20" bgcolor="d3eaef" class="STYLE6">
							<div align="center">
								<span class="STYLE10">序号</span>
							</div>
						</th>
						<th width="10%" height="20" bgcolor="d3eaef" class="STYLE6">
							<div align="center">
								<span class="STYLE10">板块名称</span>
							</div>
						</th>
						<th width="10%" height="20" bgcolor="d3eaef" class="STYLE6">
							<div align="center">
								<span class="STYLE10">文章总数</span>
							</div>
						</th>
						<th width="10%" height="20" bgcolor="d3eaef" class="STYLE6">
							<div align="center">
								<span class="STYLE10">今日文章</span>
							</div>
						</th>
						<th width="10%" height="20" bgcolor="d3eaef" class="STYLE6">
							<div align="center">
								<span class="STYLE10">
								
								<c:if test="${countType=='BK'}">
								浏览总数
								</c:if>
								
								<c:if test="${countType=='LT'}">
								评价总数
								</c:if>
								<c:if test="${countType=='WD'}">
								回答总数
								</c:if>
								
								</span>
							</div>
						</th>
						<th width="10%" height="20" bgcolor="d3eaef" class="STYLE6">
							<div align="center">
								<span class="STYLE10">
	<c:if test="${countType=='BK'}">
								今日总数
								</c:if>
								
								<c:if test="${countType=='LT'}">
								今日评价
								</c:if>
								<c:if test="${countType=='WD'}">
								今日答题
								</c:if>

</span>
							</div>
						</th>

						<th width="12%" height="20" bgcolor="d3eaef" class="STYLE6">
							<div align="center">
								<span class="STYLE10">基本操作</span>
							</div>
						</th>
					</tr>

					<!-- 这里开始从数据库循坏取数据..jstl标签 -->
					<c:if test="${!empty cmList}">
						<%
							int i = 1;
		
						%>
						<c:forEach items="${cmList}" var="item">


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
									<div align="center" style="margin-left: 5px">${ item.boardName}
									</div>
								</td>
								<td height="20" bgcolor="#FFFFFF" class="STYLE19">
									<div align="center">
						
				
${item.boardTotal }





</div> 
								</td>
								<td height="20" bgcolor="#FFFFFF" class="STYLE19">
									<div align="center">${item.boardToday }</div>
								</td>
								<td height="20" bgcolor="#FFFFFF" class="STYLE19">
									<div align="center">
								${item.boardVisited }
									
									
									</div>
								</td>
								<td height="20" bgcolor="#FFFFFF" class="STYLE19">
									<div align="center">
								${item.boardVisitedToday }
									 
									
									</div>
									
								</td>
								<td height="20" bgcolor="#FFFFFF">
									<div class="STYLE21" align="center">
									 
									  <input type="hidden" id="userId${item.boardId}" value=" ${item.boardId}"/>
									<a href="<%=basePath%>web/management/Count/labelCount?boardId=${item.boardId}&countType=${countType}">查看分类明细</a> 
								<%-- 	<input type="hidden" id="userId${ item.id}" value="${ item.id}"/>
										<a href="javascript:void(0)" onclick='return update()'>修改</a><!-- &nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;
										<a href="javascript:void(0)">删除</a> --> --%>
									</div>
								</td>
							</tr>

						</c:forEach>
					</c:if>
				</table>
			</td>
		</tr>
	</table>

</body>
</html>
