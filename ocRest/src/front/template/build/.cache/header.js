/*TMODJS:{"version":2,"md5":"fecf879edea00532e2d89681b5716480"}*/
template('header',function($data,$filename
/**/) {
'use strict';var $utils=this,$helpers=$utils.$helpers,$escape=$utils.$escape,name=$data.name,$out='';$out+='<div class="f-header"> <div class="f-header-box clearfix"> <a href=".." class="logo" title="网校在线学习平台"></a> <nav class="header-nav"> <a href=".." class="header-nav-item">首 页</a> <a href="./course/list.html" class="header-nav-item">';
$out+=$escape(name);
$out+='</a> <a href="./user/home.html" class="header-nav-item">我的</a> <a href="./opt/index.html" style="width:100px;" target="_blank" class="header-nav-item">运营CMS</a> </nav> <nav class="header-nav" style="float:right"> <a href="#myModal" class="header-nav-item" data-toggle="modal" onclick="login();" style="margin-right:0px;font-size:14px;">登录</a> <a href="./auth/register.html" class="header-nav-item" style="margin-left:0px;font-size:14px;">注册</a> <a href="#" class="header-nav-item" style="margin-left:0px;font-size:14px;" id="userdetail">头像</a> </nav> </div> </div>';
return new String($out);
});