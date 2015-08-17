package com.yq.user.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.sr178.common.jdbc.bean.IPage;
import com.sr178.game.framework.context.ServiceCacheFactory;
import com.yq.common.ProblemCode;
import com.yq.common.exception.ServiceException;
import com.yq.common.utils.DateUtils;
import com.yq.common.utils.IDCardUtils;
import com.yq.common.utils.MD5Security;
import com.yq.user.bo.Bdbdate;
import com.yq.user.bo.Cpuser;
import com.yq.user.bo.Datecj;
import com.yq.user.bo.Datepay;
import com.yq.user.bo.Ejbk;
import com.yq.user.bo.Epkjdate;
import com.yq.user.bo.Fcxt;
import com.yq.user.bo.Gcuser;
import com.yq.user.bo.Gpjy;
import com.yq.user.bo.Jbk10;
import com.yq.user.bo.Jbk100;
import com.yq.user.bo.Jbk300;
import com.yq.user.bo.Jbk50;
import com.yq.user.bo.Jbk500;
import com.yq.user.bo.Jfcp;
import com.yq.user.bo.Jfkjdate;
import com.yq.user.bo.Province;
import com.yq.user.bo.Sgxt;
import com.yq.user.bo.Txifok;
import com.yq.user.bo.Txpay;
import com.yq.user.bo.YouMingxi;
import com.yq.user.bo.ZuoMingxi;
import com.yq.user.dao.BdbDateDao;
import com.yq.user.dao.CpuserDao;
import com.yq.user.dao.DatePayDao;
import com.yq.user.dao.DatecjDao;
import com.yq.user.dao.DateipDao;
import com.yq.user.dao.EjbkDao;
import com.yq.user.dao.EptzbDao;
import com.yq.user.dao.GcuserDao;
import com.yq.user.dao.GpjyDao;
import com.yq.user.dao.JbkDao;
import com.yq.user.dao.JfcpDao;
import com.yq.user.dao.JftzbDao;
import com.yq.user.dao.ProvinceDao;
import com.yq.user.dao.SgxtDao;
import com.yq.user.dao.TduserDao;
import com.yq.user.dao.TxPayDao;
import com.yq.user.dao.TxifokDao;
import com.yq.user.dao.VipxtgcDao;
import com.yq.user.dao.YouMingXiDao;
import com.yq.user.dao.ZuoMingxiDao;

public class UserService {
	
    @Autowired
	private GcuserDao gcuserDao;
    @Autowired
    private TduserDao tduserDao;
    @Autowired
    private ProvinceDao provinceDao;
    @Autowired
    private TxifokDao txifokDao;
    @Autowired
    private DateipDao dateipDao;
    @Autowired
    private ZuoMingxiDao zuoMingxiDao;
    @Autowired
    private YouMingXiDao youMingXiDao;
    @Autowired
    private SgxtDao sgxtDao;
    @Autowired
    private BdbDateDao bdbDateDao; 
    @Autowired
    private VipxtgcDao vipxtgcDao; 
    @Autowired
    private EptzbDao eptzbDao;
    @Autowired
    private LogService logService;
    @Autowired
    private ManagerService managerService;
    @Autowired
    private JfcpDao jfcpDao;
    @Autowired
    private CpuserDao cpuserDao;
    @Autowired
    private TxPayDao txPayDao;
    @Autowired
    private DatePayDao datePayDao;
    @Autowired
    private GpjyDao gpjyDao;
    @Autowired
    private EjbkDao ejbkDao;
    @Autowired
    private DatecjDao datecjDao;
    @Autowired
    private JbkDao jdbDao;
    @Autowired
    private JftzbDao jftzbDao;

    
    Map<String,String> userSession = new ConcurrentHashMap<String,String>();
    
    /**
     * 查看是否登录了
     * @param sessionId
     * @return
     */
    public String isLogin(String sessionId){
    	return userSession.get(sessionId);
    }
    
    
    
	/**
	 * 登录
	 * @param sessionId
	 * @param userName
	 * @param pwd
	 * @return
	 */
    @ProblemCode
	public Gcuser login(String sessionId,String userName,String pwd,String ip){
    	/**
    	 * checkindex.asp中这段代码没看懂
    	 * Dim allName
			allName=ygid
			Call CalculateQ(allName,ygid)
			Function CalculateQ(allName,userName)
				set rs_Calculate = Server.CreateObject("ADODB.Recordset")
				sql_Calculate = "SELECT * FROM gcuser where username = '"&userName&"'"
				rs_Calculate.open sql_Calculate,conn2,1,1
				
				If rs_Calculate.eof Or rs_Calculate.bof Then
				rs_Calculate.close()
				'Response.write "没有数据<br>"
				Exit Function
				End If
				if rs_Calculate("username")=userName Then
				if rs_Calculate("vip")>0 Then
				allName=rs_Calculate("username")
				Exit Function
				End if
				Call CalculateQ(allName,rs_Calculate("up"))
			    rs_Calculate.close()
				Else
				rs_Calculate.close()
				'Response.write "错误的逻辑<br>"
				Exit Function'错误的逻辑
				End if
				
			End Function
			
						<%
			response.cookies("regid")=rs_login("username")
			response.cookies("password")=rs_login("password")
			ygid=request.cookies("regid")
			ygpa=request.cookies("password")
			rs_login("vipname")=allName
			rs_login("logtime")=Now()
			rs_login.update
			rs_login.close
			conn2.close
			set conn2=nothing
			response.redirect "/vgo/vipdl.asp?dl="&ygid&"&pa="&ygpa&""
			'response.redirect "manager.asp"
			%>
    	 */
    	
		Gcuser gcUser = gcuserDao.getUser(userName);
		String md5pass = MD5Security.md5_16(pwd).toLowerCase();
		//登录成功
		if(gcUser!=null && gcUser.getPassword().equals(md5pass)){
			userSession.put(sessionId, gcUser.getUsername());
			gcuserDao.updateLoginTime(userName);
			this.addUserDateIpLog(userName, "登录", ip);
			return gcUser;
		}
		return null;
	}
	
    
    /**
     * 登出
     * @param sessionId
     * @return
     */
    public boolean logout(String sessionId){
    	String userName = userSession.remove(sessionId);
    	return dateipDao.updateLogout(userName);
    }
    
	/**
	 * 注册
	 * @param gguser
	 * @param upvip
	 * @param ggname
	 * @param gguserid
	 * @param ggpa1
	 * @param ggpa3
	 * @param ggbank
	 * @param ggcard
	 * @param ggcall
	 * @param ggqq
	 * @param provinceName
	 * @param cityName
	 * @param areaName
	 * @return
	 */
	public int reg(String gguser,String upvip,String ggname,String gguserid,String ggpa1,String ggpa3,String ggbank,String ggcard,String ggcall,String ggqq,String provinceName,String cityName,String areaName){
		if(getUserByUserName(gguser)!=null){
			return 1;//用户已存在
		}
		if(!Strings.isNullOrEmpty(upvip)&&getUserByUserName(upvip)==null){
			return 2;//推荐人不存在
		}
		List<Gcuser> list = getUserByIdCard(ggname, gguserid);
		if(list!=null&&list.size()>0){
			return 3;// 该姓名["&request.Form("ggname")&"]及身份证号码["&Request.Form("gguserid")&"]已经被注册过，请您登录后在-[业务查询]下-[添加同名账户]！
		}
		if(!IDCardUtils.IDCardValidate(gguserid).equals("")){
			return 4;//身份证号码无效
		}
		if(isForbidNameOrID(ggname, gguserid)){
			return 5;//禁用账号
		}
		if(Strings.isNullOrEmpty(provinceName)||provinceName.equals("0")||Strings.isNullOrEmpty(cityName)||cityName.equals("0")||Strings.isNullOrEmpty(areaName)||areaName.equals("0")){
			return 6;//所在地区不全！请重新选择！
		}
		Province province = provinceDao.getProvinceByB(provinceName);
		Gcuser user = new Gcuser();
		user.setUsername(gguser);
		user.setPassword(MD5Security.md5_16(ggpa1).toLowerCase());
		user.setPassword3(ggpa3);
		user.setName(ggname);
		user.setBank(ggbank);
		user.setCard(ggcard);
		user.setCall(ggcall);
		user.setQq(ggqq);
		user.setUp(upvip);
		user.setUserid(gguserid);
		user.setAddsheng(provinceName);
		user.setAddshi(cityName);
		user.setAddqu(areaName);
		user.setRegtime(new Date());
		
		if(province!=null){
			user.setAddqu(province.getAreaNum());
			user.setAdd9dqu(province.getAreaName());
		}
		if(!gcuserDao.addUser(user)){
			return 7;//注册失败
		}
		//也不知道这是什么日志  反正先添加进去再说
		Txifok txifok = new Txifok();
		txifok.setUsername(gguser);
		txifok.setUp(upvip);
		txifok.setPassword3(ggpa3);
		txifok.setName(ggname);
		txifok.setCall(ggcall);
		txifokDao.add(txifok);
		return 0;
	}
	
