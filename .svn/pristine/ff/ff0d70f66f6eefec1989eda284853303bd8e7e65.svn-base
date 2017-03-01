function form_submit() {
	document.getElementById("blogNew").submit();

}
function form_reset() {
	$("#ajaxLabel").css("display", "none");
	// $("#blogNew")[0].reset();
	$('#blogNew')[0].reset();
	// 取得HTML内容
	html = editor.html();

	// 同步数据后可以直接取得textarea的value
	editor.sync();
	html = document.getElementById('blogContent').value; // 原生API
	// html = K('#blogContent').val(); // KindEditor Node API
	// html = $('#blogContent').val(); // jQuery

	// 设置HTML内容
	editor.html('');
}

function createAjaxObj() {
	var req;
	if (window.XMLHttpRequest) {
		req = new XMLHttpRequest();
	} else {
		req = new ActiveXObject("Msxml2.XMLHTTP"); // ie
	}
	return req;
}

function checkNum() {
	var req = createAjaxObj();
	var checkNum = document.getElementById("chknumber").value;
	var blogType = document.getElementById("blogType").value;
	var sfzz = document.getElementById("sfzz").value;
	var boardId = document.getElementById("boardId").value;
	var subject = document.getElementById("subject").value;
	var wzcc = document.getElementById("wzcc").value;
	var labels = $("input[name='labelId']");
	var html = editor.html();
	editor.sync();
	var blogContent = document.getElementById('blogContent').value;
	var checkLabel = $(":checkbox:checked").length;


	
	if (boardId == -1) {
		$("#errorBod").css("display", "block");
		$("#boardId").focus;
		return false;
	} else if (checkLabel <= 0) {
		$("#errorLab").css("display", "block");
		labels.focus;
		return false;
	}
	else if (blogType == 0) {
		$("#errorType").css("display", "block");
		$("#blogType").focus;
		return false;

	} else if (blogType == 2
			&& (wzcc == null || wzcc == "" || wzcc.length == 0)) {
		$("#errorWzcc").css("display", "block");
		$("#wzcc").focus;
		return false;
	} else if (sfzz == -1) {
		$("#errorSfzz").css("display", "block");
		$("#sfzz").focus;
		return false;

	} else if (subject == null || subject == "") {
		$("#errorSubject").css("display", "block");
		$("#subject").focus;
		return false;
	} else if (subject.length > 50) {
		$("#errorSubjectOutOfBound").css("display", "block");
		$("#subject").focus;
		return false;
	} else if (blogContent.length < 500 || blogContent.length > 15000) {
		$("#errorContent").css("display", "block");
		$("#Content").focus;
		return false;
	}

	else {

		var ajaxUrl = getRootPath()+"/ajax.do?action=checkNum&Num=" + checkNum;

		var htmlUrl = document.URL;

		if (htmlUrl.indexOf("Draft") != -1) {
			ajaxUrl = getRootPath()+"/ajax.do?action=checkNum&Num=" + checkNum;
		}
		// ajax验证验证码提交form
		req.open("post", ajaxUrl);
		req.setRequestHeader("accept", "application/json");
		req.onreadystatechange = function() {
			if (req.readyState == 4 && req.status == 200) {

				if (req.responseText == "true") {
					form_submit();
					// alert("OK");
				} else
					alert("Incorrect verification code");
				return false;
			}
		}
		req.send(null);

	}
}

 
//js获取项目根路径，如： http://localhost:8083/uimcardprj
function getRootPath(){
    //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
    var curWwwPath=window.document.location.href;
    //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
    var pathName=window.document.location.pathname;
    var pos=curWwwPath.indexOf(pathName);
    //获取主机地址，如： http://localhost:8083
    var localhostPaht=curWwwPath.substring(0,pos);
    //获取带"/"的项目名，如：/uimcardprj
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    return(localhostPaht+projectName);
}
