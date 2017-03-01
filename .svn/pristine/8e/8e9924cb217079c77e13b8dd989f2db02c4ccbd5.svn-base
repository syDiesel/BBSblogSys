<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
    
    <meta http-equiv="refresh" content="0;url=<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/" %>toIndexHome">
    
    
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
    <h2><font color="red">测试页面..</font></h2>
    <hr/>

    
     后台主页面:<br>
    <ul>    	
    	<li><a href="./web/management/main.jsp">后台主页完整版</a></li><br/>  
    	<li><a href="<%=basePath %>toManagement">后台主页控制器</a></li><br/>  
    	           
    </ul> 
    <hr/>
    网站前台:<br>
    <ul>
    	<li><a href="/BBSblogSys/toIndexHome" >首页</a></li>    
    </ul>
    论坛发布：<br>
    <ul>
    	<li><a href="listPostByBoard" >论坛</a></li>    
    </ul>
        博客发布：<br>
    <ul>
    	<li><a href="/BBSblogSys/web/Blog/home.jsp" >博客首页</a></li>    
    </ul>

<br>
    <ul>
    	<li><a href="/BBSblogSys/web/user/login.jsp" >用户登录</a></li>    
    	<li><a href="/BBSblogSys/web/user/register.jsp" >用户注册</a></li>    
    </ul>
   <hr/>
   
私信：<br>
    <ul>
    	<li><a href="/BBSblogSys/web/PrivateMsg/sendPM.jsp" >发送PM</a></li>    
    	<li><a href="/BBSblogSys/web/PrivateMsg/sendBox" >发信箱</a></li>    
    		<li><a href="/BBSblogSys/web/PrivateMsg/RecBox" >收信箱</a></li> 
    </ul>
    
  </body> 
</html>
