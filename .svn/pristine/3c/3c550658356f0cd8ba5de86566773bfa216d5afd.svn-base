function friend() {

	var url = document.URL // alert(url);

	var logId = $("#logId").val();
	// alert(logId);

	
	if ($.trim($("#collect").text() )== "收藏") {
		$.ajax({

			type : "get",
			url : "../addCollect",
			data : {
				url : url,
				logId : logId
			},
			contentType : "application/json",
			dataType : "text",// 服务器返回的数据类型 可选XML ,Json jsonp script html text等
			error : function(request) {

				alert("Connection error");
			},
			success : function(data) {
				if (data == "login") {
					window.location.href = "../../../login.html";
				}
				if (data == "collected") {
					alert("已收藏这篇文章");
				}
				if (data == "favorite") {
					alert("收藏成功");

					/* if ($("#collect").text() == "收藏") { */
					$("#collect").text("已收藏");
					/*
					 * } else { $("#collect").text("收藏"); }
					 */

				}
			}
		});
	} else {
		$.ajax({

			type : "get",
			url : "../removeCollect",
			data : {
				url : url,
				logId : logId
			},
			contentType : "application/json",
			dataType : "text",// 服务器返回的数据类型 可选XML ,Json jsonp script html text等
			error : function(request) {

				alert("Connection error");
			},
			success : function(data) {
				if (data == "login") {
					window.location.href = "../../../login.html";
				}
				if (data == "unCollect") {
					//alert("error")
				}
				if (data == "success") {

					/* if ($("#collect").text() == "收藏") { */
					$("#collect").text("收藏");
					/*
					 * } else { $("#collect").text("收藏"); }
					 */

				}
			}
		});

	}
}


