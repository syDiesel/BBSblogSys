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
    <script src="<%=basePath%>js/jquery-1.10.2.min.js"></script>
    <SCRIPT LANGUAGE="JavaScript">
  $(document).ready(function() {  
    $('.select').change(function(){
        var toUser=$('.select').val();
        if(toUser=='one')
        {
          $('#userNickName').css("display","block");
          
        }else{
        $('#userNickName').css("display","none");          
        }
    });
    
    
    });
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
              <form action="sendJinzhuan" method="post" enctype="multipart/form-data" class="jqtransform">
               <table class="form_table pt15 pb15" width="100%" border="0" cellpadding="0" cellspacing="0">
                 <tr >
                  <td class="td_right">赠送对象:</td>
                  <td class="">
 
                    <span class="fl" >
                      <div class="select_border"> 
                        <div class="select_containers "> 
                        <select name="toUser" class="select"> 
                       <option value="one">特定用户</option>
                       <option value="all" selected>所有用户</option>
                        </select> 
                        </div> 
                      </div> 
                    </span>
                  </td>
                 </tr>
                </table>
                <table class="form_table pt15 pb15" width="100%" border="0" 
                cellpadding="0" cellspacing="0"  id="userNickName"
                style="display:none;">
                 <tr>
                  <td class="td_right">用户昵称:</td>
                  <td class=""> 
                    <input type="text" name="nickName" id="nickName" class="input-text lh30" size="40">
                  </td>
                  
                </tr>
                </table>
                <table class="form_table pt15 pb15" width="100%" border="0" cellpadding="0" cellspacing="0" >
                <tr>
                  <td class="td_right">金砖数:</td>
                  <td class=""> 
                    <input type="text" name="jinzhuan" id="jinzhuan" 
                    class="input-text lh30" size="40" 
                    onkeyup="this.value=this.value.replace(/[^\d.]/g,'') " 
                    onafterpaste="this.value=this.value.replace(/[^\d.]/g,'') ">
                  </td>
                  
                </tr>
               
                
                 
                 <tr>
                   <td class="td_right">&nbsp;</td>
                   <td class="">
                     <input type="submit" name="button" onclick="return ret()" 
                     class="btn btn82 btn_save2" value="赠送"> 
                     <font style="color:red;font-size:12px;">${msg}</font>
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
