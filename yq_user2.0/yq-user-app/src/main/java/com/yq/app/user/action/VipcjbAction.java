package com.yq.app.user.action;

import com.google.common.base.Strings;
import com.sr178.game.framework.context.ServiceCacheFactory;
import com.yq.common.action.ALDAdminPageActionSupport;
import com.yq.user.bo.Gcuser;
import com.yq.user.bo.Vipcjgl;
import com.yq.user.service.UserService;

public class VipcjbAction extends ALDAdminPageActionSupport<Vipcjgl> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Gcuser gcuser;
	private int status;
	private Gcuser farenUser;
	private String smsCode;
	
	public String execute(){
		UserService userService = ServiceCacheFactory.getService(UserService.class);
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
		
		super.initPage(userService.getVipcjbPageList(super.getUserName(), super.getToPage(), 10));
		if(status==1){
			return "cjbdetail";
		}
		return SUCCESS;
	}
	
	private String cjuser;
	private int cjpay;
	private String cjpass;
	public String cj(){
		UserService userService = ServiceCacheFactory.getService(UserService.class);
		gcuser = userService.getUserByUserName(super.getUserName());
		if(gcuser.getVip()==2){
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
		}
		userService.vipCj(super.getUserName(), cjuser, cjpay, cjpass,farenUser);
		super.setErroCodeNum(2000);;
		return SUCCESS;
	}
	
	public String vipcjbcjbdetail(){
		UserService userService = ServiceCacheFactory.getService(UserService.class);
		gcuser = userService.getUserByUserName(super.getUserName());
		super.initPage(userService.getVipcjbPageList(super.getUserName(), super.getToPage(), 20));
		return "cjbdetail";
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

	public int getStatus() {
		return status;
	}



	public void setStatus(int status) {
		this.status = status;
	}



	public Gcuser getGcuser() {
		return gcuser;
	}

	public void setGcuser(Gcuser gcuser) {
		this.gcuser = gcuser;
	}

	public String getCjuser() {
		return cjuser;
	}

	public void setCjuser(String cjuser) {
		this.cjuser = cjuser;
	}

	public int getCjpay() {
		return cjpay;
	}

	public void setCjpay(int cjpay) {
		this.cjpay = cjpay;
	}

	public String getCjpass() {
		return cjpass;
	}

	public void setCjpass(String cjpass) {
		this.cjpass = cjpass;
	}
	
	
}
