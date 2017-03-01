$(document).ready(function(){				   
	$('ul .labelIndex').hide();
	/*$('ul #selectIndex').hide();*/
	
	//隐藏和显示菜单
	$('.BoardIndex #one').hover(function(){
		$(this).addClass('boardBg1').removeClass('boardBg');
		var openMenu= $(this).children('ul .labelIndex');
		/*var selectImg=$(this).children('ul #selectIndex');
		var noSelectImg=$(this).children('ul #selectIndex');
		alert("menu"+openMenu+"  sI"+selectImg+"  no"+noSelectImg)*/
		$(openMenu).show();		
		/*$(selectImg).show();
		$(noSelectImg).hide();*/
		
	},function(){
		$(this).addClass('boardBg').removeClass('boardBg1');
		var openMenu= $(this).children('ul .labelIndex');
		/*var selectImg=$(this).children('ul #selectIndex');
		var noSelectImg=$(this).children('ul #selectIndex');*/
		$(openMenu).hide();
		/*$(noSelectImg).show();
		$(selectImg).hide();*/
	});

	
});


function over(i){
	document.getElementById('selectIndex'+i).style.display="block";
	document.getElementById('noSelectIndex'+i).style.display="none";
	document.getElementById('go'+i).style.display="block";
	
}

function out(i){
	document.getElementById('selectIndex'+i).style.display="none";
	document.getElementById('noSelectIndex'+i).style.display="block";
	document.getElementById('go'+i).style.display="none";
	
}



