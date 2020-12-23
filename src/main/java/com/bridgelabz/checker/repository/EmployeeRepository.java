package com.bridgelabz.checker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bridgelabz.checker.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	@Query(value = "select department from employee_department where employee_id=:id", nativeQuery = true)
	List<String> findDepartmentsById(long id);

}
