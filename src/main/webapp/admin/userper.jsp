<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<html>
<title>显示用户信息</title>
<head>
		<style>
			#tip{
				width:200px;
				height:120px;
				background:#ccc;
				border:1px solid black;
				position:absolute;
				display:none;
			}
		</style>
<script type="text/javascript" src="/scripts/jquery.js"></script>
<link rel="stylesheet" type="text/css" href="/scripts/jquery.datetimepicker.css"/>
<script src="/scripts/jquery.datetimepicker.js"></script>
<script src="/scripts/go.js"></script>
</head>
<body bgcolor="#DDECFE" topmargin="5" leftmargin="5" onload="init()">
<div align="center">
  <table border="0" cellspacing="1" width="100%" height="184">
    <tr align="center">
      <td width="100%" height="26" background="/meme/images/admin_bg_1.gif"> 
        <p align="center"><font color="#000000" style="font-size: 14px"><strong>用户业绩信息详情</strong></font>
      <form name="form1" method="POST" action="/admin/userper?status=1">
用户名:<input type="text" name="user" size="20" value="${user}">
开始日期：<input type="text" name="startTime" id="startTime" size="20" value="${startTime}">
结束日期：<input type="text" name="endTime" id="endTime" size="20" value="${endTime}">
          <input type="submit" name="Submit" value="搜索"></form>
      </td>
  </tr> 
  </table>
  <c:if test="${not empty bean}">
            <table border="1" cellspacing="0" width="100%" style="border-collapse: collapse" cellpadding="0" height="62">
              <tr bgcolor="#7bb5de"> 
                <td width="144" align="center" height="23" bgcolor="#D9E6FF"><font face="宋体"><strong>用户名</strong></font></td>
                <td>${user}</td>
                <td></td>
              </tr>
              <tr bgcolor="#7bb5de"> 
                <td width="144" align="center" height="23" bgcolor="#D9E6FF"><font face="宋体"><strong>个人业绩</strong></font></td>
                <td bgcolor='<c:if test="${bean.siglePerformance*500>=500000}">green</c:if><c:if test="${bean.siglePerformance*500<500000}">red</c:if>' >${bean.siglePerformance}单=${bean.siglePerformance*500}元</td>
                <td>(此处数据为上级为${user}，并且不是${user}的同名账号的开户时间在${startTime}至${endTime}用户的单数之和)</td>
              </tr>
              <tr bgcolor="#7bb5de"> 
                <td width="144" align="center" height="23" bgcolor="#D9E6FF"><font face="宋体"><strong>总业绩</strong></font></td>
                <td  bgcolor='<c:if test="${bean.allPerformance*500>=620000}">green</c:if><c:if test="${bean.allPerformance*500<620000}">red</c:if>' >${bean.allPerformance}单=${bean.allPerformance*500}元</td>
                <td>(此处数据为${user}下级的开户时间在${startTime}至${endTime}用户的单数之和)</td>
              </tr>
              <tr bgcolor="#7bb5de"> 
                <td width="144" align="center" height="23" bgcolor="#D9E6FF"><font face="宋体"><strong>是否5层全满</strong></font></td>
                <td bgcolor='<c:if test="${bean.isFiveFull==true}">green</c:if><c:if test="${bean.isFiveFull==false}">red</c:if>'><c:if test="${bean.isFiveFull==true}">是</c:if><c:if test="${bean.isFiveFull==false}">否</c:if></td>
                <td></td>
              </tr>
            </table>
</c:if>
</div> 
<div id="sample">
  <div id="myDiagram" style="background-color: white; border: solid 1px black; width: 100%; height: 600px"></div>
</div>
</body> 
</html>
 <script type="text/javascript">
		$('#startTime').datetimepicker({
			yearOffset : 0,
			lang : 'ch',
			timepicker : false,
			format : 'Y-m-d',
			formatDate : 'Y-m-d',
		//		minDate:'1970/01/01', // yesterday is minimum date
		//		maxDate:'+1970/01/02' // and tommorow is maximum date calendar
		});
		$('#endTime').datetimepicker({
			yearOffset : 0,
			lang : 'ch',
			timepicker : false,
			format : 'Y-m-d',
			formatDate : 'Y-m-d',
		//		minDate:'1970/01/01', // yesterday is minimum date
		//		maxDate:'+1970/01/02' // and tommorow is maximum date calendar
		});
	</script>
<script id="code">
  function init() {
    var $ = go.GraphObject.make; 
    myDiagram =
      $(go.Diagram, "myDiagram",  
        {
          allowCopy: false,
          layout:  // create a TreeLayout for the family tree
            $(go.TreeLayout,
              { angle: 90, nodeSpacing: 5 })
        });
    var bluegrad = $(go.Brush, "Linear", { 0: "rgb(60, 204, 254)", 1: "rgb(70, 172, 254)" });
    var pinkgrad = $(go.Brush, "Linear", { 0: "rgb(255, 192, 203)", 1: "rgb(255, 142, 203)" });
    // Set up a Part as a legend, and place it directly on the diagram
    myDiagram.add(
      $(go.Part, "Table",
        { position: new go.Point(10, 10), selectable: false }
      ));
    // get tooltip text from the object's data
    function tooltipTextConverter(person) {
      var str = "";
      str += "Born: " + person.birthYear;
      if (person.deathYear !== undefined) str += "\nDied: " + person.deathYear;
      if (person.reign !== undefined) str += "\nReign: " + person.reign;
      return str;
    }
    // define tooltips for nodes
    var tooltiptemplate =
      $(go.Adornment, "Auto",
        $(go.Shape, "Rectangle",
          { fill: "whitesmoke", stroke: "black" }),
        $(go.TextBlock,
          { font: "bold 8pt Helvetica, bold Arial, sans-serif",
            wrap: go.TextBlock.WrapFit,
            margin: 5 },
          new go.Binding("text", "", tooltipTextConverter))
      );
    // define Converters to be used for Bindings
    function genderBrushConverter(gender) {
      if (gender === "M") return bluegrad;
      if (gender === "F") return pinkgrad;
      return "orange";
    }
    // replace the default Node template in the nodeTemplateMap
    myDiagram.nodeTemplate =
      $(go.Node, "Auto",
        { deletable: false, toolTip: tooltiptemplate },
        new go.Binding("text", "name"),
        $(go.Shape, "Rectangle",
          { fill: "orange",
            stroke: "black",
            stretch: go.GraphObject.Fill,
            alignment: go.Spot.Center },
          new go.Binding("fill", "gender", genderBrushConverter)),
        $(go.Panel, "Vertical",
          $(go.TextBlock,
            { font: "bold 8pt Helvetica, bold Arial, sans-serif",
              alignment: go.Spot.Center,
              margin: 6 },
            new go.Binding("text", "name")),
          $(go.TextBlock,
            new go.Binding("text", "kanjiName"))
        )
      );
    // define the Link template
    myDiagram.linkTemplate =
      $(go.Link,  // the whole link panel
        { routing: go.Link.Orthogonal, corner: 5, selectable: false },
        $(go.Shape));  // the default black link shape
    // here's the family data
     ${bean.performance.htmlScript}
  }
</script>