	/**
	 * 注册同名账号
	 * @param newUserName
	 * @param oldUserName
	 */
	public void regTheSameUser(String newUserName,String oldUserName){
		
		if(gcuserDao.getUser(newUserName)!=null){
			throw new ServiceException(1, "此用户名已有人使用！请更换！");
		}
		
		Gcuser oldUser = gcuserDao.getUser(oldUserName);
		
		Gcuser user = new Gcuser();
		user.setUsername(newUserName);
		user.setPassword(oldUser.getPassword());
		user.setPassword3(oldUser.getPassword3());
		user.setName(oldUser.getName());
		user.setBank(oldUser.getBank());
		user.setCard(oldUser.getCard());
		user.setCall(oldUser.getCall());
		user.setQq(oldUser.getQq());
		user.setUp(oldUserName);
		user.setUserid(oldUser.getUserid());
		user.setAddsheng(oldUser.getAddsheng());
		user.setAddshi(oldUser.getAddshi());
		user.setAddqu(oldUser.getAddqu());
		user.setRegtime(new Date());
		user.setAddqu(oldUser.getAddqu());
		user.setAdd9dqu(oldUser.getAdd9dqu());
		
		gcuserDao.addUser(user);
		
		Txifok txifok = new Txifok();
		txifok.setUsername(newUserName);
		txifok.setUp(oldUserName);
		txifok.setPassword3(user.getPassword3());
		txifok.setName(user.getName());
		txifok.setCall(user.getCall());
		txifokDao.add(txifok);
		
	}
	
	
	
	/**
	 * 更新用户信息
	 * @param userName
	 * @param idCard
	 * @param password
	 * @param password3
	 * @param ganew
	 * @param qq
	 * @param call
	 * @return
	 */
	public boolean updateUser(String userName,String name, String idCard, String password, String password3, int ganew, String qq,String  call,String ip){
		boolean result =  gcuserDao.updateUser(name, idCard, password, password3, ganew, qq, call);
		if(result){
			addUserDateIpLog(userName, "更新资料", ip);
		}
		return result;
	}
	
	
	public boolean updateUser(String userName,String name, String idCard, String password,  String card, String bank,String  addsheng,String addshi,String addqu,String ip){
		boolean result =  gcuserDao.updateUser(name, idCard, password, card, bank, addsheng, addshi, addqu);
		if(result){
			addUserDateIpLog(userName, "更新资料", ip);
		}
		return result;
	}
	
	
	public boolean updateUser(String userName,String jdName,String jcUserId){
		return gcuserDao.updateUser(userName, jdName, jcUserId);
	}
	/**
	 * 根据用户名获取用户信息
	 * @param userName
	 * @return
	 */
	public Gcuser getUserByUserName(String userName){
		return gcuserDao.getUser(userName);
	}
	
	/**
	 * 根据真实名称及身份证号码获取用户信息
	 * @param name
	 * @param idNum
	 * @return
	 */
	public List<Gcuser> getUserByIdCard(String name,String idNum){
		return gcuserDao.getUserByIdCard(name, idNum);
	}
	/**
	 * 是否禁用账号
	 * @param name
	 * @param idNum
	 * @return
	 */
	public boolean isForbidNameOrID(String name,String idNum){
		if(tduserDao.get(name, idNum)!=null){
			return true;
		}
		return false;
	}
	/**
	 * 添加插入日志
	 * @param userName
	 * @param desc
	 * @param ip
	 * @return
	 */
	public boolean addUserDateIpLog(String userName,String desc,String ip){
		return dateipDao.addDateIpLog(userName, desc, ip);
	}
	
	/**
	 * 获取同名账户
	 * @param name
	 * @param idCard
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public IPage<Gcuser> getTheSameNameUserPage(String name,String idCard,int pageIndex,int pageSize){
		return gcuserDao.getUserPage(name, idCard, pageIndex, pageSize);
	}
	/**
	 * 获取同名账户
	 * @param name
	 * @param idCard
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public IPage<Gcuser> getTheSameNameUserPageByCondition(String userName,String name,String idCard,int pageIndex,int pageSize){
		return gcuserDao.getUserPageByCondition(userName,name, idCard, pageIndex, pageSize);
	}
	/**
	 * 改变yb
	 * @param username
	 * @param changeNum
	 * @return
	 */
	public boolean changeYb(String username,int changeNum,String desc,int newzBz,Integer kjqi){
		boolean result = false;
		if(changeNum<0){
			result = gcuserDao.reduceYb(username, changeNum*-1);
			if(result){
				Gcuser gcuser = gcuserDao.getUser(username);
				Datepay datePay = new Datepay();
				datePay.setUsername(username);
				datePay.setJc(changeNum*-1);
				datePay.setPay(gcuser.getPay());
				datePay.setJydb(gcuser.getJydb());
				datePay.setRegid(desc);
				datePay.setNewbz(newzBz);
				if(kjqi!=null){
					datePay.setKjqi(kjqi);
				}
				datePay.setAbdate(new Date());
				logService.addDatePay(datePay);
			}
			return result;
		}else if(changeNum>0){
			result = gcuserDao.addYb(username, changeNum);
			if(result){
				Gcuser gcuser = gcuserDao.getUser(username);
				Datepay datePay = new Datepay();
				datePay.setUsername(gcuser.getUsername());
				datePay.setSyjz(changeNum);
				datePay.setPay(gcuser.getPay());
				datePay.setJydb(gcuser.getJydb());
				datePay.setRegid(desc);
				datePay.setNewbz(newzBz);
				datePay.setAbdate(new Date());
				logService.addDatePay(datePay);
			}
			return result;
		}
		return true;
	}
	
	
	public ZuoMingxi getZuoMingxi(String tjuser,String down){
		return zuoMingxiDao.get(tjuser, down);
	}
	public ZuoMingxi getZuoMingxi(String down){
		return zuoMingxiDao.get(down);
	}
	public YouMingxi getYouMingxi(String tjuser,String down){
		return youMingXiDao.get(tjuser, down);
	}
	
	public YouMingxi getYouMingxi(String down){
		return youMingXiDao.get(down);
	}
	
	public Sgxt getSgxt(String username){
		return sgxtDao.get(username);
	}
	
	public Sgxt getSgxtByAorBuid(String uid){
		return sgxtDao.getByAOrBuid(uid);
	}
	
	public int getSumSjb(String name,String idNum){
		return gcuserDao.getSumSjb(name, idNum);
	}
	
