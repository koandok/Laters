<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/base/base.jsp"%>
<%@ include file="/base/database.jsp" %>
<% 
   //接收参数
    String userid=request.getParameter("userid");
   //根据参数读取数据库响应记录
   Connection conn=getConn();
   String sql="select * from t_user where userid=?";
   PreparedStatement pstmt=conn.prepareStatement(sql);
   pstmt.setString(1, userid);
   ResultSet rs=pstmt.executeQuery();
   String rs_userid ="";
   String rs_pwd  ="";
   String rs_utype  ="";
   String rs_sex    ="";
   String rs_birthday ="";
   String rs_xq     ="";
   String rs_email  ="";
   String rs_remark ="";
   String rs_fullname="";
   boolean a_flag=false;
   boolean b_flag=false;
   boolean c_flag=false;
   if(rs.next()){
	       rs_userid =rs.getString("userid");
	       rs_pwd  =rs.getString("pwd");
	       rs_utype  =rs.getString("utype");
	       rs_sex    =rs.getString("sex");
	       rs_birthday =rs.getString("birthday");
	       rs_xq     =rs.getString("xq");//A-B-C
	       rs_email  =rs.getString("email");
	       rs_remark =rs.getString("remark");
	       rs_fullname=rs.getString("fullname");
	       
	       //转换
	       if(rs_xq!=null){
	    	  String[] xqs= rs_xq.split("-");
	    	  for(String s:xqs){
	    		  if("A".equals(s)){
	    			  a_flag=true;
	    		  }
	    		  if("B".equals(s)){
	    			  b_flag=true;
	    		  }
	    		  if("C".equals(s)){
	    			  c_flag=true;
	    		  }
	    	  }
	       }
	   
   }
   //使用表达式显示
   //跳转，无
%>
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
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>编辑用户</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="page/user/action_editUser.jsp">  
      <div class="form-group">
        <div class="label">
          <label>用户名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" readonly="readonly" value="<%=rs_userid %>" name="userid" data-validate="required:数据必填项" />
          <div class="tips"></div>
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>密码：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="<%=rs_pwd %>" name="pwd" data-validate="required:数据必填项" />
          <div class="tips"></div>
        </div>
      </div>
        <div class="form-group">
        <div class="label">
          <label>姓名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="<%=rs_fullname %>" name="fullname" data-validate="required:数据必填项" />
          <div class="tips"></div>
        </div>
      </div>
    
  
        <div class="form-group">
          <div class="label">
            <label>用户类型：</label>
          </div>
          <div class="field">
            <select name="utype" class="input w50">
              <option value="1" <%if("1".equals(rs_utype)){ %>selected="selected" <%} %>>管理员</option>
              <option value="0" <%if("0".equals(rs_utype)){ %>selected="selected" <%} %>>普通用户</option>
            </select>
            <div class="tips"></div>
          </div>
        </div>
        <div class="form-group">
          <div class="label">
            <label>用户类型：</label>
          </div>
          <div class="field">
           
        
        <label for="sex_f">女</label>
				<input type="radio" name="sex" id="sex_f" value="1" 
				<%if("1".equals(rs_sex)){ %>checked="checked" <%} %>/>
				<label for="sex_m">男</label>
				<input type="radio" name="sex" id="sex_m" value="0" 
				<%if("0".equals(rs_sex)){ %>checked="checked" <%} %>/>
            <div class="tips"></div>
          </div>
        </div>
        <div class="form-group">
        <div class="label">
          <label>出生年月：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="<%=rs_birthday %>" name="birthday" data-validate="required:数据必填项" />
          <div class="tips"></div>
        </div>
      </div>
        <div class="form-group">
          <div class="label">
            <label>兴趣爱好：</label>
          </div>
          <div class="field" style="padding-top:8px;"> 
           阅读 <input id="xq_A"  type="checkbox" name="xq" value="A" <%if(a_flag){ %>checked="checked" <%} %>/>
          音乐 <input id="xq_B"  type="checkbox" name="xq" value="B" <%if(b_flag){ %>checked="checked" <%} %>/>
           运动 <input id="xq_C"  type="checkbox" name="xq" value="C" <%if(c_flag){ %>checked="checked" <%} %>/> 
         
          </div>
        </div>
 <div class="form-group">
        <div class="label">
          <label>电子邮箱：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="<%=rs_email %>" name="email" data-validate="required:数据必填项" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>自我介绍：</label>
        </div>
        <div class="field">
          <textarea class="input" name="remark" style=" height:90px;"><%=rs_remark %></textarea>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
        </div>
      </div>
    </form>
  </div>
</div>

</body>
</html>
