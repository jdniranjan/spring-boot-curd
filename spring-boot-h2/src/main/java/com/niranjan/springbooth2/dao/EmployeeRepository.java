package com.niranjan.springbooth2.dao;

import com.niranjan.springbooth2.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {


}
