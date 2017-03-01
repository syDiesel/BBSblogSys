

function select_img() {
	var value = $("#fn").val();
	var ext = value.substring(value.lastIndexOf(".") + 1).toLowerCase();
	if (ext == null
			|| ext == ""
			|| (ext != "jpg" && ext != "gif" && ext != "bmp" && ext != "jpeg" && ext != "png")) {
		art.dialog({
			title : 'prompt',
			icon : 'error',
			content : 'No photo format support!'
		}).lock().time(3);
		return;
	}
	$.ajaxFileUpload({
		url : 'uploadTest.do',// 用于文件上传的服务器端请求地址
		secureuri : false,// 一般设置为false
		fileElementId : 'fn',// 文件上传空间的id属性
		dataType : 'text',// 返回值类型 一般设置为json
		success : function(data, status) // 服务器成功响应处理函数
		{
			// alert("success"+data)
			$("#target").attr("src", getRootPath() + data);
			$("#previewImgBig").attr("src", getRootPath() + data);
			$("#btnl").css("display","block");
			
			var imageName = data.substring(19, data.length);
			
			$("#image_name").val(imageName);

			adjustwh();
			do_Jcrop();

		},

		error : function(data, status, e)// 服务器响应失败处理函数
		{
			alert(e);
		}
	})
}

function getRootPath() {
	// 获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
	var curWwwPath = window.document.location.href;
	// 获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
	var pathName = window.document.location.pathname;
	var pos = curWwwPath.indexOf(pathName);
	// 获取主机地址，如： http://localhost:8083
	var localhostPaht = curWwwPath.substring(0, pos);
	// 获取带"/"的项目名，如：/uimcardprj
	var projectName = pathName
			.substring(0, pathName.substr(1).indexOf('/') + 1);
	return (localhostPaht + projectName) + "/";
}
function adjustwh() {
	var image = new Image();

	/*
	 * if (image.readyState=="complete") { var true_width = image.width; var
	 * true_height = image.height; }
	 */
	image.src = $("#target").attr('src');

	image.onload = function() {

		// alert([ "图片大小是:", image.width, image.height ]);
		var true_width = this.width;
		var true_height = this.height;
		if (true_width > 400 || true_height > 249) {
			if ((true_width / true_height) > (16 / 9)) {
				var zoom_rate = true_width / 400;
				$("#zoom_rate").val(zoom_rate);
			} else {
				var zoom_rate = true_height / 249;
				$("#zoom_rate").val(zoom_rate);
			}
		}
		// alert([ "zoom_rate:", zoom_rate ]);
	}

}


function do_Jcrop() {

    
	$('#target').Jcrop({
		// start off with jcrop-light class
		bgOpacity : 0.5,
		bgColor : 'white',
		aspectRatio : 1,
		addClass : 'jcrop-light',
		onChange : showCoords,
		onSelect : showCoords,
		boxWidth : 400,
		boxHeight : 249, 
	}, function() {
		// Use the API to get the real image size
		var bounds = this.getBounds();
		boundx = bounds[0];
		boundy = bounds[1];
		// Store the API in the jcrop_api variable
		api = this;
		api.setSelect([ 130, 65, 130 + 350, 65 + 285 ]);
		api.setOptions({
			bgFade : true
		});
		api.ui.selection.addClass('jcrop-selection');
		$preview.appendTo(api.ui.holder);
	});

	$('#buttonbar')
			.on('click','button',function(e) {
						var $t = $(this), $g = $t.closest('.btn-group');
						$g.find('button.active').removeClass('active');
						$t.addClass('active');
						$g
								.find('[data-setclass]')
								.each(
										function() {
											var $th = $(this), c = $th
													.data('setclass'), a = $th
													.hasClass('active');
											if (a) {
												api.ui.holder.addClass(c);
												switch (c) {

												case 'jcrop-light':
													api.setOptions({
														bgColor : 'white',
														bgOpacity : 0.5
													});
													break;

												case 'jcrop-dark':
													api.setOptions({
														bgColor : 'black',
														bgOpacity : 0.4
													});
													break;

												case 'jcrop-normal':
													api
															.setOptions({
																bgColor : $.Jcrop.defaults.bgColor,
																bgOpacity : $.Jcrop.defaults.bgOpacity
															});
													break;
												}
											} else
												api.ui.holder.removeClass(c);
										});
					});

}



function showCoords(c) {
/*	var api,
	boundx,
	boundy,

	// Grab some information about the preview pane
	$preview = $('#preview-pane'),
	$pcnt = $('#preview-pane .previewBoxBig'),
	$pimg = $('#previewImgBig'),

	xsize = $pcnt.width(),
	ysize = $pcnt.height();
	 if (parseInt(c.w) > 0)
     {
       var rx = xsize / c.w;
       var ry = ysize / c.h;

       $pimg.css({
         width: Math.round(rx * boundx) + 'px',
         height: Math.round(ry * boundy) + 'px',
         marginLeft: '-' + Math.round(rx * c.x) + 'px',
         marginTop: '-' + Math.round(ry * c.y) + 'px'
       });
     }*/

	$('#width').val(c.w); // c.w 裁剪区域的宽
	$('#height').val(c.h); // c.h 裁剪区域的高
	jQuery('#x').val(c.x);
	jQuery('#y').val(c.y);
	jQuery('#x2').val(c.x2);
	jQuery('#y2').val(c.y2);
};