package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Dao.EmployeeManagementDao;
import Model.Employee;
import Model.Manager;

@Service
@Transactional
public class EmployeeManagementServiceImpl implements EmployeeManagementService {

	@Autowired
	private EmployeeManagementDao employeeManagementDao;
	
	public String manager_signUp(Manager manager) {
		// TODO Auto-generated method stub
		return employeeManagementDao.manager_signUp(manager);
	}

	public String manager_Login(Manager manager) {
		// TODO Auto-generated method stub
		return employeeManagementDao.manager_Login(manager);
	}

	public String Create_Employee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeManagementDao.Create_Employee(employee);
	}

	public String Update_Employee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeManagementDao.Update_Employee(employee);
	}

	public String Delete_Employee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeManagementDao.Delete_Employee(employee);
	}

	public List<Employee> fetchAll_Employee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeManagementDao.fetchAll_Employee(employee);
	}

}
