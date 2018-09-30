/*TMODJS:{"version":34,"md5":"fc44af57b0b7966681cad54cdc233aa5"}*/
template('courses',function($data,$filename
/**/) {
'use strict';var $utils=this,$helpers=$utils.$helpers,$each=$utils.$each,data=$data.data,item=$data.item,index=$data.index,$escape=$utils.$escape,$out='';$out+='<div class="types-block clearfix"> <h3 class="types-title">实战推荐</h3> <div class="types-content"> ';
$each(data.actionCourses,function(item,index){
$out+=' <a href=""> <div class="course-card-container" ';
if((index ==4 )){
$out+=' style="margin-right:0px;"';
}
$out+='> <div class="course-card-top green-bg"> <span>';
$out+=$escape(item.classifyName);
$out+=' ';
$out+=$escape(index);
$out+='</span> </div> <div class="course-card-content"> <h3 class="course-card-name">';
$out+=$escape(item.name);
$out+='</h3> <p title="';
$out+=$escape(item.brief);
$out+='">';
$out+=$escape(item.brief);
$out+='</p> <div class="course-card-bottom"> <div class="course-card-info">178人在学</div> <div class="course-card-price">￥179.00</div> </div> </div> </div> </a> ';
});
$out+=' </div> </div>   <div class="types-block clearfix"> <h3 class="types-title">免费好课</h3> <div class="types-content"> ';
$each(data.freeCourses,function(item,index){
$out+=' <a href=""> <div class="course-card-container" ';
if((index ==4 )){
$out+=' style="margin-right:0px;"';
}
$out+='> <div class="course-card-top green-bg"> <span>';
$out+=$escape(item.classifyName);
$out+='</span> </div> <div class="course-card-content"> <h3 class="course-card-name">';
$out+=$escape(item.name);
$out+='</h3> <p title="';
$out+=$escape(item.brief);
$out+='">';
$out+=$escape(item.brief);
$out+='</p> <div class="course-card-bottom"> <div class="course-card-info">初级<span>·</span>178人在学</div> </div> </div> </div> </a> ';
});
$out+=' </div> </div> ';
return new String($out);
});