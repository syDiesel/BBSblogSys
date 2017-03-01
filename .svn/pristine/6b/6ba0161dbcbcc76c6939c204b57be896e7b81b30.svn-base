function form_submit() {
	document.getElementById("blogNew").submit();

}
function form_reset() {
	$("#ajaxLabel").css("display","none");
	$("#blogNew")[0].reset();
	// 取得HTML内容
	 html = editor.html();

	 // 同步数据后可以直接取得textarea的value
	 editor.sync();
	 html = document.getElementById('blogContent').value; // 原生API
	// html = K('#blogContent').val(); // KindEditor Node API
	 //html = $('#blogContent').val(); // jQuery

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
	var subject=document.getElementById("subject").value;


	if(subject==null||subject==""){
		alert("Article title cannot be empty");
	}
	else if(subject.length>50){
		alert("Too long article title");
	}
	else{
	 
	
	
	//ajax验证验证码提交form
	req.open("post", "../../ajax.do?action=checkNum&Num=" + checkNum);
	req.setRequestHeader("accept", "application/json");
	req.onreadystatechange = function() {
		if (req.readyState == 4 && req.status == 200) {

			if (req.responseText == "true") {
				form_submit();
				// alert("OK");
			} else
				alert("Incorrect verification code");
		}
	}
	req.send(null);
	}
}
