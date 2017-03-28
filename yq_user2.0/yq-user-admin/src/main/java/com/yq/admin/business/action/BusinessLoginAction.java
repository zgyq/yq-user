package com.yq.admin.business.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.google.common.base.Strings;
import com.sr178.game.framework.context.ServiceCacheFactory;
import com.yq.business.service.BusinessService;
import com.yq.common.action.ALDAdminActionSupport;

public class BusinessLoginAction extends ALDAdminActionSupport {
	
	
	private static final long serialVersionUID = 1L;
	
	
		private String adminUserName;
		private String passWord;
		private String validCode;
		private int status;
		
		
		public String execute(){
			if(status==0){
				return SUCCESS;
			}
			BusinessService businessService = ServiceCacheFactory.getServiceCache().getService(BusinessService.class);
			HttpSession sessionhttp = ServletActionContext.getRequest().getSession();
			String rand = (String) sessionhttp.getAttribute("rand");
			if(Strings.isNullOrEmpty(validCode)){
				super.setErroCodeNum(399);
				super.setErroDescrip("验证码不能为空！");
				return SUCCESS;
			}
			if(Strings.isNullOrEmpty(rand)){
				super.setErroCodeNum(400);
				super.setErroDescrip("验证码过期,请点击刷新！");
				return SUCCESS;
			}
			if(!rand.equals(validCode)){
				super.setErroCodeNum(401);
				super.setErroDescrip("验证码不正确！");
				return SUCCESS;
			}
			
			if(businessService.businessUserLogin(adminUserName, passWord, sessionhttp, ServletActionContext.getRequest().getRemoteAddr())){
				return "redirect";
			}else{
				super.setErroCodeNum(402);
				super.setErroDescrip("用户名或密码错误！");
				return SUCCESS;
			}
			
		}


		public String getAdminUserName() {
			return adminUserName;
		}


		public void setAdminUserName(String adminUserName) {
			this.adminUserName = adminUserName;
		}


		public String getPassWord() {
			return passWord;
		}

		public void setPassWord(String passWord) {
			this.passWord = passWord;
		}

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}


		public String getValidCode() {
			return validCode;
		}


		public void setValidCode(String validCode) {
			this.validCode = validCode;
		}


	

}