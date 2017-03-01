<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" import="java.util.*,com.bbsBlog.entity.ForumPost,java.text.SimpleDateFormat;" pageEncoding="utf-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path +  "/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Q & A</title>
<meta http-equiv="x-ua-compatible" content="ie=8" />

<link type="text/css" href="<%=basePath%>css/button.css" rel="stylesheet" />
<link href="<%=basePath%>css/headfoot.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>css/index_default.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>css/Index/index.css" rel="stylesheet"
	type="text/css" />
<link type="text/css" href="<%=basePath%>css/Forums1/post/forum_post.css" rel="stylesheet" />
<link href="<%=basePath%>css/qiantai/login.css" rel="stylesheet" type="text/css" />

<script charset="utf-8" src="<%=basePath%>kindeditor/kindeditor.js"></script>
<script charset="utf-8" src="<%=basePath%>kindeditor/lang/zh_CN.js"></script>
<script charset="utf-8" src="<%=basePath%>kindeditor/plugins/code/prettify.js"></script>
<script src="<%=basePath%>js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/index/index.js"></script>
<script type="text/javascript" src="<%=basePath%>js/index/language.js"></script>
<script charset="utf-8" src="<%=basePath%>kindeditor/kindeditor.js"></script>
<script charset="utf-8" src="<%=basePath%>kindeditor/lang/zh_CN.js"></script>
<script charset="utf-8" src="<%=basePath%>kindeditor/plugins/code/prettify.js"></script>
<script type="text/javascript" src="<%=basePath%>js/Forum/home.js"></script>
<script type="text/javascript" src="<%=basePath%>js/checkLable.js"></script>
<script type="text/javascript" src="<%=basePath%>js/login_all.js"></script>

<script type="text/javascript">
//文本编辑器
var editor;
KindEditor.ready(function(K) {
	editor = K.create('textarea[name="qContent"]', {
		cssPath : '<%=basePath%>kindeditor/plugins/code/prettify.css',
		uploadJson : '<%=basePath%>kindeditor/jsp/upload_json.jsp',
		fileManagerJson : '<%=basePath%>kindeditor/jsp/file_manager_json.jsp',
		resizeType : 1,
		allowPreviewEmoticons : false,
		allowImageUpload : true,
		items : [
			'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
			'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
			'insertunorderedlist', '|', 'emoticons', 'image', 'link']
	});
});
  $(function(){
  
     
      
    $("#check").click(function(){
    $("#q_div").css("display","block");
    });
    
    $("#nocheck").click(function(){
    $("#q_div").css("display","none");
    });

    
    $("#board").change(function(){
    $("input[name='labels']").remove();
    $(".labelsName").remove();
       var board_id=$(this).val(); 
            if(board_id!=""){
            var url=board_id;
            $.getJSON(url,function(data){
            if(data.length==0)
            alert("no tag in selected union");
            for(var i=0;i<data.length;i++){
            var id=data[i].id;
            var name=data[i].labelName;
            $(".label").append("<input type='checkbox' name='labels' value='"+id  +"'>" );
            $(".label").append("<span class='labelsName' style='font-size:14' >"+name+"</span>");
            }
            });
            }
     });
 
  $("input[name='qSubject']").blur(function(){
        var textVal=$(this).val();
        textVal=textVal.trim();
         if(textVal=="")
          $("#errorSub").css("visibility","");
          else
          $("#errorSub").css("visibility","hidden");
  });

  $("textarea[name='qContent']").blur(function(){
        var textVal=$(this).html();
        textVal=textVal.trim();
         if(textVal=="")
          $("#errorCon").css("visibility","");
          else
          $("#errorCon").css("visibility","hidden");
  });

  $("#board").change(function(){
       var textVal=$(this).val();
       if(textVal==""){
          $("#errorBod").css("visibility","");
          $("#errorLab").css("visibility","hidden"); 
       }else
          $("#errorBod").css("visibility","hidden");
     
  });
       $("#label").change(function(){
       var checkboxs=$("input[name='labels']");
       var count=0;
       for(var i=0;i<checkboxs.length;i++){
       if(checkboxs[i].checked==true){
          $("#errorLab").css("visibility","hidden");
       }
       else count++;
       }
       if(count==checkboxs.length)    
          $("#errorLab").css("visibility","");
  });
  
  


  $("input[name='radiovalue']").change(function(){
      $("#valueId").val(0);
  });



 $("#valueId").change(function(){
   var value=$(this).val();
   value=Number(value);
   if(!isNaN(value)){
    if(value<0||value>100){
     alert("reward:0-100");
     $(this).val(0);
     }
    }
     else{
     alert("ilegal amount");
     $(this).val(0);
     }
   /* if(0<=value&&value<=100){
   var radio=$("input[name='radiovalue']:checked").val();
   var url="web/QandA/jugde/"+value+"/"+radio;
  $.getJSON(url,function(data){
  alert("余额不足，请充值");
    $("#valueId").val("0");
  });   
  }
  else{
     alert("悬赏金额在0到100之间");
     $(this).val("0");
      } */
 });
     
     $("#subMit").click(function(){
       var textSub=$.trim($("input[name='qSubject']").val());
       //var textCon=$.trim($("textarea[name='qContent']").val());
       var textCon=editor.html();
       var textBod=$("#board").val();
       var checkboxs=$("input[name='labels']");
       var count=0;
       var radios=$("input[name='radiovalue']");
       var orgValue=0;
       var value=$("#valueId").val();
       value=parseInt(value);
      
       for(var i=0;i<radios.length;i++){
       if(radios[i].checked==true)
          if(i==0)
               orgValue=parseInt($("#Orgjinzhuan").val());
           else
               orgValue=parseInt($("#Orglingdan").val());
       }
       
       
       for(var i=0;i<checkboxs.length;i++){
       if(checkboxs[i].checked==false)
       count++;
       }
       
       //设置作答权限的检验
        var validateAccess=false;
        var check=$("input[name='check']");
        if(check[0].checked==true)
        {    
        var access=$("#qAccess").val();
        var level=$("#userLevel").val();
        var lingdan=$("#lingdan").val();
        if(access>level&&lingdan>1)
           {
             if(confirm("It is to minus a brick. Sure?"))
             {
                validateAccess=true;
             }
             else
             {
             	return false;
             }
           }else if(access<=level)
                validateAccess=true;         
        }else{
           validateAccess=true;
        }
        
        if(validateAccess==false)
          {
             $("#access_info").css("display","block");
             return false;
          }else
          {
             $("#access_info").css("display","none");
          }      
          
       if(textSub!=""&&textCon!=""&&textBod!=""&&count!=checkboxs.length&&orgValue>=value&&validateAccess)  
      return true;
      
      else if(textSub==""){
      $("#errorSub").css("visibility","");
     return false;
     }
      else if(textCon==""){
     $("#errorCon").css("visibility","");
     return false;
     }
     else if(textBod==""){
     $("#errorBod").css("visibility","");
     return false;
     }
      else if(count==checkboxs.length){
     $("#errorLab").css("visibility","");
     return false;
     }
     else if(orgValue<value){
      $("#errorVal").css("visibility",""); 
      return false;
     }
     });
   
     
    });
