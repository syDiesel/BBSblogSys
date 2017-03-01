
window.onload = function() {	

	
	var personWorkYear=document.getElementById("personWorkYear").value;
	var personHangye=document.getElementById("personHangye").value;
	
	var option=document.getElementsByTagName("option");

	

	for(var i=0;i<option.length;i++)
		{
	        if(option[i].innerHTML==personWorkYear)
	        	option[i].selected="true";
	        if(option[i].innerHTML==personHangye)
	        	option[i].selected="true";
	       
		}
	
	
}


function check(){
	var personalJobPlan=document.getElementById("personalJobPlan").value;
	if(personalJobPlan.length>100)
		{
		document.getElementById("planInfo").innerHTML="Career planning please don't beyond 100 words";
		    return false;
		}
	else{
		document.getElementById("planInfo").innerHTML="";
		return true;
	}
}
