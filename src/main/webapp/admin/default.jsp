<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:if test="${erroCodeNum==1}"><script language=javascript>alert('验证码已过期！');history.go(-1);</script></c:if>
<c:if test="${erroCodeNum==2}"><script language=javascript>alert('验证码错误！');history.go(-1);</script></c:if>
<c:if test="${erroCodeNum==3}"><script language=javascript>alert('登录密码错误，请检查输入是否正确！');history.go(-1);</script></c:if>
<html>
<head>
<title>增值服务-管理登录</title>
</head>
<script language="javascript">
function checkdata() {
var Empty=false
if (Form.adminusername.value==""|| Form.password.value=="") {
alert("用户名、密码不能为空！");
Form.adminusername.focus();
Form.password.focus();
return (false);
}
return (true);
}
	  </script>
<body bgcolor="#EEEEEE" text="#000000" scroll="no">
<div align="center">
</body>
</html>
<br>
　<table width="575" border="0" cellspacing="0" cellpadding="0" align="center">
  <tr> 
    <td style="font-family: 宋体; font-size: 9pt">
	　<p>　</p>
	<p align="center"><font color="#FF0000">
	<span style="font-size: 30pt; font-weight: 700">增值服务管理后台</span></font></p>
	<p>　</td>
  </tr><BR>
  <tr valign="top"> 
            <form name="Form" method="POST" action="adminindex?status=1" onsubmit="return checkdata()">
    <td style="font-family: 宋体; font-size: 9pt"> 
      <table width="575" border="0" cellspacing="2" cellpadding="0" background="../images/2.gif" height="142">
        <tr>
          <td height="14" width="79" style="font-family: 宋体; font-size: 9pt">　</td>
          <td height="14" width="490" style="font-family: 宋体; font-size: 9pt">　</td>
        </tr>
        <tr>
          <td width="79" height="40" style="font-family: 宋体; font-size: 9pt">　</td>
          <td width="490" height="40" style="font-family: 宋体; font-size: 9pt"> 
            <table width="469" border="0" cellspacing="0" cellpadding="0" height="42">
              <tr>
        <td width="143" height="29" align="right" style="border-left: 1px solid #C9D8AD; font-family:宋体; font-size:9pt" valign="middle" bgcolor="#FFFFFF" bordercolor="#336699"> 
          <font size="2">用户名：</font></td>
        <td width="69%" height="29" style="border-right: 1px solid #C9D8AD; font-family:宋体; font-size:9pt" colspan="2" valign="middle" bgcolor="#FFFFFF" bordercolor="#336699"> 
            <font size="2"> 
            <input name="adminusername" size="20" style="float: left" value="admin"></font></td>
    			</tr>
				<tr>
        <td width="143" height="29" style="border-left: 1px solid #C9D8AD; font-family:宋体; font-size:9pt" align="right" bgcolor="#FFFFFF" bordercolor="#336699"> 
          <div align="right"><font size="2">密&nbsp; 码：</font></div>
        </td>
        <td width="69%" height="29" style="border-right: 1px solid #C9D8AD; font-family:宋体; font-size:9pt" colspan="2" bgcolor="#FFFFFF" bordercolor="#336699"> 
            <font size="2"> 
            <input type="password" name="password" size="20" style="float: left"></font></td>
  			</tr>
				<tr>
        <td width="143" height="29" style="border-left: 1px solid #C9D8AD; font-family:宋体; font-size:9pt" align="right" bgcolor="#FFFFFF" bordercolor="#336699"> 
<font size="2">验证码：</font></td>
        <td width="13%" height="29" style="border-right: 1px solid #C9D8AD; font-family:宋体; font-size:9pt" bgcolor="#FFFFFF" bordercolor="#336699"> 
<font size="2">
<input name="ValidCode" size="8" style="float: left"></font></td>
        <td width="50%" height="29" style="border-right: 1px solid #C9D8AD; font-family:宋体; font-size:9pt" bgcolor="#FFFFFF" bordercolor="#336699" bordercolorlight="#FFFFFF" bordercolordark="#FFFFFF"> 
<font size="2">
<img src="/VerifyCode.jsp" title="点击刷新" onclick="this.src='/VerifyCode.jsp?'+Math.random()" align="left"></font></td>
  			</tr>
				<tr>
        <td width="89%" height="28" colspan="3" align="center" style="border-left: 1px solid #C9D8AD; border-right: 1px solid #C9D8AD; border-bottom: 1px solid #C9D8AD; font-family:宋体; font-size:9pt" bgcolor="#FFFFFF" bordercolor="#336699">
          <div align="center">
            <input type="submit" name="Submit" value="进入系统管理中心" class="lkbtn">&nbsp;
                        
                      </div>
        </td>
  			</tr>
            </table>
          </td>
        </tr>
        </table>
    </td>
  </tr>
  <tr>
    <td style="font-family: 宋体; font-size: 9pt">
    　</td>
  </tr>
</table>
