(function(win, doc){
    "use strict";

    // 设置分享的相关属性
    // className为分享按钮className
    // title分享按钮的title属性
    // img分享按钮图片
    // url分享链接计算方式，返回string为按钮的链接
    //
    // 局部变量：
    // title标题,url分享的链接，preview,分享预览图地址

    var shareLIst = [{
            className: 'qzone',
            title: '分享到QQ空间',
            img: 'images/qq.gif',
            url: function () {
                return 'http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?title=' +
                    title + '&url=' + url + '&pics=' + preview;
            }
        }, {
            className: 'sina',
            title: '分享到新浪微博',
            img: 'images/weibo.gif',
            url: function () {
                return 'http://v.t.sina.com.cn/share/share.php?url=' +
                    url + '&title=' + title + '&appkey=2924220432';
            }
        }, {
            className: 'douban',
            title: '分享到豆瓣',
            img: 'images/douban.gif',
            url: function () {
                var e = encodeURIComponent,
                    s1 = win.getSelection,
                    s2 = doc.getSelection,
                    s3 = doc.selection,
                    s = s1 ? s1() : s2 ? s2() : s3 ? s3.createRange().text: '';

                return 'http://www.douban.com/recommend/?url=' +
                    url + '&title=' + title + '&sel=' + e(s) + '&v=1';
            }
        }, {
            className: 'renren',
            title: '分享到人人',
            img: 'images/renren.gif',
            url: function () {
                return 'http://share.xiaonei.com/share/buttonshare.do?link=' +
                    url + '&amp;title=' + title;
            }
        }, {
            className: 'qqweibo',
            title: '分享到腾讯微博',
            img: 'images/qqwb.gif',
            url: function () {
                return 'http://v.t.qq.com/share/share.php?title=' +
                    title + '&url=' + url + '&pics=' + preview;
            }
        }],
        title = encodeURIComponent(doc.title), // 标题默认获取为当前页面的标题
        url = encodeURIComponent(window.location.href), // 默认获取当前页面的地址
        preview = '', // TODO:分享的默认图片地址
		config = {};
		
	//DOM加载完成时的回调
	function completed () {
		
		// 当readyState为complete的时候才执行
		if (!doc.addEventListener && document.readyState !== "complete") {
			return null;
		}

		//获取分享标签
		var shareElements = doc.getElementsByTagName('hcx-share'),
			configElements = doc.getElementsByTagName('hcx-share-config'),
			eleIndex,
			eleLength;
			
		//解析配置
		for (eleIndex = 0, eleLength = configElements.length;
				eleIndex < eleLength; eleIndex++) {
			config[configElements[eleIndex].getAttribute('name')] =  configElements[eleIndex].getAttribute('value');
		}	
			
		//解析每个分享标签
		for (eleIndex = 0, eleLength = shareElements.length;
				eleIndex < eleLength; eleIndex++) {
					
			parseShare(shareElements[eleIndex]);
		}
		return null;
	}

	//解析分享标签
	function parseShare (ele) {
		var i,
			l,
			imgPrefix = config['img-prefix'] || '';
		for (i = 0, l = shareLIst.length; i < l; i++) {
			var shareItem = shareLIst[i],
				anchor = doc.createElement('a'),
				img = doc.createElement('img');
				
			title = ele.getAttribute('title') || title;
			url = ele.getAttribute('url') || url;
			preview = ele.getAttribute('preview') || preview;

			anchor.title = shareItem.title;
			anchor.className = shareItem.className;
			anchor.href = shareItem.url();
			anchor.target = '_blank';
            anchor.style.marginLeft = '10px';
			img.src = imgPrefix + shareItem.img;
			anchor.appendChild(img);
			ele.appendChild(anchor);
		}
	}
	
	doc.createElement('hcx-share');
	doc.createElement('hcx-share-config');
	
    //dom加载完成之后开始解析标签
    if ( doc.addEventListener ) {
        doc.addEventListener( "DOMContentLoaded", completed, false );

    } else {
        doc.attachEvent( "onreadystatechange", completed );
    }

})(window, document);
