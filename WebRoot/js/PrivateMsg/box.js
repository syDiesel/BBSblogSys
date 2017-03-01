$(document).ready(function() {

	/*
	 * if($(".main-content-list-details").css("display")=="none")
	 * $(".main-content-list-details").css("display","block"); else
	 * $(".main-content-list-details").css("display","none"); }
	 */
});

function blockDetails(i) {

	if ($("#details_" + i).css("display") == "none")
		$("#details_" + i).css("display", "block");
	else
		$("#details_" + i).css("display", "none");
	var textId = i;

	$.ajax({

		type : "get",
		url : "RecBox/" + textId,
		data : {

		},
		contentType : "application/json",
		dataType : "text",// 服务器返回的数据类型 可选XML ,Json jsonp script html text等
		success : function(data) {
			// alert(data);
			if (data == 1) {
				$("#isReadIcon_" + i).removeClass("icon-notice-ru").addClass(
						"icon-notice-rd");
			}

		}
	});

}

function checkNickName() {
	var recName = $("#recName")[0].value;

	// alert(recName);

	$.ajax({

		type : "get",
		url : "checkNickNameExist?recName=" + recName,
		contentType : 'application/x-www-form-urlencoded; charset=utf-8',
		dataType : "text",
		error : function(request) {

			alert("Connection error");
		},
		success : function(data) {

			if (data == "exist") {
				$("#recNameTip").css("color", "green")
				$("#recNameTip").text("This nickname effectively, the user can successfully receive your information");
			} else {
				$("#recNameTip").css("color", "red")
				$("#recNameTip").text("This nickname is invalid, the user cannot be successfully received your information");
				$("#recName").focus();
			}

		}
	});
}
