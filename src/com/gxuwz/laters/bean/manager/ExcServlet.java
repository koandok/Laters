package com.gxuwz.laters.bean.manager;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.*;

import com.gxuwz.laters.bean.entity.*;

public class ExcServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
        List<Later> list = new ArrayList<Later>();  
        String keywords = request.getParameter("keywords");
        System.out.println(keywords);
        LaterManager latermanager = new LaterManager();
        list = latermanager.findAll(keywords);
        ExcManager m = new ExcManager();
        HSSFWorkbook wb = m.export(list);  
        response.setContentType("application/vnd.ms-excel");  
        response.setHeader("Content-disposition", "attachment;filename=later.xls");  
        OutputStream ouputStream = response.getOutputStream();  
        wb.write(ouputStream);  
        ouputStream.flush();  
        ouputStream.close();  
	}catch(Exception e){
		e.printStackTrace();
	}

}}
