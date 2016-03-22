package com.yq.user.dao;

import java.util.List;

import com.google.common.base.Strings;
import com.sr178.common.jdbc.SqlParameter;
import com.sr178.common.jdbc.bean.IPage;
import com.yq.common.dao.YqDaoBase;
import com.yq.user.bo.Vipcjgl;

public class VipcjglDao extends YqDaoBase<Vipcjgl> {

	public boolean add(Vipcjgl vipcjgl){
		return super.add(vipcjgl);
	}
	
	public List<Vipcjgl> getVipcjglList(String userName,String startTime,String endTime){
		String sql = "select * from "+super.getTable()+" where vipuser=? ";
		SqlParameter sqlParameter = SqlParameter.Instance();
		sqlParameter.withString(userName);
		if(!Strings.isNullOrEmpty(startTime)&&!Strings.isNullOrEmpty(endTime)){
			sql = sql +" and cjdate between ? and ?";
			sqlParameter.setString(startTime);
			sqlParameter.setString(endTime);
		}
		sql = sql +" order by cjid desc";
		return super.getJdbc().getList(sql, Vipcjgl.class, sqlParameter);
	}
	
	
	public IPage<Vipcjgl> getVipcjglPageList(String userName,String startTime,String endTime,int pageSize,int pageIndex){
		String sql = "select * from "+super.getTable()+" where vipuser=?";
		SqlParameter sqlParameter = SqlParameter.Instance();
		sqlParameter.withString(userName);
		if(!Strings.isNullOrEmpty(startTime)&&!Strings.isNullOrEmpty(endTime)){
			sql = sql +" and cjdate between ? and ?";
			sqlParameter.setString(startTime);
			sqlParameter.setString(endTime);
		}
		sql = sql +" order by cjid desc";
		return super.getJdbc().getListPage(sql, Vipcjgl.class, sqlParameter,pageSize, pageIndex);
	}
	
	
	public Double getSumVipZc(String userName,String startTime,String endTime){
		String sql = "select sum(cjjo) from "+super.getTable()+" where vipuser=? and cjuser<>'系统'";
		SqlParameter sqlParameter = SqlParameter.Instance();
		sqlParameter.withString(userName);
		if(!Strings.isNullOrEmpty(startTime)&&!Strings.isNullOrEmpty(endTime)){
			sql = sql +" and cjdate between ? and ?";
			sqlParameter.setString(startTime);
			sqlParameter.setString(endTime);
		}
		return super.getJdbc().getDouble(sql, sqlParameter);
	}
	
	public Double getSumVipSr(String userName,String startTime,String endTime){
		String sql = "select sum(cjjo) from "+super.getTable()+" where ((vipuser=? and cjuser='系统') or (cjuser=?))";
		SqlParameter sqlParameter = SqlParameter.Instance();
		sqlParameter.withString(userName);
		sqlParameter.withString(userName);
		if(!Strings.isNullOrEmpty(startTime)&&!Strings.isNullOrEmpty(endTime)){
			sql = sql +" and cjdate between ? and ?";
			sqlParameter.setString(startTime);
			sqlParameter.setString(endTime);
		}
		return super.getJdbc().getDouble(sql, sqlParameter);
	}
}
