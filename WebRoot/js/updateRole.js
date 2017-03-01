function update(i){
	var userSex = $("#userSex"+i).val();
	var userRole = $("#userRole"+i).val();
    var say = $("#say"+i).val();
	var userId =$("#userId"+i).val();

	$.ajax({

		type : "get",
		url : "web/management/Role/updateRole",
		data : {
			sex : userSex,
			role : userRole,
			say : say,
			userId:userId
		},
		contentType : "application/json",
		dataType : "text",// 服务器返回的数据类型?可选XML?,Json?jsonp?script?html?text等
		error : function(request) {

			alert("Connection error");
		},
		success : function(data) {
			//alert(data);
				alert("用户资料修改成功");
				$("#isSayOption").text(data);
				$("#isSayOption").attr("selected",'selected');
		}
	});

}