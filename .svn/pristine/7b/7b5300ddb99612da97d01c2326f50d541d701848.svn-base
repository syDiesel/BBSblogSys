<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<title>My JSP 'advice.jsp' starting page</title>

<link type="text/css" href="<%=basePath%>css/button.css"
	rel="stylesheet" />

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>
<body>
	<center>
		<c:if test="${!empty userAlbumPhoto }">
			<h2>相片详情</h2>
			<img src="<%=basePath%>${userAlbumPhoto.photo}" width=400px>
			<p style="font-family:'Microsoft YaHei';">${userAlbumPhoto.photoDesc}</p>
			<form
				action="<%=basePath %>pass.do">
				<table style="margin-bottom:30px;">
					<tr>
						<td
							style="font-family:'Microsoft YaHei';line-height:50px;margin-bottom:20px;">更新相片描述
						</td>
						<td><textarea name="albumPhotoDesc" cols="60" rows="10"
								style="width:230px;height:50px;font-style: normal;"></textarea>
						</td>
					</tr>
				</table>
				<input type="hidden" name="id" value="${userAlbumPhoto.id }">
				<input type="hidden" name="record" value="${record}">
				<input type="submit" name="submit" value="通过审核" class="submitButton"
					style="margin-left:30px;">
					<a href="<%=basePath %>unpass.do?id=${userAlbumPhoto.id }&record=${record}"><INPUT
					class="submitButton" type="button" value="未通过"
					style="margin-left:20px;"
					onclick="javascrtpt:window.location.href='<%=basePath %>unpass.do?id=${userAlbumPhoto.id }&record=${record}'"></a>
			</form>
		</c:if>
	</center>
</body>
</html>
