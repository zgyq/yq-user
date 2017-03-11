function imgpreload(e,t){t instanceof Function&&(t={all:t}),"string"==typeof e&&(e=[e]);var i=[],n=e.length,a=0;for(a;a<n;a++){var o=new Image;o.onload=function(){i.push(this),t.each instanceof Function&&t.each.call(this),i.length>=n&&t.all instanceof Function&&t.all.call(i)},o.src=e[a]}}function setCookie(e,t,i){var n=getsec(i),a=new Date;a.setTime(a.getTime()+1*n),document.cookie=e+"="+escape(t)+";expires="+a.toGMTString()}function getsec(e){var t=1*e.substring(1,e.length),i=e.substring(0,1);return"s"==i?1e3*t:"h"==i?60*t*60*1e3:"d"==i?24*t*60*60*1e3:void 0}function getCookie(e){var t,i=new RegExp("(^| )"+e+"=([^;]*)(;|$)");return(t=document.cookie.match(i))?unescape(t[2]):null}function delCookie(e){var t=new Date;t.setTime(t.getTime()-1);var i=getCookie(e);null!=i&&(document.cookie=e+"="+i+";expires="+t.toGMTString())}function settime(e,t){var i=getCookie(cookiesName);i||(i=initWait,setCookie(cookiesName,i,"h1")),0==i?(e.removeAttr("disabled"),"en_US"==t&&e.val("get verification code"),"zh_CN"==t&&e.val("获取验证码"),e.val("获取验证码"),delCookie(cookiesName)):(e.attr("disabled","disabled"),"en_US"==t&&e.val(i+"seconds after the re-issued"),"zh_CN"==t&&e.val(i+"秒后可重发"),e.val(i+"秒后可重发"),i--,console.log(i),setCookie(cookiesName,i,"h1"),setTimeout(function(){settime(e,t)},1e3))}function btnStatus(e,t){if(e){var i=getCookie(cookiesName);null!=i&&i>0&&(e.attr("disabled","disabled"),"en_US"==t&&e.val(i+"seconds after the re-issued"),"zh_CN"==t&&e.val(i+"秒后可重发"),i--,setCookie(cookiesName,i,"h1"),setTimeout(function(){settime(e,t)},1e3))}}function hex_md5(e){return binl2hex(core_md5(str2binl(e),e.length*chrsz))}function b64_md5(e){return binl2b64(core_md5(str2binl(e),e.length*chrsz))}function str_md5(e){return binl2str(core_md5(str2binl(e),e.length*chrsz))}function hex_hmac_md5(e,t){return binl2hex(core_hmac_md5(e,t))}function b64_hmac_md5(e,t){return binl2b64(core_hmac_md5(e,t))}function str_hmac_md5(e,t){return binl2str(core_hmac_md5(e,t))}function md5_vm_test(){return"900150983cd24fb0d6963f7d28e17f72"==hex_md5("abc")}function core_md5(e,t){e[t>>5]|=128<<t%32,e[(t+64>>>9<<4)+14]=t;for(var i=1732584193,n=-271733879,a=-1732584194,o=271733878,r=0;r<e.length;r+=16){var s=i,l=n,c=a,d=o;i=md5_ff(i,n,a,o,e[r+0],7,-680876936),o=md5_ff(o,i,n,a,e[r+1],12,-389564586),a=md5_ff(a,o,i,n,e[r+2],17,606105819),n=md5_ff(n,a,o,i,e[r+3],22,-1044525330),i=md5_ff(i,n,a,o,e[r+4],7,-176418897),o=md5_ff(o,i,n,a,e[r+5],12,1200080426),a=md5_ff(a,o,i,n,e[r+6],17,-1473231341),n=md5_ff(n,a,o,i,e[r+7],22,-45705983),i=md5_ff(i,n,a,o,e[r+8],7,1770035416),o=md5_ff(o,i,n,a,e[r+9],12,-1958414417),a=md5_ff(a,o,i,n,e[r+10],17,-42063),n=md5_ff(n,a,o,i,e[r+11],22,-1990404162),i=md5_ff(i,n,a,o,e[r+12],7,1804603682),o=md5_ff(o,i,n,a,e[r+13],12,-40341101),a=md5_ff(a,o,i,n,e[r+14],17,-1502002290),n=md5_ff(n,a,o,i,e[r+15],22,1236535329),i=md5_gg(i,n,a,o,e[r+1],5,-165796510),o=md5_gg(o,i,n,a,e[r+6],9,-1069501632),a=md5_gg(a,o,i,n,e[r+11],14,643717713),n=md5_gg(n,a,o,i,e[r+0],20,-373897302),i=md5_gg(i,n,a,o,e[r+5],5,-701558691),o=md5_gg(o,i,n,a,e[r+10],9,38016083),a=md5_gg(a,o,i,n,e[r+15],14,-660478335),n=md5_gg(n,a,o,i,e[r+4],20,-405537848),i=md5_gg(i,n,a,o,e[r+9],5,568446438),o=md5_gg(o,i,n,a,e[r+14],9,-1019803690),a=md5_gg(a,o,i,n,e[r+3],14,-187363961),n=md5_gg(n,a,o,i,e[r+8],20,1163531501),i=md5_gg(i,n,a,o,e[r+13],5,-1444681467),o=md5_gg(o,i,n,a,e[r+2],9,-51403784),a=md5_gg(a,o,i,n,e[r+7],14,1735328473),n=md5_gg(n,a,o,i,e[r+12],20,-1926607734),i=md5_hh(i,n,a,o,e[r+5],4,-378558),o=md5_hh(o,i,n,a,e[r+8],11,-2022574463),a=md5_hh(a,o,i,n,e[r+11],16,1839030562),n=md5_hh(n,a,o,i,e[r+14],23,-35309556),i=md5_hh(i,n,a,o,e[r+1],4,-1530992060),o=md5_hh(o,i,n,a,e[r+4],11,1272893353),a=md5_hh(a,o,i,n,e[r+7],16,-155497632),n=md5_hh(n,a,o,i,e[r+10],23,-1094730640),i=md5_hh(i,n,a,o,e[r+13],4,681279174),o=md5_hh(o,i,n,a,e[r+0],11,-358537222),a=md5_hh(a,o,i,n,e[r+3],16,-722521979),n=md5_hh(n,a,o,i,e[r+6],23,76029189),i=md5_hh(i,n,a,o,e[r+9],4,-640364487),o=md5_hh(o,i,n,a,e[r+12],11,-421815835),a=md5_hh(a,o,i,n,e[r+15],16,530742520),n=md5_hh(n,a,o,i,e[r+2],23,-995338651),i=md5_ii(i,n,a,o,e[r+0],6,-198630844),o=md5_ii(o,i,n,a,e[r+7],10,1126891415),a=md5_ii(a,o,i,n,e[r+14],15,-1416354905),n=md5_ii(n,a,o,i,e[r+5],21,-57434055),i=md5_ii(i,n,a,o,e[r+12],6,1700485571),o=md5_ii(o,i,n,a,e[r+3],10,-1894986606),a=md5_ii(a,o,i,n,e[r+10],15,-1051523),n=md5_ii(n,a,o,i,e[r+1],21,-2054922799),i=md5_ii(i,n,a,o,e[r+8],6,1873313359),o=md5_ii(o,i,n,a,e[r+15],10,-30611744),a=md5_ii(a,o,i,n,e[r+6],15,-1560198380),n=md5_ii(n,a,o,i,e[r+13],21,1309151649),i=md5_ii(i,n,a,o,e[r+4],6,-145523070),o=md5_ii(o,i,n,a,e[r+11],10,-1120210379),a=md5_ii(a,o,i,n,e[r+2],15,718787259),n=md5_ii(n,a,o,i,e[r+9],21,-343485551),i=safe_add(i,s),n=safe_add(n,l),a=safe_add(a,c),o=safe_add(o,d)}return Array(n,a)}function md5_cmn(e,t,i,n,a,o){return safe_add(bit_rol(safe_add(safe_add(t,e),safe_add(n,o)),a),i)}function md5_ff(e,t,i,n,a,o,r){return md5_cmn(t&i|~t&n,e,t,a,o,r)}function md5_gg(e,t,i,n,a,o,r){return md5_cmn(t&n|i&~n,e,t,a,o,r)}function md5_hh(e,t,i,n,a,o,r){return md5_cmn(t^i^n,e,t,a,o,r)}function md5_ii(e,t,i,n,a,o,r){return md5_cmn(i^(t|~n),e,t,a,o,r)}function core_hmac_md5(e,t){var i=str2binl(e);i.length>16&&(i=core_md5(i,e.length*chrsz));for(var n=Array(16),a=Array(16),o=0;o<16;o++)n[o]=909522486^i[o],a[o]=1549556828^i[o];var r=core_md5(n.concat(str2binl(t)),512+t.length*chrsz);return core_md5(a.concat(r),640)}function safe_add(e,t){var i=(65535&e)+(65535&t),n=(e>>16)+(t>>16)+(i>>16);return n<<16|65535&i}function bit_rol(e,t){return e<<t|e>>>32-t}function str2binl(e){for(var t=Array(),i=(1<<chrsz)-1,n=0;n<e.length*chrsz;n+=chrsz)t[n>>5]|=(e.charCodeAt(n/chrsz)&i)<<n%32;return t}function binl2str(e){for(var t="",i=(1<<chrsz)-1,n=0;n<32*e.length;n+=chrsz)t+=String.fromCharCode(e[n>>5]>>>n%32&i);return t}function binl2hex(e){for(var t=hexcase?"0123456789ABCDEF":"0123456789abcdef",i="",n=0;n<4*e.length;n++)i+=t.charAt(e[n>>2]>>n%4*8+4&15)+t.charAt(e[n>>2]>>n%4*8&15);return i}function binl2b64(e){for(var t="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/",i="",n=0;n<4*e.length;n+=3)for(var a=(e[n>>2]>>8*(n%4)&255)<<16|(e[n+1>>2]>>8*((n+1)%4)&255)<<8|e[n+2>>2]>>8*((n+2)%4)&255,o=0;o<4;o++)i+=8*n+6*o>32*e.length?b64pad:t.charAt(a>>6*(3-o)&63);return i}function gotoPage(e){location.href="?toPage="+(e-1)}function openwindow2(e){window.open(e,"new","toolbar=no,scrollbars=yes,width=800,height=850")}function memberDialog(e){$(e).on("click",function(){var t=$(this),i=t.attr("data-url"),n={type:2,title:"",shadeClose:!0,shade:.8,area:["1000px","680px"],content:i,cancel:function(){window.parent.location.reload()}};switch(e){case".JQ_moreDialog":layer.open(n);break;case".JQ_goDialog":var a=$.extend({},n,{id:"J_newDialog",cancel:function(){}});layer.open(a);break;case".JQ_goSmallDialog":var a=$.extend({},n,{area:["580px","560px"]});layer.open(a)}})}function chkEbSaleSecondLogin(e){$.post("/login2j?status=1&inputUrl=login3j.jsp",e,function(e){var t=e.erroCodeNum;switch(t){case-2:location.replace("userpay?transferType=2");break;case-1:location.replace("userpay?transferType=1");break;case 1:alert("二级密码输入错误！请重新输入"),secondLoginForm.password3.focus();break;case 2:alert("您好，您同一姓名账号或同一身份证号码账号已发布成功过，请耐心等待处理完成后再发布第二笔，如果认购方已向您付款，请先确认收款再发布第二笔，谢谢!"),location.replace("epmcjl");break;case 3:alert("您好，一币商城的商家账户暂时不提供卖出功能，谢谢!");break;case 4:alert("您好，您的诚信星为+response.cxt+，离取消[限制发布]时间还有+response.days+天，谢谢!");break;case 5:alert("操作错误，请检查输入是否正确！");break;case 6:alert("请把收款方式改为“工商银行”或“农业银行”或“建设银行”再进行卖出操作！"),location.replace("dateuser")}})}function chkEbMarket(e){$.post("login2j?status=1",e,function(e){var t=e.erroCodeNum;return 0==t?void location.replace("epjysc"):(alert("二级密码输入错误！请重新输入!"),void secondLoginForm.password3.focus())})}function chkEbSaleDetail(e){$.post("login2j?status=1",e,function(e){var t=e.erroCodeNum;return 0==t?void location.replace("epmcjl"):(alert("二级密码输入错误！请重新输入!"),void secondLoginForm.password3.focus())})}function chkEbBuyDetail(e){$.post("login2j?status=1",e,function(e){var t=e.erroCodeNum;return 0==t?void location.replace("epmyjl"):(alert("二级密码输入错误！请重新输入!"),void secondLoginForm.password3.focus())})}function chkEbGoldBuy(e){$.post("login2j?status=1",e,function(e){var t=e.erroCodeNum;return 0==t?void location.replace("jztojb"):(alert("二级密码输入错误！请重新输入"),void secondLoginForm.password3.focus())})}function chkModifyUserInfo(e){$.post("login2j?status=1",e,function(e){var t=e.erroCodeNum;return 0==t?void location.replace("userga"):(alert("二级密码输入错误！请重新输入!"),void secondLoginForm.password3.focus())})}function chkGoldDetail(e){$.post("login2j?status=1",e,function(e){var t=e.erroCodeNum;return 0==t?void location.replace("gmjh"):(alert("二级密码输入错误！请重新输入"),void Form.password3.focus())})}"undefined"!=typeof jQuery&&!function(e){e.imgpreload=imgpreload,e.fn.imgpreload=function(t){t=e.extend({},e.fn.imgpreload.defaults,t instanceof Function?{all:t}:t),this.each(function(){var i=this;imgpreload(e(this).attr("src"),function(){t.each instanceof Function&&t.each.call(i)})});var i=[];this.each(function(){i.push(e(this).attr("src"))});var n=this;return imgpreload(i,function(){t.all instanceof Function&&t.all.call(n)}),this},e.fn.imgpreload.defaults={each:null,all:null}}(jQuery);var cookiesName="secondsremained",initWait=60,hexcase=0,b64pad="",chrsz=8;$(function(){function e(){function e(){var e=document.documentElement.scrollHeight||document.body.scrollHeight;e<u&&(d.style.height=h+"px")}if(document.getElementById("J_header"))var t=document.getElementById("J_header"),i=t.offsetHeight,n="1";else var n="0";if(document.getElementById("J_memberIndexTop"))var a=document.getElementById("J_memberIndexTop"),o=a.offsetHeight,r="1";else var r="0";if(document.getElementById("J_memberHeader"))var s=document.getElementById("J_memberHeader"),l=s.offsetHeight,c="1";else var c="0";if(document.getElementById("J_memberContent"))var d=document.getElementById("J_memberContent"),f=(d.offsetHeight,"1");else var f="0";var u=document.documentElement.clientHeight||document.body.clientHeight,m=n+r+c+f;switch(m){case"1101":var h=u-i-o-32;e();break;case"1011":var h=u-i-l-32;e();break;case"1001":var h=u-i-32;e()}}e(),window.onresize=e}),!function(e,t){"use strict";var i,n,a=e.layui&&layui.define,o={getPath:function(){var e=document.scripts,t=e[e.length-1],i=t.src;if(!t.getAttribute("merge"))return i.substring(0,i.lastIndexOf("/")+1)}(),config:{},end:{},minIndex:0,minLeft:[],btn:["&#x786E;&#x5B9A;","&#x53D6;&#x6D88;"],type:["dialog","page","iframe","loading","tips"]},r={v:"3.0.1",ie:function(){var t=navigator.userAgent.toLowerCase();return!!(e.ActiveXObject||"ActiveXObject"in e)&&((t.match(/msie\s(\d+)/)||[])[1]||"11")}(),index:e.layer&&e.layer.v?1e5:0,path:o.getPath,config:function(e,t){return e=e||{},r.cache=o.config=i.extend({},o.config,e),r.path=o.config.path||r.path,"string"==typeof e.extend&&(e.extend=[e.extend]),o.config.path&&r.ready(),e.extend?(a?layui.addcss("modules/layer/"+e.extend):r.link("skin/"+e.extend),this):this},link:function(t,n,a){if(r.path){var o=i("head")[0],s=document.createElement("link");"string"==typeof n&&(a=n);var l=(a||t).replace(/\.|\//g,""),c="layuicss-"+l,d=0;s.rel="stylesheet",s.href=r.path+t,s.id=c,i("#"+c)[0]||o.appendChild(s),"function"==typeof n&&!function t(){return++d>80?e.console&&console.error("layer.css: Invalid"):void(1989===parseInt(i("#"+c).css("width"))?n():setTimeout(t,100))}()}},ready:function(e){var t="skinlayercss",i="1110";return a?layui.addcss("modules/layer/default/layer.css?v="+r.v+i,e,t):r.link("skin/default/layer.css?v="+r.v+i,e,t),this},alert:function(e,t,n){var a="function"==typeof t;return a&&(n=t),r.open(i.extend({content:e,yes:n},a?{}:t))},confirm:function(e,t,n,a){var s="function"==typeof t;return s&&(a=n,n=t),r.open(i.extend({content:e,btn:o.btn,yes:n,btn2:a},s?{}:t))},msg:function(e,n,a){var s="function"==typeof n,c=o.config.skin,d=(c?c+" "+c+"-msg":"")||"layui-layer-msg",f=l.anim.length-1;return s&&(a=n),r.open(i.extend({content:e,time:3e3,shade:!1,skin:d,title:!1,closeBtn:!1,btn:!1,resize:!1,end:a},s&&!o.config.skin?{skin:d+" layui-layer-hui",anim:f}:function(){return n=n||{},(n.icon===-1||n.icon===t&&!o.config.skin)&&(n.skin=d+" "+(n.skin||"layui-layer-hui")),n}()))},load:function(e,t){return r.open(i.extend({type:3,icon:e||0,resize:!1,shade:.01},t))},tips:function(e,t,n){return r.open(i.extend({type:4,content:[e,t],closeBtn:!1,time:3e3,shade:!1,resize:!1,fixed:!1,maxWidth:210},n))}},s=function(e){var t=this;t.index=++r.index,t.config=i.extend({},t.config,o.config,e),document.body?t.creat():setTimeout(function(){t.creat()},50)};s.pt=s.prototype;var l=["layui-layer",".layui-layer-title",".layui-layer-main",".layui-layer-dialog","layui-layer-iframe","layui-layer-content","layui-layer-btn","layui-layer-close"];l.anim=["layer-anim","layer-anim-01","layer-anim-02","layer-anim-03","layer-anim-04","layer-anim-05","layer-anim-06"],s.pt.config={type:0,shade:.3,fixed:!0,move:l[1],title:"&#x4FE1;&#x606F;",offset:"auto",area:"auto",closeBtn:1,time:0,zIndex:19891014,maxWidth:360,anim:0,icon:-1,moveType:1,resize:!0,scrollbar:!0,tips:2},s.pt.vessel=function(e,t){var n=this,a=n.index,r=n.config,s=r.zIndex+a,c="object"==typeof r.title,d=r.maxmin&&(1===r.type||2===r.type),f=r.title?'<div class="layui-layer-title" style="'+(c?r.title[1]:"")+'">'+(c?r.title[0]:r.title)+"</div>":"";return r.zIndex=s,t([r.shade?'<div class="layui-layer-shade" id="layui-layer-shade'+a+'" times="'+a+'" style="'+("z-index:"+(s-1)+"; background-color:"+(r.shade[1]||"#000")+"; opacity:"+(r.shade[0]||r.shade)+"; filter:alpha(opacity="+(100*r.shade[0]||100*r.shade)+");")+'"></div>':"",'<div class="'+l[0]+(" layui-layer-"+o.type[r.type])+(0!=r.type&&2!=r.type||r.shade?"":" layui-layer-border")+" "+(r.skin||"")+'" id="'+l[0]+a+'" type="'+o.type[r.type]+'" times="'+a+'" showtime="'+r.time+'" conType="'+(e?"object":"string")+'" style="z-index: '+s+"; width:"+r.area[0]+";height:"+r.area[1]+(r.fixed?"":";position:absolute;")+'">'+(e&&2!=r.type?"":f)+'<div id="'+(r.id||"")+'" class="layui-layer-content'+(0==r.type&&r.icon!==-1?" layui-layer-padding":"")+(3==r.type?" layui-layer-loading"+r.icon:"")+'">'+(0==r.type&&r.icon!==-1?'<i class="layui-layer-ico layui-layer-ico'+r.icon+'"></i>':"")+(1==r.type&&e?"":r.content||"")+'</div><span class="layui-layer-setwin">'+function(){var e=d?'<a class="layui-layer-min" href="javascript:;"><cite></cite></a><a class="layui-layer-ico layui-layer-max" href="javascript:;"></a>':"";return r.closeBtn&&(e+='<a class="layui-layer-ico '+l[7]+" "+l[7]+(r.title?r.closeBtn:4==r.type?"1":"2")+'" href="javascript:;"></a>'),e}()+"</span>"+(r.btn?function(){var e="";"string"==typeof r.btn&&(r.btn=[r.btn]);for(var t=0,i=r.btn.length;t<i;t++)e+='<a class="'+l[6]+t+'">'+r.btn[t]+"</a>";return'<div class="'+l[6]+" layui-layer-btn-"+(r.btnAlign||"")+'">'+e+"</div>"}():"")+(r.resize?'<span class="layui-layer-resize"></span>':"")+"</div>"],f,i('<div class="layui-layer-move"></div>')),n},s.pt.creat=function(){var e=this,t=e.config,a=e.index,s=t.content,c="object"==typeof s,d=i("body");if(!i("#"+t.id)[0]){switch("string"==typeof t.area&&(t.area="auto"===t.area?["",""]:[t.area,""]),t.shift&&(t.anim=t.shift),6==r.ie&&(t.fixed=!1),t.type){case 0:t.btn="btn"in t?t.btn:o.btn[0],r.closeAll("dialog");break;case 2:var s=t.content=c?t.content:[t.content||"http://layer.layui.com","auto"];t.content='<iframe scrolling="'+(t.content[1]||"auto")+'" allowtransparency="true" id="'+l[4]+a+'" name="'+l[4]+a+'" onload="this.className=\'\';" class="layui-layer-load" frameborder="0" src="'+t.content[0]+'"></iframe>';break;case 3:delete t.title,delete t.closeBtn,t.icon===-1&&0===t.icon,r.closeAll("loading");break;case 4:c||(t.content=[t.content,"body"]),t.follow=t.content[1],t.content=t.content[0]+'<i class="layui-layer-TipsG"></i>',delete t.title,t.tips="object"==typeof t.tips?t.tips:[t.tips,!0],t.tipsMore||r.closeAll("tips")}e.vessel(c,function(n,r,f){d.append(n[0]),c?function(){2==t.type||4==t.type?function(){i("body").append(n[1])}():function(){s.parents("."+l[0])[0]||(s.data("display",s.css("display")).show().addClass("layui-layer-wrap").wrap(n[1]),i("#"+l[0]+a).find("."+l[5]).before(r))}()}():d.append(n[1]),i(".layui-layer-move")[0]||d.append(o.moveElem=f),e.layero=i("#"+l[0]+a),t.scrollbar||l.html.css("overflow","hidden").attr("layer-full",a)}).auto(a),2==t.type&&6==r.ie&&e.layero.find("iframe").attr("src",s[0]),4==t.type?e.tips():e.offset(),t.fixed&&n.on("resize",function(){e.offset(),(/^\d+%$/.test(t.area[0])||/^\d+%$/.test(t.area[1]))&&e.auto(a),4==t.type&&e.tips()}),t.time<=0||setTimeout(function(){r.close(e.index)},t.time),e.move().callback(),l.anim[t.anim]&&e.layero.addClass(l.anim[t.anim]).data("anim",!0)}},s.pt.auto=function(e){function t(e){e=s.find(e),e.height(c[1]-d-f-2*(0|parseFloat(e.css("padding"))))}var a=this,o=a.config,s=i("#"+l[0]+e);""===o.area[0]&&o.maxWidth>0&&(r.ie&&r.ie<8&&o.btn&&s.width(s.innerWidth()),s.outerWidth()>o.maxWidth&&s.width(o.maxWidth));var c=[s.innerWidth(),s.innerHeight()],d=s.find(l[1]).outerHeight()||0,f=s.find("."+l[6]).outerHeight()||0;switch(o.type){case 2:t("iframe");break;default:""===o.area[1]?o.fixed&&c[1]>=n.height()&&(c[1]=n.height(),t("."+l[5])):t("."+l[5])}return a},s.pt.offset=function(){var e=this,t=e.config,i=e.layero,a=[i.outerWidth(),i.outerHeight()],o="object"==typeof t.offset;e.offsetTop=(n.height()-a[1])/2,e.offsetLeft=(n.width()-a[0])/2,o?(e.offsetTop=t.offset[0],e.offsetLeft=t.offset[1]||e.offsetLeft):"auto"!==t.offset&&("t"===t.offset?e.offsetTop=0:"r"===t.offset?e.offsetLeft=n.width()-a[0]:"b"===t.offset?e.offsetTop=n.height()-a[1]:"l"===t.offset?e.offsetLeft=0:"lt"===t.offset?(e.offsetTop=0,e.offsetLeft=0):"lb"===t.offset?(e.offsetTop=n.height()-a[1],e.offsetLeft=0):"rt"===t.offset?(e.offsetTop=0,e.offsetLeft=n.width()-a[0]):"rb"===t.offset?(e.offsetTop=n.height()-a[1],e.offsetLeft=n.width()-a[0]):e.offsetTop=t.offset),t.fixed||(e.offsetTop=/%$/.test(e.offsetTop)?n.height()*parseFloat(e.offsetTop)/100:parseFloat(e.offsetTop),e.offsetLeft=/%$/.test(e.offsetLeft)?n.width()*parseFloat(e.offsetLeft)/100:parseFloat(e.offsetLeft),e.offsetTop+=n.scrollTop(),e.offsetLeft+=n.scrollLeft()),i.attr("minLeft")&&(e.offsetTop=n.height()-(i.find(l[1]).outerHeight()||0),e.offsetLeft=i.css("left")),i.css({top:e.offsetTop,left:e.offsetLeft})},s.pt.tips=function(){var e=this,t=e.config,a=e.layero,o=[a.outerWidth(),a.outerHeight()],r=i(t.follow);r[0]||(r=i("body"));var s={width:r.outerWidth(),height:r.outerHeight(),top:r.offset().top,left:r.offset().left},c=a.find(".layui-layer-TipsG"),d=t.tips[0];t.tips[1]||c.remove(),s.autoLeft=function(){s.left+o[0]-n.width()>0?(s.tipLeft=s.left+s.width-o[0],c.css({right:12,left:"auto"})):s.tipLeft=s.left},s.where=[function(){s.autoLeft(),s.tipTop=s.top-o[1]-10,c.removeClass("layui-layer-TipsB").addClass("layui-layer-TipsT").css("border-right-color",t.tips[1])},function(){s.tipLeft=s.left+s.width+10,s.tipTop=s.top,c.removeClass("layui-layer-TipsL").addClass("layui-layer-TipsR").css("border-bottom-color",t.tips[1])},function(){s.autoLeft(),s.tipTop=s.top+s.height+10,c.removeClass("layui-layer-TipsT").addClass("layui-layer-TipsB").css("border-right-color",t.tips[1])},function(){s.tipLeft=s.left-o[0]-10,s.tipTop=s.top,c.removeClass("layui-layer-TipsR").addClass("layui-layer-TipsL").css("border-bottom-color",t.tips[1])}],s.where[d-1](),1===d?s.top-(n.scrollTop()+o[1]+16)<0&&s.where[2]():2===d?n.width()-(s.left+s.width+o[0]+16)>0||s.where[3]():3===d?s.top-n.scrollTop()+s.height+o[1]+16-n.height()>0&&s.where[0]():4===d&&o[0]+16-s.left>0&&s.where[1](),a.find("."+l[5]).css({"background-color":t.tips[1],"padding-right":t.closeBtn?"30px":""}),a.css({left:s.tipLeft-(t.fixed?n.scrollLeft():0),top:s.tipTop-(t.fixed?n.scrollTop():0)})},s.pt.move=function(){var e=this,t=e.config,a=i(document),s=e.layero,l=s.find(t.move),c=s.find(".layui-layer-resize"),d={};return t.move&&l.css("cursor","move"),l.on("mousedown",function(e){e.preventDefault(),t.move&&(d.moveStart=!0,d.offset=[e.clientX-parseFloat(s.css("left")),e.clientY-parseFloat(s.css("top"))],o.moveElem.css("cursor","move").show())}),c.on("mousedown",function(e){e.preventDefault(),d.resizeStart=!0,d.offset=[e.clientX,e.clientY],d.area=[s.outerWidth(),s.outerHeight()],o.moveElem.css("cursor","se-resize").show()}),a.on("mousemove",function(i){if(d.moveStart){var a=i.clientX-d.offset[0],o=i.clientY-d.offset[1],l="fixed"===s.css("position");if(i.preventDefault(),d.stX=l?0:n.scrollLeft(),d.stY=l?0:n.scrollTop(),!t.moveOut){var c=n.width()-s.outerWidth()+d.stX,f=n.height()-s.outerHeight()+d.stY;a<d.stX&&(a=d.stX),a>c&&(a=c),o<d.stY&&(o=d.stY),o>f&&(o=f)}s.css({left:a,top:o})}if(t.resize&&d.resizeStart){var a=i.clientX-d.offset[0],o=i.clientY-d.offset[1];i.preventDefault(),r.style(e.index,{width:d.area[0]+a,height:d.area[1]+o}),d.isResize=!0}}).on("mouseup",function(e){d.moveStart&&(delete d.moveStart,o.moveElem.hide(),t.moveEnd&&t.moveEnd()),d.resizeStart&&(delete d.resizeStart,o.moveElem.hide())}),e},s.pt.callback=function(){function e(){var e=a.cancel&&a.cancel(t.index,n);e===!1||r.close(t.index)}var t=this,n=t.layero,a=t.config;t.openLayer(),a.success&&(2==a.type?n.find("iframe").on("load",function(){a.success(n,t.index)}):a.success(n,t.index)),6==r.ie&&t.IE6(n),n.find("."+l[6]).children("a").on("click",function(){var e=i(this).index();if(0===e)a.yes?a.yes(t.index,n):a.btn1?a.btn1(t.index,n):r.close(t.index);else{var o=a["btn"+(e+1)]&&a["btn"+(e+1)](t.index,n);o===!1||r.close(t.index)}}),n.find("."+l[7]).on("click",e),a.shadeClose&&i("#layui-layer-shade"+t.index).on("click",function(){r.close(t.index)}),n.find(".layui-layer-min").on("click",function(){var e=a.min&&a.min(n);e===!1||r.min(t.index,a)}),n.find(".layui-layer-max").on("click",function(){i(this).hasClass("layui-layer-maxmin")?(r.restore(t.index),a.restore&&a.restore(n)):(r.full(t.index,a),setTimeout(function(){a.full&&a.full(n)},100))}),a.end&&(o.end[t.index]=a.end)},o.reselect=function(){i.each(i("select"),function(e,t){var n=i(this);n.parents("."+l[0])[0]||1==n.attr("layer")&&i("."+l[0]).length<1&&n.removeAttr("layer").show(),n=null})},s.pt.IE6=function(e){i("select").each(function(e,t){var n=i(this);n.parents("."+l[0])[0]||"none"===n.css("display")||n.attr({layer:"1"}).hide(),n=null})},s.pt.openLayer=function(){var e=this;r.zIndex=e.config.zIndex,r.setTop=function(e){var t=function(){r.zIndex++,e.css("z-index",r.zIndex+1)};return r.zIndex=parseInt(e[0].style.zIndex),e.on("mousedown",t),r.zIndex}},o.record=function(e){var t=[e.width(),e.height(),e.position().top,e.position().left+parseFloat(e.css("margin-left"))];e.find(".layui-layer-max").addClass("layui-layer-maxmin"),e.attr({area:t})},o.rescollbar=function(e){l.html.attr("layer-full")==e&&(l.html[0].style.removeProperty?l.html[0].style.removeProperty("overflow"):l.html[0].style.removeAttribute("overflow"),l.html.removeAttr("layer-full"))},e.layer=r,r.getChildFrame=function(e,t){return t=t||i("."+l[4]).attr("times"),i("#"+l[0]+t).find("iframe").contents().find(e)},r.getFrameIndex=function(e){return i("#"+e).parents("."+l[4]).attr("times")},r.iframeAuto=function(e){if(e){var t=r.getChildFrame("html",e).outerHeight(),n=i("#"+l[0]+e),a=n.find(l[1]).outerHeight()||0,o=n.find("."+l[6]).outerHeight()||0;n.css({height:t+a+o}),n.find("iframe").css({height:t})}},r.iframeSrc=function(e,t){i("#"+l[0]+e).find("iframe").attr("src",t)},r.style=function(e,t,n){var a=i("#"+l[0]+e),r=a.find(".layui-layer-content"),s=a.attr("type"),c=a.find(l[1]).outerHeight()||0,d=a.find("."+l[6]).outerHeight()||0;a.attr("minLeft"),s!==o.type[3]&&s!==o.type[4]&&(n||(parseFloat(t.width)<=260&&(t.width=260),parseFloat(t.height)-c-d<=64&&(t.height=64+c+d)),a.css(t),d=a.find("."+l[6]).outerHeight(),s===o.type[2]?a.find("iframe").css({height:parseFloat(t.height)-c-d}):r.css({height:parseFloat(t.height)-c-d-parseFloat(r.css("padding-top"))-parseFloat(r.css("padding-bottom"))}))},r.min=function(e,t){var a=i("#"+l[0]+e),s=a.find(l[1]).outerHeight()||0,c=a.attr("minLeft")||181*o.minIndex+"px",d=a.css("position");o.record(a),o.minLeft[0]&&(c=o.minLeft[0],o.minLeft.shift()),a.attr("position",d),r.style(e,{width:180,height:s,left:c,top:n.height()-s,position:"fixed",overflow:"hidden"},!0),a.find(".layui-layer-min").hide(),"page"===a.attr("type")&&a.find(l[4]).hide(),o.rescollbar(e),a.attr("minLeft")||o.minIndex++,a.attr("minLeft",c)},r.restore=function(e){var t=i("#"+l[0]+e),n=t.attr("area").split(",");t.attr("type"),r.style(e,{width:parseFloat(n[0]),height:parseFloat(n[1]),top:parseFloat(n[2]),left:parseFloat(n[3]),position:t.attr("position"),overflow:"visible"},!0),t.find(".layui-layer-max").removeClass("layui-layer-maxmin"),t.find(".layui-layer-min").show(),"page"===t.attr("type")&&t.find(l[4]).show(),o.rescollbar(e)},r.full=function(e){var t,a=i("#"+l[0]+e);o.record(a),l.html.attr("layer-full")||l.html.css("overflow","hidden").attr("layer-full",e),clearTimeout(t),t=setTimeout(function(){var t="fixed"===a.css("position");r.style(e,{top:t?0:n.scrollTop(),left:t?0:n.scrollLeft(),width:n.width(),height:n.height()},!0),a.find(".layui-layer-min").hide()},100)},r.title=function(e,t){var n=i("#"+l[0]+(t||r.index)).find(l[1]);n.html(e)},r.close=function(e){var t=i("#"+l[0]+e),n=t.attr("type"),a="layer-anim-close";if(t[0]){var s="layui-layer-wrap",c=function(){if(n===o.type[1]&&"object"===t.attr("conType")){t.children(":not(."+l[5]+")").remove();for(var a=t.find("."+s),r=0;r<2;r++)a.unwrap();a.css("display",a.data("display")).removeClass(s)}else{if(n===o.type[2])try{var c=i("#"+l[4]+e)[0];c.contentWindow.document.write(""),c.contentWindow.close(),t.find("."+l[5])[0].removeChild(c)}catch(e){}t[0].innerHTML="",t.remove()}"function"==typeof o.end[e]&&o.end[e](),delete o.end[e]};t.data("anim")&&t.addClass(a),i("#layui-layer-moves, #layui-layer-shade"+e).remove(),6==r.ie&&o.reselect(),o.rescollbar(e),t.attr("minLeft")&&(o.minIndex--,o.minLeft.push(t.attr("minLeft"))),setTimeout(function(){c()},r.ie&&r.ie<10||!t.data("anim")?0:200)}},r.closeAll=function(e){i.each(i("."+l[0]),function(){var t=i(this),n=e?t.attr("type")===e:1;n&&r.close(t.attr("times")),n=null})};var c=r.cache||{},d=function(e){return c.skin?" "+c.skin+" "+c.skin+"-"+e:""};r.prompt=function(e,t){var a="";if(e=e||{},"function"==typeof e&&(t=e),e.area){var o=e.area;a='style="width: '+o[0]+"; height: "+o[1]+';"',delete e.area}var s,l=2==e.formType?'<textarea class="layui-layer-input"'+a+">"+(e.value||"")+"</textarea>":function(){return'<input type="'+(1==e.formType?"password":"text")+'" class="layui-layer-input" value="'+(e.value||"")+'">'}();return r.open(i.extend({type:1,btn:["&#x786E;&#x5B9A;","&#x53D6;&#x6D88;"],content:l,skin:"layui-layer-prompt"+d("prompt"),maxWidth:n.width(),success:function(e){s=e.find(".layui-layer-input"),s.focus()},resize:!1,yes:function(i){var n=s.val();""===n?s.focus():n.length>(e.maxlength||500)?r.tips("&#x6700;&#x591A;&#x8F93;&#x5165;"+(e.maxlength||500)+"&#x4E2A;&#x5B57;&#x6570;",s,{tips:1}):t&&t(n,i,s)}},e))},r.tab=function(e){e=e||{};var t=e.tab||{};return r.open(i.extend({type:1,skin:"layui-layer-tab"+d("tab"),resize:!1,title:function(){var e=t.length,i=1,n="";if(e>0)for(n='<span class="layui-layer-tabnow">'+t[0].title+"</span>";i<e;i++)n+="<span>"+t[i].title+"</span>";return n}(),content:'<ul class="layui-layer-tabmain">'+function(){var e=t.length,i=1,n="";if(e>0)for(n='<li class="layui-layer-tabli xubox_tab_layer">'+(t[0].content||"no content")+"</li>";i<e;i++)n+='<li class="layui-layer-tabli">'+(t[i].content||"no  content")+"</li>";return n}()+"</ul>",success:function(t){var n=t.find(".layui-layer-title").children(),a=t.find(".layui-layer-tabmain").children();n.on("mousedown",function(t){t.stopPropagation?t.stopPropagation():t.cancelBubble=!0;var n=i(this),o=n.index();n.addClass("layui-layer-tabnow").siblings().removeClass("layui-layer-tabnow"),a.eq(o).show().siblings().hide(),"function"==typeof e.change&&e.change(o)})}},e))},r.photos=function(t,n,a){function o(e,t,i){var n=new Image;return n.src=e,n.complete?t(n):(n.onload=function(){n.onload=null,t(n)},void(n.onerror=function(e){n.onerror=null,i(e)}))}var s={};if(t=t||{},t.photos){var l=t.photos.constructor===Object,c=l?t.photos:{},f=c.data||[],u=c.start||0;if(s.imgIndex=(0|u)+1,t.img=t.img||"img",l){if(0===f.length)return r.msg("&#x6CA1;&#x6709;&#x56FE;&#x7247;")}else{var m=i(t.photos),h=function(){f=[],m.find(t.img).each(function(e){var t=i(this);t.attr("layer-index",e),f.push({alt:t.attr("alt"),pid:t.attr("layer-pid"),src:t.attr("layer-src")||t.attr("src"),thumb:t.attr("src")})})};if(h(),0===f.length)return;if(n||m.on("click",t.img,function(){var e=i(this),n=e.attr("layer-index");r.photos(i.extend(t,{photos:{start:n,data:f,tab:t.tab},full:t.full}),!0),h()}),!n)return}s.imgprev=function(e){s.imgIndex--,s.imgIndex<1&&(s.imgIndex=f.length),s.tabimg(e)},s.imgnext=function(e,t){s.imgIndex++,s.imgIndex>f.length&&(s.imgIndex=1,t)||s.tabimg(e)},s.keyup=function(e){if(!s.end){var t=e.keyCode;e.preventDefault(),37===t?s.imgprev(!0):39===t?s.imgnext(!0):27===t&&r.close(s.index)}},s.tabimg=function(e){f.length<=1||(c.start=s.imgIndex-1,r.close(s.index),r.photos(t,!0,e))},s.event=function(){s.bigimg.hover(function(){s.imgsee.show()},function(){s.imgsee.hide()}),s.bigimg.find(".layui-layer-imgprev").on("click",function(e){e.preventDefault(),s.imgprev()}),s.bigimg.find(".layui-layer-imgnext").on("click",function(e){e.preventDefault(),s.imgnext()}),i(document).on("keyup",s.keyup)},s.loadi=r.load(1,{shade:!("shade"in t)&&.9,scrollbar:!1}),o(f[u].src,function(n){r.close(s.loadi),s.index=r.open(i.extend({type:1,area:function(){var a=[n.width,n.height],o=[i(e).width()-100,i(e).height()-100];if(!t.full&&(a[0]>o[0]||a[1]>o[1])){var r=[a[0]/o[0],a[1]/o[1]];r[0]>r[1]?(a[0]=a[0]/r[0],a[1]=a[1]/r[0]):r[0]<r[1]&&(a[0]=a[0]/r[1],a[1]=a[1]/r[1])}return[a[0]+"px",a[1]+"px"]}(),title:!1,shade:.9,shadeClose:!0,closeBtn:!1,move:".layui-layer-phimg img",moveType:1,scrollbar:!1,moveOut:!0,anim:5*Math.random()|0,skin:"layui-layer-photos"+d("photos"),content:'<div class="layui-layer-phimg"><img src="'+f[u].src+'" alt="'+(f[u].alt||"")+'" layer-pid="'+f[u].pid+'"><div class="layui-layer-imgsee">'+(f.length>1?'<span class="layui-layer-imguide"><a href="javascript:;" class="layui-layer-iconext layui-layer-imgprev"></a><a href="javascript:;" class="layui-layer-iconext layui-layer-imgnext"></a></span>':"")+'<div class="layui-layer-imgbar" style="display:'+(a?"block":"")+'"><span class="layui-layer-imgtit"><a href="javascript:;">'+(f[u].alt||"")+"</a><em>"+s.imgIndex+"/"+f.length+"</em></span></div></div></div>",success:function(e,i){s.bigimg=e.find(".layui-layer-phimg"),s.imgsee=e.find(".layui-layer-imguide,.layui-layer-imgbar"),s.event(e),t.tab&&t.tab(f[u],e)},end:function(){s.end=!0,i(document).off("keyup",s.keyup)}},t))},function(){r.close(s.loadi),r.msg("&#x5F53;&#x524D;&#x56FE;&#x7247;&#x5730;&#x5740;&#x5F02;&#x5E38;<br>&#x662F;&#x5426;&#x7EE7;&#x7EED;&#x67E5;&#x770B;&#x4E0B;&#x4E00;&#x5F20;&#xFF1F;",{time:3e4,btn:["&#x4E0B;&#x4E00;&#x5F20;","&#x4E0D;&#x770B;&#x4E86;"],yes:function(){f.length>1&&s.imgnext(!0,!0)}})})}},o.run=function(t){i=t,n=i(e),l.html=i("html"),r.open=function(e){var t=new s(e);return t.index}},e.layui&&layui.define?(r.ready(),layui.define("jquery",function(t){r.path=layui.cache.dir,o.run(layui.jquery),e.layer=r,t("layer",r)})):"function"==typeof define?define(["jquery"],function(){return o.run(e.jQuery),r}):function(){o.run(e.jQuery),r.ready()}()}(window),$("#J_headerSameNameIdSelect").on("click",function(){var e=$("#J_headerSameNameIdList");e.append('<div class="list-insaid" id="J_sameNameIdList"></div>');var t=layer.load(1,{shade:[.7,"#333"]}),i=$("#J_userName").html(),n=$("#J_sameNameIdList");$.ajax({url:"/getuserlist",type:"POST",data:i,dataType:"json",success:function(i){layer.close(t);for(var a=i.userList,o="",r=0;r<a.length;r++){var s=a[r].username,l=a[r].level;o+='<a class="item" href="/relogin?luserName='+s+'" title="'+s+"("+l+')"><span>'+s+"</span><em>("+l+")</em></a>"}n.html(o),e.show(),$("body").append('<p class="select-id-mark JQ_selectIdListMark"></p>'),
$(document).on("click",".JQ_selectIdListMark",function(){$("#J_headerSameNameIdList").html(""),console.log($("#J_headerSameNameIdList").html()),$("#J_headerSameNameIdList").hide(),$(".JQ_selectIdListMark").remove()})},error:function(){alert("连接错误，请手动刷新页面"),console.log("传输失败")}})}),$(document).on("click","#J_headerSameNameIdList li",function(){var e=$(this).html();console.log(e),location.replace("/relogin?luserName="+e)}),$(function(){function e(){var e=$(".JQ_navSecondary li");e.each(function(){var e=$(this);e.on("mouseover",function(){t.mouseenter(e)}),e.on("mouseout",function(){t.mouseout(e)}),e.on("touchend",function(i){t.touchend(e)})});var t={mouseenter:function(e){e.addClass("on")},mouseout:function(e){e.removeClass("on")},touchend:function(e){$(".JQ_navThirdMark").remove(),e.addClass("on"),e.find(".JQ_navThirdList").addClass("show"),$("body").append('<p class="nav-third-mark JQ_navThirdMark"></p>'),$(".JQ_navThirdMark").on("touchend",function(){$(this).remove(),e.removeClass("on"),e.find(".JQ_navThirdList").removeClass("show")})}}}e()}),$(function(){memberDialog(".JQ_moreDialog"),memberDialog(".JQ_goDialog")}),$(function(){$(".JQ_secondLoginBtn").on("click",function(){if(""==secondLoginForm.password3.value)return alert("二级密码不能为空"),secondLoginForm.password3.focus(),!1;var e=($(this),$("#J_secondLoginForm").serialize()),t=window.location.search;switch(t){case"?inputUrl=login3j.jsp":chkEbSaleSecondLogin(e);break;case"?inputUrl=login8j.jsp":chkEbMarket(e);break;case"?inputUrl=loginmc.jsp":chkEbSaleDetail(e);break;case"?inputUrl=loginmy.jsp":chkEbBuyDetail(e);break;case"?inputUrl=login5j.jsp":chkEbGoldBuy(e);break;case"?inputUrl=login2j.jsp":chkModifyUserInfo(e);break;case"?inputUrl=login6j.jsp":chkGoldDetail(e)}return!0})});