package com.gxuwz.laters.bean.manager;
import com.gxuwz.laters.bean.entity.User;
import com.gxuwz.laters.database.DbUtil;
import java.util.*;
import java.sql.*;
public class UserManager {
	private DbUtil dbUtil =new DbUtil();
	
	
	public int edit(User user)throws Exception{
		try {
			String sql = "update sys_user set fullname = ?,password=?,telephone=? WHERE userid=?";
			Object params[] = new Object [4];
			params[0] = user.getFullname();
			params[1] = user.getPwd();
			params[2] = user.getTelephone();
			params[3] = user.getUserid();
		    int count = dbUtil.executeUpate(sql, params);
		    return count;
		       }catch(Exception e){
		       e.printStackTrace();
		       throw e;
		       }finally{
		   		dbUtil.closeall();
		   	}
	}
	
	public User findAllbyID(String ID)throws Exception{
		try {
			String sql = "select * from  WHERE userid='"+ID+"'";
			
		    ResultSet rs = dbUtil.executeQuery(sql, null);
		    User user =new User();
		    while(rs.next()){
		    	user.setFullname(rs.getString("fullname"));
		    	user.setPwd(rs.getString("password"));
		    	user.setTelephone(rs.getString("telephone"));
		    	user.setUserid(rs.getString("userid"));
		    }
		    return user;
		       }catch(Exception e){
		       e.printStackTrace();
		       throw e;
		       }finally{
		   		dbUtil.closeall();
		   	}
	}
}
