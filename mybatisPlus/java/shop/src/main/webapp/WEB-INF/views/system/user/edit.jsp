<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!-- $Id: category_info.htm 16752 2009-10-20 09:59:38Z wangleisvn $ -->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>ECSHOP 管理中心 - 添加用户 </title>
<meta name="robots" content="noindex, nofollow">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/shop/resource/system/styles/general.css" rel="stylesheet" type="text/css" />
<link href="/shop/resource/system/styles/main.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h1>
    <span class="action-span"><s:a action="user.action"> 用户列表</s:a></span>
    <span class="action-span1"><s:a action="navigate_main.action">ECSHOP 管理中心</s:a></span>
    <span id="search_id" class="action-span1"> - 
    <s:if test="user==null">添加</s:if><s:else>修改</s:else>用户 </span>
    <div style="clear:both"></div>
</h1>
<div class="main-div">
    <s:form action="user_save" method="post" >
    <s:hidden name="user.id"></s:hidden>
        <table width="100%" id="general-table">
            <tr>
                <td class="label" for="username">用户名:</td>
                <td><s:textfield id="username" name="user.username" size='30'/>
                <font color="red">* <s:property value="fieldErrors.username_error[0]"/></font></td>
            </tr>
            <tr>
                <td class="label">昵称:</td>
                <td><s:textfield name="user.nickname" size='30'/>
                <font color="red">* <s:property value="fieldErrors.nickname_error[0]"/></font></td>
            </tr>
            <tr>
                <td class="label">电话号码:</td>
                <td><s:textfield name="user.tel" size='30'/>
                <font color="red">* <s:property value="fieldErrors.tel_error[0]"/></font></td>
            </tr>
            <tr>
                <td class="label">邮箱地址:</td>
                <td><s:textfield name="user.email" size='30'/>
                <font color="red">* <s:property value="fieldErrors.email_error[0]"/></font></td>
            </tr>
            <tr>
                <td class="label">家庭地址:</td>
                <td><s:textarea name="user.address" cols="50" rows="2"/></td>
            </tr>
            <tr>
            <td class="label">状态:</td>
            <td>
            <s:if test="user==null">
            <s:radio name="user.status" list="#{'0':'启用','-1':'禁用'}" value="0"/>
            </s:if>
            <s:else>
            <s:radio name="user.status" list="#{'0':'启用','-1':'禁用'}"/>
            </s:else>
            </td>
            </tr>
        </table>
        <div class="button-div">
            <input type="submit" value=" 确定 " />
            <input type="reset" value=" 重置 " />
        </div>
    </s:form>
</div>

<div id="footer">
共执行 3 个查询，用时 0.162348 秒，Gzip 已禁用，内存占用 2.266 MB<br />
版权所有 &copy; 2005-2012 上海商派网络科技有限公司，并保留所有权利。</div>

</body>
</html>