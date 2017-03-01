<%@ page contentType="image/jpeg" language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>My JSP 'makeCertPic.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	
  </head>
  
  <body>
    <jsp:useBean id="makeCertPic" scope="page" class="com.bbsBlog.util.MakeCertPic" />
　　<%
		String str=makeCertPic.getCertPic(120,37,response.getOutputStream());		
		session.setAttribute("certCode", str);
		
		//由于jsp container在处理完成请求后会调用releasePageContet方法释放所用的PageContext object,
		//并且同时调用getWriter方法,由于getWriter方法与在jsp页面中使用流相关的getOutputStream方法冲突,
		//所以会造成这种异常,解决办法是:只需要在jsp页面的最后加上两条语句:  out.clear();
		//out=pageContext.pushBody();即可(其中out,pageContext均为jsp内置对象!) 
		
		out.clear();
		out = pageContext.pushBody();
	%>

  </body>
</html>
