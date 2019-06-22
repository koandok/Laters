<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/base/base.jsp"%>
<%@ page import = "com.gxuwz.laters.bean.manager.*" %>
<%@ page import = "com.gxuwz.laters.bean.entity.*" %>
<%@ page import = "com.gxuwz.laters.tools.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>信息列表</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<link rel="shortcut icon" href="images/logo.jpg">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>

</head>

<body>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="<%=path%>/LaterServlet?action=add">  
    <%
      Student stu = (Student)request.getAttribute("stu");
      DateUtil dateutil = new DateUtil();
    
     %>
      <div class="form-group">
        <div class="label">
          <label>晚归记录ID：</label>
        </div>
        <div class="field" align="center">
          <input  type="text" class="input w50" value="<%=dateutil.IDbyDateNow() %>" name="laterID" readonly="readonly" />
          <div class="tips"></div>
        </div>
      </div>

      <div class="form-group">
        <div class="label">
          <label>宿舍号：</label>
        </div>
        <div class="field" align="center">
          <input type="text" class="input w50" value="<%=stu.getDormID() %>" name="dormID" data-validate="required:请输入班号"readonly="readonly" />
          <div class="tips"></div>
        </div>
      </div>
      
            <div class="form-group">
        <div class="label">
          <label>学生ID：</label>
        </div>
        <div class="field" align="center">
          <input type="text" class="input w50" value="<%=stu.getStuID() %>" name="stuID" data-validate="required:请输入班号"readonly="readonly" />
          <div class="tips"></div>
        </div>
      </div>
      
                       <div class="form-group">
        <div class="label">
          <label>班级ID：</label>
        </div>
        <div class="field" align="center">
          <input type="text" class="input w50" value="<%=stu.getClassID() %>" name="classID" data-validate="required:请输入班号" readonly="readonly"/>
          <div class="tips"></div>
        </div>
      </div>
      
            <div class="form-group">
        <div class="label">
          <label>学生名字：</label>
        </div>
        <div class="field" align="center">
          <input type="text" class="input w50" value="<%=stu.getStuName() %>" name="stuName" data-validate="required:请输入班号"readonly="readonly" />
          <div class="tips"></div>
        </div>
      </div>
      
            <div class="form-group">
        <div class="label">
          <label>晚归时间：</label>
        </div>
        <div class="field" align="center">
          <input type="text" class="input w50" value="<%=dateutil.DateNow() %>" name="laterTime" data-validate="required:请输入班号" readonly="readonly"/>
          <div class="tips"></div>
        </div>
      </div>
      
                  <div class="form-group">
        <div class="label">
          <label>原因：</label>
        </div>
        <div class="field" align="center">
          <input type="text" class="input w50" value="" name="reason" data-validate="required:请输入班号" />
          <div class="tips"></div>
        </div>
      </div>
      
 
            <%
				Object obj = request.getAttribute("flag");
				
				if (obj!= null){	
				 %>
				 <div style="txxt-align:center">
				 <span>error:操作失败</span>
				 </div>
				 <%}%> 

       <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field" >
          <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
        </div>
      </div>
    </form>
  </div>
</div>

</body>
</html>
