window.onload = function() {
	var msg=document.getElementById("msg").value;
    if(msg==1){
  	       /* document.getElementById("displayTP").style.display="block";*/
          	document.getElementById("TPprocess").style.display="none";
          	document.getElementById("TPresult").style.display="block"; 	
          }else if(msg=="noTP")
          {
          	document.getElementById("displayTP").style.display="none";
             /* document.getElementById("TPprocess").style.display="none";
          	document.getElementById("TPresult").style.display="none"; */
          }else if(msg=="notBegin")
          {
          	/*document.getElementById("displayTP").style.display="block";*/
              document.getElementById("TPbutton").disabled=true;
              document.getElementById("TPmsg").innerHTML="Voting has not started";
          }else if(msg=="TPEnd"){
          	/*document.getElementById("displayTP").style.display="block";*/
              document.getElementById("TPresult").style.display="block"; 
              document.getElementById("TPprocess").style.display="none";
              document.getElementById("TPmsg").innerHTML="Voting has ended";
          }else if(msg=="noUser"){
          	/*document.getElementById("displayTP").style.display="block";*/
          	document.getElementById("TPbutton").disabled="disabled";
              document.getElementById("TPmsg").innerHTML="You need to login to vote&nbsp;&nbsp;&nbsp;<a style='color:#0ff;'  href='login.html'>【登录】</a>";
          }else{
          	
          }

}                    


var basePath=document.getElementById("basePath").value;
	
function yinyong(id) {
        
		 
         var content=document.getElementById("replyContent"+id).innerHTML;
         
         var name=document.getElementById("fr"+id).innerHTML+document.getElementById("nickName"+id).innerHTML;
         
         var div="<hr><br><span style='color:#999;'>【quote："+name+"】<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+content+"</span><br><hr><br><br>";
         
         editor.insertHtml(div);

         window.location.hash = "#writeReply"; 
 
    } 	
    
    
    function reply(){
         //window.location.hash = "#writeReply";
    	//alert("reply");
         document.getElementById('writeReply').scrollIntoView();
    }	 
    
    function addTP(){
               var el = document.getElementsByTagName("input");
               var resultTP=false;
               var len = el.length;  
                 
               for(var k=0; k<len; k++) {          
              if(el[k].checked==true&&el[k].id=="forumTPcheck") { 
              
                 resultTP=true;        	                          
                    } 
                 } 
              if(!resultTP)
               {alert("Please select the investment options");}
              return resultTP;
    }
    
    
    function check(){
    	
        var jinzhuan=document.getElementById("jinzhuan").value;
        var lingdan=document.getElementById("lingdan").value;
        var poster_id=document.getElementById("poster_id").value;
        var userInfo_id=document.getElementById("userInfo_id").value;
        var userLevel=document.getElementById("userLevel").value;
        var replyAccess=document.getElementById("replyAccess").value;
       
        if(poster_id!=userInfo_id)
        	{
        	    if((userLevel+1)<replyAccess)//因为设置权限时存值从1开始，等级是从0开始
        	    	{
        	    	 
        	    	    if(document.getElementById("check_lingdan").checked==true)
        	    	    	{
        	    	    	 if(confirm("This behavior will consume a panaceas, sure?"))
        	    	    	   if(lingdan<1)
        	    	    		   {
        	    	    		   alert("Panaceas is not enough，Please change the brics");
        	    	    		   return false;
        	    	    		   }else{
        	    	    			   return true;
        	    	    		   }
        	    	    	 else
        	    	    		 return false;
        	    	    	}else{
        	    	    		if(confirm("it will cost a panacess,sure?"))
        	    	    		if(jinzhuan<1)
        	    	    		 {
         	    	    		   alert("Brics is not enough, Please change pasaceas");
         	    	    		   return false;
         	    	    		   }else{
         	    	    			   return true;
         	    	    		   }
        	    	    		else
        	    	    			return false;
        	    	    	}
        	    	}else{
        	    		return true;
        	    	}
        	    
        	}else{
        		return true;
        	}
       }
       
       
       
       
       function checkPass()
       {
          var result=0; 
          var processCause=$.trim(document.getElementById("processCause").value);
          
            for(var i=0;i<document.form2.isPass.length;i++)
          {
             
             if(document.form2.isPass[i].checked)
             {
               //alert("checked");
               result=1;
                 if(processCause.length>500||processCause.length==0)
                 {
                   alert("Words not qualified");
                   return false;
                 }else
                 {return true;}
             }
         
          } 
          
          if(result==0)
          {
              alert("Please choose whether or not to pass the audit");
              return false;
          } 
      
          
       }
       
       
       
       function comment(type,reply_id,count){
         //alert("type:"+type+" reply_id="+reply_id);
        
          	$.ajax({
   			            type:"post",
   			            url:"comment.do?type="+type+"&reply_id="+reply_id+"&basePath="+basePath,		            
   			            error:function(){
   			                alert("connection error");
   			               
   			            },
   			            success:function(msg){		               
   			                if(msg=="error"){
   			                	
   			                	alert("You have been evaluated, please do not repeat the evaluation");
   			                }else if(msg=="noLoginUser")
   			                	{
   			                	   alert("Please evaluate after login");
   			                	}else{
   			                	
   			                	
   			                	//alert(type);
   			                	if(type=="up")
   			                	{
   			                	  //alert("up");
   			                	  document.getElementById("up"+reply_id).innerHTML=msg;
    			                	}else if(type=="normal")
   			                	{
   			                	  //alert("normal");
   			                	  document.getElementById("normal"+reply_id).innerHTML=msg;
   			                	}else{
   			                	 // alert("down");
   			                	  document.getElementById("down"+reply_id).innerHTML=msg;
   			                	}
   			                	
   			                		                			                				                	
   			                }
   			            }
   			        });	
       }
       
       
       
       
       
       function YMorSH(type,role,receiver_id,count){
         
    	   
    	   if(confirm("This operation requires to deduct a panacea, you determine the implementation"))
            	$.ajax({
     			            type:"post",
     			            url:"YMorSH.do?type="+type+"&receiver_id="+receiver_id,		            
     			            error:function(){
     			                alert("connection error！");
     			               
     			            },
     			            success:function(msg){		               
     			                if(msg=="error"){    			                	
     			                	alert("All is not enough, please recharge");
     			                }else{
     			                	if(type=="yangmu")
     			                		{
     			                		var c=document.getElementsByClassName("yangmu"+receiver_id);
     			                		
     			                		
     			                		for(var i=0;i<c.length;i++)
     			                			{
     			                			c[i].innerHTML=msg;
     			                			}
     			                		  
     			                		}
     			                	if(type=="songhua")
     			                		{
     			                		
     			                		var c=document.getElementsByClassName("xianhua"+receiver_id);
     			                		for(var i=0;i<c.length;i++)
 			                			{
 			                			c[i].innerHTML=msg;
 			                			}
     			                		}
     			                	
     			                	
     			                	              			                				                	
     			                }
     			            }
     			        });	
         }
       
       
       function confirmDel()
       {
    	   if(confirm("Determine the implementation of the operation"))
    		   return true;
    	   else 
    		   return false;
       }
       
       
       function confirmLock()
       {
    	   if(confirm("Determine the implementation of the operation"))
    		   return true;
    	   else 
    		   return false;
       }
       
 