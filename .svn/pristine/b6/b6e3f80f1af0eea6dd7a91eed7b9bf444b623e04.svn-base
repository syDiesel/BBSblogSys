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

<title>用 户 指 南</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
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
<link href="<%=basePath%>css/qiantai/login.css" rel="stylesheet" type="text/css" />	
	
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
	<style>
.main {
	height: auto;
	overflow: hidden;
}
.main{
	width:900px;
	min-height:650px;
	margin:10px auto;
	background-color: white;
	
}
.main_head h2{
	font-size:18px;
	margin: 5px auto;
}
.main_head h2{
	text-align:center;
}
.main_content p {
	width: 800px;
	white-space: normal;
	margin: 5px auto;
}
</style>

	<!--main start-->
	<div class="main">
		<div class="main_head">
			<h2>
				用 户 指 南
			</h2>
		</div>

		<div class="main_content">

<p class="MsoNormal" style="text-indent:26.35pt;margin-top:20px;margin-top:20px;">
	<b><span style="font-family:宋体;">一、网站宗旨：<span></span></span></b>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">通过“以文会友”等形式，邀请各行各业的有识之士和专业才俊，充分展示思想、才能，促进相互间的高尚交流。<span></span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">&nbsp;</span>
</p>
<p class="MsoNormal" style="text-indent:26.35pt;margin-top:20px;">
	<b><span style="font-family:宋体;">二、栏目设置：<span></span></span></b>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">网站下设多个兴趣专题（兴趣联盟），均划分为：博客展示、论坛交流、问答互助三个子版块。<span></span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">&nbsp;</span>
</p>
<p class="MsoNormal" style="text-indent:26.35pt;margin-top:20px;">
	<b><span style="font-family:宋体;">三、会员管理；<span></span></span></b>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">会员的管理采取分级体制（评定分为<span>7</span>个星级，会员标识下用最多七颗星显示），以公开、公平的累积积分为基础。<span></span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">&nbsp;</span>
</p>
<p class="MsoNormal" style="text-indent:26.35pt;margin-top:20px;">
	<b><span style="font-family:宋体;">四、兴趣专题：<span></span></span></b>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">各个兴趣联盟（专题），下列多个分类标签，并可按标签进行此项排名（博客按所获欣赏的积分数，论坛按跟帖回复数，问答按所获欣赏的积分数）。<span></span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">&nbsp;</span>
</p>
<p class="MsoNormal" style="text-indent:26.35pt;margin-top:20px;">
	<b><span style="font-family:宋体;">五、标签设立：<span></span></span></b>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">会员在初始注册进入网站后，可以写博客文章，也可以发起论坛话题、或提问<span>/</span>回答。无论何种形式，会员都须填写<span>1-3</span>个标签（即该拟发表内容的关键字；第一个自动默认为大标签，即最主要的属性分类），然后在该分类标签下发表博文等。如无感觉合适的分类标签，会员可向管理员申请自行添加标签。<span></span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">&nbsp;</span>
</p>
<p class="MsoNormal" style="text-indent:26.35pt;margin-top:20px;">
	<b><span style="font-family:宋体;">六、站内支付：<span></span></span></b>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">本站设有“金砖”、“灵丹”两种虚拟的支付方式。“金砖”对应一个会员积累的点赞数，象征其能力级别；“灵丹”对应实际的货币（人民币）交易，象征能打破一般规则所需的报酬。<span></span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">1</span><span style="font-family:宋体;">颗灵丹<span> = 1</span>块金砖<span>= 1</span>元人民币；“金砖”与货币实际交易完全无关，只具有等效意义；“灵丹”则等值于实际货币。<span></span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">&nbsp;</span>
