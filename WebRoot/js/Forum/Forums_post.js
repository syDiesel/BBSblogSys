

 //显示投票
        
		  
		  function showTP()
		  {		
			  var isTP=document.form1.TP.value;		  
			  if(isTP==1)
			    $("#editTP").css("display","block");
			  else
				  $("#editTP").css("display","none");
		  }
		  
		  
		  function addMoreTP()
		  {
			  $("#moreTP").css("display","block");
			  $("#addMore").css("display","none");
			  
		  }
		  
		  
		  function checkOther()
		  {
			  var userLevel=document.getElementById("userLevel").value;
	          
			  var lingdan=document.getElementById("lingdan").value;
			  
			  var userLingdan=document.getElementById("userLingdan").value;
			  
			  var reply_access=document.getElementById("reply_access").value;
			  
			  var access=false;
			 
			  var TP=false;
			  
			  var isTP=document.form1.TP.value;	
			  
			  var el = document.getElementsByTagName('input'); 
	         
			  var result=false;
	          
			  var len = el.length; 
			  
			  var discuss=document.getElementById("discuss").value;
			  
			//验证用户是否有回复权限
			  if((parseInt(userLevel)+1)<reply_access) 
				  {
				  
		    	   if(confirm("Your level is not enough, need to pay a panacea,are you sure you pay a panacea ?"))
		    		   {
		    		     if(lingdan=="1")//灵丹够用
		    		    	 {
		    		    	 access=true;
		    		    	 }else{	    		    		
		    		    		access=false;
		    		    		alert("All is not enough, please recharge");
		    		    		return false;
		    		    	 }
		    		
				       }
		    	
				  }else{
					  access=true;
				  }
			  
			  
			  
			  if(isTP==1)
			  {
				  var TPtext=false;
				  //alert("checkTP"+TP1+"     "+TP1.length);
	    		  for(var i=0; i<len; i++)
	    			  {
	    			  //alert(i);
	    			  if((el[i].type=="text") && (el[i].name=="TP1")&&($.trim(el[i].value).length>0)) 
	    			  { TPtext=true;
	    			  $("#TPinfo").css("display","none")}
	    			  }
	    		  if(TPtext==false)
	    			  {
	    			 
	    			  $("#TPinfo").css("display","block");
	    			  return false;
	    			  }
	    		  
	    		  var TPtitle=$.trim($("#TPtitle").val());
	              if(TPtitle=="")
	              { 
	            	  $("#TPtitleInfo").css("display","block");
	                  return false;
	              }
	              else
	            	  $("#TPtitleInfo").css("display","none");
	    		  
	    		  var Btime=document.form1.time1.value;
	   		      var Etime=document.form1.time2.value;
	   		      
		    	    if($.trim(Btime)=="")
		    	    	{
		    	    	$("#TPtimeInfo").css("display","block");
		    	    	return false;
		    	    	}else if($.trim(Etime)=="")
		    	    		{
		    	    		$("#TPtimeInfo").css("display","block");
			    	    	return false;
		    	    		}
		    	    		else{
		    	    		var time1=Btime.split("-");
		    	    		var time2=Etime.split("-");
		    	    		
		    	    	    for(var i=1;i<time1.length;i++)
		    	    	    {
		    	    	       if(time1[i].length<2)
		    	    	          time1[i]="0"+time1[i];
		    	    	       if(time2[i].length<2)
			    	    	          time2[i]="0"+time2[i];
		    	    	    }
		    	    	    Btime=time1[0]+"-"+time1[1]+"-"+time1[2];
		    	    	    Etime=time2[0]+"-"+time2[1]+"-"+time2[2];
		    	    	  
		    	    		var d2 = new Date(Etime);
		    	    		var d1 = new Date(Btime);
		    	    		
		    	    		//alert(d1+" "+d2);
		    	    		
		    	    		var n = d1.getTime() - d2.getTime();
		    	    	    if (n >= 0) {
		    	    	    	$("#TPtimeInfo").css("display","block");
		    	    	        return false;
		    	    	    } else{
		    	    	    	$("#TPtimeInfo").css("display","none");
		    	    	    }
		    	    	    }
		    	    	
				  
				  if(confirm("Vote required to pay ten a panacea,determining payment ten panaceas ?"))
					  {
			      if(userLingdan<10)
			    	  {
			    	       TP=false;
			    		   alert("All is not enough, please recharge");
			    		   return false;
			    	  }else if(TPtext==true){
	                       TP=true;
			    	  }
					  }
			      
			  }
			  
			  
			  
			  //验证用户是否选择版块
			 if(discuss=="origin")
	        {
				 
	         var board=document.getElementById("boardId").value;
	         if(board==-1)
	          {
	       	  result=false;
	       	  //alert(a10['a10']);
	       	 $("#boardInfo").css("display","block");
	          return false;
	          }
	         
	        }else{
	        	 $("#boardInfo").css("display","none");
	        	 
	        	result=true;
	        }
			 
			 
			  //验证用户是否选择标签
			 if(discuss=="origin")
	        {
				 
	          for(var i=0; i<len; i++) { 
	        	 
	         if((el[i].type=="checkbox") && (el[i].name=='labelId')&&(el[i].checked==true)) { 
	        	 
	                 result=true;     
	                 $("#labelInfo").css("display","none");
	               } 
	            } 
	         if(!result)
	          {
	       	  result=false;
	       	  //alert(a10['a10']);
	       	 $("#labelInfo").css("display","block");
	          return false;
	          }
	         
	        }else{
	        	 $("#labelInfo").css("display","none");
	        	 
	        	result=true;
	        }
			 
			 
			 /*//验证keyword
			 var keywords=document.getElementById("keyword").value;
			 var validateKeyword=false;
			 if($.trim(keywords)!="")
				 {
				 var listKeyword=keywords.split(";");
				 if(listKeyword.length>3)
					 {
					 $("#keywordInfo").css("display","block");
					 validateKeyword=false;
					 return false;
					 }else
						 {
						
						 $("#keywordInfo").css("display","none");
						 validateKeyword=true;
						 }
				 }else{
					 $("#keywordInfo").css("display","block");
					 validateKeyword=false;
					 return false;
				 }
			*/
			 
			 
			 
			 //验证标题
	         var post_title=$.trim(document.getElementById("post_title").value);
		     var title=false;
		     if(post_title=="")
		    	 {
		    	 title=false;
		    	 $("#titleInfo").css("display","block");
		    	 return false;
		    	 }else{
		    			 title=true;
		    			 $("#titleInfo").css("display","none");
		    
		    		 }
		     
		     
		     var validateTP=false;
		     if(isTP==0)
		    	 validateTP=true;
		     else if(isTP==1&&TP==true)
		    	 validateTP=true;
		     
		     var result1=access&&result&&title&&validateTP;
		    
		     //alert("access"+access+"result"+result+"title"+title+"validateTP"+validateTP);
		     
		     //alert(result1);
		     if(result1)
		    	 {
		    	 //alert("true");
		    	 return true;
		    	 }else
		    		 {
		    		// alert("false");
		    		 return false;
		    		 }
	         
			  
		  }

   
		
	
		  function  submitForm(){									
								
	        	
			  
			  
	        	  var code=false;

	              //验证验证码
	                
	        	    var checkNum = document.getElementById("chknumber").value;
	        	    if(checkNum.length!=4)
	        	    	{
	        	    	/*document.getElementById("chknumber").style.border="#ff0000 solid 2px";*/
	        	    	 $("#codeInfo").css("display","block");
	        	    	 code=false;
	        	    	 return false;
	        	    	}
	        	    if(checkNum.length==4){
	        	    	
	        			$.ajax({
	        	            type:"post",
	        	            url:"checkNum.do",
	        	            data:"mycode="+checkNum,         
	        	            error:function(){
	        	                alert("connection error");
	        	                code=false;
	        	               return false;
	        	            },
	        	            success:function(msg){	
	        	            	
	        	            	if(msg=="error"){
	        	                	code=false;
	        	                	//alert(a13['a13']);
	        	                	 $("#codeInfo").css("display","block");
	        	                   
	        	                }else{
	        	                	//alert("正确");
	        	                	code=true;
	                              // alert(code);
	        	                	$("#codeInfo").css("display","none");
	                               if(checkOther())
	                            	   {
	                            	   $("#form1").submit();
	                            	   }
	                               

	        	                
	        	                }
	        	            }
	        	        });	
	        	    }
	        	
		  }
     	
	    	
	        
	       

	    
	        
	