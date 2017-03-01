$(function() {

	$("#collect_blogContent").css("display", "none");
	$("#collect_questionContent").css("display", "none");
	$('#collect_blog').css("background", "#fff");
	$('#collect_blog').css("color", "#333");
	$('#collect_question').css("background", "#fff");
	$('#collect_question').css("color", "#333");
	
	var value = $("#choose_collect").val();
	if(value == '1'){
		$("#collect_questionContent").css("display","block");
		$('#collect_question').css("background","#087ec4");
		$('#collect_question').css("color","#fff");
		
	}else{
		$("#collect_blogContent").css("display","block");
		$('#collect_blog').css("background","#087ec4");
		$('#collect_blog').css("color","#fff");
		
	}

	$("#collect_blog").click(function() {
		$("#choose_collect").val("0");
		
		$("#collect_blogContent").css("display","block");
		$('#collect_blog').css("background","#087ec4");
		$('#collect_blog').css("color","#fff");
		
		$("#collect_questionContent").css("display","none");
		$('#collect_question').css("background", "#fff");
		$('#collect_question').css("color", "#333");

	});

	$("#collect_question").click(function() {
		$("#choose_collect").val("1");
		
		$("#collect_blogContent").css("display","none");
		$('#collect_blog').css("background", "#fff");
		$('#collect_blog').css("color", "#333");
		
		$("#collect_questionContent").css("display","block");
		$('#collect_question').css("background","#087ec4");
		$('#collect_question').css("color","#fff");

	});

});