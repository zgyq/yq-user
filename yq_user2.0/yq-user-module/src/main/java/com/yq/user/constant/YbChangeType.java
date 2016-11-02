package com.yq.user.constant;

public class YbChangeType {

	public static final int AGENT_REDUCE 		= 1000;		//第三方代理商减少
	
	
	public static final int MALL_BUY_RATION 	= 1001;		//商城买家缴纳的税
	
	public static final int MALL_SALE_RATION 	= 1002;		//商城卖家缴纳的税
	
	public static final int SHOP_TEMP 			= 1003;		//商城卖家临时存放的钱
	
	
	public static final int SHOP_SALE_ADD 		= 1004;		//商城卖家卖出商品获得yb
	
	public static final int SHOP_SALE_ADD_SELF 	= 1005;		//商城卖家卖出商品获得yb  zxz888自己商家卖出商品
	
	public static final int TRANSFER_TO_BDB = 1006;        //大vip转成备用报单币
	
	
	public static final int SHOP_TEMP_REDUCE 	= 2001;		//商城临时账号转账给商家货物YB数
	
	public static final int ADMIN_ORDER_CANCEL 	= 2007;		//管理员撤销获得
	
	public static final int ADMIN_ORDER_RESET 	= 2008;		//管理员重置订单
}
