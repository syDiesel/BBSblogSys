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

<title>常見問題</title>

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
			<h2>用 戶 指 南</h2>
		</div>

		<div class="main_content">


<p class="MsoListParagraph" style="text-indent:26.35pt;">
	<b>一、網站宗旨：</b><b></b>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	通過“以文會友”等形式，邀請各行各業的有識之士和專業才俊，充分展示思想、才能，促進相互間的高尚交流。
</p>
<p class="MsoListParagraph" style="text-indent:26.35pt;">
	<b>二、欄目設置：</b><b></b>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	網站主要有“興趣專題”、“個人主頁”兩大部分；每個興趣專題，都劃分為：博客展示、論壇交流、問答互助三個（縱向）分版塊。
</p>
<p class="MsoListParagraph" style="text-indent:26.35pt;">
	<b>三、會員管理；</b><b></b>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	會員的管理採取分級體制（評定分為7個星級，會員標識下用最多七顆星顯示），以公開、公平的累積積分為基礎。
</p>
<p class="MsoListParagraph" style="text-indent:26.35pt;">
	<b>四、興趣專題：</b><b></b>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	各個興趣專題，指具體的（橫向）分版塊（例如歷史、軍事、健康、汽車、文化、科技等），各版塊下列多個分類標籤，並可按標籤進行分類及此項排名（博客按點贊積分數，論壇按跟帖回復數，問答按點贊積分數）。
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	初始興趣分版塊有以下分類，可供下拉選擇：（括弧是對易混淆的類別進行必要的說明）
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	財經、科技、歷史、外語、文學（各類原創作品）、體育、文化、藝術、軍事、法律、社會（民生焦點、社會百態等）、城市（國內外各城市生活）、國際（新聞熱點）、健康、醫藥、職場、情感、思想、家庭、育兒、教育、留學、移民、影視、娛樂、攝影、汽車、寵物、購物、時尚、房產、家居、遊戲、美食、旅遊、動漫。
</p>
<p class="MsoListParagraph" style="text-indent:26.35pt;">
	<b>五、標籤設立：</b><b></b>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	會員在初始註冊進入網站後，可以寫博客文章，也可以發起論壇話題、或提問/回答。無論何種形式，會員都須填寫1-3個標籤（即該擬發表內容的關鍵字或所屬分類；第一個自動默認為大標籤，即最主要的屬性分類），然後在該分類標籤下（系統亦會自動提示以前已發表或存有的標籤）發表博文等。如感覺無合適的分類標籤，會員可向管理員申請自行添加標籤。
</p>
<p class="MsoListParagraph" style="text-indent:26.35pt;">
	<b>六、站內支付：</b><b></b>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	本站設有“金磚”、“靈丹”兩種虛擬的支付方式。“金磚”對應一個會員積累的點贊數，象徵其能力級別；“靈丹”對應實際的貨幣（人民幣）交易，象徵能打破一般規則所需的報酬。
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	1顆靈丹 =
1塊金磚= 1元人民幣；“金磚”與貨幣實際交易完全無關，只具有等效意義；“靈丹”則等值於實際貨幣。
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	會員間每一次的貨幣實際交易，每1元錢將由網站收取0.1元的管理費用；例如，會員A為觀賞會員B的一篇文章，而充值並支付了一顆靈丹，即1元錢，則B的網站個人帳戶上將實際獲得0.9元。
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	網站交易平臺，充值交易最低為100元人民幣。
</p>
<p class="MsoListParagraph" style="text-indent:26.35pt;">
	<b>七、交流規則：</b><b></b>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	高級別會員對於低級別會員總具有優先權；一般來說，會員有權向同級或較低級別會員要求一定的“金磚”或者“靈丹”（具體哪種方式，由會員自行決定）作為回報，來享受其提供的服務（如資源區文章、參加討論帖、回答問題）；如果會員向更高級別會員提出要求，則必須以支付“靈丹”形式進行回報。
