<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">

<head>
  <meta chartset="UTF-8">
  <title><s:text name='vipgpjymy.jsp.gpjymy.jsp.624662580'/>|<s:text name='Two_level_password_login'/></title>
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta http-equiv="x-dns-prefetch-control" content="on">
  <link rel="stylesheet" href="${ctx}/css/common${SESSION_LOCALE}.css">
  <script type="text/javascript" src="${ctx}/js/jquery.js"></script>
  <script type="text/javascript" src="${ctx}/js/common.js"></script>
  
</head>
<%@ include file="/mainUI/common/head.jsp" %>
<!-- 通用头部 end -->
 
<!-- 会员中心导航模块 -->
<div class="container">
  <div class="member-header" id="J_memberHeader">
    <p class="breadcrumb-trail"><s:text name='viewhead.jsp.head.jsp.1099577248'/> >> <s:text name='viewyblc.jsp.yblc.jsp.618950045'/></p>
    <%@ include file="/mainUI/common/scendhead.jsp" %>
  </div>
</div>
<!-- 会员中心导航模块 end -->

<!-- 一币理财内容 -->
<div class="container">
  <div class="member-content" id="J_memberContent">
    <!-- 会员中心左边栏 -->
<div class="member-aside">
  <%@ include file="/mainUI/common/userLeft.jsp" %>
  <!-- 账户概览 积分理财、一币理财、业绩查询、个人信息 的不一样 -->
 <%@ include file="/mainUI/common/yblc.jsp" %>
  <!-- <s:text name='viewzhgl.jsp.zhgl.jsp.1101502999'/> end -->
</div>
<!-- 会员中心左边栏 end -->

    <div class="member-main">
      <!-- <s:text name='Money_transaction_rules'/> -->
      <div class="main-widget">
        <p class="widget-title-line"><s:text name='Money_transaction_rules'/></p>
        <div class="widget-article scroll-y small-size">
          <!-- 以下是直接引入的文章内容 -->
          <s:text name='viewlogin3j.jsp.login3j.jsp.1072980487'/>
          <br/> 1、<s:text name='viewlogin3j.jsp.login3j.jsp.1178622703'/>。
          <br/>2、<s:text name='viewlogin3j.jsp.login3j.jsp.1078412623'/>。
          <br/> <s:text name='viewlogin3j.jsp.login3j.jsp.203331168'/>
          <br/> 1、<s:text name='viewlogin3j.jsp.login3j.jsp.98672732'/>！
          <br/> 2、<s:text name='viewlogin3j.jsp.login3j.jsp.-1363913732'/>。
          <br/> 3、<s:text name='viewlogin3j.jsp.login3j.jsp.-9035302'/>。
          <br/> （<s:text name='viewlogin3j.jsp.login3j.jsp.2027468904'/>！）
        </div>
      </div>
      <!-- <s:text name='Money_transaction_rules'/> end -->
      <!-- 二级密码登录验证 -->
      <div class="main-widget mt15">
        <form class="widget-form" method="POST" action="" name="Form" id="Form" onsubmit="return false">
          <p class="item">
            <label class="title"><s:text name='reg.jsp.reg.jsp.29623262'/>：</label>
            <input type="text" value="${userName}" readonly="">
          </p>
          <p class="item">
            <label class="title"><s:text name='reg.jsp.reg.jsp.630954966'/>：</label>
            <input type="password" name="password3">
          </p>
          <p class="button-line mt15 tc">
            <button class="widget-button" type="submit" value="<s:text name='viplogin2j.jsp.login2j.jsp.941571312'/>" name="login" onclick="checkdate();"><s:text name='viplogin8j.jsp.login8j.jsp.665975448'/></button>
          </p>
        </form>
      </div>
      <!-- 二级密码登录验证 end -->
    </div>
  </div>
</div>
<!-- 一币理财内容 end -->
<script type="text/javascript" src="${ctx}/js/jquery.js"></script>
<script type="text/javascript" src="${ctx}/js/common.js"></script>
<script type="text/javascript">
function checkdate() {
  if (Form.pa3.value == "") {
    alert("<s:text name='reg.jsp.reg.jsp.-1719221018'/>");
    Form.pa3.focus();
    return false;
  }
  var data = $("#Form").serialize();
  $.post("/login2j?status=1&inputUrl=second-login.jsp", data, function(response) {
    var responseMsg = response;
    if (responseMsg.erroCodeNum == -1) { //注册成功
      //执行跳转
      location.replace('userpay?transferType=1');
      return;
    } else if (responseMsg.erroCodeNum == 1) {
      alert('<s:text name='viewlogin2j.jsp.login2j.jsp.950326025'/>');
      Form.pa3.focus();
      return;
    } else if (responseMsg.erroCodeNum == 2) {
      alert('<s:text name='viewlogin3j.jsp.login3j.jsp.-710088382'/>!');
      location.replace('epmcjl');
      return;
    } else if (responseMsg.erroCodeNum == 3) {
      alert('<s:text name='viewlogin3j.jsp.login3j.jsp.-1740535765'/>!');
      return;
    } else if (responseMsg.erroCodeNum == 4) {
      alert('<s:text name='viewlogin3j.jsp.login3j.jsp.-838678250'/>!');
      return;
    } else if (responseMsg.erroCodeNum == 5) {
      alert('<s:text name='viewlogin3j.jsp.login3j.jsp.-830018135'/>！');
      return;
    } else if (responseMsg.erroCodeNum == 6) {
      alert('<s:text name='viewlogin3j.jsp.login3j.jsp.-437103877'/>！');
      location.replace('dateuser');
      return
    } else if (responseMsg.erroCodeNum == -2) {
      location.replace('userpay?transferType=2');
      return;
    }
  });
  return true;
}
</script>
</body>

</html>
