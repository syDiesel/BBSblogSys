<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<title>后台管理工作平台</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->


<c:if test="${userInfo.role.id==1}">
	<frameset rows="127,*,11" frameborder="no" border="0" framespacing="0">
		<frame src="<%=basePath%>web/management/top.jsp" name="topFrame"
			scrolling="No" noresize="noresize" id="topFrame" />
		<frame src="<%=basePath%>web/management/center.jsp" name="mainFrame"
			id="mainFrame" />
		<frame src="<%=basePath%>web/management/down.jsp" name="bottomFrame"
			scrolling="No" noresize="noresize" id="bottomFrame" />
	</frameset>
</c:if>

<c:if test="${userInfo.role.id!=1}">
	<div align="center">
		<font color="red" size="8">非法操作,您需要登陆后才能使用!</font><br/><a
			href="<%=basePath%>login.html" target="_parent">点击登录</a>
	</div>
</c:if>

</head>

<body>
</body>
</html>
