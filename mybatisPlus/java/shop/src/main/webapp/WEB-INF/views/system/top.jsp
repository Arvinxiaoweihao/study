<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/shop/resource/layui/css/layui.css" rel="stylesheet" type="text/css" media="all"/>
<script type="text/javascript" src="/shop/resource/layui/js/layui.js" charset="utf-8"></script>
</head>
<body>

<a>
<ul class="layui-nav" style="background:#278296;">
  <li class="layui-nav-item layui-this">
    <a href="/shop/system/navigate_main.action" target="main-frame">管理中心</a>
  </li>
  <li class="layui-nav-item">
    <a href="/shop/system/user.action" target="main-frame">用户列表</a>
  </li>
  <li class="layui-nav-item">
    <a href="/shop/system/product.action" target="main-frame">商品列表</a>
  </li>
  <li class="layui-nav-item">
    <a href="/shop/system/product.action" target="main-frame">解决方案</a>
    <dl class="layui-nav-child">
      <dd><a href="">移动模块</a></dd>
      <dd><a href="">后台模版</a></dd>
      <dd class="layui-this"><a href="">选中项</a></dd>
      <dd><a href="">电商平台</a></dd>
    </dl>
  </li>
  <li style="float:right;margin-top:20px;margin-left:10px;">
    <a href="javascript:window.parent.location.href='/shop/system/logout_logout.action';"><font color="white" >退出</font></a>
  </li>
  <li style="float:right;margin-top:20px;margin-left:10px;">
    欢迎你：${USER_IN_SESSION.username}
  </li>
  <li style="float:right;margin-top:15px;"><img src="/shop/resource/system/images/head.jpg" class="layui-nav-img"></li>
</ul>
</div>

<script>
layui.use('element', function(){
  var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
  
  //监听导航点击
  element.on('nav(demo)', function(elem){
    //console.log(elem)
    layer.msg(elem.text());
  });
});

</script>
</body>
</html>