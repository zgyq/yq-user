<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:if test="${erroCodeNum==1}"><script language=javascript>alert('注意：您的一币小于15，请充值！');history.go(-1);</script></c:if>
<c:if test="${erroCodeNum==2}"><script language=javascript>alert('注意：您的一币不够本次购卡，请充值！');history.go(-1);</script></c:if>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
  <meta chartset="UTF-8">
  <title>会员中心|一币购金币卡</title>
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta http-equiv="x-dns-prefetch-control" content="on">
  <link rel="stylesheet" href="${ctx}/css/common.css">
</head>

<body> <!-- 通用头部 -->
<%@ include file="/mainUI/common/head.jsp" %>
<!-- 通用头部 end -->
 <!-- 会员中心导航模块 -->
<div class="container">
  <div class="member-header" id="J_memberHeader">
    <p class="breadcrumb-trail">财富中心 >> 一币理财</p>
     <%@ include file="/mainUI/common/scendhead.jsp" %>
  </div>
</div>
<!-- 会员中心导航模块 end -->

<!-- 一币理财内容 -->
<div class="container">
  <div class="member-content" id="J_memberContent">
     <div class="member-main-full">
      <!-- 一币购金币卡 -->
      <div class="main-widget">
        <p class="widget-title-line">一币转换电子金币卡录入</p>
        <div class="widget-article">
          <form class="widget-form" action="jztojb?status=3&mj=${mj}&gmsl=${gmsl}&secondThisState=${secondThisState}&thisState=${thisState}" method="post" onSubmit="return checkdate();" name="Form" id="Form">
            <p class="item">
              <lable class="title">金币卡面值：</lable>
              <span class="text widget-warning">
							<c:if test="${mj==10}">10金币（15一币/张）</c:if>
							<c:if test="${mj==50}">50金币（75一币/张）</c:if>
							<c:if test="${mj==100}">100金币（150一币/张）</c:if>
							<c:if test="${mj==300}">300金币（450一币/张）</c:if>
							<c:if test="${mj==500}">500金币（750一币/张）</c:if>
							<c:if test="${mj==1000}">1000金币（1500一币/张）</c:if></span>
            </p>
            <p class="item">
              <lable class="title">购买金币卡数量：</lable>
              <span class="text"><b class="widget-warning">${gmsl}</b>张</span>
            </p>
            <p class="item">
              <lable class="title">将获取金币总数：</lable>
              <span class="text"><b class="widget-warning">${gmsl*mj}</b>个</span>
            </p>
            <p class="item">
              <lable class="title">消费一币数：</lable>
              <span class="text"><b class="widget-warning">${gmsl*mj*1.5}</b>一币</span>
            </p>
            <p class="item">
              <lable class="title">二级密码：</lable>
              <input type="password" name="pa3" />
            </p>
            <p class="item">
	            <label class="title">手机验证码：</label>
	            <input type="text" name="smsCode" size="20" onKeyUp="value=value.replace(/[\W]/g,'')"/>
	            <input class="widget-button-small" id="btn" type="button" onclick="sendMsg()" value="获取验证码"/>
	            <!-- input type="text" name="smsCode" size="20" onKeyUp="value=value.replace(/[\W]/g,'')"/><a href="javascript:void(0);" class="widget-button-small" onclick="sendMsg()">获取验证码</a> -->
         	 </p> 
            <p class="button-line mt15">
              <button type="submit" class="widget-button">确定从我的一币-扣除</button>
            </p>
            
          </form>
        </div>
      </div>
      <!-- 一币购金币卡 end -->
    </div>
  </div>
</div>
<!-- 一币理财内容 end -->
<script type="text/javascript" src="${ctx}/js/jquery.js"></script>
<script type="text/javascript" src="${ctx}/js/common.js"></script>
<script language="JavaScript">
function checkdate() {
  if (Form.pa3.value == "") {
    alert("请输入二级密码!");
    return false;
  }
  if (Form.smsCode.value == "") {
	    alert("手机验证码不能为空！");
	    Form.smsCode.focus();
	    return false;
	  }
  if (!confirm('提示：您确定了吗？ ')) {
    return false;
  }
  return true;
}
function sendMsg() {
	  /* if (!checkdate()) {
	    return;
	  } */
	  $("#btn").attr("disabled", "disabled");
	  var data = $("#Form").serialize();
	  $.post("/sms?op=17", data, function(response) {
	    $("#btn").removeAttr("disabled");
	    if (response.erroCodeNum != 0) {
	      alert("手机验证码发送失败");
	      return false;
	    }
	    settime($("#btn"), '#SESSION_LOCALE');
	    alert("手机验证码发送成功");
	  });
	} 
</script>
</body>

</html>