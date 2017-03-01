
window.onload = function() {	

	
	var personMarry=document.getElementById("personMarry").value;
	
	var personZongjiao=document.getElementById("personZongjiao").value;

	var option=document.getElementsByTagName("option");

	

	for(var i=0;i<option.length;i++)
		{
	        if(option[i].innerHTML==personMarry)
	        	option[i].selected="true";
	        
	        if(option[i].innerHTML==personZongjiao)
	        	option[i].selected="true";
	       
		}
	
	
}


function check(){
	var idno=document.getElementById("idno").value;
	if(idno.length!=18)
		{
		document.getElementById("idnoInfo").innerHTML="Please enter a valid ID number";
		return false;
		}else{
			document.getElementById("idnoInfo").innerHTML="";
			return true;
		}
}