</p>
<p class="MsoListParagraph" style="text-indent:26.35pt;">
	<b>八、博客展示：</b><b></b>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	會員可對其個人主頁中的所屬文章進行設定；展示區是對所有人（包括遊客）公開，資源區則可自行設限，需要具備一定許可權或者要求站內支付（靈丹或金磚）才可以進入。
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	對於資源區的觀看，會員自行設定（其星級或以下人員觀看的）許可權，針對每篇文章，其它會員需支付1顆靈丹或1塊金磚（發起會員可選擇支付方式，可以為任意一種，也可以指定必須其中一種），才能進入觀看。例如會員A為3星級，則A有權設定其資源區的文章，0-3星級的人需要繳納才能觀看。
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	如果用金磚支付，則需求者需要相應減少其積分（積分由他人點贊、自己發表文章等途徑獲得），相應的博主增加積分；如果用靈丹支付，則需求者需首先進行網站充值，然後支付給博主。資源區具有部分預覽功能。
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	高級別的會員可以進入低級別會員的資源區。如果低級別會員希望獲得連高級別會員都無法進入的許可權，則每篇文章需要支付1顆靈丹。
</p>
<p class="MsoListParagraph" style="text-indent:26.35pt;">
	<b>九、論壇交流：</b><b></b>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	會員及遊客均可流覽板塊內的話題帖子，但發起會員可以自行設定，使得只有部分授權會員才可以參加評論回復。
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	每個註冊的會員都可發起話題帖子，且有權設定一定級別以上的會員（該許可權只能是其星級及以下）才可以參與其話題討論。例如，A會員為3星級，則A可自行設定0-3星級（低於其會員級別）以上的會員才可參與討論A發起的話題（也就是說，若A願意，則只有一定級別的人方可被限定參加他發起的討論）。當然，A也可以選擇不設定，則所有會員（不包括遊客）均能參加回復評論。
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	請注意，星級高於A的會員則不會受到限制。例如，一個5星級的人B，可以自由參與任何等於或低於5星會員發起的討論，即從高星級向低星級往往是有優先權的。
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	若低星級會員希望參加高星級限定的帖子，則需要繳納1顆靈丹或1塊金磚（由帖子發起者在發帖限定時即自行選擇例外及支付方式；當然他也可以選擇根本不允許例外）。例如會員A為3星級，發起了一個需要2星級以上會員才可以回復的話題，且允許支付1塊金磚的例外情況，則1星級會員B，需繳納費用（1塊金磚）才能參加發言。
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	如果發帖會員要求其它的非默認限定，例如要求高於他本人級別以上的人才能發言，或者更加精准的限定，則需要支付給系統一顆靈丹。例如會員A為3星級，則A需繳納一顆靈丹，才能有權設定他發起的話題只有4星級以上的人才能參加發言。
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	會員發起的話題可以是針對該興趣專題版塊的某一問題，也可以是博客展示文章中直接引出的討論。
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	為了避免灌水等不良行為，本網站的博客展示欄目僅供發表文章等和他人點贊，不支持直接評論。有關評論，將自動轉至論壇欄目。（首先需要博客作者提前設定，允許他人轉至論壇進行公開評論）
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	評論要求在100-1000字之間；評論在10-100字之間的，可以正常發表，但將不獲得點贊功能，也就是說，即使他人點贊也無法獲得積分。
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	同時，發起話題的會員也可以選擇是否發起投票，並可自行確定投票選項，發起投票需要支付10顆靈丹。
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	論壇中的討論評論，也具備如博文一樣的點贊加分功能，即好、中、差三種統計，標準同博文點贊功能的十分之一。例如一個會員A在某話題中發表一個評論，一個4星級會員B看後，覺得不錯點“欣賞”，則A可以獲得0.4分。
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	同樣的，若點“一般”、“遺憾”，也如同博客欄目的點贊規則，即分數不增不減，只改變中評和差評的統計數量。
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	請注意，與博客、問答欄目中的流覽者應當做出評價（系統自動提示）不同，對於論壇發帖評論的評價，是遵從自願原則（即系統不會自動提示）。
</p>
<p class="MsoListParagraph" style="text-indent:26.35pt;">
	<b>十、問答互助</b><b></b>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	會員可以自由發起專業提問（同樣的，要首先設定至少一個主標籤），並懸賞酬謝0-100顆靈丹或0-100塊金磚（支付靈丹需先充值現金後轉到網內靈丹帳戶，支付金磚則將扣除提問會員的金磚點數並轉給回答會員；無論靈丹還是金磚的餘額不夠的，則提問者不能繼續看回答者的應答）。
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	會員在提問時，為了避免參與人過多，可以指定一定星級以上的會員進行應答。這時，無論他指定的星級是比本身高或低，他都要繳納給系統（針對每個問題）一顆靈丹。
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	會員提問後，往往會有多人應答，答案將分別提供給提問者，提問者只有在支付所承諾的靈丹或者磚後，才能看到答案（一般來說，提問者將考慮回答者的背景級別，慎重的、有選擇性的點擊一部分甚至一個答案）。
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	提問者支付的靈丹或者金磚，先進入系統的支付中轉站，一旦提問者看到答案，並給予了評價後，報酬將會正式到達回答者的帳戶，同時答案將自動在系統中公開展示。
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	若提問者看到答案，但並不滿意，可以暫不評論，而進行最多三次追問。每次追問並獲得回答後，系統會提示提問者是否要評價，直到第三次提示時，提問者必須作出評價。若提問者未主動評價就關閉頁面等的，則視為默認“一般”。只有在提問者給予了評價後，答案才會自動在系統中公開展示。
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	若提問者追問後，而回答者拖延回答，自首次追問起一個月內回答者仍未回應追問的，則報酬將退回給提問者，同時系統提示提問者仍作評價，之後公開已有的回答。
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	請注意：提問者可以有選擇無償提問的權利，而回答者也有選擇放棄報酬的權利，即並不是所有的問答都有償，也可以是完全無償的，這完全取決於問答雙方的意願。例如，會員A提出一個問題，可以懸賞（當然也可以選擇“無酬謝提問”），並自我設定報酬額為50靈丹；會員B進行回答，可以在回答前選擇“接受酬謝”，也可以選擇“無需酬謝回答”；前者情況下，一旦A看了B的回答，則無論A評價否，評價是何，只要正常回答最多三次追問，B最終都會自動獲得A承諾的獎賞，即50靈丹；後者情況下，即使A看了B的回答，B也不會得到A承諾的獎賞。
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	對於任何一個回答，提問者、及其他的流覽者，都須選擇評價“欣賞”（回答者另外加1磚），“一般”或“遺憾”（不加不減金磚積分）。每個問題最終都有多種答案及相應的好中差評數量統計，其中提問者對答案的評價統計另列。
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	為了保護會員隱私，提問者的身份可以自行選擇不予暴露。
</p>
<p class="MsoListParagraph" style="text-indent:26.35pt;">
	<b>十一、個人主頁</b><b></b>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	即個人展示部分，具有精簡導讀、資訊索引、基本社交等功能。主要欄目有：
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	個人展示區：發佈的公開博文等資源；
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	資源分享區：發佈的有償資源，其它會員需要花費積分等方式進入；
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	站內信：用於會員之間及管理員發送各類活動及處理資訊等；
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	個人簡介：個人基本資訊、照片、資質能力證書等；同一個資質證書可由會員上傳兩個版本，一是供系統核實資質名稱用，二是用於公佈便於其他會員流覽和點贊，點贊積分規則與文章相同，但後者可以由會員自行隱藏名字、證件號等隱私資訊；
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	個人社交：顯示博主關注和關注博主的會員、我的好友（相互關注即為好友）及動態更新互通功能、每日心情短語；“送花”或“仰慕”者等；
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	關注收藏：收藏或轉載（至他處）的所流覽博文、參加的論壇帖子、回答過的問題及發起的提問；
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	個人星級統計：個人總星級、金磚數（即總積分）、興趣展示（即在各大興趣版塊的次積分統計、參與的多個專題小組（標籤）及標籤子項積分）；
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	會員在網站中的星級，是他在所有大類中的累積積分綜合決定的。例如，他在健康大類有1萬分，4星級，在國際觀察大類有9萬分，同樣是4星級，但他的綜合級別是5星級10萬分，也表明他在網站中任何一個分類，都具有5星級的許可權（例如可以看4星及以下會員的資源區文章等）。
</p>
<p class="MsoListParagraph" style="text-indent:26.35pt;">
	<b>十二、分級體制</b><b></b>
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	會員評定星級分為7星（會員標識下用最多七顆星顯示星級），每個星級有10<sup>n</sup>分（n為星級數，這裡的積累分數用“金磚”表示，寓意經過不斷的磚壘堆積，達到更高級別），最初（無展示文章）註冊後即為有1分，累積滿本級別內的分數則提升一星。
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	每發表一篇1000-10000字的文章（其它藝術形式另議）、或者上傳一個專業資質並經過後臺審核後上傳，可獲得（某大分類之標籤下）1分，但未經評論的會員最多不能超過7分。只有在經過其它會員的評論後，初始會員才有可能達到10分並成為1星會員。
</p>
<p class="MsoNormal" style="text-indent:26.25pt;"> 
	例如，某人A註冊後成為會員，則有1分（1塊金磚），然後上傳若干文章和資質，達到最多7分，然後這些文章（他人可以點贊文章，也可以點贊資質）被評論後，例如被三個人（以一星會員點一次為例）點“好”後，就獲得3分，從而變成10分，也就成為了1星會員（10分）。
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	然後，這個1星會員不斷發表文章，或者他的文章繼續被點贊，積累到100分時，就成為2星會員。類似的，到了5星級，就意味著他有10萬分。到了7星級，就意味著他有1千萬分。
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	博文分為公開展示區和限制資源區；都是以一篇1000-10000字的文章為基本單位（或者一篇畫作、或者一部樂譜、或者一張照片）。
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	博客文章（或資質等）的評論只分為“欣賞”、“一般”、“遺憾”三種，獲得“欣賞”的（以一星會員點一次為例）得一分，“一般”和“遺憾”不得分。每個文章最終都要有好中差評數量統計。注意對文章沒有具體評論留言功能，以簡化統計，便於管理，以免灌水。
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	任何人閱讀完一篇文章後，系統都會提示，請尊重作者的勞動，進行評價；若仍不予評價而關閉頁面，則預設為“一般”。此規則對於論壇評論、問答評價也同樣適用。
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	100個遊客或者10個（0星級）會員點贊“欣賞”，有1分。
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	7星級一次點贊可以給7分，3星級給3分，1星級給1分。
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	對於一篇文章，每個IP位址的會員只能點評一次。
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	對於上傳有國家級或高級專家類資質的，或者有特殊影響力的專業名人等，經過審核認證後，網站管理員有權考慮破格直接給予X星以上的頭銜。
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	每個會員在完成註冊時，會自動生成該網站的個人交易帳戶，該交易帳戶為使用者實際支付購買“靈丹”的帳戶，與積分“金磚”無關；帳戶用於站內會員間進行實際貨幣的虛擬資源交易。
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	會員可以發表轉載他人或別處（非本網站）的文章等，以鼓勵會員收集整理非原創、卻仍然有益的知識資訊。但會員必須選擇注明“轉載”字樣，並注明出處（系統可以提示選擇預設“來源於網路”）。其他會員對這類文章點贊均為原標準的十分之一。例如，一個一星會員點一次某轉載文章，該文章獲得0.1分。
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	為了鼓勵會員間的參與熱情，除了基本的點贊模式外，網站還具備“送花”（限異性）、“仰慕”（限同性）兩種互動形式，只通過支付“靈丹”方式實現，一次“送花”或“仰慕”消耗一顆靈丹；會員通過他人點擊其文章來接收，但最終會顯示歸集在作者會員的主頁上。
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	會員可以轉載本網站博客欄目的發表文章，至其他主流社交管道。轉載後，原作者相當於又獲得一次點贊，而轉發會員獲得自身點贊標準的十分之一。（原作者須在發表博文時就注明允許轉載）
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	例如，一個2星級會員發表一篇博文，一個4星級會員看後點贊，然後系統提示是否轉載時，他又進行了轉載到XX空間，則原作者獲得4（點贊得分）+4（轉載得分）共計8分，同時轉載者獲得0.4的轉載酬勞得分。
</p>
<p class="MsoNormal" style="text-indent:26.25pt;">
	&nbsp;
</p>
<p class="MsoNormal" style="text-indent:390.0pt;">
	二零一四年十月二十七日&nbsp;&nbsp; 第一版
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
