package com.Employee.EmployeeMgmt.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.Employee.EmployeeMgmt.Model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
	@Query("SELECT e FROM Employee e where e.emp_mgrid=:emp_mgrid")
	List<Employee> findByemp_mgrId(@Param("emp_mgrid") String emp_mgrid);
}
