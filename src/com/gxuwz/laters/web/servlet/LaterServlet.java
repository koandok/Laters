package com.gxuwz.laters.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gxuwz.laters.bean.entity.*;
import com.gxuwz.laters.bean.manager.*;

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
		//ѡ��ṹ
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
		}else if("adds".equals(action)){
			try {
				gets(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public void edit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try{
	
			String buildID = request.getParameter("buildID");
			String buildName = request.getParameter("buildName");
			
			//ʵ����user
			Building build = new Building();
		//�Ѳ�����Ӧ����ʵ����user������
	build.setBuildID(buildID);
	build.setBuildName(buildName);
		
	BuildManager buildmanager = new BuildManager();
		
		if(buildmanager.edit(build)>0){
		//response.sendRedirect("/leaveMVC/WebRoot/page/user/user_updata.jsp");
		list(request, response);
		}else{
		//response.sendRedirect("/leaveMVC/WebRoot/page/user/user_updata.jsp");	
			proccess(request, response, "/page/user/user_updata.jsp");
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		}
	public void del(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try{
	
			String buildID = request.getParameter("buildID");
			
			//ʵ����user
			Building build = new Building();
		//�Ѳ�����Ӧ����ʵ����user������
	build.setBuildID(buildID);
	
		
	BuildManager buildmanager = new BuildManager();
		
		if(buildmanager.del(build)>0){
		//response.sendRedirect("/leaveMVC/WebRoot/page/user/user_updata.jsp");
		list(request, response);
		}else{
		//response.sendRedirect("/leaveMVC/WebRoot/page/user/user_updata.jsp");	
			proccess(request, response, "/page/user/user_update.jsp");
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		}
		
		public void get(HttpServletRequest request, HttpServletResponse response) throws Exception {
			String buildID = request.getParameter("buildID");;
			//ʵ����user
			
			Building build = new Building();		
			BuildManager buildmanager = new BuildManager();
			build = buildmanager.findAllbyID(buildID);
			request.setAttribute("build", build);
			proccess(request, response, "/page/building/building_update.jsp");
			
	}
		public void gets(HttpServletRequest request, HttpServletResponse response) throws Exception {
			String stuID = request.getParameter("stuID");;
			//ʵ����user
			
			Student  stu   = new Student();		
			LaterManager latermanager = new LaterManager();
			stu = buildmanager.findAllbyID(buildID);
			request.setAttribute("build", build);
			proccess(request, response, "/page/building/building_update.jsp");
			
	}

		public void add(HttpServletRequest request, HttpServletResponse response) throws Exception {
			try{
			
			String buildID = request.getParameter("buildID");
			String buildName = request.getParameter("buildName");
			
			//ʵ����user
			Building build = new Building();
			//�Ѳ�����Ӧ����ʵ����user������
			build.setBuildID(buildID);
			build.setBuildName(buildName);
			
			BuildManager buildmanager = new BuildManager();
			
			if(buildmanager.add(build)>0){
			//response.sendRedirect("/leaveMVC/WebRoot/page/user/user_updata.jsp");
			list(request, response);
			}else{
			//response.sendRedirect("/leaveMVC/WebRoot/page/user/user_updata.jsp");	
				proccess(request, response, "/page/build/build_add.jsp");
			}
			}catch(Exception e){
				e.printStackTrace();
			}
			}
		public void list(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
			List<Building> buildList = new ArrayList<Building>();			
			BuildManager buildmanager = new BuildManager();
			buildList = buildmanager.findAll();
			request.setAttribute("buildList", buildList);
			proccess(request, response, "/page/building/building_list.jsp");
			
	}
		
		public void seach(HttpServletRequest request, HttpServletResponse response) throws Exception {
			String keywords= request.getParameter("keywords");
			List<Building> buildList = new ArrayList<Building>();			
			BuildManager buildmanager = new BuildManager();
			buildList = buildmanager.Seach(keywords);
			request.setAttribute("buildList", buildList);
			proccess(request, response, "/page/building/building_list.jsp");
			
			
	}
}