	/**
	 * 绑定用户
	 * @param userName  操作者用户id
	 * @param up        接点用户id
	 * @param bduser    被绑定用户id
	 * @param cjpay     绑定的业务类型
	 * @param pa1j      登录密码
	 * @param pa2j      二级密码
	 * @param idCardNum 身份证号码
	 * @param status    0 确认绑定   1提交绑定
	 * @return
	 */
    @Transactional
	public String bdReg(String userName,String up,String bduser,int cjpay,String pa1j,String pa2j,String idCardNum,int status){
		ManagerService managerService = ServiceCacheFactory.getServiceCache().getService(ManagerService.class);
		Fcxt fcxt = managerService.getFcxtById(2);
		if(fcxt!=null){
			Date date = fcxt.getJsdate();
			if(date!=null&&new Date().getTime()>date.getTime()){
				throw new ServiceException(1,"结算期间暂停开户，明天开放！");
//				super.setErroCodeNum(1);//alert('结算期间暂停开户，明天开放！');;history.go(-1);
//				return SUCCESS;
			}
		}
		if(cjpay<1000){
			throw new ServiceException(2,"选择报单金额错误，无法完成开户，请充值后再试！");
//			super.setErroCodeNum(2);//alert('选择报单金额错误，无法完成开户，请充值后再试！');history.go(-1);
//			return SUCCESS;
		}
		
		Gcuser operatorUser = gcuserDao.getUser(userName);
		
		if(!MD5Security.md5_16(pa1j).equals(operatorUser.getPassword())){
			throw new ServiceException(3,"登录密码错误，请检查输入是否正确！");
//			super.setErroCodeNum(3);//alert('登录密码错误，请检查输入是否正确！');history.go(-1);
//			return SUCCESS;
		}
		if(!pa2j.equals(operatorUser.getPassword3())){
			throw new ServiceException(4,"二级密码错误，请检查输入是否正确！");
//			super.setErroCodeNum(4);//alert('二级密码错误，请检查输入是否正确！');history.go(-1);
//			return SUCCESS;
		}
		if(operatorUser.getSjb()==0){
			throw new ServiceException(5,"此功能，需联系推荐人选择适合的位置升级！！");
//			super.setErroCodeNum(5);//alert('此功能，需联系推荐人选择适合的位置升级！！');history.go(-1);
//			return SUCCESS;
		}
		if(cjpay>9000 && operatorUser.getSybdb()<cjpay){
			throw new ServiceException(6,"报单币余额小于开户金额"+cjpay+"，无法完成开户，请充值后再试！");
//			super.setErroCodeNum(6);//alert('报单币余额小于开户金额"&cjpay&"，无法完成开户，请充值后再试！');history.go(-1);
//			return SUCCESS;			
		}
		
		if(cjpay<9000 && operatorUser.getPay()<cjpay){
			throw new ServiceException(7,"一币余额小于开户金额"+cjpay+"，无法完成开户，请充值后再试！");
//			super.setErroCodeNum(7);//alert('一币余额小于开户金额"&cjpay&"，无法完成开户，请充值后再试！');history.go(-1);
//			return SUCCESS;			
		}
		
		int callLenght = operatorUser.getCall().length();
		String callLeft = operatorUser.getCall().substring(0, 3);
		String CallRight = operatorUser.getCall().substring(callLenght-3, callLenght);
		String call = callLeft+"*****"+CallRight;
		
		UserService userService = ServiceCacheFactory.getServiceCache().getService(UserService.class);
        Gcuser bdGUser = gcuserDao.getUser(bduser);
		Fcxt fcxt2 = managerService.getFcxtById(10);
        if(bdGUser==null){
        	throw new ServiceException(8,"要开户的用户名不存在，请检查输入是否正确！");
//			super.setErroCodeNum(8);//alert('要开户的用户名不存在，请检查输入是否正确！');history.go(-1);
//			return SUCCESS;		
        }else if(bdGUser.getRegtime().getTime()<fcxt2.getJsdate().getTime()){
        	throw new ServiceException(9,"系统调试中，请重新注册新的用户名进行操作或联系您的推荐人！");
//			super.setErroCodeNum(9);//alert('系统调试中，请重新注册新的用户名进行操作或联系您的推荐人！');history.go(-1);
//			return SUCCESS;		        	
        }
		
        
        if(cjpay>49980){
        	int sumSjb = userService.getSumSjb(bdGUser.getName(), bdGUser.getUserid());
        	if(sumSjb>298){
        		throw new ServiceException(10,"该姓名持有5万的账户已达到3个，不能再开设5万的账户！");
//    			super.setErroCodeNum(10);//alert('该姓名持有5万的账户已达到3个，不能再开设5万的账户！');history.go(-1);
//    			return SUCCESS;		 
        	}
        }
        
        if(userService.getZuoMingxi(bduser)!=null||userService.getYouMingxi(bduser)!=null){
        	throw new ServiceException(11,"开户人已安置好，不能重复，请检查输入是否正确！");
//			super.setErroCodeNum(11);//alert('开户人已安置好，不能重复，请检查输入是否正确！');history.go(-1);
//			return SUCCESS;		
        }
		

        if(userService.getSgxtByAorBuid(bduser)!=null){
        	throw new ServiceException(12,"开户人已安置好，不能重复，请检查输入是否正确！");
//			super.setErroCodeNum(12);//alert('开户人已安置好，不能重复，请检查输入是否正确！');history.go(-1);
//			return SUCCESS;	
        }else if(!bduser.equals(operatorUser.getUsername())&&!bdGUser.getUp().equals(operatorUser.getUsername())){
        	throw new ServiceException(13,"只能给自己的直接推荐的人开户！");
//			super.setErroCodeNum(13);//alert('只能给自己的直接推荐的人开户！');history.go(-1);
//			return SUCCESS;	
        }
        
		Sgxt tuser = userService.getSgxt(up);
		if(tuser==null){
			throw new ServiceException(14,"接点人不存在，没法放置，请检查是否正确！");
//			super.setErroCodeNum(14);//alert('接点人不存在，没法放置，请检查是否正确！');history.go(-1);
//			return SUCCESS;
		}else{
			if(!Strings.isNullOrEmpty(tuser.getAuid())&&!Strings.isNullOrEmpty(tuser.getBuid())){
				throw new ServiceException(15,"接点人位置已被占用，请重新选择！");
//				super.setErroCodeNum(15);//alert('接点人位置已被占用，请重新选择！');history.go(-1);
//				return SUCCESS;
			}
		}
		
		
		if(status!=0){//确认操作
			int zjjb=0;
			int sjb=0;
			int fd=0;
			int cfd=0;
			if(cjpay==500){
				   zjjb=200;
						   sjb=1;
						   fd=2000;
						   cfd=20;
			}else if(cjpay==1000){
				   zjjb=450;
						   sjb=2;
						   fd=4000;
						   cfd=40		;		
			}else if(cjpay==2000){
				   zjjb=960;
						   sjb=4;
						   fd=8000;
						   cfd=60	;			
			}else if(cjpay==5000){
				   zjjb=2500;
						   sjb=10;
						   fd=20000;
						   cfd=80;				
			}else if(cjpay==10000){
				   zjjb=5000;
						   sjb=20;
						   fd=40000;
						   cfd=100	;			
			}else if(cjpay==20000){
				   zjjb=11000;
						   sjb=40;
						   fd=80000;
						   cfd=150	;			
			}else if(cjpay==50000){
				   zjjb=30000;
						   sjb=100;
						   fd=200000;
						   cfd=200	;			
			}
			
			if(!idCardNum.equals(operatorUser.getVipsq())){
				throw new ServiceException(16,"验证码错误，请检查输入是否正确！");
//					super.setErroCodeNum(16);//alert('验证码错误，请检查输入是否正确！');history.go(-1);
//					return SUCCESS;
			}
			
			if(cjpay>9000){//使用报单币开户
				if(!updateSybdb(userName, -cjpay, "给"+bduser+"开户"+cjpay)){
					throw new ServiceException(6,"报单币余额小于开户金额"+cjpay+"，无法完成开户，请充值后再试！");
				}
			}else{
				if(!this.changeYb(userName, -cjpay, "给"+bduser+"开户"+cjpay, 0,null)){
					throw new ServiceException(7,"一币余额小于开户金额"+cjpay+"，无法完成开户，请充值后再试！");
				}
			}
			//修改被绑定用户金币及单数
			gcuserDao.updateSjb(bduser, sjb);
			updateJB(bduser,zjjb,"消费"+cjpay+"送"+zjjb+"金币-"+userName+"");
			
			
			if(Strings.isNullOrEmpty(tuser.getAuid())){
				sgxtDao.updateAuid(tuser.getUsername(), bduser);
			}else{
				sgxtDao.updateBuid(tuser.getUsername(), bduser);
			}
			
//			int jszfh=0;
			int jsnew = 0;
//			double fhbl = 0;
			if(sjb>10){
//			   jszfh=sjb*250;
			   jsnew=3;
//			   fhbl=0.005;
			}else{
//			   jszfh=0;
			   jsnew=0;
//			   fhbl=0;
			}
			
			Sgxt sgxt = new Sgxt();
			sgxt.setUsername(bduser);
			sgxt.setSjb(sjb);
			sgxt.setXxnew(jsnew);
			sgxt.setFdpay(fd);
			sgxt.setCfd(cfd);
			sgxtDao.add(sgxt);
			
			//给接点人加钱
			int upPay = (int)(0.1*cjpay);
			gcuserDao.addOtherYb(up,upPay);
			Gcuser upuser = gcuserDao.getUser(up);
			Datepay datePay = new Datepay();
			datePay.setUsername(up);
			datePay.setRegid("用户一"+bduser+"开户"+cjpay+"");
			datePay.setSyjz(upPay);
			datePay.setPay(upuser.getPay());
			datePay.setJydb(upuser.getJydb());
			datePay.setNewbz(9);
			datePay.setAbdate(new Date());
			logService.addDatePay(datePay);
			
			
			int zysjb = sgxt.getSjb();
			
			
			cupUser(bduser,1,zysjb);//不知道他在干嘛
			
			
			List<ZuoMingxi> zList = zuoMingxiDao.getDownList(bduser);
			if(zList!=null&&!zList.isEmpty()){
				for(ZuoMingxi zuoMingxi:zList){
					int sjtjzb = zuoMingxiDao.getSumSjb(zuoMingxi.getTjuser(), zuoMingxi.getCount());
					if(sjtjzb>0){
						if(zuoMingxi.getCount()>0&&zuoMingxi.getCount()<=16){
							sgxtDao.updateZfiled(userName, "z"+zuoMingxi.getCount(), sjtjzb,sjtjzb-sjb,zuoMingxi.getCount());
						}
					}
				}
			}
			
			List<YouMingxi> yList = youMingXiDao.getDownList(bduser);
			if(yList!=null&&!yList.isEmpty()){
				for(YouMingxi youMingxi:yList){
					int sjtjzb = youMingXiDao.getSumSjb(youMingxi.getTjuser(), youMingxi.getCount());
					if(sjtjzb>0){
						if(youMingxi.getCount()>0&&youMingxi.getCount()<=16){
							sgxtDao.updateZfiled(userName, "y"+youMingxi.getCount(), sjtjzb,sjtjzb-sjb,youMingxi.getCount());
						}
					}
				}
			}
			CalculateQ(bduser,sjb,bduser);
		}
		return call;
	}
	
	
	private void CalculateQ(String userName,int sjb,String bduser){
		Sgxt sgxtBd = sgxtDao.getByAOrBuid(userName);
		if(sgxtBd==null){
			return;
		}
		if(sgxtBd.getAuid().equals(userName)){
			sgxtDao.updateZaq(userName, sjb);
			int zyzj = 0;
			if(sgxtBd.getDqzuo()<sgxtBd.getCfd()){
				 zyzj = sgxtBd.getCfd()-sgxtBd.getDqzuo();
				 sgxtDao.updateAq(userName, zyzj);
				 Bdbdate bdbdate = new Bdbdate();
				 bdbdate.setZuser(sgxtBd.getUsername());
				 bdbdate.setZaq(sgxtBd.getZaq());
				 bdbdate.setZbq(sgxtBd.getZbq());
				 bdbdate.setAq(sgxtBd.getAq());
				 bdbdate.setBq(sgxtBd.getBq());
				if(sjb>zyzj){
					 bdbdate.setBz("新单"+bduser+"("+sjb+")在第"+sgxtBd.getCount()+"层(左边)层封顶超出-"+(sjb-zyzj));
				}else{
					 bdbdate.setBz("新单"+bduser+"("+sjb+")在第"+sgxtBd.getCount()+"层(左边)增加可结算-"+zyzj);
				}
				bdbDateDao.add(bdbdate);
			}else{
				 Bdbdate bdbdate = new Bdbdate();
				 bdbdate.setZuser(sgxtBd.getUsername());
				 bdbdate.setZaq(sgxtBd.getZaq());
				 bdbdate.setZbq(sgxtBd.getZbq());
				 bdbdate.setAq(sgxtBd.getAq());
				 bdbdate.setBq(sgxtBd.getBq());
				 bdbdate.setBz("新单"+bduser+"("+sjb+")在第"+sgxtBd.getCount()+"层(左边)已层封顶-无效单");
				 bdbDateDao.add(bdbdate);
			}
			CalculateQ(sgxtBd.getUsername(),sjb,bduser);
		}else if(sgxtBd.getBuid().equals(userName)){
			sgxtDao.updateZbq(userName, sjb);
			if(sgxtBd.getDqyou()<sgxtBd.getCfd()){
				int yyzj=sgxtBd.getCfd()-sgxtBd.getDqyou();
				 Bdbdate bdbdate = new Bdbdate();
				 bdbdate.setZuser(sgxtBd.getUsername());
				 bdbdate.setZaq(sgxtBd.getZaq());
				 bdbdate.setZbq(sgxtBd.getZbq());
				 bdbdate.setAq(sgxtBd.getAq());
				 bdbdate.setBq(sgxtBd.getBq());
				 if(sjb>yyzj){
					 bdbdate.setBz("新单"+bduser+"("+sjb+")在第"+sgxtBd.getCount()+"层(右边)层封顶超出-"+(sjb-yyzj));
				 }else{
					 bdbdate.setBz("新单"+bduser+"("+sjb+")在第"+sgxtBd.getCount()+"层(右边)增加可结算-"+yyzj);
				 }
				 bdbDateDao.add(bdbdate);
			}else{
				 Bdbdate bdbdate = new Bdbdate();
				 bdbdate.setZuser(sgxtBd.getUsername());
				 bdbdate.setZaq(sgxtBd.getZaq());
				 bdbdate.setZbq(sgxtBd.getZbq());
				 bdbdate.setAq(sgxtBd.getAq());
				 bdbdate.setBq(sgxtBd.getBq());
				 bdbdate.setBz("新单"+bduser+"("+sjb+")在第"+sgxtBd.getCount()+"层(右边)已层封顶-无效单");
				 bdbDateDao.add(bdbdate);
			}
			CalculateQ(sgxtBd.getUsername(),sjb,bduser);
		}
	}
	
