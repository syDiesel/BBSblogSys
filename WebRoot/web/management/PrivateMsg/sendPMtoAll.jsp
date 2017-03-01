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


<link type="text/css" href="<%=basePath%>css/index_default.css"
	rel="stylesheet" />
<link type="text/css" href="<%=basePath%>css/home.css" rel="stylesheet" />
<link type="text/css" href="<%=basePath%>css/home_search.css"
	rel="stylesheet" />
<link type="text/css" href="<%=basePath%>css/PMtoAll.css"
	rel="stylesheet" />
 

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
														您当前的位置是：私信管理-> 私信群发</span></td>
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
			<td >
					<!--新建私信-->
	<div class="col-content">

		<div class="private-new" style="display: block;">
			<div class="row nty-mas-rtop">
				<h3 class="noy-pl15">
					<i class="icon-envelope">&nbsp; </i> 新私信
				</h3>
			</div>
			<form class="form-horizontal nty-sent-newmas" name="send_new"
				action="<%=basePath%>web/PrivateMsg/sendPMtoAll" method="post">
				<!--           <div class="form-group">
            <label class="pull-left control-label" style="text-align:right;">发给：</label>
            <div class="pull-right">
              <input type="text" placeholder="请输入有效的收信人" name="receiver" class="form-control typeahead"  background-attachment: scroll;  background-position: 100% 50%; background-repeat: no-repeat no-repeat;" autocomplete="off">
              <span class="error error-empty help-block">请输入有效的收信人</span>            </div>
          </div> -->


				<div class="form-group">
					<label class="pull-left control-label" style="text-align: right;">主题：</label>
					<div class="pull-right">
						<input type="text" placeholder="请输入信息主题" name="msgSubject"
							class="form-control typeahead" background-attachment:
							scroll;  background-position: 100% 50%; background-repeat:
							no-repeat no-repeat;" autocomplete="off">
					</div>

				</div>
				<div class="form-group1">




					<label class="pull-left control-label" style="text-align: right;">内容：</label>
					<div class="pull-right">
						<textarea rows="6" class="form-control" name="msgContent"
							placeholder="可发送200字以内的内容"></textarea>
					</div>
				</div>
				<div class="form-group2">
					<!--   <button type="button" class="btn btn-default btn-cancel send-cancle nty-ml87">取消</button> -->
					<button class="btn btn-primary send-private nty-ml87">发送私信</button>
				</div>
			</form>
		</div>
				
				
				
				
				
			</td>
		</tr>
	</table>

</body>
</html>
