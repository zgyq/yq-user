<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!--#include file="../mq0618.asp"-->
<html>
<title>-一币-开奖记录</title>
</head>
<body topmargin="0">
<div align="center"><b><table border="0" cellspacing="1" width="100%" cellpadding="0" height="75">
  <tr> 
 <td width="87%" style="border-left: 1px solid #E5EAC2; border-right: 1px solid #E5EAC2; border-bottom: 1px solid #E5EAC2" height="73" bgcolor="#808000"><p align="center" style="line-height: 150%; margin-top: 0; margin-bottom: 0">
    <font face="宋体"><b><font color="#FF0000">一币-</font>开奖记录</b><font size="2"></font></font></p>
	<div align="center">    
     <table border="0" cellspacing="0" width="100%" cellpadding="0" height="50" bgcolor="#000000">
         <tr>        
     <td width="400" align="center" height="28" bgcolor="#000000" bordercolor="#000000"><b><font size="2" color="#FF0000" face="宋体">期号</font></b></td>                
     <td width="400" align="center" height="28" bgcolor="#000000" bordercolor="#000000"><p style="line-height: 150%; margin-top: 0; margin-bottom: 0"><font face="宋体" color="#FF0000" size="2"><strong>单双</strong></font></td>                
     <td width="400" align="center" height="28" bgcolor="#000000" bordercolor="#000000"><p style="line-height: 150%; margin-top: 0; margin-bottom: 0"><font color="#FF0000" face="宋体" size="2"> <strong>大小</strong></font></td>
         </tr>
      <s:iterator var="data" value="dataList">
         <tr> 
      <td height="24" width="425" align="center"><b><font size="2" face="宋体" color="#FFFFFF">${data.kid}</font></b></td>
      <td height="24" width="412" align="center"><p style="line-height: 150%; margin-top: 0; margin-bottom: 0"><font color="#FFFFFF" face="宋体" size="2" style="font-weight: 700">
      <c:if test="${data.dskj==1}">单</c:if><c:if test="${data.dskj==2}">双</c:if></font></td>
      <td valign="middle" width="394" align="center"><p style="line-height: 150%; margin-top: 0; margin-bottom: 0"><b><font color="#FFFFFF" face="宋体" size="2">
      <c:if test="${data.kdxj==3}">大</c:if><c:if test="${data.dskj==4}">小</c:if></font></b></td>
      </tr>
       </s:iterator>
       </table> 
</div><font size="2" face="宋体"><aldtags:pageTag/>
</font>
</tr> 
</table> 
</div> 
</html>