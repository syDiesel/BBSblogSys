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
								<span class="STYLE10">用户昵称</span>
							</div>
						</th>
						<th width="10%" height="20" bgcolor="d3eaef" class="STYLE6">
							<div align="center">
								<span class="STYLE10">用户账号</span>
							</div>
						</th>
						<th width="10%" height="20" bgcolor="d3eaef" class="STYLE6">
							<div align="center">
								<span class="STYLE10">E-mail</span>
							</div>
						</th>
						<th width="5%" height="20" bgcolor="d3eaef" class="STYLE6">
							<div align="center">
								<span class="STYLE10">性别</span>
							</div>
						</th>
						<th width="10%" height="20" bgcolor="d3eaef" class="STYLE6">
							<div align="center">
								<span class="STYLE10">用户身份</span>
							</div>
						</th>
						
						<th width="10%" height="20" bgcolor="d3eaef" class="STYLE6">
							<div align="center">
								<span class="STYLE10">禁言时间</span>
							</div>
						</th>

						<th width="12%" height="20" bgcolor="d3eaef" class="STYLE6">
							<div align="center">
								<span class="STYLE10">基本操作</span>
							</div>
						</th>
					</tr>

					<!-- 这里开始从数据库循坏取数据..jstl标签 -->
					<c:if test="${!empty foundUsers}">
						<%
							int i = 1;
						%>
						<c:forEach items="${foundUsers}" var="item">
<c:if test = "${item.userName!='admin' }">

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
									<div align="center" style="margin-left: 5px">${ item.nickName}
									</div>
								</td>
								<td height="20" bgcolor="#FFFFFF" class="STYLE19">
									<div align="center">${ item.userName}</div>
								</td>
								<td height="20" bgcolor="#FFFFFF" class="STYLE19">
									<div align="center">${item.e_mail }</div>
								</td>
								<td height="20" bgcolor="#FFFFFF" class="STYLE19">
									<div align="center">
									
									<select id="userSex${ item.id}">
									
									<option value="男" <c:if test="${item.personalInfo.sex=='男' }">selected</c:if>>男</option>
									<option value="女" <c:if test="${item.personalInfo.sex=='女' }">selected</c:if>>女</option>
									</select>
									
									
									</div>
								</td>
								<td height="20" bgcolor="#FFFFFF" class="STYLE19">
									<div align="center">
									<select id="userRole${ item.id}">
									
									<option value="1" <c:if test="${item.role.role=='管理员' }">selected</c:if>>管理员</option>
									<option value="2" <c:if test="${item.role.role=='普通用户' }">selected</c:if>>普通用户</option>
									</select>
									
									
									
									</div>
									
								</td>
								
								<td height="20" bgcolor="#FFFFFF" class="STYLE19">
									<div align="center">
									<select id="say${ item.id}">	
			 						<c:if test="${item.isSay=='0'}">
			 						<option value="0" selected>未禁言</option>
									</c:if>
			 						<c:if test="${item.isSay!='0'}">							
									<option id="isSayOption" value="0" selected>${item.isSay}</option>
	                                <option value="-1">取消禁言</option>
									</c:if>
									<option value="1">+一天</option>
									<option value="2">+两天</option>
									<option value="3">+三天</option>
									<option value="4">+四天</option>
									<option value="5">+五天</option>

									</select>
									
									
									
									</div>
									
								</td>
								<td height="20" bgcolor="#FFFFFF">
									<div class="STYLE21" align="center">
									<input type="hidden" id="userId${ item.id}" value="${ item.id}"/>
										<a href="javascript:void(0)" onclick="return update('${ item.id}')">修改</a><!-- &nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;
										<a href="javascript:void(0)">删除</a> -->
									</div>
								</td>
							</tr>
</c:if>
						</c:forEach>
					</c:if>
				</table>
			</td>
		</tr>
	</table>

</body>
</html>
