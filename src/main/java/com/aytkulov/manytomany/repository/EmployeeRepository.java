package com.aytkulov.manytomany.repository;


import com.aytkulov.manytomany.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
