package com.Employee.EmployeeMgmt.Model;


import java.sql.Date;

import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;  
import javax.persistence.GenerationType;  
import javax.persistence.Id;  
import javax.persistence.Table;

@Entity
@Table(name="manager")
public class Manager {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int mgr_id;
	private String mgr_email;
	private String mgr_fname;
	private String mgr_lname;
	private String mgr_address;
	private String mgr_mobile;
	private String mgr_city;
	private String mgr_dept;
	private String mgr_password;
	
	public String getMgr_password() {
		return mgr_password;
	}
	public void setMgr_password(String mgr_password) {
		this.mgr_password = mgr_password;
	}
	public String getMgr_repassword() {
		return mgr_repassword;
	}
	public void setMgr_repassword(String mgr_repassword) {
		this.mgr_repassword = mgr_repassword;
	}
	private String mgr_repassword;
	public String getMgr_email() {
		return mgr_email;
	}
	public void setMgr_email(String mgr_email) {
		this.mgr_email = mgr_email;
	}
	public String getMgr_fname() {
		return mgr_fname;
	}
	public void setMgr_fname(String mgr_fname) {
		this.mgr_fname = mgr_fname;
	}
	public String getMgr_lname() {
		return mgr_lname;
	}
	public void setMgr_lname(String mgr_lname) {
		this.mgr_lname = mgr_lname;
	}
	public String getMgr_address() {
		return mgr_address;
	}
	public void setMgr_address(String mgr_address) {
		this.mgr_address = mgr_address;
	}
	
	public String getMgr_mobile() {
		return mgr_mobile;
	}
	public void setMgr_mobile(String mgr_mobile) {
		this.mgr_mobile = mgr_mobile;
	}
	public String getMgr_city() {
		return mgr_city;
	}
	public void setMgr_city(String mgr_city) {
		this.mgr_city = mgr_city;
	}
	public String getMgr_dept() {
		return mgr_dept;
	}
	public void setMgr_dept(String mgr_dept) {
		this.mgr_dept = mgr_dept;
	}
}
