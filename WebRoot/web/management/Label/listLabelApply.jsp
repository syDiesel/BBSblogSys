<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
								<span class="STYLE10">申请板块</span>
							</div>
						</th>
						
						<th width="10%" height="20" bgcolor="d3eaef" class="STYLE6">
							<div align="center">
								<span class="STYLE10">申请标签</span>
							</div>
						</th>
						<th width="15%" height="20" bgcolor="d3eaef" class="STYLE6">
							<div align="center">
								<span class="STYLE10">申请时间</span>
							</div>
						</th>


						<th width="12%" height="20" bgcolor="d3eaef" class="STYLE6">
							<div align="center">
								<span class="STYLE10">基本操作</span>
							</div>
						</th>
					</tr>

					<!-- 这里开始从数据库循坏取数据..jstl标签 -->
					<c:if test="${!empty listLabelApplyMsg}">
						<%
							int i = 1;
						%>
						<c:forEach items="${listLabelApplyMsg}" var="listLabelApplyMsg">


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
									<div align="center">${ listLabelApplyMsg.userInfo2.nickName}</div>
								</td>
								<td height="20" bgcolor="#FFFFFF" class="STYLE19">
									<div align="center">${ listLabelApplyMsg.messageText.msgSubject}</div>
								</td>
								<td height="20" bgcolor="#FFFFFF" class="STYLE19">
									<div align="center">${ listLabelApplyMsg.messageText.msgContent}</div>
								</td>
								<td height="20" bgcolor="#FFFFFF" class="STYLE19">
									<div align="center">${ listLabelApplyMsg.messageText.msgTime}</div>
								</td>
								

								<td height="20" bgcolor="#FFFFFF">
									<div class="STYLE21" align="center">
									    <a href="approveLabelApply.do?msgId=${listLabelApplyMsg.id }&record=${record}">批准</a>&nbsp;&nbsp;&nbsp;
										<a href="deleteLabelApply?msgId=${listLabelApplyMsg.id }&record=${record}">删除</a>
									</div>
								</td>
							</tr>

						</c:forEach>
					</c:if>
					<c:if test="${empty listLabelApplyMsg}">
						<tr>
							<td colspan="6" align="center" bgcolor="#EFF3F7">没有找到相应的记录</td>
						</tr>
					</c:if>
				</table>
			</td>
		</tr>
	</table>
	<c:if test="${!empty listLabelApplyMsg}">
	<div align="center" style="margin-top: 80px;">
		
		 <!-- 此处设置分页 -->
                         <c:if test="${record>1}">
						<a href="listLabelApply.do?record=${record-1}">上一页</a>
						</c:if>
						
					   	<c:if test="${allPage<=10}"> 
						<c:forEach begin="1" end="${allPage}" step="1" var="i">
						      &nbsp; <a href="listLabelApply.do?record=${i}"> 
						      <c:if test="${record==i}"> <b style="color:#3399CC;">${i}</b> </c:if> 
						      <c:if test="${record!=i}"> <b style="color:#999;">${i}</b> </c:if>
						      </a>&nbsp;
						</c:forEach>
						</c:if>
						
						<c:if test="${allPage>10}">
						<c:forEach begin="${record-5}" end="${record+4}" step="1" var="i">
						      &nbsp;<a href="listLabelApply.do?record=${i}">
						      <c:if test="${record==i}"> <b style="color:#3399CC;">${i}</b> </c:if> 
						      <c:if test="${record!=i}"> <b style="color:#999;">${i}</b> </c:if>
						      </a>&nbsp;
						</c:forEach>
						</c:if>
						
						
						 <c:if test="${record<allPage}">
						<a href="listLabelApply.do?record=${record+1}">下一页</a>
                         </c:if>
	</div>
	</c:if>
</body>
</html>
