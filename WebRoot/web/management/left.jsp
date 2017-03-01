<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>My JSP 'left.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<script type="text/javascript">
	function expandOne(x, y) {

		var i;
		var parent = new Array();
		var child = new Array();

		for (i = 0; i < y; i++) {
			parent[i] = document.getElementById("parent" + x + "_" + (i + 1));
			child[i] = document.getElementById("child" + x + "_" + (i + 1));

			if ((parent[i].style.display == 'none')
					&& (child[i].style.display == 'none')) {
				parent[i].style.display = 'block';
			}

			else if ((parent[i].style.display == 'block')
					&& (child[i].style.display == 'none')) {
				parent[i].style.display = 'none';
				child[i].style.display = 'none';
			} else if ((parent[i].style.display == 'block')
					&& (child[i].style.display == 'block')) {
				parent[i].style.display = 'none';
				child[i].style.display = 'none';
			} else {
			}
		}
	}

	function expandTwo(x, y) {

		var parent = document.getElementById("parent" + x + "_" + y);
		var child = document.getElementById("child" + x + "_" + y);

		if ((parent.style.display == 'block')
				&& (child.style.display == 'none')) {
			child.style.display = 'block';
		} else if ((parent.style.display == 'block')
				&& (child.style.display == 'block')) {
			child.style.display = 'none';
		} else {
		}
	}
</script>

<style type="text/css">
body {
	margin: 0;
	text-decoration: none;
	color: #000;
	background-color: #fff;
	letter-spacing: 0.8px;
}

table {
	cellSpacing: 0;
	cellSpacing: 0;
	border: 0;
}

body table {
	FONT-SIZE: 12px;
	LINE-HEIGHT: 141%;
	FONT-FAMILY: "Verdana", "Arial", "Helvetica", "sans-serif" ；
}

table tr td table tr td a.menuParent {
	font-size: 13px;
}

table tr td table tr td a.menuChild {
	font-size: 12.5px;
}

table tr td table tr td a.menuChild1 {
	font-size: 12.5px;
}

a:link {
	color: #036;
	text-decoration: none
}

a:visited {
	color: #036;
	text-decoration: none
}

a:hover {
	color: #f60;
	text-decoration: underline
}

a.menuChild:link {
	color: #036;
	text-decoration: none
}

a.menuChild:visited {
	color: #036;
	text-decoration: none
}

a.menuChild:hover {
	color: #f60;
	text-decoration: none
}

a.menuParent:link {
	color: #000;
	text-decoration: none
}

a.menuParent:visited {
	color: #000;
	text-decoration: none
}

a.menuParent:hover {
	color: #f60;
	text-decoration: none
}
</style>

</head>

