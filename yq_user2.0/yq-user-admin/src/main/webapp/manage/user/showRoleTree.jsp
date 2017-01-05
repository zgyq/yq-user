<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/manage/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>科宇科技</title>
<%@ include file="/manage/commons/meta.jsp"%>
<link href="${ctx}/styles/css.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" href="${ctx}/scripts/zTree/zTreeStyle/zTreeStyle.css" type="text/css"/>
	<script type="text/javascript" src="${ctx}/scripts/zTree/jquery.ztree.core-3.0.js"></script>
	<script type="text/javascript" src="${ctx}/scripts/zTree/jquery.ztree.excheck-3.0.js"></script>
    <script type="text/javascript" src="${ctx}/scripts/loadTree/roleTreeCheck.js"></script>
<script type="text/javascript">

$(document).ready(function(){
	loadResourceTree();//加载tree
});



function select_terminal(){
	var userId=$("#userId").val();
	if(userId!=null&&userId!=""){
	var parEle="";
	//获取选中的值
	var zTree = $.fn.zTree.getZTreeObj("resourceTree");
	var treeNode = zTree.getCheckedNodes();
	var names = '';
	var ids = '';
	for(var i=0;i < treeNode.length;i++){
		var node = treeNode[i];
			names += node.name+',';
			ids += node.id+',';
	}
	parEle = subString(ids);
	$.ajax({
			  url: "/user/save.action?userId="+userId+"&roleCheckId="+parEle,
			  cache: false,
			  success: function(html){
				  var data = eval("(" + html + ")");//json为接收的后台返回的数据；
			      alert(data.info);
	  		 }
	});
    
  }
}

function subString(str){
	return str.substr(0,str.lastIndexOf(','))
}
</script>
</head>

<body >
<input type="hidden"  name="userId" id="userId" value="${param['id']}"/>
<div class="table_div">
  <table border="0" cellspacing="0" cellpadding="0" width="" style=" width:100%; ">
    <tr>
      <td valign="top">
        <div class="table_right">
          <div class="moudle_div">
             <div class="sidebar_title">
              <div class="sidebar_title_border">角色分配</div>
            </div>
            <div class="div_content">
              <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td width="220" valign="top" style="border:#dedee0 1px solid;"><div class="modlue_menu_div"><ul id="resourceTree" class="ztree"></ul></div></td>
                </tr>
              </table>
              <div style="clear:both;"></div>
            </div>
          </div>
        </div>
      </td>
    </tr>
    <tr>
    	<td align="right">
    		<input type="button" value="提交" onclick="select_terminal();"/>
    	</td>
    </tr>
  </table>
</div>
</body>
  
</html>

