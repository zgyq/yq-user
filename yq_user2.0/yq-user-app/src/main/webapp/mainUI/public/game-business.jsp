<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:if test="${erroCodeNum==1}"><script language="javascript">alert('<s:text name='viewyjcx-game.jsp.yjcx-game.jsp.1836756650'/>！');</script></c:if>
<c:if test="${erroCodeNum==2}"><script language="javascript">alert('<s:text name='viewyblc-vipcjb.jsp.yblc-vipcjb.jsp.2073267590'/>！');history.go(-1);</script></c:if>

<!DOCTYPE html>
<html lang="zh-CN">

<head>
  <meta chartset="UTF-8">
  <title><s:text name='vipgpjymc.jsp.gpjymc.jsp.624662580'/>|<s:text name='viewlinks.html.links.html.865347806'/></title>
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
    <p class="breadcrumb-trail"><s:text name='Wealth-center'/> >> <s:text name='viewlinks.html.links.html.627723500'/></p>
    <%@ include file="/mainUI/common/scendhead.jsp" %>
  </div>
</div>
<!-- 会员中心导航模块 end -->

<!-- 业绩查询内容 -->
<div class="container">
  <div class="member-content" id="J_memberContent">
    <!-- 会员中心左边栏 -->
<div class="member-aside">
  <!-- 账户概览 积分理财、一币理财、业绩查询、个人信息 的不一样 -->
   <%@ include file="/mainUI/common/gameservice.jsp" %>
  <!-- <s:text name='viewzhgl.jsp.zhgl.jsp.1101502999'/>  end -->
