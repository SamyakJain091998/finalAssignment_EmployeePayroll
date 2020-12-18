package com.bridgelabz.checker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.checker.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
