function mark(obj) {
	
	
	var kind = obj.id;

	var userId = $("#userId").val();
       
	if (kind == "yangmu") {
		marks = "1";
	} else if (kind == "xianhua") {
		marks = "2";
	} 
	
	if(confirm("Confirm submission? You’ll lose a panacea!")){
		
	$.ajax({
		
		type : "get",
		url : "../Blog/blogYMXH",
		data : {
			id : userId,
			marks : marks
		},
		contentType : "application/json",
		dataType : "text",// 服务器返回的数据类型 可选XML ,Json jsonp script html text等
		error : function(XMLHttpRequest, textStatus, errorThrown) {   
		
			alert('connect error');  
		},
		success:function(data){
			
			if(data == "error"){
				
				alert("Your panaceas are not enough to pay!");
			}
			else if(kind == "yangmu"){
				
				$("#YMcount").html("Respect：<em title="+data+">"+data+"</em>");
			}
			else if(kind == "xianhua"){
				
				$("#XHcount").html("Flower：<em title="+data+">"+data+"</em>");
			}
		}
		
		
		
	});
	}
	return false;
	
}