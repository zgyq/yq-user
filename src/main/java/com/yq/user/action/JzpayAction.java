package com.yq.user.action;

import com.sr178.game.framework.context.ServiceCacheFactory;
import com.yq.common.action.ALDAdminActionSupport;
import com.yq.user.bo.Gcuser;
import com.yq.user.service.UserService;

public class JzpayAction extends ALDAdminActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Gcuser gcuser;
	
	private int status;
	
	private String fromUser;
	
	private String jzuser;//接收用户名
	
	private int jzpay;//转入金额
	
	private String pa3;//二级密码
	
	private String dbz;//订单号
	
	private String yy;
	
	private double ration;
	
	private int jb;
	
	public String execute(){
		UserService userService = ServiceCacheFactory.getServiceCache().getService(UserService.class);
		gcuser = userService.getUserByUserName(super.getUserName());
		if(!super.getUserName().equals("300fhk")&&!super.getUserName().equals("zxz888")){
			super.setErroCodeNum(7);
			return SUCCESS;
		}
		if(status==1){
			userService.mallBack(fromUser, jzuser, pa3, jzpay, dbz,yy,ration);
			super.setErroCodeNum(2000);
		}
		
		return SUCCESS;
	}
	
	
	public String backScores(){
		UserService userService = ServiceCacheFactory.getServiceCache().getService(UserService.class);
		gcuser = userService.getUserByUserName(super.getUserName());
		if(!super.getUserName().equals("zxz888")){
			super.setErroCodeNum(3001);
			return SUCCESS;
		}
		if(status==1){
			userService.mallBackScores(fromUser, jzuser, pa3, jzpay, dbz,yy);
			super.setErroCodeNum(2000);
		}
		
		return SUCCESS;
	}
	
	
	public String setForMall(){
		if(!super.getUserName().equals("zxz888")){
			super.setErroCodeNum(3001);
			return SUCCESS;
		}
		UserService userService = ServiceCacheFactory.getServiceCache().getService(UserService.class);
		if(!userService.setToMaller(fromUser,jb,super.ip())){
			super.setErroCodeNum(1);
		}
		return SUCCESS;
	}
	
	
	public String getFromUser() {
		return fromUser;
	}
	public int getErroCodeNum() {
		return super.getErroCodeNum();
	}

	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}


	public int getJb() {
		return jb;
	}


	public void setJb(int jb) {
		this.jb = jb;
	}


	public double getRation() {
		return ration;
	}


	public void setRation(double ration) {
		this.ration = ration;
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
	public String getJzuser() {
		return jzuser;
	}
	public void setJzuser(String jzuser) {
		this.jzuser = jzuser;
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
	public String getDbz() {
		return dbz;
	}
	public void setDbz(String dbz) {
		this.dbz = dbz;
	}
	public String getYy() {
		return yy;
	}
	public void setYy(String yy) {
		this.yy = yy;
	}
}
