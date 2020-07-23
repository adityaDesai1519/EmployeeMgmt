package com.Employee.EmployeeMgmt.Model;

import java.sql.Date;

import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;  
import javax.persistence.GenerationType;  
import javax.persistence.Id;  
import javax.persistence.Table;  


@Entity

public class Employee {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int emp_id;
private String emp_fname;
private String emp_lname;
private String emp_address;
private String emp_dob;
private String emp_mobile;
private String emp_city;
private String emp_mgrid;
protected Employee(){}
protected Employee(String emp_fname,String emp_lname,String emp_address,String emp_dob,String emp_mobile,String emp_city,String emp_mgrId){
	this.emp_fname = emp_fname;
	this.emp_lname = emp_lname;
	this.emp_address = emp_address;
	this.emp_city = emp_city;
	this.emp_dob = emp_dob;
	this.emp_mobile = emp_mobile;
	this.emp_mgrid = emp_mgrId;
}
public String getEmp_mgrid() {
	return emp_mgrid;
}
public void setEmp_mgrid(String emp_mgrId) {
	this.emp_mgrid = emp_mgrId;
}
public int getEmp_id() {
	return emp_id;
}
public void setEmp_id(int emp_id) {
	this.emp_id = emp_id;
}
public String getEmp_fname() {
	return emp_fname;
}
public void setEmp_fname(String emp_fname) {
	this.emp_fname = emp_fname;
}
public String getEmp_lname() {
	return emp_lname;
}
public void setEmp_lname(String emp_lname) {
	this.emp_lname = emp_lname;
}
public String getEmp_address() {
	return emp_address;
}
public void setEmp_address(String emp_address) {
	this.emp_address = emp_address;
}
public String getEmp_dob() {
	return emp_dob;
}
public void setEmp_dob(String emp_dob) {
	this.emp_dob = emp_dob;
}
public String getEmp_mobile() {
	return emp_mobile;
}
public void setEmp_mobile(String emp_mobile) {
	this.emp_mobile = emp_mobile;
}
public String getEmp_city() {
	return emp_city;
}
public void setEmp_city(String emp_city) {
	this.emp_city = emp_city;
}
}
