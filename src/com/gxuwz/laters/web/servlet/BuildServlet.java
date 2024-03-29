package com.gxuwz.laters.web.servlet;
import java.io.IOException;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.gxuwz.laters.bean.entity.Building;
import com.gxuwz.laters.bean.manager.BuildManager;




/**
 * Servlet implementation class BuildServlet
 */
public class BuildServlet extends HttpServlet {

private void proccess(HttpServletRequest request,HttpServletResponse response,String path)throws ServletException,IOException{
		
		RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request, response);
		
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//定义区分不同处理动作类型参数: list:表示显示列表，add表示添加，input表示录入，edit表示修改，get表示读取单个用户信息
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
				}

	
	}

	public void edit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try{
	
			String buildID = request.getParameter("buildID");
			String buildName = request.getParameter("buildName");
			
			//实例化user
			Building build = new Building();
		//把参数对应放入实体类user属性中
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
			
			//实例化user
			Building build = new Building();
		//把参数对应放入实体类user属性中
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
			//实例化user
			
			Building build = new Building();		
			BuildManager buildmanager = new BuildManager();
			build = buildmanager.findAllbyID(buildID);
			request.setAttribute("build", build);
			proccess(request, response, "/page/building/building_update.jsp");
			
	}

		public void add(HttpServletRequest request, HttpServletResponse response) throws Exception {
			try{
			
			String buildID = request.getParameter("buildID");
			String buildName = request.getParameter("buildName");
			
			//实例化user
			Building build = new Building();
			//把参数对应放入实体类user属性中
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