	private void cupUser(String userName,int count,int sjb){
		Sgxt sgxtBd = sgxtDao.getByAOrBuid(userName);
		if(sgxtBd!=null){
			if(userName.equals(sgxtBd.getAuid())){
				ZuoMingxi zuoMingxi = new ZuoMingxi();
				zuoMingxi.setTjuser(sgxtBd.getUsername());
				zuoMingxi.setSjb(sjb);
				zuoMingxi.setDown(userName);
				zuoMingxi.setCount(count);
				zuoMingxiDao.add(zuoMingxi);
			}else{
				YouMingxi youMingxi = new YouMingxi();
				youMingxi.setCount(count);
				youMingxi.setDown(userName);
				youMingxi.setTjuser(sgxtBd.getUsername());
				youMingxi.setSjb(sjb);
				youMingXiDao.add(youMingxi);
			}
			count = count+1;
			cupUser(sgxtBd.getUsername(),count,sjb);
		}
	}
	
	/**
	 * 更新报单币
	 * @param userName
	 * @param changeNum
	 * @param desc
	 * @return
	 */
	public boolean updateSybdb(String userName,int changeNum,String desc){
		if(changeNum>=0){
			boolean result = gcuserDao.addSybdb(userName, changeNum);
			if(result){
				Gcuser gcuser = gcuserDao.getUser(userName);
				Bdbdate bdbdate = new Bdbdate();
				bdbdate.setZuser(userName);
				bdbdate.setBz(desc);
				bdbdate.setJc(changeNum);
				bdbdate.setSybdb(gcuser.getSybdb());
				bdbdate.setLjbdb(gcuser.getLjbdb());
				bdbDateDao.add(bdbdate);
			}
			return result;
		}else{
			changeNum = Math.abs(changeNum);
			boolean result = gcuserDao.reduceSybdb(userName, changeNum);
			if(result){
				Gcuser gcuser = gcuserDao.getUser(userName);
				Bdbdate bdbdate = new Bdbdate();
				bdbdate.setZuser(userName);
				bdbdate.setBz(desc);
				bdbdate.setJc(changeNum);
				bdbdate.setSybdb(gcuser.getSybdb());
				bdbdate.setLjbdb(gcuser.getLjbdb());
				bdbDateDao.add(bdbdate);
			}
			return result;
		}
	}
	
	/**
	 * 更新金币
	 * @param userName
	 * @param sjb
	 * @param jydb
	 * @param desc
	 * @return
	 */
	public boolean updateJB(String userName,int jydb,String desc){
		boolean result = gcuserDao.updateJB(userName, jydb);
		if(result){
			Gcuser gcuser = gcuserDao.getUser(userName);
			Datepay datePay = new Datepay();
			datePay.setUsername(userName);
			datePay.setJyjz(jydb);
			datePay.setJydb(gcuser.getJydb());
			datePay.setRegid(desc);
			datePay.setPay(gcuser.getPay());
			datePay.setNewbz(0);
			datePay.setAbdate(new Date());
			logService.addDatePay(datePay);
		}
		return result;
	}
	
	/**
	 * 获取我们所有的下家
	 * @param userName
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public IPage<Gcuser> getMyDownUserPage(String userName,int pageIndex,int pageSize){
		return gcuserDao.getMyDownUserPage(userName, pageIndex, pageSize);
	}
	
	/**
	 * 报单币转账
	 * @param fromUser
	 * @param toUser
	 * @param amount
	 */
	@Transactional
	public void trasferBdb(String fromUser,String toUser,int amount,String password3){
		Gcuser from = gcuserDao.getUser(fromUser);
		if(from.getVip()==0){
			throw new ServiceException(1, "vip用户才能玩这个功能！");
		}
		
		if(!from.getPassword3().equals(password3)){
			throw new ServiceException(2, "二级密码不正确");
		}
		
		if(fromUser.equals(toUser)){
			throw new ServiceException(3, "不能转给自己！");
		}
		if(!fromUser.equals("300fhk")){
			if(zuoMingxiDao.get(fromUser, toUser)==null&&youMingXiDao.get(fromUser, toUser)==null){
				throw new ServiceException(4, "只能转给自己团队的并已进入双区的玩家！");
			}
		}
		if(amount<=0){
			throw new ServiceException(5, "转账金额不能小于0");
		}
		
		if(from.getSybdb()<amount){
			throw new ServiceException(6, "转出用户名报单币不能大于剩余报单币 "+from.getSybdb()+" ，谢谢！");
		}
		Gcuser to = gcuserDao.getUser(toUser);
		if(to==null){
			throw new ServiceException(7, "接收的用户名不存在，请检查输入是否正确！");
		}
		
		//减被转者的报单币
		if(!this.updateSybdb(fromUser, -amount, "转给-"+toUser)){
			throw new ServiceException(6, "转出用户名报单币不能大于剩余报单币 "+from.getSybdb()+" ，谢谢！");
		}
		
		this.updateSybdb(toUser, amount, "收到-服务中心"+fromUser.substring(0,2)+"***");
		
		vipxtgcDao.updateJcBdb(fromUser, DateUtils.getDate(new Date()), amount);
		
	}
	/**
	 * yb转账
	 * @param fromUser
	 * @param toUser
	 * @param amount
	 */
	private void trasferYb(String fromUser,String toUser,int amount){
		if(!this.changeYb(fromUser, -amount, "转给-"+toUser, 6,null)){
			throw new ServiceException(100, "Yb不足");
		}
		this.changeYb(toUser, amount, "收到-"+fromUser, 6,null);
	}
	
	/**
	 * 批量同名账号转账
	 * @param fromUsers
	 * @param toUser
	 * @param password3
	 */
	@Transactional
	public void batchTrasferYb(List<String> fromUsers,String toUser,String password3){
		Gcuser gcuser = gcuserDao.getUser(toUser);
		if(!gcuser.getPassword3().equals(password3)){
			throw new ServiceException(1, "二级密码错误，请检查输入是否正确！");
		}
		if(gcuser.getPayok()==10){
			throw new ServiceException(2, "您好，您已申请的卖出尚未交易成功，暂时不能使用转账功能，谢谢！");
		}
		if(gcuser.getJygt1()==2 || gcuser.getDbt1()==2){
			throw new ServiceException(3, "操作错误，请检查输入是否正确！");
		}
		
		for(String fromUser: fromUsers){
			Gcuser user = gcuserDao.getUser(fromUser);
			if(user==null){
				throw new ServiceException(4, "用户不存在");
			}
			if(!gcuser.getName().equals(user.getName())||!gcuser.getUserid().equals(user.getUserid())){
				throw new ServiceException(5, "非同名用户,不能转");
			}
			if(user.getPay()>0&&!fromUser.equals(toUser)){
				trasferYb(fromUser,toUser,user.getPay());
			}
		}
	}
	
	private static final String[] ARRAY_DESC = new String[]{"单","双 ","大","小"};
	public void guessYb(String userName,int type,int ybNum){
		Gcuser gcuser = gcuserDao.getUser(userName);
		if(gcuser.getPay()==0 || gcuser.getPay()<10 || ybNum>gcuser.getPay()){
			throw new ServiceException(1,"一币不足");
		}
		Epkjdate epkjdate = managerService.getEpkjdateBz0();
		if(!this.changeYb(userName, -ybNum, "竞猜投注"+ARRAY_DESC[type-1], 0,epkjdate.getKid())){
			throw new ServiceException(1,"一币不足");
		}
		//更新压注池子
		if(type==1){
			managerService.updateEpkjdateBz0(ybNum, 0, 0, 0);
		}else if(type==2){
			managerService.updateEpkjdateBz0(0, ybNum, 0, 0);
		}else if(type==3){
			managerService.updateEpkjdateBz0(0, 0, ybNum, 0);
		}else if(type==4){
			managerService.updateEpkjdateBz0(0, 0, 0, ybNum);
		}
		eptzbDao.updateSumGuessByType(userName, type, ybNum);
	}
	

