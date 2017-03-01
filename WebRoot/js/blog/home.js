$(document).ready(function() {

	var basePath = $('#basePath').val();
	var nickName = $('#hidden').val();
	var href = $("#xqzs_more").href;
	var blog = basePath + 'web/Blog/' + nickName + '/Log';
	var post = basePath + "web/Blog/" + nickName + "/bbs";
	var question = basePath + "web/Blog/" + nickName + "/question";

	$('#PersonInfoBtn').click(function() {
		
		$('#PersonInfo').css("display", "block");
		$('#friendDt').css("display", "none");
		$('#PersonInfoBtn').css("background", "#087ec4");
		$('#PersonInfoBtn').css("color", "#fff");
		$('#friendDtBtn').css("background", "#fff");
		$('#friendDtBtn').css("color", "#333");
		$('#PersonInfoBtn_more').css("display","block");
		$('#friendDtBtn_more').css("display","none");

	});
	$('#friendDtBtn').click(function() {
		
		$('#PersonInfo').css("display", "none");
		$('#friendDt').css("display", "block");
		$('#friendDtBtn').css("background", "#087ec4");
		$('#friendDtBtn').css("color", "#fff");
		$('#PersonInfoBtn').css("background", "#fff");
		$('#PersonInfoBtn').css("color", "#333");
		$('#PersonInfoBtn_more').css("display","none");
		$('#friendDtBtn_more').css("display","block");
	});
	// 这里开始兴趣
	$('#interestBlogBtn').click(function() {

		$('#interestBlog').css("display", "block");
		$('#interestForum').css("display", "none");
		$('#interestQuestion').css("display", "none");
		$('#interestLabel').css("display", "none");

		$('#interestBlogBtn').css("background", "#087ec4");
		$('#interestBlogBtn a').css("color", "#fff");
		$('#interestForumBtn').css("background", "#fff");
		$('#interestForumBtn a').css("color", "#333");
		$('#interestQuestionBtn').css("background", "#fff");
		$('#interestQuestionBtn a').css("color", "#333");
		$('#interestLabelBtn').css("background", "#fff");
		$('#interestLabelBtn a').css("color", "#333");
	});

	$('#interestForumBtn').click(function() {

		$('#interestBlog').css("display", "none");
		$('#interestForum').css("display", "block");
		$('#interestQuestion').css("display", "none");
		$('#interestLabel').css("display", "none");

		$('#interestBlogBtn').css("background", "#fff");
		$('#interestBlogBtn a').css("color", "#333");
		$('#interestForumBtn').css("background", "#087ec4");
		$('#interestForumBtn a').css("color", "#fff");
		$('#interestQuestionBtn').css("background", "#fff");
		$('#interestQuestionBtn a').css("color", "#333");
		$('#interestLabelBtn').css("background", "#fff");
		$('#interestLabelBtn a').css("color", "#333");
	});
	$('#interestQuestionBtn').click(function() {

		$('#interestBlog').css("display", "none");
		$('#interestForum').css("display", "none");
		$('#interestQuestion').css("display", "block");
		$('#interestLabel').css("display", "none");

		$('#interestBlogBtn').css("background", "#fff");
		$('#interestBlogBtn a').css("color", "#333");
		$('#interestForumBtn').css("background", "#fff");
		$('#interestForumBtn a').css("color", "#333");
		$('#interestQuestionBtn').css("background", "#087ec4");
		$('#interestQuestionBtn a').css("color", "#fff");
		$('#interestLabelBtn').css("background", "#fff");
		$('#interestLabelBtn a').css("color", "#333");
	});
	$('#interestLabelBtn').click(function() {

		$('#interestBlog').css("display", "none");
		$('#interestForum').css("display", "none");
		$('#interestQuestion').css("display", "none");
		$('#interestLabel').css("display", "block");

		$('#interestBlogBtn').css("background", "#fff");
		$('#interestBlogBtn a').css("color", "#333");
		$('#interestForumBtn').css("background", "#fff");
		$('#interestForumBtn a').css("color", "#333");
		$('#interestQuestionBtn').css("background", "#fff");
		$('#interestQuestionBtn a').css("color", "#333");
		$('#interestLabelBtn').css("background", "#087ec4");
		$('#interestLabelBtn a').css("color", "#fff");
	});

	
	$("#cash_request").click(function(){
		
		$("#cash_request").css("display", "none");
		$("#cash_put").css("display", "block");
	});
	
	$("#cash_cancel").click(function(){
		
		$("#cash_request").css("display", "block");
		$("#cash_put").css("display", "none");
		$("#cash_size").val("");
	});
	
	
	
	
	
	
	
	
	
	
});