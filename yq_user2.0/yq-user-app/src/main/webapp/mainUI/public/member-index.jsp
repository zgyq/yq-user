<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<c:if test="${isHaveTxPayBuy==true}"><script language=javascript>alert('<s:text name='viewindex2.jsp.index2.jsp.1200989498'/>！');location.replace('epmyjl?secondThisState=253&thisState=244');</script></c:if>
<c:if test="${isHaveTxPaySale==true}"><script language=javascript>alert('<s:text name='viewindex2.jsp.index2.jsp.545255763'/>！');location.replace('epmcjl?secondThisState=249&thisState=244');</script></c:if>
<c:if test="${dq=='0' or dq=='2' or dq=='7' or dq=='8'}">
<c:set var="cz01" value="<s:text name='viewindex2.jsp.index2.jsp.642434221'/>QQ：613697151"></c:set>
<c:set var="qq" value="613697151"></c:set>
<c:set var="cz02" value="<s:text name='viewindex2.jsp.index2.jsp.37800384'/>"></c:set>
</c:if>
<c:if test="${dq=='1' or dq=='3' or dq=='4' or dq=='5' or dq=='6'}">
<c:set var="cz01" value="<s:text name='viewindex2.jsp.index2.jsp.643357742'/>QQ：613697152"></c:set>
<c:set var="qq" value="613697152"></c:set>
<c:set var="cz02" value="<s:text name='viewindex2.jsp.index2.jsp.37800384'/>"></c:set>
</c:if>
<head>
  <meta chartset="UTF-8">
  <title><s:text name='reg1.jsp.reg1.jsp.624662580'/>|<s:text name='vipbdbdate.jsp.bdbdate.jsp.1257887'/></title>
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta http-equiv="x-dns-prefetch-control" content="on">
   <link rel="stylesheet" href="${ctx}/css/common${SESSION_LOCALE}.css">
    <link rel="stylesheet" href="${ctx}/css/member-index${SESSION_LOCALE}.css">
</head>

<body> 
<!-- 通用头部 -->
   <%@ include file="/mainUI/common/head.jsp" %>
<!-- 通用头部 end -->

<div class="container">
  <!-- 首页活动公告 -->
  <div class="index-top" id="J_memberIndexTop">
    <div class="active">
     <!--  <p class="title">活动</p> -->
      <div class="banner">
      <!-- <img src="img/banner.png" width="348" height="168"> -->
      <a href="#"><img src="${ctx}/img/banner.png" /></a>
      </div>
    </div>
    <%-- <div class="news">
      <p class="title"><s:text name='viewindex2.jsp.index2.jsp.667742'/></p>
      <div class="news-content">
        <!--文摘的所有内容 start-->
          <span><s:text name='viewindex2.jsp.index2.jsp.803273677'/>！</span>
	<s:text name='viewjflc-recharge-ok.jsp.jflc-recharge-ok.jsp.-836674711'/>：${gcuserup.qq}<a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=${gcuserup.qq}&site=qq&menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=2:${gcuserup.qq}:41" alt="<s:text name='Click_here_to_send_me_a_message'/>" title="<s:text name='Click_here_to_send_me_a_message'/>"></a><br /><br />

          <br>
         <!--  <span>根据您注册用户时选择的地区，本服务中心为您提供贴身的服务，以提高办事效率！ 有任何事情请联系：中国一川【②号】客服QQ：613</span>
          <br>
          <span>根据您注册用户时选择的地区，本服务中心为您提供贴身的服务，以提高办事效率！ 有任何事情请联系：中国一川【②号】客服QQ：613</span> -->
          <!--文摘的所有内容 end-->
      </div>
    </div> --%>
  </div>
  <!-- 首页活动公告 end -->
</div>
<div class="container">
  <!-- 首页内容 -->
  <div class="member-content" id="J_memberContent">
    <!-- 会员中心左边栏 -->
<div class="member-aside-index">
   <%@ include file="/mainUI/common/userLeft.jsp" %>
   <%@ include file="/mainUI/common/licaiLeft2.jsp" %>
