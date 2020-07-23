package com.Employee.EmployeeMgmt.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.Employee.EmployeeMgmt.Model.Manager;
import com.Employee.EmployeeMgmt.Repository.ManagerRepository;

@RestController
@RequestMapping(value="/manager")
@CrossOrigin("http://localhost:4200")
public class ManagerController {
	
	private ManagerRepository managerRepository;
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	public ManagerController(ManagerRepository managerRepository){
		this.managerRepository = managerRepository;
	}
	
	@CrossOrigin("http://localhost:4200")
	@GetMapping(value="/fetchManager")
	public List<Manager> fetchManager(@RequestParam String mgr_email,@RequestParam String mgr_password){
		logger.info("Inside [ManagerController]:[findAllByManagerEmail]");
		return managerRepository.findByMgr_emailMgr_password(mgr_email, mgr_password);
	}

	@GetMapping
	public Iterable<Manager> fetchAllManagers(){
		logger.info("Inside [ManagerController]:[fetchAllManagers]");
		return managerRepository.findAll();
	}
	@PostMapping
	public String addManager(@RequestBody Manager manager){
		logger.info("Inside [ManagerController]:[addManager]");
		String message="failed";
		List<Manager> check = managerRepository.findByMgr_email(manager.getMgr_email());
		System.out.println(check.size());
		if(check.size()<=0){
			Manager newManager= managerRepository.save(manager);
			if(newManager.getMgr_email().equalsIgnoreCase(manager.getMgr_email())){
				message="success";
			}
		}
		else{
			message="Manager email already exist!";
		}
		return message;
	}
}
