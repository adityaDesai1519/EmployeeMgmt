package Controller;

import java.util.List;

import javax.persistence.PostUpdate;

import org.apache.commons.logging.Log;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Model.Employee;
import Model.Manager;
import Service.EmployeeManagementService;

@RestController
@CrossOrigin(origins="http://localhost:4200")  
@RequestMapping(value="/api")
public class EmployeeManagementController {
	
	@Autowired 
	private EmployeeManagementService employeeManagementService;
	
	@GetMapping("/hello_test")
	public String testFunc(){
		System.out.println("Hello");
		return "Hello User:";
	}
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(
			  value = "/manager_SignUp", 
			  method = {RequestMethod.POST})
	public String manager_signUp(@RequestBody Manager manager){
		
		return employeeManagementService.manager_signUp(manager);
	}
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(
			  value = "/Create_employee", 
			  method = {RequestMethod.POST})
	public String Create_Employee(@RequestBody Employee employee) {
		return employeeManagementService.Create_Employee(employee);
	}
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(
			  value = "/fetchall_Employee", 
			  method = {RequestMethod.GET})
	public List<Employee> fetchAll_Employee(@RequestParam("emp_mgrId") String emp_mgrId,Employee employee) {
		System.out.println(emp_mgrId);
		employee.setEmp_mgrId(emp_mgrId);
		return employeeManagementService.fetchAll_Employee(employee);
	}
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(
			  value = "/Update_employee", 
			  method = {RequestMethod.POST})
	public String Update_Employee(@RequestBody Employee employee) {
		System.out.println(employee.getEmp_id());
		
		return employeeManagementService.Update_Employee(employee);
	}
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(
			  value = "/Delete_employee", 
			  method = {RequestMethod.GET})
	public String Delete_employee(@RequestParam("emp_Id") String emp_Id,Employee employee){
		System.out.println(emp_Id);
		employee.setEmp_id(Integer.parseInt(emp_Id));
		return employeeManagementService.Delete_Employee(employee);
	}
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(
			  value = "/manager_Login_POST", 
			  method = {RequestMethod.POST})
	public String manager_Login_POST(@RequestBody Manager manager) {
		return employeeManagementService.manager_Login(manager);
	}
}
