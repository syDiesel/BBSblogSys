$(document).ready(function(){
	
	var validateCode=false;
	
	//验证码
	$("#mycode").change(function(){
		var mycode=$.trim($('#mycode').val());		

		if(mycode.length<=3){
			validateCode=false;
			$(".code_info1").html(imgError);
		}
		if(mycode.length==4){
			$.ajax({
	            type:"post",
	            url:"checkCode.do",
	            data:"mycode="+mycode,         
	            error:function(){
	            	alert("Connection error");
	                validateCode=false;
	            },
	            success:function(msg){		               
	                
	            	if(msg=="error"){
	                	validateCode=false;
	                	$(".code_info1").html(imgError);
	                }else{
	                	validateCode=true;
	                	$(".code_info1").html(imgRight);			                			                				                	
	                }
	            }
	        });			
		}
	});
	
	$("#mycode").focus(function(){
		$("#mycode").css("border","2px #aaa solid");
	});
	$("#mycode").blur(function(){
		$("#mycode").css("border","1px #bbc solid");		
	});
	
	
	$("#tijiao").click(function(){		
		   if(validateCode&&($("#is_message").val() == "1")){
			  
				$("#form_advice").submit();
   
		   }
	});
});