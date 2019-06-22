package com.gxuwz.laters.bean.manager;

import java.sql.*;
import com.gxuwz.laters.database.DbUtil;

public class LoginManager {
	private DbUtil dbUtil =new DbUtil();

	public boolean ruserlogin(String name, String password) throws Exception {
			boolean a = false;
			String sql = "select * from sys_ruser where ruserID = '"+name+"'and password = '"+password+"'";
			ResultSet rs = dbUtil.executeQuery(sql, null);
			if(rs.next()){
				a = true;
			}
			return a;
	}

	public boolean stulogin(String name, String password) throws Exception {
		boolean a = false;
		String sql = "select * from sys_student where stuID = '"+name+"'and password = '"+password+"'";
		ResultSet rs = dbUtil.executeQuery(sql, null);
		if(rs.next()){
			a = true;
		}
		return a;
	}

	public boolean instlogin(String name, String password) throws Exception {
		boolean a = false;
		String sql = "select * from sys_instructor where instID = '"+name+"'and password = '"+password+"'";
		ResultSet rs = dbUtil.executeQuery(sql, null);
		if(rs.next()){
			a = true;
		}
		return a;
	}
}
