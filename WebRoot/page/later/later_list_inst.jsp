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
<title>信息列表</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<link rel="shortcut icon" href="images/logo.jpg">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>

</head>

<body>
<form method="post" action="<%=path%>/LaterServlet?action=list_inst" id="listform">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 列表</strong> </div>
   <%--  <form method="post" action="<%=path%>/BuildServlet?action=seach" > --%>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">

        <li>搜索：</li>
          
          <li> <input type="text" placeholder="请输入搜索关键字" name="keywords" class="input" style="width:250px; line-height:17px;display:inline-block" />       
         <input type="submit" value="搜索"name="搜索" class="button border-main icon-search"  ></li>
<%--        <li>
          <input type="text" placeholder="请输入搜索关键字" name="keywords" class="input" style="width:250px; line-height:17px;display:inline-block" />
          <a href="<%=path%>/BuildServlet?action=seach" class="button border-main icon-search" onclick="changesearch()" > 搜索</a></li> --%>
                <%String keywords = request.getParameter("keywords"); %>
      <div class="button-group"> <a class="button border-main" href="<%=path%>/ExcServlet?keywords=<%=keywords%>"><span class="icon-edit"></span> 导出</a></div>
      </ul>

    </div>
    <!-- </form>  -->
     
     
    <table class="table table-hover text-center">
      <tr>
       <th>序号</th>
				<th>迟到表号</th>
				<th>宿舍号</th>
				<th>学生号</th>
				<th>学生名字</th>
				<th>迟到时间</th>
				<th>班级ID</th>
				<th>原因</th>
      </tr>
    
				
				
			<%--读取所有用户信息记录 --%>
			<%  //设置编码方式
			
		       List<Later> laterList = new ArrayList<Later>();
			   laterList = (List)request.getAttribute("laterList");
			   int index = 1;
			   for(Later later : laterList){
			   String laterID = later.getLaterID();
			   String dormID = later.getDormID();
			   String stuID = later.getStuID();
			   String stuName = later.getStuName();
			   Date laterTime = later.getLaterTime();
			   String reason = later.getReason();
			   String classID = later.getClassID();
			%>

			<tr>
				<td><%=index++%></td>
				<td><%=laterID%></td>
				<td><%=dormID%></td>
				<td><%=stuID%></td>
				<td><%=stuName%></td>
				<td><%=laterTime%></td>
				<td><%=classID%></td>
				<td><%=reason%></td>
				
			</tr>
			<%
				}
			%>
    </table>
    
  </div>
  
  <div class="pagelist"> <a href="">上一页</a> <span class="current">1</span><a href="">2</a><a href="">3</a><a href="">下一页</a><a href="">尾页</a> </div>
</form>
</body>
</html>
