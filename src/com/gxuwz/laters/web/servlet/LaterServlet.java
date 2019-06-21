package com.gxuwz.laters.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gxuwz.laters.bean.entity.*;
import com.gxuwz.laters.bean.manager.*;
import com.gxuwz.laters.tools.DateUtil;

public class LaterServlet extends HttpServlet {
private void proccess(HttpServletRequest request,HttpServletResponse response,String path)throws ServletException,IOException{
		
		RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request, response);
		
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action=request.getParameter("action");
		System.out.println("11111111111"+action);
		//选择结构
		if("list".equals(action)){
			try {
				list(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("add".equals(action)){
			try {
				add(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("list_inst".equals(action)){
			try {
				list_inst(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("seach".equals(action)){
			try {
				seach(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("edit".equals(action)){
			try {
				edit(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("get".equals(action)){
			try {
				get(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("del".equals(action)){
			try {
				del(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("getstu".equals(action)){
			try {
				getstu(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public void edit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try{
			DateUtil dateutil = new DateUtil(); 
			String laterID = request.getParameter("laterID");
			String reason = request.getParameter("reason");
			Later later = new Later();	
			later.setLaterID(laterID);
			later.setReason(reason);
			LaterManager latermanager = new LaterManager();

		if(latermanager.edit(later)>0){
		//response.sendRedirect("/leaveMVC/WebRoot/page/user/user_updata.jsp");
		list(request, response);
		}else{
			proccess(request, response, "/page/user/user_updata.jsp");
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		}
	public void del(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try{
			String laterID = request.getParameter("laterID");
			//实例化user
			Later later = new Later();
		//把参数对应放入实体类user属性中
			later.setLaterID(laterID);
			LaterManager latermanager = new LaterManager();
		
		if(latermanager.del(later)>0){
		list(request, response);
		}else{
			list(request, response);
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		}
		
	public void get(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String LaterID = request.getParameter("laterID");
		Later later = new Later();
		LaterManager latermanager = new LaterManager();
		later = latermanager.findAllbyID(LaterID);
		request.setAttribute("later", later);
		proccess(request, response, "/page/later/later_update.jsp");
		
}
		public void getstu(HttpServletRequest request, HttpServletResponse response) throws Exception {
			String stuID = request.getParameter("stuID");;
			Student  stu   = new Student();		
			LaterManager latermanager = new LaterManager();
			stu = latermanager.findStubyID(stuID);
			if(stu.getStuID()!=null){
			request.setAttribute("stu", stu);
			proccess(request, response, "/page/later/later_add.jsp");
			}else{
				request.setAttribute("flag", "error");	
				list(request, response);
			}
	}

		public void add(HttpServletRequest request, HttpServletResponse response) throws Exception {
			try{
			DateUtil dateutil = new DateUtil(); 
			String laterID = request.getParameter("laterID");
			String dormID = request.getParameter("dormID");
			String stuID = request.getParameter("stuID");
			String stuName = request.getParameter("stuName");
			String laterTime = request.getParameter("laterTime");
			String reason = request.getParameter("reason");
			String classID = request.getParameter("classID");
			//实例化user
			Later later = new Later();
			//把参数对应放入实体类user属性中
			later.setClassID(classID);
			later.setDormID(dormID);
			later.setLaterID(laterID);
			later.setLaterTime(dateutil.StringtoD(laterTime));
			later.setReason(reason);
			later.setStuID(stuID);
			later.setStuName(stuName);
			LaterManager latermanager = new LaterManager();
			
			if(latermanager.add(later)>0){
		
			list(request, response);
			}else{
				list(request, response);
				}
			}catch(Exception e){
				e.printStackTrace();
				}
			}
		public void list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
			List<Later> laterList = new ArrayList<Later>();			
			LaterManager latermanager = new LaterManager();
			laterList = latermanager.findAll(null);
			request.setAttribute("laterList", laterList);
			proccess(request, response, "/page/later/later_list.jsp");
			
	}
		public void list_inst(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
			List<Later> laterList = new ArrayList<Later>();			
			LaterManager latermanager = new LaterManager();
			laterList = latermanager.findAll(null);
			request.setAttribute("laterList", laterList);
			proccess(request, response, "/page/later/later_list_inst.jsp");
			
	}	
		public void seach(HttpServletRequest request, HttpServletResponse response) throws Exception {
			String keywords= request.getParameter("keywords");
			System.out.println(keywords);
			List<Later> laterList = new ArrayList<Later>();			
			LaterManager latermanager = new LaterManager();
			laterList = latermanager.findAll(keywords);
			request.setAttribute("laterList", laterList);
			proccess(request, response, "/page/later/later_list_inst.jsp");
			
			
	}
}
