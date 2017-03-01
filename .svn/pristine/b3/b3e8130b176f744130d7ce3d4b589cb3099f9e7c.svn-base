$(function(){
	
	$("#ajaxLabel").click(function(){

		var count = $(":checkbox:checked").length;
		
		
		
		

			$("#errorLab").css("display", "none");
		
		
		
		
		
		if(count>2){
			$(":checkbox").each(function(){
				if(!this.checked){
					this.disabled=true;
				}
			});
		}else{
			$(":checkbox").each(function(){
					this.disabled=false;
			});
		}	
		
	});
});