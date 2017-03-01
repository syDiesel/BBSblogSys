/**
	 * 
	 * @author swh	 
	 * 
	 * @date 2014-9-3
	 * 
	 * @param ajax登录  验证
	 * 
	 * 
	 */

$(document).ready(function(){
		
	
	//合法性验证
	var validateName=false;		
	var validatePwd=false;		
	var validateCode=false;		
	
	
	//图片路径
	var basePath=$('#basePath').val();
	var imgError="<img src='"+basePath+"images/home/wrong.jpg' width=15px height=15px>";
	var imgRight="<img src='"+basePath+"images/home/right.jpg' width=20px height=20px>";
	
	
	//文本框右边的信息显示
	var username_info1=$(".username_info1").attr("tempUsername");	
	/*var password_info1=$(".password_info1").attr("tempPassword");*/
	
	//验证用户名或Email
	
	$("#username").change(function(){  			
		var username=$.trim($("#username").val());
		var password=$.trim($("#password").val());
		
		var username_filter = /^[a-zA-Z0-9_]{1,}$/;	
		
		if(username.length<=0){
			validateName=false;
			$(".username_info1").html(imgError);			
		}else{
			if(!username.match(username_filter)){
				validateName=false;
				$(".username_info1").html(imgError);
			}else{
				if( (username.length<5)||(username.length>20) ){
					validateName=false;
					$(".username_info1").html(imgError);
					
					validatePwd=false;
                	/*$(".password_info1").html(imgError);*/
				}else{			
					$.ajax({
			            type:"post",
			            url:"checkUserNameOrEmail.do",
			            data:"userName="+username+"&passWord="+password,			            
			            error:function(){
			            	alert(""+mark['print']+"");
			                validateName=false;
			            },
			            success:function(msg){		               
			                if(msg=="0"){
			                	validateName=false;
			                	$(".username_info1").html(imgError);
			             /*   	validatePwd=false;
			                	$(".password_info1").html(imgError);*/
			                }else if(msg=="1"){
			                	validateName=true;
			                	$(".username_info1").html(imgRight);
			                /*	validatePwd=false;
			                	$(".password_info1").html(imgError);*/
			                }else if(msg=="2"){
			                	validateName=true;
			             /*   	validatePwd=false;*/
			                	$(".username_info1").html(imgRight);
			                /*	$(".password_info1").html(imgError);*/
			                }else if(msg=="ok"){
			                	validateName=true;
			                	validatePwd=true;
			                	$(".username_info1").html(imgRight);
			                	$(".password_info1").html(imgRight);
			                }else{
			                	
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
	
	
	//密码
	
/*	$("#password").keyup(function(){
		
		var username=$.trim($("#username").val());	//用户名或Email
		var password=$.trim($("#password").val());
		
		if(username.length<5){
			validatePwd=false;
        	$(".password_info1").html(imgError);
		}else{
			
			if(password.length<5){
				validatePwd=false;
	        	$(".password_info1").html(imgError);
			}else{
				
				$.ajax({
		            type:"post",
		            url:"checkUserPassword.do",
		            data:"userName="+username+"&passWord="+password,			            
		            error:function(){
		            	alert(""+mark['print']+"");
		                validatePwd=false;
		            },
		            success:function(msg){	
		            	if(msg=="0"){
		            		validateName=false;
		                	$(".username_info1").html(imgError);
		                	validatePwd=false;
		                	$(".password_info1").html(imgError);
		            	}else if(msg=="1"){
		            		validateName=true;
		                	$(".username_info1").html(imgRight);
		                	validatePwd=false;
		                	$(".password_info1").html(imgError);
		                }
		            	else if(msg=="ok"){
		            		validateName=true;
		                	validatePwd=true;
		                	$(".username_info1").html(imgRight);
		                	$(".password_info1").html(imgRight);
		                }else{
		                			                		                			                				              
		                }
		            }
		        });
			}
		}
		
	});*/
	
	$("#password").focus(function(){
		$("#password").css("border","2px #aaa solid");
	});
	$("#password").blur(function(){
		$("#password").css("border","1px #bbc solid");
	});
	
	
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
	                alert(""+mark['print']+"");
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
	
	
	//点击登录：先验证用户名、密码等是否都合法 validateName validatePwd  validateCode
	$("#toLogin").click(function(){									

		 var validate=validateCode&&validateName;
		   if(validate){
			  
				$("#loginForm").submit();
   
		   }
	});
	
});