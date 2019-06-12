package com.gxuwz.laters.bean.entity;

public class Student {
	private String stuID;
	private String classID;
	private String stuName;
	private String bedID;
	private String password;
	private String dormID;
	private String garde;
	public Student(){
		
	}
	public String getBedID() {
		return bedID;
	}
	public void setBedID(String bedID) {
		this.bedID = bedID;
	}
	public String getDormID() {
		return dormID;
	}
	public void setDormID(String dormID) {
		this.dormID = dormID;
	}
	public String getGarde() {
		return garde;
	}
	public void setGarde(String garde) {
		this.garde = garde;
	}
	public String getStuID() {
		return stuID;
	}
	public void setStuID(String stuID) {
		this.stuID = stuID;
	}
	public String getClassID() {
		return classID;
	}
	public void setClassID(String classID) {
		this.classID = classID;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
