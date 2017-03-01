function Collect() {

	var url = document.URL // alert(url);

	var logId = $("#logId").val();
	// alert(logId);

	
	if ($.trim($("#collect").text() )== "Favorite") {
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
					alert("Has marked as favorite");
				}
				if (data == "favorite") {
					alert("favorited");

					/* if ($("#collect").text() == "收藏") { */
					$("#collect").text("Favorited");
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
					$("#collect").text("Favorite");
					/*
					 * } else { $("#collect").text("收藏"); }
					 */

				}
			}
		});

	}
}


function removeCollect(){
	var url = document.URL // alert(url);

	var logId = $("#logId").val();
	$.ajax({

		type : "get",
		url : "removeCollect",
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

				window.location.href = "collect";

			}
		}
	});
}