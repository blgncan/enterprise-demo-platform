package com.blgncan.enterprise.api.repository;

import com.blgncan.enterprise.api.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


}