</p>
<p class="MsoNormal" style="text-indent:26.35pt;margin-top:20px;">
	<b><span style="font-family:宋体;">七、交流规则：<span></span></span></b>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">高级别会员对于低级别会员总具有优先权；一般来说，会员有权向同级或较低级别会员要求一定的“金砖”或者“灵丹”（具体哪种方式，由会员自行决定）作为回报，来享受其提供的服务（如资源区文章、参加讨论帖、回答问题）；如果会员向更高级别会员提出要求，则必须以支付“灵丹”形式进行回报。<span></span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">&nbsp;</span>
</p>
<p class="MsoNormal" style="text-indent:26.35pt;margin-top:20px;">
	<b><span style="font-family:宋体;">八、博客展示：<span></span></span></b>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">会员可对其个人主页中的所属文章进行设定；展示区是对所有人（包括游客）公开，资源区则可自行设限，需要具备一定权限或者要求站内</span><span style="font-family:宋体;">支付（灵丹或金砖）才可以进入。</span><span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">对于资源区的观看，会员自行设定（其星级或以下人员观看的）权限，针对每篇文章，其它会员需支付<span>1</span>颗灵丹或<span>1</span>块金砖（发起会员可选择支付方式，可以为任意一种，也可以指定必须其中一种），才能进入观看。例如会员<span>A</span>为<span>3</span>星级，则<span>A</span>有权设定其资源区的文章，<span>0-3</span>星级的人需要缴纳才能观看。<span></span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">如果用金砖支付，则需求者需要相应减少其积分（积分由他人点赞欣赏、自己发表文章等途径获得），相应的博主增加积分；如果用灵丹支付，则需求者需首先进行网站充值，然后支付给博主。资源区具有部分预览功能。<span></span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">高级别的会员可以进入低级别会员的资源区。如果低级别会员希望获得连高级别会员都无法进入的权限，则每篇文章需要支付<span>1</span>颗灵丹。<span></span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">&nbsp;</span>
</p>
<p class="MsoNormal" style="text-indent:26.35pt;margin-top:20px;">
	<b><span style="font-family:宋体;">九、论坛交流：<span></span></span></b>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">会员及游客均可浏览板块内的话题帖子，但发起会员可以自行设定，使得只有部分授权会员才可以参加评论回复。<span></span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">每个注册的会员都可发起话题帖子，且有权设定一定级别以上的会员（该权限只能是其星级及以下）才可以参与其话题讨论。例如，<span>A</span>会员为<span>3</span>星级，则<span>A</span>可自行设定<span>0-3</span>星级（低于其会员级别）以上的会员才可参与讨论<span>A</span>发起的话题（也就是说，若<span>A</span>愿意，则只有一定级别的人方可被限定参加他发起的讨论）。当然，<span>A</span>也可以选择不设定，则所有会员（不包括游客）均能参加回复评论。<span></span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">请注意，星级高于<span>A</span>的会员则不会受到限制。例如，一个<span>5</span>星级的人<span>B</span>，可以自由参与任何等于或低于<span>5</span>星会员发起的讨论，即从高星级向低星级往往是有优先权的。<span></span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">若低星级会员希望参加高星级限定的帖子，则需要缴纳<span>1</span>颗灵丹或<span>1</span>块金砖（由帖子发起者在发帖限定时即自行选择例外及支付方式；当然他也可以选择根本不允许例外）。例如会员<span>A</span>为<span>3</span>星级，发起了一个需要<span>2</span>星级以上会员才可以回复的话题，且允许支付<span>1</span>块金砖的例外情况，则<span>1</span>星级会员<span>B</span>，需缴纳费用（<span>1</span>块金砖）才能参加发言。<span></span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">如果发帖会员要求其它的非默认限定，例如要求高于他本人级别以上的人才能发言，或者更加精准的限定，则需要支付给系统一颗灵丹。例如会员<span>A</span>为<span>3</span>星级，则<span>A</span>需缴纳一颗灵丹，才能有权设定他发起的话题只有<span>4</span>星级以上的人才能参加发言。<span></span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">会员发起的话题可以是针对该兴趣专题版块的某一问题，也可以是博客展示文章中直接引出的讨论。<span></span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">为了避免灌水等不良行为，本网站的博客展示栏目仅供发表文章等和他人点赞欣赏，不支持直接评论。有关评论，将自动转至论坛栏目。（首先需要博客作者提前设定，允许他人转至论坛进行公开评论）<span></span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">评论要求在<span>100-1000</span>字之间；评论在<span>10-100</span>字之间的，可以正常发表，但将不获得点赞欣赏功能，也就是说，即使他人点赞欣赏，也无法获得积分。<span></span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">同时，发起话题的会员也可以选择是否发起投票，并可自行确定投票选项，发起投票需要支付<span>10</span>颗灵丹。<span></span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">论坛中的讨论评论，也具备如博文一样的欣赏加分功能，即好、中、差三种统计，标准同博文点赞欣赏功能的十分之一。例如一个会员<span>A</span>在某话题中发表一个评论，一个<span>4</span>星级会员<span>B</span>看后，觉得不错点“欣赏”，则<span>A</span>可以获得<span>0.4</span>分。<span></span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">同样的，若点“一般”、“遗憾”，也如同博客栏目的点赞规则，即分数不增不减，只改变中评和差评的统计数量。<span></span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">请注意，与博客、问答栏目中的浏览者应当做出评价（系统自动提示）不同，对于论坛发帖评论的评价，是遵从自愿原则（即系统不会自动提示）。<span></span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">&nbsp;</span>
