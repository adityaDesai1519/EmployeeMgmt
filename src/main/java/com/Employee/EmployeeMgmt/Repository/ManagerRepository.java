package com.Employee.EmployeeMgmt.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.Employee.EmployeeMgmt.Model.Manager;

public interface ManagerRepository extends CrudRepository<Manager,String> {
	@Query("SELECT m FROM Manager m WHERE m.mgr_email=:mgr_email")
	List<Manager> findByMgr_email(@Param("mgr_email") String mgr_email);
	@Query("SELECT m FROM Manager m WHERE m.mgr_email=:mgr_email AND m.mgr_password=:mgr_password")
	List<Manager> findByMgr_emailMgr_password(@Param("mgr_email") String mgr_email,@Param("mgr_password")String mgr_password);
}
