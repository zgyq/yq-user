<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<head>
<meta http-equiv="Content-Language" content="zh-cn">
</head>
<div align="center">
	<table border="0" width="30%" id="table1">
		<tr>
			<td>
			<p align="center">${bcid}修改成功</p>
			<p align="center">原来积分为：<font color="#800000">${gcuser.jyg-bcjf}</font>&nbsp; 修改后为：<b><font color="#FF0000">${gcuser.jyg}</font></b></p>
			</td>
		</tr>
	</table>
	<p align="center"><b><a href="bcjf?bcid=${bcid}" style="text-decoration: none">返回</a></b></div>