</script>

</head>

<body style="text-align: center;font-family:Arial,verdana,tahoma;">
<!---------------------------login_begin  ------------------------->
	<div id="main_login" class="main_login"></div>
	<div class="login_div" id="login_div">
		<div class="login_head">
			<h1>Login</h1>
			<span class="login_head_right"> <span
				class="login_head_right_none">No Account</span>&nbsp;&nbsp;&nbsp;<a
				href="<%=basePath%>isAgree.do">Register</a> </span>
		</div>
		<div class="login_form">
			<form action="<%=basePath%>login.do" method="post">
				<input type="hidden" value="" id="login_href" name="login_href">
				<table>
					<tr>
						<td><input type="text" name="userName" placeholder="User Name"
							class="login_td"></td>
					</tr>
					<tr>
						<td><input type="password" name="password" placeholder="Cipher"
							class="login_td"></td>
					</tr>
					<tr>
						<td><input class="login_but" accesskey="l" value="Login"
							tabindex="5" type="submit"> <!-- <span class="login_span"><input type="checkbox" name="">保持登录</span> -->
							<span class="login_span"><a
								href="<%=basePath%>ToGetBackPwd.do">Forget Cipher？</a>
						</span></td>
					</tr>
				</table>
			</form>
		</div>
		<!-- <div class="login_other">
			<p>login other way</p>
			<div style="width:380px;height:80px;padding-top:20px;">
				<button class="login_sina"></button>
				<button class="login_qq"></button>
			</div>
		</div> -->
	</div>
	<!---------------------------login_end  ------------------------->
	<!--head begin-->
	<div ID="head" class="head">
		<!--top-->
		<div id="top" class="top">
			<div class="top-btn-left">
				<a href="javascript:AddFavorite(window.location,document.title)">Save Us</a>
				<!-- <a href="javascript:void(0)">联系我们</a> -->
			</div>

			<div class="top-btn-right">

				<!-- <div class="language">
					<a href="javascript:changeLocale('locale=zh_CN')">简</a> 
					<a href="javascript:changeLocale('locale=zh_TW')">繁</a>
					<a href="javascript:changeLocale('locale=en_US')">EN</a>
				</div>  -->
				<c:if test="${!empty userInfo }">
					<div class="user-btn">
						<ul>
							<span class="ban">&nbsp;</span>
							<li id="personPic"><a><img
									src="<%=basePath%>${userInfo.headImg}" width="20" height="20" />
							</a>
								<div class="personInfo" id="personInfo">
									<div class="personInfoPart1">
										<a href="<%=basePath%>web/Blog/${userInfo.nickName}"> <img
											src="<%=basePath%>${userInfo.headImg}" width="90" height="90" />
										</a>
										<div class="personInfoDetail">
											<p>
											<h3>${userInfo.nickName}</h3>
											</p>
											<p>

												<span>Level：</span>

												<c:forEach begin="1" end="${userInfo.userLevel}" step="1">
													<img src="<%=basePath%>images/Forums/star.png" width="10px"
														height="10px" />
												</c:forEach>
												<c:forEach begin="${userInfo.userLevel+1}" end="7" step="1">
													<img src="<%=basePath%>images/Forums/0star.png"
														width="10px" height="10px" />
												</c:forEach>

											</p>
											<br /> <a class="pConfig"
												href="<%=basePath%>u/detail/${userInfo.id}.html"><span
												class="icon-pConfig"></span>Edit</a>
										</div>
									</div>
									<div class="personInfoPart2">
										<div class="config">
											<a href="<%=basePath%>u/setting/password"><span
												class="icon-cog"></span>Setting</a>

										</div>
										<div class="logout">
											<a href="<%=basePath%>logout.do" title="Exit"><span
												class="icon-logout"></span> </a>
										</div>

									</div>

								</div></li>


							<span class="ban">&nbsp;</span>
							<li style="height: 30px;"><div class="config">
									<a href="<%=basePath%>/web/PrivateMsg/RecBox"><span
										class="icon-msg"></span><em>${newMsgCount }</em> </a>

								</div></li>
							<span class="ban">&nbsp;</span>
						</ul>



					</div>
				</c:if>




				<div class="charge">
					<c:if test="${empty userInfo }">
						<span class="ban">&nbsp;</span>
						<a href="javascript:void(0)" id="login_all">Log in</a>
						<span class="ban">&nbsp;</span>
						<a href="<%=basePath%>isAgree.do">Register</a>
					</c:if>
					<span class="ban">&nbsp;</span> <a
						href="<%=basePath%>ToGetBackPwd.do">Find Cipher</a> <span class="ban">&nbsp;</span>
					<a href="javascript:void(0)">Voucher Center</a> <span class="ban">&nbsp;</span>
				</div>
			</div>
			<!---top-btn-right  end-->
		</div>
		<!--top end-->
		<!--logo-->
		<div class="logo">
			<div class="yszs">
				<a href="#"><img src="<%=basePath%>img/Index-logo.png" /> </a>
			</div>
			<div class="searchBanner">
				<FORM name="search_form_1" id="search_form_1"
					action="<%=basePath%>search.do">
					<DIV class="search-text-con2">
						<INPUT name="search" class="search-text2" id="q1" type="text"
							value="" autocomplete="off" path="q" placeholder="  input keyword">
						<input type="hidden" id="txtSear" value="0" name="searchMethod" />
					</DIV>
					<DIV class="search-btn-con2">
						<INPUT class="search-btn2" type="submit" value="Search">
					</DIV>
				</FORM>
			</div>
			<div class="app">
				<a href="javascript:void(0)"></a>
				<h3 style="font-size:14px;">App Download</h3>
			</div>

		</div>
		<!--logo end-->
		<!--nav-->
		<div class="nav">
			<ul>
				<li><a href="<%=basePath%>toIndexHome">Frontpage</a></li>
				<li><a href="<%=basePath%>web/Blog/index.html">Blog</a></li>
				<li><a href="<%=basePath%>listPostByBoard">Forum</a></li>
				<li><a href="<%=basePath%>web/QandA/Home.html">Q & A</a></li>
				<li><c:if test="${userInfo.role.id!=1 }">
						<a href="<%=basePath%>contact.do">Service Center</a>
						</c:if>
						<c:if test="${userInfo.role.id==1 }">
						<a href="<%=basePath%>toManagement">Supervision</a>
						</c:if></li>
				<li><a href="<%=basePath%>faq.do">Regulation</a></li>
			</ul>
		</div>
		<!--nav end-->
		<!--pic-->
		<div class="Logo_pic"></div>
		<!--pic end-->



	</div>
	<!--head end-->

