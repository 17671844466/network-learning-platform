jQuery(document).ready(function($){
	//ajax来自于后台服务器的数据
	var data = {name:'首页1'};
	
	var headerHTML = template('header',data); //动态获取的
	$('#headerDIV').html(headerHTML);
	
	//ajax请求 rest 接口
	var courseUrl = "http://localhost:8080/ocRest/course/getCourses.html?callback=?";
	$.jsonp({
		"url":courseUrl,
		"success":function(data){
			//加载课程
			var courseHTML = template('courses',data); //动态获取的
			$('#coursesDIV').html(courseHTML);
		},
		"error":function(d,msg){
			alert(msg);
		}
	});
	
	//ajax请求 rest 接口
	var url = "http://localhost:8080/ocRest/getClassifyJson.html?callback=?";
//	$.ajax({});//不需要跨域
	$.jsonp({
		"url":url,
		"success":function(data){
			var allClassify = {'allClassify':data.data};
			var classifyHTML = template('classify',allClassify);
			$('#classifyDIV').html(classifyHTML);
			
			//课程分类展示 
			$(".category").popover({
	            trigger:'manual',
	            placement : 'right',
	            html: 'true',
	            content : '',
	            animation: false
	        }).on("mouseenter", function () {
	            var cid = $(this).attr('c-id');
	            $('#' + cid).show();
	            $('#' + cid).hover(function(){
	            	$('#' + cid).show();
	            },function(){
	            	$('#' + cid).hide();
				});
	        }).on("mouseleave", function () {
	            var cid = $(this).attr('c-id');
	            $('#' + cid).hide();
	        });
			
		},
		"error":function(d,msg){
			alert(msg);
		}
	});
});