<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>ECSHOP 管理中心</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/shop/resource/system/styles/general.css" rel="stylesheet" type="text/css" />
<link href="/shop/resource/system/styles/main.css" rel="stylesheet" type="text/css" />
</head>
<body style="background: #278296;color:white">
<s:form method="post" action="logout_login">
    <table cellspacing="0" cellpadding="0" style="margin-top:100px" align="center">
        <tr>
            <td>
                <img src="/shop/resource/system/images/login.png" width="178" height="256" border="0" alt="ECSHOP" />
            </td>
            <td style="padding-left: 50px">
                <table>
                    <tr>
                        <td>管理员姓名：</td>
                        <td>
                             <s:textfield name="user.username" size='25' />
                             <font color="red">* <s:property value="fieldErrors.username_error[0]"/></font>
                        </td>
                    </tr>
                    <tr>
                        <td>管理员密码：</td>
                        <td>
                            <s:textfield name="user.password" size='25' />
                            <font color="red">* <s:property value="fieldErrors.password_error[0]"/></font>
                        </td>
                    </tr>
                    <tr>
                        <td>验证码：</td>
                        <td>
                            <s:textfield name="code" size='25' />
                            <font color="red">* <s:property value="fieldErrors.code_error[0]"/></font>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="right">
                            <img id="img" src="logout_verifyCode.action" />
                            <a href='#' onclick="changeImg()" style="color:white;">
                                <label style="color:white;cursor: pointer">看不清？</label></a>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="checkbox" value="1" name="remember" id="remember" />
                            <label for="remember">请保存我这次的登录信息。</label>
                        </td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td>
                            <s:submit value="进入管理中心"></s:submit>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
<!--   <input type="hidden" name="act" value="signin" /> -->
</s:form>


</body>
<script type="text/javascript">
    function changeImg(){
        var img = document.getElementById("img");
        img.src="logout_verifyCode.action?date="+new Date();
    }
</script>
</html>