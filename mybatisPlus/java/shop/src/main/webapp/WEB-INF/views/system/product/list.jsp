<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>ECSHOP 管理中心 - 商品列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/shop/resource/system/styles/general.css" rel="stylesheet"
	type="text/css" />
<link href="/shop/resource/system/styles/main.css" rel="stylesheet"
	type="text/css" />
<link href="/shop/resource/system/styles/product_list.css" rel="stylesheet"
	type="text/css" />
</head>
<body>
	<h1>
		<span class="action-span"><s:a href="product_input.action">添加新商品</s:a></span>
		<span class="action-span1"><s:a action="navigate_main.action">ECSHOP 管理中心</s:a></span>
		<span id="search_id" class="action-span1"> - 商品列表 </span>
		<div style="clear: both"></div>
	</h1>
	<!-- 高级查询 -->
	<div class="form-div">
		<s:form id="productSearchForm" method="post" action="product_list.action" enctype="multipart/form-data">
		<s:hidden id="currentPage" name="productQuery.pageQuery.currentPage"></s:hidden>
		<s:hidden id="showMoreQueryz_text" name="productQuery.showMoreQuery"/>
		<div>
			关键字
			<s:textfield id="seachKey" name="productQuery.seachKey" size="15" />
			<s:if test="productQuery.showMoreQuery==1" >
			<img id="showMoreQuery" src="/shop/resource/system/images/bag_close.gif"
                width="26" height="22" border="0" alt="search" onclick="showMoreQuery()"/>
            </s:if>
            <s:else>
			<img id="showMoreQuery" src="/shop/resource/system/images/bag_open.gif"
                width="26" height="22" border="0" alt="search" onclick="showMoreQuery()"/>
            </s:else>

			<img id="search" src="/shop/resource/system/images/icon_search.gif"
				width="26" height="22" border="0" alt="search" />
			<img id="clearQuery" src="/shop/resource/system/images/icon_trash.gif"
				width="26" height="22" border="0" alt="search" onclick="clearAllQuery()"/>
			</div>
			
			<s:if test="productQuery.showMoreQuery==1" ><div id="moreQuery" style="display:block;"></s:if>
			<s:else><div id="moreQuery" style="display:none;"></s:else>
				商品分类
            <s:select id ="productDirId" name="productQuery.productDirId" listKey="id"
                listValue="name" headerKey="-1" headerValue="-----请选择-----"
                list="%{#dirList}" />
            销售价
            <s:textfield id="salePriceStart" name="productQuery.salePriceStart" size="15" />
            -
            <s:textfield id='salePriceEnd' name="productQuery.salePriceEnd"  size="15" />
            推荐
            <s:select id="recommended" name="productQuery.recommended"
                 headerKey="-1" headerValue="-----请选择-----"  list="#{1:'推荐',0:'不推荐'}"/>
                 </div>
		</s:form>
	</div>

	<!-- 商品列表 -->
		<div class="list-div" id="listDiv">
			<table id="dataTable" cellpadding="3" cellspacing="1">
				<thead>
					<tr>
						<th>序号</th>
						<th>商品名称</th>
						<th>商品编号</th>
						<th>成本价</th>
						<th>销售价</th>
						<th>产地</th>
						<th>访问量</th>
						<th>推荐</th>
						<th>库存</th>
						<th>上架时间</th>
						<th>分类名称</th>
						<th>缩略图</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody id="dataBody">
					<s:iterator value="#productList" status="status">
						<tr>
							<td align="center"><s:property value="#status.count" /></td>
							<td align="center"><s:property value="name" /></td>
							<td align="center"><s:property value="sn" /></td>
							<td align="center"><s:property value="costPrice" /></td>
							<td align="center"><s:property value="salePrice" /></td>
							<td align="center"><s:property value="place" /></td>
							<td align="center"><s:property value="viewTimes" /></td>
							<td align="center"><s:if test="recommended==0">不推荐</s:if> <s:else>
									<font style="color: green">推荐</font>
								</s:else></td>
							<td align="center"><s:property value="num" /></td>
							<td align="center"><s:date name="inputTime"
									format="yyyy-MM-dd" /></td>
							<td align="center"><s:property value="productDir.name" /></td>
							<td align="center"><img src="<s:property value="smallPic"/>"
								alt="无" width="20" height="20"/></td>
							<td align="center"><a
								href="__APP__/Goods/?goods_id=<{$val.goods_id}>" target="_blank"
								title="查看"><img
									src="/shop/resource/system/images/icon_view.gif" width="16"
									height="16" border="0" /></a> <s:a
									action="product_update?product.id=%{id}" title="编辑">
									<img src="/shop/resource/system/images/icon_edit.gif"
										width="16" height="16" border="0" />
								</s:a> <s:a action="product_delete?product.id=%{id}" title="删除">
									<img src="/shop/resource/system/images/icon_trash.gif"
										width="16" height="16" border="0" />
								</s:a></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>
			<!-- 分页开始 -->
			<table id="page-table" cellspacing="0">
			<tr>
				<td width="80%"><div class="toHand" onclick="upPage(<s:property value="productQuery.pageQuery.firstPage"/>)">首页</div>
					<div class="toHand" onclick="upPage(<s:property value="productQuery.pageQuery.upPage"/>)">上一页 </div>
					<div class="toHand" >|</div>
					<div class="toHand" onclick="upPage(<s:property value="productQuery.pageQuery.downPage"/>)">下一页</div>
					<div class="toHand" onclick="upPage(<s:property value="productQuery.pageQuery.endPage"/>)">尾页</div>
				</td>
				<td align="center" nowrap="true">
					当前第<s:property value="productQuery.pageQuery.currentPage"/>页&nbsp;/&nbsp;
					共<s:property value="productQuery.pageQuery.totalPages"/>页
					&nbsp;一共有<s:property value="productQuery.pageQuery.totalCount"/>条数据
					<div id="demo3"></div>
				</td>
			</tr>
		</table>
			<!-- 分页结束 -->

	<div id="footer">
		共执行 7 个查询，用时 0.028849 秒，Gzip 已禁用，内存占用 3.219 MB<br /> 版权所有 &copy;
		2005-2012 上海商派网络科技有限公司，并保留所有权利。
	</div>

	<script type="text/javascript" src="/shop/resource/system/js/product_list.js"></script>
</body>
</html>