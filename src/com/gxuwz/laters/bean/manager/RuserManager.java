package com.gxuwz.laters.bean.manager;

import java.sql.ResultSet;
import java.sql.SQLException;


import com.gxuwz.laters.bean.entity.Ruser;
import com.gxuwz.laters.database.DbUtil;

public class RuserManager {
	private DbUtil dbUtil =new DbUtil();
	public Ruser findAllbyID(String ruserID)throws Exception{
		try {
			String sql = "select *  from sys_ruser WHERE ruserID='"+ruserID+"'";
			
		    ResultSet rs = dbUtil.executeQuery(sql, null);
		    Ruser ruser = new Ruser();
		    
		    while(rs.next()){
		    	ruser.setBuildID(rs.getString("buildID"));
		    	ruser.setPassword(rs.getString("password"));
		    	ruser.setRuserID(rs.getString("ruserID"));
		    	ruser.setRuserName(rs.getString("ruserName"));
		    }
		    return ruser;
		       }catch(SQLException e){
		       e.printStackTrace();
		       throw e;
		       }
	}
}