</p>
<p class="MsoNormal" style="text-indent:26.35pt;margin-top:20px;">
	<b><span style="font-family:宋体;">十、问答互助：<span></span></span></b>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">会员可以自由发起专业提问（同样的，要首先设定至少一个主标签），并悬赏酬谢<span>0-100</span>颗灵丹或<span>0-100</span>块金砖（支付灵丹需先充值现金后转到网内灵丹账户，支付金砖则将扣除提问会员的金砖点数并转给回答会员；无论灵丹还是金砖的余额不够的，则提问者不能继续看回答者的应答）。<span></span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">会员在提问时，为了避免参与人过多，可以指定一定星级以上的会员进行应答。这时，无论他指定的星级是比本身高或低，他都要缴纳给系统（针对每个问题）一颗灵丹。<span></span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">会员提问后，往往会有多人应答，答案将分别提供给提问者，提问者只有在支付所承诺的灵丹或者砖后，才能看到答案（一般来说，提问者将考虑回答者的背景级别，慎重的、有选择性的点击一部分甚至一个答案）。<span></span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">提问者支付的灵丹或者金砖，先进入系统的支付中转站，一旦提问者看到答案，并给予了评价后，报酬将会正式到达回答者的账户，同时答案将自动在系统中公开展示。<span></span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">若提问者看到答案，但并不满意，可以暂不评论，而进行最多三次追问。每次追问并获得回答后，系统会提示提问者是否要评价，直到第三次提示时，提问者必须作出评价。若提问者未主动评价就关闭页面等的，则视为默认“一般”。只有在提问者给予了评价后，答案才会自动在系统中公开展示。<span></span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">若提问者追问后，而回答者拖延回答，自首次追问起一个月内回答者仍未回应追问的，则报酬将退回给提问者，同时系统提示提问者仍作评价，之后公开已有的回答。<span></span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">请注意：提问者可以有选择无偿提问的权利，而回答者也有选择放弃报酬的权利，即并不是所有的问答都有偿，也可以是完全无偿的，这完全取决于问答双方的意愿。例如，会员<span>A</span>提出一个问题，可以悬赏（当然也可以选择“无酬谢提问”），并自我设定报酬额为<span>50</span>灵丹；会员<span>B</span>进行回答，可以在回答前选择“接受酬谢”，也可以选择“无需酬谢回答”；前者情况下，一旦<span>A</span>看了<span>B</span>的回答，则无论<span>A</span>评价否，评价是何，只要正常回答最多三次追问，<span>B</span>最终都会自动获得<span>A</span>承诺的奖赏，即<span>50</span>灵丹；后者情况下，即使<span>A</span>看了<span>B</span>的回答，<span>B</span>也不会得到<span>A</span>承诺的奖赏。<span></span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">对于任何一个回答，提问者、及其他的浏览者，都须选择评价“欣赏”（回答者另外加<span>1</span>砖），“一般”或“遗憾”（不加不减金砖积分）。每个问题最终都有多种答案及相应的好中差评数量统计，其中提问者对答案的评价统计另列。<span></span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">为了保护会员隐私，提问者的身份可以自行选择不予暴露。<span></span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">&nbsp;</span>
