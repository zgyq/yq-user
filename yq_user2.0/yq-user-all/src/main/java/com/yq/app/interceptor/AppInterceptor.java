package com.yq.app.interceptor;


import java.util.Map;


import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.sr178.game.framework.context.ServiceCacheFactory;
import com.sr178.game.framework.exception.ServiceException;
import com.sr178.game.framework.log.LogSystem;
import com.sr178.module.web.interceptor.BaseInterceptor;
import com.yq.app.action.AppBaseActionSupport;
import com.yq.app.service.AppService;

public class AppInterceptor extends BaseInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		AppBaseActionSupport appAction = null;
		Object obj = actionInvocation.getAction();
		String className = obj.getClass().getCanonicalName();
		if (obj instanceof AppBaseActionSupport) {
			appAction = (AppBaseActionSupport) obj;
		} else {
			throw new RuntimeException("ACTION继承的类非AppBaseActionSupport"+className);
		}
		
		AppService aus = ServiceCacheFactory.getServiceCache()
				.getService(AppService.class);
		Map<String,Object> map = actionInvocation.getInvocationContext().getParameters();
		Object values = map.get("tokenId");
		String tokenId = values==null?null:((String[])values)[0];
		String userName = aus.isLogin(tokenId);
		ServletActionContext.getResponse().setHeader("Access-Control-Allow-Origin", "*");
		if (userName==null&&!className.equals("com.yq.app.action.AppNoAuthAction")) {
			appAction.renderErrorResult("token失效或没有登录");
			return "json";
		} else {
			appAction.setLoginUser(userName);
			// 异常处理
			try {
				String result = actionInvocation.invoke();
				return result;
			} catch (Exception e) {
				if(e instanceof ServiceException){
					ServiceException exception = (ServiceException)e;
					appAction.renderErrorResult(exception.getCode(), exception.getMessage());
					LogSystem.info(super.getMsgTag()+"[userName]=["+userName+"]"+exception.getMessage());
					return AppBaseActionSupport.JSON;
				}else{
					LogSystem.error(e, super.getMsgTag()+"[userName]=["+userName+"]");
					appAction.renderErrorResult("未知错误！");
					return AppBaseActionSupport.JSON;
				}
			}
		}
	}
}
