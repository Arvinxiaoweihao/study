<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!-- $Id: category_info.htm 16752 2009-10-20 09:59:38Z wangleisvn $ -->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>ECSHOP 管理中心 - 商品编辑</title>
<meta name="robots" content="noindex, nofollow">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link href="/shop/resource/system/styles/general.css" rel="stylesheet"
		type="text/css" />
	<link href="/shop/resource/layui/css/layui.css" rel="stylesheet"
		type="text/css" />
	<link href="/shop/resource/system/styles/main.css" rel="stylesheet"
		type="text/css" />
		<script type="text/javascript" src="/shop/resource/layui/js/layui.js" charset="utf-8"></script>
		<script type="text/javascript" src="/shop/resource/system/js/product_edit.js" charset="utf-8"></script>
</head>
<body>
	<h1>
		<span class="action-span"><s:a action="product.action"> 商品列表</s:a>
		</span> <span class="action-span1"><s:a action="navigate_main.action">ECSHOP 管理中心</s:a>
		</span> <span id="search_id" class="action-span1"> - <s:if
				test="product==null">添加</s:if> <s:else>修改</s:else>商品</span>
		<div style="clear:both"></div>
	</h1>
	<div class="main-div">
		<s:form enctype="multipart/form-data" action="product_save.action"
			method="post">
			<s:hidden name="product.id"></s:hidden>
			<table width="90%" id="general-table" align="center">
				<tr>
					<td class="label">商品名称：</td>
					<td><s:textfield name="product.name" size='30' /> <font
						color="red">*${fieldErrors.productname_error[0]} </font>
					</td>
				</tr>
				<tr>
					<td class="label">商品货号：</td>
					<td><s:textfield name="product.sn" size='30' /> <font
						color="red">* </font>
					</td>
				</tr>
				<tr>
					<td class="label">商品分类：</td>
					<td><s:select name="product.productDir.id"  listKey="id" listValue="name" 
					headerKey="-1" headerValue="-----请选择-----" list="%{#dirList}"/> <font color="red">* </font>
					</td>
				</tr>
				<tr>
                    <td class="label">成本价：</td>
                    <td><s:textfield name="product.costPrice" size='30' /> <font
                        color="red">* </font>
                    </td>
                </tr>
				<tr>
					<td class="label">本店售价：</td>
					<td><s:textfield name="product.salePrice" size='30' /> <font
						color="red">* </font>
					</td>
				</tr>
				<tr>
                    <td class="label">市场售价：</td>
                    <td><s:textfield name="product.marketPrice" size='30' /> <font
                        color="red">* </font>
                    </td>
                </tr>
				<tr>
					<td class="label">商品数量：</td>
					<td><s:textfield name="product.num" size='30' /> <font
						color="red">* </font>
					</td>
				</tr>
				<tr>
					<td class="label">加入推荐：</td>
					<td><s:if test="product==null">
							<s:radio name="product.recommended" list="#{'false':'不推荐','true':'推荐'}"
								value="false" />
						</s:if> <s:else>
							<s:radio name="product.recommended" list="#{'false':'不推荐','true':'推荐'}" />
						</s:else>
					</td>
				</tr>
				
				
				<tr>
					<td class="label">规格：</td>
					<td><s:textfield name="product.model" size='30' /> <font
						color="red">* </font>
					</td>
				</tr>
				<tr>
					<td class="label">产地：</td>
					<td><s:textfield name="product.place" size='30' /> <font
						color="red">* </font>
					</td>
				</tr>
				<tr>
					<td class="label">上架时间：</td>
					<td>
					    <s:date name="product.inputTime" var="inputRq" format="yyyy-MM-dd"/>
						<s:textfield name="product.inputTime" id="inputDate" size='30' value="%{inputRq}" />
						<font color="red">* </font>
					</td>
				</tr>
				<tr>
					<td class="label">商品简单描述：</td>
					<td><s:textarea name="product.intro" cols="40" rows="3" />
					<font color="red">* </font>
					</td>
				</tr>
				<tr>
					<td class="label">商品图片：</td>
					<td><s:file name="pic"></s:file>
					</td>
				</tr>
			</table>
			<div class="button-div">
				<input type="submit" value=" 确定 " class="button" /> <input
					type="reset" value=" 重置 " class="button" />
			</div>
		</s:form>
	</div>

	<div id="footer">
		共执行 3 个查询，用时 0.162348 秒，Gzip 已禁用，内存占用 2.266 MB<br /> 版权所有 &copy;
		2005-2012 上海商派网络科技有限公司，并保留所有权利。
	</div>

</body>
</html>