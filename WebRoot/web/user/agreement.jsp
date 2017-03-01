<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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

<title><fmt:message key="注册协议"></fmt:message></title>

<meta http-equiv="x-ua-compatible" content="ie=8" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="<%=basePath%>css/home.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>css/qiantai/more.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>css/qiantai/agree.css" rel="stylesheet"
	type="text/css" />
<link type="text/css" href="<%=basePath%>css/button.css"
	rel="stylesheet" />
<link href="<%=basePath%>css/qiantai/login.css" rel="stylesheet" type="text/css" />

<script type="text/javascript"
	src="<%=basePath%>js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/index/index.js"></script>
<script type="text/javascript" src="<%=basePath%>js/index/language.js"></script>
<script type="text/javascript" src="<%=basePath%>js/login_all.js"></script>

</head>
<link type="image/x-icon" href="<%=basePath%>img/bitbug_favicon.ico"
	rel="shortcut icon" />

<link href="<%=basePath%>css/headfoot.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>css/index_default.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>css/Index/index.css" rel="stylesheet"
	type="text/css" />
</head>

<body>
<!---------------------------login_begin  ------------------------->
<div id="main_login" class="main_login">
  </div>
  <div class="login_div" id="login_div">
        <div class="login_head">
          <h1>会员登录</h1>
          <span class="login_head_right">
              <span class="login_head_right_none">还没账号</span>&nbsp;&nbsp;&nbsp;<a href="<%=basePath%>isAgree.do">免费注册</a>
          </span>
        </div>
        <div class="login_form">
           <form action="<%=basePath %>login.do" method="post">
            <input type="hidden" value="" id="login_href" name="login_href">
              <table>
                  <tr>
                     <td>
                         <input type="text" name="userName" placeholder="用户名" class="login_td">
                     </td>
                  </tr>
                  <tr>
                     <td>
                         <input type="password" name="password" placeholder="密码" class="login_td">
                     </td>
                  </tr>
                  <tr>
                     <td>
                          <input class="login_but" accesskey="l" value="登 录" tabindex="5" type="submit">
                          <!-- <span class="login_span"><input type="checkbox" name="">保持登录</span> -->
                          <span class="login_span"><a href="<%=basePath%>ToGetBackPwd.do">忘记密码？</a></span>
                     </td>
                  </tr>
              </table>
           </form>
        </div>
        <div class="login_other">
           <p>用第三方账号直接登录</p>
           <div style="width:380px;height:80px;padding-top:20px;">
               <button class="login_sina"></button>
               <button class="login_qq"></button>
           </div>
        </div>
      </div>
    <!---------------------------login_end  ------------------------->
	<!--head begin-->
	<div ID="head" class="head">
		<!--top-->
		<div id="top" class="top">
			<div class="top-btn-left">
				<a href="javascript:AddFavorite(window.location,document.title)">收藏友识知世</a>
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

												<span>等级：</span>

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
												class="icon-pConfig"></span>编辑个人资料</a>
										</div>
									</div>
									<div class="personInfoPart2">
										<div class="config">
											<a href="<%=basePath%>u/setting/password"><span
												class="icon-cog"></span>账户设定</a>

										</div>
										<div class="logout">
											<a href="<%=basePath%>logout.do" title="退出"><span
												class="icon-logout"></span>
											</a>
										</div>

									</div>

								</div>
							</li>


							<span class="ban">&nbsp;</span>
							<li style="height: 30px;"><div class="config">
									<a href="<%=basePath%>/web/PrivateMsg/RecBox"><span
										class="icon-msg"></span><em>${newMsgCount }</em>
									</a>

								</div>
							</li>
							<span class="ban">&nbsp;</span>
						</ul>



					</div>
				</c:if>




				<div class="charge">
					<c:if test="${empty userInfo }">
						<span class="ban">&nbsp;</span>
						<a href="javascript:void(0)" id="login_all">立即登录</a>
						<span class="ban">&nbsp;</span>
						<a href="<%=basePath%>isAgree.do">免费注册</a>
					</c:if>
					<span class="ban">&nbsp;</span> <a
						href="<%=basePath%>ToGetBackPwd.do">找回密码</a> <span class="ban">&nbsp;</span>
					<a href="javascript:void(0)">充值中心</a> <span class="ban">&nbsp;</span>
				</div>
			</div>
			<!---top-btn-right  end-->
		</div>
		<!--top end-->
		<!--logo-->
		<div class="logo">
			<div class="yszs">
				<a href="#"><img src="<%=basePath%>img/Index-logo.png" />
				</a>
			</div>
			<div class="searchBanner">
				<FORM name="search_form_1" id="search_form_1"
					action="<%=basePath%>search.do">
					<DIV class="search-text-con2">
						<INPUT name="search" class="search-text2" id="q1" type="text"
							value="" autocomplete="off" path="q" placeholder="请键入关键词">
						<input type="hidden" id="txtSear" value="0" name="searchMethod" />
					</DIV>
					<DIV class="search-btn-con2">
						<INPUT class="search-btn2" type="submit" value="搜一搜">
					</DIV>
				</FORM>
			</div>
			<div class="app">
				<a href="javascript:void(0)"></a>
				<h3 style="font-size:14px;">移动端下载</h3>
			</div>

		</div>
		<!--logo end-->
		<!--nav-->
		<div class="nav">
			<ul>
				<li><a href="<%=basePath%>toIndexHome">首页</a></li>
				<li><a href="<%=basePath%>web/Blog/index.html">博客展示</a></li>
				<li><a href="<%=basePath%>listPostByBoard">论坛交流</a></li>
				<li><a href="<%=basePath%>web/QandA/Home.html">问答互助</a></li>
				<li><c:if test="${userInfo.role.id!=1 }">
						<a href="<%=basePath%>contact.do">联系客服</a>
						</c:if>
						<c:if test="${userInfo.role.id==1 }">
						<a href="<%=basePath%>toManagement">网站管理</a>
						</c:if></li>
				<li><a href="<%=basePath%>faq.do">常见问题</a></li>
			</ul>
		</div>
		<!--nav end-->
		<!--pic-->
		<div class="Logo_pic"></div>
		<!--pic end-->



	</div>
	<!--head end-->

	<!--main start-->
	<div class="main">
		<div class="main_head">
			<h3 style="font-size:30px;margin-top:20px;">
				服 务 声 明
			</h3>
		</div>
		<style>
