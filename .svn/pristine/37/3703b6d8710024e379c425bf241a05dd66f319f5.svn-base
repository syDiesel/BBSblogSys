$(document).ready(function() {
	var id=$('#logId').val();
	var basePath=$('#basePath').val();
	$('#blogToForum').click(function(){
		
		$.ajax({
	           type:"post",
	           url:basePath+"checkBlog.do?id="+id,		            
	           error:function(){
	               alert("connection error");
	              
	           },
	           success:function(msg){		               
	               if(msg!="nobody"){
	               	   if(confirm("This blog has been reprinted，are you sure to reprint？"))
	               		   {
	               		     $('#toForumForm').submit();
	               		   }else{
	               			  location.href=basePath+"toTopics?post_id="+msg;
	               		   }
	               }else{
	            	   $('#toForumForm').submit();
	               }
	           }
	       });	
	});
	
});