<body>
	<table height="100%" width="145"
		background="<%=basePath%>images/houtai/menu_bg.jpg">
		<tr>
			<td valign="top" align="center">

				<table width="100%">
					<tr>
						<td height="5"></td>
					</tr>
				</table> <!--....................................板块管理.......1...........................-->
				<table width="141px">
					<tr height="22px">
						<td style="padding-left: 30px"
							background="<%=basePath%>images/houtai/menu_bt.jpg"><a
							class="menuParent" onclick="expandOne(1,7)"
							href="javascript:void(0);">
								<div style="width: 105px">分类&标签</div>
						</a></td>
					</tr>
					<tr height="4px">
						<td></td>
					</tr>
				</table> <!--...........................板块管理.......1....................................-->
				<table id="parent1_1" style="display: none" width="141px">
					<tr height="20px">
						<td align="center" width="30px"><img height="9px"
							src="<%=basePath%>images/houtai/menu_icon.gif" width="9px" /></td>
						<td><a class="menuChild" onclick="expandTwo(1,1)"
							href="javascript:void(0);">分类管理</a></td>
					</tr>
				</table>
				<table id="child1_1" style="display: none" width="141px">
					<tr height="20px">
						<td align="right" width="30px"><img height="9px"
							src="<%=basePath%>images/houtai/menu_icon.gif" width="8px" /></td>
						<td>&nbsp;&nbsp;&nbsp;<a class="menuChild1"
							href="<%=basePath%>web/management/Board/addBoard.jsp"
							target="rightFrame">添加信息</a></td>
					</tr>
					<tr height="20px">
						<td align="right"><img height="9px"
							src="<%=basePath%>images/houtai/menu_icon.gif" width="8px" /></td>
						<td>&nbsp;&nbsp;&nbsp;<a class="menuChild1"
							href="web/management/Board/list" target="rightFrame">查看信息</a></td>
					</tr>
				</table> <!--...............................................................-->
				<table id="parent1_2" style="display: none" width="141px">
					<tr height="20px">
						<td align="center" width="30px"><img height="9px"
							src="<%=basePath%>images/houtai/menu_icon.gif" width="9px"></td>
						<td><a class="menuChild" onclick="expandTwo(1,2)"
							href="javascript:void(0);">标签管理</a></td>
					</tr>
				</table>
				<table id="child1_2" style="display: none" width="141px">
				<tr height="20px">
						<td align="right" width="30px"><img height="9px"
							src="<%=basePath%>images/houtai/menu_icon.gif" width="9px" /></td>
						<td>&nbsp;&nbsp;&nbsp;<a class="menuChild1"
							href="listLabelApply.do?record=1"
							target="rightFrame">查看申请</a></td>
					</tr>
					<tr height="20px">
						<td align="right" width="30px"><img height="9px"
							src="<%=basePath%>images/houtai/menu_icon.gif" width="9px" /></td>
						<td>&nbsp;&nbsp;&nbsp;<a class="menuChild1"
							href="<%=basePath%>web/management/Label/toAddLabel"
							target="rightFrame">添加信息</a></td>
					</tr>
					
					<tr height="20px">
						<td align="right" width="30px"><img height="9px"
							src="<%=basePath%>images/houtai/menu_icon.gif" width="9px" /></td>
						<td>&nbsp;&nbsp;&nbsp;<a class="menuChild1"
							href="<%=basePath%>web/management/Label/list" target="rightFrame">查看信息</a></td>
					</tr>
				</table> <!-- ................................................................ -->
				<table id="parent1_3" style="display: none" width="141px">
					<tr height="20px">
						<td align="center" width="30px"><img height="9px"
							src="<%=basePath%>images/houtai/menu_icon.gif" width="9px"></td>
						<td><a class="menuChild" onclick="expandTwo(1,3)"
							href="javascript:void(0);">版主管理</a></td>
					</tr>
				</table>
				<table id="child1_3" style="display: none" width="141px">
					<tr height="20px">
						<td align="right" width="30px"><img height="9px"
							src="<%=basePath%>images/houtai/menu_icon.gif" width="9px" /></td>
						<td>&nbsp;&nbsp;&nbsp;<a class="menuChild1"
							href="listApply?record=1"
							target="rightFrame">查看申请</a></td>
					</tr>
					<tr height="20px">
						<td align="right" width="30px"><img height="9px"
							src="<%=basePath%>images/houtai/menu_icon.gif" width="9px" /></td>
						<td>&nbsp;&nbsp;&nbsp;<a class="menuChild1"
							href="listMaster?record=1" target="rightFrame">版主信息</a></td>
					</tr>
				</table> <!--.....................敏感词管理....2..................................-->
				<table width="141px">
					<tr height="22px">
						<td style="padding-left: 30px"
							background="<%=basePath%>images/houtai/menu_bt.jpg"><a
							class="menuParent" onclick="expandOne(2,3)"
							href="javascript:void(0);">
								<div style="width: 105px">敏感词管理</div>
						</a></td>
					</tr>
					<tr height="4px">
						<td></td>
					</tr>
				</table> <!--....................................2-1..................................-->
				<table id="parent2_1" style="display: none" width="141px">
					<tr height="20px">
						<td align="center" width="30px"><img height="9px"
							src="<%=basePath%>images/houtai/menu_icon.gif" width="9px" /></td>
						<td><a class="menuChild" onclick="expandTwo(2,1)"
							href="javascript:void(0);">敏感词管理</a></td>
					</tr>
				</table>
				<table id="child2_1" style="display: none" width="141px">
					<tr height="20px">
						<td align="right" width="30px"><img height="9px"
							src="<%=basePath%>images/houtai/menu_icon.gif" width="8px" /></td>
						<td>&nbsp;&nbsp;&nbsp;<a class="menuChild1"
							href="web/management/FilterWord/addFilterWord.jsp"
							target="rightFrame">添加信息</a></td>
					</tr>
					<tr height="20px">
						<td align="right" width="30px"><img height="9px"
							src="<%=basePath%>images/houtai/menu_icon.gif" width="8px" /></td>
						<td>&nbsp;&nbsp;&nbsp;<a class="menuChild1"
							href="web/management/FilterWord/list?pager.offset=0"
							target="rightFrame">查看信息</a></td>
					</tr>
				</table> <!--.....................用户管理....3..................................-->
				<table width="141px">
					<tr height="22px">
						<td style="padding-left: 30px"
							background="<%=basePath%>images/houtai/menu_bt.jpg"><a
							class="menuParent" onclick="expandOne(3,3)"
							href="javascript:void(0);">
								<div style="width: 105px">用户管理</div>
						</a></td>
					</tr>
					<tr height="4px">
						<td></td>
					</tr>
				</table> <!--....................................3-1..................................-->
				<table id="parent3_1" style="display: none" width="141px">
					<tr height="20px">
						<td align="center" width="30px"><img height="9px"
							src="<%=basePath%>images/houtai/menu_icon.gif" width="9px" /></td>
						<td><a class="menuChild" onclick="expandTwo(3,1)"
							href="javascript:void(0);">用户组信息</a></td>
					</tr>
				</table>
				<table id="child3_1" style="display: none" width="141px">
					<tr height="20px">
						<td align="right" width="30px"><img height="9px"
							src="<%=basePath%>images/houtai/menu_icon.gif" width="8px" /></td>
						<td>&nbsp;&nbsp;&nbsp;<a class="menuChild1"
							href="<%=basePath%>web/management/Role/findUser.jsp" target="rightFrame">查找用户</a></td>
					</tr>
					<tr height="20px">
						<td align="right" width="30px"><img height="9px"
							src="<%=basePath%>images/houtai/menu_icon.gif" width="8px" /></td>
						<td>&nbsp;&nbsp;&nbsp;<a class="menuChild1"
							href="<%=basePath%>web/management/Role/listRole" target="rightFrame">查看信息</a></td>
					</tr>
				</table>
				<!--..................................................3-2...................................-->
				<table id="parent3_2" style="display: none" width="141px">
					<tr height="20px">
						<td align="center" width="30px"><img height="9px"
							src="<%=basePath%>images/houtai/menu_icon.gif" width="9px" /></td>
						<td><a class="menuChild" onclick="expandTwo(3,2)"
							href="javascript:void(0);">资质管理</a></td>
					</tr>
				</table>
				<table id="child3_2" style="display: none" width="141px">
					<tr height="20px">
						<td align="right" width="30px"><img height="9px"
							src="<%=basePath%>images/houtai/menu_icon.gif" width="8px" /></td>
						<td>&nbsp;&nbsp;&nbsp;<a class="menuChild1"
							href="<%=basePath%>listZzzm.do?record=1" target="rightFrame">查看信息</a></td>
					</tr>
				</table>
				
				<!--..................................................3-3...................................-->
				<table id="parent3_3" style="display: none" width="141px">
					<tr height="20px">
						<td align="center" width="30px"><img height="9px"
							src="<%=basePath%>images/houtai/menu_icon.gif" width="9px" /></td>
						<td><a class="menuChild" onclick="expandTwo(3,3)"
							href="javascript:void(0);">兑换管理</a></td>
					</tr>
				</table>
				<table id="child3_3" style="display: none" width="141px">
				   <tr height="20px">
						<td align="right" width="30px"><img height="9px"
							src="<%=basePath%>images/houtai/menu_icon.gif" width="8px" /></td>
						<td>&nbsp;&nbsp;&nbsp;<a class="menuChild1"
							href="<%=basePath%>listCash.html?record=1&value=0" target="rightFrame">兑换申请</a></td>
					</tr>
					<tr height="20px">
						<td align="right" width="30px"><img height="9px"
							src="<%=basePath%>images/houtai/menu_icon.gif" width="8px" /></td>
						<td>&nbsp;&nbsp;&nbsp;<a class="menuChild1"
							href="<%=basePath%>listCash.html?record=1&value=1" target="rightFrame">兑换记录</a></td>
					</tr>
				</table>
				 <!--.....................................................................-->
				<!--.......................................................-->
				<table width="141px">
					<tr height="22px">
						<td style="padding-left: 30px"
							background="<%=basePath%>images/houtai/menu_bt.jpg"><a
							class="menuParent" onclick="expandOne(4,4)"
							href="javascript:void(0);">
								<div style="width: 105px">信息管理</div>
						</a></td>
					</tr>
					<tr height="4px">
						<td></td>
					</tr>
				</table> <!--....................................4-1..................................-->
				<table id="parent4_1" style="display: none" width="141px">
					<tr height="20px">
						<td align="center" width="30px"><img height="9px"
							src="<%=basePath%>images/houtai/menu_icon.gif" width="9px" /></td>
						<td><a class="menuChild" onclick="expandTwo(4,1)"
							href="javascript:void(0);">举报管理</a></td>
					</tr>
				</table>
				<table id="child4_1" style="display: none" width="141px">