</div>
<!-- 会员中心左边栏 end -->

    <div class="member-main">
      <!-- <s:text name='viewlinks.html.links.html.865347806'/> -->
      <div class="main-widget">
        <p class="widget-title-line"><s:text name='viewlinks.html.links.html.865347806'/></p>
        <div class="game-business">
          <div class="game-wrap">
            <div class="head-search">
              <p class="fl"><s:text name='reg.jsp.reg.jsp.29623262'/>：<span class="game-warning">${myup}</span></p>
              <form class="fr" method="POST" action="sgks01" name="Form">
                <input type="text" class="input" name="myup" placeholder="<s:text name='viewyjcx-game.jsp.yjcx-game.jsp.1364845601'/>" />
                <input type="button" class="search-btn" onclick="Form.submit()" />
              </form>
            </div>
            <div class="game-table-content small-size mt5">
              <table class="table-total" border="0" cellspacing="0" cellpadding="0">
                <caption><s:text name='viewyjcx-game.jsp.yjcx-game.jsp.1029202'/></caption>
                <thead>
                  <tr>
                    <th><s:text name='viewyjcx-game.jsp.yjcx-game.jsp.766484'/></th>
                    <th><s:text name='viewyjcx-game.jsp.yjcx-game.jsp.687527'/></th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                   <td><b class="game-warning">${sgxt.zaq}</b></td>
                   <td><b class="game-warning">${sgxt.zbq}</b></td>
                  </tr>
                </tbody>
              </table>
            </div>
            <div class="game-table-content middle-size">
              <table class="current-distribution-status-3" border="0" cellspacing="0" cellpadding="0">
                <caption>(${myup})<s:text name='viewyjcx-game.jsp.yjcx-game.jsp.1917466217'/></caption>
                <thead>
                  <tr>
                    <th><s:text name='viewyjcx-game.jsp.yjcx-game.jsp.1017813'/></th>
                    <th><s:text name='reg.jsp.reg.jsp.29623262'/></th>
                    <th><s:text name='viewyjcx-game.jsp.yjcx-game.jsp.769813'/></th>
                    <th><s:text name='viewyjcx-game.jsp.yjcx-game.jsp.690856'/></th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td><i class="icon-stage-1">1-1</i></td>
                    <td><c:if test="${!empty sgxt.auid}"><a href="sgks01?secondThisState=${secondThisState}&thisState=${thisState}&status=1&bd=${bdid}&myup=${sgxt.auid}" style="text-decoration: none">${sgxt.auid}（${sgxta.sjb}）</a></c:if>
			<c:if test="${empty sgxt.auid}"><a href="sgreg?secondThisState=${secondThisState}&thisState=${thisState}&bd=${bdid}&myup=${myup}" style="text-decoration: none"><s:text name='viewyjcx-game.jsp.yjcx-game.jsp.1123809299'/></a></c:if></a>
                    </td>
                    <td><span><c:if test="${sgxta.zaq!=''}">${sgxta.zaq}</c:if></span></td>
                    <td><span><c:if test="${sgxta.zbq!=''}">${sgxta.zbq}</c:if></span></td>
                  </tr>
                  <tr>
                    <td><i class="icon-stage-1">1-2</i></td>
                    <td><c:if test="${!empty sgxt.buid}"><a href="sgks01?secondThisState=${secondThisState}&thisState=${thisState}&status=1&bd=${bdid}&myup=${sgxt.buid}" style="text-decoration: none">${sgxt.buid}（${sgxtb.sjb}）</a></c:if>
			<c:if test="${empty sgxt.buid}"><a href="sgreg?secondThisState=${secondThisState}&thisState=${thisState}&bd=${bdid}&myup=${myup}" style="text-decoration: none"><s:text name='viewyjcx-game.jsp.yjcx-game.jsp.1123809299'/></a></c:if></a>
                    </td>
                    <td><span><c:if test="${sgxtb.zaq!=''}">${sgxtb.zaq}</c:if></span></td>
                    <td><span><c:if test="${sgxtb.zbq!=''}">${sgxtb.zbq}</c:if></span></td>
                  </tr>
                  <tr>
                    <td>
                      <i class="icon-stage-2">2-1</i>
                    </td>
                    <td>
                      <c:if test="${!empty sgxta.auid}">
						<a href="sgks01?secondThisState=${secondThisState}&thisState=${thisState}&status=1&bd=${bdid}&myup=${sgxta.auid}"
							style="text-decoration: none">${sgxta.auid}（${sgxtaa.sjb}）</a>
					</c:if> <c:if test="${empty sgxta.auid}">
						<c:if test="${not empty sgxta.username}">
							<a href="sgreg?secondThisState=${secondThisState}&thisState=${thisState}&bd=${bdid}&myup=${sgxta.username}"
								style="text-decoration: none"><s:text name='viewyjcx-game.jsp.yjcx-game.jsp.1123809299'/></a>
						</c:if>
						<c:if test="${empty sgxta.username}"><s:text name='viewyjcx-game.jsp.yjcx-game.jsp.802378150'/></c:if>
					</c:if>
                    </td>
                    <td><span><c:if test="${sgxtaa.zaq!=''}">${sgxtaa.zaq}</c:if></span></td>
                    <td><span><c:if test="${sgxtaa.zbq!=''}">${sgxtaa.zbq}</c:if></span></td>
                  </tr>
                  <tr>
                    <td>
                      <i class="icon-stage-2">2-2</i>
                    </td>
                    <td>
                      <c:if test="${!empty sgxta.buid}">
							<a href="sgks01?secondThisState=${secondThisState}&thisState=${thisState}&status=1&bd=${bdid}&myup=${sgxta.buid}"
								style="text-decoration: none">${sgxta.buid}（${sgxtab.sjb}）</a>
						</c:if> <c:if test="${empty sgxta.buid}">
							<c:if test="${not empty sgxta.username}">
								<a href="sgreg?secondThisState=${secondThisState}&thisState=${thisState}&bd=${bdid}&myup=${sgxta.username}"
									style="text-decoration: none"><s:text name='viewyjcx-game.jsp.yjcx-game.jsp.1123809299'/></a>
							</c:if>
							<c:if test="${empty sgxta.username}"><s:text name='viewyjcx-game.jsp.yjcx-game.jsp.802378150'/></c:if>
					</c:if>
                    </td>
                    <td><span><c:if test="${sgxtab.zaq!=''}">${sgxtab.zaq}</c:if></span></td>
                    <td><span><c:if test="${sgxtab.zbq!=''}">${sgxtab.zbq}</c:if></span></td>
                  </tr>
                  <tr>
                    <td>
                      <i class="icon-stage-2">2-3</i>
                    </td>
                    <td>
                     <c:if test="${!empty sgxtb.auid}"><a href="sgks01?secondThisState=${secondThisState}&thisState=${thisState}&status=1&bd=${bdid}&myup=${sgxtb.auid}" style="text-decoration: none">${sgxtb.auid}（${sgxtba.sjb}）</a></c:if>
					<c:if test="${empty sgxtb.auid}">
			   		<c:if test="${not empty sgxtb.username}"><a href="sgreg?secondThisState=${secondThisState}&thisState=${thisState}&bd=${bdid}&myup=${sgxtb.username}" style="text-decoration: none"><s:text name='viewyjcx-game.jsp.yjcx-game.jsp.1123809299'/></a></c:if>
			   		<c:if test="${empty sgxtb.username}"><s:text name='viewyjcx-game.jsp.yjcx-game.jsp.802378150'/></c:if>
			 		</c:if>
                    </td>
                    <td><span><c:if test="${sgxtba.zaq!=''}">${sgxtba.zaq}</c:if></span></td>
                    <td><span><c:if test="${sgxtba.zbq!=''}">${sgxtba.zbq}</c:if></span></td>
                  </tr>
                  <tr>
                    <td>
                      <i class="icon-stage-2">2-4</i>
                    </td>
                    <td>
                      <c:if test="${!empty sgxtb.buid}"><a href="sgks01?secondThisState=${secondThisState}&thisState=${thisState}&status=1&bd=${bdid}&myup=${sgxtb.buid}" style="text-decoration: none">${sgxtb.buid}（${sgxtbb.sjb}）</a></c:if>
						<c:if test="${empty sgxtb.buid}">
						   <c:if test="${not empty sgxtb.username}"><a href="sgreg?secondThisState=${secondThisState}&thisState=${thisState}&bd=${bdid}&myup=${sgxtb.username}" style="text-decoration: none"><s:text name='viewyjcx-game.jsp.yjcx-game.jsp.1123809299'/></a></c:if>
						   <c:if test="${empty sgxtb.username}"><s:text name='viewyjcx-game.jsp.yjcx-game.jsp.802378150'/></c:if>
						</c:if>
                    </td>
                    <td><span><c:if test="${sgxtbb.zaq!=''}">${sgxtbb.zaq}</c:if></span></td>
                    <td><span><c:if test="${sgxtbb.zbq!=''}">${sgxtbb.zbq}</c:if></span></td>
                  </tr>
                  <tr>
                    <td><i class="icon-stage-3">3-1</i></td>
                    <td>
                      <c:if test="${!empty sgxtaa.auid}"><a href="sgks01?secondThisState=${secondThisState}&thisState=${thisState}&status=1&bd=${bdid}&myup=${sgxtaa.auid}" style="text-decoration: none">${sgxtaa.auid}（${sgxtaaa.sjb}）</a></c:if>
					<c:if test="${empty sgxtaa.auid}">
					<c:if test="${not empty sgxtaa.username}">
					<a href="sgreg?secondThisState=${secondThisState}&thisState=${thisState}&bd=${bdid}&myup=${sgxtaa.username}" style="text-decoration: none"><s:text name='viewyjcx-game.jsp.yjcx-game.jsp.1123809299'/></a>
					</c:if>
					<c:if test="${empty sgxtaa.username}"><s:text name='viewyjcx-game.jsp.yjcx-game.jsp.802378150'/></c:if>
					</c:if>
                    </td>
                    <td><span></span></td>
                    <td><span></span></td>
                  </tr>
                  <tr>
                    <td><i class="icon-stage-3">3-2</i></td>
                    <td>
                     <c:if test="${!empty sgxtaa.buid}"><a href="sgks01?secondThisState=${secondThisState}&thisState=${thisState}&status=1&bd=${bdid}&myup=${sgxtaa.buid}" style="text-decoration: none">${sgxtaa.buid}（${sgxtaab.sjb}）</a></c:if>
			<c:if test="${empty sgxtaa.buid}">
			    <c:if test="${not empty sgxtaa.username}"><a href="sgreg?secondThisState=${secondThisState}&thisState=${thisState}&bd=${bdid}&myup=${sgxtaa.username}" style="text-decoration: none"><s:text name='viewyjcx-game.jsp.yjcx-game.jsp.1123809299'/></a></c:if>
			    <c:if test="${empty sgxtaa.username}"><s:text name='viewyjcx-game.jsp.yjcx-game.jsp.802378150'/></c:if>
			</c:if>
                    </td>
                    <td><span></span></td>
                    <td><span></span></td>
                  </tr>
                  <tr>
                    <td><i class="icon-stage-3">3-3</i></td>
                    <td><c:if test="${!empty sgxtab.auid}"><a href="sgks01?secondThisState=${secondThisState}&thisState=${thisState}&status=1&bd=${bdid}&myup=${sgxtab.auid}" style="text-decoration: none">${sgxtab.auid}（${sgxtaba.sjb}）</a></c:if>
			<c:if test="${empty sgxtab.auid}">
			    <c:if test="${not empty sgxtab.username}"><a href="sgreg?secondThisState=${secondThisState}&thisState=${thisState}&bd=${bdid}&myup=${sgxtab.username}" style="text-decoration: none"><s:text name='viewyjcx-game.jsp.yjcx-game.jsp.1123809299'/></a></c:if>
			    <c:if test="${empty sgxtab.username}"><s:text name='viewyjcx-game.jsp.yjcx-game.jsp.802378150'/></c:if>
			</c:if>
                    </td>
                    <td><span></span></td>
                    <td><span></span></td>
                  </tr>
                  <tr>
                    <td><i class="icon-stage-3">3-4</i></td>
                    <td>
                     <c:if test="${!empty sgxtab.buid}"><a href="sgks01?secondThisState=${secondThisState}&thisState=${thisState}&status=1&bd=${bdid}&myup=${sgxtab.buid}" style="text-decoration: none">${sgxtab.buid}（${sgxtabb.sjb}）</a></c:if>
			<c:if test="${empty sgxtab.buid}">
			    <c:if test="${not empty sgxtab.username}"><a href="sgreg?secondThisState=${secondThisState}&thisState=${thisState}&bd=${bdid}&myup=${sgxtab.username}" style="text-decoration: none"><s:text name='viewyjcx-game.jsp.yjcx-game.jsp.1123809299'/></a></c:if>
			    <c:if test="${empty sgxtab.username}"><s:text name='viewyjcx-game.jsp.yjcx-game.jsp.802378150'/></c:if>
			</c:if>
                    </td>
                    <td><span></span></td>
                    <td><span></span></td>
                  </tr>
                  <tr>
                    <td><i class="icon-stage-3">3-5</i></td>
                    <td>
                     <c:if test="${!empty sgxtba.auid}"><a href="sgks01?secondThisState=${secondThisState}&thisState=${thisState}&status=1&bd=${bdid}&myup=${sgxtba.auid}" style="text-decoration: none">${sgxtba.auid}（${sgxtbaa.sjb}）</a></c:if>
			<c:if test="${empty sgxtba.auid}">
			   <c:if test="${not empty sgxtba.username}">
			   		<a href="sgreg?secondThisState=${secondThisState}&thisState=${thisState}&bd=${bdid}&myup=${sgxtba.username}" style="text-decoration: none"><s:text name='viewyjcx-game.jsp.yjcx-game.jsp.1123809299'/></a>
			   </c:if>
			   <c:if test="${empty sgxtba.username}"><s:text name='viewyjcx-game.jsp.yjcx-game.jsp.802378150'/></c:if>
			</c:if>
                    </td>
                    <td><span></span></td>
                    <td><span></span></td>
                  </tr>
                  <tr>
                    <td><i class="icon-stage-3">3-6</i></td>
                    <td>
                      <c:if test="${!empty sgxtba.buid}"><a href="sgks01?secondThisState=${secondThisState}&thisState=${thisState}&status=1&bd=${bdid}&myup=${sgxtba.buid}" style="text-decoration: none">${sgxtba.buid}（${sgxtbab.sjb}）</a></c:if>
			<c:if test="${empty sgxtba.buid}">
			   <c:if test="${not empty sgxtba.username}">
			   <a href="sgreg?secondThisState=${secondThisState}&thisState=${thisState}&bd=${bdid}&myup=${sgxtba.username}" style="text-decoration: none"><s:text name='viewyjcx-game.jsp.yjcx-game.jsp.1123809299'/></a>
			   </c:if>
			   <c:if test="${empty sgxtba.username}"><s:text name='viewyjcx-game.jsp.yjcx-game.jsp.802378150'/></c:if>
            </c:if>
                    </td>
                    <td><span></span></td>
                    <td><span></span></td>
                  </tr>
                  <tr>
                    <td><i class="icon-stage-3">3-7</i></td>
                    <td>
                    <c:if test="${!empty sgxtbb.auid}"><a href="sgks01?secondThisState=${secondThisState}&thisState=${thisState}&status=1&bd=${bdid}&myup=${sgxtbb.auid}" style="text-decoration: none">${sgxtbb.auid}（${sgxtbba.sjb}）</a></c:if>
			<c:if test="${empty sgxtbb.auid}">
			    <c:if test="${not empty sgxtbb.username}">
			      <a href="sgreg?secondThisState=${secondThisState}&thisState=${thisState}&bd=${bdid}&myup=${sgxtbb.username}" style="text-decoration: none"><s:text name='viewyjcx-game.jsp.yjcx-game.jsp.1123809299'/></a>
			    </c:if>
			    <c:if test="${empty sgxtbb.username}"><s:text name='viewyjcx-game.jsp.yjcx-game.jsp.802378150'/></c:if>
			</c:if>
                    </td>
                    <td><span></span></td>
                    <td><span></span></td>
                  </tr>
                  <tr>
                    <td><i class="icon-stage-3">3-8</i></td>
                    <td>
                    <c:if test="${!empty sgxtbb.buid}"><a href="sgks01?secondThisState=${secondThisState}&thisState=${thisState}&status=1&bd=${bdid}&myup=${sgxtbb.buid}" style="text-decoration: none">${sgxtbb.buid}（${sgxtbbb.sjb}）</a></c:if>
			<c:if test="${empty sgxtbb.buid}">
			    <c:if test="${not empty sgxtbb.username}">
			      <a href="sgreg?secondThisState=${secondThisState}&thisState=${thisState}&bd=${bdid}&myup=${sgxtbb.username}" style="text-decoration: none"><s:text name='viewyjcx-game.jsp.yjcx-game.jsp.1123809299'/></a>
			    </c:if>
			    <c:if test="${empty sgxtbb.username}"><s:text name='viewyjcx-game.jsp.yjcx-game.jsp.802378150'/></c:if>
			</c:if>
                    </td>
                    <td><span></span></td>
                    <td><span></span></td>
                  </tr>
                </tbody>
                <tfoot>
                  <tr>
                    <td colspan="4"><s:text name='The_left_and_right_sides_of_the_current_3_layer_refers_to_the_total_sum_of_the_total_singular_number_of_the_user_name_network_within_the_current_16_layers'/>(<span class="game-warning">${myup}</span>)<s:text name='viewyjcx-game.jsp.yjcx-game.jsp.2025953425a'/>
                    </td>
                  </tr>
                </tfoot>
              </table>
            </div>
          </div>
          <div class="game-wrap fl ml5">
            <div class="head-back">
              <a href="sgks01?secondThisState=${secondThisState}&thisState=${thisState}&bd=&amp;myup=${userName}" class="fl"><s:text name='viewyjcx-game.jsp.yjcx-game.jsp.1119330385'/>：${userName}</a>
              <a href="javascript:history.back();" class="fr"><s:text name='viewyjcx-choose-empty-sure.jsp.yjcx-choose-empty-sure.jsp.326654005'/></a>
            </div>
            <div class="game-table-content small-size mt5">
              <table class="forthcoming-settlement" border="0" cellspacing="0" cellpadding="0">
                <caption><s:text name='viewyjcx-game.jsp.yjcx-game.jsp.660102487'/></caption>
                <thead>
                  <tr>
                    <th><s:text name='viewyjcx-game.jsp.yjcx-game.jsp.766484'/></th>
                    <th><s:text name='viewyjcx-game.jsp.yjcx-game.jsp.687527'/></th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td><b class="game-warning">${sgxt.aq}</b></td>
                    <td><b class="game-warning">${sgxt.bq}</b></td>
                  </tr>
                </tbody>
              </table>
            </div>
            <div class="game-table-content middle-size">
              <table class="current-distribution-status-6" border="0" cellspacing="0" cellpadding="0">
                <caption>(${myup})<s:text name='viewyjcx-game.jsp.yjcx-game.jsp.438864785'/></caption>
                <thead>
                  <tr>
                    <th><s:text name='viewyjcx-game.jsp.yjcx-game.jsp.758126'/></th>
                    <th><s:text name='viewyjcx-game.jsp.yjcx-game.jsp.769813'/></th>
                    <th><s:text name='viewyjcx-game.jsp.yjcx-game.jsp.690856'/></th>
                    <th><s:text name='viewyjcx-game.jsp.yjcx-game.jsp.755711'/></th>
                    <th>可用</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td><i>1</i></td>
                    <td>${sgxt.z1}</td>
					<td>${sgxt.y1}</td>
					<td><span class="r">${sgxt.cfd}</span></td>
					<td>
						<c:set var="basez" scope="session" value="${sgxt.z1}"/>
						<c:set var="basey" scope="session" value="${sgxt.y1}"/>
						<c:choose>
							<c:when test="${null==basez || null==basey}">
								<c:out value="${sgxt.cfd}"/>
							</c:when>
							<c:otherwise>
								<c:if test="${basez>basey}"> <c:out value="${sgxt.cfd-basey}"/></c:if>
								<c:if test="${basez==basey}"> <c:out value="${sgxt.cfd-basez}"/></c:if>
								<c:if test="${basez<basey}"><c:out value="${sgxt.cfd-basez}"/></c:if>
							</c:otherwise>
						</c:choose>
					</td>
                  </tr>
                  <tr>
                    <td><i>2</i></td>
                    <td>${sgxt.z2}</td>
					<td>${sgxt.y2}</td>
					<td><span class="r">${sgxt.cfd}</span></td>
					<td>
						<c:set var="basez" scope="session" value="${sgxt.z2}"/>
						<c:set var="basey" scope="session" value="${sgxt.y2}"/>
						<c:choose>
							<c:when test="${null==basez || null==basey}">
								<c:out value="${sgxt.cfd}"/>
							</c:when>
							<c:otherwise>
								<c:if test="${basez>basey}"> <c:out value="${sgxt.cfd-basey}"/></c:if>
								<c:if test="${basez==basey}"> <c:out value="${sgxt.cfd-basez}"/></c:if>
								<c:if test="${basez<basey}"><c:out value="${sgxt.cfd-basez}"/></c:if>
							</c:otherwise>
						</c:choose>
					</td>
                  </tr>
                  <tr>
                    <td><i>3</i></td>
                    <td>${sgxt.z3}</td>
                    <td>${sgxt.y3}</td>
                    <td><span class="r">${sgxt.cfd}</span></td>
                    <td>
						<c:set var="basez" scope="session" value="${sgxt.z3}"/>
						<c:set var="basey" scope="session" value="${sgxt.y3}"/>
						<c:choose>
							<c:when test="${null==basez || null==basey}">
								<c:out value="${sgxt.cfd}"/>
							</c:when>
							<c:otherwise>
								<c:if test="${basez>basey}"> <c:out value="${sgxt.cfd-basey}"/></c:if>
								<c:if test="${basez==basey}"> <c:out value="${sgxt.cfd-basez}"/></c:if>
								<c:if test="${basez<basey}"><c:out value="${sgxt.cfd-basez}"/></c:if>
							</c:otherwise>
						</c:choose>
					</td>
                  </tr>
                  <tr>
                    <td><i>4</i></td>
                    <td>${sgxt.z4}</td>
                    <td>${sgxt.y4}</td>
                    <td><span class="r">${sgxt.cfd}</span></td>
                    <td>
						<c:set var="basez" scope="session" value="${sgxt.z4}"/>
						<c:set var="basey" scope="session" value="${sgxt.y4}"/>
						<c:choose>
							<c:when test="${null==basez || null==basey}">
								<c:out value="${sgxt.cfd}"/>
							</c:when>
							<c:otherwise>
								<c:if test="${basez>basey}"> <c:out value="${sgxt.cfd-basey}"/></c:if>
								<c:if test="${basez==basey}"> <c:out value="${sgxt.cfd-basez}"/></c:if>
								<c:if test="${basez<basey}"><c:out value="${sgxt.cfd-basez}"/></c:if>
							</c:otherwise>
						</c:choose>
					</td>
                  </tr>
                  <tr>
                    <td><i>5</i></td>
                    <td>${sgxt.z5}</td>
                    <td>${sgxt.y5}</td>
                    <td><span class="r">${sgxt.cfd}</span></td>
                    <td>
						<c:set var="basez" scope="session" value="${sgxt.z5}"/>
						<c:set var="basey" scope="session" value="${sgxt.y5}"/>
						<c:choose>
							<c:when test="${null==basez || null==basey}">
								<c:out value="${sgxt.cfd}"/>
							</c:when>
							<c:otherwise>
								<c:if test="${basez>basey}"> <c:out value="${sgxt.cfd-basey}"/></c:if>
								<c:if test="${basez==basey}"> <c:out value="${sgxt.cfd-basez}"/></c:if>
								<c:if test="${basez<basey}"><c:out value="${sgxt.cfd-basez}"/></c:if>
							</c:otherwise>
						</c:choose>
					</td>
                  </tr>
                  <tr>
                    <td><i>6</i></td>
                    <td>${sgxt.z6}</td>
                    <td>${sgxt.y6}</td>
                    <td><span class="r">${sgxt.cfd}</span></td>
                    <td>
						<c:set var="basez" scope="session" value="${sgxt.z6}"/>
						<c:set var="basey" scope="session" value="${sgxt.y6}"/>
						<c:choose>
							<c:when test="${null==basez || null==basey}">
								<c:out value="${sgxt.cfd}"/>
							</c:when>
							<c:otherwise>
								<c:if test="${basez>basey}"> <c:out value="${sgxt.cfd-basey}"/></c:if>
								<c:if test="${basez==basey}"> <c:out value="${sgxt.cfd-basez}"/></c:if>
								<c:if test="${basez<basey}"><c:out value="${sgxt.cfd-basez}"/></c:if>
							</c:otherwise>
						</c:choose>
					</td>
                  </tr>
                  <tr>
                    <td><i>7</i></td>
                    <td>${sgxt.z7}</td>
                    <td>${sgxt.y7}</td>
                    <td><span class="r">${sgxt.cfd}</span></td>
                    <td>
						<c:set var="basez" scope="session" value="${sgxt.z7}"/>
						<c:set var="basey" scope="session" value="${sgxt.y7}"/>
						<c:choose>
							<c:when test="${null==basez || null==basey}">
								<c:out value="${sgxt.cfd}"/>
							</c:when>
							<c:otherwise>
								<c:if test="${basez>basey}"> <c:out value="${sgxt.cfd-basey}"/></c:if>
								<c:if test="${basez==basey}"> <c:out value="${sgxt.cfd-basez}"/></c:if>
								<c:if test="${basez<basey}"><c:out value="${sgxt.cfd-basez}"/></c:if>
							</c:otherwise>
						</c:choose>
					</td>
                  </tr>
                  <tr>
                    <td><i>8</i></td>
                    <td>${sgxt.z8}</td>
                    <td>${sgxt.y8}</td>
                    <td><span class="r">${sgxt.cfd}</span></td>
                    <td>
						<c:set var="basez" scope="session" value="${sgxt.z8}"/>
						<c:set var="basey" scope="session" value="${sgxt.y8}"/>
						<c:choose>
							<c:when test="${null==basez || null==basey}">
								<c:out value="${sgxt.cfd}"/>
							</c:when>
							<c:otherwise>
								<c:if test="${basez>basey}"> <c:out value="${sgxt.cfd-basey}"/></c:if>
								<c:if test="${basez==basey}"> <c:out value="${sgxt.cfd-basez}"/></c:if>
								<c:if test="${basez<basey}"><c:out value="${sgxt.cfd-basez}"/></c:if>
							</c:otherwise>
						</c:choose>
					</td>
                  </tr>
                  <tr>
                    <td><i>9</i></td>
                    <td>${sgxt.z9}</td>
                    <td>${sgxt.y9}</td>
                    <td><span class="r">${sgxt.cfd}</span></td>
                    <td>
						<c:set var="basez" scope="session" value="${sgxt.z9}"/>
						<c:set var="basey" scope="session" value="${sgxt.y9}"/>
						<c:choose>
							<c:when test="${null==basez || null==basey}">
								<c:out value="${sgxt.cfd}"/>
							</c:when>
							<c:otherwise>
								<c:if test="${basez>basey}"> <c:out value="${sgxt.cfd-basey}"/></c:if>
								<c:if test="${basez==basey}"> <c:out value="${sgxt.cfd-basez}"/></c:if>
								<c:if test="${basez<basey}"><c:out value="${sgxt.cfd-basez}"/></c:if>
							</c:otherwise>
						</c:choose>
					</td>
                  </tr>
                  <tr>
                    <td><i>10</i></td>
                    <td>${sgxt.z10}</td>
                    <td>${sgxt.y10}</td>
                    <td><span class="r">${sgxt.cfd}</span></td>
                    <td>
						<c:set var="basez" scope="session" value="${sgxt.z10}"/>
						<c:set var="basey" scope="session" value="${sgxt.y10}"/>
						<c:choose>
							<c:when test="${null==basez || null==basey}">
								<c:out value="${sgxt.cfd}"/>
							</c:when>
							<c:otherwise>
								<c:if test="${basez>basey}"> <c:out value="${sgxt.cfd-basey}"/></c:if>
								<c:if test="${basez==basey}"> <c:out value="${sgxt.cfd-basez}"/></c:if>
								<c:if test="${basez<basey}"><c:out value="${sgxt.cfd-basez}"/></c:if>
							</c:otherwise>
						</c:choose>
					</td>
                  </tr>
                  <tr>
                    <td><i>11</i></td>
                   <td>${sgxt.z11}</td>
                    <td>${sgxt.y11}</td>
                    <td><span class="r">${sgxt.cfd}</span></td>
                    <td>
						<c:set var="basez" scope="session" value="${sgxt.z11}"/>
						<c:set var="basey" scope="session" value="${sgxt.y11}"/>
						<c:choose>
							<c:when test="${null==basez || null==basey}">
								<c:out value="${sgxt.cfd}"/>
							</c:when>
							<c:otherwise>
								<c:if test="${basez>basey}"> <c:out value="${sgxt.cfd-basey}"/></c:if>
								<c:if test="${basez==basey}"> <c:out value="${sgxt.cfd-basez}"/></c:if>
								<c:if test="${basez<basey}"><c:out value="${sgxt.cfd-basez}"/></c:if>
							</c:otherwise>
						</c:choose>
					</td>
                  </tr>
                  <tr>
                    <td><i>12</i></td>
                   <td>${sgxt.z12}</td>
                    <td>${sgxt.y12}</td>
                    <td><span class="r">${sgxt.cfd}</span></td>
                    <td>
						<c:set var="basez" scope="session" value="${sgxt.z12}"/>
						<c:set var="basey" scope="session" value="${sgxt.y12}"/>
						<c:choose>
							<c:when test="${null==basez || null==basey}">
								<c:out value="${sgxt.cfd}"/>
							</c:when>
							<c:otherwise>
								<c:if test="${basez>basey}"> <c:out value="${sgxt.cfd-basey}"/></c:if>
								<c:if test="${basez==basey}"> <c:out value="${sgxt.cfd-basez}"/></c:if>
								<c:if test="${basez<basey}"><c:out value="${sgxt.cfd-basez}"/></c:if>
							</c:otherwise>
						</c:choose>
					</td>
                  </tr>
                  <tr>
                    <td><i>13</i></td>
                    <td>${sgxt.z13}</td>
                    <td>${sgxt.y13}</td>
                    <td><span class="r">${sgxt.cfd}</span></td>
                    <td>
						<c:set var="basez" scope="session" value="${sgxt.z13}"/>
						<c:set var="basey" scope="session" value="${sgxt.y13}"/>
						<c:choose>
							<c:when test="${null==basez || null==basey}">
								<c:out value="${sgxt.cfd}"/>
							</c:when>
							<c:otherwise>
								<c:if test="${basez>basey}"> <c:out value="${sgxt.cfd-basey}"/></c:if>
								<c:if test="${basez==basey}"> <c:out value="${sgxt.cfd-basez}"/></c:if>
								<c:if test="${basez<basey}"><c:out value="${sgxt.cfd-basez}"/></c:if>
							</c:otherwise>
						</c:choose>
					</td>
                  </tr>
                  <tr>
                    <td><i>14</i></td>
                    <td>${sgxt.z14}</td>
                    <td>${sgxt.y14}</td>
                    <td><span class="r">${sgxt.cfd}</span></td>
                    <td>
						<c:set var="basez" scope="session" value="${sgxt.z14}"/>
						<c:set var="basey" scope="session" value="${sgxt.y14}"/>
						<c:choose>
							<c:when test="${null==basez || null==basey}">
								<c:out value="${sgxt.cfd}"/>
							</c:when>
							<c:otherwise>
								<c:if test="${basez>basey}"> <c:out value="${sgxt.cfd-basey}"/></c:if>
								<c:if test="${basez==basey}"> <c:out value="${sgxt.cfd-basez}"/></c:if>
								<c:if test="${basez<basey}"><c:out value="${sgxt.cfd-basez}"/></c:if>
							</c:otherwise>
						</c:choose>
					</td>
                  </tr>
                  <tr>
                    <td><i>15</i></td>
                    <td>${sgxt.z15}</td>
                    <td>${sgxt.y15}</td>
                    <td><span class="r">${sgxt.cfd}</span></td>
                    <td>
						<c:set var="basez" scope="session" value="${sgxt.z15}"/>
						<c:set var="basey" scope="session" value="${sgxt.y15}"/>
						<c:choose>
							<c:when test="${null==basez || null==basey}">
								<c:out value="${sgxt.cfd}"/>
							</c:when>
							<c:otherwise>
								<c:if test="${basez>basey}"> <c:out value="${sgxt.cfd-basey}"/></c:if>
								<c:if test="${basez==basey}"> <c:out value="${sgxt.cfd-basez}"/></c:if>
								<c:if test="${basez<basey}"><c:out value="${sgxt.cfd-basez}"/></c:if>
							</c:otherwise>
						</c:choose>
					</td>
                  </tr>
                  <tr>
                    <td><i>16</i></td>
                    <td>${sgxt.z16}</td>
                    <td>${sgxt.y16}</td>
                    <td><span class="r">${sgxt.cfd}</span></td>
                    <td>
						<c:set var="basez" scope="session" value="${sgxt.z16}"/>
						<c:set var="basey" scope="session" value="${sgxt.y16}"/>
						<c:choose>
							<c:when test="${null==basez || null==basey}">
								<c:out value="${sgxt.cfd}"/>
							</c:when>
							<c:otherwise>
								<c:if test="${basez>basey}"> <c:out value="${sgxt.cfd-basey}"/></c:if>
								<c:if test="${basez==basey}"> <c:out value="${sgxt.cfd-basez}"/></c:if>
								<c:if test="${basez<basey}"><c:out value="${sgxt.cfd-basez}"/></c:if>
							</c:otherwise>
						</c:choose>
					</td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
      <!-- <s:text name='viewlinks.html.links.html.865347806'/> end -->
    </div>
  </div>
</div>
</div>
<!-- 业绩查询内容 end -->
<script type="text/javascript" src="${ctx}/js/jquery.js"></script>
<script type="text/javascript" src="${ctx}/js/common.js"></script>
</body>

</html>