.main {
	height: auto;
	overflow: hidden;

}

.main_content p{
	width: 800px;
	white-space: normal;
	margin: 5px auto;
}
</style>
		<div class="main_content">

<br/><br/><br/>


			<p>


欢迎光临友识知世<sup>®</sup>网站，并请仔细阅读以下条款；您首先应当完全同意本声明协议的所有内容，然后进入网站浏览以认识更多的有识之士，并可根据提示完成注册程序，发起讨论、参与交流；用户进入网站即视为已了解并同意遵守本协议项下的全部规定，且接受本网站的统一管理；若用户对该声明的任何条款有异议，则请停止使用本网站所提供的全部服务。敬请理解。
</p><br/><p>
一、友识知世<sup>®</sup>网站是向用户（包括注册用户和浏览用户）提供友好讨论、优质交流的平台，您需要遵守中华人民共和国的互联网相关管理条例、所在地的社会公德，其中包括不得利用本站危害国家安全、不得侵犯国家、社会和公民的合法权益、不得利用本站制作、复制和传播有害信息（例如：违反及破坏宪法和法律法规实施的；破坏国家统一和民族团结的；歪曲事实或者传播谣言，扰乱社会秩序的；宣扬封建迷信、淫秽色情、赌博、暴力恐怖、教唆犯罪的；侮辱及诽谤他人，或者在站内骚扰他人、进行恶意攻击的；任何形式的商业广告；无实际意义的各类灌水、或使用多个（三个及以上）账号等违规发帖、非法获取积分的；发布侵权及违法链接的；所发表文章等包含有严重影响其他用户浏览的内容或格式的；含有虚假、粗俗、侵犯隐私、或其它在道德上令人反感的内容）等。
</p><br/><p>
二、友识知世<sup>®</sup>网站的层次，与广大参与用户自身的水平息息相关，大家若希望能够结识并彼此欣赏更多的有识之士，拥有健康、有益、高尚、正能量的互动讨论氛围，则请您从自己做起，并互相规劝，使大家都能获得应有的尊重和乐趣；为了能够给广大用户尽力提供一个优质的平台，本网站拥有对违反本站使用规则者进行警告、删文、禁言，直至封闭清空其账号等严厉处理的权力，并保留移交司法机关处理的权利；您应独立承担一切因其个人的行为而可能直接或间接导致的民事或刑事法律责任；因用户不当行为给本网站造成损失的，用户需负责赔偿；若您发现有任何人涉嫌违反该协议规定进行信息传播的，可及时向本网站进行投诉处理。
</p><br/><p>
三、友识知世<sup>®</sup>网站关注、并呼吁广大用户都同样尊重他人的知识产权和合法权益。本网站中用户发表的各类文章作品，应有合法来源，相关内容为您所有或您已获得权利人的授权，且仅表明用户作者个人的立场和观点，并不代表本网站；对于转载至本网站的信息，请写明转载和出处，以尊重原作者的著作权；请您对自己发布的信息资源、参与的讨论问答、表达的个人观点，始终保持认真负责和客观公正的态度；对由于用户言论、或用户之间交流可能产生的任何法律纠纷或损失，该内容的发表者需自行解决并承担全部的责任，本网站不承担任何法律及连带责任。
</p><br/><p>
四、用户于任何时间段在友识知世<sup>®</sup>网站所发表作品内容的著作财产权，用户许可本网站在全世界范围内免费地、永久性地、不可撤销地、非独家地使用及转授的权利，包括但不限于：复制权、发行权、出租权、展览权、表演权、放映权、广播权、信息网络传播权、摄制权、改编权、翻译权、汇编权以及《著作权法》规定的由著作权人享有的其他著作财产权利。
</p><br/><p>
五、友识知世<sup>®</sup>网站所包含信息内容的知识产权均受到法律保护，未经本网站许可，不得任意复制或转载；未经本网站书面授权，不得以任何形式创造相关衍生作品，或用于商业盈利等用途；使用本网站的任何内容均应注明"来源于友识知世<sup>®</sup>网站"及署上作者姓名，按法律规定需要支付稿酬的，应当通知本网站和作者及支付稿酬，并独立承担一切法律责任；恶意转载站内内容的，本网站保留诉诸法律的权利。
 </p><br/><p>
