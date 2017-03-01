<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<title>添加信息</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">


<style type="text/css">
body {
	margin-left: 3px;
	margin-top: 0px;
	margin-right: 3px;
	margin-bottom: 0px;
}
</style>

<SCRIPT LANGUAGE="JavaScript">
	function ret() {
		if (confirm("您确认提交吗？")) {
			return true;
		}
		
		return false;
	}
</SCRIPT>
</head>

<body>

<form action="web/management/Master/new" method="post" enctype="multipart/form-data">
<input type="hidden" name="applyId" value="${masterApplys.id }"><br/><!-- 申请人ID -->
<input type="hidden" name="userInfo" value="1"><br/><!-- 申请人ID -->
<input type="hidden" name="label" value="${masterApply.label }">
申请人:<input type="text" value="${masterApply.userInfo.userName }" readonly="readonly"><br/>
申请版块:<input type="text" name="label" value="${masterApply.label.name }" readonly="readonly"/><br/>
备注：<input type="text" name="masterExplain" ><br/>
申请说明:${masterApplys.apply_desc }
申请时间:${masterApplys.time }

	<div align="left">
		<input type="submit" value="添加" onclick="return ret()" />
		&nbsp;&nbsp;&nbsp;&nbsp; <input type="reset" value="重置">
	</div>

</form>

</body>
</html>
