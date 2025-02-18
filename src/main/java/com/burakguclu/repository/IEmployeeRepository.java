package com.burakguclu.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.burakguclu.model.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer>{

	@Query(value = "from Employee")
	List<Employee> findAllEmployees();
	
	@Query(value = "from Employee e WHERE e.id = :employeeID")
	Optional<Employee> findEmployeeByID(Integer employeeID);
	
	@Query("from Employee e WHERE e.firstName = :employeeName")
	Optional<Employee> findByName(String employeeName);
}
