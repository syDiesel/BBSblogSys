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

<title>服 務 聲 明</title>

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
          <h1>會員登錄</h1>
          <span class="login_head_right">
              <span class="login_head_right_none">還沒帳號</span>&nbsp;&nbsp;&nbsp;<a href="<%=basePath%>isAgree.do">免費註冊</a>
          </span>
        </div>
        <div class="login_form">
           <form action="<%=basePath %>login.do" method="post">
            <input type="hidden" value="" id="login_href" name="login_href">
              <table>
                  <tr>
                     <td>
                         <input type="text" name="userName" placeholder="用戶名" class="login_td">
                     </td>
                  </tr>
                  <tr>
                     <td>
                         <input type="password" name="password" placeholder="密碼" class="login_td">
                     </td>
                  </tr>
                  <tr>
                     <td>
                          <input class="login_but" accesskey="l" value="登 錄" tabindex="5" type="submit">
                          <!-- <span class="login_span"><input type="checkbox" name="">保持登錄</span> -->
                          <span class="login_span"><a href="<%=basePath%>ToGetBackPwd.do">忘記密碼？</a></span>
                     </td>
                  </tr>
              </table>
           </form>
        </div>
        <div class="login_other">
           <p>用協力廠商帳號直接登錄</p>
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
				<a href="javascript:AddFavorite(window.location,document.title)">收藏友識知世</a>
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

												<span>等級：</span>

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
												class="icon-pConfig"></span>編輯個人資料</a>
										</div>
									</div>
									<div class="personInfoPart2">
										<div class="config">
											<a href="<%=basePath%>u/setting/password"><span
												class="icon-cog"></span>帳戶設定</a>

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
						<a href="javascript:void(0)" id="login_all">立即登錄</a>
						<span class="ban">&nbsp;</span>
						<a href="<%=basePath%>isAgree.do">免费注册</a>
					</c:if>
					<span class="ban">&nbsp;</span> <a
						href="<%=basePath%>ToGetBackPwd.do">找回密碼</a> <span class="ban">&nbsp;</span>
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
							value="" autocomplete="off" path="q" placeholder="請鍵入關鍵字">
						<input type="hidden" id="txtSear" value="0" name="searchMethod" />
					</DIV>
					<DIV class="search-btn-con2">
						<INPUT class="search-btn2" type="submit" value="搜一搜">
					</DIV>
				</FORM>
			</div>
			<div class="app">
				<a href="javascript:void(0)"></a>
				<h3 style="font-size:14px;">移動端下載</h3>
			</div>

		</div>
		<!--logo end-->
		<!--nav-->
		<div class="nav">
			<ul>
				<li><a href="<%=basePath%>toIndexHome">首頁</a>
				</li>
				<li><a href="<%=basePath%>web/Blog/index.html">博客展示</a>
				</li>
				<li><a href="<%=basePath%>listPostByBoard">論壇交流</a>
				</li>
				<li><a href="<%=basePath%>web/QandA/Home.html">問答互助</a>
				</li>
				<li><c:if test="${userInfo.role.id!=1 }">
						<a href="<%=basePath%>contact.do">聯繫客服</a>
					</c:if> <c:if test="${userInfo.role.id==1 }">
						<a href="<%=basePath%>toManagement">網站管理</a>
					</c:if>
				</li>
				<li><a href="<%=basePath%>faq.do">常見問題</a>
				</li>
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
			<h3 style="font-size:30px;">
				服 務 聲 明
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


