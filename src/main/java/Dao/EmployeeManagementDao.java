package Dao;

import java.util.List;

import Model.Employee;
import Model.Manager;

public interface EmployeeManagementDao {
	public String manager_signUp(Manager manager);
	public String manager_Login(Manager manager);
	public String Create_Employee(Employee employee);
	public String Update_Employee(Employee employee);
	public String Delete_Employee(Employee employee);
	public List<Employee> fetchAll_Employee(Employee employee);
}
