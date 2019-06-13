package com.gxuwz.laters.bean.manager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gxuwz.laters.bean.entity.*;
import com.gxuwz.laters.database.DbUtil;

public class LaterManager {
private DbUtil dbUtil =new DbUtil();
	
	public List<Later> findAll() throws Exception{
		List<Later> laterList = new ArrayList<Later>();
		String sql = "select * from sys_later where 1=1";
		ResultSet rs = dbUtil.executeQuery(sql, null);
		while(rs.next()){
			Later later = new Later();
			later.setDormID(rs.getString("dormID"));
			later.setLaterID(rs.getString("laterID"));
			later.setLaterTime(rs.getDate("latetTime"));
			later.setReason(rs.getString("reason"));
			later.setStuID(rs.getString("stuID"));
			later.setStuName(rs.getString("stuName"));
			laterList.add(later);
		}
		return laterList;
	}
	
	public List<Later> Seach(String keywords) throws Exception{
		List<Later> laterList = new ArrayList<Later>();
		String sql = "select * from sys_later where 1=1";
			  if(keywords!=null){
			   sql="select * from sys_later where classID like '%"+keywords+"%'  ";
		      }
		ResultSet rs = dbUtil.executeQuery(sql, null);
		while(rs.next()){
			Later later = new Later();
			later.setDormID(rs.getString("dormID"));
			later.setLaterID(rs.getString("laterID"));
			later.setLaterTime(rs.getDate("latetTime"));
			later.setReason(rs.getString("reason"));
			later.setStuID(rs.getString("stuID"));
			later.setStuName(rs.getString("stuName"));
			laterList.add(later);
		}
		return laterList;
	}
	
	public Later findAllbyID(String ID)throws Exception{
		try {
			String sql = "select *  from sys_later WHERE laterID='"+ID+"'";
			
		    ResultSet rs = dbUtil.executeQuery(sql, null);
		    Later later = new Later();
		    while(rs.next()){
		    	later.setDormID(rs.getString("dormID"));
				later.setLaterID(rs.getString("laterID"));
				later.setLaterTime(rs.getDate("latetTime"));
				later.setReason(rs.getString("reason"));
				later.setStuID(rs.getString("stuID"));
				later.setStuName(rs.getString("stuName"));
		    }
		    return later;
		       }catch(SQLException e){
		       e.printStackTrace();
		       throw e;
		       }
	}
	
	public int edit(Later later)throws Exception{
		try {
			String sql = "update sys_later set reason=? WHERE laterID=?";
			Object params[] = new Object [2];
			params[0] = later.getReason();
			params[1] = later.getLaterID();
		    int count = dbUtil.executeUpate(sql, params);
		    return count;
		       }catch(Exception e){
		       e.printStackTrace();
		       throw e;
		       }
	}
	
	public int del(Later later)throws Exception{
		try {
			String sql = "delete from sys_later where laterID=?";
			Object params[] = new Object [1];
			params[0] = later.getLaterID();

		    int count = dbUtil.executeUpate(sql, params);
		    return count;
		       }catch(Exception e){
		       e.printStackTrace();
		       throw e;
		       }
	}
	
	public int add(Later later)throws Exception{
		try {
			String sql = "insert into sys_later(laterID,dormID,stuID,stuName,lateTime,reason,classID)values(?,?,?,?,?,?,?)";
			Object params[] = new Object [7];
			params[0] = later.getLaterID();
			params[1] = later.getDormID();
			params[2] = later.getStuID();
			params[3] = later.getStuName();
			params[4] = later.getLaterTime();
			params[5] = later.getReason();
			params[6] = later.getClassID();
		    int count = dbUtil.executeUpate(sql, params);
		    return count;
		       }catch(Exception e){
		       e.printStackTrace();
		       throw e;
		       }
	}
	
	public List<Student> findStubyID(String ID) throws Exception{
		List<Student> stuList = new ArrayList<Student>();
		String sql = "select * from sys_student where stuID = '"+ID+"'";
		ResultSet rs = dbUtil.executeQuery(sql, null);
		while(rs.next()){
			Student stu = new Student();
			stu.setBedID(rs.getString("bedID"));
			stu.setClassID(rs.getString("classID"));
			stu.setDormID(rs.getString("dormID"));
			stu.setGarde(rs.getString("garde"));
			stu.setPassword(rs.getString("password"));
			stu.setStuID(rs.getString("stuID"));
			stu.setStuName(rs.getString("stuName"));
			stuList.add(stu);
		}
		return stuList;
	}
	
	
}