歡迎光臨友識知世<sup>®</sup>網站，並請仔細閱讀以下條款；您首先應當完全同意本聲明協定的所有內容，然後進入網站流覽以認識更多的有識之士，並可根據提示完成註冊程式，發起討論、參與交流；用戶進入網站即視為已瞭解並同意遵守本協定項下的全部規定，且接受本網站的統一管理；若用戶對該聲明的任何條款有異議，則請停止使用本網站所提供的全部服務。敬請理解。
</p><br/><p>
一、友識知世<sup>®</sup>網站是向用戶（包括註冊用戶和流覽用戶）提供友好討論、優質交流的平臺，您需要遵守中華人民共和國以及香港特別行政區的互聯網相關管理條例、所在地的社會公德，其中包括不得利用本站危害國家安全、不得侵犯國家、社會和公民的合法權益、不得利用本站製作、複製和傳播有害資訊（例如：違反及破壞憲法和法律法規實施的；破壞國家統一和民族團結的；歪曲事實或者傳播謠言，擾亂社會秩序的；宣揚封建迷信、淫穢色情、賭博、暴力恐怖、教唆犯罪的；侮辱及誹謗他人，或者在站內騷擾他人、進行惡意攻擊的；任何形式的商業廣告；無實際意義的各類灌水、或使用多個（三個及以上）帳號等違規發帖、非法獲取積分的；發佈侵權及違法連結的；所發表文章等包含有嚴重影響其他使用者流覽的內容或格式的；含有虛假、粗俗、侵犯隱私、或其它在道德上令人反感的內容）等。
</p><br/><p>二、友識知世<sup>®</sup>網站的層次，與廣大參與使用者自身的水準息息相關，大家若希望能夠結識並彼此欣賞更多的有識之士，擁有健康、有益、高尚、正能量的互動討論氛圍，則請您從自己做起，並互相規勸，使大家都能獲得應有的尊重和樂趣；為了能夠給廣大用戶盡力提供一個優質的平臺，本網站擁有對違反本站使用規則者進行警告、刪文、禁言，直至封閉清空其帳號等嚴厲處理的權力，並保留移交司法機關處理的權利；您應獨立承擔一切因其個人的行為而可能直接或間接導致的民事或刑事法律責任；因用戶不當行為給本網站造成損失的，用戶需負責賠償；若您發現有任何人涉嫌違反該協定規定進行資訊傳播的，可及時向本網站進行投訴處理。
</p><br/><p>三、友識知世<sup>®</sup>網站關注、並呼籲廣大用戶都同樣尊重他人的智慧財產權和合法權益。本網站中使用者發表的各類文章作品，應有合法來源，相關內容為您所有或您已獲得權利人的授權，且僅表明用戶作者個人的立場和觀點，並不代表本網站；對於轉載至本網站的資訊，請寫明轉載和出處，以尊重原作者的著作權；請您對自己發佈的資訊資源、參與的討論問答、表達的個人觀點，始終保持認真負責和客觀公正的態度；對由於用戶言論、或用戶之間交流可能產生的任何法律糾紛或損失，該內容的發表者需自行解決並承擔全部的責任，本網站不承擔任何法律及連帶責任。
</p><br/><p>四、用戶於任何時間段在友識知世<sup>®</sup>網站所發表作品內容的著作財產權，使用者許可本網站在全世界範圍內免費地、永久性地、不可撤銷地、非獨家地使用及轉授的權利，包括但不限於：複製權、發行權、出租權、展覽權、表演權、放映權、廣播權、資訊網路傳播權、攝製權、改編權、翻譯權、彙編權以及《著作權法》規定的由著作權人享有的其他著作財產權利。
</p><br/><p>五、友識知世<sup>®</sup>網站所包含資訊內容的智慧財產權均受到法律保護，未經本網站許可，不得任意複製或轉載；未經本網站書面許可，不得以任何形式創造相關衍生作品；使用本網站的任何內容均應注明"來源於友識知世<sup>®</sup>網站"及署上作者姓名，按法律規定需要支付稿酬的，應當通知本網站和作者及支付稿酬，並獨立承擔一切法律責任；惡意轉載站內內容的，本網站保留訴諸法律的權利。
</p><br/><p>六、友識知世<sup>®</sup>網站高度重視智慧財產權保護，並遵守中國各項智慧財產權法律、法規和具有約束力的規範性檔；根據法律、法規和規範性檔要求，本網站制定了旨在保護智慧財產權權利人合法權益的措施和步驟，如果權利人發現在本網站的內容侵犯其著作權等相關權益時，權利人應事先向本網站發出書面的“權利通知”，並提供身份證明、權屬證明、詳細侵權情況說明及真實性聲明；本網站將根據中國法律法規和政府規範性檔，採取措施移除相關內容或斷開相關連結。
</p><br/><p>七、您理解並同意，友識知世<sup>®</sup>網站的服務是按照現有技術和條件所能達到的現狀提供的；本網站會盡最大努力向使用者提供服務，確保服務的連貫性和安全性，但不能隨時預見和防範法律、技術以及其他風險，包括但不限於不可抗力、病毒、木馬、駭客攻擊、網路故障、系統不穩定、協力廠商服務瑕疵、政府行為等原因可能導致的服務中斷、資料丟失以及其他的損失和風險；如因系統維護或升級等而需暫停服務時，本網站將事先公告；若因硬體故障或不可抗力等而導致暫停服務，或由於網站調整導致資訊丟失或其他結果的，本網站不承擔任何責任，對網路服務的及時性、安全性、準確性也都不作擔保。
</p><br/><p>八、鑒於網路服務的特殊性，您理解並同意友識知世<sup>®</sup>網站有權不經事先通知，隨時變更、中斷或終止部分或全部的網路服務；無論通知與否，本網站對用戶和任何第三人均無需承擔任何責任；如使用者有違反本協定中規定的使用規則，或註冊的帳號在任何連續180日內未實際使用的，本網站保留刪除帳號並停止提供服務的權利。
</p><br/><p>九、"友識知世<sup>®</sup>"及相關LOGO標識、網站設計、源代碼等，均為傑宸公司所有，並已進行商標及著作權等智慧財產權登記註冊；任何人未經許可，請勿以任何形式擅自使用。
</p><br/><p>十、本聲明協議的最終解釋權歸屬友識知世<sup>®</sup>網站和傑宸公司；本網站保留隨時修訂條款政策的權利，因此我們建議您定期查閱本頁面，以確保清楚有關政策的最新內容。
</p><br/><p>

二零一四年十月二十七日




</p><br/>






		
		
			<table>
				<tr>
					<td><a href="<%=basePath%>agree.do"><button
								class="submitButton"
								style="margin-left: 320px; margin-top: 100px;"
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
