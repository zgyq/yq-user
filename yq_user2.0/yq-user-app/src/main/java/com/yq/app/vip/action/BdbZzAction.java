package com.yq.app.vip.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.google.common.base.Strings;
import com.sr178.game.framework.context.ServiceCacheFactory;
import com.yq.common.action.ALDAdminActionSupport;
import com.yq.user.bo.Gcuser;
import com.yq.user.service.UserService;

public class BdbZzAction extends ALDAdminActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int status;
	
	private int jzpay;
	
	private String pa3;
	
	private String syuser;
	
	private int sybdb;
	
	private Gcuser farenUser;
	
	private Gcuser gcuser;
	
	private String smsCode;
	
	private String inputUrl;
	public String execute(){
		UserService userService = ServiceCacheFactory.getServiceCache().getService(UserService.class);
		HttpSession sessionhttp = ServletActionContext.getRequest().getSession();
		HttpServletRequest request=ServletActionContext.getRequest();
		gcuser = userService.getUserByUserName(super.getUserName());
		if(gcuser.getVip()==2){
			farenUser = userService.getUserByUserName(userService.getUserProperty(super.getUserName()).getFaren());
			if(farenUser==null){
				super.setErroCodeNum(2002);
				return SUCCESS;
			}
			if(!Strings.isNullOrEmpty(farenUser.getCall())){
				int callLenght = farenUser.getCall().length();
				String callLeft = farenUser.getCall().substring(0, 3);
				String CallRight = farenUser.getCall().substring(callLenght-3, callLenght);
				farenUser.setCall(callLeft+"*****"+CallRight);
			}
		}
		
		if(!Strings.isNullOrEmpty(gcuser.getCall())){
			int callLenght = gcuser.getCall().length();
			String callLeft = gcuser.getCall().substring(0, 3);
			String CallRight = gcuser.getCall().substring(callLenght-3, callLenght);
			gcuser.setCall(callLeft+"*****"+CallRight);
		}
		String vipuserSession = userService.isHasVipToken(sessionhttp.getId());
		if(vipuserSession==null || !vipuserSession.equals(super.getUserName())){
			inputUrl= request.getRequestURI();
			super.setErroCodeNum(2005);
			return SUCCESS;
		}
		
		if(status==1){
			/*if(gcuser.getVip()==2){
				farenUser = userService.getUserByUserName(userService.getUserProperty(super.getUserName()).getFaren());
				if(farenUser!=null){
					if(!farenUser.getVipsq().equals(smsCode)){
						super.setErroCodeNum(2001);
						return SUCCESS;
					}
				}else{
					super.setErroCodeNum(2002);
					return SUCCESS;
				}
			}else{
				if(!smsCode.equals(gcuser.getVipsq())){
					super.setErroCodeNum(2001);
					return SUCCESS;
				}
			}*/
			userService.trasferBdb(super.getUserName(), syuser, jzpay,pa3,farenUser);
			super.setErroCodeNum(2000);
			return  SUCCESS;
		}else{
			
			sybdb = gcuser.getSybdb();
			if(gcuser.getVip()==0){
				super.setErroCodeNum(1);
				return SUCCESS;
			}
		}
		return SUCCESS;
	}
	
	//报单币充值
	private Gcuser czgcuser;
	private String touser;
	public String bdbcz(){
//		super.setErroCodeNum(9);
//		return SUCCESS;
		UserService userService = ServiceCacheFactory.getServiceCache().getService(UserService.class);
		HttpSession sessionhttp = ServletActionContext.getRequest().getSession();
		HttpServletRequest request=ServletActionContext.getRequest();
		gcuser = userService.getUserByUserName(super.getUserName());
		if(gcuser.getVip()==2){
			farenUser = userService.getUserByUserName(userService.getUserProperty(super.getUserName()).getFaren());
			if(farenUser==null){
				super.setErroCodeNum(2002);
				return SUCCESS;
			}
			if(!Strings.isNullOrEmpty(farenUser.getCall())){
				int callLenght = farenUser.getCall().length();
				String callLeft = farenUser.getCall().substring(0, 3);
				String CallRight = farenUser.getCall().substring(callLenght-3, callLenght);
				farenUser.setCall(callLeft+"*****"+CallRight);
			}
		}
		
		if(!Strings.isNullOrEmpty(gcuser.getCall())){
			int callLenght = gcuser.getCall().length();
			String callLeft = gcuser.getCall().substring(0, 3);
			String CallRight = gcuser.getCall().substring(callLenght-3, callLenght);
			gcuser.setCall(callLeft+"*****"+CallRight);
		}
		
		String vipuserSession = userService.isHasVipToken(sessionhttp.getId());
		if(vipuserSession==null || !vipuserSession.equals(super.getUserName())){
			inputUrl= request.getRequestURI();
			super.setErroCodeNum(2005);
			return SUCCESS;
		}
		
		if(status==1){
			userService.chargeBdbByBigVip(super.getUserName(),pa3,touser);
			super.setErroCodeNum(2000);
			return SUCCESS;
			
		}else{
			czgcuser = userService.getUserByUserName(super.getUserName());
			if(czgcuser.getVip()!=2){
				super.setErroCodeNum(1);
				super.setErroDescrip("只有大vip才能使用此功能");
				return SUCCESS;
			}
		}
		return SUCCESS;
	}

	
	
	public String getInputUrl() {
		return inputUrl;
	}



	public void setInputUrl(String inputUrl) {
		this.inputUrl = inputUrl;
	}



	public Gcuser getGcuser() {
		return gcuser;
	}


	public void setGcuser(Gcuser gcuser) {
		this.gcuser = gcuser;
	}


	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getJzpay() {
		return jzpay;
	}

	public void setJzpay(int jzpay) {
		this.jzpay = jzpay;
	}

	public String getPa3() {
		return pa3;
	}

	public void setPa3(String pa3) {
		this.pa3 = pa3;
	}

	public String getSyuser() {
		return syuser;
	}

	public void setSyuser(String syuser) {
		this.syuser = syuser;
	}

	public int getSybdb() {
		return sybdb;
	}

	public void setSybdb(int sybdb) {
		this.sybdb = sybdb;
	}

	public Gcuser getCzgcuser() {
		return czgcuser;
	}

	public void setCzgcuser(Gcuser czgcuser) {
		this.czgcuser = czgcuser;
	}

	public String getTouser() {
		return touser;
	}

	public void setTouser(String touser) {
		this.touser = touser;
	}

	public Gcuser getFarenUser() {
		return farenUser;
	}

	public void setFarenUser(Gcuser farenUser) {
		this.farenUser = farenUser;
	}

	public String getSmsCode() {
		return smsCode;
	}

	public void setSmsCode(String smsCode) {
		this.smsCode = smsCode;
	}
	public String getErroDescrip() {
		return super.getErroDescrip();
	}
	public int getErroCodeNum() {
		return super.getErroCodeNum();
	}
}