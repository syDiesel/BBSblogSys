$(function(){
	
	$("#concerContent").css("display","none");
	$("#concer_auditContent").css("display","none");
	$("#friendContent").css("display","none");
	$("#friend_auditContent").css("display","none");
	$("#ans_questionContent").css("display","none");
	$("#ans_forumContent").css("display","none");
	$('#concer').css("background","#fff");
	$('#concer').css("color","#333");
	$('#concer_audit').css("background","#fff");
	$('#concer_audit').css("color","#333");
	$('#friend').css("background","#fff");
	$('#friend').css("color","#333");
	$('#friend_audit').css("background","#fff");
	$('#friend_audit').css("color","#333");
	$('#ans_question').css("background","#fff");
	$('#ans_question').css("color","#333");
	$('#ans_forum').css("background","#fff");
	$('#ans_forum').css("color","#333");
	
	var value = $("#choose").val();
	if(value == '1'){
		$("#concerContent").css("display","block");
		$('#concer').css("background","#087ec4");
		$('#concer').css("color","#fff");
		
	}else if(value == '2'){
		$("#concer_auditContent").css("display","block");
		$('#concer_audit').css("background","#087ec4");
		$('#concer_audit').css("color","#fff");
		
	}else if(value == '3'){
		$("#friendContent").css("display","block");
		$('#friend').css("background","#087ec4");
		$('#friend').css("color","#fff");
		
	}else if(value == '4'){
		$("#friend_auditContent").css("display","block");
		$('#friend_audit').css("background","#087ec4");
		$('#friend_audit').css("color","#fff");
		
	}else if(value == '5'){
		$("#ans_questionContent").css("display","block");
		$('#ans_question').css("background","#087ec4");
		$('#ans_question').css("color","#fff");
		
	}else if(value == '6'){
		$("#ans_forumContent").css("display","block");
		$('#ans_forum').css("background","#087ec4");
		$('#ans_forum').css("color","#fff");
		
	}else{
		$("#concerContent").css("display","block");
		$('#concer').css("background","#087ec4");
		$('#concer').css("color","#fff");
	}
	
	
	
	$("#concer").click(function(){
		
		$("#choose").val("1");
		
		$("#concerContent").css("display","block");
		$("#concer_auditContent").css("display","none");
		$("#friendContent").css("display","none");
		$("#friend_auditContent").css("display","none");
		$("#ans_questionContent").css("display","none");
		$("#ans_forumContent").css("display","none");
		
		$('#concer').css("background","#087ec4");
		$('#concer').css("color","#fff");
		$('#concer_audit').css("background","#fff");
		$('#concer_audit').css("color","#333");
		$('#friend').css("background","#fff");
		$('#friend').css("color","#333");
		$('#friend_audit').css("background","#fff");
		$('#friend_audit').css("color","#333");
		$('#ans_question').css("background","#fff");
		$('#ans_question').css("color","#333");
		$('#ans_forum').css("background","#fff");
		$('#ans_forum').css("color","#333");
	});
	
	$("#concer_audit").click(function(){
		$("#choose").val("2");
		
		$("#concerContent").css("display","none");
		$("#concer_auditContent").css("display","block");
		$("#friendContent").css("display","none");
		$("#friend_auditContent").css("display","none");
		$("#ans_questionContent").css("display","none");
		$("#ans_forumContent").css("display","none");
		
		$('#concer').css("background","#fff");
		$('#concer').css("color","#333");
		$('#concer_audit').css("background","#087ec4");
		$('#concer_audit').css("color","#fff");
		$('#friend').css("background","#fff");
		$('#friend').css("color","#333");
		$('#friend_audit').css("background","#fff");
		$('#friend_audit').css("color","#333");
		$('#ans_question').css("background","#fff");
		$('#ans_question').css("color","#333");
		$('#ans_forum').css("background","#fff");
		$('#ans_forum').css("color","#333");
	});
	
	$("#friend").click(function(){
		$("#choose").val("3");
		
		$("#concerContent").css("display","none");
		$("#concer_auditContent").css("display","none");
		$("#friendContent").css("display","block");
		$("#friend_auditContent").css("display","none");
		$("#ans_questionContent").css("display","none");
		$("#ans_forumContent").css("display","none");
		
		$('#concer').css("background","#fff");
		$('#concer').css("color","#333");
		$('#concer_audit').css("background","#fff");
		$('#concer_audit').css("color","#333");
		$('#friend').css("background","#087ec4");
		$('#friend').css("color","#fff");
		$('#friend_audit').css("background","#fff");
		$('#friend_audit').css("color","#333");
		$('#ans_question').css("background","#fff");
		$('#ans_question').css("color","#333");
		$('#ans_forum').css("background","#fff");
		$('#ans_forum').css("color","#333");
	});
	
	$("#friend_audit").click(function(){
		$("#choose").val("4");
		
		$("#concerContent").css("display","none");
		$("#concer_auditContent").css("display","none");
		$("#friendContent").css("display","none");
		$("#friend_auditContent").css("display","block");
		$("#ans_questionContent").css("display","none");
		$("#ans_forumContent").css("display","none");
		
		$('#concer').css("background","#fff");
		$('#concer').css("color","#333");
		$('#concer_audit').css("background","#fff");
		$('#concer_audit').css("color","#333");
		$('#friend').css("background","#fff");
		$('#friend').css("color","#333");
		$('#friend_audit').css("background","#087ec4");
		$('#friend_audit').css("color","#fff");
		$('#ans_question').css("background","#fff");
		$('#ans_question').css("color","#333");
		$('#ans_forum').css("background","#fff");
		$('#ans_forum').css("color","#333");
	});
	
	$("#ans_question").click(function(){
		$("#choose").val("5");
		
		$("#concerContent").css("display","none");
		$("#concer_auditContent").css("display","none");
		$("#friendContent").css("display","none");
		$("#friend_auditContent").css("display","none");
		$("#ans_questionContent").css("display","block");
		$("#ans_forumContent").css("display","none");
		
		$('#concer').css("background","#fff");
		$('#concer').css("color","#333");
		$('#concer_audit').css("background","#fff");
		$('#concer_audit').css("color","#333");
		$('#friend').css("background","#fff");
		$('#friend').css("color","#333");
		$('#friend_audit').css("background","#fff");
		$('#friend_audit').css("color","#333");
		$('#ans_question').css("background","#087ec4");
		$('#ans_question').css("color","#fff");
		$('#ans_forum').css("background","#fff");
		$('#ans_forum').css("color","#333");
	});
	
	$("#ans_forum").click(function(){
		$("#choose").val("6");
		
		$("#concerContent").css("display","none");
		$("#concer_auditContent").css("display","none");
		$("#friendContent").css("display","none");
		$("#friend_auditContent").css("display","none");
		$("#ans_questionContent").css("display","none");
		$("#ans_forumContent").css("display","block");
		
		$('#concer').css("background","#fff");
		$('#concer').css("color","#333");
		$('#concer_audit').css("background","#fff");
		$('#concer_audit').css("color","#333");
		$('#friend').css("background","#fff");
		$('#friend').css("color","#333");
		$('#friend_audit').css("background","#fff");
		$('#friend_audit').css("color","#333");
		$('#ans_question').css("background","#fff");
		$('#ans_question').css("color","#333");
		$('#ans_forum').css("background","#087ec4");
		$('#ans_forum').css("color","#fff");
	});
	

});