六、友识知世<sup>®</sup>网站高度重视知识产权保护，并遵守中国各项知识产权法律、法规和具有约束力的规范性文件；根据法律、法规和规范性文件要求，本网站制定了旨在保护知识产权权利人合法权益的措施和步骤，如果权利人发现在本网站的内容侵犯其著作权等相关权益时，权利人应事先向本网站发出书面的“权利通知”，并提供身份证明、权属证明、详细侵权情况说明及真实性声明；本网站将根据中国法律法规和政府规范性文件，采取措施移除相关内容或断开相关链接。
</p><br/><p>
七、您理解并同意，友识知世<sup>®</sup>网站的服务是按照现有技术和条件所能达到的现状提供的；本网站会尽最大努力向用户提供服务，确保服务的连贯性和安全性，但不能随时预见和防范法律、技术以及其他风险，包括但不限于不可抗力、病毒、木马、黑客攻击、网络故障、系统不稳定、第三方服务瑕疵、政府行为等原因可能导致的服务中断、数据丢失以及其他的损失和风险；如因系统维护或升级等而需暂停服务时，本网站将事先公告；若因硬件故障或不可抗力等而导致暂停服务，或由于网站调整导致信息丢失或其他结果的，本网站不承担任何责任，对网络服务的及时性、安全性、准确性也都不作担保。
</p><br/><p>
八、鉴于网络服务的特殊性，您理解并同意友识知世<sup>®</sup>网站有权不经事先通知，随时变更、中断或终止部分或全部的网络服务；无论通知与否，本网站对用户和任何第三人均无需承担任何责任；如用户有违反本协议中规定的使用规则，或注册的账号在任何连续180日内未实际使用的，本网站保留删除账号并停止提供服务的权利。
</p><br/><p>
九、"友识知世<sup>®</sup>"及相关LOGO标识、网站设计、源代码等，均为杰宸公司所有，并已进行商标及著作权等知识产权登记注册；任何人未经许可，请勿以任何形式擅自使用。
</p><br/><p>
十、本声明协议的最终解释权归属友识知世<sup>®</sup>网站和杰宸公司；本网站保留随时修订条款政策的权利，因此我们建议您定期查阅本页面，以确保清楚有关政策的最新内容。
</p><br/><p>

二零一四年十月二十七日
</p><br/>
			<table>
				<tr>
					<td><a href="<%=basePath%>agree.do"><button
								class="submitButton"
								style="margin-left: 320px;margin-top: 100px;"
								onclick="javascrtpt:window.location.href='<%=basePath%>agree.do'">
								<fmt:message key='我同意'></fmt:message>
							</button></a></td>
					<td><a href="<%=basePath%>unagree.do"><button
								class="submitButton"
								style="margin-left: 100px; margin-top: 100px;"
								onclick="javascrtpt:window.location.href='<%=basePath%>unagree.do'">
								<fmt:message key='我不同意'></fmt:message>
							</button></a></td>
				</tr>
			</table>
			<br/><br/><br/>
		</div>
	</div>
	<!--main end-->

<!--footer-->

	<div class="footer">
		<h3>Copyright © 2014 傑宸發展（香港）有限公司版權所有.&nbsp;&nbsp;All Rights Reserved.</h3>
	</div>
	<!--footer end-->
</body>
</body>
</html>
