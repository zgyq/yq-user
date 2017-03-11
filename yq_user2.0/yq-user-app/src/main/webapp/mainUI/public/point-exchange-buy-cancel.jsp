<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:if test="${erroCodeNum==1}"><script language=javascript>alert('二级密码不正确！');location.replace('mysl?secondThisState=${secondThisState}&thisState=${thisState}');</script></c:if>
<c:if test="${erroCodeNum==2}"><script language=javascript>alert('该积分交易进行中或已经由它人交易成功了，不能修改，请选择其它交易！');location.replace('mysl?secondThisState=${secondThisState}&thisState=${thisState}');</script></c:if>
<c:if test="${erroCodeNum==2000}"><script language=javascript>alert('撤销求购积分成功！');location.replace('mysl?secondThisState=${secondThisState}&thisState=${thisState}');</script></c:if>

<!DOCTYPE html>
<html lang="zh-CN">

<head>
  <meta chartset="UTF-8">
  <title>会员中心|当前发布的积分买入撤销</title>
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta http-equiv="x-dns-prefetch-control" content="on">
  <link rel="stylesheet" href="${ctx}/css/common.css">
</head>

<body>
<!-- 通用头部 -->
<%@ include file="/mainUI/common/head.jsp" %>
<!-- 通用头部 end -->
 
<!-- 会员中心导航模块 -->
<div class="container">
  <div class="member-header" id="J_memberHeader">
    <p class="breadcrumb-trail">财富中心 >> 积分理财</p>
    <%@ include file="/mainUI/common/scendhead.jsp" %>
  </div>
</div>
<!-- 会员中心导航模块 end -->

<!-- 积分理财内容 -->
<div class="container">
  <div class="member-content" id="J_memberContent">
    <!-- 会员中心左边栏 -->
<div class="member-aside">
        <!-- 账户概览 积分理财、一币理财、业绩查询、个人信息 的不一样 -->
          <%@ include file="/mainUI/common/pointLicaiLeft.jsp" %>
        <!-- 账户概览  end -->
      </div>
<!-- 会员中心左边栏 end -->

    <div class="member-main">
    <div class="dialog-widget">
      <p class="dialog-title">当前发布的积分买入撤销</p>
      <!-- 图纸为一页13条数据 -->
      <div class="dialog-wrap-border main-widget">
        <form class="widget-form" method="POST" action="qxqg?status=1&qxid=${qxid}&secondThisState=${secondThisState}&thisState=${thisState}" name="Form" onSubmit="return checkdate()">
          <p class="item">
            <label class="title">用户名：</label><span class="text">${userName}</span></p>
          <p class="item">
            <label class="title">二级密码：</label>
            <input type="password" name="pa3">
          </p>
          <p class="button-line mt10">
            <input type="submit" class="widget-button" value='确认无误' name="B1">
          </p>
        </form>
      </div>
    </div>
  </div>
</div>
<script type="text/javascript" src="${ctx}/js/jquery.js"></script>
<script type="text/javascript" src="${ctx}/js/common.js"></script>
<script language="JavaScript">
function checkdate() {
  if (Form.nm3.value == "") {
    alert("请输入二级密码密码!");
    return false;
  }
  return true;
}
</script>
</body>

</html>
