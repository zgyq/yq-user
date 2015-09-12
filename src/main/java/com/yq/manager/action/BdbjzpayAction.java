package com.yq.manager.action;

import com.sr178.game.framework.context.ServiceCacheFactory;
import com.yq.common.action.ALDAdminActionSupport;
import com.yq.user.service.UserService;

public class BdbjzpayAction extends ALDAdminActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int status;
	
	private String jcname;
	private String syuser;
	private int jzpay;
	
	
	public String execute(){
		if(status==0){
			return INPUT;
		}
		UserService userService  = ServiceCacheFactory.getService(UserService.class);
		userService.trasferBdbByAdmin(jcname, syuser, jzpay);
		super.setErroCodeNum(2000);
		return SUCCESS;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public String getJcname() {
		return jcname;
	}


	public void setJcname(String jcname) {
		this.jcname = jcname;
	}


	public String getSyuser() {
		return syuser;
	}


	public void setSyuser(String syuser) {
		this.syuser = syuser;
	}


	public int getJzpay() {
		return jzpay;
	}


	public void setJzpay(int jzpay) {
		this.jzpay = jzpay;
	}

}
