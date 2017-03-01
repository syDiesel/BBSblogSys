function listLabelByBoardAjax() {
	var boardId = $("#boardId")[0].value;

	var ajaxUrl = "listLabelByBoard?boardId=" + boardId;

	var htmlUrl = document.URL;

	if (htmlUrl.indexOf("Draft") != -1) {
		ajaxUrl = "../listLabelByBoard?boardId=" + boardId;
	}

	$.ajax({

		type : "get",
		url : ajaxUrl,
		contentType : 'application/x-www-form-urlencoded; charset=utf-8',
		data : null,
		dataType : "json",
		error : function(request) {
			alert("Connection error");
		},
		success : function(data) {

			// alert(data);
			var result = eval(data);
			if (data == null) {

				$("#ajaxLabel").html(" ");
				$("#ajaxLabel").css("display", "none");
			} else {
				$("#ajaxLabel").css("display", "block");
				$("#errorBod").css("display", "none");
				var labelHtml = "";

				for (var i = 0; i < result.length; i++) {

					if (result[i].labelName != "others") {
						labelHtml += "<label><input type='checkbox' value='"
								+ result[i].id + "' name='labelId' >"
								+ result[i].labelName + "</label>";
					}


				}
				for (var i = 0; i < result.length; i++) {

					if (result[i].labelName == "others") {
						labelHtml += "<label><input type='checkbox' value='"
								+ result[i].id + "' name='labelId' >"
								+ result[i].labelName + "</label>";
					}


				}
				

				$("#ajaxLabel").html(labelHtml);
			}

		}
	});
}

function listBlogType() {

	var blogType = $("#blogType")[0].value;

	$("#errorType").css("display", "none");

	if (blogType == 2) {

		$("#ajaxType").css("display", "block");
	} else {
		$("#ajaxType").css("display", "none");
	}

}
