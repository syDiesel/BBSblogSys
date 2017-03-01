
window.onload = function() {	

	
	var shengao=document.getElementById("personShengao").value;
	var guoji=document.getElementById("personGuoji").value;
	var jiguan=document.getElementById("personJiguan").value;
	var tizhong=document.getElementById("personTizhong").value;
	var xuexing=document.getElementById("personXuexing").value;
	var address=document.getElementById("personAddress").value;
	var option=document.getElementsByTagName("option");

	

	for(var i=0;i<option.length;i++)
		{
	        if(option[i].innerHTML==shengao)
	        	option[i].selected="true";
	        if(option[i].innerHTML==tizhong)
	        	option[i].selected="true";
	        if(option[i].innerHTML==xuexing)
	        	option[i].selected="true";
	        if(option[i].innerHTML==jiguan)
	        	option[i].selected="true";
	        if(option[i].innerHTML==guoji)
	        	option[i].selected="true";
	        if(option[i].innerHTML==address)
	        	option[i].selected="true";
		}
	
	
}




function check(){
	var desc=document.getElementById("personalDesc").value;
	if(desc.length>100)
		{
		document.getElementById("descInfo").innerHTML="Individual resume less than 100 characters";
		    return false;
		}
	else{
		document.getElementById("descInfo").innerHTML="";
		return true;
	}
}