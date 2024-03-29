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
Later later = (Later)request.getAttribute("later");

 %>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>修改</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="<%=path %>/LaterServlet?action=edit">  
       <div class="form-group">
        <div class="label">
          <label>晚归记录ID：</label>
        </div>
        <div class="field" align="center">
          <input  type="text" class="input w50" value="<%=later.getLaterID() %>" name="laterID" readonly="readonly" />
          <div class="tips"></div>
        </div>
      </div>

      <div class="form-group">
        <div class="label">
          <label>宿舍号：</label>
        </div>
        <div class="field" align="center">
          <input type="text" class="input w50" value="<%=later.getDormID() %>" name="dormID" data-validate="required:请输入班号"readonly="readonly" />
          <div class="tips"></div>
        </div>
      </div>
      
            <div class="form-group">
        <div class="label">
          <label>学生ID：</label>
        </div>
        <div class="field" align="center">
          <input type="text" class="input w50" value="<%=later.getStuID() %>" name="stuID" data-validate="required:请输入班号"readonly="readonly" />
          <div class="tips"></div>
        </div>
      </div>
      
                       <div class="form-group">
        <div class="label">
          <label>班级ID：</label>
        </div>
        <div class="field" align="center">
          <input type="text" class="input w50" value="<%=later.getClassID() %>" name="classID" data-validate="required:请输入班号" readonly="readonly"/>
          <div class="tips"></div>
        </div>
      </div>
      
            <div class="form-group">
        <div class="label">
          <label>学生名字：</label>
        </div>
        <div class="field" align="center">
          <input type="text" class="input w50" value="<%=later.getStuName() %>" name="stuName" data-validate="required:请输入班号"readonly="readonly" />
          <div class="tips"></div>
        </div>
      </div>
      
            <div class="form-group">
        <div class="label">
          <label>晚归时间：</label>
        </div>
        <div class="field" align="center">
          <input type="text" class="input w50" value="<%=later.getLaterTime() %>" name="laterTime" data-validate="required:请输入班号" readonly="readonly"/>
          <div class="tips"></div>
        </div>
      </div>
      
            <div class="form-group">
        <div class="label">
          <label>请假事由：</label>
        </div>
        <div class="field">
          <textarea class="input w50" style="height:100px" name="reason" value="<%=later.getReason() %>"><%=later.getReason()%></textarea> 
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
