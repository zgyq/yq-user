<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:if test="${erroCodeNum==1}"><script language=javascript>alert('<s:text name='vipybpay.jsp.ybpay.jsp.1801089794'/>！');history.go(-1);</script></c:if>
<c:if test="${erroCodeNum==2}"><script language=javascript>alert('<s:text name='vipybpay.jsp.ybpay.jsp.274591465'/>！');history.go(-1);</script></c:if>
<c:if test="${erroCodeNum==3}"><script language=javascript>alert('<s:text name='vipybpay.jsp.ybpay.jsp.-155027371'/>！');history.go(-1);</script></c:if>
<c:if test="${erroCodeNum==4}"><script language=javascript>alert('<s:text name='vipybpay.jsp.ybpay.jsp.-1103003435'/>！');history.go(-1);</script></c:if>
<c:if test="${erroCodeNum==5}"><script language=javascript>alert('<s:text name='vipybpay.jsp.ybpay.jsp.2037393748'/>！');history.go(-1);</script></c:if>
<c:if test="${erroCodeNum==6}"><script language=javascript>alert('<s:text name='vipybpay.jsp.ybpay.jsp.1747166923'/>！');history.go(-1);</script></c:if>
<c:if test="${erroCodeNum==7}"><script language=javascript>alert('<s:text name='vipybpay.jsp.ybpay.jsp.-495031333'/>！');history.go(-1);</script></c:if>
<c:if test="${erroCodeNum==8}"><script language=javascript>alert('<s:text name='vipybpay.jsp.ybpay.jsp.-1268974387'/>！');history.go(-1);</script></c:if>
<c:if test="${erroCodeNum==9}"><script language=javascript>alert('<s:text name='vipybpay.jsp.ybpay.jsp.267310126'/>！');history.go(-1);</script></c:if>
<c:if test="${erroCodeNum==10}"><script language=javascript>alert('<s:text name='vipybpay.jsp.ybpay.jsp.-1166221771'/>！');history.go(-1);</script></c:if>
<c:if test="${erroCodeNum==2000}"><script language=javascript>alert('<s:text name='vipybpay.jsp.ybpay.jsp.791872472'/>！');location.replace('${url}?act=payment&resultstr=${resultstr}&op=returnyibi&sn=${sn}&paycode=success&payamount=${gwpay}&pid=1&order_sn=${order}&&payuser=${user}');</script></c:if>
<c:if test="${erroCodeNum==2001}"><script language=javascript>alert('<s:text name='vipybpay.jsp.ybpay.jsp.640340070'/>！');location.replace('${url}?act=payment&op=returnyibi&sn=${sn}&paycode=success&payamount=${gwpay}&pid=2&order_sn=${order}&&payuser=${user}');</script></c:if>
<html>
<head>
<title></title>
<head>
<script type="text/javascript" src="images/jquery.min.js"></script>
<script type="text/ecmascript" src="images/md5.js"></script>
<script src="/scripts/sms.js"></script>
<script language="JavaScript"> 
function checkdate()  {
  if (Form.user.value=="") {     alert("<s:text name='vipybpay.jsp.ybpay.jsp.751820177'/>!");  Form.user.focus();      return false;    }
  if (Form.pa01.value=="") {      alert("<s:text name='vipybpay.jsp.ybpay.jsp.1841070946'/>!");  Form.pa01.focus();      return false;    }
  if (Form.pa02.value=="") {      alert("<s:text name='vipybpay.jsp.ybpay.jsp.1544222851'/>!");  Form.pa02.focus();      return false;    }
  	
    $("#btn").attr("disabled","disabled");
	var data = $("#Form").serialize();
	$.post("/sms2?op=7&toUserName="+Form.user.value, data, function(response) {
		$("#btn").removeAttr("disabled");
		if (response.erroCodeNum!=0) { alert("<s:text name='vipybpay.jsp.ybpay.jsp.1886666017'/>"); return false; }
		settime($("#btn"),'<s:text name="#SESSION_LOCALE"/>');
		alert("<s:text name='vipybpay.jsp.ybpay.jsp.1886721436'/>");
	});
	return false;
}  
function checkNumber()  { 
	if (Form.inputCall.value=="") {  alert("<s:text name='reg.jsp.reg.jsp.1688991270'/>！");  Form.inputCall.focus();  return false;  }
	var data = $("#Form").serialize();
	$.post("/checkUserParam?status=8&toUserName="+Form.user.value,data, function(response) {
		if(response.erroCodeNum==1){
			alert('<s:text name='dones.not.exist.username'/>！');
			Form.user.value;  return false;
		}
		if(response.erroCodeNum==2){
			alert('<s:text name='Enter_phone_number_error'/>！');
			Form.inputCall.focus();  return false;
		}
	});

}
function checkdate1()  {  
  if (Form.hgcode.value=="") {   alert("<s:text name='vipybpay.jsp.ybpay.jsp.-352812950'/>");  Form.mcygcode.focus();   return false;    }
  return true;
} 
</script>
<meta http-equiv="Content-Language" content="zh-cn">
</head>
<body topmargin="0" bgcolor="#FFEBC1">
<form method="POST" action="ybpay?ybf=actok&url=${url}" id="Form" name="Form">
	<input type="hidden" name="targetdate" size="8">
	<input type="hidden" name="xmlmode" size="8">
	<div align="center">
	　<p><font size="6" color="#FF0000">${title}</font></p>
	<table border="0" id="table1" height="308" width="560">
		<tr>
			<td width="214" align="right"><s:text name='vipybpay.jsp.ybpay.jsp.35034724'/>：</td>
			<td width="336" align="left" colspan="2"><font color="#008000">${order}<input type="hidden" name="order" size="20" value="${order}"></font></td>
			</tr>
		<tr>
			<td width="214" align="right"><s:text name='vipybpay.jsp.ybpay.jsp.1086606367'/>：</td>
			<td width="336" align="left" colspan="2"><input type="hidden" name="ybstr" size="20" value="${ybstr}" readonly>
			<input type="hidden" name="gwpay" size="20" value="${gwpay}" readonly>${gwpay}<input type="hidden" name="sid" size="20" value="${sid}" readonly><input type="hidden" name="pid" size="20" value="${pid}" readonly></td>
		</tr>
		<tr>
			<td width="214" align="right"><s:text name='vipybpay.jsp.ybpay.jsp.26044037'/>(2%)：</td>
			<td width="336" align="left" colspan="2">${fee}</td>
		</tr>
		<tr>
			<td width="214" align="right"><s:text name='vipybpay.jsp.ybpay.jsp.702617'/>：</td>
			<td width="336" align="left" colspan="2"><b><font color="#FF0000">${ybsl}<input type="hidden" name="ybpay" size="20" value="${ybsl}"></font></b></td>
		</tr>
		<c:if test="${pid==1}">
		<tr>
			<td width="214" align="right"><s:text name='vipybpay.jsp.ybpay.jsp.1531315753'/>(2%)：</td>
			<td width="336" align="left" colspan="2">${feeScores}</td>
		</tr>
		<tr>
			<td width="214" align="right"><s:text name='vipybpay.jsp.ybpay.jsp.-507512925'/>：</td>
			<td width="336" align="left" colspan="2"><b><font color="#FF0000">${allScores}<input type="hidden" name="sign" size="20" value="${sign}"></font></b></td>
		</tr>
		</c:if>
		<tr>
			<td width="214" align="right"><s:text name='vipybpay.jsp.ybpay.jsp.29623262'/>：</td>
			<td width="336" align="left" colspan="2"><b><font color="#0000FF"><input type="text" name="user" size="20" onKeyUp="value=value.replace(/[\W]/g,'')"><input type="hidden" name="remark" size="5" value="8" readonly></font></b></td>
			</tr>
		<tr>
			<td width="214" align="right"><s:text name='vipybpay.jsp.ybpay.jsp.927803061'/>：</td>
			<td width="336" align="left" colspan="2"><input type="password" name="pa01" size="20"></td>
		</tr>
		<tr>
			<td width="214" align="right"><s:text name='vipybpay.jsp.ybpay.jsp.630954966'/>：</td>
			<td width="336" align="left" colspan="2"><span style="font-size: 9pt"><font size="1"><input type="password" name="pa02" size="20" maxlength="20"></font></span></td>
		</tr>
		<tr>
			<td width="260" align="right"><s:text name='enter.phone.number'/>：</td>
			<td width="336" align="left" colspan="2" ><input type="text" id="inputCall" name="inputCall" size="20" tabindex="18" onblur="checkNumber()"></input></td>
		</tr> 
		<tr>
			<td width="214" align="right" height="30"><s:text name='vipybpay.jsp.ybpay.jsp.-1704827075'/>：</td>
			<td width="81" align="right" height="30"><input type="text" name="hgcode" size="10"></td>
			<td width="252" align="right" height="30"><p align="left"><input id="btn" type="button" onclick="checkdate()" value="<s:text name='vipybpay.jsp.ybpay.jsp.1753968781'/>" name="B2"></td>
		</tr>
		<tr>
			<td width="214" align="right" height="46"><p align="center"></td>
			<td width="336" align="right" height="46" colspan="2"><p align="left"><span style="font-size: 9pt"><font size="1"><input type="submit" value="<s:text name='vipybpay.jsp.ybpay.jsp.-1071255236'/>" name="B1" onClick="{if(confirm('<s:text name='vipybpay.jsp.ybpay.jsp.-1071255236'/>?')){this.style.visibility='hidden';return true;}return false;}" style="font-family: 楷体_GB2312; font-size: 14pt; font-weight: bold; "></font></span></td>
		</tr>
		</table>
	<p><s:text name='vipybpay.jsp.ybpay.jsp.-1255245828'/>！</p>
	<p><s:text name='vipybpay.jsp.ybpay.jsp.-2122652385'/>！</p>
	</div>
</form>
<script type="text/javascript">
btnStatus($("#btn"),'<s:text name="#SESSION_LOCALE"/>');
</script>
