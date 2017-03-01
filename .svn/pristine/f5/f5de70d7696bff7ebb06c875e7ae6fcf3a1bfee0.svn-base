function changeLocale(i) {
	var url = window.location.href;
	var loacle = i
	var locale = url.indexOf("locale=");

	if (locale == '-1' && (url.indexOf("?") == '-1')) {

		url = url + "?" + i;

	} 
	else if (locale == '-1' && url.indexOf("?") != '-1') {
		url = url + "&" + i
	} else {
		var weizhi = url.indexOf("locale=");

		url = url.replace(url.substr(weizhi, weizhi + 6), i);
	}

	window.location.href = url

}


function AddFavorite(sURL, sTitle) {
	 
    sURL = encodeURI(sURL); 
try{   

    window.external.addFavorite(sURL, sTitle);   

}catch(e) {   

    try{   

        window.sidebar.addPanel(sTitle, sURL, "");   

    }catch (e) {   

        alert("Fail to mark as favorite,please enter Ctrl+D or set by hand in the browser.");

    }   

}

}

//设为首页

function SetHome(url){

if (document.all) {

    document.body.style.behavior='url(#default#homepage)';

       document.body.setHomePage(url);

}else{

    alert("Your browser does not set the page as frontpage automatically, pls set by hand.");

}


}



$(document).ready(function() {

	$("#personPic").hover(function() {
		$("#personInfo").show();
	}, function() {
		$("#personInfo").hide();
	});

	$("#searchPic").hover(function() {
		$("#searchContent").show();
	}, function() {
		$("#searchContent").hide();
	});

});