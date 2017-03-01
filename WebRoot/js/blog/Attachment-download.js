function downloadAttachment() {
	var basePath = $("#basePath")[0].value;
	var userId = $("#userId")[0].value;
	var attachId = $("#attachId")[0].value;
	
	$.ajax({

		type : "get",
		url : "../downloadAttachment",
		contentType : 'application/json; charset=utf-8',
		data : {userId:userId,attachId:attachId},
		//dataType : "json",
		error : function(request) {
			alert("Connection error");
			
		},
		success : function(data) {
			//alert(data);
			
			//window.open(basePath+data);
			//下载文件的地址 
			var url=basePath+data; 
			$("#ifile").attr("src",url); 
			
			
		}
	});
}




