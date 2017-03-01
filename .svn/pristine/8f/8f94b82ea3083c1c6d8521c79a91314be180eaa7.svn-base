<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		
	<script type="text/javascript">
	function url(){
		var s=document.getElementById("list").value;
		//window.open("listMsg.do?record="+s);
		location.href="listMsg.do?record="+s;
	}

	function go(){
		var s=document.getElementById("rs").value;
		var count=<s:property value="pageCount"/>;
		if(s=="")
			alert("请输入页码");
		else if(s<=count)
		location.href="listMsg.do?record="+s;
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
    <%		
		int record=Integer.parseInt(request.getAttribute("record").toString());
		int pageRecords=Integer.parseInt(request.getAttribute("pageRecords").toString());
		int i =(record-1)*pageRecords;
	   	i++;		   
	%>
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td height="30">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td height="24" bgcolor="#353c44">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td>
											<table width="100%" border="0" cellspacing="0"
												cellpadding="0">
												<tr>
													<td width="6%" height="19" valign="bottom">
														<div align="center">
															<img src="<%=basePath%>images/houtai/tb.gif" width="14" height="14" />
														</div>
													</td>
													<td width="94%" valign="bottom">
														<%-- <span class="STYLE1"> 您当前的位置是：${msgTypeName} -> 列出信息</span> --%>
														<span class="STYLE1"> 您当前的位置是：意见管理 -> 列出信息</span>
													</td>
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
					<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
						<tr>							
							<th width="3%" height="20" bgcolor="d3eaef" class="STYLE6">
								<div align="center">
									<span class="STYLE10">序号</span>
								</div>
							</th>										
							<th width="9%" height="20" bgcolor="d3eaef" class="STYLE6">
								<div align="center">
									<span class="STYLE10">发布时间</span>
								</div>
							</th>	
							<th width="7%" height="20" bgcolor="d3eaef" class="STYLE6">
								<div align="center">
									<span class="STYLE10">发布者</span>
								</div>
						    </th>		
						    <th width="7%" height="20" bgcolor="d3eaef" class="STYLE6">
								<div align="center">
									<span class="STYLE10">类型</span>
								</div>
						    </th>						    											
							<th width="10%" height="20" bgcolor="d3eaef" class="STYLE6">
								<div align="center">
									<span class="STYLE10">基本操作</span>
								</div>
							</th>
						</tr>
						
						<!-- 这里开始从数据库循坏取数据..jstl标签 -->
						<c:if test="${!empty listAdvice}">
							<c:forEach items="${listAdvice}" var="listAdvice">
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
									<div align="center">
										${listAdvice.suggestTime}
									</div>
								</td>
								<td height="20" bgcolor="#FFFFFF" class="STYLE19">
									<div align="center">
										<!-- 此处取出用户名字 -->
										${listAdvice.userInfo.userName}
									</div>
								</td>
								<td height="20" bgcolor="#FFFFFF" class="STYLE19">
									<div align="center">
										<!-- 此处取出类型 -->
										<c:if test="${listAdvice.suggestionType == '1' }">
										   建议
										</c:if>
										<c:if test="${listAdvice.suggestionType == '2' }">
										  报错
										</c:if>
										<c:if test="${listAdvice.suggestionType == '3' }">
										  合作
										</c:if>
										<c:if test="${listAdvice.suggestionType == '4' }">
										   投诉
										</c:if>
										<c:if test="${listAdvice.suggestionType == '5' }">
										   其他
										</c:if>
									</div>
								</td>
								<td height="20" bgcolor="#FFFFFF">
									<div class="STYLE21">								
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<a href="Suggestion.do?id=${listAdvice.id}" target="rightFrame">详情</a>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<a href="deleteSuggestion.do?id=${listAdvice.id}&record=${record}">删除</a>
									</div>
								</td>
							</tr>
							
							</c:forEach>
						</c:if>	
						<tr>
						    <td colspan="9" style="text-align:center;margin:0px;padding:4px;font-size: 12px;height: 20px;">
						   
						  	<!-- 此处设置分页 -->
						  	<c:choose>
						  		<c:when test="${record>1}"><a href="listSuggestion.do?record=1" style="text-decoration: none">首页 </a>&nbsp;&nbsp;</c:when>
								<c:otherwise><a>首页</a>&nbsp;&nbsp;</c:otherwise>
						  	</c:choose>
						  	
							<c:choose>
								<c:when test="${record>1}"><a href="listSuggestion.do?record=${record-1}" style="text-decoration: none">上页 </a>&nbsp;&nbsp;</c:when>
								<c:otherwise><a>上页</a>&nbsp;&nbsp;</c:otherwise>
							</c:choose> 
							
							${record}/${allPage} &nbsp;
							
							<c:choose>							
								<c:when test="${record<allPage}"><a href="listSuggestion.do?record=${record+1}" style="text-decoration: none">下页  </a>&nbsp;&nbsp;</c:when>
								<c:otherwise><a>下页</a>&nbsp;&nbsp;</c:otherwise>
							</c:choose>
							
							<c:choose>
								<c:when test="${record<allPage}"><a href="listSuggestion.do?record=${allPage}" style="text-decoration: none">末页  </a>&nbsp;&nbsp;</c:when>
								<c:otherwise><a>末页</a>&nbsp;&nbsp;</c:otherwise>
							</c:choose>
						  	</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
</body>
</html>