<%-- 					<tr height="20px">
						<td align="right" width="30px"><img height="9px"
							src="<%=basePath%>images/houtai/menu_icon.gif" width="8px" /></td>
						<td>&nbsp;&nbsp;&nbsp;<a class="menuChild1"
							href="addMsgByType.do?type=14" target="rightFrame">添加信息</a></td>
					</tr> --%>
					<tr height="20px">
						<td align="right" width="30px"><img height="9px"
							src="<%=basePath%>images/houtai/menu_icon.gif" width="8px" /></td>
						<td>&nbsp;&nbsp;&nbsp;<a class="menuChild1"
							href="web/management/Flag/list" target="rightFrame">查看信息</a></td>
					</tr>
				</table> <!--....................................4-2.................................-->
				<table id="parent4_2" style="display: none" width="141px">
					<tr height="20px">
						<td align="center" width="30px"><img height="9px"
							src="<%=basePath%>images/houtai/menu_icon.gif" width="9px" /></td>
						<td><a class="menuChild" onclick="expandTwo(4,2)"
							href="javascript:void(0);">意见管理</a></td>
					</tr>
				</table>
				<table id="child4_2" style="display: none" width="141px">
<%-- 					<tr height="20px">
						<td align="right" width="30px"><img height="9px"
							src="<%=basePath%>images/houtai/menu_icon.gif" width="8px" /></td>
						<td>&nbsp;&nbsp;&nbsp;<a class="menuChild1"
							href="addMsgByType.do?type=15" target="rightFrame">添加信息</a></td>
					</tr> --%>
					<tr height="20px">
						<td align="right" width="30px"><img height="9px"
							src="<%=basePath%>images/houtai/menu_icon.gif" width="8px" /></td>
						<td>&nbsp;&nbsp;&nbsp;<a class="menuChild1"
							href="listSuggestion.do?record=1" target="rightFrame">查看信息</a></td>
					</tr>
				</table> 
				
				<!--  -->
				 <!--....................................成功案例6-1.......典型客户...........................-->
				<table id="parent4_3" style="display: none" width="141px">
					<tr height="20px">
						<td align="center" width="30px"><img height="9px"
							src="<%=basePath%>images/houtai/menu_icon.gif" width="9px" /></td>
						<td><a class="menuChild" onclick="expandTwo(4,3)"
							href="javascript:void(0);">公告管理</a></td>
					</tr>
				</table>
				<table id="child4_3" style="display: none" width="141px">
					<tr height="20px">
						<td align="right" width="30px"><img height="9px"
							src="<%=basePath%>images/houtai/menu_icon.gif" width="8px" /></td>
						<td>&nbsp;&nbsp;&nbsp;<a class="menuChild1"
							href="<%=basePath%>addMsgByType.do" target="rightFrame">添加信息</a></td>
					</tr>
					<tr height="20px">
						<td align="right" width="30px"><img height="9px"
							src="<%=basePath%>images/houtai/menu_icon.gif" width="8px" /></td>
						<td>&nbsp;&nbsp;&nbsp;<a class="menuChild1"
							href="<%=basePath%>listNotice.do?record=1" target="rightFrame">查看信息</a></td>
					</tr>
				
				</table> 
				<table id="parent4_4" style="display: none" width="141px">
					<tr height="20px">
						<td align="center" width="30px"><img height="9px"
							src="<%=basePath%>images/houtai/menu_icon.gif" width="9px" /></td>
						<td><a class="menuChild" onclick="expandTwo(4,4)"
							href="javascript:void(0);">私信管理</a></td>
					</tr> 
				</table>
				<table id="child4_4" style="display: none" width="141px">
					<tr height="20px">
						<td align="right" width="30px"><img height="9px"
							src="<%=basePath%>images/houtai/menu_icon.gif" width="8px" /></td>
						<td>&nbsp;&nbsp;&nbsp;<a class="menuChild1"
							href="<%=basePath %>web/management/PrivateMsg/sendPMtoAll.jsp" target="rightFrame">私信群发</a></td>
					</tr>
					<tr height="20px">
						<td align="right" width="30px"><img height="9px"
							src="<%=basePath%>images/houtai/menu_icon.gif" width="8px" /></td>
						<td>&nbsp;&nbsp;&nbsp;<a class="menuChild1"
							href="<%=basePath %>web/PrivateMsg/adminRecBox" target="rightFrame">查看信息</a></td>
					</tr>
				</table> 
				
				
				
				
				
				
				
				
				
				
				<!--....................................4-3.................................-->
 <!--.....................合作与代理5..................................-->
				<table width="141px">
					<tr height="22px">
						<td style="padding-left: 30px"
							background="<%=basePath%>images/houtai/menu_bt.jpg"><a
							class="menuParent" onclick="expandOne(5,1)"
							href="javascript:void(0);">
								<div style="width: 105px">数据统计</div>
						</a></td>
					</tr>
					<tr height="4px">
						<td></td>
					</tr>
				</table> <!--....................................合作与代理5-1.......服务概述...........................-->
				<table id="parent5_1" style="display: none" width="141px">
					<tr height="20px">
						<td align="center" width="30px"><img height="9px"
							src="<%=basePath%>images/houtai/menu_icon.gif" width="9px" /></td>
						<td><a class="menuChild" onclick="expandTwo(5,1)"
							href="javascript:void(0);">统计信息</a></td>
					</tr>
				</table>
				<table id="child5_1" style="display: none" width="141px">