<div id="index">
<font>ask</font>
</div>
<div class="post_main">
    
    <form action="<%=basePath%>web/QandA/AskQ" method="post">
    <table  style="border-bottom:none;">
    <tr>
       <td id="td1">title</td>
       <td id="td2">
       <input  type="text"  name="qSubject" style="width:350px;height:30px" />
       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
       <span id="errorSub" style="visibility:hidden;color:red;font-size:10px ;width:120px;">*file the title</span>
       </td>
    </tr>
            <tr>
			<td id="td1">content</td>
			<td id="td2"><textarea name="qContent" style="width:450px;height:180px"></textarea>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<span id="errorCon" style="visibility:hidden;color:red;font-size:10px;vertical-align:top;">*file the content</span>
			</td>
			</tr> 
    <tr>
       <td id="td1">union</td>
       <td id="td2">
           <select  name="board_id"  id="board"  style="width:350px;height:30px">
            <option value="" selected="selected">select </option>
            <c:forEach items="${requestScope.board}" var="b"  >
            <option  value="${b.getId() }"> ${b.getBoardName()}</option>    
            </c:forEach>
            </select>
             <a href="<%=basePath%>addLabelApply"
								style="margin-left: 20px; padding: 1px 12px;" targer="_blank"
								class="submitButton" type="button">apply to add label</a>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <span id="errorBod" style="visibility:hidden;color:red;font-size:10px" >*fill the union</span>
       </td>
    </tr>
    <tr>
       <td id="td1">label</td>
       <td id="td2">
       <span id="ajaxLabel" class="label"></span>
      
       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
       <span id="errorLab" style="visibility:hidden;color:red;font-size:10px">*fill the label</span>
       </td>
    </tr>
    
    
    <tr>
       <td id="td1">reward point</td>
       <td id="td2">
       <input type="text"  id="valueId" name="value" style="width:150px;height:30px" value=0 /> 
      <input type="radio" name="radiovalue" value="jinzhuan" checked="checked"/>brick
      <input type="radio" name="radiovalue" value="lingdan"/>panacea
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <span>
      <input id="Orgjinzhuan" type="hidden" value="${userInfo.getJinzhuan() }"/>
       <input id="Orglingdan" type="hidden" value="${userInfo.getLingdan() }"/>
       <br/>
       <label>account balance&nbsp;&nbsp;&nbsp;&nbsp;</label>
       <label>brick:</label><label>${userInfo.getJinzhuan() }</label>
       <label>&nbsp;/&nbsp;panacea:</label><label>${userInfo.getLingdan() }</label>
       
       
       <a id="errorVal" href="<%=basePath%>web/QandA/chongzhi.jsp" style="visibility:hidden;color:red;font-size:10px;text-decoration:underline;"  >please recharge  </a> 
      </span>
	   </td>
    </tr>
    
    <tr>
       <td id="td1">to set answer level</td>
       <td id="td2">
          <input type="radio"  name="check" id="check" value="ischeck"/>yes&nbsp;&nbsp;&nbsp;
          <input type="radio"  name="check" value="nocheck" id="nocheck" checked="checked"/>no
          
          <span id="q_div" style="display:none">
             required level:<select name="qAccess" style="width:100px;height:30px" id="qAccess">
                       <c:forEach begin="1" end="${userInfo.userLevel}" step="1" var="x">
                           <option value="${x}" style="color:blue;">${x} 
                         	 star user</option>
                       </c:forEach>
                       <c:if test="${userInfo.userLevel<7}">
                       <c:forEach begin="${userInfo.userLevel+1}" end="7" step="1" var="x">
                            <option value="${x}" style="color:red;">${x} 
                            	star user</option>
                       </c:forEach>
                       </c:if>
          </select>
          <input type="hidden" id="lingdan" value="${userInfo.lingdan }"/>
          <input type="hidden" id="userLevel" value="${userInfo.userLevel }"/>
          <span id="access_info" style="font-size:12px;color:red;display:none;">please recharge</span>
          <font style="font-size:12px;color:blue;">&nbsp;&nbsp;*Pay a pananea to set answer level higher than you.</font>
          
          </span>
          
	   </td>
    </tr> 
    <tr>
       <td id="td1">ask as anonymous</td>
       <td id="td2">
          <input type="radio" name="hiddenUser" value="checked"/>yes&nbsp;&nbsp;&nbsp;
          <input type="radio"  name="hiddenUser" value="nocheck" checked="checked"/>no
          
	   </td>
    </tr>
    
    <tr>
       <td id="td1">&nbsp;</td>
       <td id="td2">
          <input id="subMit" type="submit" value="submit question" class="submitButton"/>
	   </td>
    </tr>

    </table>

    </form>



</div>

<!--footer-->

	<div class="footer">
		<h3>Copyright © 2014 JIE & C DEV(HK)CO L.&nbsp;&nbsp;All Rights Reserved.</h3>
	</div>
	<!--footer end-->
  </body>
</html>
      