	public void guessJf(String userName,int type,int jfNum){
		Gcuser gcuser = gcuserDao.getUser(userName);
		if(gcuser.getJyg()==0 || gcuser.getJyg()<10 || jfNum>gcuser.getJyg()){
			throw new ServiceException(1,"操作错误，积分不足，请检查输入是否正确！");
		}
		Jfkjdate epkjdate = managerService.getJfkjdateBz0();
		
		if(!gcuserDao.updateJyg(userName, jfNum)){
			throw new ServiceException(1, "操作错误，积分不足，请检查输入是否正确！");
		}
		
		Gpjy gpjy = new Gpjy();
		gpjy.setUsername(userName);
		gpjy.setMcsl(jfNum);
		gpjy.setSysl(gcuser.getJyg()-jfNum);
		gpjy.setBz("竞猜投注-"+ARRAY_DESC[type-1]);
		gpjy.setKjqi(epkjdate.getKid());
		gpjy.setCgdate(new Date());
		gpjy.setJy(1);
		gpjy.setAbdate(new Date());
		gpjyDao.add(gpjy);
		
		//更新压注池子
		if(type==1){
			managerService.updateEpkjdateBz0(jfNum, 0, 0, 0);
		}else if(type==2){
			managerService.updateEpkjdateBz0(0, jfNum, 0, 0);
		}else if(type==3){
			managerService.updateEpkjdateBz0(0, 0, jfNum, 0);
		}else if(type==4){
			managerService.updateEpkjdateBz0(0, 0, 0, jfNum);
		}
		jftzbDao.updateSumGuessByType(userName, type, jfNum);
	}
	/**
	 * 一币抢购
	 */
	@Transactional
	public int yqQg(String userName,int goodsId,int buyNum,int price){
		Gcuser gcuser = gcuserDao.getUser(userName);
		if(gcuser.getPay()==0 ||  price*buyNum>gcuser.getPay()){
			throw new ServiceException(1,"一币不足");
		}
		boolean result = jfcpDao.update(goodsId, buyNum);
		if(!result){
			throw new ServiceException(2,"本轮该产品已成功被抢购，请稍候再试或联系客服进行下一轮抢购或选择其它产品！");
		}
		Jfcp jfcp =jfcpDao.get(goodsId);
		
		if(!this.changeYb(userName, -price*buyNum, "抢购-"+jfcp.getCpmq(), 0, null)){
			throw new ServiceException(1,"一币不足");
		}
		
		if(jfcp.getDqep()==10||jfcp.getDqep()<21&&jfcp.getCglist()!=0){
			if(!jfcpDao.updateDqepAndCglist(goodsId, buyNum)){
				throw new ServiceException(3000,"未知错误");
			}
		}
		
		jfcp =jfcpDao.get(goodsId);
		
		if(jfcp.getDqep()==0||jfcp.getDqep()<0&&jfcp.getCglist()==0){
			Cpuser cpuser = new Cpuser();
			cpuser.setCguser(userName);
			cpuser.setCpmq("一币-"+jfcp.getCpmq());
			cpuser.setJydate(new Date());
			cpuser.setJyjf(jfcp.getZepsl());
			cpuser.setJyname(gcuser.getName());
			cpuser.setJyqq(gcuser.getQq());
			cpuser.setJycall(gcuser.getCall());
			cpuserDao.add(cpuser);
			
			Datepay datepay = new Datepay();
			datepay.setUsername(userName);
			datepay.setRegid("抢购成功"+jfcp.getCpmq());
			datepay.setPay(gcuser.getPay()-buyNum*price);
			datepay.setJydb(gcuser.getJydb());
			
			if(!jfcpDao.updateDqepOrCglistOrJysl(goodsId)){
				throw new ServiceException(3000,"未知错误");
			}
		}else{
			//throw new ServiceException(3,"您好，本次点击抢购还差一点点，还有"+jfcp.getDqep()+"就可以抢中，继续加油！！！");
			return jfcp.getDqep();
		}
		return -1;
	}
	
	/**
	 * 挂单出售一币
	 * @param userName
	 * @param password3
	 * @param saleNum
	 * @param smsCode
	 * @param ip
	 */
	@Transactional
	public void saleYb(String userName,String password3,int saleNum,String smsCode,String ip){
		
		if(saleNum<100){
			throw new ServiceException(1,"发布一币数量有误，请检查输入是否正确！");
		}
		
		
		Gcuser gcuser = this.gcuserDao.getUser(userName);
		
		int txqpay = gcuser.getPay();
		
		Fcxt fcxt = managerService.getFcxtById(10);
		
		if(saleNum>gcuser.getPay()){
			throw new ServiceException(2,"您好，您发布的一币数量不能大于您剩余一币 "+gcuser.getPay()+" ，谢谢！");	
		}
		
		if(saleNum>gcuser.getPay()-gcuser.getVippay() && gcuser.getRegtime().getTime()>fcxt.getJsdate().getTime()){
			throw new ServiceException(3,"您好，您有 "+gcuser.getVippay()+"-一币是[服务中心转入]或[游戏收益部分]，此额度不提供卖出，仅用于开户使用，谢谢！");
		}

		if(!password3.equals(gcuser.getPassword3())){
			throw new ServiceException(4,"您好，您二级密码不正确，请重新输入！");
		}
		
		if(gcuser.getGanew()!=0&&!gcuser.getVipsq().equals(smsCode)){
			throw new ServiceException(5,"您好，手机验证码不正确，请重新输入！");
		}
		
		if(saleNum<100){
			throw new ServiceException(6,"您好，您发布的一币数量不能小于100，谢谢！");
		}
		
		if(gcuser.getPayok()==1){
			throw new ServiceException(7,"您好，您已发布成功过，请耐心等待处理完成后再发布第二笔，或认购方已向您付款，请先确认收款再发布第二笔，谢谢！");
		}
		
		
		double tgpay9 = 0d;
		int tgpay09 = 0;
		if(saleNum<1000){
			tgpay9 = saleNum*0.85;
			tgpay09 = (int)tgpay9;
		}else{
			tgpay9 = saleNum*0.9;
			tgpay09 = (int)tgpay9;
		}
		
		if(!gcuserDao.saleYb(userName, saleNum)){
			throw new ServiceException(2,"您好，您发布的一币数量不能大于您剩余一币 "+gcuser.getPay()+" ，谢谢！");
		}
		Datepay datePay = new Datepay();
		datePay.setUsername(userName);
		datePay.setJc(saleNum);
		datePay.setPay(gcuser.getPay());
		datePay.setJydb(gcuser.getJydb());
		datePay.setRegid("实收"+tgpay09);
		datePay.setNewbz(3);
		datePay.setTxbz(1); 
		datePay.setAbdate(new Date());
		logService.addDatePay(datePay);
		
		int datePayId = logService.getLasterInsertId();
		
		Txpay txpay = txPayDao.get();
		
		int jypay = txpay.getPayid()+1;
		
		gcuser = gcuserDao.getUser(userName);
		
		Txpay txpay2 = new Txpay();
		txpay2.setPayusername(userName);
		txpay2.setCxt(gcuser.getCxt());
		txpay2.setPaynum(saleNum);
		txpay2.setPaynum9(tgpay09);
		txpay2.setPayname(gcuser.getName());
		txpay2.setPaybank(gcuser.getBank());
		txpay2.setPaycard(gcuser.getCard());
		txpay2.setPayonoff("尚未转账");
		txpay2.setBankbz(txqpay+"");
		txpay2.setBz(gcuser.getPay()+"");
		txpay2.setDqu(gcuser.getDqu());
		txpay2.setQlid(datePayId);
		txpay2.setPdid(11);
		txpay2.setJyid(jypay);
		txpay2.setVipname(gcuser.getVipname());
		txpay2.setTxvip(gcuser.getTxlb());
		txpay2.setTxip(ip);
		txPayDao.add(txpay2);
		
		gcuserDao.updatePayOk(gcuser.getName(), gcuser.getUserid(), 1);
	}
	/**
	 * 转账一币至谁的名下
	 * @param fromUser
	 * @param toUser
	 * @param amount
	 */
	
	@Transactional
	public void trasferYbToOtherPersion(String fromUser,String toUser,String password3,int amount){
        if(amount<0 || amount==0 || amount >100000){
        	throw new ServiceException(1,"您好，您转账一币不能小于零或超过100000，谢谢！");
        }
		if(amount%100!=0){
			throw new ServiceException(2,"转账必须是100的倍整数如：100，200，300，400，500，1000，5000，请检查输入是否正确！");
		}
		if(fromUser.equals(toUser)){
			throw new ServiceException(3, "您好，不能转给自己，谢谢！");
		}
		
		if(!fromUser.equals("300fhk")){
			if(zuoMingxiDao.get(fromUser, toUser)==null&&youMingXiDao.get(fromUser, toUser)==null){
				throw new ServiceException(4, "只能转给自己团队的并已进入双区的玩家！");
			}
		}
		
		Gcuser gcuser = gcuserDao.getUser(fromUser);
		
		if(!gcuser.getPassword3().equals(password3)){
			throw new ServiceException(5, "二级密码不正确");
		}
		
		if(gcuser.getPay()<50000){
			throw new ServiceException(6, "VIP玩家一币账户余额必须大于或等于50000！");
		}
		
		if(gcuser.getPay()<amount){
			throw new ServiceException(7, "您好，您转账一币不能大于您剩余一币 "+gcuser.getPay()+" ，谢谢！");
		}
		
		Gcuser toGcUser = gcuserDao.getUser(toUser);
		
		if(toGcUser==null){
			throw new ServiceException(8, "转入的用户名不存在，请检查输入是否正确！");
		}
		
		if(!gcuserDao.transferReduceYb(fromUser, amount)){
			throw new ServiceException(6, "您好，您转账一币不能大于您剩余一币 "+gcuser.getPay()+" ，谢谢！");
		}
		Datepay datePay = new Datepay();
		datePay.setUsername(fromUser);
		datePay.setJc(amount);
		datePay.setPay(gcuser.getPay()-amount);
		datePay.setJydb(gcuser.getJydb());
		datePay.setRegid("转给-"+toUser);
		datePay.setNewbz(0);
		datePay.setAbdate(new Date());
		logService.addDatePay(datePay);
		
		if(this.changeYb(toUser, amount, "收到服务中心"+toUser.substring(0, 2)+"***转入", 0, null)){
			throw new ServiceException(3000, "未知错误！");
		}
		
		vipxtgcDao.updateJcYb(fromUser, DateUtils.getDate(new Date()), amount);
	}
	
