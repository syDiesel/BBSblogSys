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



<script type="text/javascript"
	src="<%=basePath%>js/jquery-1.10.2.min.js"></script>
<script charset="utf-8" src="<%=basePath%>kindeditor/kindeditor.js"></script>
<script charset="utf-8" src="<%=basePath%>kindeditor/lang/zh_CN.js"></script>
<script charset="utf-8"
	src="<%=basePath%>kindeditor/plugins/code/prettify.js"></script>
<script>
     var editor;
	 KindEditor.ready(function(K) {
		editor = K.create('textarea[name="msg"]', {
			cssPath : '<%=basePath%>kindeditor/plugins/code/prettify.css',
			uploadJson : '<%=basePath%>kindeditor/jsp/upload_json.jsp',
			fileManagerJson : '<%=basePath%>kindeditor/jsp/file_manager_json.jsp',
									//简单模式
									resizeType : 1,
									allowPreviewEmoticons : false,
									allowImageUpload : false,
									items : [ 'source', 'fontname', 'fontsize',
											'|', 'forecolor', 'hilitecolor',
											'bold', 'italic', 'underline',
											'removeformat', '|', 'justifyleft',
											'justifycenter', 'justifyright',
											'insertorderedlist',
											'insertunorderedlist', '|',
											'emoticons', 'image', 'link' ],

									//图片空间管理
									//allowFileManager : true,
									autoHeightMode : false,

									afterCreate : function() {
										this.loadPlugin('autoheight');
										var self = this;
										K.ctrl(document, 13, function() {
											self.sync();
											document.forms['example'].submit();
										});
										K.ctrl(self.edit.doc, 13, function() {
											self.sync();
											document.forms['example'].submit();
										});
									},
									afterChange : function() {
										if (this.count('text') <= 10) {
											$("#button").attr("disabled", true);
										} else {
											$("#button")
													.attr("disabled", false);
										}
										var limitNum = 100; //设定限制字数
										var pattern =  "还可以输入"+limitNum+"字；"
											
										$('.word_surplus')
												.html(pattern);
																
										if (this.count('text') > limitNum) {
											
											$("#button").attr("disabled", true);
										} else {
											//计算剩余字数
											var result = limitNum
													- this.count('text');
											pattern = "还可以输入"+result+"字；";
													
										}
										$('.word_surplus')
												.html(pattern);												

									},
									afterBlur : function() {
										this.sync();
									}

								});

				prettyPrint();

			});
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
														您当前的位置是：公告管理-> 添加公告</span></td>
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

				<div class="col-content">

					<div class="private-new" style="display: block;">
						<div class="row nty-mas-rtop">
							<h3 class="noy-pl15">
								<i class="icon-envelope">&nbsp; </i> 新公告
							</h3>
						</div>
						<form class="form-horizontal nty-sent-newmas" name="send_new"
							action="<%=basePath%>saveMsg.do" method="post">
							<!--           <div class="form-group">
            <label class="pull-left control-label" style="text-align:right;">发给：</label>
            <div class="pull-right">
              <input type="text" placeholder="请输入有效的收信人" name="receiver" class="form-control typeahead"  background-attachment: scroll;  background-position: 100% 50%; background-repeat: no-repeat no-repeat;" autocomplete="off">
              <span class="error error-empty help-block">请输入有效的收信人</span>            </div>
          </div> -->


							<div class="form-group">
								<label class="pull-left control-label"
									style="text-align: right;">主题：</label>
								<div class="pull-right">
									<input type="text" placeholder="请输入信息主题" name="msgTitle"
										class="form-control typeahead" background-attachment:
										scroll;  background-position: 100% 50%; background-repeat:
										no-repeat no-repeat;" autocomplete="off">
								</div>

							</div>
							<div class="form-group1">




								<label class="pull-left control-label"
									style="text-align: right;">内容：</label>
								<div class="pull-right">
									<textarea rows="6" class="form-control" name="msg"
										placeholder="可发送100字以内的内容"></textarea>
								</div>
							</div>
							<div class="form-group2" style="margin-top:20px;">
								
								<!--   <button type="button" class="btn btn-default btn-cancel send-cancle nty-ml87">取消</button> -->
								<button id="button" class="btn btn-primary send-private nty-ml87" style="float:left;">提交</button>
								<div class="word_surplus" style="float:left;margin-left:20px;line-height:28px;"></div>
							
							</div>
						</form>
					</div>
			</td>
		</tr>
	</table>

</body>
</html>
