<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>ECSHOP 管理中心 - 用户列表 </title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/shop/resource/system/styles/general.css" rel="stylesheet" type="text/css" />
<link href="/shop/resource/system/styles/main.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h1>
    <span class="action-span"><s:a action="user_input">添加新用户</s:a></span>
    <span class="action-span1"><s:a action="navigate_main.action">ECSHOP 管理中心</s:a></span>
    <span id="search_id" class="action-span1"> - 用户列表 </span>
    <div style="clear:both"></div>
</h1>
<div class="form-div">
    <form action="" name="searchForm">
        <img src="/shop/resource/system/images/icon_search.gif" width="26" height="22" border="0" alt="search" />
        <!-- 关键字 -->
        用户名 <input type="text" name="keyword" size="15" />
        <input type="submit" value=" 搜索 " class="button" />
    </form>
</div>

<!-- 商品列表 -->
<form method="post" action="" name="listForm" onsubmit="">
    <div class="list-div" id="listDiv">
        <table cellpadding="3" cellspacing="1">
            <tr>
                <th>编号</th>
                <th>用户名</th>
                <th>昵称</th>
                <th>电话</th>
                <th>上次登录时间</th>
                <th>上次登录ip</th>
                <th>注册日期</th>
                <th>状态</th>
                <th>操作</th>
            </tr>
            <s:iterator value="#userList" status="status">
            <tr>
                <td align="center"><s:property value="#status.count"/> </td>
                <td align="center"><s:property value="username"/> </td>
                <td align="center"><s:property value="nickname"/> </td>
                <td align="center"><s:property value="tel"/> </td>
                <td align="center"><s:date name="lastLoginTime" format="yyyy-MM-dd HH:mm:ss" /> </td>
                <td align="center"><s:property value="lastLoginIp"/> </td>
                <td align="center"><s:date name="registerRq" format="yyyy-MM-dd" /> </td>
                <td align="center">
                <s:if test="status==0"><font style="color:green">启用</font></s:if>
                <s:else><font style="color:red">禁用</font></s:else>
                </td>
                <td align="center">
                <a href="__APP__/Goods/?goods_id=<{$val.goods_id}>" target="_blank" title="查看"><img src="/shop/resource/system/images/icon_view.gif" width="16" height="16" border="0" /></a>
                <s:a action="user_update?user.id=%{id}" title="编辑"><img src="/shop/resource/system/images/icon_edit.gif" width="16" height="16" border="0" /></s:a>
                <s:a action="user_delete?user.id=%{id}" title="删除"><img src="/shop/resource/system/images/icon_trash.gif" width="16" height="16" border="0" /></s:a></td>
            </tr>
            </s:iterator>
        </table>

    <!-- 分页开始 -->
        <table id="page-table" cellspacing="0">
            <tr>
                <td width="80%">&nbsp;</td>
                <td align="center" nowrap="true">
                    <{$showPage}>
                </td>
            </tr>
        </table>
    <!-- 分页结束 -->
    </div>
</form>

<div id="footer">
共执行 7 个查询，用时 0.028849 秒，Gzip 已禁用，内存占用 3.219 MB<br />
版权所有 &copy; 2005-2012 上海商派网络科技有限公司，并保留所有权利。</div>
</body>
</html>