	/**
	 * 获取一币交易列表
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public IPage<Txpay> getTxpayPage(int pageIndex,int pageSize){
		return txPayDao.getPageList(pageIndex, pageSize);
	}
	/**
	 * 一币卖出明细
	 * @param userName
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public IPage<Txpay> getTxpaySalesDetailsPage(String userName,int pageIndex,int pageSize){
		return txPayDao.getPageListSalesDetails(userName, pageIndex, pageSize);
	}
	
	/**
	 * 一币求购明细
	 * @param userName
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public IPage<Txpay> getTxpayBuyDetailsPage(String userName,int pageIndex,int pageSize){
		return txPayDao.getPageListBuyDetails(userName, pageIndex, pageSize);
	}
	/**
	 * 撤销卖出一币
	 * @param userName
	 * @param payid
	 * @param ip
	 */
	@Transactional
	public void cancleYbSale(String userName,int payid,String ip){
		Txpay txpay = txPayDao.getByPayid(payid);
		if(txpay==null||!txpay.getPayusername().equals(userName)){
			throw new ServiceException(1, "该一币卖出方不是本人，请重新操作！");
		}
		
		if(txpay.getEp()>0 || txpay.getZftime()!=null || txpay.getKjygid()!=0){
			throw new ServiceException(2, "该一币交易进行中或已经由它人交易成功，暂时不能撤销，或稍后再试！");
		}
		if(datePayDao.updateByQlid(txpay.getQlid())){
			gcuserDao.backSaleYb(userName, txpay.getPaynum());
			Gcuser gcuser = gcuserDao.getUser(userName);
			Datepay datePay = new Datepay();
			datePay.setUsername(userName);
			datePay.setSyjz(txpay.getPaynum());
			datePay.setPay(gcuser.getPay());
			datePay.setJydb(gcuser.getJydb());
			datePay.setRegid("撤销卖出");
			datePay.setNewbz(3);
			datePay.setTxbz(1); 
			datePay.setAbdate(new Date());
			logService.addDatePay(datePay);
			
			if(!txPayDao.updateByPayid(payid, 0, new Date(), "已经转账", new Date(), "撤销", ip)){
				throw new ServiceException(3000, "未知错误");
			}
			if(!gcuserDao.updatePayOk(gcuser.getName(), gcuser.getUserid(), 0)){
				throw new ServiceException(3000, "未知错误");
			}
		}else{
			throw new ServiceException(2, "该一币交易进行中或已经由它人交易成功，暂时不能撤销，或稍后再试！");
		}
	}
	
	/**
	 * 购买一币的前置检查
	 * @param userName
	 * @param payId
	 */
	public Txpay buyYbPre(String userName,int payId){
		Txpay txpay = txPayDao.getByPayid(payId);
		if(txpay==null){
			throw new ServiceException(1, "交易不存在，请重新操作！");
		}
		Gcuser gcuser = gcuserDao.getUser(userName);
		if(gcuser.getSjb()==0){
			throw new ServiceException(2, "您好，您还不是双区玩家，暂时不能使用一币理财功能！");
		}
		
		if(gcuser.getSjb()<20){
			throw new ServiceException(3, "您好，您还没达到D套餐，暂时不能使用一币理财功能！\n\n您可以联系团队服务中心以95%的价格购买一币后进行操作！");
		}
		
		if(gcuser.getCxt()<4&&gcuser.getCxdate().getTime()>System.currentTimeMillis()){
			throw new ServiceException(4, "您好，您的诚信星为"+gcuser.getCxt()+"，离取消[限制认购]时间还有"+DateUtils.getIntervalDays(new Date(),gcuser.getCxdate())+"天，谢谢！");
		}
		
		if(userName.equals(txpay.getPayusername())){
			throw new ServiceException(5, "您好，不能认购自己的一币，请选择其它用户，谢谢！");
		}
		if(gcuser.getJyg()<txpay.getPaynum()){
			throw new ServiceException(6, "您好您，的积分数量不足"+txpay.getPaynum()+"（认购一币作为诚信金），暂时不能使用一币理财功能！\n\n您可以联系团队服务中心以95%的价格购买一币后进行操作！");
		}
		

		return txpay;
	}
	
	@Transactional
	public Txpay buyYb(String userName,int payId,String password3){
		Txpay txpay = buyYbPre(userName,payId);
		
		Gcuser gcuser = gcuserDao.getUser(userName);
		
		if(!password3.equals(gcuser.getPassword3())){
			throw new ServiceException(8, "您好，您的二级密码不正确，请检查输入是否正确！");
		}
		
		
		if(!txPayDao.updateEpToBeSalesPre(payId,new Date(),userName,txpay.getPaynum())){
			throw new ServiceException(7, "该一币交易进行中或已经由它人交易成功了，不能重复，请选择其它交易！");
		}
		
		if(!gcuserDao.updateJyg(userName, txpay.getPaynum())){
			throw new ServiceException(6, "您好您，的积分数量不足"+txpay.getPaynum()+"（认购一币作为诚信金），暂时不能使用一币理财功能！\n\n您可以联系团队服务中心以95%的价格购买一币后进行操作！");
		}
		
		Gpjy gpjy = new Gpjy();
		gpjy.setUsername(userName);
		gpjy.setMcsl(txpay.getPaynum());
		gpjy.setSysl(gcuser.getJyg()-txpay.getPaynum());
		gpjy.setBz("冻结-认购一币-"+txpay.getPaynum()+"诚信金-"+txpay.getPayusername());
		gpjy.setCgdate(new Date());
		gpjy.setJy(1);
		gpjy.setDfuser(payId+"");
		gpjy.setNewjy(1);
		gpjy.setAbdate(new Date());
		
		gpjyDao.add(gpjy);
		
		return txpay;
	}
	
	public Txpay getTxpayById(int payId){
		return txPayDao.getByPayid(payId);
	}
	/**
	 * 确认已打钱
	 * @param userName
	 * @param payId
	 */
	public void sureIGivedMoney(String userName,int payId){
		Txpay txpay = txPayDao.getByPayid(payId);
		if(!txpay.getDfuser().equals(userName)||txpay.getKjygid()==0){
			throw new ServiceException(1, "认购方出错，请检查输入是否正确！");
		}else{
			if(!txPayDao.updateEpToHavePay(payId, DateUtils.addDay(new Date(), 2))){
				throw new ServiceException(1, "认购方出错，请检查输入是否正确！");
			}
		}
	}
    /**
     * 购买金币卡
     * @param userName  用户名
     * @param mz        面值
     * @param gmsl      购买数量
     */
	
	private static final double[] rations = new double[]{0.1,0.03,0.01};
	private static final String[] descs = new String[]{"商家一","商家二","商家三"};
	
	@Transactional
	public void buyJb(String userName,int mz,int gmsl){
		//需要的一币数量
		double needYbCountDouble = (double)mz*(double)gmsl*1.5;
		int needYbCount = (int)needYbCountDouble;
		//金币数量
		int jbCount = mz*gmsl;
		
		Gcuser gcuser = gcuserDao.getUser(userName);
		
		if(gcuser.getPay()<needYbCount){
			throw new ServiceException(2, "注意：您的一币不够本次发卡，请充值！");
		}
		
		
		String d9 = gcuser.getAdd9dqu();
		String sheng = gcuser.getAddsheng();
		String shi = gcuser.getAddshi();
		String qu = gcuser.getAddqu();
		
		if(!this.changeYb(userName, -needYbCount, "一币余额购金币卡"+jbCount, 0, null)){
			throw new ServiceException(2, "注意：您的一币不够本次发卡，请充值！");
		}
		//更新gmdate
		gcuserDao.updateGmdate(userName, new Date());
		
		//更新3线上家
		Gcuser tempUser = gcuser;
		for(int i=0;i<rations.length;i++){
			if(tempUser!=null){
				updateUpJbAndYj(tempUser.getUp(), descs[i]+userName+"自助购卡"+jbCount, (int)(rations[i]*jbCount));
				tempUser = gcuserDao.getUser(tempUser.getUp());
			}
		}
		
		//区总上限
		Gcuser quUser = gcuserDao.getGcuserByQu(qu);
		if(quUser!=null){
			int addNum = (int)(0.01*jbCount);
			gcuserDao.updateQuPay(quUser.getUsername(),addNum);
			logService.addDlDate(quUser.getUsername(), addNum, quUser.getQupay()+addNum, "区内商家"+userName+"自助购卡"+jbCount);
		}
		//市
		Gcuser shiUser = gcuserDao.getGcuserByShi(shi);
		if(shiUser!=null){
			int addNum = (int)(0.005*jbCount);
			gcuserDao.updateShiPay(shiUser.getUsername(),addNum);
			logService.addDlDate(shiUser.getUsername(), addNum, shiUser.getShipay()+addNum, "市内商家"+userName+"自助购卡"+jbCount);
		}
		//省
		Gcuser shengUser = gcuserDao.getGcuserBySheng(sheng);
		if(shengUser!=null){
			int addNum = (int)(0.002*jbCount);
			gcuserDao.updateShengPay(shengUser.getUsername(), addNum);
			logService.addDlDate(shengUser.getUsername(), addNum, shengUser.getShengpay()+addNum, "省内商家"+userName+"自助购卡"+jbCount);
		}
		//大区
		Gcuser dquUser = gcuserDao.getGcuserByDqu9(d9);
		if(dquUser!=null){
			int addNum = (int)(0.001*jbCount);
			gcuserDao.update9QuPay(dquUser.getUsername(), addNum);
			logService.addDlDate(dquUser.getUsername(), addNum, dquUser.getDqupay()+addNum, "大区内商家"+userName+"自助购卡"+jbCount);
		}
		
		
//		lkjlDao.updatelksl(userName, gmsl);
		
		batchGeneratorEjbk(userName,gmsl,mz);
		
	}
	