</p>
<p class="MsoNormal" style="text-indent:26.35pt;margin-top:20px;">
	<b><span style="font-family:宋体;">十一、个人主页：<span></span></span></b>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">即个人展示部分，具有精简导读、信息索引、基本社交等功能。主要栏目有：<span></span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">个人展示区：发布的公开博文等资源；<span></span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">资源共享区：发布的有偿资源，其它会员需要花费积分等方式进入；<span></span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">站内信：用于会员之间及管理员发送各类活动及处理信息等；<span></span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">个人简介：个人基本信息、生活照片、资质能力证书等；资质证书可由会员进行密码或权限管理，并供其他会员浏览点赞欣赏，正常获得积分。<span></span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">个人社交：显示博主关注和关注博主的会员、我的好友（相互关注即为好友）及动态更新互通功能、每日心情短语；“送花”或“仰慕<span>”</span>者等；<span></span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">关注收藏：收藏或转载（至他处）的所浏览博文、参加的论坛帖子、回答过的问题及发起的提问；<span></span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">个人星级统计：个人总星级、金砖数（即总积分）、兴趣展示（即在各大兴趣版块的次积分统计、参与的多个专题小组（标签）及标签子项积分）；<span></span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">会员在网站中的星级，是他在所有大类中的累积积分综合决定的。例如，他在健康“兴趣联盟”有<span>1</span>万分，<span>4</span>星级，在社会“兴趣联盟”有<span>9</span>万分，同样是<span>4</span>星级，但他的综合级别是<span>5</span>星级<span>10</span>万分，也表明他在网站中任何一个分类，都具有<span>5</span>星级的权限（例如可以看<span>4</span>星及以下会员的资源区文章等）。<span></span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">&nbsp;</span>
