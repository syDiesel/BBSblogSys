(function(win, doc){
    "use strict";

    // ���÷�����������
    // classNameΪ����ťclassName
    // title����ť��title����
    // img����ťͼƬ
    // url�������Ӽ��㷽ʽ������stringΪ��ť������
    //
    // �ֲ�������
    // title����,url��������ӣ�preview,����Ԥ��ͼ��ַ

    var shareLIst = [{
            className: 'qzone',
            title: '����QQ�ռ�',
            img: 'images/qq.gif',
            url: function () {
                return 'http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?title=' +
                    title + '&url=' + url + '&pics=' + preview;
            }
        }, {
            className: 'sina',
            title: '��������΢��',
            img: 'images/weibo.gif',
            url: function () {
                return 'http://v.t.sina.com.cn/share/share.php?url=' +
                    url + '&title=' + title + '&appkey=2924220432';
            }
        }, {
            className: 'douban',
            title: '��������',
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
            title: '��������',
            img: 'images/renren.gif',
            url: function () {
                return 'http://share.xiaonei.com/share/buttonshare.do?link=' +
                    url + '&amp;title=' + title;
            }
        }, {
            className: 'qqweibo',
            title: '������Ѷ΢��',
            img: 'images/qqwb.gif',
            url: function () {
                return 'http://v.t.qq.com/share/share.php?title=' +
                    title + '&url=' + url + '&pics=' + preview;
            }
        }],
        title = encodeURIComponent(doc.title), // ����Ĭ�ϻ�ȡΪ��ǰҳ��ı���
        url = encodeURIComponent(window.location.href), // Ĭ�ϻ�ȡ��ǰҳ��ĵ�ַ
        preview = '', // TODO:�����Ĭ��ͼƬ��ַ
		config = {};
		
	//DOM�������ʱ�Ļص�
	function completed () {
		
		// ��readyStateΪcomplete��ʱ���ִ��
		if (!doc.addEventListener && document.readyState !== "complete") {
			return null;
		}

		//��ȡ�����ǩ
		var shareElements = doc.getElementsByTagName('hcx-share'),
			configElements = doc.getElementsByTagName('hcx-share-config'),
			eleIndex,
			eleLength;
			
		//��������
		for (eleIndex = 0, eleLength = configElements.length;
				eleIndex < eleLength; eleIndex++) {
			config[configElements[eleIndex].getAttribute('name')] =  configElements[eleIndex].getAttribute('value');
		}	
			
		//����ÿ�������ǩ
		for (eleIndex = 0, eleLength = shareElements.length;
				eleIndex < eleLength; eleIndex++) {
					
			parseShare(shareElements[eleIndex]);
		}
		return null;
	}

	//���������ǩ
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
	
    //dom�������֮��ʼ������ǩ
    if ( doc.addEventListener ) {
        doc.addEventListener( "DOMContentLoaded", completed, false );

    } else {
        doc.attachEvent( "onreadystatechange", completed );
    }

})(window, document);
