package com.Employee.EmployeeMgmt.Controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Employee.EmployeeMgmt.Model.Employee;
import com.Employee.EmployeeMgmt.Repository.EmployeeRepository;


@RestController
@RequestMapping(value="/employee")
@CrossOrigin("http://localhost:4200")

@PreAuthorize("isAuthenticated()")
public class EmployeeController{
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	private EmployeeRepository employeeRepository;
	protected EmployeeController(EmployeeRepository employeeRepository){
		this.employeeRepository = employeeRepository;
	}
	
	@GetMapping(value="/fetchAllByManagerEmail")
	public Iterable<Employee> findAllByManagerEmail(@RequestParam("emp_mgrid")String emp_mgrid){
		logger.info("Inside [EmployeeController]:[findAllByManagerEmail]");
		return employeeRepository.findByemp_mgrId(emp_mgrid);
	}

	@GetMapping
	public Iterable<Employee> fetchAll(){
		logger.info("Inside [EmployeeController]:[fetchAll]");
		return employeeRepository.findAll();
	}
	
	@CrossOrigin("http://localhost:4200")
	@PostMapping
	public String createEmployee(@RequestBody Employee employee){
		logger.info("Inside [EmployeeController]:[createEmployee]");
		String msg="failed";
		Employee temp = employeeRepository.save(employee);
		if(temp.getEmp_fname().equalsIgnoreCase(employee.getEmp_fname())){
			msg="success";
		}
		return msg;
	}
	@CrossOrigin("http://localhost:4200")
	@PutMapping("{emp_id}")
	public String updateEmployee(@PathVariable("emp_id") String emp_id,@RequestBody Employee employee){
		logger.info("Inside [EmployeeController]:[updateEmployee]");
		String msg="failed";
		Employee temp =employeeRepository.save(employee); 
		if(temp.getEmp_id() == employee.getEmp_id()){
			msg="success";
		}
		return msg;
	}
	@CrossOrigin("http://localhost:4200")
	@DeleteMapping("{emp_id}")
	public String deleteEmployee(@PathVariable("emp_id")String emp_id){
		logger.info("Inside [EmployeeController]:[deleteEmployee]");
		String msg="";
		try{
			employeeRepository.deleteById(Integer.parseInt(emp_id));
			msg="success";
		}catch(Exception e){
			logger.info("Exception occured in [EmployeeController]:[deleteEmployee]"+e);
			msg="failed";
		}
		return msg;
	}

}