</div>
<!-- 会员中心左边栏 end -->

    <!-- <s:text name='viewindex2.jsp.index2.jsp.70014993'/> -->
    <div class="member-main-index">
      <div class="main-widget admin-news">
        <p class="widget-title-line"><s:text name='viewindex2.jsp.index2.jsp.70014993'/></p>
        <ul class="news-list">
          <s:iterator var="data" value="dataList">
           <%--  <li class="item">
              <p class="article-info">
                <span class="time"><fmt:formatDate value="${data.ggdate}" type="date"/></span>
                <br/>
                <span class="article-title"><a href="/ggck?ck=${data.id}">${data.ggbt}</a></span>
              </p>
              <a class="more" href="/ggck?ck=${data.id}"><s:text name='See'/></a>
            </li> --%>
              <li class="item">
              <p class="article-info">
                <c:choose>  
				<c:when test="${SESSION_LOCALE=='en_US'}"> 
				<span class="time"><fmt:formatDate value="${data.ggdate}" type="date"/></span><br/>
				<c:if test="${data.ggbt_en==null}">
					<span  class="article-title"><a href="/ggck?ck=${data.id}">${data.ggbt}</a></span>
				</c:if>
				<span class="article-title"><a href="/ggck?ck=${data.id}">${data.ggbt_en}</a></span>
  				</c:when>
  				<c:when test="${SESSION_LOCALE=='zh_CN'}">   
  					<span class="time"><fmt:formatDate value="${data.ggdate}" type="date"/></span>
				<c:if test="${data.ggbt==null}">
					<span  class="article-title"><a href="/ggck?ck=${data.id}">${data.ggbt_en}</a></span>
				</c:if>
				<span  class="article-title"><a href="/ggck?ck=${data.id}">${data.ggbt}</a></span>
  				</c:when>  
				<c:otherwise>
				<span class="time"><fmt:formatDate value="${data.ggdate}" type="date"/></span><br/>
				<span class="article-title"><a href="/ggck?ck=${data.id}">${data.ggbt}</a></span>
  				</c:otherwise> 
  				</c:choose>
              </p>
              <a class="more" href="/ggck?ck=${data.id}"><s:text name='See'/></a>
            </li>
           </s:iterator>
           <%-- <s:iterator var="data" value="dataList">
			 <li class="item">
			<a href="/ggck?ck=${data.id}" class="ck">
			<img src="/images/ck${SESSION_LOCALE}.png" />  
			</a>
			<c:choose>  
			<c:when test="${SESSION_LOCALE=='en_US'}"> 
				<span><fmt:formatDate value="${data.ggdate}" type="date"/></span>
				<c:if test="${data.ggbt_en==null}">
					<p><a href="/ggck?ck=${data.id}">${data.ggbt}</a></p>
				</c:if>
				<p><a href="/ggck?ck=${data.id}">${data.ggbt_en}</a></p>
  				</c:when>
  				<c:when test="${SESSION_LOCALE=='zh_CN'}">   
  					<span><fmt:formatDate value="${data.ggdate}" type="date"/></span>
				<c:if test="${data.ggbt==null}">
					<p><a href="/ggck?ck=${data.id}">${data.ggbt_en}</a></p>
				</c:if>
				<p><a href="/ggck?ck=${data.id}">${data.ggbt}</a></p>
  				</c:when>  
			<c:otherwise>
				<span><fmt:formatDate value="${data.ggdate}" type="date"/></span>
				<p><a href="/ggck?ck=${data.id}">${data.ggbt}</a></p>
  				</c:otherwise> 
  				</c:choose>
			</li>
			</s:iterator> --%>
        </ul>
        <!-- 会员中心翻页组件 -->
<p class="widget-pages">
 <aldtags:pageTag paraStr="thisState,${thisState},secondThisState,${secondThisState}"/>
</p>
<!-- 会员中心翻页组件 end -->

      </div>
    </div>
    <!-- <s:text name='viewindex2.jsp.index2.jsp.70014993'/> end -->
  </div>
  <!-- 首页内容 end -->
</div>
<c:if test="${guanggao==1 && SESSION_LOCALE!='en_US'}">
<div id="mask"></div>
<div id="passport-login-pop-dialog">
<div id='tang-title'><span>积分游戏大平台</span><span id="close"></span>
	<div class="dialog-content">
		<p class="p-1">积分游戏大平台APP钱罐正式上线及积分卖出规则变更通知</p>
		<p class="p-indent">“积分游戏大平台APP钱罐”将于2017年06月02日正式上线，从即日起会员中心积分卖出规则变更为：</p>
		<p>积分卖出总额扣除10%手续费后，余下部分65%进入一币账户（可提现、复利），5%进入钱罐可用于消费（积分游戏大平台APP、实体店、科瞻票务、幸福商城等），30%返回到金币账户（可进行回购积分再次获取差价利润和增值收益）。</p>
		<p class="p-indent">“钱罐”是用户在使用“积分游戏大平台app”支付中的现金。 “钱罐”中的货币可以用于APP内的各项消费（充值手机话费，购买机票，商城购物等）“钱罐”内的余额可以通过 微信 支付宝 银行卡 一币充值。“积分游戏大平台APP钱罐”将成为您今后消费理财的新助手，欢迎家人使用。</p>
	</div>
</div>
</div>
</c:if>
<script>
	    function $$(close){
			return document.getElementById(close)
		}
		$$('close').onclick=function(){
			$$('mask').style.display="none";
			$$('passport-login-pop-dialog').style.display="none";
		}
	</script>
<script type="text/javascript" src="${ctx}/js/jquery.js"></script>
<script type="text/javascript" src="${ctx}/js/common.js"></script>
<script type="text/javascript" src="${ctx}/js/member-index.js"></script>
</body>

</html>

