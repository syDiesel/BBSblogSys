$(document).ready(function(){
		
	//合法性验证
		
	var validateOldPwd=false;
	var validateNewPwd1=false;
	var validateNewPwd2=false;

	
	//密码
	
	$("#oldPWD").keyup(function(){
		
		var username=$.trim($("#userName").val());	//用户名或Email
		var password=$.trim($("#oldPWD").val());

			if(password.length<6){
				validateOldPwd=false;
				$(".oldPWD").html("The login password is not valid");
			}else{
				
				$.ajax({
		            type:"post",
		            url:"checkUserPassword.do",
		            data:"userName="+username+"&passWord="+password,	
		            error:function(){
		                alert("connection error");
		                validateOldPwd=false;
		            },
		            success:function(msg){	
		            	
		            	if(msg=="0"){
		            		validateOldPwd=false;
		            	}else if(msg=="1"){
		            				                	
		            		validateOldPwd=false;
		                	$(".oldPWD").html("The login password is not valid");
		                }
		            	else if(msg=="ok"){
		            		
		            		validateOldPwd=true;
		            		$(".oldPWD").html("");	
		                	
		                }
		            }
		        });
			}
		
		
	});
	
	$("#oldPWD").focus(function(){
		$("#oldPWD").css("border","2px #aaa solid");
	});
	$("#oldPWD").blur(function(){
		$("#oldPWD").css("border","1px #bbc solid");
	});
	
	
	
//验证密码	validatePwd
	
	$("#newPWD1").keyup(function(){
		
		var password=$.trim($("#newPWD1").val());		
      
		if(password.length<6)
			{
			validateNewPwd1=false;
			$(".newPWD1").html("More than 6 digits");
			}else{
				validateNewPwd1=true;
				$(".newPWD1").html("");	
			}
	});		
	
	$("#newPWD1").focus(function(){
		$("#newPWD1").css("border","2px #aaa solid");
	});
	$("#newPWD1").blur(function(){
		$("#newPWD1").css("border","1px #bbc solid");
	});
	
	
	
	
	
	//验证确认密码	validatePwd1
	$("#newPWD2").keyup(function(){
		
		var password=$.trim($("#newPWD1").val());
		var password1=$.trim($("#newPWD2").val());
		
		if(password!=password1)
			{
			validateNewPwd2=false;
			$(".newPWD2").html("unsame cipher");
			}else{
				validateNewPwd2=true;
				$(".newPWD2").html("");	
			}
						
	});
	
	$("#newPWD2").focus(function(){
		$("#newPWD2").css("border","2px #aaa solid");
	});
	$("#newPWD2").blur(function(){
		$("#newPWD2").css("border","1px #bbc solid");
	});
	

	
	
    $("#toUpdatePWD").click(function(){									
		
		var validate=validateOldPwd&&validateNewPwd1&&validateNewPwd2;
        
		if(validate){
			$("#profile").submit();
		}
		
	});
	
});