<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:if test="${erroCodeNum==1}"><script language=javascript>alert('<s:text name='vipwymy.jsp.wymy.jsp.-1519534343'/>！');history.go(-1);</script></c:if>
<c:if test="${erroCodeNum==2}"><script language=javascript>alert('<s:text name='vipdiyjygj.jsp.diyjygj.jsp.-791568500'/>！');history.go(-1);</script></c:if>
<c:if test="${erroCodeNum==2000}"><script language=javascript>alert('<s:text name='vipwymy.jsp.wymy.jsp.-1596880694'/>！');location.replace('/gpjysc?secondThisState=${secondThisState}&thisState=${thisState}');</script></c:if>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
  <meta chartset="UTF-8">
  <title><s:text name='reg1.jsp.reg1.jsp.624662580'/>|<s:text name='I_want_to_buy_points'/></title>
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta http-equiv="x-dns-prefetch-control" content="on">
 <link rel="stylesheet" href="${ctx}/css/common${SESSION_LOCALE}.css">
</head>

<body> 
<!-- 通用头部 -->
<%@ include file="/mainUI/common/head.jsp" %>
<!-- 通用头部 end -->
 
<!-- 会员中心导航模块 -->
<div class="container">
  <div class="member-header" id="J_memberHeader">
    <p class="breadcrumb-trail"><s:text name='viewhead.jsp.head.jsp.1099577248'/> >> <s:text name='viewjflc.jsp.jflc.jsp.951062035'/></p>
    <%@ include file="/mainUI/common/scendhead.jsp" %>
  </div>
</div>
<!-- 会员中心导航模块 end -->

<!-- 积分理财内容 -->
<div class="container">
  <div class="member-content" id="J_memberContent">
  <%--   <!-- 会员中心左边栏 -->
<div class="member-aside">
  		<%@ include file="/mainUI/common/userLeft.jsp" %>
        <!-- 账户概览 积分理财、一币理财、业绩查询、个人信息 的不一样 -->
          <%@ include file="/mainUI/common/pointLicaiLeft.jsp" %>
        <!-- <s:text name='viewzhgl.jsp.zhgl.jsp.1101502999'/>  end -->
  <!-- <s:text name='viewzhgl.jsp.zhgl.jsp.1101502999'/>  end -->
</div>
<!-- 会员中心左边栏 end --> --%>

    <!-- 我要买积分 -->
    <div class="member-main">
      <div class="main-widget">
        <p class="widget-title-line"><s:text name='I_want_to_buy_points'/></p>
        <form class="widget-form">
          <p class="item">
            <lable class="title"><s:text name='vipwymy.jsp.wymy.jsp.1181588703'/>：</lable>
            <span class="text widget-warning">${gpjy.jypay}</span>
          </p>
          <p class="item">
            <lable class="title"><s:text name='vipwymy.jsp.wymy.jsp.-766773789'/>：</lable>
            <span class="text widget-warning">${gpjy.jypay}</span>
          </p>
          <p class="button-line mt15">
            <a class="widget-button" onclick="return confirm('"<s:text name='vipgpjymc.jsp.gpjymc.jsp.1526835300'/>"')" href="/wymy?status=1&id=${id}&secondThisState=${secondThisState}&thisState=${thisState}"><s:text name='vipepmy.jsp.epmy.jsp.941836283'/></a>
          </p>
        </form>
      </div>
    </div>
    <!-- 我要买积分 end -->
  </div>
</div>
<script type="text/javascript" src="${ctx}/js/jquery.js"></script>
<script type="text/javascript" src="${ctx}/js/common.js"></script>
</body>

</html>
