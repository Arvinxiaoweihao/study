<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>ECSHOP Menu</title>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/shop/resource/layui/css/layui.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="/shop/resource/layui/js/layui.js"
	charset="utf-8"></script>

<style type="text/css">
body {
	background: #80BDCB;
}

#tabbar-div {
	background: #278296;
	padding-left: 10px;
	height: 21px;
	padding-top: 0px;
}

.tab-front {
	background: #80BDCB;
	line-height: 20px;
	font-weight: bold;
	padding: 4px 15px 4px 18px;
	border-right: 2px solid #335b64;
	cursor: hand;
	cursor: pointer;
}

.tab-back {
	color: #F4FAFB;
	line-height: 20px;
	padding: 4px 15px 4px 18px;
	cursor: hand;
	cursor: pointer;
}


#main-div {
	border: 1px solid #345C65;
	padding: 5px;
	margin: 5px;
	background: #FFF;
}

</style>

</head>
<body>
	<div id="tabbar-div">
		<p>

			<span class="tab-front" id="menu-tab">菜单</span>
		</p>
	</div>
	<div id="main-div">
		<div
			style="display: inline-block; width: 135px; padding: 10px; overflow:auto;">
			<ul id="demo1"></ul>
		</div>
	</div>
	<script>
		//Demo
		layui.use([ 'tree', 'layer' ], function() {
			var layer = layui.layer, $ = layui.jquery;

			layui.tree({
				elem : '#demo1',
				target : 'main-frame', 
				nodes : [ //节点
				{
					name : '管理中心',
					id : 1,
					spread : true,
					href : '/shop/system/navigate_main.action',
					children : [ {
						name : '用户列表',
						id : 11,
						href : '/shop/system/user.action'
					}, {
						name : '商品列表',
						id : 12,
						href : '/shop/system/product.action'
					}, {
						name : '商品分类',
						id : 13,
						href : '/shop/system/productDir.action'
					} ]
				} ]
			});

		});
	</script>

</body>
</html>