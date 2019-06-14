package com.gxuwz.laters.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtil {
	public String DateNow(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
	
	public String DatetoS(Date date){
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
	public Date StringtoD(String string) throws ParseException{
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    return sdf.parse(string);
	}
	
	public String IDbyDateNow(){
		Date t = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
				int i=(int)(Math.random()*900)+100; 
				String ID = df.format(t)+String.valueOf(i);
				return ID;
	}
}
