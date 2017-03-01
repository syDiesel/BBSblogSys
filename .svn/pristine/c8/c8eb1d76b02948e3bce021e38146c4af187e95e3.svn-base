function form_submit(){
	document.getElementById("loginForm").submit();
	
}
function form_reset(){
	document.getElementById("loginForm").reset();
}


function createAjaxObj(){
	var req;
	if(window.XMLHttpRequest){
		req = new XMLHttpRequest();
	}else{
		req = new ActiveXObject("Msxml2.XMLHTTP");  //ie
	}
	return req;
}

function checkNum(){
	var req = createAjaxObj();
	var mycode = document.getElementById("mycode").value;


	req.open("post","ajax.do?action=checkNum&Num="+mycode);
	req.setRequestHeader("accept","application/json"); 
	req.onreadystatechange  = function(){
		if (req.readyState==4 && req.status==200)
	    {
		
		if(req.responseText=="true"){
				form_submit();
			/* alert("正确");*/
				}
		else alert("Please enter correct verification code");
	    }
	}
	req.send(null);
}
