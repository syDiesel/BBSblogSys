$(document).ready(function() {
	var id=$('#blogUser_id').val();
	var basePath=$('#basePath').val();
	$('#info_addFriend').click(function(){
		
		$.ajax({
	           type:"post",
	           url:basePath+"ajaxFriend.do?id="+id,	
	           
	           error:function(){
	               alert("connection error");
	              
	           },
	           success:function(msg){
	        	  /* alert(msg);*/
	               if(msg=="0"){
	               	   alert("Please log in !");
	               }else if(msg=="add"){
	            	   //添加关注成功
	            	   $('#info_addFriend').html('unfollow');
	               }else{
	            	   //取消关注成功
	            	   $('#info_addFriend').html('follow');
	               }
	           }
	       });	
	});
	
});