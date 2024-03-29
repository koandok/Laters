<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/base/base.jsp"%>
<%@ page import = "com.gxuwz.laters.bean.manager.*" %>
<%@ page import = "com.gxuwz.laters.bean.entity.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>用户信息列表</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<link rel="shortcut icon" href="images/logo.jpg">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>

</head>

<body>
<%
Dorm dorm = (Dorm)request.getAttribute("dorm");

 %>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加用户</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="<%=path %>/DormServlet?action=edit">  
   <div class="form-group">
        <div class="label">
          <label>宿舍号：</label>
        </div>
        <div class="field" align="center">
          <input  type="text" class="input w50" value="<%=dorm.getDormID() %>" name="dormID"  readonly="ture"/>
          <div class="tips"></div>
        </div>
      </div>
      
       <div class="form-group">
        <div class="label">
          <label>学生号：</label>
        </div>
        <div class="field" align="center">
          <input  type="text" class="input w50" value="<%=dorm.getStuID() %>" name="stuID" readonly="ture" />
          <div class="tips"></div>
        </div>
      </div>
 
       <div class="form-group">
        <div class="label">
          <label>楼号：</label>
        </div>
        <div class="field" align="center">
          <input type="text" class="input w50" value="<%=dorm.getBuildID() %>" name="buildID" data-validate="required:请输入" readonly="ture"/>
          <div class="tips"></div>
        </div>
      </div>
 
       <div class="form-group">
        <div class="label">
          <label>床号：</label>
        </div>
        <div class="field" align="center">
		  <select name = "bedID"class="select w50"style="height:50px">
		    <option value = "<%=dorm.getBedID()%>"><%=dorm.getBedID()%></option>
	        <option value = "1"><%=1%></option>
	        <option value = "2"><%=2%></option>
	        <option value = "3"><%=3%></option>
	        <option value = "4"><%=4%></option>
	        <option value = "5"><%=5%></option>
	        <option value = "6"><%=6%></option>
	        <option value = "7"><%=7%></option>
	        <option value = "8"><%=8%></option>
		  </select>
          <div class="tips"></div>
        </div>
      </div>
 <%
				Object obj = request.getAttribute("flag");
				
				if (obj!= null){	
				 %>
				 <div style="txxt-align:center">
				 <span>error:键位冲突</span>
				 </div>
				 <%}%> 


       <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field" >
          <button class="button bg-main icon-check-square-o" type="submit"> 修改</button>
        </div>
      </div>
    </form>
  </div>
</div>

</body>
</html>
