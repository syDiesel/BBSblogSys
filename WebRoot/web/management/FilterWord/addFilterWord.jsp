<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/management/main.css">
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
    <div id="forms" class="mt10">
        <div class="box">
          <div class="box_border">
            <div class="box_top"></div>
            <div class="box_center">
              <form action="web/management/FilterWord/new" method="post" enctype="multipart/form-data" class="jqtransform">
               <table class="form_table pt15 pb15" width="100%" border="0" cellpadding="0" cellspacing="0">
                 <tr>
                  <td class="td_right">敏感词：</td>
                  <td class=""> 
                    <input type="text" name="find" class="input-text lh30" size="40">
                  </td>
                </tr>
                <tr>
                  <td class="td_right">替换词：</td>
                  <td class=""> 
                    <input type="text" name="replacement" class="input-text lh30" size="40">
                  </td>
                </tr>
                 
                 <tr>
                   <td class="td_right">&nbsp;</td>
                   <td class="">
                     <input type="submit" onclick="ret()" name="button" class="btn btn82 btn_save2" value="保存"> 
                    <input type="reset" name="button" class="btn btn82 btn_res" value="重置"> 
                   </td>
                 </tr>
               </table>
               </form>
            </div>
          </div>
        </div>
     </div>
 
  </body>
</html>
