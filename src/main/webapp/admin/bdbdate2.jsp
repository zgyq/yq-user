<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<html>
<title>报单币变化明细</title>
<script type="text/javascript" src="/scripts/jquery.js"></script>
<link rel="stylesheet" type="text/css" href="/scripts/jquery.datetimepicker.css"/>
<script src="/scripts/jquery.datetimepicker.js"></script>
<DIV class=box>
<DIV class=box_con style=" text-align:left">
 <script type="text/javascript">
 function exportExcel(){
	 var url="outexcel?zuser="+Form.zuser.value+"&startDate1="+Form.startDate1.value+"&endDate1="+Form.endDate1.value;
	 window.open(url,'new','toolbar=no,scrollbars=yes,width=800,height=850');
 }
 </script>

  <table border="0" cellspacing="0" width="100%" cellpadding="0" height="108">
    <tr>
      <td width="100%" height="25"> 
        <p align="center">
		<font color="#000000" face="宋体"><strong>（${zuser}）报 单 币 变 化 明 细</strong></font></td> 
  </tr> 
       <tr>
      <td width="100%" height="25"> 
      <form method="post" action="bdbdate2" name="Form" id="Form">
        <p align="center">用户：<input name="zuser" id="zuser" type="text" value="${zuser}"/>
		 	开始日期:<input name="startDate1" id="startDate1" type="text" value="${startDate1}"/>结束日期:<input name="endDate1" id="endDate1" type="text" value="${endDate1}"/>
	<input type="submit" value="查询"/><input type="button" onClick="exportExcel()" value="导出excel"/></p></form></td> 
  </tr> 

  <tr> 
    <td width="100%" style="border-left: 1px solid #E5EAC2; border-right: 1px solid #E5EAC2; border-bottom: 1px solid #E5EAC2" height="84" bgcolor="#E5EAC2">
	<font face="宋体" size="2"><br> 
</font><div align="center">    
          <table border="1" cellspacing="0" width="100%" bordercolor="#FFFFFF" style="border-collapse: collapse" cellpadding="0" height="57">
            <tr> 
              <td width="120" align="center" height="27" bgcolor="#FFE1FF"><font face="宋体" color="#000000" size="2"><strong style="font-weight: 400">会员名</strong></font></td>
              <td width="97" align="center" height="27" bgcolor="#FFE1FF"><font color="#FF0000" face="宋体" size="2"> <strong style="font-weight: 400">报单币收入</strong></font></td>
              <td width="99" align="center" height="27" bgcolor="#FFE1FF"><font face="宋体" color="#000000" size="2">报单币支出</font></td>
              <td width="95" align="center" height="27" bgcolor="#FFE1FF"><font color="#000000" face="宋体" size="2">剩余报单币</font></td>
              <td width="95" align="center" height="27" bgcolor="#FFE1FF"><font color="#000000" face="宋体" size="2">左总计</font></td>
              <td width="95" align="center" height="27" bgcolor="#FFE1FF"><font color="#000000" face="宋体" size="2">右总计</font></td>
              <td width="95" align="center" height="27" bgcolor="#FFE1FF"><font color="#000000" face="宋体" size="2">左结余</font></td>
              <td width="95" align="center" height="27" bgcolor="#FFE1FF"><font color="#000000" face="宋体" size="2">右结余</font></td>
              <td width="150" align="center" height="27" bgcolor="#FFE1FF"><font color="#000000" face="宋体" size="2">更新时间</font></td>
              <td width="404" align="center" height="27" bgcolor="#FFE1FF"><font color="#000000" face="宋体" size="2">备注</font></td>
              </tr>
              <s:iterator var="data" value="dataList">
              <tr> 
              <td height="31" width="120" align="center"><font color="#000000" face="宋体" size="2">${data.zuser}</font></td>
              <td valign="middle" align="center"><font color="#FF0000" face="宋体" size="2">${data.sy}</font></td>
              <td valign="middle" align="center" width="99"><font face="宋体" size="2">
              <c:if test="${data.jc>0}">-${data.jc }</c:if><c:if test="${data.jc<=0}">${data.jc }</c:if></font></td>
              <td valign="middle" align="center" width="95"><font color="#000000" face="宋体" size="2">${data.sybdb}</font></td>
              <td valign="middle" align="center" width="95"><font color="#000000" face="宋体" size="2">${data.zaq}</font></td>
              <td valign="middle" align="center" width="95"><font color="#000000" face="宋体" size="2">${data.zbq}</font></td>
              <td valign="middle" align="center" width="95"><font color="#000000" face="宋体" size="2">${data.aq}</font></td>
              <td valign="middle" align="center" width="95"><font color="#000000" face="宋体" size="2">${data.bq}</font></td>
              <td valign="middle" align="center" width="150"><font color="#000000" face="宋体" size="2">${data.bfdate}</font></td>
              <td valign="middle" align="center" width="404"><font color="#000000" face="宋体" size="2">${data.bz}</font></td>
              </tr>
             </s:iterator>
            </table> 
</div><font face="宋体" size="2"><aldtags:pageTag paraStr="zuser,${zuser},startDate1,${startDate1},endDate1,${endDate1}"/>
</font> 
</tr> 
</table> 
</div> </div>
<p align="center">
<a href="javascript:history.back();" style="text-decoration: none"><font color="#FF6600" style="font-size: 12pt; font-weight: 700">返回上一页</font></a></p>
</body> 
</html>
 <script type="text/javascript">
		$('#startDate1').datetimepicker({
			yearOffset : 0,
			lang : 'ch',
			timepicker : false,
			format : 'Y-m-d',
			formatDate : 'Y-m-d',
		//		minDate:'1970/01/01', // yesterday is minimum date
		//		maxDate:'+1970/01/02' // and tommorow is maximum date calendar
		});
		
		$('#endDate1').datetimepicker({
			yearOffset : 0,
			lang : 'ch',
			timepicker : false,
			format : 'Y-m-d',
			formatDate : 'Y-m-d',
		//		minDate:'1970/01/01', // yesterday is minimum date
		//		maxDate:'+1970/01/02' // and tommorow is maximum date calendar
		});
	</script>