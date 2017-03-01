<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Upload</title>
</head>
<script type="text/javascript"
	src="<%=basePath%>js/jquery-1.10.2.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/jcrop/jquery.ajaxfileupload.js"></script>
<script src="<%=basePath%>js/jcrop/jquery.Jcrop.js"></script>
<script src="<%=basePath%>js/jcrop/jquery.color.js"></script>

<link rel="stylesheet" href="<%=basePath%>css/jcrop/jquery.Jcrop.css"
	type="text/css" />


</head>

<script>
function select_img() {
	var value = $("#fn").val();
	var ext = value.substring(value.lastIndexOf(".") + 1).toLowerCase();
	if (ext == null
			|| ext == ""
			|| (ext != "jpg" && ext != "gif" && ext != "bmp" && ext != "jpeg" && ext != "png")) {
		art.dialog({
			title : '提示',
			icon : 'error',
			content : '不支持的照片格式'
		}).lock().time(3);
		return;
	}
	$.ajaxFileUpload({
		url : '../../uploadTest.do',// 用于文件上传的服务器端请求地址
		secureuri : false,// 一般设置为false
		fileElementId : 'fn',// 文件上传空间的id属性
		dataType : 'text',// 返回值类型 一般设置为json
		success : function(data, status) // 服务器成功响应处理函数
		{
			// alert("success"+data)
			$("#target").attr("src", getRootPath() + data);

			var imageName = data.substring(19, data.length);

			$("#image_name").val(imageName);
			$(".btnl").css("display","block");
			return adjustwh();
			 
			

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

	image.src = $("#target").attr('src');


	image.onload = function() {

		// alert([ "图片大小是:", image.width, image.height ]);
		var true_width = this.width;
		var true_height = this.height;
		if (true_width > 400 || true_height > 249) {
			if ((true_width / true_height) > (16 / 9)) {
				$("#target").css({
					"width" : "400"
				});
				var zoom_rate = true_width / 400;
				$("#zoom_rate").val(zoom_rate);
			} else {
				$("#target").css({
					"height" : "249"
				});
				var zoom_rate = true_height / 249;
				$("#zoom_rate").val(zoom_rate);
			}
		}
		 alert([ "zoom_rate:", zoom_rate ]);
	}
	return do_Jcrop();
}

function do_Jcrop() {
	var api;
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
		api = this;
		api.setSelect([ 130, 65, 130 + 350, 65 + 285 ]);
		api.setOptions({
			bgFade : true
		});
		api.ui.selection.addClass('jcrop-selection');
	});

	$('#buttonbar').on('click','button',function(e) {
						var $t = $(this), $g = $t.closest('.btn-group');
						$g.find('button.active').removeClass('active');
						$t.addClass('active');
						$g.find('[data-setclass]').each(
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
	$('#width').val(c.w); // c.w 裁剪区域的宽
	$('#height').val(c.h); // c.h 裁剪区域的高
	jQuery('#x').val(c.x);
	jQuery('#y').val(c.y);
	jQuery('#x2').val(c.x2);
	jQuery('#y2').val(c.y2);
};</script>

<body>


			<form action="<%=basePath%>cut_face" method="post">
				<div>
					<p style="font-size: 15px">Set new  portrait</p>
					<p>1.Use real pic and cut out portions you really want.</p>
					<p>2.Supports JPG, GIF, PNG, BMP format picture.</p>
					<p>3.The biggest support 10 m images.</p>
				</div>
				<div class="picture">
					<input type="file" id="fn" name='file'
						style="opacity: 0; width: 70px; position: absolute; filter: alpha(opacity =   0);"
						onchange="select_img();" /> <a class="btnl"
						style="color: #000; cursor: pointer;">select</a>
				</div>
				<div class="background" id="back_ground">
					<img id='target'  />
				</div> 

				<input type="hidden" id="image_name" name="image_name" /> <input
					type="hidden" id="x" name="x" value="" />
				<!--四个值分别用来存储截取的四个位置-->
				<input type="hidden" id="y" name="y" value="" /> <input
					type="hidden" id="x2" name="x2" value="" /> <input type="hidden"
					id="y2" name="y2" value="" /> <input type="hidden" id="height"
					name="height" value="" /> <input type="hidden" id="width"
					name="width" value="" /> <input type="hidden" id="zoom_rate"
					name="zoom_rate" value="" />
				<div class="upload_button">
					<input type="submit"
						style="display: none; padding: 3px; cursor: pointer;" class="btnl"
						value="save" />
				</div>
			</form>
	<!--footer-->

	<div class="footer">
		<h3>Copyright © 2014 JIE & C DEV(HK)CO L.&nbsp;&nbsp;All Rights
			Reserved.</h3>
	</div>
	<!--footer end-->
</body>




</html>