	private static final char[] RANDOMCHAR = new char[]{'0','1','2','3','4','9','a','b','c','d','e','f','g','5','6','7','8','h','j','k','x','y','z','i'};
	private void batchGeneratorEjbk(String userName,int count,int value){
		value = value/10;
		List<Ejbk> list = Lists.newArrayList();
		for(int i=0;i<count;i++){
			Ejbk ejbk = new Ejbk();
			ejbk.setPdid(userName+""+RandomStringUtils.random(6,RANDOMCHAR));
			ejbk.setUp(userName);
			ejbk.setGpa(1);
			ejbk.setBf2(value);
			ejbk.setGmdate(new Date());
			list.add(ejbk);
		}
		ejbkDao.batchAdd(list);
	}
	/**
	 * 更新业绩
	 */
	private void updateUpJbAndYj(String upUserName,String desc,int count){
		gcuserDao.addWhenOtherPersionBuyJbCard(upUserName, count);
		Gcuser gcuser = gcuserDao.getUser(upUserName);
		Datepay datePay = new Datepay();
		datePay.setUsername(upUserName);
		datePay.setRegid(desc);
		datePay.setSyjz(count);
		datePay.setPay(gcuser.getPay());
		datePay.setJydb(gcuser.getJydb());
		datePay.setAbdate(new Date());
		logService.addDatePay(datePay);
	}
	/**
	 * 查询用户金币卡列表
	 * @param upUserName
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public IPage<Ejbk> getEjbkPageList(String upUserName,int pageIndex,int pageSize){
		return ejbkDao.getPageList(upUserName, pageIndex, pageSize);
	}
	/**
	 * 获取单张金币卡
	 * @param pdid
	 * @return
	 */
	public Ejbk getEjbk(String pdid){
		return ejbkDao.get(pdid);
	}
	/**
	 * 更新密码
	 * @param pdid
	 * @param pdpamd5
	 * @param fwidmd5
	 * @return
	 */
	public Ejbk updateEjbk(String pdid,String userName,String pdpa,String fwid){
		Ejbk ejbk = ejbkDao.get(pdid);
		if(!ejbk.getUp().equals(userName)){
			throw new ServiceException(3000, "不是自己的金币卡，不能修复激活码！~");
		}
		String pdpamd5 = MD5Security.md5_16(pdpa).toUpperCase(); 
		String fwidmd5 = MD5Security.md5_16(fwid).toUpperCase();
		if(ejbkDao.update(pdid, pdpamd5, fwidmd5)){
			return ejbkDao.get(pdid);
		}
		return null;
	}
	/**
	 * 激活金币卡
	 * @param userName
	 * @param pdid
	 * @param pdpa
	 * @param fwid
	 * @param ip
	 */
	@Transactional
	public void activedGoldCard(String userName,String pdid,String pdpa,String fwid,String ip){
		String pdpamd5 = MD5Security.md5_16(pdpa).toUpperCase(); 
		String fwidmd5 = MD5Security.md5_16(fwid).toUpperCase();
		
		Ejbk ejbk = ejbkDao.get(pdid);
		String gmuser = "";
		Date gmdate= null;
		if(ejbk==null){
			Jbk10 jbk10 = jdbDao.getJbk10(pdid);
			if(jbk10!=null){
				if(!pdpamd5.equals(jbk10.getPdpamd5())){
					throw new ServiceException(1, "你的 登录密码 不正确，请重新输入！");
				}
				if(!fwidmd5.equals(jbk10.getFwidmd5())){
					throw new ServiceException(2, "你的 防伪编码 不正确，请重新输入！");
				}
				int cjpay=   10;
				vipgwly(userName, pdid, pdpamd5, fwidmd5, gmuser, gmdate, cjpay, ip);
				if(!jdbDao.deleteJbk10(pdid)){
					throw new ServiceException(3, "你的 消费编号 不正确或已激活过，请查正后重新输入！");
				}
			}else{
				Jbk50 jbk50 = jdbDao.getJbk50(pdid);
				if(jbk50!=null){
					if(!pdpamd5.equals(jbk50.getPdpamd5())){
						throw new ServiceException(1, "你的 登录密码 不正确，请重新输入！");
					}
					if(!fwidmd5.equals(jbk50.getFwidmd5())){
						throw new ServiceException(2, "你的 防伪编码 不正确，请重新输入！");
					}
					
					int cjpay=   50;
					vipgwly(userName, pdid, pdpamd5, fwidmd5, gmuser, gmdate, cjpay, ip);
					if(!jdbDao.deleteJbk50(pdid)){
						throw new ServiceException(3, "你的 消费编号 不正确或已激活过，请查正后重新输入！");
					}
				}else{
					Jbk100 jbk100 = jdbDao.getJbk100(pdid);
					if(jbk100!=null){
						if(!pdpamd5.equals(jbk100.getPdpamd5())){
							throw new ServiceException(1, "你的 登录密码 不正确，请重新输入！");
						}
						if(!fwidmd5.equals(jbk100.getFwidmd5())){
							throw new ServiceException(2, "你的 防伪编码 不正确，请重新输入！");
						}
						int cjpay=   100;
						vipgwly(userName, pdid, pdpamd5, fwidmd5, gmuser, gmdate, cjpay, ip);
						if(!jdbDao.deleteJbk100(pdid)){
							throw new ServiceException(3, "你的 消费编号 不正确或已激活过，请查正后重新输入！");
						}
					}else{
						Jbk300 jbk300 = jdbDao.getJbk300(pdid);
						if(jbk300!=null){
							if(!pdpamd5.equals(jbk300.getPdpamd5())){
								throw new ServiceException(1, "你的 登录密码 不正确，请重新输入！");
							}
							if(!fwidmd5.equals(jbk300.getFwidmd5())){
								throw new ServiceException(2, "你的 防伪编码 不正确，请重新输入！");
							}
							int cjpay=   300;
							vipgwly(userName, pdid, pdpamd5, fwidmd5, gmuser, gmdate, cjpay, ip);
							if(!jdbDao.deleteJbk300(pdid)){
								throw new ServiceException(3, "你的 消费编号 不正确或已激活过，请查正后重新输入！");
							}
						}else{
							Jbk500 jbk500 = jdbDao.getJbk500(pdid);
							if(jbk500!=null){
								if(!pdpamd5.equals(jbk500.getPdpamd5())){
									throw new ServiceException(1, "你的 登录密码 不正确，请重新输入！");
								}
								if(!fwidmd5.equals(jbk500.getFwidmd5())){
									throw new ServiceException(2, "你的 防伪编码 不正确，请重新输入！");
								}
								int cjpay=   500;
								vipgwly(userName, pdid, pdpamd5, fwidmd5, gmuser, gmdate, cjpay, ip);
								if(!jdbDao.deleteJbk500(pdid)){
									throw new ServiceException(3, "你的 消费编号 不正确或已激活过，请查正后重新输入！");
								}
							}else{
								throw new ServiceException(3, "你的 消费编号 不正确或已激活过，请查正后重新输入！");
							}
						}
					}
				}
			}
			
		}else{
				if(!pdpamd5.equals(ejbk.getPdpamd5())){
					throw new ServiceException(1, "你的 登录密码 不正确，请重新输入！");
				}
				if(!fwidmd5.equals(ejbk.getFwidmd5())){
					throw new ServiceException(2, "你的 防伪编码 不正确，请重新输入！");
				}
				gmuser=  ejbk.getUp();
				gmdate=    ejbk.getGmdate();
				int cjpay=      ejbk.getBf2()*10;
				vipgwly(userName, pdid, pdpamd5, fwidmd5, gmuser, gmdate, cjpay, ip);
				if(!ejbkDao.delete(pdid)){
					throw new ServiceException(3, "你的 消费编号 不正确或已激活过，请查正后重新输入！");
				}
		}
	}
	
