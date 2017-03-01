   $(document).ready(function(){ 
           $("#findQuestion").click(function(){
               var userName=$.trim($("#userName").val());
               if(userName=="")
               {
               alert("User name is empty");
               }else{
    
                  $.ajax({

		type : "get",
		url : "getProtectQuestion.do?userName=" +userName,
		data : null,
		dataType : "json",
		error : function(request) {
			alert("Connection error");
		},
		success : function(data) {
             //alert(typeof data);
			
		     var result=eval(data);		     
			//alert(result[0]);
		   /*  alert(data);*/
			if (data == null) {
				//alert("null");
				$("#nameError").html("The user name does not exist or not set password security question");
				$("#questionTable").css("display","none");
			} else {
				//alert("!!!");
				$("#nameError").html(" ");
				var questionHtml="";
				$("#questionTable").css("display","block");
				
				for (var i = 0; i < result.length; i++) {
					 a=result[i];

				 questionHtml += "<option value='"+i+"'>"
					                +result[i]+"</option>";
				 				 
                }
               $("#listQuestion").html(questionHtml); 
			
			}

		}
	});
               }
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
         		
         		var validate=validateNewPwd1&&validateNewPwd2;
         		
         		if(validate){
         			$("#regForm").submit();
         		}
         		
         	});
         	
  });