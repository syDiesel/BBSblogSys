/**
 * 
 * @author swh
 * 
 * @date 2014-9-2
 * 
 * @param ajax注册
 *            验证
 * 
 * 
 */


$(document).ready(function(){  
	
	// 合法性验证
	var validateName=false;		// 验证****用户名******的合法性
	var validateNickName=false; // 验证****昵称******的合法性
	var validatePwd=false;		// 验证*****密码*******的合法性
	var validatePwd1=false;		// 验证***确认密码****的合法性
	var validateEmail=false;	// 验证*****邮箱*******的合法性
	var validateCode=false;		// 验证*****验证码*******的合法性

	
	// 图片路径
	var basePath=$('#basePath').val();
	var imgError="<img src='"+basePath+"images/home/wrong.jpg' width=15px height=15px>";
	var imgRight="<img src='"+basePath+"images/home/right.jpg' width=20px height=20px>";
	
	
	// 获取username文本框右边的提示信息（写在了temp**属性中），如需修改，直接jsp中修改，避免也在js中来回修改
	var username_info1=$(".username_info1").attr("tempUsername");
	var nickName_info1=$(".nickName_info1").attr("tempNickName");	
	var password_info1=$(".password_info1").attr("tempPassword");
	var password1_info1=$(".password1_info1").attr("tempPassword1");	
	var email_info1=$(".email_info1").attr("tempEmail");	
	
	
	// 验证用户名 validateName
	
	$("#username").change(function(){    
		
		var username=$.trim($("#username").val());
		var username_filter = /^[a-zA-Z0-9_]{1,}$/;	
		
		if(username.length<=0){
			validateName=false;
			/* $(".username_info1").html(username_info1); */
			$(".username_info2").html(imgError+"&nbsp;<font color='red'>User name cannot be empty!</font>");
		}else{
			if(!username.match(username_filter)){
				validateName=false;
				/* $(".username_info1").html(username_info1); */
				$(".username_info2").html(imgError+"&nbsp;<font color='red'>Please enter the legitimate user name!</font>");
			}else{
				if( username.length<6){
					validateName=false;
					/* $(".username_info1").html(username_info1); */
					$(".username_info2").html(imgError+"&nbsp;<font color='red'>more than 6 digits</font>");
				}else if(username.length>20){
					validateName=false;
					/* $(".username_info1").html(username_info1); */
					$(".username_info2").html(imgError+"&nbsp;<font color='red'>less than 20 digits</font>");
				}else{			
					$.ajax({
			            type:"post",
			            url:"checkUserName.do",
			            data:"userName="+username,			            
			            error:function(){
			                alert("Confirm password cannot be empty!");
			                validateName=false;
			            },
			            success:function(msg){		               
			                if(msg=="1"){
			                	validateName=false;
			                	/* $(".username_info1").html(username_info1); */
			                	$(".username_info2").html(imgError+"&nbsp;<font color='red'>The user name has already been registered!</font>");
			                }else{
			                	validateName=true;
			                	$(".username_info1").html(imgRight);
			                	$(".username_info2").html("");			                			                				                	
			                }
			            }
			        });					
				}
			}
		}
	});
	$("#username").focus(function(){
		$("#username").css("border","2px #aaa solid");
	});
	$("#username").blur(function(){
		$("#username").css("border","1px #bbc solid");
	});
	
	
	// 验证昵称
	
$("#nickName").change(function(){    
		
		var nickName=$.trim($("#nickName").val());
		var nickName_filter = /^[a-zA-Z0-9_\u4e00-\u9fa5]{4,10}$/;	
		if(nickName.length<=0){
			validateNickName=false;
			/* $(".nickName_info1").html(nickName_info1); */
			$(".nickName_info2").html(imgError+"&nbsp;<font color='red'>Nickname illegal!</font>");
		}else{
			if(!nickName.match(nickName_filter)){
				validateNickName=false;
			/* $(".username_info1").html(username_info1); */
			$(".nickName_info2").html(imgError+"&nbsp;<font color='red'>Nickname illegal!</font>");
			}else{
					
					$.ajax({
			            type:"post",
			            url:"checkNickName.do",
			            data:"nickName="+nickName,			            
			            error:function(){
			                alert("connection error");
			                validateNickName=false;
			            },
			            success:function(msg){	
			            	
			                if(msg=="0"){
			                	validateNickName=false;
			                	/* $(".nickName_info1").html(nickName_info1); */
			                	$(".nickName_info2").html(imgError+"&nbsp;<font color='red'>This nickname has been occupied!</font>");
			                }else{
			                	validateNickName=true;
			                	$(".nickName_info1").html(imgRight);
			                	$(".nickName_info2").html("");			                			                				                	
			                }
			            }
			        });					
				}
		}
		
	});
	$("#nickName").focus(function(){
		$("#nickName").css("border","2px #aaa solid");
	});
	$("#nickName").blur(function(){
		$("#nickName").css("border","1px #bbc solid");
	});
	
	
	
	// 验证密码 validatePwd
	
	$("#password").keyup(function(){
		
		var password=$.trim($("#password").val());		
		var password1=$.trim($("#password1").val());	
		
		if(password1.length<=0){

			validatePwd=false;
			validatePwd1=false;
			
			if(password.length<=0){	
				
				/* $(".password_info1").html(password_info1); */
				$(".password_info2").html(imgError+"&nbsp;<font color='red'>Password cannot be empty!</font>");
				
			}else if( (password.length>0)&&(password.length<6)){
				
				/* $(".password_info1").html(password_info1); */
				$(".password_info2").html(imgError+"&nbsp;<font color='red'>Password length cannot be less than 6!</font>");
				
			}else{
				
				$(".password_info1").html(imgRight);
				$(".password_info2").html("");
			}
		}else{
			
			if(password.length<=0){	
				
				validatePwd=false;
				validatePwd1=false;
				
				/* $(".password_info1").html(password_info1); */
				$(".password_info2").html(imgError+"&nbsp;<font color='red'>Password cannot be empty!</font>");
				/* $(".password1_info1").html(password1_info1); */
				$(".password1_info2").html(imgError+"&nbsp;<font color='red'>Passwords do not match!</font>");
				
			}else if( (password.length>0)&&(password.length<6)){
				
				validatePwd=false;
				validatePwd1=false;
				
				if(password1==password){
					/* $(".password_info1").html(password_info1); */
					$(".password_info2").html(imgError+"&nbsp;<font color='red'>Password length cannot be less than 6!</font>");
					/*
					 * $(".password1_info1").html("<font
					 * color='red'>"+password_info1+"</font>");
					 */
					$(".password1_info2").html(imgError+"&nbsp;<font color='red'>password illegal!</font>");
				}else{									
					/* $(".password_info1").html(password_info1); */
					$(".password_info2").html(imgError+"&nbsp;<font color='red'>Password length cannot be less than 6!</font>");
					/*
					 * $(".password1_info1").html("<font
					 * color='red'>"+password_info1+"</font>");
					 */
					$(".password1_info2").html(imgError+"&nbsp;<font color='red'>Passwords do not match!</font>");
				}				
				
			}else{
			
				if(password1==password){
					
					validatePwd=true;
					validatePwd1=true;
					$(".password_info1").html(imgRight);
					$(".password_info2").html("");
					$(".password1_info1").html(imgRight);
					$(".password1_info2").html(" ");
					
				}else{
					
					validatePwd=false;
					validatePwd1=false;
					
					$(".password_info1").html(imgRight);
					$(".password_info2").html("");
					/* $(".password1_info1").html(password1_info1); */
					$(".password1_info2").html(imgError+"&nbsp;<font color='red'>Passwords do not match!</font>");
				}
			}
		}
		
	});		
	
	$("#password").focus(function(){
		$("#password").css("border","2px #aaa solid");
	});
	$("#password").blur(function(){
		$("#password").css("border","1px #bbc solid");
	});
	
	
	
	
	
	// 验证确认密码 validatePwd1
	$("#password1").keyup(function(){
		
		var password=$.trim($("#password").val());
		var password1=$.trim($("#password1").val());
		
		if(password.length<=0){
			
			validatePwd=false;
			validatePwd1=false;
						
			if(password1.length<=0){
				
				/* $(".password1_info1").html(password1_info1); */
				$(".password1_info2").html(imgError+"&nbsp;<font color='red'>Confirm password cannot be empty!</font>");
				
			}else{
				
				/* $(".password1_info1").html(password1_info1); */
				$(".password1_info2").html(imgError+"&nbsp;<font color='red'>Passwords do not match!</font>");
			}
			
		}else if( (password.length>0)&&(password.length<6) ){
			
			validatePwd=false;
			validatePwd1=false;
			
			if(password1.length<=0){
				
				/* $(".password1_info1").html(password1_info1); */
				$(".password1_info2").html(imgError+"&nbsp;<font color='red'>Confirm password cannot be empty!</font>");
				
			}else{
				if(password==password1){
					
					/* $(".password1_info1").html(password1_info1); */
					$(".password1_info2").html(imgError+"&nbsp;<font color='red'>password illegal!</font>");
					
				}else{
					
					/* $(".password1_info1").html(password1_info1); */
					$(".password1_info2").html(imgError+"&nbsp;<font color='red'>Passwords do not match!</font>");
				}
				
			}
			
		}else{
			
			if(password1.length<=0){
				
				validatePwd=false;
				validatePwd1=false;
				
				/* $(".password1_info1").html(password1_info1); */
				$(".password1_info2").html(imgError+"&nbsp;<font color='red'>Confirm password cannot be empty!</font>");
				
			}else{
				
				if(password==password1){
					
					validatePwd=true;
					validatePwd1=true;
					
					$(".password_info1").html(imgRight);
					$(".password_info2").html("");
					$(".password1_info1").html(imgRight);
					$(".password1_info2").html(" ");
					
				}else{
					
					validatePwd=false;
					validatePwd1=false;
					
					$(".password_info1").html(imgRight);
					$(".password_info2").html("");
					/* $(".password1_info1").html(password1_info1); */
					$(".password1_info2").html(imgError+"&nbsp;<font color='red'>Passwords do not match!</font>");
				}
				
			}
			
		}
						
	});
	
	$("#password1").focus(function(){
		$("#password1").css("border","2px #aaa solid");
	});
	$("#password1").blur(function(){
		$("#password1").css("border","1px #bbc solid");
	});
	
	
	
	// 验证邮箱 validateEmail
	$("#email").change(function(){
		
		var email=$.trim($("#email").val());
		// var email_filter =
		// /^([a-zA-Z0-9]+[_|_|.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|_|.]?)*[a-zA-Z0-9]+\.(?:com|cn)$/;
		var email_filter = /^(\w)+(\.\w+)*@(\w)+((\.\w+)+)$/;	
		
		if(email.length<=0){
			
			validateEmail=false;
		/* $(".email_info1").html(email_info1); */
			$(".email_info2").html(imgError+"&nbsp;<font color='red'>Email can't be empty!</font>");
			
		}else{
			
			/*
			 * if(!email.match(email_filter)){
			 * 
			 * validateEmail=false;
			 * 
			 * $(".email_info1").html(email_info1);
			 * $(".email_info2").html(imgError+"&nbsp;<font
			 * color='red'>Email address format is illegal!</font>");
			 * 
			 * }else{
			 */
				
				$.ajax({
		            type:"post",
		            url:"checkEmail.do",
		            data:"email="+email,		            
		            error:function(){
		                alert(""+reMarks['print15']+"");
		                validateEmail=false;
		            },
		            success:function(msg){	
		            	
		                if(msg=="error"){
		                	
		                	validateEmail=false;
		                	
		                	/* $(".email_info1").html(email_info1); */
		                	$(".email_info2").html(imgError+"&nbsp;<font color='red'>The email address is already being used!</font>");
		                	
		                }else if(msg=="wrong"){
		                	
		                	$(".email_info1").html(imgError);
		                	$(".email_info2").html(imgError+"&nbsp;<font color='red'>Email address format is illegal!</font>");
		                	
		                }else{
		                	
		                	validateEmail=true;
		                	
		                	$(".email_info1").html(imgRight);
		    				$(".email_info2").html(" ");			                			                				                	
		                }
		            }
		        });				
			}
		/* } */
	});
	
	$("#email").focus(function(){
		$("#email").css("border","2px #aaa solid");
	});
	$("#email").blur(function(){
		$("#email").css("border","1px #bbc solid");
	});
	
	
	
	// 验证码 验证
	$("#mycode").keyup(function(){
		
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
	                alert(reMarks['print15']);
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
	
	
	
	
	// 点击注册：先验证用户名、密码等是否都合法 validateName validatePwd validatePwd1 validateEmail
	// validateCode
	
	$("#toRegister").click(function(){									
		
		/*
		 * var
		 * validate=validateName&&validatePwd&&validatePwd1&&validateEmail&&validateCode&&validateNickName;
		 */
		
		if(validateCode){
			$("#regForm").submit();
		}
		
	});
}); 
