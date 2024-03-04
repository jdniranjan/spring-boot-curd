package com.niranjan.springbooth2.controller;

import com.niranjan.springbooth2.dao.EmployeeRepository;
import com.niranjan.springbooth2.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("/")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

   @PostMapping("save")
    public void saveEmployee(@RequestBody Employee employee){

       employeeRepository.save(employee);
    }

    @GetMapping("get")
    public ResponseEntity<List<Employee>> getAllEmployees(){
       return new ResponseEntity<>(employeeRepository.findAll(), HttpStatusCode.valueOf(233));

    }


    @GetMapping("/getEmployee/{id}")
    public ResponseEntity<Employee> getEmployeesByDept(@PathVariable Integer id) {
        Optional<Employee> emp = employeeRepository.findById(id);

        if (emp.isPresent()) {
            return ResponseEntity.ok(emp.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteEmp/{id}")
    public ResponseEntity<Void> deleteEmp(@PathVariable Integer id) {
        employeeRepository.deleteById(id);
        return ResponseEntity.noContent().build();

    }




}