<%-- 					<tr height="20px">
						<td align="right" width="30px"><img height="9px"
							src="<%=basePath%>images/houtai/menu_icon.gif" width="8px" /></td>
						<td>&nbsp;&nbsp;&nbsp;<a class="menuChild1"
							href="" target="rightFrame">用户统计</a></td>
					</tr> --%>
										<tr height="20px">
						<td align="right" width="30px"><img height="9px"
							src="<%=basePath%>images/houtai/menu_icon.gif" width="8px" /></td>
						<td>&nbsp;&nbsp;&nbsp;<a class="menuChild1"
							href="<%=basePath%>web/management/Count/boardCount?countType=BK" target="rightFrame">博客统计</a></td>
					</tr>
										<tr height="20px">
						<td align="right" width="30px"><img height="9px"
							src="<%=basePath%>images/houtai/menu_icon.gif" width="8px" /></td>
						<td>&nbsp;&nbsp;&nbsp;<a class="menuChild1"
							href="<%=basePath%>web/management/Count/boardCount?countType=LT" target="rightFrame">论坛统计</a></td>
					</tr>
					<tr height="20px">
						<td align="right" width="30px"><img height="9px"
							src="<%=basePath%>images/houtai/menu_icon.gif" width="8px" /></td>
						<td>&nbsp;&nbsp;&nbsp;<a class="menuChild1"
							href="<%=basePath%>web/management/Count/boardCount?countType=WD" target="rightFrame">问答统计</a></td>
					</tr>
					 </table>
 
				<table id="parent5_2" style="display: none" width="141px">
					<tr height="20px">
						<td align="center" width="30px"><img height="9px"
							src="<%=basePath%>images/houtai/menu_icon.gif" width="9px" /></td>
						<td><a class="menuChild" onclick="expandTwo(5,2)"
							href="javascript:void(0);">操作日志</a></td>
					</tr>
				</table>
				<table id="child5_2" style="display: none" width="141px">

					<tr height="20px">
						<td align="right" width="30px"><img height="9px"
							src="<%=basePath%>images/houtai/menu_icon.gif" width="8px" /></td>
						<td>&nbsp;&nbsp;&nbsp;<a class="menuChild1"
							href="" target="rightFrame">操作日志</a></td>
					</tr> 

					 </table>
					<!--.....................金砖管理6..................................-->
				<table width="141px">
					<tr height="22px">
						<td style="padding-left: 30px"
							background="<%=basePath%>images/houtai/menu_bt.jpg"><a
							class="menuParent" onclick="expandOne(6,1)"
							href="javascript:void(0);">
								<div style="width: 105px">金砖管理</div>
						</a></td>
					</tr>
					<tr height="4px">
						<td></td>
					</tr>
				</table> <!--....................................6-1...........................-->
				<table id="parent6_1" style="display: none" width="141px">
					<tr height="20px">
						<td align="center" width="30px"><img height="9px"
							src="<%=basePath%>images/houtai/menu_icon.gif" width="9px" /></td>
						<td><a class="menuChild" onclick="expandTwo(6,1)"
							href="javascript:void(0);">金砖管理</a></td>
					</tr>
				</table>
				<table id="child6_1" style="display: none" width="141px">

					<tr height="20px">
						<td align="right" width="30px"><img height="9px"
							src="<%=basePath%>images/houtai/menu_icon.gif" width="8px" /></td>
						<td>&nbsp;&nbsp;&nbsp;<a class="menuChild1"
							href="<%=basePath%>web/management/jinzhuan/sendJinzhuan.jsp" target="rightFrame">送金砖</a></td>
					</tr> 

					 </table>
			


			</td>
		</tr>
	</table>
</body>
</html>
