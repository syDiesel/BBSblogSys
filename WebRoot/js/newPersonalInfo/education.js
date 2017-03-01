
window.onload = function() {	

	
	var personZhuanye=document.getElementById("personZhuanye").value;
	var personXueli=document.getElementById("personXueli").value;
	var personDegree=document.getElementById("personDegree").value;
	var option=document.getElementsByTagName("option");

	

	for(var i=0;i<option.length;i++)
		{
	        if(option[i].innerHTML==personZhuanye)
	        	option[i].selected="true";
	        if(option[i].innerHTML==personXueli)
	        	option[i].selected="true";
	        if(option[i].innerHTML==personDegree)
	        	option[i].selected="true";
	      
		}
	
	
}