	private void vipgwly(String userName,String pdid,String pdpa,String fwid,String gmuser,Date gmdate,int cjpay,String ip){
//		double zjgc = 0;
//		if(cjpay<1000){
//		   zjgc=0;
//		}else if(cjpay>999 && cjpay<2000){
//		   zjgc=cjpay*0.01;
//		}else if(cjpay>1999 && cjpay<3000){
//		   zjgc=cjpay*0.02;
//		}else if(cjpay>2999 && cjpay<4000){
//		   zjgc=cjpay*0.03;
//		}else if(cjpay>3999 && cjpay<5000){
//			zjgc=cjpay*0.04;
//		}else if(cjpay>4999 && cjpay<6000){
//			zjgc=cjpay*0.05;
//		}else if(cjpay>5999 && cjpay<7000){
//			zjgc=cjpay*0.06;
//		}else if(cjpay>6999 && cjpay<8000){
//			zjgc=cjpay*0.07;
//		}else if(cjpay>7999 && cjpay<9000){
//			zjgc=cjpay*0.08;
//		}else if(cjpay>8999 && cjpay<10000){
//			zjgc=cjpay*0.09;
//		}else if(cjpay>9999){
//			zjgc=cjpay*0.1;
//		}
		Datecj datecj = datecjDao.get(userName);
		int cjtj = 0;
		if(datecj!=null){
			cjtj = datecj.getLjcj();
		}
		Datecj datecjTemp = new Datecj();
		datecjTemp.setCjuser(userName);
		datecjTemp.setDqcj(cjpay);
		datecjTemp.setLjcj(cjtj);
		datecjTemp.setCjfs(pdid);
		datecjTemp.setCjdate(gmdate);
		datecjTemp.setBz(gmuser);
		datecjTemp.setIp(ip);
		datecjDao.add(datecjTemp);
		
		Gcuser user = gcuserDao.getUser(userName);
		int count = (int)(cjpay*0.03);
		
		updateUpJbAndYj(user.getUp(), "用户一"+userName+"激活金币卡"+cjpay, count);
		gcuserDao.addOnlyJB(userName, cjpay);
		user = gcuserDao.getUser(userName);
		Datepay datePay = new Datepay();
		datePay.setUsername(userName);
		datePay.setRegid("激活金币卡"+cjpay);
		datePay.setPay(user.getPay());
		datePay.setJydb(user.getJydb());
		datePay.setJyjz(cjpay);
		datePay.setAbdate(new Date());
		logService.addDatePay(datePay);
	}
	/**
	 * 积分竞猜
	 * @param userName
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public IPage<Gpjy> getGpjyPage(String userName,int pageIndex,int pageSize){
		return gpjyDao.getPageList(userName, pageIndex, pageSize);
	}
	
	@Transactional
	public int jfQg(String userName,int goodsId){
		Gcuser user = gcuserDao.getUser(userName);
		int cost = 1;
		int buyNum = 1;
		if(user.getJyg()<10||user.getJyg()<cost){
			throw new ServiceException(1, "您好，积分不足，暂时不能参与，谢谢！");
		}
		
		boolean result = jfcpDao.updateJf(goodsId, buyNum);
		if(!result){
			throw new ServiceException(2,"本轮该产品已成功被抢购，请稍候再试或联系客服进行下一轮抢购或选择其它产品！");
		}
		Jfcp jfcp =jfcpDao.get(goodsId);
		
		if(!gcuserDao.updateJyg(userName, cost)){
			throw new ServiceException(1, "您好，积分不足，暂时不能参与，谢谢！");
		}
		user = gcuserDao.getUser(userName);
		Gpjy gpjy = new Gpjy();
		gpjy.setUsername(userName);
		gpjy.setMcsl(cost);
		gpjy.setSysl(user.getJyg());
		gpjy.setBz("抢购-"+jfcp.getCpmq());
		gpjy.setCgdate(new Date());
		gpjy.setJy(1);
		gpjy.setAbdate(new Date());
		gpjyDao.add(gpjy);
		
		if(jfcp.getDqjf()==10||jfcp.getDqjf()<21&&jfcp.getCglist()!=0){
			if(!jfcpDao.updateDqjfAndCglist(goodsId, buyNum)){
				throw new ServiceException(3000,"未知错误");
			}
		}
		
		jfcp =jfcpDao.get(goodsId);
		
		if(jfcp.getDqjf()==0||jfcp.getDqjf()<0&&jfcp.getCglist()==0){
			Cpuser cpuser = new Cpuser();
			cpuser.setCguser(userName);
			cpuser.setCpmq("jf-"+jfcp.getCpmq());
			cpuser.setJydate(new Date());
			cpuser.setJyjf(jfcp.getZjfsl());
			cpuser.setJyname(user.getName());
			cpuser.setJyqq(user.getQq());
			cpuser.setJycall(user.getCall());
			cpuserDao.add(cpuser);
			
			Gpjy gpjy2 = new Gpjy();
			gpjy.setUsername(userName);
			gpjy.setSysl(user.getJyg());
			gpjy.setBz("抢购成功-"+jfcp.getCpmq());
			gpjy.setCgdate(new Date());
			gpjy.setJy(1);
			gpjyDao.add(gpjy2);
			
			if(!jfcpDao.updateDqjfOrCglistOrJysl(goodsId)){
				throw new ServiceException(3000,"未知错误");
			}
			return -1;
		}else{
			//throw new ServiceException(3,"您好，本次点击抢购还差一点点，还有"+jfcp.getDqep()+"就可以抢中，继续加油！！！");
			return jfcp.getDqjf();
		}
	}
	/**
	 * 金币购买积分 
	 * @param userName
	 * @param buyNum
	 */
	public void buyJf(String userName,int buyNum){
		
		if(gpjyDao.get()!=null){
			throw new ServiceException(1,"交易市场已有积分在出售中，请按需求点击 [我要买入] ！");
		}
		
		Gcuser gcuser = gcuserDao.getUser(userName);
		
		Fcxt fcxt = managerService.getFcxtById(2);
		
		int needJb = (int)(Math.ceil(fcxt.getJygj()*buyNum));
		
		if(!gcuserDao.reduceOnlyJB(userName, needJb)){
			throw new ServiceException(2,"操作错误，金币不足，请检查输入是否正确！");
		}
		
		Datepay datePay = new Datepay();
		datePay.setUsername(userName);
		datePay.setRegid("买入挂牌中");
		datePay.setDbjc(needJb);
		datePay.setPay(gcuser.getPay());
		datePay.setJydb(gcuser.getJydb()-needJb);
		datePay.setAbdate(new Date());
		logService.addDatePay(datePay);
		
		int id = logService.getLasterInsertId();
		
		Gpjy gpjy = new Gpjy();
		gpjy.setUsername(userName);
		gpjy.setMysl(buyNum);
		gpjy.setSysl(gcuser.getJyg());
		gpjy.setPay(fcxt.getJygj());
		gpjy.setBz("买入挂牌中");
		gpjy.setJypay(needJb);
		gpjy.setJyid(id);
		gpjy.setAbdate(new Date());
		gpjyDao.add(gpjy);
		 
	}
	
	public IPage<Gpjy> getAllGpjyPageList(String userName,int pageIndex,int pageSize){
		return gpjyDao.getAllPageList(userName, pageIndex, pageSize);
	}
	
	public IPage<Gpjy> getAllGpjyDetailsPageList(String userName,int pageIndex,int pageSize){
		return gpjyDao.getUserPageDetailsList(userName, pageIndex, pageSize);
	}
	/**
	 * 卖出积分
	 * @param userName
	 * @param price
	 * @param saleNum
	 * @param passwrod3
	 */
	@Transactional
	public void saleJf(String userName,double price,int saleNum,String passwrod3){
		checkSaleJf(userName,price,saleNum,passwrod3);
		
		if(!gcuserDao.updateJyg(userName, saleNum)){
			throw new ServiceException(9,"您好，您卖出数量不能大于您剩余数量  ，谢谢！");
		}
		if(!gcuserDao.increaseStopjyg(userName,20)){
			throw new ServiceException(8,"您好，为了提供更公平公证的交易规则，累计挂牌最高20笔，待交易完成后才可以继续发布，谢谢！");
		}
		
		int needJb = (int)(Math.ceil(price*saleNum));
		
		Gcuser gcuser = gcuserDao.getUser(userName);
		Gpjy gpjy = new Gpjy();
		gpjy.setUsername(userName);
		gpjy.setMcsl(saleNum);
		gpjy.setSysl(gcuser.getJyg());
		gpjy.setPay(price);
		gpjy.setBz("卖出挂牌中");
		gpjy.setJypay(needJb);
		gpjy.setAbdate(new Date());
		gpjyDao.add(gpjy);
	}
	/**
	 * 检查条件
	 * @param userName
	 * @param price
	 * @param saleNum
	 * @param passwrod3
	 */
	public void checkSaleJf(String userName,double price,int saleNum,String passwrod3){
		Gcuser gcuser = gcuserDao.getUser(userName);
		if(gcuser.getJyg()<50000&&DateUtils.getIntervalDays(gcuser.getBddate(), new Date())<100){
			throw new ServiceException(1,"未满100天的账户，积分暂时停止卖出交易，收益完成后自动开放！");
		}
		
		Sgxt sgxt = sgxtDao.get(userName);
		if(sgxt.getMqfh()>0&&sgxt.getMqfh()<sgxt.getZfh()&&sgxt.getXxnew()>0&&gcuser.getJyg()<50000){
			throw new ServiceException(2,"游戏收益未完成，积分暂时停止卖出交易，收益完成后自动开放！");
		}
		
		if(DateUtils.getIntervalDays(sgxt.getBddate(), new Date())==0){
			throw new ServiceException(3,"请于开户后第二天再进行卖出操作，谢谢！");
		}
		
		if(!passwrod3.equals("-1")&&!passwrod3.equals(gcuser.getPassword3())){
			throw new ServiceException(4,"二级密码不正确");
		}
		
		Fcxt fcxt = managerService.getFcxtById(2);
		if(price<0.77){
			throw new ServiceException(5,"卖出单价不能小于 0.77 ！");
		}
		if(price > fcxt.getJygj()+0.03){
			throw new ServiceException(6,"卖出单价不能大于 "+(fcxt.getJygj()+0.03)+" 哦！");
		}
		
		if(saleNum<=0){
			throw new ServiceException(7,"您好，您卖出数量不能小于零，谢谢！");
		}
		if(gcuser.getStopjyg()>19){
			throw new ServiceException(8,"您好，为了提供更公平公证的交易规则，累计挂牌最高20笔，待交易完成后才可以继续发布，谢谢！");
		}
		
		if(saleNum>gcuser.getJyg()){
			throw new ServiceException(9,"您好，您卖出数量不能大于您剩余数量 "+gcuser.getJyg()+" ，谢谢！");
		}
		
		if(gcuser.getJygt1()==0){
			if(gpjyDao.get()!=null){
				throw new ServiceException(10,"交易市场已有求购信息，请按需求点击 [我要卖给] ！");
			}
		}
	}
}
