package com.gxuwz.laters.bean.entity;
import java.util.*;


public class Leave {
/*	<td><%=leaveID%></td>
	<td><%=courseID%></td>
	<td><%=reason%></td>
	<td><%=daynum%></td>
	<td><%=stuID%></td>
	<td><%=applytime%></td>
	<td><%=status%></td>
	<td><%=audittime%></td>
	<td><%=opinion%></td>
	int daynum = rs.getInt("daynum");
	Date applytime = rs.getDate("applytime");*/
	private String leaveID;
	private String courseID;
	private String reason;
	private String stuID;
	private String status;
	private String audittime;
	private String opinion;
	private int daynum;
	private Date applytime;
	public String getLeaveID() {
		return leaveID;
	}
	public void setLeaveID(String leaveID) {
		this.leaveID = leaveID;
	}
	public String getCourseID() {
		return courseID;
	}
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getStuID() {
		return stuID;
	}
	public void setStuID(String stuID) {
		this.stuID = stuID;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAudittime() {
		return audittime;
	}
	public void setAudittime(String audittime) {
		this.audittime = audittime;
	}
	public String getOpinion() {
		return opinion;
	}
	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}
	public int getDaynum() {
		return daynum;
	}
	public void setDaynum(int daynum) {
		this.daynum = daynum;
	}
	public Date getApplytime() {
		return applytime;
	}
	public void setApplytime(Date applytime) {
		this.applytime = applytime;
	}
}
