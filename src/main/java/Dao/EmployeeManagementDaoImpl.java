package Dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Controller.EmployeeManagementController;
import Model.Employee;
import Model.Manager;

@Repository
public class EmployeeManagementDaoImpl implements EmployeeManagementDao {

	 @Autowired  
	 private SessionFactory sessionFactory;  
	 private Logger log = org.slf4j.LoggerFactory.getLogger(EmployeeManagementController.class);
	public String manager_signUp(Manager manager) {
		String status="";
		try{
		
		sessionFactory.getCurrentSession().save(manager);
		status="success";
		}catch(Exception e){
			log.trace("Error occured in Manager Sign up:"+e);
		}
		return status;
	}

	public String manager_Login(Manager manager) {
		// TODO Auto-generated method stub
		String msg ="";
		Session session = sessionFactory.getCurrentSession();
		try{
		Query<Manager> query = session.createQuery("from Manager where mgr_email=:mgr_email and mgr_password=:mgr_password",Manager.class);
		System.out.println(manager.getMgr_email());
		System.out.println(manager.getMgr_password());
		query.setParameter("mgr_email",manager.getMgr_email());
		query.setParameter("mgr_password",manager.getMgr_password());
		int row = 0;
		List<Manager> temp = query.getResultList();
		Iterator iterator = temp.iterator();
		if(temp.size()>0){
			msg="success";
		}
		else{
			msg="failed";
		}
		}catch(Exception e){
			log.trace("Error occured in Manager Login:"+e);
		}
		return msg;
	}

	public String Create_Employee(Employee employee) {
		String status="";
		try{
		sessionFactory.getCurrentSession().save(employee);
		status="success";
		}catch(Exception e){
			log.trace("Error occured in Employee create:"+e);
		}
		return status;
	}

	public String Update_Employee(Employee employee) {
		String status="";
		try{
		sessionFactory.getCurrentSession().update(employee);
		status="success";
		}catch(Exception e){
			e.printStackTrace();
			status= "failed";
			log.trace("Error occured in Employee update:"+e);
		}
		return status;
	}

	public String Delete_Employee(Employee employee) {
		String status="";
		try{
		sessionFactory.getCurrentSession().delete(employee);
		status="success";
		}catch(Exception e){
			log.trace("Error occured in Employee delete:"+e);
		}
		return status;
	}

	public List<Employee> fetchAll_Employee(Employee employee) {
		// TODO Auto-generated method stub
		List<Employee> empList = new ArrayList<Employee>();
		Session session = sessionFactory.getCurrentSession();
		try{
		Query<Employee> query = session.createQuery("from Employee where emp_mgrId=:emp_mgrId",Employee.class);
		query.setParameter("emp_mgrId",employee.getEmp_mgrId());
		empList = query.getResultList();
		}catch(Exception e){
			log.trace("Error occured in Employee fetchall:"+e);
		}
		return empList;
	}

}