</p>
<p class="MsoNormal" style="text-indent:26.35pt;margin-top:20px;">
	<b><span style="font-family:宋体;">十二、分级体制：<span></span></span></b>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">会员评定星级分为<span>7</span>星（会员标识下用最多七颗星显示星级），每个星级有<span>10<sup>n</sup></span>分（<span>n</span>为星级数，这里的积累分数用“金砖”表示，寓意经过不断的砖垒堆积，达到更高级别），最初（无展示文章）注册后即为有<span>1</span>分，累积满本级别内的分数则提升一星。<span></span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">每发表一篇<span>1000-10000</span>字的文章（或其它艺术形式的作品一个）、或者上传一个专业资质并经过后台审核后上传，可获得（某大分类之标签下）<span>1</span>分，但未经评论的会员最多不能超过<span>7</span>分。只有在经过其它会员的评论后，初始会员才有可能达到<span>10</span>分并成为<span>1</span>星会员。<span></span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">例如，某人<span>A</span>注册后成为会员，则有<span>1</span>分（<span>1</span>块金砖），然后上传若干文章和资质，达到最多<span>7</span>分，然后这些文章（他人可以点赞欣赏文章，也可以点赞欣赏资质）被评论后，例如被三个人（以一星会员点一次为例）点“好”后，就获得<span>3</span>分，从而变成<span>10</span>分，也就成为了<span>1</span>星会员（<span>10</span>分）。<span></span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">然后，这个<span>1</span>星会员不断发表文章，或者他的文章继续被点赞，积累到<span>100</span>分时，就成为<span>2</span>星会员。类似的，到了<span>5</span>星级，就意味着他有<span>10</span>万分。到了<span>7</span>星级，就意味着他有<span>1</span>千万分。<span></span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">博文分为公开展示区和限制资源区；都是以一篇<span>1000-10000</span>字的文章为基本单位（或者一篇画作、或者一部乐谱、或者一张照片）。<span></span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">博客文章（或资质等）的评论只分为“欣赏”、“一般”、“遗憾”三种，获得“欣赏”的（以一星会员点一次为例）得一分，“一般”和“遗憾”不得分。每个文章最终都要有好中差评数量统计。注意对文章没有具体评论留言功能，以简化统计，便于管理，以免灌水。<span></span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">任何人阅读完一篇文章后，系统都会提示：请尊重作者的劳动，进行评价；若仍不予评价而关闭页面，则默认为“一般”。此规则对于论坛评论、问答评价也同样适用。<span></span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">100</span><span style="font-family:宋体;">个游客或者<span>10</span>个（<span>0</span>星级）会员点赞“欣赏”，有<span>1</span>分。<span></span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">7</span><span style="font-family:宋体;">星级一次点赞可以给<span>7</span>分，<span>3</span>星级给<span>3</span>分，<span>1</span>星级给<span>1</span>分。<span></span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">对于一篇文章，每个<span>IP</span>地址的会员只能点评一次。<span></span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">对于上传有国家级或高级专家类资质的，或者有特殊影响力的专业名人等，经过审核认证后，网站管理员有权考虑破格直接给予<span>X</span>星以上的头衔。<span></span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">每个会员在完成注册时，会自动生成该网站的个人交易账户，该交易账户为用户实际支付购买“灵丹”的账户，与积分“金砖”无关；账户用于站内会员间进行实际货币的虚拟资源交易。<span></span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">会员可以发表转载他人或别处（非本网站）的文章等，以鼓励会员收集整理非原创、却仍然有益的知识信息。但会员必须选择注明“转载”字样，并注明出处（系统可以提示选择默认“来源于网络”）。其他会员对这类文章点赞均为原标准的十分之一。例如，一个一星会员点一次某转载文章，该文章获得<span>0.1</span>分。<span></span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">为了鼓励会员间的参与热情，除了基本的点赞模式外，网站还具备“送花”（限异性）、“仰慕<span>”</span>（限同性）两种互动形式，只通过支付“灵丹”方式实现，一次“送花”或“仰慕<span>”</span>消耗一颗灵丹；会员通过他人点击其文章来接收，但最终会显示归集在作者会员的主页上。<span></span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">会员可以转载本网站博客栏目的发表文章，至其他主流社交渠道。转载后，原作者相当于又获得一次点赞，而转发会员获得自身点赞标准的十分之一。（原作者须在发表博文时就注明允许转载）<span></span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">例如，一个<span>2</span>星级会员发表一篇博文，一个<span>4</span>星级会员看后点赞，然后系统提示是否转载时，他又进行了转载到<span>XX</span>空间，则原作者获得<span>4</span>（点赞得分）<span>+4</span>（转载得分）共计<span>8</span>分，同时转载者获得<span>0.4</span>的转载酬劳得分。<span></span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">&nbsp;</span>
</p>
<p class="MsoNormal" style="text-indent:26.35pt;margin-top:20px;">
	<b><span style="font-family:宋体;">十三、其它事项：<span></span></span></b>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">网站目前为试运行阶段，暂不开启充值、支付等货币交易功能，亦不激活（上述文中提及有关）站内“灵丹”的各项实际使用。<span></span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">&nbsp;</span>
</p>
<p class="MsoNormal" align="right" style="text-align:right;text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">二零一四年十月二十七日 <span>&nbsp;&nbsp;</span>第一版<span></span></span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">&nbsp;</span>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;line-height:150%">
	<span style="font-family:宋体;">&nbsp;</span>
</p>

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
